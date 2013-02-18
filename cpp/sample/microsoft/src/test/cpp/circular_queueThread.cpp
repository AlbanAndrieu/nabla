/*
 * circular_queueThread.cpp
 *
 *  Created on: 1 févr. 2012
 *      Author: Alban
 */
#include "circular_queueThread.h"

#include <iostream>

circular_queueThread::circular_queueThread() : m_stoprequested(false), m_nbSteps(0), m_type(true) {

}

circular_queueThread::~circular_queueThread() {

}

void circular_queueThread::setNbSteps(int nbSteps)
{
	boost::mutex::scoped_lock l(this->m_mutex);
	this->m_nbSteps = nbSteps;
}

void circular_queueThread::setQueue(circular_queue* aQueue)
{
	boost::mutex::scoped_lock l(this->m_mutex);
	this->queue = aQueue;
}

boost::posix_time::time_duration circular_queueThread::getDuration()
{
	return this->m_TimeStop - this->m_TimeStart;
}

// Create the thread and start work
void circular_queueThread::go()
{
	assert(!m_thread);
	m_thread = boost::shared_ptr<boost::thread>(new boost::thread(boost::bind(&circular_queueThread::work, this)));
}

void circular_queueThread::stop() // Note 1
{
	assert(m_thread);
	m_stoprequested = true;
	m_thread->join();
}

void circular_queueThread::setType(bool type) {
	m_type = type;
}

// Compute and save fibonacci numbers as fast as possible
void circular_queueThread::work()
{
	int value = 1;
	assert(queue);
	//queue = new circular_queue(50);
	this->m_TimeStart = boost::posix_time::second_clock::local_time();

	while (!m_stoprequested && (value <= m_nbSteps))
	{
		if (m_type) {
			bool done = queue->enqueue(value);
			if (done) {
				std::cout << "Enqueue : " << value << std::endl;
				value++;
			}
		} else {
			try {
				int res = queue->dequeue();
				std::cout << "Dequeue : " << value << " - " << res << std::endl;
				value++;
			} catch(const char * str ) {
				//std::cout << "Exception raised : " << str << std::endl;
			} catch(const std::exception& e) {
				//std::cout << "std::exception catched : " << e.what() << std::endl;
			} catch(...) {
				//std::cout << "Other Exception catched" << std::endl;
			}
		}


		//boost::mutex::scoped_lock l(m_mutex);
	}

	this->m_stoprequested = false;
	this->m_TimeStop = boost::posix_time::second_clock::local_time();

}


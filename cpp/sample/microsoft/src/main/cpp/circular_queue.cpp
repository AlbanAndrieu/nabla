#include <circular_queue.h>
//#include <boost/shared_ptr.hpp>
#include <iostream>
#include <string>
#include <exception>

#define DEFAULT_SIZE 100
#define DEFAULT_VALUE 0

//! The constructor.
// Attributes initialization
circular_queue::circular_queue(const unsigned int size) :
	ui_size(DEFAULT_SIZE), m_queue(0), i_head(0), i_tail(0), i_nbElement(0) {

	std::cout << "Constructor..." << std::endl;

	if (size <= 0) {
		throw "Size value must be bigger than 0";
	}

	ui_size = size;
	try {
		m_queue = new int[ui_size];
	}
	catch( ... ) {
		std::cerr << "Memory allocation failure!" << std::endl;
		throw;
	}

	initialize(DEFAULT_VALUE);

	//pthread_mutex_init(&mutex, NULL);
}

//! The destructor.
// virtual is not necessary as I hope circular_queue will not be derivated (but it is best pratice to put virtual in the destructor), you can remove it for optimization of v_table
circular_queue::~circular_queue() {

	std::cout << "Destructor..." << std::endl;

	if (m_queue != 0) {
		delete[] m_queue;
		m_queue = 0;
	}

	clear();
	ui_size = 0;

	//pthread_mutex_destroy(&mutex);
}

void circular_queue::initialize(const int x) {

	//TODO put a mutex if method is public
	for (unsigned int i = 0; i < ui_size; i++) {
		m_queue[i] = x;
		std::cout << "Value of index " << i << " is " << m_queue[i]
				<< std::endl;
	}
	//clear();
}

bool circular_queue::enqueue(const int x) {
	bool res = false;
	boost::mutex::scoped_lock lock(m_mutex);
	//p_thread_mutex_lock(&mp);
	if (i_nbElement == (ui_size)) {
		res = false;
		std::cerr << "We cannot enqueue without dequeuing" << std::endl;
		std::cout << "Number of element is : " << i_nbElement << std::endl;
	} else {
		std::cout << "Current value : " << x << " inserted at position : "
				<< i_tail << std::endl;
		m_queue[i_tail] = x;
		i_nbElement++;
		i_tail = (i_tail + 1) % (ui_size);
		std::cout << "Next value is : " << i_tail << std::endl;
		res = true;
	}
	//p_thread_mutex_unlock(&mp);
	return res;
}

int circular_queue::dequeue(const bool reset) {
	int res = 0;

	boost::mutex::scoped_lock lock(m_mutex);
	//pthread_mutex_lock(&mp);
	if (i_nbElement == 0) {
		//std::cout << "We cannot dequeuing because queue is empty" << std::endl;
		//pthread_mutex_unlock(&mp);
		throw std::logic_error("Queue is empty");
	} else {
		std::cout << "Current value retrieve from position : " << i_head
				<< std::endl;

		res = m_queue[i_head];
		if (reset) {
			// This is for test purposes and may not be activated
			m_queue[i_head] = DEFAULT_VALUE;
		}
		i_head = (i_head + 1) % (ui_size);

		i_nbElement--;
		std::cout << "Next head value is at position : " << i_head << std::endl;
		std::cout << "There is/are : " << i_nbElement
				<< " remaining element(s)" << std::endl;
	}
	//pthread_mutex_unlock(&mp);
	return res;
}

/**
 * This method has been designed for test purpose and my access inconsistent memory values
 * (if the queue is not full and initialized)
 */
std::string circular_queue::values() {
	std::ostringstream values;
	values << "[";
	std::cout << "Print value of circular_queue of " << ui_size << " : " << std::endl;

	boost::mutex::scoped_lock lock(m_mutex);
	for (unsigned int i = 0; i < ui_size; i++) {
		std::cout << "Value of index " << i << " is " << m_queue[i] << std::endl;
		if (i != 0) {
			values << "-";
		}
		values << m_queue[i];
	}
	values << "]";
	return values.str();
}

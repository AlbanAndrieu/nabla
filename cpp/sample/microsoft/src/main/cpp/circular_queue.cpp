//TODO Win32#include "StdAfx.h"
#include <circular_queue.h>

#include <exception>
//TODO Win32#include <sstream>
//TODO Win32#include <assert.h>

// \def DEFAULT_SIZE 100
#define DEFAULT_SIZE 100
// \def DEFAULT_VALUE 100
#define DEFAULT_VALUE 0

//TODO Win32 const wchar_t* MUTEXNAME = L"MyMutex";

//! The constructor.
// Attributes initialization
circular_queue::circular_queue(const unsigned int size, const std::string& name) :
	ui_size(DEFAULT_SIZE), s_name(name), m_queue(0), ui_head(0), ui_tail(0), ui_nbElement(0) {

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

	//pthread_mutex_init(&mutex, NULL);
	//TODO Win32 hMutex=CreateMutex(NULL,FALSE,MUTEXNAME);
	//TODO Win32 assert(hMutex!=NULL);

	initialize(DEFAULT_VALUE);
}

//! The destructor.
// virtual is not necessary as I hope circular_queue will not be derived (but it is best practices to put virtual in the destructor),
// you can remove it for optimization of v_table
circular_queue::~circular_queue() {

	std::cout << "Destructor..." << std::endl;

	if (m_queue != 0) {
		delete[] m_queue;
		m_queue = 0;
	}

	clear();
	ui_size = 0;

	//pthread_mutex_destroy(&mutex);
	//TODO Win32 check if we need to destroy the mutex properly
}

circular_queue::circular_queue(const circular_queue& copy)
    : ui_size(copy.ui_size), s_name(copy.s_name), m_queue(new int[copy.ui_size])
{
	std::cout << "Copy constructor..." << std::endl;

    std::copy(copy.m_queue, copy.m_queue + copy.ui_size, m_queue);    // #include <algorithm> for std::copy
}

const std::string& circular_queue::name() const {
    return s_name;
}

void circular_queue::name(const std::string& name) {
	s_name = name;
}

void circular_queue::initialize(const int data) {

	//TODO put a mutex if method is public
	for (unsigned int i = 0; i < ui_size; i++) {
		m_queue[i] = data;
		std::cout << "Value of index " << i << " is " << m_queue[i]
				<< std::endl;
	}
	//clear();
}

const bool circular_queue::enqueue(const int data) {
	boost::mutex::scoped_lock lock(m_mutex);
	//p_thread_mutex_lock(&mp);
	//TODO Win32 WaitForSingleObject(hMutex,INFINITE); // wait for ownership
	if (ui_nbElement == ui_size) {
		std::cerr << "We cannot enqueue without dequeuing" << std::endl;
		std::cout << "Number of element is : " << ui_nbElement << std::endl;
		//p_thread_mutex_unlock(&mp);
		//TODO Win32 ReleaseMutex(hMutex);
		return false;
	} else {
		std::cout << "Current value : " << data << " inserted at position : "
				<< ui_tail << std::endl;
		m_queue[ui_tail] = data;
		ui_nbElement++;
		ui_tail = (ui_tail + 1) % ui_size;
		std::cout << "Next value is : " << ui_tail << std::endl;
		//p_thread_mutex_unlock(&mp);
		//TODO Win32 ReleaseMutex(hMutex);
		return true;
	}
}

const int circular_queue::dequeue(const bool reset) {
	int res = 0;

	boost::mutex::scoped_lock lock(m_mutex);
	//pthread_mutex_lock(&mp);
	//TODO Win32 WaitForSingleObject(hMutex,INFINITE); // wait for ownership
	if (ui_nbElement == 0) {
		//std::cout << "Unable to dequeue because the queue is empty" << std::endl;
		//pthread_mutex_unlock(&mp);
		//TODO Win32 ReleaseMutex(hMutex);
		throw std::logic_error("Queue is empty");
	} else {
		std::cout << "Current value retrieve from position : " << ui_head
				<< std::endl;

		res = m_queue[ui_head];
		if (reset) {
			// This is for test purposes and must not be activated
			m_queue[ui_head] = DEFAULT_VALUE;
		}
		ui_head = (ui_head + 1) % ui_size;

		ui_nbElement--;
		std::cout << "Next head value is at position : " << ui_head << std::endl;
		std::cout << "There is/are : " << ui_nbElement
				<< " remaining element(s)" << std::endl;
	}
	//pthread_mutex_unlock(&mp);
	//TODO Win32 ReleaseMutex(hMutex);
	return res;
}

const std::string circular_queue::values() const {
	std::ostringstream values;
	values << "[";
	std::cout << "Print value of circular_queue " << s_name << "of " << ui_size << " : " << std::endl;

	// Mutex is not necessary has we do not change any values
	//boost::mutex::scoped_lock lock(m_mutex);
	//TODO Win32 WaitForSingleObject(hMutex,INFINITE); // wait for ownership
	for (unsigned int i = 0; i < ui_size; i++) {
		std::cout << "Value of index " << i << " is " << m_queue[i] << std::endl;
		if (i != 0) {
			values << "-";
		}
		values << m_queue[i];
	}
	values << "]";
	//TODO Win32 ReleaseMutex(hMutex);
	return values.str();
}

std::ostream& operator<<(std::ostream& out, const circular_queue& queue)
{
    out << queue.values();
    return out;
}

/**
 * \file circular_queue.h
 * \brief Programm for answering an interview.
 * \author Alban Andrieu
 * \version 0.1
 * \date 09 february 2011
 *
 * A thread safe circular queue - a circular queue of integers of user-specified size using a simple array.
 *
 */
// see http://en.wikipedia.org/wiki/Pragma_once
#pragma once
#ifndef CIRCULARQUEUE_HPP_
#define CIRCULARQUEUE_HPP_

// used for std::ostream
#include <iostream>
// used for std::string
#include <string>

// used for POSIX thread
//TODO POSIX #include <pthread.h>
// used for boost::mutex
#include <boost/thread/mutex.hpp>
// I usually use Boost, because I trust it
//TODO Win32 #include <windows.h>
//MFC #include <afxmt.h>

/*!
 * \class circular_queue
 * \brief A thread safe circular queue - a circular queue of integers of user-specified size using a simple array.
 * \param int The number of the elements stored in the <code>circular_queue</code>.
 * \note This is a sample
 */
class circular_queue {

	//Now that the overloaded operator function is using two variables, it cannot be part of the class
	//You must declare it outside of the class.
	//In order for the function to access private (and/or protected) member variables of the class, you should make it a friend of the class
	// See : http://www.functionx.com/cpp/Lesson25.htm
	friend std::ostream& operator<<(std::ostream& out, const circular_queue& queue);

private:
	// I usually use boost::shared_array<int> m_queue;
	int *m_queue; /*!< A pointer to an array of integer*/

	unsigned int ui_head; /*!< Head of the queue*/

	unsigned int ui_tail; /*!< Tail of the queue*/

	unsigned int ui_size; /*!< The queue size*/

	unsigned int ui_nbElement; /*!< Number of elements in the queue*/

	// A mutex, I usually use boost::mutex m_mutex;
	//POSIX thread pthread_mutex_t mp = PTHREAD_MUTEX_INITIALIZER;
	boost::mutex m_mutex; /*!< A mutex to make the queue thread safe*/
	//TODO Win32 HANDLE hMutex;
	//TODO For MFC CMutex my_mutex(FALSE, _T("MyAppMutex"));
	//CSingleLock mutex_lock(&my_mutex, FALSE);
	// See http://msdn.microsoft.com/en-us/library/bwk62eb7.aspx
	// \code
	// if(mutex_lock.IsLocked() == FALSE)
	// {
	//	 BOOL bRet = mutex_lock.Lock(100);
	//
	//	 if(bRet == TRUE) {
	//        ...
	//	 } else {
	//		std::cout << "Another instance of the same application is running.\n";
	//		return 0;
	//	 }
	// }
	// \endcode

	void initialize(const int data);

	std::string s_name; /*!< The name of the queue*/

public:
	/*!
	 *  \brief The constructor
	 *
	 *  Constructor for the class circular_queue
	 *
	 *  \param size : The size of the queue
	 *  \param name : The name of the queue (default name is default)
	 *  \throw This constructor throw an exception "Size value must be bigger than 0" if the size is not correct
	 *  \throw This constructor throw an exception if it cannot create the array of integer (it can be std::bad_alloc, std::out_of_range, ...)
	 */
	circular_queue(const unsigned int size, const std::string& name = "default");

	/*!
	 *  \brief The destructor
	 *
	 *  Destructor for the class circular_queue
	 */
	virtual ~circular_queue();

	// Copy contructor because of the pointer int* m_queue
	/*!
	 *  \brief The copy constructor
	 *
	 *  Copy constructor for the class circular_queue
	 *
	 *  \param copy : A reference to the queue to copy
	 */
	circular_queue(const circular_queue& copy);

	// getter for size
	const std::string& name() const;
	// setter for size
	void name(const std::string& size);

	/**
	 * \fn const bool enqueue(const int data)
	 * \brief Add a value to the queue.
	 *
	 * \param data the integer to add to the queue, cannot be NULL.
	 * \return A boolean that says if it was possible to add the data in the queue.
	 */
	const bool enqueue(const int data);

	/**
	 * \fn const int dequeue(const bool reset = false)
	 * \brief Retrieve a value from the queue.
	 *
	 * \param reset This boolean reset the value to the default value DEFAULT_VALUE after the value was retrieved.
	 * \return An integer that give the value retrieved.
	 * \throw This method throw an exception "Queue is empty" if it was unable to retrieve the value
	 */
	const int dequeue(const bool reset = false);

	/**
	 * \fn std::string values() const
	 * \brief Display the values of the queue.
	 *
	 * \return A string which contains the values of the queue.
	 * \note This method has been designed for test purposes and may access inconsistent memory values
	 * (if the queue is not full and initialized)
	 */
	const std::string values() const;

	inline void clear(void) { ui_head = ui_tail = ui_nbElement = 0; }

	//inline int size(void) const { return (ui_size - 1); }

	// true - if queue is empty
	//inline bool empty(void) const { return (i_head == i_tail); }

	// true - if queue is full
	//inline bool full(void) const  { return ( ((i_tail + 1) % (ui_size - 1)) == i_head ); }

};

#endif /* CIRCULARQUEUE_HPP_ */

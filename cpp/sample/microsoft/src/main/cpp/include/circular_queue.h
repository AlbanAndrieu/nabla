/*
 * circular_queue.h
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
    \class circular_queue
    \brief A thread safe circular queue - a circular queue of integers of user-specified size using a simple array.
    \param int The number of the elements stored in the <code>circular_queue</code>.
    \note This is a sample
 */
class circular_queue {

	//Now that the overloaded operator function is using two variables, it cannot be part of the class
	//You must declare it outside of the class.
	//In order for the function to access private (and/or protected) member variables of the class, you should make it a friend of the class
	// See : http://www.functionx.com/cpp/Lesson25.htm
	friend std::ostream& operator<<(std::ostream& out, const circular_queue& queue);

private:
	// A pointer to an array of integer
	// I usually use boost::shared_array<int> m_queue;
	int *m_queue;

	// Head of the queue
	unsigned int ui_head;
	// Tail of the queue
	unsigned int ui_tail;

	unsigned int ui_size; // The queue size

	unsigned int ui_nbElement;

	// A mutex, I usually use boost::mutex m_mutex;
	//POSIX thread pthread_mutex_t mp = PTHREAD_MUTEX_INITIALIZER;
	boost::mutex m_mutex;
	//TODO Win32 HANDLE hMutex;
	//TODO For MFC CMutex my_mutex(FALSE, _T("MyAppMutex"));
    //CSingleLock mutex_lock(&my_mutex, FALSE);
	// See http://msdn.microsoft.com/en-us/library/bwk62eb7.aspx
/*
	if(mutex_lock.IsLocked() == FALSE)
{
	BOOL bRet = mutex_lock.Lock(100);

	if(bRet == TRUE)

	{
        ...
	} else
	{
		std::cout << "Another instance of the same application is running.\n";
		return 0;
	}
}
*/

	void initialize(const int data);

	std::string s_name;

public:
	circular_queue(const unsigned int size, const std::string& name = "default");

	virtual ~circular_queue();

	// Copy contructor because of the pointer int* m_queue
	circular_queue(const circular_queue& copy);

	// getter for size
	const std::string& name() const;
	// setter for size
	void name(const std::string& size);

	const bool enqueue(const int data);

	const int dequeue(const bool reset = false);

	const std::string values() const;

	inline void clear(void) { ui_head = ui_tail = ui_nbElement = 0; }

	//inline int size(void) const { return (ui_size - 1); }

	// true - if queue is empty
	//inline bool empty(void) const { return (i_head == i_tail); }

	// true - if queue is full
	//inline bool full(void) const  { return ( ((i_tail + 1) % (ui_size - 1)) == i_head ); }

};

#endif /* CIRCULARQUEUE_HPP_ */

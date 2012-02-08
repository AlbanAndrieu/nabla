/*
 * circular_queue.h
 *
 */

#ifndef CIRCULARQUEUE_HPP_
#define CIRCULARQUEUE_HPP_

#include <pthread.h>
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

public:
	circular_queue(const unsigned int size);

	virtual ~circular_queue();

	bool enqueue(const int data);

	int dequeue(const bool reset = false);

	std::string values();

	inline void clear(void) { ui_head = ui_tail = ui_nbElement = 0; }

	//inline int size(void) const { return (ui_size - 1); }

	// true - if queue is empty
	//inline bool empty(void) const { return (i_head == i_tail); }

	// true - if queue is full
	//inline bool full(void) const  { return ( ((i_tail + 1) % (ui_size - 1)) == i_head ); }

};

#endif /* CIRCULARQUEUE_HPP_ */

/*
 * circular_queue.h
 *
 *  Created on: 31 janv. 2012
 *      Author: Alban
 */

#ifndef CIRCULARQUEUE_HPP_
#define CIRCULARQUEUE_HPP_

#include <pthread.h>
#include <boost/thread/mutex.hpp>
// I usually use Boost, because I do relly on it
// http://www.boost.org/doc/libs/1_39_0/libs/circular_buffer/doc/circular_buffer.html

/*!
    \class circular_queue
    \brief A thread safe circular queue - a circular queue of integers of user-specified size using a simple array.
    \param int The number of the elements stored in the <code>circular_queue</code>.
    \note This is a sample
 */
class circular_queue {
private:
	// A pointer to the an array of integer
	// I usually use boost::shared_array<int> m_queue;
	int *m_queue;

	// Head of the queue
	int i_head;
	// Tail of the queue
	int i_tail;

	unsigned int ui_size; // The queue size

	int i_nbElement;

	// A mutex, I usually use boost::mutex m_mutex;
	//pthread_mutex_t mp = PTHREAD_MUTEX_INITIALIZER;
	//static pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
	boost::mutex m_mutex;

	void initialize(const int x);

public:
	circular_queue(const unsigned int size);

	virtual ~circular_queue();

	bool enqueue(const int x);

	int dequeue(const bool reset = false);

	std::string values();

	inline void clear(void) { i_head = i_tail = i_nbElement = 0; }

	//inline int size(void) const { return (ui_size - 1); }

	// true - if queue if empty
	//inline bool empty(void) const { return (i_head == i_tail); }

	// true - if queue if full
	//inline bool full(void) const  { return ( ((i_tail + 1) % (ui_size - 1)) == i_head ); }

};

#endif /* CIRCULARQUEUE_HPP_ */

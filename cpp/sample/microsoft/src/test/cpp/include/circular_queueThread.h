/*
 * circular_queueThread.h
 *
 */

#ifndef CIRCULAR_QUEUETHREAD_H_
#define CIRCULAR_QUEUETHREAD_H_

#include <boost/thread/mutex.hpp>
#include <boost/thread/thread.hpp>
#include <boost/shared_ptr.hpp>

#include "boost/date_time/posix_time/posix_time.hpp"

#include <circular_queue.h>

class circular_queueThread {
public:
	circular_queueThread();

	virtual ~circular_queueThread();

    void go();

    void stop();

    // if true enqueue, if false dequeue
    void setType(bool type);

    // sets the number of enqueue dequeue
    void setNbSteps(int nbSteps);

    void setQueue(circular_queue* aQueue);

    boost::posix_time::time_duration getDuration();

private:
    volatile bool m_stoprequested;
    boost::shared_ptr<boost::thread> m_thread;
    boost::mutex m_mutex;

    boost::posix_time::ptime m_TimeStart;
    boost::posix_time::ptime m_TimeStop;
    int m_nbSteps;
    bool m_type; // true for enqueue, false for dequeue

    circular_queue* queue;

    // Compute the enqueue and dequeue
    void work();
};

#endif /* CIRCULAR_QUEUETHREAD_H_ */

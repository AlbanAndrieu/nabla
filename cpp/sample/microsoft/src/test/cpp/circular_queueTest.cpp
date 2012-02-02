#include "circular_queueTest.h"
#include "circular_queueThread.h"

#include "boost/date_time/posix_time/posix_time.hpp"
#include <Windows.h>

#include <circular_queue.h>

CPPUNIT_TEST_SUITE_NAMED_REGISTRATION( circular_queueTest, "circular_queueTest"  );

void circular_queueTest::setUp() {
}

void circular_queueTest::tearDown() {
}

void circular_queueTest::testConstructor() {

	std::cout << "START testConstructor..." << std::endl;

	circular_queue* a = new circular_queue(3); // No Exception must be raised here to avoid core dump
	std::cout << "Free memory circular_queue" << std::endl;
	delete a;

	std::cout << "END testConstructor..." << std::endl;
}
void circular_queueTest::testConstructorWithNegative() {

	std::cout << "START testConstructorWithNegative..." << std::endl;

	circular_queue* a;

	try {
		a = new circular_queue(-1);
		std::cout << "Free memory circular_queue not done" << std::endl;
		delete a;
	} catch(int) {
		std::cout << "Integer exception raised." << std::endl;
	} catch(const char * str ) {
		std::cout << "Exception raised : " << str << std::endl;
	} catch(const std::bad_alloc& e) {
		std::cout << "std::bad_alloc catched : " << e.what() << std::endl;
	} catch ( const std::out_of_range & e) {
		std::cout << "std::out_of_range catched : " << e.what() << std::endl;
	} catch(const std::exception& e) {
		std::cout << "std::exception catched : " << e.what() << std::endl;
	} catch(...) {
		std::cout << "Other Exception catched" << std::endl;
	}

	std::cout << "END testConstructorWithNegative..." << std::endl;
}

void circular_queueTest::testConstructorWithZero() {

	std::cout << "START testConstructorWithZero..." << std::endl;

	try {
		circular_queue* a = new circular_queue(0);
		std::cout << "Free memory circular_queue not done" << std::endl;
		delete a;
	} catch(const char * str ) {
		std::cout << "Exception raised : " << str << std::endl;
	} catch(const std::exception& e) {
		std::cout << "std::exception catched : " << e.what() << std::endl;
	} catch(...) {
		std::cout << "Other Exception catched" << std::endl;
	}

	std::cout << "END testConstructorWithZero..." << std::endl;
}

void circular_queueTest::testEnqueue() {

	std::cout << "START testEnqueue..." << std::endl;

	circular_queue* a = new circular_queue(3);

	try {

		CPPUNIT_ASSERT(a->enqueue(1) == true);
		CPPUNIT_ASSERT(a->enqueue(2) == true);
		CPPUNIT_ASSERT(a->enqueue(3) == true);

		std::ostringstream os;
		os << a->values();
		CPPUNIT_ASSERT_EQUAL( std::string("[1-2-3]"), os.str() );
		std::cout << "Result is : " << os.str() << std::endl;

	} catch(const char * str ) {
		std::cout << "Exception raised : " << str << std::endl;
	} catch(const std::exception& e) {
		std::cout << "std::exception catched : " << e.what() << std::endl;
	} catch(...) {
		std::cout << "Other Exception catched" << std::endl;
	}

	std::cout << "Free memory circular_queue" << std::endl;
	delete a;

	std::cout << "END testEnqueue..." << std::endl;
}

void circular_queueTest::testEnqueueTooMany() {

	std::cout << "START testEnqueueTooMany..." << std::endl;

	circular_queue* a = new circular_queue(3);

	try {
		CPPUNIT_ASSERT(a->enqueue(1) == true);
		CPPUNIT_ASSERT(a->enqueue(2) == true);
		CPPUNIT_ASSERT(a->enqueue(3) == true);
		CPPUNIT_ASSERT(a->enqueue(4) == false);

		std::ostringstream os;
		os << a->values();
		CPPUNIT_ASSERT_EQUAL( std::string("[1-2-3]"), os.str() );
		std::cout << "Result is : " << os.str() << std::endl;

	} catch(const char * str ) {
		std::cout << "Exception raised : " << str << std::endl;
	} catch(const std::exception& e) {
		std::cout << "std::exception catched : " << e.what() << std::endl;
	} catch(...) {
		std::cout << "Other Exception catched" << std::endl;
	}

	std::cout << "Free memory circular_queue" << std::endl;
	delete a;

	std::cout << "END testEnqueueTooMany..." << std::endl;
}

void circular_queueTest::testEnqueueNotEnough() {

	std::cout << "START testEnqueueNotEnough..." << std::endl;

	circular_queue* a = new circular_queue(5);

	try {
		CPPUNIT_ASSERT(a->enqueue(1) == true);
		CPPUNIT_ASSERT(a->enqueue(2) == true);
		CPPUNIT_ASSERT(a->enqueue(3) == true);

		std::ostringstream os;
		os << a->values();
		CPPUNIT_ASSERT_EQUAL( std::string("[1-2-3-0-0]"), os.str() );
		std::cout << "Result is : " << os.str() << std::endl;
		//		std::ostringstream osFull;
		//		osFull << a->printWholeQueue();
		//		std::cout << "Full Queue is : " << osFull.str() << std::endl;

	} catch(const char * str ) {
		std::cout << "Exception raised : " << str << std::endl;
	} catch(const std::exception& e) {
		std::cout << "std::exception catched : " << e.what() << std::endl;
	} catch(...) {
		std::cout << "Other Exception catched" << std::endl;
	}

	std::cout << "Free memory circular_queue" << std::endl;
	delete a;

	std::cout << "END testEnqueueNotEnough..." << std::endl;
}

void circular_queueTest::testDequeue() {

	std::cout << "START testDequeue..." << std::endl;

	circular_queue* a = new circular_queue(3);

	try {
		CPPUNIT_ASSERT(a->enqueue(1) == true);
		CPPUNIT_ASSERT(a->enqueue(2) == true);
		CPPUNIT_ASSERT(a->enqueue(3) == true);
		CPPUNIT_ASSERT_EQUAL(1, a->dequeue(true));

		std::ostringstream os;
		os << a->values();
		CPPUNIT_ASSERT_EQUAL( std::string("[0-2-3]"), os.str() );
		std::cout << "Result is : " << os.str() << std::endl;

	} catch(const char * str ) {
		std::cout << "Exception raised : " << str << std::endl;
	} catch(const std::exception& e) {
		std::cout << "std::exception catched : " << e.what() << std::endl;
	} catch(...) {
		std::cout << "Other Exception catched" << std::endl;
	}

	std::cout << "Free memory circular_queue" << std::endl;
	delete a;

	std::cout << "END testDequeue..." << std::endl;
}

void circular_queueTest::testDequeueTooMany() {

	std::cout << "START testDequeueTooMany..." << std::endl;

	circular_queue* a = new circular_queue(3);

	try {
		CPPUNIT_ASSERT(a->enqueue(1) == true);
		CPPUNIT_ASSERT(a->enqueue(2) == true);
		CPPUNIT_ASSERT(a->enqueue(3) == true);
		CPPUNIT_ASSERT_EQUAL(1, a->dequeue(true));
		CPPUNIT_ASSERT_EQUAL(2, a->dequeue(true));
		CPPUNIT_ASSERT_EQUAL(3, a->dequeue(true));
		CPPUNIT_ASSERT_THROW(a->dequeue(true), std::exception);

		std::ostringstream os;
		os << a->values();
		CPPUNIT_ASSERT_EQUAL( std::string("[0-0-0]"), os.str() );
		std::cout << "Result is : " << os.str() << std::endl;

	} catch(const char * str ) {
		std::cout << "Exception raised : " << str << std::endl;
	} catch(const std::exception& e) {
		std::cout << "std::exception catched : " << e.what() << std::endl;
	} catch(...) {
		std::cout << "Other Exception catched" << std::endl;
	}

	std::cout << "Free memory circular_queue" << std::endl;
	delete a;

	std::cout << "END testDequeueTooMany..." << std::endl;
}

void circular_queueTest::testEnqueueDequeue() {

	std::cout << "START testEnqueueDequeue..." << std::endl;

	circular_queue* a = new circular_queue(3);

	try {
		CPPUNIT_ASSERT(a->enqueue(1) == true);
		CPPUNIT_ASSERT(a->enqueue(2) == true);
		CPPUNIT_ASSERT(a->enqueue(3) == true);
		CPPUNIT_ASSERT_EQUAL( std::string("[1-2-3]"), a->values() );
		CPPUNIT_ASSERT_EQUAL(1, a->dequeue(true));
		CPPUNIT_ASSERT_EQUAL( std::string("[0-2-3]"), a->values() );
		CPPUNIT_ASSERT(a->enqueue(4) == true);
		CPPUNIT_ASSERT_EQUAL( std::string("[4-2-3]"), a->values() );
		CPPUNIT_ASSERT_EQUAL(2, a->dequeue(true));
		CPPUNIT_ASSERT_EQUAL(3, a->dequeue(true));
		CPPUNIT_ASSERT_EQUAL( std::string("[4-0-0]"), a->values() );
		CPPUNIT_ASSERT(a->enqueue(5) == true);
		CPPUNIT_ASSERT(a->enqueue(6) == true);
		CPPUNIT_ASSERT(a->enqueue(7) == false);
		CPPUNIT_ASSERT_EQUAL( std::string("[4-5-6]"), a->values() );
		CPPUNIT_ASSERT_EQUAL(4, a->dequeue(true));
		CPPUNIT_ASSERT_EQUAL(5, a->dequeue(true));
		CPPUNIT_ASSERT_EQUAL(6, a->dequeue(true));
		CPPUNIT_ASSERT_THROW(a->dequeue(true), std::exception);

		std::cout << "Result is : " << a->values() << std::endl;

	} catch(const char * str ) {
		std::cout << "Exception raised : " << str << std::endl;
	} catch(const std::exception& e) {
		std::cout << "std::exception catched : " << e.what() << std::endl;
	} catch(...) {
		std::cout << "Other Exception catched" << std::endl;
	}

	std::cout << "Free memory circular_queue" << std::endl;
	delete a;

	std::cout << "END testEnqueueDequeue..." << std::endl;
}

std::string circular_queueTest::printTime() {
	boost::posix_time::ptime now = boost::posix_time::second_clock::local_time();
	return boost::posix_time::to_simple_string(now);
}

void circular_queueTest::testEnqueueDequeueThread() {

	std::cout << "START testEnqueueDequeueThread..." << std::endl;

	circular_queue* a = new circular_queue(10);

	std::cout << printTime() << " Creating the thread enqueue." << std::endl;
	circular_queueThread enqueueThread;
	enqueueThread.setQueue(a);
	enqueueThread.setNbSteps(15); // Try to do 15 enqueue
	enqueueThread.setType(true);

	std::cout << printTime() << " Creating the thread dequeue." << std::endl;
	circular_queueThread dequeueThread;
	dequeueThread.setQueue(a);
	dequeueThread.setNbSteps(18); // Try to do 12 dequeue then 18
	enqueueThread.setType(false);

	std::cout << printTime() << " Starting the thread enqueue." << std::endl;
	enqueueThread.go();
	std::cout << printTime() << " Starting the thread dequeue." << std::endl;
	dequeueThread.go();

	std::cout << printTime() << " Sleeping for 2 seconds." << std::endl;
	Sleep(4000);

	//CPPUNIT_ASSERT(a->enqueue(1) == true);

	std::cout << printTime() << " Stopping the thread dequeue." << std::endl;
	dequeueThread.stop();

	std::cout << printTime() << " Stopping the thread enqueue." << std::endl;
	enqueueThread.stop();

	std::cout << printTime() << " Sleeping for 2 seconds to stop." << std::endl;
	Sleep(2000);

	std::cout << "Result is : " << a->values() << std::endl;

	std::cout << printTime() << " Time duration for enqueue was " << boost::posix_time::to_simple_string(enqueueThread.getDuration()) << std::endl;
	std::cout << printTime() << " Time duration for dequeue was " << boost::posix_time::to_simple_string(dequeueThread.getDuration()) << std::endl;

	std::cout << "Free memory circular_queue" << std::endl;
	delete a;

	std::cout << "END testEnqueueDequeueThread..." << std::endl;
}

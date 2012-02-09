#pragma once
#ifndef CIRCULAR_QUEUETEST_H
#define CIRCULAR_QUEUETEST_H

#include <cppunit/extensions/HelperMacros.h>

class circular_queueTest: public CppUnit::TestFixture {
    CPPUNIT_TEST_SUITE( circular_queueTest );
    CPPUNIT_TEST( testConstructor );
    CPPUNIT_TEST( testConstructorWithNegative );
    CPPUNIT_TEST( testConstructorWithZero );
    CPPUNIT_TEST( testCopyConstructor );
    CPPUNIT_TEST( testEnqueue );
    CPPUNIT_TEST( testOperatorOutput );
    CPPUNIT_TEST( testEnqueueTooMany );
    CPPUNIT_TEST( testEnqueueNotEnough );
    CPPUNIT_TEST( testDequeue );
    CPPUNIT_TEST( testDequeueTooMany );
    CPPUNIT_TEST( testEnqueueDequeue );
    CPPUNIT_TEST( testEnqueueDequeueThread );
	CPPUNIT_TEST_SUITE_END();

public:
	void setUp();
	void tearDown();

	void testConstructor();
	void testConstructorWithNegative();
	void testConstructorWithZero();
	void testCopyConstructor();
	void testEnqueue();
	void testOperatorOutput();
	void testEnqueueTooMany();
	void testEnqueueNotEnough();
	void testDequeue();
	void testDequeueTooMany();
	void testEnqueueDequeue();

	std::string printTime();

	void testEnqueueDequeueThread();
};

#endif  // CIRCULAR_QUEUETEST_H

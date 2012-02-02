#ifndef CPPUNITTEST_H
#define CPPUNITTEST_H

#include <cppunit/extensions/HelperMacros.h>

class cppunitTest: public CppUnit::TestFixture {
    CPPUNIT_TEST_SUITE( cppunitTest );
    CPPUNIT_TEST( testNOK );
    CPPUNIT_TEST( testOK );
	CPPUNIT_TEST_SUITE_END();

public:
	void setUp();
	void tearDown();

	void testNOK();
	void testOK();
};

#endif  // CPPUNITTEST_H

#ifndef TRIANGLETEST_H
#define TRIANGLETEST_H

#include <cppunit/extensions/HelperMacros.h>

class TriangleTest: public CppUnit::TestFixture {
    CPPUNIT_TEST_SUITE( TriangleTest );
    CPPUNIT_TEST( testERROR );
    CPPUNIT_TEST( testEQUILATERAL );
    CPPUNIT_TEST( testISOSCELES );
    CPPUNIT_TEST( testSCALENE );
	CPPUNIT_TEST_SUITE_END();

public:
	void setUp();
	void tearDown();

	void testERROR();
	void testEQUILATERAL();
	void testISOSCELES();
	void testSCALENE();
};

#endif  // TRIANGLETEST_H

#include "TriangleTest.h"
#include <Triangle.h>

CPPUNIT_TEST_SUITE_NAMED_REGISTRATION( TriangleTest, "TriangleTest"  );

void TriangleTest::setUp() {
}

void TriangleTest::tearDown() {
}

void TriangleTest::testERROR() {
	CPPUNIT_ASSERT_EQUAL ( 4, Triangle::triangleType(0, 0, 0) );
	CPPUNIT_ASSERT_EQUAL ( 4, Triangle::triangleType(1, 0, 0) );
	CPPUNIT_ASSERT_EQUAL ( 4, Triangle::triangleType(0, 1, 0) );
	CPPUNIT_ASSERT_EQUAL ( 4, Triangle::triangleType(0, 0, 1) );
	CPPUNIT_ASSERT_EQUAL ( 4, Triangle::triangleType(1, 1, 0) );
	CPPUNIT_ASSERT_EQUAL ( 4, Triangle::triangleType(0, 1, 1) );
	CPPUNIT_ASSERT_EQUAL ( 4, Triangle::triangleType(1, 0, 1) );
	CPPUNIT_ASSERT_EQUAL ( 4, Triangle::triangleType(1, 2, 4) );
	CPPUNIT_ASSERT_EQUAL ( 4, Triangle::triangleType(5, 6, 12) );
	CPPUNIT_ASSERT_EQUAL ( 4, Triangle::triangleType(12, 5, 6) );
	CPPUNIT_ASSERT_EQUAL ( 4, Triangle::triangleType(6, 12, 5) );
}

void TriangleTest::testEQUILATERAL() {
	CPPUNIT_ASSERT_EQUAL ( 3, Triangle::triangleType(1, 1, 1) );
	CPPUNIT_ASSERT_EQUAL ( 3, Triangle::triangleType(4, 4, 4) );
}

void TriangleTest::testISOSCELES() {
	CPPUNIT_ASSERT_EQUAL ( 2, Triangle::triangleType(10, 10, 8) );
	CPPUNIT_ASSERT_EQUAL ( 2, Triangle::triangleType(9, 5, 5) );
	CPPUNIT_ASSERT_EQUAL ( 2, Triangle::triangleType(7, 10, 7) );
}

void TriangleTest::testSCALENE() {
	CPPUNIT_ASSERT_EQUAL ( 1, Triangle::triangleType(1, 2, 3) );
	CPPUNIT_ASSERT_EQUAL ( 1, Triangle::triangleType(4, 5, 3) );
	CPPUNIT_ASSERT_EQUAL ( 1, Triangle::triangleType(3, 2, 1) );
}

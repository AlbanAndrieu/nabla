#include "cppunitTest.h"

CPPUNIT_TEST_SUITE_NAMED_REGISTRATION( cppunitTest, "cppunitTest"  );

void cppunitTest::setUp() {
}

void cppunitTest::tearDown() {
}

void cppunitTest::testNOK() {
	CPPUNIT_ASSERT ( 3 == 5 );
	CPPUNIT_ASSERT_EQUAL ( 3, 5 );
 }

void cppunitTest::testOK() {
	CPPUNIT_ASSERT ( 3 == 3 );
	CPPUNIT_ASSERT_EQUAL ( 3, 3 );
 }

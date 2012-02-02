#include <cppunit/CompilerOutputter.h>
#include <cppunit/extensions/TestFactoryRegistry.h>
#include <cppunit/ui/text/TestRunner.h>
#include <cppunit/CompilerOutputter.h>
#include <cppunit/TestResult.h>
#include <cppunit/TestResultCollector.h>
#include <cppunit/TextTestProgressListener.h>
#include <cppunit/XmlOutputter.h>

#include <cppunitTest.h>
#include <circular_queueTest.h>
#include <circular_queue.h>
#include <TriangleTest.h>

#include <string>

//using namespace CppUnit;

void print_all_tests(CppUnit::Test* t, const char* spacer, std::ostream& os) {
	os << t->getName() << spacer;
	for (int i=0; i < t->getChildTestCount(); i++) {
		print_all_tests( t->getChildTestAt(i), spacer, os );
	}
}

int main(int argc, char* argv[]) {

	std::cout << "Start to run Tests." << std::endl;

	//CppUnit::TestFactoryRegistry& registry = CppUnit::TestFactoryRegistry::getRegistry();


	// Adds the test to the list of test to run
	CppUnit::TextUi::TestRunner runner;

	// run all tests if none specified on command line
	//CppUnit::Test* test_to_run = registry.makeTest();
	if (argc > 1) {

		std::string testName = argv[1];
		std::cout << "Running "  <<  testName << "." << std::endl;

		if (testName.compare("circular_queueTest") == 0) {
			runner.addTest(circular_queueTest::suite() );
			std::cout << "Test circular_queueTest loaded." << std::endl;
		}
        if (testName.compare("TriangleTest") == 0) {
			runner.addTest(TriangleTest::suite() );
			std::cout << "Test TriangleTest loaded." << std::endl;
		}
        if (testName.compare("cppunitTest") == 0) {
			runner.addTest(cppunitTest::suite() );
			std::cout << "Test cppunitTest loaded." << std::endl;
		}

	} else {
		runner.addTest(circular_queueTest::suite() );
	}
	// Run the tests.
	bool failed = runner.run("", false);
	std::cout << "Test ran." << std::endl;

	// Return error code 1 if the one of test failed.
	return !failed; // failed ? 0 : 1;
}

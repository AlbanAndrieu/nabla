In src\main\app\run_app.cpp is a simple program that answer this question 1

The following files answered question 2
In src\main\cpp\circular_queue.cpp src\main\cpp\include\circular_queue.h

As it takes me time to set up an environement to compil C++ and run test on my computer, I have used open source products.
But I had to use library for the test and a cross-environement library (boost) to use mutex.
It may not fit to the following requirement : Please do not to use existing class libraries for this question.
But as test was not asked for the question 2, I think it will not be an issue.

With the following files it would be easier to run the test of question 1 (but I used CPPUnit library)
In src\main\cpp\Triangle.cpp src\main\cpp\include\Triangle.h
and src\test\cpp\TriangleTest.cpp src\test\cpp\include\TriangleTest.h

Below are CPPUnit for testing question 2
and src\test\cpp\circular_queueTest.cpp src\test\cpp\circular_queueThread.cpp src\test\cpp\include\circular_queueTest.h src\test\cpp\include\circular_queueThread.h

TODO See http://msdn.microsoft.com/en-us/library/windows/desktop/ms686927(v=vs.85).aspx for Win32 mutex use

#Simple C++ Project with CMake.

**Introduction**

This is a sample project to compile, test and package C++. With this sample you can use CPPUnit for testing, Boost for multi-threading. You can easily import this project in to Eclipse.

**Set up Eclipse**

Before importing a project into Eclipse, run the following command: Note: You may need to run it twice

cd /cygdrive/c/workspace/users/albandri10/cpp/sample/build-cygwin
./cmake.sh

**Compile your project**
Use the Cygwin environment to compile your project:

cd /cygdrive/c/workspace/users/albandri10/cpp/sample/build-cygwin
make clean install

**View your test results**
cd /cygdrive/c/workspace/users/albandri10/cpp/sample/build-cygwin
make test

**Run your test manually**
cd /cygdrive/c/target/install/x86Linux/debug/bin

./run_tests.exe cppunitTest

./run_tests.exe TriangleTest

./run_tests.exe circular_queueTest

**Run your executable manually**

cd /cygdrive/c/target/install/x86Linux/debug/bin
./run_app.exe

**Package your project**

cd /cygdrive/c/workspace/users/albandri10/cpp/sample/build-cygwin
make package

package MICROSOFT-1.2-CYGWIN-1 will be then available

For your information: library used

cppunit for unitary test
boost_thread-mt for mutext and thread
boost_date_time-mt for date

Test Questions
This is a sample project that answers the following questions for an interview:

Coding Question 1: Write me a function that receives three integer inputs for the lengths of the sides of a triangle and returns one of four values to determine the triangle type (1=scalene, 2=isosceles, 3=equilateral, 4=error). Generate test cases for the function assuming another developer coded the function
Coding Question 2: Implement a circular queue of integers of user-specified size using a simple array. Provide routines to initialize(), enqueue() and dequeue() the queue. Make it thread safe.
Please do not to use existing class libraries for this question. Thanks!

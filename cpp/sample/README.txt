
How to compile :

Using Cygwin environement
make clean install

Quick test :
make test

Run test manually :
cd /cygdrive/c/target/install/x86Linux/debug/bin
./run_tests.exe cppunitTest
./run_tests.exe TriangleTest
./run_tests.exe circular_queueTest

Run exe manually :
./run_app.exe

Package
make package

Library used : 
cppunit for unitary test
boost_thread-mt for mutext and thread
boost_date_time-mt for date

This project contains the following answer to the questions :

Coding Question1: Write me a function that receives three integer inputs for the lengths of the sides of a triangle and returns one of four values to determine the triangle type (1=scalene, 2=isosceles, 3=equilateral, 4=error). Generate test cases for the function assuming another developer coded the function  

Coding Question2: Implement a circular queue of integers of user-specified size using a simple array. Provide routines to initialize(), enqueue() and dequeue() the queue. Make it thread safe. 

Please do not to use existing class libraries for this question. Thanks!

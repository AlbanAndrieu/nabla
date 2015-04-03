# Introduction #

This is a sample project to compile, test and package C++.
With this sample you can use CPPUnit for testing, Boost for multi-threading.
You can easily import this project in to Eclipse.

# Check out the project #

Check out the project with svn.
```
svn co http://alban.googlecode.com/svn/trunk/cpp cpp
```

Alternatively, you can use this link :

https://code.google.com/p/alban/source/browse/#svn%2Ftrunk%2Fcpp

# Set up Eclipse #

Before importing a project into Eclipse, run the following command: _Note: You may need to run it twice_
```
cd /cygdrive/c/workspace/users/albandri10/cpp/sample/build-cygwin
./cmake.sh
```

# Compile your project #

Use the Cygwin environment to compile your project:
```
cd /cygdrive/c/workspace/users/albandri10/cpp/sample/build-cygwin
make clean install
```

# View your test results #

```
cd /cygdrive/c/workspace/users/albandri10/cpp/sample/build-cygwin
make test
```

# Run your test manually #

```
cd /cygdrive/c/target/install/x86Linux/debug/bin

./run_tests.exe cppunitTest

./run_tests.exe TriangleTest

./run_tests.exe circular_queueTest
```

# Run your executable manually #

```
cd /cygdrive/c/target/install/x86Linux/debug/bin
./run_app.exe
```

# Package your project #

```
cd /cygdrive/c/workspace/users/albandri10/cpp/sample/build-cygwin
make package
```

package MICROSOFT-1.2-CYGWIN-1 is available here:
http://code.google.com/p/alban/downloads/list

# Document your project #

```
cd /cygdrive/c/workspace/users/albandri10/cpp/sample/build-cygwin
make DoxygenDoc
```

Doxygen documentation is available here:
/cygdrive/c/workspace/users/albandri10/cpp/sample/build-cygwin/doc

A sample is available here:
http://www.maven.nabla.mobi/cpp/index.html

# For your information: library used #

  * cppunit for unitary test
  * boost\_thread-mt for mutext and thread
  * boost\_date\_time-mt for date

# Test Questions #

This is a sample project that answers the following questions for an interview:

  * Coding Question 1:  Write me a function that receives three integer inputs for the lengths of the sides of a triangle and returns one of four values to determine the triangle type (1=scalene, 2=isosceles, 3=equilateral, 4=error). Generate test cases for the function assuming another developer coded the function

  * Coding Question 2: Implement a circular queue of integers of user-specified size using a simple array. Provide routines to initialize(), enqueue() and dequeue() the queue. Make it thread safe.

**Please do not to use existing class libraries for this question. Thanks!**
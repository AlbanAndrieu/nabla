
echo "WORKSPACE ${WORKSPACE}"

#In Hudson
#Extract trunk/cpp in Google Code (automatic configuration)
#Batch Windows command : %WORKSPACE%\sample\build-cygwin\cmake.bat
#export PROJECT_SRC=${WORKSPACE}
#export PROJECT_TARGET_PATH=/target

echo "PROJECT_SRC : $PROJECT_SRC - PROJECT_TARGET_PATH : $PROJECT_TARGET_PATH"

cd $PROJECT_SRC/sample/build-${ARCH}

rm CMakeCache.txt

#-DCMAKE_C_COMPILER=i686-pc-cygwin-gcc-3.4.4 -DCMAKE_CXX_COMPILER=i686-pc-cygwin-g++-3
cmake -G"Eclipse CDT4 - Unix Makefiles" -DCMAKE_BUILD_TYPE=debug -DCMAKE_ECLIPSE_GENERATE_SOURCE_PROJECT=TRUE ../microsoft
#-DCMAKE_INSTALL_PREFIX=${PROJECT_TARGET_PATH}/install/${MACHINE}/debug 
#-DENABLE_TESTING=true

make -B clean install test DoxygenDoc 
#make package
#make test_all
#cd src
#ctest -D Experimental
#cd ~/cpp/sample/build-linux/src/test/cpp
#ctest .. -R circular_queueTest


echo "WORKSPACE ${WORKSPACE}"

#In Hudson
#Extract trunk/cpp in Google Code (automatic configuration)
#Batch Windows command : %WORKSPACE%\sample\build-cygwin\cmake.bat
export PROJECT_SRC=${WORKSPACE}
export PROJECT_TARGET_PATH=/cygdrive/c/target

echo "PROJECT_SRC : $PROJECT_SRC - PROJECT_TARGET_PATH : $PROJECT_TARGET_PATH"

cd $PROJECT_SRC/sample/build-cygwin

rm CMakeCache.txt

#-DCMAKE_C_COMPILER=i686-pc-cygwin-gcc-3.4.4 -DCMAKE_CXX_COMPILER=i686-pc-cygwin-g++-3
cmake -G"Eclipse CDT4 - Unix Makefiles" -DCMAKE_BUILD_TYPE=debug -DCMAKE_ECLIPSE_GENERATE_SOURCE_PROJECT=TRUE -DCMAKE_INSTALL_PREFIX=${PROJECT_TARGET_PATH}/install/${ARCH}/debug ../microsoft

make -B clean install test package DoxygenDoc

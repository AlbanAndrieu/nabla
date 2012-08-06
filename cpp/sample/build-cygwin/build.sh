
echo "WORKSPACE ${WORKSPACE}"
export WORKSPACE=/cygdrive/c/hudson/jobs/Nabla-CMake-Bat/workspace/

export PROJECT_DEV=${WORKSPACE}
export PROJECT_EXTRACTION=
export PROJECT_SRC=${PROJECT_DEV}/${PROJECT_EXTRACTION}

echo "PROJECT_SRC $PROJECT_SRC"

cd $PROJECT_SRC/sample/build-cygwin

rm CMakeCache.txt

cmake -G"Eclipse CDT4 - Unix Makefiles" -DCMAKE_BUILD_TYPE=debug -DCMAKE_C_COMPILER=i686-pc-cygwin-gcc-3.4.4 -DCMAKE_CXX_COMPILER=i686-pc-cygwin-g++-3 -DECLIPSE_CDT4_GENERATE_SOURCE_PROJECT=TRUE -DCMAKE_INSTALL_PREFIX=/cygdrive/c/target/install/${ARCH}/debug ../microsoft

make -B clean test install package DoxygenDoc

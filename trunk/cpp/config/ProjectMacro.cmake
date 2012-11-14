#
# Include and link against required stuff
#

#
# RTT supplies header files which should be included when 
# using RTT. Each subdir should use this macro
# to supply its header-files.
#
# Usage: GLOBAL_ADD_INCLUDE( RELATIVE_LOCATION hpp1, hpp2 ...)
MACRO( GLOBAL_ADD_INCLUDE COMPONENT_LOCATION )
#  INSTALL_FILES( /include/orocos/${OROCOS_TARGET}${RTTLIB_SUFFIX}/${COMPONENT_LOCATION} FILES ${ARGN})
  INSTALL_FILES( /include/${COMPONENT_LOCATION} FILES ${ARGN})
ENDMACRO( GLOBAL_ADD_INCLUDE COMPONENT_LOCATION )

#
# Sources should add themselves by calling 'GLOBAL_ADD_SRC' 
# instead of 'ADD_LIBRARY' in CMakeLists.txt.
#
# This gives a centralised location where all sources are registered
# and lets us make the library in just one place.
#
#
# Usage: GLOBAL_ADD_SRC( src1 src2 src3 )
#
MACRO( GLOBAL_ADD_SRC )
  STRING(LENGTH "${ARGN}" NOTEMPTY)
  IF(NOTEMPTY)
    SET (ENV{GLOBAL_LIBRARY_SRCS} "$ENV{GLOBAL_LIBRARY_SRCS}${ARGN};" )
  ENDIF(NOTEMPTY) 
ENDMACRO( GLOBAL_ADD_SRC )



MACRO( GLOBAL_ADD_TESTS TEST_NAME )
  IF(BUILD_TESTS)
    STRING(LENGTH "${ARGN}" NOTEMPTY)
    IF(NOTEMPTY)
    ADD_EXECUTABLE( ${TEST_NAME} ${ARGN} )
    ENDIF(NOTEMPTY) 
  ENDIF(BUILD_TESTS)
ENDMACRO( GLOBAL_ADD_TESTS TEST_NAME)


#http://www.cmake.org/Wiki/CMake_User_Contributed_Macros

#
# Generate rules for installing include files.
#
MACRO(COPY_HEADER_LIST TO_DIR EXTENSION)
   # Macro to implement copy_header_list for a list of files
   # Arguments - 
   #   TO_DIR   - this is the destination directory
#IF (MINGW)
IF (NOT MINGW)
FILE(GLOB_RECURSE files ./*.${EXTENSION} )
#FILE(GLOB files ${EXTENSION} )
FOREACH(file ${files})
  get_filename_component(po ${file} ABSOLUTE)
  get_filename_component(podir ${file} PATH)
  get_filename_component(outfile ${file} NAME)
  MESSAGE(STATUS "Moving \"${file}\" to include dir \"${TO_DIR}/${outfile}\" ")  
  #MESSAGE(STATUS "${COPY_FILE_COMMAND} -p \${file}\" \"${TO_DIR}/${outfile}\"")  
  IF(EXISTS "${file}")
    EXECUTE_PROCESS(
      COMMAND ${COPY_FILE_COMMAND} -p ${file} ${TO_DIR}/${outfile}
      OUTPUT_VARIABLE cp_out
      RESULT_VARIABLE cp_retval
      )
    IF(NOT "${cp_retval}" STREQUAL 0)
      MESSAGE(FATAL_ERROR "Problem when moving \"${podir} ${outfile}\"")
    ENDIF(NOT "${cp_retval}" STREQUAL 0)
  ELSE(EXISTS "${file}")
    MESSAGE(STATUS "File \"${file}\" does not exist.")
  ENDIF(EXISTS "${file}")
ENDFOREACH(file)
ENDIF (NOT MINGW)
#ENDIF (MINGW)
ENDMACRO(COPY_HEADER_LIST TO_DIR)

#HOW TO USE
#ADD_LIBRARY(foo SHARED kfoo1.cpp kfoo2.cpp)
#CREATE_LIBTOOL_FILE(foo /lib/kde3)
MACRO(GET_TARGET_PROPERTY_WITH_DEFAULT _variable _target _property _default_value)
  GET_TARGET_PROPERTY (${_variable} ${_target} ${_property})
  IF (${_variable} STREQUAL NOTFOUND)
    SET (${_variable} ${_default_value})
  ENDIF (${_variable} STREQUAL NOTFOUND)
ENDMACRO (GET_TARGET_PROPERTY_WITH_DEFAULT)

MACRO(CREATE_LIBTOOL_FILE _target _install_DIR)
  GET_TARGET_PROPERTY(_target_location ${_target} LOCATION)
  GET_TARGET_PROPERTY_WITH_DEFAULT(_target_static_lib ${_target} STATIC_LIB "")
  GET_TARGET_PROPERTY_WITH_DEFAULT(_target_dependency_libs ${_target} LT_DEPENDENCY_LIBS "")
  GET_TARGET_PROPERTY_WITH_DEFAULT(_target_current ${_target} LT_VERSION_CURRENT 0)
  GET_TARGET_PROPERTY_WITH_DEFAULT(_target_age ${_target} LT_VERSION_AGE 0)
  GET_TARGET_PROPERTY_WITH_DEFAULT(_target_revision ${_target} LT_VERSION_REVISION 0)
  GET_TARGET_PROPERTY_WITH_DEFAULT(_target_installed ${_target} LT_INSTALLED yes)
  GET_TARGET_PROPERTY_WITH_DEFAULT(_target_shouldnotlink ${_target} LT_SHOULDNOTLINK yes)
  GET_TARGET_PROPERTY_WITH_DEFAULT(_target_dlopen ${_target} LT_DLOPEN "")
  GET_TARGET_PROPERTY_WITH_DEFAULT(_target_dlpreopen ${_target} LT_DLPREOPEN "")
  GET_FILENAME_COMPONENT(_laname ${_target_location} NAME_WE)
  GET_FILENAME_COMPONENT(_soname ${_target_location} NAME)
  SET(_laname ${_laname}.la)
  FILE(WRITE ${_laname} "# ${_laname} - a libtool library file, generated by cmake \n")
  FILE(APPEND ${_laname} "# The name that we can dlopen(3).\n")
  FILE(APPEND ${_laname} "dlname='${_soname}'\n")
  FILE(APPEND ${_laname} "# Names of this library\n")
  FILE(APPEND ${_laname} "library_names='${_soname}.${_target_current}.${_target_age}.${_target_revision} ${_soname}.${_target_current} ${_soname}'\n")
  FILE(APPEND ${_laname} "# The name of the static archive\n")
  FILE(APPEND ${_laname} "old_library='${_target_static_lib}'\n")
  FILE(APPEND ${_laname} "# Libraries that this one depends upon.\n")
  FILE(APPEND ${_laname} "dependency_libs='${_target_dependency_libs}'\n")
  FILE(APPEND ${_laname} "# Version information.\n")
  FILE(APPEND ${_laname} "current=${_target_current}\n")
  FILE(APPEND ${_laname} "age=${_target_age}\n")
  FILE(APPEND ${_laname} "revision=${_target_revision}\n")
  FILE(APPEND ${_laname} "# Is this an already installed library?\n")
  FILE(APPEND ${_laname} "installed=${_target_installed}\n")
  FILE(APPEND ${_laname} "# Should we warn about portability when linking against -modules?\n")
  FILE(APPEND ${_laname} "shouldnotlink=${_target_shouldnotlink}\n")
  FILE(APPEND ${_laname} "# Files to dlopen/dlpreopen\n")
  FILE(APPEND ${_laname} "dlopen='${_target_dlopen}'\n")
  FILE(APPEND ${_laname} "dlpreopen='${_target_dlpreopen}'\n")
  FILE(APPEND ${_laname} "# Directory that this library needs to be installed in:\n")
  FILE(APPEND ${_laname} "libdir='${CMAKE_INSTALL_PREFIX}${_install_DIR}'\n")
  INSTALL( FILES ${_laname} ${_soname}
    DESTINATION ${CMAKE_INSTALL_PREFIX}${_install_DIR})
ENDMACRO(CREATE_LIBTOOL_FILE)

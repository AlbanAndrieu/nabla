# Locate TAO install directory

MESSAGE ( STATUS "Looking for TAO with orbsvcs...")

# DOES NOT WORK: TAO_ID.pc not found on debian system... detect .so files instead !
#PKGCONFIG( "TAO_PortableServer" TAO_FOUND TAO_INCLUDE_DIRS TAO_DEFINES TAO_LINK_DIRS TAO_LIBS )
#PKGCONFIG( "TAO_CosNaming" TAONAMING_FOUND TAONAMING_INCLUDE_DIRS TAONAMING_DEFINES TAONAMING_LINK_DIRS TAONAMING_LIBS )

IF(CYGWIN)
  MESSAGE(STATUS "CYGWIN found ACE_DIR and TAO_ROOT setted to default values")
  SET(ACE_DIR "${PROJECT_THIRDPARTY_PATH}/tao/ACE_wrappers")
  SET(TAO_DIR "${PROJECT_THIRDPARTY_PATH}/tao/ACE_wrappers/TAO")  
  #SET(ACE_DIR "${PROJECT_THIRDPARTY_PATH}/ACE_wrappers")
  #SET(TAO_DIR "${PROJECT_THIRDPARTY_PATH}/ACE_wrappers/TAO")      
ELSE(CYGWIN)
  MESSAGE(STATUS "CYGWIN not found ACE_DIR and TAO_ROOT setted to environement values")
  SET(ACE_DIR $ENV{ACE_ROOT})
  SET(TAO_DIR $ENV{TAO_ROOT})
ENDIF(CYGWIN)

IF (NOT ACE_DIR AND NOT CMAKE_CROSS_COMPILE)
    SET(ACE_DIR /usr)
ENDIF (NOT ACE_DIR AND NOT CMAKE_CROSS_COMPILE )
IF (NOT TAO_DIR AND NOT CMAKE_CROSS_COMPILE )
    SET(TAO_DIR /usr)
ENDIF (NOT TAO_DIR AND NOT CMAKE_CROSS_COMPILE )

MESSAGE( "TAO_DIR is ${TAO_DIR}" )
MESSAGE( "ACE_DIR is ${ACE_DIR}" )

# See if headers are present.
IF(CYGWIN)
  MESSAGE(STATUS "CYGWIN found ACE_DIR and TAO_ROOT setted to default values")
  FIND_FILE(ACE_CONFIG config-all.h ${ACE_DIR}/ace )
  FIND_FILE(TAO_ORB ORB.h ${TAO_DIR}/tao )
  FIND_FILE(TAO_15 Any.h ${TAO_DIR}/tao/AnyTypeCode )
ELSE(CYGWIN)
  MESSAGE(STATUS "CYGWIN not found ACE_DIR and TAO_ROOT setted to environement values")
  FIND_FILE(ACE_CONFIG config-all.h ${ACE_DIR}/include/ace )
  FIND_FILE(TAO_ORB ORB.h ${TAO_DIR}/include/tao )
  FIND_FILE(TAO_ORB ORB.h ${TAO_DIR}/TAO/tao )
  FIND_FILE(TAO_15 Any.h ${TAO_DIR}/include/tao/AnyTypeCode )
  FIND_FILE(TAO_15 Any.h ${TAO_DIR}/TAO/tao/AnyTypeCode )
ENDIF(CYGWIN)
  
# try to find orbsvcs (FIX: include CosNaming.idl ourselves ??)
IF (NOT ORBSVCS_DIR )
    FIND_FILE(TAO_ORBSVCS CosNaming.idl ${TAO_DIR}/TAO/orbsvcs/orbsvcs)
    IF (TAO_ORBSVCS)
        SET( ORBSVCS_DIR ${TAO_DIR}/TAO/orbsvcs/orbsvcs )
    ELSE (TAO_ORBSVCS)        
                
    ENDIF (TAO_ORBSVCS)    
    
    FIND_FILE(TAO_ORBSVCS CosNaming.idl ${TAO_DIR}/include/orbsvcs )
    IF (TAO_ORBSVCS)
        SET( ORBSVCS_DIR ${TAO_DIR}/include/orbsvcs )
    ELSE (TAO_ORBSVCS)
    ENDIF (TAO_ORBSVCS)    

    FIND_FILE(TAO_ORBSVCS CosNaming.idl ${TAO_DIR}/orbsvcs/orbsvcs )
    IF (TAO_ORBSVCS)
        SET( ORBSVCS_DIR ${TAO_DIR}/orbsvcs/orbsvcs )
    ELSE (TAO_ORBSVCS)
    ENDIF (TAO_ORBSVCS)    
        
ENDIF (NOT ORBSVCS_DIR )

IF (NOT ACE_CONFIG )
    IF(CYGWIN)
        MESSAGE( "ACE config-all.h not found in ${ACE_DIR}/ace.")
    ELSE(CYGWIN)
        MESSAGE( "ACE config-all.h not found in ${ACE_DIR}/include/ace.")
    ENDIF(CYGWIN)  
ELSE(NOT ACE_CONFIG ) 
    IF(CYGWIN)
        MESSAGE( "ACE config-all.h found in ${ACE_DIR}/ace.")
    ELSE(CYGWIN)
        MESSAGE( "ACE config-all.h found in ${ACE_DIR}/include/ace.")
    ENDIF(CYGWIN)    
ENDIF (NOT ACE_CONFIG )

IF (NOT TAO_ORB )
    IF(CYGWIN)
        MESSAGE( "TAO ORB.h not found in ${TAO_DIR}/tao.")
    ELSE(CYGWIN)
        MESSAGE( "TAO ORB.h not found in ${TAO_DIR}/include/tao.")
    ENDIF(CYGWIN)      
ELSE (NOT TAO_ORB )
    IF(CYGWIN)
        MESSAGE( "TAO ORB.h found in ${TAO_DIR}/tao.")
    ELSE(CYGWIN)
        MESSAGE( "TAO ORB.h found in ${TAO_DIR}/include/tao.")
    ENDIF(CYGWIN)    
ENDIF (NOT TAO_ORB )

IF (NOT TAO_15 )
    MESSAGE( "Assuming TAO < 1.5 (based on location of Any.h)")
ELSE (NOT TAO_15 )
    MESSAGE( "Assuming TAO >= 1.5 (based on location of Any.h)")
ENDIF (NOT TAO_15 )

IF (NOT TAO_ORBSVCS )
    MESSAGE( "TAO orbsvcs/CosNaming.idl not found in ${ORBSVCS_DIR}.")
ELSE (NOT TAO_ORBSVCS )    
    MESSAGE( "TAO orbsvcs/CosNaming.idl found in ${ORBSVCS_DIR}.")
ENDIF (NOT TAO_ORBSVCS )

IF (ACE_CONFIG AND TAO_ORB AND TAO_ORBSVCS )
    MESSAGE ( "TAO with orbsvcs found.")

    FIND_PROGRAM( ORO_TAOIDL_EXECUTABLE tao_idl PATHS "${ACE_DIR}/bin" NO_DEFAULT_PATH )
    FIND_PROGRAM( ORO_TAOIDL_EXECUTABLE tao_idl )

    IF( NOT ORO_TAOIDL_EXECUTABLE )
        MESSAGE( FATAL "TAO Headers found but no tao_idl !")
    ELSE( NOT ORO_TAOIDL_EXECUTABLE )
        MESSAGE( "tao_idl: ${ORO_TAOIDL_EXECUTABLE}")
        SET(FOUND_TAO TRUE)
        SET(CORBA_IS_TAO 1)

        SET(CORBA_CFLAGS "")
        SET(CORBA_INCLUDE_DIRS "")
        SET(CORBA_LDFLAGS "")
        SET(CORBA_LIBRARIES "")
        SET(CORBA_LINK_DIRECTORIES "")
        SET(CORBA_DEFINES "") #-DCORBA_IS_TAO)

        # Set include/link variables
        IF( ${ACE_DIR} STREQUAL /usr )
            LIST(APPEND CORBA_INCLUDE_DIRS "${ACE_DIR}/include")
            LIST(APPEND CORBA_CFLAGS "-I${ACE_DIR}/include")
            LIST(APPEND CORBA_LINK_DIRECTORIES "${ACE_DIR}/lib")
            LIST(APPEND CORBA_LDFLAGS "-L${ACE_DIR}/lib")
        ENDIF( ${ACE_DIR} STREQUAL /usr )
        IF( NOT ${ACE_DIR} STREQUAL /usr )
            LIST(APPEND CORBA_INCLUDE_DIRS "${ACE_DIR}/include")
            LIST(APPEND CORBA_CFLAGS "-I${ACE_DIR}/include")
            LIST(APPEND CORBA_LINK_DIRECTORIES "${ACE_DIR}/lib")
            LIST(APPEND CORBA_LDFLAGS "-L${ACE_DIR}/lib")
        ENDIF( NOT ${ACE_DIR} STREQUAL /usr )
        IF( NOT ${TAO_DIR} STREQUAL /usr AND NOT ${TAO_DIR} STREQUAL ${ACE_DIR})
            #LIST(APPEND CORBA_INCLUDE_DIRS "${TAO_DIR}/include")
            #LIST(APPEND CORBA_CFLAGS "-I${TAO_DIR}/include")
            LIST(APPEND CORBA_LINK_DIRECTORIES "${TAO_DIR}/lib")
            LIST(APPEND CORBA_LDFLAGS "-L${TAO_DIR}/lib")
        ENDIF( NOT ${TAO_DIR} STREQUAL /usr AND NOT ${TAO_DIR} STREQUAL ${ACE_DIR})
        IF( NOT ${ORBSVCS_DIR} STREQUAL /usr AND NOT ${ORBSVCS_DIR} STREQUAL ${TAO_DIR})
            LIST(APPEND CORBA_INCLUDE_DIRS "${ORBSVCS_DIR}")
            LIST(APPEND CORBA_CFLAGS "-I${ORBSVCS_DIR}")
            LIST(APPEND CORBA_LINK_DIRECTORIES "${ORBSVCS_DIR}/lib")
            LIST(APPEND CORBA_LDFLAGS "-L${ORBSVCS_DIR}/lib")
        ENDIF( NOT ${ORBSVCS_DIR} STREQUAL /usr AND NOT ${ORBSVCS_DIR} STREQUAL ${TAO_DIR})

        # Is used for building  the library
        LIST(APPEND CORBA_LIBRARIES TAO TAO_PortableServer TAO_CosNaming ACE)        
        LIST(APPEND CORBA_LDFLAGS -lTAO -lTAO_PortableServer -lTAO_CosNaming -lACE)

        IF(APPLE)
            # Mac OS X needs this define (or _POSIX_C_SOURCE) to pick up some type
            # definitions that ACE/TAO needs. Personally, I think this is a bug in
            # ACE/TAO, but ....
            LIST(APPEND CORBA_CFLAGS -D_DARWIN_C_SOURCE)
            # and needs additional libraries 
            LIST(APPEND CORBA_LIBRARIES TAO_AnyTypeCode)
        ENDIF(APPLE)

        IF( NOT TAO_15 )
	    IF(CMAKE_HOST_SYSTEM_NAME MATCHES "Linux")
              LIST(APPEND CORBA_LIBRARIES TAO_IDL_BE_DLL)
              LIST(APPEND CORBA_LDFLAGS -lTAO_IDL_BE_DLL)
	    ELSE(CMAKE_HOST_SYSTEM_NAME MATCHES "Linux")
	      LIST(APPEND CORBA_LIBRARIES TAO_IDL_BE)
              LIST(APPEND CORBA_LDFLAGS -lTAO_IDL_BE)
	    ENDIF(CMAKE_HOST_SYSTEM_NAME MATCHES "Linux")
        ENDIF( NOT TAO_15 )
    ENDIF( NOT ORO_TAOIDL_EXECUTABLE )
ENDIF (ACE_CONFIG AND TAO_ORB AND TAO_ORBSVCS )

# Generate all files required for a corba server app.
# PROJECT_ADD_CORBA_SERVERS( foo_SRCS foo_HPPS file.idl ... ) 
MACRO(PROJECT_ADD_CORBA_SERVERS _sources _headers)
   FOREACH (_current_FILE ${ARGN})

      GET_FILENAME_COMPONENT(_tmp_FILE ${_current_FILE} ABSOLUTE)
      GET_FILENAME_COMPONENT(_basename ${_tmp_FILE} NAME_WE)
      GET_FILENAME_COMPONENT(_filedir ${_tmp_FILE} PATH)

      SET(_server  ${CMAKE_CURRENT_BINARY_DIR}/${_basename}_s.cc)
      SET(_serverh ${CMAKE_CURRENT_BINARY_DIR}/${_basename}_s.hh ${CMAKE_CURRENT_BINARY_DIR}/${_basename}_s.i)

      # From TAO 1.5 onwards, the _T files are no longer generated
      IF( NOT TAO_15 )
          SET(_tserver )
          SET(_tserverh ${CMAKE_CURRENT_BINARY_DIR}/${_basename}_st.hh ${CMAKE_CURRENT_BINARY_DIR}/${_basename}_st.i ${CMAKE_CURRENT_BINARY_DIR}/${_basename}_st.cc)
      ENDIF( NOT TAO_15 )

      SET(_client  ${CMAKE_CURRENT_BINARY_DIR}/${_basename}.cc)
      SET(_clienth ${CMAKE_CURRENT_BINARY_DIR}/${_basename}_s.hh ${CMAKE_CURRENT_BINARY_DIR}/${_basename}.i)

      IF (NOT HAVE_${_basename}_SERVER_RULE)
         SET(HAVE_${_basename}_SERVER_RULE ON)
	 
        # CMake atrocity: if none of these OUTPUT files is used in a target in the current CMakeLists.txt file,
        # the ADD_CUSTOM_COMMAND is plainly ignored and left out of the make files.
     
         IF(CMAKE_HOST_SYSTEM_NAME MATCHES "Linux")
           MESSAGE( "tao_idl: ${ORO_TAOIDL_EXECUTABLE} -hc .hh -hs _s.hh -cs .cc -ss _s.cc -st _st.i -sT _st.cc -si _s.i -ci .i -hT _st.hh ${_current_FILE} -o ${CMAKE_CURRENT_BINARY_DIR} -I${CMAKE_CURRENT_SOURCE_DIR} -I${ORBSVCS_DIR}")
	 ELSE(CMAKE_HOST_SYSTEM_NAME MATCHES "Linux")
	   MESSAGE( "tao_idl: ${ORO_TAOIDL_EXECUTABLE} -hc .hh -hs _s.hh -cs .cc -ss _s.cc -sT _st.cc -si _s.i -ci .i -hT _st.hh ${_current_FILE} -o ${CMAKE_CURRENT_BINARY_DIR} -I${CMAKE_CURRENT_SOURCE_DIR} -I${ORBSVCS_DIR}")
	 ENDIF(CMAKE_HOST_SYSTEM_NAME MATCHES "Linux")
	 
         IF(CMAKE_HOST_SYSTEM_NAME MATCHES "Linux")
           ADD_CUSTOM_COMMAND(OUTPUT ${_tserver} ${_server} ${_client} ${_tserverh} ${_serverh} ${_clienth}	 
             COMMAND ${ORO_TAOIDL_EXECUTABLE} -hc .hh -hs _s.hh -cs .cc -ss _s.cc -st _st.i -sT _st.cc -si _s.i -ci .i -hT _st.hh ${_current_FILE} -o ${CMAKE_CURRENT_BINARY_DIR} -I${CMAKE_CURRENT_SOURCE_DIR} -I${ORBSVCS_DIR} -I${PROJECT_INCLUDE_DIR}
           DEPENDS ${_tmp_FILE}
           )
	 ELSE(CMAKE_HOST_SYSTEM_NAME MATCHES "Linux")
           ADD_CUSTOM_COMMAND(OUTPUT ${_tserver} ${_server} ${_client} ${_tserverh} ${_serverh} ${_clienth}
	     COMMAND ${ORO_TAOIDL_EXECUTABLE} -hc .hh -hs _s.hh -cs .cc -ss _s.cc -sT _st.cc -si _s.i -ci .i -hT _st.hh ${_current_FILE} -o ${CMAKE_CURRENT_BINARY_DIR} -I${CMAKE_CURRENT_SOURCE_DIR} -I${ORBSVCS_DIR} -I${PROJECT_INCLUDE_DIR}
	   DEPENDS ${_tmp_FILE}
           )	 
	 ENDIF(CMAKE_HOST_SYSTEM_NAME MATCHES "Linux")
	 
     ENDIF (NOT HAVE_${_basename}_SERVER_RULE)

     SET(${_sources} ${${_sources}} ${_server} ${_tserver} ${_client})
     SET(${_headers} ${${_headers}} ${_serverh} ${_tserverh} ${_clienth})

     SET_SOURCE_FILES_PROPERTIES(${_server} ${_serverh} ${_tserver} ${_client} ${_tserverh} ${_clienth} PROPERTIES GENERATED TRUE)
    ENDFOREACH (_current_FILE)
ENDMACRO(PROJECT_ADD_CORBA_SERVERS)

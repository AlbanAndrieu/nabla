#
# File generated by CMakeBuilder
#
#

SET(CMAKE_BUILT_TYPE "Debug")

IF(CMAKE_COMPILER_IS_GNUCC)
  SET(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -fmessage-length=0")
ENDIF(CMAKE_COMPILER_IS_GNUCC)
IF(CMAKE_COMPILER_IS_GNUCXX)
  SET(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fmessage-length=0")
ENDIF(CMAKE_COMPILER_IS_GNUCXX)

OPTION(BUILD_SHARED_LIBS "Build shared libraries." ON)

SET(CMAKE_COLOR_MAKEFILE ON)
SET(CMAKE_VERBOSE_MAKEFILE ON)

SET(EXECUTABLE_OUTPUT_PATH bin/${CMAKE_BUILD_TYPE})
        
# AIX                           AIX  
# BSD/OS                        BSD/OS  
# FreeBSD                       FreeBSD  
# HP-UX                         HP-UX  
# IRIX                          IRIX  
# Linux                         Linux  
# NetBSD                        NetBSD  
# OpenBSD                       OpenBSD  
# OFS/1 (Digital Unix)          OSF1  
# SCO OpenServer 5              SCO_SV  
# SCO UnixWare 7                UnixWare  
# SCO UnixWare (pre release 7)  UNIX_SV  
# SCO XENIX                     Xenix  
# Solaris                       SunOS  
# SunOS                         SunOS  
# Tru64                         Tru64  
# Ultrix                        ULTRIX  
# cygwin                        CYGWIN_NT-5.1
# MacOSX                        Darwin

MESSAGE("OS is : ${CMAKE_SYSTEM}-${CMAKE_SYSTEM_VERSION} ${CMAKE_UNAME} ${CMAKE_HOST_UNIX} ${CMAKE_HOST_SYSTEM_NAME} ${CMAKE_HOST_SYSTEM_PROCESSOR} ")

#default /usr/local
#SET(CMAKE_INSTALL_PREFIX  /usr/local)

SET(PROJECT_TARGET ${CMAKE_BUILD_TYPE})

MESSAGE(STATUS "PROJECT_SRC, PROJECT_OBJ and THIRDPARTY_ROOT setted to environement values")
  
#SET(DEV_SOURCE_DIR "$ENV{PROJECT_SRC}")
SET(DEV_SOURCE_DIR "/cygdrive/c/workspace/users/albandri10/cpp")
#SET(DEV_BINARY_DIR "$ENV{PROJECT_OBJ}")
SET(DEV_BINARY_DIR "/cygdrive/c/target")
SET(PROJECT_SOURCE_DIR "${DEV_SOURCE_DIR}")
SET(PROJECT_BINARY_DIR "${DEV_BINARY_DIR}")
SET(THIRDPARTY_ROOT "$ENV{THIRDPARTY_ROOT}")
SET(THIRDPARTY_ROOT_LOCAL "${THIRDPARTY_ROOT}")

SET(DATABASE_ROOT "${THIRDPARTY_ROOT_LOCAL}/database")

MESSAGE("CMAKE_SYSTEM is ${CMAKE_SYSTEM}")

IF(UNIX)

  MESSAGE(STATUS "UNIX found")  

  IF(CMAKE_HOST_SYSTEM_NAME MATCHES "Linux")
    MESSAGE(STATUS "Linux found")
    SET(MACHINE x86Linux)

    SET(CMAKE_CXX_FLAGS "-g -Wall -pthread")
    SET(CMAKE_SHARED_LINKER_FLAGS "-Wl,--no-undefined")
    ADD_DEFINITIONS(-Dlinux -DP100)

  ELSE(CMAKE_HOST_SYSTEM_NAME MATCHES "Linux")
    MESSAGE(STATUS "Linux not found")
  ENDIF(CMAKE_HOST_SYSTEM_NAME MATCHES "Linux")

  IF(CMAKE_HOST_SYSTEM_NAME MATCHES "SunOS")
    MESSAGE(STATUS "SunOS found")
    SET(MACHINE sun4sol)

    ADD_DEFINITIONS(-Dsolaris -DSYSV -DSVR4 -DP100 -DDEBUG -DANSI_C -D_POSIX_THREADS -mt -xildoff -DOWTOOLKIT_WARNING_DISABLED)
    
  ELSE(CMAKE_HOST_SYSTEM_NAME MATCHES "SunOS")
    MESSAGE(STATUS "SunOS not found")
  ENDIF(CMAKE_HOST_SYSTEM_NAME MATCHES "SunOS")

  IF("${CMAKE_SYSTEM}" MATCHES "SunOS-5.10")
    MESSAGE(STATUS "SunOS-5.10 found")
    SET(MACHINE x86sol)  
    
  ELSE("${CMAKE_SYSTEM}" MATCHES "SunOS-5.10")
    MESSAGE(STATUS "SunOS-5.10 not found")
  ENDIF("${CMAKE_SYSTEM}" MATCHES "SunOS-5.10")    

  IF(CMAKE_HOST_SYSTEM_NAME MATCHES "CYGWIN")
    MESSAGE(STATUS "CYGWIN found")
    SET(MACHINE x86Linux)    
    
    SET(GCC_VERSION 3.4.4)  
    
    #For Eclipse to avoid : Unresolved inclusion add this to the include path
    #INCLUDE_DIRECTORIES("/cygdrive/c/cygwin/lib/gcc/i686-pc-cygwin/${GCC_VERSION}/include/c++")
    #LINK_DIRECTORIES("/cygdrive/c/cygwin/lib/gcc/i686-pc-cygwin/${GCC_VERSION}/debug")
        
    SET(CMAKE_SHARED_LINKER_FLAGS "-Wl,--no-undefined")

    ADD_DEFINITIONS(-Dcygwin -Dlinux -DP100)
    ADD_DEFINITIONS(-DDEBUG -DNOMINMAX)
    ADD_DEFINITIONS(-DEXCEPTION_EXPORTS)
 
  ELSE(CMAKE_HOST_SYSTEM_NAME MATCHES "CYGWIN")
    MESSAGE(STATUS "CYGWIN not found")
  ENDIF(CMAKE_HOST_SYSTEM_NAME MATCHES "CYGWIN")    

ELSE(UNIX)
  MESSAGE(STATUS "UNIX not found")
ENDIF(UNIX)

IF(MINGW)

  MESSAGE(STATUS "MINGW found")    
  SET(MACHINE x86Linux)    

  SET(TIBCO_VERSION "7.2")
  SET(XERCES_VERSION "2_5_0")
  SET(CORBA_VERSION "1_3_")

  INCLUDE_DIRECTORIES("C:\\cygwin\\usr\\include")
  LINK_DIRECTORIES("C:\\cygwin\\lib")

  ADD_DEFINITIONS(-Dlinux -DuseTao -DACE_HAS_EXCEPTIONS -D_TEMPLATES_ENABLE_ -D_REENTRANT -DEffix_Infra_HAS_BOOL)
    
ELSE(MINGW)
  MESSAGE(STATUS "MINGW not found")
  
ENDIF(MINGW)

#SET(PROJECT_INCLUDE_DIR ${PROJECT_BINARY_DIR}/include/${PROJECT_TARGET})
SET(PROJECT_INCLUDE_DIR ${PROJECT_BINARY_DIR}/install/${MACHINE}/${PROJECT_TARGET}/include)
SET(PROJECT_INSTALL_DIR ${PROJECT_BINARY_DIR}/install/${MACHINE}/${PROJECT_TARGET})
SET(LIBRARY_OUTPUT_PATH ${PROJECT_BINARY_DIR}/lib/${MACHINE}/${PROJECT_TARGET})
SET(EXECUTABLE_OUTPUT_PATH ${PROJECT_BINARY_DIR}/bin/${MACHINE}/${PROJECT_TARGET})

SET(CORBA_PC_DIR ${PROJECT_BINARY_DIR}/project/corba/${MACHINE}/${PROJECT_TARGET})

MESSAGE(STATUS "MACHINE is ${MACHINE}")
  
MAKE_DIRECTORY(${PROJECT_INCLUDE_DIR}) 
MAKE_DIRECTORY(${CORBA_PC_DIR})

OPTION(BUILD_SHARED_LIBS "Build PROJECT shared libraries." OFF)

#IF(WIN32)
#  ADD_DEFINITIONS("-DWIN32")
#ENDIF(WIN32)

CONFIGURE_FILE(${PROJECT_SOURCE_DIR}/config/config.h.in ${PROJECT_INCLUDE_DIR}/config.h)
MESSAGE(STATUS "configured ${PROJECT_SOURCE_DIR}/config/config.h.in --> ${PROJECT_INCLUDE_DIR}/config.h")

SET(MOVE_FILE_COMMAND mv)
SET(COPY_FILE_COMMAND cp)

MESSAGE(STATUS "Project source directory is ${PROJECT_SOURCE_DIR}")
MESSAGE(STATUS "Project include directory is ${PROJECT_INCLUDE_DIR}")

INCLUDE(${PROJECT_SOURCE_DIR}/config/ProjectVersion.cmake)

INCLUDE(${PROJECT_SOURCE_DIR}/config/ProjectMacro.cmake)

OPTION(ENABLE_TESTS "Enable building of tests" ON)

IF( ENABLE_TESTS )
  INCLUDE(FindCppUnit)
ENDIF(ENABLE_TESTS )

#Inclusion
# See ${PROJ_SOURCE_DIR}/config for special inclusion
INCLUDE(FindBoost)
INCLUDE(FindGettext)
INCLUDE(FindLibXml2)
#INCLUDE(FindX11)
#INCLUDE(FindQt3)
INCLUDE(FindZLIB)
INCLUDE(FindDoxygen)

#HOW TO USE
#cmake -DWITH_GUI=ON -DDATA_DIR=/home/me/datadir .

IF (NOT DATA_DIR)
  SET(DATA_DIR "/usr/share/mydatadir")
ENDIF(NOT DATA_DIR)
MESSAGE(STATUS "Data are in directory ${DATA_DIR}")

INCLUDE_DIRECTORIES(${PROJECT_INCLUDE_DIR})
#INCLUDE_DIRECTORIES(${CMAKE_INSTALL_PREFIX})

IF(UNIX)

  MESSAGE(STATUS "UNIX found")  

  IF(CMAKE_HOST_SYSTEM_NAME MATCHES "SunOS")
    MESSAGE(STATUS "SunOS found")

    SET(TIBCO_VERSION "8.1.2")
    SET(XERCES_VERSION "3_0_1")
    
    #Inclusion de CORBA
    SET(CORBA_VERSION "")

    SET(JAVA_AWT_INCLUDE_DIRECTORIES ${THIRDPARTY_ROOT}/j2se/${MACHINE}/jdk1.5/include)
    SET(JAVA_INCLUDE_PATH ${THIRDPARTY_ROOT}/j2se/${MACHINE}/jdk1.5/include/solaris)
    SET(JAVA_INCLUDE_PATH2 ${THIRDPARTY_ROOT}/j2se/${MACHINE}/jdk1.5/include/solaris)
    SET(JAVA_JVM_LIBRARY_DIRECTORIES ${THIRDPARTY_ROOT}/j2se/${MACHINE}/jdk1.5/jre/lib/sparc)

    SET(JAVA_AWT_LIBRARY ${JAVA_JVM_LIBRARY_DIRECTORIES}/libjawt.so ${JAVA_JVM_LIBRARY_DIRECTORIES}/xawt/libmawt.so)
    SET(JAVA_JVM_LIBRARY ${JAVA_JVM_LIBRARY_DIRECTORIES}/libjvm.so)    
    
  ELSE(CMAKE_HOST_SYSTEM_NAME MATCHES "SunOS")
    MESSAGE(STATUS "SunOS not found")
  ENDIF(CMAKE_HOST_SYSTEM_NAME MATCHES "SunOS")

  IF("${CMAKE_SYSTEM}" MATCHES "SunOS-5.10")
    MESSAGE(STATUS "SunOS-5.10 found")
    SET(MACHINE x86sol)  
    
  ELSE("${CMAKE_SYSTEM}" MATCHES "SunOS-5.10")
    MESSAGE(STATUS "SunOS-5.10 not found")
  ENDIF("${CMAKE_SYSTEM}" MATCHES "SunOS-5.10")    

  IF(CMAKE_HOST_SYSTEM_NAME MATCHES "Linux")
    MESSAGE(STATUS "Linux found")

    SET(TIBCO_VERSION "7.2.x")

    SET(SYBASE_VERSION "12.5")
    SET(SYBASE_SERVER_VERSION "12.51")
    SET(SYBASE_ESD_VERSION "17")    

    LINK_DIRECTORIES(/usr/lib)
        
    SET(BOOST_OUTPUT_PATH ${PROJECT_BINARY_DIR}/install/${MACHINE}/${PROJECT_TARGET}/lib/boost-1_41_0)
    LINK_DIRECTORIES(${BOOST_OUTPUT_PATH})
          
    #z boost_thread-gcc-mt intl ncurses
    SET(Boost_LIBRARIES boost_thread-mt)
    SET(ZLIB_LIBRARY_DIRS z)
    SET(Gettext_LIBRARY_DIRS intl ncurses)
    SET(LIBXML_LIBRARY_DIRS xml2)

    LINK_DIRECTORIES(${Gettext_LIBRARY_DIRS})
  
    #Inclusion de CORBA
    #INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers)
    #INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/TAO)
    #INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/TAO/orbsvcs)
  
    LINK_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib)        
    
    INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/database/sybase/openclient/${SYBASE_SERVER_VERSION}/ESD_${SYBASE_ESD_VERSION}/${MACHINE}/include)    
        
    LINK_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/database/sybase/openclient/${SYBASE_SERVER_VERSION}/ESD_${SYBASE_ESD_VERSION}/${MACHINE}/lib)
    LINK_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/database/sybase/openclient/${SYBASE_SERVER_VERSION}/ESD_${SYBASE_ESD_VERSION}/${MACHINE}/lib3p)
    LINK_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/database/sybase/openclient/${SYBASE_SERVER_VERSION}/ESD_${SYBASE_ESD_VERSION}/${MACHINE}/dll/debug)
    
    #INCLUDE_DIRECTORIES(/cygdrive/c/oraclexe/app/oracle/product/10.2.0/server/OCI/include)
    #LINK_DIRECTORIES(/cygdrive/c/oraclexe/app/oracle/product/10.2.0/server/OCI/lib/MSVC/vc71)

    INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/artix30/${MACHINE}/artix/3.0/include)
    LINK_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/artix30/${MACHINE}/bin)  
    
  ELSE(CMAKE_HOST_SYSTEM_NAME MATCHES "Linux")
    MESSAGE(STATUS "Linux not found")
  ENDIF(CMAKE_HOST_SYSTEM_NAME MATCHES "Linux")

  IF(CMAKE_HOST_SYSTEM_NAME MATCHES "CYGWIN")
    MESSAGE(STATUS "CYGWIN found")     
        
    #SET(LIB_PREFIX lib)
    #SET(LIB_STATIC_SUFFIX .a)
    #SET(LIB_DYNAMIC_SUFFIX .dll)

    SET(TIBCO_VERSION "7.2.x")   
    
    SET(SYBASE_VERSION "12.5")
    SET(SYBASE_SERVER_VERSION "12.51")
    SET(SYBASE_ESD_VERSION "17")    
    
    LINK_DIRECTORIES(/usr/lib)
        
    SET(BOOST_OUTPUT_PATH ${PROJECT_BINARY_DIR}/install/${MACHINE}/${PROJECT_TARGET}/lib/boost-1_41_0)
    LINK_DIRECTORIES(${BOOST_OUTPUT_PATH})
          
    #z boost_thread-gcc-mt intl ncurses
    #SET(Boost_LIBRARIES boost_thread-gcc-mt)
    SET(Boost_LIBRARIES boost_thread-gcc34-mt-1_41)
    SET(ZLIB_LIBRARY_DIRS z)
    SET(Gettext_LIBRARY_DIRS intl ncurses)  
    #SET(LIBXML_LIBRARY_DIRS LIBXML2_LIBRARIES) 
    SET(LIBXML_LIBRARY_DIRS xml2)

    LINK_DIRECTORIES(${Gettext_LIBRARY_DIRS})
  
    #Inclusion de CORBA
    INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers)
    INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/TAO)
    INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/TAO/orbsvcs)
  
    LINK_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib)        
    
    INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/database/sybase/openclient/${SYBASE_SERVER_VERSION}/ESD_${SYBASE_ESD_VERSION}/${MACHINE}/include)    
        
    LINK_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/database/sybase/openclient/${SYBASE_SERVER_VERSION}/ESD_${SYBASE_ESD_VERSION}/${MACHINE}/lib)
    LINK_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/database/sybase/openclient/${SYBASE_SERVER_VERSION}/ESD_${SYBASE_ESD_VERSION}/${MACHINE}/lib3p)
    LINK_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/database/sybase/openclient/${SYBASE_SERVER_VERSION}/ESD_${SYBASE_ESD_VERSION}/${MACHINE}/dll/debug)
    
    INCLUDE_DIRECTORIES(/cygdrive/c/oraclexe/app/oracle/product/10.2.0/server/OCI/include)
    LINK_DIRECTORIES(/cygdrive/c/oraclexe/app/oracle/product/10.2.0/server/OCI/lib/MSVC/vc71)
            
    #${JAVA_JVM_LIBRARY_DIRECTORIES}/xawt/libmawt.so
    #SET(JAVA_AWT_LIBRARY ${JAVA_JVM_LIBRARY_DIRECTORIES}/jawt.dll)
    #SET(JAVA_JVM_LIBRARY ${JAVA_JVM_LIBRARY_DIRECTORIES}/jvm.dll)    

    INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/artix30/${MACHINE}/artix/3.0/include)
    LINK_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/artix30/${MACHINE}/bin)  
                    
  ENDIF(CMAKE_HOST_SYSTEM_NAME MATCHES "CYGWIN")  
  
  IF(CMAKE_HOST_SYSTEM_NAME MATCHES "SunOS")  

    LINK_DIRECTORIES(/usr/lib)

    SET(LIB_PREFIX lib)
    SET(LIB_STATIC_SUFFIX .a)
    SET(LIB_DYNAMIC_SUFFIX .so)
      
    #QT_USE_FILE
    #SET(QT_INCLUDE_DIR ${TOOLS_ROOT}/qt/${QT_VERSION}/${MACHINE}/opt/include)
    #SET(QT_BINARY_DIR ${TOOLS_ROOT}/qt/${QT_VERSION}/${MACHINE}/opt/bin)
    #SET(QT_LIBRARY_DIR ${TOOLS_ROOT}/qt/${QT_VERSION}/${MACHINE}/debug/lib)
    #SET(QT_PLUGINS_DIR ${TOOLS_ROOT}/qt/${QT_VERSION}/${MACHINE}/opt/plugins)
    #SET(QT_TRANSLATIONS_DIR ${TOOLS_ROOT}/qt/${QT_VERSION}/${MACHINE}/opt/translations)
    #SET(QT_DOC_DIR ${TOOLS_ROOT}/qt/${QT_VERSION}/${MACHINE}/opt/doc)
    #SET(QT_MKSPECS_DIR ${TOOLS_ROOT}/qt/${QT_VERSION}/${MACHINE}/opt/mkspecs)
  
    #INCLUDE(${QT_INCLUDE_DIR})
    #LINK_DIRECTORIES(${QT_LIBRARY_DIR})
    
    #SET(Qt3_FOUND)
    
    #Inclusion de CORBA
    INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT}/corba/tao/${CORBA_VERSION}${MACHINE}/ACE_wrappers)
    INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT}/corba/tao/${CORBA_VERSION}${MACHINE}/ACE_wrappers/TAO)
    INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT}/corba/tao/${CORBA_VERSION}${MACHINE}/ACE_wrappers/TAO/orbsvcs)
  
    LINK_DIRECTORIES(${THIRDPARTY_ROOT}/corba/tao/${CORBA_VERSION}${MACHINE}/lib/${MACHINE}.mt/debug/shared)
    LINK_DIRECTORIES(${THIRDPARTY_ROOT}/corba/tao/${CORBA_VERSION}${MACHINE}/lib/${MACHINE}.mt/gcc/opt/shared)
  
    #Inclusion de BOOST
    SET(Boost_INCLUDE_DIRS ${THIRDPARTY_ROOT}/boost/${BOOST_VERSION}/include)
    MESSAGE(STATUS "Boost_INCLUDE_DIRS : ${Boost_INCLUDE_DIRS}")
    SET(Boost_LIBRARY_DIRS ${THIRDPARTY_ROOT}/boost/${BOOST_VERSION}/lib/${MACHINE}/debug/shared)
    MESSAGE(STATUS "Boost_LIBRARY_DIRS : ${Boost_LIBRARY_DIRS}")  
    #SET(Boost_FOUND TRUE)

    #Inclusion de XERCES
    INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT}/xml/xerces/c++/${XERCES_VERSION}/${MACHINE}/include)
    LINK_DIRECTORIES(${THIRDPARTY_ROOT}/xml/xerces/c++/${XERCES_VERSION}/${MACHINE}/lib)

    #Inclusion de CPPUNIT
    INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT}/cppunit/${CPPUNIT_VERSION}/include)
    LINK_DIRECTORIES(${THIRDPARTY_ROOT}/cppunit/${CPPUNIT_VERSION}/lib/${MACHINE}/gcc/debug/shared)

    #Inclusion de LIBXML2
    #INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/libxml2/2.7.2/winnt/include)
    #LINK_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/libxml2/2.7.2/winnt/lib)  

    #INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/database/sybase/openclient/${SYBASE_SERVER_VERSION}/ESD_${SYBASE_ESD_VERSION}/${MACHINE}/include)

  ENDIF(CMAKE_HOST_SYSTEM_NAME MATCHES "SunOS")       
    
ELSE(UNIX)
  MESSAGE(STATUS "UNIX not found")
ENDIF(UNIX)

  #Inclusion de ENVIRONNEMENT
  LINK_DIRECTORIES(${LIBRARY_OUTPUT_PATH})

  #Inclusion de TIBCO
  INCLUDE_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/tibco/tibrv/${TIBCO_VERSION}/${MACHINE}/include)
  LINK_DIRECTORIES(${THIRDPARTY_ROOT_LOCAL}/tibco/tibrv/${TIBCO_VERSION}/${MACHINE}/lib)
    
IF(CYGWIN)

  SET(BASECORBA ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libACE.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_AnyTypeCode.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_BiDirGIOP.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_DynamicAny.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_DynamicInterface.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_IDL_BE.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_IDL_FE.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_IFR_Client.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_IORManip.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_IORTable.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_Messaging.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_PortableServer.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_RTCORBA.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_RTPortableServer.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_SmartProxies.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_Strategies.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_TypeCodeFactory.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_Utils.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosNaming.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosNaming_Serv.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosNaming_Skel.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_Codeset.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libACE_ETCL.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libACE_ETCL_Parser.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libACE_Monitor_Control.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_AV.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CodecFactory.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_Compression.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosConcurrency.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosConcurrency_Serv.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosConcurrency_Skel.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosEvent.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosEvent_Serv.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosEvent_Skel.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosLifeCycle.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosLifeCycle_Skel.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosLoadBalancing.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosNotification.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosNotification_MC.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosNotification_MC_Ext.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosNotification_Serv.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosNotification_Skel.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosProperty.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosProperty_Serv.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosProperty_Skel.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosTime.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosTime_Serv.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosTime_Skel.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosTrading.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosTrading_Serv.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CosTrading_Skel.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CSD_Framework.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_CSD_ThreadPool.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_DiffServPolicy.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_DsEventLogAdmin.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_DsEventLogAdmin_Serv.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_DsEventLogAdmin_Skel.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_DsLogAdmin.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_DsLogAdmin_Serv.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_DsLogAdmin_Skel.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_DsNotifyLogAdmin.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_DsNotifyLogAdmin_Serv.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_DsNotifyLogAdmin_Skel.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_EndpointPolicy.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_ETCL.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_FaultTolerance.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_FT_ClientORB.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_FT_ServerORB.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_FTORB_Utils.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_FTRT_ClientORB.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_FTRT_EventChannel.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_FtRtEvent.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_IFR_BE.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_IFRService.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_ImR_Activator_IDL.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_ImR_Client.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_ImR_Locator_IDL.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_IORInterceptor.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_Monitor.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_Notify_Service.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_ObjRefTemplate.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_PI.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_PI_Server.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_PortableGroup.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_ReplicationManagerLib.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_RT_Notification.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_RTCORBA.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_RTCORBAEvent.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_RTEvent.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_RTEvent_Serv.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_RTEvent_Skel.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_RTEventLogAdmin.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_RTEventLogAdmin_Serv.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_RTEventLogAdmin_Skel.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_RTSched.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_RTSchedEvent.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_RTScheduler.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_Security.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_Svc_Utils.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_TC.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_TC_IIOP.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_TypeCodeFactory.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_Utils.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_Valuetype.dll
                ${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libTAO_ZIOP.dll)
  
                #${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libUTF16_UCS2.dll  
                #${THIRDPARTY_ROOT_LOCAL}/tao/ACE_wrappers/lib/libDynServer.dll
                  
ELSE(CYGWIN)
  MESSAGE(STATUS "CYGWIN not found")

  SET(BASECORBA ACE ACE_RMCast TAO TAO_BiDirGIOP TAO_DynamicAny TAO_DynamicInterface TAO_IDL_BE TAO_IDL_FE TAO_IFR_Client TAO_IORManip TAO_IORTable TAO_Messaging TAO_PortableServer TAO_RTCORBA TAO_RTPortableServer TAO_SmartProxies TAO_Strategies TAO_TypeCodeFactory TAO_Utils TAO_CosNaming TAO_Codeset)
                  
ENDIF(CYGWIN)
 
#MESSAGE(STATUS "BASECORBA : ${BASECORBA}")  

IF(CYGWIN)

  SET(BASETIBCO ${THIRDPARTY_ROOT_LOCAL}/tibco/tibrv/${TIBCO_VERSION}/${MACHINE}/bin/libeay32.dll
                ${THIRDPARTY_ROOT_LOCAL}/tibco/tibrv/${TIBCO_VERSION}/${MACHINE}/bin/ssleay32.dll
                ${THIRDPARTY_ROOT_LOCAL}/tibco/tibrv/${TIBCO_VERSION}/${MACHINE}/bin/tibrv.dll
                ${THIRDPARTY_ROOT_LOCAL}/tibco/tibrv/${TIBCO_VERSION}/${MACHINE}/bin/tibrvcm.dll
                ${THIRDPARTY_ROOT_LOCAL}/tibco/tibrv/${TIBCO_VERSION}/${MACHINE}/bin/tibrvcmq.dll
                ${THIRDPARTY_ROOT_LOCAL}/tibco/tibrv/${TIBCO_VERSION}/${MACHINE}/bin/tibrvcom.dll
                ${THIRDPARTY_ROOT_LOCAL}/tibco/tibrv/${TIBCO_VERSION}/${MACHINE}/bin/tibrvft.dll
                ${THIRDPARTY_ROOT_LOCAL}/tibco/tibrv/${TIBCO_VERSION}/${MACHINE}/bin/tibrvj.dll
                ${THIRDPARTY_ROOT_LOCAL}/tibco/tibrv/${TIBCO_VERSION}/${MACHINE}/bin/tibrvjsd.dll
                ${THIRDPARTY_ROOT_LOCAL}/tibco/tibrv/${TIBCO_VERSION}/${MACHINE}/bin/tibrvsd.dll
                ${THIRDPARTY_ROOT_LOCAL}/tibco/tibrv/${TIBCO_VERSION}/${MACHINE}/bin/tibrvsdcom.dll)
                
ELSE(CYGWIN)
  MESSAGE(STATUS "CYGWIN not found")
  
  SET(BASETIBCO tibrv tibrvcm tibrvcmq tibrvft)
  
ENDIF(CYGWIN)   
      
IF(CYGWIN)

  SET(BASELIBXML2 ${THIRDPARTY_ROOT_LOCAL}/libxml2/2.7.2/winnt/lib/libxml2.dll
                  ${THIRDPARTY_ROOT_LOCAL}/libxml2/2.7.2/winnt/lib/libiconv2.dll)
                  
  SET(BASELIBXML2 ${LIBXML_LIBRARY_DIRS})
  
ELSE(CYGWIN)
  MESSAGE(STATUS "CYGWIN not found")

  SET(BASELIBXML2 xml2)

ENDIF(CYGWIN)  

IF(CYGWIN)
        
  SET(BASESYBASE ${THIRDPARTY_ROOT_LOCAL}/database/sybase/openclient/${SYBASE_SERVER_VERSION}/ESD_${SYBASE_ESD_VERSION}/${MACHINE}/dll/debug/libct.dll
                 ${THIRDPARTY_ROOT_LOCAL}/database/sybase/openclient/${SYBASE_SERVER_VERSION}/ESD_${SYBASE_ESD_VERSION}/${MACHINE}/dll/debug/libcobct.dll
                 ${THIRDPARTY_ROOT_LOCAL}/database/sybase/openclient/${SYBASE_SERVER_VERSION}/ESD_${SYBASE_ESD_VERSION}/${MACHINE}/dll/debug/libcs.dll
                 ${THIRDPARTY_ROOT_LOCAL}/database/sybase/openclient/${SYBASE_SERVER_VERSION}/ESD_${SYBASE_ESD_VERSION}/${MACHINE}/dll/debug/libsybdb.dll
                 ${THIRDPARTY_ROOT_LOCAL}/database/sybase/openclient/${SYBASE_SERVER_VERSION}/ESD_${SYBASE_ESD_VERSION}/${MACHINE}/dll/debug/libxadtm.dll
                 ${THIRDPARTY_ROOT_LOCAL}/database/sybase/openclient/${SYBASE_SERVER_VERSION}/ESD_${SYBASE_ESD_VERSION}/${MACHINE}/dll/debug/libblk.dll)

ELSE(CYGWIN)
  MESSAGE(STATUS "CYGWIN not found")
  
  SET(BASESYBASE ct
                 cobct
                 cs
                 sybdb
                 xadtm
                 blk)  
  
ENDIF(CYGWIN)

IF(CYGWIN)

  SET(BASEORACLE /cygdrive/c/oraclexe/app/oracle/product/10.2.0/server/BIN/oci.dll
                 /cygdrive/c/oraclexe/app/oracle/product/10.2.0/server/BIN/ociw32.dll)
                 
ELSE(CYGWIN)
  MESSAGE(STATUS "CYGWIN not found")
  
  SET(BASEORACLE oci
                 ociw32)  
  
ENDIF(CYGWIN)

  SET(BASEXERCES xerces-c)

OPTION(WITH_GUI "Compil graphic unser interface" ON)

IF(WITH_GUI)
  MESSAGE(STATUS "Graphic user interface compilation activated")
  FIND_PACKAGE(X11)

  IF(X11_FOUND)
    MESSAGE(STATUS "X11 available")
    INCLUDE_DIRECTORIES(${X11_INCLUDE_DIR})
  ELSE(X11_FOUND)
    MESSAGE(STATUS "X11 not found")
  ENDIF(X11_FOUND)

  #FIND_PACKAGE(Qt3)

  #IF(Qt3_FOUND)
  #  MESSAGE(STATUS "Qt3 available")
  #  INCLUDE(${QT_USE_FILE})
  #  INCLUDE_DIRECTORIES(${QT_INCLUDES})
  #ELSE(Qt3_FOUND)
  #  MESSAGE(STATUS "Qt3 not found")
  #ENDIF(Qt3_FOUND)

ENDIF(WITH_GUI)

FIND_PACKAGE(ZLIB REQUIRED)

IF(ZLIB_FOUND)
  MESSAGE(STATUS "ZLIB available")
  INCLUDE_DIRECTORIES(${ZLIB_INCLUDE_DIR})
  LINK_DIRECTORIES(${ZLIB_LIBRARY_DIRS})
ELSE(ZLIB_FOUND)
  MESSAGE(STATUS "ZLIB not found")
ENDIF(ZLIB_FOUND)

#FIND_PACKAGE(
#	Boost 
#	1.31.0
#	REQUIRED signals
#)

FIND_PACKAGE(
	Boost
)

#ADD_DEFINITIONS("-pthread")

IF(Boost_FOUND)
  MESSAGE(STATUS "Boost available")
  SET(Boost_USE_STATIC_LIBS OFF)
  SET(Boost_USE_MULTITHREAD ON)
  #SET(Boost_LIBRARIES boost_thread)

  MESSAGE(STATUS "${Boost_LIBRARIES}")

  INCLUDE_DIRECTORIES(${Boost_INCLUDE_DIRS})
  LINK_DIRECTORIES(${Boost_LIBRARY_DIRS})
ELSE(Boost_FOUND)
  MESSAGE(STATUS "Boost not found")

ENDIF(Boost_FOUND)

FIND_PACKAGE(LibXml2 REQUIRED)

IF(LIBXML2_FOUND)
  MESSAGE(STATUS "LIBXML2 available")
  INCLUDE_DIRECTORIES(${LIBXML2_INCLUDE_DIR})
  LINK_DIRECTORIES(${LIBXML2_LIBRARY_DIRS})
ELSE(LIBXML2_FOUND)
  MESSAGE(STATUS "LIBXML2 not found")
ENDIF(LIBXML2_FOUND)

OPTION( ENABLE_CORBA "Enable CORBA" ON)

INCLUDE(${PROJECT_SOURCE_DIR}/config/FindTAO.cmake)

IF(FOUND_TAO)
  MESSAGE(STATUS "TAO available")
  MESSAGE(STATUS " dans ${TAO_DIR} et ${ACE_DIR}")

  ADD_DEFINITIONS(${CORBA_CFLAGS} -DuseTao -D_TEMPLATES_ENABLE_ -D_REENTRANT)
ELSE(FOUND_TAO)
  MESSAGE(STATUS "TAO not found")
ENDIF(FOUND_TAO)
  
IF (MINGW)
  MESSAGE(STATUS "JNI not searched")
ELSE(MINGW)
  #INCLUDE(FindJNI)
  #MESSAGE(STATUS " JAVA dans ${JAVA_JVM_LIBRARY_DIR} et ${JNI_INCLUDE_DIRS}")
  
  #INCLUDE_DIRECTORIES(${JNI_INCLUDE_DIRS})
  #INCLUDE_DIRECTORIES(${JAVA_INCLUDE_PATH})
  
  #LINK_DIRECTORIES(${JNI_LIBRARIES})
ENDIF(MINGW)

#SET(EXCLUDE Unittest)
#SET(EXCLUDE_PATTERNS */*Unittest*/* )

INCLUDE(${PROJECT_SOURCE_DIR}/config/ProjectDoc.cmake)

ENABLE_TESTING()
INCLUDE(${PROJECT_SOURCE_DIR}/config/CTestConfig.cmake)
INCLUDE(Dart)
IF(CMAKE_COMPILER_IS_GNUCXX AND NOT BUILD_SHARED_LIBS)
  SET(CMAKE_CXX_FLAGS "-fprofile-arcs -ftest-coverage")
ENDIF(CMAKE_COMPILER_IS_GNUCXX AND NOT BUILD_SHARED_LIBS)

INCLUDE(InstallRequiredSystemLibraries)

SET(CPACK_PACKAGE_VERSION ${PROJECT_VERSION})
SET(CPACK_PACKAGE_VERSION_MAJOR ${PROJECT_VERSION_MAJOR})
SET(CPACK_PACKAGE_VERSION_MINOR ${PROJECT_VERSION_MINOR})
SET(CPACK_PACKAGE_VERSION_PATCH ${PROJECT_VERSION_PATCH})

IF(WIN32 AND NOT UNIX)
  SET(CPACK_NSIS_MODIFY_PATH ON)
ELSE(WIN32 AND NOT UNIX)
  SET(CPACK_STRIP_FILES "")
  SET(CPACK_SOURCE_STRIP_FILES "")
ENDIF(WIN32 AND NOT UNIX)
#SET(CPACK_PACKAGE_EXECUTABLES "Tools" "Tools")

INCLUDE(CPack)

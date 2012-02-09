# add everything necessary for a project to use DoxygenDoc target

OPTION(BUILD_REFERENCE_DOCS "Build Project reference documentation using doxygen (use: make DoxygenDoc)" ON)

IF(BUILD_REFERENCE_DOCS)
    SET(BUILD_DOCUMENTATION YES)
    OPTION(DOCUMENTATION_SEARCHENGINE "Enable doxygen's search engine (requires that documentation to be installed on a php enabled web server)" ON)
    OPTION(DOCUMENTATION_TAGFILE "Generate a tag file named project.tag on the documentation web server" ON)
ENDIF(BUILD_REFERENCE_DOCS)

#Generation of the documentation using doxygen
#FIND_PATH(DOXYGEN_DIR doxygen
#/usr/local/bin
#/usr/bin
#)
FIND_PACKAGE(Doxygen)

IF (DOXYGEN_FOUND)

  # click+jump in Emacs and Visual Studio (for doxy.config) (jw)
  IF    (CMAKE_BUILD_TOOL MATCHES "(msdev|devenv)")
    SET(DOXY_WARN_FORMAT "\"$file($line) : $text \"")
  ELSE  (CMAKE_BUILD_TOOL MATCHES "(msdev|devenv)")
    SET(DOXY_WARN_FORMAT "\"$file:$line: $text \"")
  ENDIF (CMAKE_BUILD_TOOL MATCHES "(msdev|devenv)")
  
  # we need latex for doxygen because of the formulas
  FIND_PACKAGE(LATEX)
  IF    (NOT LATEX_COMPILER)
    MESSAGE(STATUS "latex command LATEX_COMPILER not found but usually required. You will probably get warnings and user inetraction on doxy run.")
  ENDIF (NOT LATEX_COMPILER)
  IF    (NOT MAKEINDEX_COMPILER)
    MESSAGE(STATUS "makeindex command MAKEINDEX_COMPILER not found but usually required.")
  ENDIF (NOT MAKEINDEX_COMPILER)
  IF    (NOT DVIPS_CONVERTER)
    MESSAGE(STATUS "dvips command DVIPS_CONVERTER not found but usually required.")
  ENDIF (NOT DVIPS_CONVERTER)
  
  # For Doxygen
  INCLUDE(${CMAKE_ROOT}/Modules/Documentation.cmake OPTIONAL)
  OPTION(BUILD_DOCUMENTATION "Build osg documentation" ON)
  # To build the documention, you will have to enable it
  # and then do the equivalent of "make DoxygenDoc".
  IF(BUILD_DOCUMENTATION)
    SET(BUILD_DOCUMENTATION YES)
    IF(DOCUMENTATION_SEARCHENGINE)
        SET(SEARCHENGINE "YES")
    ELSE(DOCUMENTATION_SEARCHENGINE)
        SET(SEARCHENGINE "NO")
    ENDIF(DOCUMENTATION_SEARCHENGINE)
    IF(DOCUMENTATION_TAGFILE)
        SET(GENERATE_TAGFILE "doc/Project.tag")
    ELSE(DOCUMENTATION_TAGFILE)
        SET(GENERATE_TAGFILE "")
    ENDIF(DOCUMENTATION_TAGFILE)
    IF(DOT)
        SET(HAVE_DOT YES)
    ELSE(DOT)
        MESSAGE(STATUS "d0t command not found but usually required.")    
        SET(HAVE_DOT NO)
    ENDIF(DOT)
  ENDIF(BUILD_DOCUMENTATION)

  #CMAKE_CURRENT_SOURCE_DIR --> PROJECT_SOURCE_DIR 
  IF   (EXISTS "${PROJECT_SOURCE_DIR}/config/doxy.config.in")
    MESSAGE(STATUS "configured ${PROJECT_SOURCE_DIR}/config/doxy.config.in --> ${CMAKE_CURRENT_BINARY_DIR}/doxy.config")
    CONFIGURE_FILE(${PROJECT_SOURCE_DIR}/config/doxy.config.in 
      ${CMAKE_CURRENT_BINARY_DIR}/doxy.config
      @ONLY )
    ## use (configured) doxy.config from (out of place) BUILD tree:
    SET(DOXY_CONFIG "${CMAKE_CURRENT_BINARY_DIR}/doxy.config")
  ELSE (EXISTS "${PROJECT_SOURCE_DIR}/config/doxy.config.in")
    # use static hand-edited doxy.config from SOURCE tree:
    SET(DOXY_CONFIG "${PROJECT_SOURCE_DIR}/config/doxy.config")
    IF   (EXISTS "${PROJECT_SOURCE_DIR}/config/doxy.config")
      MESSAGE(STATUS "WARNING: using existing ${PROJECT_SOURCE_DIR}/config/doxy.config instead of configuring from doxy.config.in file.")
    ELSE (EXISTS "${PROJECT_SOURCE_DIR}/config/doxy.config")
      IF   (EXISTS "${CMAKE_MODULE_PATH}/doxy.config.in")
        # using template doxy.config.in
        MESSAGE(STATUS "configured ${CMAKE_CMAKE_MODULE_PATH}/doxy.config.in --> ${CMAKE_CURRENT_BINARY_DIR}/doxy.config")
        CONFIGURE_FILE(${CMAKE_MODULE_PATH}/doxy.config.in 
          ${CMAKE_CURRENT_BINARY_DIR}/doxy.config
          @ONLY )
        SET(DOXY_CONFIG "${CMAKE_CURRENT_BINARY_DIR}/doxy.config")
      ELSE (EXISTS "${CMAKE_MODULE_PATH}/doxy.config.in")
        # failed completely...
        MESSAGE(SEND_ERROR "Please create ${PROJECT_SOURCE_DIR}/config/doxy.config.in (or doxy.config as fallback)")
      ENDIF(EXISTS "${CMAKE_MODULE_PATH}/doxy.config.in")

    ENDIF(EXISTS "${PROJECT_SOURCE_DIR}/config/doxy.config")
  ENDIF(EXISTS "${PROJECT_SOURCE_DIR}/config/doxy.config.in")
  
  ADD_CUSTOM_TARGET(DoxygenDoc ${DOXYGEN_EXECUTABLE} ${DOXY_CONFIG})
  
  # create a windows help .chm file using hhc.exe
  # HTMLHelp DLL must be in path!
  # fallback: use hhw.exe interactively
  IF    (WIN32)
    FIND_PACKAGE(HTMLHelp)
    IF   (HTML_HELP_COMPILER)      
      SET (TMP "${CMAKE_CURRENT_BINARY_DIR}\\doc\\html\\index.hhp")
      STRING(REGEX REPLACE "[/]" "\\\\" HHP_FILE ${TMP} )
      # MESSAGE(SEND_ERROR "DBG  HHP_FILE=${HHP_FILE}")
      ADD_CUSTOM_TARGET(winhelp ${HTML_HELP_COMPILER} ${HHP_FILE})
      ADD_DEPENDENCIES (winhelp doc)
     
      IF (NOT TARGET_DOC_SKIP_INSTALL)
      # install windows help?
      # determine useful name for output file 
      # should be project and version unique to allow installing 
      # multiple projects into one global directory      
      IF   (EXISTS "${PROJECT_BINARY_DIR}/doc/html/index.chm")
        IF   (PROJECT_NAME)
          SET(OUT "${PROJECT_NAME}")
        ELSE (PROJECT_NAME)
          SET(OUT "Documentation") # default
        ENDIF(PROJECT_NAME)
        IF   (${PROJECT_NAME}_VERSION_MAJOR)
          SET(OUT "${OUT}-${${PROJECT_NAME}_VERSION_MAJOR}")
          IF   (${PROJECT_NAME}_VERSION_MINOR)
            SET(OUT  "${OUT}.${${PROJECT_NAME}_VERSION_MINOR}")
            IF   (${PROJECT_NAME}_VERSION_PATCH)
              SET(OUT "${OUT}.${${PROJECT_NAME}_VERSION_PATCH}")      
            ENDIF(${PROJECT_NAME}_VERSION_PATCH)
          ENDIF(${PROJECT_NAME}_VERSION_MINOR)
        ENDIF(${PROJECT_NAME}_VERSION_MAJOR)
        # keep suffix
        SET(OUT  "${OUT}.chm")
        
        #MESSAGE("DBG ${PROJECT_BINARY_DIR}/doc/html/index.chm \n${OUT}")
        # create target used by install and package commands 
        INSTALL(FILES "${PROJECT_SOURCE_DIR}/fullsite/site-deploy/doc/html/index.chm"
          DESTINATION "doc"
          RENAME "${OUT}"
        )
      ENDIF(EXISTS "${PROJECT_BINARY_DIR}/doc/html/index.chm")
      ENDIF(NOT TARGET_DOC_SKIP_INSTALL)

    ENDIF(HTML_HELP_COMPILER)
    # MESSAGE(SEND_ERROR "HTML_HELP_COMPILER=${HTML_HELP_COMPILER}")
  ENDIF (WIN32) 
ELSE (DOXYGEN_FOUND)
  MESSAGE(STATUS "DOXYGEN not found")
ENDIF(DOXYGEN_FOUND)

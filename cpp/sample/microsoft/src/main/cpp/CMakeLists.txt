########## Project setup ##########
#PROJECT(LIB-MainLibrary CXX)

# ######### General setup ##########
COPY_HEADER_LIST(${PROJECT_INCLUDE_DIR} h)

INCLUDE_DIRECTORIES("${PROJECT_SOURCE_DIR}/src/main/cpp/include")

# ########## MainLibrary executable ##########
# Sources:
SET(main_files_SRCS
    circular_queue.cpp
    Triangle.cpp
)

# Headers:
#SET(main_files_HDRS
#    circular_queue.h
#)
FILE(GLOB main_files_HDRS RELATIVE ${CMAKE_CURRENT_SOURCE_DIR} "*.h")
MESSAGE("Found Header Files: ${main_files_HDRS}")

ADD_LIBRARY(main_library SHARED ${main_files_SRCS})

SET_TARGET_PROPERTIES(main_library PROPERTIES
  VERSION ${PROJECT_VERSION}
  SOVERSION ${PROJECT_VERSION_MAJOR})

# add install files:
INSTALL(FILES ${main_files_HDRS}
  DESTINATION include
  PERMISSIONS OWNER_READ GROUP_READ WORLD_READ OWNER_WRITE  )

INSTALL(TARGETS main_library
  EXPORT  microsoft-install
  RUNTIME DESTINATION bin
  LIBRARY DESTINATION lib
  ARCHIVE DESTINATION lib)

# make sure the library gets installed
#INSTALL_TARGETS(/lib main_library)

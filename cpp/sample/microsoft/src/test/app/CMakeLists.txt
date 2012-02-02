########## Project setup ##########
#PROJECT(TEST-APP-Run CXX)

COPY_HEADER_LIST(${PROJECT_INCLUDE_DIR} h)

INCLUDE_DIRECTORIES("${PROJECT_SOURCE_DIR}/src/main/cpp/include")
INCLUDE_DIRECTORIES("${PROJECT_SOURCE_DIR}/src/test/cpp/include")

ADD_EXECUTABLE(run_tests run_tests.cpp)

TARGET_LINK_LIBRARIES(run_tests main_library test_library ${CPPUNIT_LIBRARY})

INSTALL(TARGETS run_tests
  EXPORT  microsoft-install
  RUNTIME DESTINATION bin
  LIBRARY DESTINATION lib
  ARCHIVE DESTINATION lib)

#INSTALL_PROGRAMS(/bin FILES run_tests)

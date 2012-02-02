########## Project setup ##########
#PROJECT(APP-Run CXX)

COPY_HEADER_LIST(${PROJECT_INCLUDE_DIR} h)

INCLUDE_DIRECTORIES("${PROJECT_SOURCE_DIR}/src/main/cpp/include")

ADD_EXECUTABLE(run_app run_app.cpp)

TARGET_LINK_LIBRARIES(run_app main_library)

INSTALL(TARGETS run_app
  EXPORT  microsoft-install
  RUNTIME DESTINATION bin
  LIBRARY DESTINATION lib
  ARCHIVE DESTINATION lib)
  
#INSTALL_PROGRAMS(/bin FILES run_app)
  
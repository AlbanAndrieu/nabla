PROJECT(MICROSOFT CXX)

SET(EXPORT_FILE microsoft-build.cmake)

INSTALL(EXPORT microsoft-install
        DESTINATION lib/microsoft-${PROJECT_VERSION_FULL}
        FILE microsoft-install.cmake)

MESSAGE(" PROJECT_INSTALL_DIR ${PROJECT_INSTALL_DIR}")

# Just process the sub directories
ADD_SUBDIRECTORY(src)

# Add coverage options for CI
#if(COVERAGE)
#	set_target_properties(main_library run_app run_tests PROPERTIES
#						  COMPILE_FLAGS "-fprofile-arcs -ftest-coverage"
#						  LINK_FLAGS "-coverage")
#endif(COVERAGE)

# Just process the sub directories
ADD_SUBDIRECTORY(cpp)
ADD_SUBDIRECTORY(app)

# Include resources available
INSTALL(FILES resources/Microsoft.properties DESTINATION share)

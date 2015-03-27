## This file should be placed in the root directory of your project.
## Then modify the CMakeLists.txt file in the root directory of your
## project to incorporate the testing dashboard.
## # The following are required to uses Dart and the Cdash dashboard
##   ENABLE_TESTING()
##   INCLUDE(CTest)
SET(CTEST_PROJECT_NAME "MICROSOFT")
SET(CTEST_NIGHTLY_START_TIME "00:00:00 EST")
SET(CTEST_DROP_METHOD "http")
SET(CTEST_DROP_SITE "albandri")
#SET (CTEST_DROP_SITE "public.kitware.com")
#SET (CTEST_DROP_LOCATION "/cgi-bin/HTTPUploadDartFile.cgi")
SET (CTEST_TRIGGER_SITE "${CTEST_DROP_METHOD}://${CTEST_DROP_SITE}/cgi-bin/Submit-CMake-TestingResults.pl")
SET(CTEST_DROP_LOCATION "/CDash/submit.php?project=MICROSOFT")
SET(CTEST_DROP_SITE_CDASH TRUE)
SET(CTEST_BUILD_CONFIGURATION "Debug")

MESSAGE(STATUS "CTest is ${CTEST_TRIGGER_SITE}")

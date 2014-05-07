cls

call setenv.bat
call mvn javadoc:javadoc

rem call mvn javadoc:fix

rem javadoc:aggregate to generate the Javadoc files.
rem javadoc:test-aggregate to generate the test Javadoc files.
rem javadoc:aggregate-jar to create an archive file of the Javadoc files.
rem javadoc:test-aggregate-jar to create an archive file of the test Javadoc files.

pause

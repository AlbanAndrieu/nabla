cls

call setenv.bat
call mvn help:active-profiles -Psample,jboss5 -Dserver=jboss5x > profile.log

pause

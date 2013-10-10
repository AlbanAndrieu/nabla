cls

call setenv.bat
call mvn help:active-profiles -Psample,arq-jbossas-managed,derby > profile.log

pause

cls

call setenv.bat
call mvn clean site -Pmaven-2-site,sample > site.log
call mvn site:deploy

pause

cls

call setenv.bat

REM runs a simple HTTP server on localhost:1337 and autorefresh a page, when any file in project is changed
call grunt serve > serve.log 2>&1

pause
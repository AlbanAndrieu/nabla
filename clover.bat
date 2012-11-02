cls

call setenv.bat
call mvn clover2:setup test clover2:aggregate clover2:clover > clover.log
REM call mvn clover2:setup test clover2:aggregate clover2:clover -Psample > clover.log

pause

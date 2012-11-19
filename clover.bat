cls

REM https://confluence.atlassian.com/display/CLOVER/Clover+for+Maven+2+and+3+Best+Practices

call setenv.bat
REM call mvn clover2:setup test clover2:aggregate clover2:clover > clover.log
REM call mvn clover2:setup test clover2:aggregate clover2:clover -Psample > clover.log
call mvn verify -Pclover.optimize > clover.log
call mvn site -Pclover.report > clover.log

pause

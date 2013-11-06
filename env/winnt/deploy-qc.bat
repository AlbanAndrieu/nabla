:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::
:: Cool QC deployer.
::
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

@echo off

set QUIET=2^>NUL 1^>NUL

@echo [*] Deploying QC...
@echo [*] Killing any runining instance of Internet Explorer...
taskkill /f /im iexplore.exe %QUIET%

@echo [*] Running QC deployment process
start iexplore.exe http:\\qcserver:8080\qcbin\
start iexplore.exe http:\\qcserver:8080\qcbin\start_a.jsp?common=true

goto END

:ERROR
@echo [!] Deployment failed!
exit /b -1

:END
@echo [*] Deployment in progress... (should finish in couple of minutes).
exit /b 0

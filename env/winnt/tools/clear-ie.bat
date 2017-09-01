:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::
:: Script clears IE browsing history.
::
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

@echo off

@echo [*] Removing browsing history...
RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255
exit

:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::
:: Configure and run clean nabla.
::
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

@echo off
SETLOCAL

set CLEANREG=.\clear-desktop.reg
set QUIET=2^>NUL 1^>NUL

@echo [*] Running regedit...
REGEDIT /s %CLEANREG%

@echo [*] Running clean regedit...
CLEANMGR /sagerun:1337
exit

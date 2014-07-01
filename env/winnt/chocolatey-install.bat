@echo off

@powershell Get-ExecutionPolicy
@powershell -NoProfile -ExecutionPolicy unrestricted -Command "iex ((new-object net.webclient).DownloadString('https://chocolatey.org/install.ps1'))" 

echo Installed on C:\Chocolatey

REM cinst .\workstation-packages.config

REM cinst notepadplusplus

REM echo Installed Notepad ++ 

REM cinst zabbix-agent

REM echo Installed Zabbix Agent

REM cinst Cygwin

REM cinst cruisecontrol.net –override –installArguments ""/S /D=c:\ccnet""

pause

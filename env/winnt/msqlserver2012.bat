SQL 2012 you can install using this ISO:
\\gdnsnetapp01\qakplus\qa_store\windows\MSSQL_Server2012
REM \\gdnsnetapp01\qakplus\qa_store\windows\WindowsServer2012R2Standard

REM First do
http://www.windows8facile.fr/installer-net-framework-35-windows-server-2012/ 
in order to avoid Error while enabling Windows feature : NetFx3, Error Code : -2146498298 , cm and then run setup again. For more information on how to enable Windows features , see http://go.microsoft.com/fwlink/?linkid=227143
REM NOK below
REM Add-WindowsFeature NET-Framework-Core -Source F:\sources\sxs
REM Install-WindowsFeature NET-Framework-Core –Source F:\Sources\SxS 
REM DISM /Online /Enable-Feature /FeatureName:NetFx3 /All 
REM DISM /Online /Enable-Feature /FeatureName:NetFx3 /All /LimitAccess /Source:F:\Sources\SxS

MSSQLSERVER
C:\Program Files\Microsoft SQL Server\

TITLE: Microsoft SQL Server 2012 Service Pack 1 Setup
------------------------------

The following error has occurred:



For help, click: http://go.microsoft.com/fwlink?LinkID=20476&ProdName=Microsoft%20SQL%20Server&EvtSrc=setup.rll&EvtID=50000&ProdVer=11.0.3000.0&EvtType=0x681D636F%25401428%25401

------------------------------
BUTTONS:

OK
------------------------------

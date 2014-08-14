get-alias
set-alias list get-childitem
export-alias C:\Users\User\myalias.csv list
export-alias C:\Users\User\myalias.csv *
import-alias C:\Users\User\myalias.csv

Get-Command

Get-Command -verb "get"
Get-Command -noun "service"

Get-Help Get-Command
Get-Help Get-Command -Examples
Get-Help Get-Command -Detailed
Get-Help Get-Command -Full

Get-Command -?

Set-Location C:\workpace\users\albandri10

Get-ChildItem 
Get-ChildItem | 
    Where-Object { $_.Length -gt 10kb } | 
        Sort-Object Length |
            Format-Table -Property Name, Length -AutoSize

Get-ChildItem  | Select-Object Name, Length

Clear-Host
Get-PSProvider

Clear-Host
Get-PSDrive

Clear-Host
Set-Location env:
Get-ChildItem 

Clear-Host
Get-ChildItem | Format-Table -Property Name, Value -AutoSize

Clear-Host
Set-Location alias:
Get-ChildItem 

Clear-Host
Get-PSSnapin

Clear-Host
Get-PSSnapin -Registered

Clear-Host
Get-PSSnapin SqlServerCmdletSnapin100
Get-PSSnapin SqlServerProviderSnapin100

Clear-Host
Get-PSSnapin -Name "Sql*"

Get-PSDrive

Clear-Host
Set-Location SQLSERVER:
Get-ChildItem 
Get-ChildItem | Select-Object PSChildName

Clear-Host
Set-Location SQL
Get-ChildItem 

Clear-Host
Set-Location FL-WS-CON-RC01
Get-ChildItem 

Clear-Host
Set-Location DEFAULT
Get-ChildItem 

Clear-Host
Set-Location Databases
Get-ChildItem | Select-Object PSChildName

Clear-Host
Set-Location MyDatabases
Get-ChildItem | Select-Object PSChildName

Clear-Host
Set-Location Tables
Get-ChildItem | Select-Object PSChildName

Clear-Host
Remove-PSSnapin SqlServerCmdletSnapin100
Remove-PSSnapin SqlServerProviderSnapin100

Clear-Host
Get-PSSnapin | Select-Object Name
Get-PSProvider

$a = "I am now a PowerShell export"
$a
$a.Length
$a.GetType()

@ECHO OFF
ECHO This file modifies the registry in Windows 7 or 8 to add Dropbox as a service within Office 2013
ECHO This script is provided as is and no warranty or support of any form is offered
pause Do you want to continue?

ECHO Please enter the complete path your dropbox folder in the following format, note there is no end slash: C:\Users\Username\Location
SET /P dropboxdir=[promptString]

REM Check Windows Version
ver | findstr /i "5\.0\." > nul
IF %ERRORLEVEL% EQU 0 goto ver_2000
ver | findstr /i "5\.1\." > nul
IF %ERRORLEVEL% EQU 0 goto ver_XP
ver | findstr /i "5\.2\." > nul
IF %ERRORLEVEL% EQU 0 goto ver_2003
ver | findstr /i "6\.0\." > nul
IF %ERRORLEVEL% EQU 0 goto ver_Vista
ver | findstr /i "6\.1\." > nul
IF %ERRORLEVEL% EQU 0 goto ver_Win7
ver | findstr /i "6\.2\." > nul
IF %ERRORLEVEL% EQU 0 goto ver_Win8
goto warn_and_exit

:ver_Win8
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad" /v "DisplayName" /t REG_SZ /d "Dropbox"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad" /v "Description" /t REG_SZ /d "Dropbox is a free service that lets you bring all your photos, docs, and videos anywhere."
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad" /v "Url48x48" /t REG_SZ /d "http://dl.dropbox.com/u/46565/metro/Dropbox_48x48.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad" /v "LearnMoreURL" /t REG_SZ /d "https://www.dropbox.com/"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad" /v "ManageURL" /t REG_SZ /d "https://www.dropbox.com/account"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad" /v "LocalFolderRoot" /t REG_SZ /d "%dropboxdir%"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad\Thumbnails"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad\Thumbnails" /v "Url48x48" /t REG_SZ /d "http://dl.dropbox.com/u/46565/metro/Dropbox_48x48.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad\Thumbnails" /v "Url40x40" /t REG_SZ /d "http://dl.dropbox.com/u/46565/metro/Dropbox_40x40.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad\Thumbnails" /v "Url32x32" /t REG_SZ /d "http://dl.dropbox.com/u/46565/metro/Dropbox_32x32.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad\Thumbnails" /v "Url24x24" /t REG_SZ /d "http://dl.dropbox.com/u/46565/metro/Dropbox_24x24.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad\Thumbnails" /v "Url20x20" /t REG_SZ /d "http://dl.dropbox.com/u/46565/metro/Dropbox_24x24.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad\Thumbnails" /v "Url16x16" /t REG_SZ /d "http://dl.dropbox.com/u/46565/metro/Dropbox_16x16.png"
goto end

:ver_Win7
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad" /v "DisplayName" /t REG_SZ /d "Dropbox"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad" /v "Description" /t REG_SZ /d "Dropbox is a free service that lets you bring all your photos, docs, and videos anywhere."
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad" /v "Url48x48" /t REG_SZ /d "http://dl.dropbox.com/u/46565/metro/Dropbox_48x48.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad" /v "LearnMoreURL" /t REG_SZ /d "https://www.dropbox.com/"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad" /v "ManageURL" /t REG_SZ /d "https://www.dropbox.com/account"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad" /v "LocalFolderRoot" /t REG_SZ /d "%dropboxdir%"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad\Thumbnails"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad\Thumbnails" /v "Url48x48" /t REG_SZ /d "http://dl.dropbox.com/u/46565/metro/Dropbox_48x48.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad\Thumbnails" /v "Url40x40" /t REG_SZ /d "http://dl.dropbox.com/u/46565/metro/Dropbox_40x40.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad\Thumbnails" /v "Url32x32" /t REG_SZ /d "http://dl.dropbox.com/u/46565/metro/Dropbox_32x32.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad\Thumbnails" /v "Url24x24" /t REG_SZ /d "http://dl.dropbox.com/u/46565/metro/Dropbox_24x24.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad\Thumbnails" /v "Url20x20" /t REG_SZ /d "http://dl.dropbox.com/u/46565/metro/Dropbox_24x24.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\2c0ed794-6d21-4c07-9fdb-f076662715ad\Thumbnails" /v "Url16x16" /t REG_SZ /d "http://dl.dropbox.com/u/46565/metro/Dropbox_16x16.png"

goto end

:ver_Vista
:Run Windows Vista specific commands here
REM echo This script does not support Windows Vista
goto end

:ver_2003
:Run Windows Server 2003 specific commands here
REM echo This script does not support Windows Server 2003
goto end

:ver_XP
:Run Windows XP specific commands here
REM echo This script does not support Windows XP
goto end

:ver_2000
:Run Windows 2000 specific commands here
REM echo This script does not support Windows 2000
goto end

:warn_and_exit
echo Machine OS cannot be determined.

:end  
ECHO The script is finished!
ECHO If you don't see any errors, you can close this window.
ECHO Any error messages can be posted on https://forums.dropbox.com/topic.php?id=93098
pause
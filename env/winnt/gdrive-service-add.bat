@ECHO OFF
ECHO This file modifies the registry in Windows 7 or 8 to add Google Drive as a service within Office 2013
ECHO This script is provided as is and no warranty or support of any form is offered.
ECHO Original Script created by Philip P. from Dropbox, Remastered by RedeyeGT
pause Do you want to continue?

ECHO Please enter the complete path your Google Drive folder in the following format, note there is no end slash: C:\Users\Username\Location
SET /P gdrivedir=[promptString]

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
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66" /v "DisplayName" /t REG_SZ /d "Google Drive"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66" /v "Description" /t REG_SZ /d "Google Drive is a free service that lets you bring all your photos, docs, and videos anywhere."
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66" /v "Url48x48" /t REG_SZ /d "http://k37.kn3.net/7DDDA8544.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66" /v "LearnMoreURL" /t REG_SZ /d "https://drive.google.com/"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66" /v "ManageURL" /t REG_SZ /d "https://drive.google.com"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66" /v "LocalFolderRoot" /t REG_SZ /d "%gdrivedir%"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66\Thumbnails"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66\Thumbnails" /v "Url48x48" /t REG_SZ /d "http://k37.kn3.net/7DDDA8544.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66\Thumbnails" /v "Url40x40" /t REG_SZ /d "http://k35.kn3.net/AA5EBCDA4.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66\Thumbnails" /v "Url32x32" /t REG_SZ /d "http://k31.kn3.net/022B096E1.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66\Thumbnails" /v "Url24x24" /t REG_SZ /d "http://k35.kn3.net/397FB33CC.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66\Thumbnails" /v "Url20x20" /t REG_SZ /d "http://k35.kn3.net/397FB33CC.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66\Thumbnails" /v "Url16x16" /t REG_SZ /d "http://k43.kn3.net/E5162FC3D.png"
goto end

:ver_Win7
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66" /v "DisplayName" /t REG_SZ /d "Google Drive"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66" /v "Description" /t REG_SZ /d "Google Drive is a free service that lets you bring all your photos, docs, and videos anywhere."
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66" /v "Url48x48" /t REG_SZ /d "http://k37.kn3.net/7DDDA8544.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66" /v "LearnMoreURL" /t REG_SZ /d "https://drive.google.com/"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66" /v "ManageURL" /t REG_SZ /d "https://drive.google.com"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66" /v "LocalFolderRoot" /t REG_SZ /d "%gdrivedir%"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66\Thumbnails"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66\Thumbnails" /v "Url48x48" /t REG_SZ /d "http://k37.kn3.net/7DDDA8544.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66\Thumbnails" /v "Url40x40" /t REG_SZ /d "http://k35.kn3.net/AA5EBCDA4.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66\Thumbnails" /v "Url32x32" /t REG_SZ /d "http://k31.kn3.net/022B096E1.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66\Thumbnails" /v "Url24x24" /t REG_SZ /d "http://k35.kn3.net/397FB33CC.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66\Thumbnails" /v "Url20x20" /t REG_SZ /d "http://k35.kn3.net/397FB33CC.png"
reg add "HKCU\Software\Microsoft\Office\Common\Cloud Storage\ecc30fd0-4546-11e2-bcfd-0800200c9a66\Thumbnails" /v "Url16x16" /t REG_SZ /d "http://k43.kn3.net/E5162FC3D.png"

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
ECHO Original Script created by Philip P. from Dropbox, Remastered by RedeyeGT
pause
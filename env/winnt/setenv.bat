rem retieve current directory under windows
rem set POC_HOME=%~dp0

# Deactivate proxy
rem proxycfg -d

# Flush DNS cache
rem ipconfig /flushdns

set VERSION=10

set UNIX_USERNAME=albandri
set HOME=C:\workspace\users\%UNIX_USERNAME%%VERSION%
set WORKSPACE=%HOME%
set HOMEPATH=%HOME%

#set PROJECT_HOME=%HOME%
set PROJECT_DEV=%HOME%
set PROJECT_SRC=%HOME%\nabla
set PROJECT_OBJ=C:\target
rem set PROJECT_THIRDPARTY_PATH=T:\thirdparty
set PROJECT_THIRDPARTY_PATH=C:\thirdparty
set PROJECT_USER_PROFILE=%PROJECT_DEV%\config\config\profiles\%UNIX_USERNAME%.dev.properties

set JAVA_HOME=C:\Sun\SDK\jdk
set JAVA=%JAVA_HOME%\bin
set JAVA_OPTS=-Xms256m -Xmx1024m
set ANT_HOME=C:\apache-ant-1.8.0
set ANT=%ANT_HOME%\bin
set M2_HOME=C:\apache-maven-3.0.4
set M2=%M2_HOME%\bin
set M2_REPO=${env.WORKSPACE}/.repository

#set MAVEN_OPTS=-Xms512m -Xmx1024m -XX:MaxPermSize=256m
rm Add MaxPermSize for andromda
set MAVEN_OPTS=-Xms256m -Xmx512m -XX:PermSize=40M -XX:MaxPermSize=128M

set MD_HOME=C:\MagicDraw UML 16.5
set ANDROMDA_HOME=C:\repo\org\andromda

set JBOSS_HOME=C:\jboss-as-7.1.1.Final
set JBOSS=%JBOSS_HOME%\bin

set BEES_HOME=C:\cloudbees-sdk-1.1
set BEES=%BEES_HOME%

set CMAKE_HOME=C:\CMake-2.6.4
set CMAKE=%CMAKE_HOME%\bin
set GRAPHVIZ_HOME=C:\Graphviz2.26.3
set GRAPHVIZ=%GRAPHVIZ_HOME%\bin
set LUMBERMILL_HOME=C:\lumbermill-2.0-b3
set LUMBERMILL=%LUMBERMILL_HOME%\bin
set CYGWIN_HOME=C:\cygwin
set MINGW_HOME=C:\MinGW
rem set MSYS_HOME=C:\msys\1.0
set MSVCDir=C:\MinGW

set NODEJS_HOME=C:\nodejs
set NPM_HOME=C:\nodejs\node_modules\npm

set HUDSON_HOME=C:\hudson
set JENKINS_HOME=C:\hudson
set SVN_HOME=C:\Program Files\VisualSVN Server

set ORACLE_HOME=C:\oraclexe\app\oracle\product\10.2.0\server

set ACE_ROOT=%PROJECT_THIRDPARTY_PATH%\tao\ACE_wrappers
set TAO_ROOT=%PROJECT_THIRDPARTY_PATH%\tao\ACE_wrappers\TAO
set QTDIR=C:\cygwin\lib\qt3

set MACHINE=x86Linux
set TIBCO_HOME==${DRIVE_PATH}/TODO
set CHROME_BIN=${DRIVE_PATH}/usr/bin/google-chrome

rem set DISPLAY=localhost:0.0

rem set PATH=%JAVA%;%ANT%;%M2%;%M2_REPO%;
set PATH=%TIBCO_HOME%\bin;%CYGWIN_HOME%\bin;%MINGW_HOME%\bin;%TIBCO_HOME%\bin;%GRAPHVIZ_HOME%\bin;%LUMBERMILL_HOME%\bin;%M2_HOME%\bin;%ANT_HOME%\bin;%NODEJS_HOME%
REM For selenium
set PATH=%PATH%;C:\Program Files (x86)\Internet Explorer;C:\Program Files (x86)\Mozilla Firefox

REM PATH %SystemRoot%\system32;%SystemRoot%;%SystemRoot%\System32\Wbem;%SYSTEMROOT%\System32\WindowsPowerShell\v1.0\;C:\Program Files\Dell\Dell Wireless WLAN Card;c:\Program Files (x86)\ATI Technologies\ATI.ACE\Core-Static;c:\Program Files (x86)\Common Files\Roxio Shared\DLLShared\;C:\Program Files\TortoiseSVN\bin;%ORACLE_HOME%\bin;%JAVA_HOME%\bin;%TIBCO_HOME%\bin;%CYGWIN_HOME%\bin;%MINGW_HOME%\bin;%CMAKE_HOME%\bin;%GRAPHVIZ_HOME%\bin;%LUMBERMILL_HOME%\bin;%M2_HOME%\bin;%ANT_HOME%\bin;c:\Program Files (x86)\Microsoft SQL Server\100\Tools\Binn\;c:\Program Files\Microsoft SQL Server\100\Tools\Binn\;c:\Program Files\Microsoft SQL Server\100\DTS\Binn\;C:\Program Files (x86)\QuickTime\QTSystem\

REM test CLASSPATH executing javadoc.bat
REM bad classpath with ;C:\Sun\SDK6\lib\ext\QTJava.zip
REM set CLASSPATH=.;%JAVA_HOME%\bin;%M2_HOME%\bin;%ANT_HOME%\bin;%SVN_HOME%\bin;%TIBCO_HOME%\bin;%CYGWIN_HOME%\bin;%CYGWIN_HOME%\usr\include;%CYGWIN_HOME%\lib;%CYGWIN_HOME%\usr\lib;%MINGW_HOME%\bin;%CMAKE_HOME%\bin;%GRAPHVIZ_HOME%\bin;%LUMBERMILL_HOME%\bin
set CLASSPATH=.;%JAVA_HOME%\bin;%M2_HOME%\bin;%ANT_HOME%\bin;%SVN_HOME%\bin;%TIBCO_HOME%\bin;%CYGWIN_HOME%\bin;%CYGWIN_HOME%\usr\include;%CYGWIN_HOME%\lib;%CYGWIN_HOME%\usr\lib;%MINGW_HOME%\bin;%CMAKE_HOME%\bin;%GRAPHVIZ_HOME%\bin;%LUMBERMILL_HOME%\bin;%NODEJS_HOME%
echo %CLASSPATH%

set PATHEXT=.COM;.EXE;.BAT;.CMD;.VBS;.VBE;.JS;.JSE;.WSF;.WSH;.py;.pyw

REM @echo off
rem récupère le répertoire courant sous windows
rem set POC_HOME=%~dp0

set VERSION=10

set HOME=C:\workspace\users\albandri%VERSION%
set THIRDPARTY_ROOT=C:\thirdparty

set JAVA_HOME=C:\SUN\SDK\jdk1.6.0_33
set JAVA=%JAVA_HOME%\bin
set ANT_HOME=C:\apache-ant-1.7.1
set ANT=%ANT_HOME%\bin
set M2_HOME=C:\apache-maven-3.0.4
set M2=%M2_HOME%\bin
set M2_REPO=C:\repo

set MAVEN_OPTS=-Xms512m -Xmx1024m -XX:PermSize=512m -XX:MaxPermSize=1024m

set GRAPHVIZ_HOME=C:\Graphviz2.22
set CYGWIN_HOME=C:\cygwin

set PATH=%M2_HOME%/bin;%JAVA_HOME%/bin;%GRAPHVIZ_HOME%\bin
set CLASSPATH=.;%JAVA_HOME%\bin;%M2_HOME%\bin;%ANT_HOME%\bin;%GRAPHVIZ_HOME%\bin
echo %CLASSPATH%

java -jar C:\jenkins\jenkins.war --httpPort=8280 > jenkins.log

REM pause

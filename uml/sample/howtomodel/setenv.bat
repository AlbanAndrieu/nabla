set POC_HOME=%~dp0
REM set M2_HOME=%POC_HOME%../tools/maven-2.0.6
REM set M2_HOME=C:\apache-maven-3.0.2
set M2_HOME=C:\apache-maven-2.2.1
set ANT_HOME=C:\apache-ant-1.8.0
set MAVEN_OPTS=-Xmx512m
set JAVA_HOME=C:\Sun\SDK\jdk
set GRAPHVIZ_HOME=C:\Graphviz2.26.3

set path=%M2_HOME%/bin;%JAVA_HOME%/bin;%GRAPHVIZ_HOME%\bin
set CLASSPATH=.;%JAVA_HOME%\bin;%M2_HOME%\bin;%ANT_HOME%\bin;%GRAPHVIZ_HOME%\bin
echo %CLASSPATH%

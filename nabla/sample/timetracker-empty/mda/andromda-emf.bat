cls
rem call setenv.bat
rem set MAVEN_OPTS=-Xmx1024m
set MD_HOME=C:\MagicDraw UML 16.5
call mvn andromda:export2emf
pause
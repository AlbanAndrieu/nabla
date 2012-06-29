cls

call mvn validate
call mvn help:active-profiles > profile.log
call mvn dependency:tree > dependency.log
call mvn dependency:analyze > analyze.log
call mvn help:effective-pom > effective.log
call mvn initialize -Pshow-properties > properties.log
call mvn scm:validate
call mvn jalopy:format
call mvn source:jar mvn source:test-jar
call mvn eclipse:clean 
call mvn eclipse:eclipse -DdownloadSources=true -DdownloadJavadocs=true -Peclipse-folders
call mvn rat:check
call mvn doap:generate

pause
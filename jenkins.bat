cls

call setenv.bat
call mvn validate -Psample > validate.log
call mvn validate -Dnabla -Psample > validate-nabla.log
REM call mvn clean -Dnabla -Psample -amd andromda-database-cartridge > clean-nabla.log
call mvn versions:display-dependency-updates -Psample > dependency-updates.log
call mvn versions:display-plugin-updates -Psample > plugin-updates.log
call mvn help:active-profiles > profile.log
call mvn dependency:tree > dependency.log
call mvn dependency:analyze > analyze.log
call mvn help:effective-pom > effective.log
call mvn initialize -Pshow-properties > properties.log
call mvn scm:validate > scm-validate.log
REM call mvn jalopy:format > format.log
call mvn java-formatter:format > forma.log
call mvn source:jar > source.log
call mvn source:test-jar > source-test.log
call mvn javadoc:javadoc > javadoc.log
call mvn jxr:jxr > jxr.log
call mvn jxr:test-jxr > jxr-test.log
call mvn eclipse:clean > eclipse-clean.log
call mvn eclipse:eclipse -DdownloadSources=true -DdownloadJavadocs=true -Peclipse-folders > eclipse.log
call mvn rat:check > rat.log
call mvn doap:generate > doap.log

REM call mvn install -pl maven/skin
REM call mvn install -amd maven/skin

pause

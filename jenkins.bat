cls

call setenv.bat
call mvn validate -Psample > validate.log 2>&1
call mvn validate -Dnabla -Psample > validate-nabla.log 2>&1
REM call mvn clean -Dnabla -Psample -amd andromda-database-cartridge > clean-nabla.log 2>&1
call mvn versions:display-dependency-updates -Psample > dependency-updates.log 2>&1
call mvn versions:display-plugin-updates -Psample > plugin-updates.log 2>&1
call mvn help:active-profiles > profile.log 2>&1
call mvn dependency:tree > dependency.log 2>&1
call mvn dependency:analyze > analyze.log 2>&1
call mvn help:effective-pom > effective.log 2>&1
call mvn initialize -Pshow-properties > properties.log 2>&1
call mvn scm:validate > scm-validate.log 2>&1
REM call mvn jalopy:format > format.log 2>&1
call mvn java-formatter:format > forma.log 2>&1
call mvn source:jar > source.log 2>&1
call mvn source:test-jar > source-test.log 2>&1
call mvn javadoc:javadoc > javadoc.log 2>&1
call mvn jxr:jxr > jxr.log 2>&1
call mvn jxr:test-jxr > jxr-test.log 2>&1
call mvn eclipse:clean -P!mda,sample > eclipse-clean.log 2>&1
call mvn eclipse:configure-workspace -P!mda,sample > eclipse-workspace.log 2>&1
call mvn eclipse:eclipse -P!mda,sample -DdownloadSources=true -DdownloadJavadocs=true -Peclipse-folders > eclipse.log 2>&1
call mvn rat:check > rat.log 2>&1
call mvn doap:generate > doap.log 2>&1

REM call mvn install -pl maven/skin
REM call mvn install -amd maven/skin

pause

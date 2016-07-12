cls

call setenv.bat
call mvn validate -Psample > validate.log 2>&1
call mvn validate -Dnabla -Psample > validate-nabla.log 2>&1
REM call mvn clean -Dnabla -Psample -amd andromda-database-cartridge > clean-nabla.log 2>&1
call mvn versions:display-dependency-updates -Psample > dependency-updates.log 2>&1
call mvn versions:display-plugin-updates -Psample > plugin-updates.log 2>&1
call mvn versions:update-parent "-DparentVersion=1.0.0-SNAPSHOT"
call mvn dependency:tree -Psample > dependency-tree.log 2>&1
call mvn dependency:resolve-plugins -Psample > dependency-tree.log 2>&1
call mvn dependency:build-classpath -Psample > dependency-classpath.log 2>&1
call mvn dependency:copy-dependencies -Psample > dependency-dependencies.log 2>&1
call mvn dependency:analyze -Psample > analyze.log 2>&1
call mvn help:effective-pom -Psample > effective.log 2>&1
call mvn help:active-profiles -Psample > profile.log 2>&1
call mvn initialize -Pshow-properties > properties.log 2>&1
REM call mvn properties:write-active-profile-properties > profile-properties.log 2>&1
call mvn scm:validate -Psample > scm-validate.log 2>&1
REM call mvn jalopy:format -Psample > format.log 2>&1
call mvn java-formatter:format -Psample > format.log 2>&1
call mvn source:jar -Psample > source.log 2>&1
call mvn source:test-jar -Psample > source-test.log 2>&1
call mvn javadoc:javadoc -Psample > javadoc.log 2>&1
call mvn jxr:jxr -Psample > jxr.log 2>&1
call mvn jxr:test-jxr -Psample > jxr-test.log 2>&1
call mvn eclipse:clean -P!mda,sample > eclipse-clean.log 2>&1
call mvn eclipse:configure-workspace -P!mda,sample > eclipse-workspace.log 2>&1
call mvn eclipse:eclipse -P!mda,sample -DdownloadSources=true -DdownloadJavadocs=true -Peclipse-folders -Dappend.to.project.name=trunk > eclipse.log 2>&1
call mvn rat:check -Psample > rat.log 2>&1
call mvn doap:generate -Psample > doap.log 2>&1
call mvn codenarc:codenarc -Psample > codenarc.log 2>&1
call mvn clean install org.pitest:pitest-maven:mutationCoverage -Psample > pit.log 2>&1
call mvn versioneye:create
call mvn versioneye:update
call mvn jdeps:jdeps
call mvn javancss:report -Psample > javancss.log

call mvn -B -U -e -Dsurefire.useFile=false install pmd:pmd pmd:cpd checkstyle:checkstyle findbugs:findbugs codenarc:codenarc cobertura:cobertura -Psample,jacoco,mutation,run-its,upstream -Djacoco.outputDir=${WORKSPACE}/target > jenkins.log 2>&1
REM karma start ${WORKSPACE}/code/riskinsight/webapp/src/main/webapp/karma.jenkins.conf.js
REM output code/riskinsight/webapp/src/main/webapp/TEST-Karma-resultsTest.xml
REM mvn -Dsonargraph.prepareForSonar=true -Dsonargraph.activationCode=2356-F3B2-E2C6-CC70 com.hello2morrow.sonargraph:maven-sonargraph-plugin:7.1.10:architect-report -Psample -Ddatabase=derby
#TODO Archive the artifacts **/pit-reports/**/*.html

REM call mvn install -pl maven/skin
REM call mvn install -amd maven/skin
REM call mvn -Dsonar.branch=`git rev-parse --abbrev-ref HEAD` sonar:sonar

pause

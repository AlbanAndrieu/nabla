cls

call setenv.bat

call mvn enforcer:display-info

call mvn -B validate -Psample > validate.log 2>&1
call mvn -B validate -Dnabla -Psample > validate-nabla.log 2>&1
REM call mvn -B clean -Dnabla -Psample -amd andromda-database-cartridge > clean-nabla.log 2>&1
call mvn -B versions:display-dependency-updates -Psample > dependency-updates.log 2>&1
call mvn -B versions:display-plugin-updates -Psample > plugin-updates.log 2>&1
call mvn -B versions:update-parent -DparentVersion=1.0.0-SNAPSHOT
call mvn -B versions:set -DnewVersion=1.0.0-SNAPSHOT
call mvn -B dependency:tree -Psample > dependency-tree.log 2>&1
call mvn -B dependency:resolve-plugins -Psample > dependency-tree.log 2>&1
call mvn -B dependency:build-classpath -Psample > dependency-classpath.log 2>&1
call mvn -B dependency:copy-dependencies -Psample > dependency-dependencies.log 2>&1
call mvn -B dependency:analyze -DignoreNonCompile -Psample > analyze.log 2>&1
call mvn -B dependency:analyze-dep-mgt -Psample > analyze-dep.log 2>&1
call mvn -B animal-sniffer:check -Psample > animal-sniffer-check.log 2>&1
call mvn -B help:effective-pom -Psample > effective.log 2>&1
call mvn -B help:active-profiles -Psample > profile.log 2>&1
call mvn -B initialize -Pshow-properties > properties.log 2>&1
REM call mvn -B properties:write-active-profile-properties > profile-properties.log 2>&1
call mvn -B scm:validate -Psample > scm-validate.log 2>&1
REM call mvn -B jalopy:format -Psample > format.log 2>&1
call mvn -B java-formatter:format -Psample > format.log 2>&1
call mvn -B source:jar -Psample > source.log 2>&1
call mvn -B source:test-jar -Psample > source-test.log 2>&1
call mvn -B javadoc:javadoc -Psample > javadoc.log 2>&1
call mvn -B jxr:jxr -Psample > jxr.log 2>&1
call mvn -B jxr:test-jxr -Psample > jxr-test.log 2>&1
REM call mvn -B eclipse:clean -P!mda,sample > eclipse-clean.log 2>&1
REM call mvn -B eclipse:configure-workspace -P!mda,sample > eclipse-workspace.log 2>&1
REM call mvn -B eclipse:eclipse -P!mda,sample -DdownloadSources=true -DdownloadJavadocs=true -Peclipse-folders -Dappend.to.project.name=trunk > eclipse.log 2>&1
call mvn -B rat:check -Psample > rat.log 2>&1
call mvn -B doap:generate -Psample > doap.log 2>&1
call mvn -B codenarc:codenarc -Psample > codenarc.log 2>&1
call mvn -B clean install org.pitest:pitest-maven:mutationCoverage -Psample > pit.log 2>&1
call mvn -B versioneye:create
call mvn -B versioneye:update
call mvn -B jdeps:jdeps
call mvn -B javancss:report -Psample > javancss.log
call mvn -B whitesource:update -Psample > whitesource.log
call mvn -B sortpom:verify -Psample > sortpom.log

call mvn -B -U -e -Dsurefire.useFile=false install pmd:pmd pmd:cpd checkstyle:checkstyle findbugs:findbugs codenarc:codenarc cobertura:cobertura -Psample,jacoco,mutation,run-its,upstream -Djacoco.outputDir=${WORKSPACE}/target > jenkins.log 2>&1
REM karma start ${WORKSPACE}/code/riskinsight/webapp/src/main/webapp/karma.jenkins.conf.js
REM output code/riskinsight/webapp/src/main/webapp/TEST-Karma-resultsTest.xml
REM mvn -Dsonargraph.prepareForSonar=true -Dsonargraph.activationCode=2356-F3B2-E2C6-CC70 com.hello2morrow.sonargraph:maven-sonargraph-plugin:7.1.10:architect-report -Psample -Ddatabase=derby
REM #TODO Archive the artifacts **/pit-reports/**/*.html

REM call mvn install -pl maven/skin
REM call mvn install -amd maven/skin
REM call mvn -Dsonar.branch=`git rev-parse --abbrev-ref HEAD` sonar:sonar

REM display all modules path for sonar-project.properties
call mvn -q --also-make exec:exec -Dexec.executable="pwd"

pause

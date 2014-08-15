cls

call setenv.bat
call mvn validate -Psample,arq-jbossas-managed > validate.log 2>&1
call mvn validate -Dnabla -Psample,arq-jbossas-managed > validate-nabla.log 2>&1
REM call mvn clean -Dnabla -Psample,arq-jbossas-managed -amd andromda-database-cartridge > clean-nabla.log 2>&1
call mvn versions:display-dependency-updates -Psample,arq-jbossas-managed > dependency-updates.log 2>&1
call mvn versions:display-plugin-updates -Psample,arq-jbossas-managed > plugin-updates.log 2>&1
call mvn dependency:tree -Psample,arq-jbossas-managed > dependency-tree.log 2>&1
call mvn dependency:build-classpath -Psample,arq-jbossas-managed > dependency-classpath.log 2>&1
call mvn dependency:copy-dependencies -Psample,arq-jbossas-managed > dependency-dependencies.log 2>&1
call mvn dependency:analyze -Psample,arq-jbossas-managed > analyze.log 2>&1
call mvn help:effective-pom -Psample,arq-jbossas-managed > effective.log 2>&1
call mvn help:active-profiles -Psample,arq-jbossas-managed > profile.log 2>&1
call mvn initialize -Pshow-properties > properties.log 2>&1
REM call mvn properties:write-active-profile-properties > profile-properties.log 2>&1
call mvn scm:validate -Psample,arq-jbossas-managed > scm-validate.log 2>&1
REM call mvn jalopy:format -Psample,arq-jbossas-managed > format.log 2>&1
call mvn java-formatter:format -Psample,arq-jbossas-managed > format.log 2>&1
call mvn source:jar -Psample,arq-jbossas-managed > source.log 2>&1
call mvn source:test-jar -Psample,arq-jbossas-managed > source-test.log 2>&1
call mvn javadoc:javadoc -Psample,arq-jbossas-managed > javadoc.log 2>&1
call mvn jxr:jxr -Psample,arq-jbossas-managed > jxr.log 2>&1
call mvn jxr:test-jxr -Psample,arq-jbossas-managed > jxr-test.log 2>&1
call mvn eclipse:clean -P!mda,sample,arq-jbossas-managed > eclipse-clean.log 2>&1
call mvn eclipse:configure-workspace -P!mda,sample,arq-jbossas-managed > eclipse-workspace.log 2>&1
call mvn eclipse:eclipse -P!mda,sample,arq-jbossas-managed -DdownloadSources=true -DdownloadJavadocs=true -Peclipse-folders -Dappend.to.project.name=trunk > eclipse.log 2>&1
call mvn rat:check -Psample,arq-jbossas-managed > rat.log 2>&1
call mvn doap:generate -Psample,arq-jbossas-managed > doap.log 2>&1
call mvn clean install org.pitest:pitest-maven:mutationCoverage -Psample,arq-jbossas-managed > pit.log 2>&1
REM karma start ${WORKSPACE}/code/riskinsight/webapp/src/main/webapp/karma.jenkins.conf.js
REM output code/riskinsight/webapp/src/main/webapp/TEST-Karma-resultsTest.xml
#TODO Archive the artifacts **/pit-reports/**/*.html

REM call mvn install -pl maven/skin
REM call mvn install -amd maven/skin

pause

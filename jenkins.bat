cls

call setenv.bat
call mvn validate -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > validate.log 2>&1
call mvn validate -Dnabla -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > validate-nabla.log 2>&1
REM call mvn clean -Dnabla -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby -amd andromda-database-cartridge > clean-nabla.log 2>&1
call mvn versions:display-dependency-updates -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > dependency-updates.log 2>&1
call mvn versions:display-plugin-updates -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > plugin-updates.log 2>&1
call mvn help:active-profiles -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > profile.log 2>&1
call mvn dependency:tree -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > dependency.log 2>&1
call mvn dependency:analyze -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > analyze.log 2>&1
call mvn help:effective-pom -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > effective.log 2>&1
call mvn initialize -Pshow-properties > properties.log 2>&1
call mvn scm:validate -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > scm-validate.log 2>&1
REM call mvn jalopy:format -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > format.log 2>&1
call mvn java-formatter:format -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > format.log 2>&1
call mvn source:jar -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > source.log 2>&1
call mvn source:test-jar -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > source-test.log 2>&1
call mvn javadoc:javadoc -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > javadoc.log 2>&1
call mvn jxr:jxr -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > jxr.log 2>&1
call mvn jxr:test-jxr -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > jxr-test.log 2>&1
call mvn eclipse:clean -P!mda,sample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > eclipse-clean.log 2>&1
call mvn eclipse:configure-workspace -P!mda,sample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > eclipse-workspace.log 2>&1
call mvn eclipse:eclipse -P!mda,sample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby -DdownloadSources=true -DdownloadJavadocs=true -Peclipse-folders -Dappend.to.project.name=trunk > eclipse.log 2>&1
call mvn rat:check -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > rat.log 2>&1
call mvn doap:generate -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > doap.log 2>&1
call mvn clean install org.pitest:pitest-maven:mutationCoverage -Psample,arq-jbossas-managed -Dserver=jboss5x -Ddatabase=derby > pit.log 2>&1
REM karma start ${WORKSPACE}/code/riskinsight/webapp/src/main/webapp/karma.jenkins.conf.js
REM output code/riskinsight/webapp/src/main/webapp/TEST-Karma-resultsTest.xml
#TODO Archive the artifacts **/pit-reports/**/*.html

REM call mvn install -pl maven/skin
REM call mvn install -amd maven/skin

pause

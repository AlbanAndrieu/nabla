
Do not add target runtime  to JBOSS :
error will be : java.lang.RuntimeException: java.lang.NoSuchFieldError: TRACE

Persistence provider caller does not implement the EJB3 spec correctly. PersistenceUnitInfo.getNewTempClassLoader() is null
You can ignore that log message.
http://stackoverflow.com/questions/2328720/persistence-provider-caller-does-not-implement-the-ejb3-spec-correctly-warnin

You can add JPA facet to project but hibernate config does not work in eclipse without core.launch and hibernate-console.properties at the project base
In order to hibernate configuration to work, first connect JPA in project properties
add an hibernate config called timetracker-ejb3-core
Project : core-3.4
Database connection : JPA
Property file : \core-3.4\hibernate-console.properties

For jboss embedded files required are :
default.persistence
ejb3-interceptors-aop
embedded-jboss-beans
jndi
(log4j)

See :  TODO
/cygdrive/c/workspace/users/divers/ctpjava-read-only/core-test/core-test-webapp
http://localhost:8180/
http://code.google.com/p/ctpjava/wiki/MavenSeamHotdeployPluginUsage

Remove components.xml from core project because it does not work in core-test project

TestNG does not work in eclipse without add -Dsun.lang.ClassLoader.allowArraySyntax=true in the VM args

In order to enable seam facet : add Seam 2 Runtime with C:\jboss-seam-2.2.1.Final

for GWT access to Seam see :
http://virgo47.wordpress.com/2010/02/09/jboss-seam-gwt-2-support/
http://code.google.com/p/gwt-seam/wiki/GettingStartedGWTRPC
based on : http://docs.jboss.com/seam/2.1.1.GA/reference/en-US/html/gwt.html and http://unrealities.com/seamgwt/ http://unrealities.com/seamgwt/article_0.2.html

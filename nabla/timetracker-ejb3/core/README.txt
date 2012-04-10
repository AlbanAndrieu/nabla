
Do not add target runtime  to JBOSS :
error will be : java.lang.RuntimeException: java.lang.NoSuchFieldError: TRACE

Persistence provider caller does not implement the EJB3 spec correctly. PersistenceUnitInfo.getNewTempClassLoader() is null
You can ignore that log message.
http://stackoverflow.com/questions/2328720/persistence-provider-caller-does-not-implement-the-ejb3-spec-correctly-warnin

You can add JPA facet to project but hibernate config does not work in eclipse???

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

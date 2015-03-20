package org.andromda.timetracker.action;

import java.io.File;

import javax.naming.InitialContext;

import org.andromda.timetracker.domain.UserDaoBase;
import org.andromda.timetracker.service.UserServiceBean;
import org.andromda.timetracker.service.UserServiceLocal;
import org.andromda.timetracker.vo.UserVO;
import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.mock.JUnitSeamTest;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.MavenResolverSystem;
import org.jboss.shrinkwrap.resolver.api.maven.ScopeType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class SimpleSeamArquillianWithDataTest extends JUnitSeamTest
{
    private static final Logger logger = Logger.getLogger(SimpleSeamArquillianWithDataTest.class);

    @Deployment(name = "SimpleSeamArquillianTestWithData")
    @OverProtocol("Servlet 3.0")
    public static Archive<?> createTestArchive()
    {

        MavenResolverSystem resolver = Maven.resolver();

        // MavenDependencyResolver resolver = DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");
        // File[] libs = Maven.resolver().loadPomFromFile("pom.xml").importDependencies(ScopeType.TEST, ScopeType.COMPILE, ScopeType.PROVIDED).resolve().withTransitivity().asFile();
        File[] libs = resolver.loadPomFromFile("pom.xml").importDependencies(ScopeType.TEST, ScopeType.COMPILE, ScopeType.PROVIDED).resolve().withTransitivity().asFile();

        // File[] dependencyAndTransitives = resolver.resolve("org.jboss.seam:jboss-seam").withTransitivity().as(File.class);

        // File[] libs = Maven.resolver().loadPomFromFile("pom.xml").importCompileAndRuntimeDependencies()
        // resolve jboss-seam, because it is provided-scoped in the pom, but we need it bundled in the WAR
        // .resolve("org.jboss.seam:jboss-seam").withTransitivity().asFile();

        return ShrinkWrap.create(WebArchive.class, "core-test.war").addClasses(SimpleSeamArquillianWithDataTest.class, Authenticator.class, AuthenticatorAction.class, UserDaoBase.class, UserServiceBean.class)
                .addPackages(true, "org.andromda.timetracker.action").addPackages(true, "org.andromda.timetracker.domain")
                .addPackages(true, "org.andromda.timetracker")
                // Needed to run in managed / remote container
                .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml").addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource(EmptyAsset.INSTANCE, "seam.properties")
                // Deploy our test datasource
                .addAsWebInfResource("test-ds.xml", "test-ds.xml").addAsWebInfResource("WEB-INF/test-web.xml", "web.xml").addAsWebInfResource("WEB-INF/test-components.xml", "components.xml")
                .addAsWebInfResource("WEB-INF/jboss-deployment-structure.xml").addAsResource("META-INF/security.drl", "META-INF/security.drl").addAsResource("import.sql", "import.sql").addAsLibraries(libs)
        // libraries resolved using ShrinkWrap Resolver
        // .addAsLibraries(resolver.resolve("org.jboss.seam:jboss-seam").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("commons-collections:commons-collections").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("org.hibernate:hibernate-core").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("org.javassist:javassist").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("org.drools:drools-core").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("org.drools:drools-compiler").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("org.jbpm:jbpm-jpdl").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("org.jboss.el:jboss-el").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("javax.ejb:ejb-api").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("javax.el:el-api").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("org.mvel:mvel2").withTransitivity().asFile())
        ;
        // .addAsLibraries(resolver.artifact("log4j:log4j").resolveAsFiles())
        // .addAsLibraries(libs);
        // .delete("/WEB-INF/web.xml")
        // web resources
        // .addAsWebResource("index.html")
        // .addAsWebResource("register.xhtml")
        // .addAsWebResource("registered.xhtml")
    }

    // required import.sql
    @Test
    public void testEJBs() throws Exception
    {

        final InitialContext initialContext = this.getInitialContext();
        final UserServiceLocal local = (UserServiceLocal) initialContext.lookup("java:app/core/UserServiceBean");
        Assert.assertNotNull(local);

        final UserVO userVOLocal = local.getUser("testuser");
        Assert.assertNotNull(userVOLocal);
        System.out.println("Successfully found TestUser from @Local interface");

        /*
         * UserServiceRemote remote = (UserServiceRemote) initialContext.lookup("java:app/core/UserServiceBean!org.andromda.timetracker.service.UserServiceRemote");
         * Assert.assertNotNull(remote);
         * final UserVO userVORemote = remote.getUser("admin");
         * Assert.assertNotNull(userVORemote);
         */
        System.out.println("Successfully found Admin from @Remote interface");
    }

}

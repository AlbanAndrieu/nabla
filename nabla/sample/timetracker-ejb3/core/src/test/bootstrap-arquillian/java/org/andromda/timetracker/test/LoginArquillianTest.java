package org.andromda.timetracker.test;

import java.io.File;

import org.andromda.timetracker.action.Authenticator;
import org.andromda.timetracker.action.AuthenticatorAction;
import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.domain.UserDaoBase;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.Component;
import org.jboss.seam.core.Manager;
import org.jboss.seam.mock.JUnitSeamTest;
import org.jboss.seam.security.Identity;
import org.jboss.seam.web.Session;
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
public class LoginArquillianTest extends JUnitSeamTest
{
    @Deployment(name = "LoginArquillianTest")
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

        return ShrinkWrap
                .create(WebArchive.class, "core.war")
                .addClasses(LoginArquillianTest.class, Authenticator.class, AuthenticatorAction.class, UserDaoBase.class)
                .addPackages(true, "org.andromda.timetracker.action")
                .addPackages(true, "org.andromda.timetracker.domain")
                .addPackages(true, "org.andromda.timetracker")
                // Needed to run in managed / remote container
                .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml")
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource(EmptyAsset.INSTANCE, "seam.properties")
                // Deploy our test datasource
                // .addAsWebInfResource("test-ds.xml", "test-ds.xml")
                .addAsWebInfResource("WEB-INF/test-web.xml", "web.xml")
                .addAsWebInfResource("WEB-INF/test-components.xml", "components.xml")
.addAsWebInfResource("WEB-INF/jboss-deployment-structure.xml")
                .addAsResource("META-INF/security.drl", "META-INF/security.drl")
.addAsResource("import.sql", "import.sql")
.addAsResource("log4j.xml", "log4j.xml")
                .addAsLibraries(libs)
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

    @Test
    public void testLoginComponent() throws Exception
    {
        new ComponentTest()
        {
            @Override
            protected void testComponents() throws Exception
            {
                Identity identity = Identity.instance();

                Assert.assertFalse(identity.isLoggedIn());
                identity.setUsername("admin");
                identity.setPassword("cooldude");
                identity.login();

                User user = (User) Component.getInstance("user");
                Assert.assertEquals("admin", user.getUsername());
                Assert.assertEquals("cooldude", user.getPassword());
                Assert.assertEquals("Alban", user.getFirstName());
                Assert.assertEquals("Andrieu", user.getLastName());

                Assert.assertTrue(identity.isLoggedIn());
                identity.logout();
                Assert.assertFalse(identity.isLoggedIn());
                identity.setUsername("gavin");
                identity.setPassword("tiger");
                identity.login();
                Assert.assertFalse(identity.isLoggedIn());
            }
        }.run();
    }

    @Test
    public void testLogin() throws Exception
    {
        new ComponentTest()
        {
            @Override
            protected void testComponents() throws Exception
            {
                Identity identity = Identity.instance();

                Assert.assertFalse(identity.isLoggedIn());

                identity.setUsername("admin");
                identity.setPassword("cooldude");
                identity.login();

                User user = (User) Component.getInstance("user");
                Assert.assertEquals("admin", user.getUsername());
                Assert.assertEquals("cooldude", user.getPassword());
                Assert.assertEquals("Alban", user.getFirstName());
                Assert.assertEquals("Andrieu", user.getLastName());
                Assert.assertFalse(Manager.instance().isLongRunningConversation());
                Assert.assertTrue(identity.isLoggedIn());

                identity.logout();
                Assert.assertTrue(Session.instance().isInvalid());

                Assert.assertFalse(identity.isLoggedIn());
            }
        }.run();
    }

}

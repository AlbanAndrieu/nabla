package org.andromda.timetracker.test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.andromda.timetracker.action.Authenticator;
import org.andromda.timetracker.action.AuthenticatorAction;
import org.andromda.timetracker.action.ChangePassword;
import org.andromda.timetracker.action.ChangePasswordAction;
import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.domain.UserDaoBase;
import org.andromda.timetracker.service.UserServiceBean;
import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.Component;
import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.mock.JUnitSeamTest;
import org.jboss.seam.security.Identity;
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
public class SimpleSeamArquillianTest extends JUnitSeamTest
{
    private static final Logger logger = Logger.getLogger(SimpleSeamArquillianTest.class);

    @Deployment(name = "SimpleSeamArquillianTest")
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

        return ShrinkWrap.create(WebArchive.class, "core-test.war")
                .addClasses(SimpleSeamArquillianTest.class, Authenticator.class, AuthenticatorAction.class, UserDaoBase.class, UserServiceBean.class, ChangePasswordAction.class)
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

    @Test
    public void testLogin() throws Exception
    {
        new ComponentTest()
        {
            @Override
            protected void testComponents() throws Exception
            {

                Identity.setSecurityEnabled(true);

                /*
                 * ChangePassword bean = (ChangePassword) Component.getInstance(ChangePasswordAction.class, true);
                 * Assert.assertNotNull(bean)
                 */;

                Identity identity = Identity.instance();

                final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
                Contexts.getSessionContext().set("user", new User("admin", "cooldude", "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu"));
                identity.setUsername("admin");
                identity.setPassword("cooldude");
                System.out.println("Login : " + identity.login());

                System.out.println("Is logged in : " + identity.isLoggedIn());

                Assert.assertTrue(identity.isLoggedIn());

                System.out.println("Successfully login tested");
            }
        }.run();
    }

    @Test
    public void testGetUserWhitoutUsingChangePassword() throws Exception
    {
        new ComponentTest()
        {

            @Override
            protected void testComponents() throws Exception
            {
                User user = (User) Component.getInstance("user", true);
                Assert.assertNotNull(user);

                SimpleSeamArquillianTest.logger.debug("User : " + user);

                final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
                Contexts.getSessionContext().set("user", new User("admin", "cooldude", "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu"));

                user = (User) Component.getInstance("user", true);

                SimpleSeamArquillianTest.logger.debug("User : " + user);

                Assert.assertEquals(user.getUsername(), "admin");

                System.out.println("Successfully found User admin");
            }
        }.run();
    }

    @Test
    public void testBeanSeamInjectByName() throws Exception
    {
        new ComponentTest()
        {
            @Override
            protected void testComponents() throws Exception
            {

                Identity.setSecurityEnabled(false);

                ChangePassword beanChangePassword = (ChangePassword) getInstance("changePassword");
                Assert.assertNotNull(beanChangePassword);

                SimpleSeamArquillianTest.logger.debug("ChangePassword : " + beanChangePassword);

                Identity identity = Identity.instance();

                final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
                Contexts.getSessionContext().set("user", new User("admin", "cooldude", "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu"));
                identity.setUsername("admin");
                identity.setPassword("cooldude");
                identity.login();

                final User beanUser = beanChangePassword.getUser();

                Assert.assertNotNull(beanUser);
                SimpleSeamArquillianTest.logger.debug("User : " + beanUser);

                Assert.assertEquals(beanUser.getUsername(), "admin");

                System.out.println("Successfully found User from ChangePasswordAction");
            }
        }.run();
    }

    @Test
    public void testBeanSeamInjectByClass() throws Exception
    {
        new ComponentTest()
        {
            @Override
            protected void testComponents() throws Exception
            {

                Identity.setSecurityEnabled(false);

                ChangePassword beanChangePassword = (ChangePassword) Component.getInstance(ChangePasswordAction.class, true);
                Assert.assertNotNull(beanChangePassword);

                SimpleSeamArquillianTest.logger.debug("ChangePassword : " + beanChangePassword);

                Identity identity = Identity.instance();

                final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
                Contexts.getSessionContext().set("user", new User("admin", "cooldude", "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu"));
                identity.setUsername("admin");
                identity.setPassword("cooldude");
                identity.login();

                final User beanUser = beanChangePassword.getUser();

                Assert.assertNotNull(beanUser);
                SimpleSeamArquillianTest.logger.debug("User : " + beanUser);

                Assert.assertEquals(beanUser.getUsername(), "admin");

                System.out.println("Successfully found User from ChangePasswordAction");
            }
        }.run();
    }

    @Test
    public void testGetChangePasswordAction() throws Exception
    {
        new ComponentTest()
        {

            @Override
            protected void testComponents() throws Exception
            {

                Identity.setSecurityEnabled(false);

                ChangePassword bean = (ChangePassword) Component.getInstance(ChangePasswordAction.class, true);
                Assert.assertNotNull(bean);

                final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
                Contexts.getSessionContext().set("user", new User("admin", "cooldude", "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu"));

                bean = (ChangePassword) Component.getInstance(ChangePasswordAction.class, true);
                Assert.assertNotNull(bean);
                SimpleSeamArquillianTest.logger.debug("ChangePasswordAction bean : " + bean);

                Assert.assertEquals(bean.isChanged(), false);

                final User beanUser = bean.getUser();

                Assert.assertNotNull(beanUser);
                SimpleSeamArquillianTest.logger.debug("User : " + beanUser);

                Assert.assertEquals(beanUser.getUsername(), "admin");

                System.out.println("Successfully found User from ChangePasswordAction");
            }
        }.run();
    }

}

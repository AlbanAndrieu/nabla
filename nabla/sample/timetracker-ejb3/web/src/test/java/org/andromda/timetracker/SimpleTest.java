package org.andromda.timetracker;

import java.io.File;

import org.andromda.timetracker.action.Authenticator;
import org.andromda.timetracker.action.AuthenticatorAction;
import org.andromda.timetracker.domain.UserDaoBase;
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
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class SimpleTest extends JUnitSeamTest // SeamOpenEjbTest
{
    private static final Logger logger = Logger.getLogger(SimpleTest.class);

    @Deployment(name = "SimpleTest")
    @OverProtocol("Servlet 3.0")
    public static Archive<?> createTestArchive()
    {

        MavenResolverSystem resolver = Maven.resolver();

        // MavenDependencyResolver resolver = DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");
        File[] libs = resolver.loadPomFromFile("pom.xml").importDependencies(ScopeType.TEST, ScopeType.COMPILE, ScopeType.PROVIDED).resolve().withTransitivity().asFile();

        // File[] libs = Maven.resolver().loadPomFromFile("pom.xml").importCompileAndRuntimeDependencies()
        // resolve jboss-seam, because it is provided-scoped in the pom, but we need it bundled in the WAR
        // .resolve("org.jboss.seam:jboss-seam").withTransitivity().asFile();

        return ShrinkWrap.create(WebArchive.class, "web.war").addClasses(Authenticator.class, AuthenticatorAction.class, UserDaoBase.class).addPackages(true, "org.andromda.timetracker.client")
                .addPackages(true, "org.andromda.timetracker.server").addPackages(true, "org.andromda.timetracker")
                // Needed to run in managed / remote container
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource(EmptyAsset.INSTANCE, "seam.properties")
                // Deploy our test datasource
                // .addAsWebInfResource("test-ds.xml", "test-ds.xml")
                .addAsWebInfResource("WEB-INF/test-web.xml", "web.xml").addAsWebInfResource("WEB-INF/test-components.xml", "components.xml").addAsResource("META-INF/security.drl", "META-INF/security.drl")
                .addAsResource("import.sql", "import.sql").addAsResource("log4j.xml", "log4j.xml").addAsLibraries(libs)
        // libraries resolved using ShrinkWrap Resolver
        // .addAsLibraries(resolver.artifact("org.jboss.seam:jboss-seam").resolveAsFiles()).addAsLibraries(resolver.artifact("commons-collections:commons-collections").resolveAsFiles())
        // .addAsLibraries(resolver.artifact("org.hibernate:hibernate-core").resolveAsFiles()).addAsLibraries(resolver.artifact("org.drools:drools-core").resolveAsFiles())
        // .addAsLibraries(resolver.artifact("org.drools:drools-compiler").resolveAsFiles())
        // .addAsLibraries(resolver.artifact("org.jboss.el:jboss-el").resolveAsFiles())
        // .addAsLibraries(resolver.artifact("org.mvel:mvel2").resolveAsFiles()).
        // addAsLibraries(resolver.artifact("org.jbpm:jbpm-jpdl").resolveAsFiles())
        // .addAsLibraries(resolver.artifact("org.javassist:javassist").resolveAsFiles()).addAsLibraries(resolver.artifact("javax.ejb:ejb-api").resolveAsFiles())
        // .addAsLibraries(resolver.artifact("javax.el:el-api").resolveAsFiles());
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

                assert this.getValue("#{identity.loggedIn}").equals(false);

                // final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
                // Contexts.getSessionContext().set("user", new User("admin", PasswordEncoder.getMD5Base64EncodedPassword("cooldude"), "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu"));

                this.setValue("#{identity.username}", "admin");
                SimpleTest.logger.info("Identity username : " + this.getValue("#{identity.username}"));
                this.setValue("#{identity.password}", "cooldude");
                SimpleTest.logger.info("Identity password : " + this.getValue("#{identity.password}"));
                this.invokeMethod("#{identity.login}");

                assert this.getValue("#{identity.loggedIn}").equals(true);

                this.invokeMethod("#{identity.logout}");
                assert this.getValue("#{identity.loggedIn}").equals(false);
            }

        }.run();

    }

}

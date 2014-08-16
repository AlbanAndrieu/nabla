package org.andromda.timetracker.action;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

import org.andromda.timetracker.domain.UserDaoBase;
import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.mock.JUnitSeamTest;
import org.jboss.seam.security.Credentials;
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
public class AuthenticatorArquillianTest extends JUnitSeamTest // SeamOpenEjbTest
{

    private static final Logger logger = Logger.getLogger(AuthenticatorArquillianTest.class);

    @Deployment(name = "AuthenticatorArquillianTest")
    @OverProtocol("Servlet 3.0")
    public static Archive<?> createTestArchive()
    {

        MavenResolverSystem resolver = Maven.resolver();

        // MavenDependencyResolver resolver = DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");
        // File[] libs = Maven.resolver().loadPomFromFile("pom.xml").importDependencies(ScopeType.TEST, ScopeType.COMPILE, ScopeType.PROVIDED).resolve().withTransitivity().asFile();
        File[] libs = resolver.loadPomFromFile("pom.xml").importDependencies(ScopeType.TEST, ScopeType.COMPILE, ScopeType.PROVIDED).resolve().withTransitivity().asFile();

        // File[] libs = Maven.resolver().loadPomFromFile("pom.xml").importCompileAndRuntimeDependencies()
        // resolve jboss-seam, because it is provided-scoped in the pom, but we need it bundled in the WAR
        // .resolve("org.jboss.seam:jboss-seam").withTransitivity().asFile();

        return ShrinkWrap.create(WebArchive.class, "core.war").addClasses(AuthenticatorArquillianTest.class, Authenticator.class, AuthenticatorAction.class, UserDaoBase.class)
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
                .addAsWebInfResource("WEB-INF/test-web.xml", "web.xml").addAsWebInfResource("WEB-INF/test-components.xml", "components.xml")
.addAsWebInfResource("WEB-INF/jboss-deployment-structure.xml")
                .addAsResource("META-INF/security.drl", "META-INF/security.drl")
.addAsResource("import.sql", "import.sql").addAsResource("log4j.xml", "log4j.xml")
                // libraries resolved using ShrinkWrap Resolver
                .addAsLibraries(libs)
        // libraries resolved using ShrinkWrap Resolver
                .addAsLibraries(resolver.resolve("org.jboss.seam:jboss-seam:2.3.1.Final").withTransitivity().asFile())
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

    // Ignore Junit Test @Ignore("Pending improvment")
    @Test
    public void shouldAuthenticate() throws Exception
    {
        new ComponentTest()
        {
            @Override
            protected void testComponents() throws Exception
            {

                Identity.setSecurityEnabled(true);

                AuthenticatorArquillianTest.logger.info("credentials : " + this.getValue("#{credentials}"));
                AuthenticatorArquillianTest.logger.info("authenticator : " + this.getValue("#{authenticator}"));
                // given
                final Credentials cred = (Credentials) this.getValue("#{credentials}");
                final Authenticator auth = (Authenticator) this.getValue("#{authenticator}");

                // when
                cred.setUsername("admin");
                cred.setPassword("cooldude");

                AuthenticatorArquillianTest.logger.info("credentials username : " + cred.getUsername());

                final boolean success1 = auth.authenticate();

                // then
                Assert.assertTrue(success1);

                final Set<String> roles = new TreeSet<String>();
                final boolean success2 = auth.authenticate("admin", "cooldude", roles);
                // then
                Assert.assertTrue(success2);

                for (final String role : roles)
                {
                    AuthenticatorArquillianTest.logger.info("authenticator role : " + role);
                }
                Assert.assertEquals(roles.toString(), "[Administrator, StandardUser]");
                // AuthenticatorTest.logger.info("authenticator role hosRole : " + this.getValue("#{identity.checkRole(\"Administrator\")}"));

            }
        }.run();
    }

}

// license-header java merge-point
//
// Generated by test/SessionTest.vsl in andromda-ejb3-cartridge on 03/29/2012 12:08:36.
//
package org.andromda.timetracker.service.test;

import java.io.File;

import javax.naming.InitialContext;

import org.andromda.timetracker.action.Authenticator;
import org.andromda.timetracker.action.AuthenticatorAction;
import org.andromda.timetracker.domain.UserDaoBase;
import org.andromda.timetracker.service.SecurityServiceRemote;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

/**
 * Service test class SecurityServiceTest for testing with TestNG
 * Check the testng.xml for initialization of the EJB3Container before running any tests.
 */
@RunWith(Arquillian.class)
public class SecurityServiceTest extends JUnitSeamTest
{
    private static final Log logger = LogFactory.getLog(SecurityServiceTest.class);

    @Deployment(name = "AuthenticatorArquillianTest")
    @OverProtocol("Servlet 3.0")
    public static Archive<?> createTestArchive()
    {

        MavenResolverSystem resolver = Maven.resolver();

        File[] libs = resolver.loadPomFromFile("pom.xml").importDependencies(ScopeType.TEST, ScopeType.COMPILE, ScopeType.PROVIDED).resolve().withTransitivity().asFile();

        return ShrinkWrap.create(WebArchive.class, "core*test.war").addClasses(SecurityServiceTest.class, Authenticator.class, AuthenticatorAction.class, UserDaoBase.class)
                .addPackages(true, "org.andromda.timetracker.action")
                .addPackages(true, "org.andromda.timetracker.domain")
                .addPackages(true, "org.andromda.timetracker.service")
                .addPackages(true, "org.andromda.timetracker")
                // Needed to run in managed / remote container
                .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml").addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource(EmptyAsset.INSTANCE, "seam.properties")
                // Deploy our test datasource
                .addAsWebInfResource("test-ds.xml", "test-ds.xml").addAsWebInfResource("WEB-INF/test-web.xml", "web.xml").addAsWebInfResource("WEB-INF/test-components.xml", "components.xml")
                .addAsWebInfResource("WEB-INF/jboss-deployment-structure.xml").addAsResource("META-INF/security.drl", "META-INF/security.drl").addAsResource("import.sql", "import.sql")
                .addAsResource("log4j.xml", "log4j.xml")
                // libraries resolved using ShrinkWrap Resolver
                .addAsLibraries(libs)
        // other libraries resolved using ShrinkWrap Resolver
        // needed for FacesMessages
        // .addAsLibraries(resolver.resolve("org.jboss.seam:jboss-seam:2.3.1.Final").withTransitivity().asFile())
        ;
    }

    @Test
    public void testGetUserDetails() throws Exception
    {

        try
        {
            final InitialContext initialContext = this.getInitialContext();
            final SecurityServiceRemote securityService = (SecurityServiceRemote) initialContext.lookup("java:app/core/SecurityServiceBean/remote");
            Assert.assertNotNull(securityService);

            SecurityServiceTest.logger.debug("Service : " + securityService.toString());

        } catch (Exception e)
        {
            SecurityServiceTest.logger.warn("Failed test SecurityServiceBean", e);
            Assert.fail();
        }
    }

}

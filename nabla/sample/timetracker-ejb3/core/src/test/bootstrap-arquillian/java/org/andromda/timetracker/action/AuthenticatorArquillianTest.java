package org.andromda.timetracker.action;

import java.util.Set;
import java.util.TreeSet;

import no.knowit.seam.openejb.mock.AbstractSeamOpenEjbTest;
import no.knowit.seam.openejb.mock.SeamOpenEjbTest;

import org.apache.log4j.Logger;
import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.mock.AbstractSeamTest.ComponentTest;
import org.jboss.seam.security.Credentials;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@RunWith(Arquillian.class)
public class AuthenticatorArquillianTest extends SeamOpenEjbTest
{

    private static final Logger logger = Logger.getLogger(AuthenticatorArquillianTest.class);

    @Deployment
    public static Archive<?> createTestArchive()
    {
        return ShrinkWrap.create(WebArchive.class, "test.war").addClasses(Authenticator.class, AuthenticatorAction.class).addPackages(true, "org.andromda.timetracker") // Needed to run in managed / remote container
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml").addAsResource(EmptyAsset.INSTANCE, "seam.properties")
                // Deploy our test datasource
                .addAsWebInfResource("test-ds.xml", "test-ds.xml");
    }

    /*
    @Override
    @BeforeSuite
    public void beforeSuite() throws Exception
    {

        // System.out.println("**** AuthenticatorTest.beforeSuite()");

        // Change some logging, INFO|DEBUG|WARN|ERROR|FATAL contextProperties.put("log4j.category.org.jboss.seam.Component", "DEBUG");
        AbstractSeamOpenEjbTest.contextProperties.put("log4j.category.org.jboss.seam.transaction", "DEBUG");
        AbstractSeamOpenEjbTest.contextProperties.put("log4j.category.org.jboss.seam.mock", "DEBUG");
        AbstractSeamOpenEjbTest.contextProperties.put("log4j.category.no.knowit.seam.openejb.mock", "DEBUG");
        AbstractSeamOpenEjbTest.contextProperties.put("log4j.category.no.knowit.seam.example", "debug");
        super.beforeSuite();
    }
     */

    // Ignore Junit Test @Ignore("Pending improvment")
    @Test(enabled = false)
    public void shouldAuthenticate() throws Exception
    {
        new ComponentTest()
        {
            @Override
            protected void testComponents() throws Exception
            {

                AuthenticatorArquillianTest.logger.info("credentials : " + this.getValue("#{credentials}"));
                AuthenticatorArquillianTest.logger.info("authenticator : " + this.getValue("#{authenticator}"));
                // given
                final Credentials cred = (Credentials) this.getValue("#{credentials}");
                final Authenticator auth = (Authenticator) this.getValue("#{authenticator}");

                // when
                cred.setUsername("admin");
                cred.setPassword("cooldude");
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

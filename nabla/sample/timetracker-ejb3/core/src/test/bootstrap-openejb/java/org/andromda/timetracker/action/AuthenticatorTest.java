package org.andromda.timetracker.action;

import java.util.Set;
import java.util.TreeSet;

import no.knowit.seam.openejb.mock.AbstractSeamOpenEjbTest;
import no.knowit.seam.openejb.mock.SeamOpenEjbTest;

import org.apache.log4j.Logger;
import org.jboss.seam.security.Credentials;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AuthenticatorTest extends SeamOpenEjbTest
{

    private static final Logger logger = Logger.getLogger(AuthenticatorTest.class);

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

    public void shouldAuthenticate() throws Exception
    {
        new ComponentTest()
        {
            @Override
            protected void testComponents() throws Exception
            {

                AuthenticatorTest.logger.info("credentials : " + this.getValue("#{credentials}"));
                AuthenticatorTest.logger.info("authenticator : " + this.getValue("#{authenticator}"));
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
                    AuthenticatorTest.logger.info("authenticator role : " + role);
                }
                Assert.assertEquals(roles.toString(), "[Administrator, StandardUser]");
                // AuthenticatorTest.logger.info("authenticator role hosRole : " + this.getValue("#{identity.checkRole(\"Administrator\")}"));

            }
        }.run();
    }

}

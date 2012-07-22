package org.jboss.seam.example.booking.test;

import org.andromda.timetracker.security.PasswordEncoder;
import org.apache.log4j.Logger;
import org.jboss.seam.example.booking.Authenticator;
import org.jboss.seam.mock.SeamTest;
import org.jboss.seam.security.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticatorTest extends SeamTest
{

    private static final Logger logger = Logger.getLogger(AuthenticatorTest.class);

    @Test
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
                cred.setPassword(PasswordEncoder.getMD5Base64EncodedPassword("cooldude"));
                final boolean success1 = auth.authenticate();

                // then
                Assert.assertTrue(success1);

                // TODO add check on roles
                final boolean success2 = auth.authenticate("admin", PasswordEncoder.getMD5Base64EncodedPassword("cooldude"), null);

                // then
                Assert.assertTrue(success2);
            }
        }.run();
    }

}

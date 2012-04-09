package jar;

import org.apache.log4j.Logger;
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
                final boolean success = auth.authenticate();

                // then
                Assert.assertTrue(success);
            }
        }.run();
    }

}

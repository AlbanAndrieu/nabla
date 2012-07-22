package org.jboss.seam.example.booking.test;

import org.andromda.timetracker.security.PasswordEncoder;
import org.apache.log4j.Logger;
import org.jboss.seam.mock.SeamTest;
import org.testng.annotations.Test;

public class SimpleTest extends SeamTest
{
    private static final Logger logger = Logger.getLogger(SimpleTest.class);

    @Test
    public void testLogIn() throws Exception
    {

        new FacesRequest()
        {

            @Override
            protected void invokeApplication() throws Exception
            {
                // final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
                // Contexts.getSessionContext().set("user", new User("admin", PasswordEncoder.getMD5Base64EncodedPassword("cooldude"), "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu"));
                this.setValue("#{identity.username}", "admin");
                SimpleTest.logger.info("Identity username : " + this.getValue("#{identity.username}"));
                this.setValue("#{identity.password}", PasswordEncoder.getMD5Base64EncodedPassword("cooldude"));
                SimpleTest.logger.info("Identity password : " + this.getValue("#{identity.password}"));
                this.invokeAction("#{identity.login}");
            }

        }.run();

    }

}

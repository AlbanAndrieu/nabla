package org.andromda.timetracker;

import no.knowit.seam.openejb.mock.SeamOpenEjbTest;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class SimpleTest extends SeamOpenEjbTest
{
    private static final Logger logger = Logger.getLogger(SimpleTest.class);

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

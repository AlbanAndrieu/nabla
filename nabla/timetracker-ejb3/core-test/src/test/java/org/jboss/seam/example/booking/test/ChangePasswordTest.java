package org.jboss.seam.example.booking.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.security.PasswordEncoder;
import org.apache.log4j.Logger;
import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.core.Manager;
import org.jboss.seam.mock.SeamTest;
import org.testng.annotations.Test;

public class ChangePasswordTest extends SeamTest
{
    private static final Logger logger = Logger.getLogger(ChangePasswordTest.class);

    @Test
    public void testChangePassword() throws Exception
    {

        new FacesRequest()
        {

            @Override
            protected void invokeApplication() throws Exception
            {
                final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
                Contexts.getSessionContext().set("user", new User("admin", PasswordEncoder.getMD5Base64EncodedPassword("cooldude"), "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu"));
                this.setValue("#{identity.username}", "admin");
                ChangePasswordTest.logger.info("Identity username : " + this.getValue("#{identity.username}"));
                this.setValue("#{identity.password}", PasswordEncoder.getMD5Base64EncodedPassword("cooldude"));
                ChangePasswordTest.logger.info("Identity password : " + this.getValue("#{identity.password}"));
                this.invokeMethod("#{identity.login}");
            }

        }.run();

        new FacesRequest()
        {

            @Override
            protected void processValidations() throws Exception
            {
                final boolean validate = this.validateValue("#{user.password}", "xxx");
                ChangePasswordTest.logger.info("User password : " + validate + " - " + this.getValue("#{user.username}") + " + " + this.getValue("#{user.password}") + " - " + this.isValidationFailure());
                assert !this.isValidationFailure();
            }

            @Override
            protected void renderResponse() throws Exception
            {
                assert this.getValue("#{user.firstName}").equals("Alban");
                assert this.getValue("#{user.lastName}").equals("Andrieu");
                assert this.getValue("#{user.username}").equals("admin");
                assert this.getValue("#{user.password}").equals(PasswordEncoder.getMD5Base64EncodedPassword("cooldude"));
                assert !Manager.instance().isLongRunningConversation();
                assert this.getValue("#{identity.loggedIn}").equals(true);

            }

        }.run();

        new FacesRequest()
        {

            @Override
            protected void updateModelValues() throws Exception
            {
                this.setValue("#{user.password}", "xxxyyy");
                ChangePasswordTest.logger.info("User password : " + this.getValue("#{user.username}") + " + " + this.getValue("#{user.password}"));
                this.setValue("#{changePassword.verify}", "xxyyyx");
            }

            @Override
            protected void invokeApplication()
            {
                assert this.invokeAction("#{changePassword.changePassword}") == null;
            }

            @Override
            protected void renderResponse() throws Exception
            {
                assert this.getValue("#{user.firstName}").equals("Alban");
                assert this.getValue("#{user.lastName}").equals("Andrieu");
                assert this.getValue("#{user.username}").equals("admin");
                assert this.getValue("#{user.password}").equals(PasswordEncoder.getMD5Base64EncodedPassword("cooldude"));
                assert !Manager.instance().isLongRunningConversation();
                assert this.getValue("#{identity.loggedIn}").equals(true);
            }

        }.run();

        new FacesRequest()
        {

            @Override
            protected void updateModelValues() throws Exception
            {
                this.setValue("#{user.password}", "xxxyyy");
                ChangePasswordTest.logger.info("User password : " + this.getValue("#{user.username}") + " + " + this.getValue("#{user.password}"));
                this.setValue("#{changePassword.verify}", "xxxyyy");
            }

            @Override
            protected void invokeApplication()
            {
                this.invokeMethod("#{changePassword.changePassword}");
            }

            @Override
            protected void renderResponse()
            {
                assert this.getValue("#{user.firstName}").equals("Alban");
                assert this.getValue("#{user.lastName}").equals("Andrieu");
                assert this.getValue("#{user.username}").equals("admin");
                assert this.getValue("#{user.password}").equals("xxxyyy");
                assert !Manager.instance().isLongRunningConversation();
                assert this.getValue("#{identity.loggedIn}").equals(true);

            }

        }.run();

        new FacesRequest()
        {

            @Override
            protected void updateModelValues() throws Exception
            {
                assert this.getValue("#{user.password}").equals("xxxyyy");
                this.setValue("#{user.password}", "foobar");
                this.setValue("#{changePassword.verify}", "foobar");
            }

            @Override
            protected void invokeApplication()
            {
                this.invokeMethod("#{changePassword.changePassword}");
            }

            @Override
            protected void renderResponse()
            {
                assert this.getValue("#{user.firstName}").equals("Alban");
                assert this.getValue("#{user.lastName}").equals("Andrieu");
                assert this.getValue("#{user.username}").equals("admin");
                assert this.getValue("#{user.password}").equals("foobar");
                assert !Manager.instance().isLongRunningConversation();
                assert this.getValue("#{identity.loggedIn}").equals(true);

            }

        }.run();

    }

}

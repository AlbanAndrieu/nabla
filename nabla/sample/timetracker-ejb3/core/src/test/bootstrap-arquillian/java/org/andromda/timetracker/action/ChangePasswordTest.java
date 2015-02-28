package org.andromda.timetracker.action;

import org.apache.log4j.Logger;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.core.Manager;
import org.jboss.seam.mock.JUnitSeamTest;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ChangePasswordTest extends JUnitSeamTest
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
                // final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
                // Contexts.getSessionContext().set("user", new User("admin", PasswordEncoder.getMD5Base64EncodedPassword("cooldude"), "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu"));
                this.setValue("#{identity.username}", "admin");
                ChangePasswordTest.logger.info("Identity username : " + this.getValue("#{identity.username}"));
                this.setValue("#{identity.password}", "cooldude");
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
                assert this.isValidationFailure(); // because xxx is too small
            }

            @Override
            protected void renderResponse() throws Exception
            {
                // assert this.getValue("#{user.firstName}").equals("Alban");
                // assert this.getValue("#{user.lastName}").equals("Andrieu");
                assert this.getValue("#{user.username}").equals("admin");
                assert this.getValue("#{user.password}").equals("cooldude");
                assert !Manager.instance().isLongRunningConversation();
                assert this.getValue("#{identity.loggedIn}").equals(true);

            }

        }.run();

        new FacesRequest()
        {

            @Override
            protected void applyRequestValues() throws Exception
            {
                Contexts.getSessionContext().set("loggedIn", true);
                // final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
                // Contexts.getSessionContext().set("user", new User("admin", PasswordEncoder.getMD5Base64EncodedPassword("cooldude"), "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu"));
                // ChangePasswordTest.logger.info("User username : " + this.getValue("#{user.username}"));
                // ChangePasswordTest.logger.info("User password : " + this.getValue("#{user.password}"));
            }

            @Override
            protected void updateModelValues() throws Exception
            {
                // final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
                // Contexts.getSessionContext().set("user", new User("admin", PasswordEncoder.getMD5Base64EncodedPassword("cooldude"), "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu"));
                // ChangePasswordTest.logger.info("User username : " + this.getValue("#{user.username}"));
                // ChangePasswordTest.logger.info("User password : " + this.getValue("#{user.password}"));
                // this.invokeMethod("#{identity.login}");

                // final User user = (User) Component.getInstance("user", true);
                // user.setPassword("xxxyyy");

                // assert !Manager.instance().isLongRunningConversation();
                // assert this.getValue("#{identity.loggedIn}").equals(true);

                this.setValue("#{user.password}", "xxxyyy");
                ChangePasswordTest.logger.info("User password : " + this.getValue("#{user.username}") + " + " + this.getValue("#{user.password}"));
                assert this.getValue("#{user.password}").equals("xxxyyy");
                this.setValue("#{changePassword.verify}", "xxyyyx");
                // this.setValue("#{changePassword.user}", user);
            }

            @Override
            protected void invokeApplication()
            {
                // must go through revertUser
                // assert this.invokeMethod("#{changePassword.changePassword}").equals("success");
                assert this.invokeAction("#{changePassword.changePassword}") == null;
            }

            @Override
            protected void renderResponse() throws Exception
            {
                assert this.getValue("#{changePassword.changed}").equals(false);
                assert this.getValue("#{user.firstName}").equals("Alban");
                assert this.getValue("#{user.lastName}").equals("Andrieu");
                assert this.getValue("#{user.username}").equals("admin");
                assert this.getValue("#{user.password}").equals("cooldude");
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
                ChangePasswordTest.logger.info("updateModelValues User password : " + this.getValue("#{user.username}") + " + " + this.getValue("#{user.password}"));
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
                assert this.getValue("#{changePassword.changed}").equals(true);
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
                this.setValue("#{user.password}", "cooldude");
                this.setValue("#{changePassword.verify}", "cooldude");
            }

            @Override
            protected void invokeApplication()
            {
                this.invokeMethod("#{changePassword.changePassword}");
            }

            @Override
            protected void renderResponse() throws Exception
            {
                assert this.getValue("#{changePassword.changed}").equals(true);
                assert this.getValue("#{user.firstName}").equals("Alban");
                assert this.getValue("#{user.lastName}").equals("Andrieu");
                assert this.getValue("#{user.username}").equals("admin");
                assert this.getValue("#{user.password}").equals("cooldude");
                assert !Manager.instance().isLongRunningConversation();
                assert this.getValue("#{identity.loggedIn}").equals(true);

            }

        }.run();

    }

}

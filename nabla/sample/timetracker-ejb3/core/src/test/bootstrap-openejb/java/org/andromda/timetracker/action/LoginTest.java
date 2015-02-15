package org.andromda.timetracker.action;

import org.apache.log4j.Logger;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.core.Manager;
import org.jboss.seam.mock.JUnitSeamTest;
import org.jboss.seam.web.Session;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@RunWith(Arquillian.class)
public class LoginTest extends JUnitSeamTest // SeamOpenEjbTest
{
	private static final Logger logger = Logger.getLogger(LoginTest.class);

	@Test
	public void testLoginComponent() throws Exception {
		new ComponentTest() {

			@Override
			protected void testComponents() throws Exception {
				// final Date date = (new
				// SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
				// Contexts.getSessionContext().set("user", new User("admin",
				// PasswordEncoder.getMD5Base64EncodedPassword("cooldude"),
				// "Alban", "Andrieu", "alban.andrieu@free.fr", true, date,
				// "Alban Andrieu"));

				assert this.getValue("#{identity.loggedIn}").equals(false);

				// this.setValue("#{user.firstName}", "Alban");
				// this.setValue("#{user.lastName}", "Andrieu");
				this.setValue("#{identity.username}", "admin");
				this.setValue("#{identity.password}", "cooldude");
				this.invokeMethod("#{identity.login}");
				LoginTest.logger.info("testComponents - User password : "
						+ this.getValue("#{user.username}") + " + "
						+ this.getValue("#{user.password}"));
				assert this.getValue("#{user.firstName}").equals("Alban");
				assert this.getValue("#{user.lastName}").equals("Andrieu");
				assert this.getValue("#{user.username}").equals("admin");
				assert this.getValue("#{user.password}").equals("cooldude");
				assert this.getValue("#{identity.loggedIn}").equals(true);
				this.invokeMethod("#{identity.logout}");
				assert this.getValue("#{identity.loggedIn}").equals(false);

				this.setValue("#{identity.username}", "other");
				this.setValue("#{identity.password}", "tiger");
				this.invokeMethod("#{identity.login}");
				assert this.getValue("#{identity.loggedIn}").equals(false);
			}

		}.run();
	}

	@Test
	public void testLogin() throws Exception {

		new FacesRequest() {

			@Override
			protected void invokeApplication() {
				assert !LoginTest.this.isSessionInvalid();
				assert this.getValue("#{identity.loggedIn}").equals(false);
			}

		}.run();

		new FacesRequest() {

			@Override
			protected void updateModelValues() throws Exception {
				assert !LoginTest.this.isSessionInvalid();
				this.setValue("#{identity.username}", "admin");
				this.setValue("#{identity.password}", "cooldude");
			}

			@Override
			protected void invokeApplication() {
				this.invokeAction("#{identity.login}");
			}

			@Override
			protected void renderResponse() throws Exception {
				LoginTest.logger.info("renderResponse - User password : "
						+ this.getValue("#{user.username}") + " + "
						+ this.getValue("#{user.password}"));
				// assert this.getValue("#{user.firstName}").equals("Alban");
				// assert this.getValue("#{user.lastName}").equals("Andrieu");
				assert this.getValue("#{user.username}").equals("admin");
				assert this.getValue("#{user.password}").equals("cooldude");
				assert !Manager.instance().isLongRunningConversation();
				assert this.getValue("#{identity.loggedIn}").equals(true);
			}

		}.run();

		new FacesRequest() {

			@Override
			protected void invokeApplication() {
				assert !LoginTest.this.isSessionInvalid();
				assert this.getValue("#{identity.loggedIn}").equals(true);
			}

		}.run();

		new FacesRequest() {

			@Override
			protected void invokeApplication() {
				assert !Manager.instance().isLongRunningConversation();
				assert !LoginTest.this.isSessionInvalid();
				this.invokeMethod("#{identity.logout}");
				assert Session.instance().isInvalid();
			}

			@Override
			protected void renderResponse() {
				assert this.getValue("#{identity.loggedIn}").equals(false);
				assert Session.instance().isInvalid();
			}

		}.run();

	}

}

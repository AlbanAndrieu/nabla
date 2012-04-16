package org.andromda.timetracker.service.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import no.knowit.seam.openejb.mock.AbstractSeamOpenEjbTest;
import no.knowit.seam.openejb.mock.SeamManagedEntityManagerFactoryBean;
import no.knowit.seam.openejb.mock.SeamOpenEjbTest;

import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.security.PasswordEncoder;
import org.andromda.timetracker.service.RegisterAction;
import org.apache.log4j.Logger;
import org.jboss.seam.Component;
import org.jboss.seam.contexts.Contexts;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public class RegisterActionTest extends SeamOpenEjbTest
{

    private static final Logger logger = Logger.getLogger(RegisterActionTest.class);

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

    // @Test
    // Does not work with transaction type to JTA in persistence.xml
    public void testRegisterAction() throws Exception
    {

        new ComponentTest()
        {
            private EntityManagerFactory emf;

            public EntityManagerFactory getEntityManagerFactory()
            {
                return this.emf;
            }

            @Override
            protected void testComponents()
            {
                try
                {
                    // this.emf = Persistence.createEntityManagerFactory("timetracker-ejb3");
                    this.emf = (EntityManagerFactory) Component.getInstance(SeamManagedEntityManagerFactoryBean.class, true);
                    Assert.assertNotNull(this.emf);
                    RegisterActionTest.logger.debug("SeamManagedEntityManagerFactory bean : " + this.emf);

                    Date date;

                    date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");

                    final User user = new User("admin", PasswordEncoder.getMD5Base64EncodedPassword("cooldude"), "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu");
                    Contexts.getSessionContext().set("user", user);

                    // this.setValue("#{identity.username}", "admin");
                    // this.setValue("#{identity.password}", PasswordEncoder.getMD5Base64EncodedPassword("cooldude"));
                    // this.invokeMethod("#{identity.login}");
                    // assert this.getValue("#{identity.loggedIn}").equals(true);

                    final EntityManager em = this.getEntityManagerFactory().createEntityManager();
                    em.getTransaction().begin();

                    final RegisterAction action = new RegisterAction();
                    action.setUser(user);
                    action.setEntityManager(em);
                    action.setVerify(PasswordEncoder.getMD5Base64EncodedPassword("cooldude"));

                    // assert "success".equals(action.register());
                    Assert.assertNull(action.register()); // Already exist

                    em.getTransaction().commit();
                    em.close();

                }
                catch (final Exception e)
                {
                    RegisterActionTest.logger.info("error : " + e);
                    Assert.fail();
                }
                finally
                {
                    this.emf.close();
                }
            }
        }.run();

    }

}

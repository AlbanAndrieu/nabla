package org.andromda.timetracker.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.transaction.TransactionManager;

import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.service.UserService;
import org.andromda.timetracker.service.UserServiceBean;
import org.andromda.timetracker.service.UserServiceLocal;
import org.apache.log4j.Logger;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.Component;
import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.mock.JUnitSeamTest;
import org.jboss.seam.security.Identity;
import org.junit.runner.RunWith;
import org.testng.Assert;
import org.testng.annotations.Test;

@RunWith(Arquillian.class)
public class SimpleSeamTest extends JUnitSeamTest //SeamOpenEjbTest
{
    private static final Logger logger           = Logger.getLogger(SimpleSeamTest.class);
    //public static final String  JNDI_PREFIX_NAME = "";                                    //"global/timetracker-ejb3-ear/core-3.4/";

    @Test
    public void testGetUser() throws Exception
    {
        new ComponentTest()
        {

            @Override
            protected void testComponents() throws Exception
            {
                User user = (User) Component.getInstance("user", true);
                Assert.assertNotNull(user);
                SimpleSeamTest.logger.debug("User : " + user);

                final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
                Contexts.getSessionContext().set("user", new User("admin", "cooldude", "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu"));

                user = (User) Component.getInstance("user", true);

                SimpleSeamTest.logger.debug("User : " + user);

                Assert.assertEquals(user.getUsername(), "admin");

                System.out.println("Successfully found User from SimpleSeamTest");
            }
        }.run();
    }

    @Test
    public void testGetChangePasswordAction() throws Exception
    {
        new ComponentTest()
        {

            @Override
            protected void testComponents() throws Exception
            {

                Identity.setSecurityEnabled(false);

                ChangePassword bean = (ChangePassword) Component.getInstance(ChangePasswordAction.class, true);
                Assert.assertNotNull(bean);

                final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
                Contexts.getSessionContext().set("user", new User("admin", "cooldude", "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu"));

                bean = (ChangePassword) Component.getInstance(ChangePasswordAction.class, true);
                Assert.assertNotNull(bean);
                SimpleSeamTest.logger.debug("ChangePasswordAction bean : " + bean);

                Assert.assertEquals(bean.isChanged(), false);

                final User beanUser = bean.getUser();

                Assert.assertNotNull(beanUser);
                SimpleSeamTest.logger.debug("User : " + beanUser);

                Assert.assertEquals(beanUser.getUsername(), "admin");

                System.out.println("Successfully found User from ChangePasswordAction");
            }
        }.run();
    }

    @Test
    public void testGetUserServiceBean() throws Exception
    {
        new ComponentTest()
        {

            @Override
            protected void testComponents() throws Exception
            {
                final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
                Contexts.getSessionContext().set("user", new User("admin", "cooldude", "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu"));

                final UserService bean = (UserService) Component.getInstance(UserServiceBean.class, true);
                Assert.assertNotNull(bean);
                SimpleSeamTest.logger.debug("UserServiceBean bean : " + bean);

                // final UserVO userVOLocal = bean.getUser("testuser");
                // Assert.assertNotNull(userVOLocal);
                System.out.println("Successfully created and found TestUser from @Local interface");
            }
        }.run();
    }

    @Test
    public void testEJBs() throws Exception
    {

        final InitialContext initialContext = this.getInitialContext();
        final UserServiceLocal local = (UserServiceLocal) initialContext.lookup(/*JNDI_PREFIX_NAME +*/ "UserServiceBean/Local");
        Assert.assertNotNull(local);

        // final UserVO userVOLocal = local.getUser("testuser");
        // Assert.assertNotNull(userVOLocal);
        // System.out.println("Successfully found TestUser from @Local interface");

        // initialContext.lookup("UserServiceBean/Remote");
        // Assert.assertNotNull(local);

        // final UserVO userVORemote = remote.getUser("admin");
        // Assert.assertNotNull(userVORemote);
        // System.out.println("Successfully found Admin from @Remote interface");
    }

    // @Test
    public void testEntityManager() throws Exception
    {
        // This is a transactionally aware EntityManager and must be accessed within a JTA transaction
        // Why aren't we using javax.persistence.Persistence? Well, our persistence.xml file uses
        // jta-datasource which means that it is created by the EJB container/embedded JBoss.
        // using javax.persistence.Persistence will just cause us an error
        final EntityManager em = (EntityManager) new InitialContext().lookup("java:/EntityManagerFactories/timetracker-ejb3");

        // final SeamManagedEntityManagerFactory bean = (SeamManagedEntityManagerFactory) Component.getInstance(SeamManagedEntityManagerFactoryBean.class, true);
        // final EntityManager em = bean.getEntityMangagerFactory().createEntityManager();

        // Obtain JBoss transaction
        final TransactionManager tm = (TransactionManager) new InitialContext().lookup("java:/TransactionManager");

        tm.begin();

        final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
        User user = new User("admin", "cooldude", "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu");
        em.persist(user);

        Assert.assertTrue(user.getId() > 0);

        final Long id = user.getId();

        System.out.println("created admin with id: " + id);

        tm.commit();

        tm.begin();
        user = em.find(User.class, id);
        Assert.assertNotNull(user);
        tm.commit();
    }
}

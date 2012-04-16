/*
 * JBoss, Home of Professional Open Source
 * Copyright 2006, JBoss Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.andromda.timetracker.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.transaction.TransactionManager;

import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.security.PasswordEncoder;
import org.andromda.timetracker.service.ChangePassword;
import org.andromda.timetracker.service.ChangePasswordAction;
import org.andromda.timetracker.service.UserService;
import org.andromda.timetracker.service.UserServiceBean;
import org.apache.log4j.Logger;
import org.jboss.seam.Component;
import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.mock.SeamTest;
import org.jboss.seam.security.Identity;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleSeamTest extends SeamTest
{
    private static final Logger logger = Logger.getLogger(SimpleSeamTest.class);

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
                Contexts.getSessionContext().set("user", new User("admin", PasswordEncoder.getMD5Base64EncodedPassword("cooldude"), "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu"));

                user = (User) Component.getInstance("user", true);

                SimpleSeamTest.logger.debug("User : " + user);

                Assert.assertEquals(user.getUsername(), "admin");

                System.out.println("Successfully found User from ChangePasswordAction");
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
                Contexts.getSessionContext().set("user", new User("admin", PasswordEncoder.getMD5Base64EncodedPassword("cooldude"), "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu"));

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
                Contexts.getSessionContext().set("user", new User("admin", PasswordEncoder.getMD5Base64EncodedPassword("cooldude"), "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu"));

                final UserService bean = (UserService) Component.getInstance(UserServiceBean.class, true);
                Assert.assertNotNull(bean);
                SimpleSeamTest.logger.debug("UserServiceBean bean : " + bean);

                // final UserVO userVOLocal = bean.getUser("testuser");
                // Assert.assertNotNull(userVOLocal);
                System.out.println("Successfully created and found TestUser from @Local interface");
            }
        }.run();
    }

    public void testEJBs() throws Exception
    {

        // final InitialContext ctx = new InitialContext();
        // final UserServiceLocal local = (UserServiceLocal) ctx.lookup("UserServiceBean/local");
        // final UserServiceRemote remote = (UserServiceRemote) ctx.lookup("UserServiceBean/remote");

        // final UserVO userVOLocal = local.getUser("testuser");
        // Assert.assertNotNull(userVOLocal);
        // System.out.println("Successfully created and found TestUser from @Local interface");
        //
        // final UserVO userVORemote = remote.getUser("admin");
        // Assert.assertNotNull(userVORemote);
        // System.out.println("Successfully created and found Admin from @Remote interface");
    }

    public void testEntityManager() throws Exception
    {
        // This is a transactionally aware EntityManager and must be accessed within a JTA transaction
        // Why aren't we using javax.persistence.Persistence? Well, our persistence.xml file uses
        // jta-datasource which means that it is created by the EJB container/embedded JBoss.
        // using javax.persistence.Persistence will just cause us an error
        final EntityManager em = (EntityManager) new InitialContext().lookup("java:/EntityManagerFactories/timetracker-ejb3");

        // Obtain JBoss transaction
        final TransactionManager tm = (TransactionManager) new InitialContext().lookup("java:/TransactionManager");

        tm.begin();

        final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
        User user = new User("admin", PasswordEncoder.getMD5Base64EncodedPassword("cooldude"), "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu");
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

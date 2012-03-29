/*
 * Copyright (c) 2002-2004, Nabla
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Nabla' nor 'Alban' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package org.andromda.timetracker.test;

import java.util.Date;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.andromda.timetracker.domain.Role;
import org.andromda.timetracker.security.PasswordEncoder;
import org.andromda.timetracker.service.UserDoesNotExistException;
import org.andromda.timetracker.service.UserServiceRemote;
import org.andromda.timetracker.vo.UserDetailsVO;
import org.andromda.timetracker.vo.UserRoleVO;
import org.andromda.timetracker.vo.UserVO;
import org.apache.log4j.Logger;
import org.jboss.ejb3.embedded.EJB3StandaloneBootstrap;
import org.jboss.ejb3.embedded.EJB3StandaloneDeployer;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * DOCUMENT ME! Alban.
 *
 * @author $Author$
 * @version $Revision$
 *
 * @since $Date$
 *
 */
public class EmbeddedEjb3TestCase /* extends TestCase */
{

    private static final Logger           logger           = Logger.getLogger(EmbeddedEjb3TestCase.class);

    // a boolean to test if the container is running or not
    private static boolean                containerRunning = false;

    // the EJB3 deployer
    private static EJB3StandaloneDeployer deployer;

    // The remote interface
    private static UserServiceRemote      myServiceRemote;

    // private EntityManager em;
    //
    // private TransactionManager tm;

    // public EmbeddedEjb3TestCase()
    // {
    // super("EmbeddedEjb3TestCase");
    // }

    /**
     * This method is executed before the test methods. It starts the JBoss
     * Embedded Container
     * @throws Exception
     */
    @BeforeClass
    public static void oneTimeSetUp()
    {

        try
        {
            EmbeddedEjb3TestCase.startupEmbeddedContainer();

            /**
             * Create proxies to call the User Service
             */
            // final InitialContext initialContext = new InitialContext();
            final InitialContext initialContext = EmbeddedEjb3TestCase.getInitialContext();

            EmbeddedEjb3TestCase.myServiceRemote = (UserServiceRemote) initialContext.lookup("UserServiceBean/remote");

            // This is a transactionally aware EntityManager and must be accessed within a JTA transaction
            // Why aren't we using javax.persistence.Persistence? Well, our persistence.xml file uses
            // jta-datasource which means that it is created by the EJB container/embedded JBoss.
            // using javax.persistence.Persistence will just cause us an error
            // this.em = (EntityManager) initialContext.lookup("java:/EntityManagers/timetracker-ejb3");

            // Obtain JBoss transaction
            // this.tm = (TransactionManager) initialContext.lookup("java:/TransactionManager");

        }
        catch (final Exception ex)
        {
            EmbeddedEjb3TestCase.logger.error(ex.getMessage(), ex);
            // throw new RuntimeException(ex);
        }

    }

    @AfterClass
    public static void oneTimeTearDown()
    {

        try
        {
            EmbeddedEjb3TestCase.logger.info("==>Invoking EJB3.shutdown...");
            EmbeddedEjb3TestCase.deployer.stop();
            EmbeddedEjb3TestCase.deployer.destroy();

            EJB3StandaloneBootstrap.shutdown();

            EmbeddedEjb3TestCase.containerRunning = false;
        }
        catch (final Exception ex)
        {
            throw new RuntimeException(ex);
        }
    }

    /**
     * The method starts the container and creates a deployer
     * using the persistence.xml file
     *
     * @throws Exception
     */
    private static void startupEmbeddedContainer() throws Exception
    {
        if (!EmbeddedEjb3TestCase.containerRunning)
        {

            EmbeddedEjb3TestCase.logger.info("==>Bootstrapping EJB3 container...");

            // start EJB microcontainer
            // configuration files ejb3-interceptors-aop.xml and
            // embedded-jboss-beans.xml are used
            EJB3StandaloneBootstrap.boot(null);

            EmbeddedEjb3TestCase.logger.info("==>Deploying security-beans");
            EJB3StandaloneBootstrap.deployXmlResource("security-beans.xml");
            EmbeddedEjb3TestCase.logger.info("==>Deployed security-beans");

            /*
             * Create a deployer based on the persistence.xml file
             */
            EmbeddedEjb3TestCase.deployer = EJB3StandaloneBootstrap.createDeployer();
            EmbeddedEjb3TestCase.deployer.getArchivesByResource().add("META-INF/persistence.xml");
            // Deploy everything we got
            // this.deployer.setKernel(EJB3StandaloneBootstrap.getKernel());
            EmbeddedEjb3TestCase.deployer.create();
            EmbeddedEjb3TestCase.deployer.start();

            EmbeddedEjb3TestCase.containerRunning = true;

            EmbeddedEjb3TestCase.logger.info("==>End of bootstrapping EJB3 container");
        }
    }

    /**
     * call the remote interface
     */
    @Test
    public void testRemote()
    {
        System.out.println("Service Remote : " + EmbeddedEjb3TestCase.myServiceRemote);
        Assert.assertNotNull(EmbeddedEjb3TestCase.myServiceRemote);
        EmbeddedEjb3TestCase.logger.debug("Service Remote : " + EmbeddedEjb3TestCase.myServiceRemote);
    }

    @Test
    public void testEJBs() throws Exception
    {
        System.out.println("----------------------------------------------------------");
        System.out.println("This test create delete and find a user called testuser");
        System.out.print("    ");

        // Remote testuser if it already exists
        UserVO userVO = null;
        try
        {
            userVO = EmbeddedEjb3TestCase.myServiceRemote.getUser("testuser");
            if ((userVO != null) && (userVO.getId().longValue() > 0))
            {
                EmbeddedEjb3TestCase.myServiceRemote.removeUser(userVO);
            }
        }
        catch (final UserDoesNotExistException e)
        {
            EmbeddedEjb3TestCase.logger.debug("UserDoesNotExistException : " + e);
        }
        catch (final Exception e)
        {
            EmbeddedEjb3TestCase.logger.debug("Exception : " + e);
            Assert.fail();
        }

        // Add testuser
        UserDetailsVO udVO = new UserDetailsVO();
        udVO.setFirstName("testuser");
        udVO.setLastName("testuser");
        udVO.setEmail("test@test.com");
        udVO.setIsActive(false);
        udVO.setUsername("testuser");
        udVO.setPassword(PasswordEncoder.getMD5Base64EncodedPassword("testuser"));
        udVO.setCreationDate(new Date());
        final UserRoleVO urVO = new UserRoleVO();
        urVO.setRole(Role.STANDARD_USER);
        udVO.setRoles(new UserRoleVO[] { urVO });
        try
        {
            udVO = EmbeddedEjb3TestCase.myServiceRemote.registerUser(udVO);
            Assert.assertNotNull(udVO);
            Assert.assertTrue(udVO.getId().longValue() > 0);
            EmbeddedEjb3TestCase.logger.info("Registered new user: " + udVO.getFirstName() + ", " + udVO.getId());
            // Remote testuser if it already exists
            userVO = EmbeddedEjb3TestCase.myServiceRemote.getUser("testuser");
            if ((userVO != null) && (userVO.getId().longValue() > 0))
            {
                EmbeddedEjb3TestCase.myServiceRemote.removeUser(userVO);
            }
        }
        catch (final UserDoesNotExistException e)
        {
            EmbeddedEjb3TestCase.logger.debug("UserDoesNotExistException : " + e);
            Assert.fail();
        }
        catch (final Exception e)
        {
            EmbeddedEjb3TestCase.logger.debug("Exception : " + e);
            Assert.fail();
        }

        System.out.println("Successfully created and found testuser from @Remote interface");
        System.out.println("----------------------------------------------------------");
    }

    // public void testEntityManager() throws Exception
    // {
    //
    // final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MaBaseDeTestPU");
    //
    // final EntityManager em = emf.createEntityManager();
    //
    // final EntityTransaction transac = em.getTransaction();
    //
    // transac.begin();
    //
    // this.tm.begin();
    //
    // UserDao cust = new UserDao();
    // cust.setName("Bill");
    // this.em.persist(cust);
    //
    // Assert.assertTrue(cust.getId() > 0);
    //
    // final int id = cust.getId();
    //
    // System.out.println("created bill in DB with id: " + id);
    //
    // this.tm.commit();
    //
    // this.tm.begin();
    // cust = this.em.find(Customer.class, id);
    // Assert.assertNotNull(cust);
    // this.tm.commit();
    // }

    private static InitialContext initialContext        = null;
    private static InitialContext securedInitialContext = null;

    /**
     * Return a new InitialContext based on org.jnp.interfaces.LocalOnlyContextFactory,
     * setting the the default context.
     *
     * @return InitialContext
     * @throws Exception
     */
    public static InitialContext newInitialContext() throws Exception
    {
        final Hashtable<String, String> props = EmbeddedEjb3TestCase.getInitialContextProperties();
        EmbeddedEjb3TestCase.initialContext = new InitialContext(props);
        return EmbeddedEjb3TestCase.initialContext;
    }

    /**
     * Return a new InitialContext based on org.jboss.security.jndi.JndiLoginInitialContextFactory,
     * setting the default context. Use the specified username and password to set the security context.
     *
     * @param principal
     * @param credential
     * @return InitialContext
     * @throws Exception
     */
    public static InitialContext newInitialContext(final String principal, final String credential) throws Exception
    {
        final Hashtable<String, String> props = EmbeddedEjb3TestCase.getInitialContextProperties(principal, credential);
        EmbeddedEjb3TestCase.securedInitialContext = new InitialContext(props);
        return EmbeddedEjb3TestCase.securedInitialContext;
    }

    /**
     * Return the default InitialContext based on org.jnp.interfaces.LocalOnlyContextFactory
     * if one is already instantiated, otherwise create a new InitialContext and set as the default.
     *
     * @return InitialContext
     * @throws Exception
     */
    public static InitialContext getInitialContext() throws Exception
    {
        if (EmbeddedEjb3TestCase.initialContext == null)
        {
            final Hashtable<String, String> props = EmbeddedEjb3TestCase.getInitialContextProperties();
            EmbeddedEjb3TestCase.initialContext = new InitialContext(props);
        }
        return EmbeddedEjb3TestCase.initialContext;
    }

    /**
     * Return the default InitialContext based on org.jboss.security.jndi.JndiLoginInitialContextFactory
     * if one is already instantiated, otherwise create a new InitialContext and set as the default.
     * Use the specified username and password to set the security context.
     *
     * @param principal
     * @param credential
     * @return InitialContext
     * @throws Exception
     */
    public static InitialContext getInitialContext(final String principal, final String credential) throws Exception
    {
        if (EmbeddedEjb3TestCase.securedInitialContext == null)
        {
            final Hashtable<String, String> props = EmbeddedEjb3TestCase.getInitialContextProperties(principal, credential);
            EmbeddedEjb3TestCase.securedInitialContext = new InitialContext(props);
        }
        return EmbeddedEjb3TestCase.securedInitialContext;
    }

    private static Hashtable<String, String> getInitialContextProperties()
    {
        final Hashtable<String, String> props = new Hashtable<String, String>();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.LocalOnlyContextFactory");
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        return props;
    }

    private static Hashtable<String, String> getInitialContextProperties(final String principal, final String credential)
    {
        final Hashtable<String, String> props = new Hashtable<String, String>();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.security.jndi.JndiLoginInitialContextFactory");
        props.put(Context.SECURITY_PRINCIPAL, principal);
        props.put(Context.SECURITY_CREDENTIALS, credential);
        return props;
    }

}

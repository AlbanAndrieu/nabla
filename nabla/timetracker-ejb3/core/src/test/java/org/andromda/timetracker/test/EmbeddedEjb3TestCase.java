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

import javax.naming.InitialContext;

import junit.framework.TestCase;

import org.andromda.timetracker.service.UserServiceRemote;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.ejb3.embedded.EJB3StandaloneBootstrap;
import org.jboss.ejb3.embedded.EJB3StandaloneDeployer;

/**
 * DOCUMENT ME! Alban.
 *
 * @author $Author$
 * @version $Revision$
 *
 * @since $Date$
 *
 */
public class EmbeddedEjb3TestCase extends TestCase
{

    private static final Log       logger           = LogFactory.getLog(EmbeddedEjb3TestCase.class);

    // a boolean to test if the container is running or not
    private static boolean         containerRunning = false;

    // the EJB3 deployer
    private EJB3StandaloneDeployer deployer;

    // The remote interface
    private UserServiceRemote      myServiceRemote;

    // the local interface
    // private UserServiceLocal myServiceLocal;

    public EmbeddedEjb3TestCase()
    {
        super("EmbeddedEjb3TestCase");
    }

    /*
     * public static Test suite() throws Exception
     * {
     * final TestSuite suite = new TestSuite();
     * suite.addTestSuite(EmbeddedEjb3TestCase.class);
     * // setup test so that embedded JBoss is started/stopped once for all tests here.
     * final TestSetup wrapper = new TestSetup(suite)
     * {
     * @Override
     * protected void setUp()
     * {
     * EmbeddedEjb3TestCase.startupEmbeddedJboss();
     * }
     * @Override
     * protected void tearDown()
     * {
     * EmbeddedEjb3TestCase.shutdownEmbeddedJboss();
     * }
     * };
     * return wrapper;
     * }
     * public static void startupEmbeddedJboss()
     * {
     * try
     * {
     * // EJB3StandaloneBootstrap.boot("target/classes");
     * // EJB3StandaloneBootstrap.scanClasspath("target/test-classes");
     * EJB3StandaloneBootstrap.boot(null);
     * }
     * catch (final java.lang.IllegalArgumentException e)
     * {
     * EmbeddedEjb3TestCase.logger.error("Error with EJB3StandaloneBootstrap.scanClasspath");
     * }
     * }
     * public static void shutdownEmbeddedJboss()
     * {
     * EJB3StandaloneBootstrap.shutdown();
     * }
     */

    /**
     * This method is executed before the test methods. It starts the JBoss
     * Embedded Container
     * @throws Exception
     */
    @Override
    protected void setUp()
    {

        try
        {
            this.startupEmbeddedContainer();

            /**
             * Create proxies to call the User Service
             */
            final InitialContext initialContext = new InitialContext();

            // this.myServiceLocal = (UserServiceLocal) initialContext.lookup("UserServiceBean/local");
            this.myServiceRemote = (UserServiceRemote) initialContext.lookup("UserServiceBean/remote");
        }
        catch (final Exception ex)
        {
            EmbeddedEjb3TestCase.logger.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }

    }

    /**
     * The method starts the container and creates a deployer
     * using the persistence.xml file
     *
     * @throws Exception
     */
    private void startupEmbeddedContainer() throws Exception
    {
        if (!EmbeddedEjb3TestCase.containerRunning)
        {

            EmbeddedEjb3TestCase.logger.info("==>Bootstrapping EJB3 container...");

            // start EJB microcontainer
            // configuration files ejb3-interceptors-aop.xml and
            // embedded-jboss-beans.xml are used
            EJB3StandaloneBootstrap.boot(null);

            // EJB3StandaloneBootstrap.deployXmlResource("login-config.xml");

            EmbeddedEjb3TestCase.logger.info("==>Deploying security-beans");
            EJB3StandaloneBootstrap.deployXmlResource("security-beans.xml");
            EmbeddedEjb3TestCase.logger.info("==>Deployed security-beans");

            /*
             * Create a deployer based on the persistence.xml file
             */
            this.deployer = EJB3StandaloneBootstrap.createDeployer();
            this.deployer.getArchivesByResource().add("META-INF/persistence.xml");
            // Deploy everything we got
            this.deployer.setKernel(EJB3StandaloneBootstrap.getKernel());
            this.deployer.create();
            this.deployer.start();

            EmbeddedEjb3TestCase.containerRunning = true;

            EmbeddedEjb3TestCase.logger.info("==>End of bootstrapping EJB3 container");
        }
    }

    /**
     * call the remote interface
     */
    public void testRemote()
    {
        System.out.println("Service Remote : " + this.myServiceRemote);
        EmbeddedEjb3TestCase.logger.debug("Service Remote : " + this.myServiceRemote);
    }

    /*
     * public void testEJBs() throws Exception
     * {
     * // final InitialContext ctx = EmbeddedEjb3TestCase.getInitialContext();
     * // final UserServiceLocal local = (UserServiceLocal) ctx.lookup("UserServiceBean/local");
     * // final UserServiceRemote remote = (UserServiceRemote) ctx.lookup("UserServiceBean/remote");
     * System.out.println("----------------------------------------------------------");
     * System.out.println("This test scans the System Property java.class.path for all annotated EJB3 classes");
     * System.out.print("    ");
     * // int id = local.createCustomer("Gavin");
     * // Customer cust = local.findCustomer(id);
     * // Assert.assertNotNull(cust);
     * // System.out.println("Successfully created and found Gavin from @Local interface");
     * // Remote testuser if it already exists
     * UserVO userVO = null;
     * try
     * {
     * userVO = this.myServiceRemote.getUser("testuser");
     * if ((userVO != null) && (userVO.getId().longValue() > 0))
     * {
     * this.myServiceRemote.removeUser(userVO);
     * }
     * }
     * catch (final UserDoesNotExistException e)
     * {
     * // OK to avoid
     * }
     * // Add testuser
     * UserDetailsVO udVO = new UserDetailsVO();
     * udVO.setFirstName("testuser");
     * udVO.setLastName("testuser");
     * udVO.setEmail("test@test.com");
     * udVO.setIsActive(false);
     * udVO.setUsername("testuser");
     * udVO.setPassword(PasswordEncoder.getMD5Base64EncodedPassword("testuser"));
     * udVO.setCreationDate(new Date());
     * final UserRoleVO urVO = new UserRoleVO();
     * urVO.setRole(Role.STANDARD_USER);
     * udVO.setRoles(new UserRoleVO[] { urVO });
     * udVO.setRoles(new UserRoleVO[] { urVO });
     * try
     * {
     * udVO = this.myServiceRemote.registerUser(udVO);
     * assert udVO != null;
     * assert udVO.getId().longValue() > 0;
     * EmbeddedEjb3TestCase.logger.info("Registered new user: " + udVO.getFirstName() + ", " + udVO.getId());
     * // Remote testuser if it already exists
     * userVO = this.myServiceRemote.getUser("testuser");
     * if ((userVO != null) && (userVO.getId().longValue() > 0))
     * {
     * this.myServiceRemote.removeUser(userVO);
     * }
     * }
     * catch (final UserDoesNotExistException e)
     * {
     * // OK to avoid
     * }
     * // id = remote.createCustomer("Emmanuel");
     * // cust = remote.findCustomer(id);
     * // Assert.assertNotNull(cust);
     * System.out.println("Successfully created and found testuser from @Remote interface");
     * System.out.println("----------------------------------------------------------");
     * }
     */

    // public void testEntityManager() throws Exception
    // {
    // // This is a transactionally aware EntityManager and must be accessed within a JTA transaction
    // // Why aren't we using javax.persistence.Persistence? Well, our persistence.xml file uses
    // // jta-datasource which means that it is created by the EJB container/embedded JBoss.
    // // using javax.persistence.Persistence will just cause us an error
    // final EntityManager em = (EntityManager) EmbeddedEjb3TestCase.getInitialContext().lookup("java:/EntityManagers/timetracker-ejb3");
    //
    // // Obtain JBoss transaction
    // final TransactionManager tm = (TransactionManager) EmbeddedEjb3TestCase.getInitialContext().lookup("java:/TransactionManager");
    //
    // tm.begin();
    //
    // UserDao cust = new UserDao();
    // cust.setName("Bill");
    // em.persist(cust);
    //
    // Assert.assertTrue(cust.getId() > 0);
    //
    // final int id = cust.getId();
    //
    // System.out.println("created bill in DB with id: " + id);
    //
    // tm.commit();
    //
    // tm.begin();
    // cust = em.find(Customer.class, id);
    // Assert.assertNotNull(cust);
    // tm.commit();
    // }

    /*
     * public static InitialContext getInitialContext() throws Exception
     * {
     * final Hashtable props = EmbeddedEjb3TestCase.getInitialContextProperties();
     * return new InitialContext(props);
     * }
     * private static Hashtable getInitialContextProperties()
     * {
     * final Hashtable props = new Hashtable();
     * props.put("java.naming.factory.initial", "org.jnp.interfaces.LocalOnlyContextFactory");
     * props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
     * return props;
     * }
     */
}

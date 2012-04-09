// license-header java merge-point
//
// Generated by test/SessionTest.vsl in andromda-ejb3-cartridge on 03/29/2012 12:08:36.
//
package org.andromda.timetracker.service.test;

import java.util.Date;
import java.util.Properties;

import javax.naming.NamingException;

import org.andromda.timetracker.ServiceLocator;
import org.andromda.timetracker.domain.Role;
import org.andromda.timetracker.security.PasswordEncoder;
import org.andromda.timetracker.service.UserDoesNotExistException;
import org.andromda.timetracker.service.UserServiceLocal;
import org.andromda.timetracker.service.UserServiceRemote;
import org.andromda.timetracker.test.EJB3Container;
import org.andromda.timetracker.vo.UserDetailsVO;
import org.andromda.timetracker.vo.UserRoleVO;
import org.andromda.timetracker.vo.UserVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Service test class UserServiceTest for testing with TestNG
 * Check the testng.xml for initialisation of the EJB3Container before running any tests.
 */
public class UserServiceTest
{
    private static final Log logger = LogFactory.getLog(UserServiceTest.class);

    @BeforeTest
    public void startup() throws Exception
    {
        EJB3Container.startupEmbeddedContainer();

    }

    /**
     * The method is executed after lunching all tests methods.
     * It stops and destroys the EJB3 deployer and shuts down the container
     * @throws Exception
     */
    @AfterClass
    public void terminate() throws Exception
    {
        EJB3Container.stopEmbeddedContainer();
    }

    @Test
    public void testSimpleLookupService()
    {
        UserServiceLocal userService;
        try
        {
            userService = (UserServiceLocal) EJB3Container.getInitialContext().lookup("UserServiceBean/local");
            UserServiceTest.logger.debug("Service : " + userService.toString());
            Assert.assertNotNull(userService);
        }
        catch (final NamingException e)
        {
            UserServiceTest.logger.debug("NamingException : " + e);
            // Warning : Receive timed out error within eclipse because embedded Jboss container not started
            Assert.fail();
        }
        catch (final Exception e)
        {
            UserServiceTest.logger.debug("Exception : " + e);
            Assert.fail();
        }

    }

    // @Test
    public void testOtherLookupPathRemoteService()
    {
        UserServiceRemote userService;
        try
        {
            userService = ServiceLocator.getInstance().getUserService();
            UserServiceTest.logger.debug("Service : " + userService.toString());
            Assert.assertNotNull(userService);
            userService = ServiceLocator.getInstance().get_org_andromda_timetracker_service_UserServiceBean_Remote(null);
            UserServiceTest.logger.debug("Service : " + userService.toString());
            Assert.assertNotNull(userService);
        }
        catch (final NamingException e)
        {
            UserServiceTest.logger.debug("NamingException : " + e);
            Assert.fail();
        }
        catch (final Exception e)
        {
            UserServiceTest.logger.debug("Exception : " + e);
            Assert.fail();
        }

    }

    @Test
    public void testServiceLocatorLookupPathRemoteService()
    {
        UserServiceRemote userService;
        try
        {
            final Properties prop = new Properties();
            prop.putAll(EJB3Container.getInitialContextProperties());
            userService = ServiceLocator.getInstance().get_org_andromda_timetracker_service_UserServiceBean_Remote(prop);
            UserServiceTest.logger.debug("Service : " + userService.toString());
            Assert.assertNotNull(userService);
        }
        catch (final NamingException e)
        {
            UserServiceTest.logger.debug("NamingException : " + e);
            Assert.fail();
        }
        catch (final Exception e)
        {
            UserServiceTest.logger.debug("Exception : " + e);
            Assert.fail();
        }

    }

    @Test
    public void testSecureService()
    {
        UserServiceLocal userService;
        try
        {
            userService = (UserServiceLocal) EJB3Container.getInitialContext("user", "password").lookup("UserServiceBean/local");
            UserServiceTest.logger.debug("Service : " + userService.toString());
            Assert.assertNotNull(userService);
        }
        catch (final NamingException e)
        {
            UserServiceTest.logger.debug("NamingException : " + e);
            Assert.fail();
        }
        catch (final Exception e)
        {
            UserServiceTest.logger.debug("Exception : " + e);
            Assert.fail();
        }

    }

    // @Test
    public void testGetUser()
    {
        // try
        // {
        // org.andromda.timetracker.service.UserServiceRemote userService = (org.andromda.timetracker.service.UserServiceRemote)EJB3Container.getInitialContext().lookup("UserServiceBean/remote");
        // test implementation
        // }
        // catch (Exception ex)
        // {
        // logger.warn("Failed test testGetUser()", ex);
        // }
    }

    /**
     *
     * See Junit test EmbeddedEjb3TestCase.
     *
     */
    @Test
    public void testRegisterUser()
    {
        try
        {

            // final UserServiceRemote userService = (UserServiceRemote) EJB3Container.getInitialContext("user", "password").lookup("UserServiceBean/remote");
            final UserServiceLocal userService = (UserServiceLocal) EJB3Container.getInitialContext().lookup("UserServiceBean/local");

            // Remote testuser if it already exists
            UserVO userVO = null;
            try
            {
                userVO = userService.getUser("testuser");
                if ((userVO != null) && (userVO.getId().longValue() > 0))
                {
                    userService.removeUser(userVO);
                }
            }
            catch (final UserDoesNotExistException e)
            {
                UserServiceTest.logger.debug("UserDoesNotExistException : " + e);
            }
            catch (final Exception e)
            {
                UserServiceTest.logger.debug("Exception : " + e);
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

            udVO = userService.registerUser(udVO);

            Assert.assertNotNull(udVO);
            Assert.assertTrue(udVO.getId().longValue() > 0);

            UserServiceTest.logger.info("Registered new user: " + udVO.getFirstName() + ", " + udVO.getId());
            try
            {
                // Remove testuser if it already exists

                userVO = userService.getUser("testuser");
                if ((userVO != null) && (userVO.getId().longValue() > 0))
                {
                    userService.removeUser(userVO);
                }
            }
            catch (final UserDoesNotExistException e)
            {
                UserServiceTest.logger.debug("UserDoesNotExistException : " + e);
                Assert.fail();
            }
        }
        catch (final Exception ex)
        {
            UserServiceTest.logger.warn("Failed test testRegisterUser()", ex);
            Assert.fail();
        }
    }

    // @Test
    public void testRemoveUser()
    {
        // try
        // {
        // org.andromda.timetracker.service.UserServiceRemote userService = (org.andromda.timetracker.service.UserServiceRemote)EJB3Container.getInitialContext().lookup("UserServiceBean/remote");
        // test implementation
        // }
        // catch (Exception ex)
        // {
        // logger.warn("Failed test testRemoveUser()", ex);
        // }
    }

    @Test
    public void testGetAllUsers() throws NamingException, Exception
    {

        final UserServiceRemote userService = (UserServiceRemote) EJB3Container.getInitialContext("user", "password").lookup("UserServiceBean/remote");

        try
        {
            final UserVO[] users = userService.getAllUsers();
            Assert.assertTrue(users.length > 0);

            for (final UserVO userVO : users)
            {
                UserServiceTest.logger.info("user : " + userVO.getFirstName());
            }
        }
        catch (final Exception ex)
        {
            UserServiceTest.logger.warn("Failed test testGetAllUsers()", ex);
            // if reached that means that database is empty and default values have not been inserted
            Assert.fail();
        }
    }

}

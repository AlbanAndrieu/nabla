package org.andromda.timetracker.service;

import java.util.Date;

import org.andromda.timetracker.ServiceLocator;
import org.andromda.timetracker.domain.Role;
import org.andromda.timetracker.security.PasswordEncoder;
import org.andromda.timetracker.vo.UserDetailsVO;
import org.andromda.timetracker.vo.UserRoleVO;
import org.andromda.timetracker.vo.UserVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class UserServiceTest
{
    private final Log   logger = LogFactory.getLog(UserServiceTest.class);

    private UserService userService;

    /**
     * Initialize test suite
     */
    @BeforeSuite
    public void initializeTestSuite()
    {
        // Initialize ServiceLocator
        this.logger.info("Initializing ServiceLocator");
        final ServiceLocator locator = ServiceLocator.instance();
        locator.init("testBeanRefFactory.xml", "beanRefFactory");

        // Initialize UserService
        this.logger.info("Initializing UserService");
        this.userService = locator.getUserService();
    }

    @org.testng.annotations.Test
    public void testRegisterUser()
    {
        try
        {

            // Remote testuser if it already exists
            UserVO userVO = null;
            try
            {
                userVO = this.userService.getUser("testuser");
                if ((userVO != null) && (userVO.getId().longValue() > 0))
                {
                    this.userService.removeUser(userVO);
                }
            } catch (final UserDoesNotExistException e)
            {
                // OK to avoid
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

            udVO.setRoles(new UserRoleVO[]
            { urVO });

            udVO = this.userService.registerUser(udVO);

            Assert.assertNotNull(udVO);
            Assert.assertTrue(udVO.getId().longValue() > 0);

            this.logger.info("Registered new user: " + udVO.getFirstName() + ", " + udVO.getId());

            // Remote testuser if it already exists
            try
            {
                userVO = this.userService.getUser("testuser");
                if ((userVO != null) && (userVO.getId().longValue() > 0))
                {
                    this.userService.removeUser(userVO);
                }
            } catch (final UserDoesNotExistException e)
            {
                this.logger.info("OK to avoid");
            }

        } catch (final Exception ex)
        {
            this.logger.warn("Failed test testRegisterUser()", ex);
            Assert.fail();
        }
    }

    @Test
    public void testGetAllUsers()
    {
        try
        {
            this.logger.info("testGetAllUsers:");
            final UserVO[] users = this.userService.getAllUsers();
            Assert.assertTrue(users.length > 0);

            for (final UserVO userVO : users)
            {
                this.logger.info("user : " + userVO.getFirstName());
            }
        } catch (final Exception ex)
        {
            this.logger.warn("Failed test testGetAllUsers()", ex);
            Assert.fail();
        }
    }
}

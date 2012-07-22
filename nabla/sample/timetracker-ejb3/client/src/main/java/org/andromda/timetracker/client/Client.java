package org.andromda.timetracker.client;

import java.util.Date;
import java.util.Properties;

import org.andromda.timetracker.domain.Role;
import org.andromda.timetracker.service.UserDoesNotExistException;
import org.andromda.timetracker.service.UserServiceDelegate;
import org.andromda.timetracker.vo.UserDetailsVO;
import org.andromda.timetracker.vo.UserRoleVO;
import org.andromda.timetracker.vo.UserVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Client
{
    private final Log  logger = LogFactory.getLog(Client.class);

    private Properties prop;

    public void init()
    {
        this.prop = new Properties();
        this.prop.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        this.prop.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        this.prop.put("java.naming.provider.url", "localhost");
    }

    public void getAllUsersAsVO()
    {
        System.out.println("Getting all users...");

        UserVO[] users = null;

        final UserServiceDelegate usd = new UserServiceDelegate(this.prop);
        try
        {
            users = usd.getAllUsers();
        }
        catch (final UserDoesNotExistException e)
        {
            this.logger.debug("UserDoesNotExistException catched", e);
        }
        finally
        {
            if (usd != null)
            {
                usd.close();
            }
        }

        if ((users != null) && (users.length > 0))
        {
            for (final UserVO userVO : users)
            {
                System.out.println("user: " + userVO.toString() + " - " + userVO.getId());
            }
        }

        System.out.println("Got all users complete.");
    }

    public void addUser()
    {
        final UserDetailsVO userDetailsVO = new UserDetailsVO();
        userDetailsVO.setFirstName("vance");
        userDetailsVO.setLastName("Karimi");
        userDetailsVO.setUsername("vancek");
        userDetailsVO.setPassword("monkey1");
        userDetailsVO.setEmail("test@test.com");
        userDetailsVO.setIsActive(true);
        userDetailsVO.setCreationDate(new Date());

        final UserRoleVO[] roles = new UserRoleVO[1];
        roles[0] = new UserRoleVO();
        roles[0].setRole(Role.ADMINISTRATOR);

        userDetailsVO.setRoles(roles);

        UserServiceDelegate usd = null;
        try
        {
            usd = new UserServiceDelegate(this.prop);
            usd.registerUser(userDetailsVO);
        }
        catch (final UserDoesNotExistException e)
        {
            this.logger.debug("UserDoesNotExistException catched", e);
        }
        finally
        {
            if (usd != null)
            {
                usd.close();
            }
        }
    }
}

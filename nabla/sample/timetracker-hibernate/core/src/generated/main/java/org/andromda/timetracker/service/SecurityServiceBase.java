// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringServiceBase.vsl in andromda-spring-cartridge.
//
/**
 * TEMPLATE:    SpringServiceBase.vsl in andromda-spring cartridge
 * MODEL CLASS: TimeTracker::TimeTracker::org.andromda.timetracker::service::SecurityService
 * STEREOTYPE:  Service
 */
package org.andromda.timetracker.service;

import java.security.Principal;
import java.util.Locale;
import org.andromda.timetracker.BeanLocator;
import org.andromda.timetracker.PrincipalStore;
import org.andromda.timetracker.domain.UserDao;
import org.andromda.timetracker.vo.UserDetailsVO;
import org.springframework.context.MessageSource;

/**
 * <p>
 * Spring Service base class for <code>SecurityService</code>,
 * provides access to all services and entities referenced by this service.
 * </p>
 *
 * @see SecurityService
 */
public abstract class SecurityServiceBase
    implements SecurityService
{
    private UserDao userDao;

    /**
     * Sets the reference to <code>user</code>'s DAO.
     * @param userDaoIn
     */
    public void setUserDao(UserDao userDaoIn)
    {
        this.userDao = userDaoIn;
    }

    /**
     * Gets the reference to <code>user</code>'s DAO.
     * @return userDao
     */
    protected UserDao getUserDao()
    {
        return this.userDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDetailsVO getUserDetails(final String username)
    {
        if (username == null || username.trim().length() == 0)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.service.SecurityService.getUserDetails(String username) - 'username' can not be null or empty");
        }
        try
        {
            return this.handleGetUserDetails(username);
        }
        catch (Throwable th)
        {
            throw new SecurityServiceException(
                "Error performing 'SecurityService.getUserDetails(String username)' --> " + th,
                th);
        }
    }

    /**
     * Performs the core logic for {@link #getUserDetails(String)}
     * @param username String TODO: Model Documentation for
SecurityService.getUserDetails(username)
     * @return UserDetailsVO
     * @throws Exception
     */
    protected abstract UserDetailsVO handleGetUserDetails(String username)
        throws Exception;

    /**
     * Gets the current <code>principal</code> if one has been set,
     * otherwise returns <code>null</code>.
     *
     * @return the current principal
     */
    protected Principal getPrincipal()
    {
        return PrincipalStore.get();
    }

    /**
     * Gets the message source available to this service.
     * @return MessageSource
     */
    protected MessageSource getMessages()
    {
        return (MessageSource)
            BeanLocator.instance().getBean("messageSource");
    }

    /**
     * Gets the message having the given <code>key</code> in the underlying message bundle.
     *
     * @param key the key of the message in the messages.properties message bundle.
     * @return String
     */
    protected String getMessage(final String key)
    {
        return this.getMessages().getMessage(key, null, null);
    }

    /**
     * Gets the message having the given <code>key</code> and <code>arguments</code> in the
     * underlying message bundle.
     *
     * @param key the key of the message in the messages.properties message bundle.
     * @param arguments any arguments to substitute when resolving the message.
     * @return String
     */
    protected String getMessage(final String key, final Object[] arguments)
    {
        return this.getMessages().getMessage(key, arguments, null);
    }

    /**
     * Gets the message having the given <code>key</code> using the given <code>arguments</code>
     * for the given <code>locale</code>.
     *
     * @param key the key of the message in the messages.properties message bundle.
     * @param arguments any arguments to substitute when resolving the message.
     * @param locale the locale of the messages to retrieve.
     * @return String
     */
    protected String getMessage(
        final String key, final Object[] arguments,
        final Locale locale)
    {
        return this.getMessages().getMessage(key, arguments, locale);
    }

}
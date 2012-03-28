// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by SessionBeanBase.vsl in andromda-ejb3-cartridge on 03/27/2012 13:19:38.
//
package org.andromda.timetracker.service;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.andromda.timetracker.domain.UserDao;
import org.andromda.timetracker.vo.UserDetailsVO;

/**
 * Autogenerated EJB3 session bean base class SecurityServiceBean which contains
 * method level annotations for the session bean.  All method level annotations
 * are inherited by the extending session bean class.
 *
 */
// @SecurityDomain("timetracker-ejb3")
public abstract class SecurityServiceBase implements SecurityService
{
    // ------ Session Context Injection ------

    @Resource
    protected SessionContext context;

    // ------ Persistence Context Definitions --------

    /**
     * Inject persistence context timetracker-ejb3
     */
    @PersistenceContext(unitName = "timetracker-ejb3")
    protected EntityManager  emanager;

    // ------ DAO Injection Definitions --------

    /**
     * Inject DAO UserDao
     */
    @EJB
    private UserDao          userDao;

    // --------------- Constructors ---------------

    public SecurityServiceBase()
    {
        super();
    }

    // ------ DAO Getters --------

    /**
     * Get the injected DAO UserDao
     */
    protected UserDao getUserDao()
    {
        return this.userDao;
    }

    // -------- Business Methods --------------

    /**
     *
     */
    @PermitAll
    public UserDetailsVO getUserDetails(final String username)
    {
        if (username == null)
        {
            throw new IllegalArgumentException("org.andromda.timetracker.service.SecurityServiceBean.getUserDetails(String username) - 'username' can not be null");
        }
        try
        {
            return this.handleGetUserDetails(username);
        }
        catch (final Throwable th)
        {
            throw new SecurityServiceException("Error performing 'SecurityService.getUserDetails(String username)' --> " + th, th);
        }
    }

    /**
     * Performs the core logic for {@link #getUserDetails(String)}
     */
    protected abstract UserDetailsVO handleGetUserDetails(String username) throws Exception;

    // -------- Lifecycle Callbacks --------------

}

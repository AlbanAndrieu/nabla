package org.andromda.timetracker.service;

import static org.jboss.seam.ScopeType.SESSION;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.domain.UserRole;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

@Stateless
@Name("authenticator")
public class AuthenticatorAction implements Authenticator
{

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AuthenticatorAction.class);

    @org.jboss.seam.annotations.Logger
    private org.jboss.seam.log.Log               log;

    @In
    Identity                                     identity;
    @In
    Credentials                                  credentials;

    @In
    private EntityManager                        entityManager;

    @Out(required = false, scope = SESSION)
    private User                                 user;

    // @EJB
    // private UserDao userDao;

    /**
     * Get the injected DAO UserDao
     */
    // protected UserDao getUserDao()
    // {
    // return this.userDao;
    // }

    @Override
    public boolean authenticate()
    {
        AuthenticatorAction.logger.debug("Authenticating username : " + this.credentials.getUsername());

        this.log.info("Authenticating : {0}", this.credentials.getUsername());
        logger.debug("Authenticating password : " + this.credentials.getPassword());

        return this.authenticate(this.credentials.getUsername(), this.credentials.getPassword(), null);

    }

    @Override
    public boolean authenticate(final String username, final String password, final Set<String> roles)
    {
        AuthenticatorAction.logger.info("Authenticating username : " + username);
        AuthenticatorAction.logger.debug("Authenticating password : " + password);

        if (this.credentials != null)
        {
            AuthenticatorAction.logger.debug("Authenticating credentials : " + this.credentials);
        } else
        {
            AuthenticatorAction.logger.warn("Authenticating credentials is null");
        }

        final List<User> results = this.entityManager.createQuery("select u from User u where u.username=:username and u.password=:password").setParameter("username", username).setParameter("password", password)
                .getResultList();

        if (results.size() == 0)
        {
            AuthenticatorAction.logger.debug("Authenticating no result found for : " + username);

            // write your authentication logic here,
            // return true if the authentication was
            // successful, false otherwise
            if ("admin".equals(username))
            {
                this.identity.addRole("admin");
                return true;
            }

            return false;
        } else
        {
            this.user = results.get(0);
            if (this.user.getPassword().equals(password))
            {

                // this.getUserDao().toUserDetailsVO(this.user);

                if ((roles != null) && (this.user.getRoles() != null))
                {
                    for (final UserRole mr : this.user.getRoles())
                    {
                        AuthenticatorAction.logger.debug("Authenticating add role : " + mr.getRole().getValue() + " for user : " + username);
                        this.identity.addRole(mr.getRole().getValue());
                        roles.add(mr.getRole().getValue());
                    }
                }

                return true;
            } else
            {
                AuthenticatorAction.logger.debug("Authenticating no credential found for : " + username);

                // write your authentication logic here,
                // return true if the authentication was
                // successful, false otherwise
                if ("admin".equals(username))
                {
                    this.identity.addRole("admin");
                    return true;
                }

                return false;
            }
        }
    }

}

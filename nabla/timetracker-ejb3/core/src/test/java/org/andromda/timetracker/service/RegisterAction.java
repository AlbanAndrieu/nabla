package org.andromda.timetracker.service;

import static org.jboss.seam.ScopeType.EVENT;

import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.andromda.timetracker.domain.User;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;

@Stateful
@Scope(EVENT)
@Name("register")
// @Interceptors(SeamInterceptor.class)
public class RegisterAction implements Register
{

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RegisterAction.class);

    // @In
    private User                                 user;

    // @PersistenceContext
    private EntityManager                        entityManager;

    @In
    private FacesMessages                        facesMessages;

    private String                               verify;

    private boolean                              registered;

    @Override
    @In
    public void setUser(final User user)
    {
        this.user = user;
    }

    @Override
    @PersistenceContext
    public void setEntityManager(final EntityManager em)
    {
        this.entityManager = em;
    }

    @Override
    public String register()
    {
        RegisterAction.logger.debug("changePassword verify : " + this.verify);
        // RegisterAction.logger.debug("changePassword Username : " + Identity.instance().getUsername());

        RegisterAction.logger.debug("changePassword password : " + this.user.getPassword());

        if (this.user.getPassword().equals(this.verify))
        {
            final List existing = this.entityManager.createQuery("select u.username from User u where u.username=#{user.username}").getResultList();
            if (existing.size() == 0)
            {
                this.entityManager.persist(this.user);
                RegisterAction.logger.debug("register user updated : " + this.user.getUsername());
                this.facesMessages.add("Successfully registered as #{user.username}");
                this.registered = true;
                return "success";
            } else
            {
                RegisterAction.logger.debug("revertUser Username : " + this.user.getUsername() + "already exists");
                this.facesMessages.addToControl("username", "Username #{user.username} already exists");
            }
        } else
        {
            this.facesMessages.addToControl("verify", "Re-enter your password");
            this.verify = null;
        }
        return null;
    }

    @Override
    public void invalid()
    {
        this.facesMessages.add("Please try again");
    }

    @Override
    public boolean isRegistered()
    {
        return this.registered;
    }

    @Override
    public String getVerify()
    {
        return this.verify;
    }

    @Override
    public void setVerify(final String verify)
    {
        this.verify = verify;
    }

    @Override
    @Remove
    public void destroy()
    {
    }
}

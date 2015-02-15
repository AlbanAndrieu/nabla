package org.andromda.timetracker.action;

import static org.jboss.seam.ScopeType.EVENT;

import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.andromda.timetracker.domain.User;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.JndiName;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;

@Stateful
@Scope(EVENT)
@Name("register")
// @Restrict("#{identity.loggedIn}")
// @Interceptors(SeamInterceptor.class)
@JndiName("java:app/core/RegisterAction")
public class RegisterAction implements Register
{

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RegisterAction.class);

    // @In
    private User                                 user;

    @PersistenceContext
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
    @In
    public void setEntityManager(final EntityManager em)
    {
        entityManager = em;
    }

    @Override
    public String register()
    {
        RegisterAction.logger.debug("register verify : " + verify);
        // RegisterAction.logger.debug("changePassword Username : " + Identity.instance().getUsername());

        RegisterAction.logger.debug("register password : " + user.getPassword());

        if (user.getPassword().equals(verify))
        {
            RegisterAction.logger.debug("register Username : " + user.getUsername());

            // final List existing = this.entityManager.createQuery("select u.username from User u where u.username=#{user.username}").getResultList();
            final List existing = entityManager.createQuery("select u.username from User u where u.username=:username").setParameter("username", user.getUsername()).getResultList();
            if (existing.size() == 0)
            {
                entityManager.persist(user);
                RegisterAction.logger.debug("register user updated : " + user.getUsername());
                facesMessages.add("Successfully registered as #{user.username}");
                registered = true;
                return "success";
            } else
            {
                RegisterAction.logger.debug("revertUser Username : " + user.getUsername() + " already exists");
                // this.facesMessages.addToControl("username", "Username #{user.username} already exists");
            }
        } else
        {
            facesMessages.addToControl("verify", "Re-enter your password");
            verify = null;
        }
        return null;
    }

    @Override
    public void invalid()
    {
        facesMessages.add("Please try again");
    }

    @Override
    public boolean isRegistered()
    {
        return registered;
    }

    @Override
    public String getVerify()
    {
        return verify;
    }

    @Override
    public void setVerify(final String verify)
    {
        this.verify = verify;
    }

    @Override
    @Remove
    @Destroy
    public void destroy()
    {
    }
}

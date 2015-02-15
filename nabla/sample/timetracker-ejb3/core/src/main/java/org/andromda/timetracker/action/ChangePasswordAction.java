package org.andromda.timetracker.action;

import static org.jboss.seam.ScopeType.EVENT;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.andromda.timetracker.domain.User;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.JndiName;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.security.Restrict;
import org.jboss.seam.ejb.SeamInterceptor;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.security.Identity;

@Stateful
@Scope(EVENT)
@Name("changePassword")
@Restrict("#{identity.loggedIn}")
@Interceptors(SeamInterceptor.class)
@JndiName("java:app/core/ChangePasswordAction")
public class ChangePasswordAction implements ChangePassword
{

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ChangePasswordAction.class);

    @In
    /* (create = true) */
    // @Out
    // @Valid
    @Out(required = false, scope = org.jboss.seam.ScopeType.SESSION)
    private User                                 user;

    // @PersistenceContext(unitName = "timetracker-ejb3")
    // @In
    @PersistenceContext
    private EntityManager                        entityManager;

    private String                               verify;

    private boolean                              changed;

    @In
    private FacesMessages                        facesMessages;

    @Override
    public void changePassword()
    {

        ChangePasswordAction.logger.debug("changePassword verify : " + verify);
        ChangePasswordAction.logger.debug("changePassword Username : " + Identity.instance().getUsername());
        // ChangePasswordAction.logger.debug("changePassword Password : " + Identity.instance().getPassword());

        ChangePasswordAction.logger.debug("changePassword password : " + user.getPassword());

        if (user.getPassword().equals(verify))
        {
            user = entityManager.merge(user);
            ChangePasswordAction.logger.debug("changePassword password updated to : " + user.getPassword());
            facesMessages.add("Password updated");
            changed = true;
        } else
        {
            facesMessages.addToControl("verify", "Re-enter new password");
            this.revertUser();
            verify = null;
            changed = false;
        }
    }

    @Override
    public boolean isChanged()
    {
        return changed;
    }

    private void revertUser()
    {
        ChangePasswordAction.logger.debug("revertUser Username : " + user.getUsername());

        user = (User) entityManager.createQuery("select u from User u where u.username=:username").setParameter("username", user.getUsername()).getSingleResult();
        // this.user = this.entityManager.find(User.class, this.user.getUsername());
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

    /**
     * DOCUMENT ME! Alban.
     * 
     * @return the user
     */
    @Override
    public User getUser()
    {
        return user;
    }

    /**
     * DOCUMENT ME! Alban.
     * 
     * @param user the user to set
     */
    public void setUser(final User user)
    {
        this.user = user;
    }

    @Override
    @Remove
    @Destroy
    public void destroy()
    {
    }
}

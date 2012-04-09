package org.jboss.seam.example.booking;

import static org.jboss.seam.ScopeType.EVENT;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.andromda.timetracker.domain.User;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.security.Restrict;
import org.jboss.seam.faces.FacesMessages;

@Stateful
@Scope(EVENT)
@Name("changePassword")
@Restrict("#{identity.loggedIn}")
public class ChangePasswordAction implements ChangePassword
{
    @In
    @Out
    private User          user;

    // @PersistenceContext(unitName = "timetracker-ejb3")
    @PersistenceContext(unitName = "core-test")
    private EntityManager em;

    private String        verify;

    private boolean       changed;

    @In
    private FacesMessages facesMessages;

    // @Override
    public void changePassword()
    {
        if (this.user.getPassword().equals(this.verify))
        {
            this.user = this.em.merge(this.user);
            this.facesMessages.add("Password updated");
            this.changed = true;
        } else
        {
            this.facesMessages.addToControl("verify", "Re-enter new password");
            this.revertUser();
            this.verify = null;
        }
    }

    // @Override
    public boolean isChanged()
    {
        return this.changed;
    }

    private void revertUser()
    {
        this.user = this.em.find(User.class, this.user.getUsername());
    }

    // @Override
    public String getVerify()
    {
        return this.verify;
    }

    // @Override
    public void setVerify(final String verify)
    {
        this.verify = verify;
    }

    // @Override
    @Remove
    public void destroy()
    {
    }
}

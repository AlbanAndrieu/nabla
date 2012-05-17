package org.andromda.timetracker.action;

import javax.ejb.Local;
import javax.persistence.EntityManager;

import org.andromda.timetracker.domain.User;

@Local
public interface Register
{
    public void setUser(final User user);

    public void setEntityManager(EntityManager em);

    public String register();

    public void invalid();

    public String getVerify();

    public void setVerify(String verify);

    public boolean isRegistered();

    public void destroy();
}

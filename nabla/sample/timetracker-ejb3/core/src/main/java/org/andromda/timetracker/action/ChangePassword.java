package org.andromda.timetracker.action;

import javax.ejb.Local;

import org.andromda.timetracker.domain.User;

@Local
public interface ChangePassword
{
    public User getUser();

    public void changePassword();

    public boolean isChanged();

    public String getVerify();

    public void setVerify(String verify);

    public void destroy();
}

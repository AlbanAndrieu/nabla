package org.andromda.timetracker.service;

import javax.ejb.Local;

import org.andromda.timetracker.domain.User;

@Local
public interface ChangePassword
{
    public void changePassword();

    public boolean isChanged();

    public String getVerify();

    public void setVerify(String verify);

    public User getUser();

    public void destroy();
}

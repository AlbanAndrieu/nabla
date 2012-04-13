package org.andromda.timetracker.service;

import javax.ejb.Local;

import org.andromda.timetracker.domain.User;

@Local
public interface SimpleService
{
    User getUser();

    void loadUser(String username);

    public void destroy();
}

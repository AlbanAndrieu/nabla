package org.andromda.timetracker.action;

import java.util.Set;

import javax.ejb.Local;

@Local
public interface Authenticator
{
    boolean authenticate();

    boolean authenticate(final String username, final String password, final Set<String> roles);
}

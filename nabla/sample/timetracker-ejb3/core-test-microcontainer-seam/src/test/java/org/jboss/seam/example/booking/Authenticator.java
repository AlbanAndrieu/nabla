package org.jboss.seam.example.booking;

import java.util.Set;

//@Local
public interface Authenticator
{
    boolean authenticate();

    boolean authenticate(final String username, final String password, final Set<String> roles);
}

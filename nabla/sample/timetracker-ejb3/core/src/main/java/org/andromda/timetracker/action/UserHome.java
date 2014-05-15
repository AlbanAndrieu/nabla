package org.andromda.timetracker.action;

import org.andromda.timetracker.domain.User;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("userHome")
public class UserHome extends EntityHome<User>
{

    public void setUserId(Long id)
    {
        setId(id);
    }

    public Long getUserId()
    {
        return (Long) getId();
    }

    @Override
    protected User createInstance()
    {
        User user = new User();
        return user;
    }

    public void load()
    {
        if (isIdDefined())
        {
            wire();
        }
    }

    public void wire()
    {
        getInstance();
    }

    public boolean isWired()
    {
        return true;
    }

    public User getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

}

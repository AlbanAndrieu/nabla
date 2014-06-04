package org.andromda.timetracker.action;

import java.util.Arrays;

import org.andromda.timetracker.domain.User;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

@Name("userList")
public class UserList extends EntityQuery<User>
{
    private static final long     serialVersionUID = 1L;

    private static final String   EJBQL            = "select user from User user";

    private static final String[] RESTRICTIONS     =
                                                   { "lower(user.comment) like lower(concat(#{userList.user.comment},'%'))", "lower(user.email) like lower(concat(#{userList.user.email},'%'))",
            "lower(user.username) like lower(concat(#{userList.user.username},'%'))", };

    private final User            user             = new User();

    public UserList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public User getUser()
    {
        return user;
    }
}

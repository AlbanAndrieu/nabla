// license-header java merge-point
// Generated by: crud/SpringCrudDao.vsl in andromda-spring-cartridge.
package org.andromda.timetracker.domain.crud;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.andromda.timetracker.domain.User;

/**
 * TODO: Model Documentation for User
 */
public interface UserManageableDao
{
    /**
     * @param username TODO: Model Documentation for User.username
     * @param password TODO: Model Documentation for User.password
     * @param firstName TODO: Model Documentation for User.firstName
     * @param lastName TODO: Model Documentation for User.lastName
     * @param email TODO: Model Documentation for User.email
     * @param isEnable TODO: Model Documentation for User.isEnable
     * @param creationDate TODO: Model Documentation for User.creationDate
     * @param comment TODO: Model Documentation for User.comment
     * @param id TODO: Model Documentation for User.id
     * @param roles TODO: Model Documentation for org.andromda.timetracker.domain.UserRole
     * @return User
     */
    public User create(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles);

    /**
     * @param id
     * @return User
     */
    public User readById(Long id);

    /**
     * @param username TODO: Model Documentation for User.username
     * @param password TODO: Model Documentation for User.password
     * @param firstName TODO: Model Documentation for User.firstName
     * @param lastName TODO: Model Documentation for User.lastName
     * @param email TODO: Model Documentation for User.email
     * @param isEnable TODO: Model Documentation for User.isEnable
     * @param creationDate TODO: Model Documentation for User.creationDate
     * @param comment TODO: Model Documentation for User.comment
     * @param id TODO: Model Documentation for User.id
     * @param roles TODO: Model Documentation for org.andromda.timetracker.domain.UserRole
     * @return List<User>
     */
    public List<User> read(String username, String password, String firstName, String lastName, String email, Boolean isEnable, Date creationDate, String comment, Long id, Long[] roles);

    /**
     * @return List<User>
     */
    public List<User> readAll();

    /**
     * @return BackingLists Map<String,?>
     */
    public Map<String,?> readBackingLists();

    /**
     * @param username TODO: Model Documentation for User.username
     * @param password TODO: Model Documentation for User.password
     * @param firstName TODO: Model Documentation for User.firstName
     * @param lastName TODO: Model Documentation for User.lastName
     * @param email TODO: Model Documentation for User.email
     * @param isEnable TODO: Model Documentation for User.isEnable
     * @param creationDate TODO: Model Documentation for User.creationDate
     * @param comment TODO: Model Documentation for User.comment
     * @param id TODO: Model Documentation for User.id
     * @param roles TODO: Model Documentation for org.andromda.timetracker.domain.UserRole
     * @return User
     */
    public User update(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles);

    /**
     * @param ids
     */
    public void delete(Long[] ids);
}
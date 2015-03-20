// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: hibernate/HibernateEntity.vsl overrided in andromda-hibernate-cartridge.
//
package org.andromda.timetracker.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * TODO: Model Documentation for User
 */
@XmlType(propOrder = {"username", "password", "firstName", "lastName", "email", "isEnable", "creationDate", "comment"})
@XmlAccessorType(XmlAccessType.FIELD)
// HibernateEntity.vsl annotations merge-point
public abstract class User implements Serializable, Comparable<User>
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 280161844106669459L;

    // Generate 9 attributes
    @XmlElement(name = "username")
    private String username;

    /**
     * TODO: Model Documentation for User.username
     * @return this.username String
     */
    public String getUsername()
    {
        return this.username;
    }

    /**
     * TODO: Model Documentation for User.username
     * @param usernameIn String
     */
    public void setUsername(String usernameIn)
    {
        this.username = usernameIn;
    }

    @XmlElement(name = "password")
    private String password;

    /**
     * TODO: Model Documentation for User.password
     * @return this.password String
     */
    public String getPassword()
    {
        return this.password;
    }

    /**
     * TODO: Model Documentation for User.password
     * @param passwordIn String
     */
    public void setPassword(String passwordIn)
    {
        this.password = passwordIn;
    }

    @XmlElement(name = "firstName")
    private String firstName;

    /**
     * TODO: Model Documentation for User.firstName
     * @return this.firstName String
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * TODO: Model Documentation for User.firstName
     * @param firstNameIn String
     */
    public void setFirstName(String firstNameIn)
    {
        this.firstName = firstNameIn;
    }

    @XmlElement(name = "lastName")
    private String lastName;

    /**
     * TODO: Model Documentation for User.lastName
     * @return this.lastName String
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * TODO: Model Documentation for User.lastName
     * @param lastNameIn String
     */
    public void setLastName(String lastNameIn)
    {
        this.lastName = lastNameIn;
    }

    @XmlElement(name = "email")
    private String email;

    /**
     * TODO: Model Documentation for User.email
     * @return this.email String
     */
    public String getEmail()
    {
        return this.email;
    }

    /**
     * TODO: Model Documentation for User.email
     * @param emailIn String
     */
    public void setEmail(String emailIn)
    {
        this.email = emailIn;
    }

    @XmlElement(name = "isEnable")
    private boolean isEnable;

    /**
     * TODO: Model Documentation for User.isEnable
     * @return this.isEnable boolean
     */
    public boolean isIsEnable()
    {
        return this.isEnable;
    }

    /**
     * TODO: Model Documentation for User.isEnable
     * @param isEnableIn boolean
     */
    public void setIsEnable(boolean isEnableIn)
    {
        this.isEnable = isEnableIn;
    }

    @XmlElement(name = "creationDate")
    private Date creationDate;

    /**
     * TODO: Model Documentation for User.creationDate
     * @return this.creationDate Date
     */
    public Date getCreationDate()
    {
        return this.creationDate;
    }

    /**
     * TODO: Model Documentation for User.creationDate
     * @param creationDateIn Date
     */
    public void setCreationDate(Date creationDateIn)
    {
        this.creationDate = creationDateIn;
    }

    @XmlElement(name = "comment")
    private String comment;

    /**
     * TODO: Model Documentation for User.comment
     * @return this.comment String
     */
    public String getComment()
    {
        return this.comment;
    }

    /**
     * TODO: Model Documentation for User.comment
     * @param commentIn String
     */
    public void setComment(String commentIn)
    {
        this.comment = commentIn;
    }

    @XmlElement(name = "id")
    private Long id;

    /**
     * TODO: Model Documentation for User.id
     * @return this.id Long
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * TODO: Model Documentation for User.id
     * @param idIn Long
     */
    public void setId(Long idIn)
    {
        this.id = idIn;
    }

    // Generate 3 associations
    private Collection<UserRole> roles = new HashSet<UserRole>();

    /**
     * TODO: Model Documentation for UserRole
     * @return this.roles Collection<UserRole>
     */
    public Collection<UserRole> getRoles()
    {
        return this.roles;
    }

    /**
     * TODO: Model Documentation for UserRole
     * @param rolesIn Collection<UserRole>
     */
    public void setRoles(Collection<UserRole> rolesIn)
    {
        this.roles = rolesIn;
    }

    /**
     * TODO: Model Documentation for UserRole
     * @param elementToAdd UserRole
     * @return <tt>true</tt> if this collection changed as a result of the
     *         call
     */
    public boolean addRoles(UserRole elementToAdd)
    {
        return this.roles.add(elementToAdd);
    }

    /**
     * TODO: Model Documentation for UserRole
     * @param elementToRemove UserRole
     * @return <tt>true</tt> if this collection changed as a result of the
     *         call
     */
    public boolean removeRoles(UserRole elementToRemove)
    {
        return this.roles.remove(elementToRemove);
    }

    /**
     * Returns <code>true</code> if the argument is an User instance and all identifiers for this entity
     * equal the identifiers of the argument entity. Returns <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof User))
        {
            return false;
        }
        final User that = (User)object;
        if (this.id == null || that.getId() == null || !this.id.equals(that.getId()))
        {
            return false;
        }
        return true;
    }

    /**
     * Returns a hash code based on this entity's identifiers.
     */
    @Override
    public int hashCode()
    {
        int hashCode = 0;
        hashCode = 29 * hashCode + (this.id == null ? 0 : this.id.hashCode());

        return hashCode;
    }

    /**
     * Constructs new instances of {@link User}.
     */
    public static final class Factory
    {
        /**
         * Constructs a new instance of {@link User}.
         * @return new UserImpl()
         */
        public static User newInstance()
        {
            return new UserImpl();
        }

        // requiredParams not identifier : 7 allSize minus identifier : 9 all required constructor parameters : 7 identifiers : 1 all properties :  10
        /**
         * Constructs a new instance of {@link User}, taking all required and/or
         * read-only properties as arguments, except for identifiers.
         * @param username String
         * @param password String
         * @param firstName String
         * @param lastName String
         * @param email String
         * @param isEnable boolean
         * @param creationDate Date
         * @return newInstance
         */
        public static User newInstance(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate)
        {
            final User entity = new UserImpl();
            entity.setUsername(username);
            entity.setPassword(password);
            entity.setFirstName(firstName);
            entity.setLastName(lastName);
            entity.setEmail(email);
            entity.setIsEnable(isEnable);
            entity.setCreationDate(creationDate);
            return entity;
        }

        /**
         * Constructs a new instance of {@link User}, taking all possible properties
         * (except the identifier(s))as arguments.
         * @param username String
         * @param password String
         * @param firstName String
         * @param lastName String
         * @param email String
         * @param isEnable boolean
         * @param creationDate Date
         * @param comment String
         * @param roles Collection<UserRole>
         * @return newInstance User
         */
        public static User newInstance(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Collection<UserRole> roles)
        {
            final User entity = new UserImpl();
            entity.setUsername(username);
            entity.setPassword(password);
            entity.setFirstName(firstName);
            entity.setLastName(lastName);
            entity.setEmail(email);
            entity.setIsEnable(isEnable);
            entity.setCreationDate(creationDate);
            entity.setComment(comment);
            entity.setRoles(roles);
            return entity;
        }
    }

    /**
     * @param other
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     * @see Comparable#compareTo
     */
    @Override
    public int compareTo(User other)
    {
        int cmp = 0;
        if (this.getId() != null)
        {
            cmp = this.getId().compareTo(other.getId());
        }
        else
        {
            if (this.getUsername() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getUsername().compareTo(other.getUsername()));
            }
            if (this.getPassword() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getPassword().compareTo(other.getPassword()));
            }
            if (this.getFirstName() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getFirstName().compareTo(other.getFirstName()));
            }
            if (this.getLastName() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getLastName().compareTo(other.getLastName()));
            }
            if (this.getEmail() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getEmail().compareTo(other.getEmail()));
            }
            if (this.getCreationDate() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getCreationDate().compareTo(other.getCreationDate()));
            }
            if (this.getComment() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getComment().compareTo(other.getComment()));
            }
        }
        return cmp;
    }
// HibernateEntity.vsl merge-point
}
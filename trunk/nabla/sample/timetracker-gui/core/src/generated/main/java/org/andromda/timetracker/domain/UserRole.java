// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: hibernate/HibernateEntity.vsl overrided in andromda-hibernate-cartridge.
//
package org.andromda.timetracker.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * TODO: Model Documentation for UserRole
 */
@XmlType(propOrder = {"role"})
@XmlAccessorType(XmlAccessType.FIELD)
// HibernateEntity.vsl annotations merge-point
public abstract class UserRole implements Serializable, Comparable<UserRole>
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 7844086459073233566L;

    // Generate 2 attributes
    @XmlElement(name = "role")
    private Role role;

    /**
     * TODO: Model Documentation for UserRole.role
     * @return this.role Role
     */
    public Role getRole()
    {
        return this.role;
    }

    /**
     * TODO: Model Documentation for UserRole.role
     * @param roleIn Role
     */
    public void setRole(Role roleIn)
    {
        this.role = roleIn;
    }

    @XmlElement(name = "id")
    private Long id;

    /**
     * TODO: Model Documentation for UserRole.id
     * @return this.id Long
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * TODO: Model Documentation for UserRole.id
     * @param idIn Long
     */
    public void setId(Long idIn)
    {
        this.id = idIn;
    }

    // Generate 1 associations
    /**
     * Returns <code>true</code> if the argument is an UserRole instance and all identifiers for this entity
     * equal the identifiers of the argument entity. Returns <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof UserRole))
        {
            return false;
        }
        final UserRole that = (UserRole)object;
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
     * Constructs new instances of {@link UserRole}.
     */
    public static final class Factory
    {
        /**
         * Constructs a new instance of {@link UserRole}.
         * @return new UserRoleImpl()
         */
        public static UserRole newInstance()
        {
            return new UserRoleImpl();
        }


        /**
         * Constructs a new instance of {@link UserRole}, taking all possible properties
         * (except the identifier(s))as arguments.
         * @param role Role
         * @return newInstance UserRole
         */
        public static UserRole newInstance(Role role)
        {
            final UserRole entity = new UserRoleImpl();
            entity.setRole(role);
            return entity;
        }
    }

    /**
     * @param other
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     * @see Comparable#compareTo
     */
    @Override
    public int compareTo(UserRole other)
    {
        int cmp = 0;
        if (this.getId() != null)
        {
            cmp = this.getId().compareTo(other.getId());
        }
        else
        {
            if (this.getRole() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getRole().compareTo(other.getRole()));
            }
        }
        return cmp;
    }
// HibernateEntity.vsl merge-point
}
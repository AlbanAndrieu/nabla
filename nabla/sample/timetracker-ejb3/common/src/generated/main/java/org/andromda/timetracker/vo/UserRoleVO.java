// license-header java merge-point
//
/**
 * Attention: Generated code! Do not modify by hand!!
 *
 * TEMPLATE:     ValueObject.vsl in andromda-java-cartridge.
 * MODEL CLASS:  TimeTracker::TimeTracker::org.andromda.timetracker::vo::UserRoleVO
 * STEREOTYPE:   ValueObject
 */
package org.andromda.timetracker.vo;

import java.io.Serializable;
import java.util.Arrays;
import org.andromda.timetracker.domain.Role;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * TODO: Model Documentation for UserRoleVO
 */
public class UserRoleVO
    implements Serializable, Comparable<UserRoleVO>
{
    /** The serial version UID of this class. Needed for serialization. */
    private static final long serialVersionUID = -144923373363619730L;

    // Class attributes
    /**
     * TODO: Model Documentation for UserRoleVO.id
     */
    protected Long id;
    /**
     * TODO: Model Documentation for UserRoleVO.role
     */
    protected Role role;

    /** Default Constructor with no properties */
    public UserRoleVO()
    {
        // Documented empty block - avoid compiler warning - no super constructor
    }

    /**
     * Constructor taking only required properties
     * @param roleIn Role TODO: Model Documentation for UserRoleVO.role
     */
    public UserRoleVO(final Role roleIn)
    {
        this.role = roleIn;
    }

    /**
     * Constructor with all properties
     * @param idIn Long
     * @param roleIn Role
     */
    public UserRoleVO(final Long idIn, final Role roleIn)
    {
        this.id = idIn;
        this.role = roleIn;
    }

    /**
     * Copies constructor from other UserRoleVO
     *
     * @param otherBean Cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public UserRoleVO(final UserRoleVO otherBean)
    {
        this.id = otherBean.getId();
        this.role = otherBean.getRole();
    }

    /**
     * Copies all properties from the argument value object into this value object.
     * @param otherBean Cannot be <code>null</code>
     */
    public void copy(final UserRoleVO otherBean)
    {
        if (null != otherBean)
        {
            this.setId(otherBean.getId());
            this.setRole(otherBean.getRole());
        }
    }

    /**
     * TODO: Model Documentation for UserRoleVO.id
     * Get the id Attribute
     * @return id Long
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * TODO: Model Documentation for UserRoleVO.id
     * @param value Long
     */
    public void setId(final Long value)
    {
        this.id = value;
    }

    /**
     * TODO: Model Documentation for UserRoleVO.role
     * Get the role Attribute
     * @return role Role
     */
    public Role getRole()
    {
        return this.role;
    }

    /**
     * TODO: Model Documentation for UserRoleVO.role
     * @param value Role
     */
    public void setRole(final Role value)
    {
        this.role = value;
    }

    /**
     * @param object to compare this object against
     * @return boolean if equal
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(final Object object)
    {
        if (object==null || object.getClass() != this.getClass())
        {
             return false;
        }
        // Check if the same object instance
        if (object==this)
        {
            return true;
        }
        UserRoleVO rhs = (UserRoleVO) object;
        return new EqualsBuilder()
            .append(this.getId(), rhs.getId())
            .append(this.getRole(), rhs.getRole())
            .isEquals();
    }

    /**
     * @param object to compare this object against
     * @return int if equal
     * @see Comparable#compareTo(Object)
     */
    public int compareTo(final UserRoleVO object)
    {
        if (object==null)
        {
            return -1;
        }
        // Check if the same object instance
        if (object==this)
        {
            return 0;
        }
        return new CompareToBuilder()
            .append(this.getId(), object.getId())
            .append(this.getRole(), object.getRole())
            .toComparison();
    }

    /**
     * @return int hashCode value
     * @see Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(1249046965, -82296885)
            .append(this.getId())
            .append(this.getRole())
            .toHashCode();
    }

    /**
     * @return String representation of object
     * @see Object#toString()
     */
    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
            .append("id", this.getId())
            .append("role", this.getRole())
            .toString();
    }

    /**
     * Compares the properties of this instance to the properties of the argument. This method will return
     * {@code false} as soon as it detects that the argument is {@code null} or not of the same type as
     * (or a sub-type of) this instance's type.
     *
     * <p/>For array, collection or map properties the comparison will be done one level deep, in other words:
     * the elements will be compared using the {@code equals()} operation.
     *
     * <p/>Note that two properties will be considered equal when both values are {@code null}.
     *
     * @param thatObject the object containing the properties to compare against this instance
     * @return this method will return {@code true} in case the argument has the same type as this class, or is a
     *      sub-type of this class and all properties as found on this class have equal values when queried on that
     *      argument instance; in all other cases this method will return {@code false}
     */
    public boolean equalProperties(final Object thatObject)
    {
        if (thatObject == null || !this.getClass().isAssignableFrom(thatObject.getClass()))
        {
            return false;
        }

        final UserRoleVO that = (UserRoleVO)thatObject;

        return
            equal(this.getId(), that.getId())
            && equal(this.getRole(), that.getRole())
        ;
    }

    /**
     * This is a convenient helper method which is able to detect whether or not two values are equal. Two values
     * are equal when they are both {@code null}, are arrays of the same length with equal elements or are
     * equal objects (this includes {@link java.util.Collection} and {@link java.util.Map} instances).
     *
     * <p/>Note that for array, collection or map instances the comparison runs one level deep.
     *
     * @param first the first object to compare, may be {@code null}
     * @param second the second object to compare, may be {@code null}
     * @return this method will return {@code true} in case both objects are equal as explained above;
     *      in all other cases this method will return {@code false}
     */
    protected static boolean equal(final Object first, final Object second)
    {
        final boolean equal;

        if (first == null)
        {
            equal = (second == null);
        }
        else if (first.getClass().isArray() && (second != null) && second.getClass().isArray())
        {
            equal = Arrays.equals((Object[])first, (Object[])second);
        }
        else // note that the following also covers java.util.Collection and java.util.Map
        {
            equal = first.equals(second);
        }

        return equal;
    }

    // UserRoleVO value-object java merge-point
}
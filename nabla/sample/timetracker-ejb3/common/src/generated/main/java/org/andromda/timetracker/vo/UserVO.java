// license-header java merge-point
//
/**
 * Attention: Generated code! Do not modify by hand!!
 *
 * TEMPLATE:     ValueObject.vsl in andromda-java-cartridge.
 * MODEL CLASS:  TimeTracker::TimeTracker::org.andromda.timetracker::vo::UserVO
 * STEREOTYPE:   ValueObject
 */
package org.andromda.timetracker.vo;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * TODO: Model Documentation for UserVO
 */
public class UserVO
    implements Serializable, Comparable<UserVO>
{
    /** The serial version UID of this class. Needed for serialization. */
    private static final long serialVersionUID = 1001098440399290858L;

    // Class attributes
    /**
     * TODO: Model Documentation for UserVO.id
     */
    protected Long id;
    /**
     * TODO: Model Documentation for UserVO.username
     */
    protected String username;
    /**
     * TODO: Model Documentation for UserVO.firstName
     */
    protected String firstName;
    /**
     * TODO: Model Documentation for UserVO.lastName
     */
    protected String lastName;

    /** Default Constructor with no properties */
    public UserVO()
    {
        // Documented empty block - avoid compiler warning - no super constructor
    }

    /**
     * Constructor taking only required properties
     * @param usernameIn String TODO: Model Documentation for UserVO.username
     * @param firstNameIn String TODO: Model Documentation for UserVO.firstName
     * @param lastNameIn String TODO: Model Documentation for UserVO.lastName
     */
    public UserVO(final String usernameIn, final String firstNameIn, final String lastNameIn)
    {
        this.username = usernameIn;
        this.firstName = firstNameIn;
        this.lastName = lastNameIn;
    }

    /**
     * Constructor with all properties
     * @param idIn Long
     * @param usernameIn String
     * @param firstNameIn String
     * @param lastNameIn String
     */
    public UserVO(final Long idIn, final String usernameIn, final String firstNameIn, final String lastNameIn)
    {
        this.id = idIn;
        this.username = usernameIn;
        this.firstName = firstNameIn;
        this.lastName = lastNameIn;
    }

    /**
     * Copies constructor from other UserVO
     *
     * @param otherBean Cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public UserVO(final UserVO otherBean)
    {
        this.id = otherBean.getId();
        this.username = otherBean.getUsername();
        this.firstName = otherBean.getFirstName();
        this.lastName = otherBean.getLastName();
    }

    /**
     * Copies all properties from the argument value object into this value object.
     * @param otherBean Cannot be <code>null</code>
     */
    public void copy(final UserVO otherBean)
    {
        if (null != otherBean)
        {
            this.setId(otherBean.getId());
            this.setUsername(otherBean.getUsername());
            this.setFirstName(otherBean.getFirstName());
            this.setLastName(otherBean.getLastName());
        }
    }

    /**
     * TODO: Model Documentation for UserVO.id
     * Get the id Attribute
     * @return id Long
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * TODO: Model Documentation for UserVO.id
     * @param value Long
     */
    public void setId(final Long value)
    {
        this.id = value;
    }

    /**
     * TODO: Model Documentation for UserVO.username
     * Get the username Attribute
     * @return username String
     */
    public String getUsername()
    {
        return this.username;
    }

    /**
     * TODO: Model Documentation for UserVO.username
     * @param value String
     */
    public void setUsername(final String value)
    {
        this.username = value;
    }

    /**
     * TODO: Model Documentation for UserVO.firstName
     * Get the firstName Attribute
     * @return firstName String
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * TODO: Model Documentation for UserVO.firstName
     * @param value String
     */
    public void setFirstName(final String value)
    {
        this.firstName = value;
    }

    /**
     * TODO: Model Documentation for UserVO.lastName
     * Get the lastName Attribute
     * @return lastName String
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * TODO: Model Documentation for UserVO.lastName
     * @param value String
     */
    public void setLastName(final String value)
    {
        this.lastName = value;
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
        UserVO rhs = (UserVO) object;
        return new EqualsBuilder()
            .append(this.getId(), rhs.getId())
            .append(this.getUsername(), rhs.getUsername())
            .append(this.getFirstName(), rhs.getFirstName())
            .append(this.getLastName(), rhs.getLastName())
            .isEquals();
    }

    /**
     * @param object to compare this object against
     * @return int if equal
     * @see Comparable#compareTo(Object)
     */
    public int compareTo(final UserVO object)
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
            .append(this.getUsername(), object.getUsername())
            .append(this.getFirstName(), object.getFirstName())
            .append(this.getLastName(), object.getLastName())
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
            .append(this.getUsername())
            .append(this.getFirstName())
            .append(this.getLastName())
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
            .append("username", this.getUsername())
            .append("firstName", this.getFirstName())
            .append("lastName", this.getLastName())
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

        final UserVO that = (UserVO)thatObject;

        return
            equal(this.getId(), that.getId())
            && equal(this.getUsername(), that.getUsername())
            && equal(this.getFirstName(), that.getFirstName())
            && equal(this.getLastName(), that.getLastName())
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

    // UserVO value-object java merge-point
}
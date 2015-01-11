// license-header java merge-point
//
/**
 * Attention: Generated code! Do not modify by hand!!
 *
 * TEMPLATE:     ValueObject.vsl in andromda-java-cartridge.
 * MODEL CLASS:  TimeTracker::TimeTracker::org.andromda.timetracker::vo::UserDetailsVO
 * STEREOTYPE:   ValueObject
 */
package org.andromda.timetracker.vo;

import java.util.Date;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * TODO: Model Documentation for UserDetailsVO
 */
public class UserDetailsVO
    extends UserVO
{
    /** The serial version UID of this class. Needed for serialization. */
    private static final long serialVersionUID = 1496993145138888879L;

    // Class attributes
    /**
     * TODO: Model Documentation for UserDetailsVO.password
     */
    protected String password;
    /**
     * TODO: Model Documentation for UserDetailsVO.email
     */
    protected String email;
    /**
     * TODO: Model Documentation for UserDetailsVO.isActive
     */
    protected boolean isActive;
    /**
     * boolean setter for primitive attribute, so we can tell if it's initialized
     */
    protected boolean setIsActive = false;
    /**
     * TODO: Model Documentation for UserDetailsVO.creationDate
     */
    protected Date creationDate;
    /**
     * TODO: Model Documentation for UserDetailsVO.comment
     */
    protected String comment;
    /**
     * TODO: Model Documentation for UserDetailsVO.roles
     */
    protected UserRoleVO[] roles;

    /** Default Constructor with no properties */
    public UserDetailsVO()
    {
        super();
    }

    /**
     * Constructor taking only required properties
     * @param usernameIn String TODO: Model Documentation for UserVO.username
     * @param firstNameIn String TODO: Model Documentation for UserVO.firstName
     * @param lastNameIn String TODO: Model Documentation for UserVO.lastName
     * @param passwordIn String TODO: Model Documentation for UserDetailsVO.password
     * @param emailIn String TODO: Model Documentation for UserDetailsVO.email
     * @param isActiveIn boolean TODO: Model Documentation for UserDetailsVO.isActive
     * @param creationDateIn Date TODO: Model Documentation for UserDetailsVO.creationDate
     * @param rolesIn UserRoleVO[] TODO: Model Documentation for UserDetailsVO.roles
     */
    public UserDetailsVO(final String usernameIn, final String firstNameIn, final String lastNameIn, final String passwordIn, final String emailIn, final boolean isActiveIn, final Date creationDateIn, final UserRoleVO[] rolesIn)
    {
        super(usernameIn, firstNameIn, lastNameIn);
        this.password = passwordIn;
        this.email = emailIn;
        this.isActive = isActiveIn;
        this.setIsActive = true;
        this.creationDate = creationDateIn;
        this.roles = rolesIn;
    }

    /**
     * Constructor with all properties
     * @param idIn Long
     * @param usernameIn String
     * @param firstNameIn String
     * @param lastNameIn String
     * @param passwordIn String
     * @param emailIn String
     * @param isActiveIn boolean
     * @param creationDateIn Date
     * @param commentIn String
     * @param rolesIn UserRoleVO[]
     */
    public UserDetailsVO(final Long idIn, final String usernameIn, final String firstNameIn, final String lastNameIn, final String passwordIn, final String emailIn, final boolean isActiveIn, final Date creationDateIn, final String commentIn, final UserRoleVO[] rolesIn)
    {
        super(idIn, usernameIn, firstNameIn, lastNameIn);
        this.password = passwordIn;
        this.email = emailIn;
        this.isActive = isActiveIn;
        this.setIsActive = true;
        this.creationDate = creationDateIn;
        this.comment = commentIn;
        this.roles = rolesIn;
    }

    /**
     * Copies constructor from other UserDetailsVO
     *
     * @param otherBean Cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public UserDetailsVO(final UserDetailsVO otherBean)
    {
        super(otherBean);
        this.password = otherBean.getPassword();
        this.email = otherBean.getEmail();
        this.isActive = otherBean.isIsActive();
        this.setIsActive = true;
        this.creationDate = otherBean.getCreationDate();
        this.comment = otherBean.getComment();
        this.roles = otherBean.getRoles();
    }

    /**
     * Copies all properties from the argument value object into this value object.
     * @param otherBean Cannot be <code>null</code>
     */
    public void copy(final UserDetailsVO otherBean)
    {
        if (null != otherBean)
        {
            super.copy(otherBean);
            this.setPassword(otherBean.getPassword());
            this.setEmail(otherBean.getEmail());
            this.setIsActive(otherBean.isIsActive());
            this.setIsActive = true;
            this.setCreationDate(otherBean.getCreationDate());
            this.setComment(otherBean.getComment());
            this.setRoles(otherBean.getRoles());
        }
    }

    /**
     * TODO: Model Documentation for UserDetailsVO.password
     * Get the password Attribute
     * @return password String
     */
    public String getPassword()
    {
        return this.password;
    }

    /**
     * TODO: Model Documentation for UserDetailsVO.password
     * @param value String
     */
    public void setPassword(final String value)
    {
        this.password = value;
    }

    /**
     * TODO: Model Documentation for UserDetailsVO.email
     * Get the email Attribute
     * @return email String
     */
    public String getEmail()
    {
        return this.email;
    }

    /**
     * TODO: Model Documentation for UserDetailsVO.email
     * @param value String
     */
    public void setEmail(final String value)
    {
        this.email = value;
    }

    /**
     * TODO: Model Documentation for UserDetailsVO.isActive
     * Get the isActive Attribute
     * @return isActive boolean
     */
    public boolean isIsActive()
    {
        return this.isActive;
    }

    /**
     * TODO: Model Documentation for UserDetailsVO.isActive
     * Duplicates isBoolean method, for use as Jaxb2 compatible object
     * Get the isActive Attribute
     * @return isActive boolean
     */
    @Deprecated
    public boolean getIsActive()
    {
        return this.isActive;
    }

    /**
     * TODO: Model Documentation for UserDetailsVO.isActive
     * @param value boolean
     */
    public void setIsActive(final boolean value)
    {
        this.isActive = value;
        this.setIsActive = true;
    }

    /**
     * Return true if the primitive attribute isActive is set, through the setter or constructor
     * @return true if the attribute value has been set
     */
    public boolean isSetIsActive()
    {
        return this.setIsActive;
    }

    /**
     * TODO: Model Documentation for UserDetailsVO.creationDate
     * Get the creationDate Attribute
     * @return creationDate Date
     */
    public Date getCreationDate()
    {
        return this.creationDate;
    }

    /**
     * TODO: Model Documentation for UserDetailsVO.creationDate
     * @param value Date
     */
    public void setCreationDate(final Date value)
    {
        this.creationDate = value;
    }

    /**
     * TODO: Model Documentation for UserDetailsVO.comment
     * Get the comment Attribute
     * @return comment String
     */
    public String getComment()
    {
        return this.comment;
    }

    /**
     * TODO: Model Documentation for UserDetailsVO.comment
     * @param value String
     */
    public void setComment(final String value)
    {
        this.comment = value;
    }

    /**
     * TODO: Model Documentation for UserDetailsVO.roles
     * Get the roles Attribute
     * @return roles UserRoleVO[]
     */
    public UserRoleVO[] getRoles()
    {
        return this.roles;
    }

    /**
     * TODO: Model Documentation for UserDetailsVO.roles
     * @param value UserRoleVO[]
     */
    public void setRoles(final UserRoleVO[] value)
    {
        this.roles = value;
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
        UserDetailsVO rhs = (UserDetailsVO) object;
        return new EqualsBuilder()
            .appendSuper(super.equals(object))
            .append(this.getPassword(), rhs.getPassword())
            .append(this.getEmail(), rhs.getEmail())
            .append(this.isIsActive(), rhs.isIsActive())
            .append(this.getCreationDate(), rhs.getCreationDate())
            .append(this.getComment(), rhs.getComment())
            .append(this.getRoles(), rhs.getRoles())
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
        if (!(object instanceof UserDetailsVO))
        {
            return -1;
        }
        UserDetailsVO myClass = (UserDetailsVO)object;
        return new CompareToBuilder()
            .appendSuper(super.compareTo(object))
            .append(this.getPassword(), myClass.getPassword())
            .append(this.getEmail(), myClass.getEmail())
            .append(this.isIsActive(), myClass.isIsActive())
            .append(this.getCreationDate(), myClass.getCreationDate())
            .append(this.getComment(), myClass.getComment())
            .append(this.getRoles(), myClass.getRoles())
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
            .appendSuper(super.hashCode())
            .append(this.getPassword())
            .append(this.getEmail())
            .append(this.isIsActive())
            .append(this.getCreationDate())
            .append(this.getComment())
            .append(this.getRoles())
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
            .append("password", this.getPassword())
            .append("email", this.getEmail())
            .append("isActive", this.isIsActive())
            .append("creationDate", this.getCreationDate())
            .append("comment", this.getComment())
            .append("roles", this.getRoles())
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
    @Override
    public boolean equalProperties(final Object thatObject)
    {
        if (thatObject == null || !this.getClass().isAssignableFrom(thatObject.getClass()))
        {
            return false;
        }

        final UserDetailsVO that = (UserDetailsVO)thatObject;

        return super.equalProperties(that)
            && equal(this.getPassword(), that.getPassword())
            && equal(this.getEmail(), that.getEmail())
            && equal(this.isIsActive(), that.isIsActive())
            && equal(this.getCreationDate(), that.getCreationDate())
            && equal(this.getComment(), that.getComment())
            && equal(this.getRoles(), that.getRoles())
        ;
    }

    // UserDetailsVO value-object java merge-point
}
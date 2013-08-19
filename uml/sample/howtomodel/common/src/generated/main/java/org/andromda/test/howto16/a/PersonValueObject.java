// license-header java merge-point
//
/**
 * Attention: Generated code! Do not modify by hand!!
 *
 * TEMPLATE:     ValueObject.vsl in andromda-java-cartridge.
 * MODEL CLASS:  Data::EJB3 Example::org.andromda.test::howto16::a::PersonValueObject
 * STEREOTYPE:   ValueObject
 */
package org.andromda.test.howto16.a;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * TODO: Model Documentation for PersonValueObject
 */
public class PersonValueObject
    implements Serializable, Comparable<PersonValueObject>
{
    /** The serial version UID of this class. Needed for serialization. */
    private static final long serialVersionUID = -6491520082644996244L;

    // Class attributes
    /**
     * TODO: Model Documentation for PersonValueObject.serial
     */
    protected String serial;
    /**
     * TODO: Model Documentation for PersonValueObject.name
     */
    protected String name;
    /**
     * TODO: Model Documentation for PersonValueObject.birthDate
     */
    protected Date birthDate;

    /** Default Constructor with no properties */
    public PersonValueObject()
    {
        // Documented empty block - avoid compiler warning - no super constructor
    }

    /**
     * Constructor with all properties
     * @param serialIn String
     * @param nameIn String
     * @param birthDateIn Date
     */
    public PersonValueObject(final String serialIn, final String nameIn, final Date birthDateIn)
    {
        this.serial = serialIn;
        this.name = nameIn;
        this.birthDate = birthDateIn;
    }

    /**
     * Copies constructor from other PersonValueObject
     *
     * @param otherBean Cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public PersonValueObject(final PersonValueObject otherBean)
    {
        this.serial = otherBean.getSerial();
        this.name = otherBean.getName();
        this.birthDate = otherBean.getBirthDate();
    }

    /**
     * Copies all properties from the argument value object into this value object.
     * @param otherBean Cannot be <code>null</code>
     */
    public void copy(final PersonValueObject otherBean)
    {
        if (null != otherBean)
        {
            this.setSerial(otherBean.getSerial());
            this.setName(otherBean.getName());
            this.setBirthDate(otherBean.getBirthDate());
        }
    }

    /**
     * TODO: Model Documentation for PersonValueObject.serial
     * Get the serial Attribute
     * @return serial String
     */
    public String getSerial()
    {
        return this.serial;
    }

    /**
     * TODO: Model Documentation for PersonValueObject.serial
     * @param value String
     */
    public void setSerial(final String value)
    {
        this.serial = value;
    }

    /**
     * TODO: Model Documentation for PersonValueObject.name
     * Get the name Attribute
     * @return name String
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * TODO: Model Documentation for PersonValueObject.name
     * @param value String
     */
    public void setName(final String value)
    {
        this.name = value;
    }

    /**
     * TODO: Model Documentation for PersonValueObject.birthDate
     * Get the birthDate Attribute
     * @return birthDate Date
     */
    public Date getBirthDate()
    {
        return this.birthDate;
    }

    /**
     * TODO: Model Documentation for PersonValueObject.birthDate
     * @param value Date
     */
    public void setBirthDate(final Date value)
    {
        this.birthDate = value;
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
        PersonValueObject rhs = (PersonValueObject) object;
        return new EqualsBuilder()
            .append(this.getSerial(), rhs.getSerial())
            .append(this.getName(), rhs.getName())
            .append(this.getBirthDate(), rhs.getBirthDate())
            .isEquals();
    }

    /**
     * @param object to compare this object against
     * @return int if equal
     * @see Comparable#compareTo(Object)
     */
    public int compareTo(final PersonValueObject object)
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
            .append(this.getSerial(), object.getSerial())
            .append(this.getName(), object.getName())
            .append(this.getBirthDate(), object.getBirthDate())
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
            .append(this.getSerial())
            .append(this.getName())
            .append(this.getBirthDate())
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
            .append("serial", this.getSerial())
            .append("name", this.getName())
            .append("birthDate", this.getBirthDate())
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

        final PersonValueObject that = (PersonValueObject)thatObject;

        return
            equal(this.getSerial(), that.getSerial())
            && equal(this.getName(), that.getName())
            && equal(this.getBirthDate(), that.getBirthDate())
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

    // PersonValueObject value-object java merge-point
}
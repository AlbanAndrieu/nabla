// license-header java merge-point
//
/**
 * Attention: Generated code! Do not modify by hand!!
 *
 * TEMPLATE:     ValueObject.vsl in andromda-java-cartridge.
 * MODEL CLASS:  Data::EJB3 Example::org.andromda.test::howto16::a::CareValueObject
 * STEREOTYPE:   ValueObject
 */
package org.andromda.test.howto16.a;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * TODO: Model Documentation for CareValueObject
 */
public class CareValueObject
    implements Serializable, Comparable<CareValueObject>
{
    /** The serial version UID of this class. Needed for serialization. */
    private static final long serialVersionUID = -4439548878484213163L;

    // Class attributes
    /**
     * TODO: Model Documentation for CareValueObject.serial
     */
    protected String serial;
    /**
     * TODO: Model Documentation for CareValueObject.name
     */
    protected String name;
    /**
     * TODO: Model Documentation for CareValueObject.type
     */
    protected CarType type;

    /** Default Constructor with no properties */
    public CareValueObject()
    {
        // Documented empty block - avoid compiler warning - no super constructor
    }

    /**
     * Constructor with all properties
     * @param serialIn String
     * @param nameIn String
     * @param typeIn CarType
     */
    public CareValueObject(final String serialIn, final String nameIn, final CarType typeIn)
    {
        this.serial = serialIn;
        this.name = nameIn;
        this.type = typeIn;
    }

    /**
     * Copies constructor from other CareValueObject
     *
     * @param otherBean Cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public CareValueObject(final CareValueObject otherBean)
    {
        this.serial = otherBean.getSerial();
        this.name = otherBean.getName();
        this.type = otherBean.getType();
    }

    /**
     * Copies all properties from the argument value object into this value object.
     * @param otherBean Cannot be <code>null</code>
     */
    public void copy(final CareValueObject otherBean)
    {
        if (null != otherBean)
        {
            this.setSerial(otherBean.getSerial());
            this.setName(otherBean.getName());
            this.setType(otherBean.getType());
        }
    }

    /**
     * TODO: Model Documentation for CareValueObject.serial
     * Get the serial Attribute
     * @return serial String
     */
    public String getSerial()
    {
        return this.serial;
    }

    /**
     * TODO: Model Documentation for CareValueObject.serial
     * @param value String
     */
    public void setSerial(final String value)
    {
        this.serial = value;
    }

    /**
     * TODO: Model Documentation for CareValueObject.name
     * Get the name Attribute
     * @return name String
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * TODO: Model Documentation for CareValueObject.name
     * @param value String
     */
    public void setName(final String value)
    {
        this.name = value;
    }

    /**
     * TODO: Model Documentation for CareValueObject.type
     * Get the type Attribute
     * @return type CarType
     */
    public CarType getType()
    {
        return this.type;
    }

    /**
     * TODO: Model Documentation for CareValueObject.type
     * @param value CarType
     */
    public void setType(final CarType value)
    {
        this.type = value;
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
        CareValueObject rhs = (CareValueObject) object;
        return new EqualsBuilder()
            .append(this.getSerial(), rhs.getSerial())
            .append(this.getName(), rhs.getName())
            .append(this.getType(), rhs.getType())
            .isEquals();
    }

    /**
     * @param object to compare this object against
     * @return int if equal
     * @see Comparable#compareTo(Object)
     */
    public int compareTo(final CareValueObject object)
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
            .append(this.getType(), object.getType())
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
            .append(this.getType())
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
            .append("type", this.getType())
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

        final CareValueObject that = (CareValueObject)thatObject;

        return
            equal(this.getSerial(), that.getSerial())
            && equal(this.getName(), that.getName())
            && equal(this.getType(), that.getType())
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

    // CareValueObject value-object java merge-point
}
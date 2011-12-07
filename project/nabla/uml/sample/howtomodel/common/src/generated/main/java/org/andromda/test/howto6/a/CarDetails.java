// license-header java merge-point
//
/**
 * @author Generated on 12/07/2011 19:18:39+0100 Do not modify by hand!
 *
 * TEMPLATE:     ValueObject.vsl in andromda-java-cartridge.
 * MODEL CLASS:  Data::EJB3 Example::org.andromda.test::howto6::a::CarDetails
 * STEREOTYPE:   ValueObject
 */
package org.andromda.test.howto6.a;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * TODO: Model Documentation for class CarDetails
 */
public class CarDetails
    implements Serializable, Comparable<CarDetails>
{
    /** The serial version UID of this class. Needed for serialization. */
    private static final long serialVersionUID = 265048543605741244L;

    // Class attributes
    /** TODO: Model Documentation for attribute name */
    protected String name;
    /** TODO: Model Documentation for attribute serial */
    protected String serial;
    /** TODO: Model Documentation for attribute ownerName */
    protected String ownerName;
    /** TODO: Model Documentation for attribute year */
    protected Date year;
    /** TODO: Model Documentation for attribute timesRented */
    protected int timesRented;
    /**
     * boolean setter for primitive attribute, so we can tell if it's initialized
     */
    protected boolean setTimesRented = false;

    /** Default Constructor with no properties */
    public CarDetails()
    {
        // Documented empty block - avoid compiler warning - no super constructor
    }

    /**
     * Constructor with all properties
     * @param nameIn String
     * @param serialIn String
     * @param ownerNameIn String
     * @param yearIn Date
     * @param timesRentedIn int
     */
    public CarDetails(final String nameIn, final String serialIn, final String ownerNameIn, final Date yearIn, final int timesRentedIn)
    {
        this.name = nameIn;
        this.serial = serialIn;
        this.ownerName = ownerNameIn;
        this.year = yearIn;
        this.timesRented = timesRentedIn;
        this.setTimesRented = true;
    }

    /**
     * Copies constructor from other CarDetails
     *
     * @param otherBean Cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public CarDetails(final CarDetails otherBean)
    {
        this.name = otherBean.getName();
        this.serial = otherBean.getSerial();
        this.ownerName = otherBean.getOwnerName();
        this.year = otherBean.getYear();
        this.timesRented = otherBean.getTimesRented();
        this.setTimesRented = true;
    }

    /**
     * Copies all properties from the argument value object into this value object.
     * @param otherBean Cannot be <code>null</code>
     */
    public void copy(final CarDetails otherBean)
    {
        if (null != otherBean)
        {
            this.setName(otherBean.getName());
            this.setSerial(otherBean.getSerial());
            this.setOwnerName(otherBean.getOwnerName());
            this.setYear(otherBean.getYear());
            this.setTimesRented(otherBean.getTimesRented());
            this.setTimesRented = true;
        }
    }

    /**
     * TODO: Model Documentation for attribute name
     * Get the name Attribute
     * @return name String
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * 
     * @param value String
     */
    public void setName(final String value)
    {
        this.name = value;
    }

    /**
     * TODO: Model Documentation for attribute serial
     * Get the serial Attribute
     * @return serial String
     */
    public String getSerial()
    {
        return this.serial;
    }

    /**
     * 
     * @param value String
     */
    public void setSerial(final String value)
    {
        this.serial = value;
    }

    /**
     * TODO: Model Documentation for attribute ownerName
     * Get the ownerName Attribute
     * @return ownerName String
     */
    public String getOwnerName()
    {
        return this.ownerName;
    }

    /**
     * 
     * @param value String
     */
    public void setOwnerName(final String value)
    {
        this.ownerName = value;
    }

    /**
     * TODO: Model Documentation for attribute year
     * Get the year Attribute
     * @return year Date
     */
    public Date getYear()
    {
        return this.year;
    }

    /**
     * 
     * @param value Date
     */
    public void setYear(final Date value)
    {
        this.year = value;
    }

    /**
     * TODO: Model Documentation for attribute timesRented
     * Get the timesRented Attribute
     * @return timesRented int
     */
    public int getTimesRented()
    {
        return this.timesRented;
    }

    /**
     * 
     * @param value int
     */
    public void setTimesRented(final int value)
    {
        this.timesRented = value;
        this.setTimesRented = true;
    }

    /**
     * Return true if the primitive attribute timesRented is set, through the setter or constructor
     * @return true if the attribute value has been set
     */
    public boolean isSetTimesRented()
    {
        return this.setTimesRented;
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
        CarDetails rhs = (CarDetails) object;
        return new EqualsBuilder()
            .append(this.getName(), rhs.getName())
            .append(this.getSerial(), rhs.getSerial())
            .append(this.getOwnerName(), rhs.getOwnerName())
            .append(this.getYear(), rhs.getYear())
            .append(this.getTimesRented(), rhs.getTimesRented())
            .isEquals();
    }

    /**
     * @param object to compare this object against
     * @return int if equal
     * @see Comparable#compareTo(Object)
     */
    public int compareTo(final CarDetails object)
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
            .append(this.getName(), object.getName())
            .append(this.getSerial(), object.getSerial())
            .append(this.getOwnerName(), object.getOwnerName())
            .append(this.getYear(), object.getYear())
            .append(this.getTimesRented(), object.getTimesRented())
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
            .append(this.getName())
            .append(this.getSerial())
            .append(this.getOwnerName())
            .append(this.getYear())
            .append(this.getTimesRented())
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
            .append("name", this.getName())
            .append("serial", this.getSerial())
            .append("ownerName", this.getOwnerName())
            .append("year", this.getYear())
            .append("timesRented", this.getTimesRented())
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

        final CarDetails that = (CarDetails)thatObject;

        return
            equal(this.getName(), that.getName())
            && equal(this.getSerial(), that.getSerial())
            && equal(this.getOwnerName(), that.getOwnerName())
            && equal(this.getYear(), that.getYear())
            && equal(this.getTimesRented(), that.getTimesRented())
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

    // CarDetails value-object java merge-point
}
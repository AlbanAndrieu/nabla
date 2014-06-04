// license-header java merge-point
//
/**
 * Attention: Generated code! Do not modify by hand!!
 *
 * TEMPLATE:     ValueObject.vsl in andromda-java-cartridge.
 * MODEL CLASS:  TimeTracker::TimeTracker::org.andromda.timetracker::vo::TimePeriodVO
 * STEREOTYPE:   ValueObject
 */
package org.andromda.timetracker.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * TODO: Model Documentation for TimePeriodVO
 */
public class TimePeriodVO
    implements Serializable, Comparable<TimePeriodVO>
{
    /** The serial version UID of this class. Needed for serialization. */
    private static final long serialVersionUID = 20317410267177457L;

    // Class attributes
    /**
     * TODO: Model Documentation for TimePeriodVO.startTime
     */
    protected Date startTime;
    /**
     * TODO: Model Documentation for TimePeriodVO.endTime
     */
    protected Date endTime;

    /** Default Constructor with no properties */
    public TimePeriodVO()
    {
        // Documented empty block - avoid compiler warning - no super constructor
    }

    /**
     * Constructor with all properties
     * @param startTimeIn Date
     * @param endTimeIn Date
     */
    public TimePeriodVO(final Date startTimeIn, final Date endTimeIn)
    {
        this.startTime = startTimeIn;
        this.endTime = endTimeIn;
    }

    /**
     * Copies constructor from other TimePeriodVO
     *
     * @param otherBean Cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public TimePeriodVO(final TimePeriodVO otherBean)
    {
        this.startTime = otherBean.getStartTime();
        this.endTime = otherBean.getEndTime();
    }

    /**
     * Copies all properties from the argument value object into this value object.
     * @param otherBean Cannot be <code>null</code>
     */
    public void copy(final TimePeriodVO otherBean)
    {
        if (null != otherBean)
        {
            this.setStartTime(otherBean.getStartTime());
            this.setEndTime(otherBean.getEndTime());
        }
    }

    /**
     * TODO: Model Documentation for TimePeriodVO.startTime
     * Get the startTime Attribute
     * @return startTime Date
     */
    public Date getStartTime()
    {
        return this.startTime;
    }

    /**
     * TODO: Model Documentation for TimePeriodVO.startTime
     * @param value Date
     */
    public void setStartTime(final Date value)
    {
        this.startTime = value;
    }

    /**
     * TODO: Model Documentation for TimePeriodVO.endTime
     * Get the endTime Attribute
     * @return endTime Date
     */
    public Date getEndTime()
    {
        return this.endTime;
    }

    /**
     * TODO: Model Documentation for TimePeriodVO.endTime
     * @param value Date
     */
    public void setEndTime(final Date value)
    {
        this.endTime = value;
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
        TimePeriodVO rhs = (TimePeriodVO) object;
        return new EqualsBuilder()
            .append(this.getStartTime(), rhs.getStartTime())
            .append(this.getEndTime(), rhs.getEndTime())
            .isEquals();
    }

    /**
     * @param object to compare this object against
     * @return int if equal
     * @see Comparable#compareTo(Object)
     */
    public int compareTo(final TimePeriodVO object)
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
            .append(this.getStartTime(), object.getStartTime())
            .append(this.getEndTime(), object.getEndTime())
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
            .append(this.getStartTime())
            .append(this.getEndTime())
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
            .append("startTime", this.getStartTime())
            .append("endTime", this.getEndTime())
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

        final TimePeriodVO that = (TimePeriodVO)thatObject;

        return
            equal(this.getStartTime(), that.getStartTime())
            && equal(this.getEndTime(), that.getEndTime())
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

    // TimePeriodVO value-object java merge-point
}
// license-header java merge-point
//
/**
 * Attention: Generated code! Do not modify by hand!!
 *
 * TEMPLATE:     ValueObject.vsl in andromda-java-cartridge.
 * MODEL CLASS:  TimeTracker::TimeTracker::org.andromda.timetracker::vo::TimeAllocationVO
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
 * TODO: Model Documentation for TimeAllocationVO
 */
public class TimeAllocationVO
    implements Serializable, Comparable<TimeAllocationVO>
{
    /** The serial version UID of this class. Needed for serialization. */
    private static final long serialVersionUID = -3871073062522340607L;

    // Class attributes
    /**
     * TODO: Model Documentation for TimeAllocationVO.id
     */
    protected Long id;
    /**
     * TODO: Model Documentation for TimeAllocationVO.timePeriodVO
     */
    protected TimePeriodVO timePeriodVO;
    /**
     * TODO: Model Documentation for TimeAllocationVO.taskId
     */
    protected Long taskId;

    /** Default Constructor with no properties */
    public TimeAllocationVO()
    {
        // Documented empty block - avoid compiler warning - no super constructor
    }

    /**
     * Constructor taking only required properties
     * @param timePeriodVOIn TimePeriodVO TODO: Model Documentation for TimeAllocationVO.timePeriodVO
     */
    public TimeAllocationVO(final TimePeriodVO timePeriodVOIn)
    {
        this.timePeriodVO = timePeriodVOIn;
    }

    /**
     * Constructor with all properties
     * @param idIn Long
     * @param timePeriodVOIn TimePeriodVO
     * @param taskIdIn Long
     */
    public TimeAllocationVO(final Long idIn, final TimePeriodVO timePeriodVOIn, final Long taskIdIn)
    {
        this.id = idIn;
        this.timePeriodVO = timePeriodVOIn;
        this.taskId = taskIdIn;
    }

    /**
     * Copies constructor from other TimeAllocationVO
     *
     * @param otherBean Cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public TimeAllocationVO(final TimeAllocationVO otherBean)
    {
        this.id = otherBean.getId();
        this.timePeriodVO = otherBean.getTimePeriodVO();
        this.taskId = otherBean.getTaskId();
    }

    /**
     * Copies all properties from the argument value object into this value object.
     * @param otherBean Cannot be <code>null</code>
     */
    public void copy(final TimeAllocationVO otherBean)
    {
        if (null != otherBean)
        {
            this.setId(otherBean.getId());
            this.setTimePeriodVO(otherBean.getTimePeriodVO());
            this.setTaskId(otherBean.getTaskId());
        }
    }

    /**
     * TODO: Model Documentation for TimeAllocationVO.id
     * Get the id Attribute
     * @return id Long
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * TODO: Model Documentation for TimeAllocationVO.id
     * @param value Long
     */
    public void setId(final Long value)
    {
        this.id = value;
    }

    /**
     * TODO: Model Documentation for TimeAllocationVO.timePeriodVO
     * Get the timePeriodVO Attribute
     * @return timePeriodVO TimePeriodVO
     */
    public TimePeriodVO getTimePeriodVO()
    {
        return this.timePeriodVO;
    }

    /**
     * TODO: Model Documentation for TimeAllocationVO.timePeriodVO
     * @param value TimePeriodVO
     */
    public void setTimePeriodVO(final TimePeriodVO value)
    {
        this.timePeriodVO = value;
    }

    /**
     * TODO: Model Documentation for TimeAllocationVO.taskId
     * Get the taskId Attribute
     * @return taskId Long
     */
    public Long getTaskId()
    {
        return this.taskId;
    }

    /**
     * TODO: Model Documentation for TimeAllocationVO.taskId
     * @param value Long
     */
    public void setTaskId(final Long value)
    {
        this.taskId = value;
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
        TimeAllocationVO rhs = (TimeAllocationVO) object;
        return new EqualsBuilder()
            .append(this.getId(), rhs.getId())
            .append(this.getTimePeriodVO(), rhs.getTimePeriodVO())
            .append(this.getTaskId(), rhs.getTaskId())
            .isEquals();
    }

    /**
     * @param object to compare this object against
     * @return int if equal
     * @see Comparable#compareTo(Object)
     */
    public int compareTo(final TimeAllocationVO object)
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
            .append(this.getTimePeriodVO(), object.getTimePeriodVO())
            .append(this.getTaskId(), object.getTaskId())
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
            .append(this.getTimePeriodVO())
            .append(this.getTaskId())
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
            .append("timePeriodVO", this.getTimePeriodVO())
            .append("taskId", this.getTaskId())
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

        final TimeAllocationVO that = (TimeAllocationVO)thatObject;

        return
            equal(this.getId(), that.getId())
            && equal(this.getTimePeriodVO(), that.getTimePeriodVO())
            && equal(this.getTaskId(), that.getTaskId())
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

    // TimeAllocationVO value-object java merge-point
}
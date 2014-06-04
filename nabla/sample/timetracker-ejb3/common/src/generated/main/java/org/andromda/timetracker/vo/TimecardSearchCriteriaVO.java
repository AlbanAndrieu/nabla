// license-header java merge-point
//
/**
 * Attention: Generated code! Do not modify by hand!!
 *
 * TEMPLATE:     ValueObject.vsl in andromda-java-cartridge.
 * MODEL CLASS:  TimeTracker::TimeTracker::org.andromda.timetracker::vo::TimecardSearchCriteriaVO
 * STEREOTYPE:   ValueObject
 */
package org.andromda.timetracker.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import org.andromda.timetracker.domain.TimecardStatus;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * TODO: Model Documentation for TimecardSearchCriteriaVO
 */
public class TimecardSearchCriteriaVO
    implements Serializable, Comparable<TimecardSearchCriteriaVO>
{
    /** The serial version UID of this class. Needed for serialization. */
    private static final long serialVersionUID = -4922460977778596080L;

    // Class attributes
    /**
     * TODO: Model Documentation for
     * TimecardSearchCriteriaVO.submitterId
     */
    protected Long submitterId;
    /**
     * TODO: Model Documentation for TimecardSearchCriteriaVO.approverId
     */
    protected Long approverId;
    /**
     * TODO: Model Documentation for TimecardSearchCriteriaVO.status
     */
    protected TimecardStatus status;
    /**
     * TODO: Model Documentation for
     * TimecardSearchCriteriaVO.startDateMin
     */
    protected Date startDateMin;
    /**
     * TODO: Model Documentation for
     * TimecardSearchCriteriaVO.startDateMax
     */
    protected Date startDateMax;

    /**
     * Constructor taking only required properties
     */
    public TimecardSearchCriteriaVO()
    {
        // Documented empty block - avoid compiler warning - no super constructor
    }

    /**
     * Constructor with all properties
     * @param submitterIdIn Long
     * @param approverIdIn Long
     * @param statusIn TimecardStatus
     * @param startDateMinIn Date
     * @param startDateMaxIn Date
     */
    public TimecardSearchCriteriaVO(final Long submitterIdIn, final Long approverIdIn, final TimecardStatus statusIn, final Date startDateMinIn, final Date startDateMaxIn)
    {
        this.submitterId = submitterIdIn;
        this.approverId = approverIdIn;
        this.status = statusIn;
        this.startDateMin = startDateMinIn;
        this.startDateMax = startDateMaxIn;
    }

    /**
     * Copies constructor from other TimecardSearchCriteriaVO
     *
     * @param otherBean Cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public TimecardSearchCriteriaVO(final TimecardSearchCriteriaVO otherBean)
    {
        this.submitterId = otherBean.getSubmitterId();
        this.approverId = otherBean.getApproverId();
        this.status = otherBean.getStatus();
        this.startDateMin = otherBean.getStartDateMin();
        this.startDateMax = otherBean.getStartDateMax();
    }

    /**
     * Copies all properties from the argument value object into this value object.
     * @param otherBean Cannot be <code>null</code>
     */
    public void copy(final TimecardSearchCriteriaVO otherBean)
    {
        if (null != otherBean)
        {
            this.setSubmitterId(otherBean.getSubmitterId());
            this.setApproverId(otherBean.getApproverId());
            this.setStatus(otherBean.getStatus());
            this.setStartDateMin(otherBean.getStartDateMin());
            this.setStartDateMax(otherBean.getStartDateMax());
        }
    }

    /**
     * TODO: Model Documentation for
     * TimecardSearchCriteriaVO.submitterId
     * Get the submitterId Attribute
     * @return submitterId Long
     */
    public Long getSubmitterId()
    {
        return this.submitterId;
    }

    /**
     * TODO: Model Documentation for
     * TimecardSearchCriteriaVO.submitterId
     * @param value Long
     */
    public void setSubmitterId(final Long value)
    {
        this.submitterId = value;
    }

    /**
     * TODO: Model Documentation for TimecardSearchCriteriaVO.approverId
     * Get the approverId Attribute
     * @return approverId Long
     */
    public Long getApproverId()
    {
        return this.approverId;
    }

    /**
     * TODO: Model Documentation for TimecardSearchCriteriaVO.approverId
     * @param value Long
     */
    public void setApproverId(final Long value)
    {
        this.approverId = value;
    }

    /**
     * TODO: Model Documentation for TimecardSearchCriteriaVO.status
     * Get the status Attribute
     * @return status TimecardStatus
     */
    public TimecardStatus getStatus()
    {
        return this.status;
    }

    /**
     * TODO: Model Documentation for TimecardSearchCriteriaVO.status
     * @param value TimecardStatus
     */
    public void setStatus(final TimecardStatus value)
    {
        this.status = value;
    }

    /**
     * TODO: Model Documentation for
     * TimecardSearchCriteriaVO.startDateMin
     * Get the startDateMin Attribute
     * @return startDateMin Date
     */
    public Date getStartDateMin()
    {
        return this.startDateMin;
    }

    /**
     * TODO: Model Documentation for
     * TimecardSearchCriteriaVO.startDateMin
     * @param value Date
     */
    public void setStartDateMin(final Date value)
    {
        this.startDateMin = value;
    }

    /**
     * TODO: Model Documentation for
     * TimecardSearchCriteriaVO.startDateMax
     * Get the startDateMax Attribute
     * @return startDateMax Date
     */
    public Date getStartDateMax()
    {
        return this.startDateMax;
    }

    /**
     * TODO: Model Documentation for
     * TimecardSearchCriteriaVO.startDateMax
     * @param value Date
     */
    public void setStartDateMax(final Date value)
    {
        this.startDateMax = value;
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
        TimecardSearchCriteriaVO rhs = (TimecardSearchCriteriaVO) object;
        return new EqualsBuilder()
            .append(this.getSubmitterId(), rhs.getSubmitterId())
            .append(this.getApproverId(), rhs.getApproverId())
            .append(this.getStatus(), rhs.getStatus())
            .append(this.getStartDateMin(), rhs.getStartDateMin())
            .append(this.getStartDateMax(), rhs.getStartDateMax())
            .isEquals();
    }

    /**
     * @param object to compare this object against
     * @return int if equal
     * @see Comparable#compareTo(Object)
     */
    public int compareTo(final TimecardSearchCriteriaVO object)
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
            .append(this.getSubmitterId(), object.getSubmitterId())
            .append(this.getApproverId(), object.getApproverId())
            .append(this.getStatus(), object.getStatus())
            .append(this.getStartDateMin(), object.getStartDateMin())
            .append(this.getStartDateMax(), object.getStartDateMax())
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
            .append(this.getSubmitterId())
            .append(this.getApproverId())
            .append(this.getStatus())
            .append(this.getStartDateMin())
            .append(this.getStartDateMax())
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
            .append("submitterId", this.getSubmitterId())
            .append("approverId", this.getApproverId())
            .append("status", this.getStatus())
            .append("startDateMin", this.getStartDateMin())
            .append("startDateMax", this.getStartDateMax())
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

        final TimecardSearchCriteriaVO that = (TimecardSearchCriteriaVO)thatObject;

        return
            equal(this.getSubmitterId(), that.getSubmitterId())
            && equal(this.getApproverId(), that.getApproverId())
            && equal(this.getStatus(), that.getStatus())
            && equal(this.getStartDateMin(), that.getStartDateMin())
            && equal(this.getStartDateMax(), that.getStartDateMax())
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

    // TimecardSearchCriteriaVO value-object java merge-point
}
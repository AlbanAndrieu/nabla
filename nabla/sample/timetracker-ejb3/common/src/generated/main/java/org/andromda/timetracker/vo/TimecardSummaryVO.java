// license-header java merge-point
//
/**
 * Attention: Generated code! Do not modify by hand!!
 *
 * TEMPLATE:     ValueObject.vsl in andromda-java-cartridge.
 * MODEL CLASS:  TimeTracker::TimeTracker::org.andromda.timetracker::vo::TimecardSummaryVO
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
 * TODO: Model Documentation for TimecardSummaryVO
 */
public class TimecardSummaryVO
    implements Serializable, Comparable<TimecardSummaryVO>
{
    /** The serial version UID of this class. Needed for serialization. */
    private static final long serialVersionUID = -1821740768280350818L;

    // Class attributes
    /**
     * TODO: Model Documentation for TimecardSummaryVO.id
     */
    protected Long id;
    /**
     * TODO: Model Documentation for TimecardSummaryVO.status
     */
    protected TimecardStatus status;
    /**
     * TODO: Model Documentation for TimecardSummaryVO.startDate
     */
    protected Date startDate;
    /**
     * TODO: Model Documentation for TimecardSummaryVO.comments
     */
    protected String comments;
    /**
     * TODO: Model Documentation for TimecardSummaryVO.submitterName
     */
    protected String submitterName;
    /**
     * TODO: Model Documentation for TimecardSummaryVO.approverName
     */
    protected String approverName;

    /** Default Constructor with no properties */
    public TimecardSummaryVO()
    {
        // Documented empty block - avoid compiler warning - no super constructor
    }

    /**
     * Constructor taking only required properties
     * @param statusIn TimecardStatus TODO: Model Documentation for TimecardSummaryVO.status
     * @param startDateIn Date TODO: Model Documentation for TimecardSummaryVO.startDate
     * @param commentsIn String TODO: Model Documentation for TimecardSummaryVO.comments
     * @param submitterNameIn String TODO: Model Documentation for TimecardSummaryVO.submitterName
     * @param approverNameIn String TODO: Model Documentation for TimecardSummaryVO.approverName
     */
    public TimecardSummaryVO(final TimecardStatus statusIn, final Date startDateIn, final String commentsIn, final String submitterNameIn, final String approverNameIn)
    {
        this.status = statusIn;
        this.startDate = startDateIn;
        this.comments = commentsIn;
        this.submitterName = submitterNameIn;
        this.approverName = approverNameIn;
    }

    /**
     * Constructor with all properties
     * @param idIn Long
     * @param statusIn TimecardStatus
     * @param startDateIn Date
     * @param commentsIn String
     * @param submitterNameIn String
     * @param approverNameIn String
     */
    public TimecardSummaryVO(final Long idIn, final TimecardStatus statusIn, final Date startDateIn, final String commentsIn, final String submitterNameIn, final String approverNameIn)
    {
        this.id = idIn;
        this.status = statusIn;
        this.startDate = startDateIn;
        this.comments = commentsIn;
        this.submitterName = submitterNameIn;
        this.approverName = approverNameIn;
    }

    /**
     * Copies constructor from other TimecardSummaryVO
     *
     * @param otherBean Cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public TimecardSummaryVO(final TimecardSummaryVO otherBean)
    {
        this.id = otherBean.getId();
        this.status = otherBean.getStatus();
        this.startDate = otherBean.getStartDate();
        this.comments = otherBean.getComments();
        this.submitterName = otherBean.getSubmitterName();
        this.approverName = otherBean.getApproverName();
    }

    /**
     * Copies all properties from the argument value object into this value object.
     * @param otherBean Cannot be <code>null</code>
     */
    public void copy(final TimecardSummaryVO otherBean)
    {
        if (null != otherBean)
        {
            this.setId(otherBean.getId());
            this.setStatus(otherBean.getStatus());
            this.setStartDate(otherBean.getStartDate());
            this.setComments(otherBean.getComments());
            this.setSubmitterName(otherBean.getSubmitterName());
            this.setApproverName(otherBean.getApproverName());
        }
    }

    /**
     * TODO: Model Documentation for TimecardSummaryVO.id
     * Get the id Attribute
     * @return id Long
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * TODO: Model Documentation for TimecardSummaryVO.id
     * @param value Long
     */
    public void setId(final Long value)
    {
        this.id = value;
    }

    /**
     * TODO: Model Documentation for TimecardSummaryVO.status
     * Get the status Attribute
     * @return status TimecardStatus
     */
    public TimecardStatus getStatus()
    {
        return this.status;
    }

    /**
     * TODO: Model Documentation for TimecardSummaryVO.status
     * @param value TimecardStatus
     */
    public void setStatus(final TimecardStatus value)
    {
        this.status = value;
    }

    /**
     * TODO: Model Documentation for TimecardSummaryVO.startDate
     * Get the startDate Attribute
     * @return startDate Date
     */
    public Date getStartDate()
    {
        return this.startDate;
    }

    /**
     * TODO: Model Documentation for TimecardSummaryVO.startDate
     * @param value Date
     */
    public void setStartDate(final Date value)
    {
        this.startDate = value;
    }

    /**
     * TODO: Model Documentation for TimecardSummaryVO.comments
     * Get the comments Attribute
     * @return comments String
     */
    public String getComments()
    {
        return this.comments;
    }

    /**
     * TODO: Model Documentation for TimecardSummaryVO.comments
     * @param value String
     */
    public void setComments(final String value)
    {
        this.comments = value;
    }

    /**
     * TODO: Model Documentation for TimecardSummaryVO.submitterName
     * Get the submitterName Attribute
     * @return submitterName String
     */
    public String getSubmitterName()
    {
        return this.submitterName;
    }

    /**
     * TODO: Model Documentation for TimecardSummaryVO.submitterName
     * @param value String
     */
    public void setSubmitterName(final String value)
    {
        this.submitterName = value;
    }

    /**
     * TODO: Model Documentation for TimecardSummaryVO.approverName
     * Get the approverName Attribute
     * @return approverName String
     */
    public String getApproverName()
    {
        return this.approverName;
    }

    /**
     * TODO: Model Documentation for TimecardSummaryVO.approverName
     * @param value String
     */
    public void setApproverName(final String value)
    {
        this.approverName = value;
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
        TimecardSummaryVO rhs = (TimecardSummaryVO) object;
        return new EqualsBuilder()
            .append(this.getId(), rhs.getId())
            .append(this.getStatus(), rhs.getStatus())
            .append(this.getStartDate(), rhs.getStartDate())
            .append(this.getComments(), rhs.getComments())
            .append(this.getSubmitterName(), rhs.getSubmitterName())
            .append(this.getApproverName(), rhs.getApproverName())
            .isEquals();
    }

    /**
     * @param object to compare this object against
     * @return int if equal
     * @see Comparable#compareTo(Object)
     */
    public int compareTo(final TimecardSummaryVO object)
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
            .append(this.getStatus(), object.getStatus())
            .append(this.getStartDate(), object.getStartDate())
            .append(this.getComments(), object.getComments())
            .append(this.getSubmitterName(), object.getSubmitterName())
            .append(this.getApproverName(), object.getApproverName())
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
            .append(this.getStatus())
            .append(this.getStartDate())
            .append(this.getComments())
            .append(this.getSubmitterName())
            .append(this.getApproverName())
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
            .append("status", this.getStatus())
            .append("startDate", this.getStartDate())
            .append("comments", this.getComments())
            .append("submitterName", this.getSubmitterName())
            .append("approverName", this.getApproverName())
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

        final TimecardSummaryVO that = (TimecardSummaryVO)thatObject;

        return
            equal(this.getId(), that.getId())
            && equal(this.getStatus(), that.getStatus())
            && equal(this.getStartDate(), that.getStartDate())
            && equal(this.getComments(), that.getComments())
            && equal(this.getSubmitterName(), that.getSubmitterName())
            && equal(this.getApproverName(), that.getApproverName())
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

    // TimecardSummaryVO value-object java merge-point
}
// license-header java merge-point
//
/**
 * Attention: Generated code! Do not modify by hand!!
 *
 * TEMPLATE:     ValueObject.vsl in andromda-java-cartridge.
 * MODEL CLASS:  TimeTracker::TimeTracker::org.andromda.timetracker::vo::TimecardVO
 * STEREOTYPE:   ValueObject
 */
package org.andromda.timetracker.vo;

import java.util.Date;
import org.andromda.timetracker.domain.TimecardStatus;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * TODO: Model Documentation for TimecardVO
 */
public class TimecardVO
    extends TimecardSummaryVO
{
    /** The serial version UID of this class. Needed for serialization. */
    private static final long serialVersionUID = 6418926857174063619L;

    // Class attributes
    /**
     * TODO: Model Documentation for TimecardVO.allocations
     */
    protected TimeAllocationVO[] allocations;

    /** Default Constructor with no properties */
    public TimecardVO()
    {
        super();
    }

    /**
     * Constructor taking only required properties
     * @param statusIn TimecardStatus TODO: Model Documentation for TimecardSummaryVO.status
     * @param startDateIn Date TODO: Model Documentation for TimecardSummaryVO.startDate
     * @param commentsIn String TODO: Model Documentation for TimecardSummaryVO.comments
     * @param submitterNameIn String TODO: Model Documentation for TimecardSummaryVO.submitterName
     * @param approverNameIn String TODO: Model Documentation for TimecardSummaryVO.approverName
     * @param allocationsIn TimeAllocationVO[] TODO: Model Documentation for TimecardVO.allocations
     */
    public TimecardVO(final TimecardStatus statusIn, final Date startDateIn, final String commentsIn, final String submitterNameIn, final String approverNameIn, final TimeAllocationVO[] allocationsIn)
    {
        super(statusIn, startDateIn, commentsIn, submitterNameIn, approverNameIn);
        this.allocations = allocationsIn;
    }

    /**
     * Constructor with all properties
     * @param idIn Long
     * @param statusIn TimecardStatus
     * @param startDateIn Date
     * @param commentsIn String
     * @param submitterNameIn String
     * @param approverNameIn String
     * @param allocationsIn TimeAllocationVO[]
     */
    public TimecardVO(final Long idIn, final TimecardStatus statusIn, final Date startDateIn, final String commentsIn, final String submitterNameIn, final String approverNameIn, final TimeAllocationVO[] allocationsIn)
    {
        super(idIn, statusIn, startDateIn, commentsIn, submitterNameIn, approverNameIn);
        this.allocations = allocationsIn;
    }

    /**
     * Copies constructor from other TimecardVO
     *
     * @param otherBean Cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public TimecardVO(final TimecardVO otherBean)
    {
        super(otherBean);
        this.allocations = otherBean.getAllocations();
    }

    /**
     * Copies all properties from the argument value object into this value object.
     * @param otherBean Cannot be <code>null</code>
     */
    public void copy(final TimecardVO otherBean)
    {
        if (null != otherBean)
        {
            super.copy(otherBean);
            this.setAllocations(otherBean.getAllocations());
        }
    }

    /**
     * TODO: Model Documentation for TimecardVO.allocations
     * Get the allocations Attribute
     * @return allocations TimeAllocationVO[]
     */
    public TimeAllocationVO[] getAllocations()
    {
        return this.allocations;
    }

    /**
     * TODO: Model Documentation for TimecardVO.allocations
     * @param value TimeAllocationVO[]
     */
    public void setAllocations(final TimeAllocationVO[] value)
    {
        this.allocations = value;
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
        TimecardVO rhs = (TimecardVO) object;
        return new EqualsBuilder()
            .appendSuper(super.equals(object))
            .append(this.getAllocations(), rhs.getAllocations())
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
        if (!(object instanceof TimecardVO))
        {
            return -1;
        }
        TimecardVO myClass = (TimecardVO)object;
        return new CompareToBuilder()
            .appendSuper(super.compareTo(object))
            .append(this.getAllocations(), myClass.getAllocations())
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
            .append(this.getAllocations())
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
            .append("allocations", this.getAllocations())
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

        final TimecardVO that = (TimecardVO)thatObject;

        return super.equalProperties(that)
            && equal(this.getAllocations(), that.getAllocations())
        ;
    }

    // TimecardVO value-object java merge-point
}
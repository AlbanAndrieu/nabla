// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by EntityEmbeddable.vsl in andromda-ejb3-cartridge on 04/03/2012 12:18:27.
//
package org.andromda.timetracker.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Autogenerated POJO EJB mapped super class for Timecard containing the
 * bulk of the entity implementation.
 *
 * This is a mapped super class and autogenerated by AndroMDA using the EJB3
 * cartridge.
 *
 * DO NOT MODIFY this class.
 *
 * This class represents a timecard submitted by a person.
 */
@MappedSuperclass
public abstract class TimecardEmbeddable
    implements Serializable
{
    private static final long serialVersionUID = -635666710596476780L;

    // ----------- 4 Attribute Definitions ------------
    private TimecardStatus status;
    private Date startDate;
    private String comments;
    private Long id;

    // --------- 3 Relationship Definitions -----------
    private User approver;
    private User submitter;
    private Set<TimeAllocation> allocations = new TreeSet<TimeAllocation>();

    // ---- Manageable Display Attributes (Transient) -----
    private String approverLabel;       // Manageable display attribute
    private String submitterLabel;       // Manageable display attribute

    // -------- 4 Attribute Accessors ----------
    /**
     * Get the status property.
     * 
     * @return TimecardStatus The value of status
     */
    @Column(name = "STATUS", nullable = false, insertable = true, updatable = true, columnDefinition = "VARCHAR(20)")
    @Enumerated(EnumType.STRING)
    public TimecardStatus getStatus()
    {
        return this.status;
    }

    /**
     * Set the status property.
     * @param value the new value
     */
    public void setStatus(TimecardStatus value)
    {
        this.status = value;
    }

    /**
     * Get the startDate property.
     * 
     * @return Date The value of startDate
     */
    @Column(name = "START_DATE", nullable = false, insertable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getStartDate()
    {
        return this.startDate;
    }

    /**
     * Set the startDate property.
     * @param value the new value
     */
    public void setStartDate(Date value)
    {
        this.startDate = value;
    }

    /**
     * Get the comments property.
     * 
     * @return String The value of comments
     */
    @Column(name = "COMMENTS", nullable = false, insertable = true, updatable = true)
    public String getComments()
    {
        return this.comments;
    }

    /**
     * Set the comments property.
     * @param value the new value
     */
    public void setComments(String value)
    {
        this.comments = value;
    }

    /**
     * Get the id property.
     * 
     * @return Long The value of id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, insertable = true, updatable = true)
    public Long getId()
    {
        return this.id;
    }

    /**
     * Set the id property.
     * @param value the new value
     */
    public void setId(Long value)
    {
        this.id = value;
    }


    // ------------- 3 Relations ------------------
    /**
     * Get the approver
     *
     * @return User
     */
    @ManyToOne()
    @JoinColumn(name = "APPROVER_FK")
    public User getApprover()
    {
        return this.approver;
    }

   /**
    * Set the approver
    *
    * @param approverIn
    */
    public void setApprover(User approverIn)
    {
        this.approver = approverIn;
    }

    /**
     * Get the submitter
     *
     * @return User
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "SUBMITTER_FK")
    public User getSubmitter()
    {
        return this.submitter;
    }

   /**
    * Set the submitter
    *
    * @param submitterIn
    */
    public void setSubmitter(User submitterIn)
    {
        this.submitter = submitterIn;
    }

    /**
     * Get the allocations Collection
     *
     * @return Set<TimeAllocation>
     */
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE} ,mappedBy = "timecard")
    public Set<TimeAllocation> getAllocations()
    {
        return this.allocations;
    }

    /**
     * Set the allocations
     *
     * @param allocationsIn
     */
    public void setAllocations (Set<TimeAllocation> allocationsIn)
    {
        this.allocations = allocationsIn;
    }

    // -------- Manageable Attribute Display -----------
    /**
     * Get the approverLabel
     *
     * @return String

     */
    @Transient
    public String getApproverLabel()
    {
        return this.approverLabel;
    }

    /**
     * Set the approverLabel
     *
     * @param approverLabelIn
     */
    public void setApproverLabel (String approverLabelIn)
    {
        this.approverLabel = approverLabelIn;
    }

    /**
     * Get the submitterLabel
     *
     * @return String

     */
    @Transient
    public String getSubmitterLabel()
    {
        return this.submitterLabel;
    }

    /**
     * Set the submitterLabel
     *
     * @param submitterLabelIn
     */
    public void setSubmitterLabel (String submitterLabelIn)
    {
        this.submitterLabel = submitterLabelIn;
    }

    // --------------- Constructors -----------------

    /**
     * Default empty constructor
     */
    public TimecardEmbeddable()
    {
        // Default empty constructor
    }

    /**
     * Implementation for the constructor with all POJO attributes except auto incremented identifiers.
     * This method sets all POJO fields defined in this class to the values provided by
     * the parameters.
     *
     * @param status Value for the status property
     * @param startDate Value for the startDate property
     * @param comments Value for the comments property
     */
    public TimecardEmbeddable(TimecardStatus status, Date startDate, String comments)
    {
        setStatus(status);
        setStartDate(startDate);
        setComments(comments);
    }

    /**
     * Constructor with all POJO attribute values and CMR relations.
     *
     * @param status Value for the status property
     * @param startDate Value for the startDate property
     * @param comments Value for the comments property
     * @param approver Value for the approver relation
     * @param submitter Value for the submitter relation
     * @param allocations Value for the allocations relation
     */
    public TimecardEmbeddable(TimecardStatus status, Date startDate, String comments, User approver, User submitter, Set<TimeAllocation> allocations)
    {
        setStatus(status);
        setStartDate(startDate);
        setComments(comments);

        setApprover(approver);
        setSubmitter(submitter);
        setAllocations(allocations);
    }

    // -------- Common Methods -----------

    /**
     * Indicates if the argument is of the same type and all values are equal.
     *
     * @param object The target object to compare with
     * @return boolean True if both objects a 'equal'
     */
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof TimecardEmbeddable))
        {
            return false;
        }
        final TimecardEmbeddable that = (TimecardEmbeddable)object;
        if (this.getId() == null || that.getId() == null || !this.getId().equals(that.getId()))
        {
            return false;
        }
        return true;
    }

    /**
     * Returns a hash code value for the object
     *
     * @return int The hash code value
     */
    public int hashCode()
    {
        int hashCode = 0;
        hashCode = 29 * hashCode + (getId() == null ? 0 : getId().hashCode());

        return hashCode;
    }

    /**
     * Returns a String representation of the object
     *
     * @return String Textual representation of the object displaying name/value pairs for all attributes
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("TimecardEmbeddable(=");
        sb.append("status: ");
        sb.append(getStatus());
        sb.append(", startDate: ");
        sb.append(getStartDate());
        sb.append(", comments: ");
        sb.append(getComments());
        sb.append(", id: ");
        sb.append(getId());
        sb.append(")");
        return sb.toString();
    }

}
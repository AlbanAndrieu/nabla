// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by Entity.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import org.andromda.timetracker.vo.TimecardSearchCriteriaVO;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Autogenerated POJO EJB3 implementation class for Timecard.
 *
 * Add any manual implementation within this class.  This class will NOT
 * be overwritten with incremental changes.
 *
 * This class represents a timecard submitted by a person.
 *
 */
@Entity
@Table(name = "TIMECARD", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
// Uncomment to enable entity listener for Timecard
// @javax.persistence.EntityListeners({org.andromda.timetracker.domain.TimecardListener.class})
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@NamedQuery(name = "Timecard.findAll", query = "select timecard from Timecard AS timecard")
public class Timecard extends TimecardEmbeddable implements Serializable, Comparable<Timecard>
{
    /**
     * The serial version UID of this class required for serialization.
     */
    private static final long serialVersionUID = -8810488711747049867L;

    // --------------- constructors -----------------

    /**
     * Default Timecard constructor
     */
    public Timecard()
    {
        super();
    }

    /**
     * Implementation for the constructor with all POJO attributes except auto incremented identifiers.
     * This method sets all POJO fields defined in this/super class to the
     * values provided by the parameters.
     *
     */
    public Timecard(String comments, Date startDate, TimecardStatus status)
    {
        super(comments, startDate, status);
    }

    /**
     * Constructor with all POJO attribute values and CMR relations.
     *
     * @param comments Value for the comments property
     * @param startDate Value for the startDate property
     * @param status Value for the status property
     * @param approver Value for the approver relation
     * @param submitter Value for the submitter relation
     * @param allocations Value for the allocations relation
     */
    public Timecard(String comments, Date startDate, TimecardStatus status, User approver, User submitter, Set<TimeAllocation> allocations)
    {
        super(comments, startDate, status, approver, submitter, allocations);
    }


    // -------------- Entity Methods -----------------

    /**
     * 
     */
    @Transient
    public void addTimeAllocation(TimeAllocation timeAllocation)
    {
        // TODO put your implementation here.
        throw new UnsupportedOperationException("org.andromda.timetracker.domain.Timecard.addTimeAllocation(TimeAllocation timeAllocation) Not implemented!");
    }

    /**
     * 
     */
    @Transient
    public static List findByCriteria(TimecardSearchCriteriaVO criteria)
    {
        // TODO put your implementation here.
        return null;
    }


    // --------------- Lifecycle callbacks -----------------

    /**
     * @see Comparable#compareTo(T)
     */
    public int compareTo(Timecard o)
    {
        int cmp = 0;
        if (this.getId() != null)
        {
            cmp = this.getId().compareTo(o.getId());
        }
        else
        {
            if (this.getComments() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getComments().compareTo(o.getComments()));
            }
            if (this.getStartDate() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getStartDate().compareTo(o.getStartDate()));
            }
            if (this.getStatus() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getStatus().compareTo(o.getStatus()));
            }
        }
        return cmp;
    }
}
// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by Entity.vsl in andromda-ejb3-cartridge on 03/25/2012 14:35:50.
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
import org.andromda.timetracker.vo.TimecardSearchCriteriaVO;

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
@Table(name = "TIMECARD")
// Uncomment to enable entity listener for Timecard
// @javax.persistence.EntityListeners({org.andromda.timetracker.domain.TimecardListener.class})
// Uncomment to enable caching for Timecard
// @org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.TRANSACTIONAL)
@NamedQuery(name = "Timecard.findAll", query = "select timecard from Timecard AS timecard")
public class Timecard
    extends TimecardEmbeddable
    implements Serializable, Comparable<Timecard>
{
    /**
     * The serial version UID of this class required for serialization.
     */
    private static final long serialVersionUID = -635666710596476780L;

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
    public Timecard(TimecardStatus status, Date startDate, String comments)
    {
        super(status, startDate, comments);
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
    public Timecard(TimecardStatus status, Date startDate, String comments, User approver, User submitter, Set<TimeAllocation> allocations)
    {
        super(status, startDate, comments, approver, submitter, allocations);
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
            if (this.getStatus() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getStatus().compareTo(o.getStatus()));
            }
            if (this.getStartDate() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getStartDate().compareTo(o.getStartDate()));
            }
            if (this.getComments() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getComments().compareTo(o.getComments()));
            }
        }
        return cmp;
    }
}
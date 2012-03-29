// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: hibernate/HibernateEntity.vsl overrided in andromda-hibernate-cartridge.
//
package org.andromda.timetracker.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * TimeAllocation represents a time period for which the timecard submitter worked on the associated
 * task.
 */
@XmlType(propOrder = {"timePeriod"})
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class TimeAllocation implements Serializable, Comparable<TimeAllocation>
 {
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 6048749692954952788L;

    // Generate 2 attributes
    @XmlTransient  
    @XmlElement(name = "timePeriod")
    private TimePeriod timePeriod;

    /**
     * 
     * @return this.timePeriod TimePeriod
     */
    public TimePeriod getTimePeriod()
    {
        return this.timePeriod;
    }

    /**
     * 
     * @param timePeriodIn TimePeriod
     */
    public void setTimePeriod(TimePeriod timePeriodIn)
    {
        this.timePeriod = timePeriodIn;
    }

    @XmlElement(name = "id")
    private Long id;

    /**
     * 
     * @return this.id Long
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * 
     * @param idIn Long
     */
    public void setId(Long idIn)
    {
        this.id = idIn;
    }

    // Generate 2 associations
    private Task task;

    /**
     * 
     * @return this.task Task
     */
    public Task getTask()
    {
        return this.task;
    }

    /**
     * 
     * @param taskIn Task
     */
    public void setTask(Task taskIn)
    {
        this.task = taskIn;
    }

    private Timecard timecard;

    /**
     * 
     * @return this.timecard Timecard
     */
    public Timecard getTimecard()
    {
        return this.timecard;
    }

    /**
     * 
     * @param timecardIn Timecard
     */
    public void setTimecard(Timecard timecardIn)
    {
        this.timecard = timecardIn;
    }

    /**
     * Returns <code>true</code> if the argument is an TimeAllocation instance and all identifiers for this entity
     * equal the identifiers of the argument entity. Returns <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof TimeAllocation))
        {
            return false;
        }
        final TimeAllocation that = (TimeAllocation)object;
        if (this.id == null || that.getId() == null || !this.id.equals(that.getId()))
        {
            return false;
        }
        return true;
    }

    /**
     * Returns a hash code based on this entity's identifiers.
     */
    @Override
    public int hashCode()
    {
        int hashCode = 0;
        hashCode = 29 * hashCode + (this.id == null ? 0 : this.id.hashCode());

        return hashCode;
    }

    /**
     * Constructs new instances of {@link TimeAllocation}.
     */
    public static final class Factory
    {
        /**
         * Constructs a new instance of {@link TimeAllocation}.
         * @return new TimeAllocationImpl()
         */
        public static TimeAllocation newInstance()
        {
            return new TimeAllocationImpl();
        }


        /**
         * Constructs a new instance of {@link TimeAllocation}, taking all possible properties
         * (except the identifier(s))as arguments.
         * @param timePeriod TimePeriod
         * @param task Task
         * @param timecard Timecard
         * @return newInstance TimeAllocation
         */
        public static TimeAllocation newInstance(TimePeriod timePeriod, Task task, Timecard timecard)
        {
            final TimeAllocation entityInstance = new TimeAllocationImpl();
            entityInstance.setTimePeriod(timePeriod);
            entityInstance.setTask(task);
            entityInstance.setTimecard(timecard);
            return entityInstance;
        }
    }

    /**
     * @see Comparable#compareTo
     */
    public int compareTo(TimeAllocation o)
    {
        int cmp = 0;
        if (this.getId() != null)
        {
            cmp = this.getId().compareTo(o.getId());
        }
        else
        {
            if (this.getTimePeriod() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getTimePeriod().compareTo(o.getTimePeriod()));
            }
        }
        return cmp;
    }
// HibernateEntity.vsl merge-point
}
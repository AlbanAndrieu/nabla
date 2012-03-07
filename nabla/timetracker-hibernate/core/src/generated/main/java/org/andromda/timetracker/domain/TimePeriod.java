// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: hibernate/HibernateEmbeddedValue.vsl in andromda-hibernate-cartridge.
//
package org.andromda.timetracker.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * A general representation of quanitities of anything. Consists of a value and a unit. For example,
 * 5.00 USD, 10 USD/hour, 100 meters, 100 meters/hour, 100 meters/(hour^2).
 */
public abstract class TimePeriod
    implements Serializable, Comparable<TimePeriod>
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = -708617510741626676L;

    /**
     * Creates a new instance of {@link TimePeriod}
     * taking all properties.
     * @param startTime
     * @param endTime
     * @return object
     */
    public static TimePeriod newInstance(Date startTime,Date endTime)
    {
        TimePeriodImpl object = new TimePeriodImpl();
        object.setStartTime(startTime);
        object.setEndTime(endTime);
        object.initialize();
        return object;
    }

    /**
     * Creates a new instance from other TimePeriod instance.
     * @param otherObject
     * @return newInstance
     */
    public static TimePeriod newInstance(TimePeriod otherObject)
    {
        if (otherObject != null)
        {
            return newInstance(otherObject.getStartTime(),otherObject.getEndTime());
        }
        return null;
    }

    /**
     * Default protected empty constructor
     */
    protected TimePeriod()
    {
        // Default protected empty constructor
    }

    /**
     * Hook for initializing the object in the subclass. Empty method.
     */
    protected void initialize()
    {
        // Empty block comment
    }

    // EmbeddedValue attributes

    private Date startTime;

    /**
     * 
     * @return startTime
     */
    public Date getStartTime()
    {
        return this.startTime;
    }

    /**
     * 
     * @param startTimeIn
     */
    public void setStartTime(Date startTimeIn)
    {
        this.startTime = startTimeIn;
    }

    private Date endTime;

    /**
     * 
     * @return endTime
     */
    public Date getEndTime()
    {
        return this.endTime;
    }

    /**
     * 
     * @param endTimeIn
     */
    public void setEndTime(Date endTimeIn)
    {
        this.endTime = endTimeIn;
    }

    /**
     * Indicates if the argument is of the same type and all values are equal.
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof TimePeriod))
        {
            return false;
        }
        final TimePeriod that = (TimePeriod)object;
        if (this.startTime == null || that.getStartTime() == null || !this.startTime.equals(that.getStartTime()))
        {
            return false;
        }
        if (this.endTime == null || that.getEndTime() == null || !this.endTime.equals(that.getEndTime()))
        {
            return false;
        }
        return true;
    }

    /**
     * Returns a hash code based on this entity's identifiers.
     * @see Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        int hashCode = 0;
        hashCode = 29 * hashCode + (this.startTime == null ? 0 : this.startTime.hashCode());
        hashCode = 29 * hashCode + (this.endTime == null ? 0 : this.endTime.hashCode());

        return hashCode;
    }
    /**
     * @see Comparable#compareTo
     */
    public int compareTo(TimePeriod o)
    {
        int cmp = 0;
            if (this.getStartTime() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getStartTime().compareTo(o.getStartTime()));
            }
            if (this.getEndTime() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getEndTime().compareTo(o.getEndTime()));
            }
        return cmp;
    }
}
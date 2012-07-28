// license-header java merge-point
/* Autogenerated by AndroMDA EntityCompositePK.vsl in andromda-ejb3-cartridge - do not edit */
package org.andromda.test.howto4.a;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * Composite primary key class for Car entity bean.
 * 
 */
@Embeddable
public class CarPK
    implements Serializable, Comparable<CarPK>
{
    private static final long serialVersionUID = 1L;
    private String serial;
    private String name;

    /**
     * Get the serial property.
     * 
     * @return String The value of serial
     */
    public String getSerial()
    {
        return this.serial;
    }

    /**
     * Set the serial property.
     * @param value the new value
     */
    public void setSerial(String value)
    {
        this.serial = value;
    }

    /**
     * Get the name property.
     * 
     * @return String The value of name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Set the name property.
     * @param value the new value
     */
    public void setName(String value)
    {
        this.name = value;
    }

    /**
     * Default empty constructor
     */
    public CarPK()
    {
        // default empty constructor
    }

    /**
     * Implementation for the main constructor with all POJO identifier attributes.
     *
     * @param serial Value for the serial property
     * @param name Value for the name property
     */
    public CarPK(String serial, String name)
    {
        setSerial(serial);
        setName(name);
    }

    /**
     * Returns a hash code value for the object
     * @return int The hash code value
     * @see Object#hashCode
     */
    @Override
    public int hashCode()
    {
        int result = 0;
        result = 37*result + ((this.serial != null) ? this.serial.hashCode() : 0);
        result = 37*result + ((this.name != null) ? this.name.hashCode() : 0);
        return result;
    }

    /**
     * Indicates if the argument is of the same type and all values are equal.
     * @param object The target object to compare with
     * @return boolean True if both objects a 'equal'
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object object)
    {
        if (object == null)
        {
            return false;
        }
        if (object == this)
        {
            return true;
        }
        if (!(object instanceof CarPK))
        {
            return false;
        }
        CarPK pk = (CarPK)object;
        return
             pk.serial.equals(this.serial)
            && pk.name.equals(this.name);
    }

    /**
     * @see Comparable#compareTo
     */
    public int compareTo(CarPK o)
    {
        int cmp = 0;
        if (this.getSerial() != null)
        {
            cmp = this.getSerial().compareTo(o.getSerial());
        }
        if (this.getName() != null)
        {
            cmp = (cmp != 0 ? cmp : this.getName().compareTo(o.getName()));
        }
        return cmp;
    }
}
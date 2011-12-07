// license-header java merge-point
/* Autogenerated by AndroMDA (EntityCompositePK.vsl) - do not edit */
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

    public CarPK()
    {
        // default null constructor
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
     * Get the serial property.
     * 
     * @return String The value of serial
     */
    public String getSerial()
    {
        return serial;
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
        return name;
    }

    /**
     * Set the name property.
     * @param value the new value
     */
    public void setName(String value)
    {
        this.name = value;
    }

    public int hashCode()
    {
        int result = 0;
        result = 37*result + ((this.serial != null) ? this.serial.hashCode() : 0);
        result = 37*result + ((this.name != null) ? this.name.hashCode() : 0);
        return result;
    }

    public boolean equals(Object object)
    {
        if (object == this)
        {
            return true;
        }
        if (!(object instanceof CarPK))
        {
            return false;
        }
        if (object == null)
        {
            return false;
        }
        CarPK pk = (CarPK)object;
        return
             pk.serial.equals(this.serial)
            && pk.name.equals(this.name);
    }

    /**
     * @see Comparable#compareTo(T)
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
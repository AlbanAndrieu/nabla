// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by EntityEmbeddable.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto1.d;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Autogenerated POJO EJB class for Car containing the
 * bulk of the entity implementation.
 *
 * This is autogenerated by AndroMDA using the EJB3
 * cartridge.
 *
 * DO NOT MODIFY this class.
 *
 * 
 */
@Entity
@Table(name = "CAR")
@NamedQuery(name = "Car.findAll", query = "select car from Car AS car")
public class Car implements Serializable, Comparable<Car>
{
    private static final long serialVersionUID = 5852341216223813462L;

    // ----------- 3 Attribute Definitions ------------
    private String serial;
    private String name;
    private String type;

    // -------- 3 Attribute Accessors ----------
    /**
     * Get the serial property.
     * 
     * @return String The value of serial
     */
    @Id
    @Column(name = "SERIAL", unique = true, nullable = false, insertable = true, updatable = true)
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
    @Column(name = "NAME", unique = true, nullable = false, insertable = true, updatable = true)
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
     * Get the type property.
     * 
     * @return String The value of type
     */
    @Column(name = "TYPE", unique = true, nullable = false, insertable = true, updatable = true)
    public String getType()
    {
        return this.type;
    }

    /**
     * Set the type property.
     * @param value the new value
     */
    public void setType(String value)
    {
        this.type = value;
    }


    // ------------- 0 Relations ------------------
    // --------------- Constructors -----------------

    /**
     * Default empty constructor
     */
    public Car()
    {
        // Default empty constructor
    }

    /**
     * Implementation for the constructor with all POJO attributes except auto incremented identifiers.
     * This method sets all POJO fields defined in this class to the values provided by
     * the parameters.
     *
     * @param serial Value for the serial property
     * @param name Value for the name property
     * @param type Value for the type property
     */
    public Car(String serial, String name, String type)
    {
        setSerial(serial);
        setName(name);
        setType(type);
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
        if (!(object instanceof Car))
        {
            return false;
        }
        final Car that = (Car)object;
        if (this.getSerial() == null || that.getSerial() == null || !this.getSerial().equals(that.getSerial()))
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
        hashCode = 29 * hashCode + (getSerial() == null ? 0 : getSerial().hashCode());

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
        sb.append("Car(=");
        sb.append("serial: ");
        sb.append(getSerial());
        sb.append(", name: ");
        sb.append(getName());
        sb.append(", type: ");
        sb.append(getType());
        sb.append(")");
        return sb.toString();
    }

    /**
     * @see Comparable#compareTo(T)
     */
    public int compareTo(Car o)
    {
        int cmp = 0;
        if (this.getSerial() != null)
        {
            cmp = this.getSerial().compareTo(o.getSerial());
        }
        else
        {
            if (this.getName() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getName().compareTo(o.getName()));
            }
            if (this.getType() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getType().compareTo(o.getType()));
            }
        }
        return cmp;
    }
}
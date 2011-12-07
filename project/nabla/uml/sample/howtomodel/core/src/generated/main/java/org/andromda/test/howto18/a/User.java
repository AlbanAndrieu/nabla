// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: EntityEmbeddable.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto18.a;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Autogenerated POJO EJB class for User containing the
 * bulk of the entity implementation.
 *
 * This is autogenerated by AndroMDA using the EJB3
 * cartridge.
 *
 * DO NOT MODIFY this class.
 *
 * 
 *
 */
@Entity
@Table(name = "USER")
@NamedQuery(name = "User.findAll", query = "select user from User AS user")
public class User
    implements Serializable, Comparable<User>
{

    private static final long serialVersionUID = 8686751208262899436L;

    // ----------- Attribute Definitions ------------

    private String name;
    private String serial;

    // --------------- Constructors -----------------

    /**
     * Default empty constructor
     */
    public User() {}

    /**
     * Implementation for the constructor with all POJO attributes except auto incremented identifiers.
     * This method sets all POJO fields defined in this class to the values provided by
     * the parameters.
     *
     * @param name Value for the name property
     * @param serial Value for the serial property
     */
    public User(String name, String serial)
    {
        setName(name);
        setSerial(serial);
    }



    // -------- Attribute Accessors ----------

    /**
     * Get the name property.
     * 
     * @return String The value of name
     */
    @Column(name = "NAME", unique = true, nullable = false, insertable = true, updatable = true, length = 50)
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

    /**
     * Get the serial property.
     * 
     * @return String The value of serial
     */
    @Id
    @Column(name = "SERIAL", unique = true, nullable = false, insertable = true, updatable = true)
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


    // ------------- Relations ------------------

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
        if (!(object instanceof User))
        {
            return false;
        }
        final User that = (User)object;
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
        sb.append("User(=");
        sb.append("name: ");
        sb.append(getName());
        sb.append(", serial: ");
        sb.append(getSerial());
        sb.append(")");
        return sb.toString();
    }

    /**
     * @see Comparable#compareTo(T)
     */
    public int compareTo(User o)
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
        }
        return cmp;
    }
}
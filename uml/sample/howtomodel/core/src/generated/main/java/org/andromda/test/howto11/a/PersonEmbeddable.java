// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: EntityEmbeddable.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto11.a;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Autogenerated POJO EJB mapped super class for Person containing the
 * bulk of the entity implementation.
 *
 * This is a mapped super class and autogenerated by AndroMDA using the EJB3
 * cartridge.
 *
 * DO NOT MODIFY this class.
 *
 * 
 *
 */
@MappedSuperclass
public abstract class PersonEmbeddable
    implements Serializable
{

    private static final long serialVersionUID = -3303510932853057403L;

    // ----------- Attribute Definitions ------------

    private String name;
    private Date birthDate;
    private String serial;


    // --------- Relationship Definitions -----------

    private Set<Car> cars = new TreeSet<Car>();

    // ---- Manageable Display Attributes (Transient) -----


    // --------------- Constructors -----------------

    /**
     * Default empty constructor
     */
    public PersonEmbeddable() {}

    /**
     * Implementation for the constructor with all POJO attributes except auto incremented identifiers.
     * This method sets all POJO fields defined in this class to the values provided by
     * the parameters.
     *
     * @param name Value for the name property
     * @param birthDate Value for the birthDate property
     * @param serial Value for the serial property
     */
    public PersonEmbeddable(String name, Date birthDate, String serial)
    {
        setName(name);
        setBirthDate(birthDate);
        setSerial(serial);
    }

    /**
     * Constructor with all POJO attribute values and CMR relations.
     *
     * @param name Value for the name property
     * @param birthDate Value for the birthDate property
     * @param serial Value for the serial property
     * @param cars Value for the cars relation
     */
    public PersonEmbeddable(String name, Date birthDate, String serial, Set<Car> cars)
    {
        setName(name);
        setBirthDate(birthDate);
        setSerial(serial);

        setCars(cars);
    }


    // -------- Attribute Accessors ----------

    /**
     * Get the name property.
     * 
     * @return String The value of name
     */
    @Column(name = "NAME", unique = true, nullable = false, insertable = true, updatable = true)
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
     * Get the birthDate property.
     * 
     * @return Date The value of birthDate
     */
    @Column(name = "BIRTH_DATE", unique = true, nullable = false, insertable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getBirthDate()
    {
        return birthDate;
    }

    /**
     * Set the birthDate property.
     * @param value the new value
     */
    public void setBirthDate(Date value)
    {
        this.birthDate = value;
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

    /**
     * Get the cars Collection
     *
     * @return Set<Car>
     */
    @OneToMany(mappedBy = "owner")
    public Set<Car> getCars()
    {
        return this.cars;
    }

    /**
     * Set the cars
     *
     * @param cars
     */
    public void setCars (Set<Car> cars)
    {
        this.cars = cars;
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
        if (!(object instanceof PersonEmbeddable))
        {
            return false;
        }
        final PersonEmbeddable that = (PersonEmbeddable)object;
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
        sb.append("PersonEmbeddable(=");
        sb.append("name: ");
        sb.append(getName());
        sb.append(", birthDate: ");
        sb.append(getBirthDate());
        sb.append(", serial: ");
        sb.append(getSerial());
        sb.append(")");
        return sb.toString();
    }

}
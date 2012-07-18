// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by EntityEmbeddable.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto10.a;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Autogenerated POJO EJB class for Person containing the
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
@Table(name = "PERSON")
@NamedQueries
({
    @NamedQuery(name = "Person.findAll", query = "from Person as person"), 
    @NamedQuery(name = "Person.findByName", query = "from Person as person where person.name = :name and"), 
    @NamedQuery(name = "Person.findByNameOrBirthDate", query = "where person.name = :name or person.birthDate = :birthDate")
})
public class Person implements Serializable, Comparable<Person>
{
    private static final long serialVersionUID = -7369490585991748846L;

    // ----------- 3 Attribute Definitions ------------
    private String name;
    private Date birthDate;
    private String serial;

    // --------- 1 Relationship Definitions -----------
    private Set<Car> cars = new TreeSet<Car>();

    // ---- Manageable Display Attributes (Transient) -----

    // -------- 3 Attribute Accessors ----------
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
     * Get the birthDate property.
     * 
     * @return Date The value of birthDate
     */
    @Column(name = "BIRTH_DATE", unique = true, nullable = false, insertable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getBirthDate()
    {
        return this.birthDate;
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


    // ------------- 1 Relations ------------------
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
     * @param carsIn
     */
    public void setCars (Set<Car> carsIn)
    {
        this.cars = carsIn;
    }

    // --------------- Constructors -----------------

    /**
     * Default empty constructor
     */
    public Person()
    {
        // Default empty constructor
    }

    /**
     * Implementation for the constructor with all POJO attributes except auto incremented identifiers.
     * This method sets all POJO fields defined in this class to the values provided by
     * the parameters.
     *
     * @param name Value for the name property
     * @param birthDate Value for the birthDate property
     * @param serial Value for the serial property
     */
    public Person(String name, Date birthDate, String serial)
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
    public Person(String name, Date birthDate, String serial, Set<Car> cars)
    {
        setName(name);
        setBirthDate(birthDate);
        setSerial(serial);

        setCars(cars);
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
        if (!(object instanceof Person))
        {
            return false;
        }
        final Person that = (Person)object;
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
        sb.append("Person(=");
        sb.append("name: ");
        sb.append(getName());
        sb.append(", birthDate: ");
        sb.append(getBirthDate());
        sb.append(", serial: ");
        sb.append(getSerial());
        sb.append(")");
        return sb.toString();
    }

    /**
     * @see Comparable#compareTo(T)
     */
    public int compareTo(Person o)
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
            if (this.getBirthDate() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getBirthDate().compareTo(o.getBirthDate()));
            }
        }
        return cmp;
    }
}
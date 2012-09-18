// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by Entity.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto11.a;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

/**
 * Autogenerated POJO EJB3 implementation class for Car.
 *
 * Add any manual implementation within this class.  This class will NOT
 * be overwritten with incremental changes.
 *
 * 
 *
 */
@Entity
@Table(name = "CAR", uniqueConstraints = @UniqueConstraint(columnNames = { "serial", "name", "type" }))
// Uncomment to enable entity listener for Car
// @javax.persistence.EntityListeners({org.andromda.test.howto11.a.CarListener.class})
// Uncomment to enable caching for Car
// @org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.TRANSACTIONAL)
@NamedQueries( { @NamedQuery(name = "Car.findAll", query = "select car from Car AS car"), @NamedQuery(name = "Car.findByType", query = "from Car as car where car.type = :type and") })
public class Car extends CarEmbeddable implements Serializable, Comparable<Car>
{
    /**
     * The serial version UID of this class required for serialization.
     */
    private static final long serialVersionUID = -7616604201737209315L;

    // --------------- constructors -----------------

    /**
     * Default Car constructor
     */
    public Car()
    {
        super();
    }

    /**
     * Implementation for the constructor with all POJO attributes except auto incremented identifiers.
     * This method sets all POJO fields defined in this/super class to the
     * values provided by the parameters.
     *
     */
    public Car(String serial, String name, CarType type)
    {
        super(serial, name, type);
    }

    /**
     * Constructor with all POJO attribute values and CMR relations.
     *
     * @param serial Value for the serial property
     * @param name Value for the name property
     * @param type Value for the type property
     * @param owner Value for the owner relation
     */
    public Car(String serial, String name, CarType type, Person owner)
    {
        super(serial, name, type, owner);
    }

    // -------------- Entity Methods -----------------

    /**
     * Returns true if this car is current rented.
     */
    @Transient
    public boolean isRented()
    {
        // TODO put your implementation here.
        return false;
    }

    /**
     * Returns true if all cars are currently rented.
     */
    @Transient
    public static boolean allCarsAreRented()
    {
        // TODO put your implementation here.
        return false;
    }

    // --------------- Lifecycle callbacks -----------------

    /**
     * @see Comparable#compareTo(T)
     */
    public int compareTo(Car o)
    {
        int cmp = 0;
        if (this.getSerial() != null)
        {
            cmp = this.getSerial().compareTo(o.getSerial());
        } else
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
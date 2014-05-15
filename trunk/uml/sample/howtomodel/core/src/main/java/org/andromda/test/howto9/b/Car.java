// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by Entity.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto9.b;

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
 * TODO: Model Documentation for org.andromda.test.howto9.b.Car
 *
 */
@Entity
@Table(name = "CAR", uniqueConstraints = @UniqueConstraint(columnNames = { "name", "type" }))
// Uncomment to enable entity listener for Car
// @javax.persistence.EntityListeners({org.andromda.test.howto9.b.CarListener.class})
// Uncomment to enable caching for Car
// @org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.TRANSACTIONAL)
@NamedQueries({ @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car AS c"), @NamedQuery(name = "Car.findByType", query = "SELECT c from Car as c WHERE c.type = :type") })
public class Car extends CarEmbeddable implements Serializable, Comparable<Vehicle>
{
    /**
     * The serial version UID of this class required for serialization.
     */
    private static final long serialVersionUID = -488825889238712652L;

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
    public Car(String make, String model, Short age, String serial, String name, CarType type)
    {
        super(make, model, age, serial, name, type);
    }

    /**
     * Constructor with all POJO attribute values and CMR relations.
     *
     * @param make Value for the make property
     * @param model Value for the model property
     * @param age Value for the age property
     * @param serial Value for the serial property
     * @param name Value for the name property
     * @param type Value for the type property
     * @param owner Value for the owner relation
     */
    public Car(String make, String model, Short age, String serial, String name, CarType type, Person owner)
    {
        super(make, model, age, serial, name, type, owner);
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
     * @see Comparable#compareTo
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
            if (this.getMake() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getMake().compareTo(o.getMake()));
            }
            if (this.getModel() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getModel().compareTo(o.getModel()));
            }
            if (this.getAge() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getAge().compareTo(o.getAge()));
            }
        }
        return cmp;
    }

}

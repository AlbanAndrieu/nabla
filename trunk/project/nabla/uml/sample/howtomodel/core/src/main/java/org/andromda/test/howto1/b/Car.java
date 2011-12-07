// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: Entity.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto1.b;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Table(name = "CAR")
// Uncomment to enable entity listener for Car
// @javax.persistence.EntityListeners({org.andromda.test.howto1.b.CarListener.class})
// Uncomment to enable caching for Car
// @org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.TRANSACTIONAL)
@NamedQuery(name = "Car.findAll", query = "select car from Car AS car")
public class Car
    extends CarEmbeddable
    implements Serializable, Comparable<Car>
{

    /**
     * The serial version UID of this class required for serialization.
     */
    private static final long serialVersionUID = -6793461983486533447L;

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
    public Car(String serial, String name, String type)
    {
        super(serial, name, type);
    }


    // -------------- Entity Methods -----------------

    /**
     * <p>
     * Returns true if all cars are currently rented.
     * </p>
     */
    @Transient
    public static boolean allCarsAreRented()
    {
        // TODO put your implementation here.
        return false;
    }

    /**
     * <p>
     * Returns true if this car is current rented.
     * </p>
     */
    @Transient
    public boolean isRented()
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
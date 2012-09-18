// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by DaoLocal.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto9.b;

import java.util.Collection;

/**
 * @see Vehicle
 */
public interface VehicleDao
{
    /**
     * This constant is used as a transformation flag; entities can be converted automatically into value objects
     * or other types, different methods in a class implementing this interface support this feature: look for
     * an <code>int</code> parameter called <code>transform</code>.
     * <p/>
     * This specific flag denotes no transformation will occur.
     */
    public static final int TRANSFORM_NONE = 0;

    /**
     * Loads an instance of Vehicle from the persistent store.
     * @param serial the identifier of the entity to load.
     * @throws VehicleDaoException
     */
    public Vehicle load(String serial) throws VehicleDaoException;

    /**
     *   Does the same thing as {@link #load(String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined in this class then the result <strong>WILL BE</strong> passed through an operation which can
     *   optionally transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param serial the identifier of the entity to load.
     * @return either the entity or the object transformed from the entity.
     * @throws VehicleDaoException
     */
    public Object load(int transform, String serial) throws VehicleDaoException;

    /**
     * Loads all entities of type {@link Vehicle}.
     *
     * @return the loaded entities.
     * @throws VehicleDaoException
     */
    public Collection<Vehicle> loadAll() throws VehicleDaoException;

    /**
     *   Does the same thing as {@link #loadAll()} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param transform the flag indicating what transformation to use.
     * @return Collection of the loaded entities.
     * @throws VehicleDaoException
     */
    public Collection loadAll(final int transform) throws VehicleDaoException;

    /**
     * Creates an instance of Vehicle and adds it to the persistent store.
     * @param vehicle
     * @return Vehicle
     * @throws VehicleDaoException
     */
    public Vehicle create(Vehicle vehicle) throws VehicleDaoException;

    /**
     *   Does the same thing as {@link #create(Vehicle)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param transform
     * @param vehicle
     * @return Object
     * @throws VehicleDaoException
     */
    public Object create(int transform, Vehicle vehicle) throws VehicleDaoException;

    /**
     * Creates a new instance of Vehicle and adds
     * from the passed in <code>entities</code> collection
     *
     * @param entities the collection of Vehicle
     *        instances to create.
     * @return the created instances. Collection<Vehicle>
     * @throws VehicleDaoException
     */
    public Collection<Vehicle> create(Collection<Vehicle> entities) throws VehicleDaoException;

    /**
     *   Does the same thing as {@link #create(Vehicle)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     *
     * @param transform
     * @param entities
     * @return the created instances. Collection
     * @throws VehicleDaoException
     */
    public Collection create(int transform, Collection<Vehicle> entities)
        throws VehicleDaoException;

    /**
     *   Creates a new <code>Vehicle</code>
     *   instance from <strong>all</strong> attributes and adds it to
     *   the persistent store.
     * @param make
     * @param model
     * @param age
     * @return the created instances. Vehicle
     * @throws VehicleDaoException
     */
    public Vehicle create(        String make,
        String model,
        short age)
 throws VehicleDaoException;

    /**
     *   Does the same thing as {@link #create(String, String, short)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param transform
     * @param make
     * @param model
     * @param age
     * @return the created instances. Object
     * @throws VehicleDaoException
     */
    public Object create( int transform,        String make,
        String model,
        short age)
 throws VehicleDaoException;


    /**
     * Updates the <code>vehicle</code> instance in the persistent store.
     * @param vehicle
     * @throws VehicleDaoException
     */
    public void update(Vehicle vehicle) throws VehicleDaoException;

    /**
     * Updates all instances in the <code>entities</code> collection in the persistent store.
     * @param entities
     * @throws VehicleDaoException
     */
    public void update(Collection<Vehicle> entities) throws VehicleDaoException;

    /**
     * Removes the instance of Vehicle from the persistent store.
     * @param vehicle
     * @throws VehicleDaoException
     */
    public void remove(Vehicle vehicle) throws VehicleDaoException;

    /**
     * Removes the instance of Vehicle having the given
     * <code>identifier</code> from the persistent store.
     * @param serial
     * @throws VehicleDaoException
     */
    public void remove(String serial) throws VehicleDaoException;

    /**
     * Removes all entities in the given <code>entities<code> collection.
     * @param entities
     * @throws VehicleDaoException
     */
    public void remove(Collection<Vehicle> entities) throws VehicleDaoException;

}
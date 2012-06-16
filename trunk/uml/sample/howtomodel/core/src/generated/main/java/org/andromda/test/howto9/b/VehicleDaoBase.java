// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SessionDaoBase.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto9.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * <p>
 * Base EJB3 DAO Class: is able to create, update, remove, load, and find
 * objects of type <code>Vehicle</code>.
 * </p>
 *
 * @see VehicleDao
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Local({VehicleDao.class})
public abstract class VehicleDaoBase
    implements VehicleDao
{
    // ------ Session Context Injection ------

    @Resource
    protected SessionContext context;

    // ------ Persistence Context Injection --------

    /**
     * Inject persistence context howtomodel
     */
    @PersistenceContext(unitName = "howtomodel")
    protected EntityManager emanager;

    /**
     * @see VehicleDao#load(int,)
     */
    public Object load(final int transform, final String serial)
        throws VehicleDaoException
    {
        if (serial == null)
        {
            throw new IllegalArgumentException(
                "Vehicle.load - 'serial' can not be null");
        }
        try
        {
            final Object entity = (Vehicle)emanager.find(Vehicle.class, serial);
            return transformEntity(transform, (Vehicle)entity);
        }
        catch (Exception ex)
        {
            throw new VehicleDaoException(ex);
        }
    }

    /**
     * @see VehicleDao#load()
     */
    public Vehicle load( final String serial)
        throws VehicleDaoException
    {
        return (Vehicle)this.load(TRANSFORM_NONE, serial);
    }

    /**
     * @see VehicleDao#loadAll()
     */
    @SuppressWarnings({"unchecked"})
    public Collection<Vehicle> loadAll()
        throws VehicleDaoException
    {
        return(Collection<Vehicle>) this.loadAll(TRANSFORM_NONE);
    }

    /**
     * @see VehicleDao#loadAll(int)
     */
    public Collection loadAll(final int transform)
        throws VehicleDaoException
    {
        try
        {
            Query query = emanager.createNamedQuery("Vehicle.findAll");
            List<Vehicle> results = query.getResultList();
            this.transformEntities(transform, results);
            return results;
        }
        catch (Exception ex)
        {
            throw new VehicleDaoException(ex);
        }
    }

    /**
     * @see VehicleDao#create(Vehicle)
     */
    public Vehicle create(Vehicle vehicle)
        throws VehicleDaoException
    {
        return (Vehicle)this.create(TRANSFORM_NONE, vehicle);
    }

    /**
     * @see VehicleDao#create(int transform, Vehicle)
     */
    public Object create(final int transform, final Vehicle vehicle)
        throws VehicleDaoException
    {
        if (vehicle == null)
        {
            throw new IllegalArgumentException(
                "Vehicle.create - 'vehicle' can not be null");
        }

        try
        {
            emanager.persist(vehicle);
            emanager.flush();
            return this.transformEntity(transform, vehicle);
        }
        catch (Exception ex)
        {
            throw new VehicleDaoException(ex);
        }
    }

    /**
     * @see VehicleDao#create(Collection<Vehicle>)
     */
    @SuppressWarnings({"unchecked"})
    public Collection<Vehicle> create(final Collection<Vehicle> entities)
        throws VehicleDaoException
    {
        return create(TRANSFORM_NONE, entities);
    }

    /**
     * @see VehicleDao#create(int, Collection<Vehicle>)
     */
    @SuppressWarnings({"unchecked"})
    public Collection create(final int transform, final Collection<Vehicle> entities)
        throws VehicleDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Vehicle.create - 'entities' can not be null");
        }
        Collection results = new ArrayList();
        try
        {
            for (final Iterator entityIterator = entities.iterator(); entityIterator.hasNext();)
            {
                results.add(create(transform, (Vehicle)entityIterator.next()));
            }
        }
        catch (Exception ex)
        {
            throw new VehicleDaoException(ex);
        }
        return results;
    }

    /**
     * @see VehicleDao#create(String, String, short)
     */
    public Vehicle create(
        String make,
        String model,
        short age)
        throws VehicleDaoException
    {
        return (Vehicle)this.create(TRANSFORM_NONE, make, model, age);
    }

    /**
     * @see VehicleDao#create(int, String, String, short)
     */
    public Object create(
        final int transform,
        String make,
        String model,
        short age)
        throws VehicleDaoException
    {
        Vehicle entity = new Vehicle();
        entity.setMake(make);
        entity.setModel(model);
        entity.setAge(age);
        return this.create(transform, entity);
    }

    /**
     * @see VehicleDao#update(Vehicle)
     */
    public void update(Vehicle vehicle)
        throws VehicleDaoException
    {
        if (vehicle == null)
        {
            throw new IllegalArgumentException(
                "Vehicle.update - 'vehicle' can not be null");
        }
        try
        {
            emanager.merge(vehicle);
            emanager.flush();
        }
        catch (Exception ex)
        {
            throw new VehicleDaoException(ex);
        }
    }

    /**
     * @see VehicleDao#update(Collection<Vehicle>)
     */
    public void update(final Collection<Vehicle> entities)
        throws VehicleDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Vehicle.update - 'entities' can not be null");
        }
        try
        {
            for (final Iterator entityIterator = entities.iterator(); entityIterator.hasNext();)
            {
                update((Vehicle)entityIterator.next());
            }
        }
        catch (Exception ex)
        {
            throw new VehicleDaoException(ex);
        }
    }

    /**
     * @see VehicleDao#remove(Vehicle)
     */
    public void remove(Vehicle vehicle)
        throws VehicleDaoException
    {
        if (vehicle == null)
        {
            throw new IllegalArgumentException(
                "Vehicle.remove - 'vehicle' can not be null");
        }
        try
        {
            emanager.remove(vehicle);
            emanager.flush();
        }
        catch (Exception ex)
        {
            throw new VehicleDaoException(ex);
        }
    }

    /**
     * @see VehicleDao#remove(String)
     */
    public void remove(String serial)
        throws VehicleDaoException
    {
        if (serial == null)
        {
            throw new IllegalArgumentException(
                "Vehicle.remove - 'serial' can not be null");
        }
        try
        {
            final Vehicle entity = this.load(serial);
            if (entity != null)
            {
                this.remove(entity);
            }
        }
        catch (Exception ex)
        {
            throw new VehicleDaoException(ex);
        }
    }

    /**
     * @see VehicleDao#remove(Collection<Vehicle>)
     */
    public void remove(Collection<Vehicle> entities)
        throws VehicleDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Vehicle.remove - 'entities' can not be null");
        }
        try
        {
            for (final Iterator entityIterator = entities.iterator(); entityIterator.hasNext();)
            {
                remove((Vehicle)entityIterator.next());
            }
        }
        catch (Exception ex)
        {
            throw new VehicleDaoException(ex);
        }
    }

    /**
     * Allows transformation of entities into value objects
     * (or something else for that matter), when the <code>transform</code>
     * flag is set to one of the constants defined in <code>VehicleDao</code>, please note
     * that the {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself
     * will be returned.
     *
     * If the integer argument value is unknown {@link #TRANSFORM_NONE} is assumed.
     *
     * @param transform one of the constants declared in {@link VehicleDao}
     * @param entity an entity that was found
     * @return the transformed entity (i.e. new value object, etc)
     * @see #transformEntities(int,Collection)
     */
    protected Object transformEntity(final int transform, final Vehicle entity)
    {
        Object target = null;
        if (entity != null)
        {
            switch (transform)
            {
                case TRANSFORM_NONE : // fall-through
                default:
                    target = entity;
            }
        }
        return target;
    }

    /**
     * Transforms a collection of entities using the
     * {@link #transformEntity(int, Vehicle)}
     * method. This method does not instantiate a new collection.
     * <p/>
     * This method is to be used internally only.
     *
     * @param transform one of the constants declared in <code>VehicleDao</code>
     * @param entities the collection of entities to transform
     * @return the same collection as the argument, but this time containing the transformed entities
     * @see #transformEntity(int, Vehicle)
     */
    protected void transformEntities(final int transform, final Collection entities)
    {
        switch (transform)
        {
            case TRANSFORM_NONE : // fall-through
                default:
                // do nothing;
        }
    }

}
// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SessionDaoBase.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto13.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.TemporalType;

/**
 * <p>
 * Base EJB3 DAO Class: is able to create, update, remove, load, and find
 * objects of type <code>Person</code>.
 * </p>
 *
 * @see PersonDao
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Local({PersonDao.class})
public abstract class PersonDaoBase
    implements PersonDao
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
     * @see PersonDao#load(int,)
     */
    public Object load(final int transform, final String serial)
        throws PersonDaoException
    {
        if (serial == null)
        {
            throw new IllegalArgumentException(
                "Person.load - 'serial' can not be null");
        }
        try
        {
            final Object entity = (Person)emanager.find(Person.class, serial);
            return transformEntity(transform, (Person)entity);
        }
        catch (Exception ex)
        {
            throw new PersonDaoException(ex);
        }
    }

    /**
     * @see PersonDao#load()
     */
    public Person load( final String serial)
        throws PersonDaoException
    {
        return (Person)this.load(TRANSFORM_NONE, serial);
    }

    /**
     * @see PersonDao#loadAll()
     */
    @SuppressWarnings({"unchecked"})
    public Collection<Person> loadAll()
        throws PersonDaoException
    {
        return(Collection<Person>) this.loadAll(TRANSFORM_NONE);
    }

    /**
     * @see PersonDao#loadAll(int)
     */
    public Collection loadAll(final int transform)
        throws PersonDaoException
    {
        try
        {
            Query query = emanager.createNamedQuery("Person.findAll");
            List<Person> results = query.getResultList();
            this.transformEntities(transform, results);
            return results;
        }
        catch (Exception ex)
        {
            throw new PersonDaoException(ex);
        }
    }

    /**
     * @see PersonDao#create(Person)
     */
    public Person create(Person person)
        throws PersonDaoException
    {
        return (Person)this.create(TRANSFORM_NONE, person);
    }

    /**
     * @see PersonDao#create(int transform, Person)
     */
    public Object create(final int transform, final Person person)
        throws PersonDaoException
    {
        if (person == null)
        {
            throw new IllegalArgumentException(
                "Person.create - 'person' can not be null");
        }

        try
        {
            emanager.persist(person);
            emanager.flush();
            return this.transformEntity(transform, person);
        }
        catch (Exception ex)
        {
            throw new PersonDaoException(ex);
        }
    }

    /**
     * @see PersonDao#create(Collection<Person>)
     */
    @SuppressWarnings({"unchecked"})
    public Collection<Person> create(final Collection<Person> entities)
        throws PersonDaoException
    {
        return create(TRANSFORM_NONE, entities);
    }

    /**
     * @see PersonDao#create(int, Collection<Person>)
     */
    @SuppressWarnings({"unchecked"})
    public Collection create(final int transform, final Collection<Person> entities)
        throws PersonDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Person.create - 'entities' can not be null");
        }
        Collection results = new ArrayList();
        try
        {
            for (final Iterator entityIterator = entities.iterator(); entityIterator.hasNext();)
            {
                results.add(create(transform, (Person)entityIterator.next()));
            }
        }
        catch (Exception ex)
        {
            throw new PersonDaoException(ex);
        }
        return results;
    }

    /**
     * @see PersonDao#create(String, Date)
     */
    public Person create(
        String name,
        Date birthDate)
        throws PersonDaoException
    {
        return (Person)this.create(TRANSFORM_NONE, name, birthDate);
    }

    /**
     * @see PersonDao#create(int, String, Date)
     */
    public Object create(
        final int transform,
        String name,
        Date birthDate)
        throws PersonDaoException
    {
        Person entity = new Person();
        entity.setName(name);
        entity.setBirthDate(birthDate);
        return this.create(transform, entity);
    }

    /**
     * @see PersonDao#update(Person)
     */
    public void update(Person person)
        throws PersonDaoException
    {
        if (person == null)
        {
            throw new IllegalArgumentException(
                "Person.update - 'person' can not be null");
        }
        try
        {
            emanager.merge(person);
            emanager.flush();
        }
        catch (Exception ex)
        {
            throw new PersonDaoException(ex);
        }
    }

    /**
     * @see PersonDao#update(Collection<Person>)
     */
    public void update(final Collection<Person> entities)
        throws PersonDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Person.update - 'entities' can not be null");
        }
        try
        {
            for (final Iterator entityIterator = entities.iterator(); entityIterator.hasNext();)
            {
                update((Person)entityIterator.next());
            }
        }
        catch (Exception ex)
        {
            throw new PersonDaoException(ex);
        }
    }

    /**
     * @see PersonDao#remove(Person)
     */
    public void remove(Person person)
        throws PersonDaoException
    {
        if (person == null)
        {
            throw new IllegalArgumentException(
                "Person.remove - 'person' can not be null");
        }
        try
        {
            emanager.remove(person);
            emanager.flush();
        }
        catch (Exception ex)
        {
            throw new PersonDaoException(ex);
        }
    }

    /**
     * @see PersonDao#remove(String)
     */
    public void remove(String serial)
        throws PersonDaoException
    {
        if (serial == null)
        {
            throw new IllegalArgumentException(
                "Person.remove - 'serial' can not be null");
        }
        try
        {
            final Person entity = this.load(serial);
            if (entity != null)
            {
                this.remove(entity);
            }
        }
        catch (Exception ex)
        {
            throw new PersonDaoException(ex);
        }
    }

    /**
     * @see PersonDao#remove(Collection<Person>)
     */
    public void remove(Collection<Person> entities)
        throws PersonDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Person.remove - 'entities' can not be null");
        }
        try
        {
            for (final Iterator entityIterator = entities.iterator(); entityIterator.hasNext();)
            {
                remove((Person)entityIterator.next());
            }
        }
        catch (Exception ex)
        {
            throw new PersonDaoException(ex);
        }
    }

    /**
     * @see PersonDao#findAll()
     */
    public List findAll()
        throws PersonDaoException
    {
        return this.findAll(TRANSFORM_NONE);
    }

    /**
     * @see PersonDao#findAll(String)
     */
    public List findAll(final String queryString)
        throws PersonDaoException
    {
        return this.findAll(TRANSFORM_NONE, queryString);
    }

    /**
     * @see PersonDao#findAll(int)
     */
    public List findAll(final int transform)
        throws PersonDaoException
    {
        try
        {
            Query queryObject = emanager.createNamedQuery("Person.findAll");
            List results = queryObject.getResultList();
            transformEntities(transform, results);
            return results;
        }
        catch (Exception ex)
        {
            throw new PersonDaoException(ex);
        }
    }

    /**
     * @see PersonDao#findAll(int, String)
     */
    public List findAll(final int transform, final String queryString)
        throws PersonDaoException
    {
        try
        {
            Query queryObject = emanager.createQuery(queryString);
            List results = queryObject.getResultList();
            transformEntities(transform, results);
            return results;
        }
        catch (Exception ex)
        {
            throw new PersonDaoException(ex);
        }
    }

    /**
     * @see PersonDao#findByName(String)
     */
    public List findByName(String name)
        throws PersonDaoException
    {
        return this.findByName(TRANSFORM_NONE, name);
    }

    /**
     * @see PersonDao#findByName(String, String)
     */
    public List findByName(final String queryString, final String name)
        throws PersonDaoException
    {
        return this.findByName(TRANSFORM_NONE, queryString, name);
    }

    /**
     * @see PersonDao#findByName(int, String)
     */
    public List findByName(final int transform, final String name)
        throws PersonDaoException
    {
        try
        {
            Query queryObject = emanager.createNamedQuery("Person.findByName");
            queryObject.setParameter("name", name);
            List results = queryObject.getResultList();
            transformEntities(transform, results);
            return results;
        }
        catch (Exception ex)
        {
            throw new PersonDaoException(ex);
        }
    }

    /**
     * @see PersonDao#findByName(int, String, String)
     */
    public List findByName(final int transform, final String queryString, final String name)
        throws PersonDaoException
    {
        try
        {
            Query queryObject = emanager.createQuery(queryString);
            queryObject.setParameter("name", name);
            List results = queryObject.getResultList();
            transformEntities(transform, results);
            return results;
        }
        catch (Exception ex)
        {
            throw new PersonDaoException(ex);
        }
    }

    /**
     * @see PersonDao#findByNameOrBirthDate(String, Date)
     */
    public List findByNameOrBirthDate(String name, Date birthDate)
        throws PersonDaoException
    {
        return this.findByNameOrBirthDate(TRANSFORM_NONE, name, birthDate);
    }

    /**
     * @see PersonDao#findByNameOrBirthDate(String, String, Date)
     */
    public List findByNameOrBirthDate(final String queryString, final String name, final Date birthDate)
        throws PersonDaoException
    {
        return this.findByNameOrBirthDate(TRANSFORM_NONE, queryString, name, birthDate);
    }

    /**
     * @see PersonDao#findByNameOrBirthDate(int, String, Date)
     */
    public List findByNameOrBirthDate(final int transform, final String name, final Date birthDate)
        throws PersonDaoException
    {
        try
        {
            Query queryObject = emanager.createNamedQuery("Person.findByNameOrBirthDate");
            queryObject.setParameter("name", name);
            queryObject.setParameter("birthDate", birthDate, TemporalType.DATE);
            List results = queryObject.getResultList();
            transformEntities(transform, results);
            return results;
        }
        catch (Exception ex)
        {
            throw new PersonDaoException(ex);
        }
    }

    /**
     * @see PersonDao#findByNameOrBirthDate(int, String, String, Date)
     */
    public List findByNameOrBirthDate(final int transform, final String queryString, final String name, final Date birthDate)
        throws PersonDaoException
    {
        try
        {
            Query queryObject = emanager.createQuery(queryString);
            queryObject.setParameter("name", name);
            queryObject.setParameter("birthDate", birthDate, TemporalType.DATE);
            List results = queryObject.getResultList();
            transformEntities(transform, results);
            return results;
        }
        catch (Exception ex)
        {
            throw new PersonDaoException(ex);
        }
    }

    /**
     * Allows transformation of entities into value objects
     * (or something else for that matter), when the <code>transform</code>
     * flag is set to one of the constants defined in <code>PersonDao</code>, please note
     * that the {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself
     * will be returned.
     *
     * If the integer argument value is unknown {@link #TRANSFORM_NONE} is assumed.
     *
     * @param transform one of the constants declared in {@link PersonDao}
     * @param entity an entity that was found
     * @return the transformed entity (i.e. new value object, etc)
     * @see #transformEntities(int,Collection)
     */
    protected Object transformEntity(final int transform, final Person entity)
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
     * {@link #transformEntity(int, Person)}
     * method. This method does not instantiate a new collection.
     * <p/>
     * This method is to be used internally only.
     *
     * @param transform one of the constants declared in <code>PersonDao</code>
     * @param entities the collection of entities to transform
     * @return the same collection as the argument, but this time containing the transformed entities
     * @see #transformEntity(int, Person)
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
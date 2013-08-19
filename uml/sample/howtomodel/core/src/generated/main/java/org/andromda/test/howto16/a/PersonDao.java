// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by DaoLocal.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto16.a;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @see Person
 */
public interface PersonDao
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
     * This constant is used as a transformation flag; entities can be converted automatically into value objects
     * or other types, different methods in a class implementing this interface support this feature: look for
     * an <code>int</code> parameter called <code>transform</code>.
     * <p/>
     * This specific flag denotes entities must be transformed into objects of type
     * {@link PersonValueObject}.
     */
    public static final int TRANSFORM_PERSONVALUEOBJECT = 1;

    /**
     * Copies the fields of the specified entity to the target value object.  This method is similar to
     * toPersonValueObject(), but it does not handle any attributes in the target
     * value object that are "read-only" (as those do not have setter methods exposed).
     * @param sourceEntity
     * @param targetVO
     */
    public void toPersonValueObject( Person sourceEntity, PersonValueObject targetVO);

    /**
     * Converts this DAO's entity to an object of type {@link PersonValueObject}.
     * @param entity
     * @return PersonValueObject
     */
    public PersonValueObject toPersonValueObject(Person entity);

    /**
     * Converts this DAO's entity to a Collection of instances of type {@link PersonValueObject}.
     * @param entities
     */
    public void toPersonValueObjectCollection(Collection entities);

    /**
     * Copies the fields of {@link PersonValueObject} to the specified entity.
     * @param sourceVO
     * @param targetEntity
     * @param copyIfNull If FALSE, the value object's field will not be copied to the entity if the value is NULL. If TRUE,
     *        it will be copied regardless of its value.
     */
    public void personValueObjectToEntity( PersonValueObject sourceVO, Person targetEntity, boolean copyIfNull);

    /**
     * Converts an instance of type {@link PersonValueObject} to this DAO's entity.
     * @param personValueObject
     * @return Person
     */
    public Person personValueObjectToEntity(PersonValueObject personValueObject);

    /**
     * Converts a Collection of instances of type {@link PersonValueObject} to this
     * DAO's entity.
     * @param instances
     */
    public void personValueObjectToEntityCollection(Collection instances);

    /**
     * Loads an instance of Person from the persistent store.
     * @param serial String identifier part of the composite PK of the entity to load.
     * @return Person
     * @throws PersonDaoException
     */
    public Person load(String serial) throws PersonDaoException;

    /**
     *   Does the same thing as {@link #load(String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined in this class then the result <strong>WILL BE</strong> passed through an operation which can
     *   optionally transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param transform int transformation flag
     * @param serial String identifier part of the composite PK of the entity to load.
     * @return either the entity or the object transformed from the entity.
     * @throws PersonDaoException
     */
    public Object load(int transform, String serial) throws PersonDaoException;

    /**
     * Loads all entities of type {@link Person}.
     *
     * @return the loaded entities.
     * @throws PersonDaoException
     */
    public Collection<Person> loadAll() throws PersonDaoException;

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
     * @throws PersonDaoException
     */
    @SuppressWarnings("rawtypes")
    public Collection loadAll(final int transform) throws PersonDaoException;

    /**
     * Creates an instance of Person and adds it to the persistent store.
     * @param person
     * @return Person
     * @throws PersonDaoException
     */
    public Person create(Person person) throws PersonDaoException;

    /**
     *   Does the same thing as {@link #create(Person)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param transform
     * @param person
     * @return Object
     * @throws PersonDaoException
     */
    public Object create(int transform, Person person) throws PersonDaoException;

    /**
     * Creates a new instance of Person and adds
     * from the passed in <code>entities</code> collection
     *
     * @param entities the collection of Person
     *        instances to create.
     * @return the created instances. Collection<Person>
     * @throws PersonDaoException
     */
    public Collection<Person> create(Collection<Person> entities) throws PersonDaoException;

    /**
     *   Does the same thing as {@link #create(Person)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     *
     * @param transform
     * @param entities
     * @return the created instances. Collection
     * @throws PersonDaoException
     */
    @SuppressWarnings({"rawtypes"})
    public Collection create(int transform, Collection<Person> entities)
        throws PersonDaoException;

    /**
     *   Creates a new <code>Person</code>
     *   instance from <strong>all</strong> attributes and adds it to
     *   the persistent store.
     * @param name
     * @param birthDate
     * @return the created instances. Person
     * @throws PersonDaoException
     */
    public Person create(        String name,
        Date birthDate)
 throws PersonDaoException;

    /**
     *   Does the same thing as {@link #create(String, Date)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param transform
     * @param name
     * @param birthDate
     * @return the created instances. Object
     * @throws PersonDaoException
     */
    public Object create( int transform,        String name,
        Date birthDate)
 throws PersonDaoException;


    /**
     * Updates the <code>person</code> instance in the persistent store.
     * @param person
     * @throws PersonDaoException
     */
    public void update(Person person) throws PersonDaoException;

    /**
     * Updates all instances in the <code>entities</code> collection in the persistent store.
     * @param entities
     * @throws PersonDaoException
     */
    public void update(Collection<Person> entities) throws PersonDaoException;

    /**
     * Removes the instance of Person from the persistent store.
     * @param person
     * @throws PersonDaoException
     */
    public void remove(Person person) throws PersonDaoException;

    /**
     * Removes the instance of Person having the given
     * <code>identifier</code> from the persistent store.
     * @param serial
     * @throws PersonDaoException
     */
    public void remove(String serial) throws PersonDaoException;

    /**
     * Removes all entities in the given <code>entities<code> collection.
     * @param entities
     * @throws PersonDaoException
     */
    public void remove(Collection<Person> entities) throws PersonDaoException;

    /**
     * TODO: Model Documentation for Person.findAll
     * @return List
     * @throws PersonDaoException
     */
    public List findAll() throws PersonDaoException;

    /**
     *   Does the same thing as {@link #findAll()} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #findAll()}.
     * @return List
     * @throws PersonDaoException
     */
    public List findAll(String queryString) throws PersonDaoException;

    /**
     *   Does the same thing as {@link #findAll()} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * @return List
     * @throws PersonDaoException
     */
    public List findAll(int transform) throws PersonDaoException;

    /**
     *   Does the same thing as {@link #findAll(boolean)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #findAll(int)}.
     */
    public List findAll(int transform, String queryString) throws PersonDaoException;

    /**
     * TODO: Model Documentation for Person.findByName
     * @param name
     * @return List
     * @throws PersonDaoException
     */
    public List findByName(String name) throws PersonDaoException;

    /**
     *   Does the same thing as {@link #findByName(String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #findByName(String)}.
     * @param name
     * @return List
     * @throws PersonDaoException
     */
    public List findByName(String queryString, String name) throws PersonDaoException;

    /**
     *   Does the same thing as {@link #findByName(String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * @param name
     * @return List
     * @throws PersonDaoException
     */
    public List findByName(int transform, String name) throws PersonDaoException;

    /**
     *   Does the same thing as {@link #findByName(boolean, String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #findByName(int, String name)}.
     */
    public List findByName(int transform, String queryString, String name) throws PersonDaoException;

}
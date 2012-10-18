// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by DaoLocal.vsl overrided in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.andromda.timetracker.vo.TimecardSearchCriteriaVO;
import org.andromda.timetracker.vo.TimecardSummaryVO;
import org.andromda.timetracker.vo.TimecardVO;

/**
 * @see Timecard
 */
public interface TimecardDao
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
     * {@link TimecardSummaryVO}.
     */
    public static final int TRANSFORM_TIMECARDSUMMARYVO = 1;

    /**
     * Copies the fields of the specified entity to the target value object.  This method is similar to
     * toTimecardSummaryVO(), but it does not handle any attributes in the target
     * value object that are "read-only" (as those do not have setter methods exposed).
     * @param sourceEntity
     * @param targetVO
     */
    public void toTimecardSummaryVO(
        Timecard sourceEntity,
        TimecardSummaryVO targetVO);

    /**
     * Converts this DAO's entity to an object of type {@link TimecardSummaryVO}.
     * @param entity
     * @return TimecardSummaryVO
     */
    public TimecardSummaryVO toTimecardSummaryVO(Timecard entity);

    /**
     * Converts this DAO's entity to a Collection of instances of type {@link TimecardSummaryVO}.
     * @param entities
     */
    public void toTimecardSummaryVOCollection(Collection entities);

    /**
     * Copies the fields of {@link TimecardSummaryVO} to the specified entity.
     * @param sourceVO
     * @param targetEntity
     * @param copyIfNull If FALSE, the value object's field will not be copied to the entity if the value is NULL. If TRUE,
     *        it will be copied regardless of its value.
     */
    public void timecardSummaryVOToEntity(
        TimecardSummaryVO sourceVO,
        Timecard targetEntity,
        boolean copyIfNull);

    /**
     * Converts an instance of type {@link TimecardSummaryVO} to this DAO's entity.
     * @param timecardSummaryVO
     * @return Timecard
     */
    public Timecard timecardSummaryVOToEntity(TimecardSummaryVO timecardSummaryVO);

    /**
     * Converts a Collection of instances of type {@link TimecardSummaryVO} to this
     * DAO's entity.
     * @param instances
     */
    public void timecardSummaryVOToEntityCollection(Collection instances);

    /**
     * This constant is used as a transformation flag; entities can be converted automatically into value objects
     * or other types, different methods in a class implementing this interface support this feature: look for
     * an <code>int</code> parameter called <code>transform</code>.
     * <p/>
     * This specific flag denotes entities must be transformed into objects of type
     * {@link TimecardVO}.
     */
    public static final int TRANSFORM_TIMECARDVO = 2;

    /**
     * Copies the fields of the specified entity to the target value object.  This method is similar to
     * toTimecardVO(), but it does not handle any attributes in the target
     * value object that are "read-only" (as those do not have setter methods exposed).
     * @param sourceEntity
     * @param targetVO
     */
    public void toTimecardVO(
        Timecard sourceEntity,
        TimecardVO targetVO);

    /**
     * Converts this DAO's entity to an object of type {@link TimecardVO}.
     * @param entity
     * @return TimecardVO
     */
    public TimecardVO toTimecardVO(Timecard entity);

    /**
     * Converts this DAO's entity to a Collection of instances of type {@link TimecardVO}.
     * @param entities
     */
    public void toTimecardVOCollection(Collection entities);

    /**
     * Copies the fields of {@link TimecardVO} to the specified entity.
     * @param sourceVO
     * @param targetEntity
     * @param copyIfNull If FALSE, the value object's field will not be copied to the entity if the value is NULL. If TRUE,
     *        it will be copied regardless of its value.
     */
    public void timecardVOToEntity(
        TimecardVO sourceVO,
        Timecard targetEntity,
        boolean copyIfNull);

    /**
     * Converts an instance of type {@link TimecardVO} to this DAO's entity.
     * @param timecardVO
     * @return Timecard
     */
    public Timecard timecardVOToEntity(TimecardVO timecardVO);

    /**
     * Converts a Collection of instances of type {@link TimecardVO} to this
     * DAO's entity.
     * @param instances
     */
    public void timecardVOToEntityCollection(Collection instances);

    /**
     * Loads an instance of Timecard from the persistent store.
     * @param id the identifier of the entity to load.
     * @throws TimecardDaoException
     */
    public Timecard load(Long id)
        throws TimecardDaoException;

    /**
     *   Does the same thing as {@link #load(Long)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined in this class then the result <strong>WILL BE</strong> passed through an operation which can
     *   optionally transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param id the identifier of the entity to load.
     * @return either the entity or the object transformed from the entity.
     * @throws TimecardDaoException
     */
    public Object load(int transform, Long id)
        throws TimecardDaoException;

    /**
     * Loads all entities of type {@link Timecard}.
     *
     * @return the loaded entities.
     * @throws TimecardDaoException
     */
    public Collection<Timecard> loadAll()
        throws TimecardDaoException;

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
     * @throws TimecardDaoException
     */
    public Collection loadAll(final int transform)
        throws TimecardDaoException;

    /**
     * Creates an instance of Timecard and adds it to the persistent store.
     * @param timecard
     * @return Timecard
     * @throws TimecardDaoException
     */
    public Timecard create(Timecard timecard)
        throws TimecardDaoException;

    /**
     *   Does the same thing as {@link #create(Timecard)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param transform
     * @param timecard
     * @return Object
     * @throws TimecardDaoException
     */
    public Object create(int transform, Timecard timecard)
        throws TimecardDaoException;

    /**
     * Creates a new instance of Timecard and adds
     * from the passed in <code>entities</code> collection
     *
     * @param entities the collection of Timecard
     *        instances to create.
     * @return the created instances. Collection<Timecard>
     * @throws TimecardDaoException
     */
    public Collection<Timecard> create(Collection<Timecard> entities)
        throws TimecardDaoException;

    /**
     *   Does the same thing as {@link #create(Timecard)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     *
     * @param transform
     * @param entities
     * @return the created instances. Collection
     * @throws TimecardDaoException
     */
    public Collection create(int transform, Collection<Timecard> entities)
        throws TimecardDaoException;

    /**
     *   Creates a new <code>Timecard</code>
     *   instance from <strong>all</strong> attributes and adds it to
     *   the persistent store.
     * @param comments
     * @param startDate
     * @param status
     * @return the created instances. Timecard
     * @throws TimecardDaoException
     */
    public Timecard create(
        String comments,
        Date startDate,
        TimecardStatus status)
        throws TimecardDaoException;

    /**
     *   Does the same thing as {@link #create(String, Date, TimecardStatus)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param transform
     * @param comments
     * @param startDate
     * @param status
     * @return the created instances. Object
     * @throws TimecardDaoException
     */
    public Object create(
        int transform,
        String comments,
        Date startDate,
        TimecardStatus status)
        throws TimecardDaoException;

    /**
     *  Creates a new <code>Timecard</code>
     *  instance from only <strong>required</strong> properties (attributes
     *  and association ends) and adds it to the persistent store.
     *
     * @param comments
     * @param startDate
     * @param status
     * @param submitter
     * @return the created instance. Timecard
     * @throws TimecardDaoException
     */
    public Timecard create(
        String comments,
        Date startDate,
        TimecardStatus status,
        User submitter)
        throws TimecardDaoException;

    /**
     *   Does the same thing as {@link #create(String, Date, TimecardStatus)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param transform
     * @param comments
     * @param startDate
     * @param status
     * @param submitter
     * @return the created instance. Object
     * @throws TimecardDaoException
     */
    public Object create(
        int transform,
        String comments,
        Date startDate,
        TimecardStatus status,
        User submitter)
        throws TimecardDaoException;

    /**
     * Updates the <code>timecard</code> instance in the persistent store.
     * @param timecard
     * @throws TimecardDaoException
     */
    public void update(Timecard timecard)
        throws TimecardDaoException;

    /**
     * Updates all instances in the <code>entities</code> collection in the persistent store.
     * @param entities
     * @throws TimecardDaoException
     */
    public void update(Collection<Timecard> entities)
        throws TimecardDaoException;

    /**
     * Removes the instance of Timecard from the persistent store.
     * @param timecard
     * @throws TimecardDaoException
     */
    public void remove(Timecard timecard)
        throws TimecardDaoException;

    /**
     * Removes the instance of Timecard having the given
     * <code>identifier</code> from the persistent store.
     * @param id
     * @throws TimecardDaoException
     */
    public void remove(Long id)
        throws TimecardDaoException;

    /**
     * Removes all entities in the given <code>entities<code> collection.
     * @param entities
     * @throws TimecardDaoException
     */
    public void remove(Collection<Timecard> entities)
        throws TimecardDaoException;

    /**
     * 
     * @param criteria
     * @return List
     */
    public List findByCriteria(TimecardSearchCriteriaVO criteria)     
        throws TimecardDaoException;
    
}
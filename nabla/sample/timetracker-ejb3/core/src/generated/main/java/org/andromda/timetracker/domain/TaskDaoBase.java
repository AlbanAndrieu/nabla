// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by DaoBase.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain;

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
import org.andromda.timetracker.vo.TaskVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 * <p>
 * Base EJB3 DAO Class: is able to create, update, remove, load, and find
 * objects of type <code>Task</code>.
 * </p>
 *
 * @see TaskDao
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Local({TaskDao.class})
public abstract class TaskDaoBase implements TaskDao
{

    private static final Logger logger = Logger.getLogger(TaskDaoBase.class);
    
    /** Session Context Injection */
    @Resource
    protected SessionContext context;

    /**
     * Inject persistence context timetracker-ejb3     */    
    @PersistenceContext(unitName = "timetracker-ejb3")
    protected EntityManager entityManager;

    /**
     * Inject Hibernate Session
     */
    @PersistenceContext(unitName = "timetracker-ejb3")
    protected Session hibernateSession;

    /**
     * @see TaskDao#load
     */
    @Override
    public Object load(final int transform, final Long id) throws TaskDaoException
    {
        if (id == null)
        {
            throw new IllegalArgumentException("Task.load - 'id' can not be null");
        }
        try
        {
                        final Task entity = this.entityManager.find(Task.class, id);
            return transformEntity(transform, entity);
        }
        catch (Exception ex)
        {
            throw new TaskDaoException(ex);
        }
    }

    /**
     * @see TaskDao#load( Long)
     */
    @Override
        public Task load( final Long id) throws TaskDaoException
    {
        return (Task)this.load(TRANSFORM_NONE, id);
    }

    /**
     * @see TaskDao#loadAll()
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public Collection<Task> loadAll() throws TaskDaoException
    {
        return this.loadAll(TRANSFORM_NONE);
    }

    /**
     * @see TaskDao#loadAll(int)
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Collection loadAll(final int transform) throws TaskDaoException
    {
        try
        {
            Query query = entityManager.createNamedQuery("Task.findAll");            

            List<Task> results = query.getResultList();
            this.transformEntities(transform, results);
            return results;
        }
        catch (Exception ex)
        {
            throw new TaskDaoException(ex);
        }
    }

    /**
     * Create Task with no VO transformation
     * @see TaskDao#create(Task)
     */
    @Override
    public Task create(Task task) throws TaskDaoException
    {
        return (Task)this.create(TRANSFORM_NONE, task);
    }

    /**
     * Create Task with VO transformation
     * @see TaskDao#create(int, Task)
     */
    @Override
    public Object create(final int transform, final Task task) throws TaskDaoException
    {
        if (task == null)
        {
            throw new IllegalArgumentException("Task.create - 'task' can not be null");
        }

        try
        {
            this.entityManager.persist(task);
            this.entityManager.flush();
            return this.transformEntity(transform, task);
        }
        catch (Exception ex)
        {
            throw new TaskDaoException(ex);
        }
    }

    /**
     * Create a Collection of Task with no VO transformation
     * @see TaskDao#create(Collection)
     */
    @Override
    //@SuppressWarnings({"unchecked"})
    public Collection<Task> create(final Collection<Task> entities) throws TaskDaoException
    {
        return create(TRANSFORM_NONE, entities);
    }

    /**
     * Create a Collection of Task with VO transformation
     * @see TaskDao#create(int, Collection)
     */
    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Collection create(final int transform, final Collection<Task> entities) throws TaskDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException("Task.create - 'entities' can not be null");
        }
        Collection results = new ArrayList();
        try
        {
            for (final Task entity : entities)
            {
                results.add(create(transform, entity));
            }
        }
        catch (Exception ex)
        {
            throw new TaskDaoException(ex);
        }
        return results;
    }

    /**
     * Create Entity Task using instance attributes with no VO transformation
     * @see TaskDao#create(String)
     */
    @Override
    public Task create(String name) throws TaskDaoException
    {
        return (Task)this.create(TRANSFORM_NONE, name);
    }

    /**
     * Create Entity Task using instance attributes with VO transformation
     * @see TaskDao#create(int, String)
     * composite=false identifiers=1
     */
    @Override
    public Object create(final int transform, String name) throws TaskDaoException
    {
        Task entity = new Task();
        entity.setName(name);
        return this.create(transform, entity);
    }

    /**
     * @see TaskDao#update(Task)
     */
    @Override
    public void update(Task task) throws TaskDaoException
    {
        if (task == null)
        {
            throw new IllegalArgumentException("Task.update - 'task' can not be null");
        }
        try
        {
            this.entityManager.merge(task);
            this.entityManager.flush();
        }
        catch (Exception ex)
        {
            throw new TaskDaoException(ex);
        }
    }

    /**
     * @see TaskDao#update(Collection)
     */
    @Override
    public void update(final Collection<Task> entities) throws TaskDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException("Task.update - 'entities' can not be null");
        }
        try
        {
            for (final Task entity : entities)
            {
                update(entity);
            }
        }
        catch (Exception ex)
        {
            throw new TaskDaoException(ex);
        }
    }

    /**
     * @see TaskDao#remove(Task)
     */
    @Override
    public void remove(Task task) throws TaskDaoException
    {
        if (task == null)
        {
            throw new IllegalArgumentException("Task.remove - 'task' can not be null");
        }
        try
        {
            this.entityManager.remove(task);
            this.entityManager.flush();
        }
        catch (Exception ex)
        {
            throw new TaskDaoException(ex);
        }
    }

    /**
     * @see TaskDao#remove(Long)
     */
    @Override
    public void remove(Long id) throws TaskDaoException
    {
        if (id == null)
        {
            throw new IllegalArgumentException("Task.remove - 'id' can not be null");
        }
        try
        {
            final Task entity = this.load(id);
            if (entity != null)
            {
                this.remove(entity);
            }
        }
        catch (Exception ex)
        {
            throw new TaskDaoException(ex);
        }
    }

    /**
     * @see TaskDao#remove(Collection)
     */
    @Override
    public void remove(Collection<Task> entities) throws TaskDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException("Task.remove - 'entities' can not be null");
        }
        try
        {
            for (final Task entity : entities)
            {
                remove(entity);
            }
        }
        catch (Exception ex)
        {
            throw new TaskDaoException(ex);
        }
    }

    /**
     * Allows transformation of entities into value objects
     * (or something else for that matter), when the <code>transform</code>
     * flag is set to one of the constants defined in <code>TaskDao</code>, please note
     * that the {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself
     * will be returned.
     * <p/>
     * This method will return instances of these types:
     * <ul>
     *   <li>{@link Task} - {@link #TRANSFORM_NONE}</li>
     *   <li>{@link TaskVO} - {@link #TRANSFORM_TASKVO}</li>
     * </ul>
     *
     * If the integer argument value is unknown {@link #TRANSFORM_NONE} is assumed.
     *
     * @param transform one of the constants declared in {@link TaskDao}
     * @param entity an entity that was found
     * @return the transformed entity (i.e. new value object, etc)
     * @see #transformEntities(int,Collection)
     */
    protected Object transformEntity(final int transform, final Task entity)
    {
        Object target = null;
        if (entity != null)
        {
            switch (transform)
            {
                case TaskDao.TRANSFORM_TASKVO :
                    target = toTaskVO(entity);
                    break;
                case TRANSFORM_NONE : // fall-through
                default:
                    target = entity;
            }
        }
        return target;
    }

    /**
     * Transforms a collection of entities using the
     * {@link #transformEntity(int, Task)}
     * method. This method does not instantiate a new collection.
     * <p/>
     * Transforms into the same collection as the argument, but this time containing the transformed entities
     * This method is to be used internally only.
     *
     * @param transform one of the constants declared in <code>TaskDao</code>
     * @param entities the collection of entities to transform
     * @see #transformEntity(int, Task)
     */
    protected void transformEntities(final int transform, final Collection<Task> entities)
    {
        switch (transform)
        {
            case TaskDao.TRANSFORM_TASKVO :
                toTaskVOCollection(entities);
                break;
            case TRANSFORM_NONE : // fall-through
                default:
                // do nothing;
        }
    }

    /**
     * @see TaskDao#toTaskVOCollection(Collection)
     */
    @Override
    public final void toTaskVOCollection(Collection entities)
    {
        if (entities != null)
        {
            CollectionUtils.transform(entities, this.TASKVO_TRANSFORMER);
        }
    }

    /**
     * Default implementation for transforming the results of a report query into a value object. This
     * implementation exists for convenience reasons only. It needs only be overridden in the
     * {@link TaskDaoImpl} class if you intend to use reporting queries.
     * @param row Object[] Array of Task to transform
     * @return target TaskVO
     * @see TaskDao#toTaskVO(Task)
     */
    protected TaskVO toTaskVO(Object[] row)
    {
        TaskVO target = null;
        if (row != null)
        {
            final int numberOfObjects = row.length;
            for (int ctr = 0; ctr < numberOfObjects; ctr++)
            {
                final Object object = row[ctr];
                if (object instanceof Task)
                {
                    target = this.toTaskVO((Task)object);
                    break;
                }
            }
        }
        return target;
    }

    /**
     * This anonymous transformer is designed to transform entities or report query results
     * (which result in an array of objects) to {@link TaskVO}
     * using the Jakarta Commons-Collections Transformation API.
     */
    private Transformer TASKVO_TRANSFORMER =
        new Transformer()
        {
            @Override
            public Object transform(Object input)
            {
                Object result = null;
                if (input instanceof Task)
                {
                    result = toTaskVO((Task)input);
                }
                else if (input instanceof Object[])
                {
                    result = toTaskVO((Object[])input);
                }
                return result;
            }
        };

    /**
     * @see TaskDao#taskVOToEntityCollection(Collection)
     */
    @Override
    public final void taskVOToEntityCollection(Collection instances)
    {
        if (instances != null)
        {
            for (final Iterator iterator = instances.iterator(); iterator.hasNext();)
            {
                // - remove objects that are null or not of the correct instance
                if (!(iterator.next() instanceof TaskVO))
                {
                    iterator.remove();
                }
            }
            CollectionUtils.transform(instances, this.TaskVOToEntityTransformer);
        }
    }

    private final Transformer TaskVOToEntityTransformer =
        new Transformer()
        {
            @Override
            public Object transform(Object input)
            {
                return taskVOToEntity((TaskVO)input);
            }
        };

    /**
     * @see TaskDao#toTaskVO(Task, TaskVO)
     */
    @Override
    public void toTaskVO( Task source, TaskVO target)
    {
        target.setId(source.getId());
        target.setName(source.getName());
    }

    /**
     * @see TaskDao#toTaskVO(Task)
     */
    @Override
    public TaskVO toTaskVO(final Task entity)
    {
        final TaskVO target = new TaskVO();
        this.toTaskVO(entity, target);
        return target;
    }

    /**
     * @see TaskDao#taskVOToEntity(TaskVO, Task, boolean)
     */
    @Override
    public void taskVOToEntity( TaskVO source, Task target, boolean copyIfNull)
    {
        if (copyIfNull || source.getName() != null)
        {
            target.setName(source.getName());
        }
    }


    // For unit testing outside of container - persistence context not injected
    /**
     * @return the context
     */
    public SessionContext getContext()
    {
        return this.context;
    }

    /**
     * @param contextIn the context to set
     */
    public void setContext(SessionContext contextIn)
    {
        this.context = contextIn;
    }

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager()
    {
        return this.entityManager;
    }

    /**
     * @param entityManagerIn the entityManager to set
     */
    public void setEntityManager(EntityManager entityManagerIn)
    {
        this.entityManager = entityManagerIn;
    }

    /**
     * @return the hibernateSession
     */   
    public Session getHibernateSession()
    {
        return this.hibernateSession;
    }

    /**
     * @param hibernateSessionIn the hibernateSession to set
     */
    public void setHibernateSession(Session hibernateSessionIn)
    {
        this.hibernateSession = hibernateSessionIn;
    }        
}
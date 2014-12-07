// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand! hibernate4=false hibernateVersion=3
// Generated by hibernate/SpringHibernateDaoBase.vsl in andromda-spring-cartridge.
//
package org.andromda.timetracker.domain;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.andromda.spring.PaginationResult;
import org.andromda.timetracker.PrincipalStore;
import org.andromda.timetracker.PropertySearch;
import org.andromda.timetracker.Search;
import org.andromda.timetracker.SearchParameter;
import org.andromda.timetracker.vo.TaskVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * <p>
 * Base Spring DAO Class: is able to create, update, remove, load, and find
 * objects of type <code>Task</code>.
 * </p>
 *
 * @see Task
 */
public abstract class TaskDaoBase
    extends HibernateDaoSupport
    implements TaskDao
{
    /**
     * {@inheritDoc}
     */
    @Override
    public Object get(final int transform, final Long id)
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "Task.get - 'id' can not be null");
        }
        final Object entity = this.getHibernateTemplate().get(TaskImpl.class, id);
        return transformEntity(transform, (Task)entity);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Task get(Long id)
    {
        return (Task)this.get(TRANSFORM_NONE, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object load(final int transform, final Long id)
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "Task.load - 'id' can not be null");
        }
        final Object entity = this.getHibernateTemplate().get(TaskImpl.class, id);
        return transformEntity(transform, (Task)entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task load(Long id)
    {
        return (Task)this.load(TRANSFORM_NONE, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public Collection<Task> loadAll()
    {
        return (Collection<Task>) this.loadAll(TaskDao.TRANSFORM_NONE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<?> loadAll(final int transform)
    {
        return this.loadAll(transform, -1, -1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<?> loadAll(final int pageNumber, final int pageSize)
    {
        return this.loadAll(TaskDao.TRANSFORM_NONE, pageNumber, pageSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<?> loadAll(final int transform, final int pageNumber, final int pageSize)
    {
        try
        {
            final Criteria criteria = this.getSession(false).createCriteria(TaskImpl.class);
            if (pageNumber > 0 && pageSize > 0)
            {
                criteria.setFirstResult(this.calculateFirstResult(pageNumber, pageSize));
                criteria.setMaxResults(pageSize);
            }
            final Collection<?> results = criteria.list();
            this.transformEntities(transform, results);
            return results;
        }
        catch (HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    /**
     * firstResult = (pageNumber - 1) * pageSize
     * @param pageNumber
     * @param pageSize
     * @return firstResult
     */
    protected int calculateFirstResult(int pageNumber, int pageSize)
    {
        int firstResult = 0;
        if (pageNumber > 0)
        {
            firstResult = (pageNumber - 1) * pageSize;
        }
        return firstResult;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task create(Task task)
    {
        return (Task)this.create(TaskDao.TRANSFORM_NONE, task);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object create(final int transform, final Task task)
    {
        if (task == null)
        {
            throw new IllegalArgumentException(
                "Task.create - 'task' can not be null");
        }
        this.getHibernateTemplate().save(task);
        return this.transformEntity(transform, task);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public Collection<Task> create(final Collection<Task> entities)
    {
        return (Collection<Task>) create(TaskDao.TRANSFORM_NONE, entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<?> create(final int transform, final Collection<Task> entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Task.create - 'entities' can not be null");
        }
        this.getHibernateTemplate().executeWithNativeSession(
            new HibernateCallback()
            {
                public Object doInHibernate(Session session)
                    throws HibernateException
                {
                    for (Task entity : entities)
                    {
                        create(transform, entity);
                    }
                    return null;
                }
            });
        return entities;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task create(
        String name)
    {
        return (Task)this.create(TaskDao.TRANSFORM_NONE, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object create(
        final int transform,
        String name)
    {
        Task entity = new TaskImpl();
        entity.setName(name);
        return this.create(transform, entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Task task)
    {
        if (task == null)
        {
            throw new IllegalArgumentException(
                "Task.update - 'task' can not be null");
        }
        this.getHibernateTemplate().update(task);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Collection<Task> entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Task.update - 'entities' can not be null");
        }
        this.getHibernateTemplate().executeWithNativeSession(
            new HibernateCallback()
            {
                public Object doInHibernate(Session session)
                    throws HibernateException
                {
                    for (Task entity : entities)
                    {
                        update(entity);
                    }
                    return null;
                }
            });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Task task)
    {
        if (task == null)
        {
            throw new IllegalArgumentException(
                "Task.remove - 'task' can not be null");
        }
        this.getHibernateTemplate().delete(task);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Long id)
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "Task.remove - 'id' can not be null");
        }
        Task entity = this.get(id);
        if (entity != null)
        {
            this.remove(entity);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Collection<Task> entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Task.remove - 'entities' can not be null");
        }
        for (Task entity : entities)
        {
            this.getHibernateTemplate().delete(entity);
        }
    }
    /**
     * Allows transformation of entities into value objects
     * (or something else for that matter), when the <code>transform</code>
     * flag is set to one of the constants defined in <code>TaskDao</code>, please note
     * that the {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself
     * will be returned.
     * <p>
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
     * @see TaskDao#transformEntity(int, Task)
     */
    public Object transformEntity(final int transform, final Task entity)
    {
        Object target = null;
        if (entity != null)
        {
            switch (transform)
            {
                case TRANSFORM_TASKVO :
                    target = toTaskVO(entity);
                    break;
                case TaskDao.TRANSFORM_NONE : // fall-through
                default:
                    target = entity;
            }
        }
        return target;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void transformEntities(final int transform, final Collection<?> entities)
    {
        switch (transform)
        {
            case TRANSFORM_TASKVO :
                toTaskVOCollection(entities);
                break;
            case TaskDao.TRANSFORM_NONE : // fall-through
                default:
                // do nothing;
        }
    }

    /**
     * @see TaskDao#toEntities(Collection)
     */
    public void toEntities(final Collection<?> results)
    {
        if (results != null)
        {
            CollectionUtils.transform(results, this.ENTITYTRANSFORMER);
        }
    }

    /**
     * This anonymous transformer is designed to transform report query results
     * (which result in an array of entities) to {@link Task}
     * using the Jakarta Commons-Collections Transformation API.
     */
    private Transformer ENTITYTRANSFORMER =
        new Transformer()
        {
            public Object transform(Object input)
            {
                Object result = null;
                if (input instanceof Object[])
                {
                    result = toEntity((Object[])input);
                }
                else if (input instanceof Task)
                {
                    result = input;
                }
                return result;
            }
        };

    /**
     * @param row
     * @return Task
     */
    protected Task toEntity(Object[] row)
    {
        Task target = null;
        if (row != null)
        {
            final int numberOfObjects = row.length;
            for (int ctr = 0; ctr < numberOfObjects; ctr++)
            {
                final Object object = row[ctr];
                if (object instanceof Task)
                {
                    target = (Task)object;
                    break;
                }
            }
        }
        return target;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public final Collection<TaskVO> toTaskVOCollection(Collection<?> entities)
    {
        Collection<TaskVO> result = new ArrayList<TaskVO>();
        if (entities != null)
        {
            CollectionUtils.transform(entities, this.TASKVO_TRANSFORMER);
            result.addAll((Collection<? extends TaskVO>) entities);
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({ "unchecked" })
    public final TaskVO[] toTaskVOArray(Collection<?> entities)
    {
        TaskVO[] result = null;
        if (entities != null)
        {
            // Unchecked transformation: reuses entities Collection
            final Collection collection = new ArrayList(entities);
            this.toTaskVOCollection(collection);
            result = (TaskVO[]) collection.toArray(new TaskVO[collection.size()]);
        }
        return result;
    }

    /**
     * Default implementation for transforming the results of a report query into a value object. This
     * implementation exists for convenience reasons only. It needs only be overridden in the
     * {@link TaskDaoImpl} class if you intend to use reporting queries.
     * @param row
     * @return toTaskVO(this.toEntity(row))
     * @see TaskDao#toTaskVO(Task)
     */
    protected TaskVO toTaskVO(Object[] row)
    {
        return this.toTaskVO(this.toEntity(row));
    }

    /**
     * This anonymous transformer is designed to transform entities or report query results
     * (which result in an array of objects) to {@link TaskVO}
     * using the Jakarta Commons-Collections Transformation API.
     */
    private Transformer TASKVO_TRANSFORMER =
        new Transformer()
        {
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
     * {@inheritDoc}
     */
    @Override
    public final void taskVOToEntityCollection(Collection<?> instances)
    {
        if (instances != null)
        {
            for (final Iterator<?> iterator = instances.iterator(); iterator.hasNext();)
            {
                // - remove an objects that are null or not of the correct instance
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
            public Object transform(Object input)
            {
                return taskVOToEntity((TaskVO)input);
            }
        };


    /**
     * {@inheritDoc}
     */
    @Override
    public void toTaskVO(
        Task source,
        TaskVO target)
    {
        target.setId(source.getId());
        target.setName(source.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskVO toTaskVO(final Task entity)
    {
        TaskVO target = null;
        if (entity != null)
        {
            target =  new TaskVO();
            this.toTaskVO(entity, target);
        }
        return target;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void taskVOToEntity(
        TaskVO source,
        Task target,
        boolean copyIfNull)
    {
        if (copyIfNull || source.getName() != null)
        {
            target.setName(source.getName());
        }
    }

    /**
     * Gets the current <code>principal</code> if one has been set,
     * otherwise returns <code>null</code>.
     *
     * @return the current principal
     */
    protected Principal getPrincipal()
    {
        return PrincipalStore.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({ "unchecked" })
    public PaginationResult search(final int transform, final int pageNumber, final int pageSize, final Search search)
    {
        try
        {
            search.setPageNumber(pageNumber);
            search.setPageSize(pageSize);
            final PropertySearch propertySearch = new PropertySearch(
                this.getSession(false), TaskImpl.class, search);
            final List results = propertySearch.executeAsList();
            this.transformEntities(transform, results);
            return new PaginationResult(results.toArray(new Object[results.size()]), propertySearch.getTotalCount());
        }
        catch (HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResult search(final int pageNumber, final int pageSize, final Search search)
    {
        return this.search(TaskDao.TRANSFORM_NONE, pageNumber, pageSize, search);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<?> search(final int transform, final Search search)
    {
        try
        {
            final PropertySearch propertySearch = new PropertySearch(
                this.getSession(false), TaskImpl.class, search);
            final Set<?> results = propertySearch.executeAsSet();
            this.transformEntities(transform, results);
            return results;
        }
        catch (HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public Set<Task> search(final Search search)
    {
        return (Set<Task>) this.search(TaskDao.TRANSFORM_NONE, search);
    }

    /**
     * Executes and returns the given Hibernate queryObject as a {@link PaginationResult} instance.
     * @param queryObject
     * @param transform
     * @param pageNumber
     * @param pageSize
     * @return PaginationResult
     */
    @SuppressWarnings({ "unchecked" })
    protected PaginationResult getPaginationResult(
        final Query queryObject,
        final int transform, int pageNumber, int pageSize)
    {
        try
        {
            final ScrollableResults scrollableResults = queryObject.scroll();
            scrollableResults.last();
            int totalCount = scrollableResults.getRowNumber();
            totalCount = totalCount >= 0 ? totalCount + 1 : 0;
            if (pageNumber > 0 && pageSize > 0)
            {
                queryObject.setFirstResult(this.calculateFirstResult(pageNumber, pageSize));
                queryObject.setMaxResults(pageSize);
            }
            // Unchecked transformation because Set object is reused, cannot be strongly typed.
            Set results = new LinkedHashSet(queryObject.list());
            transformEntities(transform, results);
            return new PaginationResult(results.toArray(new Object[results.size()]), totalCount);
        }
        catch (HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task searchUniqueName(final String name)
    {
        final Search search=new Search(
            new SearchParameter[]{
                new SearchParameter("name",name,SearchParameter.EQUAL_COMPARATOR)
            }
        );

        final Set<Task> searchResult=this.search(search);
        switch(searchResult.size())
        {
            case 0: return null;
            case 1: return searchResult.iterator().next();
            default: throw new NonUniqueResultException(searchResult.size());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object searchUniqueName(final int transform, final String name)
    {
        final Task entity=this.searchUniqueName(name);
        if(entity == null)
        {
            return null;
        }
        return transformEntity(transform, entity);
    }

    // spring-hibernate-dao-base merge-point
}
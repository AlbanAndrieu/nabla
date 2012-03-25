// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: hibernate/SpringHibernateDaoBase.vsl overrided in andromda-spring-cartridge.
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
import org.andromda.timetracker.vo.UserRoleVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * <p>
 * Base Spring DAO Class: is able to create, update, remove, load, and find
 * objects of type <code>UserRole</code>.
 * </p>
 *
 * @see UserRole
 */
public abstract class UserRoleDaoBase
    extends HibernateDaoSupport
    implements UserRoleDao
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
                "UserRole.get - 'id' can not be null");
        }
        final Object entity = this.getHibernateTemplate().get(UserRoleImpl.class, id);
        return transformEntity(transform, (UserRole)entity);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public UserRole get(Long id)
    {
        return (UserRole)this.get(TRANSFORM_NONE, id);
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
                "UserRole.load - 'id' can not be null");
        }
        final Object entity = this.getHibernateTemplate().get(UserRoleImpl.class, id);
        return transformEntity(transform, (UserRole)entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRole load(Long id)
    {
        return (UserRole)this.load(TRANSFORM_NONE, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public Collection<UserRole> loadAll()
    {
        return (Collection<UserRole>) this.loadAll(UserRoleDao.TRANSFORM_NONE);
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
        return this.loadAll(UserRoleDao.TRANSFORM_NONE, pageNumber, pageSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<?> loadAll(final int transform, final int pageNumber, final int pageSize)
    {
        try
        {
            final Criteria criteria = this.getSession(false).createCriteria(UserRoleImpl.class);
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
    public UserRole create(UserRole userRole)
    {
        return (UserRole)this.create(UserRoleDao.TRANSFORM_NONE, userRole);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object create(final int transform, final UserRole userRole)
    {
        if (userRole == null)
        {
            throw new IllegalArgumentException(
                "UserRole.create - 'userRole' can not be null");
        }
        this.getHibernateTemplate().save(userRole);
        return this.transformEntity(transform, userRole);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public Collection<UserRole> create(final Collection<UserRole> entities)
    {
        return (Collection<UserRole>) create(UserRoleDao.TRANSFORM_NONE, entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<?> create(final int transform, final Collection<UserRole> entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "UserRole.create - 'entities' can not be null");
        }
        this.getHibernateTemplate().executeWithNativeSession(
            new HibernateCallback()
            {
                public Object doInHibernate(Session session)
                    throws HibernateException
                {
                    for (UserRole entity : entities)
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
    public UserRole create(
        Role role)
    {
        return (UserRole)this.create(UserRoleDao.TRANSFORM_NONE, role);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object create(
        final int transform,
        Role role)
    {
        UserRole createEntity = new UserRoleImpl();
        createEntity.setRole(role);
        return this.create(transform, createEntity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(UserRole userRole)
    {
        if (userRole == null)
        {
            throw new IllegalArgumentException(
                "UserRole.update - 'userRole' can not be null");
        }
        this.getHibernateTemplate().update(userRole);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Collection<UserRole> entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "UserRole.update - 'entities' can not be null");
        }
        this.getHibernateTemplate().executeWithNativeSession(
            new HibernateCallback()
            {
                public Object doInHibernate(Session session)
                    throws HibernateException
                {
                    for (UserRole entity : entities)
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
    public void remove(UserRole userRole)
    {
        if (userRole == null)
        {
            throw new IllegalArgumentException(
                "UserRole.remove - 'userRole' can not be null");
        }
        this.getHibernateTemplate().delete(userRole);
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
                "UserRole.remove - 'id' can not be null");
        }
        UserRole entity = this.get(id);
        if (entity != null)
        {
            this.remove(entity);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Collection<UserRole> entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "UserRole.remove - 'entities' can not be null");
        }
        this.getHibernateTemplate().deleteAll(entities);
    }
    /**
     * Allows transformation of entities into value objects
     * (or something else for that matter), when the <code>transform</code>
     * flag is set to one of the constants defined in <code>UserRoleDao</code>, please note
     * that the {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself
     * will be returned.
     * <p>
     * This method will return instances of these types:
     * <ul>
     *   <li>{@link UserRole} - {@link #TRANSFORM_NONE}</li>
     *   <li>{@link UserRoleVO} - {@link #TRANSFORM_USERROLEVO}</li>
     * </ul>
     *
     * If the integer argument value is unknown {@link #TRANSFORM_NONE} is assumed.
     *
     * @param transform one of the constants declared in {@link UserRoleDao}
     * @param entity an entity that was found
     * @return the transformed entity (i.e. new value object, etc)
     * @see UserRoleDao#transformEntity(int, UserRole)
     */
    public Object transformEntity(final int transform, final UserRole entity)
    {
        Object target = null;
        if (entity != null)
        {
            switch (transform)
            {
                case TRANSFORM_USERROLEVO :
                    target = toUserRoleVO(entity);
                    break;
                case UserRoleDao.TRANSFORM_NONE : // fall-through
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
            case TRANSFORM_USERROLEVO :
                toUserRoleVOCollection(entities);
                break;
            case UserRoleDao.TRANSFORM_NONE : // fall-through
                default:
                // do nothing;
        }
    }

    /**
     * @see UserRoleDao#toEntities(Collection)
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
     * (which result in an array of entities) to {@link UserRole}
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
                else if (input instanceof UserRole)
                {
                    result = input;
                }
                return result;
            }
        };

    /**
     * @param row
     * @return UserRole
     */
    protected UserRole toEntity(Object[] row)
    {
        UserRole target = null;
        if (row != null)
        {
            final int numberOfObjects = row.length;
            for (int ctr = 0; ctr < numberOfObjects; ctr++)
            {
                final Object object = row[ctr];
                if (object instanceof UserRole)
                {
                    target = (UserRole)object;
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
    public final Collection toUserRoleVOCollection(Collection<?> entities)
    {
        Collection result = new ArrayList<UserRoleVO>();
        if (entities != null)
        {
            CollectionUtils.transform(entities, this.USERROLEVO_TRANSFORMER);
            result.addAll((Collection) entities);
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({ "unchecked" })
    public final UserRoleVO[] toUserRoleVOArray(Collection<?> entities)
    {
        UserRoleVO[] result = null;
        if (entities != null)
        {
            // Unchecked transformation: reuses entities Collection
            final Collection collection = new ArrayList(entities);
            this.toUserRoleVOCollection(collection);
            result = (UserRoleVO[]) collection.toArray(new UserRoleVO[collection.size()]);
        }
        return result;
    }

    /**
     * Default implementation for transforming the results of a report query into a value object. This
     * implementation exists for convenience reasons only. It needs only be overridden in the
     * {@link UserRoleDaoImpl} class if you intend to use reporting queries.
     * @param row
     * @return toUserRoleVO(this.toEntity(row))
     * @see UserRoleDao#toUserRoleVO(UserRole)
     */
    protected UserRoleVO toUserRoleVO(Object[] row)
    {
        return this.toUserRoleVO(this.toEntity(row));
    }

    /**
     * This anonymous transformer is designed to transform entities or report query results
     * (which result in an array of objects) to {@link UserRoleVO}
     * using the Jakarta Commons-Collections Transformation API.
     */
    private Transformer USERROLEVO_TRANSFORMER =
        new Transformer()
        {
            public Object transform(Object input)
            {
                Object result = null;
                if (input instanceof UserRole)
                {
                    result = toUserRoleVO((UserRole)input);
                }
                else if (input instanceof Object[])
                {
                    result = toUserRoleVO((Object[])input);
                }
                return result;
            }
        };

    /**
     * {@inheritDoc}
     */
    @Override
    public final void userRoleVOToEntityCollection(Collection<?> instances)
    {
        if (instances != null)
        {
            for (final Iterator<?> iterator = instances.iterator(); iterator.hasNext();)
            {
                // - remove an objects that are null or not of the correct instance
                if (!(iterator.next() instanceof UserRoleVO))
                {
                    iterator.remove();
                }
            }
            CollectionUtils.transform(instances, this.UserRoleVOToEntityTransformer);
        }
    }

    private final Transformer UserRoleVOToEntityTransformer =
        new Transformer()
        {
            public Object transform(Object input)
            {
                return userRoleVOToEntity((UserRoleVO)input);
            }
        };


    /**
     * {@inheritDoc}
     */
    @Override
    public void toUserRoleVO(
        UserRole source,
        UserRoleVO target)
    {
        target.setId(source.getId());
        target.setRole(source.getRole());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRoleVO toUserRoleVO(final UserRole entity)
    {
        UserRoleVO target = null;
        if (entity != null)
        {
            target =  new UserRoleVO();
            this.toUserRoleVO(entity, target);
        }
        return target;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void userRoleVOToEntity(
        UserRoleVO source,
        UserRole target,
        boolean copyIfNull)
    {
        if (copyIfNull || source.getRole() != null)
        {
            target.setRole(source.getRole());
        }
        // Do nothing for org.andromda.metafacades.emf.uml22.EntityAttributeLogicImpl[UserRole.id]
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
                this.getSession(false), UserRoleImpl.class, search);
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
        return this.search(UserRoleDao.TRANSFORM_NONE, pageNumber, pageSize, search);
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
                this.getSession(false), UserRoleImpl.class, search);
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
    public Set<UserRole> search(final Search search)
    {
        return (Set<UserRole>) this.search(UserRoleDao.TRANSFORM_NONE, search);
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

    // spring-hibernate-dao-base merge-point
}
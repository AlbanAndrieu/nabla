// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by DaoBase.vsl in andromda-ejb3-cartridge on 04/03/2012 12:18:28.
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
import org.andromda.timetracker.vo.UserRoleVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.hibernate.Session;

/**
 * <p>
 * Base EJB3 DAO Class: is able to create, update, remove, load, and find
 * objects of type <code>UserRole</code>.
 * </p>
 *
 * @see UserRoleDao
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Local({UserRoleDao.class})
public abstract class UserRoleDaoBase
    implements UserRoleDao
{
    /** Session Context Injection */
    @Resource
    protected SessionContext context;

    /**
     * Inject persistence context timetracker-ejb3
     */
    @PersistenceContext(unitName = "timetracker-ejb3")
    protected EntityManager emanager;

    /**
     * Inject Hibernate Session
     */
    @PersistenceContext(unitName = "timetracker-ejb3")
    protected Session hibernateSession;

    /**
     * @see UserRoleDao#load(int,)
     */
    @Override
    public Object load(final int transform, final Long id)
        throws UserRoleDaoException
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "UserRole.load - 'id' can not be null");
        }
        try
        {
            final Object entity = (UserRole)this.emanager.find(UserRole.class, id);
            return transformEntity(transform, (UserRole)entity);
        }
        catch (Exception ex)
        {
            throw new UserRoleDaoException(ex);
        }
    }

    /**
     * @see UserRoleDao#load()
     */
    @Override
    public UserRole load( final Long id)
        throws UserRoleDaoException
    {
        return (UserRole)this.load(TRANSFORM_NONE, id);
    }

    /**
     * @see UserRoleDao#loadAll()
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public Collection<UserRole> loadAll()
        throws UserRoleDaoException
    {
        return(Collection<UserRole>) this.loadAll(TRANSFORM_NONE);
    }

    /**
     * @see UserRoleDao#loadAll(int)
     */
    @Override
    public Collection loadAll(final int transform)
        throws UserRoleDaoException
    {
        try
        {
            Query query = emanager.createNamedQuery("UserRole.findAll");
            List<UserRole> results = query.getResultList();
            this.transformEntities(transform, results);
            return results;
        }
        catch (Exception ex)
        {
            throw new UserRoleDaoException(ex);
        }
    }

    /**
     * @see UserRoleDao#create(UserRole)
     */
    @Override
    public UserRole create(UserRole userRole)
        throws UserRoleDaoException
    {
        return (UserRole)this.create(TRANSFORM_NONE, userRole);
    }

    /**
     * @see UserRoleDao#create(int, UserRole)
     */
    @Override
    public Object create(final int transform, final UserRole userRole)
        throws UserRoleDaoException
    {
        if (userRole == null)
        {
            throw new IllegalArgumentException(
                "UserRole.create - 'userRole' can not be null");
        }

        try
        {
            this.emanager.persist(userRole);
            this.emanager.flush();
            return this.transformEntity(transform, userRole);
        }
        catch (Exception ex)
        {
            throw new UserRoleDaoException(ex);
        }
    }

    /**
     * @see UserRoleDao#create(Collection<UserRole>)
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public Collection<UserRole> create(final Collection<UserRole> entities)
        throws UserRoleDaoException
    {
        return create(TRANSFORM_NONE, entities);
    }

    /**
     * @see UserRoleDao#create(int, Collection)
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public Collection create(final int transform, final Collection<UserRole> entities)
        throws UserRoleDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "UserRole.create - 'entities' can not be null");
        }
        Collection results = new ArrayList();
        try
        {
            for (final UserRole entity : entities)
            {
                results.add(create(transform, entity));
            }
        }
        catch (Exception ex)
        {
            throw new UserRoleDaoException(ex);
        }
        return results;
    }

    /**
     * @see UserRoleDao#create(Role)
     */
    @Override
    public UserRole create(
        Role role)
        throws UserRoleDaoException
    {
        return (UserRole)this.create(TRANSFORM_NONE, role);
    }

    /**
     * @see UserRoleDao#create(int, Role)
     */
    @Override
    public Object create(
        final int transform,
        Role role)
        throws UserRoleDaoException
    {
        UserRole entity = new UserRole();
        entity.setRole(role);
        return this.create(transform, entity);
    }

    /**
     * @see UserRoleDao#update(UserRole)
     */
    @Override
    public void update(UserRole userRole)
        throws UserRoleDaoException
    {
        if (userRole == null)
        {
            throw new IllegalArgumentException(
                "UserRole.update - 'userRole' can not be null");
        }
        try
        {
            this.emanager.merge(userRole);
            this.emanager.flush();
        }
        catch (Exception ex)
        {
            throw new UserRoleDaoException(ex);
        }
    }

    /**
     * @see UserRoleDao#update(Collection<UserRole>)
     */
    @Override
    public void update(final Collection<UserRole> entities)
        throws UserRoleDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "UserRole.update - 'entities' can not be null");
        }
        try
        {
            for (final UserRole entity : entities)
            {
                update(entity);
            }
        }
        catch (Exception ex)
        {
            throw new UserRoleDaoException(ex);
        }
    }

    /**
     * @see UserRoleDao#remove(UserRole)
     */
    @Override
    public void remove(UserRole userRole)
        throws UserRoleDaoException
    {
        if (userRole == null)
        {
            throw new IllegalArgumentException(
                "UserRole.remove - 'userRole' can not be null");
        }
        try
        {
            this.emanager.remove(userRole);
            this.emanager.flush();
        }
        catch (Exception ex)
        {
            throw new UserRoleDaoException(ex);
        }
    }

    /**
     * @see UserRoleDao#remove(Long)
     */
    @Override
    public void remove(Long id)
        throws UserRoleDaoException
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "UserRole.remove - 'id' can not be null");
        }
        try
        {
            final UserRole entity = this.load(id);
            if (entity != null)
            {
                this.remove(entity);
            }
        }
        catch (Exception ex)
        {
            throw new UserRoleDaoException(ex);
        }
    }

    /**
     * @see UserRoleDao#remove(Collection<UserRole>)
     */
    @Override
    public void remove(Collection<UserRole> entities)
        throws UserRoleDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "UserRole.remove - 'entities' can not be null");
        }
        try
        {
            for (final UserRole entity : entities)
            {
                remove(entity);
            }
        }
        catch (Exception ex)
        {
            throw new UserRoleDaoException(ex);
        }
    }

    /**
     * Allows transformation of entities into value objects
     * (or something else for that matter), when the <code>transform</code>
     * flag is set to one of the constants defined in <code>UserRoleDao</code>, please note
     * that the {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself
     * will be returned.
     * <p/>
     * This method will return instances of these types:
     * <ul>
     *   <li>{@link UserRole} - {@link #TRANSFORM_NONE}</li>
     *   <li>{@link UserRoleVO} - {@link TRANSFORM_USERROLEVO}</li>
     * </ul>
     *
     * If the integer argument value is unknown {@link #TRANSFORM_NONE} is assumed.
     *
     * @param transform one of the constants declared in {@link UserRoleDao}
     * @param entity an entity that was found
     * @return the transformed entity (i.e. new value object, etc)
     * @see #transformEntities(int,Collection)
     */
    protected Object transformEntity(final int transform, final UserRole entity)
    {
        Object target = null;
        if (entity != null)
        {
            switch (transform)
            {
                case UserRoleDao.TRANSFORM_USERROLEVO :
                    target = toUserRoleVO(entity);
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
     * {@link #transformEntity(int, UserRole)}
     * method. This method does not instantiate a new collection.
     * <p/>
     * Transforms into the same collection as the argument, but this time containing the transformed entities
     * This method is to be used internally only.
     *
     * @param transform one of the constants declared in <code>UserRoleDao</code>
     * @param entities the collection of entities to transform
     * @see #transformEntity(int, UserRole)
     */
    protected void transformEntities(final int transform, final Collection<UserRole> entities)
    {
        switch (transform)
        {
            case UserRoleDao.TRANSFORM_USERROLEVO :
                toUserRoleVOCollection(entities);
                break;
            case TRANSFORM_NONE : // fall-through
                default:
                // do nothing;
        }
    }

    /**
     * @see UserRoleDao#toUserRoleVOCollection(Collection)
     */
    public final void toUserRoleVOCollection(Collection entities)
    {
        if (entities != null)
        {
            CollectionUtils.transform(entities, USERROLEVO_TRANSFORMER);
        }
    }

    /**
     * Default implementation for transforming the results of a report query into a value object. This
     * implementation exists for convenience reasons only. It needs only be overridden in the
     * {@link UserRoleDaoImpl} class if you intend to use reporting queries.
     * @see UserRoleDao#toUserRoleVO(UserRole)
     */
    protected UserRoleVO toUserRoleVO(Object[] row)
    {
        UserRoleVO target = null;
        if (row != null)
        {
            final int numberOfObjects = row.length;
            for (int ctr = 0; ctr < numberOfObjects; ctr++)
            {
                final Object object = row[ctr];
                if (object instanceof UserRole)
                {
                    target = this.toUserRoleVO((UserRole)object);
                    break;
                }
            }
        }
        return target;
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
     * @see UserRoleDao#userRoleVOToEntityCollection(Collection)
     */
    public final void userRoleVOToEntityCollection(Collection instances)
    {
        if (instances != null)
        {
            for (final Iterator iterator = instances.iterator(); iterator.hasNext();)
            {
                // - remove an objects that are null or not of the correct instance
                if (!(iterator.next() instanceof UserRoleVO))
                {
                    iterator.remove();
                }
            }
            CollectionUtils.transform(instances, UserRoleVOToEntityTransformer);
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
     * @see UserRoleDao#toUserRoleVO(UserRole, UserRoleVO)
     */
    public void toUserRoleVO(
        UserRole source,
        UserRoleVO target)
    {
        target.setId(source.getId());
        target.setRole(source.getRole());
    }

    /**
     * @see UserRoleDao#toUserRoleVO(UserRole)
     */
    public UserRoleVO toUserRoleVO(final UserRole entity)
    {
        final UserRoleVO target = new UserRoleVO();
        this.toUserRoleVO(entity, target);
        return target;
    }

    /**
     * @see UserRoleDao#userRoleVOToEntity(UserRoleVO, UserRole)
     */
    public void userRoleVOToEntity(
        UserRoleVO source,
        UserRole target,
        boolean copyIfNull)
    {
        if (copyIfNull || source.getRole() != null)
        {
            target.setRole(source.getRole());
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
     * @return the emanager
     */
    public EntityManager getEmanager()
    {
        return this.emanager;
    }

    /**
     * @param emanagerIn the emanager to set
     */
    public void setEmanager(EntityManager emanagerIn)
    {
        this.emanager = emanagerIn;
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
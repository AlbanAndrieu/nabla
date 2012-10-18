// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by DaoBase.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.andromda.timetracker.vo.UserDetailsVO;
import org.andromda.timetracker.vo.UserVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.ejb.HibernateEntityManager;
import org.jboss.seam.annotations.In;

/**
 * <p>
 * Base EJB3 DAO Class: is able to create, update, remove, load, and find
 * objects of type <code>User</code>.
 * </p>
 *
 * @see UserDao
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Local({UserDao.class})
public abstract class UserDaoBase implements UserDao
{

    private static final Logger logger = Logger.getLogger(UserDaoBase.class);

    /** Session Context Injection */
    @Resource
    protected SessionContext context;

    /**
     * Inject persistence seam context
     */
    @In

    protected EntityManager entityManager;

    // ------ DAO Injections ------

    /**
     * Inject DAO UserRoleDao
     */
    @EJB 
    protected UserRoleDao userRoleDao;

    /**
     * Gets the reference to <code>userRoleDao</code>.
     */
    protected UserRoleDao getUserRoleDao()
    {
        return this.userRoleDao;
    }

    /**
     * @see UserDao#load(int,)
     */
    @Override
    public Object load(final int transform, final Long id) throws UserDaoException
    {
        if (id == null)
        {
            throw new IllegalArgumentException("User.load - 'id' can not be null");
        }
        try
        {
            final Object entity = (User)this.entityManager.find(User.class, id);
            return transformEntity(transform, (User)entity);
        }
        catch (Exception ex)
        {
            throw new UserDaoException(ex);
        }
    }

    /**
     * @see UserDao#load()
     */
    @Override
    public User load( final Long id) throws UserDaoException
    {
        return (User)this.load(TRANSFORM_NONE, id);
    }

    /**
     * @see UserDao#loadAll()
     */
    @Override
    //@SuppressWarnings({"unchecked"})
    public Collection<User> loadAll() throws UserDaoException
    {
        return(Collection<User>) this.loadAll(TRANSFORM_NONE);
    }

    /**
     * @see UserDao#loadAll(int)
     */
    @Override
    public Collection loadAll(final int transform) throws UserDaoException
    {
        try
        {
            Query query = entityManager.createNamedQuery("User.findAll");
            List<User> results = query.getResultList();
            this.transformEntities(transform, results);
            return results;
        }
        catch (Exception ex)
        {
            throw new UserDaoException(ex);
        }
    }

    /**
     * @see UserDao#create(User)
     */
    @Override
    public User create(User user) throws UserDaoException
    {
        return (User)this.create(TRANSFORM_NONE, user);
    }

    /**
     * @see UserDao#create(int, User)
     */
    @Override
    public Object create(final int transform, final User user) throws UserDaoException
    {
        if (user == null)
        {
            throw new IllegalArgumentException("User.create - 'user' can not be null");
        }

        try
        {
            this.entityManager.persist(user);
            this.entityManager.flush();
            return this.transformEntity(transform, user);
        }
        catch (Exception ex)
        {
            throw new UserDaoException(ex);
        }
    }

    /**
     * @see UserDao#create(Collection<User>)
     */
    @Override
    //@SuppressWarnings({"unchecked"})
    public Collection<User> create(final Collection<User> entities) throws UserDaoException
    {
        return create(TRANSFORM_NONE, entities);
    }

    /**
     * @see UserDao#create(int, Collection)
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public Collection create(final int transform, final Collection<User> entities) throws UserDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException("User.create - 'entities' can not be null");
        }
        Collection results = new ArrayList();
        try
        {
            for (final User entity : entities)
            {
                results.add(create(transform, entity));
            }
        }
        catch (Exception ex)
        {
            throw new UserDaoException(ex);
        }
        return results;
    }

    /**
     * @see UserDao#create(String, String, String, String, String, boolean, Date, String)
     */
    @Override
    public User create(String username, String password, String firstName, String lastName, String email, boolean isActive, Date creationDate, String comment) throws UserDaoException
    {
        return (User)this.create(TRANSFORM_NONE, username, password, firstName, lastName, email, isActive, creationDate, comment);
    }

    /**
     * @see UserDao#create(int, String, String, String, String, String, boolean, Date, String)
     */
    @Override
    public Object create(final int transform, String username, String password, String firstName, String lastName, String email, boolean isActive, Date creationDate, String comment) throws UserDaoException
    {
        User entity = new User();
        entity.setUsername(username);
        entity.setPassword(password);
        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        entity.setEmail(email);
        entity.setIsActive(isActive);
        entity.setCreationDate(creationDate);
        entity.setComment(comment);
        return this.create(transform, entity);
    }

    /**
     * @see UserDao#update(User)
     */
    @Override
    public void update(User user) throws UserDaoException
    {
        if (user == null)
        {
            throw new IllegalArgumentException("User.update - 'user' can not be null");
        }
        try
        {
            this.entityManager.merge(user);
            this.entityManager.flush();
        }
        catch (Exception ex)
        {
            throw new UserDaoException(ex);
        }
    }

    /**
     * @see UserDao#update(Collection<User>)
     */
    @Override
    public void update(final Collection<User> entities) throws UserDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException("User.update - 'entities' can not be null");
        }
        try
        {
            for (final User entity : entities)
            {
                update(entity);
            }
        }
        catch (Exception ex)
        {
            throw new UserDaoException(ex);
        }
    }

    /**
     * @see UserDao#remove(User)
     */
    @Override
    public void remove(User user) throws UserDaoException
    {
        if (user == null)
        {
            throw new IllegalArgumentException("User.remove - 'user' can not be null");
        }
        try
        {
            this.entityManager.remove(user);
            this.entityManager.flush();
        }
        catch (Exception ex)
        {
            throw new UserDaoException(ex);
        }
    }

    /**
     * @see UserDao#remove(Long)
     */
    @Override
    public void remove(Long id) throws UserDaoException
    {
        if (id == null)
        {
            throw new IllegalArgumentException("User.remove - 'id' can not be null");
        }
        try
        {
            final User entity = this.load(id);
            if (entity != null)
            {
                this.remove(entity);
            }
        }
        catch (Exception ex)
        {
            throw new UserDaoException(ex);
        }
    }

    /**
     * @see UserDao#remove(Collection<User>)
     */
    @Override
    public void remove(Collection<User> entities) throws UserDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException("User.remove - 'entities' can not be null");
        }
        try
        {
            for (final User entity : entities)
            {
                remove(entity);
            }
        }
        catch (Exception ex)
        {
            throw new UserDaoException(ex);
        }
    }

    /**
     * @see UserDao#findByEmail(String)
     */
    @Override
    public User findByEmail(String email) throws UserDaoException
    {
        return (User)this.findByEmail(TRANSFORM_NONE, email);
    }

    /**
     * @see UserDao#findByEmail(String, String)
     */
    @Override
    public User findByEmail(final String queryString, final String email) throws UserDaoException
    {
        return (User)this.findByEmail(TRANSFORM_NONE, queryString, email);
    }

    /**
     * @see UserDao#findByEmail(int, String)
     */
    @Override
    public Object findByEmail(final int transform, final String email) throws UserDaoException
    {
        try
        {
            Query queryObject = entityManager.createNamedQuery("User.findByEmail");
            queryObject.setParameter("email", email);
            Object result = queryObject.getSingleResult();
            result = transformEntity(transform, (User)result);
            return result;
        }
        catch (Exception ex)
        {
            throw new UserDaoException(ex);
        }
    }

    /**
     * @see UserDao#findByEmail(int, String, String)
     */
    @Override
    public Object findByEmail(final int transform, final String queryString, final String email) throws UserDaoException
    {
        try
        {
            Query queryObject = entityManager.createQuery(queryString);
            queryObject.setParameter("email", email);
            Object result = queryObject.getSingleResult();
            result = transformEntity(transform, (User)result);
            return result;
        }
        catch (Exception ex)
        {
            throw new UserDaoException(ex);
        }
    }

    /**
     * @see UserDao#getUserDetails(String)
     */
    @Override
    public User getUserDetails(final String username)
    {
        if (username == null)
        {
            throw new IllegalArgumentException("org.andromda.timetracker.domain.UserDao.getUserDetails(String username) - 'username' can not be null");
        }
        try
        {
            return this.handleGetUserDetails(username);
        }
        catch (Throwable th)
        {
            UserDaoBase.logger.debug("Error performing 'UserDao.getUserDetails(String username)' --> " + th);
            throw new RuntimeException("Error performing 'UserDao.getUserDetails(String username)' --> " + th, th);
        }
    }

     /**
      * Performs the core logic for {@link #getUserDetails(String)}
      */
    protected abstract User handleGetUserDetails(String username) throws Exception;

    /**
     * Allows transformation of entities into value objects
     * (or something else for that matter), when the <code>transform</code>
     * flag is set to one of the constants defined in <code>UserDao</code>, please note
     * that the {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself
     * will be returned.
     * <p/>
     * This method will return instances of these types:
     * <ul>
     *   <li>{@link User} - {@link #TRANSFORM_NONE}</li>
     *   <li>{@link UserVO} - {@link TRANSFORM_USERVO}</li>
     *   <li>{@link UserDetailsVO} - {@link TRANSFORM_USERDETAILSVO}</li>
     * </ul>
     *
     * If the integer argument value is unknown {@link #TRANSFORM_NONE} is assumed.
     *
     * @param transform one of the constants declared in {@link UserDao}
     * @param entity an entity that was found
     * @return the transformed entity (i.e. new value object, etc)
     * @see #transformEntities(int,Collection)
     */
    protected Object transformEntity(final int transform, final User entity)
    {
        Object target = null;
        if (entity != null)
        {
            switch (transform)
            {
                case UserDao.TRANSFORM_USERVO :
                    target = toUserVO(entity);
                    break;
                case UserDao.TRANSFORM_USERDETAILSVO :
                    target = toUserDetailsVO(entity);
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
     * {@link #transformEntity(int, User)}
     * method. This method does not instantiate a new collection.
     * <p/>
     * Transforms into the same collection as the argument, but this time containing the transformed entities
     * This method is to be used internally only.
     *
     * @param transform one of the constants declared in <code>UserDao</code>
     * @param entities the collection of entities to transform
     * @see #transformEntity(int, User)
     */
    protected void transformEntities(final int transform, final Collection<User> entities)
    {
        switch (transform)
        {
            case UserDao.TRANSFORM_USERVO :
                toUserVOCollection(entities);
                break;
            case UserDao.TRANSFORM_USERDETAILSVO :
                toUserDetailsVOCollection(entities);
                break;
            case TRANSFORM_NONE : // fall-through
                default:
                // do nothing;
        }
    }

    /**
     * @see UserDao#toUserVOCollection(Collection)
     */
    public final void toUserVOCollection(Collection entities)
    {
        if (entities != null)
        {
            CollectionUtils.transform(entities, USERVO_TRANSFORMER);
        }
    }

    /**
     * Default implementation for transforming the results of a report query into a value object. This
     * implementation exists for convenience reasons only. It needs only be overridden in the
     * {@link UserDaoImpl} class if you intend to use reporting queries.
     * @see UserDao#toUserVO(User)
     */
    protected UserVO toUserVO(Object[] row)
    {
        UserVO target = null;
        if (row != null)
        {
            final int numberOfObjects = row.length;
            for (int ctr = 0; ctr < numberOfObjects; ctr++)
            {
                final Object object = row[ctr];
                if (object instanceof User)
                {
                    target = this.toUserVO((User)object);
                    break;
                }
            }
        }
        return target;
    }

    /**
     * This anonymous transformer is designed to transform entities or report query results
     * (which result in an array of objects) to {@link UserVO}
     * using the Jakarta Commons-Collections Transformation API.
     */
    private Transformer USERVO_TRANSFORMER =
        new Transformer()
        {
            public Object transform(Object input)
            {
                Object result = null;
                if (input instanceof User)
                {
                    result = toUserVO((User)input);
                }
                else if (input instanceof Object[])
                {
                    result = toUserVO((Object[])input);
                }
                return result;
            }
        };

    /**
     * @see UserDao#userVOToEntityCollection(Collection)
     */
    public final void userVOToEntityCollection(Collection instances)
    {
        if (instances != null)
        {
            for (final Iterator iterator = instances.iterator(); iterator.hasNext();)
            {
                // - remove an objects that are null or not of the correct instance
                if (!(iterator.next() instanceof UserVO))
                {
                    iterator.remove();
                }
            }
            CollectionUtils.transform(instances, UserVOToEntityTransformer);
        }
    }

    private final Transformer UserVOToEntityTransformer =
        new Transformer()
        {
            public Object transform(Object input)
            {
                return userVOToEntity((UserVO)input);
            }
        };


    /**
     * @see UserDao#toUserVO(User, UserVO)
     */
    public void toUserVO( User source, UserVO target)
    {
        target.setId(source.getId());
        target.setUsername(source.getUsername());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
    }

    /**
     * @see UserDao#toUserVO(User)
     */
    public UserVO toUserVO(final User entity)
    {
        final UserVO target = new UserVO();
        this.toUserVO(entity, target);
        return target;
    }

    /**
     * @see UserDao#userVOToEntity(UserVO, User)
     */
    public void userVOToEntity( UserVO source, User target, boolean copyIfNull)
    {
        if (copyIfNull || source.getUsername() != null)
        {
            target.setUsername(source.getUsername());
        }
        if (copyIfNull || source.getFirstName() != null)
        {
            target.setFirstName(source.getFirstName());
        }
        if (copyIfNull || source.getLastName() != null)
        {
            target.setLastName(source.getLastName());
        }
    }

    /**
     * @see UserDao#toUserDetailsVOCollection(Collection)
     */
    public final void toUserDetailsVOCollection(Collection entities)
    {
        if (entities != null)
        {
            CollectionUtils.transform(entities, USERDETAILSVO_TRANSFORMER);
        }
    }

    /**
     * Default implementation for transforming the results of a report query into a value object. This
     * implementation exists for convenience reasons only. It needs only be overridden in the
     * {@link UserDaoImpl} class if you intend to use reporting queries.
     * @see UserDao#toUserDetailsVO(User)
     */
    protected UserDetailsVO toUserDetailsVO(Object[] row)
    {
        UserDetailsVO target = null;
        if (row != null)
        {
            final int numberOfObjects = row.length;
            for (int ctr = 0; ctr < numberOfObjects; ctr++)
            {
                final Object object = row[ctr];
                if (object instanceof User)
                {
                    target = this.toUserDetailsVO((User)object);
                    break;
                }
            }
        }
        return target;
    }

    /**
     * This anonymous transformer is designed to transform entities or report query results
     * (which result in an array of objects) to {@link UserDetailsVO}
     * using the Jakarta Commons-Collections Transformation API.
     */
    private Transformer USERDETAILSVO_TRANSFORMER =
        new Transformer()
        {
            public Object transform(Object input)
            {
                Object result = null;
                if (input instanceof User)
                {
                    result = toUserDetailsVO((User)input);
                }
                else if (input instanceof Object[])
                {
                    result = toUserDetailsVO((Object[])input);
                }
                return result;
            }
        };

    /**
     * @see UserDao#userDetailsVOToEntityCollection(Collection)
     */
    public final void userDetailsVOToEntityCollection(Collection instances)
    {
        if (instances != null)
        {
            for (final Iterator iterator = instances.iterator(); iterator.hasNext();)
            {
                // - remove an objects that are null or not of the correct instance
                if (!(iterator.next() instanceof UserDetailsVO))
                {
                    iterator.remove();
                }
            }
            CollectionUtils.transform(instances, UserDetailsVOToEntityTransformer);
        }
    }

    private final Transformer UserDetailsVOToEntityTransformer =
        new Transformer()
        {
            public Object transform(Object input)
            {
                return userDetailsVOToEntity((UserDetailsVO)input);
            }
        };


    /**
     * @see UserDao#toUserDetailsVO(User, UserDetailsVO)
     */
    public void toUserDetailsVO( User source, UserDetailsVO target)
    {
        target.setId(source.getId());
        target.setUsername(source.getUsername());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setPassword(source.getPassword());
        target.setEmail(source.getEmail());
        target.setIsActive(source.isIsActive());
        target.setCreationDate(source.getCreationDate());
        target.setComment(source.getComment());
        // No conversion for target.roles (can't convert source.getRoles():org.andromda.timetracker.domain.UserRole to org.andromda.timetracker.vo.UserRoleVO[])
    }

    /**
     * @see UserDao#toUserDetailsVO(User)
     */
    public UserDetailsVO toUserDetailsVO(final User entity)
    {
        final UserDetailsVO target = new UserDetailsVO();
        this.toUserDetailsVO(entity, target);
        return target;
    }

    /**
     * @see UserDao#userDetailsVOToEntity(UserDetailsVO, User)
     */
    public void userDetailsVOToEntity( UserDetailsVO source, User target, boolean copyIfNull)
    {
        if (copyIfNull || source.getUsername() != null)
        {
            target.setUsername(source.getUsername());
        }
        if (copyIfNull || source.getPassword() != null)
        {
            target.setPassword(source.getPassword());
        }
        if (copyIfNull || source.getFirstName() != null)
        {
            target.setFirstName(source.getFirstName());
        }
        if (copyIfNull || source.getLastName() != null)
        {
            target.setLastName(source.getLastName());
        }
        if (copyIfNull || source.getEmail() != null)
        {
            target.setEmail(source.getEmail());
        }
        if (copyIfNull || source.isIsActive() != false)
        {
            target.setIsActive(source.isIsActive());
        }
        if (copyIfNull || source.getCreationDate() != null)
        {
            target.setCreationDate(source.getCreationDate());
        }
        if (copyIfNull || source.getComment() != null)
        {
            target.setComment(source.getComment());
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
        if (this.entityManager.getDelegate() instanceof HibernateEntityManager)
        {
            return ((HibernateEntityManager) this.entityManager.getDelegate()).getSession();
        } else
        {
            return (Session) this.entityManager.getDelegate();
        }
    }

}
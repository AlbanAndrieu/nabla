// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * Generated by DaoImpl.vsl in andromda-ejb3-cartridge on 03/29/2012 12:08:35.
 * You can (and have to!) safely modify it by hand.
 */
package org.andromda.timetracker.domain;

import javax.ejb.Stateless;

import org.andromda.timetracker.vo.UserDetailsVO;
import org.andromda.timetracker.vo.UserVO;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

/**
 * @see User
 */
@Stateless
// @Stateful if stateful uncomment the destroy method
@Name("userDao")
@Scope(ScopeType.EVENT)
@AutoCreate
public class UserDaoImpl extends UserDaoBase
{
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(UserDaoImpl.class);

    /**
     * @see org.andromda.timetracker.domain.UserDao#getUserDetails(String)
     */
    @Override
    protected User handleGetUserDetails(final String username)
    {
        UserDaoImpl.logger.debug("Search user : " + username);
        // final User user = (User) this.getHibernateSession().createQuery("from User user left join fetch user.roles where user.username = :username").setParameter("username", username).uniqueResult();
        final User user = (User) this.getHibernateSession().createQuery("select User from User user where user.username = :username").setParameter("username", username).uniqueResult();
        // final User user = (User) this.getEntityManager().createQuery("select User from User user where user.username = :username").setParameter("username", username).getSingleResult();
        return user;
    }

    /**
     * @see org.andromda.timetracker.domain.UserDao#toUserVO(User, UserVO)
     */
    @Override
    public void toUserVO(final User sourceEntity, final UserVO targetVO)
    {
        // TODO verify behavior of toUserVO
        super.toUserVO(sourceEntity, targetVO);
    }

    /**
     * @see org.andromda.timetracker.domain.UserDao#toUserVO(User)
     */
    @Override
    public UserVO toUserVO(final User entity)
    {
        // TODO verify behavior of toUserVO
        return super.toUserVO(entity);
    }

    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
    private User loadUserFromUserVO(final UserVO userVO)
    {
        // TODO implement loadUserFromUserVO
        throw new UnsupportedOperationException("org.andromda.timetracker.domain.loadUserFromUserVO(UserVO) not yet implemented.");

        /*
         * A typical implementation looks like this:
         * User user = this.load(userVO.getId());
         * if (user == null)
         * {
         * user = User.Factory.newInstance();
         * }
         * return user;
         */
    }

    /**
     * @see org.andromda.timetracker.domain.UserDao#userVOToEntity(UserVO)
     */
    @Override
    public User userVOToEntity(final UserVO userVO)
    {
        // TODO verify behavior of userVOToEntity
        final User entity = this.loadUserFromUserVO(userVO);
        this.userVOToEntity(userVO, entity, true);
        return entity;
    }

    /**
     * @see org.andromda.timetracker.domain.UserDao#userVOToEntity(UserVO, User)
     */
    @Override
    public void userVOToEntity(final UserVO sourceVO, final User targetEntity, final boolean copyIfNull)
    {
        // TODO verify behavior of userVOToEntity
        super.userVOToEntity(sourceVO, targetEntity, copyIfNull);
    }

    /**
     * @see org.andromda.timetracker.domain.UserDao#toUserDetailsVO(User, UserDetailsVO)
     */
    @Override
    public void toUserDetailsVO(final User sourceEntity, final UserDetailsVO targetVO)
    {
        // TODO verify behavior of toUserDetailsVO
        super.toUserDetailsVO(sourceEntity, targetVO);
        // WARNING! No conversion for targetVO.roles (can't convert sourceEntity.getRoles():org.andromda.timetracker.domain.UserRole to org.andromda.timetracker.vo.UserRoleVO[]

        // Convert roles
        // final Collection srcRoles = sourceEntity.getRoles();
        // final UserRoleVO[] targetRoles = new UserRoleVO[srcRoles.size()];
        // int i = 0;
        // for (final Object srcRole : srcRoles)
        // {
        // targetRoles[i] = this.getUserRoleDao().toUserRoleVO((UserRole) srcRole);
        // i++;
        // }
        // targetVO.setRoles(targetRoles);
    }

    /**
     * @see org.andromda.timetracker.domain.UserDao#toUserDetailsVO(User)
     */
    @Override
    public UserDetailsVO toUserDetailsVO(final User entity)
    {
        // TODO verify behavior of toUserDetailsVO
        return super.toUserDetailsVO(entity);
    }

    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
    private User loadUserFromUserDetailsVO(final UserDetailsVO userDetailsVO)
    {
        User user = null;
        if ((userDetailsVO != null) && (userDetailsVO.getId() != null))
        {
            try
            {
                user = this.load(userDetailsVO.getId());
            } catch (final UserDaoException e)
            {
                // user id no set - OK to ignore
            }
        }
        if (user == null)
        {
            user = new User();
        }
        return user;
    }

    /**
     * @see org.andromda.timetracker.domain.UserDao#userDetailsVOToEntity(UserDetailsVO)
     */
    @Override
    public User userDetailsVOToEntity(final UserDetailsVO userDetailsVO)
    {
        // TODO verify behavior of userDetailsVOToEntity
        final User entity = this.loadUserFromUserDetailsVO(userDetailsVO);
        this.userDetailsVOToEntity(userDetailsVO, entity, true);
        return entity;
    }

    /**
     * @see org.andromda.timetracker.domain.UserDao#userDetailsVOToEntity(UserDetailsVO, User)
     */
    @Override
    public void userDetailsVOToEntity(final UserDetailsVO sourceVO, final User targetEntity, final boolean copyIfNull)
    {
        // TODO verify behavior of userDetailsVOToEntity
        super.userDetailsVOToEntity(sourceVO, targetEntity, copyIfNull);

        // if (sourceVO.getRoles().length > 0)
        // {
        // final Set<UserRole> roles = new TreeSet<UserRole>();
        //
        // for (final UserRoleVO userRoleVO : sourceVO.getRoles())
        // {
        // System.out.println(" user role : " + userRoleVO.getRole());
        // roles.add(this.getUserRoleDao().userRoleVOToEntity(userRoleVO));
        // }
        // targetEntity.setRoles(roles);
        // }
    }

}

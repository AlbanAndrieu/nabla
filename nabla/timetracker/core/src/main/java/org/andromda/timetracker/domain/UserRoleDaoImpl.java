// Generated by: hibernate/SpringHibernateDaoImpl.vsl in andromda-spring-cartridge.
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package org.andromda.timetracker.domain;

import org.andromda.timetracker.vo.UserRoleVO;

/**
 * @see UserRole
 */
public class UserRoleDaoImpl
    extends UserRoleDaoBase
{
    /**
     * @inheritDoc
     */
    @Override
    public void toUserRoleVO(
        UserRole source,
        UserRoleVO target)
    {
        // TODO verify behavior of toUserRoleVO
        super.toUserRoleVO(source, target);
    }

    /**
     * @inheritDoc
     */
    @Override
    public UserRoleVO toUserRoleVO(final UserRole entity)
    {
        // TODO verify behavior of toUserRoleVO
        return super.toUserRoleVO(entity);
    }

    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
    private UserRole loadUserRoleFromUserRoleVO(UserRoleVO userRoleVO)
    {
        // TODO implement loadUserRoleFromUserRoleVO
        throw new UnsupportedOperationException("org.andromda.timetracker.domain.loadUserRoleFromUserRoleVO(UserRoleVO) not yet implemented.");

        /* A typical implementation looks like this:
        UserRole userRole = this.load(userRoleVO.getId());
        if (userRole == null)
        {
            userRole = UserRole.Factory.newInstance();
        }
        return userRole;
        */
    }

    /**
     * @inheritDoc
     */
    public UserRole userRoleVOToEntity(UserRoleVO userRoleVO)
    {
        // TODO verify behavior of userRoleVOToEntity
        UserRole entity = this.loadUserRoleFromUserRoleVO(userRoleVO);
        this.userRoleVOToEntity(userRoleVO, entity, true);
        return entity;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void userRoleVOToEntity(
        UserRoleVO source,
        UserRole target,
        boolean copyIfNull)
    {
        // TODO verify behavior of userRoleVOToEntity
        super.userRoleVOToEntity(source, target, copyIfNull);
    }
}

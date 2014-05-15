// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: TimeTracker::TimeTracker::org.andromda.timetracker::service::UserService
 * STEREOTYPE:  Service
 */
package org.andromda.timetracker.service;

import java.util.Collection;

import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.domain.UserDao;
import org.andromda.timetracker.vo.UserDetailsVO;
import org.andromda.timetracker.vo.UserVO;

/**
 * @see org.andromda.timetracker.service.UserService
 */
public class UserServiceImpl extends UserServiceBase
{

    // /**
    // * @return userVOs
    // * @throws Exception
    // * @see org.andromda.timetracker.service.UserService#getAllUsers()
    // */
    // @Override
    // Use this implementation for UML2 model with returnParameter * multiplicity
    // @SuppressWarnings("unchecked")
    // protected Collection<UserVO> handleGetAllUsers() throws Exception
    // {
    // return (Collection<UserVO>) this.getUserDao().loadAll(UserDao.TRANSFORM_USERVO);
    // }

    /**
     * @see org.andromda.timetracker.service.UserService#getAllUsers()
     */
    @Override
    protected UserVO[] handleGetAllUsers() throws Exception
    {
        final Collection userVOs = this.getUserDao().loadAll(UserDao.TRANSFORM_USERVO);
        return (UserVO[]) userVOs.toArray(new UserVO[userVOs.size()]);
    }

    /**
     * @see org.andromda.timetracker.service.UserService#getUser(String)
     */
    @Override
    protected UserVO handleGetUser(final String username) throws Exception
    {
        final User user = this.getUserDao().getUserDetails(username);
        return this.getUserDao().toUserVO(user);
    }

    /**
     * @see org.andromda.timetracker.service.UserService#registerUser(UserDetailsVO)
     */
    @Override
    protected UserDetailsVO handleRegisterUser(final UserDetailsVO userDetailVO) throws Exception
    {
        User user = this.getUserDao().userDetailsVOToEntity(userDetailVO);
        user = this.getUserDao().create(user);
        return this.getUserDao().toUserDetailsVO(user);
    }

    /**
     * @see org.andromda.timetracker.service.UserService#removeUser(UserVO)
     */
    @Override
    protected void handleRemoveUser(final UserVO userVO) throws Exception
    {
        this.getUserDao().remove(userVO.getId());
    }

}

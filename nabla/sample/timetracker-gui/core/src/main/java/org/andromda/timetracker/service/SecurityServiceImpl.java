// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: TimeTracker::TimeTracker::org.andromda.timetracker::service::SecurityService
 * STEREOTYPE:  Service
 */
package org.andromda.timetracker.service;

import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.vo.UserDetailsVO;

/**
 * @see org.andromda.timetracker.service.SecurityService
 */
public class SecurityServiceImpl extends SecurityServiceBase
{

    /**
     * @see org.andromda.timetracker.service.SecurityService#getUserDetails(String)
     */
    @Override
    protected UserDetailsVO handleGetUserDetails(final String username) throws Exception
    {
        UserDetailsVO userDetailsVO = null;
        final User user = this.getUserDao().getUserDetails(username);
        if (user != null)
        {
            userDetailsVO = this.getUserDao().toUserDetailsVO(user);
        }
        return userDetailsVO;
    }
}

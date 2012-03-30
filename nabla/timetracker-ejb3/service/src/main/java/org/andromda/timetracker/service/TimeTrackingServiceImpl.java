// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: TimeTracker::TimeTracker::org.andromda.timetracker::service::TimeTrackingService
 * STEREOTYPE:  Service
 */
package org.andromda.timetracker.service;

import java.util.List;

import org.andromda.timetracker.vo.TimecardSearchCriteriaVO;
import org.andromda.timetracker.vo.TimecardSummaryVO;

/**
 * @see org.andromda.timetracker.service.TimeTrackingService
 */
public class TimeTrackingServiceImpl extends TimeTrackingServiceBase
{

    /**
     * @see org.andromda.timetracker.service.TimeTrackingService#findTimecards(TimecardSearchCriteriaVO)
     */
    @Override
    protected TimecardSummaryVO[] handleFindTimecards(final TimecardSearchCriteriaVO criteria) throws Exception
    {
        final List<TimecardSummaryVO> timecards = this.getTimecardDao().findByCriteria(criteria);
        this.getTimecardDao().toTimecardSummaryVOCollection(timecards);
        return timecards.toArray(new TimecardSummaryVO[timecards.size()]);
    }

}

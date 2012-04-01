// license-header java merge-point
package org.andromda.timetracker.web.timecardsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.andromda.timetracker.domain.TimecardStatus;
import org.andromda.timetracker.service.TimeTrackingServiceDelegate;
import org.andromda.timetracker.service.UserDoesNotExistException;
import org.andromda.timetracker.service.UserServiceDelegate;
import org.andromda.timetracker.vo.TimecardSearchCriteriaVO;
import org.andromda.timetracker.vo.TimecardSummaryVO;
import org.andromda.timetracker.vo.UserVO;
import org.andromda.timetracker.vo.UserVOComparator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @see org.andromda.timetracker.web.timecardsearch.SearchController
 */
public class SearchControllerImpl extends SearchController
{
    private static final long   serialVersionUID = 1465722497189650491L;

    private final Log           logger           = LogFactory.getLog(SearchControllerImpl.class);
    private static final String ALL_STRING       = "-- All --";

    /**
     * @see org.andromda.timetracker.web.timecardsearch.SearchController#populateSearchScreen(java.lang.Long submitter, java.lang.Long approver, java.lang.String status, java.util.Date startDateMinimum, java.util.Date startDateMaximum)
     */
    @Override
    public void populateSearchScreen(final PopulateSearchScreenForm form)
    {
        // form.setSubmitterValueList(new Object[] {"submitter-1", "submitter-2", "submitter-3", "submitter-4", "submitter-5"});
        // form.setSubmitterLabelList(form.getSubmitterValueList());
        // form.setApproverValueList(new Object[] {"approver-1", "approver-2", "approver-3", "approver-4", "approver-5"});
        // form.setApproverLabelList(form.getApproverValueList());
        // form.setStatusValueList(new Object[] {"status-1", "status-2", "status-3", "status-4", "status-5"});
        // form.setStatusLabelList(form.getStatusValueList());

        if (this.logger.isDebugEnabled())
        {
            this.logger.debug("form: " + form);
        }

        // Get the list of users and add the "All" option at the top
        UserVO[] users = null;
        UserServiceDelegate usd = null;
        try
        {
            usd = new UserServiceDelegate();
            users = usd.getAllUsers();
        }
        catch (final UserDoesNotExistException e)
        {
            this.logger.debug("UserDoesNotExistException" + e);
        }
        finally
        {
            usd.close();
        }

        if (users != null)
        {
            Arrays.sort(users, new UserVOComparator());
            final List userList = new ArrayList(Arrays.asList(users));
            userList.add(0, new UserVO(Long.valueOf(0), SearchControllerImpl.ALL_STRING, null, null));

            // Populate the submitter and approver dropdowns
            form.setSubmitterBackingList(userList, "id", "username");
            form.setApproverBackingList(userList, "id", "username");
        }

        // Populate the status dropdown
        final List statusLabels = new ArrayList(TimecardStatus.literals());
        final List statusValues = new ArrayList(TimecardStatus.literals());
        statusLabels.add(0, SearchControllerImpl.ALL_STRING);
        statusValues.add(0, "");
        form.setStatusLabelList(statusLabels.toArray());
        form.setStatusValueList(statusValues.toArray());

        TimecardStatus status = null;
        if ((form.getStatus() != null) && (form.getStatus().length() > 0))
        {
            status = TimecardStatus.fromString(form.getStatus());
        }

        // Populate timecard summaries
        final TimecardSearchCriteriaVO criteria = new TimecardSearchCriteriaVO(form.getSubmitter(), form.getApprover(), status, form.getStartDateMinimum(), form.getStartDateMaximum());

        TimeTrackingServiceDelegate tsd = null;
        try
        {
            tsd = new TimeTrackingServiceDelegate();
            final TimecardSummaryVO[] timecards = tsd.findTimecards(criteria);
            form.setTimecardSummaries(timecards);
        }
        catch (final Exception e)
        {
            this.logger.error("failed finding timecards", e);
        }
        finally
        {
            tsd.close();
        }
    }

    /**
     * @see org.andromda.timetracker.web.timecardsearch.SearchController#initializeTimecardId(org.andromda.timetracker.web.timecardsearch.InitializeTimecardIdForm)
     */
    @Override
    public void initializeTimecardId(final InitializeTimecardIdForm form)
    {
        form.setTimecardId(form.getId());
    }

}

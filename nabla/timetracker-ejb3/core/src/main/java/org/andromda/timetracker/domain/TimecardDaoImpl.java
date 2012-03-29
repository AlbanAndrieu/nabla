// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package org.andromda.timetracker.domain;

import java.util.List;

import org.andromda.timetracker.vo.TimecardVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

/**
 * @see org.andromda.timetracker.domain.Timecard
 */
public class TimecardDaoImpl extends org.andromda.timetracker.domain.TimecardDaoBase
{
    private final Log logger = LogFactory.getLog(TimecardDaoImpl.class);

    /**
     * @see org.andromda.timetracker.domain.TimecardDao#findByCriteria(org.andromda.timetracker.vo.TimecardSearchCriteriaVO)
     */
    @Override
    protected java.util.List handleFindByCriteria(final org.andromda.timetracker.vo.TimecardSearchCriteriaVO criteria)
    {
        // Create the timecard criteria
        final Criteria timecardCriteria = this.hibernateSession.createCriteria(Timecard.class);
        timecardCriteria.setFetchMode("submitter", FetchMode.JOIN);
        timecardCriteria.setFetchMode("approver", FetchMode.JOIN);

        // Add sumitter criteria
        if (criteria.getSubmitterId() != null)
        {
            timecardCriteria.createCriteria("submitter").add(Restrictions.idEq(criteria.getSubmitterId()));
        }

        // Add approver criteria
        if (criteria.getApproverId() != null)
        {
            timecardCriteria.createCriteria("approver").add(Restrictions.idEq(criteria.getApproverId()));
        }

        // Add status criteria
        if (criteria.getStatus() != null)
        {
            timecardCriteria.add(Restrictions.eq("status", criteria.getStatus()));
        }

        // Add startDateMin criteria
        if (criteria.getStartDateMin() != null)
        {
            timecardCriteria.add(Restrictions.ge("startDate", criteria.getStartDateMin()));
        }

        // Add startDateMax criteria
        if (criteria.getStartDateMax() != null)
        {
            timecardCriteria.add(Restrictions.le("startDate", criteria.getStartDateMax()));
        }

        final List timecards = timecardCriteria.list();
        if (this.logger.isDebugEnabled())
        {
            this.logger.debug(timecards.size() + " timecards found");
        }
        return timecards;
    }

    /**
     * @see org.andromda.timetracker.domain.TimecardDao#toTimecardSummaryVO(org.andromda.timetracker.domain.Timecard, org.andromda.timetracker.vo.TimecardSummaryVO)
     */
    @Override
    public void toTimecardSummaryVO(final org.andromda.timetracker.domain.Timecard sourceEntity, final org.andromda.timetracker.vo.TimecardSummaryVO targetVO)
    {
        // TODO verify behavior of toTimecardSummaryVO
        super.toTimecardSummaryVO(sourceEntity, targetVO);

        // add the related entities
        targetVO.setSubmitterName(sourceEntity.getSubmitter().getUsername());
        if (sourceEntity.getApprover() != null)
        {
            targetVO.setApproverName(sourceEntity.getApprover().getUsername());
        }
    }

    /**
     * @see org.andromda.timetracker.domain.TimecardDao#toTimecardSummaryVO(org.andromda.timetracker.domain.Timecard)
     */
    @Override
    public org.andromda.timetracker.vo.TimecardSummaryVO toTimecardSummaryVO(final org.andromda.timetracker.domain.Timecard entity)
    {
        // TODO verify behavior of toTimecardSummaryVO
        return super.toTimecardSummaryVO(entity);
    }

    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
    private Timecard loadTimecardFromTimecardVO(final TimecardVO timecardVO)
    {
        // TODO implement loadTimecardFromTimecardVO
        throw new UnsupportedOperationException("org.andromda.timetracker.domain.loadTimecardFromTimecardVO(TimecardVO) not yet implemented.");

        /*
         * A typical implementation looks like this:
         * Timecard timecard = this.load(timecardVO.getId());
         * if (timecard == null)
         * {
         * timecard = Timecard.Factory.newInstance();
         * }
         * return timecard;
         */
    }

    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
    private org.andromda.timetracker.domain.Timecard loadTimecardFromTimecardSummaryVO(final org.andromda.timetracker.vo.TimecardSummaryVO timecardSummaryVO)
    {
        // TODO implement loadTimecardFromTimecardSummaryVO
        throw new java.lang.UnsupportedOperationException("org.andromda.timetracker.domain.loadTimecardFromTimecardSummaryVO(org.andromda.timetracker.vo.TimecardSummaryVO) not yet implemented.");

        /*
         * A typical implementation looks like this:
         * org.andromda.timetracker.domain.Timecard timecard = this.load(timecardSummaryVO.getId());
         * if (timecard == null)
         * {
         * timecard = org.andromda.timetracker.domain.Timecard.Factory.newInstance();
         * }
         * return timecard;
         */
    }

    /**
     * @see org.andromda.timetracker.domain.TimecardDao#timecardSummaryVOToEntity(org.andromda.timetracker.vo.TimecardSummaryVO)
     */
    @Override
    public org.andromda.timetracker.domain.Timecard timecardSummaryVOToEntity(final org.andromda.timetracker.vo.TimecardSummaryVO timecardSummaryVO)
    {
        // TODO verify behavior of timecardSummaryVOToEntity
        final org.andromda.timetracker.domain.Timecard entity = this.loadTimecardFromTimecardSummaryVO(timecardSummaryVO);
        this.timecardSummaryVOToEntity(timecardSummaryVO, entity, true);
        return entity;
    }

    /**
     * @see org.andromda.timetracker.domain.TimecardDao#timecardSummaryVOToEntity(org.andromda.timetracker.vo.TimecardSummaryVO, org.andromda.timetracker.domain.Timecard)
     */
    @Override
    public void timecardSummaryVOToEntity(final org.andromda.timetracker.vo.TimecardSummaryVO sourceVO, final org.andromda.timetracker.domain.Timecard targetEntity, final boolean copyIfNull)
    {
        // TODO verify behavior of timecardSummaryVOToEntity
        super.timecardSummaryVOToEntity(sourceVO, targetEntity, copyIfNull);
    }

    /*
     * (non-Javadoc)
     * @see org.andromda.timetracker.domain.TimecardDao#timecardVOToEntity(org.andromda.timetracker.vo.TimecardVO)
     */
    @Override
    public Timecard timecardVOToEntity(final TimecardVO timecardVO)
    {
        // TODO verify behavior of timecardVOToEntity
        final Timecard entity = this.loadTimecardFromTimecardVO(timecardVO);
        this.timecardVOToEntity(timecardVO, entity, true);
        return entity;
    }

}

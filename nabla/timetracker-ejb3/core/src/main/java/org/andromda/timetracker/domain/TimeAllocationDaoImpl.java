// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * Generated by DaoImpl.vsl in andromda-ejb3-cartridge on 03/25/2012 14:35:52.
 * You can (and have to!) safely modify it by hand.
 */
package org.andromda.timetracker.domain;

import org.andromda.timetracker.vo.TimeAllocationVO;

/**
 * @see TimeAllocation
 */
public class TimeAllocationDaoImpl
    extends TimeAllocationDaoBase
{
    /**
     * @see org.andromda.timetracker.domain.TimeAllocationDao#toTimeAllocationVO(TimeAllocation, TimeAllocationVO)
     */
    public void toTimeAllocationVO(
        TimeAllocation sourceEntity,
        TimeAllocationVO targetVO)
    {
        // TODO verify behavior of toTimeAllocationVO
        super.toTimeAllocationVO(sourceEntity, targetVO);
    }


    /**
     * @see org.andromda.timetracker.domain.TimeAllocationDao#toTimeAllocationVO(TimeAllocation)
     */
    public TimeAllocationVO toTimeAllocationVO(final TimeAllocation entity)
    {
        // TODO verify behavior of toTimeAllocationVO
        return super.toTimeAllocationVO(entity);
    }


    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
    private TimeAllocation loadTimeAllocationFromTimeAllocationVO(TimeAllocationVO timeAllocationVO)
    {
        // TODO implement loadTimeAllocationFromTimeAllocationVO
        throw new UnsupportedOperationException("org.andromda.timetracker.domain.loadTimeAllocationFromTimeAllocationVO(TimeAllocationVO) not yet implemented.");

        /* A typical implementation looks like this:
        TimeAllocation timeAllocation = this.load(timeAllocationVO.getId());
        if (timeAllocation == null)
        {
            timeAllocation = TimeAllocation.Factory.newInstance();
        }
        return timeAllocation;
        */
    }


    /**
     * @see org.andromda.timetracker.domain.TimeAllocationDao#timeAllocationVOToEntity(TimeAllocationVO)
     */
    public TimeAllocation timeAllocationVOToEntity(TimeAllocationVO timeAllocationVO)
    {
        // TODO verify behavior of timeAllocationVOToEntity
        TimeAllocation entity = this.loadTimeAllocationFromTimeAllocationVO(timeAllocationVO);
        this.timeAllocationVOToEntity(timeAllocationVO, entity, true);
        return entity;
    }


    /**
     * @see org.andromda.timetracker.domain.TimeAllocationDao#timeAllocationVOToEntity(TimeAllocationVO, TimeAllocation)
     */
    public void timeAllocationVOToEntity(
        TimeAllocationVO sourceVO,
        TimeAllocation targetEntity,
        boolean copyIfNull)
    {
        // TODO verify behavior of timeAllocationVOToEntity
        super.timeAllocationVOToEntity(sourceVO, targetEntity, copyIfNull);
    }

}
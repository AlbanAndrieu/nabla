// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * Generated by DaoImpl.vsl in andromda-ejb3-cartridge on 03/29/2012 12:08:35.
 * You can (and have to!) safely modify it by hand.
 */
package org.andromda.timetracker.domain;

import org.andromda.timetracker.vo.TaskVO;

/**
 * @see Task
 */
public class TaskDaoImpl extends TaskDaoBase
{
    /**
     * @see org.andromda.timetracker.domain.TaskDao#toTaskVO(Task, TaskVO)
     */
    @Override
    public void toTaskVO(final Task sourceEntity, final TaskVO targetVO)
    {
        // TODO verify behavior of toTaskVO
        super.toTaskVO(sourceEntity, targetVO);
    }

    /**
     * @see org.andromda.timetracker.domain.TaskDao#toTaskVO(Task)
     */
    @Override
    public TaskVO toTaskVO(final Task entity)
    {
        // TODO verify behavior of toTaskVO
        return super.toTaskVO(entity);
    }

    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
    private Task loadTaskFromTaskVO(final TaskVO taskVO)
    {
        // TODO implement loadTaskFromTaskVO
        throw new UnsupportedOperationException("org.andromda.timetracker.domain.loadTaskFromTaskVO(TaskVO) not yet implemented.");

        /*
         * A typical implementation looks like this:
         * Task task = this.load(taskVO.getId());
         * if (task == null)
         * {
         * task = Task.Factory.newInstance();
         * }
         * return task;
         */
    }

    /**
     * @see org.andromda.timetracker.domain.TaskDao#taskVOToEntity(TaskVO)
     */
    @Override
    public Task taskVOToEntity(final TaskVO taskVO)
    {
        // TODO verify behavior of taskVOToEntity
        final Task entity = this.loadTaskFromTaskVO(taskVO);
        this.taskVOToEntity(taskVO, entity, true);
        return entity;
    }

    /**
     * @see org.andromda.timetracker.domain.TaskDao#taskVOToEntity(TaskVO, Task)
     */
    @Override
    public void taskVOToEntity(final TaskVO sourceVO, final Task targetEntity, final boolean copyIfNull)
    {
        // TODO verify behavior of taskVOToEntity
        super.taskVOToEntity(sourceVO, targetEntity, copyIfNull);
    }

}

// license-header java merge-point
// Generated by: crud/SpringCrudServiceBase.vsl in andromda-spring-cartridge.
package org.andromda.timetracker.domain.crud;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.andromda.timetracker.domain.Task;

/**
 *This class represents a task for which time allocations need to be tracked.
 */
public final class TaskManageableServiceBase
    implements TaskManageableService
{
    private TaskManageableDao dao;

    /**
     * @param daoIn
     */
    public void setDao(TaskManageableDao daoIn)
    {
        this.dao = daoIn;
    }

    /**
     * @return dao
     */
    protected TaskManageableDao getDao()
    {
        return this.dao;
    }

    /**
     * @param name 
     * @param id 
     * @return TaskValueObject
     * @throws Exception
     * @see org.andromda.timetracker.domain.TaskDao#create
     */
    public TaskValueObject create(String name, Long id)
        throws Exception
    {
        if (name == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.TaskManageableService.create(String name, Long id) - 'name' can not be null");
        }

        return toValueObject(this.dao.create(name, id));
    }

    /**
     * @param id
     * @return TaskValueObject
     * @throws Exception
     * @see TaskManageableService#readById(Long)
     */
    public TaskValueObject readById(Long id)
        throws Exception
    {
        return toValueObject(this.dao.readById(id));
    }

    /**
     * @param name 
     * @param id 
     * @return toValueObjects(dao.read())
     * @throws Exception
     * @see TaskManageableService#read
     */
    public List<TaskValueObject> read(String name, Long id)
        throws Exception
    {
        return toValueObjects(this.dao.read(name, id));
    }

    /**
     * @return toValueObjects(dao.readAll())
     * @throws Exception
     */
    public List<TaskValueObject> readAll()
        throws Exception
    {
        return toValueObjects(this.dao.readAll());
    }

    /**
     * @param name 
     * @param id 
     * @return toValueObject(this.dao.update(name, id))
     * @throws Exception
     * @see TaskManageableDao#update
     */
    public TaskValueObject update(String name, Long id)
        throws Exception
    {
        if (name == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.TaskManageableService.update(String name, Long id) - 'name' can not be null");
        }

        return toValueObject(this.dao.update(name, id));
    }

    /**
     * @param ids
     * @throws Exception
     * @see TaskManageableService#delete(Long[])
     */
    public void delete(Long[] ids)
        throws Exception
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.TaskManageableService.delete(Long[] ids) - 'ids' can not be null");
        }

        this.dao.delete(ids);
    }

    private static List<TaskValueObject> toValueObjects(Collection<Task> entities)
    {
        final List<TaskValueObject> list = new ArrayList<TaskValueObject>();

        for (Iterator<Task> iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject(iterator.next()));
        }

        return list;
    }

    private static TaskValueObject toValueObject(Task entity)
    {
        final TaskValueObject valueObject = new TaskValueObject();

        valueObject.setName(entity.getName());
        valueObject.setId(entity.getId());

        return valueObject;
    }
}
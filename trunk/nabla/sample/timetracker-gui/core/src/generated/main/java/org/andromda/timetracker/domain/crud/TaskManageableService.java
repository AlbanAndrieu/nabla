// license-header java merge-point
// Generated by: crud/SpringCrudService.vsl in andromda-spring-cartridge.
package org.andromda.timetracker.domain.crud;

import java.util.List;

/**
 * This class represents a task for which time allocations need to be tracked.
 */
public interface TaskManageableService
{
    /**
     * @param name 
     * @param id 
     * @return create
     * @throws Exception
     */
    public TaskValueObject create(String name, Long id)
        throws Exception;

    /**
     * @param id The manageable identifier name
     * @return manageable
     * @throws Exception
     */
    public TaskValueObject readById(Long id)
        throws Exception;

    /**
     * @param name 
     * @param id 
     * @return manageable
     * @throws Exception
     */
    public List<TaskValueObject> read(String name, Long id)
        throws Exception;

    /**
     * @return all manageable
     * @throws Exception
     */
    public List<TaskValueObject> readAll()
        throws Exception;

    /**
     * @param name 
     * @param id 
     * @return update
     * @throws Exception
     */
    public TaskValueObject update(String name, Long id)
        throws Exception;

    /**
     * @param ids The array of IDs to be deleted
     * @throws Exception
     */
    public void delete(Long[] ids)
        throws Exception;

}
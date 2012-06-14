// license-header java merge-point
// Generated by: crud/SpringCrudDaoBase.vsl overrided in andromda-spring-cartridge.
package org.andromda.timetracker.domain.crud;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.andromda.timetracker.domain.Task;
import org.andromda.timetracker.domain.TaskDao;
import org.andromda.timetracker.domain.TaskImpl;
import org.andromda.timetracker.domain.TimeAllocation;
import org.andromda.timetracker.domain.TimeAllocationImpl;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * This class represents a task for which time allocations need to be tracked.
 */
public final class TaskManageableDaoBase
    extends HibernateDaoSupport
    implements TaskManageableDao
{
    private TaskDao dao;

    /**
     * @param daoIn
     */
    public void setDao(TaskDao daoIn)
    {
        this.dao = daoIn;
    }

    /**
     * @return dao
     */
    protected TaskDao getDao()
    {
        return this.dao;
    }

    @SuppressWarnings({"unchecked"})
    private Set<TimeAllocation> findTimeAllocationByIds(Long[] ids)
    {
        final Session session = this.getSession(false);
        try
        {
            final Criteria criteria = session.createCriteria(TimeAllocationImpl.class);
            criteria.add(Restrictions.in("id", ids));
            return new HashSet<TimeAllocation>(criteria.list());
        }
        catch (HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    /**
     * @param name 
     * @param id 
     * @return entity
     * @see TaskDao#create(Task)
     */
    @SuppressWarnings("cast")
    public Task create(String name, Long id)
    {
        final Task entity = new TaskImpl();

        entity.setName(name);
        entity.setId(id);

        return (Task)this.getDao().create(entity);
    }

    /**
     * @param id
     * @return entity
     * @see TaskDao#load(Long)
     */
    public Task readById(Long id)
    {
        return getDao().load(id);
    }

    /**
     * @param name 
     * @param id 
     * @return List<Task>
     */
    @SuppressWarnings("unchecked")
    public List<Task> read(String name, Long id)
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(TaskImpl.class);

            if (name != null)
            {
                criteria.add(Restrictions.ilike("name", name, MatchMode.START));
            }
            if (id != null)
            {
                criteria.add(Restrictions.eq("id", id));
            }
            criteria.setMaxResults(250);

            return criteria.list();
        }
        catch (HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    /**
     * @return criteria.list()
     */
    @SuppressWarnings("unchecked")
    public List<Task> readAll()
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(TaskImpl.class);
            criteria.setMaxResults(250);
            return criteria.list();
        }
        catch (HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    /**
     * @param name 
     * @param id 
     * @return getDao().update(entity)
     * @see TaskDao#update(Task)
     */
    public Task update(String name, Long id)
    {
        final Task entity = this.getDao().load(id);

        entity.setName(name);
        // entity.setId(id);

        this.getDao().update(entity);
        return entity;
    }


    /**
     * @param ids
     */
    public void delete(Long[] ids)
    {
        final Session session = getSession(false);
        try
        {
            final Query queryObject =
                session.createQuery("delete TaskImpl where id in (:ids)");
            queryObject.setParameterList("ids", ids);
            queryObject.executeUpdate();
        }
        catch (HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }
}
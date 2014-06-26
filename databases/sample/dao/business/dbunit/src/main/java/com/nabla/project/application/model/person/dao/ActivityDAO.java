package com.nabla.project.application.model.person.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import com.nabla.project.application.model.person.entity.Activity;

/**
 * Data access object (DAO) for domain model class Activity.
 * 
 * @see com.nabla.project.application.model.dao.person.entity.Activity
 * @author MyEclipse Persistence Tools
 */
public class ActivityDAO extends JpaDaoSupport implements IActivityDAO
{

    private final Log          logger  = LogFactory.getLog(this.getClass());

    // property constants
    public static final String VERSION = "version";
    public static final String NAME    = "name";

    @Override
    public void save(final Activity transientInstance)
    {
        this.logger.info("saving Activity instance");

        try
        {
            this.getJpaTemplate().persist(transientInstance);
            this.logger.info("save successful");
        } catch (final RuntimeException re)
        {
            this.logger.error("save failed", re);
            throw re;
        }
    }

    @Override
    public void delete(final Activity persistentInstance)
    {
        this.logger.info("deleting Activity instance");

        try
        {
            this.getJpaTemplate().remove(persistentInstance);
            this.logger.info("delete successful");
        } catch (final RuntimeException re)
        {
            this.logger.error("delete failed", re);
            throw re;
        }
    }

    @Override
    public Activity update(final Activity detachedInstance)
    {
        this.logger.info("updating Activity instance");

        try
        {
            final Activity result = this.getJpaTemplate().merge(detachedInstance);
            this.logger.info("update successful");

            return result;
        } catch (final RuntimeException re)
        {
            this.logger.error("update failed", re);
            throw re;
        }
    }

    @Override
    public Activity findById(final Long id)
    {
        this.logger.info("finding Activity instance with id: " + id);

        try
        {
            final Activity instance = this.getJpaTemplate().find(Activity.class, id);

            return instance;
        } catch (final RuntimeException re)
        {
            this.logger.error("find failed", re);
            throw re;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Activity> findByProperty(final String propertyName, final Object value)
    {
        this.logger.info("finding Activity instance with property: " + propertyName + ", value: " + value);

        try
        {
            final String queryString = "select model from Activity model where model." + propertyName + "= ?1";

            return this.getJpaTemplate().find(queryString, value);
        } catch (final RuntimeException re)
        {
            this.logger.error("find by property name failed", re);
            ;
            throw re;
        }
    }

    @Override
    public List<Activity> findByVersion(final Object version)
    {
        return this.findByProperty(ActivityDAO.VERSION, version);
    }

    @Override
    public List<Activity> findByName(final Object name)
    {
        return this.findByProperty(ActivityDAO.NAME, name);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Activity> findAll()
    {
        this.logger.info("finding all Activity instances");

        try
        {
            final String queryString = "select model from Activity model";

            return this.getJpaTemplate().find(queryString);
        } catch (final RuntimeException re)
        {
            this.logger.error("find all failed", re);
            ;
            throw re;
        }
    }

    public static IActivityDAO getFromApplicationContext(final ApplicationContext ctx)
    {
        return (IActivityDAO) ctx.getBean("ActivityDAO");
    }
}

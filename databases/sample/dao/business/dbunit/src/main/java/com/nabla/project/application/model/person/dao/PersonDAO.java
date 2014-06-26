package com.nabla.project.application.model.person.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.appfuse.dao.jpa.GenericDaoJpa;
import org.springframework.context.ApplicationContext;

import com.nabla.project.application.model.person.entity.Person;

/**
 * Data access object (DAO) for domain model class Person.
 * 
 * @see com.nabla.project.application.model.dao.person.entity.Person
 * @author MyEclipse Persistence Tools
 */

// public class PersonDAOTest extends JpaDaoSupport implements IPersonDAO
public class PersonDAO extends GenericDaoJpa<Person, Long> implements IPersonDAO
{
    public static Logger       logger     = Logger.getLogger(PersonDAO.class);

    // property constants
    public static final String VERSION    = "version";
    public static final String FIRSTNAME  = "firstname";
    public static final String LASTNAME   = "lastname";
    public static final String MARRIED    = "married";
    public static final String NBCHILDREN = "nbchildren";

    public PersonDAO()
    {
        super(Person.class);
    }

    /*
     * public void save( Person transientInstance )
     * {
     * logger.info( "saving Person instance" );
     * try
     * {
     * getJpaTemplate( ).persist( transientInstance );
     * logger.info( "save successful" );
     * } catch ( RuntimeException re )
     * {
     * logger.error( "save failed", re );
     * throw re;
     * }
     * }
     * public void delete( Person persistentInstance )
     * {
     * logger.info( "deleting Person instance" );
     * try
     * {
     * getJpaTemplate( ).remove( persistentInstance );
     * logger.info( "delete successful" );
     * } catch ( RuntimeException re )
     * {
     * logger.error( "delete failed", re );
     * throw re;
     * }
     * }
     * public Person update( Person detachedInstance )
     * {
     * logger.info( "updating Person instance" );
     * try
     * {
     * Person result = getJpaTemplate( ).merge( detachedInstance );
     * logger.info( "update successful" );
     * return result;
     * } catch ( RuntimeException re )
     * {
     * logger.error( "update failed", re );
     * throw re;
     * }
     * }
     * public Person findById( Long id )
     * {
     * logger.info( "finding Person instance with id: " + id );
     * try
     * {
     * Person instance = getJpaTemplate( ).find( Person.class, id );
     * return instance;
     * } catch ( RuntimeException re )
     * {
     * logger.error( "find failed", re );
     * throw re;
     * }
     * }
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Person> findByProperty(final String propertyName, final Object value)
    {
        PersonDAO.logger.info("finding Person instance with property: " + propertyName + ", value: " + value);

        try
        {
            final Query q = super.getEntityManager().createQuery("select p from Person p where p." + propertyName + "= ?");
            q.setParameter(1, value);

            return q.getResultList();

            // String queryString = "select model from Person model where model." + propertyName + "= ?1";
            // return getJpaTemplate( ).find( queryString, value );
        } catch (final RuntimeException re)
        {
            PersonDAO.logger.error("find by property name failed", re);
            ;
            throw re;
        }
    }

    @Override
    public List<Person> findByVersion(final Object version)
    {
        return this.findByProperty(PersonDAO.VERSION, version);
    }

    @Override
    public List<Person> findByFirstname(final Object firstname)
    {
        return this.findByProperty(PersonDAO.FIRSTNAME, firstname);
    }

    /*
     * public List<Person> findByLastname( Object lastname )
     * {
     * return findByProperty( LASTNAME, lastname );
     * }
     */

    // @SuppressWarnings("unchecked")
    @Override
    public List<Person> findByLastname(final Object lastName)
    {
        return this.findByProperty(PersonDAO.LASTNAME, lastName);
    }

    @Override
    public List<Person> findByMarried(final Object married)
    {
        return this.findByProperty(PersonDAO.MARRIED, married);
    }

    @Override
    public List<Person> findByNbchildren(final Object nbchildren)
    {
        return this.findByProperty(PersonDAO.NBCHILDREN, nbchildren);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> findAll()
    {
        PersonDAO.logger.info("finding all Person instances");

        try
        {
            final Query q = super.getEntityManager().createQuery("select p from Person p");

            return q.getResultList();

            // String queryString = "select model from Person model";
            // return getJpaTemplate( ).find( queryString );
        } catch (final RuntimeException re)
        {
            PersonDAO.logger.error("find all failed", re);
            ;
            throw re;
        }
    }

    public static IPersonDAO getFromApplicationContext(final ApplicationContext ctx)
    {
        return (IPersonDAO) ctx.getBean("PersonDAOTest");
    }
}

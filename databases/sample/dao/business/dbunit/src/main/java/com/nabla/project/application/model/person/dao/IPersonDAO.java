package com.nabla.project.application.model.person.dao;

import com.nabla.project.application.model.person.entity.Person;

import org.appfuse.dao.GenericDao;

import java.util.List;

/**
 * Interface for PersonDAO.
 *
 * @author MyEclipse Persistence Tools
 */
public interface IPersonDAO extends GenericDao<Person, Long>
{
    // public void save( Person transientInstance );

    // public void delete( Person persistentInstance );

    // public Person update( Person detachedInstance );

    // public Person findById( Long id );
    public List<Person> findByProperty(String propertyName, Object value);

    public List<Person> findByVersion(Object version);

    public List<Person> findByFirstname(Object firstname);

    public List<Person> findByLastname(Object lastname);

    public List<Person> findByMarried(Object married);

    public List<Person> findByNbchildren(Object nbchildren);

    public List<Person> findAll();

    // public List<Person> findByLastName(String lastName);
}

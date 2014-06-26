package com.nabla.project.application.database.business.hibernate.dao;

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.nabla.project.application.database.business.global.dao.IPersonDao;
import com.nabla.project.application.database.business.global.model.Person;

public class PersonDaoHibernateTest extends BaseDaoTestCase
{
    @Autowired
    private IPersonDao personDao = null;

    // private GenericDao<Person, Long> personDao = null;
    public void setPersonDao(final IPersonDao personDao)
    {
        this.personDao = personDao;
    }

    @Test
    public void testFindPersonByLastName() throws Exception
    {
        System.out.println("PersonDao : " + this.personDao);

        Person person = new Person();
        person.setFirstName("Marc");
        person.setLastName("Giry");

        person = this.personDao.save(person);

        final List<Person> people = this.personDao.findByLastName("Giry");
        Assert.assertTrue(people.size() > 0);
        System.out.println("Person : " + people.get(0).getLastName());
    }

    @Test
    public void testAddAndRemovePerson() throws Exception
    {
        Person person = new Person();

        // Use the file PersonDaoHibernateTest.properties
        // person = (Person) this.populate(person);
        person.setFirstName("Matt");
        person.setLastName("Raible");

        person = this.personDao.save(person);

        System.out.println("First name : " + person.getFirstName());
        System.out.println("Last name : " + person.getLastName());
        System.out.println("ID : " + person.getId());

        Assert.assertEquals("Matt", person.getFirstName());
        Assert.assertEquals("Raible", person.getLastName());
        Assert.assertNotNull(person.getId());

        this.log.debug("removing person...");

        this.personDao.remove(person.getId());

        try
        {
            this.personDao.get(person.getId());
            Assert.fail("Person found in database");
        } catch (final DataAccessException dae)
        {
            this.log.debug("Expected exception: " + dae.getMessage());
            Assert.assertNotNull(dae);
        }
    }
}

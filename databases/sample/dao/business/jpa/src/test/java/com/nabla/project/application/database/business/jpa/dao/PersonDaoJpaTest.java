package com.nabla.project.application.database.business.jpa.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.nabla.project.application.database.business.global.dao.IPersonDao;
import com.nabla.project.application.database.business.global.model.Person;

public class PersonDaoJpaTest extends BaseDaoTestCase
{
    @Autowired
    private IPersonDao personDao = null;

    // private GenericDao<Person, Long> personDao = null;
    public void setPersonDao(final IPersonDao personDao)
    {
        this.personDao = personDao;
    }

    /*
     * public void setPersonDao(GenericDao<Person, Long> personDao) {
     * this.personDao = personDao;
     * }
     */
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
        // person = (Person) populate(person);
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
        } catch (final EntityNotFoundException enf)
        {
            this.log.debug("Expected exception: " + enf.getMessage());
            Assert.assertNotNull(enf);
        } catch (final ObjectRetrievalFailureException orf)
        {
            this.log.debug("Expected exception: " + orf.getMessage());
        }
    }
}

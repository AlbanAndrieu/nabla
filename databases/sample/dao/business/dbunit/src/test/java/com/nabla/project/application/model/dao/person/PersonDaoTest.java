package com.nabla.project.application.model.dao.person;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.nabla.project.application.model.person.dao.IPersonDAO;
import com.nabla.project.application.model.person.entity.Address;
import com.nabla.project.application.model.person.entity.Person;

public class PersonDaoTest extends AbstractDaoDatabase
{

    public static Logger logger    = Logger.getLogger(DaoTest.class);

    private IPersonDAO   personDao = null;

    public void setTestDao(final IPersonDAO testDao)
    {
        this.personDao = testDao;
    }

    public void testFindPersonByLastName() throws Exception
    {
        final List<Person> people = this.personDao.findByLastname("Raible");
        Assert.assertTrue(people.size() > 0);
    }

    public void testAddAndRemovePerson() throws Exception
    {
        Person person = new Person("Lucas", "Cedric", new SimpleDateFormat("dd/MM/yy").parse("31/01/2000"), true, 2);

        // Use the file PersonDaoHibernateTest.properties
        // person = (Person) populate(person);

        // person.setFirstname("Cedric");
        // person.setLastname("Lucas");

        final Address address = new Address("adr1", null, null, "38410", "Uriage", null, "France");
        person.setAddress(address);

        // Already exist
        person = this.personDao.save(person);

        System.out.println("First name : " + person.getFirstname());
        System.out.println("Last name : " + person.getLastname());
        System.out.println("ID : " + person.getId());

        Assert.assertEquals("Cedric", person.getFirstname());
        Assert.assertEquals("Lucas", person.getLastname());
        Assert.assertNotNull(person.getId());

        PersonDaoTest.logger.debug("removing person...");

        this.personDao.remove(person.getId());

        try
        {
            this.personDao.get(person.getId());
            Assert.fail("Person found in database");
        } catch (final EntityNotFoundException enf)
        {
            PersonDaoTest.logger.debug("Expected exception: " + enf.getMessage());
            Assert.assertNotNull(enf);
        } catch (final ObjectRetrievalFailureException orf)
        {
            PersonDaoTest.logger.debug("Expected exception: " + orf.getMessage());
        }
    }
}

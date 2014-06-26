package com.nabla.project.application.model.dao.person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;

import com.nabla.project.application.model.person.dao.IPersonDAO;
import com.nabla.project.application.model.person.entity.Person;
import com.nabla.project.application.time.Chronometer;

public class DaoTest extends AbstractDaoDatabase
{
    public static Logger logger  = Logger.getLogger(DaoTest.class);
    private IPersonDAO   testDao = null;

    // couche service
    // private IService service;
    Chronometer          chronometer;

    // Called by spring to inject the testDao
    public void setTestDao(final IPersonDAO testDao)
    {
        this.testDao = testDao;
    }

    /*
     * (non-Javadoc)
     * @see com.nabla.project.application.model.dao.person.AbstractDaoDatabase#onSetUpInTransaction()
     */
    @Override
    protected void onSetUpInTransaction() throws Exception
    {
        // TODO Auto-generated method stub
        super.onSetUpInTransaction();
        this.chronometer = new Chronometer();
        this.chronometer.start();
    }

    public void testFindAllNames()
    {
        final List<Person> persons = this.testDao.findAll();
        Assert.assertEquals(2, persons.size());

        Date date;

        try
        {
            date = new SimpleDateFormat("dd/MM/yy").parse("20/04/2007");
            Assert.assertTrue(persons.get(0).getBirthdate().compareTo(date) == 0);
        } catch (final ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Assert.assertTrue(persons.get(0).getFirstname().contains("Firstname 1"));
        Assert.assertTrue(persons.get(0).getLastname().contains("Lastname 1"));
        Assert.assertTrue(persons.get(0).getMarried().equals(true));
        Assert.assertTrue(persons.get(0).getNbchildren().equals(2));
    }

    /*
     * (non-Javadoc)
     * @see com.nabla.project.application.model.dao.person.AbstractDaoDatabase#onTearDownAfterTransaction()
     */
    @Override
    protected void onTearDownAfterTransaction() throws Exception
    {
        // TODO Auto-generated method stub
        super.onTearDownAfterTransaction();
        this.chronometer.stop();
        DaoTest.logger.info("Total Time = " + this.chronometer);
    }
}

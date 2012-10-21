package com.nabla.database.person.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.nabla.database.person.dao.IDao;
import com.nabla.database.person.entites.Activity;
import com.nabla.database.person.entites.Address;
import com.nabla.database.person.entites.Person;

// All method go through one transaction
@Transactional
public class Service implements IService
{
    // couche [dao]
    private IDao dao;

    public IDao getDao()
    {
        return this.dao;
    }

    public void setDao(final IDao dao)
    {
        this.dao = dao;
    }

    @Override
    public Person getPerson(final Long personId)
    {
        return this.dao.getPerson(personId);
    }

    @Override
    // @SuppressWarnings("unchecked")
    public List<Person> getAllPersons()
    {
        return this.dao.getAllPersons();
    }

    @Override
    // @SuppressWarnings("unchecked")
    public List<Person> getAllPersonsWithNameLike(final String modelName)
    {
        return this.dao.getAllPersonsWithNameLike(modelName);
    }

    @Override
    // @SuppressWarnings("unchecked")
    public List<Activity> getActivitiesOfPerson(final Long personId)
    {
        return this.dao.getActivitiesOfPerson(personId);
    }

    @Override
    public Person updatePerson(final Person person)
    {
        return this.dao.updatePerson(person);
    }

    @Override
    public Person savePerson(final Person person)
    {
        return this.dao.savePerson(person);
    };

    @Override
    public void deletePerson(final Long personId)
    {
        this.dao.deletePerson(personId);
    }

    @Override
    public void savePersonsWithActivities(final Person[] persons)
    {
        for (final Person person : persons)
        {
            this.dao.savePerson(person);

            for (final Activity activity : person.getActivities())
            {
                this.dao.saveActivity(activity);
            }
        }
    }

    @Override
    public Activity getActivity(final Long activityId)
    {
        return this.dao.getActivity(activityId);
    }

    @Override
    // @SuppressWarnings("unchecked")
    public List<Activity> getAllActivities()
    {
        return this.dao.getAllActivities();
    }

    @Override
    // @SuppressWarnings("unchecked")
    public List<Activity> getAllActivitiesWithNameLike(final String modelName)
    {
        return this.dao.getAllActivitiesWithNameLike(modelName);
    };

    @Override
    public Activity saveActivity(final Activity activity)
    {
        return this.dao.saveActivity(activity);
    }

    @Override
    public Activity updateActivity(final Activity activity)
    {
        return this.dao.updateActivity(activity);
    }

    @Override
    public void deleteActivity(final Long activityId)
    {
        this.dao.deleteActivity(activityId);
    }

    @Override
    public List<Person> getPersonsDoingActivity(final Long activityId)
    {
        return this.dao.getPersonsDoingActivity(activityId);
    }

    @Override
    public List<Address> getAllAddresses()
    {
        return this.dao.getAllAddresses();
    }
}

package com.nabla.database.person.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.nabla.database.person.entites.Activity;
import com.nabla.database.person.entites.Address;
import com.nabla.database.person.entites.Person;

public class Dao implements IDao
{
    @PersistenceContext
    private EntityManager em;

    // persons
    @Override
    public Person getPerson(final Long categoryId)
    {
        return this.em.find(Person.class, categoryId);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getAllPersons()
    {
        return this.em.createQuery("select p from Person p").getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getAllPersonsWithNameLike(final String modelName)
    {
        return this.em.createQuery("select p from Person p where p.lastname like :model").setParameter("model", modelName).getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Activity> getActivitiesOfPerson(final Long personId)
    {
        return this.em.createQuery("select a from Person p join p.activities a where p.id=:personId").setParameter("personId", personId).getResultList();
    }

    @Override
    public Person updatePerson(final Person person)
    {
        return this.em.merge(person);
    }

    @Override
    public Person savePerson(final Person person)
    {
        this.em.persist(person);

        return person;
    }

    @Override
    public void deletePerson(final Long personId)
    {
        final Person person = this.em.find(Person.class, personId);

        if (person == null)
        {
            throw new DaoException(30);
        }

        this.em.remove(person);
    }

    // activity
    @Override
    public Activity getActivity(final Long activityId)
    {
        return this.em.find(Activity.class, activityId);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Activity> getAllActivities()
    {
        return this.em.createQuery("select a from Activity a").getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Activity> getAllActivitiesWithNameLike(final String modelName)
    {
        return this.em.createQuery("select a from Activity a where a.name like :model").setParameter("model", modelName).getResultList();
    }

    @Override
    public Activity saveActivity(final Activity activity)
    {
        this.em.persist(activity);

        return activity;
    }

    @Override
    public Activity updateActivity(final Activity activity)
    {
        return this.em.merge(activity);
    }

    @Override
    public void deleteActivity(final Long activityId)
    {
        final Activity article = this.em.find(Activity.class, activityId);

        if (article == null)
        {
            throw new DaoException(20);
        }

        this.em.remove(article);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getPersonsDoingActivity(final Long activityId)
    {
        // The following query works with Hibernate, not with Toplink which does not accept the following navigation p.activites.id
        // return em.createQuery("select p from Person p, Activity a where p.activites.id=a.id and a.id=:activiteId").setParameter("activiteId",
        // activiteId).getResultList();

        // The following query works for both
        return this.em.createQuery("select p from Person p join p.activities a where a.id=:activityId").setParameter("activityId", activityId).getResultList();
    }

    // addresses
    @Override
    @SuppressWarnings("unchecked")
    public List<Address> getAllAddresses()
    {
        return this.em.createQuery("select a from Address a").getResultList();
    }
}

package com.nabla.project.application.database.business.global.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.appfuse.dao.jpa.GenericDaoJpa;
import org.springframework.stereotype.Repository;

import com.nabla.project.application.database.business.global.model.Activity;
import com.nabla.project.application.database.business.global.model.Address;
import com.nabla.project.application.database.business.global.model.Person;

@Repository("dao")
public class Dao implements IDao
{

    @PersistenceContext(unitName = GenericDaoJpa.PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public EntityManager getEntityManager()
    {
        return this.entityManager;
    }

    // persons
    @Override
    public Person getPerson(final Long categoryId)
    {
        return this.entityManager.find(Person.class, categoryId);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getAllPersons()
    {
        return this.entityManager.createQuery("select p from Person p").getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getAllPersonsWithNameLike(final String modelName)
    {
        return this.entityManager.createQuery("select p from Person p where p.lastName like :model").setParameter("model", modelName).getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Activity> getActivitiesOfPerson(final Long personId)
    {
        return this.entityManager.createQuery("select a from Person p join p.activities a where p.id=:personId").setParameter("personId", personId).getResultList();
    }

    @Override
    public Person updatePerson(final Person person)
    {
        return this.entityManager.merge(person);
    }

    @Override
    public Person savePerson(final Person person)
    {
        this.entityManager.persist(person);

        return person;
    }

    @Override
    public void deletePerson(final Long personId)
    {
        final Person person = this.entityManager.find(Person.class, personId);

        if (person == null)
        {
            throw new DaoException(30);
        }

        this.entityManager.remove(person);
    }

    // activity
    @Override
    public Activity getActivity(final Long activityId)
    {
        return this.entityManager.find(Activity.class, activityId);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Activity> getAllActivities()
    {
        return this.entityManager.createQuery("select a from Activity a").getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Activity> getAllActivitiesWithNameLike(final String modelName)
    {
        return this.entityManager.createQuery("select a from Activity a where a.name like :model").setParameter("model", modelName).getResultList();
    }

    @Override
    public Activity saveActivity(final Activity activity)
    {
        this.entityManager.persist(activity);

        return activity;
    }

    @Override
    public Activity updateActivity(final Activity activity)
    {
        return this.entityManager.merge(activity);
    }

    @Override
    public void deleteActivity(final Long activityId)
    {
        final Activity article = this.entityManager.find(Activity.class, activityId);

        if (article == null)
        {
            throw new DaoException(20);
        }

        this.entityManager.remove(article);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getPersonsDoingActivity(final Long activityId)
    {
        // The following query works with Hibernate, not with Toplink which does not accept the following navigation p.activites.id
        // return em.createQuery("select p from Person p, Activity a where p.activites.id=a.id and a.id=:activiteId").setParameter("activiteId",
        // activiteId).getResultList();

        // The following query works for both
        return this.entityManager.createQuery("select p from Person p join p.activities a where a.id=:activityId").setParameter("activityId", activityId).getResultList();
    }

    // addresses
    @Override
    @SuppressWarnings("unchecked")
    public List<Address> getAllAddresses()
    {
        return this.entityManager.createQuery("select a from Address a").getResultList();
    }

    @Override
    public void deleteAddress(final Long addressId)
    {
        final Address address = this.entityManager.find(Address.class, addressId);

        if (address == null)
        {
            throw new DaoException(30);
        }

        this.entityManager.remove(address);
    }
}

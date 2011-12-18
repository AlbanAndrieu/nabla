package com.nabla.project.application.model.person.dao;

import com.nabla.project.application.model.person.entity.Activity;
import com.nabla.project.application.model.person.entity.Address;
import com.nabla.project.application.model.person.entity.Person;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Dao
    implements IDao
{
    @PersistenceContext
    private EntityManager em;

    // personnes
    public Person getPerson( Long categoryId )
    {
        return em.find( Person.class, categoryId );
    }

    @SuppressWarnings( "unchecked" )
    public List<Person> getAllPersons(  )
    {
        return em.createQuery( "select p from Person p" ).getResultList(  );
    }

    @SuppressWarnings( "unchecked" )
    public List<Person> getAllPersonsWithNameLike( String modelName )
    {
        return em.createQuery( "select p from Person p where p.lastname like :model" ).setParameter( "model", modelName )
                 .getResultList(  );
    }

    @SuppressWarnings( "unchecked" )
    public List<Activity> getActivitiesOfPerson( Long personId )
    {
        return em.createQuery( "select a from Person p join p.activities a where p.id=:personId" )
                 .setParameter( "personId", personId ).getResultList(  );
    }

    public Person updatePerson( Person person )
    {
        return em.merge( person );
    }

    public Person savePerson( Person person )
    {
        em.persist( person );

        return person;
    }

    public void deletePerson( Long personId )
    {
        Person person = em.find( Person.class, personId );

        if ( person == null )
        {
            throw new DaoException( 30 );
        }

        em.remove( person );
    }

    // activités
    public Activity getActivity( Long activityId )
    {
        return em.find( Activity.class, activityId );
    }

    @SuppressWarnings( "unchecked" )
    public List<Activity> getAllActivities(  )
    {
        return em.createQuery( "select a from Activity a" ).getResultList(  );
    }

    @SuppressWarnings( "unchecked" )
    public List<Activity> getAllActivitiesWithNameLike( String modelName )
    {
        return em.createQuery( "select a from Activity a where a.name like :model" ).setParameter( "model", modelName )
                 .getResultList(  );
    }

    public Activity saveActivity( Activity activity )
    {
        em.persist( activity );

        return activity;
    }

    public Activity updateActivity( Activity activity )
    {
        return em.merge( activity );
    }

    public void deleteActivity( Long activityId )
    {
        Activity article = em.find( Activity.class, activityId );

        if ( article == null )
        {
            throw new DaoException( 20 );
        }

        em.remove( article );
    }

    @SuppressWarnings( "unchecked" )
    public List<Person> getPersonsDoingActivity( Long activityId )
    {
        // la requête suivante marche avec Hibernate, pas avec Toplink qui refuse la navigation p.activites.id
        // return em.createQuery("select p from Person p, Activity a where p.activites.id=a.id and a.id=:activiteId").setParameter("activiteId",
        // activiteId).getResultList();

        // la requête suivante est acceptée par les deux
        return em.createQuery( "select p from Person p join p.activities a where a.id=:activityId" )
                 .setParameter( "activityId", activityId ).getResultList(  );
    }

    // adresses
    @SuppressWarnings( "unchecked" )
    public List<Address> getAllAddresses(  )
    {
        return em.createQuery( "select a from Address a" ).getResultList(  );
    }
}

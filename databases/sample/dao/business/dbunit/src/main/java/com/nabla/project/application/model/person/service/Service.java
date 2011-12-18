package com.nabla.project.application.model.person.service;

import com.nabla.project.application.model.person.dao.IDao;
import com.nabla.project.application.model.person.entity.Activity;
import com.nabla.project.application.model.person.entity.Address;
import com.nabla.project.application.model.person.entity.Person;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//ttes les méthodes de la classe se déroulent dans une transaction
@Transactional
public class Service
    implements IService
{
    // couche [dao]
    private IDao dao;

    public IDao getDao(  )
    {
        return dao;
    }

    public void setDao( IDao dao )
    {
        this.dao = dao;
    }

    // catégories
    public Person getPerson( Long personId )
    {
        return dao.getPerson( personId );
    }

    @SuppressWarnings( "unchecked" )
    public List<Person> getAllPersons(  )
    {
        return dao.getAllPersons(  );
    }

    @SuppressWarnings( "unchecked" )
    public List<Person> getAllPersonsWithNameLike( String modelName )
    {
        return dao.getAllPersonsWithNameLike( modelName );
    }

    @SuppressWarnings( "unchecked" )
    public List<Activity> getActivitiesOfPerson( Long personId )
    {
        return dao.getActivitiesOfPerson( personId );
    }

    public Person updatePerson( Person person )
    {
        return dao.updatePerson( person );
    }

    public Person savePerson( Person person )
    {
        return dao.savePerson( person );
    }
    ;
    public void deletePerson( Long personId )
    {
        dao.deletePerson( personId );
    }

    public void savePersonsWithActivities( Person[] persons )
    {
        for ( Person person : persons )
        {
            dao.savePerson( person );

            for ( Activity activity : person.getActivities(  ) )
            {
                dao.saveActivity( activity );
            }
        }
    }

    // activites
    public Activity getActivity( Long activityId )
    {
        return dao.getActivity( activityId );
    }

    @SuppressWarnings( "unchecked" )
    public List<Activity> getAllActivities(  )
    {
        return dao.getAllActivities(  );
    }

    @SuppressWarnings( "unchecked" )
    public List<Activity> getAllActivitiesWithNameLike( String modelName )
    {
        return dao.getAllActivitiesWithNameLike( modelName );
    }
    ;
    public Activity saveActivity( Activity activity )
    {
        return dao.saveActivity( activity );
    }

    public Activity updateActivity( Activity activity )
    {
        return dao.updateActivity( activity );
    }

    public void deleteActivity( Long activityId )
    {
        dao.deleteActivity( activityId );
    }

    public List<Person> getPersonsDoingActivity( Long activityId )
    {
        return dao.getPersonsDoingActivity( activityId );
    }

    // adresses
    public List<Address> getAllAddresses(  )
    {
        return dao.getAllAddresses(  );
    }
}

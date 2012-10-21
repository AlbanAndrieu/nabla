package com.nabla.project.application.model.person.service;

import com.nabla.project.application.model.person.entity.Activity;
import com.nabla.project.application.model.person.entity.Address;
import com.nabla.project.application.model.person.entity.Person;

import java.util.List;

public interface IService
{
    // activites
    public Activity getActivity(Long activityId);

    public List<Activity> getAllActivities();

    public Activity saveActivity(Activity activity);

    public Activity updateActivity(Activity activity);

    public void deleteActivity(Long activityId);

    public List<Activity> getAllActivitiesWithNameLike(String modelName);

    public List<Person> getPersonsDoingActivity(Long activityId);

    // personnes
    public Person getPerson(Long personId);

    public List<Person> getAllPersons();

    public Person savePerson(Person person);

    public Person updatePerson(Person person);

    public void deletePerson(Long personId);

    public List<Person> getAllPersonsWithNameLike(String modelName);

    public void savePersonsWithActivities(Person[] persons);

    public List<Activity> getActivitiesOfPerson(Long personId);

    // adresses
    public List<Address> getAllAddresses();
}

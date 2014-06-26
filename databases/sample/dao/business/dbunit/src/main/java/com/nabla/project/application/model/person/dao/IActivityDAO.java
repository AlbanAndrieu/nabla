package com.nabla.project.application.model.person.dao;

import com.nabla.project.application.model.person.entity.Activity;

import java.util.List;

/**
 * Interface for ActivityDAO.
 * 
 * @author MyEclipse Persistence Tools
 */
public interface IActivityDAO
{
    public void save(Activity transientInstance);

    public void delete(Activity persistentInstance);

    public Activity update(Activity detachedInstance);

    public Activity findById(Long id);

    public List<Activity> findByProperty(String propertyName, Object value);

    public List<Activity> findByVersion(Object version);

    public List<Activity> findByName(Object name);

    public List<Activity> findAll();
}

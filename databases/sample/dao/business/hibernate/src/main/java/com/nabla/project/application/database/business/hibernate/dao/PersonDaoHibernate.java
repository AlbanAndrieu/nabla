package com.nabla.project.application.database.business.hibernate.dao;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

import com.nabla.project.application.database.business.global.dao.IPersonDao;
import com.nabla.project.application.database.business.global.model.Person;

@Repository("personDao")
public class PersonDaoHibernate extends GenericDaoHibernate<Person, Long> implements IPersonDao
{
    public PersonDaoHibernate()
    {
        super(Person.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> findByLastName(final String lastName)
    {
        return this.getHibernateTemplate().find("from Person where lastName=?", lastName);
    }
}

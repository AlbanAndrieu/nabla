package com.nabla.project.application.database.business.jpa.dao;

import java.util.List;

import javax.persistence.Query;

import org.appfuse.dao.jpa.GenericDaoJpa;
import org.springframework.stereotype.Repository;

import com.nabla.project.application.database.business.global.dao.IPersonDao;
import com.nabla.project.application.database.business.global.model.Person;

@Repository("personDao")
public class PersonDaoJpa extends GenericDaoJpa<Person, Long> implements IPersonDao
{
    public PersonDaoJpa()
    {
        super(Person.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> findByLastName(final String lastName)
    {
        final Query q = super.getEntityManager().createQuery("select p from Person p where p.lastName=?");
        q.setParameter(1, lastName);

        return q.getResultList();
    }
}

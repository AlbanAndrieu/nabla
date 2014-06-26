package com.nabla.project.application.model.person.dao;

import com.nabla.project.application.model.person.entity.Address;

import java.util.List;

/**
 * Interface for AddressDAO.
 * 
 * @author MyEclipse Persistence Tools
 */
public interface IAddressDAO
{
    public void save(Address transientInstance);

    public void delete(Address persistentInstance);

    public Address update(Address detachedInstance);

    public Address findById(Long id);

    public List<Address> findByProperty(String propertyName, Object value);

    public List<Address> findByVersion(Object version);

    public List<Address> findByAdr1(Object adr1);

    public List<Address> findByAdr2(Object adr2);

    public List<Address> findByAdr3(Object adr3);

    public List<Address> findByCedex(Object cedex);

    public List<Address> findByCity(Object city);

    public List<Address> findByCode(Object code);

    public List<Address> findByCountry(Object country);

    public List<Address> findAll();
}

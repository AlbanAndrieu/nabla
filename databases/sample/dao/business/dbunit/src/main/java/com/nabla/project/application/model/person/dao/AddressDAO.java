package com.nabla.project.application.model.person.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import com.nabla.project.application.model.person.entity.Address;

/**
 * Data access object (DAO) for domain model class Address.
 * 
 * @see com.nabla.project.application.model.dao.person.entity.Address
 * @author MyEclipse Persistence Tools
 */
public class AddressDAO extends JpaDaoSupport implements IAddressDAO
{
    // property constants
    public static final String VERSION = "version";
    public static final String ADR1    = "adr1";
    public static final String ADR2    = "adr2";
    public static final String ADR3    = "adr3";
    public static final String CEDEX   = "cedex";
    public static final String CITY    = "city";
    public static final String CODE    = "code";
    public static final String COUNTRY = "country";

    @Override
    public void save(final Address transientInstance)
    {
        this.logger.info("saving Address instance");

        try
        {
            this.getJpaTemplate().persist(transientInstance);
            this.logger.info("save successful");
        } catch (final RuntimeException re)
        {
            this.logger.error("save failed", re);
            throw re;
        }
    }

    @Override
    public void delete(final Address persistentInstance)
    {
        this.logger.info("deleting Address instance");

        try
        {
            this.getJpaTemplate().remove(persistentInstance);
            this.logger.info("delete successful");
        } catch (final RuntimeException re)
        {
            this.logger.error("delete failed", re);
            throw re;
        }
    }

    @Override
    public Address update(final Address detachedInstance)
    {
        this.logger.info("updating Address instance");

        try
        {
            final Address result = this.getJpaTemplate().merge(detachedInstance);
            this.logger.info("update successful");

            return result;
        } catch (final RuntimeException re)
        {
            this.logger.error("update failed", re);
            throw re;
        }
    }

    @Override
    public Address findById(final Long id)
    {
        this.logger.info("finding Address instance with id: " + id);

        try
        {
            final Address instance = this.getJpaTemplate().find(Address.class, id);

            return instance;
        } catch (final RuntimeException re)
        {
            this.logger.error("find failed", re);
            throw re;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Address> findByProperty(final String propertyName, final Object value)
    {
        this.logger.info("finding Address instance with property: " + propertyName + ", value: " + value);

        try
        {
            final String queryString = "select model from Address model where model." + propertyName + "= ?1";

            return this.getJpaTemplate().find(queryString, value);
        } catch (final RuntimeException re)
        {
            this.logger.error("find by property name failed", re);
            ;
            throw re;
        }
    }

    @Override
    public List<Address> findByVersion(final Object version)
    {
        return this.findByProperty(AddressDAO.VERSION, version);
    }

    @Override
    public List<Address> findByAdr1(final Object adr1)
    {
        return this.findByProperty(AddressDAO.ADR1, adr1);
    }

    @Override
    public List<Address> findByAdr2(final Object adr2)
    {
        return this.findByProperty(AddressDAO.ADR2, adr2);
    }

    @Override
    public List<Address> findByAdr3(final Object adr3)
    {
        return this.findByProperty(AddressDAO.ADR3, adr3);
    }

    @Override
    public List<Address> findByCedex(final Object cedex)
    {
        return this.findByProperty(AddressDAO.CEDEX, cedex);
    }

    @Override
    public List<Address> findByCity(final Object city)
    {
        return this.findByProperty(AddressDAO.CITY, city);
    }

    @Override
    public List<Address> findByCode(final Object code)
    {
        return this.findByProperty(AddressDAO.CODE, code);
    }

    @Override
    public List<Address> findByCountry(final Object country)
    {
        return this.findByProperty(AddressDAO.COUNTRY, country);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Address> findAll()
    {
        this.logger.info("finding all Address instances");

        try
        {
            final String queryString = "select model from Address model";

            return this.getJpaTemplate().find(queryString);
        } catch (final RuntimeException re)
        {
            this.logger.error("find all failed", re);
            ;
            throw re;
        }
    }

    public static IAddressDAO getFromApplicationContext(final ApplicationContext ctx)
    {
        return (IAddressDAO) ctx.getBean("AddressDAO");
    }
}

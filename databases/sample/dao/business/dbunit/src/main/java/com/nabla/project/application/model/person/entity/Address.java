package com.nabla.project.application.model.person.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Address generated by MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ADDRESS", schema = "", uniqueConstraints = {})
public class Address extends AbstractAddress implements java.io.Serializable
{
    // Constructors

    /** default constructor */
    public Address()
    {
    }

    /** minimal constructor */
    public Address(final Long id, final String adr1, final String city, final String code, final String country)
    {
        super(id, adr1, city, code, country);
    }

    /** full constructor */
    public Address(final Long id, final String adr1, final String adr2, final String adr3, final String cedex, final String city, final String code, final String country, /* Set<Person> persons */
            final Person person)
    {
        // super(id, adr1, adr2, adr3, cedex, city, code, country, persons);
        super(id, adr1, adr2, adr3, cedex, city, code, country, person);
    }

    public Address(final String adr1, final String adr2, final String adr3, final String code, final String city, final String cedex, final String country)
    {
        super();
        this.setAdr1(adr1);
        this.setAdr2(adr2);
        this.setAdr3(adr3);
        this.setCode(code);
        this.setCity(city);
        this.setCedex(cedex);
        this.setCountry(country);
    }

    /*
     * public void setPerson(Person person) {
     * Set<Person> persons = new HashSet<Person>();
     * persons.add(person);
     * setPersons(persons);
     * }
     */

    @Override
    public String toString()
    {
        return String.format("A[%d,%s,%s,%s,%s,%s,%s,%s]", this.getId(), this.getAdr1(), this.getAdr2(), this.getAdr3(), this.getCode(), this.getCity(), this.getCedex(), this.getCountry());
    }
}

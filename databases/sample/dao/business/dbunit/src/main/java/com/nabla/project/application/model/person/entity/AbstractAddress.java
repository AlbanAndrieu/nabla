package com.nabla.project.application.model.person.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Version;

/**
 * AbstractAddress generated by MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractAddress implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    // Fields
    private Long              id;
    private Integer           version;
    private String            adr1;
    private String            adr2;
    private String            adr3;
    private String            cedex;
    private String            city;
    private String            code;
    private String            country;

    // private Set<Person> persons = new HashSet<Person>(0);
    private Person            person;

    // Constructors

    /** default constructor */
    public AbstractAddress() {
    }

    /** minimal constructor */
    public AbstractAddress(final Long id, final String adr1, final String city, final String code, final String country) {
        this.id = id;
        this.adr1 = adr1;
        this.city = city;
        this.code = code;
        this.country = country;
    }

    /** full constructor */
    public AbstractAddress(final Long id, final String adr1, final String adr2, final String adr3, final String cedex, final String city, final String code, final String country, /* Set<Person> persons */
            final Person person) {
        this.id = id;
        this.adr1 = adr1;
        this.adr2 = adr2;
        this.adr3 = adr3;
        this.cedex = cedex;
        this.city = city;
        this.code = code;
        this.country = country;
        // this.persons = persons;
        this.person = person;
    }

    // Property accessors
    @Id
    // @Column( name = "ID", unique = true, nullable = false, insertable = true, updatable = true )
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "VERSION", unique = false, nullable = false, insertable = true, updatable = true)
    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(final Integer version) {
        this.version = version;
    }

    @Column(name = "ADR1", unique = false, nullable = false, insertable = true, updatable = true, length = 30)
    public String getAdr1() {
        return this.adr1;
    }

    public void setAdr1(final String adr1) {
        this.adr1 = adr1;
    }

    @Column(name = "ADR2", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
    public String getAdr2() {
        return this.adr2;
    }

    public void setAdr2(final String adr2) {
        this.adr2 = adr2;
    }

    @Column(name = "ADR3", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
    public String getAdr3() {
        return this.adr3;
    }

    public void setAdr3(final String adr3) {
        this.adr3 = adr3;
    }

    @Column(name = "CEDEX", unique = false, nullable = true, insertable = true, updatable = true, length = 3)
    public String getCedex() {
        return this.cedex;
    }

    public void setCedex(final String cedex) {
        this.cedex = cedex;
    }

    @Column(name = "CITY", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
    public String getCity() {
        return this.city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    @Column(name = "CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 5)
    public String getCode() {
        return this.code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    @Column(name = "COUNTRY", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
    public String getCountry() {
        return this.country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    // @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "address")
    /*
     * @OneToOne(mappedBy = "address")
     * public Set<Person> getPersons() {
     * return this.persons;
     * }
     * public void setPersons(Set<Person> persons) {
     * this.persons = persons;
     * }
     */
    @OneToOne(mappedBy = "address")
    public Person getPerson() {
        return this.person;
    }

    public void setPerson(final Person person) {
        this.person = person;
    }
}

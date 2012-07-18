package com.nabla.database.person.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@SuppressWarnings("serial")
@Entity
@Table(name = "Address")
public class Address implements Serializable
{
    // champs
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long   id;
    @Column(nullable = false)
    @Version
    private int    version;
    @Column(length = 30, nullable = false)
    private String adr1;
    @Column(length = 30)
    private String adr2;
    @Column(length = 30)
    private String adr3;
    @Column(length = 5, nullable = false)
    private String code;
    @Column(length = 20, nullable = false)
    private String city;
    @Column(length = 3)
    private String cedex;
    @Column(length = 20, nullable = false)
    private String country;
    @OneToOne(mappedBy = "address")
    private Person person;

    // constructeurs
    public Address()
    {
    }

    public Address(String adr1, String adr2, String adr3, String code, String city, String cedex, String country)
    {
        super();
        this.adr1 = adr1;
        this.adr2 = adr2;
        this.adr3 = adr3;
        this.code = code;
        this.city = city;
        this.cedex = cedex;
        this.country = country;
    }

    // getters et setters
    public String getAdr1()
    {
        return adr1;
    }

    public void setAdr1(String adr1)
    {
        this.adr1 = adr1;
    }

    public String getAdr2()
    {
        return adr2;
    }

    public void setAdr2(String adr2)
    {
        this.adr2 = adr2;
    }

    public String getAdr3()
    {
        return adr3;
    }

    public void setAdr3(String adr3)
    {
        this.adr3 = adr3;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCedex()
    {
        return cedex;
    }

    public void setCedex(String cedex)
    {
        this.cedex = cedex;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public int getVersion()
    {
        return version;
    }

    public void setVersion(int version)
    {
        this.version = version;
    }

    // toString
    public String toString()
    {
        return String.format("A[%d,%s,%s,%s,%s,%s,%s,%s]", getId(), getAdr1(), getAdr2(), getAdr3(), getCode(), getCity(), getCedex(), getCountry());
    }
}

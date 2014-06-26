package com.nabla.database.person.entites;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@SuppressWarnings(
{ "unused", "serial" })
@Entity
@Table(name = "Person")
public class Person implements Serializable
{
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long          id;
    @Column(nullable = false)
    @Version
    private int           version;
    @Column(length = 30, nullable = false, unique = true)
    private String        lastname;
    @Column(length = 30, nullable = false)
    private String        firstname;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date          birthdate;
    @Column(nullable = false)
    private boolean       married;
    @Column(nullable = false)
    private int           nbChildren;

    // relation principale Person (one) -> Address (one)
    // implementee par la cle etrangere Person(adresse_id) -> Address
    // cascade insertion Person -> insertion Address
    // cascade maj Person -> maj Address
    // cascade suppression Person -> suppression Address
    // une Person doit avoir 1 Address (nullable=false)
    // 1 Address n'appartient qu'a 1 personne (unique=true)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", unique = true, nullable = false)
    private Address       address;

    // relation Person (many) -> Activity (many) via une table de jointure PersonneActivite
    // PersonneActivite5(PERSONNE_ID) est cle etangere sur Person(id)
    // PersonneActivite5(ACTIVITE_ID) est cle etangere sur Activity(id)
    // plus de cascade sur les activites
    // @ManyToMany(cascade={CascadeType.PERSIST})
    @ManyToMany()
    @JoinTable(name = "PersonActivity", joinColumns = @JoinColumn(name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "ACTIVITY_ID")

    )
    private Set<Activity> activities = new HashSet<Activity>();

    // constructeurs
    public Person()
    {
    }

    public Person(final String lastname, final String firstname, final Date birtdate, final boolean married, final int nbChildren)
    {
        this.setLastname(lastname);
        this.setFirstname(firstname);
        this.setBirthdate(birtdate);
        this.setMarried(married);
        this.setNbChildren(nbChildren);
    }

    // toString
    @Override
    public String toString()
    {
        return String.format("P[%d,%d,%s,%s,%s,%s,%d,%d]", this.getId(), this.getVersion(), this.getLastname(), this.getFirstname(), new SimpleDateFormat("dd/MM/yyyy").format(this.getBirthdate()), this.isMarried(),
                this.getNbChildren(), this.getAddress().getId());
    }

    // getters and setters
    public Long getId()
    {
        return this.id;
    }

    private void setId(final Long id)
    {
        this.id = id;
    }

    public int getVersion()
    {
        return this.version;
    }

    private void setVersion(final int version)
    {
        this.version = version;
    }

    public String getLastname()
    {
        return this.lastname;
    }

    public void setLastname(final String lastname)
    {
        this.lastname = lastname;
    }

    public String getFirstname()
    {
        return this.firstname;
    }

    public void setFirstname(final String firstname)
    {
        this.firstname = firstname;
    }

    public Date getBirthdate()
    {
        return this.birthdate;
    }

    public void setBirthdate(final Date birthdate)
    {
        this.birthdate = birthdate;
    }

    public boolean isMarried()
    {
        return this.married;
    }

    public void setMarried(final boolean married)
    {
        this.married = married;
    }

    public int getNbChildren()
    {
        return this.nbChildren;
    }

    public void setNbChildren(final int nbChildren)
    {
        this.nbChildren = nbChildren;
    }

    public Address getAddress()
    {
        return this.address;
    }

    public void setAddress(final Address address)
    {
        this.address = address;
    }

    public Set<Activity> getActivities()
    {
        return this.activities;
    }

    public void setActivities(final Set<Activity> activities)
    {
        this.activities = activities;
    }
}

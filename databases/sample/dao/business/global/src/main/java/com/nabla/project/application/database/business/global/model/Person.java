package com.nabla.project.application.database.business.global.model;

import java.io.Serializable;
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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.compass.annotations.SearchableProperty;

@SuppressWarnings(
{ "unused", "serial" })
@Entity
@Table(name = "Person")
public class Person /* extends BaseObject */implements Serializable
{
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long          id;
    @Column(nullable = false)
    @Version
    private int           version;
    @Column(name = "last_name", nullable = false, length = 50)
    @SearchableProperty
    private String        lastName;
    @Column(name = "first_name", nullable = false, length = 50)
    @SearchableProperty
    private String        firstName;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date          birthDate;
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
    @JoinColumn(name = "address_id", unique = true, nullable = false)
    private Address       address;

    // relation Person (many) -> Activity (many) via une table de jointure PersonneActivite
    // PersonneActivite5(PERSONNE_ID) est cle etangere sur Person(id)
    // PersonneActivite5(ACTIVITE_ID) est cle etangere sur Activity(id)
    // plus de cascade sur les activites
    // @ManyToMany(cascade={CascadeType.PERSIST})
    @ManyToMany()
    @JoinTable(name = "PersonActivity", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "ACTIVITY_ID")

    )
    private Set<Activity> activities = new HashSet<Activity>();

    // constructeurs
    public Person()
    {
    }

    public Person(final String lastname, final String firstname, final Date birtdate, final boolean married, final int nbChildren)
    {
        this.setLastName(lastname);
        this.setFirstName(firstname);
        this.setBirthDate(birtdate);
        this.setMarried(married);
        this.setNbChildren(nbChildren);
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

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(final String lastname)
    {
        this.lastName = lastname;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(final String firstname)
    {
        this.firstName = firstname;
    }

    public Date getBirthDate()
    {
        return this.birthDate;
    }

    public void setBirthDate(final Date birthdate)
    {
        this.birthDate = birthdate;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Person))
        {
            return false;
        }

        final Person person = (Person) o;

        return this.hashCode() == person.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        int result;
        result = (this.lastName != null ? this.lastName.hashCode() : 0);
        result = (29 * result) + (this.firstName != null ? this.firstName.hashCode() : 0);
        result = (29 * result) + (this.birthDate != null ? this.birthDate.hashCode() : 0);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", this.id).append("version", this.version).append("lastName", this.lastName).append("firstName", this.firstName)
                .append("birthDate", this.birthDate).append("married", this.married).append("nbChildren", this.nbChildren).append("address", this.address).toString();
    }
    // public String toString() {
    // return String.format("P[%d,%d,%s,%s,%s,%s,%d,%d]", this.getId(), this.getVersion(), this.getLastname(), this.getFirstname(), new SimpleDateFormat("dd/MM/yyyy").format(this.getBirthdate()), this.isMarried(),
    // this.getNbChildren(), this.getAddress().getId());
    // }
}

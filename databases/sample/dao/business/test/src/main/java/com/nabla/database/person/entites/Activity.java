package com.nabla.database.person.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@SuppressWarnings("serial")
@Entity
@Table(name = "Activity")
public class Activity implements Serializable
{
    // champs
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long   id;
    @Column(nullable = false)
    @Version
    private int    version;
    @Column(length = 30, nullable = false, unique = true)
    private String name;

    // plus de relation inverse avec Person
    // @ManyToMany(mappedBy = "activites")
    // private Set<Person> personnes = new HashSet<Person>();

    // constructeurs
    public Activity()
    {
    }

    public Activity(Long id, int version, String name)
    {
        super();
        setId(id);
        setVersion(version);
        setName(name);
    }

    // getters et setters
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

    public String getName()
    {
        return name;
    }

    public void setName(String nom)
    {
        this.name = nom;
    }

    // toString
    public String toString()
    {
        return String.format("Ac[%d,%d,%s]", getId(), getVersion(), getName());
    }
}

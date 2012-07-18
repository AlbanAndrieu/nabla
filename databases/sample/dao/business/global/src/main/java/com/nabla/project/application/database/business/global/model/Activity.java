package com.nabla.project.application.database.business.global.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.appfuse.model.BaseObject;

@SuppressWarnings("serial")
@Entity
@Table(name = "Activity")
public class Activity extends BaseObject implements Serializable
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

    public Activity(final Long id, final int version, final String name)
    {
        super();
        this.setId(id);
        this.setVersion(version);
        this.setName(name);
    }

    // getters et setters
    public Long getId()
    {
        return this.id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public int getVersion()
    {
        return this.version;
    }

    public void setVersion(final int version)
    {
        this.version = version;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(final String nom)
    {
        this.name = nom;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", this.id).append("version", this.version).append("name", this.name).toString();
    }

    // @Override
    // public String toString() {
    // return String.format("Ac[%d,%d,%s]", this.getId(), this.getVersion(), this.getName());
    // }

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
        if (!(o instanceof Activity))
        {
            return false;
        }

        final Activity activity = (Activity) o;

        return !(this.name != null ? !this.name.equals(activity.name) : activity.name != null);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        return (this.name != null ? this.name.hashCode() : 0);
    }
}

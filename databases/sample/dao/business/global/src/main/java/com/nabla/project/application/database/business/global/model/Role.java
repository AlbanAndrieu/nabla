package com.nabla.project.application.database.business.global.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.appfuse.model.BaseObject;
import org.springframework.security.GrantedAuthority;

/**
 * This class is used to represent available roles in the database.
 */
@Entity
@Table(name = "role")
@NamedQueries(
{ @NamedQuery(name = "findRoleByName", query = "select r from Role r where r.name = :name ") })
public class Role extends BaseObject implements Serializable, GrantedAuthority
{
    private static final long serialVersionUID = 3690197650654049848L;
    private Long              id;
    private String            name;
    private String            description;

    /**
     * Default constructor - creates a new instance with no values set.
     */
    public Role()
    {
    }

    /**
     * Create a new instance and set the name.
     * 
     * @param name name of the role.
     */
    public Role(final String name)
    {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId()
    {
        return this.id;
    }

    /**
     * @return the name property (getAuthority required by Acegi's GrantedAuthority interface)
     * @see org.springframework.security.GrantedAuthority#getAuthority()
     */
    @Override
    @Transient
    public String getAuthority()
    {
        return this.getName();
    }

    @Column(length = 20)
    public String getName()
    {
        return this.name;
    }

    @Column(length = 64)
    public String getDescription()
    {
        return this.description;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public void setDescription(final String description)
    {
        this.description = description;
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
        if (!(o instanceof Role))
        {
            return false;
        }

        final Role role = (Role) o;

        return !(this.name != null ? !this.name.equals(role.name) : role.name != null);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        return (this.name != null ? this.name.hashCode() : 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(this.name).toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(final Object o)
    {
        return (this.equals(o) ? 0 : -1);
    }
}

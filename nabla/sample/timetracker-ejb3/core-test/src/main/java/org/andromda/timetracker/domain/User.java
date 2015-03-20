package org.andromda.timetracker.domain;

import static org.jboss.seam.ScopeType.SESSION;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Pattern;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Entity
@Name("user")
@Scope(SESSION)
@Table(name = "USERS")
public class User implements Serializable
{
    private Long   id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public User(final String username, final String password, final String firstName, final String lastName)
    {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User()
    {
    }

    @NotNull
    @Length(max = 100)
    @Column(name = "FIRST_NAME", nullable = false, insertable = true, updatable = true)
    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(final String value)
    {
        this.firstName = value;
    }

    @NotNull
    @Length(max = 100)
    @Column(name = "LAST_NAME", nullable = false, insertable = true, updatable = true)
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * Set the lastName property.
     * 
     * @param value the new value
     */
    public void setLastName(final String value)
    {
        this.lastName = value;
    }

    @Column(name = "PASSWORD", nullable = false, insertable = true, updatable = true)
    @NotNull
    @Length(min = 5, max = 50)
    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(final String password)
    {
        this.password = password;
    }

    /**
     * Get the id property.
     * 
     * @return Long The value of id
     */
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", columnDefinition = "long"/* , unique = true, nullable = false, insertable = true, updatable = true */)
    public Long getId()
    {
        return this.id;
    }

    /**
     * Set the id property.
     * 
     * @param value the new value
     */
    public void setId(final Long value)
    {
        this.id = value;
    }

    // @Id
    @Column(name = "USERNAME", unique = true, nullable = false, insertable = true, updatable = true, length = 50)
    @Length(min = 4, max = 15)
    @Pattern(regex = "^\\w*$", message = "not a valid username")
    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(final String username)
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return "User(" + this.username + ")";
    }
}

package com.nabla.project.application.database.business.global.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.appfuse.model.BaseObject;
import org.appfuse.model.LabelValue;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;

/**
 * This class represents the basic "user" object in AppFuse that allows for authentication
 * and user management. It implements Acegi Security's UserDetails interface.
 */
@Entity
@Table(name = "app_user")
@Searchable
public class User extends BaseObject implements Serializable, UserDetails
{
    private static final long serialVersionUID = 3832626162173359411L;

    private Long              id;
    private String            username;                               // required
    private String            password;                               // required
    private String            confirmPassword;
    private String            passwordHint;
    private String            firstName;                              // required
    private String            lastName;                               // required
    private String            email;                                  // required; unique
    private String            phoneNumber;
    private String            website;
    private Address           address          = new Address();
    private Integer           version;
    private Set<Role>         roles            = new HashSet<Role>();
    private boolean           enabled;
    private boolean           accountExpired;
    private boolean           accountLocked;
    private boolean           credentialsExpired;

    /**
     * Default constructor - creates a new instance with no values set.
     */
    public User()
    {
    }

    /**
     * Create a new instance and set the username.
     * 
     * @param username login name for user.
     */
    public User(final String username)
    {
        this.username = username;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SearchableId
    public Long getId()
    {
        return this.id;
    }

    @Override
    @Column(nullable = false, length = 50, unique = true)
    @SearchableProperty
    public String getUsername()
    {
        return this.username;
    }

    @Override
    @Column(nullable = false)
    public String getPassword()
    {
        return this.password;
    }

    @Transient
    public String getConfirmPassword()
    {
        return this.confirmPassword;
    }

    @Column(name = "password_hint")
    public String getPasswordHint()
    {
        return this.passwordHint;
    }

    @Column(name = "first_name", nullable = false, length = 50)
    @SearchableProperty
    public String getFirstName()
    {
        return this.firstName;
    }

    @Column(name = "last_name", nullable = false, length = 50)
    @SearchableProperty
    public String getLastName()
    {
        return this.lastName;
    }

    @Column(nullable = false, unique = true)
    @SearchableProperty
    public String getEmail()
    {
        return this.email;
    }

    @Column(name = "phone_number")
    @SearchableProperty
    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    @SearchableProperty
    public String getWebsite()
    {
        return this.website;
    }

    /**
     * Returns the full name.
     * 
     * @return firstName + ' ' + lastName
     */
    @Transient
    public String getFullName()
    {
        return this.firstName + ' ' + this.lastName;
    }

    // @Embedded
    // @SearchableComponent
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", unique = true, nullable = false)
    public Address getAddress()
    {
        return this.address;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns =
    { @JoinColumn(name = "user_id") }, inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles()
    {
        return this.roles;
    }

    /**
     * Convert user roles to LabelValue objects for convenience.
     * 
     * @return a list of LabelValue objects with role information
     */
    @Transient
    public List<LabelValue> getRoleList()
    {
        final List<LabelValue> userRoles = new ArrayList<LabelValue>();

        if (this.roles != null)
        {
            for (final Role role : this.roles)
            {
                // convert the user's roles to LabelValue Objects
                userRoles.add(new LabelValue(role.getName(), role.getName()));
            }
        }

        return userRoles;
    }

    /**
     * Adds a role for the user
     * 
     * @param role the fully instantiated role
     */
    public void addRole(final Role role)
    {
        this.getRoles().add(role);
    }

    /**
     * @return GrantedAuthority[] an array of roles.
     * @see org.springframework.security.userdetails.UserDetails#getAuthorities()
     */
    @Override
    @Transient
    public GrantedAuthority[] getAuthorities()
    {
        return this.roles.toArray(new GrantedAuthority[0]);
    }

    @Version
    public Integer getVersion()
    {
        return this.version;
    }

    @Override
    @Column(name = "account_enabled")
    public boolean isEnabled()
    {
        return this.enabled;
    }

    @Column(name = "account_expired", nullable = false)
    public boolean isAccountExpired()
    {
        return this.accountExpired;
    }

    /**
     * @see org.springframework.security.userdetails.UserDetails#isAccountNonExpired()
     */
    @Override
    @Transient
    public boolean isAccountNonExpired()
    {
        return !this.isAccountExpired();
    }

    @Column(name = "account_locked", nullable = false)
    public boolean isAccountLocked()
    {
        return this.accountLocked;
    }

    /**
     * @see org.springframework.security.userdetails.UserDetails#isAccountNonLocked()
     */
    @Override
    @Transient
    public boolean isAccountNonLocked()
    {
        return !this.isAccountLocked();
    }

    @Column(name = "credentials_expired", nullable = false)
    public boolean isCredentialsExpired()
    {
        return this.credentialsExpired;
    }

    /**
     * @see org.springframework.security.userdetails.UserDetails#isCredentialsNonExpired()
     */
    @Override
    @Transient
    public boolean isCredentialsNonExpired()
    {
        return !this.credentialsExpired;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public void setUsername(final String username)
    {
        this.username = username;
    }

    public void setPassword(final String password)
    {
        this.password = password;
    }

    public void setConfirmPassword(final String confirmPassword)
    {
        this.confirmPassword = confirmPassword;
    }

    public void setPasswordHint(final String passwordHint)
    {
        this.passwordHint = passwordHint;
    }

    public void setFirstName(final String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(final String lastName)
    {
        this.lastName = lastName;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    public void setPhoneNumber(final String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setWebsite(final String website)
    {
        this.website = website;
    }

    public void setAddress(final Address address)
    {
        this.address = address;
    }

    public void setRoles(final Set<Role> roles)
    {
        this.roles = roles;
    }

    public void setVersion(final Integer version)
    {
        this.version = version;
    }

    public void setEnabled(final boolean enabled)
    {
        this.enabled = enabled;
    }

    public void setAccountExpired(final boolean accountExpired)
    {
        this.accountExpired = accountExpired;
    }

    public void setAccountLocked(final boolean accountLocked)
    {
        this.accountLocked = accountLocked;
    }

    public void setCredentialsExpired(final boolean credentialsExpired)
    {
        this.credentialsExpired = credentialsExpired;
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
        if (!(o instanceof User))
        {
            return false;
        }

        final User user = (User) o;

        return !(this.username != null ? !this.username.equals(user.getUsername()) : user.getUsername() != null);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        return (this.username != null ? this.username.hashCode() : 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        final ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).append("username", this.username).append("enabled", this.enabled).append("accountExpired", this.accountExpired)
                .append("credentialsExpired", this.credentialsExpired).append("accountLocked", this.accountLocked);

        final GrantedAuthority[] auths = this.getAuthorities();
        if (auths != null)
        {
            sb.append("Granted Authorities: ");

            for (int i = 0; i < auths.length; i++)
            {
                if (i > 0)
                {
                    sb.append(", ");
                }
                sb.append(auths[i].toString());
            }
        } else
        {
            sb.append("No Granted Authorities");
        }
        return sb.toString();
    }
}

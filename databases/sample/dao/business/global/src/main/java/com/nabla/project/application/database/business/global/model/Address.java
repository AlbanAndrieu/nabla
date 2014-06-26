package com.nabla.project.application.database.business.global.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.compass.annotations.SearchableProperty;

//@SuppressWarnings("serial")
@Entity
@Table(name = "Address")
// @Embeddable
// @Searchable(root = false)
public class Address /* extends BaseObject */implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long              id;
    @Column(nullable = false)
    @Version
    private int               version;
    @Column(length = 150, nullable = false)
    @SearchableProperty
    private String            address;
    @Column(name = "address_info", length = 30)
    private String            addressInfo;
    @Column(length = 5, nullable = false)
    private String            code;
    @Column(length = 20, nullable = false)
    @SearchableProperty
    private String            city;
    @Column(length = 100)
    @SearchableProperty
    private String            province;
    @Column(name = "postal_code", length = 15)
    @SearchableProperty
    private String            postalCode;
    @Column(length = 3)
    @SearchableProperty
    private String            cedex;
    @Column(length = 20, nullable = false)
    @SearchableProperty
    private String            country;
    @OneToOne(mappedBy = "address")
    private Person            person;

    public Address()
    {
    }

    public Address(final String address, final String addressInfo, final String adr3, final String code, final String city, final String province, final String postalCode, final String cedex, final String country)
    {
        super();
        this.address = address;
        this.addressInfo = addressInfo;
        this.code = code;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.cedex = cedex;
        this.country = country;
    }

    // getters et setters
    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(final String address)
    {
        this.address = address;
    }

    public String getAdressInfo()
    {
        return this.addressInfo;
    }

    public void setAdressInfo(final String addressInfo)
    {
        this.addressInfo = addressInfo;
    }

    public String getCode()
    {
        return this.code;
    }

    public void setCode(final String code)
    {
        this.code = code;
    }

    public String getCity()
    {
        return this.city;
    }

    public void setCity(final String city)
    {
        this.city = city;
    }

    public String getCedex()
    {
        return this.cedex;
    }

    public void setCedex(final String cedex)
    {
        this.cedex = cedex;
    }

    public String getCountry()
    {
        return this.country;
    }

    public void setCountry(final String country)
    {
        this.country = country;
    }

    /**
     * DOCUMENT ME! Alban.
     * 
     * @return the province
     */
    public String getProvince()
    {
        return this.province;
    }

    /**
     * DOCUMENT ME! Alban.
     * 
     * @param province the province to set
     */
    public void setProvince(final String province)
    {
        this.province = province;
    }

    /**
     * DOCUMENT ME! Alban.
     * 
     * @return the postalCode
     */
    public String getPostalCode()
    {
        return this.postalCode;
    }

    /**
     * DOCUMENT ME! Alban.
     * 
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(final String postalCode)
    {
        this.postalCode = postalCode;
    }

    public Person getPerson()
    {
        return this.person;
    }

    public void setPerson(final Person person)
    {
        this.person = person;
    }

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

    /**
     * Overridden equals method for object comparison. Compares based on hashCode.
     * 
     * @param o Object to compare
     * @return true/false based on hashCode
     */
    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Address))
        {
            return false;
        }

        final Address address1 = (Address) o;

        return this.hashCode() == address1.hashCode();
    }

    /**
     * Overridden hashCode method - compares on address, city, province, country and postal code.
     * 
     * @return hashCode
     */
    @Override
    public int hashCode()
    {
        int result;
        result = (this.address != null ? this.address.hashCode() : 0);
        result = (29 * result) + (this.city != null ? this.city.hashCode() : 0);
        result = (29 * result) + (this.province != null ? this.province.hashCode() : 0);
        result = (29 * result) + (this.country != null ? this.country.hashCode() : 0);
        result = (29 * result) + (this.postalCode != null ? this.postalCode.hashCode() : 0);
        return result;
    }

    /**
     * Returns a multi-line String with key=value pairs.
     * 
     * @return a String representation of this class.
     */
    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("address", this.address).append("addressInfo", this.addressInfo).append("code", this.code).append("city", this.city)
                .append("province", this.province).append("postalCode", this.postalCode).append("cedex", this.cedex).append("country", this.country).toString();
    }

    // public String toString() {
    // return String.format("A[%d,%s,%s,%s,%s,%s,%s,%s]", this.getId(), this.getAddress(), this.getAdressInfo(), this.getCode(), this.getCity(), this.getCedex(), this.getCountry());
    // }

}

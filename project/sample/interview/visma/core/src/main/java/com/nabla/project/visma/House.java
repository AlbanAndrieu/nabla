package com.nabla.project.visma;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.nabla.project.visma.api.IProduct;

/**
 * @author albandri
 *
 */
public class House implements IProduct, Comparable<House>, Serializable {

    private static final long serialVersionUID = 1L;

    public static final String DEFAULT_NAME = "House";
    
    private String name = DEFAULT_NAME;
    private BigDecimal price = BigDecimal.TEN;

    public House() {
        throw new AssertionError();
    }

    public House(BigDecimal aPrice) {

        this.price = aPrice;
        this.validateState();

    }

    public House(int aPrice) {
        this(new BigDecimal(aPrice));
    }

    /**
     * Validate immutable data like BigDecimal.
     * It raise the exception IllegalArgumentException when arguments are wrong
     */
    private void validateState()
    {
        if (null == this.price)
        {
            throw new IllegalArgumentException("Price cannot be null");
        }
        if (this.price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Price must not be negatif or zero");
        }
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public String toString() {

        final StringBuffer str = new StringBuffer();

        str.append("name:").append(this.getName()).append(' ');
        str.append("price:").append(this.getPrice());

        return str.toString();

    }

    public int hashCode() {
        return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
                // if deriving: appendSuper(super.hashCode()).
                append(getName()).
                append(getPrice()).
                toHashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof House))
            return false;

        House rhs = (House) obj;
        return new EqualsBuilder().
                // if deriving: appendSuper(super.equals(obj)).
                append(name, rhs.name).
                append(price, rhs.price).
                isEquals();
    }

    @Override
    public int compareTo(House aHouse)
    {
        if (this == aHouse)
        {
            return 0;
        }

        // the object fields are never null
        int comparison = this.price.compareTo(aHouse.price);
        if (comparison != 0)
        {
            return comparison;
        }

        return 0;
    }

}

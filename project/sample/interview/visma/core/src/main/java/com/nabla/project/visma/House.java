package com.nabla.project.visma;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.nabla.project.visma.api.IProduct;

@Immutable
public class House implements IProduct, Comparable<House>, Serializable
{

    private static final long  serialVersionUID = 1L;

    public static final String DEFAULT_NAME     = "House";

    private final String       name             = House.DEFAULT_NAME;
    private final BigDecimal   price;

    public House()
    {
        throw new AssertionError();
    }

    public House(@Nonnull @Nonnegative final BigDecimal aPrice)
    {

        this.price = aPrice;
        this.validateState();

    }

    public House(@Nonnegative final int aPrice)
    {
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
        if (this.price.compareTo(BigDecimal.ZERO) <= 0)
        {
            throw new IllegalArgumentException("Amount must not be negatif or zero");
        }
    }

    @Override
    public BigDecimal getPrice()
    {
        return this.price;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public String toString()
    {

        final StringBuffer str = new StringBuffer();

        str.append("name:").append(this.getName()).append(' ');
        str.append("price:").append(this.getPrice());

        return str.toString();

    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
                // if deriving: appendSuper(super.hashCode()).
                append(this.getName()).append(this.getPrice()).toHashCode();
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof House))
        {
            return false;
        }

        final House rhs = (House) obj;
        return new EqualsBuilder().
        // if deriving: appendSuper(super.equals(obj)).
                append(this.name, rhs.name).append(this.price, rhs.price).isEquals();
    }

    @Override
    public int compareTo(final House aHouse)
    {
        if (this == aHouse)
        {
            return 0;
        }

        // the object fields are never null
        final int comparison = this.price.compareTo(aHouse.price);
        if (comparison != 0)
        {
            return comparison;
        }

        return 0;
    }

}

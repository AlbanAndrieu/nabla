/*
 * Copyright (c) 2002-2004, Nabla
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Nabla' nor 'Alban' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
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

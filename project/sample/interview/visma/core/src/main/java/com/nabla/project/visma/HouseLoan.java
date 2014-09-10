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

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;

import com.nabla.project.visma.api.ILoan;
import com.nabla.project.visma.api.IPaymentMethod;
import com.nabla.project.visma.api.IProduct;

@XmlRootElement
public class HouseLoan implements ILoan
{

    private static final transient Logger LOGGER           = Logger.getLogger(HouseLoan.class);

    public static final double            DEFAULT_INTEREST = 5.5;

    // Fixed interest of 5.5% per year
    private double                        interest         = HouseLoan.DEFAULT_INTEREST;       // NOSONAR

    private transient IProduct            product;

    private int                           paybackTime;

    private final IPaymentMethod          paymentMethod    = new BasicPaymentMethod();

    public HouseLoan()
    {
        throw new AssertionError();
    }

    public HouseLoan(final IProduct aProduct, final int aPaybackTime)
    {
        this.product = aProduct;
        this.paybackTime = aPaybackTime;

        if (null == this.product)
        {
            throw new IllegalArgumentException("Product cannot be null");
        }

        if (this.paybackTime <= 0)
        {
            throw new IllegalArgumentException("Payback time cannot be zero or negatif");
        }
    }

    public HouseLoan(final IProduct aProduct, final int aPaybackTime, final double aInterest)
    {
        this(aProduct, aPaybackTime);
        this.interest = aInterest;

        if (this.interest <= 0)
        {
            throw new IllegalArgumentException("Interest time cannot be zero or negatif");
        }
    }

    @Override
    public double getInterest()
    {

        return this.interest;
    }

    @Override
    public IProduct getProduct()
    {
        return this.product;
    }

    @Override
    public int getPaybackTime()
    {
        return this.paybackTime;
    }

    @Override
    public String toString()
    {

        final StringBuilder str = new StringBuilder();

        str.append("product:{").append(this.getProduct()).append("} ");
        str.append("paybacktime:").append(this.getPaybackTime()).append(' ');
        str.append("interest:").append(this.getInterest());

        return str.toString();

    }

    @XmlElementDecl(namespace = "http://nabla.mobi", name = "houseloan")
    public JAXBElement<HouseLoan> toXml()
    {
        return new JAXBElement<HouseLoan>(new QName("houseloan"), HouseLoan.class, this);
    }

    /*
     * TODO add Jackson
     * public String toJson()
     * {
     * return new ObjectMapper().writeValueAsString(this);
     * }
     */

    @Override
    public Map<Integer, List<BigDecimal>> calcMonthlyPayment()
    {

        if (HouseLoan.LOGGER.isDebugEnabled())
        {
            HouseLoan.LOGGER.debug("Start calculateMonthlyPayment for : " + this.toString());
        }
        // TODO check Design pattern strategy
        this.paymentMethod.setLoan(this);
        return this.paymentMethod.calculate();
    }

    @Override
    public BigDecimal getTotalPayment()
    {
        this.paymentMethod.setLoan(this);
        return this.paymentMethod.getTotalPayment();
    }

}

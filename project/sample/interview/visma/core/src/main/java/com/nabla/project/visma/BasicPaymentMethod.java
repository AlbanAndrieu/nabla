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
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nabla.project.visma.api.ILoan;
import com.nabla.project.visma.api.IPaymentMethod;

/**
 * DOCUMENT ME!
 * 
 * @author $Author$
 * @version $Revision$
 * @since $Date$
 */
// TODO WARNING non Immutable
public class BasicPaymentMethod implements IPaymentMethod
{

    private ILoan loan;

    public BasicPaymentMethod()
    {
        // TODO throw new AssertionError();
    }

    /**
     * Creates a new BasicPaymentMethod object.
     * 
     * @param aLoan DOCUMENT ME!
     */
    public BasicPaymentMethod(final ILoan aLoan)
    {

        this.loan = aLoan;

        if (null == this.loan)
        {

            throw new IllegalArgumentException("Loan cannot be null");

        }

    }

    @Override
    public ILoan getLoan()
    {
        return this.loan;
    }

    @Override
    public void setLoan(final ILoan aloan)
    {
        this.loan = aloan;
        if (null == this.loan)
        {

            throw new IllegalArgumentException("Loan cannot be null");

        }
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    @Override
    public Map<Integer, List<BigDecimal>> calculate()
    {

        final BigDecimal payment = this.getMonthlyPayment();
        final Map<Integer, List<BigDecimal>> monthlySchedule = new HashMap<Integer, List<BigDecimal>>(); // TODO use : ConcurrentHashMap

        final int numberOfMonths = BasicPaymentMethod.calcNumberOfMonths(this.loan.getPaybackTime());

        for (int month = 0; month < numberOfMonths; month++)
        {

            final List<BigDecimal> data = new ArrayList<BigDecimal>();

            data.add(payment);
            monthlySchedule.put(month, data);

        }

        return monthlySchedule;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param annualInterestRate DOCUMENT ME!
     * @return DOCUMENT ME!
     */
    public static BigDecimal calcMonthlyInterestRate(final double annualInterestRate)
    {

        return new BigDecimal(annualInterestRate).divide(new BigDecimal(1200), MathContext.DECIMAL128);

    }

    /**
     * DOCUMENT ME!
     * 
     * @param paybackTimeInYear DOCUMENT ME!
     * @return DOCUMENT ME!
     */
    public static int calcNumberOfMonths(final int paybackTimeInYear)
    {

        return paybackTimeInYear * 12;

    }

    /**
     * @deprecated (double is not as accurate as BigDecimal)
     * @return DOCUMENT ME!
     */
    @Deprecated
    public double getMonthlyPaymentWithDouble()
    {

        final BigDecimal monthlyInterestRate = BasicPaymentMethod.calcMonthlyInterestRate(this.loan.getInterest());
        final BigDecimal loanAmount = this.loan.getProduct().getPrice();
        final int numberOfMonths = BasicPaymentMethod.calcNumberOfMonths(this.loan.getPaybackTime());

        return BasicPaymentMethod.calcMonthlyPayment(monthlyInterestRate.doubleValue(), loanAmount.doubleValue(), numberOfMonths);

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public BigDecimal getMonthlyPayment()
    {

        final BigDecimal monthlyInterestRate = BasicPaymentMethod.calcMonthlyInterestRate(this.loan.getInterest());
        final BigDecimal loanAmount = this.loan.getProduct().getPrice();
        final int numberOfMonths = BasicPaymentMethod.calcNumberOfMonths(this.loan.getPaybackTime());

        return BasicPaymentMethod.calcMonthlyPayment(monthlyInterestRate, loanAmount, numberOfMonths);

    }

    /**
     * @deprecated (double is not as accurate as BigDecimal)
     * @return DOCUMENT ME!
     */
    @Deprecated
    public double getTotalPaymentWithDouble()
    {

        return this.getMonthlyPaymentWithDouble() * BasicPaymentMethod.calcNumberOfMonths(this.loan.getPaybackTime());

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    @Override
    public BigDecimal getTotalPayment()
    {

        return this.getMonthlyPayment().multiply(new BigDecimal(BasicPaymentMethod.calcNumberOfMonths(this.loan.getPaybackTime())));

    }

    /**
     * @deprecated (double is not as accurate as BigDecimal)
     * @param monthlyInterestRate DOCUMENT ME!
     * @param loanAmount DOCUMENT ME!
     * @param numberOfMonths DOCUMENT ME!
     * @return DOCUMENT ME!
     */
    @Deprecated
    public static double calcMonthlyPayment(final double monthlyInterestRate, final double loanAmount, final int numberOfMonths)
    {

        return (loanAmount * monthlyInterestRate) / (1 - (Math.pow(1 / (1 + monthlyInterestRate), numberOfMonths)));

    }

    /**
     * DOCUMENT ME!
     * 
     * @param monthlyInterestRate DOCUMENT ME!
     * @param loanAmount DOCUMENT ME!
     * @param numberOfMonths DOCUMENT ME!
     * @return DOCUMENT ME!
     */
    public static BigDecimal calcMonthlyPayment(final BigDecimal monthlyInterestRate, final BigDecimal loanAmount, final int numberOfMonths)
    {

        return loanAmount.multiply(monthlyInterestRate).divide(BigDecimal.ONE.subtract((BigDecimal.ONE.divide((monthlyInterestRate.add(BigDecimal.ONE)), MathContext.DECIMAL128).pow(numberOfMonths))),
                MathContext.DECIMAL128);

    }

}

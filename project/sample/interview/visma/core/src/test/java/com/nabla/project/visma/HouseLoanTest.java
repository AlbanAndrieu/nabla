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

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.nabla.project.visma.api.ILoan;
import com.nabla.project.visma.api.IProduct;

/**
 * DOCUMENT ME!
 * 
 * @author $Author$
 * @version $Revision$
 * @since $Date$
 */
public class HouseLoanTest
{

    public static final double DOUBLE_DELTA         = 1e-15;
    public static final int    DEFAULT_PAYBACK_TIME = 30;

    private IProduct           product;

    @Before
    public void setUp() throws Exception
    {
        this.product = new House(HouseTest.DEFAULT_EXPECTED_PRICE);
    }

    @After
    public void tearDown() throws Exception
    {
        this.product = null;
    }

    @Test(expected = AssertionError.class)
    public final void testEmptyContructor()
    {

        final ILoan loan = new HouseLoan();
        Assert.assertNotNull(loan);

    }

    @Test
    public final void testProductNotNull()
    {

        final ILoan loan = new HouseLoan(this.product, HouseLoanTest.DEFAULT_PAYBACK_TIME);
        Assert.assertNotNull(loan.getProduct());

    }

    @Test(expected = IllegalArgumentException.class)
    public final void testProductNull()
    {

        final ILoan loan = new HouseLoan(null, HouseLoanTest.DEFAULT_PAYBACK_TIME);
        Assert.assertNotNull(loan.getProduct());

    }

    @Test
    public void testGetProduct()
    {
        Assert.assertNotNull(this.product);
        Assert.assertEquals(this.product, new House(HouseTest.DEFAULT_EXPECTED_PRICE));

        final ILoan loan = new HouseLoan(this.product, HouseLoanTest.DEFAULT_PAYBACK_TIME);
        Assert.assertNotNull(loan.getProduct());
        Assert.assertEquals(this.product, loan.getProduct());
        Assert.assertEquals(HouseTest.DEFAULT_EXPECTED_PRICE, loan.getProduct().getPrice());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroPaybackTime()
    {
        Assert.assertNotNull(this.product);
        Assert.assertEquals(this.product, new House(HouseTest.DEFAULT_EXPECTED_PRICE));

        final ILoan loan = new HouseLoan(this.product, 0);
        Assert.assertNotNull(loan.getPaybackTime());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegatifPaybackTime()
    {
        Assert.assertNotNull(this.product);
        Assert.assertEquals(this.product, new House(HouseTest.DEFAULT_EXPECTED_PRICE));

        final ILoan loan = new HouseLoan(this.product, -50);
        Assert.assertNotNull(loan.getPaybackTime());
    }

    @Test
    public void testPaybackTime()
    {
        Assert.assertNotNull(this.product);
        Assert.assertEquals(this.product, new House(HouseTest.DEFAULT_EXPECTED_PRICE));

        final ILoan loan = new HouseLoan(this.product, HouseLoanTest.DEFAULT_PAYBACK_TIME);
        Assert.assertNotNull(loan.getPaybackTime());
        Assert.assertEquals(loan.getPaybackTime(), HouseLoanTest.DEFAULT_PAYBACK_TIME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroInterest()
    {
        Assert.assertNotNull(this.product);
        Assert.assertEquals(this.product, new House(HouseTest.DEFAULT_EXPECTED_PRICE));

        final ILoan loan = new HouseLoan(this.product, HouseLoanTest.DEFAULT_PAYBACK_TIME, 0);
        Assert.assertNotNull(loan.getInterest());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegatifInterest()
    {
        Assert.assertNotNull(this.product);
        Assert.assertEquals(this.product, new House(HouseTest.DEFAULT_EXPECTED_PRICE));

        final ILoan loan = new HouseLoan(this.product, HouseLoanTest.DEFAULT_PAYBACK_TIME, -50);
        Assert.assertNotNull(loan.getInterest());
    }

    @Test
    public void testInterest()
    {
        Assert.assertNotNull(this.product);
        Assert.assertEquals(this.product, new House(HouseTest.DEFAULT_EXPECTED_PRICE));

        final ILoan loan = new HouseLoan(this.product, HouseLoanTest.DEFAULT_PAYBACK_TIME, 6.5);
        Assert.assertNotNull(loan.getInterest());
        Assert.assertEquals(loan.getInterest(), 6.5, HouseLoanTest.DOUBLE_DELTA);
    }

    @Test
    public void testDefaultInterest()
    {
        Assert.assertEquals(HouseLoan.DEFAULT_INTEREST, new HouseLoan(this.product, HouseLoanTest.DEFAULT_PAYBACK_TIME).getInterest(), HouseLoanTest.DOUBLE_DELTA);
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals(new HouseLoan(this.product, HouseLoanTest.DEFAULT_PAYBACK_TIME).toString(), "product:{name:" + House.DEFAULT_NAME + " price:" + HouseTest.DEFAULT_EXPECTED_PRICE + "} paybacktime:"
                + HouseLoanTest.DEFAULT_PAYBACK_TIME + " interest:" + HouseLoan.DEFAULT_INTEREST);
    }

    @Test
    public void testCalculateMonthlyPayment()
    {
        // See BasicPaymentMethodTest for more tests
        Assert.assertNotNull(this.product);
        Assert.assertEquals(this.product, new House(HouseTest.DEFAULT_EXPECTED_PRICE));

        final ILoan loan = new HouseLoan(this.product, 1);
        Assert.assertNotNull(loan.calcMonthlyPayment());
    }

    @Test
    public void testGetTotalPayment()
    {
        // See BasicPaymentMethodTest for more tests
        Assert.assertNotNull(this.product);
        Assert.assertEquals(this.product, new House(HouseTest.DEFAULT_EXPECTED_PRICE));

        final ILoan loan = new HouseLoan(this.product, 1);
        Assert.assertNotNull(loan.getTotalPayment());
    }

}

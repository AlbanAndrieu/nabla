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

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PaymentScheduleTest
{

    final Payment[]       payments        = new Payment[]
                                          { new Payment(new BigDecimal(100)), new Payment(new BigDecimal(1_000)), new Payment(new BigDecimal(10_000)) };

    final PaymentSchedule paymentSchedule = new PaymentSchedule(this.payments);

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testConstructorNull()
    {

        final Map<Integer, List<BigDecimal>> nullPaymentSchedule = null;
        final PaymentSchedule paymentSchedule = new PaymentSchedule(nullPaymentSchedule);
        Assert.assertNotNull(paymentSchedule.getPayments());

    }

    @Test
    public void testSetPaymentsPaymentArray()
    {
        final PaymentSchedule paymentSchedule = new PaymentSchedule(this.payments);
        Assert.assertNotNull(paymentSchedule.getPayments());
        Assert.assertEquals(3, paymentSchedule.getPayments().getRowCount());
        Assert.assertEquals("loanAmount:100", paymentSchedule.getPayments().getRowData().toString());
    }

    // @Test
    public void testSetPaymentsMapOfIntegerListOfBigDecimal()
    {
        Assert.fail("Not yet implemented");
    }

    // @Test
    public void testGetPayments()
    {
        Assert.fail("Not yet implemented");
    }

    // @Test
    public final void testToString()
    {

        Assert.fail("Not yet implemented");
        // Assert.assertEquals("paymentsDataModel:", this.paymentSchedule.toString());
        // Assert.assertFalse(this.paymentSchedule.equals("paymentsDataModel:"));

    }
}

package com.nabla.project.visma;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PaymentTest {

    final Payment payment = new Payment(new BigDecimal(100));

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testConstructor() {
        final Payment payment = new Payment(new BigDecimal(100));
        Assert.assertNotNull(payment);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNull() {
        final Payment payment = new Payment(null);
        Assert.assertNotNull(payment);
    }

    public final void testGetLoanAmount() {

        Assert.assertNotNull(this.payment.getLoanAmount());
        Assert.assertEquals(new BigDecimal(100), this.payment.getLoanAmount());

    }

    @Test
    public final void testToString() {

        Assert.assertEquals("loanAmount:100", this.payment.toString());
        Assert.assertFalse(this.payment.equals("loanAmount:100"));

    }

}

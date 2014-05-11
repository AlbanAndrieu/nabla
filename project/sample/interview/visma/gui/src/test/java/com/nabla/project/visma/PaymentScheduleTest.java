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

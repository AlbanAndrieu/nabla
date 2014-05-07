package com.nabla.project.visma;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.nabla.project.visma.api.ILoan;
import com.nabla.project.visma.api.IProduct;

public class HouseLoanTest
{

    public static final double DOUBLE_DELTA         = 1e-15;
    public static final int    DEFAULT_PAYBACK_TIME = 30;

    private IProduct           product;

    @Before
    public void setUp() throws Exception
    {
        product = new House(HouseTest.DEFAULT_EXPECTED_PRICE);
    }

    @After
    public void tearDown() throws Exception
    {
        product = null;
    }

    @Test(expected = AssertionError.class)
    public final void testEmptyContructor()
    {

        ILoan loan = new HouseLoan();
        Assert.assertNotNull(loan);

    }

    @Test
    public final void testProductNotNull()
    {

        ILoan loan = new HouseLoan(product, HouseLoanTest.DEFAULT_PAYBACK_TIME);
        Assert.assertNotNull(loan.getProduct());

    }

    @Test(expected = IllegalArgumentException.class)
    public final void testProductNull()
    {

        ILoan loan = new HouseLoan(null, HouseLoanTest.DEFAULT_PAYBACK_TIME);
        Assert.assertNotNull(loan.getProduct());

    }

    @Test
    public void testGetProduct()
    {
        Assert.assertNotNull(product);
        Assert.assertEquals(product, new House(HouseTest.DEFAULT_EXPECTED_PRICE));

        ILoan loan = new HouseLoan(product, HouseLoanTest.DEFAULT_PAYBACK_TIME);
        Assert.assertNotNull(loan.getProduct());
        Assert.assertEquals(product, loan.getProduct());
        Assert.assertEquals(HouseTest.DEFAULT_EXPECTED_PRICE, loan.getProduct().getPrice());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroPaybackTime()
    {
        Assert.assertNotNull(product);
        Assert.assertEquals(product, new House(HouseTest.DEFAULT_EXPECTED_PRICE));

        ILoan loan = new HouseLoan(product, 0);
        Assert.assertNotNull(loan.getPaybackTime());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegatifPaybackTime()
    {
        Assert.assertNotNull(product);
        Assert.assertEquals(product, new House(HouseTest.DEFAULT_EXPECTED_PRICE));

        ILoan loan = new HouseLoan(product, -50);
        Assert.assertNotNull(loan.getPaybackTime());
    }

    @Test
    public void testPaybackTime()
    {
        Assert.assertNotNull(product);
        Assert.assertEquals(product, new House(HouseTest.DEFAULT_EXPECTED_PRICE));

        ILoan loan = new HouseLoan(product, HouseLoanTest.DEFAULT_PAYBACK_TIME);
        Assert.assertNotNull(loan.getPaybackTime());
        Assert.assertEquals(loan.getPaybackTime(), HouseLoanTest.DEFAULT_PAYBACK_TIME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroInterest()
    {
        Assert.assertNotNull(product);
        Assert.assertEquals(product, new House(HouseTest.DEFAULT_EXPECTED_PRICE));

        ILoan loan = new HouseLoan(product, HouseLoanTest.DEFAULT_PAYBACK_TIME, 0);
        Assert.assertNotNull(loan.getInterest());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegatifInterest()
    {
        Assert.assertNotNull(product);
        Assert.assertEquals(product, new House(HouseTest.DEFAULT_EXPECTED_PRICE));

        ILoan loan = new HouseLoan(product, HouseLoanTest.DEFAULT_PAYBACK_TIME, -50);
        Assert.assertNotNull(loan.getInterest());
    }

    @Test
    public void testInterest()
    {
        Assert.assertNotNull(product);
        Assert.assertEquals(product, new House(HouseTest.DEFAULT_EXPECTED_PRICE));

        ILoan loan = new HouseLoan(product, HouseLoanTest.DEFAULT_PAYBACK_TIME, 6.5);
        Assert.assertNotNull(loan.getInterest());
        Assert.assertEquals(loan.getInterest(), 6.5, DOUBLE_DELTA);
    }

    @Test
    public void testDefaultInterest()
    {
        Assert.assertEquals(HouseLoan.DEFAULT_INTEREST, new HouseLoan(product, HouseLoanTest.DEFAULT_PAYBACK_TIME).getInterest(), DOUBLE_DELTA);
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals(new HouseLoan(product, HouseLoanTest.DEFAULT_PAYBACK_TIME).toString(), "product:{name:" + House.DEFAULT_NAME + " price:" + HouseTest.DEFAULT_EXPECTED_PRICE + "} paybacktime:"
                + HouseLoanTest.DEFAULT_PAYBACK_TIME + " interest:" + HouseLoan.DEFAULT_INTEREST);
    }

    @Test
    public void testCalculateMonthlyPayment()
    {
        // See BasicPaymentMethodTest for more tests
        Assert.assertNotNull(product);
        Assert.assertEquals(product, new House(HouseTest.DEFAULT_EXPECTED_PRICE));

        ILoan loan = new HouseLoan(product, 1);
        Assert.assertNotNull(loan.calcMonthlyPayment());
    }

}

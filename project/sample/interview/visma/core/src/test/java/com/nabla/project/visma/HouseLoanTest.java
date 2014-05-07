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

    private static final double DELTA = 1e-15;
    
    private IProduct product;
    
    @Before
    public void setUp() throws Exception
    {
        product = new House(HouseTest.EXPECTED_PRICE);
    }

    @After
    public void tearDown() throws Exception
    {
        product = null;
    }

    @Test(expected = AssertionError.class)
    public final void testEmptyContructor() {

        ILoan loan = new HouseLoan();
        Assert.assertNotNull(loan);

    }
    
    @Test
    public void testGetInterest()
    {
        Assert.assertEquals(new HouseLoan(product).getInterest(), HouseLoan.DEFAULT_INTEREST, DELTA);
    }

    @Test
    public final void testProductNotNull() {

        ILoan loan = new HouseLoan(product);
        Assert.assertNotNull(loan.getProduct());

    }
    
    @Test(expected = IllegalArgumentException.class)
    public final void testProductNull() {

        ILoan loan = new HouseLoan(null);
        Assert.assertNotNull(loan.getProduct());

    }
    
    @Test
    public void testGetProduct()
    {
        Assert.assertNotNull(product);
        Assert.assertEquals(product, new House(HouseTest.EXPECTED_PRICE));
        
        ILoan loan = new HouseLoan(product);
        Assert.assertNotNull(loan.getProduct());
        Assert.assertEquals(loan.getProduct(), product);
        Assert.assertEquals(loan.getProduct().getPrice(), HouseTest.EXPECTED_PRICE);
    }

    @Test
    public void testCalculateMonthlyPayment()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals(new HouseLoan(product).toString(), "product:{name:" + House.DEFAULT_HOUSE_NAME + " price:"+ HouseTest.EXPECTED_PRICE + "} interest:" + HouseLoan.DEFAULT_INTEREST);
    }

}

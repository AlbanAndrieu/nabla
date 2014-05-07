package com.nabla.project.visma;

import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.nabla.project.visma.api.ILoan;
import com.nabla.project.visma.api.IPaymentMethod;
import com.nabla.project.visma.api.IProduct;

public class BasicPaymentMethodTest
{

    private ILoan loan;
    private IProduct product;
    
    @Before
    public void setUp() throws Exception
    {
        product = new House(HouseTest.DEFAULT_EXPECTED_PRICE);
        loan = new HouseLoan(product, HouseLoanTest.DEFAULT_PAYBACK_TIME);
    }

    @After
    public void tearDown() throws Exception
    {
        loan = null;
        product = null;
    }

    @Test
    public final void testPaymentMethodNotNull() {

        IPaymentMethod method = new BasicPaymentMethod(loan);
        Assert.assertNotNull(method.calculate());

    }
    
    @Test(expected = IllegalArgumentException.class)
    public final void testPaymentMethodNull() {

        IPaymentMethod method = new BasicPaymentMethod(null);
        Assert.assertNotNull(method.calculate());

    }
    
    @Test
    public void testCalcMonthlyInterestRate()
    {
        Assert.assertEquals(HouseLoan.DEFAULT_INTEREST, loan.getInterest(), HouseLoanTest.DOUBLE_DELTA);
        Assert.assertEquals(new BigDecimal("0.004583333333333333333333333333333333"), BasicPaymentMethod.calcMonthlyInterestRate(loan.getInterest()));
    }
    
    @Test
    public void testCalcNumberOfMonths()
    {
        Assert.assertEquals(360, BasicPaymentMethod.calcNumberOfMonths(loan.getPaybackTime()), HouseLoanTest.DOUBLE_DELTA);
    }        
    
    @Test
    public void testMonthlyPaymentWithDouble()
    {
        // based on http://en.wikipedia.org/wiki/Fixed-rate_mortgage sample
        product = new House(new BigDecimal(200_000));
        loan = new HouseLoan(product, HouseLoanTest.DEFAULT_PAYBACK_TIME, 6.5);
        
        IPaymentMethod method = new BasicPaymentMethod(loan);
        Assert.assertEquals(1264.136046985934, ((BasicPaymentMethod) method).getMonthlyPaymentWithDouble(), HouseLoanTest.DOUBLE_DELTA);
    }                   
    
    @Test
    public void testMonthlyPayment()
    {
        // based on http://en.wikipedia.org/wiki/Fixed-rate_mortgage sample
        product = new House(new BigDecimal(200_000));
        loan = new HouseLoan(product, HouseLoanTest.DEFAULT_PAYBACK_TIME, 6.5);
        
        IPaymentMethod method = new BasicPaymentMethod(loan);
        Assert.assertEquals("1264.136046985927464091663352477320", ((BasicPaymentMethod) method).getMonthlyPayment().toString());
    }      

    @Test
    public void testCalculate()
    {
        fail("Not yet implemented");
    }
    
    

}

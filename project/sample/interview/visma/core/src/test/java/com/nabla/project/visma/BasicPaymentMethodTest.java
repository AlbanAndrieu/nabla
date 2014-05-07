package com.nabla.project.visma;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.nabla.project.visma.api.ILoan;
import com.nabla.project.visma.api.IPaymentMethod;
import com.nabla.project.visma.api.IProduct;

public class BasicPaymentMethodTest
{

    private static final String EXPECTED_PAYMENT_RESULT_30 = "1264.136046985927464091663352477320";
    private static final String EXPECTED_PAYMENT_RESULT_1  = "17259.28339205628248798033176022882";

    private static final double DEFAULT_TEST_INTEREST      = 6.5;

    private ILoan               loan;
    private IProduct            product;

    @Before
    public void setUp() throws Exception
    {
        // based on http://en.wikipedia.org/wiki/Fixed-rate_mortgage sample
        product = new House(new BigDecimal(200_000));
        loan = new HouseLoan(product, HouseLoanTest.DEFAULT_PAYBACK_TIME, BasicPaymentMethodTest.DEFAULT_TEST_INTEREST);
    }

    @After
    public void tearDown() throws Exception
    {
        loan = null;
        product = null;
    }

    @Test
    public final void testPaymentMethodNotNull()
    {

        IPaymentMethod method = new BasicPaymentMethod(loan);
        Assert.assertNotNull(method.calculate());

    }

    @Test(expected = IllegalArgumentException.class)
    public final void testPaymentMethodNull()
    {

        IPaymentMethod method = new BasicPaymentMethod(null);
        Assert.assertNotNull(method.calculate());

    }

    @Test
    public void testCalcMonthlyInterestRate()
    {
        Assert.assertEquals(DEFAULT_TEST_INTEREST, loan.getInterest(), HouseLoanTest.DOUBLE_DELTA);
        Assert.assertEquals(new BigDecimal("0.005416666666666666666666666666666667"), BasicPaymentMethod.calcMonthlyInterestRate(loan.getInterest()));
    }

    @Test
    public void testCalcNumberOfMonths()
    {
        Assert.assertEquals(360, BasicPaymentMethod.calcNumberOfMonths(loan.getPaybackTime()), HouseLoanTest.DOUBLE_DELTA);
    }

    @Test
    public void testMonthlyPaymentWithDouble()
    {
        IPaymentMethod method = new BasicPaymentMethod(loan);
        Assert.assertEquals(1264.136046985934, ((BasicPaymentMethod) method).getMonthlyPaymentWithDouble(), HouseLoanTest.DOUBLE_DELTA);
    }

    @Test
    public void testMonthlyPayment()
    {
        IPaymentMethod method = new BasicPaymentMethod(loan);
        Assert.assertEquals(EXPECTED_PAYMENT_RESULT_30, ((BasicPaymentMethod) method).getMonthlyPayment().toString());
    }

    @Test
    public void testCalculate()
    {
        loan = new HouseLoan(product, 1, DEFAULT_TEST_INTEREST);
        IPaymentMethod method = new BasicPaymentMethod(loan);
        Map<Integer, List<BigDecimal>> payments = method.calculate();
        Assert.assertNotNull(payments);
        Assert.assertEquals(12, payments.size());
        Assert.assertEquals("{0=[" + EXPECTED_PAYMENT_RESULT_1 + "], 1=[" + EXPECTED_PAYMENT_RESULT_1 + "], 2=[" + EXPECTED_PAYMENT_RESULT_1 + "], 3=[" + EXPECTED_PAYMENT_RESULT_1 + "], 4=[" + EXPECTED_PAYMENT_RESULT_1
                + "], 5=[" + EXPECTED_PAYMENT_RESULT_1 + "], 6=[" + EXPECTED_PAYMENT_RESULT_1 + "], 7=[" + EXPECTED_PAYMENT_RESULT_1 + "], 8=[" + EXPECTED_PAYMENT_RESULT_1 + "], 9=[" + EXPECTED_PAYMENT_RESULT_1
                + "], 10=[" + EXPECTED_PAYMENT_RESULT_1 + "], 11=[" + EXPECTED_PAYMENT_RESULT_1 + "]}", method.calculate().toString());
    }

}

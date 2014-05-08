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

/**
 * DOCUMENT ME!
 *
 * @author $Author$
 * @version $Revision$
 *
 * @since $Date$
 */
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
        this.product = new House(new BigDecimal(200_000));
        this.loan = new HouseLoan(this.product, HouseLoanTest.DEFAULT_PAYBACK_TIME, BasicPaymentMethodTest.DEFAULT_TEST_INTEREST);
    }

    @After
    public void tearDown() throws Exception
    {
        this.loan = null;
        this.product = null;
    }

    @Test
    public final void testPaymentMethodNotNull()
    {

        final IPaymentMethod method = new BasicPaymentMethod(this.loan);
        Assert.assertNotNull(method.calculate());

    }

    @Test(expected = IllegalArgumentException.class)
    public final void testPaymentMethodNull()
    {

        final IPaymentMethod method = new BasicPaymentMethod(null);
        Assert.assertNotNull(method.calculate());

    }

    @Test
    public void testCalcMonthlyInterestRate()
    {
        Assert.assertEquals(BasicPaymentMethodTest.DEFAULT_TEST_INTEREST, this.loan.getInterest(), HouseLoanTest.DOUBLE_DELTA);
        Assert.assertEquals(new BigDecimal("0.005416666666666666666666666666666667"), BasicPaymentMethod.calcMonthlyInterestRate(this.loan.getInterest()));
    }

    @Test
    public void testCalcNumberOfMonths()
    {
        Assert.assertEquals(360, BasicPaymentMethod.calcNumberOfMonths(this.loan.getPaybackTime()), HouseLoanTest.DOUBLE_DELTA);
    }

    @Test
    public void testMonthlyPaymentWithDouble()
    {
        final IPaymentMethod method = new BasicPaymentMethod(this.loan);
        Assert.assertEquals(1264.136046985934, ((BasicPaymentMethod) method).getMonthlyPaymentWithDouble(), HouseLoanTest.DOUBLE_DELTA);
    }

    @Test
    public void testMonthlyPayment()
    {
        final IPaymentMethod method = new BasicPaymentMethod(this.loan);
        Assert.assertEquals(BasicPaymentMethodTest.EXPECTED_PAYMENT_RESULT_30, ((BasicPaymentMethod) method).getMonthlyPayment().toString());
    }

    @Test
    public void testCalculate()
    {
        this.loan = new HouseLoan(this.product, 1, BasicPaymentMethodTest.DEFAULT_TEST_INTEREST);
        final IPaymentMethod method = new BasicPaymentMethod(this.loan);
        final Map<Integer, List<BigDecimal>> payments = method.calculate();
        Assert.assertNotNull(payments);
        Assert.assertEquals(12, payments.size());
        Assert.assertEquals("{0=[" + BasicPaymentMethodTest.EXPECTED_PAYMENT_RESULT_1 + "], 1=[" + BasicPaymentMethodTest.EXPECTED_PAYMENT_RESULT_1 + "], 2=[" + BasicPaymentMethodTest.EXPECTED_PAYMENT_RESULT_1
                + "], 3=[" + BasicPaymentMethodTest.EXPECTED_PAYMENT_RESULT_1 + "], 4=[" + BasicPaymentMethodTest.EXPECTED_PAYMENT_RESULT_1 + "], 5=[" + BasicPaymentMethodTest.EXPECTED_PAYMENT_RESULT_1 + "], 6=["
                + BasicPaymentMethodTest.EXPECTED_PAYMENT_RESULT_1 + "], 7=[" + BasicPaymentMethodTest.EXPECTED_PAYMENT_RESULT_1 + "], 8=[" + BasicPaymentMethodTest.EXPECTED_PAYMENT_RESULT_1 + "], 9=["
                + BasicPaymentMethodTest.EXPECTED_PAYMENT_RESULT_1 + "], 10=[" + BasicPaymentMethodTest.EXPECTED_PAYMENT_RESULT_1 + "], 11=[" + BasicPaymentMethodTest.EXPECTED_PAYMENT_RESULT_1 + "]}", method.calculate()
                .toString());
    }

}

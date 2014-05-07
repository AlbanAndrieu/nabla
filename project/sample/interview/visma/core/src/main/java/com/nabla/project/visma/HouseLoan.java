package com.nabla.project.visma;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.nabla.project.visma.api.ILoan;
import com.nabla.project.visma.api.IProduct;

public class HouseLoan implements ILoan
{

    private static final transient Logger LOGGER           = Logger.getLogger(HouseLoan.class);

    public static final double            DEFAULT_INTEREST = 5.5;

    // Fixed interest of 5.5% per year
    private double                        interest         = DEFAULT_INTEREST;

    private IProduct                      product;

    private int                           paybackTime;

    public HouseLoan()
    {
        throw new AssertionError();
    }

    public HouseLoan(IProduct aProduct, int aPaybackTime)
    {
        this.product = aProduct;
        this.paybackTime = aPaybackTime;

        if (null == this.product)
        {
            throw new IllegalArgumentException("Product cannot be null");
        }

        if (this.paybackTime <= 0)
        {
            throw new IllegalArgumentException("Payback time cannot be zero or negatif");
        }
    }

    public HouseLoan(IProduct aProduct, int aPaybackTime, double aInterest)
    {
        this(aProduct, aPaybackTime);
        this.interest = aInterest;

        if (this.interest <= 0)
        {
            throw new IllegalArgumentException("Interest time cannot be zero or negatif");
        }
    }

    @Override
    public double getInterest()
    {

        return interest;
    }

    @Override
    public IProduct getProduct()
    {
        return product;
    }

    @Override
    public Map<Integer, List<BigDecimal>> calcMonthlyPayment()
    {

        LOGGER.debug("Start calculateMonthlyPayment for : " + this.toString());
        // TODO check Design pattern strategy
        return new BasicPaymentMethod(this).calculate();
    }

    @Override
    public String toString()
    {

        final StringBuffer str = new StringBuffer();

        str.append("product:{").append(this.getProduct()).append("} ");
        str.append("paybacktime:").append(this.getPaybackTime()).append(' ');
        str.append("interest:").append(this.getInterest());

        return str.toString();

    }

    @Override
    public int getPaybackTime()
    {
        return paybackTime;
    }

}

package com.nabla.project.visma;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nabla.project.visma.api.ILoan;
import com.nabla.project.visma.api.IPaymentMethod;

public class BasicPaymentMethod implements IPaymentMethod
{

    private final ILoan loan;

    public BasicPaymentMethod(final ILoan aLoan)
    {
        this.loan = aLoan;

        if (null == this.loan)
        {
            throw new IllegalArgumentException("Loan cannot be null");
        }

    }

    @Override
    public Map<Integer, List<BigDecimal>> calculate()
    {
        final BigDecimal payment = this.getMonthlyPayment();
        final Map<Integer, List<BigDecimal>> monthlySchedule = new HashMap<Integer, List<BigDecimal>>();

        final int numberOfMonths = BasicPaymentMethod.calcNumberOfMonths(this.loan.getPaybackTime());
        for (int month = 0; month < numberOfMonths; month++)
        {
            final List<BigDecimal> data = new ArrayList<BigDecimal>();
            data.add(payment);
            monthlySchedule.put(month, data);
        }

        return monthlySchedule;
    }

    public static BigDecimal calcMonthlyInterestRate(final double annualInterestRate)
    {
        return new BigDecimal(annualInterestRate).divide(new BigDecimal(1200), MathContext.DECIMAL128);
    }

    public static int calcNumberOfMonths(final int paybackTimeInYear)
    {
        return paybackTimeInYear * 12;
    }

    // =PMT(6.5/100/12,30*12,200000)
    // =((6.5/100/12)/(1-(1+6.5/100/12)^(-30*12)))*200000
    @Deprecated
    public double getMonthlyPaymentWithDouble()
    {
        final BigDecimal monthlyInterestRate = BasicPaymentMethod.calcMonthlyInterestRate(this.loan.getInterest());
        final BigDecimal loanAmount = this.loan.getProduct().getPrice();
        final int numberOfMonths = BasicPaymentMethod.calcNumberOfMonths(this.loan.getPaybackTime());

        return BasicPaymentMethod.calcMonthlyPayment(monthlyInterestRate.doubleValue(), loanAmount.doubleValue(), numberOfMonths);
    }

    public BigDecimal getMonthlyPayment()
    {
        final BigDecimal monthlyInterestRate = BasicPaymentMethod.calcMonthlyInterestRate(this.loan.getInterest());
        final BigDecimal loanAmount = this.loan.getProduct().getPrice();
        final int numberOfMonths = BasicPaymentMethod.calcNumberOfMonths(this.loan.getPaybackTime());

        return BasicPaymentMethod.calcMonthlyPayment(monthlyInterestRate, loanAmount, numberOfMonths);
    }

    @Deprecated
    public double getTotalPaymentWithDouble()
    {
        return this.getMonthlyPaymentWithDouble() * BasicPaymentMethod.calcNumberOfMonths(this.loan.getPaybackTime());
    }

    public BigDecimal getTotalPayment()
    {
        return this.getMonthlyPayment().multiply(new BigDecimal(BasicPaymentMethod.calcNumberOfMonths(this.loan.getPaybackTime())));
    }

    @Deprecated
    public static double calcMonthlyPayment(final double monthlyInterestRate, final double loanAmount, final int numberOfMonths)
    {
        return (loanAmount * monthlyInterestRate) / (1 - (Math.pow(1 / (1 + monthlyInterestRate), numberOfMonths)));
    }

    public static BigDecimal calcMonthlyPayment(final BigDecimal monthlyInterestRate, final BigDecimal loanAmount, final int numberOfMonths)
    {
        // return (loanAmount.multiply(new BigDecimal(monthlyInterestRate)))/(1-(1+monthlyInterestRate)-numberOfMonths);
        return loanAmount.multiply(monthlyInterestRate).divide(new BigDecimal(1).subtract((new BigDecimal(1).divide((monthlyInterestRate.add(new BigDecimal(1))), MathContext.DECIMAL128).pow(numberOfMonths))),
                MathContext.DECIMAL128);
    }

}

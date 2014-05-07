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

    private ILoan loan;

    public BasicPaymentMethod(ILoan aLoan)
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
        BigDecimal payment = getMonthlyPayment();
        Map<Integer, List<BigDecimal>> monthlySchedule = new HashMap<Integer, List<BigDecimal>>();

        int numberOfMonths = BasicPaymentMethod.calcNumberOfMonths(loan.getPaybackTime());
        for (int month = 0; month < numberOfMonths; month++)
        {
            List<BigDecimal> data = new ArrayList<BigDecimal>();
            data.add(payment);
            monthlySchedule.put(month, data);
        }

        return monthlySchedule;
    }

    public static BigDecimal calcMonthlyInterestRate(double annualInterestRate)
    {
        return new BigDecimal(annualInterestRate).divide(new BigDecimal(1200), MathContext.DECIMAL128);
    }

    public static int calcNumberOfMonths(int paybackTimeInYear)
    {
        return paybackTimeInYear * 12;
    }

    // =PMT(6.5/100/12,30*12,200000)
    // =((6.5/100/12)/(1-(1+6.5/100/12)^(-30*12)))*200000
    @Deprecated
    public double getMonthlyPaymentWithDouble()
    {
        BigDecimal monthlyInterestRate = BasicPaymentMethod.calcMonthlyInterestRate(loan.getInterest());
        BigDecimal loanAmount = loan.getProduct().getPrice();
        int numberOfMonths = BasicPaymentMethod.calcNumberOfMonths(loan.getPaybackTime());

        return calcMonthlyPayment(monthlyInterestRate.doubleValue(), loanAmount.doubleValue(), numberOfMonths);
    }

    public BigDecimal getMonthlyPayment()
    {
        BigDecimal monthlyInterestRate = BasicPaymentMethod.calcMonthlyInterestRate(loan.getInterest());
        BigDecimal loanAmount = loan.getProduct().getPrice();
        int numberOfMonths = BasicPaymentMethod.calcNumberOfMonths(loan.getPaybackTime());

        return calcMonthlyPayment(monthlyInterestRate, loanAmount, numberOfMonths);
    }

    @Deprecated
    public double getTotalPaymentWithDouble()
    {
        return getMonthlyPaymentWithDouble() * BasicPaymentMethod.calcNumberOfMonths(loan.getPaybackTime());
    }

    public BigDecimal getTotalPayment()
    {
        return getMonthlyPayment().multiply(new BigDecimal(BasicPaymentMethod.calcNumberOfMonths(loan.getPaybackTime())));
    }

    @Deprecated
    public static double calcMonthlyPayment(double monthlyInterestRate, double loanAmount, int numberOfMonths)
    {
        return loanAmount * monthlyInterestRate / (1 - (Math.pow(1 / (1 + monthlyInterestRate), numberOfMonths)));
    }

    public static BigDecimal calcMonthlyPayment(BigDecimal monthlyInterestRate, BigDecimal loanAmount, int numberOfMonths)
    {
        // return (loanAmount.multiply(new BigDecimal(monthlyInterestRate)))/(1-(1+monthlyInterestRate)-numberOfMonths);
        return loanAmount.multiply(monthlyInterestRate).divide(new BigDecimal(1).subtract((new BigDecimal(1).divide((monthlyInterestRate.add(new BigDecimal(1))), MathContext.DECIMAL128).pow(numberOfMonths))),
                MathContext.DECIMAL128);
    }

}

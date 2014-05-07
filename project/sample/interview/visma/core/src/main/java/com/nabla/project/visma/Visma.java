package com.nabla.project.visma;

import java.math.BigDecimal;
import java.util.Scanner;

import com.nabla.project.visma.api.ILoan;
import com.nabla.project.visma.api.IProduct;

public class Visma
{

    public static void main(String[] args)
    {        
        double loanAmount;//double value loan amount 
        double annualInterestRate;//double value interest rate
        int numberOfYears;//int value for number of months

        try (Scanner keyboard = new Scanner(System.in)) {

            System.out.println("Please enter the amount of your loan. Ex. 200000");
            loanAmount = keyboard.nextDouble();

            System.out.println("Please enter the annual interest rate as a decimal. Ex. 6.5 for 6.5% = .065");
            annualInterestRate = keyboard.nextDouble();

            System.out.println("Please enter the number of years you have to pay back your loan. Ex. 30");
            numberOfYears = keyboard.nextInt();
        }

        IProduct product = new House(new BigDecimal(loanAmount));
        ILoan loan = new HouseLoan(product, numberOfYears, annualInterestRate);

        System.out.println("Payment schedule is :\n " + loan.calcMonthlyPayment() + "\n");

        BigDecimal totalPayment= new BasicPaymentMethod(loan).getTotalPayment();
        if (totalPayment.doubleValue() < loanAmount) {
            System.err.println("Total payment is lower than loan amount\n");
            // Calculation is wrong
        } else {
            System.out.println("Total payment is :\n " + totalPayment + "\n");
        }

    }

}

/*
 * Copyright (c) 2002-2004, Nabla
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Nabla' nor 'Alban' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package com.nabla.project.visma;

import java.math.BigDecimal;
import java.util.Scanner;

import com.nabla.project.visma.api.ILoan;
import com.nabla.project.visma.api.IProduct;

public class Visma
{

    public static void main(final String[] args)
    {
        double loanAmount;// double value loan amount
        double annualInterestRate;// double value interest rate
        int numberOfYears;// int value for number of months

        try (Scanner keyboard = new Scanner(System.in))
        {

            System.out.println("Please enter the amount of your loan. Ex. 200000");
            loanAmount = keyboard.nextDouble();

            System.out.println("Please enter the annual interest rate as a decimal. Ex. 6.5 for 6.5% = .065");
            annualInterestRate = keyboard.nextDouble();

            System.out.println("Please enter the number of years you have to pay back your loan. Ex. 30");
            numberOfYears = keyboard.nextInt();
        }

        final IProduct product = new House(new BigDecimal(loanAmount));
        final ILoan loan = new HouseLoan(product, numberOfYears, annualInterestRate);

        System.out.println("Payment schedule is :\n " + loan.calcMonthlyPayment() + "\n");

        final BigDecimal totalPayment = loan.getTotalPayment();
        if (totalPayment.doubleValue() < loanAmount)
        {
            System.err.println("Total payment is lower than loan amount\n");
            // Calculation is wrong
        } else
        {
            System.out.println("Total payment is :\n " + totalPayment + "\n");
        }

    }

}

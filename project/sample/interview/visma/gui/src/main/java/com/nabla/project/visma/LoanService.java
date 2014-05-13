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
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.nabla.project.visma.api.ILoan;
import com.nabla.project.visma.api.ILoanService;
import com.nabla.project.visma.api.IProduct;

//The @Stateless annotation eliminates the need for manual transaction
//TODO @Stateless
public class LoanService implements ILoanService
{

    // TODO @Inject
    private static transient Logger LOGGER = Logger.getLogger(LoanService.class);

    @Override
    public Map<Integer, List<BigDecimal>> calcMonthlyPayment(final BigDecimal loanAmount, final int numberOfYears)
    {

        if (LoanService.LOGGER.isDebugEnabled())
        {
            LoanService.LOGGER.debug("Start calculateMonthlyPayment for loan amount: " + loanAmount + " and number of years :" + numberOfYears);
        }

        final IProduct product = new House(loanAmount);
        final ILoan loan = new HouseLoan(product, numberOfYears);

        return loan.calcMonthlyPayment();

    }

    @Override
    public BigDecimal getTotalPayment(final BigDecimal loanAmount, final int numberOfYears)
    {

        if (LoanService.LOGGER.isDebugEnabled())
        {
            LoanService.LOGGER.debug("Start getTotalPayment for loan amount: " + loanAmount + " and number of years :" + numberOfYears);
        }

        final IProduct product = new House(loanAmount);
        final ILoan loan = new HouseLoan(product, numberOfYears);

        return loan.getTotalPayment();
    }
}

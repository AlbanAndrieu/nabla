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
package com.nabla.project.visma.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * DOCUMENT ME! albandri.
 *
 * @author $Author$
 * @version $Revision$
 *
 * @since $Date$
 *
 */
public interface ILoan {

    /**
     *
     * Interest in percent. Default is 5.5 (for 5.5%).
     *
     * @return interest in percent
     */
    double getInterest();

    /**
     *
     * Give the time wanted for the loan in order to calculate payments.
     *
     * @return payback time in years
     */
    int getPaybackTime();

    /**
     *
     * Give the product related to the loan.
     *
     * @return the product related to the loan
     */
    IProduct getProduct();

    /**
     *
     * Give monthly payback plan based on the product, interest and payback time
     *
     * @return a date with their corresponding amount and interest
     */
    Map<Integer, List<BigDecimal>> calcMonthlyPayment();

    /**
     *
     * Get the total of all scheduled payment
     *
     * @return sum of payments
     */
    BigDecimal getTotalPayment();
}

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
package com.nabla.project.foobar;

import java.math.BigDecimal;

/**
 * A Foobar.
 *
 * @author $Author$
 * @version $Revision$
 *
 * @since $Date$
 */

// See sample href=http://www.javapractices.com/topic/TopicAction.do?Id=13
public final class Foobar
{

    /**
     * Defined centrally, to allow for easy changes to the rounding mode.
     */
    public static final int         ROUNDING_MODE = BigDecimal.ROUND_HALF_EVEN;

    /**
     * Number of decimals to retain. Also referred to as "scale".
     */
    public static final int         DECIMALS      = 2;
    private static final BigDecimal HUNDRED       = new BigDecimal("100");
    private static final BigDecimal PERCENT       = new BigDecimal("20");      // In Percent

    // TODO use BigDecimal instead of float
    // TODO check BigDecimal immutable
    private final BigDecimal        price;

    /**
     * @param aPrice a price
     */
    public Foobar(final BigDecimal aPrice)
    {
        super();
        this.price = aPrice;

    }

    /**
     * Getter.
     *
     * @return the price
     */
    public BigDecimal getPrice()
    {

        return this.price;

    }

    /*
     * private void setPrice(BigDecimal aPrice) { this.price = aPrice; }
     */

    /**
     * Add percentage to the initial price.
     *
     * @param aPrice the price to set
     *
     * @return BigDecimal
     */

    // TODO must use BigDecimal instead
    public static BigDecimal addPercent(final BigDecimal aPrice)
    {

        return aPrice.add(Foobar.getPercentage(aPrice));

        // TODO we may have trouble because rounding a sum and sum of round give not the same result
        // return Foobar.round(aPrice + (aPrice * Monetary.DEFAULT_INCREASE));
    }

    /**
     * You may have trouble because rounding occurs here and a sum and sum of round give not the same result.
     *
      * @param aPrice a price
     *
     * @return the Rounded Price
     */
    public static BigDecimal getPercentage(final BigDecimal aPrice)
    {

        BigDecimal result = aPrice.multiply(Foobar.PERCENT);

        // TODO rounded must be done as late as possible
        result = result.divide(Foobar.HUNDRED, Foobar.DECIMALS, Foobar.ROUNDING_MODE);

        // return Foobar.round(result);
        return result;

    }

    /**
     * You may have trouble because rounding a sum and sum of round give not the same result.
     *
     * @param aPrice a price
     *
     * @return the Rounded Price
     */
    public static BigDecimal round(final BigDecimal aPrice)
    {

        return aPrice.setScale(Foobar.DECIMALS, Foobar.ROUNDING_MODE);

    }

    /**
     * Give the sum of the amount
     *
     * @param aFirstValue a first value
     * @param aSecondValue a second value to be added to the first value
     *
     * @return BigDecimal the sum
     */

    // TODO not used
    public static BigDecimal getSum(final BigDecimal aFirstValue, final BigDecimal aSecondValue)
    {

        final BigDecimal sum = aFirstValue.add(aSecondValue);

        // System.out.println("Sum of two BigDecimal numbers: " + sum + " - " + aFirstValue + " - " + aSecondValue);
        return sum;

    }

    /**
     * Return <tt>true</tt> only if the amount is positive.
     *
     * @param aPrice DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static boolean isPlus(final BigDecimal aPrice)
    {

        return aPrice.compareTo(BigDecimal.ZERO) > 0;

    }

    /**
     * Return <tt>true</tt> only if the amount is negative.
     *
     * @param aPrice DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static boolean isMinus(final BigDecimal aPrice)
    {

        return aPrice.compareTo(BigDecimal.ZERO) < 0;

    }

    /**
     * Return <tt>true</tt> only if the amount is zero.
     *
     * @param aPrice DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static boolean isZero(final BigDecimal aPrice)
    {

        return aPrice.compareTo(BigDecimal.ZERO) == 0;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    @Override
    public String toString()
    {

        final StringBuffer str = new StringBuffer();

        str.append("price=").append(this.getPrice());

        return str.toString();

    }

}

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
import java.util.ListIterator;

/**
 * DOCUMENT ME!
 *
 * @author $Author$
 * @version $Revision$
 *
 * @since $Date$
 */
public final class Pocket
{

    // TODO use BigDecimal instead of float see http://www.javapractices.com/topic/TopicAction.do?Id=13
    // BigDecimal is not immutable
    /**
     * The money amount. Never null.
     *
     * @serial
     */
    private BigDecimal remaining;
    private int        item;

    /**
     * Creates a new Pocket object.
     *
     * @param anInitialAmount DOCUMENT ME!
     */
    public Pocket(final BigDecimal anInitialAmount)
    {
        super();
        this.remaining = anInitialAmount;

        // this.item = 0; not needed
    }

    /**
     * Getter.
     *
     * @return the remaining
     */
    public BigDecimal getRemaining()
    {

        // TODO we may have trouble because rounding a sum and sum of round give not the same result
        // return Foobar.round(this.remaining);
        return this.remaining;

    }

    /**
     * Setter.
     *
     * @param aRemaining a remaining
     */
    private void setRemaining(final BigDecimal aRemaining)
    {

        this.remaining = aRemaining;

    }

    /**
     * Getter.
     *
     * @return the item
     */
    public int getItem()
    {

        return this.item;

    }

    /**
     * Setter.
     *
     * @param anItem the item to set
     */
    private void setItem(final int anItem)
    {

        this.item = anItem;

    }

    /**
     * Retrieve the price from the remaining amount.
     *
     * @param aPrice a price
     *
     * @return true if buying is possible
     */
    public Boolean buy(final BigDecimal aPrice)
    {

        if ((Foobar.isPlus(aPrice)) && (Foobar.isPlus(this.getRemaining())) && (Foobar.isPlus(this.getRemaining().subtract(aPrice))))
        {

            this.setRemaining(this.getRemaining().subtract(aPrice));
            this.setItem(this.getItem() + 1);

            return true;

        }

        return false;

    }

    /**
     * DOCUMENT ME!
     *
     * @param shelf DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Boolean solve(final Shelf shelf)
    {

        Boolean remained = true;
        final ListIterator<Foobar> iterator = shelf.getShelf().listIterator();

        while (remained && iterator.hasNext())
        {

            final Foobar foobar = iterator.next();

            if (!this.buy(foobar.getPrice()))
            {

                remained = false;

            }

        }

        return remained;

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

        str.append("remaining=").append(this.getRemaining()).append(' ');
        str.append("item=").append(this.getItem());

        return str.toString();

    }

}

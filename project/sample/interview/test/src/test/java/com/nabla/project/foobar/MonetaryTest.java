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

import junit.framework.Assert;

import org.junit.Test;

/**
 * DOCUMENT ME!
 *
 * @author $Author$
 * @version $Revision$
 *
 * @since $Date$
 */
public class MonetaryTest
{

    private static final int RIGHT_ITEMS = 20;

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void test()
    {

        final Shelf shelf = new Shelf(Monetary.MAX_ITEMS);

        System.out.println(shelf);

        final Pocket pocket = new Pocket(Monetary.DEFAULT_POCKET);

        Assert.assertFalse(pocket.solve(shelf));

        System.out.println(pocket);

        System.out.println("Routine stopped at " + pocket.getItem() + " items");
        Assert.assertEquals(MonetaryTest.RIGHT_ITEMS, pocket.getItem());

        final BigDecimal amountSpendInPocket = Monetary.DEFAULT_POCKET.subtract(pocket.getRemaining());

        System.out.println("So for a shelf of " + pocket.getItem() + " items, we must have the somme amount spend in pocket " + amountSpendInPocket);

        // We are trying a shelf of 20 items
        final Shelf exactShelf = new Shelf(pocket.getItem());

        System.out.println(exactShelf);

        Assert.assertEquals(pocket.getItem(), exactShelf.size());
        Assert.assertEquals(amountSpendInPocket, exactShelf.sum());

        System.out.println("Amount spend in routine is " + amountSpendInPocket + " must equals amount in a shelf of " + pocket.getItem() + " : " + exactShelf.sum());

    }

}

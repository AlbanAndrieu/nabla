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
public class PocketTest
{

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void testRemaining()
    {

        final Pocket pocket = new Pocket(Monetary.DEFAULT_POCKET);

        Assert.assertEquals(Monetary.DEFAULT_POCKET, pocket.getRemaining());
        Assert.assertEquals(0, pocket.getItem());

        final BigDecimal price1 = new BigDecimal("1");

        Assert.assertTrue(pocket.buy(price1));
        Assert.assertEquals(Monetary.DEFAULT_POCKET.subtract(price1), pocket.getRemaining());
        Assert.assertEquals(1, pocket.getItem());

        final BigDecimal price2 = new BigDecimal("1.2");

        Assert.assertTrue(pocket.buy(price2));
        System.out.println((Monetary.DEFAULT_POCKET.subtract(price1).subtract(price2)) + " - " + pocket.getRemaining());
        Assert.assertEquals(Monetary.DEFAULT_POCKET.subtract(price1).subtract(price2), pocket.getRemaining());
        Assert.assertEquals(2, pocket.getItem());

        final BigDecimal price3 = new BigDecimal("1.44");

        Assert.assertTrue(pocket.buy(price3));
        Assert.assertEquals(Monetary.DEFAULT_POCKET.subtract(price1).subtract(price2).subtract(price3), pocket.getRemaining());
        Assert.assertEquals(3, pocket.getItem());

        final BigDecimal price4 = new BigDecimal("1.73");

        Assert.assertTrue(pocket.buy(price4));
        Assert.assertEquals(Monetary.DEFAULT_POCKET.subtract(price1).subtract(price2).subtract(price3).subtract(price4), pocket.getRemaining());
        Assert.assertEquals(4, pocket.getItem());

        System.out.println(pocket);
        Assert.assertEquals("remaining=194.63 item=4", pocket.toString());

    }

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void testBuyNoPocket()
    {

        final Pocket pocket = new Pocket(BigDecimal.ZERO);

        Assert.assertEquals(0f, pocket.getRemaining().floatValue());
        Assert.assertEquals(0, pocket.getItem());

        final BigDecimal price = new BigDecimal("1.5");

        Assert.assertFalse(pocket.buy(price));
        Assert.assertEquals(0f, pocket.getRemaining().floatValue());
        Assert.assertEquals(0, pocket.getItem());

    }

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void testBuyNoPocketForPrice()
    {

        final Pocket pocket = new Pocket(new BigDecimal("100"));

        Assert.assertEquals(100f, pocket.getRemaining().floatValue());
        Assert.assertEquals(0, pocket.getItem());

        final BigDecimal price = new BigDecimal("150");

        Assert.assertFalse(pocket.buy(price));
        Assert.assertEquals(100f, pocket.getRemaining().floatValue());
        Assert.assertEquals(0, pocket.getItem());

    }

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void testBuyPriceNegatif()
    {

        final Pocket pocket = new Pocket(Monetary.DEFAULT_POCKET);

        Assert.assertEquals(Monetary.DEFAULT_POCKET, pocket.getRemaining());
        Assert.assertEquals(0, pocket.getItem());

        final BigDecimal price = new BigDecimal("-1.73");

        Assert.assertFalse(pocket.buy(price));
        Assert.assertEquals(Monetary.DEFAULT_POCKET, pocket.getRemaining());
        Assert.assertEquals(0, pocket.getItem());

    }

}

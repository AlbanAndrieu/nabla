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
public class FoobarTest
{

    /**
     * Must use BigDecimal method instead.
     *
     * @param aPrice a price
     *
     * @return the Rounded Price
     */
    @Deprecated
    public static float round(float aPrice)
    {

        aPrice *= 100;
        aPrice = (float) Math.round(aPrice) / 100;

        return aPrice;

    }

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void roundFloat()
    {

        float f = 1.234f;

        System.out.println(f);
        f *= 100;
        System.out.println(f + "-" + Math.round(f));
        f = (float) Math.round(f) / 100;
        System.out.println(f);
        Assert.assertEquals(1.23f, f);

    }

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void testRoundFloat()
    {

        final float f = 1.234f;
        final float price = FoobarTest.round(f);

        Assert.assertEquals(1.23f, price);

    }

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void testRoundBigDecimal()
    {

        final BigDecimal f = new BigDecimal("1.234");
        final BigDecimal price = Foobar.round(f);

        Assert.assertEquals("1.23", price.toString());

    }

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void testAddPercent()
    {

        final Foobar Foobar1 = new Foobar(BigDecimal.ONE);

        Assert.assertEquals(1f, Foobar1.getPrice().floatValue());

        final Foobar Foobar2 = new Foobar(Foobar.addPercent(Foobar1.getPrice()));

        Assert.assertEquals(1.2f, Foobar2.getPrice().floatValue());

        final Foobar Foobar3 = new Foobar(Foobar.addPercent(Foobar2.getPrice()));

        Assert.assertEquals(1.44f, Foobar3.getPrice().floatValue());

        final Foobar Foobar4 = new Foobar(Foobar.addPercent(Foobar3.getPrice()));

        Assert.assertEquals(1.73f, Foobar4.getPrice().floatValue());

    }

}

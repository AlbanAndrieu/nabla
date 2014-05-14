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

import org.junit.Assert;
import org.junit.Test;

import com.nabla.project.visma.api.IProduct;

/**
 * DOCUMENT ME!
 * 
 * @author $Author$
 * @version $Revision$
 * @since $Date$
 */
public class HouseTest
{

    public static final BigDecimal DEFAULT_EXPECTED_PRICE = new BigDecimal(1_000_000);

    @Test(expected = AssertionError.class)
    public final void testEmptyContructor()
    {

        final IProduct product = new House();
        Assert.assertNotNull(product);

    }

    @Test(expected = IllegalArgumentException.class)
    public final void testProductNull()
    {

        @SuppressWarnings("null")
        final IProduct product = new House(null);
        Assert.assertNotNull(product);

    }

    @Test
    public final void testPriceContructor()
    {

        Assert.assertEquals(HouseTest.DEFAULT_EXPECTED_PRICE, new House(new BigDecimal(1_000_000)).getPrice());
        Assert.assertFalse(new House(new BigDecimal(1_000_000)).equals(HouseTest.DEFAULT_EXPECTED_PRICE));
    }

    @Test(expected = NumberFormatException.class)
    public final void testPriceNotANumber()
    {

        final IProduct product = new House(new BigDecimal("Not a number"));
        Assert.assertNotNull(product);

    }

    @Test(expected = IllegalArgumentException.class)
    public final void testPriceNotNull()
    {

        @SuppressWarnings("null")
        final IProduct product = new House(null);
        Assert.assertNotNull(product);

    }

    @Test(expected = IllegalArgumentException.class)
    public final void testNegatifPriceContructorBigDecimal()
    {

        Assert.assertEquals(new BigDecimal(-100), new House(new BigDecimal(-100)));
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testNegatifPriceContructor()
    {

        Assert.assertEquals(new BigDecimal(-100), new House(-100));
    }

    @SuppressWarnings("null")
    @Test(expected = IllegalArgumentException.class)
    public final void testPriceZero1()
    {

        Assert.assertEquals(BigDecimal.ZERO, new House(BigDecimal.ZERO));

    }

    @Test(expected = IllegalArgumentException.class)
    public final void testPriceZero2()
    {

        Assert.assertEquals(BigDecimal.ZERO, new House(0));

    }

    @Test
    public final void testToString()
    {

        Assert.assertEquals("name:" + House.DEFAULT_NAME + " price:" + HouseTest.DEFAULT_EXPECTED_PRICE, new House(1_000_000).toString());
        Assert.assertFalse(new House(1_000_000).equals("name:" + House.DEFAULT_NAME + " price:" + HouseTest.DEFAULT_EXPECTED_PRICE));

    }

    @Test
    public final void testCompareNull()
    {

        Assert.assertFalse(new House(1_000_000).equals(null));
    }

    @SuppressWarnings("null")
    @Test(expected = IllegalArgumentException.class)
    public final void testCompareZero()
    {

        Assert.assertFalse(new House(1_000_000).equals(new House((BigDecimal.ZERO))));
    }

    @Test
    public final void testCompareOK()
    {

        Assert.assertEquals(new House(1_000_000), new House(1_000_000));
        Assert.assertTrue(new House(1_000_000).equals(new House(1_000_000)));
        Assert.assertFalse(new House(1_000_000).equals(new House((3_565_777))));
    }

    @Test
    public final void testCompareNOK()
    {

        Assert.assertFalse(new House(1_000_000).equals(new House((3_565_777))));
    }

    @Test(expected = AssertionError.class)
    public final void testCompareNOKwithException()
    {

        Assert.assertFalse(new House(1_000_000).equals(new House()));
    }
}

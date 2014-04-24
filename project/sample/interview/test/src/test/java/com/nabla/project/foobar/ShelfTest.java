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
import java.util.LinkedList;
import java.util.List;

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
public class ShelfTest
{

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void testInit()
    {

        final int max = 3;

        final List<Foobar> shelf = new LinkedList<Foobar>();

        shelf.add(new Foobar(BigDecimal.ONE));

        for (int i = 0; i < max; i++)
        {

            final Foobar actualFoobar = shelf.get(i);

            System.out.println("Foobar " + i + " - " + actualFoobar);

            final Foobar newFoobar = new Foobar(Foobar.addPercent(actualFoobar.getPrice()));

            System.out.println("New Foobar " + (i + 1) + " - " + newFoobar);
            shelf.add(newFoobar);

        }

        System.out.println(shelf);
        Assert.assertEquals(4, shelf.size());
        Assert.assertEquals("[price=1, price=1.20, price=1.44, price=1.73]", shelf.toString());

    }

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void testInit0Item()
    {

        final Shelf shelf = new Shelf(0);

        System.out.println(shelf);
        Assert.assertEquals(0, shelf.size());

    }

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void testInit1Item()
    {

        final Shelf shelf = new Shelf(1);

        System.out.println(shelf);
        Assert.assertEquals(1, shelf.size());

    }

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void testInit4Item()
    {

        final Shelf shelf = new Shelf(4);

        System.out.println(shelf);
        Assert.assertEquals(4, shelf.size());
        Assert.assertEquals(5.37f, shelf.sum().floatValue());
        Assert.assertEquals("size=4 sum=5.37 shelf=[price=1, price=1.20, price=1.44, price=1.73]", shelf.toString());

    }

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void testInit20Item()
    {

        final Shelf shelf = new Shelf(20);

        System.out.println(shelf);
        Assert.assertEquals(20, shelf.size());
        Assert.assertEquals(187.39f, shelf.sum().floatValue());
        Assert.assertEquals(
                "size=20 sum=187.39 shelf=[price=1, price=1.20, price=1.44, price=1.73, price=2.08, price=2.50, price=3.00, price=3.60, price=4.32, price=5.18, price=6.22, price=7.46, price=8.95, price=10.74, price=12.89, price=15.47, price=18.56, price=22.27, price=26.72, price=32.06]",
                shelf.toString());

    }

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void testInit21Item()
    {

        final Shelf shelf = new Shelf(21);

        System.out.println(shelf);
        Assert.assertEquals(21, shelf.size());
        Assert.assertEquals(225.86f, shelf.sum().floatValue());

    }

}

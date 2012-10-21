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
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * DOCUMENT ME!
 *
 * @author $Author$
 * @version $Revision$
 *
 * @since $Date$
 */
public final class Shelf
{

    private static final int   DEFAULT_ITEMS = 21;
    private final List<Foobar> shelf         = new ArrayList<Foobar>();

    /**
     * Creates a new Shelf object.
     */
    public Shelf()
    {
        this(Shelf.DEFAULT_ITEMS);
    }

    /**
     * Creates a new Shelf object.
     *
     * @param maxItem DOCUMENT ME!
     */
    public Shelf(final int maxItem)
    {
        super();
        this.init(maxItem);

    }

    /**
     * Initialize every Foobar with the correct price.
     *
     * @param aMaxItem the number of item to initialize
     */

    // TODO Do Lazy initialization maybe
    private void init(final int aMaxItem)
    {

        if (aMaxItem > 0)
        {

            this.getShelf().add(new Foobar(BigDecimal.ONE));

            // System.out.println(maxItem + " - ");
            for (int i = 0; i < (aMaxItem - 1); i++)
            {

                final Foobar actualFoobar = this.getShelf().get(i);

                // System.out.println(actualFoobar);
                final Foobar newFoobar = new Foobar(Foobar.addPercent(actualFoobar.getPrice()));

                this.getShelf().add(newFoobar);

            }

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @return the shelf
     */
    public List<Foobar> getShelf()
    {

        return this.shelf;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */

    /*
     * private void setShelf(List<Foobar> shelf) { this.shelf = shelf; }
     */

    /**
     * DOCUMENT ME!
     *
     * @return the shelf size
     */
    public int size()
    {

        return this.getShelf().size();

    }

    /**
     * DOCUMENT ME!
     *
     * @return the sum of the items in the shelf
     */
    public BigDecimal sum()
    {

        BigDecimal amount = new BigDecimal("0");

        // sum.setScale(Foobar.DECIMALS, Foobar.ROUNDING_MODE);
        final ListIterator<Foobar> iterator = this.getShelf().listIterator();

        while (iterator.hasNext())
        {

            final Foobar foobar = iterator.next();

            // System.out.println(foobar);
            // amount = new BigDecimal(mySum.toString());
            // Warning code below does not work amount.add(mySum); WHY?
            // answer : Adding a number does not change the state of the object
            // referenced by the bd reference.
            // instead a new object is returned. Hence we have to say
            amount = amount.add(foobar.getPrice());

        }

        return amount;

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

        str.append("size=").append(this.size()).append(' ');
        str.append("sum=").append(this.sum()).append(' ');
        str.append("shelf=").append(this.getShelf());

        return str.toString();

    }

}

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
package org.andromda.cartridges.gui.util.screensLib;

/**
 * DOCUMENT ME!
 *
 * @author $Author$
 * @version $Revision$
 * @since $Date$
 */
public class Item extends Field
{

    private String  legend;
    private String  label;
    private boolean hidden;
    private boolean readonly;
    private boolean mandatory;
    private boolean isLabel;

    /**
     * Creates a new Item object.
     */
    public Item()
    {
        super("item");

    }

    /**
     * Creates a new Item object.
     *
     * @param legend DOCUMENT ME!
     * @param hidden DOCUMENT ME!
     * @param readonly DOCUMENT ME!
     * @param mandatory DOCUMENT ME!
     * @param label DOCUMENT ME!
     */
    public Item(final String legend, final boolean hidden, final boolean readonly, final boolean mandatory, final String label)
    {
        super("item");
        this.legend = legend;
        this.hidden = hidden;
        this.readonly = readonly;
        this.mandatory = mandatory;
        this.label = label;

        if (this.label.equals(""))
        {

            this.isLabel = false;

        } else
        {

            this.isLabel = true;

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getLegend()
    {

        return this.legend;

    }

    /**
     * DOCUMENT ME!
     *
     * @param legend DOCUMENT ME!
     */
    public void setLegend(final String legend)
    {

        this.legend = legend;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean isHidden()
    {

        return this.hidden;

    }

    /**
     * DOCUMENT ME!
     *
     * @param hidden DOCUMENT ME!
     */
    public void setHidden(final boolean hidden)
    {

        this.hidden = hidden;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean isReadonly()
    {

        return this.readonly;

    }

    /**
     * DOCUMENT ME!
     *
     * @param readonly DOCUMENT ME!
     */
    public void setReadonly(final boolean readonly)
    {

        this.readonly = readonly;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean isMandatory()
    {

        return this.mandatory;

    }

    /**
     * DOCUMENT ME!
     *
     * @param mandatory DOCUMENT ME!
     */
    public void setMandatory(final boolean mandatory)
    {

        this.mandatory = mandatory;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getLabel()
    {

        return this.label;

    }

    /**
     * DOCUMENT ME!
     *
     * @param label DOCUMENT ME!
     */
    public void setLabel(final String label)
    {

        this.label = label;

        if (this.label.equals(""))
        {

            this.isLabel = false;

        } else
        {

            this.isLabel = true;

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean getIsLabel()
    {

        return this.isLabel;

    }

}

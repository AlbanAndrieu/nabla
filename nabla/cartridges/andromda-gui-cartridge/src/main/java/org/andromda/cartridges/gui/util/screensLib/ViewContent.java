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

import java.util.List;

/**
 * DOCUMENT ME!
 *
 * @author $Author$
 * @version $Revision$
 * @since $Date$
 */
public class ViewContent
{

    private List<Cell>  cells;
    private List<Field> fields;
    private Header      header;

    // private boolean isCells;
    /**
     * Creates a new ViewContent object.
     */
    public ViewContent()
    {

        // this.isCells = false;
        // this.isFields = false;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Header getHeader()
    {

        return this.header;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public List<Cell> getCells()
    {

        return this.cells;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public List<Field> getFields()
    {

        return this.fields;

    }

    /**
     * DOCUMENT ME!
     *
     * @param cells DOCUMENT ME!
     */
    public void setCells(final List<Cell> cells)
    {

        this.cells = cells;

        // if (cells != null && cells.size() > 0) {
        // this.isCells = true;
        // }
    }

    /**
     * DOCUMENT ME!
     *
     * @param fields DOCUMENT ME!
     */
    public void setFields(final List<Field> fields)
    {

        this.fields = fields;

        // if (fields != null && fields.size() > 0) {
        // this.isFields = true;
        // }
    }

    /**
     * DOCUMENT ME!
     *
     * @param header DOCUMENT ME!
     */
    public void setHeader(final Header header)
    {

        this.header = header;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean getIsCells()
    {

        return ((this.cells != null) && (this.cells.size() > 0));

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean getIsFields()
    {

        return ((this.fields != null) && (this.fields.size() > 0));

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean getIsHeader()
    {

        return this.header != null;

    }

}

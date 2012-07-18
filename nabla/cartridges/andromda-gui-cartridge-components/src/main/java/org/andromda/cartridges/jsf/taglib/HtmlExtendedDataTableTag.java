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
package org.andromda.cartridges.jsf.taglib;

import org.andromda.cartridges.jsf.component.html.HtmlExtendedDataTable;

import org.apache.myfaces.taglib.html.ext.HtmlDataTableTag;

import javax.faces.component.UIComponent;

/**
 * Extends dataTable to provide the ability to submit tables of data and render
 * the data back into the table using a backing value.
 *
 * @author Chad Brandon
 */
public class HtmlExtendedDataTableTag extends HtmlDataTableTag
{

    /**
     * @see javax.faces.webapp.UIComponentTag#setProperties(javax.faces.component.UIComponent)
     */
    @Override
    protected void setProperties(final UIComponent component)
    {

        super.setProperties(component);
        this.setStringProperty(component, HtmlExtendedDataTable.IDENTIFIER_COLUMNS, this.identifierColumns);
        this.setStringProperty(component, HtmlExtendedDataTable.BACKING_VALUE, this.backingValue);

    }

    /**
     * A comma separated list of the columns that uniquely identify the row for this data table.
     */
    private String identifierColumns;

    /**
     * @return Returns the identifierColumns.
     */
    public String getIdentifierColumns()
    {

        return this.identifierColumns;

    }

    /**
     * @param identifierColumnsIn The identifierColumns to set.
     */
    public void setIdentifierColumns(String identifierColumnsIn)
    {

        this.identifierColumns = identifierColumnsIn;

    }

    /**
     * The backing value for this table.
     */
    private String backingValue;

    /**
     * @return Returns the backingValue.
     */
    public String getBackingValue()
    {

        return this.backingValue;

    }

    /**
     * @param backingValueIn The backingValue to set.
     */
    public void setBackingValue(String backingValueIn)
    {

        this.backingValue = backingValueIn;

    }

    /**
     * The component type for this tag.
     */
    private static final String COMPONENT_TYPE = HtmlExtendedDataTable.class.getName();

    /**
     * @see javax.faces.webapp.UIComponentTag#getComponentType()
     */
    @Override
    public String getComponentType()
    {

        return COMPONENT_TYPE;

    }

}

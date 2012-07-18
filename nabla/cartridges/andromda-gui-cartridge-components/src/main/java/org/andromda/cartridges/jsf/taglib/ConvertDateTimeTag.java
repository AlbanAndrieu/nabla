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

import org.andromda.cartridges.jsf.converters.JSFDateTimeConverter;

import javax.el.ExpressionFactory;

import javax.faces.context.FacesContext;

import javax.servlet.jsp.PageContext;

/**
 * Extends the default myfaces convert date time tag in order to use
 * the custom date time converter {@link org.andromda.cartridges.jsf.converters.JSFDateTimeConverter}.
 *
 * @author Chad Brandon
 */
public class ConvertDateTimeTag extends org.apache.myfaces.taglib.core.ConvertDateTimeTag
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Overridden to set the converter id using out custom date time
     * converter: {@link org.andromda.cartridges.jsf.converters.JSFDateTimeConverter}.
     *
     * @see javax.servlet.jsp.tagext.Tag#setPageContext(javax.servlet.jsp.PageContext)
     */
    @Override
    public void setPageContext(PageContext context)
    {

        super.setPageContext(context);

        ExpressionFactory expressionFactory = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();

        setConverterId(expressionFactory.createValueExpression(context.getELContext(), JSFDateTimeConverter.CONVERTER_ID, String.class));

    }

}

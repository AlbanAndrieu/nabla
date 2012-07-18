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
package org.andromda.cartridges.gui.metafacades;

import org.andromda.cartridges.gui.GuiGlobals;

import org.andromda.utils.StringUtilsHelper;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiEnumeration.
 *
 * @see org.andromda.cartridges.gui.metafacades.GuiEnumeration
 */
public class GuiEnumerationLogicImpl extends GuiEnumerationLogic
{

    private static final long serialVersionUID = 34L;

    /**
     * @param metaObject
     * @param context
     */
    public GuiEnumerationLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * @return converterName
     * @see org.andromda.cartridges.gui.metafacades.GuiEnumeration#getConverterName()
     */
    @Override
    protected String handleGetConverterName()
    {

        return StringUtils.replace(ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.CONVERTER_PATTERN)), "{0}", this.getName());

    }

    /**
     * @return getPackageName() + "." + getConverterName()
     * @see org.andromda.cartridges.gui.metafacades.GuiEnumeration#getFullyQualifiedConverterName()
     */
    @Override
    protected String handleGetFullyQualifiedConverterName()
    {

        return this.getPackageName() + "." + this.getConverterName();

    }

    /**
     * @return getFullyQualifiedConverterName().replace(".", GuiGlobals.SEPARATOR)
     * @see org.andromda.cartridges.gui.metafacades.GuiEnumeration#getConverterPath()
     */
    @Override
    protected String handleGetConverterPath()
    {

        return this.getFullyQualifiedConverterName().replace(".", GuiGlobals.SEPARATOR);

    }

    /**
     * @return StringUtilsHelper.toResourceMessageKey(getName())
     * @see org.andromda.cartridges.gui.metafacades.GuiEnumeration#getMessageKey()
     */
    @Override
    protected String handleGetMessageKey()
    {

        return StringUtilsHelper.toResourceMessageKey(this.getName());

    }

}

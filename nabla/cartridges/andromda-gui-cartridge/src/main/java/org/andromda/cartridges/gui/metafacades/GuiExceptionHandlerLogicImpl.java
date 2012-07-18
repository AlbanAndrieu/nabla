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

import org.andromda.cartridges.gui.GuiProfile;

import org.andromda.metafacades.uml.StateVertexFacade;
import org.andromda.metafacades.uml.UseCaseFacade;

import org.andromda.utils.StringUtilsHelper;

/**
 *
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiExceptionHandler.
 *
 * @see org.andromda.cartridges.gui.metafacades.GuiExceptionHandler
 */
public class GuiExceptionHandlerLogicImpl extends GuiExceptionHandlerLogic
{

    private static final long serialVersionUID = 34L;

    /**
     * Public constructor for GuiExceptionHandlerLogicImpl
     * @param metaObject
     * @param context
     * @see org.andromda.cartridges.gui.metafacades.GuiExceptionHandler
     */
    public GuiExceptionHandlerLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * <p>
     * The key to use with this handler's message resource bundle that
     * will retrieve the error message template for this exception.
     * </p>
     * @return exceptionKey
     * @see org.andromda.cartridges.gui.metafacades.GuiExceptionHandler#getExceptionKey()
     */
    @Override
    protected String handleGetExceptionKey()
    {

        final String type = this.getExceptionType();
        final int dotIndex = type.lastIndexOf(".");

        // the dot may not be the last character
        return StringUtilsHelper.toResourceMessageKey((dotIndex < (type.length() - 1)) ? type.substring(dotIndex + 1) : type);

    }

    /**
     * <p>
     * The module-relative URI to the resource that will complete the
     * request/response if this exception occurs.
     * </p>
     * @return exceptionPath
     * @see org.andromda.cartridges.gui.metafacades.GuiExceptionHandler#getExceptionPath()
     */
    @Override
    protected String handleGetExceptionPath()
    {

        final StateVertexFacade target = this.getTarget();

        if (target instanceof GuiForward)
        {

            return (target).getFullyQualifiedNamePath() + ".gui";

        } else if (target instanceof GuiFinalState)
        {

            return ((GuiFinalState) target).getFullyQualifiedNamePath();

        } else
        {

            return "";

        }

    }

    /**
     * <p>
     * Fully qualified Java class name of the exception type to
     * register with this handler.
     * </p>
     * @return exceptionType
     * @see org.andromda.cartridges.gui.metafacades.GuiExceptionHandler#getExceptionType()
     */
    @Override
    protected String handleGetExceptionType()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_EXCEPTION_TYPE);

        return (value == null) ? "" : value.toString();

    }

    /**
     *
     * @return messageKey
     * @see org.andromda.cartridges.gui.metafacades.GuiExceptionHandler#getMessageKey()
     */
    @Override
    protected String handleGetMessageKey()
    {

        final UseCaseFacade useCase = this.getUseCase();

        return (useCase != null) ? StringUtilsHelper.toResourceMessageKey(useCase.getName()) : null;

    }

}

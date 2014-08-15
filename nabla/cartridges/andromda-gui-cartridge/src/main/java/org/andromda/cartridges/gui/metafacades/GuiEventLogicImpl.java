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

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiEvent.
 * 
 * @see org.andromda.cartridges.gui.metafacades.GuiEvent
 */
public class GuiEventLogicImpl extends GuiEventLogic
{

    private static final long serialVersionUID = 34L;

    /**
     * @param metaObject
     * @param context
     */
    public GuiEventLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * @return triggerKey
     * @see org.andromda.cartridges.gui.metafacades.GuiEvent#getMessageKey()
     */
    @Override
    protected String handleGetMessageKey()
    {

        String triggerKey = StringUtilsHelper.toResourceMessageKey(this.getName());

        if (!this.isNormalizeMessages())
        {

            final GuiAction action = (GuiAction) this.getAction();

            if (action != null)
            {

                final GuiView view = (GuiView) action.getInput();

                if (view != null)
                {

                    triggerKey = view.getMessageKey() + "." + triggerKey;

                }

            }

        }

        return triggerKey;

    }

    /**
     * @return StringUtilsHelper.toPhrase(this.getName())
     * @see org.andromda.cartridges.gui.metafacades.GuiEvent#getMessageValue()
     */
    @Override
    protected String handleGetMessageValue()
    {

        return StringUtilsHelper.toPhrase(this.getName());

    }

    /**
     * @return "Reset"
     * @see org.andromda.cartridges.gui.metafacades.GuiEvent#getResetMessageValue()
     */
    @Override
    protected String handleGetResetMessageValue()
    {

        return "Reset";

    }

    /**
     * @return getMessageKey() + ".reset.message"
     * @see org.andromda.cartridges.gui.metafacades.GuiEvent#getResetMessageKey()
     */
    @Override
    protected String handleGetResetMessageKey()
    {

        return this.getMessageKey() + ".reset.message";

    }

    /**
     * Indicates whether or not we should normalize messages.
     * 
     * @return normalizeMessages true/false
     */
    private boolean isNormalizeMessages()
    {

        final String normalizeMessages = (String) this.getConfiguredProperty(GuiGlobals.NORMALIZE_MESSAGES);

        return Boolean.valueOf(normalizeMessages).booleanValue();

    }

}

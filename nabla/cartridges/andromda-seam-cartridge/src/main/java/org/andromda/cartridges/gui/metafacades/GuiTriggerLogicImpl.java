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

import org.andromda.metafacades.uml.TransitionFacade;

import org.andromda.utils.StringUtilsHelper;

/**
 * A Gui trigger is represented by clicking a hyperlink or posting an action form.
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiTrigger.
 *
 * @see org.andromda.cartridges.gui.metafacades.GuiTrigger
 */
public class GuiTriggerLogicImpl extends GuiTriggerLogic
{

    private static final long serialVersionUID = 34L;

    /**
     * Public constructor for GuiTriggerLogicImpl
     * @see org.andromda.cartridges.gui.metafacades.GuiTrigger
     */
    public GuiTriggerLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * @return getTitleKey() + ".notallowed"
     * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#getNotAllowedTitleKey()
     */
    @Override
    protected String handleGetNotAllowedTitleKey()
    {

        return this.getTitleKey() + ".notallowed";

    }

    /**
     * @return getTriggerKey() + ".title"
     * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#getTitleKey()
     */
    @Override
    protected String handleGetTitleKey()
    {

        return this.getTriggerKey() + ".title";

    }

    /**
     * @return getTitleKey() + ".reset"
     * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#getResetTitleKey()
     */
    @Override
    protected String handleGetResetTitleKey()
    {

        return this.getTitleKey() + ".reset";

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiTriggerLogic#handleGetResetMessageKey()
     */
    @Override
    protected String handleGetResetMessageKey()
    {

        return this.getResetTitleKey() + ".message";

    }

    /**
     * @return getResetTitleKey() + ".not.allowed"
     * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#getResetNotAllowedTitleKey()
     */
    @Override
    protected String handleGetResetNotAllowedTitleKey()
    {

        return this.getResetTitleKey() + ".not.allowed";

    }

    /**
     * @return triggerKey
     * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#getTriggerKey()
     */
    @Override
    protected String handleGetTriggerKey()
    {

        String triggerKey = StringUtilsHelper.toResourceMessageKey(this.getName());

        if (!this.normalizeMessages())
        {

            final GuiAction action = this.getGuiAction();

            if (action != null)
            {

                final GuiView page = (GuiView) action.getInput();

                if (page != null)
                {

                    triggerKey = page.getMessageKey() + '.' + triggerKey;

                }

            }

        }

        return triggerKey;

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiTriggerLogic#handleGetTriggerValue()
     */
    @Override
    protected String handleGetTriggerValue()
    {

        return StringUtilsHelper.toPhrase(this.getName());

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiTriggerLogic#handleGetTitleValue()
     */
    @Override
    protected String handleGetTitleValue()
    {

        return this.getTriggerValue();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiTriggerLogic#handleGetResetTitleValue()
     */
    @Override
    protected String handleGetResetTitleValue()
    {

        return "Reset";

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiTriggerLogic#handleGetResetMessageValue()
     */
    @Override
    protected String handleGetResetMessageValue()
    {

        return "Reset";

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiTriggerLogic#handleGetResetNotAllowedTitleValue()
     */
    @Override
    protected String handleGetResetNotAllowedTitleValue()
    {

        return "You are not allowed to reset";

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiTriggerLogic#handleGetNotAllowedTitleValue()
     */
    @Override
    protected String handleGetNotAllowedTitleValue()
    {

        return "You are not allowed to call this action";

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiTriggerLogic#handleIsActionTrigger()
     */
    @Override
    protected boolean handleIsActionTrigger()
    {

        return this.getGuiAction() != null;

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiTriggerLogic#handleGetGuiAction()
     */
    @Override
    protected Object handleGetGuiAction()
    {

        GuiAction triggerAction = null;

        final TransitionFacade transition = this.getTransition();

        if (transition instanceof GuiAction)
        {

            triggerAction = (GuiAction) transition;

        }

        return triggerAction;

    }

    private boolean normalizeMessages()
    {

        final String normalizeMessages = (String) this.getConfiguredProperty(GuiGlobals.NORMALIZE_MESSAGES);

        return Boolean.valueOf(normalizeMessages).booleanValue();

    }

}

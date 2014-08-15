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
import org.andromda.cartridges.gui.GuiProfile;
import org.andromda.cartridges.gui.GuiUtils;

import org.andromda.metafacades.uml.EventFacade;
import org.andromda.metafacades.uml.GuardFacade;
import org.andromda.metafacades.uml.StateVertexFacade;

import org.andromda.utils.StringUtilsHelper;

import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiForward.
 * 
 * @see org.andromda.cartridges.gui.metafacades.GuiForward
 */
public class GuiForwardLogicImpl extends GuiForwardLogic
{

    private static final long serialVersionUID = 34L;
    private final Logger      logger_          = Logger.getLogger(GuiForwardLogicImpl.class);

    /**
     * @param metaObject
     * @param context
     */
    public GuiForwardLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * @see org.andromda.metafacades.uml.ModelElementFacade#getName()
     */
    @Override
    public String getName()
    {

        final StringBuilder name = new StringBuilder(super.getName());
        final Object target = this.getTarget();

        if (this.logger_.isDebugEnabled())
        {

            this.logger_.debug("getName is : " + name + " - " + target + " for : " + this.getFullyQualifiedName());

        }

        if (target instanceof GuiFinalState)
        {

            name.append(GuiGlobals.USECASE_FORWARD_NAME_SUFFIX);

        } else
        {

            name.insert(0, this.getUseCase().getName() + "-");

        }

        return GuiUtils.toWebResourceName(name.toString());

    }

    /**
     * @return forwardPath
     * @see org.andromda.cartridges.gui.metafacades.GuiForward#getPath()
     */
    @Override
    protected String handleGetPath()
    {

        String forwardPath = null;
        final StateVertexFacade target = this.getTarget();

        if (this.isEnteringView())
        {

            forwardPath = ((GuiView) target).getPath();

        } else if (this.isEnteringFinalState())
        {

            forwardPath = ((GuiFinalState) target).getPath();

        }

        return forwardPath;

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiForwardLogic#handleIsSuccessMessagesPresent()
     */
    @Override
    protected boolean handleIsSuccessMessagesPresent()
    {

        return !this.getSuccessMessages().isEmpty();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiForwardLogic#handleIsWarningMessagesPresent()
     */
    @Override
    protected boolean handleIsWarningMessagesPresent()
    {

        return !this.getWarningMessages().isEmpty();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiForwardLogic#handleIsErrorMessagesPresent()
     */
    @Override
    protected boolean handleIsErrorMessagesPresent()
    {

        return !this.getErrorMessages().isEmpty();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiForwardLogic#handleGetSuccessMessages()
     */
    @Override
    protected Map handleGetSuccessMessages()
    {

        return this.getMessages(GuiProfile.TAGGEDVALUE_ACTION_SUCCESS_MESSAGE);

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiForwardLogic#handleGetWarningMessages()
     */
    @Override
    protected Map handleGetWarningMessages()
    {

        return this.getMessages(GuiProfile.TAGGEDVALUE_ACTION_WARNING_MESSAGE);

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiForwardLogic#handleGetErrorMessages()
     */
    @Override
    protected Map handleGetErrorMessages()
    {

        return this.getMessages(GuiProfile.TAGGEDVALUE_ACTION_ERROR_MESSAGE);

    }

    /**
     * @return getTarget() instanceof GuiFinalState
     * @see org.andromda.cartridges.gui.metafacades.GuiForward#isFinalStateTarget()
     */
    @Override
    protected boolean handleIsFinalStateTarget()
    {

        return this.getTarget() instanceof GuiFinalState;

    }

    /**
     * @return getName()
     * @see org.andromda.cartridges.gui.metafacades.GuiForward#getFromOutcome()
     */
    @Override
    protected String handleGetFromOutcome()
    {

        return this.getName();

    }

    /**
     * Collects specific messages in a map.
     * 
     * @param taggedValue the tagged value from which to read the message
     * @return maps message keys to message values, but only those that match the arguments
     * will have been recorded
     */
    @SuppressWarnings("unchecked")
    private Map<String, String> getMessages(final String taggedValue)
    {

        Map<String, String> messages;

        final Collection taggedValues = this.findTaggedValues(taggedValue);

        if (taggedValues.isEmpty())
        {

            messages = Collections.EMPTY_MAP;

        } else
        {

            messages = new LinkedHashMap<String, String>(); // we want to keep the order

            for (final Iterator iterator = taggedValues.iterator(); iterator.hasNext();)
            {

                final String value = (String) iterator.next();

                messages.put(StringUtilsHelper.toResourceMessageKey(value), value);

            }

        }

        return messages;

    }

    /**
     * If this forward has a trigger this method returns that trigger's name, otherwise if this forward
     * has a name this method returns that name, otherwise if this forward's target has a name this
     * method returns that name, otherwise simply returns <code>"unknown"</code>
     */
    private String resolveName()
    {

        String forwardName = null;

        // trigger
        final EventFacade trigger = this.getTrigger();

        if (trigger != null)
        {

            forwardName = trigger.getName();

        }

        // name
        if (forwardName == null)
        {

            forwardName = this.getName();

        }

        // target
        if (forwardName == null)
        {

            forwardName = this.getTarget().getName();

        }

        // else
        if (forwardName == null)
        {

            forwardName = "unknown";

        }

        // return
        return forwardName;

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiForwardLogic#handleGetForwardName()
     */
    @Override
    protected String handleGetForwardName()
    {

        return StringUtilsHelper.toResourceMessageKey(this.resolveName());

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiForwardLogic#handleGetForwardPath()
     */
    @Override
    protected String handleGetForwardPath()
    {

        String forwardPath = null;

        final StateVertexFacade target = this.getTarget();

        if (this.isEnteringPage())
        {

            forwardPath = ((GuiView) target).getFullPath() + ".jsp";

        } else if (this.isEnteringFinalState())
        {

            forwardPath = ((GuiFinalState) target).getFullPath();

        }

        return forwardPath;

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiForwardLogic#handleGetGuardName()
     */
    @Override
    protected String handleGetGuardName()
    {

        final GuardFacade guard = this.getGuard();

        return (guard == null) ? null : guard.getName();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiForwardLogic#handleIsEnteringPage()
     */
    @Override
    protected boolean handleIsEnteringPage()
    {

        return this.isEnteringView();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiForwardLogic#handleGetTargetNameKey()
     */
    @Override
    protected String handleGetTargetNameKey()
    {

        if (this.isEnteringPage())
        {

            return ((GuiView) this.getTarget()).getTitleKey();

        } else if (this.isEnteringFinalState())
        {

            return ((GuiUseCase) ((GuiFinalState) this.getTarget()).getTargetUseCase()).getTitleKey();

        }

        return null;

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiForwardLogic#handleIsExitingPage()
     */
    @Override
    protected boolean handleIsExitingPage()
    {

        return this.isExitingView();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiForwardLogic#handleGetGuiActivityGraph()
     */
    @Override
    protected Object handleGetGuiActivityGraph()
    {

        return this.getFrontEndActivityGraph();

    }

}

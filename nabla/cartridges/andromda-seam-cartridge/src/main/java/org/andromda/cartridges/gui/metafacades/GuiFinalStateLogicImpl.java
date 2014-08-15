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

import org.andromda.metafacades.uml.FrontEndAction;
import org.andromda.metafacades.uml.FrontEndUseCase;
import org.andromda.metafacades.uml.TransitionFacade;
import org.andromda.metafacades.uml.UMLProfile;
import org.andromda.metafacades.uml.UseCaseFacade;

import org.apache.commons.lang.StringUtils;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiFinalState.
 * 
 * @see org.andromda.cartridges.gui.metafacades.GuiFinalState
 */
public class GuiFinalStateLogicImpl extends GuiFinalStateLogic
{

    private static final long serialVersionUID = 34L;
    private final Logger      logger_          = Logger.getLogger(GuiFinalStateLogicImpl.class);

    /**
     * @param metaObject
     * @param context
     */
    public GuiFinalStateLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * @return fullPath
     * @see org.andromda.cartridges.gui.metafacades.GuiFinalState#getPath()
     */
    @Override
    protected String handleGetPath()
    {

        String fullPath = null;

        final FrontEndUseCase useCase = this.getTargetUseCase();

        if (useCase == null)
        {

            // - perhaps this final state links outside of the UML model
            final Object taggedValue = this.findTaggedValue(UMLProfile.TAGGEDVALUE_EXTERNAL_HYPERLINK);

            if (taggedValue == null)
            {

                final String name = this.getName();

                if ((name != null) && (name.startsWith(GuiGlobals.SEPARATOR) || name.startsWith("http://") || name.startsWith("file:")))
                {

                    fullPath = name;

                }

            } else
            {

                fullPath = String.valueOf(taggedValue);

            }

        } else if (useCase instanceof GuiUseCase)
        {

            fullPath = ((GuiUseCase) useCase).getPath();

            // fullPath = ((GuiUseCase) useCase).getActionPath() + ".do";
        }

        return fullPath;

    }

    @Override
    protected java.lang.String handleGetFullPath()
    {

        return this.handleGetPath();

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    @Override
    public String getName()
    {

        String name = super.getName();

        if (this.logger_.isDebugEnabled())
        {

            this.logger_.debug("getName is : " + name + " for : " + this.getFullyQualifiedName());

        }

        if ((name == null) || name.isEmpty())
        {

            final UseCaseFacade useCase = this.getTargetUseCase();

            if (useCase != null)
            {

                name = useCase.getName();

            }

        }

        return name;

    }

    /**
     * Overridden for now (@todo need to figure out why it doesn't work correctly when using
     * the one from the FrontEndFinalState).
     * 
     * @see org.andromda.metafacades.uml.FrontEndFinalState#getTargetUseCase()
     */
    @Override
    public FrontEndUseCase getTargetUseCase()
    {

        FrontEndUseCase targetUseCase = null;

        // first check if there is a hyperlink from this final state to a use-case
        // this works at least in MagicDraw
        final Object taggedValue = this.findTaggedValue(UMLProfile.TAGGEDVALUE_MODEL_HYPERLINK);

        if (taggedValue != null)
        {

            this.logger_.debug("getTargetUseCase taggedValue is : " + taggedValue + "-" + taggedValue.getClass() + " for : " + this.getFullyQualifiedName());

            final UseCaseFacade useCase = this.getModel().findUseCaseByName(String.valueOf(taggedValue));

            this.logger_.debug("getTargetUseCase useCase is : " + useCase + " for : " + this.getFullyQualifiedName());

            if (useCase instanceof GuiActivityGraph)
            {

                targetUseCase = (FrontEndUseCase) ((GuiActivityGraph) useCase).getUseCase();

            } else if (useCase instanceof GuiUseCase)
            {

                targetUseCase = (FrontEndUseCase) useCase;

            }

        } else
        // maybe the name points to a use-case ?
        {

            final String name = super.getName();

            this.logger_.debug("getTargetUseCase is : " + name + " for : " + this.getFullyQualifiedName());

            if (StringUtils.isNotBlank(name))
            {

                final UseCaseFacade useCase = this.getModel().findUseCaseByName(name);

                if (useCase instanceof FrontEndUseCase)
                {

                    targetUseCase = (FrontEndUseCase) useCase;

                }

            }

        }

        return targetUseCase;

    }

    @Override
    protected List<FrontEndAction> handleGetActions()
    {

        final Set<FrontEndAction> actions = new LinkedHashSet<FrontEndAction>();
        final Collection<TransitionFacade> incoming = this.getIncomings();

        for (final TransitionFacade transitionFacade : incoming)
        {

            final GuiForward forward = (GuiForward) transitionFacade;

            actions.addAll(forward.getActions());

        }

        return new ArrayList<FrontEndAction>(actions);

    }

}

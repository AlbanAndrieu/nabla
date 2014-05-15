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

import org.andromda.metafacades.uml.ActivityGraphFacade;
import org.andromda.metafacades.uml.FrontEndForward;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.UseCaseFacade;

import org.andromda.utils.StringUtilsHelper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Encapsulates a pseudostate and provides specific Gui services. This pseudostate can be a
 * decision point, junction or initial state.
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiPseudostate.
 *
 * @see org.andromda.cartridges.gui.metafacades.GuiPseudostate
 */
public class GuiPseudostateLogicImpl extends GuiPseudostateLogic
{

    private static final long serialVersionUID = 34L;

    /**
     * Public constructor for GuiPseudostateLogicImpl
     * @see org.andromda.cartridges.gui.metafacades.GuiPseudostate
     */
    public GuiPseudostateLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * @return getStateMachine() instanceof GuiActivityGraph
     */
    protected boolean handleIsContainedInFrontEndUseCase()
    {

        return this.getStateMachine() instanceof GuiActivityGraph;

    }

    /**
     * @return actionMethodName
     * @see org.andromda.cartridges.gui.metafacades.GuiPseudostate#getActionMethodName()
     */
    @Override
    protected String handleGetActionMethodName()
    {

        final String methodName = this.getName();

        return (methodName == null) ? ("a" + System.currentTimeMillis()) : StringUtilsHelper.lowerCamelCaseName(methodName);

    }

    /**
     * Overridden and not typesafe since GuiAction does not extend FrontEndAction
     *
     * @see org.andromda.metafacades.uml.FrontEndPseudostate#getContainerActions()
     */
    @Override
    public List getContainerActions()
    {

        final Set<GuiAction> actionSet = new LinkedHashSet<GuiAction>();
        final StateMachineFacade graphContext = this.getStateMachine();

        if (graphContext instanceof ActivityGraphFacade)
        {

            final UseCaseFacade useCase = ((ActivityGraphFacade) graphContext).getUseCase();

            if (useCase instanceof GuiUseCase)
            {

                // GuiUseCase.getActions returns GuiAction which cannot be cast to FrontEndAction
                for (final Object action : ((GuiUseCaseLogicImpl) useCase).getActions())
                {

                    for (final FrontEndForward transition : ((GuiAction) action).getTransitions())
                    {

                        if (this.equals(transition.getTarget()))
                        {

                            actionSet.add((GuiAction) action);

                        }

                    }

                }

            }

        }

        // Cannot make return type List<GuiAction> because GuiAction does not extend FrontEndAction
        return new ArrayList<GuiAction>(actionSet);

    }

}

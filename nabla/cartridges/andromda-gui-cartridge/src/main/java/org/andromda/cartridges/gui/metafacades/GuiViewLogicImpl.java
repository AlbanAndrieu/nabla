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

import org.andromda.metafacades.uml.ActivityGraphFacade;
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.FrontEndAction;
import org.andromda.metafacades.uml.FrontEndForward;
import org.andromda.metafacades.uml.FrontEndParameter;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StateVertexFacade;
import org.andromda.metafacades.uml.TransitionFacade;
import org.andromda.metafacades.uml.UseCaseFacade;

import org.andromda.utils.StringUtilsHelper;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiView.
 * 
 * @see org.andromda.cartridges.gui.metafacades.GuiView
 */
public class GuiViewLogicImpl extends GuiViewLogic
{

    private static final long serialVersionUID = 34L;

    /**
     * @param metaObject
     * @param context
     */
    public GuiViewLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * @return getMessageKey() + "." + GuiGlobals.DOCUMENTATION_MESSAGE_KEY_SUFFIX
     * @see org.andromda.cartridges.gui.metafacades.GuiView#getDocumentationKey()
     */
    @Override
    protected String handleGetDocumentationKey()
    {

        return this.getMessageKey() + "." + GuiGlobals.DOCUMENTATION_MESSAGE_KEY_SUFFIX;

    }

    /**
     * @return messageKey
     * @see org.andromda.cartridges.gui.metafacades.GuiView#getMessageKey()
     */
    @Override
    protected String handleGetMessageKey()
    {

        final StringBuilder messageKey = new StringBuilder();

        if (!this.isNormalizeMessages())
        {

            final UseCaseFacade useCase = this.getUseCase();

            if (useCase != null)
            {

                messageKey.append(StringUtilsHelper.toResourceMessageKey(useCase.getName()));
                messageKey.append(".");

            }

        }

        messageKey.append(StringUtilsHelper.toResourceMessageKey(this.getName()));

        return messageKey.toString();

    }

    /**
     * Indicates whether or not we should normalize messages.
     * 
     * @return true/false
     */
    private boolean isNormalizeMessages()
    {

        final String normalizeMessages = (String) this.getConfiguredProperty(GuiGlobals.NORMALIZE_MESSAGES);

        return Boolean.valueOf(normalizeMessages).booleanValue();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiViewLogic#handleGetMessageValue()
     */
    @Override
    protected String handleGetMessageValue()
    {

        return StringUtilsHelper.toPhrase(this.getName());

    }

    /**
     * @return documentationValue
     * @see org.andromda.cartridges.gui.metafacades.GuiView#getDocumentationValue()
     */
    @Override
    protected String handleGetDocumentationValue()
    {

        final String value = StringUtilsHelper.toResourceMessage(this.getDocumentation(""));

        return (value == null) ? "" : value;

    }

    /**
     * @return getMessageKey() + "." + GuiGlobals.TITLE_MESSAGE_KEY_SUFFIX
     * @see org.andromda.cartridges.gui.metafacades.GuiView#getTitleKey()
     */
    @Override
    protected String handleGetTitleKey()
    {

        return this.getMessageKey() + "." + GuiGlobals.TITLE_MESSAGE_KEY_SUFFIX;

    }

    /**
     * @return toPhrase(getName())
     * @see org.andromda.cartridges.gui.metafacades.GuiView#getTitleValue()
     */
    @Override
    protected String handleGetTitleValue()
    {

        return StringUtilsHelper.toPhrase(this.getName());

    }

    /**
     * @return path
     * @see org.andromda.cartridges.gui.metafacades.GuiView#getPath()
     */
    @Override
    protected String handleGetPath()
    {

        final StringBuilder path = new StringBuilder();
        final String packageName = this.getPackageName();

        if (StringUtils.isNotBlank(packageName))
        {

            path.append(packageName + ".");

        }

        path.append(GuiUtils.toWebResourceName(StringUtils.trimToEmpty(this.getName())).replace(".", GuiGlobals.SEPARATOR));

        return GuiGlobals.SEPARATOR + path.toString().replace(".", GuiGlobals.SEPARATOR);

    }

    /**
     * @return forwards
     * @see org.andromda.cartridges.gui.metafacades.GuiView#getForwards()
     */
    @Override
    protected List<ModelElementFacade> handleGetForwards()
    {

        final Map<String, ModelElementFacade> forwards = new LinkedHashMap<String, ModelElementFacade>();

        for (final FrontEndAction action : this.getActions())
        {

            if ((action != null) && !action.isUseCaseStart())
            {

                for (final FrontEndForward forward : action.getActionForwards())
                {

                    if (forward instanceof GuiForward)
                    {

                        forwards.put(((GuiForward) forward).getName(), forward);

                    } else if (forward instanceof GuiAction)
                    {

                        forwards.put(((GuiAction) forward).getName(), forward);

                    }

                }

            }

        }

        return new ArrayList<ModelElementFacade>(forwards.values());

    }

    /**
     * @return tables
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#isTableLink()
     */
    protected List<GuiParameter> handleGetTables()
    {

        final List<GuiParameter> tables = new ArrayList<GuiParameter>();
        final List<FrontEndParameter> variables = this.getVariables();

        for (final FrontEndParameter parameter : variables)
        {

            if (parameter instanceof GuiParameter)
            {

                final GuiParameter variable = (GuiParameter) parameter;

                if (variable.isTable())
                {

                    tables.add(variable);

                }

            }

        }

        return tables;

    }

    /**
     * @return actionForwards
     * @see org.andromda.cartridges.gui.metafacades.GuiViewLogic#getActionForwards()
     */
    @Override
    protected List<GuiAction> handleGetActionForwards()
    {

        final List<GuiAction> action = new ArrayList<GuiAction>();
        final List<ModelElementFacade> actionForwards = new ArrayList<ModelElementFacade>(this.getForwards());

        for (final Iterator<ModelElementFacade> iterator = actionForwards.iterator(); iterator.hasNext();)
        {

            final Object actionForward = iterator.next();

            if (!(actionForward instanceof GuiAction))
            {

                iterator.remove();

            } else
            {

                action.add((GuiAction) actionForward);

            }

        }

        // TODO
        return action;

    }

    /**
     * @return populatorName
     * @see org.andromda.cartridges.gui.metafacades.GuiViewLogic#getFullyQualifiedPopulator()
     */
    @Override
    protected String handleGetFullyQualifiedPopulator()
    {

        final StringBuilder name = new StringBuilder();
        final String packageName = this.getPackageName();

        if (StringUtils.isNotBlank(packageName))
        {

            name.append(packageName);
            name.append(".");

        }

        name.append(this.getPopulator());

        return name.toString();

    }

    /**
     * @return populator
     * @see org.andromda.cartridges.gui.metafacades.GuiViewLogic#getPopulator()
     */
    @Override
    protected String handleGetPopulator()
    {

        return ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.VIEW_POPULATOR_PATTERN)).replaceAll("\\{0\\}", StringUtilsHelper.upperCamelCaseName(this.getName()));

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiViewLogic#handleGetFormActions()
     */
    @Override
    protected List<GuiAction> handleGetFormActions()
    {

        final List<GuiAction> formAction = new ArrayList<GuiAction>();
        final List<FrontEndAction> actions = new ArrayList<FrontEndAction>(this.getActions());

        for (final Iterator<FrontEndAction> iterator = actions.iterator(); iterator.hasNext();)
        {

            final FrontEndAction action = iterator.next();

            if (action.getFormFields().isEmpty())
            {

                iterator.remove();

            } else
            {

                formAction.add((GuiAction) action);

            }

        }

        // TODO
        return formAction;

    }

    /**
     * @return formKey
     * @see org.andromda.cartridges.gui.metafacades.GuiView#getFormKey()
     */
    @Override
    protected String handleGetFormKey()
    {

        final Object formKeyValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_ACTION_FORM_KEY);

        return (formKeyValue == null) ? ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.ACTION_FORM_KEY)) : String.valueOf(formKeyValue);

    }

    /**
     * @return getFullyQualifiedPopulator().replace(".", GuiGlobals.SEPARATOR)
     * @see org.andromda.cartridges.gui.metafacades.GuiView#getPopulatorPath()
     */
    @Override
    protected String handleGetPopulatorPath()
    {

        return this.getFullyQualifiedPopulator().replace(".", GuiGlobals.SEPARATOR);

    }

    /**
     * @return !getFormActions().isEmpty() || !getVariables().isEmpty()
     * @see org.andromda.cartridges.gui.metafacades.GuiView#isPopulatorRequired()
     */
    @Override
    protected boolean handleIsPopulatorRequired()
    {

        return !this.getFormActions().isEmpty() || !this.getVariables().isEmpty();

    }

    /**
     * @return validationRequired
     * @see org.andromda.cartridges.gui.metafacades.GuiView#isPopulatorRequired()
     */
    @Override
    protected boolean handleIsValidationRequired()
    {

        boolean required = false;

        for (final FrontEndAction action : this.getActions())
        {

            if (((GuiAction) action).isValidationRequired())
            {

                required = true;

                break;

            }

        }

        return required;

    }

    /**
     * @return isPopup
     * @see org.andromda.cartridges.gui.metafacades.GuiView#isPopup()
     */
    @Override
    protected boolean handleIsPopup()
    {

        return ObjectUtils.toString(this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_TYPE)).equalsIgnoreCase(GuiGlobals.VIEW_TYPE_POPUP);

    }

    /**
     * @return nonTableVariablesPresent
     * @see org.andromda.cartridges.gui.metafacades.GuiView#isNonTableVariablesPresent()
     */
    @Override
    protected boolean handleIsNonTableVariablesPresent()
    {

        boolean present = false;

        for (final FrontEndParameter variable : this.getVariables())
        {

            if (!variable.isTable())
            {

                present = true;

                break;

            }

        }

        return present;

    }

    /**
     * @return hasNameOfUseCase
     * @see org.andromda.cartridges.gui.metafacades.GuiView#isHasNameOfUseCase()
     */
    @Override
    protected boolean handleIsHasNameOfUseCase()
    {

        boolean sameName = false;
        final ModelElementFacade useCase = this.getUseCase();
        final String useCaseName = (useCase != null) ? useCase.getName() : null;

        if ((useCaseName != null) && useCaseName.equalsIgnoreCase(this.getName()))
        {

            sameName = true;

        }

        return sameName;

    }

    /**
     * @return backingValueVariables
     * @see org.andromda.cartridges.gui.metafacades.GuiView#getBackingValueVariables()
     */
    @Override
    protected List<GuiParameter> handleGetBackingValueVariables()
    {

        final Map<String, GuiParameter> variables = new LinkedHashMap<String, GuiParameter>();

        for (final FrontEndParameter frontEndParameter : this.getAllActionParameters())
        {

            if (frontEndParameter instanceof GuiParameter)
            {

                final GuiParameter parameter = (GuiParameter) frontEndParameter;
                final String parameterName = parameter.getName();
                final Collection<AttributeFacade> attributes = parameter.getAttributes();

                if (parameter.isBackingValueRequired() || parameter.isSelectable())
                {

                    if (parameter.isBackingValueRequired() || parameter.isSelectable())
                    {

                        variables.put(parameterName, parameter);

                    }

                } else
                {

                    boolean hasBackingValue = false;

                    for (final AttributeFacade attribute : attributes)
                    {

                        final GuiAttribute jsfAttribute = (GuiAttribute) attribute;

                        if (jsfAttribute.isSelectable(parameter) || jsfAttribute.isBackingValueRequired(parameter))
                        {

                            hasBackingValue = true;

                            break;

                        }

                    }

                    if (hasBackingValue)
                    {

                        variables.put(parameterName, parameter);

                    }

                }

            }

        }

        return new ArrayList<GuiParameter>(variables.values());

    }

    /**
     * @return toWebResourceName(this.getUseCase().getName() + "-" + this.getName())
     * @see org.andromda.cartridges.gui.metafacades.GuiView#getFromOutcome()
     */
    @Override
    protected String handleGetFromOutcome()
    {

        return GuiUtils.toWebResourceName(this.getUseCase().getName() + "-" + this.getName());

    }

    /**
     * @return needsFileUpload
     * @see org.andromda.cartridges.gui.metafacades.GuiView#isNeedsFileUpload()
     */
    @Override
    protected boolean handleIsNeedsFileUpload()
    {

        if (this.getAllActionParameters().size() == 0)
        {

            return false;

        }

        for (final FrontEndParameter feParameter : this.getAllActionParameters())
        {

            if (feParameter instanceof GuiParameter)
            {

                final GuiParameter parameter = (GuiParameter) feParameter;

                if (parameter.isInputFile())
                {

                    return true;

                }

                if (parameter.isComplex())
                {

                    for (final Iterator<AttributeFacade> attributes = parameter.getAttributes().iterator(); attributes.hasNext();)
                    {

                        if (((GuiAttribute) attributes.next()).isInputFile())
                        {

                            return true;

                        }

                    }

                }

            }

        }

        return false;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    @Override
    public String getPackageName()
    {

        String packageName = null;

        final StateMachineFacade graphContext = this.getStateMachine();

        if (graphContext instanceof ActivityGraphFacade)
        {

            final UseCaseFacade graphUseCase = ((ActivityGraphFacade) graphContext).getUseCase();

            if (graphUseCase instanceof GuiUseCase)
            {

                final GuiUseCase useCase = (GuiUseCase) graphUseCase;

                packageName = useCase.getPackageName();

            }

        }

        return packageName;

    }

    // TODO REMOVE
    @Override
    protected String handleGetOnlineHelpKey()
    {

        return this.getMessageKey() + ".online.help";

    }

    // TODO REMOVE
    @Override
    protected String handleGetOnlineHelpValue()
    {

        final String crlf = "<br/>";
        final StringBuffer buffer = new StringBuffer();

        final String value = StringUtilsHelper.toResourceMessage(this.getDocumentation("", 64, false));

        buffer.append((value == null) ? "No page documentation has been specified" : value);
        buffer.append(crlf);
        buffer.append(crlf);

        return StringUtilsHelper.toResourceMessage(buffer.toString());

    }

    // TODO REMOVE
    @Override
    protected String handleGetOnlineHelpPagePath()
    {

        return this.getFullPath() + "_help";

    }

    // TODO REMOVE
    @Override
    protected String handleGetOnlineHelpActionPath()
    {

        final StringBuffer buffer = new StringBuffer();

        if (StringUtils.isNotBlank(this.getPackagePath()))
        {

            buffer.append(GuiGlobals.SEPARATOR);
            buffer.append(this.getPackagePath());

        }

        buffer.append(GuiGlobals.SEPARATOR);
        buffer.append(StringUtilsHelper.upperCamelCaseName(this.getName()));
        buffer.append("Help");

        return buffer.toString();

    }

    @Override
    protected String handleGetFullPath()
    {

        return GuiGlobals.SEPARATOR + (this.getPackageName() + "." + GuiUtils.toWebFileName(StringUtils.trimToEmpty(this.getName()))).replace(".", GuiGlobals.SEPARATOR);

    }

    @Override
    protected boolean handleIsDateFieldPresent()
    {

        final Collection<FrontEndAction> actions = this.getActions();

        for (final FrontEndAction frontEndAction : actions)
        {

            final GuiAction action = (GuiAction) frontEndAction;

            if (action.isDateFieldPresent())
            {

                return true;

            }

        }

        return false;

    }

    @Override
    protected boolean handleIsCalendarRequired()
    {

        final Collection<FrontEndAction> actions = this.getActions();

        for (final FrontEndAction frontEndAction : actions)
        {

            final GuiAction action = (GuiAction) frontEndAction;

            if (action.isCalendarRequired())
            {

                return true;

            }

        }

        return false;

    }

    @Override
    protected List<FrontEndParameter> handleGetPageVariables()
    {

        return this.getVariables();

    }

    @Override
    protected List<TransitionFacade> handleGetIncomingActions()
    {

        final List<TransitionFacade> incomingActionsList = new ArrayList<TransitionFacade>();

        this.collectIncomingActions(this, new LinkedHashSet<TransitionFacade>(), incomingActionsList);

        return incomingActionsList;

    }

    /**
     * Collects all actions that are entering the argument state vertex.
     * 
     * @param stateVertex the statevertex to process
     * @param processedTransitions the transitions that have already been processed
     * @param actions the actions collected so far
     */
    private void collectIncomingActions(final StateVertexFacade stateVertex, final Collection<TransitionFacade> processedTransitions, final Collection<TransitionFacade> actions)
    {

        /*
         * final Collection<TransitionFacade> incomingTransitions = stateVertex.getIncomings();
         * for (final TransitionFacade transitionFacade : incomingTransitions) {
         * final TransitionFacade incomingTransition = transitionFacade;
         * this.collectIncomingActions(incomingTransition, processedTransitions, actions);
         * }
         */
        for (final TransitionFacade incomingTransition : stateVertex.getIncomings())
        {

            this.collectIncomingActions(incomingTransition, processedTransitions, actions);

        }

    }

    /**
     * Collects all actions that are possibly traversing the argument transitions.
     * 
     * @param transition the transition to process
     * @param processedTransitions the transitions that have already been processed
     * @param actions the actions collected so far
     */
    private void collectIncomingActions(final TransitionFacade transition, final Collection<TransitionFacade> processedTransitions, final Collection<TransitionFacade> actions)
    {

        /*
         * if (!processedTransitions.contains(transition)) {
         * processedTransitions.add(transition);
         * if (transition instanceof GuiAction) {
         * actions.add(transition);
         * } else {
         * final Collection<TransitionFacade> incomingTransitions = transition.getSource().getIncomings();
         * for (final TransitionFacade transitionFacade : incomingTransitions) {
         * final TransitionFacade incomingTransition = transitionFacade;
         * this.collectIncomingActions(incomingTransition, processedTransitions, actions);
         * }
         * }
         * }
         */
        if (!processedTransitions.contains(transition))
        {

            processedTransitions.add(transition);

            if (transition instanceof GuiAction)
            {

                actions.add(transition);

                // TODO : TEMPORARILY COMMENTED OUT -- needs verification that isCaseStart() forms are not populated, but I think they are
                // if (((StrutsAction)transition).isUseCaseStart())
                // {
                // Collection finalStates = getUseCase().getFinalStates();// todo: test usecase for null
                // for (final Iterator iterator = finalStates.iterator(); iterator.hasNext();)
                // {
                // FinalStateFacade finalState = (FinalStateFacade) iterator.next();
                // collectIncomingActions(finalState, processedTransitions, actions);
                // }
                // }
            } else
            {

                final Collection<TransitionFacade> incomingTransitions = transition.getSource().getIncomings();

                for (final TransitionFacade transitionFacade : incomingTransitions)
                {

                    final TransitionFacade incomingTransition = transitionFacade;

                    this.collectIncomingActions(incomingTransition, processedTransitions, actions);

                }

            }

        }

    }

    @Override
    protected String handleGetCssFileName()
    {

        return this.getFullPath() + ".css";

    }

    protected List<FrontEndAction> handleGetNonTableActions()
    {

        final List<FrontEndAction> nonTableActions = new ArrayList<FrontEndAction>();

        final Collection<FrontEndAction> actions = this.getActions();

        for (final FrontEndAction frontEndAction : actions)
        {

            final GuiAction action = (GuiAction) frontEndAction;

            if (!action.isTableLink())
            {

                nonTableActions.add(action);

            }

        }

        return nonTableActions;

    }

    protected List<TransitionFacade> handleGetNonActionTransitions()
    {

        final List<TransitionFacade> actions = new ArrayList<TransitionFacade>();
        final Collection<TransitionFacade> outgoing = this.getOutgoings();

        for (final TransitionFacade object : outgoing)
        {

            if (!(object instanceof GuiAction))
            {

                actions.add(object);

            }

        }

        return actions;

    }

    @Override
    protected boolean handleIsTransparent()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_CONTAINER_TYPE);

        return GuiGlobals.TAGGEDVALUE_VIEW_CONTAINER_TYPE_TR.equalsIgnoreCase((value == null) ? null : value.toString());

    }

    @Override
    protected boolean handleIsTabs()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_CONTAINER_TYPE);

        return GuiGlobals.TAGGEDVALUE_VIEW_CONTAINER_TYPE_TA.equalsIgnoreCase((value == null) ? null : value.toString());

    }

    @Override
    protected boolean handleIsWindow()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_CONTAINER_TYPE);

        return GuiGlobals.TAGGEDVALUE_VIEW_CONTAINER_TYPE_WI.equalsIgnoreCase((value == null) ? null : value.toString());

    }

    @Override
    protected boolean handleIsExpandable()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_CONTAINER_TYPE);

        return GuiGlobals.TAGGEDVALUE_VIEW_CONTAINER_TYPE_EX.equalsIgnoreCase((value == null) ? null : value.toString());

    }

    @Override
    protected boolean handleIsActionGroup()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_ACTIONGROUP);

        if (value == null)
        {

            return false;

        } else
        {

            if (value.toString().equalsIgnoreCase("true"))
            {

                return true;

            } else
            {

                return false;

            }

        }

    }

    @Override
    protected String handleGetActionGroupName()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_ACTIONGROUP_NAME);

        return (value == null) ? null : String.valueOf(value);

    }

    @Override
    protected List<TransitionFacade> handleGetNonActionForwards()
    {

        final List<TransitionFacade> actions = new ArrayList<TransitionFacade>();
        final Collection<TransitionFacade> outgoing = this.getOutgoings();

        for (final TransitionFacade object : outgoing)
        {

            if (!(object instanceof GuiAction))
            {

                actions.add(object);

            }

        }

        return actions;

    }

    @Override
    protected boolean handleIsToolbar()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_TOOLBAR);

        if (value == null)
        {

            return false;

        } else
        {

            if (value.toString().equalsIgnoreCase("true"))
            {

                return true;

            } else
            {

                return false;

            }

        }

    }

    @Override
    protected boolean handleIsMainToolbar()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_MAIN_TOOLBAR);

        if (value == null)
        {

            return false;

        } else
        {

            if (value.toString().equalsIgnoreCase("true"))
            {

                return true;

            } else
            {

                return false;

            }

        }

    }

    @Override
    protected boolean handleIsHeldTable()
    {

        return (this.getPageVariables() != null) && (this.getPageVariables().size() == 1) && this.getPageVariables().get(0).isTable();

    }

    @Override
    protected boolean handleIsAsynchronous()
    {

        return this.hasStereotype(GuiProfile.STEREOTYPE_ASYNCHRONOUS);

    }

    @Override
    protected boolean handleIsFilterView()
    {

        return false;

    }

    @Override
    protected boolean handleIsNameUniqueInWorksheetDomain()
    {

        return true;

    }

}

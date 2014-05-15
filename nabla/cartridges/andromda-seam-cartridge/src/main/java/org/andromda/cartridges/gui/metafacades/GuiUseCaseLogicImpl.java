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

import org.andromda.metafacades.uml.ActionStateFacade;
import org.andromda.metafacades.uml.ActivityGraphFacade;
import org.andromda.metafacades.uml.AssociationEndFacade;
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.FinalStateFacade;
import org.andromda.metafacades.uml.FrontEndAction;
import org.andromda.metafacades.uml.FrontEndActivityGraph;
import org.andromda.metafacades.uml.FrontEndFinalState;
import org.andromda.metafacades.uml.FrontEndForward;
import org.andromda.metafacades.uml.FrontEndParameter;
import org.andromda.metafacades.uml.FrontEndUseCase;
import org.andromda.metafacades.uml.FrontEndView;
import org.andromda.metafacades.uml.IncludeFacade;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.Role;
import org.andromda.metafacades.uml.UseCaseFacade;

import org.andromda.utils.StringUtilsHelper;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiUseCase.
 *
 * @see org.andromda.cartridges.gui.metafacades.GuiUseCase
 */
public class GuiUseCaseLogicImpl extends GuiUseCaseLogic
{

    private static final long serialVersionUID = 34L;
    private final Logger      logger_          = Logger.getLogger(GuiUseCaseLogicImpl.class);

    /**
     * @param metaObject
     * @param context
     */
    public GuiUseCaseLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * @return actionPath
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getPath()
     */
    @Override
    protected String handleGetPath()
    {

        String actionPath = null;
        final FrontEndActivityGraph graph = this.getActivityGraph();

        if (graph != null)
        {

            final GuiAction action = (GuiAction) graph.getInitialAction();

            if (action != null)
            {

                actionPath = action.getPath();

            }

        }

        return actionPath;

    }

    /**
     * @return pathRoot
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getPathRoot()
     */
    @Override
    protected String handleGetPathRoot()
    {

        final StringBuilder pathRoot = new StringBuilder(GuiGlobals.SEPARATOR);
        final String packagePath = this.getPackagePath();
        final String prefix = (packagePath != null) ? packagePath.trim() : "";

        pathRoot.append(prefix);

        return pathRoot.toString();

    }

    /**
     * @return forwardName
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getPathRoot()
     */
    @Override
    protected String handleGetForwardName()
    {

        return GuiUtils.toWebResourceName(this.getName()) + GuiGlobals.USECASE_FORWARD_NAME_SUFFIX;

    }

    /**
     * @return titleKey
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getTitleKey()
     */
    @Override
    protected String handleGetTitleKey()
    {

        return StringUtilsHelper.toResourceMessageKey(this.isNormalizeMessages() ? this.getTitleValue() : this.getName()) + "." + GuiGlobals.TITLE_MESSAGE_KEY_SUFFIX;

    }

    /**
     * @return toPhrase(getName())
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getTitleValue()
     */
    @Override
    protected String handleGetTitleValue()
    {

        return StringUtilsHelper.toPhrase(this.getName());

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
     * @return allMessages
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getAllMessages()
     */
    @Override
    protected Map handleGetAllMessages()
    {

        final boolean normalize = this.isNormalizeMessages();
        final Map<String, String> messages = normalize ? new TreeMap<String, String>() : new LinkedHashMap<String, String>();

        // - only retrieve the messages for the entry use case (i.e. the use case
        // where the application begins)
        if (this.isEntryUseCase())
        {

            final List<FrontEndUseCase> useCases = this.getAllUseCases();

            for (int ctr = 0; ctr < useCases.size(); ctr++)
            {

                // - usecase
                final GuiUseCase useCase = (GuiUseCase) useCases.get(ctr);

                messages.put(useCase.getTitleKey(), useCase.getTitleValue());

                final List<FrontEndView> views = useCase.getViews();

                for (int ctr2 = 0; ctr2 < views.size(); ctr2++)
                {

                    // - view
                    final GuiView view = (GuiView) views.get(ctr2);

                    messages.put(view.getTitleKey(), view.getTitleValue());
                    messages.put(view.getMessageKey(), view.getMessageValue());
                    messages.put(view.getDocumentationKey(), view.getDocumentationValue());

                    final List<FrontEndParameter> viewVariables = view.getVariables();

                    for (int ctr3 = 0; ctr3 < viewVariables.size(); ctr3++)
                    {

                        // - page variables
                        final Object object = viewVariables.get(ctr3);

                        if (object instanceof GuiParameter)
                        {

                            final GuiParameter parameter = (GuiParameter) object;

                            final Collection<ClassifierFacade> resolvingTypes = new ArrayList<ClassifierFacade>();

                            this.collectAttributeMessages(messages, parameter.getAttributes(), resolvingTypes);
                            this.collectAssociationEndMessages(messages, parameter.getNavigableAssociationEnds(), resolvingTypes);
                            messages.put(parameter.getMessageKey(), parameter.getMessageValue());

                            // - table
                            if (parameter.isTable())
                            {

                                for (final String columnName : parameter.getTableColumnNames())
                                {

                                    messages.put(parameter.getTableColumnMessageKey(columnName), parameter.getTableColumnMessageValue(columnName));

                                }

                            }

                        }

                    }

                    final List<FrontEndAction> actions = useCase.getActions();

                    for (int ctr3 = 0; ctr3 < actions.size(); ctr3++)
                    {

                        // - action
                        final GuiAction action = (GuiAction) actions.get(ctr3);

                        // - event/trigger
                        final Object trigger = action.getTrigger();

                        if ((trigger != null) && (trigger instanceof GuiEvent))
                        {

                            final GuiEvent event = (GuiEvent) trigger;

                            // only add these when a trigger is present, otherwise it's no use having them
                            messages.put(action.getDocumentationKey(), action.getDocumentationValue());

                            // the regular trigger messages
                            messages.put(event.getResetMessageKey(), event.getResetMessageValue());

                            // this one is the same as doing: action.getMessageKey()
                            messages.put(event.getMessageKey(), event.getMessageValue());

                            // - IMAGE LINK

                            /*
                             * if (action.isImageLink())
                             * {
                             * messages.put(
                             * action.getImageMessageKey(),
                             * action.getImagePath());
                             * }
                             */
                        }

                        // - forwards
                        for (final FrontEndForward forward : action.getTransitions())
                        {

                            if (forward instanceof GuiForward)
                            {

                                final GuiForward forwardTransition = (GuiForward) forward;

                                messages.putAll(forwardTransition.getSuccessMessages());
                                messages.putAll(forwardTransition.getWarningMessages());
                                messages.putAll(forwardTransition.getErrorMessages());

                            } else
                            {

                                final GuiAction actionTransition = (GuiAction) forward;

                                messages.putAll(actionTransition.getSuccessMessages());
                                messages.putAll(actionTransition.getWarningMessages());
                                messages.putAll(actionTransition.getErrorMessages());

                            }

                        }

                        // - action parameters
                        final List<FrontEndParameter> parameters = action.getParameters();

                        for (int l = 0; l < parameters.size(); l++)
                        {

                            final Object object = parameters.get(l);

                            if (object instanceof GuiParameter)
                            {

                                final GuiParameter parameter = (GuiParameter) object;
                                final Collection attributes = parameter.getAttributes();

                                if (!attributes.isEmpty())
                                {

                                    for (final Iterator iterator = attributes.iterator(); iterator.hasNext();)
                                    {

                                        final GuiAttribute attribute = (GuiAttribute) iterator.next();

                                        messages.put(attribute.getMessageKey(), attribute.getMessageValue());

                                    }

                                }

                                final Collection associationEnds = parameter.getNavigableAssociationEnds();

                                if (!associationEnds.isEmpty())
                                {

                                    for (final Iterator iterator = associationEnds.iterator(); iterator.hasNext();)
                                    {

                                        final AssociationEndFacade end = (AssociationEndFacade) iterator.next();
                                        final ClassifierFacade type = end.getType();

                                        if (type != null)
                                        {

                                            final Collection<AttributeFacade> typeAttributes = type.getAttributes();

                                            if (!attributes.isEmpty())
                                            {

                                                for (final AttributeFacade attributeFacade : typeAttributes)
                                                {

                                                    final GuiAttribute attribute = (GuiAttribute) attributeFacade;

                                                    messages.put(attribute.getMessageKey(), attribute.getMessageValue());

                                                }

                                            }

                                        }

                                    }

                                }

                                messages.put(parameter.getMessageKey(), parameter.getMessageValue());
                                messages.put(parameter.getDocumentationKey(), parameter.getDocumentationValue());

                                // - submittable input table
                                if (parameter.isInputTable())
                                {

                                    final Collection<String> columnNames = parameter.getTableColumnNames();

                                    for (final String columnName : columnNames)
                                    {

                                        messages.put(parameter.getTableColumnMessageKey(columnName), parameter.getTableColumnMessageValue(columnName));

                                    }

                                }

                                /*
                                 * if (parameter.getValidWhen() != null)
                                 * {
                                 * // this key needs to be fully qualified since the valid when value can be different
                                 * final String completeKeyPrefix =
                                 * (normalize)
                                 * ? useCase.getTitleKey() + "." + view.getMessageKey() + "." +
                                 * action.getMessageKey() + "." + parameter.getMessageKey() : parameter.getMessageKey();
                                 * messages.put(
                                 * completeKeyPrefix + "_validwhen",
                                 * "{0} is only valid when " + parameter.getValidWhen());
                                 * }
                                 */

                                /*
                                 * if (parameter.getOptionCount() > 0)
                                 * {
                                 * final List optionKeys = parameter.getOptionKeys();
                                 * final List optionValues = parameter.getOptionValues();
                                 * for (int m = 0; m < optionKeys.size(); m++)
                                 * {
                                 * messages.put(
                                 * optionKeys.get(m),
                                 * optionValues.get(m));
                                 * messages.put(
                                 * optionKeys.get(m) + ".title",
                                 * optionValues.get(m));
                                 * }
                                 * }
                                 */
                            }

                        }

                        // - portlet preferences
                        final GuiPortletPreferences preferences = useCase.getPreferences();

                        if (preferences != null)
                        {

                            final Collection<AttributeFacade> attributes = preferences.getAttributes(true);

                            if (!attributes.isEmpty())
                            {

                                for (final Object element : attributes)
                                {

                                    final GuiAttribute attribute = (GuiAttribute) element;

                                    messages.put(attribute.getMessageKey(), attribute.getMessageValue());

                                }

                            }

                        }

                        // - exception forwards

                        /*
                         * final List exceptions = action.getActionExceptions();
                         * if (normalize)
                         * {
                         * if (exceptions.isEmpty())
                         * {
                         * messages.put("exception.occurred", "{0}");
                         * }
                         * else
                         * {
                         * for (int l = 0; l < exceptions.size(); l++)
                         * {
                         * final FrontEndExceptionHandler exception =
                         * (FrontEndExceptionHandler)exceptions.get(l);
                         * messages.put(action.getMessageKey() + "." + exception.getExceptionKey(), "{0}");
                         * }
                         * }
                         * }
                         * else
                         * {
                         * if (exceptions.isEmpty())
                         * {
                         * if (!action.isUseCaseStart())
                         * {
                         * messages.put(action.getMessageKey() + ".exception", "{0} (java.lang.Exception)");
                         * }
                         * }
                         * else
                         * {
                         * for (int l = 0; l < exceptions.size(); l++)
                         * {
                         * final FrontEndExceptionHandler exception =
                         * (FrontEndExceptionHandler)exceptions.get(l);
                         * // we construct the key using the action message too because the exception can
                         * // belong to more than one action (therefore it cannot return the correct value
                         * // in .getExceptionKey())
                         * messages.put(
                         * action.getMessageKey() + "." + exception.getExceptionKey(),
                         * "{0} (" + exception.getExceptionType() + ")");
                         * }
                         * }
                         * }
                         */
                    }

                }

            }

        }

        return messages;

    }

    /*
     * @Override
     * protected Map<String, String> handleGetAllMessages() {
     * final boolean normalize = this.normalizeMessages();
     * final Map messages = (normalize) ? (Map) new TreeMap() : (Map) new LinkedHashMap();
     * if (this.isApplicationUseCase()) {
     * final List useCases = this.getAllUseCases();
     * for (int i = 0; i < useCases.size(); i++) {
     * // USECASE
     * final GuiUseCase useCase = (GuiUseCase) useCases.get(i);
     * messages.put(useCase.getTitleKey(), useCase.getTitleValue());
     * messages.put(useCase.getOnlineHelpKey(), useCase.getOnlineHelpValue());
     * final List actions = useCase.getActions();
     * for (int j = 0; j < actions.size(); j++) {
     * final GuiAction action = (GuiAction) actions.get(j);
     * // FORWARDS
     * final List transitions = action.getActionForwards();
     * for (int l = 0; l < transitions.size(); l++) {
     * final GuiForward forward = (GuiForward) transitions.get(l);
     * messages.putAll(forward.getSuccessMessages());
     * messages.putAll(forward.getWarningMessages());
     * }
     * // EXCEPTION FORWARDS
     * final List exceptions = action.getActionExceptions();
     * if (normalize) {
     * if (exceptions.isEmpty()) {
     * if (!action.isUseCaseStart()) {
     * messages.put(action.getMessageKey() + ".exception", "{0} (java.lang.Exception)");
     * }
     * } else {
     * for (int l = 0; l < exceptions.size(); l++) {
     * final GuiExceptionHandler exception = (GuiExceptionHandler) exceptions.get(l);
     * messages.put(action.getMessageKey() + '.' + exception.getExceptionKey(), "{0}");
     * }
     * }
     * } else {
     * if (exceptions.isEmpty()) {
     * if (!action.isUseCaseStart()) {
     * messages.put(action.getMessageKey() + ".exception", "{0} (java.lang.Exception)");
     * }
     * } else {
     * for (int l = 0; l < exceptions.size(); l++) {
     * final GuiExceptionHandler exception = (GuiExceptionHandler) exceptions.get(l);
     * // we construct the key using the action message too because the exception can
     * // belong to more than one action (therefore it cannot return the correct value
     * // in .getExceptionKey())
     * messages.put(action.getMessageKey() + '.' + exception.getExceptionKey(), "{0} (" + exception.getExceptionType() + ")");
     * }
     * }
     * }
     * // TRIGGER
     * final GuiTrigger trigger = action.getActionTrigger();
     * if (trigger != null) {
     * // only add these when a trigger is present, otherwise it's no use having them
     * messages.put(action.getOnlineHelpKey(), action.getOnlineHelpValue());
     * messages.put(action.getDocumentationKey(), action.getDocumentationValue());
     * // the regular trigger messages
     * messages.put(trigger.getTitleKey(), trigger.getTitleValue());
     * messages.put(trigger.getNotAllowedTitleKey(), trigger.getNotAllowedTitleValue());
     * messages.put(trigger.getResetMessageKey(), trigger.getResetMessageValue());
     * messages.put(trigger.getResetNotAllowedTitleKey(), trigger.getResetNotAllowedTitleValue());
     * messages.put(trigger.getResetTitleKey(), trigger.getResetTitleValue());
     * // this one is the same as doing: action.getMessageKey()
     * messages.put(trigger.getTriggerKey(), trigger.getTriggerValue());
     * // IMAGE LINK
     * if (action.isImageLink()) {
     * messages.put(action.getImageMessageKey(), action.getImagePath());
     * }
     * }
     * }
     * final List pages = useCase.getPages();
     * for (int j = 0; j < pages.size(); j++) {
     * // PAGE
     * final GuiView page = (GuiView) pages.get(j);
     * messages.put(page.getTitleKey(), page.getTitleValue());
     * messages.put(page.getMessageKey(), page.getMessageValue());
     * messages.put(page.getOnlineHelpKey(), page.getOnlineHelpValue());
     * messages.put(page.getDocumentationKey(), page.getDocumentationValue());
     * final List pageVariables = page.getPageVariables();
     * for (int k = 0; k < pageVariables.size(); k++) {
     * // PAGE-VARIABLE
     * final GuiParameter parameter = (GuiParameter) pageVariables.get(k);
     * messages.put(parameter.getMessageKey(), parameter.getMessageValue());
     */

    /*
     * if (normalize)
     * {
     * // the next line is in comment because it's not actually being used
     * //messages.put(parameter.getTitleKey(), parameter.getTitleValue());
     * messages.put(parameter.getMessageKey(), parameter.getMessageValue());
     * }
     * else
     * {
     * // the next line is in comment because it's not actually being used
     * //messages.put(page.getTitleKey() + '.' + parameter.getTitleKey(), parameter.getTitleValue());
     * messages.put(page.getTitleKey() + '.' + parameter.getMessageKey(),
     * parameter.getMessageValue());
     * }
     */

    /*
     * // TABLE
     * if (parameter.isTable()) {
     * final Collection columnNames = parameter.getTableColumnNames();
     * for (final Iterator columnNameIterator = columnNames.iterator(); columnNameIterator.hasNext();) {
     * final String columnName = (String) columnNameIterator.next();
     * messages.put(parameter.getTableColumnMessageKey(columnName), parameter.getTableColumnMessageValue(columnName));
     * }
     * }
     * }
     * for (int k = 0; k < actions.size(); k++) {
     * // ACTION
     * final GuiAction action = (GuiAction) actions.get(k);
     * // ACTION PARAMETERS
     * final List parameters = action.getActionParameters();
     * for (int l = 0; l < parameters.size(); l++) {
     * final GuiParameter parameter = (GuiParameter) parameters.get(l);
     * messages.put(parameter.getMessageKey(), parameter.getMessageValue());
     * messages.put(parameter.getOnlineHelpKey(), parameter.getOnlineHelpValue());
     * messages.put(parameter.getDocumentationKey(), parameter.getDocumentationValue());
     * messages.put(parameter.getTitleKey(), parameter.getTitleValue());
     * if (parameter.getValidWhen() != null) {
     * // this key needs to be fully qualified since the valid when value can be different
     * final String completeKeyPrefix = (normalize) ? parameter.getMessageKey() : (useCase.getTitleKey() + '.' + page.getMessageKey() + '.' + action.getMessageKey() + '.' + parameter
     * .getMessageKey());
     * messages.put(completeKeyPrefix + "_validwhen", "{0} is only valid when " + parameter.getValidWhen());
     * }
     * if (parameter.getOptionCount() > 0) {
     * final List optionKeys = parameter.getOptionKeys();
     * final List optionValues = parameter.getOptionValues();
     * for (int m = 0; m < optionKeys.size(); m++) {
     * messages.put(optionKeys.get(m), optionValues.get(m));
     * messages.put(optionKeys.get(m) + ".title", optionValues.get(m));
     * }
     * }
     * }
     * }
     * }
     * }
     * }
     * return messages;
     * }
     */

    /**
     * Collects all attribute messages into the given Map.
     *
     * @param messages the Map in which messages are collected.
     * @param attributes the attributes to collect the messages from.
     * @param resolvingTypes used to prevent endless recursion.
     */
    private void collectAttributeMessages(final Map<String, String> messages, final Collection attributes, final Collection<ClassifierFacade> resolvingTypes)
    {

        if ((attributes != null) && !attributes.isEmpty())
        {

            for (final Iterator iterator = attributes.iterator(); iterator.hasNext();)
            {

                final GuiAttribute attribute = (GuiAttribute) iterator.next();

                messages.put(attribute.getMessageKey(), attribute.getMessageValue());
                // - lets go another level for nested attributes
                this.collectTypeMessages(messages, attribute.getType(), resolvingTypes);

            }

        }

    }

    /**
     * Collects all association end messages into the given Map.
     *
     * @param messages the Map in which messages are collected.
     * @param associationEnds the association ends to collect the messages from.
     * @param resolvingTypes used to prevent endless recursion.
     */
    private void collectAssociationEndMessages(final Map<String, String> messages, final Collection associationEnds, final Collection<ClassifierFacade> resolvingTypes)
    {

        if ((associationEnds != null) && !associationEnds.isEmpty())
        {

            for (final Iterator iterator = associationEnds.iterator(); iterator.hasNext();)
            {

                final AssociationEndFacade end = (AssociationEndFacade) iterator.next();

                this.collectTypeMessages(messages, end.getType(), resolvingTypes);

            }

        }

    }

    private void collectTypeMessages(final Map<String, String> messages, ClassifierFacade type, final Collection<ClassifierFacade> resolvingTypes)
    {

        if (type != null)
        {

            if (!resolvingTypes.contains(type))
            {

                resolvingTypes.add(type);

                if (type.isArrayType())
                {

                    type = type.getNonArray();

                }

                // check again, since the type can be changed
                if (!resolvingTypes.contains(type))
                {

                    this.collectAttributeMessages(messages, type.getAttributes(), resolvingTypes);
                    this.collectAssociationEndMessages(messages, type.getNavigableConnectingEnds(), resolvingTypes);

                }

            }

            resolvingTypes.remove(type);

        }

    }

    /**
     * @return actionForwards
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getActionForwards()
     */
    @Override
    protected List<GuiAction> handleGetActionForwards()
    {

        final Set<GuiAction> actionForwards = new LinkedHashSet<GuiAction>();

        for (final FrontEndView view : this.getViews())
        {

            actionForwards.addAll(((GuiView) view).getActionForwards());

        }

        return new ArrayList<GuiAction>(actionForwards);

    }

    /**
     * @return forwards
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getForwards()
     */
    @Override
    protected List<GuiForward> handleGetForwards()
    {

        final Map<String, GuiForward> forwards = new LinkedHashMap<String, GuiForward>();

        for (final FrontEndAction action : this.getActions())
        {

            for (final FrontEndForward forward : action.getActionForwards())
            {

                if (forward instanceof GuiForward)
                {

                    forwards.put(forward.getName(), (GuiForward) forward);

                }

            }

        }

        return new ArrayList(forwards.values());

    }

    /**
     * @return allForwards
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getAllForwards()
     */
    @Override
    @SuppressWarnings("unchecked")
    protected List<ModelElementFacade> handleGetAllForwards()
    {

        final Map<String, ModelElementFacade> forwards = new LinkedHashMap<String, ModelElementFacade>();

        for (final GuiAction forward : this.getActionForwards())
        {

            forwards.put(forward.getName(), forward);

        }

        for (final GuiForward forward : this.getForwards())
        {

            forwards.put(forward.getName(), forward);

        }

        return new ArrayList<ModelElementFacade>(forwards.values());

    }

    /**
     * @return upperCamelCaseName(this.getName())
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getActionClassName()
     */
    @Override
    protected String handleGetActionClassName()
    {

        return StringUtilsHelper.upperCamelCaseName(this.getName());

    }

    /**
     * @return getFullyQualifiedActionClassName().replace(".", GuiGlobals.SEPARATOR) + ".java"
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getFullyQualifiedActionClassPath()
     */
    @Override
    protected String handleGetFullyQualifiedActionClassPath()
    {

        return this.getFullyQualifiedActionClassName().replace(".", GuiGlobals.SEPARATOR) + ".java";

    }

    /**
     * @return lowerCamelCaseName(this.getName())
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getControllerAction()
     */
    @Override
    protected String handleGetControllerAction()
    {

        return StringUtilsHelper.lowerCamelCaseName(this.getName());

    }

    /**
     * @return fullyQualifiedActionClassName
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getFullyQualifiedActionClassName()
     */
    @Override
    protected String handleGetFullyQualifiedActionClassName()
    {

        final StringBuilder path = new StringBuilder();
        final String packageName = this.getPackageName();

        if (StringUtils.isNotBlank(packageName))
        {

            path.append(packageName);
            path.append(".");

        }

        path.append(this.getActionClassName());

        return path.toString();

    }

    /**
     * @return formKeyValue
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getFormKey()
     */
    @Override
    protected String handleGetFormKey()
    {

        final Object formKeyValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_ACTION_FORM_KEY);

        return (formKeyValue == null) ? ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.ACTION_FORM_KEY)) : String.valueOf(formKeyValue);

    }

    /**
     * @return initialTargetPath
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getInitialTargetPath()
     */
    @Override
    protected String handleGetInitialTargetPath()
    {

        String path = null;
        final Object target = this.getInitialTarget();

        if (target instanceof GuiView)
        {

            path = ((GuiView) target).getPath();

        } else if (target instanceof GuiUseCase)
        {

            path = ((GuiUseCase) target).getPath();

        }

        return path;

    }

    /**
     * Gets the initial target when this use case is entered.
     *
     * @return the initial target.
     */
    private Object getInitialTarget()
    {

        Object initialTarget = null;
        final FrontEndActivityGraph graph = this.getActivityGraph();
        final FrontEndAction action = (graph != null) ? this.getActivityGraph().getInitialAction() : null;
        final Collection<FrontEndForward> forwards = (action != null) ? action.getActionForwards() : null;

        if ((forwards != null) && !forwards.isEmpty())
        {

            final Object target = forwards.iterator().next().getTarget();

            if (target instanceof FrontEndView)
            {

                initialTarget = target;

            } else if (target instanceof FrontEndFinalState)
            {

                final FrontEndFinalState finalState = (FrontEndFinalState) target;
                final FrontEndUseCase targetUseCase = finalState.getTargetUseCase();

                if ((targetUseCase != null) && !targetUseCase.equals(this.THIS()))
                {

                    initialTarget = targetUseCase;

                }

            }

        }

        return initialTarget;

    }

    /**
     * @return required
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#isValidationRequired()
     */
    @Override
    protected boolean handleIsValidationRequired()
    {

        boolean required = false;

        for (final FrontEndView feView : this.getViews())
        {

            final GuiView view = (GuiView) feView;

            if (view.isValidationRequired())
            {

                required = true;

                break;

            }

        }

        return required;

    }

    /**
     * @return getInitialTarget() instanceof GuiView
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#isInitialTargetView()
     */
    @Override
    protected boolean handleIsInitialTargetView()
    {

        return this.getInitialTarget() instanceof GuiView;

    }

    /**
     * @return required
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#isInitialTargetView()
     */
    @Override
    protected boolean handleIsApplicationValidationRequired()
    {

        boolean required = false;

        for (final FrontEndUseCase feUseCase : this.getAllUseCases())
        {

            final GuiUseCase useCase = (GuiUseCase) feUseCase;

            if (useCase.isValidationRequired())
            {

                required = true;

                break;

            }

        }

        return required;

    }

    /**
     * @return sameName
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#isViewHasNameOfUseCase()
     */
    @Override
    protected boolean handleIsViewHasNameOfUseCase()
    {

        boolean sameName = false;

        for (final FrontEndView view : this.getViews())
        {

            sameName = ((GuiView) view).isHasNameOfUseCase();

            if (sameName)
            {

                break;

            }

        }

        return sameName;

    }

    /**
     * @return hasStereotype(GuiProfile.STEREOTYPE_FRONT_END_REGISTRATION)
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#isRegistrationUseCase()
     */
    @Override
    protected boolean handleIsRegistrationUseCase()
    {

        return this.hasStereotype(GuiProfile.STEREOTYPE_FRONT_END_REGISTRATION);

    }

    /**
     * @return useCases
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getRegistrationUseCases()
     */
    @Override
    @SuppressWarnings("unchecked")
    protected List<GuiUseCase> handleGetRegistrationUseCases()
    {

        final List<FrontEndUseCase> useCases = new ArrayList<FrontEndUseCase>(this.getAllUseCases());

        for (final Iterator<FrontEndUseCase> iterator = useCases.iterator(); iterator.hasNext();)
        {

            final FrontEndUseCase useCase = iterator.next();

            if (useCase instanceof GuiUseCase)
            {

                if (!((GuiUseCase) useCase).isRegistrationUseCase())
                {

                    iterator.remove();

                }

            } else
            {

                iterator.remove();

            }

        }

        final List<GuiUseCase> registrationUseCases = new ArrayList<GuiUseCase>();

        registrationUseCases.add((GuiUseCase) useCases);

        return registrationUseCases;

        // return useCases;
    }

    /**
     * The suffix for the forwards class name.
     */
    private static final String FORWARDS_CLASS_NAME_SUFFIX = "Forwards";

    /**
     * @return getName() + FORWARDS_CLASS_NAME_SUFFIX
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getForwardsClassName()
     */
    @Override
    protected String handleGetForwardsClassName()
    {

        return StringUtilsHelper.upperCamelCaseName(this.getName()) + GuiUseCaseLogicImpl.FORWARDS_CLASS_NAME_SUFFIX;

    }

    /**
     * @return navigationRules
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getNavigationRules()
     */
    @Override
    @SuppressWarnings("unchecked")
    protected Collection<Object> handleGetNavigationRules()
    {

        final Map<String, Object> rules = new LinkedHashMap<String, Object>();

        for (final FrontEndView feView : this.getViews())
        {

            final GuiView view = (GuiView) feView;

            rules.put(view.getFromOutcome(), view);

            for (final ModelElementFacade forward : view.getForwards())
            {

                String name;

                if (forward instanceof GuiForward)
                {

                    name = ((GuiForward) forward).getFromOutcome();

                } else
                {

                    name = ((GuiAction) forward).getFromOutcome();

                }

                if (this.logger_.isDebugEnabled())
                {

                    this.logger_.debug("handleGetNavigationRules is : " + name + " for : " + this.getFullyQualifiedName());

                }

                rules.put(name, forward);

            }

        }

        return rules.values();

    }

    /**
     * @return navigationChildren
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getNavigationChildren()
     */
    @Override
    protected Collection<UseCaseFacade> handleGetNavigationChildren()
    {

        return CollectionUtils.collect(this.getIncludes(), new Transformer()
        {

            @Override
            public Object transform(final Object object)
            {

                final IncludeFacade include = (IncludeFacade) object;

                return include.getAddition();

            }

        });

    }

    private static boolean isParent(final GuiUseCase useCase1, final GuiUseCase useCase2)
    {

        return CollectionUtils.exists(useCase2.getIncludes(), new Predicate()
        {

            @Override
            public boolean evaluate(final Object object)
            {

                final IncludeFacade include = (IncludeFacade) object;

                return include.getAddition().equals(useCase1);

            }

        });

    }

    /**
     * @return navigationParents
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getNavigationParents()
     */
    @Override
    protected Collection<FrontEndUseCase> handleGetNavigationParents()
    {

        final GuiUseCase theUseCase = this;

        return CollectionUtils.select(this.getAllUseCases(), new Predicate()
        {

            @Override
            @SuppressWarnings("synthetic-access")
            public boolean evaluate(final Object o)
            {

                final GuiUseCase useCase = (GuiUseCase) o;

                if (theUseCase.equals(useCase))
                {

                    return false;

                }

                return GuiUseCaseLogicImpl.isParent(theUseCase, useCase);

            }

        });

    }

    /**
     * @return actionRoles
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCase#getActionRoles()
     */
    @Override
    protected String handleGetActionRoles()
    {

        final StringBuilder rolesBuffer = new StringBuilder();
        boolean first = true;

        for (final Role role : this.getRoles())
        {

            if (first)
            {

                first = false;

            } else
            {

                rolesBuffer.append(',');

            }

            rolesBuffer.append(role.getName());

        }

        return rolesBuffer.toString();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCaseLogic#handleGetPreferences()
     */
    @Override
    protected Object handleGetPreferences()
    {

        GuiPortletPreferences preferences = null;
        final Collection<DependencyFacade> dependencies = this.getSourceDependencies();

        if ((dependencies != null) && !dependencies.isEmpty())
        {

            for (final DependencyFacade dependency : dependencies)
            {

                final Object target = dependency.getTargetElement();

                if (dependency.getTargetElement() instanceof GuiPortletPreferences)
                {

                    preferences = (GuiPortletPreferences) target;

                    break;

                }

            }

        }

        return preferences;

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCaseLogic#handleGetPortletEditForwardName()
     */
    @Override
    protected String handleGetPortletEditForwardName()
    {

        return this.getWebResourceName() + "-portlet-edit";

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCaseLogic#handleGetPortletEditPath()
     */
    @Override
    protected String handleGetPortletEditPath()
    {

        return this.getPathRoot() + GuiGlobals.SEPARATOR + this.getPortletEditForwardName();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCaseLogic#handleGetPortletHelpForwardName()
     */
    @Override
    protected String handleGetPortletHelpForwardName()
    {

        return this.getWebResourceName() + "-portlet-help";

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCaseLogic#handleGetPortletHelpPath()
     */
    @Override
    protected String handleGetPortletHelpPath()
    {

        return this.getPathRoot() + GuiGlobals.SEPARATOR + this.getPortletHelpForwardName();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCaseLogic#handleGetPortletViewForwardName()
     */
    @Override
    protected String handleGetPortletViewForwardName()
    {

        return this.getWebResourceName() + "-portlet-view";

    }

    private String getWebResourceName()
    {

        return GuiUtils.toWebResourceName(this.getName());

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCaseLogic#handleGetPortletViewPath()
     */
    @Override
    protected String handleGetPortletViewPath()
    {

        return this.getPath();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiUseCaseLogic#handleGetAllViews()
     */
    @SuppressWarnings("unchecked")
    @Override
    protected Collection<GuiView> handleGetAllViews()
    {

        final Set<GuiView> allViews = new LinkedHashSet<GuiView>();

        for (final FrontEndUseCase useCase : this.getAllUseCases())
        {

            for (final FrontEndView view : useCase.getViews())
            {

                allViews.add((GuiView) view);

            }

            // allViews.addAll(useCase.getViews());
        }

        // TODO
        return allViews;

    }

    // TODO REMOVE
    @Override
    protected String handleGetOnlineHelpKey()
    {

        return StringUtilsHelper.toResourceMessageKey(this.getName()) + ".online.help";

    }

    // TODO REMOVE
    @Override
    protected String handleGetOnlineHelpValue()
    {

        final String crlf = "<br/>";
        final StringBuffer buffer = new StringBuffer();

        final String value = StringUtilsHelper.toResourceMessage(this.getDocumentation("", 64, false));

        buffer.append((value == null) ? "No use-case documentation has been specified" : value);
        buffer.append(crlf);

        return StringUtilsHelper.toResourceMessage(buffer.toString());

    }

    @Override
    protected String handleGetActionPath()
    {

        String actionPath = null;

        final GuiActivityGraph graph = (GuiActivityGraph) this.getActivityGraph();

        if (graph != null)
        {

            final GuiAction action = graph.getFirstAction();

            if (action != null)
            {

                actionPath = action.getActionPath();

            }

        }

        return actionPath;

    }

    @Override
    protected String handleGetActionPathRoot()
    {

        String actionPathRoot = null;

        final GuiActivityGraph graph = (GuiActivityGraph) this.getActivityGraph();

        if (graph != null)
        {

            final GuiAction action = graph.getFirstAction();

            if (action != null)
            {

                actionPathRoot = action.getActionPathRoot();

            }

        }

        return actionPathRoot;

    }

    @Override
    protected boolean handleIsCyclic()
    {

        boolean selfTargetting = false;
        final ActivityGraphFacade graph = this.getActivityGraph();

        if (graph != null)
        {

            final Collection finalStates = graph.getFinalStates();

            for (final Iterator finalStateIterator = finalStates.iterator(); finalStateIterator.hasNext() && !selfTargetting;)
            {

                final GuiFinalState finalState = (GuiFinalState) finalStateIterator.next();

                if (this.equals(finalState.getTargetUseCase()))
                {

                    selfTargetting = true;

                }

            }

        }

        return selfTargetting;

    }

    @Override
    protected List<GuiUseCase> handleGetDirectSubUseCases()
    {

        final List<GuiUseCase> subUseCases = new ArrayList<GuiUseCase>();
        final ActivityGraphFacade graph = this.getActivityGraph();

        if (graph != null)
        {

            final Collection<FinalStateFacade> finalStates = graph.getFinalStates();

            for (final FinalStateFacade finalStateFacade : finalStates)
            {

                final GuiFinalState finalState = (GuiFinalState) finalStateFacade;

                if (!this.equals(finalState.getTargetUseCase()))
                {

                    subUseCases.add((GuiUseCase) finalState.getTargetUseCase());

                }

            }

        }

        return subUseCases;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    @Override
    public List<OperationFacade> getOperations()
    {

        return Collections.EMPTY_LIST;

    }

    @Override
    protected List<FrontEndView> handleGetPages()
    {

        return this.getViews();

    }

    @Override
    protected List<GuiView> handleGetAllPages()
    {

        final List<GuiView> pagesList = new ArrayList<GuiView>();
        final Collection<ActionStateFacade> allActionStates = this.getModel().getAllActionStates();

        for (final Iterator<ActionStateFacade> actionStateIterator = allActionStates.iterator(); actionStateIterator.hasNext();)
        {

            final Object actionState = actionStateIterator.next();

            if (actionState instanceof GuiView)
            {

                pagesList.add((GuiView) actionState);

            }

        }

        return pagesList;

    }

    @Override
    protected List<GuiParameter> handleGetFormFields()
    {

        final List<GuiParameter> formFields = new ArrayList<GuiParameter>(); // parameter names are supposed to be unique

        final Collection<GuiView> pages = this.getPages();

        for (final GuiView guiView : pages)
        {

            final GuiView jsp = guiView;
            final Collection<GuiParameter> variables = jsp.getPageVariables();

            for (final GuiParameter guiParameter : variables)
            {

                formFields.add(guiParameter);

            }

            final Collection<FrontEndParameter> parameters = jsp.getAllActionParameters();

            for (final FrontEndParameter frontEndParameter : parameters)
            {

                formFields.add((GuiParameter) frontEndParameter);

            }

        }

        return formFields;

    }

    /**
     * Overriden because GuiEJBAction does not extend FrontEndAction.
     *
     * @see org.andromda.metafacades.uml.FrontEndUseCase#getActions()
     */

    /*
     * @Override
     * public List<FrontEndAction> getActions() {
     * final Set<FrontEndForward> actions = new LinkedHashSet<FrontEndForward>();
     * final List<GuiView> pages = getPages();
     * for (final Iterator pageIterator = pages.iterator(); pageIterator.hasNext();) {
     * final Object o = pageIterator.next();
     * if (o instanceof GuiView) {
     * final GuiView jsp = (GuiView) o;
     * actions.addAll(jsp.getActions());
     * } else if (o instanceof GuiActionState) {
     * }
     * }
     * final GuiActivityGraph graph = (GuiActivityGraph) getActivityGraph();
     * if (graph != null) {
     * final GuiAction action = graph.getFirstAction();
     * if (action != null) {
     * actions.add(action);
     * }
     * }
     * return new ArrayList (actions);
     * }
     */
    @Override
    protected List handleGetPageVariables()
    {

        return this.getViewVariables();

    }

    @Override
    protected boolean handleIsApplicationUseCase()
    {

        return this.isEntryUseCase();

    }

    @Override
    protected String handleGetCssFileName()
    {

        return this.getPackagePath() + GuiGlobals.SEPARATOR + GuiUtils.toWebFileName(this.getName()) + ".css";

    }

    @Override
    protected TreeNode handleGetApplicationHierarchyRoot()
    {

        final UseCaseNode root = new UseCaseNode(this);

        this.createHierarchy(root);

        return root;

    }

    @Override
    protected TreeNode handleGetHierarchyRoot()
    {

        UseCaseNode hierarchy = null;

        final Collection allUseCases = this.getAllUseCases();

        for (final Iterator useCaseIterator = allUseCases.iterator(); useCaseIterator.hasNext();)
        {

            final GuiUseCase useCase = (GuiUseCase) useCaseIterator.next();

            if (useCase.isApplicationUseCase())
            {

                final UseCaseNode root = (UseCaseNode) useCase.getApplicationHierarchyRoot();

                hierarchy = this.findNode(root, this);

            }

        }

        return hierarchy;

    }

    /**
     * Recursively creates a hierarchy of use-cases, starting with the argument use-case as the root. This is primarily
     * meant to build a set of menu items.
     */
    private void createHierarchy(final UseCaseNode root)
    {

        final GuiUseCase useCase = (GuiUseCase) root.getUserObject();

        final FrontEndActivityGraph graph = useCase.getActivityGraph();

        if (graph != null)
        {

            final Collection<FinalStateFacade> finalStates = graph.getFinalStates();

            for (final FinalStateFacade finalStateFacade : finalStates)
            {

                final GuiFinalState finalState = (GuiFinalState) finalStateFacade;
                final GuiUseCase targetUseCase = (GuiUseCase) finalState.getTargetUseCase();

                if (targetUseCase != null)
                {

                    final UseCaseNode useCaseNode = new UseCaseNode(targetUseCase);

                    if (!this.isNodeAncestor(root, useCaseNode))
                    {

                        root.add(useCaseNode);
                        this.createHierarchy(useCaseNode);

                    }

                }

            }

        }

    }

    /**
     * <code>true</code> if the argument ancestor node is actually an ancestor of the first node.
     * <p/>
     * <em>Note: DefaultMutableTreeNode's isNodeAncestor does not work because of its specific impl.</em>
     */
    private boolean isNodeAncestor(UseCaseNode node, final UseCaseNode ancestorNode)
    {

        boolean ancestor = false;

        if (node.getUseCase().equals(ancestorNode.getUseCase()))
        {

            ancestor = true;

        }

        while (!ancestor && (node.getParent() != null))
        {

            node = (UseCaseNode) node.getParent();

            if (this.isNodeAncestor(node, ancestorNode))
            {

                ancestor = true;

            }

        }

        return ancestor;

    }

    /**
     * Given a root use-case, finds the node in the hierarchy that represent the argument GuiUseCase node.
     */
    private UseCaseNode findNode(final UseCaseNode root, final GuiUseCase useCase)
    {

        UseCaseNode useCaseNode = null;

        final List nodeList = Collections.list(root.breadthFirstEnumeration());

        for (final Iterator nodeIterator = nodeList.iterator(); nodeIterator.hasNext() && (useCaseNode == null);)
        {

            final UseCaseNode node = (UseCaseNode) nodeIterator.next();

            if (useCase.equals(node.getUserObject()))
            {

                useCaseNode = node;

            }

        }

        return useCaseNode;

    }

    /**
     * DOCUMENT ME!
     *
     * @author $Author$
     * @version $Revision$
     * @since $Date$
     */
    public final static class UseCaseNode extends DefaultMutableTreeNode
    {

        /**
         * Creates a new UseCaseNode object.
         *
         * @param useCase DOCUMENT ME!
         */
        public UseCaseNode(final GuiUseCase useCase)
        {
            super(useCase);

        }

        /**
         * DOCUMENT ME!
         *
         * @return DOCUMENT ME!
         */
        public GuiUseCase getUseCase()
        {

            return (GuiUseCase) this.getUserObject();

        }

    }

    // TODO REMOVE
    @Override
    protected String handleGetOnlineHelpPagePath()
    {

        final StringBuffer buffer = new StringBuffer();

        if (StringUtils.isNotBlank(this.getPackagePath()))
        {

            buffer.append(GuiGlobals.SEPARATOR);
            buffer.append(this.getPackagePath());

        }

        buffer.append(GuiGlobals.SEPARATOR);
        buffer.append(StringUtilsHelper.separate(this.getName(), "-"));
        buffer.append("_help");

        return buffer.toString();

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
    protected boolean handleIsWorkbook()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_LAYOUT_TYPE);

        return GuiGlobals.TAGGEDVALUE_VIEW_LAYOUT_TYPE_WB.equalsIgnoreCase((value == null) ? null : value.toString());

    }

    @Override
    protected boolean handleIsWorksheet()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_LAYOUT_TYPE);

        return GuiGlobals.TAGGEDVALUE_VIEW_LAYOUT_TYPE_WS.equalsIgnoreCase((value == null) ? null : value.toString());

    }

    @Override
    protected boolean handleIsContainer()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_LAYOUT_TYPE);

        return GuiGlobals.TAGGEDVALUE_VIEW_LAYOUT_TYPE_CO.equalsIgnoreCase((value == null) ? null : value.toString());

    }

    @Override
    protected Collection handleGetIncludedUseCases()
    {

        final TreeNode root = this.getApplicationHierarchyRoot();
        final List nodeList = Collections.list(((UseCaseNode) root).breadthFirstEnumeration());
        final List<GuiUseCase> useCasesList = new ArrayList<GuiUseCase>();

        for (final Iterator it = nodeList.iterator(); it.hasNext();)
        {

            useCasesList.add(((UseCaseNode) it.next()).getUseCase());

        }

        return useCasesList;

    }

    @Override
    protected String handleGetContainerHeight()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_CONTAINER_HEIGHT);

        if (value == null)
        {

            return GuiGlobals.TAGGEDVALUE_VIEW_CONTAINER_HEIGHT_DEF;

        } else
        {

            return value.toString();

        }

    }

    @Override
    protected String handleGetContainerWidth()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_CONTAINER_WIDTH);

        if (value == null)
        {

            return GuiGlobals.TAGGEDVALUE_VIEW_CONTAINER_WIDTH_DEF;

        } else
        {

            return value.toString();

        }

    }

}

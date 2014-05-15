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
import org.andromda.metafacades.uml.FilteredCollection;
import org.andromda.metafacades.uml.FrontEndAction;
import org.andromda.metafacades.uml.FrontEndActionState;
import org.andromda.metafacades.uml.FrontEndControllerOperation;
import org.andromda.metafacades.uml.FrontEndExceptionHandler;
import org.andromda.metafacades.uml.FrontEndFinalState;
import org.andromda.metafacades.uml.FrontEndForward;
import org.andromda.metafacades.uml.FrontEndParameter;
import org.andromda.metafacades.uml.FrontEndUseCase;
import org.andromda.metafacades.uml.FrontEndView;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ParameterFacade;
import org.andromda.metafacades.uml.Role;
import org.andromda.metafacades.uml.StateVertexFacade;
import org.andromda.metafacades.uml.TransitionFacade;
import org.andromda.metafacades.uml.UseCaseFacade;

import org.andromda.utils.StringUtilsHelper;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiAction.
 *
 * @see org.andromda.cartridges.gui.metafacades.GuiAction
 */
public class GuiActionLogicImpl extends GuiActionLogic
{

    private static final long serialVersionUID = 34L;

    /**
     * @param metaObject
     * @param context
     */
    public GuiActionLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = Logger.getLogger(GuiActionLogicImpl.class);

    /**
     * @return getFormBeanName(true)
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormBeanName()
     */
    @Override
    protected String handleGetFormBeanName()
    {

        return this.getFormBeanName(true);

    }

    /**
     * Constructs the form bean name, with our without prefixing the use case name.
     *
     * @param withUseCaseName whether or not to prefix the use case name.
     * @return the constructed form bean name.
     */
    private String getFormBeanName(final boolean withUseCaseName)
    {

        final String pattern = ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.FORM_BEAN_PATTERN));
        final ModelElementFacade useCase = this.getUseCase();
        final String useCaseName = (withUseCaseName && (useCase != null)) ? StringUtilsHelper.lowerCamelCaseName(useCase.getName()) : "";
        final String formBeanName = pattern.replaceFirst("\\{0\\}", useCaseName);
        final String triggerName = (!pattern.equals(formBeanName)) ? StringUtils.capitalize(this.getTriggerName()) : this.getTriggerName();

        return formBeanName.replaceFirst("\\{1\\}", triggerName);

    }

    /**
     * @see org.andromda.metafacades.uml.ModelElementFacade#getName()
     */
    @Override
    public String getName()
    {

        return GuiUtils.toWebResourceName(this.getUseCase().getName() + "-" + super.getName());

    }

    /**
     * @return useCase.getName()
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getTriggerName()
     */
    @Override
    protected String handleGetTriggerName()
    {

        String name = null;

        if (this.isExitingInitialState())
        {

            final GuiUseCase useCase = (GuiUseCase) this.getUseCase();

            if (useCase != null)
            {

                name = useCase.getName();

            }

        } else
        {

            final EventFacade trigger = this.getTrigger();
            final String suffix = (trigger == null) ? this.getTarget().getName() : trigger.getName();

            name = this.getSource().getName() + ' ' + suffix;

        }

        return StringUtilsHelper.lowerCamelCaseName(name);

    }

    /**
     * @return formImplementationName
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormImplementationName()
     */
    @Override
    protected String handleGetFormImplementationName()
    {

        final String pattern = ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.FORM_IMPLEMENTATION_PATTERN));

        return pattern.replaceFirst("\\{0\\}", StringUtils.capitalize(this.getTriggerName()));

    }

    /**
     * @return isTableAction
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedFormImplementationName()
     */
    @Override
    protected boolean handleIsTableAction()
    {

        return GuiGlobals.ACTION_TYPE_TABLE.equals(this.findTaggedValue(GuiProfile.TAGGEDVALUE_ACTION_TYPE));

    }

    /**
     * @return fullyQualifiedFormImplementationName
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedFormImplementationName()
     */
    @Override
    protected String handleGetFullyQualifiedFormImplementationName()
    {

        final StringBuilder fullyQualifiedName = new StringBuilder();
        final String packageName = this.getPackageName();

        if (StringUtils.isNotBlank(packageName))
        {

            fullyQualifiedName.append(packageName + ".");

        }

        return fullyQualifiedName.append(this.getFormImplementationName()).toString();

    }

    /**
     * @return fullyQualifiedFormImplementationPath
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedFormImplementationPath()
     */
    @Override
    protected String handleGetFullyQualifiedFormImplementationPath()
    {

        return this.getFullyQualifiedFormImplementationName().replace(".", GuiGlobals.SEPARATOR);

    }

    /**
     * @return scope
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedFormImplementationPath()
     */
    @Override
    protected String handleGetFormScope()
    {

        String scope = ObjectUtils.toString(this.findTaggedValue(GuiProfile.TAGGEDVALUE_ACTION_FORM_SCOPE));

        if (StringUtils.isEmpty(scope))
        {

            scope = ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.FORM_SCOPE));

        }

        return scope;

    }

    /**
     * @return formImplementationInterfaceList
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormImplementationInterfaceList()
     */
    @Override
    protected String handleGetFormImplementationInterfaceList()
    {

        final List<FrontEndControllerOperation> deferredOperations = this.getDeferredOperations();

        for (final Iterator<FrontEndControllerOperation> iterator = deferredOperations.iterator(); iterator.hasNext();)
        {

            // - remove any forms that don't have arguments
            final GuiControllerOperation operation = (GuiControllerOperation) iterator.next();

            if (operation.getArguments().isEmpty())
            {

                iterator.remove();

            }

        }

        final StringBuilder list = new StringBuilder();

        for (final Iterator<FrontEndControllerOperation> iterator = deferredOperations.iterator(); iterator.hasNext();)
        {

            final GuiControllerOperation operation = (GuiControllerOperation) iterator.next();

            list.append(operation.getFormName());

            if (iterator.hasNext())
            {

                list.append(", ");

            }

        }

        return list.toString();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiActionLogic#handleGetPath()
     */
    @Override
    protected String handleGetPath()
    {

        String path = this.getPathRoot() + GuiGlobals.SEPARATOR + GuiUtils.toWebResourceName(this.getTriggerName());

        if (this.isExitingInitialState())
        {

            final GuiUseCase useCase = (GuiUseCase) this.getUseCase();

            if ((useCase != null) && useCase.isViewHasNameOfUseCase())
            {

                // - add the uc prefix to make the trigger name unique
                // when a view contained within the use case has the same name
                // as the use case
                path = path + "uc";

            }

        }

        return path;

    }

    /**
     * @return pathRoot
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getPathRoot()
     */
    @Override
    protected String handleGetPathRoot()
    {

        final StringBuilder pathRoot = new StringBuilder();
        final GuiUseCase useCase = (GuiUseCase) this.getUseCase();

        if (useCase != null)
        {

            pathRoot.append(useCase.getPathRoot());

        }

        return pathRoot.toString();

    }

    /**
     * @return messageKey
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getMessageKey()
     */
    @Override
    protected String handleGetMessageKey()
    {

        String messageKey = null;

        final Object trigger = this.getTrigger();

        if (trigger instanceof GuiEvent)
        {

            final GuiEvent actionTrigger = (GuiEvent) trigger;

            messageKey = actionTrigger.getMessageKey();

        }

        return messageKey;

    }

    /**
     * @return documentationKey
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getDocumentationKey()
     */
    @Override
    protected String handleGetDocumentationKey()
    {

        final Object trigger = this.getTrigger();
        GuiEvent event = null;

        if (trigger instanceof GuiEvent)
        {

            event = (GuiEvent) trigger;

        }

        return ((event == null) ? (this.getMessageKey() + ".is.an.action.without.trigger") : event.getMessageKey()) + "." + GuiGlobals.DOCUMENTATION_MESSAGE_KEY_SUFFIX;

    }

    /**
     * @return documentationValue
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getDocumentationValue()
     */
    @Override
    protected String handleGetDocumentationValue()
    {

        final String value = StringUtilsHelper.toResourceMessage(this.getDocumentation("", 64, false));

        return (value == null) ? "" : value;

    }

    /**
     * @return viewFragmentPath
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getViewFragmentPath()
     */
    @Override
    protected String handleGetViewFragmentPath()
    {

        return GuiGlobals.SEPARATOR + this.getPackageName().replace(".", GuiGlobals.SEPARATOR) + GuiGlobals.SEPARATOR + GuiUtils.toWebResourceName(this.getTriggerName());

    }

    /**
     * @return tableLink
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getTableLinkName()
     */
    @Override
    protected String handleGetTableLinkName()
    {

        String tableLink = null;

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_ACTION_TABLELINK);

        if (value != null)
        {

            tableLink = StringUtils.trimToNull(value.toString());

            if (tableLink != null)
            {

                final int columnOffset = tableLink.indexOf(".");

                tableLink = (columnOffset == -1) ? tableLink : tableLink.substring(0, columnOffset);

            }

        }

        return tableLink;

    }

    /**
     * @return tableLink
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getTableLinkColumnName()
     */
    @Override
    protected String handleGetTableLinkColumnName()
    {

        String tableLink = null;
        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_ACTION_TABLELINK);

        if (value != null)
        {

            tableLink = StringUtils.trimToNull(value.toString());

            if (tableLink != null)
            {

                final int columnOffset = tableLink.indexOf(".");

                tableLink = ((columnOffset == -1) || (columnOffset == (tableLink.length() - 1))) ? null : tableLink.substring(columnOffset + 1);

            }

        }

        return tableLink;

    }

    /**
     * @return tableLinkParameter
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#isTableLink()
     */
    @Override
    protected Object handleGetTableLinkParameter()
    {

        GuiParameter tableLinkParameter = null;
        final String tableLinkName = this.getTableLinkName();

        if (tableLinkName != null)
        {

            final GuiView view = (GuiView) this.getInput();

            if (view != null)
            {

                final List<FrontEndParameter> tables = view.getTables();

                for (int ctr = 0; (ctr < tables.size()) && (tableLinkParameter == null); ctr++)
                {

                    final Object object = tables.get(ctr);

                    if (object instanceof GuiParameter)
                    {

                        final GuiParameter table = (GuiParameter) object;

                        if (tableLinkName.equals(table.getName()))
                        {

                            tableLinkParameter = table;

                        }

                    }

                }

            }

        }

        return tableLinkParameter;

    }

    /**
     * @return getTableLinkParameter() != null
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#isTableLink()
     */
    @Override
    protected boolean handleIsTableLink()
    {

        return this.getTableLinkParameter() != null;

    }

    /**
     * @return hyperlink
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#isHyperlink()
     */
    @Override
    protected boolean handleIsHyperlink()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_ACTION_TYPE);

        return GuiGlobals.ACTION_TYPE_HYPERLINK.equalsIgnoreCase((value == null) ? null : value.toString());

    }

    /**
     * @return StringUtilsHelper.upperCamelCaseName(this.getTriggerName())
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionClassName()
     */
    @Override
    protected String handleGetActionClassName()
    {

        return StringUtilsHelper.upperCamelCaseName(this.getTriggerName());

    }

    /**
     * @return fullyQualifiedActionClassPath
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedActionClassPath()
     */
    @Override
    protected String handleGetFullyQualifiedActionClassPath()
    {

        return this.getFullyQualifiedActionClassName().replace(".", GuiGlobals.SEPARATOR) + ".java";

    }

    /**
     * Overridden to provide the owning use case's package name.
     *
     * @see org.andromda.metafacades.uml.ModelElementFacade#getPackageName()
     */
    @Override
    public String getPackageName()
    {

        final UseCaseFacade useCase = this.getUseCase();

        return (useCase != null) ? useCase.getPackageName() : "";

    }

    /**
     * @return getTriggerName()
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getControllerAction()
     */
    @Override
    protected String handleGetControllerAction()
    {

        return this.getTriggerName();

    }

    /**
     * @return fullyQualifiedActionClassName
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedActionClassName()
     */
    @Override
    protected String handleGetFullyQualifiedActionClassName()
    {

        final StringBuilder path = new StringBuilder();
        final GuiUseCase useCase = (GuiUseCase) this.getUseCase();

        if (useCase != null)
        {

            final String packageName = useCase.getPackageName();

            if (StringUtils.isNotBlank(packageName))
            {

                path.append(packageName);
                path.append(".");

            }

        }

        path.append(this.getActionClassName());

        return path.toString();

    }

    /**
     * @return findTaggedValue(GuiProfile.TAGGEDVALUE_ACTION_RESETTABLE) isTrue
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#isResettable()
     */
    @Override
    protected boolean handleIsResettable()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_ACTION_RESETTABLE);

        return this.isTrue((value == null) ? null : value.toString());

    }

    /**
     * Convenient method to detect whether or not a String instance represents a boolean <code>true</code> value.
     */
    private boolean isTrue(final String string)
    {

        return "yes".equalsIgnoreCase(string) || "true".equalsIgnoreCase(string) || "on".equalsIgnoreCase(string) || "1".equalsIgnoreCase(string);

    }

    /**
     * @return otherActions
     */
    protected List<FrontEndAction> handleGetOtherUseCaseFormActions()
    {

        final List<FrontEndAction> otherActions = new ArrayList<FrontEndAction>(this.getUseCase().getActions());

        for (final Iterator<FrontEndAction> iterator = otherActions.iterator(); iterator.hasNext();)
        {

            final FrontEndAction action = iterator.next();

            // - remove this action and any forms that don't have form fields
            if (action.equals(this.THIS()) || action.getFormFields().isEmpty())
            {

                iterator.remove();

            }

        }

        return otherActions;

    }

    /**
     * @return hiddenParameters
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormKey()
     */
    @Override
    protected String handleGetFormKey()
    {

        final Object formKeyValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_ACTION_FORM_KEY);

        return (formKeyValue == null) ? ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.ACTION_FORM_KEY)) : String.valueOf(formKeyValue);

    }

    /**
     * @return hiddenParameters
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getHiddenParameters()
     */
    @Override
    protected List<GuiParameter> handleGetHiddenParameters()
    {

        final List<FrontEndParameter> hiddenParameters = new ArrayList<FrontEndParameter>(this.getParameters());

        CollectionUtils.filter(hiddenParameters, new Predicate()
        {

            @Override
            public boolean evaluate(final Object object)
            {

                boolean valid = false;

                if (object instanceof GuiParameter)
                {

                    final GuiParameter parameter = (GuiParameter) object;

                    valid = parameter.isInputHidden();

                    if (!valid)
                    {

                        for (final Iterator<GuiAttribute> iterator = parameter.getAttributes().iterator(); iterator.hasNext();)
                        {

                            final GuiAttribute attribute = iterator.next();

                            valid = attribute.isInputHidden();

                            if (valid)
                            {

                                break;

                            }

                        }

                    }

                }

                return valid;

            }

        });

        // TODO
        final List<GuiParameter> parameters = new ArrayList<GuiParameter>();

        for (final Iterator<FrontEndParameter> iterator = hiddenParameters.iterator(); iterator.hasNext();)
        {

            final Object actionForward = iterator.next();

            if (actionForward instanceof GuiParameter)
            {

                parameters.add((GuiParameter) actionForward);

            }

        }

        return parameters;

        // return hiddenParameters;
    }

    /**
     * @return required
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getHiddenParameters()
     */
    @Override
    protected boolean handleIsValidationRequired()
    {

        boolean required = false;

        for (final FrontEndParameter frontEndParam : this.getParameters())
        {

            if (frontEndParam instanceof GuiParameter)
            {

                final GuiParameter parameter = (GuiParameter) frontEndParam;

                if (parameter.isValidationRequired())
                {

                    required = true;

                    break;

                }

            }

        }

        return required;

    }

    /**
     * @return popup
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#isPopup()
     */
    @Override
    protected boolean handleIsPopup()
    {

        boolean popup = ObjectUtils.toString(this.findTaggedValue(GuiProfile.TAGGEDVALUE_ACTION_TYPE)).equalsIgnoreCase(GuiGlobals.VIEW_TYPE_POPUP);

        if (!popup)
        {

            for (final FrontEndView feView : this.getTargetViews())
            {

                final GuiView view = (GuiView) feView;

                popup = view.isPopup();

                if (!popup)
                {

                    break;

                }

            }

        }

        return popup;

    }

    /**
     * @return resetRequired
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormResetRequired()
     */
    @Override
    protected boolean handleIsFormResetRequired()
    {

        boolean resetRequired = this.isFormReset();

        if (!resetRequired)
        {

            for (final FrontEndParameter feParameter : this.getParameters())
            {

                if (feParameter instanceof GuiParameter)
                {

                    final GuiParameter parameter = (GuiParameter) feParameter;

                    resetRequired = parameter.isReset();

                    if (resetRequired)
                    {

                        break;

                    }

                }

            }

        }

        return resetRequired;

    }

    // TODO remove after 3.4 release
    /**
     * Hack to keep the compatibility with Andromda 3.4-SNAPSHOT
     * @return getSource() instanceof FrontEndView
     */
    @Override
    public FrontEndView getInput()
    {

        FrontEndView input = null;
        final ModelElementFacade source = this.getSource();

        if (source instanceof FrontEndView)
        {

            input = (FrontEndView) source;

        }

        return input;

    }

    /**
     * @return formSerialVersionUID
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormSerialVersionUID()
     */
    @Override
    protected String handleGetFormSerialVersionUID()
    {

        final StringBuilder buffer = new StringBuilder();

        buffer.append(this.getName());

        final ModelElementFacade input = this.getInput();

        buffer.append((input != null) ? input.getName() : "");

        final ModelElementFacade guard = this.getGuard();

        buffer.append((guard != null) ? guard.getName() : "");

        final ModelElementFacade effect = this.getEffect();

        buffer.append((effect != null) ? effect.getName() : "");

        final ModelElementFacade decisionsTrigger = this.getDecisionTrigger();

        buffer.append((decisionsTrigger != null) ? decisionsTrigger.getName() : "");

        buffer.append(StringUtils.trimToEmpty(this.getActionClassName()));

        for (final FrontEndParameter parameter : this.getParameters())
        {

            buffer.append(parameter.getName());

        }

        for (final FrontEndForward forward : this.getActionForwards())
        {

            buffer.append(forward.getName());

        }

        for (final FrontEndAction action : this.getActions())
        {

            buffer.append(action.getName());

        }

        for (final FrontEndActionState state : this.getActionStates())
        {

            buffer.append(state.getName());

        }

        final String signature = buffer.toString();

        String serialVersionUID = String.valueOf(0L);

        try
        {

            final MessageDigest md = MessageDigest.getInstance("SHA");
            final byte[] hashBytes = md.digest(signature.getBytes());

            long hash = 0;

            for (int ctr = Math.min(hashBytes.length, 8) - 1; ctr >= 0; ctr--)
            {

                hash = (hash << 8) | (hashBytes[ctr] & 0xFF);

            }

            serialVersionUID = String.valueOf(hash);

        }
        catch (final NoSuchAlgorithmException exception)
        {

            final String message = "Error performing GuiAction.getFormSerialVersionUID";

            GuiActionLogicImpl.LOGGER.error(message, exception);

        }

        return serialVersionUID;

    }

    /**
     * @return findTaggedValue(GuiProfile.TAGGEDVALUE_ACTION_FORM_RESET)
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormResetRequired()
     */
    @Override
    protected boolean handleIsFormReset()
    {

        return Boolean.valueOf(ObjectUtils.toString(this.findTaggedValue(GuiProfile.TAGGEDVALUE_ACTION_FORM_RESET))).booleanValue();

    }

    /**
     * @return "get" + StringUtils.capitalize(this.getFormBeanName(false)) + "()"
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormImplementationGetter()
     */
    @Override
    protected String handleGetFormImplementationGetter()
    {

        return "get" + StringUtils.capitalize(this.getFormBeanName(false)) + "()";

    }

    /**
     * @return getTarget() instanceof GuiFinalState
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFinalStateTarget()
     */
    @Override
    protected boolean handleIsFinalStateTarget()
    {

        return this.getTarget() instanceof GuiFinalState;

    }

    /**
     * @return getName()
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFromOutcome()
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
     *         will have been recorded
     */
    private Map<String, String> getMessages(final String taggedValue)
    {

        Map<String, String> messages;

        final Collection<Object> taggedValues = this.findTaggedValues(taggedValue);

        if (taggedValues.isEmpty())
        {

            messages = Collections.EMPTY_MAP;

        } else
        {

            messages = new LinkedHashMap<String, String>(); // we want to keep the order

            for (final Object tag : taggedValues)
            {

                final String value = (String) tag;

                messages.put(StringUtilsHelper.toResourceMessageKey(value), value);

            }

        }

        return messages;

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiActionLogic#handleIsSuccessMessagesPresent()
     */
    @Override
    protected boolean handleIsSuccessMessagesPresent()
    {

        return !this.getSuccessMessages().isEmpty();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiActionLogic#handleGetSuccessMessages()
     */
    @Override
    protected Map handleGetSuccessMessages()
    {

        return this.getMessages(GuiProfile.TAGGEDVALUE_ACTION_SUCCESS_MESSAGE);

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiActionLogic#handleIsWarningMessagesPresent()
     */
    @Override
    protected boolean handleIsWarningMessagesPresent()
    {

        return !this.getWarningMessages().isEmpty();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiActionLogic#handleGetWarningMessages()
     */
    @Override
    protected Map<String, String> handleGetWarningMessages()
    {

        return this.getMessages(GuiProfile.TAGGEDVALUE_ACTION_WARNING_MESSAGE);

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiActionLogic#handleIsErrorMessagesPresent()
     */
    @Override
    protected boolean handleIsErrorMessagesPresent()
    {

        return !this.getErrorMessages().isEmpty();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiActionLogic#handleGetErrorMessages()
     */
    @Override
    protected Map handleGetErrorMessages()
    {

        return this.getMessages(GuiProfile.TAGGEDVALUE_ACTION_ERROR_MESSAGE);

    }

    /**
     * @return needsFileUpload
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#isNeedsFileUpload()
     */
    @Override
    protected boolean handleIsNeedsFileUpload()
    {

        if (this.getParameters().size() == 0)
        {

            return false;

        }

        for (final FrontEndParameter feParameter : this.getParameters())
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

                    for (final Iterator attributes = parameter.getAttributes().iterator(); attributes.hasNext();)
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
     * @see org.andromda.cartridges.gui.metafacades.GuiAction#getTriggerMethodName
     */
    @Override
    protected String handleGetTriggerMethodName()
    {

        final StringBuilder methodName = new StringBuilder();

        if (this.isExitingInitialState())
        {

            final GuiUseCase useCase = (GuiUseCase) this.getUseCase();

            methodName.append(StringUtilsHelper.lowerCamelCaseName(useCase.getName()) + "_started");

        } else
        {

            methodName.append(StringUtilsHelper.lowerCamelCaseName(this.getSource().getName()));
            methodName.append('_');

            final EventFacade trigger = this.getTrigger();
            final String suffix = (trigger == null) ? this.getTarget().getName() : trigger.getName();

            methodName.append(StringUtilsHelper.lowerCamelCaseName(suffix));

        }

        return "_" + methodName.toString();

    }

    @Override
    protected java.lang.String handleGetActionName()
    {

        return this.getFormBeanName();

    }

    @Override
    protected java.lang.String handleGetActionPath()
    {

        return this.getActionPathRoot() + GuiGlobals.SEPARATOR + this.getActionClassName();

    }

    @Override
    protected java.lang.String handleGetActionInput()
    {

        final StateVertexFacade source = this.getSource();

        return (source instanceof GuiView) ? ((GuiView) source).getFullPath() : "";

    }

    @Override
    protected java.lang.String handleGetActionRoles()
    {

        final Collection<Role> users = this.getRoleUsers();
        final StringBuffer roles = new StringBuffer();

        for (final Iterator<Role> userIterator = users.iterator(); userIterator.hasNext();)
        {

            roles.append(userIterator.next().getName());

            if (userIterator.hasNext())
            {

                roles.append(",");

            }

        }

        return roles.toString();

    }

    /**
     * Returns a collection containing GuiUser instances representing the roles
     * authorized to call this action. If this action starts the use-case that use-case's users
     * are returned, otherwise it will return the users associated to the use-cases targetted by this
     * action (which may be none at all)
     */
    private Collection<Role> getRoleUsers()
    {

        final Collection<Role> roleUsers = new ArrayList<Role>();

        if (this.isUseCaseStart())
        {

            final FrontEndUseCase useCase = this.getUseCase();

            if (useCase != null)
            {

                roleUsers.addAll(useCase.getRoles());

            }

        } else
        {

            for (final Object element : this.getActionForwards())
            {

                final TransitionFacade transition = (TransitionFacade) element;

                if (transition.getTarget() instanceof GuiFinalState)
                {

                    final FrontEndUseCase useCase = ((GuiFinalState) transition.getTarget()).getTargetUseCase();

                    if (useCase != null)
                    {

                        roleUsers.addAll(useCase.getRoles());

                    }

                }

            }

        }

        return roleUsers;

    }

    @Override
    protected boolean handleIsFormPost()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_ACTION_TYPE);

        return (value == null) || GuiGlobals.ACTION_TYPE_FORM.equals(value);

    }

    // TODO REMOVE
    @Override
    protected boolean handleIsDateFieldPresent()
    {

        final Collection<GuiParameter> actionParameters = this.getActionParametersToDeletes();

        for (final GuiParameter guiParameter : actionParameters)
        {

            final GuiParameter parameter = guiParameter;

            if (parameter.isDate())
            {

                return true;

            }

        }

        return false;

    }

    // TODO REMOVE
    @Override
    protected boolean handleIsCalendarRequired()
    {

        final Collection<GuiParameter> actionParameters = this.getActionParametersToDeletes();

        for (final GuiParameter guiParameter : actionParameters)
        {

            final GuiParameter parameter = guiParameter;

            if (parameter.isCalendarRequired())
            {

                return true;

            }

        }

        return false;

    }

    @Override
    protected java.util.List<ModelElementFacade> handleGetInterUseCaseParameters(final GuiFinalState finalState)
    {

        List<ModelElementFacade> parameters;

        if (finalState == null)
        {

            parameters = Collections.EMPTY_LIST;

        } else
        {

            // we don't want to list parameters with the same name to we use a hash map
            final Map<String, ModelElementFacade> parameterMap = new HashMap<String, ModelElementFacade>();

            final List<FrontEndForward> transitions = this.getActionForwards();

            for (int i = 0; i < transitions.size(); i++)
            {

                final GuiForward forward = (GuiForward) transitions.get(i);

                // only return those parameters that belong to both this action and the argument final state
                if (finalState.equals(forward.getTarget()))
                {

                    final List<FrontEndParameter> forwardParameters = forward.getForwardParameters();

                    for (int j = 0; j < forwardParameters.size(); j++)
                    {

                        final ModelElementFacade parameter = forwardParameters.get(j);

                        parameterMap.put(parameter.getName(), parameter);

                    }

                }

            }

            parameters = new ArrayList<ModelElementFacade>(parameterMap.values());

        }

        return parameters;

    }

    // TODO REMOVE
    @Override
    protected java.util.List<FrontEndExceptionHandler> handleGetActionExceptionsToDeletes()
    {

        final Collection<FrontEndExceptionHandler> exceptions = new LinkedHashSet<FrontEndExceptionHandler>();
        final Collection<FrontEndActionState> actionStates = this.getActionStates();

        for (final Object element : actionStates)
        {

            final GuiActionState actionState = (GuiActionState) element;

            exceptions.addAll(actionState.getExceptions());

        }

        return new ArrayList<FrontEndExceptionHandler>(exceptions);

    }

    // TODO REMOVE
    @Override
    protected java.util.List<ParameterFacade> handleGetActionParametersToDeletes()
    {

        final GuiTrigger trigger = this.getActionTriggerToDelete();

        return (trigger == null) ? Collections.EMPTY_LIST : new ArrayList<ParameterFacade>(trigger.getParameters());

    }

    // TODO REMOVE
    @Override
    protected java.lang.Object handleGetActionTriggerToDelete()
    {

        return this.getTrigger();

    }

    // TODO REMOVE
    @Override
    protected java.util.List<GuiParameter> handleGetActionFormFieldsToDeletes()
    {

        final Map<String, GuiParameter> formFieldMap = new HashMap<String, GuiParameter>();

        /**
         * for useCaseStart actions we need to detect all usecases forwarding to the one belonging to this action
         * if there are any parameters in those requests we need to have them included in this action's form
         */
        if (this.isUseCaseStart())
        {

            final FrontEndUseCase useCase = this.getUseCase();

            if (useCase != null)
            {

                final Collection<FrontEndFinalState> finalStates = useCase.getReferencingFinalStates();

                for (final Iterator<FrontEndFinalState> finalStateIterator = finalStates.iterator(); finalStateIterator.hasNext();)
                {

                    final Object finalStateObject = finalStateIterator.next();

                    // we need to test for the type because a non struts-use-case final state might accidently
                    // we linking to this use-case (for example: the user temporarily wants to disable code generation
                    // for a specific use-case and is not removing the final-state to use-case link(s))
                    if (finalStateObject instanceof GuiFinalState)
                    {

                        final GuiFinalState finalState = (GuiFinalState) finalStateObject;
                        final Collection<FrontEndParameter> parameters = finalState.getInterUseCaseParameters();

                        for (final FrontEndParameter frontEndParameter : parameters)
                        {

                            final GuiParameter parameter = (GuiParameter) frontEndParameter;

                            formFieldMap.put(parameter.getName(), parameter);

                        }

                    }

                }

            }

        }

        // if any action encountered by the execution of the complete action-graph path emits a forward
        // containing one or more parameters they need to be included as a form field too
        final Collection<FrontEndActionState> actionStates = this.getActionStates();

        for (final FrontEndActionState frontEndActionState : actionStates)
        {

            if (frontEndActionState instanceof GuiActionState)
            {

                final GuiActionState actionState = (GuiActionState) frontEndActionState;
                final GuiForward forward = (GuiForward) actionState.getForward();

                if (forward != null)
                {

                    final Collection<FrontEndParameter> forwardParameters = forward.getForwardParameters();

                    for (final FrontEndParameter frontEndParameter : forwardParameters)
                    {

                        final GuiParameter forwardParameter = (GuiParameter) frontEndParameter;

                        formFieldMap.put(forwardParameter.getName(), forwardParameter);

                    }

                }

            }

        }

        // add page variables for all pages/final-states targetted
        // also add the fields of the target page's actions (for preloading)
        final Collection<FrontEndForward> forwards = this.getActionForwards();

        for (final FrontEndForward frontEndForward : forwards)
        {

            final GuiForward forward = (GuiForward) frontEndForward;
            final StateVertexFacade target = forward.getTarget();

            if (target instanceof GuiView)
            {

                final GuiView xml = (GuiView) target;
                final Collection<GuiParameter> pageVariables = xml.getPageVariables();

                for (final GuiParameter guiParameter : pageVariables)
                {

                    // final ModelElementFacade facade = guiParameter;

                    // formFieldMap.put(facade.getName(), facade);
                    formFieldMap.put(guiParameter.getName(), guiParameter);

                }

                final Collection<FrontEndParameter> allActionParameters = xml.getAllActionParameters();

                for (final FrontEndParameter frontEndParameter : allActionParameters)
                {

                    // final ModelElementFacade facade = frontEndParameter;
                    final GuiParameter facade = (GuiParameter) frontEndParameter;

                    formFieldMap.put(facade.getName(), facade);

                }

            } else if (target instanceof GuiFinalState)
            {

                // only add these if there is no parameter recorded yet with the same name
                final Collection<FrontEndParameter> forwardParameters = forward.getForwardParameters();

                for (final FrontEndParameter frontEndParameter : forwardParameters)
                {

                    // final ModelElementFacade facade = frontEndParameter;
                    final GuiParameter facade = (GuiParameter) frontEndParameter;

                    if (!formFieldMap.containsKey(facade.getName()))
                    {

                        formFieldMap.put(facade.getName(), facade);

                    }

                }

            }

        }

        // we do the action parameters in the end because they are allowed to overwrite existing properties
        final Collection<GuiParameter> actionParameters = this.getActionParametersToDeletes();

        for (final GuiParameter guiParameter : actionParameters)
        {

            // final ModelElementFacade facade = guiParameter;

            // formFieldMap.put(facade.getName(), facade);
            formFieldMap.put(guiParameter.getName(), guiParameter);

        }

        // return new ArrayList<ModelElementFacade>(formFieldMap.values());
        return new ArrayList<GuiParameter>(formFieldMap.values());

    }

    @Override
    protected java.util.List<StateVertexFacade> handleGetTargetPages()
    {

        final Collection<StateVertexFacade> targetPages = new LinkedHashSet<StateVertexFacade>();

        final Collection<FrontEndForward> forwards = this.getActionForwards();

        for (final FrontEndForward frontEndForward : forwards)
        {

            final GuiForward forward = (GuiForward) frontEndForward;

            if (forward.isEnteringPage())
            {

                targetPages.add(forward.getTarget());

            }

        }

        return new ArrayList<StateVertexFacade>(targetPages);

    }

    // TODO REMOVE
    @Override
    protected java.util.List<GuiParameter> handleGetResettableActionParameters()
    {

        return new ArrayList<GuiParameter>(new FilteredCollection(this.getActionParametersToDeletes())
        {

            @Override
            public boolean evaluate(final Object object)
            {

                return (object != null) && ((GuiParameter) object).isShouldReset();

            }

        });

    }

    // TODO REMOVE
    @Override
    protected java.util.List<GuiParameter> handleGetTableNonColumnFormParameters()
    {

        List<GuiParameter> tableNonColumnActionParameters = null;

        final GuiParameter table = this.getTableLinkParameter();

        if (table != null)
        {

            final Map<String, GuiParameter> tableNonColumnActionParametersMap = new LinkedHashMap<String, GuiParameter>(4);
            final Collection<String> columnNames = table.getTableColumnNames();
            final List<GuiAction> formActions = table.getTableFormActions();

            for (int i = 0; i < formActions.size(); i++)
            {

                final GuiAction action = formActions.get(i);

                for (int j = 0; j < action.getActionParametersToDeletes().size(); j++)
                {

                    final GuiParameter parameter = action.getActionParametersToDeletes().get(j);

                    if (!columnNames.contains(parameter.getName()))
                    {

                        tableNonColumnActionParametersMap.put(parameter.getName(), parameter);

                    }

                }

            }

            tableNonColumnActionParameters = new ArrayList<GuiParameter>(tableNonColumnActionParametersMap.values());

        }

        return tableNonColumnActionParameters;

    }

    // TODO REMOVE
    @Override
    protected java.util.List<GuiParameter> handleGetHiddenActionParameters()
    {

        final List<GuiParameter> hiddenActionParameters = new ArrayList<GuiParameter>(this.getActionParametersToDeletes());

        CollectionUtils.filter(hiddenActionParameters, new Predicate()
        {

            @Override
            public boolean evaluate(final Object object)
            {

                return GuiGlobals.INPUT_HIDDEN.equals(((GuiParameter) object).getWidgetType());

            }

        });

        return hiddenActionParameters;

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiActionLogic#handleGetFormBeanClassName()
     */
    @Override
    protected String handleGetFormBeanClassName()
    {

        return this.getActionClassName() + GuiGlobals.FORM_IMPLEMENTATION_SUFFIX;

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiActionLogic#handleGetFormValidationMethodName()
     */
    @Override
    protected String handleGetFormValidationMethodName()
    {

        return "validate" + this.getActionClassName() + GuiGlobals.FORM_SUFFIX;

    }

    /**
     * @see org.andromda.cartridges.guimetafacades.GuiActionLogic#handleGetFullActionPath()
     */
    @Override
    protected String handleGetFullActionPath()
    {

        return this.getPackagePath() + GuiGlobals.SEPARATOR + this.getActionClassName();

    }

    /**
     * @see org.andromda.cartridges.guimetafacades.GuiActionLogic#handleGetFullFormBeanPath()
     */
    @Override
    protected String handleGetFullFormBeanPath()
    {

        return GuiGlobals.SEPARATOR + (this.getPackageName() + GuiGlobals.SEPARATOR + this.getFormBeanClassName()).replace(".", GuiGlobals.SEPARATOR);

    }

    /**
     * @see org.andromda.cartridges.guimetafacades.GuiActionLogic#handleGetActionPathRoot()
     */
    @Override
    protected String handleGetActionPathRoot()
    {

        String actionPathRoot = null;

        final FrontEndUseCase useCase = this.getUseCase();

        if (useCase != null)
        {

            final StringBuilder buffer = new StringBuilder();

            final String actionPathPrefix = GuiGlobals.PROPERTY_ACTION_PATH_PREFIX;
            String prefix = this.isConfiguredProperty(actionPathPrefix) ? ObjectUtils.toString(this.getConfiguredProperty(actionPathPrefix)) : "";

            final ModelElementFacade useCasePackage = useCase.getPackage();

            if (useCasePackage != null)
            {

                prefix = prefix.replaceAll("\\{0\\}", useCasePackage.getPackagePath());

            }

            buffer.append(prefix);
            buffer.append(GuiGlobals.SEPARATOR);
            buffer.append(StringUtilsHelper.upperCamelCaseName(useCase.getName()));

            actionPathRoot = buffer.toString();

        }

        return actionPathRoot;

    }

    /**
     * @see org.andromda.cartridges.guimetafacades.GuiActionLogic#handleGetFormBeanType()
     */
    @Override
    protected String handleGetFormBeanType()
    {

        return this.getFormBeanPackageName() + "." + this.getFormBeanClassName();

    }

    /**
     * @see org.andromda.cartridges.guimetafacades.GuiActionLogic#handleGetFullTilePath()
     */
    @Override
    protected String handleGetFullTilePath()
    {

        return this.isUseCaseStart() ? "empty-file" : (this.getPackagePath() + GuiGlobals.SEPARATOR + GuiUtils.toWebFileName(this.getActionClassName()));

    }

    /**
     * @see org.andromda.cartridges.guimetafacades.GuiActionLogic#handleGetOnlineHelpKey()
     */
    @Override
    // TODO REMOVE
    protected String handleGetOnlineHelpKey()
    {

        // TODO
        // return handleGetDocumentationKey();
        final GuiTrigger trigger = this.getActionTriggerToDelete();

        return ((trigger == null) ? (this.getMessageKey() + ".is.an.action.without.trigger") : trigger.getTriggerKey()) + ".online.help";

    }

    /**
     * @see org.andromda.cartridges.guimetafacades.GuiActionLogic#handleGetOnlineHelpValue()
     */
    @Override
    // TODO REMOVE
    protected String handleGetOnlineHelpValue()
    {

        final String crlf = "<br/>";
        final StringBuilder buffer = new StringBuilder();

        final String value = StringUtilsHelper.toResourceMessage(this.getDocumentation("", 64, false));

        buffer.append((value == null) ? "No action documentation has been specified" : value);
        buffer.append(crlf);

        return StringUtilsHelper.toResourceMessage(buffer.toString());

    }

    /**
     * @see org.andromda.cartridges.guimetafacades.GuiActionLogic#handleGetActionScope()
     */
    @Override
    protected String handleGetActionScope()
    {

        return "request";

    }

    /**
     * @see org.andromda.cartridges.guimetafacades.GuiActionLogic#handleGetFormBeanPackageName()
     */
    @Override
    protected String handleGetFormBeanPackageName()
    {

        return this.getPackageName();

    }

    /**
     * @see org.andromda.cartridges.guimetafacades.GuiActionLogic#handleGetActionType()
     */
    @Override
    protected String handleGetActionType()
    {

        return this.getPackageName() + "." + this.getActionClassName();

    }

    /**
     * @return getActionTrigger().getName() lowerCamelCaseName
     * @see org.andromda.cartridges.guimetafacades.GuiAction#getStyleId()
     */
    @Override
    // TODO REMOVE
    protected String handleGetStyleId()
    {

        String styleId = null;

        final GuiTrigger trigger = this.getActionTriggerToDelete();

        if (trigger != null)
        {

            final String triggerName = trigger.getName();

            styleId = StringUtilsHelper.lowerCamelCaseName(triggerName);

        }

        return styleId;

    }

    /**
     * @return GuiProfile.TAGGEDVALUE_ACTION_REDIRECT
     * @see org.andromda.cartridges.guimetafacades.GuiAction#isRedirect()
     */
    @Override
    protected boolean handleIsRedirect()
    {

        String redirect = (String) this.getConfiguredProperty(GuiGlobals.PROPERTY_DEFAULT_ACTION_REDIRECT);
        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_ACTION_REDIRECT);

        if (value != null)
        {

            redirect = (String) value;

        }

        return Boolean.valueOf(StringUtils.trimToEmpty(redirect));

    }

    /**
     * @return getFormScope().equalsIgnoreCase(FORM_SCOPE_SESSION)
     * @see org.andromda.cartridges.guimetafacades.GuiAction#isFormScopeSession()
     */
    @Override
    protected boolean handleIsFormScopeSession()
    {

        return GuiActionLogicImpl.FORM_SCOPE_SESSION.equalsIgnoreCase(this.getFormScope());

    }

    /**
     * @return getFormScope().equalsIgnoreCase(FORM_SCOPE_REQUEST)
     * @see org.andromda.cartridges.guimetafacades.GuiAction#isFormScopeRequest()
     */
    @Override
    protected boolean handleIsFormScopeRequest()
    {

        return GuiActionLogicImpl.FORM_SCOPE_REQUEST.equalsIgnoreCase(this.getFormScope());

    }

    /**
     * @return getFormScope().equalsIgnoreCase(FORM_SCOPE_NONE)
     * @see org.andromda.cartridges.guimetafacades.GuiAction#isFormScopeNone()
     */
    @Override
    protected boolean handleIsFormScopeNone()
    {

        return this.getFormScope().equalsIgnoreCase(GuiActionLogicImpl.FORM_SCOPE_NONE);

    }

    /**
     * The "session" action form scope.
     */
    private static final String FORM_SCOPE_SESSION = "session";

    /**
     * The "request" action form scope.
     */
    private static final String FORM_SCOPE_REQUEST = "request";

    /**
     * The "none" action form scope.
     */
    private static final String FORM_SCOPE_NONE    = "none";

    /**
     * @see org.andromda.cartridges.guimetafacades.GuiActionLogic#handleIsImageLink()
     */
    @Override
    protected boolean handleIsImageLink()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_ACTION_TYPE);

        return GuiGlobals.ACTION_TYPE_IMAGE.equalsIgnoreCase((value == null) ? null : value.toString());

    }

    /**
     * @see org.andromda.cartridges.guimetafacades.GuiActionLogic#handleGetImagePath()
     */
    @Override
    protected String handleGetImagePath()
    {

        return this.getPackagePath() + GuiGlobals.SEPARATOR + GuiUtils.toWebFileName(this.getActionClassName()) + ".gif";

    }

    /**
     * @see org.andromda.cartridges.guimetafacades.GuiActionLogic#handleGetImageMessageKey()
     */
    @Override
    protected String handleGetImageMessageKey()
    {

        return this.getMessageKey() + ".image";

    }

    /**
     * @see org.andromda.cartridges.guimetafacades.GuiActionLogic#handleIsTableRowAction()
     */
    @Override
    protected boolean handleIsTableRowAction()
    {

        return this.isTableLink() && !this.isTableAction();

    }

    /**
     * @see org.andromda.cartridges.guimetafacades.GuiActionLogic#handleIsMultipartFormData()
     */
    @Override
    // TODO REMOVE
    protected boolean handleIsMultipartFormData()
    {

        boolean multipartFormPost = false;

        for (final GuiParameter field : this.getActionFormFieldsToDeletes())
        {

            if (field.isFile())
            {

                multipartFormPost = true;

                break;

            }

        }

        return multipartFormPost;

    }

}

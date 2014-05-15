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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.andromda.cartridges.gui.GuiGlobals;
import org.andromda.cartridges.gui.GuiProfile;
import org.andromda.cartridges.gui.GuiUtils;
import org.andromda.metafacades.uml.AssociationEndFacade;
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.EventFacade;
import org.andromda.metafacades.uml.FrontEndAction;
import org.andromda.metafacades.uml.FrontEndActivityGraph;
import org.andromda.metafacades.uml.FrontEndForward;
import org.andromda.metafacades.uml.FrontEndParameter;
import org.andromda.metafacades.uml.FrontEndView;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.TransitionFacade;
import org.andromda.metafacades.uml.UMLMetafacadeUtils;
import org.andromda.metafacades.uml.UMLProfile;
import org.andromda.metafacades.uml.UseCaseFacade;
import org.andromda.utils.StringUtilsHelper;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiParameter.
 *
 * @see org.andromda.cartridges.gui.metafacades.GuiParameter
 */
public class GuiParameterLogicImpl extends GuiParameterLogic
{

    private static final long serialVersionUID = 34L;
    private final Logger      logger_          = Logger.getLogger(GuiParameterLogicImpl.class);

    /**
     * @param metaObject
     * @param context
     */
    public GuiParameterLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * Overridden to make sure it's not an inputTable.
     *
     * @see org.andromda.metafacades.uml.FrontEndParameter#isTable()
     */
    @Override
    public boolean isTable()
    {

        return (super.isTable() || this.isPageableTable()) && !this.isSelectable() && !this.isInputTable() && !this.isInputHidden();

    }

    /**
     * @return isPageableTable
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isPageableTable()
     */
    @Override
    protected boolean handleIsPageableTable()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_TABLE_PAGEABLE);

        return Boolean.valueOf(ObjectUtils.toString(value)).booleanValue();

    }

    /**
     * @return messageKey
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getMessageKey()
     */
    @Override
    protected String handleGetMessageKey()
    {

        final StringBuilder messageKey = new StringBuilder();

        if (!this.isNormalizeMessages())
        {

            if (this.isActionParameter())
            {

                final GuiAction action = (GuiAction) this.getAction();

                if (action != null)
                {

                    messageKey.append(action.getMessageKey());
                    messageKey.append(".");

                }

            } else
            {

                final GuiView view = (GuiView) this.getView();

                if (view != null)
                {

                    messageKey.append(view.getMessageKey());
                    messageKey.append(".");

                }

            }

            messageKey.append("param.");

        }

        messageKey.append(StringUtilsHelper.toResourceMessageKey(super.getName()));

        return messageKey.toString();

    }

    /**
     * @return getMessageKey() + "." + GuiGlobals.DOCUMENTATION_MESSAGE_KEY_SUFFIX
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getDocumentationKey()
     */
    @Override
    protected String handleGetDocumentationKey()
    {

        return this.getMessageKey() + "." + GuiGlobals.DOCUMENTATION_MESSAGE_KEY_SUFFIX;

    }

    /**
     * @return documentationValue
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getDocumentationValue()
     */
    @Override
    protected String handleGetDocumentationValue()
    {

        final String value = StringUtilsHelper.toResourceMessage(this.getDocumentation("", 64, false));

        return (value == null) ? "" : value;

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
     * @return messageValue
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getMessageValue()
     */
    @Override
    protected String handleGetMessageValue()
    {

        return StringUtilsHelper.toPhrase(super.getName()); // the actual name is used for displaying

    }

    /**
     * @param columnName
     * @return tableColumnMessageKey
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getTableColumnMessageKey(String)
     */
    @Override
    protected String handleGetTableColumnMessageKey(final String columnName)
    {

        final StringBuilder messageKey = new StringBuilder();

        if (!this.isNormalizeMessages())
        {

            final GuiView view = (GuiView) this.getView();

            if (view != null)
            {

                messageKey.append(this.getMessageKey());
                messageKey.append(".");

            }

        }

        messageKey.append(StringUtilsHelper.toResourceMessageKey(columnName));

        return messageKey.toString();

    }

    /**
     * @param columnName
     * @return StringUtilsHelper.toPhrase(columnName)
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getTableColumnMessageValue(String)
     */
    @Override
    protected String handleGetTableColumnMessageValue(final String columnName)
    {

        return StringUtilsHelper.toPhrase(columnName);

    }

    /**
     * @return getTableActions(true)
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getTableHyperlinkActions()
     */
    @Override
    protected List<GuiAction> handleGetTableHyperlinkActions()
    {

        return this.getTableActions(true);

        // return this.internalGetTableActions(true, false, false);
    }

    /**
     * If this is a table this method returns all those actions that are declared to work
     * on this table.
     *
     * @param hyperlink denotes on which type of actions to filter
     */
    private List<GuiAction> getTableActions(final boolean hyperlink)
    {

        final Set<GuiAction> actions = new LinkedHashSet<GuiAction>();
        final String name = StringUtils.trimToNull(this.getName());

        if ((name != null) && this.isTable())
        {

            final GuiView view = (GuiView) this.getView();

            final Collection<UseCaseFacade> allUseCases = this.getModel().getAllUseCases();

            for (final UseCaseFacade useCase : allUseCases)
            {

                if (useCase instanceof GuiUseCase)
                {

                    final FrontEndActivityGraph graph = ((GuiUseCase) useCase).getActivityGraph();

                    if (graph != null)
                    {

                        final Collection<TransitionFacade> transitions = graph.getTransitions();

                        for (final TransitionFacade transition : transitions)
                        {

                            if (transition.getSource().equals(view) && (transition instanceof GuiAction))
                            {

                                final GuiAction action = (GuiAction) transition;

                                if (action.isTableLink() && name.equals(action.getTableLinkName()))
                                {

                                    if (hyperlink == action.isHyperlink())
                                    {

                                        actions.add(action);

                                    }

                                }

                            }

                        }

                    }

                }

            }

        }

        return new ArrayList<GuiAction>(actions);

    }

    /**
     * @return getTableActions(false)
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getTableFormActions()
     */
    @Override
    protected List<GuiAction> handleGetTableFormActions()
    {

        return this.getTableActions(false);

        // return this.internalGetTableActions(false, true, false);
    }

    /**
     * @see org.andromda.metafacades.uml.FrontEndParameter#getTableColumns()
     */

    // TODO tableColumns can be either String or GuiParameter. Should use a single return type in Collection.
    @Override
    public Collection getTableColumns()
    {

        final Collection tableColumns = super.getTableColumns();

        if (tableColumns.isEmpty())
        {

            // try to preserve the order of the elements encountered
            // final Map<String, GuiParameter> tableColumnsMap = new LinkedHashMap<String, GuiParameter>();
            final Map tableColumnsMap = new LinkedHashMap();

            // order is important
            final List<GuiAction> actions = new ArrayList<GuiAction>();

            // all table actions need the exact same parameters, just not always all of them
            actions.addAll(this.getTableFormActions());

            // if there are any actions that are hyperlinks then their parameters get priority
            // the user should not have modeled it that way (constraints will warn him/her)
            actions.addAll(this.getTableHyperlinkActions());

            for (final GuiAction action : actions)
            {

                for (final FrontEndParameter actionParameter : action.getParameters())
                {

                    if (actionParameter instanceof GuiParameter)
                    {

                        final GuiParameter parameter = (GuiParameter) actionParameter;
                        final String parameterName = parameter.getName();

                        if (parameterName != null)
                        {

                            // never overwrite column specific table links
                            // the hyperlink table links working on a real column get priority
                            final Object existingObject = tableColumnsMap.get(parameterName);

                            if (existingObject instanceof GuiParameter)
                            {

                                if (action.isHyperlink() && parameterName.equals(action.getTableLinkColumnName()))
                                {

                                    tableColumnsMap.put(parameterName, parameter);

                                }

                            }

                        }

                    }

                }

            }

            // for any missing parameters we just add the name of the column
            for (final String columnName : this.getTableColumnNames())
            {

                if (!tableColumnsMap.containsKey(columnName))
                {

                    tableColumnsMap.put(columnName, columnName);

                }

            }

            // return everything in the same order as it has been modeled (using the table tagged value)
            for (final String columnObject : this.getTableColumnNames())
            {

                tableColumns.add(tableColumnsMap.get(columnObject));

            }

        }

        return tableColumns;

    }

    /**
     * @return the default date format pattern as defined using the configured property
     */
    private String getDefaultDateFormat()
    {

        return (String) this.getConfiguredProperty(GuiGlobals.PROPERTY_DEFAULT_DATEFORMAT);

    }

    /**
     * @return format
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getFormat()
     */
    @Override
    protected String handleGetFormat()
    {

        return GuiUtils.getFormat((ModelElementFacade) this.THIS(), this.getType(), this.getDefaultDateFormat(), this.getDefaultTimeFormat());

    }

    /**
     * @return the default time format pattern as defined using the configured property
     */
    private String getDefaultTimeFormat()
    {

        return (String) this.getConfiguredProperty(GuiGlobals.PROPERTY_DEFAULT_TIMEFORMAT);

    }

    /**
     * @return GuiUtils.isStrictDateFormat((ModelElementFacade)this.THIS())
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isStrictDateFormat()
     */
    @Override
    protected boolean handleIsStrictDateFormat()
    {

        return GuiUtils.isStrictDateFormat((ModelElementFacade) this.THIS());

    }

    /**
     * @return dateFormatter
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getDateFormatter()
     */
    @Override
    protected String handleGetDateFormatter()
    {

        final ClassifierFacade type = this.getType();

        return ((type != null) && type.isDateType()) ? (this.getName() + "DateFormatter") : null;

    }

    /**
     * @return timeFormatter
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getTimeFormatter()
     */
    @Override
    protected String handleGetTimeFormatter()
    {

        final ClassifierFacade type = this.getType();

        return ((type != null) && type.isTimeType()) ? (this.getName() + "TimeFormatter") : null;

    }

    /**
     * Gets the current value of the specified input type (or an empty string
     * if one isn't specified).
     *
     * @return the input type name.
     */
    private String getInputType()
    {

        return ObjectUtils.toString(this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_TYPE)).trim();

    }

    /**
     * Indicates whether or not this parameter is of the given input type.
     *
     * @param inputType the name of the input type to check for.
     * @return true/false
     */
    private boolean isInputType(final String inputType)
    {

        return inputType.equalsIgnoreCase(this.getInputType());

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_TEXTAREA)
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isInputTextarea()
     */
    @Override
    protected boolean handleIsInputTextarea()
    {

        return this.isInputType(GuiGlobals.INPUT_TEXTAREA);

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_SELECT)
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isInputSelect()
     */
    @Override
    protected boolean handleIsInputSelect()
    {

        return this.isInputType(GuiGlobals.INPUT_SELECT);

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_PASSWORD)
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isInputSecret()
     */
    @Override
    protected boolean handleIsInputSecret()
    {

        return this.isInputType(GuiGlobals.INPUT_PASSWORD);

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_HIDDEN)
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isInputHidden()
     */
    @Override
    protected boolean handleIsInputHidden()
    {

        return this.isInputType(GuiGlobals.INPUT_HIDDEN);

    }

    /**
     * @return isInputType(GuiGlobals.PLAIN_TEXT)
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isPlaintext()
     */
    @Override
    protected boolean handleIsPlaintext()
    {

        return this.isInputType(GuiGlobals.PLAIN_TEXT);

    }

    /**
     * @return isInputTable
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isInputTable()
     */
    @Override
    protected boolean handleIsInputTable()
    {

        return (this.getInputTableIdentifierColumns().length() > 0) || this.isInputType(GuiGlobals.INPUT_TABLE);

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_RADIO)
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isInputRadio()
     */
    @Override
    protected boolean handleIsInputRadio()
    {

        return this.isInputType(GuiGlobals.INPUT_RADIO);

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_TEXT)
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isInputText()
     */
    @Override
    protected boolean handleIsInputText()
    {

        return this.isInputType(GuiGlobals.INPUT_TEXT);

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_MULTIBOX)
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isInputMultibox()
     */
    @Override
    protected boolean handleIsInputMultibox()
    {

        return this.isInputType(GuiGlobals.INPUT_MULTIBOX);

    }

    /**
     * @return isInputCheckbox
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isInputCheckbox()
     */
    @Override
    protected boolean handleIsInputCheckbox()
    {

        boolean checkbox = this.isInputType(GuiGlobals.INPUT_CHECKBOX);

        if (!checkbox && (this.getInputType().length() == 0))
        {

            final ClassifierFacade type = this.getType();

            checkbox = (type != null) ? type.isBooleanType() : false;

        }

        return checkbox;

    }

    /**
     * @return isInputFile
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isInputFile()
     */
    @Override
    protected boolean handleIsInputFile()
    {

        boolean file = false;
        final ClassifierFacade type = this.getType();

        if (type != null)
        {

            file = type.isFileType();

        }

        return file;

    }

    /**
     * @return backingListName
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getBackingListName()
     */
    @Override
    protected String handleGetBackingListName()
    {

        return ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.BACKING_LIST_PATTERN)).replaceAll("\\{0\\}", this.getName());

    }

    /**
     * @return backingValueName
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getBackingValueName()
     */
    @Override
    protected String handleGetBackingValueName()
    {

        return ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.BACKING_VALUE_PATTERN)).replaceAll("\\{0\\}", this.getName());

    }

    /**
     * @return valueListName
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getValueListName()
     */
    @Override
    protected String handleGetValueListName()
    {

        return ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.VALUE_LIST_PATTERN)).replaceAll("\\{0\\}", this.getName());

    }

    /**
     * @return labelListName
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getLabelListName()
     */
    @Override
    protected String handleGetLabelListName()
    {

        return ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.LABEL_LIST_PATTERN)).replaceAll("\\{0\\}", this.getName());

    }

    /**
     * @return isSelectable
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isSelectable()
     */
    @Override
    protected boolean handleIsSelectable()
    {

        boolean selectable = false;

        if (this.isActionParameter())
        {

            selectable = this.isInputMultibox() || this.isInputSelect() || this.isInputRadio();

            final ClassifierFacade type = this.getType();

            if (!selectable && (type != null))
            {

                final String name = this.getName();
                final String typeName = type.getFullyQualifiedName();

                // - if the parameter is not selectable but on a targetting page it IS selectable we must
                // allow the user to set the backing list too
                final Collection<FrontEndView> views = this.getAction().getTargetViews();

                for (final Iterator<FrontEndView> iterator = views.iterator(); iterator.hasNext() && !selectable;)
                {

                    final Collection<FrontEndParameter> parameters = iterator.next().getAllActionParameters();

                    for (final Iterator<FrontEndParameter> parameterIterator = parameters.iterator(); parameterIterator.hasNext() && !selectable;)
                    {

                        final Object object = parameterIterator.next();

                        if (object instanceof GuiParameter)
                        {

                            final GuiParameter parameter = (GuiParameter) object;
                            final String parameterName = parameter.getName();
                            final ClassifierFacade parameterType = parameter.getType();

                            if (parameterType != null)
                            {

                                final String parameterTypeName = parameterType.getFullyQualifiedName();

                                if (name.equals(parameterName) && typeName.equals(parameterTypeName))
                                {

                                    selectable = parameter.isInputMultibox() || parameter.isInputSelect() || parameter.isInputRadio();

                                }

                            }

                        }

                    }

                }

            }

        } else if (this.isControllerOperationArgument())
        {

            final String name = this.getName();
            final Collection actions = this.getControllerOperation().getDeferringActions();

            for (final Iterator actionIterator = actions.iterator(); actionIterator.hasNext();)
            {

                final GuiAction action = (GuiAction) actionIterator.next();
                final Collection<FrontEndParameter> formFields = action.getFormFields();

                for (final Iterator<FrontEndParameter> fieldIterator = formFields.iterator(); fieldIterator.hasNext() && !selectable;)
                {

                    final Object object = fieldIterator.next();

                    if (object instanceof GuiParameter)
                    {

                        final GuiParameter parameter = (GuiParameter) object;

                        if (!parameter.equals(this))
                        {

                            if (name.equals(parameter.getName()))
                            {

                                selectable = parameter.isSelectable();

                            }

                        }

                    }

                }

            }

        }

        return selectable;

    }

    /**
     * Stores the initial value of each type.
     */
    private final Map<String, String> initialValues = new HashMap<String, String>();

    /**
     * @return constructDummyArray()
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getValueListDummyValue()
     */
    @Override
    protected String handleGetValueListDummyValue()
    {

        return this.constructDummyArray();

    }

    /**
     * @return dummyValue
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getDummyValue()
     */
    @Override
    protected String handleGetDummyValue()
    {

        final ClassifierFacade type = this.getType();
        final String typeName = (type != null) ? type.getFullyQualifiedName() : "";
        String initialValue = null;

        if (type != null)
        {

            if (type.isSetType())
            {

                initialValue = "new java.util.LinkedHashSet(java.util.Arrays.asList(" + this.constructDummyArray() + "))";

            } else if (type.isCollectionType())
            {

                initialValue = "java.util.Arrays.asList(" + this.constructDummyArray() + ")";

            } else if (type.isArrayType())
            {

                initialValue = this.constructDummyArray();

            }

            final String name = (this.getName() != null) ? this.getName() : "";

            if (this.initialValues.isEmpty())
            {

                this.initialValues.put(boolean.class.getName(), "false");
                this.initialValues.put(int.class.getName(), "(int)" + name.hashCode());
                this.initialValues.put(long.class.getName(), "(long)" + name.hashCode());
                this.initialValues.put(short.class.getName(), "(short)" + name.hashCode());
                this.initialValues.put(byte.class.getName(), "(byte)" + name.hashCode());
                this.initialValues.put(float.class.getName(), "(float)" + name.hashCode());
                this.initialValues.put(double.class.getName(), "(double)" + name.hashCode());
                this.initialValues.put(char.class.getName(), "(char)" + name.hashCode());

                this.initialValues.put(String.class.getName(), "\"" + name + "-test" + "\"");
                this.initialValues.put(java.util.Date.class.getName(), "new java.util.Date()");
                this.initialValues.put(java.sql.Date.class.getName(), "new java.util.Date()");
                this.initialValues.put(java.sql.Timestamp.class.getName(), "new java.util.Date()");

                this.initialValues.put(Integer.class.getName(), "new Integer((int)" + name.hashCode() + ")");
                this.initialValues.put(Boolean.class.getName(), "Boolean.FALSE");
                this.initialValues.put(Long.class.getName(), "new Long((long)" + name.hashCode() + ")");
                this.initialValues.put(Character.class.getName(), "new Character(char)" + name.hashCode() + ")");
                this.initialValues.put(Float.class.getName(), "new Float((float)" + (name.hashCode() / this.hashCode()) + ")");
                this.initialValues.put(Double.class.getName(), "new Double((double)" + (name.hashCode() / this.hashCode()) + ")");
                this.initialValues.put(Short.class.getName(), "new Short((short)" + name.hashCode() + ")");
                this.initialValues.put(Byte.class.getName(), "new Byte((byte)" + name.hashCode() + ")");

            }

            if (initialValue == null)
            {

                initialValue = this.initialValues.get(typeName);

            }

        }

        if (initialValue == null)
        {

            initialValue = "null";

        }

        return initialValue;

    }

    /**
     * Constructs a string representing an array initialization in Java.
     *
     * @return A String representing Java code for the initialization of an array.
     */
    private String constructDummyArray()
    {

        return GuiUtils.constructDummyArrayDeclaration(this.getName(), GuiGlobals.DUMMY_ARRAY_COUNT);

    }

    /**
     * @return getName() + "SortColumn"
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getTableSortColumnProperty()
     */
    @Override
    protected String handleGetTableSortColumnProperty()
    {

        return this.getName() + "SortColumn";

    }

    /**
     * @return getName() + "SortAscending"
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getTableSortAscendingProperty()
     */
    @Override
    protected String handleGetTableSortAscendingProperty()
    {

        return this.getName() + "SortAscending";

    }

    /**
     * @return getName() + "Set"
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getFormAttributeSetProperty()
     */
    @Override
    protected String handleGetFormAttributeSetProperty()
    {

        return this.getName() + "Set";

    }

    // TODO remove after 3.4 release
    /**
     * Hack to keep the compatibility with Andromda 3.4-SNAPSHOT
     */

    /**
     * @see org.andromda.metafacades.uml.FrontEndParameter#getView()
     */
    @Override
    public FrontEndView getView()
    {

        Object view = null;
        final EventFacade event = this.getEvent();

        if (event != null)
        {

            final TransitionFacade transition = event.getTransition();

            if (transition instanceof GuiActionLogicImpl)
            {

                final GuiActionLogicImpl action = (GuiActionLogicImpl) transition;

                view = action.getInput();

            } else if (transition instanceof FrontEndForward)
            {

                final FrontEndForward forward = (FrontEndForward) transition;

                if (forward.isEnteringView())
                {

                    view = forward.getTarget();

                }

            }

        }

        return (FrontEndView) view;

    }

    /**
     * @return validationRequired
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isValidationRequired()
     */
    @Override
    protected boolean handleIsValidationRequired()
    {

        boolean required = !this.getValidatorTypes().isEmpty();

        if (!required)
        {

            // - look for any attributes
            for (final Iterator<GuiAttribute> iterator = this.getAttributes().iterator(); iterator.hasNext();)
            {

                required = !iterator.next().getValidatorTypes().isEmpty();

                if (required)
                {

                    break;

                }

            }

            // - look for any table columns
            if (!required)
            {

                for (final Iterator iterator = this.getTableColumns().iterator(); iterator.hasNext();)
                {

                    final Object object = iterator.next();

                    if (object instanceof GuiAttribute)
                    {

                        final GuiAttribute attribute = (GuiAttribute) object;

                        required = !attribute.getValidatorTypes().isEmpty();

                        if (required)
                        {

                            break;

                        }

                    }

                }

            }

        }

        return required;

    }

    /**
     * @return validatorTypes
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getValidatorTypes()
     */
    @Override
    protected Collection handleGetValidatorTypes()
    {

        return GuiUtils.getValidatorTypes((ModelElementFacade) this.THIS(), this.getType());

    }

    /**
     * @return GuiUtils.getValidWhen(this)
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getValidWhen()
     */
    @Override
    protected String handleGetValidWhen()
    {

        return GuiUtils.getValidWhen(this);

    }

    /**
     * Overridden to have the same behavior as gui.
     *
     * @see org.andromda.metafacades.uml.ParameterFacade#isRequired()
     */
    @Override
    public boolean isRequired()
    {

        if ("org.omg.uml.foundation.core".equals(this.metaObject.getClass().getPackage().getName()))
        {

            // if uml 1.4, keep the old behavior (like bpm4struts)
            final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_REQUIRED);

            return Boolean.valueOf(ObjectUtils.toString(value)).booleanValue();

        } else
        {

            // if >= uml 2, default behavior
            final Object filterTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_REQUIRED);

            return (filterTag == null) ? super.isRequired() : GuiUtils.isTrue(String.valueOf(filterTag));

            // @see behavior in org.andromda.metafacades.emf.uml22.ParameterFacadeLogicImpl#handleIsRequired()
            // in ..\\andromda\\trunk\\metafacades\\uml\\emf\\uml22\\src\\main\\java\\org\\andromda\\metafacades\\emf\\uml22
            // !this.hasStereotype(UMLProfile.STEREOTYPE_NULLABLE)
        }

    }

    /**
     * @return GuiUtils.isReadOnly(this)
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isReadOnly()
     */
    @Override
    protected boolean handleIsReadOnly()
    {

        return GuiUtils.isReadOnly(this);

    }

    /**
     * @param validatorType
     * @return validatorArgs
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getValidatorArgs(String)
     */
    @Override
    protected Collection handleGetValidatorArgs(final String validatorType)
    {

        return GuiUtils.getValidatorArgs((ModelElementFacade) this.THIS(), validatorType);

    }

    /**
     * @return validatorVars
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getValidatorVars()
     */
    @Override
    protected Collection handleGetValidatorVars()
    {

        return GuiUtils.getValidatorVars((ModelElementFacade) this.THIS(), this.getType(), null);

    }

    /**
     * @return reset
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isReset()
     */
    @Override
    protected boolean handleIsReset()
    {

        boolean reset = Boolean.valueOf(ObjectUtils.toString(this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_RESET))).booleanValue();

        if (!reset)
        {

            final GuiAction action = (GuiAction) this.getAction();

            reset = (action != null) && action.isFormReset();

        }

        return reset;

    }

    /**
     * @return complex
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isComplex()
     */
    @Override
    protected boolean handleIsComplex()
    {

        boolean complex = false;
        final ClassifierFacade type = this.getType();

        if (type != null)
        {

            complex = !type.getAttributes().isEmpty();

            if (!complex)
            {

                complex = !type.getAssociationEnds().isEmpty();

            }

        }

        return complex;

    }

    /**
     * @return attributes
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getAttributes()
     */
    @Override
    protected Collection<AttributeFacade> handleGetAttributes()
    {

        Collection<AttributeFacade> attributes = null;
        ClassifierFacade type = this.getType();

        if (type != null)
        {

            if (type.isArrayType())
            {

                type = type.getNonArray();

            }

            if (type != null)
            {

                attributes = type.getAttributes(true);

            }

        }

        return (attributes == null) ? new ArrayList<AttributeFacade>() : attributes;

    }

    /**
     * @return navigableAssociationEnds
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getNavigableAssociationEnds()
     */
    @Override
    protected Collection<AssociationEndFacade> handleGetNavigableAssociationEnds()
    {

        Collection<AssociationEndFacade> associationEnds = null;
        ClassifierFacade type = this.getType();

        if (type != null)
        {

            if (type.isArrayType())
            {

                type = type.getNonArray();

            }

            if (type != null)
            {

                associationEnds = type.getNavigableConnectingEnds();

            }

        }

        return (associationEnds == null) ? new ArrayList<AssociationEndFacade>() : associationEnds;

    }

    /**
     * @return isEqualValidator
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isEqualValidator()
     */
    @Override
    protected boolean handleIsEqualValidator()
    {

        final String equal = GuiUtils.getEqual((ModelElementFacade) this.THIS());

        return (equal != null) && (equal.trim().length() > 0);

    }

    /**
     * @return isBackingValueRequired
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#isEqualValidator()
     */
    @Override
    protected boolean handleIsBackingValueRequired()
    {

        boolean required = false;

        if (this.isActionParameter())
        {

            required = this.isInputTable();

            final ClassifierFacade type = this.getType();

            if (!required && (type != null))
            {

                final String name = this.getName();
                final String typeName = type.getFullyQualifiedName();

                // - if the backing value is not required for this parameter but on
                // a targeting page it IS selectable we must allow the user to set the backing value as well
                final Collection<FrontEndView> views = this.getAction().getTargetViews();

                for (final Iterator<FrontEndView> iterator = views.iterator(); iterator.hasNext() && !required;)
                {

                    final Collection<FrontEndParameter> parameters = iterator.next().getAllActionParameters();

                    for (final Iterator<FrontEndParameter> parameterIterator = parameters.iterator(); parameterIterator.hasNext() && !required;)
                    {

                        final FrontEndParameter object = parameterIterator.next();

                        if (object instanceof GuiParameter)
                        {

                            final GuiParameter parameter = (GuiParameter) object;
                            final String parameterName = parameter.getName();
                            final ClassifierFacade parameterType = parameter.getType();

                            if (parameterType != null)
                            {

                                final String parameterTypeName = parameterType.getFullyQualifiedName();

                                if (name.equals(parameterName) && typeName.equals(parameterTypeName))
                                {

                                    required = parameter.isInputTable();

                                }

                            }

                        }

                    }

                }

            }

        } else if (this.isControllerOperationArgument())
        {

            final String name = this.getName();
            final Collection<FrontEndAction> actions = this.getControllerOperation().getDeferringActions();

            for (final FrontEndAction frontEndAction : actions)
            {

                final GuiAction action = (GuiAction) frontEndAction;
                final Collection<FrontEndParameter> formFields = action.getFormFields();

                for (final Iterator<FrontEndParameter> fieldIterator = formFields.iterator(); fieldIterator.hasNext() && !required;)
                {

                    final Object object = fieldIterator.next();

                    if (object instanceof GuiParameter)
                    {

                        final GuiParameter parameter = (GuiParameter) object;

                        if (!parameter.equals(this))
                        {

                            if (name.equals(parameter.getName()))
                            {

                                required = parameter.isBackingValueRequired();

                            }

                        }

                    }

                }

            }

        }

        return required;

    }

    /**
     * @return findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_TABLE_IDENTIFIER_COLUMNS)
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getInputTableIdentifierColumns()
     */
    @Override
    protected String handleGetInputTableIdentifierColumns()
    {

        return ObjectUtils.toString(this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_TABLE_IDENTIFIER_COLUMNS)).trim();

    }

    /**
     * @param columnName
     * @return tableColumnActions
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getTableColumnActions(String)
     */
    @Override
    protected List<GuiAction> handleGetTableColumnActions(final String columnName)
    {

        final List<GuiAction> columnActions = new ArrayList<GuiAction>();

        if (columnName != null)
        {

            final Set<GuiAction> actions = new LinkedHashSet<GuiAction>(this.getTableHyperlinkActions());

            actions.addAll(this.getTableFormActions());

            for (final GuiAction action : actions)
            {

                if (columnName.equals(action.getTableLinkColumnName()))
                {

                    columnActions.add(action);

                }

            }

        }

        return columnActions;

    }

    /**
     * @return maxLength
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getMaxLength()
     */
    @Override
    protected String handleGetMaxLength()
    {

        final Collection<Collection> vars = this.getValidatorVars();

        if (vars == null)
        {

            return null;

        }

        for (final Collection collection : vars)
        {

            final Object[] values = (collection).toArray();

            if ("maxlength".equals(values[0]))
            {

                return values[1].toString();

            }

        }

        return null;

    }

    // to be used in the range validator: "range - 1000" or "range 20 -".
    /** - */
    static final String UNDEFINED_BOUND = "-";

    /** javax.validation.constraints.NotNull */
    static final String AN_REQUIRED     = "@javax.validation.constraints.NotNull";

    /** org.hibernate.validator.constraints.URL */
    static final String AN_URL          = "@org.hibernate.validator.constraints.URL";

    /** org.apache.myfaces.extensions.validator.baseval.annotation.LongRange */
    static final String AN_LONG_RANGE   = "@org.apache.myfaces.extensions.validator.baseval.annotation.LongRange";

    /** org.apache.myfaces.extensions.validator.baseval.annotation.DoubleRange */
    static final String AN_DOUBLE_RANGE = "@org.apache.myfaces.extensions.validator.baseval.annotation.DoubleRange";

    /** org.hibernate.validator.constraints.Email */
    static final String AN_EMAIL        = "@org.hibernate.validator.constraints.Email";

    /** org.hibernate.validator.constraints.CreditCardNumber */
    static final String AN_CREDIT_CARD  = "@org.hibernate.validator.constraints.CreditCardNumber";

    /** javax.validation.constraints.Size */
    static final String AN_LENGTH       = "@javax.validation.constraints.Size";

    /** org.apache.myfaces.extensions.validator.baseval.annotation.Pattern */
    static final String AN_PATTERN      = "@org.apache.myfaces.extensions.validator.baseval.annotation.Pattern";

    /** org.apache.myfaces.extensions.validator.crossval.annotation.Equals */
    static final String AN_EQUALS       = "@org.apache.myfaces.extensions.validator.crossval.annotation.Equals";

    /**
     * @return the annotations
     * @see org.andromda.cartridges.gui.metafacades.GuiParameter#getMaxLength()
     */
    @Override
    protected Collection<String> handleGetAnnotations()
    {

        final Collection<String> result = new HashSet<String>();
        boolean requiredAdded = false;

        for (final String vt : (Collection<String>) this.getValidatorTypes())
        {

            if (vt.startsWith("@")) // add the annotation
            {

                result.add(vt);

            }

            if (GuiUtils.VT_REQUIRED.equals(vt) && this.isRequired())
            {

                requiredAdded = true;
                result.add(GuiParameterLogicImpl.AN_REQUIRED);

            } else if (GuiUtils.VT_URL.equals(vt))
            {

                result.add(GuiParameterLogicImpl.AN_URL);

            } else if (GuiUtils.VT_INT_RANGE.equals(vt))
            {

                final StringBuilder sb = new StringBuilder(GuiParameterLogicImpl.AN_LONG_RANGE + "(");
                final String format = GuiUtils.getInputFormat((ModelElementFacade) this.THIS());
                final String rangeStart = GuiUtils.getRangeStart(format);
                boolean addComma = false;

                if (StringUtils.isNotBlank(rangeStart) && !rangeStart.equals(GuiParameterLogicImpl.UNDEFINED_BOUND))
                {

                    sb.append("minimum=" + rangeStart);
                    addComma = true;

                }

                final String rangeEnd = GuiUtils.getRangeEnd(format);

                if (StringUtils.isNotBlank(rangeEnd) && !rangeEnd.equals(GuiParameterLogicImpl.UNDEFINED_BOUND))
                {

                    if (addComma)
                    {

                        sb.append(",");

                    }

                    sb.append("maximum=" + rangeEnd);

                }

                sb.append(")");
                result.add(sb.toString());

            } else if (GuiUtils.VT_FLOAT_RANGE.equals(vt) || GuiUtils.VT_DOUBLE_RANGE.equals(vt))
            {

                final StringBuilder sb = new StringBuilder(GuiParameterLogicImpl.AN_DOUBLE_RANGE + "(");
                final String format = GuiUtils.getInputFormat(((ModelElementFacade) this.THIS()));
                final String rangeStart = GuiUtils.getRangeStart(format);
                boolean addComma = false;

                if (StringUtils.isNotBlank(rangeStart) && !rangeStart.equals(GuiParameterLogicImpl.UNDEFINED_BOUND))
                {

                    sb.append("minimum=" + rangeStart);
                    addComma = true;

                }

                final String rangeEnd = GuiUtils.getRangeEnd(format);

                if (StringUtils.isNotBlank(rangeEnd) && !rangeEnd.equals(GuiParameterLogicImpl.UNDEFINED_BOUND))
                {

                    if (addComma)
                    {

                        sb.append(",");

                    }

                    sb.append("maximum=" + rangeEnd);

                }

                sb.append(")");
                result.add(sb.toString());

            } else if (GuiUtils.VT_EMAIL.equals(vt))
            {

                result.add(GuiParameterLogicImpl.AN_EMAIL);

            } else if (GuiUtils.VT_CREDIT_CARD.equals(vt))
            {

                result.add(GuiParameterLogicImpl.AN_CREDIT_CARD);

            } else if (GuiUtils.VT_MIN_LENGTH.equals(vt) || GuiUtils.VT_MAX_LENGTH.equals(vt))
            {

                final StringBuilder sb = new StringBuilder(GuiParameterLogicImpl.AN_LENGTH + "(");
                final Collection formats = this.findTaggedValues(GuiProfile.TAGGEDVALUE_INPUT_FORMAT);
                boolean addComma = false;

                for (final Iterator formatIterator = formats.iterator(); formatIterator.hasNext();)
                {

                    final String additionalFormat = String.valueOf(formatIterator.next());

                    if (GuiUtils.isMinLengthFormat(additionalFormat))
                    {

                        if (addComma)
                        {

                            sb.append(",");

                        }

                        sb.append("min=");
                        sb.append(GuiUtils.getMinLengthValue(additionalFormat));
                        addComma = true;

                    } else if (GuiUtils.isMaxLengthFormat(additionalFormat))
                    {

                        if (addComma)
                        {

                            sb.append(",");

                        }

                        sb.append("max=");
                        sb.append(GuiUtils.getMinLengthValue(additionalFormat));
                        addComma = true;

                    }

                }

                sb.append(")");
                result.add(sb.toString());

            } else if (GuiUtils.VT_MASK.equals(vt))
            {

                final Collection formats = this.findTaggedValues(GuiProfile.TAGGEDVALUE_INPUT_FORMAT);

                for (final Iterator formatIterator = formats.iterator(); formatIterator.hasNext();)
                {

                    final String additionalFormat = String.valueOf(formatIterator.next());

                    if (GuiUtils.isPatternFormat(additionalFormat))
                    {

                        result.add(GuiParameterLogicImpl.AN_PATTERN + "(\"" + GuiUtils.getPatternValue(additionalFormat) + "\")");

                    }

                }

            } else if (GuiUtils.VT_VALID_WHEN.equals(vt))
            {

                result.add("");

            } else if (GuiUtils.VT_EQUAL.equals(vt))
            {

                result.add(GuiParameterLogicImpl.AN_EQUALS + "(\"" + GuiUtils.getEqual((ModelElementFacade) this.THIS()) + "\")");

            }

        }

        if (!requiredAdded && (this.getLower() > 0) && this.isRequired())
        {

            result.add(GuiParameterLogicImpl.AN_REQUIRED);

        }

        return result;

    }

    @Override
    protected java.lang.String handleGetTitleKey()
    {

        return this.getMessageKey() + ".title";

    }

    @Override
    protected java.lang.String handleGetTitleValue()
    {

        String requiredSuffix = "";

        if (this.isRequired())
        {

            requiredSuffix = " is required";

        }

        String dateSuffix = "";

        if (this.isDate())
        {

            dateSuffix = (this.isStrictDateFormat()) ? (" (use this strict format: " + this.getDateFormat() + ")") : (" (use this lenient format: " + this.getDateFormat() + ")");

        }

        final String documentation = this.getDocumentation("", 64, false);

        return StringUtilsHelper.toResourceMessage((StringUtils.isBlank(documentation)) ? (super.getName() + requiredSuffix + dateSuffix) : documentation.trim().replaceAll("\n", "<br/>"));

    }

    @Override
    protected boolean handleIsMultiple()
    {

        boolean multiple = false;

        final ClassifierFacade type = this.getType();

        if (type != null)
        {

            multiple = type.isCollectionType() || type.isArrayType();

        }

        return multiple;

    }

    @Override
    protected boolean handleIsResetRequired()
    {

        final boolean resetRequired;

        if (this.isSelectable())
        {

            resetRequired = true;

        } else
        {

            final ClassifierFacade type = this.getType();

            if (type == null)
            {

                resetRequired = false;

            } else
            {

                resetRequired = (type.isArrayType() || type.isFileType()) ? true : this.isValidatorBoolean();

            }

        }

        return resetRequired;

    }

    @Override
    protected java.lang.String handleGetNullValue()
    {

        String nullValue = null;

        final ClassifierFacade type = this.getType();

        if (type != null)
        {

            nullValue = type.getJavaNullString();

        }

        return nullValue;

    }

    @Override
    protected java.lang.String handleGetWidgetType()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_TYPE);
        final String fieldType = (value == null) ? null : value.toString();
        String widgetType = null;

        if (this.isActionParameter())
        {

            if (fieldType == null)
            {

                // no widget type has been specified
                final ClassifierFacade type = this.getType();

                if (type != null)
                {

                    if (type.isFileType())
                    {

                        widgetType = GuiGlobals.TAGGEDVALUE_INPUT_TYPE_FILE;

                    } else if (this.isValidatorBoolean())
                    {

                        widgetType = GuiGlobals.INPUT_CHECKBOX;

                    } else if (this.isMultiple())
                    {

                        widgetType = GuiGlobals.INPUT_SELECT;

                    } else
                    {

                        widgetType = GuiGlobals.INPUT_TEXT;

                    }

                }

            } else if (GuiGlobals.INPUT_SELECT.equalsIgnoreCase(fieldType))
            {

                widgetType = GuiGlobals.INPUT_SELECT;

            } else if (GuiGlobals.INPUT_PASSWORD.equalsIgnoreCase(fieldType))
            {

                widgetType = GuiGlobals.INPUT_PASSWORD;

            } else if (GuiGlobals.INPUT_TEXTAREA.equalsIgnoreCase(fieldType))
            {

                widgetType = GuiGlobals.INPUT_TEXTAREA;

            } else if (GuiGlobals.INPUT_HIDDEN.equalsIgnoreCase(fieldType))
            {

                widgetType = GuiParameterLogicImpl.HIDDEN_INPUT_TYPE;

            } else if (fieldType.toLowerCase().startsWith(GuiGlobals.INPUT_RADIO))
            {

                widgetType = GuiGlobals.INPUT_RADIO;

            } else if (GuiGlobals.INPUT_CHECKBOX.equalsIgnoreCase(fieldType))
            {

                widgetType = GuiGlobals.INPUT_CHECKBOX;

            } else if (GuiGlobals.PLAIN_TEXT.equalsIgnoreCase(fieldType))
            {

                widgetType = GuiGlobals.PLAIN_TEXT;

            } else if (GuiGlobals.INPUT_TEXT.equalsIgnoreCase(fieldType))
            {

                widgetType = GuiGlobals.INPUT_TEXT;

            } else if (GuiGlobals.INPUT_MULTIBOX.equalsIgnoreCase(fieldType))
            {

                if (this.getMultiboxPropertyName() != null)
                {

                    widgetType = GuiGlobals.INPUT_MULTIBOX;

                }

            } else if (GuiGlobals.TAGGEDVALUE_INPUT_TYPE_LINK.equalsIgnoreCase(fieldType))
            {

                final GuiAction action = this.getGuiAction();

                if (action != null)
                {

                    if (action.isTableLink())
                    {

                        widgetType = GuiGlobals.TAGGEDVALUE_INPUT_TYPE_LINK;

                    }

                }

            } else
            {

                widgetType = (this.isMultiple()) ? GuiGlobals.INPUT_SELECT : GuiGlobals.INPUT_TEXT;

            }

        } else
        {

            widgetType = fieldType;

        }

        return widgetType;

    }

    @Override
    protected java.lang.String handleGetResetValue()
    {

        final ClassifierFacade type = this.getType();

        if (type != null)
        {

            final String name = this.getName();

            if (this.isValidatorString())
            {

                return "\"" + name + "-test" + "\"";

            }

            if (this.isValidatorDate())
            {

                return "new java.util.Date()";

            }

            if (type.isPrimitive())
            {

                if (this.isValidatorInteger())
                {

                    return "(int)" + name.hashCode();

                }

                if (this.isValidatorBoolean())
                {

                    return "false";

                }

                if (this.isValidatorLong())
                {

                    return "(long)" + name.hashCode();

                }

                if (this.isValidatorChar())
                {

                    return "(char)" + name.hashCode();

                }

                if (this.isValidatorFloat())
                {

                    return "(float)" + name.hashCode();

                }

                if (this.isValidatorDouble())
                {

                    return "(double)" + name.hashCode();

                }

                if (this.isValidatorShort())
                {

                    return "(short)" + name.hashCode();

                }

                if (this.isValidatorByte())
                {

                    return "(byte)" + name.hashCode();

                }

            } else
            {

                if (this.isValidatorInteger())
                {

                    return "new Integer((int)" + name.hashCode() + ")";

                }

                if (this.isValidatorBoolean())
                {

                    return "Boolean.FALSE";

                }

                if (this.isValidatorLong())
                {

                    return "new Long((long)" + name.hashCode() + ")";

                }

                if (this.isValidatorChar())
                {

                    return "new Character(char)" + name.hashCode() + ")";

                }

                if (this.isValidatorFloat())
                {

                    return "new Float((float)" + name.hashCode() + ")";

                }

                if (this.isValidatorDouble())
                {

                    return "new Double((double)" + name.hashCode() + ")";

                }

                if (this.isValidatorShort())
                {

                    return "new Short((short)" + name.hashCode() + ")";

                }

                if (this.isValidatorByte())
                {

                    return "new Byte((byte)" + name.hashCode() + ")";

                }

            }

            if (type.isArrayType())
            {

                return this.constructArray();

            }

            if (type.isSetType())
            {

                return "new java.util.HashSet(java.util.Arrays.asList(" + this.constructArray() + "))";

            }

            if (type.isCollectionType())
            {

                return "java.util.Arrays.asList(" + this.constructArray() + ")";

            }

            // maps and others types will simply not be treated
        }

        return "null";

    }

    @Override
    protected java.lang.String handleGetValueListResetValue()
    {

        return this.constructArray();

    }

    @Override
    protected java.lang.String handleGetValidatorMsgKey()
    {

        return this.getMessageKey();

    }

    @Override
    protected java.util.List handleGetOptionKeys()
    {

        final String key = this.getMessageKey() + '.';
        final List optionKeys = new ArrayList();
        final int optionCount = this.getOptionCount();

        for (int i = 0; i < optionCount; i++)
        {

            optionKeys.add(key + i);

        }

        return optionKeys;

    }

    @Override
    protected int handleGetTableMaxRows()
    {

        final Object taggedValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_TABLE_MAXROWS);
        int pageSize;

        try
        {

            pageSize = Integer.parseInt(String.valueOf(taggedValue));

        }
        catch (final Exception e)
        {

            pageSize = GuiProfile.TAGGEDVALUE_TABLE_MAXROWS_DEFAULT_COUNT;

        }

        return pageSize;

    }

    @Override
    protected boolean handleIsTableExportable()
    {

        return this.getTableExportTypes().indexOf("none") == -1;

    }

    @Override
    protected boolean handleIsTableSortable()
    {

        final Object taggedValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_TABLE_SORTABLE);

        return (taggedValue == null) ? GuiProfile.TAGGEDVALUE_TABLE_SORTABLE_DEFAULT_VALUE : GuiUtils.isTrue(String.valueOf(taggedValue));

    }

    @Override
    protected java.lang.String handleGetTableExportTypes()
    {

        return GuiUtils.getDisplayTagExportTypes(this.findTaggedValues(GuiProfile.TAGGEDVALUE_TABLE_EXPORT), String.valueOf(this.getConfiguredProperty(GuiGlobals.PROPERTY_DEFAULT_TABLE_EXPORT_TYPES)));

    }

    @Override
    protected boolean handleIsDate()
    {

        return this.isValidatorDate();

    }

    @Override
    protected java.lang.String handleGetDateFormat()
    {

        final String format = this.getValidatorFormat();

        return (format == null) ? this.getDefaultDateFormat() : this.getDateFormat(format);

    }

    @Override
    protected boolean handleIsCalendarRequired()
    {

        return this.isDate() && String.valueOf(this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_CALENDAR)).equals("true");

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiParameterLogic#handleGetTableDecoratorPackageName()
     */
    @Override
    protected String handleGetTableDecoratorPackageName()
    {

        final GuiView jsp = this.getGuiView();

        return (jsp == null) ? null : jsp.getPackageName();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiParameterLogic#handleGetTableDecoratorClassName()
     */
    @Override
    protected String handleGetTableDecoratorClassName()
    {

        String tableDecoratorClassName = null;

        final GuiView jsp = this.getGuiView();

        if (jsp != null)
        {

            final String suffix = String.valueOf(this.getConfiguredProperty(GuiGlobals.PROPERTY_TABLE_DECORATOR_SUFFIX));

            tableDecoratorClassName = StringUtilsHelper.upperCamelCaseName(this.getName()) + suffix;

        }

        return tableDecoratorClassName;

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiParameterLogic#handleGetTableDecoratorFullPath()
     */
    @Override
    protected String handleGetTableDecoratorFullPath()
    {

        return this.getTableDecoratorFullyQualifiedName().replace(".", GuiGlobals.SEPARATOR);

    }

    @Override
    protected java.util.List<String> handleGetOptionValues()
    {

        final List<String> optionValues = new ArrayList<String>();
        final Object taggedValueObject = this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_RADIO);

        if (taggedValueObject == null)
        {

            // we resort to the default values
            optionValues.add("0");
            optionValues.add("1");
            optionValues.add("2");

        } else
        {

            final String taggedValue = String.valueOf(taggedValueObject).trim();

            int optionCount;

            try
            {

                optionCount = Integer.parseInt(taggedValue);

                for (int i = 0; i < optionCount; i++)
                {

                    optionValues.add(String.valueOf(i));

                }

            }
            catch (final Exception exception)
            {

                // this means the value wasn't a valid integer, we'll interpret it is a comma-separated
                // list of option-values
                final String[] options = taggedValue.split("[,]");

                for (final String option : options)
                {

                    optionValues.add(option.trim());

                }

            }

        }

        return optionValues;

    }

    @Override
    protected int handleGetOptionCount()
    {

        return this.getOptionValues().size();

    }

    // TODO REMOVE
    @Override
    protected java.lang.String handleGetOnlineHelpKey()
    {

        return this.getMessageKey() + ".online.help";

    }

    // TODO REMOVE
    @Override
    protected java.lang.String handleGetOnlineHelpValue()
    {

        final String crlf = "<br/>";
        final String format = this.getValidatorFormat();
        final StringBuffer buffer = new StringBuffer();

        final String value = StringUtilsHelper.toResourceMessage(this.getDocumentation("", 64, false));

        buffer.append((value == null) ? "No field documentation has been specified" : value);
        buffer.append(crlf);
        buffer.append(crlf);

        buffer.append(this.isRequired() ? "This field is required" : "This field is optional");
        buffer.append(crlf);

        if ("password".equals(this.getWidgetType()))
        {

            buffer.append("This is a password field, it will not show the data you enter, ").append("each character will be masked using an asterisk");
            buffer.append(crlf);

        }

        if (this.isCreditCardFormat(format))
        {

            buffer.append("The value of this field should reflect a ").append("<a href=\"http://www.beachnet.com/~hstiles/cardtype.html\" target=\"_blank\">creditcard</a> ");
            buffer.append(crlf);

        }

        if (this.isDate())
        {

            final String dateFormat = this.getDateFormat();

            buffer.append("This field represents a date and should be formatted in the matter described here").append("<a href=\"http://java.sun.com/j2se/1.4.2/docs/api/java/text/SimpleDateFormat.html\" ")
                    .append("target=\"_jdk\">");
            buffer.append(dateFormat).append("</a> ");

            if (this.isStrictDateFormat())
            {

                buffer.append("This format is strict in the sense that the parser will not use any heuristics in ").append("order to guess the intended date in case the input would not perfectly match the format");

            } else
            {

                buffer.append("This format is lenient in the sense that the parser will attempt to use heuristics in ").append("order to guess the intended date in case the input would not perfectly match the format");

            }

            buffer.append(crlf);
            buffer.append("A calendar has been foreseen to select a date from, it will automatically convert the date ").append("to the appropriate format.");
            buffer.append(crlf);

        }

        if (this.isValidatorTime())
        {

            final String dateFormat = this.getDateFormat();

            buffer.append("This field represents a time and should be formatted in the manner described here (for time) ").append("<a href=\"http://java.sun.com/j2se/1.4.2/docs/api/java/text/SimpleDateFormat.html\" ")
                    .append("target=\"_jdk\">");
            buffer.append(dateFormat).append("</a> ");

        }

        if (this.isEmailFormat(format))
        {

            buffer.append("The value of this field should reflect an email address");
            buffer.append(crlf);

        }

        if (this.isMaxLengthFormat(format))
        {

            buffer.append("This field should not contain more than ");
            buffer.append(this.getMaxLengthValue(format));
            buffer.append(" characters");
            buffer.append(crlf);

        }

        if (this.isMinLengthFormat(format))
        {

            buffer.append("This field should contain at least ");
            buffer.append(this.getMinLengthValue(format));
            buffer.append(" characters");
            buffer.append(crlf);

        }

        if (this.isPatternFormat(format))
        {

            buffer.append("The value should match this ");
            buffer.append("<a href=\"http://java.sun.com/j2se/1.4.2/docs/api/java/util/regex/Pattern.html\" target=\"_jdk\">");
            buffer.append("regular expression</a>: ");
            buffer.append(this.getPatternValue(format));
            buffer.append(crlf);

        }

        if (this.isRangeFormat(format))
        {

            buffer.append("The value of this field should be in the range of ");
            buffer.append(this.getRangeStart(format));
            buffer.append(" to ");
            buffer.append(this.getRangeEnd(format));
            buffer.append(crlf);

        }

        final String validWhen = this.getValidWhen();

        if (validWhen != null)
        {

            buffer.append("This field is only valid under specific conditions, more concretely the following ").append("expression must evaluate true: ").append(validWhen);
            buffer.append(crlf);

        }

        if (this.isReadOnly())
        {

            buffer.append("The value of this field cannot be changed, it is read-only");
            buffer.append(crlf);

        }

        if (this.isValidatorBoolean())
        {

            buffer.append("The value of this field should reflect a ").append("<a href=\"http://java.sun.com/docs/books/tutorial/java/nutsandbolts/datatypes.html\" ").append("target=\"_jdk\">boolean</a> value");
            buffer.append(crlf);

        } else if (this.isValidatorByte())
        {

            buffer.append("The value of this field should reflect a ").append("<a href=\"http://java.sun.com/docs/books/tutorial/java/nutsandbolts/datatypes.html\" ").append("target=\"_jdk\">byte</a> value");
            buffer.append(crlf);

        } else if (this.isValidatorChar())
        {

            buffer.append("The value of this field should reflect a ").append("<a href=\"http://java.sun.com/docs/books/tutorial/java/nutsandbolts/datatypes.html\" ").append("target=\"_jdk\">character</a> value");
            buffer.append(crlf);

        } else if (this.isValidatorDouble())
        {

            buffer.append("The value of this field should reflect a ").append("<a href=\"http://java.sun.com/docs/books/tutorial/java/nutsandbolts/datatypes.html\" ")
                    .append("target=\"_jdk\">double precision integer</a> value");
            buffer.append(crlf);

        } else if (this.isValidatorFloat())
        {

            buffer.append("The value of this field should reflect a ").append("<a href=\"http://java.sun.com/docs/books/tutorial/java/nutsandbolts/datatypes.html\" ").append("target=\"_jdk\">floating point</a> value");
            buffer.append(crlf);

        } else if (this.isValidatorInteger())
        {

            buffer.append("The value of this field should reflect a ").append("<a href=\"http://java.sun.com/docs/books/tutorial/java/nutsandbolts/datatypes.html\" ").append("target=\"_jdk\">integer</a> value");
            buffer.append(crlf);

        } else if (this.isValidatorLong())
        {

            buffer.append("The value of this field should reflect a ").append("<a href=\"http://java.sun.com/docs/books/tutorial/java/nutsandbolts/datatypes.html\" ").append("target=\"_jdk\">long integer</a> value");
            buffer.append(crlf);

        } else if (this.isValidatorShort())
        {

            buffer.append("The value of this field should reflect a ").append("<a href=\"http://java.sun.com/docs/books/tutorial/java/nutsandbolts/datatypes.html\" ").append("target=\"_jdk\">short integer</a> value");
            buffer.append(crlf);

        } else if (this.isValidatorUrl())
        {

            buffer.append("The value of this field should reflect a ").append("<a href=\"http://java.sun.com/j2se/1.4.2/docs/api/java/net/URL.html\" ").append("target=\"_jdk\">URL</a> value");
            buffer.append(crlf);

        }

        return StringUtilsHelper.toResourceMessage(buffer.toString());

    }

    @Override
    protected java.lang.String handleGetCollectionImplementationType()
    {

        String typeName = null;

        final ClassifierFacade type = this.getType();

        if (type != null)
        {

            if (type.isCollectionType() || type.isListType())
            {

                typeName = "java.util.ArrayList";

            } else if (type.isSetType())
            {

                typeName = "java.util.HashSet";

            } else
            {

                typeName = type.getFullyQualifiedName();

            }

        }

        return typeName;

    }

    @Override
    protected java.lang.String handleGetMultiboxPropertyName()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_MULTIBOX);

        return (value == null) ? null : StringUtils.trimToNull(value.toString());

    }

    @Override
    protected boolean handleIsShouldReset()
    {

        boolean shouldReset = false;
        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_RESET);

        if (value != null)
        {

            shouldReset = Boolean.valueOf(StringUtils.trimToEmpty(String.valueOf(value))).booleanValue();

        }

        return shouldReset;

    }

    @Override
    protected java.lang.String handleGetResetName()
    {

        return "reset" + StringUtils.capitalize(StringUtils.trimToEmpty(this.getName()));

    }

    /**
     * The input type representing a 'hidden' parameter.
     */
    static final String HIDDEN_INPUT_TYPE = "hidden";

    @Override
    protected boolean handleIsFile()
    {

        boolean file = false;

        final ClassifierFacade type = this.getType();

        if (type != null)
        {

            file = type.isFileType();

        }

        return file;

    }

    @Override
    protected boolean handleIsPassword()
    {

        return GuiGlobals.INPUT_PASSWORD.equals(this.getWidgetType());

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiParameterLogic#handleIsTableDecoratorRequired()
     */
    @Override
    protected boolean handleIsTableDecoratorRequired()
    {

        boolean required = false;

        if (this.isTable())
        {

            final Object taggedValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_TABLE_DECORATOR);

            if (taggedValue != null)
            {

                final String taggedValueString = String.valueOf(taggedValue);

                required = Boolean.valueOf(taggedValueString).booleanValue();

            } else
            {

                final Object property = this.getConfiguredProperty(GuiGlobals.PROPERTY_GENERATE_TABLE_DECORATORS);
                final String propertyString = String.valueOf(property);

                required = Boolean.valueOf(propertyString).booleanValue();

            }

        }

        return required;

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiParameterLogic#handleGetTableDecoratorFullyQualifiedName()
     */
    @Override
    protected String handleGetTableDecoratorFullyQualifiedName()
    {

        String name = this.getTableDecoratorPackageName();

        name = (StringUtils.trimToEmpty(name) == null) ? "" : (name + '.');

        return name + this.getTableDecoratorClassName();

    }

    @Override
    protected java.lang.String handleGetStyleId()
    {

        String styleId = null;

        final GuiAction action = this.getGuiAction();

        if (action != null)
        {

            // if this parameter's action links to a table we use a specific styleId
            if (action.isTableLink())
            {

                styleId = action.getTableLinkName() + StringUtilsHelper.upperCamelCaseName(this.getName());

            } else
            {

                final EventFacade trigger = action.getTrigger();

                if (trigger != null)
                {

                    styleId = StringUtilsHelper.lowerCamelCaseName(trigger.getName()) + StringUtilsHelper.upperCamelCaseName(this.getName());

                }

            }

        }

        return styleId;

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiParameterLogic#handleIsTableFormActionSharingWidgets()
     */
    @Override
    protected boolean handleIsTableFormActionSharingWidgets()
    {

        // TODO
        return true;

    }

    @Override
    protected boolean handleIsTableHyperlinkColumn()
    {

        boolean tableHyperlinkColumn = false;

        final String name = this.getName();

        if (name != null)
        {

            // this parameter's action must be a table hyperlink
            final GuiAction action = this.getGuiAction();

            if (action.isHyperlink() && action.isTableLink())
            {

                // get the table and check whether this parameter is part of that table's columns
                final GuiParameter table = action.getTableLinkParameter();

                if (table != null)
                {

                    final Collection tableColumns = table.getTableColumns();

                    // if this parameter's name matches that targetted column name then we have found our column
                    tableHyperlinkColumn = tableColumns.contains(this) && name.equals(action.getTableLinkColumnName());

                }

            }

        }

        return tableHyperlinkColumn;

    }

    @Override
    protected boolean handleIsSortableBy()
    {

        boolean sortableBy = true;

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_TYPE);

        if (value != null)
        {

            final String fieldType = value.toString();

            sortableBy = !(GuiGlobals.INPUT_PASSWORD.equalsIgnoreCase(fieldType) || GuiGlobals.INPUT_HIDDEN.equalsIgnoreCase(fieldType) || GuiGlobals.INPUT_RADIO.equalsIgnoreCase(fieldType)
                    || GuiGlobals.INPUT_CHECKBOX.equalsIgnoreCase(fieldType) || GuiGlobals.INPUT_MULTIBOX.equalsIgnoreCase(fieldType));

        }

        return sortableBy;

    }

    @Override
    protected java.lang.String handleGetTimeFormat()
    {

        final String format = this.getValidatorFormat();

        return (format == null) ? this.getDefaultTimeFormat() : format;

    }

    @Override
    protected boolean handleIsTime()
    {

        return this.isValidatorTime();

    }

    // TODO REMOVE
    @Override
    protected boolean handleIsAllGlobalTableActionsHaveSameParameter()
    {

        boolean sameParameter = true;

        String name = null;
        String type = null;

        final Collection actions = this.getTableGlobalActions();

        for (final Iterator actionIterator = actions.iterator(); actionIterator.hasNext() && sameParameter;)
        {

            final GuiAction action = (GuiAction) actionIterator.next();
            final List parameters = action.getActionParametersToDeletes();

            if (!parameters.isEmpty())
            {

                final GuiParameter parameter = (GuiParameter) parameters.iterator().next();

                if ((name == null) || (type == null))
                {

                    name = parameter.getName();
                    type = parameter.getType().getFullyQualifiedName();

                } else
                {

                    sameParameter = name.equals(parameter.getName()) && type.equals(parameter.getType().getFullyQualifiedName());

                }

            }

        }

        return sameParameter;

    }

    @Override
    protected java.lang.Integer handleGetFieldRowCount()
    {

        Integer rowCount = null;

        Object rowCountObject = this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_ROW_COUNT);

        if (rowCountObject == null)
        {

            rowCountObject = this.getConfiguredProperty(GuiGlobals.PROPERTY_DEFAULT_INPUT_ROW_COUNT);

        }

        if (rowCountObject != null)
        {

            try
            {

                rowCount = Integer.valueOf(rowCountObject.toString());

            }
            catch (final NumberFormatException e)
            {

                // do nothing, we want rowCount to be null in case of an invalid value
            }

        }

        return rowCount;

    }

    @Override
    protected java.lang.Integer handleGetFieldColumnCount()
    {

        Integer columnCount = null;

        Object columnCountObject = this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_COLUMN_COUNT);

        if (columnCountObject == null)
        {

            columnCountObject = this.getConfiguredProperty(GuiGlobals.PROPERTY_DEFAULT_INPUT_COLUMN_COUNT);

        }

        if (columnCountObject != null)
        {

            try
            {

                columnCount = Integer.valueOf(columnCountObject.toString());

            }
            catch (final NumberFormatException e)
            {

                // do nothing, we want columnCount to be null in case of an invalid value
            }

        }

        return columnCount;

    }

    @Override
    protected boolean handleIsCombobox()
    {

        return GuiGlobals.INPUT_SELECT.equals(this.getWidgetType());

    }

    @Override
    protected boolean handleIsCheckbox()
    {

        return GuiGlobals.INPUT_CHECKBOX.equals(this.getWidgetType());

    }

    @Override
    protected boolean handleIsTextField()
    {

        return GuiGlobals.INPUT_TEXT.equals(this.getWidgetType());

    }

    @Override
    protected boolean handleIsTextArea()
    {

        return GuiGlobals.INPUT_TEXTAREA.equals(this.getWidgetType());

    }

    @Override
    protected boolean handleIsMultibox()
    {

        return GuiGlobals.INPUT_MULTIBOX.equals(this.getWidgetType());

    }

    @Override
    protected boolean handleIsRadioButton()
    {

        return GuiGlobals.INPUT_RADIO.equals(this.getWidgetType());

    }

    @Override
    protected boolean handleIsHiddenField()
    {

        return GuiGlobals.INPUT_HIDDEN.equals(this.getWidgetType());

    }

    @Override
    protected boolean handleIsHyperlink()
    {

        return GuiGlobals.TAGGEDVALUE_INPUT_TYPE_LINK.equals(this.getWidgetType());

    }

    @Override
    protected boolean handleIsSafeNamePresent()
    {

        return GuiUtils.isSafeName(this.getName());

    }

    @Override
    protected java.lang.Object handleGetGuiAction()
    {

        Object actionObject = null;

        final EventFacade event = this.getEvent();

        if (event != null)
        {

            final TransitionFacade transition = event.getTransition();

            if (transition instanceof GuiAction)
            {

                actionObject = transition;

            }

        }

        return actionObject;

    }

    @Override
    protected java.lang.Object handleGetGuiView()
    {

        Object viewObject = null;

        final EventFacade event = this.getEvent();

        if (event != null)
        {

            final TransitionFacade transition = event.getTransition();

            if (transition instanceof GuiAction)
            {

                final GuiAction action = (GuiAction) transition;

                viewObject = action.getInput();

            } else if (transition instanceof GuiForward)
            {

                final GuiForward forward = (GuiForward) transition;

                if (forward.isEnteringPage())
                {

                    viewObject = forward.getTarget();

                }

            }

        }

        return viewObject;

    }

    // TODO REMOVE
    @Override
    protected java.util.List<ModelElementFacade> handleGetFormFields()
    {

        final List<ModelElementFacade> formFields;

        if (this.isControllerOperationArgument() && (this.getName() != null))
        {

            final String name = this.getName();

            formFields = new ArrayList<ModelElementFacade>();

            final Collection actions = this.getControllerOperation().getDeferringActions();

            for (final Iterator actionIterator = actions.iterator(); actionIterator.hasNext();)
            {

                final GuiAction action = (GuiAction) actionIterator.next();
                final Collection actionFormFields = action.getActionFormFieldsToDeletes();

                for (final Iterator fieldIterator = actionFormFields.iterator(); fieldIterator.hasNext();)
                {

                    final GuiParameter parameter = (GuiParameter) fieldIterator.next();

                    if (name.equals(parameter.getName()))
                    {

                        formFields.add(parameter);

                    }

                }

            }

        } else
        {

            formFields = Collections.EMPTY_LIST;

        }

        return formFields;

    }

    @Override
    protected java.util.Collection<ModelElementFacade> handleGetTableGlobalActions()
    {

        return this.internalGetTableActions(false, false, true);

    }

    /**
     * If this is a table this method returns all those actions that are declared to work
     * on this table.
     */
    private List<ModelElementFacade> internalGetTableActions(final boolean hyperlink, final boolean formPost, final boolean tableAction)
    {

        final String name = StringUtils.trimToNull(this.getName());

        if ((name == null) || !this.isTable())
        {

            return Collections.EMPTY_LIST;

        }

        final GuiView page = this.getGuiView();

        final Collection<GuiAction> tableActions = new LinkedHashSet<GuiAction>();

        final Collection<UseCaseFacade> allUseCases = this.getModel().getAllUseCases();

        for (final UseCaseFacade useCaseFacade : allUseCases)
        {

            final UseCaseFacade useCase = useCaseFacade;

            if (useCase instanceof GuiUseCase)
            {

                final FrontEndActivityGraph graph = ((GuiUseCase) useCase).getActivityGraph();

                if (graph != null)
                {

                    final Collection<TransitionFacade> transitions = graph.getTransitions();

                    for (final TransitionFacade transitionFacade : transitions)
                    {

                        final TransitionFacade transition = transitionFacade;

                        if (transition.getSource().equals(page) && (transition instanceof GuiAction))
                        {

                            final GuiAction action = (GuiAction) transition;

                            if (action.isTableLink() && name.equals(action.getTableLinkName()))
                            {

                                if ((hyperlink && action.isHyperlink()) || (formPost && action.isFormPost()) || (tableAction && action.isTableAction()))
                                {

                                    tableActions.add(action);

                                }

                            }

                        }

                    }

                }

            }

        }

        return new ArrayList<ModelElementFacade>(tableActions);

    }

    // TODO REMOVE
    @Override
    protected java.lang.Object handleGetTableGlobalActionParameter()
    {

        Object parameter = null;

        final Collection actions = this.getTableGlobalActions();

        if (!actions.isEmpty())
        {

            final List actionParameters = ((GuiAction) actions.iterator().next()).getActionParametersToDeletes();

            if (!actionParameters.isEmpty())
            {

                parameter = actionParameters.iterator().next();

            }

        }

        return parameter;

    }

    /**
     * @return <code>true</code> if the type of this field is a boolean, <code>false</code> otherwise
     */
    private boolean isValidatorBoolean()
    {

        return UMLMetafacadeUtils.isType(this.getType(), UMLProfile.BOOLEAN_TYPE_NAME);

    }

    /**
     * @return <code>true</code> if the type of this field is a character, <code>false</code> otherwise
     */
    private boolean isValidatorChar()
    {

        return UMLMetafacadeUtils.isType(this.getType(), GuiProfile.CHARACTER_TYPE_NAME);

    }

    /**
     * @return <code>true</code> if the type of this field is a byte, <code>false</code> otherwise
     */
    private boolean isValidatorByte()
    {

        return UMLMetafacadeUtils.isType(this.getType(), GuiProfile.BYTE_TYPE_NAME);

    }

    /**
     * @return <code>true</code> if the type of this field is a short, <code>false</code> otherwise
     */
    private boolean isValidatorShort()
    {

        return UMLMetafacadeUtils.isType(this.getType(), GuiProfile.SHORT_TYPE_NAME);

    }

    /**
     * @return <code>true</code> if the type of this field is an integer, <code>false</code> otherwise
     */
    private boolean isValidatorInteger()
    {

        return UMLMetafacadeUtils.isType(this.getType(), GuiProfile.INTEGER_TYPE_NAME);

    }

    /**
     * @return <code>true</code> if the type of this field is a long integer, <code>false</code> otherwise
     */
    private boolean isValidatorLong()
    {

        return UMLMetafacadeUtils.isType(this.getType(), GuiProfile.LONG_TYPE_NAME);

    }

    /**
     * @return <code>true</code> if the type of this field is a floating point, <code>false</code> otherwise
     */
    private boolean isValidatorFloat()
    {

        return UMLMetafacadeUtils.isType(this.getType(), GuiProfile.FLOAT_TYPE_NAME);

    }

    /**
     * @return <code>true</code> if the type of this field is a double precision floating point, <code>false</code> otherwise
     */
    private boolean isValidatorDouble()
    {

        return UMLMetafacadeUtils.isType(this.getType(), GuiProfile.DOUBLE_TYPE_NAME);

    }

    /**
     * @return <code>true</code> if the type of this field is a date, <code>false</code> otherwise
     */
    private boolean isValidatorDate()
    {

        return (this.getType() != null) && this.getType().isDateType();

    }

    /**
     * @return <code>true</code> if the type of this field is a time, <code>false</code> otherwise
     */
    private boolean isValidatorTime()
    {

        return UMLMetafacadeUtils.isType(this.getType(), GuiProfile.TIME_TYPE_NAME);

    }

    /**
     * @return <code>true</code> if the type of this field is a URL, <code>false</code> otherwise
     */
    private boolean isValidatorUrl()
    {

        return UMLMetafacadeUtils.isType(this.getType(), GuiProfile.URL_TYPE_NAME);

    }

    /**
     * @return <code>true</code> if the type of this field is a String, <code>false</code> otherwise
     */
    private boolean isValidatorString()
    {

        return (this.getType() != null) && this.getType().isStringType();

    }

    /**
     * @return <code>true</code> if this field is to be formatted as an email address, <code>false</code> otherwise
     */
    private boolean isEmailFormat(final String format)
    {

        return "email".equalsIgnoreCase(this.getToken(format, 0, 2));

    }

    /**
     * @return <code>true</code> if this field is to be formatted as a credit card, <code>false</code> otherwise
     */
    private boolean isCreditCardFormat(final String format)
    {

        return "creditcard".equalsIgnoreCase(this.getToken(format, 0, 2));

    }

    /**
     * @return <code>true</code> if this field's value needs to be in a specific range, <code>false</code> otherwise
     */
    private boolean isRangeFormat(final String format)
    {

        return "range".equalsIgnoreCase(this.getToken(format, 0, 2)) && (this.isValidatorInteger() || this.isValidatorLong() || this.isValidatorShort() || this.isValidatorFloat() || this.isValidatorDouble());

    }

    /**
     * @return <code>true</code> if this field's value needs to respect a certain pattern, <code>false</code> otherwise
     */
    private boolean isPatternFormat(final String format)
    {

        return "pattern".equalsIgnoreCase(this.getToken(format, 0, 2));

    }

    /**
     * @return <code>true</code> if this field's value needs to conform to a strict date format, <code>false</code> otherwise
     */
    private boolean isStrictDateFormat(final String format)
    {

        return "strict".equalsIgnoreCase(this.getToken(format, 0, 2));

    }

    /**
     * @return <code>true</code> if this field's value needs to consist of at least a certain number of characters, <code>false</code> otherwise
     */
    private boolean isMinLengthFormat(final String format)
    {

        return "minlength".equalsIgnoreCase(this.getToken(format, 0, 2));

    }

    /**
     * @return <code>true</code> if this field's value needs to consist of at maximum a certain number of characters, <code>false</code> otherwise
     */
    private boolean isMaxLengthFormat(final String format)
    {

        return "maxlength".equalsIgnoreCase(this.getToken(format, 0, 2));

    }

    /**
     * @return the lower limit for this field's value's range
     */
    private String getRangeStart(final String format)
    {

        return this.getToken(format, 1, 3);

    }

    /**
     * @return the upper limit for this field's value's range
     */
    private String getRangeEnd(final String format)
    {

        return this.getToken(format, 2, 3);

    }

    /**
     * @return this field's date format
     */
    private String getDateFormat(final String format)
    {

        return (this.isStrictDateFormat(format)) ? this.getToken(format, 1, 2) : this.getToken(format, 0, 1);

    }

    /**
     * @return the minimum number of characters this field's value must consist of
     */
    private String getMinLengthValue(final String format)
    {

        return this.getToken(format, 1, 2);

    }

    /**
     * @return the maximum number of characters this field's value must consist of
     */
    private String getMaxLengthValue(final String format)
    {

        return this.getToken(format, 1, 2);

    }

    /**
     * @return the pattern this field's value must respect
     */
    private String getPatternValue(final String format)
    {

        return '^' + this.getToken(format, 1, 2) + '$';

    }

    /**
     * @return the i-th space delimited token read from the argument String, where i does not exceed the specified limit
     */
    private String getToken(final String string, final int index, final int limit)
    {

        if (string == null)
        {

            return null;

        }

        final String[] tokens = string.split("[\\s]+", limit);

        return (index >= tokens.length) ? null : tokens[index];

    }

    /**
     * @return A String representing Java code for the initialization of an array using 5 elements.
     */
    private String constructArray()
    {

        final String name = this.getName();

        return "new Object[] {\"" + name + "-1\", \"" + name + "-2\", \"" + name + "-3\", \"" + name + "-4\", \"" + name + "-5\"}";

    }

    private String getValidatorFormat()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_FORMAT);
        final String format = (value == null) ? null : String.valueOf(value);

        return (format == null) ? null : format.trim();

    }

    /**
     * @return the value for multiselection tagged value
     */
    @Override
    protected boolean handleIsMultiSelection()
    {

        final Object value = this.findTaggedValue(GuiProfile.TAGGEDVALUE_TABLE_MULTISELECTION);

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
    protected String handleToPhrase(final String string)
    {

        return StringUtilsHelper.toPhrase(string);

    }

    /**
     * Overridden to provide quotes around string types.
     *
     * @see org.andromda.metafacades.uml.ParameterFacade#getDefaultValue()
     */

    /*
     * @Override
     * public String getDefaultValue()
     * {
     * final String defaultValue = super.getDefaultValue();
     * if (StringUtils.isNotBlank(defaultValue))
     * {
     * final ClassifierFacade type = this.getType();
     * if ((type != null) && type.isStringType())
     * {
     * this.logger_.debug("getDefaultValue is : " + defaultValue + " for : " + this.getFullyQualifiedName());
     * // defaultValue = "\"" + defaultValue + "\"";
     * }
     * }
     * return defaultValue;
     * }
     */
}

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

import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.FrontEndAction;
import org.andromda.metafacades.uml.FrontEndParameter;
import org.andromda.metafacades.uml.FrontEndView;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ParameterFacade;

import org.andromda.utils.StringUtilsHelper;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiAttribute.
 *
 * @see GuiAttribute
 */
public class GuiAttributeLogicImpl extends GuiAttributeLogic
{

    private static final long serialVersionUID = 34L;

    /**
     * @param metaObject
     * @param context
     */
    public GuiAttributeLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * @return messageKey
     * @see GuiAttribute#getMessageKey()
     */
    protected String handleGetMessageKey()
    {

        final StringBuilder messageKey = new StringBuilder();

        if (!this.isNormalizeMessages())
        {

            final ClassifierFacade owner = this.getOwner();

            if (owner != null)
            {

                messageKey.append(StringUtilsHelper.toResourceMessageKey(owner.getName()));
                messageKey.append('.');

            }

        }

        final String name = this.getName();

        if ((name != null) && (name.trim().length() > 0))
        {

            messageKey.append(StringUtilsHelper.toResourceMessageKey(name));

        }

        return messageKey.toString();

    }

    /**
     * Indicates whether or not we should normalize messages.
     *
     * @return true/false
     */
    private boolean isNormalizeMessages()
    {

        final String normalizeMessages = ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.NORMALIZE_MESSAGES));

        return Boolean.valueOf(normalizeMessages).booleanValue();

    }

    /**
     * @return StringUtilsHelper.toPhrase(super.getName())
     * @see GuiAttribute#getMessageValue()
     */
    protected String handleGetMessageValue()
    {

        return StringUtilsHelper.toPhrase(super.getName());

    }

    /**
     * @return format
     * @see GuiAttribute#getFormat()
     */
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
     * @return the default date format pattern as defined using the configured property
     */
    private String getDefaultDateFormat()
    {

        return (String) this.getConfiguredProperty(GuiGlobals.PROPERTY_DEFAULT_DATEFORMAT);

    }

    /**
     * @return dummyValue
     * @see GuiAttribute#getDummyValue()
     */
    protected String handleGetDummyValue()
    {

        final ClassifierFacade type = this.getType();

        if (type != null)
        {

            final String typeName = type.getFullyQualifiedName();
            final String name = this.getName();

            if ("String".equals(typeName))
            {

                return "\"" + name + "-test" + "\"";

            }

            if ("java.util.Date".equals(typeName))
            {

                return "new java.util.Date()";

            }

            if ("java.sql.Date".equals(typeName))
            {

                return "new java.sql.Date(new java.util.Date().getTime())";

            }

            if ("java.sql.Timestamp".equals(typeName))
            {

                return "new java.sql.Timestamp(new Date().getTime())";

            }

            if ("java.util.Calendar".equals(typeName))
            {

                return "java.util.Calendar.getInstance()";

            }

            if ("int".equals(typeName))
            {

                return "(int)" + name.hashCode();

            }

            if ("boolean".equals(typeName))
            {

                return "false";

            }

            if ("long".equals(typeName))
            {

                return "(long)" + name.hashCode();

            }

            if ("char".equals(typeName))
            {

                return "(char)" + name.hashCode();

            }

            if ("float".equals(typeName))
            {

                return "(float)" + (name.hashCode() / this.hashCode());

            }

            if ("double".equals(typeName))
            {

                return "(double)" + (name.hashCode() / this.hashCode());

            }

            if ("short".equals(typeName))
            {

                return "(short)" + name.hashCode();

            }

            if ("byte".equals(typeName))
            {

                return "(byte)" + name.hashCode();

            }

            if ("java.lang.Integer".equals(typeName) || "Integer".equals(typeName))
            {

                return "new Integer((int)" + name.hashCode() + ")";

            }

            if ("java.lang.Boolean".equals(typeName) || "Boolean".equals(typeName))
            {

                return "Boolean.FALSE";

            }

            if ("java.lang.Long".equals(typeName) || "Long".equals(typeName))
            {

                return "new Long((long)" + name.hashCode() + ")";

            }

            if ("java.lang.Character".equals(typeName) || "Character".equals(typeName))
            {

                return "new Character(char)" + name.hashCode() + ")";

            }

            if ("java.lang.Float".equals(typeName) || "Float".equals(typeName))
            {

                return "new Float((float)" + (name.hashCode() / this.hashCode()) + ")";

            }

            if ("java.lang.Double".equals(typeName) || "Double".equals(typeName))
            {

                return "new Double((double)" + (name.hashCode() / this.hashCode()) + ")";

            }

            if ("java.lang.Short".equals(typeName) || "Short".equals(typeName))
            {

                return "new Short((short)" + name.hashCode() + ")";

            }

            if ("java.lang.Byte".equals(typeName) || "Byte".equals(typeName))
            {

                return "new Byte((byte)" + name.hashCode() + ")";

            }

            // if (type.isArrayType()) return constructDummyArray();
            if (type.isSetType())
            {

                return "new java.util.HashSet(java.util.Arrays.asList(" + this.constructDummyArray() + "))";

            }

            if (type.isCollectionType())
            {

                return "java.util.Arrays.asList(" + this.constructDummyArray() + ")";

            }

            // maps and others types will simply not be treated
        }

        return "null";

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
     * @param ownerParameter
     * @return propertyName
     * @see GuiAttribute#getFormPropertyName(org.andromda.metafacades.uml.ParameterFacade)
     */
    protected String handleGetFormPropertyName(final ParameterFacade ownerParameter)
    {

        final StringBuilder propertyName = new StringBuilder();

        if (ownerParameter != null)
        {

            propertyName.append(ownerParameter.getName());
            propertyName.append('.');

        }

        final String name = this.getName();

        if ((name != null) && (name.trim().length() > 0))
        {

            propertyName.append(name);

        }

        return propertyName.toString();

    }

    /**
     * @param ownerParameter
     * @return backingListName
     * @see GuiAttribute#getBackingListName(org.andromda.metafacades.uml.ParameterFacade)
     */
    protected String handleGetBackingListName(final ParameterFacade ownerParameter)
    {

        final String backingListName = StringUtils.replace(ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.BACKING_LIST_PATTERN)), "{0}", this.getFormPropertyId(ownerParameter));

        return org.andromda.utils.StringUtilsHelper.lowerCamelCaseName(backingListName);

    }

    /**
     * @param ownerParameter
     * @return backingValueName
     * @see GuiAttribute#getBackingValueName(org.andromda.metafacades.uml.ParameterFacade)
     */
    protected String handleGetBackingValueName(final ParameterFacade ownerParameter)
    {

        final String backingListName = StringUtils.replace(ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.BACKING_VALUE_PATTERN)), "{0}", this.getFormPropertyId(ownerParameter));

        return org.andromda.utils.StringUtilsHelper.lowerCamelCaseName(backingListName);

    }

    /**
     * @param ownerParameter
     * @return labelListName
     * @see GuiAttribute#getLabelListName(org.andromda.metafacades.uml.ParameterFacade)
     */
    protected String handleGetLabelListName(final ParameterFacade ownerParameter)
    {

        return StringUtils.replace(ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.LABEL_LIST_PATTERN)), "{0}", this.getFormPropertyId(ownerParameter));

    }

    /**
     * @param ownerParameter
     * @return valueListName
     * @see GuiAttribute#getValueListName(org.andromda.metafacades.uml.ParameterFacade)
     */
    protected String handleGetValueListName(final ParameterFacade ownerParameter)
    {

        return StringUtils.replace(ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.VALUE_LIST_PATTERN)), "{0}", this.getFormPropertyId(ownerParameter));

    }

    /**
     * @param ownerParameter
     * @return formPropertyId
     * @see GuiAttribute#getFormPropertyId(ParameterFacade)
     */
    protected String handleGetFormPropertyId(final ParameterFacade ownerParameter)
    {

        return StringUtilsHelper.lowerCamelCaseName(this.getFormPropertyName(ownerParameter));

    }

    /**
     * @param ownerParameter
     * @return isSelectable
     * @see GuiAttribute#isSelectable(org.andromda.metafacades.uml.FrontEndParameter)
     */
    protected boolean handleIsSelectable(final FrontEndParameter ownerParameter)
    {

        boolean selectable = false;

        if (ownerParameter != null)
        {

            if (ownerParameter.isActionParameter())
            {

                selectable = this.isInputMultibox() || this.isInputSelect() || this.isInputRadio();

                final ClassifierFacade type = this.getType();

                if (!selectable && (type != null))
                {

                    final String name = this.getName();
                    final String typeName = type.getFullyQualifiedName();

                    // - if the parameter is not selectable but on a targeting page it IS selectable we must
                    // allow the user to set the backing list too
                    final Collection<FrontEndView> views = ownerParameter.getAction().getTargetViews();

                    for (final Iterator<FrontEndView> iterator = views.iterator(); iterator.hasNext() && !selectable;)
                    {

                        final Collection<FrontEndParameter> parameters = iterator.next().getAllActionParameters();

                        for (final Iterator<FrontEndParameter> parameterIterator = parameters.iterator(); parameterIterator.hasNext() && !selectable;)
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

                                        selectable = parameter.isInputMultibox() || parameter.isInputSelect() || parameter.isInputRadio();

                                    }

                                }

                            }

                        }

                    }

                }

            } else if (ownerParameter.isControllerOperationArgument())
            {

                final String name = this.getName();

                for (final FrontEndAction action : ownerParameter.getControllerOperation().getDeferringActions())
                {

                    final Collection<FrontEndParameter> formFields = action.getFormFields();

                    for (final Iterator<FrontEndParameter> fieldIterator = formFields.iterator(); fieldIterator.hasNext() && !selectable;)
                    {

                        final FrontEndParameter object = fieldIterator.next();

                        if (object instanceof GuiParameter)
                        {

                            final GuiParameter parameter = (GuiParameter) object;

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
     * @return !this.getValidatorTypes().isEmpty()
     * @see GuiAttribute#isValidationRequired()
     */
    protected boolean handleIsValidationRequired()
    {

        return !this.getValidatorTypes().isEmpty();

    }

    /**
     * @return validatorTypes
     * @see GuiAttribute#getValidatorTypes()
     */
    protected Collection<String> handleGetValidatorTypes()
    {

        return GuiUtils.getValidatorTypes((ModelElementFacade) this.THIS(), this.getType());

    }

    /**
     * @param ownerParameter
     * @return validatorVars
     * @see GuiAttribute#getValidatorVars(GuiParameter)
     */
    protected Collection<List<String>> handleGetValidatorVars(final GuiParameter ownerParameter)
    {

        return GuiUtils.getValidatorVars((ModelElementFacade) this.THIS(), this.getType(), ownerParameter);

    }

    /**
     * @return GuiUtils.getValidWhen(this)
     * @see GuiAttribute#getValidWhen()
     */
    protected String handleGetValidWhen()
    {

        return GuiUtils.getValidWhen(this);

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_TEXTAREA)
     * @see GuiAttribute#isInputTextarea()
     */
    protected boolean handleIsInputTextarea()
    {

        return this.isInputType(GuiGlobals.INPUT_TEXTAREA);

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_SELECT)
     * @see GuiAttribute#isInputSelect()
     */
    protected boolean handleIsInputSelect()
    {

        return this.isInputType(GuiGlobals.INPUT_SELECT);

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_PASSWORD)
     * @see GuiAttribute#isInputSecret()
     */
    protected boolean handleIsInputSecret()
    {

        return this.isInputType(GuiGlobals.INPUT_PASSWORD);

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_HIDDEN)
     * @see GuiAttribute#isInputHidden()
     */
    protected boolean handleIsInputHidden()
    {

        return this.isInputType(GuiGlobals.INPUT_HIDDEN);

    }

    /**
     * @return isInputType(GuiGlobals.PLAIN_TEXT)
     * @see GuiAttribute#isPlaintext()
     */
    protected boolean handleIsPlaintext()
    {

        return this.isInputType(GuiGlobals.PLAIN_TEXT);

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_RADIO)
     * @see GuiAttribute#isInputRadio()
     */
    protected boolean handleIsInputRadio()
    {

        return this.isInputType(GuiGlobals.INPUT_RADIO);

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_TEXT)
     * @see GuiAttribute#isInputText()
     */
    protected boolean handleIsInputText()
    {

        return this.isInputType(GuiGlobals.INPUT_TEXT);

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_MULTIBOX)
     * @see GuiAttribute#isInputMultibox()
     */
    protected boolean handleIsInputMultibox()
    {

        return this.isInputType(GuiGlobals.INPUT_MULTIBOX);

    }

    /**
     * @return inputTable
     * @see GuiAttribute#isInputTable()
     */
    protected boolean handleIsInputTable()
    {

        return (this.getInputTableIdentifierColumns().length() > 0) || this.isInputType(GuiGlobals.INPUT_TABLE);

    }

    /**
     * @return inputCheckbox
     * @see GuiAttribute#isInputCheckbox()
     */
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
     * @return inputFile
     * @see GuiAttribute#isInputFile()
     */
    protected boolean handleIsInputFile()
    {

        boolean file = false;
        final ClassifierFacade type = getType();

        if (type != null)
        {

            file = type.isFileType();

        }

        return file;

    }

    /**
     * Overridden to provide consistent behavior with {@link GuiParameter#isReadOnly()}.
     *
     * @see org.andromda.metafacades.uml.AttributeFacade#isReadOnly()
     */
    public boolean isReadOnly()
    {

        return GuiUtils.isReadOnly(this);

    }

    /**
     * @return constructDummyArray()
     * @see GuiAttribute#getValueListDummyValue()
     */
    protected String handleGetValueListDummyValue()
    {

        return this.constructDummyArray();

    }

    /**
     * @param validatorType
     * @return getValidatorArgs
     * @see GuiAttribute#getValidatorArgs(String)
     */
    protected Collection handleGetValidatorArgs(final String validatorType)
    {

        return GuiUtils.getValidatorArgs((ModelElementFacade) this.THIS(), validatorType);

    }

    /**
     * @return isStrictDateFormat
     * @see GuiAttribute#isStrictDateFormat()
     */
    protected boolean handleIsStrictDateFormat()
    {

        return GuiUtils.isStrictDateFormat((ModelElementFacade) this.THIS());

    }

    /**
     * @param ownerParameter
     * @return dateFormatter
     * @see GuiAttribute#getDateFormatter(org.andromda.cartridges.gui.metafacades.GuiParameter)
     */
    protected String handleGetDateFormatter(final GuiParameter ownerParameter)
    {

        final ClassifierFacade type = this.getType();

        return ((type != null) && type.isDateType()) ? (this.getFormPropertyId(ownerParameter) + "DateFormatter") : null;

    }

    /**
     * @param ownerParameter
     * @return timeFormatter
     * @see GuiAttribute#getTimeFormatter(org.andromda.cartridges.gui.metafacades.GuiParameter)
     */
    protected String handleGetTimeFormatter(final GuiParameter ownerParameter)
    {

        final ClassifierFacade type = this.getType();

        return ((type != null) && type.isTimeType()) ? (this.getFormPropertyId(ownerParameter) + "TimeFormatter") : null;

    }

    /**
     * Overridden to provide quotes around string types.
     *
     * @see org.andromda.metafacades.uml.AttributeFacade#getDefaultValue()
     */
    public String getDefaultValue()
    {

        String defaultValue = super.getDefaultValue();

        if (StringUtils.isNotBlank(defaultValue))
        {

            final ClassifierFacade type = this.getType();

            if ((type != null) && type.isStringType())
            {

                defaultValue = "\"" + defaultValue + "\"";

            }

        }

        return defaultValue;

    }

    /**
     * @return isEqualValidator
     * @see GuiAttribute#isEqualValidator()
     */
    protected boolean handleIsEqualValidator()
    {

        final String equal = GuiUtils.getEqual((ModelElementFacade) this.THIS());

        return (equal != null) && (equal.trim().length() > 0);

    }

    /**
     * @param ownerParameter
     * @return isBackingValueRequired
     * @see GuiAttribute#isBackingValueRequired(org.andromda.metafacades.uml.FrontEndParameter)
     */
    protected boolean handleIsBackingValueRequired(final FrontEndParameter ownerParameter)
    {

        boolean required = false;

        if (ownerParameter != null)
        {

            if (ownerParameter.isActionParameter())
            {

                required = this.isInputTable();

                final ClassifierFacade type = this.getType();

                if (!required && (type != null))
                {

                    final String name = this.getName();
                    final String typeName = type.getFullyQualifiedName();

                    // - if the parameter is not selectable but on a targetting page it IS selectable we must
                    // allow the user to set the backing list too
                    final Collection<FrontEndView> views = ownerParameter.getAction().getTargetViews();

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

            } else if (ownerParameter.isControllerOperationArgument())
            {

                final String name = this.getName();
                final Collection<FrontEndAction> actions = ownerParameter.getControllerOperation().getDeferringActions();

                for (final FrontEndAction frontEndAction : actions)
                {

                    final GuiAction action = (GuiAction) frontEndAction;
                    final Collection<FrontEndParameter> formFields = action.getFormFields();

                    for (final Iterator<FrontEndParameter> fieldIterator = formFields.iterator(); fieldIterator.hasNext() && !required;)
                    {

                        final FrontEndParameter object = fieldIterator.next();

                        if (object instanceof GuiParameter)
                        {

                            final GuiParameter parameter = (GuiParameter) object;

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
     * @return present
     * @see GuiAttribute#isInputTypePresent()
     */
    protected boolean handleIsInputTypePresent()
    {

        boolean present = false;
        final ClassifierFacade type = this.getType();

        if (type != null)
        {

            present = (StringUtils.isNotBlank(this.getInputType()) || type.isDateType() || type.isBooleanType()) && !this.isPlaintext();

        }

        return present;

    }

    /**
     * @return findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_TABLE_IDENTIFIER_COLUMNS)
     * @see GuiAttribute#getInputTableIdentifierColumns()
     */
    protected String handleGetInputTableIdentifierColumns()
    {

        return ObjectUtils.toString(this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_TABLE_IDENTIFIER_COLUMNS)).trim();

    }

    /**
     * @return maxlength
     * @see GuiAttribute#getMaxLength()
     */
    protected String handleGetMaxLength()
    {

        final Collection<List<String>> vars = this.getValidatorVars(null);

        if (vars == null)
        {

            return null;

        }

        for (final List<String> values : vars)
        {

            if ("maxlength".equals(values.get(0)))
            {

                return values.get(1);

            }

        }

        return null;

    }

}

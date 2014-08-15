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
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ParameterFacade;

import org.andromda.utils.StringUtilsHelper;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute.
 * 
 * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute
 */
public class GuiManageableEntityAttributeLogicImpl extends GuiManageableEntityAttributeLogic
{

    private static final long serialVersionUID = 34L;
    private final Logger      logger_          = Logger.getLogger(GuiManageableEntityAttributeLogicImpl.class);

    /**
     * @param metaObject
     * @param context
     */
    public GuiManageableEntityAttributeLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * @return messageKey
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getMessageKey()
     */
    @Override
    protected String handleGetMessageKey()
    {

        String titleKey = "";

        final ClassifierFacade owner = this.getOwner();

        if (owner != null)
        {

            titleKey += (owner.getName() + ".");

        }

        return StringUtilsHelper.toResourceMessageKey(titleKey + this.getName());

    }

    /**
     * @return StringUtilsHelper.toPhrase(getName())
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getMessageValue()
     */
    @Override
    protected String handleGetMessageValue()
    {

        return StringUtilsHelper.toPhrase(this.getName());

    }

    /**
     * @return dateFormat
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getDateFormat()
     */
    @Override
    protected String handleGetDateFormat()
    {

        String dateFormat = this.internalGetDateFormat();

        if (dateFormat != null)
        {

            final String[] tokens = dateFormat.split("[\\s]+");
            int tokenIndex = 0;

            if ((tokenIndex < tokens.length) && "strict".equals(tokens[tokenIndex].trim()))
            {

                tokenIndex++;

            }

            if (tokenIndex < tokens.length)
            {

                dateFormat = tokens[tokenIndex].trim();

            }

        }

        return dateFormat;

    }

    /**
     * @return getType().isBlobType()
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#isNeedsFileUpload()
     */
    @Override
    protected boolean handleIsNeedsFileUpload()
    {

        return (this.getType() != null) && this.getType().isBlobType();

    }

    /**
     * @return isHidden
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#isHidden()
     */
    @Override
    protected boolean handleIsHidden()
    {

        return !this.isDisplay() || GuiGlobals.INPUT_HIDDEN.equals(this.getWidgetType());

    }

    /**
     * @return widgetType
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getWidgetType()
     */
    @Override
    protected String handleGetWidgetType()
    {

        final Object widgetTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_TYPE);

        return (widgetTag == null) ? GuiGlobals.INPUT_TEXT : widgetTag.toString();

    }

    /**
     * @return isStrictDateFormat
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#isStrictDateFormat()
     */
    @Override
    protected boolean handleIsStrictDateFormat()
    {

        final String dateFormat = this.internalGetDateFormat();

        return ((dateFormat != null) && dateFormat.trim().startsWith("strict"));

    }

    /**
     * @return getMessageKey() + ".online.help"
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getOnlineHelpKey()
     */
    @Override
    // TODO REMOVE
    protected String handleGetOnlineHelpKey()
    {

        return this.getMessageKey() + ".online.help";

    }

    /**
     * @return getDocumentation
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getOnlineHelpValue()
     */
    @Override
    // TODO REMOVE
    protected String handleGetOnlineHelpValue()
    {

        final String value = StringUtilsHelper.toResourceMessage(this.getDocumentation("", 64, false));

        return (value == null) ? "No field documentation has been specified" : value;

    }

    /**
     * @return format
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getFormat()
     */
    @Override
    protected String handleGetFormat()
    {

        return GuiUtils.getFormat((ModelElementFacade) this.THIS(), this.getType(), this.getDefaultDateFormat(), this.getDefaultTimeFormat());

    }

    /**
     * @return getConfiguredProperty(GuiGlobals.PROPERTY_DEFAULT_DATEFORMAT)
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getDefaultDateFormat()
     */
    @Override
    protected String handleGetDefaultDateFormat()
    {

        return (String) this.getConfiguredProperty(GuiGlobals.PROPERTY_DEFAULT_DATEFORMAT);

    }

    /**
     * @return getConfiguredProperty(GuiGlobals.PROPERTY_DEFAULT_TIMEFORMAT)
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getDefaultTimeFormat()
     */
    @Override
    protected String handleGetDefaultTimeFormat()
    {

        return (String) this.getConfiguredProperty(GuiGlobals.PROPERTY_DEFAULT_TIMEFORMAT);

    }

    /**
     * @return dateFormatter
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getDateFormatter()
     */
    @Override
    protected String handleGetDateFormatter()
    {

        final ClassifierFacade type = this.getType();

        return ((type != null) && type.isDateType()) ? (this.getName() + "DateFormatter") : null;

    }

    /**
     * @return timeFormatter
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getTimeFormatter()
     */
    @Override
    protected String handleGetTimeFormatter()
    {

        final ClassifierFacade type = this.getType();

        return ((type != null) && type.isTimeType()) ? (this.getName() + "TimeFormatter") : null;

    }

    /**
     * @return backingListName
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getBackingListName()
     */
    @Override
    protected String handleGetBackingListName()
    {

        final String backingListName = StringUtils.replace(ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.BACKING_LIST_PATTERN)), "{0}", this.getName());

        return org.andromda.utils.StringUtilsHelper.lowerCamelCaseName(backingListName);

    }

    /**
     * @return valueListName
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getValueListName()
     */
    @Override
    protected String handleGetValueListName()
    {

        return ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.VALUE_LIST_PATTERN)).replaceAll("\\{0\\}", this.getName());

    }

    /**
     * @return labelListName
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getLabelListName()
     */
    @Override
    protected String handleGetLabelListName()
    {

        return ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.LABEL_LIST_PATTERN)).replaceAll("\\{0\\}", this.getName());

    }

    /**
     * @return validatorTypes
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getValidatorTypes()
     */
    @Override
    protected Collection handleGetValidatorTypes()
    {

        return GuiUtils.getValidatorTypes((ModelElementFacade) this.THIS(), this.getType());

    }

    /**
     * @return !getValidatorTypes().isEmpty()
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#isValidationRequired()
     */
    @Override
    protected boolean handleIsValidationRequired()
    {

        return !this.getValidatorTypes().isEmpty();

    }

    /**
     * @return validatorVars
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getValidatorVars()
     */
    @Override
    protected Collection handleGetValidatorVars()
    {

        return GuiUtils.getValidatorVars((ModelElementFacade) this.THIS(), this.getType(), null);

    }

    /**
     * @return GuiUtils.getValidWhen(this)
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getValidWhen()
     */
    @Override
    protected String handleGetValidWhen()
    {

        return GuiUtils.getValidWhen(this);

    }

    /**
     * @return checkbox
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#isInputCheckbox()
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
     * @return file
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#isInputFile()
     */
    @Override
    protected boolean handleIsInputFile()
    {

        boolean file = false;
        final ClassifierFacade type = this.getType();

        if (type != null)
        {

            file = type.isFileType() || type.isBlobType();

        }

        return file;

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_HIDDEN)
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#isInputHidden()
     */
    @Override
    protected boolean handleIsInputHidden()
    {

        return this.isInputType(GuiGlobals.INPUT_HIDDEN);

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_MULTIBOX)
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#isInputMultibox()
     */
    @Override
    protected boolean handleIsInputMultibox()
    {

        return this.isInputType(GuiGlobals.INPUT_MULTIBOX);

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_RADIO)
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#isInputRadio()
     */
    @Override
    protected boolean handleIsInputRadio()
    {

        return this.isInputType(GuiGlobals.INPUT_RADIO);

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_PASSWORD)
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#isInputSecret()
     */
    @Override
    protected boolean handleIsInputSecret()
    {

        return this.isInputType(GuiGlobals.INPUT_PASSWORD);

    }

    /**
     * @return isInputType(GuiGlobals.INPUT_SELECT)
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#isInputSelect()
     */
    @Override
    protected boolean handleIsInputSelect()
    {

        return this.isInputType(GuiGlobals.INPUT_SELECT);

    }

    /**
     * @return isInputTable
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#isInputTable()
     */
    @Override
    protected boolean handleIsInputTable()
    {

        return (this.getInputTableIdentifierColumns().length() > 0) || this.isInputType(GuiGlobals.INPUT_TABLE);

    }

    /**
     * @return inputTableIdentifierColumns
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getInputTableIdentifierColumns()
     */
    @Override
    protected String handleGetInputTableIdentifierColumns()
    {

        return ObjectUtils.toString(this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_TABLE_IDENTIFIER_COLUMNS)).trim();

    }

    /**
     * @return isInputText
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#isInputText()
     */
    @Override
    protected boolean handleIsInputText()
    {

        return this.isInputType(GuiGlobals.INPUT_TEXT);

    }

    /**
     * @return isInputTextarea
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#isInputTextarea()
     */
    @Override
    protected boolean handleIsInputTextarea()
    {

        return this.isInputType(GuiGlobals.INPUT_TEXTAREA);

    }

    /**
     * @return isInputTypePresent
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#isInputTypePresent()
     */
    @Override
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
     * @return dummyValue
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getDummyValue()
     */
    @Override
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
     * @return isEqualValidator
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#isEqualValidator()
     */
    @Override
    protected boolean handleIsEqualValidator()
    {

        final String equal = GuiUtils.getEqual((ModelElementFacade) this.THIS());

        return (equal != null) && (equal.trim().length() > 0);

    }

    /**
     * @return isInputType(GuiGlobals.PLAIN_TEXT)
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#isPlaintext()
     */
    @Override
    protected boolean handleIsPlaintext()
    {

        return this.isInputType(GuiGlobals.PLAIN_TEXT);

    }

    /**
     * @return constructDummyArray()
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getValueListDummyValue()
     */
    @Override
    protected String handleGetValueListDummyValue()
    {

        return this.constructDummyArray();

    }

    /**
     * @param validatorType
     * @return getValidatorArgs
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getValidatorArgs(String)
     */
    @Override
    protected Collection handleGetValidatorArgs(final String validatorType)
    {

        return GuiUtils.getValidatorArgs((ModelElementFacade) this.THIS(), validatorType);

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
     * Overridden to provide consistent behavior with {@link GuiParameter#isReadOnly()}.
     * 
     * @see org.andromda.metafacades.uml.AttributeFacade#isReadOnly()
     */
    @Override
    public boolean isReadOnly()
    {

        return GuiUtils.isReadOnly(this);

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

    private String internalGetDateFormat()
    {

        String dateFormat = null;

        if ((this.getType() != null) && this.getType().isDateType())
        {

            final Object taggedValueObject = this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_FORMAT);

            if (taggedValueObject == null)
            {

                dateFormat = (String) this.getConfiguredProperty(GuiGlobals.PROPERTY_DEFAULT_DATEFORMAT);

            } else
            {

                dateFormat = taggedValueObject.toString();

            }

        }

        return dateFormat;

    }

    /**
     * @param ownerParameter
     * @return propertyName
     * @see GuiAttribute#getFormPropertyName(org.andromda.metafacades.uml.ParameterFacade)
     */
    @Override
    protected String handleGetFormPropertyName(final ParameterFacade ownerParameter)
    {

        final StringBuilder propertyName = new StringBuilder();

        if (ownerParameter != null)
        {

            propertyName.append(ownerParameter.getName());
            propertyName.append(".");

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
     * @return StringUtilsHelper.lowerCamelCaseName(this.getFormPropertyName(ownerParameter))
     * @see GuiAttribute#getFormPropertyId(ParameterFacade)
     */
    @Override
    protected String handleGetFormPropertyId(final ParameterFacade ownerParameter)
    {

        return StringUtilsHelper.lowerCamelCaseName(this.getFormPropertyName(ownerParameter));

    }

    // TODO remove after 3.4 release
    /**
     * Hack to keep the compatibility with Andromda 3.4-SNAPSHOT
     * 
     * @return defaultValue
     */
    @Override
    public String getDefaultValue()
    {

        String defaultValue = super.getDefaultValue();

        // Put single or double quotes around default in case modeler forgot to do it. Most templates
        // declare Type attribute = $attribute.defaultValue, requiring quotes around the value
        if ((defaultValue != null) && (defaultValue.length() > 0) && !super.isMany())
        {

            final String typeName = this.getType().getName();

            if ("String".equals(typeName) && (defaultValue.indexOf('"') < 0))
            {

                defaultValue = '"' + defaultValue + '"';

            } else if (("char".equals(typeName) || "Character".equals(typeName)) && !defaultValue.contains("'"))
            {

                defaultValue = "'" + defaultValue.charAt(0) + "'";

            }

        }

        if (defaultValue == null)
        {

            defaultValue = "";

        }

        return defaultValue;

    }

    /**
     * @return getColumnLength()
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute#getMaxLength()
     */
    @Override
    protected String handleGetMaxLength()
    {

        final Collection vars = this.getValidatorVars();

        if (vars == null)
        {

            return this.getColumnLength();

        }

        for (final Iterator<Collection> it = vars.iterator(); it.hasNext();)
        {

            final Object[] values = (it.next()).toArray();

            if ("maxlength".equals(values[0]))
            {

                return values[1].toString();

            }

        }

        return this.getColumnLength();

    }

    @Override
    protected boolean handleIsReadOnlyForUpdate()
    {

        final Object roUpTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_READONLY_UPDATE);

        return (roUpTag == null) ? false : GuiUtils.isTrue(String.valueOf(roUpTag));

    }

    @Override
    protected boolean handleIsSafeNamePresent()
    {

        return GuiUtils.isSafeName(this.getName());

    }

    @Override
    protected String handleGetCoherencyStateWhenDeactivated(final GuiManageableEntityAttribute targetElement)
    {

        final Collection<GuiManageableEntityAttribute> stateCoherencies = this.getStateCoherencies();

        for (final GuiManageableEntityAttribute guiManageableEntityAttribute : stateCoherencies)
        {

            final DependencyFacade coherency = (DependencyFacade) guiManageableEntityAttribute;

            if (coherency.getTargetElement().equals(targetElement))
            {

                return String.valueOf(coherency.findTaggedValue(GuiProfile.TAGGEDVALUE_COHERENCY_STATE_WHEN_DEACTIVATED));

            }

        }

        return null;

    }

    /**
     * @return true if this element is a coherency (state/value) source (dependency going out of it)
     */
    @Override
    protected boolean handleIsCoherencySource()
    {

        final Collection<DependencyFacade> coherencies = this.getSourceDependencies();

        for (final DependencyFacade dependencyFacade : coherencies)
        {

            final DependencyFacade dependency = dependencyFacade;

            if (dependency.hasStereotype(GuiProfile.STEREOTYPE_COHERENCY_REF))
            {

                // this.logger_.info("IsCoherencySource source : " + dependency.getName() + " - " + dependency.getSourceElement().getName() + " for : " + this.getFullyQualifiedName());
                return true;

            }

        }

        return false;

    }

    @Override
    protected int handleGetFieldSize()
    {

        final Object roUpTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_SIZE);

        return (roUpTag == null) ? GuiProfile.TAGGEDVALUE_INPUT_DEFAULT_SIZE : Integer.valueOf(String.valueOf(roUpTag)).intValue();

    }

    @Override
    protected boolean handleIsDealId()
    {

        final Object filterTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_SHOW_DEAL_DEAL_ID);

        return (filterTag == null) ? false : GuiUtils.isTrue(String.valueOf(filterTag));

    }

    @Override
    protected String handleGetChoiceType()
    {

        final Object filterTag = this.findTaggedValue(GuiProfile.CHOICE_TYPE_NAME);

        this.logger_.info("GetChoiceType : The tag value is : " + filterTag + " for tag : " + GuiProfile.CHOICE_TYPE_NAME + " - " + this.getFullyQualifiedName());

        return (filterTag == null) ? GuiProfile.TAGGEDVALUE_CHOICE_TYPE_DEFAULT_TYPE : String.valueOf(filterTag);

    }

    @Override
    protected java.lang.String handleGetNumericFormat()
    {

        final Object formTag = this.findTaggedValue(GuiProfile.NUMERIC_TYPE_NAME);
        final String format = (formTag == null) ? GuiProfile.TAGGEDVALUE_NUMERIC_TYPE_DEFAULT : formTag.toString();

        return GuiUtils.getNumberFormat(format);

    }

    /**
     * @return a list of value coherencies for which this element is the source
     */
    @Override
    protected List<DependencyFacade> handleGetValueCoherencyTargets()
    {

        return this.getValueCoherencies(this.getSourceDependencies());

    }

    @Override
    protected String handleGetDictionaryReturnType()
    {

        final Object filterTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_DICTIONARY_RETURN_TYPE);

        return (filterTag == null) ? "" : String.valueOf(filterTag);

    }

    @Override
    protected String handleGetFunctionalCoherency()
    {

        final Object filterTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_FUNCTIONAL_COHERENCY);

        return (filterTag == null) ? "None" : String.valueOf(filterTag);

    }

    /**
     * @param dependency, the dependency to evaluate
     * @return the value of the source value for this coherency
     */
    @Override
    protected Object handleGetSourceCoherencyValue(final DependencyFacade dependency)
    {

        return dependency.findTaggedValue(GuiProfile.TAGGEDVALUE_COHERENCY_SOURCE_SOURCEVALUE);

    }

    @Override
    protected boolean handleIsMandatory()
    {

        final Object mandatTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_MANDATORY_ELEMENT);

        return (mandatTag == null) ? GuiProfile.TAGGEDVALUE_VIEW_MANDATORY_ELEMENT_DEFAULT : GuiUtils.isTrue(String.valueOf(mandatTag));

    }

    @Override
    protected String handleGetDisplayName()
    {

        final Object filterTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_DISPLAY_NAME);

        return (filterTag == null) ? StringUtilsHelper.toPhrase(this.getName()) : String.valueOf(filterTag);

    }

    @Override
    protected boolean handleIsDealType()
    {

        final Object filterTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_SHOW_DEAL_DEAL_TYPE);

        return (filterTag == null) ? false : GuiUtils.isTrue(String.valueOf(filterTag));

    }

    /**
     * @return a list of state coherencies
     */
    @Override
    protected List<DependencyFacade> handleGetStateCoherencies()
    {

        final Collection<DependencyFacade> coherencies = this.getTargetDependencies();
        final List<DependencyFacade> stateCoherencies = new ArrayList<DependencyFacade>();

        for (final DependencyFacade dependencyFacade : coherencies)
        {

            final DependencyFacade dependency = dependencyFacade;
            final Object taggedValue = dependency.findTaggedValue(GuiProfile.TAGGEDVALUE_COHERENCY_IS_STATE);
            final boolean isValueCoherency = (taggedValue == null) ? false : GuiUtils.isTrue(String.valueOf(taggedValue));

            if (isValueCoherency)
            {

                stateCoherencies.add(dependency);

            }

        }

        return stateCoherencies;

    }

    /**
     * @return a collection of source coherency values, coherencies for which this element is the source.
     */
    @Override
    protected Collection<Object> handleGetAllSourceCoherencyValues()
    {

        final Collection<GuiManageableEntityAttribute> sourceCoherencies = this.getValueCoherencyTargets();
        final Collection<Object> sourceValues = new ArrayList<Object>();

        for (final GuiManageableEntityAttribute guiManageableEntityAttribute : sourceCoherencies)
        {

            final DependencyFacade dependency = (DependencyFacade) guiManageableEntityAttribute;
            final Object value = this.getSourceCoherencyValue(dependency);

            if (!sourceValues.contains(value))
            {

                sourceValues.add(value);

            }

        }

        return sourceValues;

    }

    /**
     * @return @return true if this element is a coherency (state/value) target (dependency going in it)
     */
    @Override
    protected boolean handleIsCoherencyTarget()
    {

        final Collection<DependencyFacade> coherencies = this.getTargetDependencies();

        for (final DependencyFacade dependencyFacade : coherencies)
        {

            final DependencyFacade dependency = dependencyFacade;

            if (dependency.hasStereotype(GuiProfile.STEREOTYPE_COHERENCY_REF))
            {

                // this.logger_.info("IsCoherencyTarget target : " + dependency.getName() + " - " + dependency.getSourceElement().getName() + " for : " + this.getFullyQualifiedName());
                return true;

            }

        }

        return false;

    }

    @Override
    protected boolean handleIsFilterElement()
    {

        final Object filterTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_SIMPLE_FILTER_ELEMENT);

        return (filterTag == null) ? GuiProfile.TAGGEDVALUE_VIEW_SIMPLE_FILTER_ELEMENT_DEFAULT : GuiUtils.isTrue(String.valueOf(filterTag));

    }

    /**
     * @return a collection of target coherency values, coherencies for which this element is the target
     */
    @Override
    protected Collection<GuiManageableEntityAttribute> handleGetAllTargetCoherencyValues()
    {

        final Collection<GuiManageableEntityAttribute> sourceCoherencies = this.getValueCoherencySources();
        final Collection<GuiManageableEntityAttribute> sourceValues = new ArrayList<GuiManageableEntityAttribute>();

        for (final GuiManageableEntityAttribute guiManageableEntityAttribute : sourceCoherencies)
        {

            final DependencyFacade dependency = (DependencyFacade) guiManageableEntityAttribute;
            final Collection<GuiManageableEntityAttribute> targetValues = this.getTargetCoherencyValues(this, this.getSourceCoherencyValue(dependency));

            for (final GuiManageableEntityAttribute value : targetValues)
            {

                if (!sourceValues.contains(value))
                {

                    sourceValues.add(value);

                }

            }

        }

        return sourceValues;

    }

    /**
     * @return a list of value coherencies for which this element is the target
     */
    @Override
    protected List<DependencyFacade> handleGetValueCoherencySources()
    {

        return this.getValueCoherencies(this.getTargetDependencies());

    }

    @Override
    protected String handleGetCoherencyStateWhenActivated(final GuiManageableEntityAttribute targetElement)
    {

        final Collection<GuiManageableEntityAttribute> stateCoherencies = this.getStateCoherencies();

        for (final GuiManageableEntityAttribute guiManageableEntityAttribute : stateCoherencies)
        {

            final DependencyFacade coherency = (DependencyFacade) guiManageableEntityAttribute;

            if (coherency.getTargetElement().equals(targetElement))
            {

                return String.valueOf(coherency.findTaggedValue(GuiProfile.TAGGEDVALUE_COHERENCY_STATE_WHEN_ACTIVATED));

            }

        }

        return null;

    }

    /**
     * @param targetElement, the target element to evaluate
     * @param sourceValue, the source value to evaluate
     * @return a list of values that the target element must display in case the source value is reached.
     */
    @Override
    protected Collection<String> handleGetTargetCoherencyValues(final GuiManageableEntityAttribute targetElement, final Object sourceValue)
    {

        final Collection<GuiManageableEntityAttribute> valueCoherencies = this.getValueCoherencyTargets();

        // We need also sources of this element, because this element may be the target element of a dependency
        valueCoherencies.addAll(this.getValueCoherencySources());

        for (final GuiManageableEntityAttribute guiManageableEntityAttribute : valueCoherencies)
        {

            final DependencyFacade coherency = (DependencyFacade) guiManageableEntityAttribute;
            final Object source = coherency.findTaggedValue(GuiProfile.TAGGEDVALUE_COHERENCY_SOURCE_SOURCEVALUE);

            if (coherency.getTargetElement().equals(targetElement) && source.equals(sourceValue))
            {

                final String fullValue = String.valueOf(coherency.findTaggedValue(GuiProfile.TAGGEDVALUE_COHERENCY_SOURCE_TARGETVALUE));

                if (fullValue != null)
                {

                    final String[] values = fullValue.split(",");

                    for (int i = 0; i < values.length; i++)
                    {

                        values[i] = values[i].trim();

                    }

                    return Arrays.asList(values);

                }

            }

        }

        return null;

    }

    /**
     * @param targetElement, the element to evaluate
     * @param sourceValue, source object
     * @return true if the given targetElement must be deactivated for the given value
     */
    @Override
    protected boolean handleMustBeDeactivated(final GuiManageableEntityAttribute targetElement, final Object sourceValue)
    {

        // final Collection<DependencyFacade> valueCoherencies = new ArrayList(this.getValueCoherencySources());
        final List<GuiManageableEntityAttribute> valueCoherencies = this.getValueCoherencySources();

        // valueCoherencies.addAll(new ArrayList(this.getValueCoherencyTargets()));
        valueCoherencies.addAll(this.getValueCoherencyTargets());

        for (final GuiManageableEntityAttribute guiManageableEntityAttribute : valueCoherencies)
        {

            final DependencyFacade coherency = (DependencyFacade) guiManageableEntityAttribute;
            final Object source = coherency.findTaggedValue(GuiProfile.TAGGEDVALUE_COHERENCY_SOURCE_SOURCEVALUE);

            if (coherency.getTargetElement().equals(targetElement) && source.equals(sourceValue))
            {

                final Object taggedValue = coherency.findTaggedValue(GuiProfile.TAGGEDVALUE_COHERENCY_SOURCE_TARGET_DEACTIVATE);

                return (taggedValue != null) ? GuiUtils.isTrue(String.valueOf(taggedValue)) : false;

            }

        }

        return false;

    }

    /**
     * Extract from a list of dependencies those which are Value Coherencies
     * 
     * @param coherencies, a list of dependencies of type DependencyFacade
     * @return a list of value coherencies
     */
    private List<DependencyFacade> getValueCoherencies(final Collection<DependencyFacade> coherencies)
    {

        final List<DependencyFacade> valueCoherencies = new ArrayList<DependencyFacade>();

        for (final DependencyFacade dependencyFacade : coherencies)
        {

            final DependencyFacade dependency = dependencyFacade;
            final Object taggedValue = dependency.findTaggedValue(GuiProfile.TAGGEDVALUE_COHERENCY_IS_VALUE);
            final boolean isValueCoherency = (taggedValue == null) ? false : GuiUtils.isTrue(String.valueOf(taggedValue));

            if (isValueCoherency)
            {

                valueCoherencies.add(dependency);

            }

        }

        return valueCoherencies;

    }

}

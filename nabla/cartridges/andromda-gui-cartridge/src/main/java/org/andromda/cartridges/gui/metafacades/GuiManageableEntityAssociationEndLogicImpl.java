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

import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.Entity;
import org.andromda.metafacades.uml.ManageableEntity;
import org.andromda.metafacades.uml.UMLProfile;

import org.andromda.utils.StringUtilsHelper;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import org.apache.log4j.Logger;

import java.util.Collection;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd.
 * 
 * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd
 */
public class GuiManageableEntityAssociationEndLogicImpl extends GuiManageableEntityAssociationEndLogic
{

    private static final long serialVersionUID = 34L;
    private final Logger      logger_          = Logger.getLogger(GuiManageableEntityAssociationEndLogicImpl.class);

    /**
     * @param metaObject
     * @param context
     */
    public GuiManageableEntityAssociationEndLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * @return messageKey
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd#getMessageKey()
     */
    @Override
    protected String handleGetMessageKey()
    {

        final StringBuilder messageKeyBuffer = new StringBuilder();

        final ClassifierFacade ownerType = this.getOtherEnd().getType();

        if (ownerType instanceof ManageableEntity)
        {

            messageKeyBuffer.append(ownerType.getName());

        } else
        {

            messageKeyBuffer.append(ownerType.getName());

        }

        messageKeyBuffer.append(".");
        messageKeyBuffer.append(this.getName());

        return StringUtilsHelper.toResourceMessageKey(messageKeyBuffer.toString());

    }

    /**
     * @return messageValue
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd#getMessageValue()
     */
    @Override
    protected String handleGetMessageValue()
    {

        String messageValue = null;

        final ClassifierFacade type = this.getType();

        if (type instanceof Entity)
        {

            messageValue = this.getName();

        }

        return StringUtilsHelper.toPhrase(messageValue);

    }

    /**
     * @return getMessageKey() + ".online.help"
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd#getOnlineHelpKey()
     */
    @Override
    // TODO REMOVE
    protected String handleGetOnlineHelpKey()
    {

        return this.getMessageKey() + ".online.help";

    }

    /**
     * @return onlineHelpValue
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd#getOnlineHelpValue()
     */
    @Override
    // TODO REMOVE
    protected String handleGetOnlineHelpValue()
    {

        final String value = StringUtilsHelper.toResourceMessage(this.getDocumentation("", 64, false));

        return (value == null) ? "No field documentation has been specified" : value;

    }

    /**
     * @return backingListName
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd#getBackingListName()
     */
    @Override
    protected String handleGetBackingListName()
    {

        final String backingListName = StringUtils.replace(ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.BACKING_LIST_PATTERN)), "{0}", this.getName());

        return org.andromda.utils.StringUtilsHelper.lowerCamelCaseName(backingListName);

    }

    /**
     * @return valueListName
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd#getValueListName()
     */
    @Override
    protected String handleGetValueListName()
    {

        return ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.VALUE_LIST_PATTERN)).replaceAll("\\{0\\}", this.getName());

    }

    /**
     * @return labelListName
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd#getLabelListName()
     */
    @Override
    protected String handleGetLabelListName()
    {

        return ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.LABEL_LIST_PATTERN)).replaceAll("\\{0\\}", this.getName());

    }

    @Override
    protected boolean handleIsMandatory()
    {

        final Object mandatTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_MANDATORY_ELEMENT);

        return (mandatTag == null) ? false : GuiUtils.isTrue(String.valueOf(mandatTag));

    }

    @Override
    protected boolean handleIsSafeNamePresent()
    {

        return GuiUtils.isSafeName(this.getName());

    }

    @Override
    protected boolean handleIsReadOnlyForUpdate()
    {

        final Object roUpTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_READONLY_UPDATE);

        return (roUpTag == null) ? false : GuiUtils.isTrue(String.valueOf(roUpTag));

    }

    @Override
    protected boolean handleIsFilterElement()
    {

        final Object filterTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_SIMPLE_FILTER_ELEMENT);

        return (filterTag == null) ? GuiProfile.TAGGEDVALUE_VIEW_SIMPLE_FILTER_ELEMENT_DEFAULT : GuiUtils.isTrue(String.valueOf(filterTag));

    }

    @Override
    protected String handleGetDisplayName()
    {

        final Object filterTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_DISPLAY_NAME);

        return (filterTag == null) ? StringUtilsHelper.toPhrase(this.getName()) : String.valueOf(filterTag);

    }

    @Override
    protected String handleGetFunctionalCoherency()
    {

        final Object filterTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_FUNCTIONAL_COHERENCY);

        return (filterTag == null) ? "None" : String.valueOf(filterTag);

    }

    @Override
    protected String handleGetDictionaryReturnType()
    {

        final Object filterTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_DICTIONARY_RETURN_TYPE);

        return (filterTag == null) ? "" : String.valueOf(filterTag);

    }

    @Override
    protected boolean handleIsSimpleDisplay()
    {

        final Object filterTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_REF_SIMPLE_DISPLAY);

        return (filterTag == null) ? false : GuiUtils.isTrue(String.valueOf(filterTag));

    }

    @Override
    protected String handleGetWidgetType()
    {

        final Object widgetTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_TYPE);

        return (widgetTag == null) ? GuiGlobals.INPUT_TEXT : widgetTag.toString();

    }

    @Override
    protected String handleGetOtherEndReferenceColumnName()
    {

        final ClassifierFacade classifier = this.getOtherEnd().getType();
        String refColName = null;

        if (classifier.hasStereotype(UMLProfile.STEREOTYPE_ENTITY) && classifier.hasStereotype(GuiProfile.STEREOTYPE_BUSINESS_OBJECT))
        {

            final Object filterTag = classifier.findTaggedValue(GuiProfile.TAGGEDVALUE_BUSINESS_OBJECT_REF_COLUMN);

            if (filterTag != null)
            {

                refColName = String.valueOf(filterTag);
                this.logger_.info("GetOtherEndReferenceColumnName : Other reference column for : " + refColName + " - " + GuiProfile.TAGGEDVALUE_BUSINESS_OBJECT_REF_COLUMN + " - " + this.getFullyQualifiedName());

            } else
            {

                refColName = this.findDefaultOtherEndReferenceColumn(classifier);

            }

        }

        return refColName;

    }

    /**
     * @param classifier
     * @return default reference column name
     */
    private String findDefaultOtherEndReferenceColumn(final ClassifierFacade classifier)
    {

        String defaultRefColName = null;
        String businessRefShortName = null;
        String businessRefName = null;
        final Collection<AttributeFacade> allAttributes = classifier.getAttributes(true);

        for (final AttributeFacade attr : allAttributes)
        {

            final String attrNameLower = attr.getName().toLowerCase();

            if (attrNameLower.indexOf("shortname") > 0)
            {

                businessRefShortName = attr.getName();

            } else if (attrNameLower.indexOf("name") > 0)
            {

                businessRefName = attr.getName();

            }

        }

        if (businessRefName != null)
        {

            defaultRefColName = businessRefName;

        } else if (businessRefShortName != null)
        {

            defaultRefColName = businessRefShortName;

        }

        this.logger_.info("OtherEndReferenceColumn : Other reference column for : " + defaultRefColName + " - " + this.getFullyQualifiedName());

        return defaultRefColName;

    }

}

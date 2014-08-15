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
import org.andromda.cartridges.gui.util.screensLib.ViewContent;

import org.andromda.metafacades.uml.AssociationEndFacade;
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.Entity;
import org.andromda.metafacades.uml.EntityAttribute;
import org.andromda.metafacades.uml.FilteredCollection;
import org.andromda.metafacades.uml.GeneralizableElementFacade;
import org.andromda.metafacades.uml.ManageableEntity;
import org.andromda.metafacades.uml.ManageableEntityAssociationEnd;
import org.andromda.metafacades.uml.ManageableEntityAttribute;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.Role;
import org.andromda.metafacades.uml.Service;
import org.andromda.metafacades.uml.UMLMetafacadeProperties;
import org.andromda.metafacades.uml.UMLProfile;
import org.andromda.metafacades.uml.ValueObject;

import org.andromda.translation.ocl.ExpressionKinds;

import org.andromda.utils.StringUtilsHelper;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import org.apache.log4j.Logger;

import org.dom4j.DocumentException;

import java.io.File;

import java.net.MalformedURLException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiManageableEntity.
 * 
 * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity
 */
public class GuiManageableEntityLogicImpl extends GuiManageableEntityLogic
{

    private static final long serialVersionUID = 34L;
    private final Logger      logger_          = Logger.getLogger(GuiManageableEntityLogicImpl.class);

    /**
     * @param metaObject
     * @param context
     */
    public GuiManageableEntityLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * @return getName().toLowerCase() + "-crud"
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getViewName()
     */
    @Override
    protected String handleGetViewName()
    {

        return this.getName().toLowerCase() + "-crud";

    }

    /**
     * @return toResourceMessageKey(this.getName()) + ".view.title"
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getViewTitleKey()
     */
    @Override
    protected String handleGetViewTitleKey()
    {

        return StringUtilsHelper.toResourceMessageKey(this.getName()) + ".view.title";

    }

    /**
     * @return StringUtilsHelper.toPhrase(getName())
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getViewTitleValue()
     */
    @Override
    protected String handleGetViewTitleValue()
    {

        return StringUtilsHelper.toPhrase(this.getName());

    }

    /**
     * @return "manageableList"
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getListName()
     */
    @Override
    protected String handleGetListName()
    {

        return "manageableList";

    }

    /**
     * @return getManageablePackageName() + getNamespaceProperty() + this.getFormBeanClassName()
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getFormBeanType()
     */
    @Override
    protected String handleGetFormBeanType()
    {

        return this.getManageablePackageName() + this.getNamespaceProperty() + this.getFormBeanClassName();

    }

    /**
     * @return formBeanName
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getFormBeanName()
     */
    @Override
    protected String handleGetFormBeanName()
    {

        final String pattern = ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.FORM_BEAN_PATTERN));
        final String formBeanName = pattern.replaceFirst("\\{0\\}", "manage");

        return formBeanName.replaceFirst("\\{1\\}", this.getName());

    }

    /**
     * @return StringUtilsHelper.toResourceMessageKey(this.getName()) + ".exception"
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getExceptionKey()
     */
    @Override
    protected String handleGetExceptionKey()
    {

        return StringUtilsHelper.toResourceMessageKey(this.getName()) + ".exception";

    }

    /**
     * @return getManageablePackageName() + getNamespaceProperty() + getActionClassName()
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getActionType()
     */
    @Override
    protected String handleGetActionType()
    {

        return this.getManageablePackageName() + this.getNamespaceProperty() + this.getActionClassName();

    }

    /**
     * @return GuiGlobals.SEPARATOR + StringUtils.replace(this.getActionType(), getNamespaceProperty(), GuiGlobals.SEPARATOR)
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getActionFullPath()
     */
    @Override
    protected String handleGetActionFullPath()
    {

        return GuiGlobals.SEPARATOR + StringUtils.replace(this.getActionType(), this.getNamespaceProperty(), GuiGlobals.SEPARATOR);

    }

    /**
     * @return GuiGlobals.SEPARATOR + getName() + GuiGlobals.SEPARATOR + "Manage"
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getActionPath()
     */
    @Override
    protected String handleGetActionPath()
    {

        return GuiGlobals.SEPARATOR + this.getName() + GuiGlobals.SEPARATOR + "Manage";

    }

    /**
     * @return "Manage" + getName()
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getActionClassName()
     */
    @Override
    protected String handleGetActionClassName()
    {

        return "Manage" + this.getName();

    }

    /**
     * @return getViewFullPath()
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getExceptionPath()
     */
    @Override
    protected String handleGetExceptionPath()
    {

        return this.getViewFullPath();

    }

    /**
     * @return false
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#isPreload()
     */
    @Override
    protected boolean handleIsPreload()
    {

        return false; // TODO think about...
        // return this.isCreate() || this.isRead() || this.isUpdate() || this.isDelete();

    }

    /**
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntityLogic#getManageableIdentifier()
     */
    @Override
    public org.andromda.metafacades.uml.ManageableEntityAttribute getManageableIdentifier()
    {

        return super.getManageableIdentifier();

    }

    /**
     * @return StringUtils.capitalize(this.getFormBeanName())
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getFormBeanClassName()
     */
    @Override
    protected String handleGetFormBeanClassName()
    {

        return StringUtils.capitalize(this.getFormBeanName());

    }

    /**
     * @return StringUtils.replace(getFormBeanType(), getNamespaceProperty(), GuiGlobals.SEPARATOR)
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getFormBeanFullPath()
     */
    @Override
    protected String handleGetFormBeanFullPath()
    {

        return StringUtils.replace(this.getFormBeanType(), this.getNamespaceProperty(), GuiGlobals.SEPARATOR);

    }

    /**
     * @return "getManageableList"
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getListGetterName()
     */
    @Override
    protected String handleGetListGetterName()
    {

        return "getManageableList";

    }

    /**
     * @return "setManageableList"
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getListSetterName()
     */
    @Override
    protected String handleGetListSetterName()
    {

        return "setManageableList";

    }

    /**
     * @return StringUtilsHelper.toResourceMessageKey(this.getName())
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getMessageKey()
     */
    @Override
    protected String handleGetMessageKey()
    {

        return StringUtilsHelper.toResourceMessageKey(this.getName());

    }

    /**
     * @return StringUtilsHelper.toPhrase(this.getName())
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getMessageValue()
     */
    @Override
    protected String handleGetMessageValue()
    {

        return StringUtilsHelper.toPhrase(this.getName());

    }

    /**
     * @return getMessageKey() + ".online.help"
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getOnlineHelpKey()
     */
    @Override
    // TODO REMOVE
    protected String handleGetOnlineHelpKey()
    {

        return this.getMessageKey() + ".online.help";

    }

    /**
     * @return onlineHelpValue
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getOnlineHelpValue()
     */
    @Override
    // TODO REMOVE
    protected String handleGetOnlineHelpValue()
    {

        final String value = StringUtilsHelper.toResourceMessage(this.getDocumentation("", 64, false));

        return (value == null) ? "No entity documentation has been specified" : value;

    }

    /**
     * @return getActionPath() + "Help"
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getOnlineHelpActionPath()
     */
    @Override
    // TODO REMOVE
    protected String handleGetOnlineHelpActionPath()
    {

        return this.getActionPath() + "Help";

    }

    /**
     * @return GuiGlobals.SEPARATOR + getManageablePackagePath() + GuiGlobals.SEPARATOR + getName().toLowerCase() + "_help"
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getOnlineHelpPagePath()
     */
    @Override
    // TODO REMOVE
    protected String handleGetOnlineHelpPagePath()
    {

        return GuiGlobals.SEPARATOR + this.getManageablePackagePath() + GuiGlobals.SEPARATOR + this.getName().toLowerCase() + "_help";

    }

    /**
     * @return getTableExportTypes().indexOf("none") == -1
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#isTableExportable()
     */
    @Override
    protected boolean handleIsTableExportable()
    {

        return this.getTableExportTypes().indexOf("none") == -1;

    }

    /**
     * @return null
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getTableExportTypes()
     */
    @Override
    protected String handleGetTableExportTypes()
    {

        return null;

        // TODO a resolver
        // return GuiUtils.getDisplayTagExportTypes(
        // this.findTaggedValues(GuiProfile.TAGGEDVALUE_TABLE_EXPORT),
        // (String)getConfiguredProperty(GuiGlobals.PROPERTY_DEFAULT_TABLE_EXPORT_TYPES) );
    }

    /**
     * @return tableMaxRows
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getTableMaxRows()
     */
    @Override
    protected int handleGetTableMaxRows()
    {

        final Object taggedValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_TABLE_MAXROWS);
        int pageSize;

        try
        {

            pageSize = Integer.parseInt(String.valueOf(taggedValue));

        } catch (final Exception e)
        {

            pageSize = GuiProfile.TAGGEDVALUE_TABLE_MAXROWS_DEFAULT_COUNT;

        }

        return pageSize;

    }

    /**
     * @return tableSortable
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#isTableSortable()
     */
    @Override
    protected boolean handleIsTableSortable()
    {

        final Object taggedValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_TABLE_SORTABLE);

        return (taggedValue == null) ? GuiProfile.TAGGEDVALUE_TABLE_SORTABLE_DEFAULT_VALUE : Boolean.valueOf(String.valueOf(taggedValue)).booleanValue();

    }

    /**
     * @return controllerType
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getControllerType()
     */
    @Override
    protected String handleGetControllerType()
    {

        return this.getManageablePackageName() + this.getNamespaceProperty() + this.getControllerName();

    }

    /**
     * @return StringUtils.uncapitalize(this.getName()) + "Controller"
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getControllerBeanName()
     */
    @Override
    protected String handleGetControllerBeanName()
    {

        return StringUtils.uncapitalize(this.getName()) + "Controller";

    }

    /**
     * @return GuiGlobals.SEPARATOR + StringUtils.replace(getControllerType(), getNamespaceProperty(), GuiGlobals.SEPARATOR)
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getControllerFullPath()
     */
    @Override
    protected String handleGetControllerFullPath()
    {

        return GuiGlobals.SEPARATOR + StringUtils.replace(this.getControllerType(), this.getNamespaceProperty(), GuiGlobals.SEPARATOR);

    }

    /**
     * @return getName() + "Controller"
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getControllerName()
     */
    @Override
    protected String handleGetControllerName()
    {

        return this.getName() + "Controller";

    }

    /**
     * @return getName() + this.getConfiguredProperty(GuiGlobals.CRUD_VALUE_OBJECT_SUFFIX)
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getValueObjectClassName()
     */
    @Override
    protected String handleGetValueObjectClassName()
    {

        return this.getName() + this.getConfiguredProperty(GuiGlobals.CRUD_VALUE_OBJECT_SUFFIX);

    }

    /**
     * @return formSerialVersionUID
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getFormSerialVersionUID()
     */
    @Override
    protected String handleGetFormSerialVersionUID()
    {

        final StringBuilder buffer = new StringBuilder();

        buffer.append(this.getFormBeanType());
        this.addSerialUIDData(buffer);

        return GuiUtils.calcSerialVersionUID(buffer);

    }

    /**
     * @return actionSerialVersionUID
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getActionSerialVersionUID()
     */
    @Override
    protected String handleGetActionSerialVersionUID()
    {

        final StringBuilder buffer = new StringBuilder();

        buffer.append(this.getActionFullPath());
        this.addSerialUIDData(buffer);

        return GuiUtils.calcSerialVersionUID(buffer);

    }

    /**
     * @return populatorName
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getPopulatorName()
     */
    @Override
    protected String handleGetPopulatorName()
    {

        return ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.VIEW_POPULATOR_PATTERN)).replaceAll("\\{0\\}", StringUtilsHelper.upperCamelCaseName(this.getFormBeanClassName()));

    }

    /**
     * @return GuiGlobals.SEPARATOR + StringUtils.replace(getPopulatorType(), getNamespaceProperty(), GuiGlobals.SEPARATOR)
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getPopulatorFullPath()
     */
    @Override
    protected String handleGetPopulatorFullPath()
    {

        return GuiGlobals.SEPARATOR + StringUtils.replace(this.getPopulatorType(), this.getNamespaceProperty(), GuiGlobals.SEPARATOR);

    }

    /**
     * @return getManageablePackageName() + getNamespaceProperty() + getPopulatorName()
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getPopulatorType()
     */
    @Override
    protected String handleGetPopulatorType()
    {

        return this.getManageablePackageName() + this.getNamespaceProperty() + this.getPopulatorName();

    }

    /**
     * @return GuiGlobals.SEPARATOR + getManageablePackagePath() + GuiGlobals.SEPARATOR + getViewName()
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getViewFullPath()
     */
    @Override
    protected String handleGetViewFullPath()
    {

        return GuiGlobals.SEPARATOR + this.getManageablePackagePath() + GuiGlobals.SEPARATOR + this.getViewName();

    }

    /**
     * @return GuiGlobals.SEPARATOR + getManageablePackagePath() + GuiGlobals.SEPARATOR + getName().toLowerCase() + "-ods-export"
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getViewFullPath()
     */
    @Override
    protected String handleGetOdsExportFullPath()
    {

        return GuiGlobals.SEPARATOR + this.getManageablePackagePath() + GuiGlobals.SEPARATOR + this.getName().toLowerCase() + "-ods-export";

    }

    /**
     * @return isValidationRequired
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#isValidationRequired()
     */
    @Override
    protected boolean handleIsValidationRequired()
    {

        for (final ManageableEntityAttribute attribute : this.getManageableAttributes())
        {

            if (attribute instanceof GuiManageableEntityAttribute)
            {

                final GuiManageableEntityAttribute jsfAttribute = (GuiManageableEntityAttribute) attribute;

                if (jsfAttribute.isValidationRequired())
                {

                    return true;

                }

            }

        }

        return false;

    }

    /**
     * @return searchFormBeanName
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getSearchFormBeanName()
     */
    @Override
    protected String handleGetSearchFormBeanName()
    {

        final String pattern = ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.FORM_BEAN_PATTERN));
        final String formBeanName = pattern.replaceFirst("\\{0\\}", "manage");

        return formBeanName.replaceFirst("\\{1\\}", this.getName() + "Search");

    }

    /**
     * @return searchFormBeanType
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getSearchFormBeanType()
     */
    @Override
    protected String handleGetSearchFormBeanType()
    {

        return this.getManageablePackageName() + this.getNamespaceProperty() + this.getSearchFormBeanClassName();

    }

    /**
     * @return searchFormBeanFullPath
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getSearchFormBeanFullPath()
     */
    @Override
    protected String handleGetSearchFormBeanFullPath()
    {

        return StringUtils.replace(this.getSearchFormBeanType(), this.getNamespaceProperty(), GuiGlobals.SEPARATOR);

    }

    /**
     * @return StringUtils.capitalize(this.getSearchFormBeanName())
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getSearchFormBeanClassName()
     */
    @Override
    protected String handleGetSearchFormBeanClassName()
    {

        return StringUtils.capitalize(this.getSearchFormBeanName());

    }

    /**
     * @return manageableSearchAttributes
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getManageableSearchAttributes()
     */
    @Override
    protected Collection<GuiManageableEntityAttribute> handleGetManageableSearchAttributes()
    {

        final Collection<GuiManageableEntityAttribute> coll = new ArrayList<GuiManageableEntityAttribute>();

        for (final ManageableEntityAttribute attribute : this.getManageableAttributes())
        {

            if (attribute instanceof GuiManageableEntityAttribute)
            {

                final GuiManageableEntityAttribute attr = (GuiManageableEntityAttribute) attribute;

                if (!attr.isHidden())
                {

                    coll.add(attr);

                }

            }

        }

        return coll;

    }

    /**
     * @return getManageableAssociationEnds()
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getManageableSearchAssociationEnds()
     */
    @Override
    protected Collection<ManageableEntityAssociationEnd> handleGetManageableSearchAssociationEnds()
    {

        return this.getManageableAssociationEnds();

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    @Override
    public List<ManageableEntityAttribute> getManageableAttributes()
    {

        return super.getManageableAttributes();

        /*
         * final List<AttributeFacade> all = this.getAttributes(true);
         * CollectionUtils.filter(all,
         * new Predicate() {
         * public boolean evaluate(final Object object) {
         * return (object instanceof AttributeFacade) && !((AttributeFacade) object).getName().equals("id");
         * }
         * });
         * return new ArrayList<AttributeFacade>(all);
         */
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    @Override
    public List<ManageableEntityAssociationEnd> getManageableAssociationEnds()
    {

        // return super.getManageableAssociationEnds();
        // TODO try to use getManageableAssociationEndsGuiManageableEntity it is faster
        return this.getManageableAssociationEndsManageableEntity(); // error go throught parent and got duplicated fields

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public List<ManageableEntityAssociationEnd> getManageableAssociationEndsManageableEntity()
    {

        // See in ManageableEntityLogicImpl.java in
        // andromda\\trunk\\metafacades\\uml\emf\\uml2\\src\\main\\java\\org\\andromda\\metafacades\\emf\\uml2
        final Set<ManageableEntityAssociationEnd> manageableAssociationEnds = new LinkedHashSet<ManageableEntityAssociationEnd>();

        // final List<ManageableEntityAssociationEnd> manageableAssociationEnds = new ArrayList<ManageableEntityAssociationEnd>();
        // linked hashset to guarantee ordering wo duplicates
        this.collectAssociationEndsManageableEntity(manageableAssociationEnds, this, true);

        return new ArrayList<ManageableEntityAssociationEnd>(manageableAssociationEnds);

        // return manageableAssociationEnds;
    }

    private List<ManageableEntityAssociationEnd> getManageableAssociationEndsEntity()
    {

        // See in ManageableEntityLogicImpl.java in
        // andromda\\trunk\\metafacades\\uml\emf\\uml2\\src\\main\\java\\org\\andromda\\metafacades\\emf\\uml2
        final Set<ManageableEntityAssociationEnd> manageableAssociationEnds = new LinkedHashSet<ManageableEntityAssociationEnd>();

        // final List<ManageableEntityAssociationEnd> manageableAssociationEnds = new ArrayList<ManageableEntityAssociationEnd>();
        // linked hashset to guarantee ordering wo duplicates
        this.collectAssociationEndsEntity(manageableAssociationEnds, this, true);

        return new ArrayList<ManageableEntityAssociationEnd>(manageableAssociationEnds);

        // return manageableAssociationEnds;
    }

    // TODO remove never used
    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public List<ManageableEntityAssociationEnd> getManageableAssociationEndsGuiManageableEntity()
    {

        // See in ManageableEntityLogicImpl.java in
        // andromda\\trunk\\metafacades\\uml\emf\\uml2\\src\\main\\java\\org\\andromda\\metafacades\\emf\\uml2
        final Set<ManageableEntityAssociationEnd> manageableAssociationEnds = new LinkedHashSet<ManageableEntityAssociationEnd>();

        // final List<ManageableEntityAssociationEnd> manageableAssociationEnds = new ArrayList<ManageableEntityAssociationEnd>();
        // linked hashset to guarantee ordering wo duplicates
        this.collectAssociationEndsGuiManageableEntity(manageableAssociationEnds, this, true);

        return new ArrayList<ManageableEntityAssociationEnd>(manageableAssociationEnds);

        // return manageableAssociationEnds;
    }

    /**
     * @param manageableAssociationEnds
     * @param entity
     */

    // TODO remove same as super.getManageableAssociationEnds();
    private void collectAssociationEndsEntity(final Collection<ManageableEntityAssociationEnd> manageableAssociationEnds, final Entity entity, final boolean filterRelevantAssoc)
    {

        final List<AssociationEndFacade> associationEnds = entity.getAssociationEnds();

        for (final AssociationEndFacade associationEnd : associationEnds)
        {

            final AssociationEndFacade otherEnd = associationEnd.getOtherEnd();

            if (this.logger_.isDebugEnabled())
            {

                this.logger_.debug("collectAssociationEndsEntity Name : " + associationEnd.getName() + " with otherEnd : " + otherEnd.getName() + " - " + otherEnd.isNavigable() + " -- " + otherEnd.getType() + " - "
                        + this.getFullyQualifiedName());

            }

            // if (otherEnd instanceof ManageableEntityAssociationEnd)
            if (otherEnd.isNavigable() && (otherEnd.getType() instanceof Entity))
            {

                manageableAssociationEnds.add((ManageableEntityAssociationEnd) otherEnd);

            } else
            {

                this.logger_.info("collectAssociationEndsEntity : " + otherEnd.getName() + " is not Entity for : " + otherEnd.getFullyQualifiedName() + " - " + this.getFullyQualifiedName());

            }

        }

        final Collection<GeneralizableElementFacade> parentEntities = entity.getAllGeneralizations();

        for (final Iterator<GeneralizableElementFacade> parentEntityIterator = parentEntities.iterator(); parentEntityIterator.hasNext();)
        {

            final Object parentEntityObject = parentEntityIterator.next();

            if (parentEntityObject instanceof /* ManageableEntity */
            Entity)
            {

                this.logger_.debug("collectAssociationEndsEntity : " + ((Entity) parentEntityObject).getName() + " parent found : " + ((Entity) parentEntityObject).getFullyQualifiedName() + " - "
                        + this.getFullyQualifiedName());

                this.collectAssociationEndsEntity(manageableAssociationEnds, (Entity) parentEntityObject, filterRelevantAssoc);

            }

        }

    }

    /**
     * @param manageableAssociationEnds
     * @param entity
     */
    private void collectAssociationEndsManageableEntity(final Collection<ManageableEntityAssociationEnd> manageableAssociationEnds, final/* Entity */ManageableEntity entity, final boolean filterRelevantAssoc)
    {

        final List<AssociationEndFacade> associationEnds = entity.getAssociationEnds();

        for (final AssociationEndFacade associationEnd : associationEnds)
        {

            final AssociationEndFacade otherEnd = associationEnd.getOtherEnd();

            if (this.logger_.isDebugEnabled())
            {

                this.logger_.debug("collectAssociationEndsManageableEntity Name : " + associationEnd.getName() + " with otherEnd : " + otherEnd.getName() + " - " + otherEnd.isNavigable() + " -- " + otherEnd.getType()
                        + " - " + this.getFullyQualifiedName());

            }

            // if (otherEnd.isNavigable() && otherEnd.getType() instanceof Entity) {
            if (otherEnd.isNavigable() && (otherEnd.getType() instanceof Entity) && !otherEnd.hasStereotype(GuiProfile.STEREOTYPE_VERSIONABLE_REF) && !otherEnd.hasStereotype(GuiProfile.STEREOTYPE_INTERCEPTABLE_REF)
                    && (this.isRelevantAssociation(otherEnd) || (filterRelevantAssoc == false)))
            {

                // if (otherEnd instanceof ManageableEntityAssociationEnd) {
                manageableAssociationEnds.add((ManageableEntityAssociationEnd) otherEnd);

            } else
            {

                this.logger_.info("collectAssociationEndsManageableEntity : " + otherEnd.getName() + " is not a valid association end for : " + otherEnd.getFullyQualifiedName() + " - " + this.getFullyQualifiedName());

            }

        }

        final Collection<GeneralizableElementFacade> parentEntities = entity.getAllGeneralizations();

        for (final Iterator<GeneralizableElementFacade> parentEntityIterator = parentEntities.iterator(); parentEntityIterator.hasNext();)
        {

            final Object parentEntityObject = parentEntityIterator.next();

            if (parentEntityObject instanceof ManageableEntity /* Entity */)
            {

                this.logger_.debug("collectAssociationEndsManageableEntity : " + ((ManageableEntity /* Entity */) parentEntityObject).getName() + " parent found : "
                        + ((ManageableEntity /* Entity */) parentEntityObject).getFullyQualifiedName() + " - " + this.getFullyQualifiedName());

                this.collectAssociationEndsManageableEntity(manageableAssociationEnds, (ManageableEntity /* Entity */) parentEntityObject, filterRelevantAssoc);

            }

        }

    }

    private void collectAssociationEndsGuiManageableEntity(final Collection<ManageableEntityAssociationEnd> manageableAssociationEnds, final GuiManageableEntity entity, final boolean filterRelevantAssoc)
    {

        final List<AssociationEndFacade> associationEnds = entity.getAssociationEnds();

        for (final AssociationEndFacade associationEnd : associationEnds)
        {

            final AssociationEndFacade otherEnd = associationEnd.getOtherEnd();

            if (this.logger_.isDebugEnabled())
            {

                this.logger_.debug("collectAssociationEndsGuiManageableEntity Name : " + associationEnd.getName() + " with otherEnd : " + otherEnd.getName() + " - " + otherEnd.isNavigable() + " -- " + otherEnd.getType()
                        + " - " + this.getFullyQualifiedName());

            }

            if (otherEnd.isNavigable() && (otherEnd.getType() instanceof GuiManageableEntity) && !otherEnd.hasStereotype(GuiProfile.STEREOTYPE_VERSIONABLE_REF)
                    && !otherEnd.hasStereotype(GuiProfile.STEREOTYPE_INTERCEPTABLE_REF) && (this.isRelevantAssociation(otherEnd) || (filterRelevantAssoc == false)))
            {

                if (otherEnd instanceof ManageableEntityAssociationEnd)
                {

                    manageableAssociationEnds.add((ManageableEntityAssociationEnd) otherEnd);

                } else
                {

                    this.logger_.info("collectAssociationEndsGuiManageableEntity : " + otherEnd.getName() + " is not ManageableEntityAssociationEnd for : " + otherEnd.getFullyQualifiedName() + " - "
                            + this.getFullyQualifiedName());

                }

            }

        }

        final Collection<GeneralizableElementFacade> parentEntities = entity.getAllGeneralizations();

        for (final Iterator<GeneralizableElementFacade> parentEntityIterator = parentEntities.iterator(); parentEntityIterator.hasNext();)
        {

            final Object parentEntityObject = parentEntityIterator.next();

            if (parentEntityObject instanceof GuiManageableEntity)
            {

                this.logger_.debug("collectAssociationEndsGuiManageableEntity : " + ((Entity) parentEntityObject).getName() + " parent found : " + ((Entity) parentEntityObject).getFullyQualifiedName() + " - "
                        + this.getFullyQualifiedName());

                this.collectAssociationEndsGuiManageableEntity(manageableAssociationEnds, (GuiManageableEntity) parentEntityObject, filterRelevantAssoc);

            }

        }

    }

    private boolean isRelevantAssociation(final AssociationEndFacade iEnd)
    {

        final Object filterTag = iEnd.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_ASSOCIATION_RELEVANT);

        return (filterTag == null) ? GuiProfile.TAGGEDVALUE_MANAGEABLE_ASSOCIATION_RELEVANT_DEFAULT : GuiUtils.isTrue(String.valueOf(filterTag));

    }

    /**
     * @param element
     * @return isSearchable
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#isSearchable(Object)
     */
    @Override
    protected boolean handleIsSearchable(final Object element)
    {

        // if(element instanceof GuiManageableEntityAttribute)
        // return getManageableSearchAttributes().contains(element);
        // else
        // return getManageableSearchAssociationEnds().contains(element);

        // TODO
        if (element instanceof GuiManageableEntityAttribute)
        {

            return !((GuiManageableEntityAttribute) element).isHidden();

        } else
        {

            return true;

        }

    }

    /**
     * @return the configured property denoting the character sequence to use for the separation of namespaces
     */
    private String getNamespaceProperty()
    {

        return (String) this.getConfiguredProperty(UMLMetafacadeProperties.NAMESPACE_SEPARATOR);

    }

    private void addSerialUIDData(final StringBuilder buffer)
    {

        for (final ManageableEntityAttribute attribute : this.getManageableAttributes())
        {

            buffer.append(attribute.getName());

        }

        for (final ManageableEntityAssociationEnd end : this.getManageableAssociationEnds())
        {

            buffer.append(end.getName());

        }

    }

    /**
     * @return allRoles
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getRoles()
     */
    @Override
    protected Collection<Role> handleGetRoles()
    {

        // copied form the Service <<Metafacade>>
        final Collection roles = new ArrayList(this.getTargetDependencies());

        CollectionUtils.filter(roles, new Predicate()
        {

            @Override
            public boolean evaluate(final Object object)
            {

                final DependencyFacade dependency = (DependencyFacade) object;

                return (dependency != null) && (dependency.getSourceElement() instanceof Role);

            }

        });
        CollectionUtils.transform(roles, new Transformer()
        {

            @Override
            public Object transform(final Object object)
            {

                return ((DependencyFacade) object).getSourceElement();

            }

        });

        final Collection allRoles = new LinkedHashSet(roles);

        // add all roles which are generalizations of this one
        CollectionUtils.forAllDo(roles, new Closure()
        {

            @Override
            public void execute(final Object object)
            {

                allRoles.addAll(((Role) object).getAllSpecializations());

            }

        });

        return allRoles;

    }

    /**
     * @return actionRoles
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getActionRoles()
     */
    @Override
    protected String handleGetActionRoles()
    {

        // copied from GuiUseCaseLogicImpl
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
     * @return needsFileUpload
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#isNeedsFileUpload()
     */
    @Override
    protected boolean handleIsNeedsFileUpload()
    {

        for (final ManageableEntityAttribute attribute : this.getManageableAttributes())
        {

            if (attribute instanceof GuiManageableEntityAttribute)
            {

                final GuiManageableEntityAttribute jsfAttribute = (GuiManageableEntityAttribute) attribute;

                if (jsfAttribute.isNeedsFileUpload())
                {

                    return true;

                }

            }

        }

        return false;

    }

    /**
     * @return needsUserInterface
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#isNeedsUserInterface()
     */
    @Override
    protected boolean handleIsNeedsUserInterface()
    {

        for (final ManageableEntityAttribute attribute : this.getManageableAttributes())
        {

            if (attribute instanceof GuiManageableEntityAttribute)
            {

                final GuiManageableEntityAttribute jsfAttribute = (GuiManageableEntityAttribute) attribute;

                if (!jsfAttribute.isHidden())
                {

                    return true;

                }

            }

        }

        for (final ManageableEntityAssociationEnd associationEnd : this.getManageableAssociationEnds())
        {

            if (associationEnd instanceof GuiManageableEntityAssociationEnd)
            {

                final GuiManageableEntityAssociationEnd jsfAssociationEnd = (GuiManageableEntityAssociationEnd) associationEnd;

                if (!jsfAssociationEnd.isDisplay())
                {

                    return true;

                }

            }

        }

        return false;

    }

    /**
     * @return converterClassName
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getConverterClassName
     */
    @Override
    public String handleGetConverterClassName()
    {

        return StringUtils.replace(ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.CONVERTER_PATTERN)), "{0}", this.getName());

    }

    /**
     * @return converterType
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getConverterType
     */
    @Override
    public String handleGetConverterType()
    {

        return this.getManageablePackageName() + this.getNamespaceProperty() + this.getConverterClassName();

    }

    /**
     * @return converterFullPath
     * @see org.andromda.cartridges.gui.metafacades.GuiManageableEntity#getConverterFullPath
     */
    @Override
    public String handleGetConverterFullPath()
    {

        return StringUtils.replace(this.getConverterType(), this.getNamespaceProperty(), GuiGlobals.SEPARATOR);

    }

    @Override
    protected java.lang.String handleGetPageName()
    {

        return this.getName().toLowerCase();

    }

    @Override
    protected java.lang.String handleGetPageFullPath()
    {

        return GuiGlobals.SEPARATOR + this.getManageablePackagePath() + GuiGlobals.SEPARATOR + this.getPageName();

    }

    @Override
    protected java.lang.String handleGetPageTitleKey()
    {

        return StringUtilsHelper.toResourceMessageKey(this.getName()) + ".page.title";

    }

    @Override
    protected java.lang.String handleGetPageTitleValue()
    {

        return StringUtilsHelper.toPhrase(this.getName());

    }

    @Override
    protected java.lang.String handleGetActionParameter()
    {

        return "crud";

    }

    @Override
    protected boolean handleIsMultipartFormData()
    {

        boolean multipartFormPost = false;

        final List<ManageableEntityAttribute> formFields = this.getManageableAttributes();

        for (final Iterator<ManageableEntityAttribute> fieldIterator = formFields.iterator(); !multipartFormPost && fieldIterator.hasNext();)
        {

            final AttributeFacade field = fieldIterator.next();

            if (field.getType().isFileType())
            {

                multipartFormPost = true;

            }

        }

        return multipartFormPost;

    }

    @Override
    protected Collection handleGetPreconditions()
    {

        return this.getConstraints(ExpressionKinds.PRE);

    }

    @Override
    protected Collection handleGetCreatePreconditions()
    {

        final Collection preConditions = this.getPreconditions();

        return new FilteredCollection(preConditions)
        {

            @Override
            public boolean evaluate(final Object object)
            {

                final ConstraintFacade preCondition = (ConstraintFacade) object;

                return preCondition.getBody().indexOf("::create") != -1;

            }

        };

    }

    @Override
    protected Collection handleGetUpdatePreconditions()
    {

        final Collection preConditions = this.getPreconditions();

        return new FilteredCollection(preConditions)
        {

            @Override
            public boolean evaluate(final Object object)
            {

                final ConstraintFacade preCondition = (ConstraintFacade) object;

                return preCondition.getBody().indexOf("::update") != -1;

            }

        };

    }

    @Override
    protected Collection handleGetDeletePreconditions()
    {

        final Collection preConditions = this.getPreconditions();

        return new FilteredCollection(preConditions)
        {

            @Override
            public boolean evaluate(final Object object)
            {

                final ConstraintFacade preCondition = (ConstraintFacade) object;

                return preCondition.getBody().indexOf("::delete") != -1;

            }

        };

    }

    @Override
    protected boolean handleIsRegroupMandatoryFields()
    {

        final Object taggedValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_REGROUP_REQUIRED);

        return (taggedValue == null) ? GuiProfile.TAGGEDVALUE_VIEW_REGROUP_MANDATORY_DEFAULT : GuiUtils.isTrue(String.valueOf(taggedValue));

    }

    @Override
    protected String handleGetDisplayName()
    {

        final Object filterTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_DISPLAY_NAME);

        return (filterTag == null) ? this.getName() : String.valueOf(filterTag);

    }

    @Override
    protected boolean handleIsVersionable()
    {

        return this.hasStereotype(GuiProfile.STEREOTYPE_VERSIONABLE);

    }

    @Override
    protected boolean handleIsVersionableRefExists()
    {

        final Collection<DependencyFacade> deps = this.getTargetDependencies();

        for (final DependencyFacade dependencyFacade : deps)
        {

            final DependencyFacade dep = dependencyFacade;

            if (dep.hasStereotype(GuiProfile.STEREOTYPE_VERSIONABLE_REF))
            {

                return true;

            }

        }

        final Collection<DependencyFacade> sourceDeps = this.getSourceDependencies();

        for (final DependencyFacade dependencyFacade : sourceDeps)
        {

            final DependencyFacade dep = dependencyFacade;

            if (dep.hasStereotype(GuiProfile.STEREOTYPE_VERSIONABLE_REF))
            {

                return true;

            }

        }

        return false;

    }

    @Override
    protected Collection<AssociationEndFacade> handleGetRulesSearchDatas()
    {

        final Collection<ManageableEntityAssociationEnd> associationEnds = this.getManageableAssociationEndsEntity();
        final Collection<AssociationEndFacade> rulesAssociations = new ArrayList<AssociationEndFacade>();

        for (final ManageableEntityAssociationEnd associationEnd : associationEnds)
        {

            if (this.logger_.isDebugEnabled())
            {

                this.logger_.debug("RulesSearchData : " + associationEnd.getName() + " - " + associationEnd.getType() + " for : " + this.getFullyQualifiedName());

            }

            if (associationEnd.getType().hasExactStereotype(GuiProfile.STEREOTYPE_RULES_SEARCH_DATA))
            {

                this.logger_.info("RulesSearchData found : " + associationEnd.getName() + " - " + associationEnd.getType() + " for : " + this.getFullyQualifiedName());

                rulesAssociations.add(associationEnd);

            }

        }

        return rulesAssociations;

    }

    @Override
    protected ClassifierFacade handleGetRulesCriteriasSearchValueObject()
    {

        final Collection rulesAssociations = this.getRulesSearchDatas();

        if (!rulesAssociations.isEmpty())
        {

            final AssociationEndFacade assoc = (AssociationEndFacade) ((ArrayList) rulesAssociations).get(0);
            final Collection<DependencyFacade> dependencies = assoc.getType().getSourceDependencies();

            for (final DependencyFacade dependencyFacade : dependencies)
            {

                final ClassifierFacade dep = (ClassifierFacade) dependencyFacade.getTargetElement();

                if (dep.hasExactStereotype(GuiProfile.STEREOTYPE_RULES_CRITERIAS_SEARCH_DATA))
                {

                    return dep;

                }

            }

        }

        return null;

    }

    @Override
    protected boolean handleIsInsertable()
    {

        final Object taggedValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_INSERTABLE);

        this.logger_.info("IsInsertable : The tag value is : " + taggedValue + " for tag : " + GuiProfile.TAGGEDVALUE_MANAGEABLE_INSERTABLE + " - " + this.getFullyQualifiedName());

        return (taggedValue == null) ? (GuiProfile.TAGGEDVALUE_MANAGEABLE_INSERT_DEFAULT && this.isEditable()) : (GuiUtils.isTrue(String.valueOf(taggedValue)) && this.isEditable());

    }

    @Override
    protected boolean handleIsUpdatable()
    {

        final Object taggedValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_UPDATABLE);

        this.logger_.info("IsUpdatable : The tag value is : " + taggedValue + " for tag : " + GuiProfile.TAGGEDVALUE_MANAGEABLE_UPDATABLE + " - " + this.getFullyQualifiedName());

        return (taggedValue == null) ? (GuiProfile.TAGGEDVALUE_MANAGEABLE_UPDATE_DEFAULT && this.isEditable()) : (GuiUtils.isTrue(String.valueOf(taggedValue)) && this.isEditable());

    }

    @Override
    protected boolean handleIsRemovable()
    {

        final Object taggedValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_REMOVABLE);

        this.logger_.info("IsRemovable : The tag value is : " + taggedValue + " for tag : " + GuiProfile.TAGGEDVALUE_MANAGEABLE_REMOVABLE + " - " + this.getFullyQualifiedName());

        return (taggedValue == null) ? (GuiProfile.TAGGEDVALUE_MANAGEABLE_DELETE_DEFAULT && this.isEditable()) : (GuiUtils.isTrue(String.valueOf(taggedValue)) && this.isEditable());

    }

    @Override
    protected boolean handleIsFiltered()
    {

        for (final AttributeFacade attributeFacade : this.getAttributes())
        {

            final AttributeFacade attribute = attributeFacade;
            final Object tag = attribute.findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_SIMPLE_FILTER_ELEMENT);

            if ((tag != null) && GuiUtils.isTrue(String.valueOf(tag)))
            {

                return true;

            }

        }

        for (final Object o : this.getManageableAssociationEnds())
        {

            if (o instanceof GuiManageableEntityAssociationEnd)
            { // AssociationEndFacade

                final Object tag = ((GuiManageableEntityAssociationEnd) o).findTaggedValue(GuiProfile.TAGGEDVALUE_VIEW_SIMPLE_FILTER_ELEMENT);

                if ((tag != null) && GuiUtils.isTrue(String.valueOf(tag)))
                {

                    return true;

                }

            } else
            {

                this.logger_.info("IsFiltered The association end " + ((AssociationEndFacade) o).getName() + " can not be handle");

            }

        }

        return false;

    }

    @Override
    protected boolean handleIsPopEdition()
    {

        final Object taggedValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_POPUP_EDITION);

        this.logger_.info("IsPopEdition : The tag value is : " + taggedValue + " for tag : " + GuiProfile.TAGGEDVALUE_MANAGEABLE_POPUP_EDITION + " - " + this.getFullyQualifiedName());

        return (taggedValue == null) ? (GuiProfile.TAGGEDVALUE_MANAGEABLE_POPUP_EDITION_DEFAULT && this.isEditable()) : (GuiUtils.isTrue(String.valueOf(taggedValue)) && this.isEditable());

    }

    @Override
    protected boolean handleIsExportable()
    {

        final Object taggedValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_EXPORTABLE);

        this.logger_.info("IsExportable : The tag value is : " + taggedValue + " for tag : " + GuiProfile.TAGGEDVALUE_MANAGEABLE_EXPORTABLE + " - " + this.getFullyQualifiedName());

        return (taggedValue == null) ? (GuiProfile.TAGGEDVALUE_MANAGEABLE_EXPORTABLE_DEFAULT && this.isEditable()) : (GuiUtils.isTrue(String.valueOf(taggedValue)) && this.isEditable());

    }

    @Override
    protected boolean handleIsClonable()
    {

        final Object taggedValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_CLONABLE);

        this.logger_.info("IsClonable : The tag value is : " + taggedValue + " for tag : " + GuiProfile.TAGGEDVALUE_MANAGEABLE_CLONABLE + " - " + this.getFullyQualifiedName());

        return (taggedValue == null) ? (GuiProfile.TAGGEDVALUE_MANAGEABLE_CLONABLE_DEFAULT && this.isEditable()) : (GuiUtils.isTrue(String.valueOf(taggedValue)) && this.isEditable());

    }

    @Override
    protected boolean handleIsSortable()
    {

        final Object taggedValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_SORTABLE);

        this.logger_.info("IsSortable : The tag value is : " + taggedValue + " for tag : " + GuiProfile.TAGGEDVALUE_MANAGEABLE_SORTABLE + " - " + this.getFullyQualifiedName());

        return (taggedValue == null) ? (GuiProfile.TAGGEDVALUE_MANAGEABLE_SORTABLE_DEFAULT && this.isEditable()) : (GuiUtils.isTrue(String.valueOf(taggedValue)) && this.isEditable());

    }

    @Override
    protected boolean handleIsHasHelp()
    {

        final Object taggedValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_HASHELP);

        this.logger_.info("IsHasHelp : The tag value is : " + taggedValue + " for tag : " + GuiProfile.TAGGEDVALUE_MANAGEABLE_HASHELP + " - " + this.getFullyQualifiedName());

        return (taggedValue == null) ? (GuiProfile.TAGGEDVALUE_MANAGEABLE_HASHELP_DEFAULT && this.isEditable()) : (GuiUtils.isTrue(String.valueOf(taggedValue)) && this.isEditable());

    }

    @Override
    protected boolean handleIsFilterable()
    {

        return this.hasStereotype(GuiProfile.STEREOTYPE_FILTERABLE);

    }

    @Override
    protected boolean handleIsHasCustom()
    {

        return this.getCustomEntityReferences().size() > 0;

    }

    @Override
    protected boolean handleIsIsCustom()
    {

        final Collection<DependencyFacade> deps = this.getTargetDependencies();

        for (final DependencyFacade dependencyFacade : deps)
        {

            final DependencyFacade dep = dependencyFacade;

            if (dep.hasStereotype(GuiProfile.STEREOTYPE_CUSTOM_RULE))
            {

                return true;

            }

        }

        return false;

    }

    @Override
    protected boolean handleIsEditable()
    {

        final Object taggedValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_EDITABLE);

        this.logger_.info("IsEditable : The tag value is : " + taggedValue + " for tag : " + GuiProfile.TAGGEDVALUE_MANAGEABLE_EDITABLE + " - " + this.getFullyQualifiedName());

        return (taggedValue == null) ? (GuiProfile.TAGGEDVALUE_MANAGEABLE_EDITABLE_DEFAULT && !this.isValidable()) : (GuiUtils.isTrue(String.valueOf(taggedValue)) && !this.isValidable());

    }

    @Override
    protected boolean handleIsHasMaximumListSize()
    {

        final Object maximumListSize = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_MAXIMUM_LIST_SIZE);

        return !((maximumListSize == null) || "".equals(String.valueOf(maximumListSize)));

    }

    @Override
    protected String handleGetSecurityName()
    {

        final Object tagValue = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_SECURITY_NAME);

        return (tagValue == null) ? this.getName() : String.valueOf(tagValue);

    }

    @Override
    protected boolean handleIsFilterLoadingShortcut()
    {

        final Object filterTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_FILTER_SHORTCUT);

        return (filterTag == null) ? GuiProfile.TAGGEDVALUE_MANAGEABLE_FILTER_SHORTCUT_DEFAULT : GuiUtils.isTrue(String.valueOf(filterTag));

    }

    @Override
    protected String handleGetEjbInterfaceName()
    {

        return String.valueOf(this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_EJB_INTERFACE));

    }

    @Override
    protected boolean handleIsHasCustomSorters()
    {

        final Object filterTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_CUSTOM_SORTERS);

        return (filterTag == null) ? GuiProfile.TAGGEDVALUE_MANAGEABLE_CUSTOM_SORTERS_DEFAULT : GuiUtils.isTrue(String.valueOf(filterTag));

    }

    @Override
    protected boolean handleIsReferencable()
    {

        return this.hasStereotype(GuiProfile.STEREOTYPE_REFERENCABLE);

    }

    @Override
    protected boolean handleIsRealTimeData()
    {

        return this.hasStereotype(GuiProfile.STEREOTYPE_REALTIME_DATA);

    }

    @Override
    protected boolean handleIsValidable()
    {

        return this.hasStereotype(GuiProfile.STEREOTYPE_VALIDABLE_OBJECT);

    }

    @Override
    protected boolean handleIsExternalOrganizationExists()
    {

        final String name = this.getName() + ".xml";

        final String manual_mapping_location = String.valueOf(this.getConfiguredProperty(GuiGlobals.MANUAL_MAPPING_LOCATION));
        final File dir = new File(manual_mapping_location);

        // File dir = new File("configuration/generation/manualMapping/");
        final org.andromda.cartridges.gui.util.FileNameFilter fileNameFilter = new org.andromda.cartridges.gui.util.FileNameFilter(name);
        final boolean b = fileNameFilter.isInFolder(name, dir);

        return b;

    }

    @Override
    protected Object handleGetManageableExternalOrganization()
    {

        if (!this.handleIsExternalOrganizationExists() || this.getName().equals(""))
        {

            return null;

        }

        try
        {

            final String manual_mapping_location = String.valueOf(this.getConfiguredProperty(GuiGlobals.MANUAL_MAPPING_LOCATION));
            final File file = new File(manual_mapping_location + GuiGlobals.FILE_SEPARATOR + this.getName() + ".xml");

            // File file = new File("configuration/generation/manualMapping/" + this.getName() + ".xml");
            final List<String> attributesAndAssociations = new ArrayList<String>();

            for (final Object o : this.getManageableAttributes())
            {

                if (o instanceof GuiManageableEntityAttribute)
                {

                    attributesAndAssociations.add(((GuiManageableEntityAttribute) o).getDisplayName());

                } else
                {

                    this.logger_.info("GetManageableExternalOrganization : The attribute " + ((AttributeFacade) o).getName() + " can not be handle");

                }

            }

            for (final Object o : this.getManageableAssociationEnds())
            {

                if (o instanceof GuiManageableEntityAssociationEnd)
                {

                    attributesAndAssociations.add(((GuiManageableEntityAssociationEnd) o).getDisplayName());

                } else
                {

                    this.logger_.info("GetManageableExternalOrganization : The association end " + ((AssociationEndFacade) o).getName() + " can not be handle");

                }

            }

            final org.andromda.cartridges.gui.util.parser.Parser parser = new org.andromda.cartridges.gui.util.parser.Parser(file.toURL(), attributesAndAssociations);
            ViewContent viewContent = new ViewContent();

            viewContent = parser.parse();

            final List<String> exceptions = parser.getInvalidAttributes();

            if (exceptions.size() > 0)
            {

                final StringBuilder attributes = new StringBuilder();

                for (final String name : exceptions)
                {

                    attributes.append(name + ", ");

                }

                this.logger_.error("The attributes " + attributes.substring(0, attributes.length() - 2) + " do not exist, please check the file configuration/generation/manualMapping/" + this.getName() + ".xml");

                // System.exit(1);
            }

            return viewContent;

        } catch (final MalformedURLException e)
        {

            e.printStackTrace();

        } catch (final DocumentException e)
        {

            e.printStackTrace();

        }

        return null;

    }

    @Override
    protected boolean handleIsShowDeal()
    {

        final Object filterTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_SHOW_DEAL);

        return (filterTag == null) ? false : GuiUtils.isTrue(String.valueOf(filterTag));

    }

    @Override
    protected boolean handleIsUseTemplating()
    {

        final Object filterTag = this.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_USE_TEMPLATING);

        return (filterTag == null) ? false : GuiUtils.isTrue(String.valueOf(filterTag));

    }

    @Override
    protected boolean handleIsRule()
    {

        return !this.getRulesSearchDatas().isEmpty();

    }

    @Override
    protected boolean handleIsInterceptable()
    {

        return this.hasStereotype(GuiProfile.STEREOTYPE_INTERCEPTABLE);

    }

    @Override
    protected boolean handleHasCustomUsecases()
    {

        final Collection<OperationFacade> members = this.getBusinessOperations();

        for (final OperationFacade operationFacade : members)
        {

            final OperationFacade member = operationFacade;

            if (member.hasStereotype(GuiProfile.STEREOTYPE_CUSTOM_USECASE))
            {

                return true;

            }

        }

        return false;

    }

    @Override
    protected java.util.Collection<OperationFacade> handleGetCustomUseCases()
    {

        final Set<OperationFacade> customUseCases = new LinkedHashSet<OperationFacade>();

        // If rendering a validation screen, no need to render business object
        // custom use cases
        if (this.isValidable())
        {

            return customUseCases;

        }

        final Collection<OperationFacade> members = this.getBusinessOperations();

        for (final OperationFacade operationFacade : members)
        {

            final OperationFacade member = operationFacade;

            if (member.hasStereotype(GuiProfile.STEREOTYPE_CUSTOM_USECASE))
            {

                customUseCases.add(member);

            }

        }

        return customUseCases;

    }

    @Override
    protected String handleGetIdentifierForBusinessObjectReference(final String businessObjectName)
    {

        final Collection<DependencyFacade> sourceDeps = this.getSourceDependencies();

        String attributeName = this.getManageableIdentifier().getName();

        // Retrieve referenced Business Object, and the discrimator attribute name
        for (final DependencyFacade dep : sourceDeps)
        {

            String targetElementName = dep.getTargetElement().getName();

            // if (this.logger_.isDebugEnabled()) {
            this.logger_.info("Business Object Name : " + businessObjectName + " with dependency : " + targetElementName + " - " + this.getFullyQualifiedName());

            // }
            if (dep.getTargetElement() instanceof GuiValidableEntity)
            {

                targetElementName = targetElementName.replaceAll(((GuiValidableEntity) dep.getTargetElement()).getValidationNameSuffix(), "");

            }

            if (dep.hasStereotype(GuiProfile.STEREOTYPE_BO_REF) && targetElementName.equals(businessObjectName))
            {

                final Object filterTag = dep.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_BOREF_DISCRIMINATOR);

                this.logger_.info("Tagged value : " + filterTag + " for : " + GuiProfile.TAGGEDVALUE_MANAGEABLE_BOREF_DISCRIMINATOR + " - " + this.getFullyQualifiedName());

                if (!"".equals(String.valueOf(filterTag)))
                {

                    attributeName = String.valueOf(filterTag);

                }

            }

        }

        // if (this.logger_.isDebugEnabled()) {
        this.logger_.info("Reference Attribute Name : " + attributeName + " for : " + GuiProfile.TAGGEDVALUE_MANAGEABLE_BOREF_DISCRIMINATOR + " - " + this.getFullyQualifiedName());

        // }

        // Find the corresponding attribute or association
        // for (final Iterator<ManageableEntityAttribute> it = this.getManageableAttributes().iterator(); it.hasNext();) {
        for (final Object o : this.getManageableAttributes())
        {

            if (o instanceof GuiManageableEntityAttribute)
            {

                // final AttributeFacade attribute = (AttributeFacade) it.next();
                final AttributeFacade attribute = ((GuiManageableEntityAttribute) o);

                // if (this.logger_.isDebugEnabled()) {
                this.logger_.info("Attribute Name : " + attribute.getName() + " for : " + businessObjectName + " - " + this.getFullyQualifiedName());

                // }
                if (attribute.getName().equals(attributeName))
                {

                    return attribute.getName();

                }

            } else
            {

                this.logger_.info("GetIdentifierForBusinessObjectReference : The attribute " + ((AttributeFacade) o).getName() + " can not be handle");

            }

        }

        for (final Object o : this.getManageableAssociationEnds())
        {

            if (o instanceof AssociationEndFacade)
            {

                // if (this.logger_.isDebugEnabled()) {
                this.logger_.info("Association Name : " + ((AssociationEndFacade) o).getName() + " for : " + businessObjectName + " - " + this.getFullyQualifiedName());

                // }
                if (((AssociationEndFacade) o).getName().equals(attributeName))
                {

                    return StringUtilsHelper.upperCamelCaseName(((AssociationEndFacade) o).getName());

                }

            }

        }

        this.logger_.error("No identifer : " + attributeName + " between : " + businessObjectName + " and " + this.getFullyQualifiedName());

        return null;

    }

    @Override
    protected boolean handleEachBusinessObjectReferenceIsValid()
    {

        final List<Entity> boRefs = this.getBusinessObjectReferences();

        for (final Entity entity : boRefs)
        {

            final ClassifierFacade classifier = entity;

            if (this.getIdentifierForBusinessObjectReference(classifier.getName()) == null)
            {

                this.logger_.error("Entity : " + classifier.getName() + " with no IdentifierForBusinessObjectReference found : " + this.getFullyQualifiedName());

                return false;

            }

            if (classifier.hasStereotype(UMLProfile.STEREOTYPE_ENTITY) && !this.hasValueObject((Entity) classifier))
            {

                this.logger_.error("Entity : " + classifier.getName() + " with no VO found : " + this.getFullyQualifiedName());

                return false;

            }

        }

        return true;

    }

    @Override
    protected String handleGetCustomUseCaseActionType(final String customUseCaseName)
    {

        final Collection<OperationFacade> members = this.getBusinessOperations();

        for (final OperationFacade operationFacade : members)
        {

            final OperationFacade member = operationFacade;

            if (member.hasStereotype(GuiProfile.STEREOTYPE_CUSTOM_USECASE))
            {

                if (customUseCaseName.compareTo(member.getName()) == 0)
                {

                    return String.valueOf(member.findTaggedValue(GuiProfile.TAGGEDVALUE_CUSTOMUSECASE_ACTION_TYPE));

                }

            }

        }

        return null;

    }

    @Override
    protected String handleGetCustomUseCaseDisplayType(final String customUseCaseName)
    {

        final Collection<OperationFacade> members = this.getBusinessOperations();

        for (final OperationFacade operationFacade : members)
        {

            final OperationFacade member = operationFacade;

            if (member.hasStereotype(GuiProfile.STEREOTYPE_CUSTOM_USECASE))
            {

                if (customUseCaseName.compareTo(member.getName()) == 0)
                {

                    return String.valueOf(member.findTaggedValue(GuiProfile.TAGGEDVALUE_CUSTOMUSECASE_DISPLAY_TYPE));

                }

            }

        }

        return null;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param serviceName DOCUMENT ME!
     * @return DOCUMENT ME!
     */
    @Override
    public boolean handleServiceNameExists(final String serviceName)
    {

        final Service service = this.getManageableService(serviceName);

        if (service == null)
        {

            this.logger_.error("ServiceNameExists TaggedValue : " + serviceName + " for : " + GuiProfile.TAGGEDVALUE_MANAGEABLE_SERVICE + " - " + this.getFullyQualifiedName() + "does not exist");

        }

        return service != null;

    }

    @Override
    protected Collection<OperationFacade> handleGetExternalUseCases()
    {

        final Set<OperationFacade> externalUseCases = new LinkedHashSet<OperationFacade>();

        final Collection<OperationFacade> members = this.getBusinessOperations();

        for (final OperationFacade operationFacade : members)
        {

            final OperationFacade member = operationFacade;

            if (member.hasStereotype(GuiProfile.STEREOTYPE_EXTERNAL_USECASE))
            {

                externalUseCases.add(member);

            }

        }

        return externalUseCases;

    }

    /*
     * @Override
     * protected AttributeFacade handleGetIdentifierToDelete()
     * {
     * // return super.getManageableIdentifier();
     * final AttributeFacade attr = super.getManageableIdentifier();
     * if (attr == null)
     * {
     * final Collection<GeneralizableElementFacade> parentEntities = this.getAllGeneralizations();
     * for (final Iterator<GeneralizableElementFacade> parentEntityIterator = parentEntities.iterator(); parentEntityIterator.hasNext();)
     * {
     * final Object parentEntityObject = parentEntityIterator.next();
     * if ((parentEntityObject instanceof Entity) && !((Entity) parentEntityObject).getIdentifiers().isEmpty())
     * {
     * final Object identifier = ((Entity) parentEntityObject).getIdentifiers().iterator().next();
     * return ((EntityAttribute) identifier);
     * }
     * }
     * }
     * return attr;
     * }
     */

    // TODO remove
    @Override
    protected ManageableEntity handleGetManageableGeneralizationToDelete()
    {

        for (GeneralizableElementFacade element = this.getGeneralization(); element != null; element = element.getGeneralization())
        {

            if (element instanceof ManageableEntity)
            {

                return (ManageableEntity) element;

            }

        }

        return null;

    }

    @Override
    protected boolean handleIsAttributeOrAssociation(final String name)
    {

        // Find the corresponding attribute or association
        // for (final Iterator<ManageableEntityAttribute> it = this.getManageableAttributes().iterator(); it.hasNext();) {
        for (final Object o : this.getManageableAttributes())
        {

            if (o instanceof GuiManageableEntityAttribute)
            {

                // final AttributeFacade attribute = (AttributeFacade) it.next();
                final AttributeFacade attribute = ((AttributeFacade) o);

                if (attribute.getName().equals(name))
                {

                    return true;

                }

            } else
            {

                this.logger_.info("IsAttributeOrAssociation : The attribute " + ((AttributeFacade) o).getName() + " can not be handle");

            }

        }

        for (final Object o : this.getManageableAssociationEnds())
        {

            if (o instanceof AssociationEndFacade)
            { // AssociationEndFacade

                if (((AssociationEndFacade) o).getName().equals(name))
                {

                    return true;

                }

            } else
            {

                this.logger_.info("IsAttributeOrAssociation : The association end " + ((AssociationEndFacade) o).getName() + " can not be handle");

            }

        }

        return false;

    }

    @Override
    protected String handleGetAttributeNameByDisplayName(final String displayName)
    {

        // for (final Iterator<ManageableEntityAttribute> it = this.getManageableAttributes().iterator(); it.hasNext();) {
        for (final Object o : this.getManageableAttributes())
        {

            // final Object o = it.next();
            if (o instanceof GuiManageableEntityAttribute)
            {

                final GuiManageableEntityAttribute attribute = (GuiManageableEntityAttribute) o;

                if (attribute.getDisplayName().equals(displayName))
                {

                    return attribute.getName();

                }

            } else
            {

                this.logger_.info("GetAttributeNameByDisplayName : The attribute " + ((AttributeFacade) o).getName() + " can not be handle");

            }

        }

        for (final Iterator<ManageableEntityAssociationEnd> it = this.getManageableAssociationEnds().iterator(); it.hasNext();)
        {

            final Object o = it.next();

            if (o instanceof GuiManageableEntityAssociationEnd)
            {

                final GuiManageableEntityAssociationEnd assoc = (GuiManageableEntityAssociationEnd) o;

                if (assoc.getDisplayName().equals(displayName))
                {

                    return assoc.getName();

                }

            } else
            {

                this.logger_.info("GetAttributeNameByDisplayName : The association end " + ((AssociationEndFacade) o).getName() + " can not be handle");

            }

        }

        return displayName;

    }

    @Override
    protected String handleGetAttributeTypeByDisplayName(final String displayName)
    {

        // for (final Iterator<ManageableEntityAttribute> it = this.getManageableAttributes().iterator(); it.hasNext();) {
        for (final Object o : this.getManageableAttributes())
        {

            // final Object o = it.next();
            if (o instanceof GuiManageableEntityAttribute)
            {

                final GuiManageableEntityAttribute attribute = (GuiManageableEntityAttribute) o;

                if (attribute.getDisplayName().equals(displayName))
                {

                    return ((attribute.getFieldSize() >= 32) && !attribute.getWidgetType().equals(GuiGlobals.INPUT_SELECT) && attribute.getJdbcType().equals("VARCHAR")) ? "long" : "";

                }

            } else
            {

                this.logger_.info("GetAttributeTypeByDisplayName : The attribute " + ((AttributeFacade) o).getName() + " can not be handle");

            }

        }

        return "";

    }

    @Override
    protected boolean handleHasCorrectShowDealInfo()
    {

        return !this.isShowDeal() || ((this.getShowDealDealId() != null) && (this.getShowDealDealType() != null));

    }

    @Override
    protected AttributeFacade handleGetShowDealDealId()
    {

        // for (final Iterator<ManageableEntityAttribute> it = this.getManageableAttributes().iterator(); it.hasNext();) {
        for (final Object o : this.getManageableAttributes())
        {

            // final Object o = it.next();
            if (o instanceof GuiManageableEntityAttribute)
            {

                final GuiManageableEntityAttribute attribute = (GuiManageableEntityAttribute) o;

                if (attribute.isDealId())
                {

                    return attribute;

                }

            } else
            {

                this.logger_.info("GetShowDealDealId : The attribute " + ((AttributeFacade) o).getName() + " can not be handle");

            }

        }

        return null;

    }

    @Override
    protected AttributeFacade handleGetShowDealDealType()
    {

        // for (final Iterator<ManageableEntityAttribute> it = this.getManageableAttributes().iterator(); it.hasNext();) {
        for (final Object o : this.getManageableAttributes())
        {

            // final Object o = it.next();
            if (o instanceof GuiManageableEntityAttribute)
            {

                final GuiManageableEntityAttribute attribute = (GuiManageableEntityAttribute) o;

                if (attribute.isDealType())
                {

                    return attribute;

                }

            } else
            {

                this.logger_.info("GetShowDealDealType : The attribute " + ((AttributeFacade) o).getName() + " can not be handle");

            }

        }

        return null;

    }

    @Override
    protected AttributeFacade handleGetCorrespondingVOAttr(final GuiManageableEntityAttribute manageableAttribute)
    {

        this.logger_.info("GetCorrespondingVOAttr : Looking VO attribute for : " + manageableAttribute.getName() + " - " + this.getFullyQualifiedName());

        final ValueObject vo = this.getValueObject();

        if (vo != null)
        {

            final Collection<AttributeFacade> voAttributes = vo.getAttributes();

            // voAttributes.addAll(((ValueObject) vo.getGeneralization()).getAllRequiredConstructorParameters());
            if (voAttributes != null)
            {

                try
                {

                    for (final Iterator<ModelElementFacade> it = ((ValueObject) vo.getGeneralization()).getAllRequiredConstructorParameters().iterator(); it.hasNext();)
                    {

                        final Object o = it.next();

                        if (o instanceof AttributeFacade)
                        {

                            final AttributeFacade attribute = (AttributeFacade) o;

                            voAttributes.add(attribute);

                        } else
                        {

                            this.logger_.info("GetCorrespondingVOAttr : The attribute " + ((ModelElementFacade) o).getName() + " can not be handle");

                        }

                    }

                    // final Collection<ModelElementFacade> voRequiredConstructorParameters = ((ValueObject) vo.getGeneralization()).getAllRequiredConstructorParameters();
                    //
                    // if (voRequiredConstructorParameters != null) {
                    //
                    // voAttributes.addAll(voRequiredConstructorParameters);
                    //
                    // }
                } catch (final Exception e)
                {

                    this.logger_.info("Exception is : " + e + " and the Manageable attribute is : " + manageableAttribute.getName() + " Generalization is : " + vo.getGeneralizationList());

                }

                for (final AttributeFacade voAttr : voAttributes)
                {

                    if (this.logger_.isDebugEnabled())
                    {

                        this.logger_.debug("The ValueObject attribute is : " + voAttr.getName() + " and the Manageable attribute is : " + manageableAttribute.getName());

                    }

                    if (voAttr.getName().equalsIgnoreCase(manageableAttribute.getName()))
                    {

                        return voAttr;

                    }

                }

            }

        }

        this.logger_.info("The ValueObject is null and the Manageable attribute is : " + manageableAttribute.getName());

        return null;

    }

    @Override
    protected AttributeFacade handleGetCorrespondingRuleVOAttr(final GuiManageableEntityAssociationEnd manageableAssocEnd)
    {

        final ValueObject vo = this.getValueObject();

        if (vo != null)
        {

            final Collection<AttributeFacade> voAttributes = vo.getAttributes();

            // voAttributes.addAll(((ValueObject) vo.getGeneralization()).getAllRequiredConstructorParameters());
            for (final Iterator<ModelElementFacade> it = ((ValueObject) vo.getGeneralization()).getAllRequiredConstructorParameters().iterator(); it.hasNext();)
            {

                final Object o = it.next();

                if (o instanceof AttributeFacade)
                {

                    final AttributeFacade attribute = (AttributeFacade) o;

                    voAttributes.add(attribute);

                } else
                {

                    this.logger_.info("GetCorrespondingVOAttr : The attribute " + ((ModelElementFacade) o).getName() + " can not be handle");

                }

            }

            final String dictDetailAssocName = manageableAssocEnd.getName().replaceAll("DictDetail_Id_", "");

            for (final AttributeFacade voAttr : voAttributes)
            {

                final String voAttrName = voAttr.getName().toLowerCase();

                if ((voAttrName.indexOf("dictdetail") >= 0) && voAttrName.replaceAll("dictdetail", "").equals(dictDetailAssocName.toLowerCase()))
                {

                    this.logger_.info("GetCorrespondingRuleVOAttr : Looking VO attribute for : " + voAttrName + " - " + this.getFullyQualifiedName());

                    return voAttr;

                }

            }

        }

        return null;

    }

    @Override
    protected Object handleGetVersionableEntityReference()
    {

        final Collection<DependencyFacade> deps = this.getTargetDependencies();

        for (final DependencyFacade dependencyFacade : deps)
        {

            final DependencyFacade dep = dependencyFacade;

            if (dep.hasStereotype(GuiProfile.STEREOTYPE_VERSIONABLE_REF))
            {

                return dep.getSourceElement();

            }

        }

        final Collection<DependencyFacade> sourceDeps = this.getSourceDependencies();

        for (final DependencyFacade dependencyFacade : sourceDeps)
        {

            final DependencyFacade dep = dependencyFacade;

            if (dep.hasStereotype(GuiProfile.STEREOTYPE_VERSIONABLE_REF))
            {

                return dep.getTargetElement();

            }

        }

        return null;

    }

    @Override
    protected Object handleGetCustomOwner()
    {

        final Collection<DependencyFacade> deps = this.getTargetDependencies();

        for (final DependencyFacade dependencyFacade : deps)
        {

            final DependencyFacade dep = dependencyFacade;

            if (dep.hasStereotype(GuiProfile.STEREOTYPE_CUSTOM_RULE))
            {

                return dep.getSourceElement();

            }

        }

        return null;

    }

    @Override
    protected List<ModelElementFacade> handleGetCustomEntityReferences()
    {

        final Collection<DependencyFacade> sourceDeps = this.getSourceDependencies();
        final List<ModelElementFacade> customReferences = new ArrayList<ModelElementFacade>();

        for (final DependencyFacade dep : sourceDeps)
        {

            if (dep.hasStereotype(GuiProfile.STEREOTYPE_CUSTOM_RULE))
            {

                customReferences.add(dep.getTargetElement());

            }

        }

        return customReferences;

    }

    @Override
    protected List<ModelElementFacade> handleGetBusinessObjectReferences()
    {

        final Collection<DependencyFacade> sourceDeps = this.getSourceDependencies();

        final List<ModelElementFacade> boRef = new ArrayList<ModelElementFacade>();

        for (final DependencyFacade dep : sourceDeps)
        {

            if (dep.hasStereotype(GuiProfile.STEREOTYPE_BO_REF))
            {

                boRef.add(dep.getTargetElement());

            }

        }

        return boRef;

    }

    /**
     * Retrieves manageable service facade for a given service name. This method
     * will search in directly attached services, and also in generalizations and
     * specializations.
     * 
     * @param serviceName
     * the service name
     * @return Service facade instance
     */
    private Service getManageableService(final String serviceName)
    {

        Service toFind = null;
        final Collection<DependencyFacade> dependencies = this.getTargetDependencies();

        for (final DependencyFacade dependencyFacade : dependencies)
        {

            final DependencyFacade dep = dependencyFacade;

            if (dep.getSourceElement().hasStereotype(UMLProfile.STEREOTYPE_SERVICE))
            {

                final Service service = (Service) dep.getSourceElement();

                if (service.getName().equals(serviceName))
                {

                    toFind = service;

                } else
                {

                    // Trying with other services
                    final Collection<GeneralizableElementFacade> otherServices = service.getAllGeneralizations();

                    otherServices.addAll(service.getAllSpecializations());

                    for (final GeneralizableElementFacade generalizableElementFacade : otherServices)
                    {

                        final Service otherService = (Service) generalizableElementFacade;

                        if (otherService.getName().equals(serviceName))
                        {

                            toFind = service;

                        }

                    }

                }

            }

        }

        return toFind;

    }

    private ValueObject getValueObject()
    {

        final Collection<DependencyFacade> deps = this.getSourceDependencies();
        ValueObject vo = null;

        for (final DependencyFacade dep : deps)
        {

            if (dep.getTargetElement().hasStereotype(UMLProfile.STEREOTYPE_VALUE_OBJECT))
            {

                vo = (ValueObject) dep.getTargetElement();

            }

        }

        return vo;

    }

    protected boolean hasValueObject(final Entity entity)
    {

        final Collection<DependencyFacade> deps = entity.getSourceDependencies();

        for (final DependencyFacade dependencyFacade : deps)
        {

            final DependencyFacade dep = dependencyFacade;

            // if (this.logger_.isDebugEnabled()) {
            this.logger_.info("Entity : " + entity.getFullyQualifiedName() + " with dependency VO : " + dep.getTargetElement().getName() + " - " + this.getFullyQualifiedName());

            // }
            if (dep.getTargetElement().hasStereotype(UMLProfile.STEREOTYPE_VALUE_OBJECT))
            {

                return true;

            }

        }

        return false;

    }

}

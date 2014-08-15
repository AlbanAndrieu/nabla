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
package org.andromda.cartridges.gui;

import org.andromda.core.profile.Profile;

/**
 * Contains the AndroMDA Gui profile.
 * 
 * @author Chad Brandon
 */
public class GuiProfile
{

    /**
     * The Profile instance from which we retrieve the mapped profile names.
     */
    private static final Profile PROFILE                                             = Profile.instance();

    /* ----------------- Stereotypes -------------------- */
    /** FRONT_END_REGISTRATION */
    public static final String   STEREOTYPE_FRONT_END_REGISTRATION                   = GuiProfile.PROFILE.get("FRONT_END_REGISTRATION");

    /** FRONT_END_NAVIGATION */
    public static final String   STEREOTYPE_FRONT_END_NAVIGATION                     = GuiProfile.PROFILE.get("FRONT_END_NAVIGATION");

    /** BUSINESS_OBJECT */
    public static final String   STEREOTYPE_BUSINESS_OBJECT                          = GuiProfile.PROFILE.get("BUSINESS_OBJECT");

    /** BUSINESS_OBJECT_REF */
    public static final String   STEREOTYPE_BO_REF                                   = GuiProfile.PROFILE.get("BUSINESS_OBJECT_REF");

    /** VERSIONABLE */
    public static final String   STEREOTYPE_VERSIONABLE                              = GuiProfile.PROFILE.get("VERSIONABLE");

    /** VERSIONABLE_REF */
    public static final String   STEREOTYPE_VERSIONABLE_REF                          = GuiProfile.PROFILE.get("VERSIONABLE_REF");

    /** INTERCEPTABLE */
    public static final String   STEREOTYPE_INTERCEPTABLE                            = GuiProfile.PROFILE.get("INTERCEPTABLE");

    /** INTERCEPTABLE_REF */
    public static final String   STEREOTYPE_INTERCEPTABLE_REF                        = GuiProfile.PROFILE.get("INTERCEPTABLE_REF");

    /** VALIDABLE_OBJECT */
    public static final String   STEREOTYPE_VALIDABLE_OBJECT                         = GuiProfile.PROFILE.get("VALIDABLE_OBJECT");

    /** VALIDABLE_OBJECT_REF */
    public static final String   STEREOTYPE_VO_REF                                   = GuiProfile.PROFILE.get("VALIDABLE_OBJECT_REF");

    /** RULES_SEARCH_DATA */
    public static final String   STEREOTYPE_RULES_SEARCH_DATA                        = GuiProfile.PROFILE.get("RULES_SEARCH_DATA");

    /** RULES_CRITERIAS_SEARCH_DATA */
    // TODO REMOVE
    public static final String   STEREOTYPE_RULES_CRITERIAS_SEARCH_DATA              = GuiProfile.PROFILE.get("RULES_CRITERIAS_SEARCH_DATA");

    /** CUSTOM_RULE */
    public static final String   STEREOTYPE_CUSTOM_RULE                              = GuiProfile.PROFILE.get("CUSTOM_RULE");

    /** CUSTOM_USECASE */
    public static final String   STEREOTYPE_CUSTOM_USECASE                           = GuiProfile.PROFILE.get("CUSTOM_USECASE");

    /** EXTERNAL_USECASE */
    public static final String   STEREOTYPE_EXTERNAL_USECASE                         = GuiProfile.PROFILE.get("EXTERNAL_USECASE");

    /** FILTERABLE */
    public static final String   STEREOTYPE_FILTERABLE                               = GuiProfile.PROFILE.get("FILTERABLE");

    /** REFERENCABLE */
    public static final String   STEREOTYPE_REFERENCABLE                             = GuiProfile.PROFILE.get("REFERENCABLE");

    /** ASYNCH_VIEW */
    // TODO DELETE
    public static final String   STEREOTYPE_ASYNCHRONOUS                             = GuiProfile.PROFILE.get("ASYNCH_VIEW");

    /** REALTIME_DATA */
    public static final String   STEREOTYPE_REALTIME_DATA                            = GuiProfile.PROFILE.get("REALTIME_DATA");

    /** COHERENCY_REF */
    public static final String   STEREOTYPE_COHERENCY_REF                            = GuiProfile.PROFILE.get("COHERENCY_REF");

    /* ----------------- Tagged Values -------------------- */
    /** ACTION_FORM_SCOPE */
    public static final String   TAGGEDVALUE_ACTION_FORM_SCOPE                       = GuiProfile.PROFILE.get("ACTION_FORM_SCOPE");

    /** ACTION_FORM_KEY */
    public static final String   TAGGEDVALUE_ACTION_FORM_KEY                         = GuiProfile.PROFILE.get("ACTION_FORM_KEY");

    /** ACTION_TABLELINK */
    public static final String   TAGGEDVALUE_ACTION_TABLELINK                        = GuiProfile.PROFILE.get("ACTION_TABLELINK");

    /** ACTION_TYPE */
    public static final String   TAGGEDVALUE_ACTION_TYPE                             = GuiProfile.PROFILE.get("ACTION_TYPE");

    /** ACTION_RESETTABLE */
    public static final String   TAGGEDVALUE_ACTION_RESETTABLE                       = GuiProfile.PROFILE.get("ACTION_RESETTABLE");

    /** ACTION_FORM_RESET */
    public static final String   TAGGEDVALUE_ACTION_FORM_RESET                       = GuiProfile.PROFILE.get("ACTION_FORM_RESET");

    /** ACTION_SUCCESS_MESSAGE */
    public static final String   TAGGEDVALUE_ACTION_SUCCESS_MESSAGE                  = GuiProfile.PROFILE.get("ACTION_SUCCESS_MESSAGE");

    /** ACTION_WARNING_MESSAGE */
    public static final String   TAGGEDVALUE_ACTION_WARNING_MESSAGE                  = GuiProfile.PROFILE.get("ACTION_WARNING_MESSAGE");

    /** ACTION_ERROR_MESSAGE */
    public static final String   TAGGEDVALUE_ACTION_ERROR_MESSAGE                    = GuiProfile.PROFILE.get("ACTION_ERROR_MESSAGE");

    /** ACTION_REDIRECT */
    public static final String   TAGGEDVALUE_ACTION_REDIRECT                         = GuiProfile.PROFILE.get("ACTION_REDIRECT");

    /** EXCEPTION_TYPE */
    public static final String   TAGGEDVALUE_EXCEPTION_TYPE                          = GuiProfile.PROFILE.get("EXCEPTION_TYPE");

    /** INPUT_TYPE */
    public static final String   TAGGEDVALUE_INPUT_TYPE                              = GuiProfile.PROFILE.get("INPUT_TYPE");

    /** INPUT_TABLELINK */
    public static final String   TAGGEDVALUE_INPUT_TABLELINK                         = GuiProfile.PROFILE.get("INPUT_TABLELINK");

    /** INPUT_REQUIRED */
    public static final String   TAGGEDVALUE_INPUT_REQUIRED                          = GuiProfile.PROFILE.get("INPUT_REQUIRED");

    /** INPUT_READONLY */
    public static final String   TAGGEDVALUE_INPUT_READONLY                          = GuiProfile.PROFILE.get("INPUT_READONLY");

    /** INPUT_VALIDWHEN */
    public static final String   TAGGEDVALUE_INPUT_VALIDWHEN                         = GuiProfile.PROFILE.get("INPUT_VALIDWHEN");

    /** INPUT_EQUAL */
    public static final String   TAGGEDVALUE_INPUT_EQUAL                             = GuiProfile.PROFILE.get("INPUT_EQUAL");

    /** INPUT_TABLE_IDENTIFIER_COLUMNS */
    public static final String   TAGGEDVALUE_INPUT_TABLE_IDENTIFIER_COLUMNS          = GuiProfile.PROFILE.get("INPUT_TABLE_IDENTIFIER_COLUMNS");

    /** INPUT_VALIDATORS */
    public static final String   TAGGEDVALUE_INPUT_VALIDATORS                        = GuiProfile.PROFILE.get("INPUT_VALIDATORS");

    /** INPUT_FORMAT */
    public static final String   TAGGEDVALUE_INPUT_FORMAT                            = GuiProfile.PROFILE.get("INPUT_FORMAT");

    /** INPUT_RESET */
    public static final String   TAGGEDVALUE_INPUT_RESET                             = GuiProfile.PROFILE.get("INPUT_RESET");

    /** INPUT_MULTIBOX */
    public static final String   TAGGEDVALUE_INPUT_MULTIBOX                          = GuiProfile.PROFILE.get("INPUT_MULTIBOX");

    /** INPUT_RADIO */
    public static final String   TAGGEDVALUE_INPUT_RADIO                             = GuiProfile.PROFILE.get("INPUT_RADIO");

    /** INPUT_CALENDAR */
    public static final String   TAGGEDVALUE_INPUT_CALENDAR                          = GuiProfile.PROFILE.get("INPUT_CALENDAR");

    /** INPUT_SIZE */
    public static final String   TAGGEDVALUE_INPUT_SIZE                              = GuiProfile.PROFILE.get("INPUT_SIZE");

    /** INPUT_COLUMN_COUNT */
    public static final String   TAGGEDVALUE_INPUT_COLUMN_COUNT                      = GuiProfile.PROFILE.get("INPUT_COLUMN_COUNT");

    /** INPUT_ROW_COUNT */
    public static final String   TAGGEDVALUE_INPUT_ROW_COUNT                         = GuiProfile.PROFILE.get("INPUT_ROW_COUNT");

    /** INPUT_READONLY_UPDATE */
    public static final String   TAGGEDVALUE_INPUT_READONLY_UPDATE                   = GuiProfile.PROFILE.get("INPUT_READONLY_UPDATE");

    /** TABLE_PAGEABLE */
    public static final String   TAGGEDVALUE_TABLE_PAGEABLE                          = GuiProfile.PROFILE.get("TABLE_PAGEABLE");

    /** TABLE_COLUMNS */
    public static final String   TAGGEDVALUE_TABLE_COLUMNS                           = GuiProfile.PROFILE.get("TABLE_COLUMNS");

    /** TABLE_MAXROWS */
    public static final String   TAGGEDVALUE_TABLE_MAXROWS                           = GuiProfile.PROFILE.get("TABLE_MAXROWS");

    /** TABLE_EXPORT */
    public static final String   TAGGEDVALUE_TABLE_EXPORT                            = GuiProfile.PROFILE.get("TABLE_EXPORT");

    /** TABLE_SORTABLE */
    public static final String   TAGGEDVALUE_TABLE_SORTABLE                          = GuiProfile.PROFILE.get("TABLE_SORTABLE");

    /**
     * DOCUMENT ME!
     */
    public static final String   TAGGEDVALUE_TABLE_MULTISELECTION                    = GuiProfile.PROFILE.get("TABLE_MULTISELECTION");

    /**
     * DOCUMENT ME!
     */
    public static final String   TAGGEDVALUE_TABLE_DECORATOR                         = GuiProfile.PROFILE.get("TABLE_DECORATOR");

    /** VIEW_TYPE */
    public static final String   TAGGEDVALUE_VIEW_TYPE                               = GuiProfile.PROFILE.get("VIEW_TYPE");

    /** LAYOUT_TYPE */
    public static final String   TAGGEDVALUE_VIEW_LAYOUT_TYPE                        = GuiProfile.PROFILE.get("LAYOUT_TYPE");

    /** CONTAINER_TYPE */
    public static final String   TAGGEDVALUE_VIEW_CONTAINER_TYPE                     = GuiProfile.PROFILE.get("CONTAINER_TYPE");

    /** CONTAINER_HEIGHT */
    public static final String   TAGGEDVALUE_VIEW_CONTAINER_HEIGHT                   = GuiProfile.PROFILE.get("CONTAINER_HEIGHT");

    /** CONTAINER_WIDTH */
    public static final String   TAGGEDVALUE_VIEW_CONTAINER_WIDTH                    = GuiProfile.PROFILE.get("CONTAINER_WIDTH");

    /** ACTIONGROUP */
    public static final String   TAGGEDVALUE_VIEW_ACTIONGROUP                        = GuiProfile.PROFILE.get("ACTIONGROUP");

    /** ACTIONGROUP_NAME */
    public static final String   TAGGEDVALUE_VIEW_ACTIONGROUP_NAME                   = GuiProfile.PROFILE.get("ACTIONGROUP_NAME");

    /** TOOLBAR */
    public static final String   TAGGEDVALUE_VIEW_TOOLBAR                            = GuiProfile.PROFILE.get("TOOLBAR");

    /** MAIN_TOOLBAR */
    public static final String   TAGGEDVALUE_VIEW_MAIN_TOOLBAR                       = GuiProfile.PROFILE.get("MAIN_TOOLBAR");

    /** MANDATORY_ELEMENT */
    public static final String   TAGGEDVALUE_VIEW_MANDATORY_ELEMENT                  = GuiProfile.PROFILE.get("MANDATORY_ELEMENT");

    /** SIMPLE_FILTER_ELEMENT */
    public static final String   TAGGEDVALUE_VIEW_SIMPLE_FILTER_ELEMENT              = GuiProfile.PROFILE.get("SIMPLE_FILTER_ELEMENT");

    /** DISPLAY_NAME */
    public static final String   TAGGEDVALUE_VIEW_DISPLAY_NAME                       = GuiProfile.PROFILE.get("DISPLAY_NAME");

    /** FUNCTIONAL_COHERENCY */
    public static final String   TAGGEDVALUE_VIEW_FUNCTIONAL_COHERENCY               = GuiProfile.PROFILE.get("FUNCTIONAL_COHERENCY");

    /** DICTIONARY_RETURN_TYPE */
    public static final String   TAGGEDVALUE_VIEW_DICTIONARY_RETURN_TYPE             = GuiProfile.PROFILE.get("DICTIONARY_RETURN_TYPE");

    /** REGROUP_MANDATORY */
    public static final String   TAGGEDVALUE_VIEW_REGROUP_REQUIRED                   = GuiProfile.PROFILE.get("REGROUP_REQUIRED");

    /** MANAGEABLE_DISPLAY_NAME */
    public static final String   TAGGEDVALUE_MANAGEABLE_EJB_INTERFACE                = GuiProfile.PROFILE.get("MANAGEABLE_EJB_INTERFACE");

    /** MANAGEABLE_DISPLAY_NAME */
    public static final String   TAGGEDVALUE_MANAGEABLE_DISPLAY_NAME                 = GuiProfile.PROFILE.get("MANAGEABLE_DISPLAY_NAME");

    /** MANAGEABLE_REF_SIMPLE_DISPLAY */
    public static final String   TAGGEDVALUE_MANAGEABLE_REF_SIMPLE_DISPLAY           = GuiProfile.PROFILE.get("MANAGEABLE_REF_SIMPLE_DISPLAY");

    /** MANAGEABLE_BOREF_DISCRIMINATOR */
    public static final String   TAGGEDVALUE_MANAGEABLE_BOREF_DISCRIMINATOR          = GuiProfile.PROFILE.get("MANAGEABLE_BOREF_DISCRIMINATOR");

    /** MANAGEABLE_VOREF_DISCRIMINATOR */
    public static final String   TAGGEDVALUE_MANAGEABLE_VOREF_DISCRIMINATOR          = GuiProfile.PROFILE.get("MANAGEABLE_VOREF_DISCRIMINATOR");

    /** MANAGEABLE_EDITABLE */
    public static final String   TAGGEDVALUE_MANAGEABLE_EDITABLE                     = GuiProfile.PROFILE.get("MANAGEABLE_EDITABLE");

    /** MANAGEABLE_INSERTABLE */
    public static final String   TAGGEDVALUE_MANAGEABLE_INSERTABLE                   = GuiProfile.PROFILE.get("MANAGEABLE_INSERTABLE");

    /** MANAGEABLE_UPDATABLE */
    public static final String   TAGGEDVALUE_MANAGEABLE_UPDATABLE                    = GuiProfile.PROFILE.get("MANAGEABLE_UPDATABLE");

    /** MANAGEABLE_REMOVABLE */
    public static final String   TAGGEDVALUE_MANAGEABLE_REMOVABLE                    = GuiProfile.PROFILE.get("MANAGEABLE_REMOVABLE");

    /** MANAGEABLE_MAXIMUM_LIST_SIZE */
    public static final String   TAGGEDVALUE_MANAGEABLE_MAXIMUM_LIST_SIZE            = GuiProfile.PROFILE.get("MANAGEABLE_MAXIMUM_LIST_SIZE");

    /** MANAGEABLE_ASSOCIATION_RELEVANT */
    public static final String   TAGGEDVALUE_MANAGEABLE_ASSOCIATION_RELEVANT         = GuiProfile.PROFILE.get("MANAGEABLE_ASSOCIATION_RELEVANT");

    /** MANAGEABLE_POPUP_EDITION */
    public static final String   TAGGEDVALUE_MANAGEABLE_POPUP_EDITION                = GuiProfile.PROFILE.get("MANAGEABLE_POPUP_EDITION");

    /** MANAGEABLE_EXPORTABLE */
    public static final String   TAGGEDVALUE_MANAGEABLE_EXPORTABLE                   = GuiProfile.PROFILE.get("MANAGEABLE_EXPORTABLE");

    /** MANAGEABLE_CLONABLE */
    public static final String   TAGGEDVALUE_MANAGEABLE_CLONABLE                     = GuiProfile.PROFILE.get("MANAGEABLE_CLONABLE");

    /** MANAGEABLE_SORTABLE */
    public static final String   TAGGEDVALUE_MANAGEABLE_SORTABLE                     = GuiProfile.PROFILE.get("MANAGEABLE_SORTABLE");

    /** MANAGEABLE_HASHELP */
    public static final String   TAGGEDVALUE_MANAGEABLE_HASHELP                      = GuiProfile.PROFILE.get("MANAGEABLE_HASHELP");

    /** MANAGEABLE_CUSTOM_SORTERS */
    public static final String   TAGGEDVALUE_MANAGEABLE_CUSTOM_SORTERS               = GuiProfile.PROFILE.get("MANAGEABLE_CUSTOM_SORTERS");

    /** FILTER_SHORTCUT */
    public static final String   TAGGEDVALUE_MANAGEABLE_FILTER_SHORTCUT              = GuiProfile.PROFILE.get("MANAGEABLE_FILTER_SHORTCUT");

    /** MANAGEABLE_USE_TEMPLATING */
    public static final String   TAGGEDVALUE_MANAGEABLE_USE_TEMPLATING               = GuiProfile.PROFILE.get("MANAGEABLE_USE_TEMPLATING");

    /** MANAGEABLE_SERVICE */
    public static final String   TAGGEDVALUE_MANAGEABLE_SERVICE                      = GuiProfile.PROFILE.get("MANAGEABLE_SERVICE");

    /** MANAGEABLE_SECURITY_NAME */
    // TODO REMOVE
    public static final String   TAGGEDVALUE_MANAGEABLE_SECURITY_NAME                = GuiProfile.PROFILE.get("MANAGEABLE_SECURITY_NAME");

    /** SHOW_DEAL */
    // TODO REMOVE
    public static final String   TAGGEDVALUE_MANAGEABLE_SHOW_DEAL                    = GuiProfile.PROFILE.get("MANAGEABLE_SHOW_DEAL");

    /** SHOW_DEAL_DEAL_TYPE */
    // TODO REMOVE
    public static final String   TAGGEDVALUE_MANAGEABLE_SHOW_DEAL_DEAL_TYPE          = GuiProfile.PROFILE.get("MANAGEABLE_SHOW_DEAL_DEAL_TYPE");

    /** SHOW_DEAL_DEAL_ID */
    // TODO REMOVE
    public static final String   TAGGEDVALUE_MANAGEABLE_SHOW_DEAL_DEAL_ID            = GuiProfile.PROFILE.get("MANAGEABLE_SHOW_DEAL_DEAL_ID");

    /** BUSINESS_OBJECT_REF_COLUMN */
    public static final String   TAGGEDVALUE_BUSINESS_OBJECT_REF_COLUMN              = GuiProfile.PROFILE.get("BUSINESS_OBJECT_REF_COLUMN");

    /** CUSTOMUSECASE_DISPLAYTYPE */
    public static final String   TAGGEDVALUE_CUSTOMUSECASE_DISPLAY_TYPE              = GuiProfile.PROFILE.get("CUSTOMUSECASE_DISPLAY_TYPE");

    /** CUSTOMUSECASE_ACTIONTYPE */
    public static final String   TAGGEDVALUE_CUSTOMUSECASE_ACTION_TYPE               = GuiProfile.PROFILE.get("CUSTOMUSECASE_ACTION_TYPE");

    /** COHERENCY_SOURCE_SOURCEVALUE */
    public static final String   TAGGEDVALUE_COHERENCY_SOURCE_SOURCEVALUE            = GuiProfile.PROFILE.get("COHERENCY_SOURCE_SOURCEVALUE");

    /** COHERENCY_SOURCE_TARGETVALUE */
    public static final String   TAGGEDVALUE_COHERENCY_SOURCE_TARGETVALUE            = GuiProfile.PROFILE.get("COHERENCY_SOURCE_TARGETVALUE");

    /** COHERENCY_SOURCE_TARGET_DEACTIVATE */
    public static final String   TAGGEDVALUE_COHERENCY_SOURCE_TARGET_DEACTIVATE      = GuiProfile.PROFILE.get("COHERENCY_SOURCE_TARGET_DEACTIVATE");

    /** COHERENCY_STATE_WHEN_DEACTIVATED */
    public static final String   TAGGEDVALUE_COHERENCY_STATE_WHEN_DEACTIVATED        = GuiProfile.PROFILE.get("COHERENCY_STATE_WHEN_DEACTIVATED");

    /** COHERENCY_STATE_WHEN_ACTIVATED */
    public static final String   TAGGEDVALUE_COHERENCY_STATE_WHEN_ACTIVATED          = GuiProfile.PROFILE.get("COHERENCY_STATE_WHEN_ACTIVATED");

    /** COHERENCY_IS_STATE */
    public static final String   TAGGEDVALUE_COHERENCY_IS_STATE                      = GuiProfile.PROFILE.get("COHERENCY_IS_STATE");

    /** COHERENCY_IS_VALUE */
    public static final String   TAGGEDVALUE_COHERENCY_IS_VALUE                      = GuiProfile.PROFILE.get("COHERENCY_IS_VALUE");

    /* ----------------- Data Types -------------------- */
    /** CHARACTER_TYPE */
    public static final String   CHARACTER_TYPE_NAME                                 = GuiProfile.PROFILE.get("CHARACTER_TYPE");

    /** BYTE_TYPE */
    public static final String   BYTE_TYPE_NAME                                      = GuiProfile.PROFILE.get("BYTE_TYPE");

    /** SHORT_TYPE */
    public static final String   SHORT_TYPE_NAME                                     = GuiProfile.PROFILE.get("SHORT_TYPE");

    /** INTEGER_TYPE */
    public static final String   INTEGER_TYPE_NAME                                   = GuiProfile.PROFILE.get("INTEGER_TYPE");

    /** LONG_TYPE */
    public static final String   LONG_TYPE_NAME                                      = GuiProfile.PROFILE.get("LONG_TYPE");

    /** FLOAT_TYPE */
    public static final String   FLOAT_TYPE_NAME                                     = GuiProfile.PROFILE.get("FLOAT_TYPE");

    /** DOUBLE_TYPE */
    public static final String   DOUBLE_TYPE_NAME                                    = GuiProfile.PROFILE.get("DOUBLE_TYPE");

    /** URL_TYPE */
    public static final String   URL_TYPE_NAME                                       = GuiProfile.PROFILE.get("URL_TYPE");

    /** TIME_TYPE */
    public static final String   TIME_TYPE_NAME                                      = GuiProfile.PROFILE.get("TIME_TYPE");

    /** CHOICE_TYPE */
    public static final String   CHOICE_TYPE_NAME                                    = GuiProfile.PROFILE.get("CHOICE_TYPE");

    /** NUMERIC_TYPE */
    public static final String   NUMERIC_TYPE_NAME                                   = GuiProfile.PROFILE.get("NUMERIC_TYPE");

    /* ----------------- Default Values ----------------- */
    /** true */
    public static final boolean  TAGGEDVALUE_TABLE_SORTABLE_DEFAULT_VALUE            = true;

    /** true */
    public static final boolean  TAGGEDVALUE_TABLE_EXPORTABLE_DEFAULT_VALUE          = true;

    /** 15 */
    public static final int      TAGGEDVALUE_TABLE_MAXROWS_DEFAULT_COUNT             = 15;

    /**
     * DOCUMENT ME!
     */
    public static final boolean  TAGGEDVALUE_VIEW_SIMPLE_FILTER_ELEMENT_DEFAULT      = false;

    /**
     * DOCUMENT ME!
     */
    public static final boolean  TAGGEDVALUE_VIEW_REGROUP_MANDATORY_DEFAULT          = false;

    /**
     * DOCUMENT ME!
     */
    public static final boolean  TAGGEDVALUE_VIEW_MANDATORY_ELEMENT_DEFAULT          = true;

    /**
     * DOCUMENT ME!
     */
    public static final boolean  TAGGEDVALUE_MANAGEABLE_EDITABLE_DEFAULT             = true;

    /**
     * DOCUMENT ME!
     */
    public static final boolean  TAGGEDVALUE_MANAGEABLE_INSERT_DEFAULT               = true;

    /**
     * DOCUMENT ME!
     */
    public static final boolean  TAGGEDVALUE_MANAGEABLE_UPDATE_DEFAULT               = true;

    /**
     * DOCUMENT ME!
     */
    public static final boolean  TAGGEDVALUE_MANAGEABLE_DELETE_DEFAULT               = true;

    /**
     * DOCUMENT ME!
     */
    public static final boolean  TAGGEDVALUE_MANAGEABLE_ASSOCIATION_RELEVANT_DEFAULT = true;

    /**
     * DOCUMENT ME!
     */
    public static final boolean  TAGGEDVALUE_MANAGEABLE_POPUP_EDITION_DEFAULT        = false;

    /**
     * DOCUMENT ME!
     */
    public static final boolean  TAGGEDVALUE_MANAGEABLE_EXPORTABLE_DEFAULT           = false;

    /**
     * DOCUMENT ME!
     */
    public static final boolean  TAGGEDVALUE_MANAGEABLE_CLONABLE_DEFAULT             = true;

    /**
     * DOCUMENT ME!
     */
    public static final boolean  TAGGEDVALUE_MANAGEABLE_SORTABLE_DEFAULT             = false;

    /**
     * DOCUMENT ME!
     */
    public static final boolean  TAGGEDVALUE_MANAGEABLE_HASHELP_DEFAULT              = false;

    /**
     * DOCUMENT ME!
     */
    public static final boolean  TAGGEDVALUE_MANAGEABLE_FILTER_SHORTCUT_DEFAULT      = true;

    /**
     * DOCUMENT ME!
     */
    public static final boolean  TAGGEDVALUE_MANAGEABLE_CUSTOM_SORTERS_DEFAULT       = false;

    /**
     * DOCUMENT ME!
     */
    public static final String   TAGGEDVALUE_CHOICE_TYPE_DEFAULT_TYPE                = "YesNo";

    /**
     * DOCUMENT ME!
     */
    public static final String   TAGGEDVALUE_NUMERIC_TYPE_DEFAULT                    = "QUANTITY_DECIMAL_FORMAT";

    /**
     * DOCUMENT ME!
     */
    public static final int      TAGGEDVALUE_INPUT_DEFAULT_SIZE                      = 32;

}

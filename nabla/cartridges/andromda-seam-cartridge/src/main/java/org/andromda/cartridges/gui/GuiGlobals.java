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

/**
 * Stores globals for the Gui cartridge metafacades.
 *
 * @author Chad Brandon
 */
public class GuiGlobals
{

    /**
     * The suffix to append to the class names of CRUD value objects.
     */
    public static final String CRUD_VALUE_OBJECT_SUFFIX              = "crudValueObjectSuffix";

    /**
     * A space-separated list of types to which displaytag table are to be exported by default.
     */
    public static final String PROPERTY_DEFAULT_TABLE_EXPORT_TYPES   = "defaultTableExportTypes";

    /**
     * The default number of columns to render for input fields.
     */
    public static final String PROPERTY_DEFAULT_INPUT_COLUMN_COUNT   = "defaultInputColumnCount";

    /**
     * The default number of rows to render for textarea fields.
     */
    public static final String PROPERTY_DEFAULT_INPUT_ROW_COUNT      = "defaultInputRowCount";

    /**
     * Denotes the way application resource messages ought to be generated.
     * When messages are normalized it means that elements with the same name
     * will reuse the same label, even if they are located in entirely different
     * use-cases or pages.
     * <p/>
     * This results in resource bundles that are not only smaller in size but
     * also more straightforward to translate. The downside is that it will be
     * less evident to customize labels for certain fields (which is rarely the
     * case anyway).
     * <p/>
     */
    public static final String NORMALIZE_MESSAGES                    = "normalizeMessages";

    /**
     * The pattern for constructing the form name.
     */
    public static final String FORM_PATTERN                          = "formPattern";

    /**
     * Contains the default value for whether or not all forwards should perform a HTTP redirect or not.
     */
    public static final String DEFAULT_ACTION_REDIRECT               = "defaultActionRedirect";

    /**
     * The pattern for constructing the form implementation name.
     */
    public static final String FORM_IMPLEMENTATION_PATTERN           = "formImplementationPattern";

    /**
     * The pattern for constructing the bean name under which the form is stored.
     */
    public static final String FORM_BEAN_PATTERN                     = "formBeanPattern";

    /**
     * Stores the default form scope which can be overridden with a tagged value.
     */
    public static final String FORM_SCOPE                            = "formScope";

    /**
     * Stores the pattern used for constructing the controller implementation name.
     */
    public static final String CONTROLLER_IMPLEMENTATION_PATTERN     = "controllerImplementationPattern";

    /**
     * The suffix given to title message keys.
     */
    public static final String TITLE_MESSAGE_KEY_SUFFIX              = "title";

    /**
     * The suffix given to the documentation message keys.
     */
    public static final String DOCUMENTATION_MESSAGE_KEY_SUFFIX      = "documentation";

    /**
     * The namespace property used to identify the pattern used to construct the backend service's accessor.
     */
    public static final String SERVICE_ACCESSOR_PATTERN              = "serviceAccessorPattern";

    /**
     * The namespace property used to identify the pattern used to construct the backend service's package name.
     */
    public static final String SERVICE_PACKAGE_NAME_PATTERN          = "servicePackageNamePattern";

    /**
     * Represents a hyperlink action type.
     */
    public static final String ACTION_TYPE_HYPERLINK                 = "hyperlink";

    /**
     * Represents a popup action type.
     */
    public static final String VIEW_TYPE_POPUP                       = "popup";

    /**
     * Represents a form action type.
     */
    public static final String ACTION_TYPE_FORM                      = "form";

    /**
     * Represents a table action type.
     */
    public static final String ACTION_TYPE_TABLE                     = "table";

    /**
     * Represents an image action type.
     */
    public static final String ACTION_TYPE_IMAGE                     = "image";

    /**
     * Stores the default date format when dates are formatted.
     */
    public static final String PROPERTY_DEFAULT_DATEFORMAT           = "defaultDateFormat";

    /**
     * Stores the default time format when times are formatted.
     */
    public static final String PROPERTY_DEFAULT_TIMEFORMAT           = "defaultTimeFormat";

    /**
     * The default key under which the action form is stored.
     */
    public static final String ACTION_FORM_KEY                       = "actionFormKey";

    /**
     * The pattern used for constructing the name of the filter that performs view form population.
     */
    public static final String VIEW_POPULATOR_PATTERN                = "viewPopulatorPattern";

    /**
     * The pattern used for constructing a parameter's backing list name.  A backing list
     * is used when you want to select the value of the parameter from a list (typically
     * used for drop-down select input types).
     */
    public static final String BACKING_LIST_PATTERN                  = "backingListPattern";

    /**
     * The pattern used for constructing a parameter's backing value name.  A backing value
     * is used when you want to select and submit values from a regular table (works well when
     * you have a list of complex items with values you need to submit).
     */
    public static final String BACKING_VALUE_PATTERN                 = "backingValuePattern";

    /**
     * The pattern used for constructing the label list name (stores the list
     * of possible parameter value labels).
     */
    public static final String LABEL_LIST_PATTERN                    = "labelListPattern";

    /**
     * The pattern used for constructing the values list name (stores the list of
     * possible parameter values when selecting from a list).
     */
    public static final String VALUE_LIST_PATTERN                    = "valueListPattern";

    /**
     * The item count for dummy arrays.
     */
    public static final int    DUMMY_ARRAY_COUNT                     = 5;

    /**
     * The pattern used for constructing the name of Gui converter classes (i.e.
     * the enumeration converter).
     */
    public static final String CONVERTER_PATTERN                     = "converterPattern";

    /**
     * The "textarea" form input type.
     */
    public static final String INPUT_TEXTAREA                        = "textarea";

    /**
     * The "select" form input type.
     */
    public static final String INPUT_SELECT                          = "select";

    /**
     * The "password" form input type.
     */
    public static final String INPUT_PASSWORD                        = "password";

    /**
     * The "hidden" form input type.
     */
    public static final String INPUT_HIDDEN                          = "hidden";

    /**
     * The "radio" form input type.
     */
    public static final String INPUT_RADIO                           = "radio";

    /**
     * The "text" form input type.
     */
    public static final String INPUT_TEXT                            = "text";

    /**
     * The "multibox" form input type.
     */
    public static final String INPUT_MULTIBOX                        = "multibox";

    /**
     * The "table" form input type.
     */
    public static final String INPUT_TABLE                           = "table";

    /**
     * The "checkbox" form input type.
     */
    public static final String INPUT_CHECKBOX                        = "checkbox";

    /**
     * The "plain text" type.
     */
    public static final String PLAIN_TEXT                            = "plaintext";

    /**
     * The suffix to append to the forward name.
     */
    public static final String USECASE_FORWARD_NAME_SUFFIX           = "-usecase";

    // public static final String TAGGEDVALUE_INPUT_TYPE_TEXT = "text";
    /**
     * DOCUMENT ME!
     */
    public static final String TAGGEDVALUE_INPUT_TYPE_LINK           = "link";

    /**
     * DOCUMENT ME!
     */
    public static final String TAGGEDVALUE_INPUT_TYPE_FILE           = "file";

    /**
     * The suffix for form names.
     */
    public static final String FORM_SUFFIX                           = "Form";

    /**
     * DOCUMENT ME!
     */
    public static final String TAGGEDVALUE_VIEW_CONTAINER_TYPE_TR    = "transparent";

    /**
     * DOCUMENT ME!
     */
    public static final String TAGGEDVALUE_VIEW_CONTAINER_TYPE_EX    = "expandable";

    /**
     * DOCUMENT ME!
     */
    public static final String TAGGEDVALUE_VIEW_CONTAINER_TYPE_TA    = "tabs";

    /**
     * DOCUMENT ME!
     */
    public static final String TAGGEDVALUE_VIEW_CONTAINER_TYPE_WI    = "window";

    /**
     * DOCUMENT ME!
     */
    public static final String TAGGEDVALUE_VIEW_LAYOUT_TYPE_WB       = "workbook";

    /**
     * DOCUMENT ME!
     */
    public static final String TAGGEDVALUE_VIEW_LAYOUT_TYPE_WS       = "worksheet";

    /**
     * DOCUMENT ME!
     */
    public static final String TAGGEDVALUE_VIEW_LAYOUT_TYPE_CO       = "container";

    /**
     * DOCUMENT ME!
     */
    public static final String TAGGEDVALUE_VIEW_CONTAINER_HEIGHT_DEF = "50";

    /**
     * DOCUMENT ME!
     */
    public static final String TAGGEDVALUE_VIEW_CONTAINER_WIDTH_DEF  = "1230";

    /**
     * The suffix for form implementation names.
     */
    public static final String FORM_IMPLEMENTATION_SUFFIX            = GuiGlobals.FORM_SUFFIX + "Impl";

    /**
     * The namespace property used to identify the action path prefix, which may very well be empty.
     */
    public static final String PROPERTY_ACTION_PATH_PREFIX           = "actionPathPrefix";

    /**
     * Contains the default value for whether or not all forwards should perform a HTTP redirect or not.
     */
    public static final String PROPERTY_DEFAULT_ACTION_REDIRECT      = "defaultActionRedirect";

    /**
     * The suffix used to append to decorator class names.
     */
    public static final String PROPERTY_TABLE_DECORATOR_SUFFIX       = "tableDecoratorSuffix";

    /**
     * The namespace property used to toggle the automatic generation of table decorators for displaytag.
     */
    public static final String PROPERTY_GENERATE_TABLE_DECORATORS    = "generateTableDecorators";

    /**
     * DOCUMENT ME!
     */

    // public static final String NEW_LINE = System.getProperty("line.separator");

    /**
     * DOCUMENT ME!
     */
    public static final String FILE_SEPARATOR                        = System.getProperty("file.separator");

    /**
     * DOCUMENT ME!
     */
    public static final String SEPARATOR                             = "/";

    /**
     * DOCUMENT ME!
     */

    // public static final String PATH_SEPARATOR = System.getProperty("path.separator");
    public static final String MANUAL_MAPPING_LOCATION               = "manual-mapping";

}

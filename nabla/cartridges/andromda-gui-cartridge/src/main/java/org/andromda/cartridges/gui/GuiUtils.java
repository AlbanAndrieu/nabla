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

import org.andromda.cartridges.gui.metafacades.GuiAttribute;
import org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute;
import org.andromda.cartridges.gui.metafacades.GuiParameter;

import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.FrontEndAction;
import org.andromda.metafacades.uml.FrontEndParameter;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.ParameterFacade;
import org.andromda.metafacades.uml.UMLMetafacadeUtils;

import org.andromda.utils.StringUtilsHelper;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Utilities for use within the Gui cartridge.
 *
 * @author Chad Brandon
 */
public class GuiUtils
{

    private static final Pattern VALIDATOR_TAGGEDVALUE_PATTERN = Pattern.compile("\\w+(\\(\\w+=[^,)]*(,\\w+=[^,)]*)*\\))?");
    private static final String  ANNOTATION_VALIDATOR_PREFIX   = "@";

    /**
     * DOCUMENT ME!
     */
    public static String         DEFAULT_NUMERIC_FORMAT        = "###,###,###,##0.000000000;-###,###,###,##0.000000000";

    /**
     * Converts the argument into a web resource name, this means: all lowercase
     * characters and words are separated with dashes.
     *
     * @param string any string
     * @return the string converted to a value that would be well-suited for a
     *         web file name
     */
    public static String toWebResourceName(final String string)
    {

        return StringUtilsHelper.separate(string, "-").toLowerCase();

    }

    /**
     * Converts the argument into a web file name, this means: all lowercase
     * characters and words are separated with dashes.
     *
     * @param string any string
     * @return the string converted to a value that would be well-suited for a
     *         web file name
     */
    public static String toWebFileName(final String string)
    {

        // return StringUtilsHelper.toPhrase(string).replace(' ', '-').toLowerCase();
        return GuiUtils.toWebResourceName(string);

    }

    /**
     * Reads the validator arguments from the the given tagged value.
     * @param validatorTaggedValue
     * @return returns a list of String instances or an empty list
     * @throws IllegalArgumentException when the input string does not match the required pattern
     */
    public static List<String> parseValidatorArgs(String validatorTaggedValue)
    {

        if (validatorTaggedValue == null)
        {

            throw new IllegalArgumentException("Validator tagged value cannot be null");

        }

        final List<String> validatorArgs = new ArrayList<String>();

        // isn't it an annotation ?
        if (!StringUtils.startsWith(validatorTaggedValue, GuiUtils.ANNOTATION_VALIDATOR_PREFIX))
        {

            // check if the input tagged value matches the required pattern
            if (!GuiUtils.VALIDATOR_TAGGEDVALUE_PATTERN.matcher(validatorTaggedValue).matches())
            {

                throw new IllegalArgumentException("Illegal validator tagged value (this tag is used to specify custom validators "
                        + "and might look like myValidator(myVar=myArg,myVar2=myArg2), perhaps you wanted to use " + "andromda_presentation_view_field_format?): " + validatorTaggedValue);

            }

            // only keep what is between parentheses (if any)
            final int left = validatorTaggedValue.indexOf('(');

            if (left > -1)
            {

                final int right = validatorTaggedValue.indexOf(')');

                validatorTaggedValue = validatorTaggedValue.substring(left + 1, right);

                final String[] pairs = validatorTaggedValue.split(",");

                for (final String pair : pairs)
                {

                    final int equalsIndex = pair.indexOf('=');

                    // it's possible the argument is the empty string
                    if (equalsIndex < (pair.length() - 1))
                    {

                        validatorArgs.add(pair.substring(equalsIndex + 1));

                    } else
                    {

                        validatorArgs.add("");

                    }

                }

            }

        }

        return validatorArgs;

    }

    /**
     * Reads the validator variable names from the the given tagged value.
     * @param validatorTaggedValue
     * @return never null, returns a list of String instances
     * @throws IllegalArgumentException when the input string does not match the required pattern
     */
    public static List<String> parseValidatorVars(String validatorTaggedValue)
    {

        if (validatorTaggedValue == null)
        {

            throw new IllegalArgumentException("Validator tagged value cannot be null");

        }

        final List<String> validatorVars = new ArrayList<String>();

        // isn't it an annotation ?
        if (!StringUtils.startsWith(validatorTaggedValue, GuiUtils.ANNOTATION_VALIDATOR_PREFIX))
        {

            // check if the input tagged value matches the required pattern
            if (!GuiUtils.VALIDATOR_TAGGEDVALUE_PATTERN.matcher(validatorTaggedValue).matches())
            {

                throw new IllegalArgumentException("Illegal validator tagged value: " + validatorTaggedValue);

            }

            // only keep what is between parentheses (if any)
            final int left = validatorTaggedValue.indexOf('(');

            if (left > -1)
            {

                final int right = validatorTaggedValue.indexOf(')');

                validatorTaggedValue = validatorTaggedValue.substring(left + 1, right);

                final String[] pairs = validatorTaggedValue.split(",");

                for (final String pair : pairs)
                {

                    final int equalsIndex = pair.indexOf('=');

                    validatorVars.add(pair.substring(0, equalsIndex));

                }

            }

        }

        return validatorVars;

    }

    /**
     * Parses the validator name for a tagged value.
     * @param validatorTaggedValue
     * @return validatorTaggedValue
     * @throws IllegalArgumentException when the input string does not match the required pattern
     */
    public static String parseValidatorName(final String validatorTaggedValue)
    {

        if (validatorTaggedValue == null)
        {

            throw new IllegalArgumentException("Validator tagged value cannot be null");

        }

        // isn't it an annotation ?
        if (StringUtils.startsWith(validatorTaggedValue, GuiUtils.ANNOTATION_VALIDATOR_PREFIX))
        {

            return validatorTaggedValue;

        }

        // check if the input tagged value matches the required pattern
        if (!GuiUtils.VALIDATOR_TAGGEDVALUE_PATTERN.matcher(validatorTaggedValue).matches())
        {

            throw new IllegalArgumentException("Illegal validator tagged value: " + validatorTaggedValue);

        }

        final int leftParen = validatorTaggedValue.indexOf('(');

        return (leftParen == -1) ? validatorTaggedValue : validatorTaggedValue.substring(0, leftParen);

    }

    /**
     * Constructs a string representing an array initialization in Java.
     *
     * @param name the name to give the array.
     * @param count the number of items to give the array.
     * @return A String representing Java code for the initialization of an array.
     */
    public static String constructDummyArrayDeclaration(final String name, final int count)
    {

        final StringBuilder array = new StringBuilder("new Object[] {");

        for (int ctr = 1; ctr <= count; ctr++)
        {

            array.append("\"" + name + "-" + ctr + "\"");

            if (ctr != count)
            {

                array.append(", ");

            }

        }

        array.append("}");

        return array.toString();

    }

    /**
     * @param format
     * @return this field's date format
     */
    public static String getDateFormat(String format)
    {

        format = StringUtils.trimToEmpty(format);

        return format.endsWith(GuiUtils.STRICT) ? GuiUtils.getToken(format, 1, 2) : GuiUtils.getToken(format, 0, 1);

    }

    private static String         defaultDateFormat = "MM/dd/yyyy HH:mm:ssZ";
    private static FastDateFormat df                = FastDateFormat.getInstance(GuiUtils.defaultDateFormat);

    /**
     * Returns the current Date in the specified format.
     *
     * @param format The format for the output date
     * @return the current date in the specified format.
     */
    public static String getDate(final String format)
    {

        if ((GuiUtils.df == null) || !format.equals(GuiUtils.df.getPattern()))
        {

            GuiUtils.df = FastDateFormat.getInstance(format);

        }

        return GuiUtils.df.format(new Date());

    }

    /**
     * Returns the current Date
     *
     * @return the current date in the default format.
     */
    public static String getDate()
    {

        return GuiUtils.getDate(GuiUtils.defaultDateFormat);

    }

    private static final String STRICT = "strict";

    /**
     * @param format
     * @return <code>true</code> if this field's value needs to conform to a
     * strict date format, <code>false</code> otherwise
     */
    public static boolean isStrictDateFormat(final String format)
    {

        return GuiUtils.strictDateTimeFormat ? GuiUtils.strictDateTimeFormat : GuiUtils.STRICT.equalsIgnoreCase(GuiUtils.getToken(format, 0, 2));

    }

    /**
     * Indicates if the given <code>format</code> is an email format.
     * @param format
     * @return <code>true</code> if this field is to be formatted as an email
     * address, <code>false</code> otherwise
     */
    public static boolean isEmailFormat(final String format)
    {

        return "email".equalsIgnoreCase(GuiUtils.getToken(format, 0, 2));

    }

    /**
     * Indicates if the given <code>format</code> is an equal format.
     * @param format
     * @return <code>true</code> if this field is to be formatted as an
     * email address, <code>false</code> otherwise
     */
    public static boolean isEqualFormat(final String format)
    {

        return "equal".equalsIgnoreCase(GuiUtils.getToken(format, 0, 2));

    }

    /**
     * Indicates if the given <code>format</code> is a credit card format.
     * @param format
     * @return <code>true</code> if this field is to be formatted as a credit card, <code>false</code> otherwise
     */
    public static boolean isCreditCardFormat(final String format)
    {

        return "creditcard".equalsIgnoreCase(GuiUtils.getToken(format, 0, 2));

    }

    /**
     * Indicates if the given <code>format</code> is a pattern format.
     * @param format
     * @return <code>true</code> if this field's value needs to respect a certain pattern, <code>false</code> otherwise
     */
    public static boolean isPatternFormat(final String format)
    {

        return "pattern".equalsIgnoreCase(GuiUtils.getToken(format, 0, 2));

    }

    /**
     * Indicates if the given <code>format</code> is a minlength format.
     * @param format
     * @return <code>true</code> if this field's value needs to consist of at least a certain
     *         number of characters, <code>false</code> otherwise
     */
    public static boolean isMinLengthFormat(final String format)
    {

        return "minlength".equalsIgnoreCase(GuiUtils.getToken(format, 0, 2));

    }

    /**
     * Indicates if the given <code>format</code> is a maxlength format.
     * @param format
     * @return <code>true</code> if this field's value needs to consist of at maximum a certain
     *         number of characters, <code>false</code> otherwise
     */
    public static boolean isMaxLengthFormat(final String format)
    {

        return "maxlength".equalsIgnoreCase(GuiUtils.getToken(format, 0, 2));

    }

    /**
     * @param string
     * @param index
     * @param limit
     * @return the i-th space delimited token read from the argument String, where i does not exceed the specified limit
     */
    public static String getToken(final String string, final int index, final int limit)
    {

        String token = null;

        if ((string != null) && (string.length() > 0))
        {

            final String[] tokens = string.split("[\\s]+", limit);

            token = (index >= tokens.length) ? null : tokens[index];

        }

        return token;

    }

    /**
     * Retrieves the input format (if one is defined), for the given
     * <code>element</code>.
     * @param element the model element for which to retrieve the input format.
     * @return the input format.
     */
    public static String getInputFormat(final ModelElementFacade element)
    {

        final Object value = element.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_FORMAT);
        final String format = (value == null) ? null : String.valueOf(value);

        return (format == null) ? null : format.trim();

    }

    /**
     * Indicates if the given <code>format</code> is a range format.
     * @param format
     * @return <code>true</code> if this field's value needs to be in a specific range, <code>false</code> otherwise
     */
    public static boolean isRangeFormat(final String format)
    {

        return "range".equalsIgnoreCase(GuiUtils.getToken(format, 0, 2));

    }

    /**
     * @param type
     * @return <code>true</code> if the type of this field is a byte, <code>false</code> otherwise
     */
    public static boolean isByte(final ClassifierFacade type)
    {

        return GuiUtils.isType(type, GuiProfile.BYTE_TYPE_NAME);

    }

    /**
     * @param type
     * @return <code>true</code> if the type of this field is a short, <code>false</code> otherwise
     */
    public static boolean isShort(final ClassifierFacade type)
    {

        return GuiUtils.isType(type, GuiProfile.SHORT_TYPE_NAME);

    }

    /**
     * @param type
     * @return <code>true</code> if the type of this field is an integer, <code>false</code> otherwise
     */
    public static boolean isInteger(final ClassifierFacade type)
    {

        return GuiUtils.isType(type, GuiProfile.INTEGER_TYPE_NAME);

    }

    /**
     * @param type
     * @return <code>true</code> if the type of this field is a long integer, <code>false</code> otherwise
     */
    public static boolean isLong(final ClassifierFacade type)
    {

        return GuiUtils.isType(type, GuiProfile.LONG_TYPE_NAME);

    }

    /**
     * @param type
     * @return <code>true</code> if the type of this field is a floating point, <code>false</code> otherwise
     */
    public static boolean isFloat(final ClassifierFacade type)
    {

        return GuiUtils.isType(type, GuiProfile.FLOAT_TYPE_NAME);

    }

    /**
     * @param type
     * @return <code>true</code> if the type of this field is a double precision floating point,
     * <code>false</code> otherwise
     */
    public static boolean isDouble(final ClassifierFacade type)
    {

        return GuiUtils.isType(type, GuiProfile.DOUBLE_TYPE_NAME);

    }

    /**
     * @param type
     * @return <code>true</code> if the type of this field is a date, <code>false</code> otherwise
     */
    public static boolean isDate(final ClassifierFacade type)
    {

        return (type != null) && type.isDateType();

    }

    /**
     * @param type
     * @return <code>true</code> if the type of this field is a time, <code>false</code> otherwise
     */
    public static boolean isTime(final ClassifierFacade type)
    {

        return GuiUtils.isType(type, GuiProfile.TIME_TYPE_NAME);

    }

    /**
     * @param type
     * @return <code>true</code> if the type of this field is a URL, <code>false</code> otherwise
     */
    public static boolean isUrl(final ClassifierFacade type)
    {

        return GuiUtils.isType(type, GuiProfile.URL_TYPE_NAME);

    }

    private static boolean isType(final ClassifierFacade type, final String typeName)
    {

        boolean isType = UMLMetafacadeUtils.isType(type, typeName);

        if (!isType)
        {

            // - handle abstract types that are mapped to java types
            if (type.getLanguageMappings() != null)
            {

                final String javaTypeName = type.getLanguageMappings().getTo(type.getFullyQualifiedName(true));

                if (javaTypeName != null)
                {

                    isType = javaTypeName.replaceAll(".*\\.", "").equalsIgnoreCase(type.getLanguageMappings().getTo(typeName));

                }

            }

        }

        return isType;

    }

    /**
     * @param type
     * @return <code>true</code> if the type of this field is a String,
     * <code>false</code> otherwise
     */
    public static boolean isString(final ClassifierFacade type)
    {

        return (type != null) && type.isStringType();

    }

    /**
     * Indicates if the given element is read-only or not.
     *
     * @param element the element to check.
     * @return true/false
     */
    public static boolean isReadOnly(final ModelElementFacade element)
    {

        boolean readOnly = false;

        if (element != null)
        {

            final Object value = element.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_READONLY);

            readOnly = Boolean.valueOf(ObjectUtils.toString(value)).booleanValue();

        }

        return readOnly;

    }

    /**
     * Retrieves the "equal" value from the given element (if one is present).
     *
     * @param element the element from which to retrieve the equal value.
     * @return the "equal" value.
     */
    public static String getEqual(final ModelElementFacade element)
    {

        String equal = null;

        if (element != null)
        {

            final Object value = element.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_EQUAL);

            equal = (value == null) ? null : value.toString();

        }

        return equal;

    }

    /**
     * Retrieves the "equal" value from the given element (if one is present).
     *
     * @param element the element from which to retrieve the equal value.
     * @param ownerParameter the optional owner parameter (specified if the element is an attribute).
     * @return the "equal" value.
     */
    public static String getEqual(final ModelElementFacade element, final ParameterFacade ownerParameter)
    {

        String equal = null;

        if (element != null)
        {

            final Object value = element.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_EQUAL);

            equal = (value == null) ? null : value.toString();

            if (StringUtils.isNotBlank(equal) && (ownerParameter != null))
            {

                equal = ownerParameter.getName() + StringUtilsHelper.upperCamelCaseName(equal);

            }

        }

        return equal;

    }

    /**
     * Retrieves the "validwhen" value from the given element (if one is present).
     *
     * @param element the element from which to retrieve the validwhen value.
     * @return the "validwhen" value.
     */
    public static String getValidWhen(final ModelElementFacade element)
    {

        String validWhen = null;

        if (element != null)
        {

            final Object value = element.findTaggedValue(GuiProfile.TAGGEDVALUE_INPUT_VALIDWHEN);

            validWhen = (value == null) ? null : ('(' + value.toString() + ')');

        }

        return validWhen;

    }

    /**
     * @param format
     * @return the lower limit for this field's value's range
     */
    public static String getRangeStart(final String format)
    {

        return GuiUtils.getToken(format, 1, 3);

    }

    /**
     * @param format
     * @return the upper limit for this field's value's range
     */
    public static String getRangeEnd(final String format)
    {

        return GuiUtils.getToken(format, 2, 3);

    }

    /**
     * @param format
     * @return the minimum number of characters this field's value must consist of
     */
    public static String getMinLengthValue(final String format)
    {

        return GuiUtils.getToken(format, 1, 2);

    }

    /**
     * @param format
     * @return the maximum number of characters this field's value must consist of
     */
    public static String getMaxLengthValue(final String format)
    {

        return GuiUtils.getToken(format, 1, 2);

    }

    /**
     * @param format
     * @return the pattern this field's value must respect
     */
    public static String getPatternValue(final String format)
    {

        return '^' + GuiUtils.getToken(format, 1, 2) + '$';

    }

    // validator strings
    /** "required" */
    public static final String VT_REQUIRED     = "required";

    /** "url" */
    public static final String VT_URL          = "url";

    /** "intRange" */
    public static final String VT_INT_RANGE    = "intRange";

    /** "floatRange" */
    public static final String VT_FLOAT_RANGE  = "floatRange";

    /** "doubleRange" */
    public static final String VT_DOUBLE_RANGE = "doubleRange";

    /** "email" */
    public static final String VT_EMAIL        = "email";

    /** "creditCard" */
    public static final String VT_CREDIT_CARD  = "creditCard";

    /** "minlength" */
    public static final String VT_MIN_LENGTH   = "minlength";

    /** "maxlength" */
    public static final String VT_MAX_LENGTH   = "maxlength";

    /** "mask" */
    public static final String VT_MASK         = "mask";

    /** "validwhen" */
    public static final String VT_VALID_WHEN   = "validwhen";

    /** "equal" */
    public static final String VT_EQUAL        = "equal";

    /**
     * Retrieves the validator types as a collection from the given
     * <code>element</code> (if any can be retrieved).
     *
     * @param element the element from which to retrieve the types.
     * @param type the type of the element.
     * @return the collection of validator types.
     */
    public static Collection<String> getValidatorTypes(final ModelElementFacade element, final ClassifierFacade type)
    {

        final Collection<String> validatorTypesList = new ArrayList<String>();

        if ((element != null) && (type != null))
        {

            final String format = GuiUtils.getInputFormat(element);
            final boolean isRangeFormat = (format != null) && GuiUtils.isRangeFormat(format);

            if (element instanceof AttributeFacade)
            {

                if (((AttributeFacade) element).isRequired())
                {

                    validatorTypesList.add(GuiUtils.VT_REQUIRED);

                }

            } else if (element instanceof GuiParameter)
            {

                if (((GuiParameter) element).isRequired())
                {

                    validatorTypesList.add(GuiUtils.VT_REQUIRED);

                }

            }

            if (GuiUtils.isByte(type))
            {

                validatorTypesList.add("byte");

            } else if (GuiUtils.isShort(type))
            {

                validatorTypesList.add("short");

            } else if (GuiUtils.isInteger(type))
            {

                validatorTypesList.add("integer");

            } else if (GuiUtils.isLong(type))
            {

                validatorTypesList.add("long");

            } else if (GuiUtils.isFloat(type))
            {

                validatorTypesList.add("float");

            } else if (GuiUtils.isDouble(type))
            {

                validatorTypesList.add("double");

            } else if (GuiUtils.isDate(type))
            {

                validatorTypesList.add("date");

            } else if (GuiUtils.isTime(type))
            {

                validatorTypesList.add("time");

            } else if (GuiUtils.isUrl(type))
            {

                validatorTypesList.add(GuiUtils.VT_URL);

            }

            if (isRangeFormat)
            {

                if (GuiUtils.isInteger(type) || GuiUtils.isShort(type) || GuiUtils.isLong(type))
                {

                    validatorTypesList.add(GuiUtils.VT_INT_RANGE);

                }

                if (GuiUtils.isFloat(type))
                {

                    validatorTypesList.add(GuiUtils.VT_FLOAT_RANGE);

                }

                if (GuiUtils.isDouble(type))
                {

                    validatorTypesList.add(GuiUtils.VT_DOUBLE_RANGE);

                }

            }

            if (format != null)
            {

                if (GuiUtils.isString(type) && GuiUtils.isEmailFormat(format))
                {

                    validatorTypesList.add(GuiUtils.VT_EMAIL);

                } else if (GuiUtils.isString(type) && GuiUtils.isCreditCardFormat(format))
                {

                    validatorTypesList.add(GuiUtils.VT_CREDIT_CARD);

                } else
                {

                    final Collection formats = element.findTaggedValues(GuiProfile.TAGGEDVALUE_INPUT_FORMAT);

                    for (final Iterator formatIterator = formats.iterator(); formatIterator.hasNext();)
                    {

                        final String additionalFormat = String.valueOf(formatIterator.next());

                        if (GuiUtils.isMinLengthFormat(additionalFormat))
                        {

                            validatorTypesList.add(GuiUtils.VT_MIN_LENGTH);

                        } else if (GuiUtils.isMaxLengthFormat(additionalFormat))
                        {

                            validatorTypesList.add(GuiUtils.VT_MAX_LENGTH);

                        } else if (GuiUtils.isPatternFormat(additionalFormat))
                        {

                            validatorTypesList.add(GuiUtils.VT_MASK);

                        }

                    }

                }

            }

            if (GuiUtils.getValidWhen(element) != null)
            {

                validatorTypesList.add(GuiUtils.VT_VALID_WHEN);

            }

            if (GuiUtils.getEqual(element) != null)
            {

                validatorTypesList.add(GuiUtils.VT_EQUAL);

            }

            // - custom (paramterized) validators are allowed here
            final Collection taggedValues = element.findTaggedValues(GuiProfile.TAGGEDVALUE_INPUT_VALIDATORS);

            for (final Iterator iterator = taggedValues.iterator(); iterator.hasNext();)
            {

                final String validator = String.valueOf(iterator.next());

                validatorTypesList.add(GuiUtils.parseValidatorName(validator));

            }

        }

        return validatorTypesList;

    }

    /**
     * Gets the validator variables for the given <code>element</code> (if they can
     * be retrieved).
     *
     * @param element the element from which to retrieve the variables
     * @param type the type of the element.
     * @param ownerParameter the optional owner parameter (if the element is an attribute for example).
     * @return the collection of validator variables.
     */
    public static Collection<List<String>> getValidatorVars(final ModelElementFacade element, final ClassifierFacade type, final ParameterFacade ownerParameter)
    {

        final Map<String, List<String>> vars = new LinkedHashMap<String, List<String>>();

        if ((element != null) && (type != null))
        {

            final String format = GuiUtils.getInputFormat(element);

            if (format != null)
            {

                final boolean isRangeFormat = GuiUtils.isRangeFormat(format);

                if (isRangeFormat)
                {

                    final String min = "min";
                    final String max = "max";

                    vars.put(min, Arrays.asList(min, GuiUtils.getRangeStart(format)));
                    vars.put(max, Arrays.asList(max, GuiUtils.getRangeEnd(format)));

                } else
                {

                    final Collection formats = element.findTaggedValues(GuiProfile.TAGGEDVALUE_INPUT_FORMAT);

                    for (final Iterator formatIterator = formats.iterator(); formatIterator.hasNext();)
                    {

                        final String additionalFormat = String.valueOf(formatIterator.next());
                        final String minlength = "minlength";
                        final String maxlength = "maxlength";
                        final String mask = "mask";

                        if (GuiUtils.isMinLengthFormat(additionalFormat))
                        {

                            vars.put(minlength, Arrays.asList(minlength, GuiUtils.getMinLengthValue(additionalFormat)));

                        } else if (GuiUtils.isMaxLengthFormat(additionalFormat))
                        {

                            vars.put(maxlength, Arrays.asList(maxlength, GuiUtils.getMaxLengthValue(additionalFormat)));

                        } else if (GuiUtils.isPatternFormat(additionalFormat))
                        {

                            vars.put(mask, Arrays.asList(mask, GuiUtils.getPatternValue(additionalFormat)));

                        }

                    }

                }

            }

            String inputFormat;

            if (element instanceof GuiAttribute)
            {

                inputFormat = ((GuiAttribute) element).getFormat();

            } else if (element instanceof GuiParameter)
            {

                inputFormat = ((GuiParameter) element).getFormat();

            } else if (element instanceof GuiManageableEntityAttribute)
            {

                inputFormat = ((GuiManageableEntityAttribute) element).getFormat();

            } else
            {

                throw new RuntimeException("'element' is an invalid type, it must be either an instance of '" + GuiAttribute.class.getName() + "' or '" + GuiParameter.class.getName() + "'");

            }

            if (GuiUtils.isDate(type))
            {

                final String datePatternStrict = "datePatternStrict";

                if ((format != null) && GuiUtils.isStrictDateFormat(format))
                {

                    vars.put(datePatternStrict, Arrays.asList(datePatternStrict, inputFormat));

                } else
                {

                    final String datePattern = "datePattern";

                    vars.put(datePattern, Arrays.asList(datePattern, inputFormat));

                }

            }

            if (GuiUtils.isTime(type))
            {

                final String timePattern = "timePattern";

                vars.put(timePattern, Arrays.asList(timePattern, inputFormat));

            }

            final String validWhen = GuiUtils.getValidWhen(element);

            if (validWhen != null)
            {

                final String test = "test";

                vars.put(test, Arrays.asList(test, validWhen));

            }

            final String equal = GuiUtils.getEqual(element, ownerParameter);

            if (equal != null)
            {

                final String fieldName = "fieldName";

                vars.put(fieldName, Arrays.asList(fieldName, equal));

            }

            // - custom (parameterized) validators are allowed here
            // in this case we will reuse the validator arg values
            final Collection taggedValues = element.findTaggedValues(GuiProfile.TAGGEDVALUE_INPUT_VALIDATORS);

            for (final Object value : taggedValues)
            {

                final String validator = String.valueOf(value);

                // - guaranteed to be of the same length
                final List<String> validatorVars = GuiUtils.parseValidatorVars(validator);
                final List<String> validatorArgs = GuiUtils.parseValidatorArgs(validator);

                for (int ctr = 0; ctr < validatorVars.size(); ctr++)
                {

                    vars.put(validatorVars.get(ctr), Arrays.asList(validatorVars.get(ctr), validatorArgs.get(ctr)));

                }

            }

        }

        return vars.values();

    }

    /**
     * Gets the validator args for the <code>element</code> and the given <code>validatorType</code>.
     *
     * @param element the element for which to retrieve the arguments.
     * @param validatorType the validator type name.
     * @return the validator args as a collection.
     */
    public static java.util.Collection getValidatorArgs(final ModelElementFacade element, final String validatorType)
    {

        final Collection<Object> args = new ArrayList<Object>();

        if ("intRange".equals(validatorType) || "floatRange".equals(validatorType) || "doubleRange".equals(validatorType))
        {

            args.add("${var:min}");
            args.add("${var:max}");

        } else if ("minlength".equals(validatorType))
        {

            args.add("${var:minlength}");

        } else if ("maxlength".equals(validatorType))
        {

            args.add("${var:maxlength}");

        } else if ("date".equals(validatorType))
        {

            final String validatorFormat = GuiUtils.getInputFormat(element);

            if (GuiUtils.isStrictDateFormat(validatorFormat))
            {

                args.add("${var:datePatternStrict}");

            } else
            {

                args.add("${var:datePattern}");

            }

        } else if ("time".equals(validatorType))
        {

            args.add("${var:timePattern}");

        } else if ("equal".equals(validatorType))
        {

            ModelElementFacade equalParameter = null;
            final String equal = GuiUtils.getEqual(element);

            if (element instanceof ParameterFacade)
            {

                final FrontEndParameter parameter = (FrontEndParameter) element;
                final OperationFacade operation = parameter.getOperation();

                if (operation != null)
                {

                    equalParameter = operation.findParameter(equal);

                }

                if (equalParameter == null)
                {

                    final FrontEndAction action = parameter.getAction();

                    if (action != null)
                    {

                        equalParameter = action.findParameter(equal);

                    }

                }

            } else if (element instanceof AttributeFacade)
            {

                final AttributeFacade attribute = (AttributeFacade) element;
                final ClassifierFacade owner = attribute.getOwner();

                if (owner != null)
                {

                    equalParameter = owner.findAttribute(equal);

                }

            }

            args.add(equalParameter);
            args.add("${var:fieldName}");

        }

        // custom (paramterized) validators are allowed here
        final Collection taggedValues = element.findTaggedValues(GuiProfile.TAGGEDVALUE_INPUT_VALIDATORS);

        for (final Iterator iterator = taggedValues.iterator(); iterator.hasNext();)
        {

            final String validator = String.valueOf(iterator.next());

            if (validatorType.equals(GuiUtils.parseValidatorName(validator)))
            {

                args.addAll(GuiUtils.parseValidatorArgs(validator));

            }

        }

        return args;

    }

    /**
     * Whether or not date patterns should be treated as strict.
     */
    private static boolean strictDateTimeFormat;

    /**
     * Sets whether or not the date patterns should be treated as strict.
     *
     * @param strictDateTimeFormat
     */
    public void setStrictDateTimeFormat(final boolean strictDateTimeFormat)
    {

        GuiUtils.strictDateTimeFormat = strictDateTimeFormat;

    }

    /**
     * Indicates whether or not the format for this element is a strict date
     * format.
     * @param element
     * @return true/false
     */
    public static boolean isStrictDateFormat(final ModelElementFacade element)
    {

        final String format = GuiUtils.getInputFormat(element);

        return GuiUtils.isStrictDateFormat(format);

    }

    /**
     * Gets the format string for the given <code>element</code>.
     *
     * @param element the element for which to retrieve the format.
     * @param type the type of the element.
     * @param defaultDateFormat
     * @param defaultTimeFormat
     * @return the format string (if one is present otherwise null).
     */
    public static String getFormat(final ModelElementFacade element, final ClassifierFacade type, final String defaultDateFormat, final String defaultTimeFormat)
    {

        String format = null;

        if ((element != null) && (type != null))
        {

            format = GuiUtils.getInputFormat(element);

            if (format == null)
            {

                if (type.isDateType() && type.isTimeType())
                {

                    format = defaultDateFormat + " " + defaultTimeFormat;

                } else if (type.isTimeType())
                {

                    format = defaultTimeFormat;

                } else if (type.isDateType())
                {

                    format = defaultDateFormat;

                }

            } else if (type.isDateType())
            {

                format = GuiUtils.getDateFormat(format);

            }

        }

        return format;

    }

    /**
     * The XHTML extension.
     */
    private static final String EXTENSION_XHTML = "xhtml";

    /**
     * Gets the extension for the view type.
     *
     * @return the view type extension.
     */
    public String getViewExtension()
    {

        return GuiUtils.EXTENSION_XHTML;

    }

    private String portletContainer;

    /**
     * @param portletContainer
     */
    public void setPortletContainer(final String portletContainer)
    {

        this.portletContainer = portletContainer;

    }

    private boolean isPortlet()
    {

        return StringUtils.isNotBlank(this.portletContainer);

    }

    /**
     * @return className
     */
    public String getRequestClassName()
    {

        final String className;

        if (this.isPortlet())
        {

            className = "javax.portlet.PortletRequest";

        } else
        {

            className = "javax.servlet.http.HttpServletRequest";

        }

        return className;

    }

    /**
     * @return className
     */
    public String getResponseClassName()
    {

        final String className;

        if (this.isPortlet())
        {

            className = "javax.portlet.PortletResponse";

        } else
        {

            className = "javax.servlet.http.HttpServletResponse";

        }

        return className;

    }

    /**
     * @return className
     */
    public String getSessionClassName()
    {

        final String className;

        if (this.isPortlet())
        {

            className = "javax.portlet.PortletSession";

        } else
        {

            className = "javax.servlet.http.HttpSession";

        }

        return className;

    }

    /**
     * @param buffer
     * @return the calculated SerialVersionUID
     */
    public static String calcSerialVersionUID(final StringBuilder buffer)
    {

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

            throw new RuntimeException("Error performing GuiAction.getFormSerialVersionUID", exception);

        }

        return serialVersionUID;

    }

    /**
     * @param string
     * @return Integer.valueOf(string) * 6000
     */
    public int calculateIcefacesTimeout(final String string)
    {

        return (string != null) ? (Integer.valueOf(string) * 6000) : 0;

    }

    /**
     * Returns a sequence of file formats representing the desired export types for the display tag tables
     * used for the argument element.
     *
     * @param taggedValues the collection of tagged values representing the export types, should only contain
     *  <code>String</code> instances and must never be <code>null</code>
     * @param defaultValue the default value to use in case the tagged values are empty
     * @return a space separated list of formats, never <code>null</code>
     */
    public static String getDisplayTagExportTypes(final Collection taggedValues, final String defaultValue)
    {

        String exportTypes;

        if (taggedValues.isEmpty())
        {

            exportTypes = defaultValue;

        } else
        {

            if (taggedValues.contains("none"))
            {

                exportTypes = "none";

            } else
            {

                final StringBuilder buffer = new StringBuilder();

                for (final Iterator iterator = taggedValues.iterator(); iterator.hasNext();)
                {

                    final String exportType = StringUtils.trimToNull(String.valueOf(iterator.next()));

                    if ("csv".equalsIgnoreCase(exportType) || "pdf".equalsIgnoreCase(exportType) || "xml".equalsIgnoreCase(exportType) || "excel".equalsIgnoreCase(exportType))
                    {

                        buffer.append(exportType);
                        buffer.append(' ');

                    }

                }

                exportTypes = buffer.toString().trim();

            }

        }

        return exportTypes;

    }

    /**
     * Convenient method to detect whether or not a String instance represents a boolean <code>true</code> value.
     */
    public static boolean isTrue(final String string)
    {

        return "yes".equalsIgnoreCase(string) || "true".equalsIgnoreCase(string) || "on".equalsIgnoreCase(string) || "1".equalsIgnoreCase(string);

    }

    /**
     * Returns <code>true</code> if the argument name will not cause any troubles with the Jakarta commons-beanutils
     * library, which basically means it does not start with an lowercase characters followed by an uppercase character.
     * This means there's a bug in that specific library that causes an incompatibility with the Java Beans
     * specification as implemented in the JDK.
     *
     * @param name the name to test, may be <code>null</code>
     * @return <code>true</code> if the name is safe to use with the Jakarta libraries, <code>false</code> otherwise
     */
    public static boolean isSafeName(final String name)
    {

        boolean safe = true;

        if ((name != null) && (name.length() > 1))
        {

            safe = !(Character.isLowerCase(name.charAt(0)) && Character.isUpperCase(name.charAt(1)));

        }

        return safe;

    }

    /**
     * DOCUMENT ME!
     *
     * @param format DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String getNumberFormat(final String format)
    {

        String displayFormat = "";

        if (format == null)
        {

            return GuiUtils.getDefaultDoubleFormat();

        }

        if (format.equals(GuiProfile.TAGGEDVALUE_NUMERIC_TYPE_DEFAULT))
        {

            displayFormat = "###,###,##0.0000;-###,###,##0.0000";

        } else if (format.equals("QUANTITY_FORMAT"))
        {

            displayFormat = "###,###,##0.0000000;-###,###,##0.0000000";

        } else if (format.equals("PRICE_FORMAT"))
        {

            displayFormat = "###,###,##0.00000000";

        } else
        {

            displayFormat = GuiUtils.getDefaultDoubleFormat();

        }

        return displayFormat;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String getDefaultDoubleFormat()
    {

        return GuiUtils.DEFAULT_NUMERIC_FORMAT;

    }

    /*
     * public static void newFile(final String path, final String name) {
     * try {
     * final File file = new File(path + "/" + StringUtilsHelper.upperCamelCaseName(name) + ".xml");
     * final boolean success = file.createNewFile();
     * if (!success) {
     * KarmaUtils.logger_.error("Can not create the file " + path + "/" + name + ".xml");
     * //throw new Exception("Can not create the file " + path + "/" + name + ".xml");
     * System.exit(1);
     * } else {
     * KarmaUtils.logger_.info("Create the file " + path + "/" + name + ".xml");
     * }
     * } catch (final IOException e) {
     * e.printStackTrace();
     * } catch (final Exception e) {
     * e.printStackTrace();
     * }
     * }
     * public static void addToFile(final String path, final String name, final String contenu) {
     * try {
     * final File file = new File(path + "/" + name + ".xml");
     * final PrintWriter out = new PrintWriter(new FileWriter(file, true), true);
     * final String res = contenu.replace("\\", "");
     * out.println(res);
     * out.close();
     * } catch (final IOException e) {
     * e.printStackTrace();
     * } catch (final Exception e) {
     * e.printStackTrace();
     * }
     * }
     */
}

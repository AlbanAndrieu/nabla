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
package org.andromda.metafacades.uml;

import java.text.Normalizer;

import org.andromda.utils.StringUtilsHelper;
import org.apache.commons.lang.StringUtils;

/**
 * Provides the ability to <code>mask</code> names in a standard manner.
 * 
 * @author Chad Brandon
 */
public class NameMasker
{
    /**
     * The <code>uppercase</code> mask.
     */
    public static final String UPPERCASE       = "uppercase";

    /**
     * The <code>underscore</code> mask.
     */
    public static final String UNDERSCORE      = "underscore";

    /**
     * The <code>upperunderscore</code> mask.
     */
    public static final String UPPERUNDERSCORE = "upperunderscore";

    /**
     * The <code>lowercase</code> mask.
     */
    public static final String LOWERCASE       = "lowercase";

    /**
     * The <code>lowerunderscore</code> mask.
     */
    public static final String LOWERUNDERSCORE = "lowerunderscore";

    /**
     * The <code>uppercamelcase</code> mask.
     */
    public static final String UPPERCAMELCASE  = "uppercamelcase";

    /**
     * The <code>lowercamelcase</code> mask.
     */
    public static final String LOWERCAMELCASE  = "lowercamelcase";

    /**
     * The <code>nospace</code> mask.
     */
    public static final String NOSPACE         = "nospace";

    /**
     * The <code>noaccent</code> mask.
     */
    public static final String NOACCENT        = "noaccent";

    /**
     * The <code>none</code> mask.
     */
    public static final String NONE            = "none";

    /**
     * Returns the name with the appropriate <code>mask</code> applied. The mask, must match one of the valid mask
     * properties or will be ignored.
     * 
     * @param name the name to be masked
     * @param mask the mask to apply
     * @return the masked name.
     */
    public static String mask(String name, String mask)
    {
        mask = StringUtils.trimToEmpty(mask);
        name = StringUtils.trimToEmpty(name);
        if (!mask.equalsIgnoreCase(NONE))
        {
            if (mask.equalsIgnoreCase(UPPERCASE))
            {
                name = name.toUpperCase();
            } else if (mask.equalsIgnoreCase(UNDERSCORE))
            {
                name = StringUtilsHelper.separate(name, "_");
            } else if (mask.equalsIgnoreCase(UPPERUNDERSCORE))
            {
                name = StringUtilsHelper.separate(name, "_").toUpperCase();
            } else if (mask.equalsIgnoreCase(LOWERCASE))
            {
                name = name.toLowerCase();
            } else if (mask.equalsIgnoreCase(LOWERUNDERSCORE))
            {
                name = StringUtilsHelper.separate(name, "_").toLowerCase();
            } else if (mask.equalsIgnoreCase(LOWERCAMELCASE))
            {
                name = StringUtilsHelper.lowerCamelCaseName(name);
            } else if (mask.equalsIgnoreCase(UPPERCAMELCASE))
            {
                name = StringUtilsHelper.upperCamelCaseName(name);
            } else if (mask.equalsIgnoreCase(NOSPACE))
            {
                name = StringUtils.deleteWhitespace(name);
            } else if (mask.equalsIgnoreCase(NOACCENT))
            {
                name = Normalizer.normalize(name, java.text.Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            }
        }
        return name;
    }
}

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

import org.andromda.core.mapping.Mapping;
import org.andromda.core.mapping.Mappings;
import org.apache.commons.lang.StringUtils;

/**
 * <p/>
 * An object responsible for mapping types in the object model to other language identifiers/types. (For example, Java,
 * SQL, Jdbc, etc). Basically just wraps the core {@link Mappings} instance in order to provide type specific mapping
 * functionality. </p>
 * 
 * @author Chad Brandon
 * @author Bob Fields
 */
public final class TypeMappings
{
    /**
     * The contained mappings instance.
     */
    private Mappings mappings = null;

    /**
     * The constructor that takes the {@link Mappings} instance.
     * 
     * @param mappings the Mapping instance from which to construct this TypeMappings instance.
     */
    private TypeMappings(Mappings mappings)
    {
        this.mappings = mappings;
    }

    /**
     * Sets the optional suffix used for array types (if
     * 
     * @param arraySuffix the suffix used for arrays within this mapping.
     */
    public void setArraySuffix(String arraySuffix)
    {
        this.arraySuffix = arraySuffix;
    }

    /**
     * Returns a new configured instance of this TypeMappings configured from the mappings instance.
     * 
     * @param mappings the Mappings instance.
     * @return TypeMappings the configured TypeMappings instance.
     */
    public static TypeMappings getInstance(Mappings mappings)
    {
        return new TypeMappings(mappings);
    }

    /**
     * Returns a new configured instance of this TypeMappings configured from the mappings instance.
     * 
     * @param mappingsUri the URI to configure the underlying {@link Mappings} instance.
     * @return TypeMappings the configured TypeMappings instance.
     */
    public static TypeMappings getInstance(String mappingsUri)
    {
        return TypeMappings.getInstance(Mappings.getInstance(mappingsUri));
    }

    /**
     * The suffix appended to array types is set from {@link #setArraySuffix(String)}.
     */
    private String arraySuffix = null;

    /**
     * Returns the <code>to</code> mapping from a given <code>from</code> mapping.
     * 
     * @param from the <code>from</code> mapping, this is the type/identifier that is in the model.
     * @return String to the <code>to</code> mapping (this is the mapping that can be retrieved if a corresponding
     * 'from' is found.
     */
    public String getTo(String from)
    {
        from = StringUtils.trimToEmpty(from);
        String initialFrom = from;

        String to = null;

        // first we check to see if there's an array
        // type mapping directly defined in the mappings
        Mapping mapping = this.mappings.getMapping(from);
        if (mapping == null && arraySuffix != null)
        {
            // if there is no mapping, remove the array suffix and
            // check for the mapping without the suffix.
            // if the from has an array suffix, then strip the array off
            // so we can find the mapping
            boolean isArray = from.endsWith(arraySuffix);
            if (isArray)
            {
                from = StringUtils.replace(from, arraySuffix, "");
            }
            mapping = this.mappings.getMapping(from);
            if (mapping != null)
            {
                StringBuilder toBuffer = new StringBuilder(mapping.getTo());
                if (isArray)
                {
                    // append the suffix back to the return value;
                    toBuffer.append(arraySuffix);
                }
                to = toBuffer.toString();
            }
        } else if (mapping != null)
        {
            to = mapping.getTo();
        }

        if (to == null)
        {
            to = initialFrom;
        }
        return StringUtils.trimToEmpty(to);
    }

    /**
     * Returns the Mappings instance which this TypeMapping wraps.
     * 
     * @return URL
     */
    public Mappings getMappings()
    {
        return this.mappings;
    }
}

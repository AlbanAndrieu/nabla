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
package org.andromda.cartridges.ejb3.metafacades;

import java.text.MessageFormat;
import org.andromda.metafacades.uml.UMLProfile;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.ejb3.metafacades.EJB3EmbeddedValueFacade.
 * 
 * @see EJB3EmbeddedValueFacade
 */
public class EJB3EmbeddedValueFacadeLogicImpl extends EJB3EmbeddedValueFacadeLogic
{
    private static final long serialVersionUID                           = 34L;
    /**
     * The property which stores the pattern defining the embedded value
     * implementation name.
     */
    static final String       EMBEDDED_VALUE_IMPLEMENTATION_NAME_PATTERN = "embeddedValueImplementationNamePattern";

    /**
     * @param metaObject
     * @param context
     */
    public EJB3EmbeddedValueFacadeLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);
    }

    /**
     * @see EJB3EmbeddedValueFacade#isImmutable()
     */
    @Override
    protected boolean handleIsImmutable()
    {
        boolean immutable = false;
        Object value = this.findTaggedValue(UMLProfile.TAGGEDVALUE_PERSISTENCE_IMMUTABLE);
        if (value != null)
        {
            immutable = Boolean.valueOf(ObjectUtils.toString(value)).booleanValue();
        }
        return immutable;
    }

    /**
     * @see EJB3EmbeddedValueFacade#getImplementationName()
     */
    @Override
    protected String handleGetImplementationName()
    {
        return MessageFormat.format(this.getImplementationNamePattern(), StringUtils.trimToEmpty(this.getName()));
    }

    /**
     * Gets the value of the {@link #EMBEDDED_VALUE_IMPLEMENTATION_NAME_PATTERN}
     * 
     * @return the embedded value name pattern.
     */
    private String getImplementationNamePattern()
    {
        return String.valueOf(this.getConfiguredProperty(EMBEDDED_VALUE_IMPLEMENTATION_NAME_PATTERN));
    }

    /**
     * @see EJB3EmbeddedValueFacadeLogic#handleGetFullyQualifiedImplementationName()
     */
    @Override
    protected String handleGetFullyQualifiedImplementationName()
    {
        return EJB3MetafacadeUtils.getFullyQualifiedName(this.getPackageName(), this.getImplementationName(), null);
    }
}

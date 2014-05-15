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

import org.andromda.core.common.ExceptionRecorder;
import org.andromda.metafacades.uml.TypeMappings;
import org.apache.commons.lang.StringUtils;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.ejb3.metafacades.EJB3TypeFacade.
 *
 * @see EJB3TypeFacade
 */
public class EJB3TypeFacadeLogicImpl extends EJB3TypeFacadeLogic
{
    private static final long serialVersionUID = 34L;

    /**
     * @param metaObject
     * @param context
     */
    public EJB3TypeFacadeLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);
    }

    /**
     * @see EJB3TypeFacade#getFullyQualifiedEJB3Type()
     */
    @Override
    protected String handleGetFullyQualifiedEJB3Type()
    {
        String fullyQualifiedName = super.getFullyQualifiedName();
        final TypeMappings mappings = this.getEJB3TypeMappings();
        if (mappings != null)
        {
            final String fullyQualifiedModelName = super.getFullyQualifiedName(true);
            if (mappings.getMappings().containsFrom(fullyQualifiedModelName))
            {
                fullyQualifiedName = mappings.getTo(fullyQualifiedModelName);
            }
        }
        return fullyQualifiedName;
    }

    /**
     * Gets the <code>hibernateTypeMappings</code> for this ejb3/hibernate type.
     *
     * @return the hibernate type TypeMappings.
     */
    protected TypeMappings getEJB3TypeMappings()
    {
        TypeMappings mappings = null;
        final String propertyName = "ejb3TypeMappingsUri";
        if (this.isConfiguredProperty(propertyName))
        {
            final Object property = this.getConfiguredProperty(propertyName);
            if (property instanceof String)
            {
                String uri = (String) property;
                if (StringUtils.isNotBlank(uri))
                {
                    try
                    {
                        mappings = TypeMappings.getInstance((String) property);
                        this.setProperty(propertyName, mappings);
                    }
                    catch (final Throwable throwable)
                    {
                        final String message = "Error getting '" + propertyName + "' --> '" + uri + '\'';

                        // don't throw the exception
                        ExceptionRecorder.instance().record(message, throwable);
                    }
                }
            } else
            {
                mappings = (TypeMappings) property;
            }
        }
        return mappings;
    }
}

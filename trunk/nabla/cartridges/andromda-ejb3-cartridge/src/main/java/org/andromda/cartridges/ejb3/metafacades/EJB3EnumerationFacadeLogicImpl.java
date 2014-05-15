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

import java.util.Collection;
import org.andromda.metafacades.uml.AttributeFacade;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.ejb3.metafacades.EJB3EnumerationFacade.
 *
 * @see EJB3EnumerationFacade
 */
public class EJB3EnumerationFacadeLogicImpl extends EJB3EnumerationFacadeLogic
{
    private static final long serialVersionUID = 34L;

    /**
     * @param metaObject
     * @param context
     */
    public EJB3EnumerationFacadeLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);
    }

    /**
     * @see EJB3EnumerationFacadeLogic#handleGetMemberVariablesAsList(java.util.Collection, boolean, boolean)
     */
    @Override
    protected String handleGetMemberVariablesAsList(final Collection variables, final boolean includeTypes, final boolean includeNames)
    {
        if (!includeNames && !includeTypes || (variables == null))
        {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String separator = "";

        for (Object obj : variables)
        {
            final AttributeFacade attr = (AttributeFacade) obj;
            sb.append(separator);
            separator = ", ";
            if (includeTypes)
            {
                sb.append(attr.getGetterSetterTypeName());
                sb.append(" ");
            }
            if (includeNames)
            {
                sb.append(attr.getName());
            }
        }
        return sb.toString();
    }
}

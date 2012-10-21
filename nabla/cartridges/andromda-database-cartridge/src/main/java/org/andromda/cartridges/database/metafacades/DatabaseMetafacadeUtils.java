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
package org.andromda.cartridges.database.metafacades;

import org.andromda.metafacades.uml.EntityMetafacadeUtils;
import org.andromda.metafacades.uml.ModelElementFacade;

/**
 * Contains utilities for dealing with some common database metafacade tasks.
 *
 * @author Chad Brandon
 */
public class DatabaseMetafacadeUtils
{

    /**
     * Constructs a SQL identifier (constraint or index) name from the given
     * <code>tableOne</code> and <code>tableTwo</code> model elements.
     * Prefixes each name with the given <code>prefix</code>.
     *
     * @param prefix the object prefixed to the name
     * @param tableOne the first table
     * @param tableTwo the second table
     * @param maxLength the maximum length the name may be
     * @return the identifier name
     */
    public static String toSqlIdentifierName(Object prefix, ModelElementFacade tableOne, ModelElementFacade tableTwo, Short maxLength)
    {

        StringBuffer identifierName = new StringBuffer();

        identifierName.append(prefix);
        identifierName.append(tableOne.getName());

        if (tableTwo != null)
        {

            identifierName.append(tableTwo.getName());

        }

        return EntityMetafacadeUtils.ensureMaximumNameLength(identifierName.toString().toUpperCase(), maxLength);

    }

    /**
     * Constructs a SQL identifier (constraint or index) name from the given
     * <code>table</code> model element. Prefixes each name with the given
     * <code>prefix</code>.
     *
     * @param prefix the object prefixed to the name
     * @param table the table used to construct the name
     * @param maxLength the maximum length the name may be
     * @return the identifier name.
     */
    public static String toSqlIdentifierName(Object prefix, ModelElementFacade table, Short maxLength)
    {

        return toSqlIdentifierName(prefix, table, null, maxLength);

    }

}

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

import org.andromda.cartridges.database.DatabaseGlobals;

import org.andromda.metafacades.uml.EntityAssociationEnd;
import org.andromda.metafacades.uml.UMLMetafacadeProperties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.database.metafacades.AssociationTable.
 *
 * @see org.andromda.cartridges.database.metafacades.AssociationTable
 */
public class AssociationTableLogicImpl extends AssociationTableLogic implements org.andromda.cartridges.database.metafacades.AssociationTable
{

    // ---------------- constructor -------------------------------
    /**
     * Creates a new AssociationTableLogicImpl object.
     *
     * @param metaObject DOCUMENT ME!
     * @param context DOCUMENT ME!
     */
    public AssociationTableLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.AssociationTable#getForeignKeyColumns()
     */
    @Override
    protected java.util.Collection handleGetForeignKeyColumns()
    {

        return this.getAssociationEnds();

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.AssociationTable#getPrimaryKeyColumns()
     */
    @Override
    protected String handleGetPrimaryKeyColumns()
    {

        final StringBuffer columns = new StringBuffer();

        for (final Iterator endIterator = this.getAssociationEnds().iterator(); endIterator.hasNext();)
        {

            final Object object = endIterator.next();

            if (EntityAssociationEnd.class.isAssignableFrom(object.getClass()))
            {

                columns.append(((EntityAssociationEnd) object).getColumnName());

                if (endIterator.hasNext())
                {

                    columns.append(", ");

                }

            }

        }

        return columns.toString();

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.AssociationTable#getPrimaryKeyConstraintName()
     */
    @Override
    protected String handleGetPrimaryKeyConstraintName()
    {

        return DatabaseMetafacadeUtils.toSqlIdentifierName(this.getConfiguredProperty(DatabaseGlobals.PRIMARY_KEY_CONSTRAINT_PREFIX), this, this.getMaxSqlNameLength());

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.AssociationTable#isForeignKeyColumnsPresent()
     */
    @Override
    protected boolean handleIsForeignKeyColumnsPresent()
    {

        return !this.getForeignKeyColumns().isEmpty();

    }

    /**
     * Gets the maximum name length SQL names may be
     */
    public Short getMaxSqlNameLength()
    {

        return Short.valueOf((String) this.getConfiguredProperty(UMLMetafacadeProperties.MAX_SQL_NAME_LENGTH));

    }

    /**
     * Returns the dummy load size for the association table. The dummy load size of a association table is the dummy
     * load size of one of the association ends
     */
    public int getDummyLoadSize()
    {

        int dummyLoadSize = -1;

        // Get the initial load size for this association table, the load size of one of the association ends
        dummyLoadSize = ((ForeignKeyColumn) this.getForeignKeyColumns().toArray()[0]).getImportedTable().getDummyLoadSize();

        return dummyLoadSize;

    }

    /**
     * Returns a flag than indicate if the association table is an enumeration. Actually only returns false, due to an
     * association table can not be an enumeration. So, this service is only for compatibility purposes with the service
     * of the same name in a Table. Both values are used in the same way in the velocity template.
     */
    public boolean isEnumeration()
    {

        return false;

    }

    /**
     * Returns the collection of the none foreign keys that are presented in the association table. Actually only
     * returns an empty collection, due to an association table can not have non foreign key columns. So, this service
     * is only for compatibility purposes with the service of the same name in a Table. Both values are used in the same
     * way in the velocity template.
     */
    public Collection getNonForeignKeyColumns()
    {

        Collection nonForeignKeyColumns;

        nonForeignKeyColumns = new ArrayList();

        nonForeignKeyColumns.clear();

        return nonForeignKeyColumns;

    }

}

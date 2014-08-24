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

import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.UMLMetafacadeProperties;

import java.util.Random;

/**
 * MetafacadeLogic implementation for
 * org.andromda.cartridges.database.metafacades.ForeignKeyColumn.
 * 
 * @see org.andromda.cartridges.database.metafacades.ForeignKeyColumn
 */
public class ForeignKeyColumnLogicImpl extends ForeignKeyColumnLogic implements org.andromda.cartridges.database.metafacades.ForeignKeyColumn
{

    // ---------------- constructor -------------------------------
    /**
     * Creates a new ForeignKeyColumnLogicImpl object.
     * 
     * @param metaObject DOCUMENT ME!
     * @param context DOCUMENT ME!
     */
    public ForeignKeyColumnLogicImpl(Object metaObject, String context)
    {
        super(metaObject, context);

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.ForeignKeyColumn#isCascadeDelete()
     */
    protected boolean handleIsCascadeDelete()
    {

        return this.isComposition() || this.isMany2Many();

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.ForeignKeyColumn#getTable()
     */
    protected java.lang.Object handleGetTable()
    {

        Object table = null;

        if (!this.isMany2Many())
        {

            table = this.getOtherEnd().getType();

        }

        return table;

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.ForeignKeyColumn#getAssociationTable()
     */
    protected java.lang.Object handleGetAssociationTable()
    {

        Object table = null;

        if (this.isMany2Many())
        {

            table = this.getAssociation();

        }

        return table;

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.ForeignKeyColumn#getImportedColumn()
     */
    protected java.lang.Object handleGetImportedTable()
    {

        return this.getType();

    }

    private final static Random RANDOM = new Random();

    /**
     * @see org.andromda.cartridges.database.metafacades.ForeignKeyColumn#getDummyLoadValue(int)
     */
    protected String handleGetDummyLoadValue(int index)
    {

        String initialLoadValue = null;
        Column importedColumn = this.getImportedTable().getPrimaryKeyColumn();

        if (importedColumn != null)
        {

            int randomValue = RANDOM.nextInt(Math.abs(importedColumn.getTable().getDummyLoadSize())) + 1;

            initialLoadValue = importedColumn.getDummyLoadValue(randomValue);

        }

        return initialLoadValue;

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.ForeignKeyColumn#getConstraintName()
     */
    protected String handleGetConstraintName()
    {

        return this.getIdentifierName(DatabaseGlobals.FOREIGN_KEY_CONSTRAINT_PREFIX);

    }

    /**
     * Returns the actual table (i.e. the table or association table depending
     * on what type of association this foreign key column represents.
     * 
     * @return the table or association table.
     */
    private String getIdentifierName(String prefixProperty)
    {

        ModelElementFacade table = this.getTable();

        if (this.getAssociationTable() != null)
        {

            table = this.getAssociationTable();

        }

        return DatabaseMetafacadeUtils.toSqlIdentifierName(this.getConfiguredProperty(prefixProperty), this.getImportedTable(), table, this.getMaxSqlNameLength());

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.ForeignKeyColumn#getIndexName()
     */
    protected String handleGetIndexName()
    {

        return this.getIdentifierName(DatabaseGlobals.INDEX_PREFIX);

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.ForeignKeyColumn#getTableName()
     */
    protected String handleGetTableName()
    {

        StringBuffer tableName = new StringBuffer();

        if (this.getAssociationTable() != null)
        {

            tableName.append(this.getAssociationTable().getTableName());

        } else
        {

            tableName.append(this.getTable().getTableName());

        }

        return tableName.toString();

    }

    /**
     * Gets the maximum name length SQL names may be
     */
    private Short getMaxSqlNameLength()
    {

        return Short.valueOf((String) this.getConfiguredProperty(UMLMetafacadeProperties.MAX_SQL_NAME_LENGTH));

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.ForeignKeyColumn#getImportedPrimaryKeyColumn()
     */
    protected Object handleGetImportedPrimaryKeyColumn()
    {

        return this.getImportedTable().getPrimaryKeyColumn();

    }

    /**
     * Override to make many-to-many relations always required.
     * 
     * @see org.andromda.metafacades.uml.AssociationEndFacade#isRequired()
     */
    public boolean isRequired()
    {

        return super.isRequired() || super.isMany2Many();

    }

}

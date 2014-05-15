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

import org.andromda.metafacades.uml.AssociationEndFacade;
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.EntityAssociationEnd;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.UMLMetafacadeProperties;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * MetafacadeLogic implementation for
 * org.andromda.cartridges.database.metafacades.DataColumn.
 *
 * @see org.andromda.cartridges.database.metafacades.DataColumn
 */
public class ColumnLogicImpl extends ColumnLogic implements org.andromda.cartridges.database.metafacades.Column
{

    // ---------------- constructor -------------------------------
    /**
     * Creates a new ColumnLogicImpl object.
     *
     * @param metaObject DOCUMENT ME!
     * @param context DOCUMENT ME!
     */
    public ColumnLogicImpl(Object metaObject, String context)
    {
        super(metaObject, context);

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.DataColumn#getTable()
     */
    protected java.lang.Object handleGetTable()
    {

        return this.getOwner();

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.PrimaryKeyColumn#getExportedColumns()
     */
    protected java.util.Collection handleGetExportedColumns()
    {

        Collection exportedColumns = new HashSet();

        Collection associationEnds = getTable().getAssociationEnds();

        for (Iterator iterator = associationEnds.iterator(); iterator.hasNext();)
        {

            AssociationEndFacade associationEnd = (AssociationEndFacade) iterator.next();

            if (associationEnd.isOne2Many())
            {

                exportedColumns.add(associationEnd.getOtherEnd());

            }

        }

        return exportedColumns;

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.PrimaryKeyColumn#getImportingTables()
     */
    protected java.util.Collection handleGetImportingTables()
    {

        Collection importingTables = new HashSet();

        Collection exportedColumns = getExportedColumns();

        for (Iterator iterator = exportedColumns.iterator(); iterator.hasNext();)
        {

            ForeignKeyColumn foreignKeyColumn = (ForeignKeyColumn) iterator.next();

            importingTables.add(foreignKeyColumn.getTable());

        }

        return importingTables;

    }

    private final static DateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * @see org.andromda.cartridges.database.metafacades.NonForeignKeyColumn#getDummyLoadValue(int)
     */
    protected String handleGetDummyLoadValue(int index)
    {

        String dummyLoadValue = null;

        final ClassifierFacade metaType = getType();
        final String type = metaType.getFullyQualifiedName(true);

        if ("datatype::String".equals(type))
        {

            dummyLoadValue = getName() + '-' + index;

        } else if ("datatype::boolean".equals(type))
        {

            dummyLoadValue = String.valueOf((index % 2) == 0);

        } else if ("datatype::int".equals(type) || "datatype::Integer".equals(type) || "datatype::short".equalsIgnoreCase(type) || "datatype::long".equalsIgnoreCase(type))
        {

            dummyLoadValue = String.valueOf(index);

        } else if ("datatype::float".equalsIgnoreCase(type) || "datatype::double".equalsIgnoreCase(type))
        {

            dummyLoadValue = String.valueOf(index) + ".555";

        } else if ("datatype::char".equals(type) || "datatype::Character".equals(type))
        {

            dummyLoadValue = Character.toString((char) index);

        } else if ("datatype::Date".equals(type) || "datatype::DateTime".equals(type))
        {

            dummyLoadValue = DATE_FORMATTER.format(new Date());

        } else if (metaType.isEnumeration())
        {

            List literals = new ArrayList(getType().getAttributes());
            AttributeFacade literal = (AttributeFacade) literals.get(index % literals.size());

            dummyLoadValue = literal.getName();

        } else
        {

            dummyLoadValue = "\'error\'";

        }

        final String maxLengthString = getColumnLength();
        int maxLength = 0;
        int dummyValueLength = dummyLoadValue.length();

        try
        {

            maxLength = Integer.parseInt(maxLengthString);

        }
        catch (Exception ex)
        {

            maxLength = 0;

        }

        if ((maxLength > 0) && (dummyValueLength > maxLength))
        {

            int startIndex = dummyLoadValue.length() - maxLength;

            dummyLoadValue = dummyLoadValue.substring(startIndex);

        }

        if (needsQuotes(metaType))
        {

            dummyLoadValue = '\'' + dummyLoadValue + '\'';

        }

        return dummyLoadValue;

    }

    private boolean needsQuotes(final ClassifierFacade metaType)
    {

        final String type = metaType.getFullyQualifiedName(true);

        return (type == null) || "datatype::String".equals(type) || "datatype::boolean".equals(type) || "datatype::char".equals(type) || "datatype::Character".equals(type) || "datatype::Date".equals(type)
                || "datatype::DateTime".equals(type) || metaType.isEnumeration();

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.NonForeignKeyColumn#isPrimaryKey()
     */
    protected boolean handleIsPrimaryKey()
    {

        return isIdentifier();

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.ColumnLogic#handleGetTableName()
     */
    protected String handleGetTableName()
    {

        String tableName = null;

        if (this.getTable() != null)
        {

            tableName = this.getTable().getTableName();

        }

        return tableName;

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.ColumnLogic#handleGetConstraintName()
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

        return DatabaseMetafacadeUtils.toSqlIdentifierName(this.getConfiguredProperty(prefixProperty), this.getImportedTable(), table, this.getMaxSqlNameLength());

    }

    /**
     * Gets the maximum name length SQL names may be
     */
    private Short getMaxSqlNameLength()
    {

        return Short.valueOf((String) this.getConfiguredProperty(UMLMetafacadeProperties.MAX_SQL_NAME_LENGTH));

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.ColumnLogic#handleGetImportedTable()
     */
    protected Object handleGetImportedTable()
    {

        Table table = null;
        EntityAssociationEnd end = this.getForeignIdentifierEnd();

        if ((end != null) && EntityAssociationEnd.class.isAssignableFrom(end.getOtherEnd().getClass()))
        {

            table = (Table) end.getOtherEnd().getType();

        }

        return table;

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.Column#isCascadeDelete()
     */
    protected boolean handleIsCascadeDelete()
    {

        boolean cascadeDelete = false;
        AssociationEndFacade end = this.getForeignIdentifierEnd();

        if (end != null)
        {

            cascadeDelete = end.getOtherEnd().isComposition();

        }

        return cascadeDelete;

    }

    /**
     * Gets the association end that has the foreign identifier
     * flag set (if there is one).
     * @return the foreign identifier association end or null if
     *         on can't be found.
     */
    private EntityAssociationEnd getForeignIdentifierEnd()
    {

        EntityAssociationEnd end = (EntityAssociationEnd) CollectionUtils.find(this.getOwner().getAssociationEnds(), new Predicate()
        {

            public boolean evaluate(Object object)
            {

                AssociationEndFacade end = (AssociationEndFacade) object;
                boolean valid = false;

                if ((end != null) && EntityAssociationEnd.class.isAssignableFrom(end.getClass()))
                {

                    valid = ((EntityAssociationEnd) end).isForeignIdentifier();

                }

                return valid;

            }

        });

        return end;

    }

}

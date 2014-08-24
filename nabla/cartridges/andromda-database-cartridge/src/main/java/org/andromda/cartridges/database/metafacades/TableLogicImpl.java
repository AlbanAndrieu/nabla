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
import org.andromda.cartridges.database.DatabaseProfile;

import org.andromda.core.metafacade.MetafacadeFactoryException;

import org.andromda.metafacades.uml.AssociationEndFacade;
import org.andromda.metafacades.uml.EntityAssociationEnd;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * MetafacadeLogic implementation for
 * org.andromda.cartridges.database.metafacades.Table.
 * 
 * @see org.andromda.cartridges.database.metafacades.Table
 */
public class TableLogicImpl extends TableLogic implements org.andromda.cartridges.database.metafacades.Table
{

    /**
     * The logger instance.
     */
    private final Logger logger_ = Logger.getLogger(TableLogicImpl.class);

    // ---------------- constructor -------------------------------
    /**
     * Creates a new TableLogicImpl object.
     * 
     * @param metaObject DOCUMENT ME!
     * @param context DOCUMENT ME!
     */
    public TableLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.Table#getInitialLoadSize()
     */
    @Override
    protected int handleGetDummyLoadSize()
    {

        /*
         * comment out until enumeration support is added. for enumerations we
         * always have a fixed size if (isEnumeration()) { return
         * getLiterals().size(); }
         */
        int dummyLoadSize = -1;
        float dummyLoadMultiplier = -1;

        // first get the initial load size for this table
        try
        {

            final String dummyLoadSizeString = (String) this.findTaggedValue(DatabaseProfile.TAGGEDVALUE_DUMMYLOAD_SIZE);

            if (dummyLoadSizeString != null)
            {

                dummyLoadSize = Integer.parseInt(dummyLoadSizeString);

            }

        } catch (final Exception e)
        {

            // do nothing, let the 'finally' clause handle it
        } finally
        {

            if (dummyLoadSize < 0)
            {

                dummyLoadSize = DatabaseProfile.DUMMY_LOAD_SIZE_DEFAULT;

            }

        }

        if (dummyLoadSize > 0)
        {

            try
            {

                final String multiplierString = (String) this.getConfiguredProperty(DatabaseGlobals.DUMMYLOAD_MULTIPLIER);

                if (multiplierString != null)
                {

                    dummyLoadMultiplier = Float.parseFloat(multiplierString);

                }

            } catch (final MetafacadeFactoryException mfe)
            {

                // this means the namespace property has not been registered
                this.logger_.info("Namespace property \'" + DatabaseGlobals.DUMMYLOAD_MULTIPLIER + "\' not specified, using default value " + DatabaseGlobals.DUMMYLOAD_MULTIPLIER_DEFAULT);
                dummyLoadMultiplier = DatabaseGlobals.DUMMYLOAD_MULTIPLIER_DEFAULT;

            } catch (final Exception e)
            {

                // this means the property has been registered with an invalid value
                this.logger_.warn("Invalid namespace property value for \'" + DatabaseGlobals.DUMMYLOAD_MULTIPLIER + "\', using default value " + DatabaseGlobals.DUMMYLOAD_MULTIPLIER_DEFAULT + " instead of "
                        + this.getConfiguredProperty(DatabaseGlobals.DUMMYLOAD_MULTIPLIER));
                dummyLoadMultiplier = DatabaseGlobals.DUMMYLOAD_MULTIPLIER_DEFAULT;

            }

            dummyLoadSize = (int) Math.ceil(dummyLoadSize * dummyLoadMultiplier);

        }

        return dummyLoadSize;

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.Table#getForeignKeyColumns()
     */
    @Override
    protected java.util.Collection handleGetForeignKeyColumns()
    {

        final Collection foreignKeyColumns = new ArrayList();

        final Collection associationEnds = this.getAssociationEnds();

        for (final Iterator iterator = associationEnds.iterator(); iterator.hasNext();)
        {

            final AssociationEndFacade end = (AssociationEndFacade) iterator.next();

            if (ForeignKeyColumn.class.isAssignableFrom(end.getClass()))
            {

                final ForeignKeyColumn column = (ForeignKeyColumn) end;
                final ForeignKeyColumn otherEnd = (ForeignKeyColumn) end.getOtherEnd();
                final boolean thisSideNavigable = column.isNavigable() && !otherEnd.isNavigable();
                final boolean aggregationPresent = end.isAggregation() || end.isComposition();
                final boolean otherEndAggregationPresent = otherEnd.isAggregation() || otherEnd.isComposition();
                final boolean one2One = end.isOne2One() && ((aggregationPresent && !otherEnd.isForeignIdentifier()) || column.isForeignIdentifier() || (!otherEndAggregationPresent && thisSideNavigable));

                if (end.isMany2One() || one2One)
                {

                    if (column.isForeignIdentifier())
                    {

                        final Column foreignColumn = this.getIdentifierForeignKeyColumns().iterator().next();

                        foreignKeyColumns.add(foreignColumn);

                    } else
                    {

                        foreignKeyColumns.add(otherEnd);

                    }

                }

            }

        }

        return foreignKeyColumns;

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.Table#getPrimaryKeyColumns()
     */
    @Override
    protected Object handleGetPrimaryKeyColumn()
    {

        final Collection identifiers = this.getIdentifiers();

        return identifiers.isEmpty() ? null : identifiers.iterator().next();

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.Table#getImportingTables()
     */
    @Override
    protected java.util.Collection handleGetImportingTables()
    {

        final Collection importingTables = new HashSet();

        final Collection associationEnds = this.getAssociationEnds();

        for (final Iterator iterator = associationEnds.iterator(); iterator.hasNext();)
        {

            final AssociationEndFacade associationEnd = (AssociationEndFacade) iterator.next();

            if (associationEnd.isOne2Many())
            {

                importingTables.add(associationEnd.getOtherEnd().getType());

            }

        }

        return importingTables;

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.Table#getImportedTables()
     */
    @Override
    protected java.util.Collection handleGetImportedTables()
    {

        final Collection importedTables = new HashSet();

        final Collection foreignKeyColumns = this.getForeignKeyColumns();

        for (final Iterator iterator = foreignKeyColumns.iterator(); iterator.hasNext();)
        {

            final ForeignKeyColumn foreignKeyColumn = (ForeignKeyColumn) iterator.next();

            importedTables.add(foreignKeyColumn.getTable());

        }

        return importedTables;

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.Table#isForeignKeyColumnsPresent()
     */
    @Override
    protected boolean handleIsForeignKeyColumnsPresent()
    {

        return !this.getForeignKeyColumns().isEmpty();

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.Table#getPrimaryKeyConstraintName()
     */
    @Override
    protected String handleGetPrimaryKeyConstraintName()
    {

        return DatabaseMetafacadeUtils.toSqlIdentifierName(this.getConfiguredProperty(DatabaseGlobals.PRIMARY_KEY_CONSTRAINT_PREFIX), this, this.getMaxSqlNameLength());

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.Table#getNonForeignKeyColumns()
     */
    @Override
    protected Collection handleGetNonForeignKeyColumns()
    {

        return this.getAttributes();

    }

    /**
     * @see org.andromda.cartridges.database.metafacades.Table#getIdentifierForeignKeyColumns()
     */
    @Override
    protected Collection handleGetIdentifierForeignKeyColumns()
    {

        Collection columns = null;
        final EntityAssociationEnd end = (EntityAssociationEnd) CollectionUtils.find(this.getAssociationEnds(), new Predicate()
        {

            @Override
            public boolean evaluate(final Object object)
            {

                boolean valid = false;

                if (EntityAssociationEnd.class.isAssignableFrom(object.getClass()))
                {

                    valid = ((EntityAssociationEnd) object).isForeignIdentifier();

                }

                return valid;

            }

        });

        if ((end != null) && EntityAssociationEnd.class.isAssignableFrom(end.getClass()))
        {

            columns = ((Table) end.getType()).getIdentifiers();

        }

        return columns;

    }

    @Override
    protected Collection handleGetColumns()
    {

        Collection columns = null;

        if (this.isForeignKeyColumnsPresent())
        {

            columns = new ArrayList();
            columns.addAll(this.getForeignKeyColumns());
            columns.addAll(this.getNonForeignKeyColumns());

        } else
        {

            columns = this.getNonForeignKeyColumns();

        }

        return columns;

    }

}

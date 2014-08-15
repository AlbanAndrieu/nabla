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
import java.util.Iterator;
import java.util.List;
import org.andromda.metafacades.uml.AssociationEndFacade;
import org.andromda.metafacades.uml.Entity;
import org.andromda.metafacades.uml.MetafacadeUtils;
import org.andromda.metafacades.uml.UMLMetafacadeProperties;
import org.andromda.metafacades.uml.UMLProfile;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.ejb3.metafacades.EJB3AssociationFacade.
 * 
 * @see EJB3AssociationFacade
 */
public class EJB3AssociationFacadeLogicImpl extends EJB3AssociationFacadeLogic
{
    private static final long serialVersionUID = 34L;

    // ---------------- constructor -------------------------------

    /**
     * @param metaObject
     * @param context
     */
    public EJB3AssociationFacadeLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);
    }

    // --------------- methods ---------------------

    /**
     * Override to provide support for One-2-Many unidirectional associations as well as Many-2-Many.
     * Returns the EJB3 cartridge specific table name for the association
     * 
     * @return table name
     */
    @Override
    public String getTableName()
    {
        String tableName = null;
        final List<AssociationEndFacade> ends = this.getAssociationEnds();
        if (ends != null && !ends.isEmpty())
        {
            for (AssociationEndFacade facade : ends)
            {
                final EJB3AssociationEndFacade end = (EJB3AssociationEndFacade) facade;
                if ((end.isMany2Many() && end.isOwning()) || (end.isOne2Many() && !end.isNavigable() && end.getOtherEnd().isNavigable()))
                {
                    // prevent ClassCastException if the association isn't an
                    // Entity
                    if (Entity.class.isAssignableFrom(end.getType().getClass()))
                    {
                        final String prefixProperty = UMLMetafacadeProperties.TABLE_NAME_PREFIX;
                        final String tableNamePrefix = this.isConfiguredProperty(prefixProperty) ? ObjectUtils.toString(this.getConfiguredProperty(prefixProperty)) : null;
                        tableName = EJB3MetafacadeUtils.getSqlNameFromTaggedValue(tableNamePrefix, this, UMLProfile.TAGGEDVALUE_PERSISTENCE_TABLE, ((Entity) end.getType()).getMaxSqlNameLength(), null,
                                this.getConfiguredProperty(UMLMetafacadeProperties.SQL_NAME_SEPARATOR));
                    }
                    break;
                }
            }
        }

        // if (StringUtils.isNotBlank(tableName) && getName().toLowerCase().startsWith(tableName.toLowerCase()))
        // {
        // tableName = getRelationName().replaceAll("-", "_").toUpperCase();
        // }

        return tableName;
    }

    /**
     * Override the default implementation to use the current getRelationName implementation
     * 
     * @return name
     */
    @Override
    public String getName()
    {
        String name = (super.getName().equalsIgnoreCase(super.getRelationName()) ? null : super.getName());

        // if the name isn't defined, use the this implementation of relation name
        if (StringUtils.isBlank(name))
        {
            name = this.getRelationName();
        }
        return name;
    }

    /**
     * Override the default implementation to set the owning side name first followed by inverse side.
     * If there is no owning side defined, then adopt the default logic of using alphabetical ordering.
     * 
     * @return relation name
     */
    @Override
    public String getRelationName()
    {
        final Collection<AssociationEndFacade> ends = this.getAssociationEnds();
        final Iterator endIt = ends.iterator();
        final EJB3AssociationEndFacade firstEnd = (EJB3AssociationEndFacade) endIt.next();
        final EJB3AssociationEndFacade secondEnd = (EJB3AssociationEndFacade) endIt.next();
        final String separator = String.valueOf(this.getConfiguredProperty(UMLMetafacadeProperties.RELATION_NAME_SEPARATOR));

        if (secondEnd.isOwning())
        {
            return secondEnd.getName() + separator + firstEnd.getName();
        } else if (firstEnd.isOwning())
        {
            return firstEnd.getName() + separator + secondEnd.getName();
        } else
        {
            return MetafacadeUtils.toRelationName(firstEnd.getName(), secondEnd.getName(), separator);
        }
    }
}

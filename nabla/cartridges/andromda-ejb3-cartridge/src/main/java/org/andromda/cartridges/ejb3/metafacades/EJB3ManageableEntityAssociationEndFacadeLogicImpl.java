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

import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.utils.StringUtilsHelper;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityAssociationEndFacade.
 *
 * @see EJB3ManageableEntityAssociationEndFacade
 */
public class EJB3ManageableEntityAssociationEndFacadeLogicImpl extends EJB3ManageableEntityAssociationEndFacadeLogic
{
    private static final long serialVersionUID = 34L;

    /**
     * Public constructor for SpringManageableEntityAssociationEndLogicImpl
     * @param metaObject
     * @param context
     * @see EJB3ManageableEntityAssociationEnd
     */
    public EJB3ManageableEntityAssociationEndFacadeLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);
    }

    /**
     * @return StringUtilsHelper.lowerCamelCaseName(this.getName()) + "Dao"
     * @see EJB3ManageableEntityAssociationEnd#getDaoName()
     */
    protected String handleGetDaoName()
    {
        return StringUtilsHelper.lowerCamelCaseName(this.getName()) + "Dao";
    }

    /**
     * @return getType().getBeanName(false)
     * @see EJB3ManageableEntityAssociationEnd#getDaoReferenceName()
     */
    protected String handleGetDaoReferenceName()
    {
        String referenceName = null;

        final ClassifierFacade type = this.getType();
        if (type instanceof EJB3EntityFacade)
        {
            final EJB3EntityFacade entity = (EJB3EntityFacade) type;
            referenceName = entity.getBeanName(false);
        }

        return referenceName;
    }

    /**
     * @return getGetterName() + "Dao"
     * @see EJB3ManageableEntityAssociationEnd#getDaoGetterName()
     */
    protected String handleGetDaoGetterName()
    {
        return this.getGetterName() + "Dao";
    }

    /**
     * @return getSetterName() + "Dao"
     * @see EJB3ManageableEntityAssociationEnd#getDaoSetterName()
     */
    protected String handleGetDaoSetterName()
    {
        return this.getSetterName() + "Dao";
    }

}

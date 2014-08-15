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

import org.andromda.cartridges.ejb3.EJB3Globals;
import org.andromda.cartridges.ejb3.EJB3Profile;
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.apache.commons.lang.StringUtils;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.ejb3.metafacades.EJB3FinderMethodArgumentFacade.
 * 
 * @see EJB3FinderMethodArgumentFacade
 */
public class EJB3FinderMethodArgumentFacadeLogicImpl extends EJB3FinderMethodArgumentFacadeLogic
{
    private static final long serialVersionUID = 34L;

    /**
     * @param metaObject
     * @param context
     */
    public EJB3FinderMethodArgumentFacadeLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);
    }

    /**
     * @see EJB3FinderMethodArgumentFacade#getTemporalType()
     */
    @Override
    protected String handleGetTemporalType()
    {
        String temporalType = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_PERSISTENCE_TEMPORAL_TYPE);
        if (StringUtils.isBlank(temporalType))
        {
            ClassifierFacade classifier = this.getType();
            if (classifier != null)
            {
                if (!classifier.isPrimitive())
                {
                    if (classifier.isDateType())
                    {
                        temporalType = EJB3Globals.TEMPORAL_TYPE_DATE;
                    } else if (classifier.isTimeType())
                    {
                        temporalType = EJB3Globals.TEMPORAL_TYPE_TIME;
                    } else if ("Timestamp".equals(classifier.getName()))
                    {
                        temporalType = EJB3Globals.TEMPORAL_TYPE_TIMESTAMP;
                    }
                }
            }
        }
        return temporalType;
    }

    /**
     * @see EJB3FinderMethodArgumentFacadeLogic#handleIsFirstResult()
     */
    @Override
    protected boolean handleIsFirstResult()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_FINDER_RESULT_TYPE_FIRST);
    }

    /**
     * @see EJB3FinderMethodArgumentFacadeLogic#handleIsMaxResults()
     */
    @Override
    protected boolean handleIsMaxResults()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_FINDER_RESULT_TYPE_MAX);
    }

    /**
     * @see EJB3FinderMethodArgumentFacadeLogic#handleIsEnumerationTypeOrdinal()
     */
    @Override
    protected boolean handleIsEnumerationTypeOrdinal()
    {
        boolean ordinalType = false;
        if (this.getType().isEnumeration())
        {
            AttributeFacade literal = this.getType().getAttributes().iterator().next();
            if (!literal.getType().isStringType())
            {
                ordinalType = true;
            }
        }
        return ordinalType;
    }

    /**
     * @see EJB3FinderMethodArgumentFacadeLogic#handleIsEnumerationTypeString()
     */
    @Override
    protected boolean handleIsEnumerationTypeString()
    {
        boolean stringType = false;
        if (this.getType().isEnumeration())
        {
            AttributeFacade literal = this.getType().getAttributes().iterator().next();
            if (literal.getType().isStringType())
            {
                stringType = true;
            }
        }
        return stringType;
    }
}

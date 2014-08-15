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

import org.andromda.cartridges.ejb3.EJB3Profile;
import org.andromda.metafacades.uml.ParameterFacade;
import org.andromda.metafacades.uml.UMLProfile;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceOperationFacade.
 * 
 * @see EJB3WebServiceOperationFacade
 */
public class EJB3WebServiceOperationFacadeLogicImpl extends EJB3WebServiceOperationFacadeLogic
{
    private static final long   serialVersionUID = 34L;
    /**
     * The logger instance.
     */
    private static final Logger logger           = Logger.getLogger(EJB3WebServiceOperationFacadeLogicImpl.class);

    /**
     * @param metaObject
     * @param context
     */
    public EJB3WebServiceOperationFacadeLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);
    }

    /**
     * @see EJB3WebServiceOperationFacade#isExposed()
     */
    @Override
    protected boolean handleIsExposed()
    {
        return this.getOwner().hasStereotype(UMLProfile.STEREOTYPE_WEBSERVICE) || this.hasStereotype(UMLProfile.STEREOTYPE_WEBSERVICE_OPERATION);
    }

    /**
     * @see EJB3WebServiceOperationFacadeLogic#handleIsOneway()
     */
    @Override
    protected boolean handleIsOneway()
    {
        return BooleanUtils.toBoolean((String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_WEBSERVICE_OPERATION_ONEWAY));
    }

    /**
     * @see EJB3WebServiceOperationFacadeLogic#getAnnotatedSignature()
     */
    @Override
    protected String handleGetAnnotatedSignature()
    {
        final StringBuilder signature = new StringBuilder(this.getName());
        signature.append("(");
        signature.append(this.getAnnotatedTypedArgumentList(true, null));
        signature.append(")");
        return signature.toString();
    }

    /**
     * @param withArgumentNames
     * @param modifier
     * @return
     */
    private String getAnnotatedTypedArgumentList(final boolean withArgumentNames, final String modifier)
    {
        final StringBuilder buffer = new StringBuilder();
        boolean commaNeeded = false;
        for (ParameterFacade paramter : this.getArguments())
        {
            String type = null;
            if (paramter.getType() == null)
            {
                EJB3WebServiceOperationFacadeLogicImpl.logger.error("ERROR! No type specified for parameter --> '" + paramter.getName() + "' on operation --> '" + this.getName() + "', please check your model");
            } else
            {
                type = paramter.getGetterSetterTypeName();
            }

            if (commaNeeded)
            {
                buffer.append(",");
            }
            buffer.append('\n');

            // Add WebParam annotation
            if (withArgumentNames)
            {
                buffer.append("        @javax.jws.WebParam(name = \"");
                buffer.append(StringUtils.capitalize(paramter.getName())).append("\")");
                buffer.append(" ");
            }
            if (StringUtils.isNotBlank(modifier))
            {
                buffer.append(modifier);
                buffer.append(" ");
            }
            buffer.append(type);
            if (withArgumentNames)
            {
                buffer.append(" ");
                buffer.append(paramter.getName());
            }
            commaNeeded = true;
        }
        buffer.append('\n');
        if (commaNeeded)
        {
            buffer.append("    ");
        }
        return buffer.toString();
    }

    /**
     * @see EJB3WebServiceOperationFacadeLogic#handleGetMethodName()
     */
    @Override
    protected String handleGetMethodName()
    {
        String methodName = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_WEBSERVICE_OPERATION_NAME);
        if (StringUtils.isBlank(methodName))
        {
            methodName = StringUtils.capitalize(this.getName());
        }
        return methodName;
    }

    /**
     * @see EJB3WebServiceOperationFacadeLogic#handleGetResultName()
     */
    @Override
    protected String handleGetResultName()
    {
        return (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_WEBSERVICE_OPERATION_RESULT_NAME);
    }
}

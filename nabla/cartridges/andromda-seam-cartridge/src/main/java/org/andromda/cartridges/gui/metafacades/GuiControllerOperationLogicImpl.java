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
package org.andromda.cartridges.gui.metafacades;

import org.andromda.cartridges.gui.GuiGlobals;

import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ParameterFacade;
import org.andromda.metafacades.uml.ServiceOperation;

import org.andromda.utils.StringUtilsHelper;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiControllerOperation.
 *
 * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation
 */
public class GuiControllerOperationLogicImpl extends GuiControllerOperationLogic
{

    private static final long serialVersionUID = 34L;

    /**
     * @param metaObject
     * @param context
     */
    public GuiControllerOperationLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * @return formName
     * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#getFormName()
     */
    @Override
    protected String handleGetFormName()
    {

        final String pattern = ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.FORM_PATTERN));

        return pattern.replaceFirst("\\{0\\}", StringUtils.capitalize(this.getName()));

    }

    /**
     * @return fullyQualifiedFormName
     * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#getFullyQualifiedFormName()
     */
    @Override
    protected String handleGetFullyQualifiedFormName()
    {

        final StringBuilder fullyQualifiedName = new StringBuilder();
        final String packageName = this.getPackageName();

        if (StringUtils.isNotBlank(packageName))
        {

            fullyQualifiedName.append(packageName + ".");

        }

        return fullyQualifiedName.append(StringUtils.capitalize(this.getFormName())).toString();

    }

    /**
     * @return getFullyQualifiedFormName().replace(".", GuiGlobals.SEPARATOR)
     * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#getFullyQualifiedFormPath()
     */
    @Override
    protected String handleGetFullyQualifiedFormPath()
    {

        return this.getFullyQualifiedFormName().replace(".", GuiGlobals.SEPARATOR);

    }

    /**
     * @return formCall
     * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#getFormCall()
     */
    @Override
    protected String handleGetFormCall()
    {

        final StringBuilder call = new StringBuilder();

        call.append(this.getName());
        call.append("(");

        if (!this.getFormFields().isEmpty())
        {

            call.append("form");

        }

        call.append(")");

        return call.toString();

    }

    /**
     * @return getFormSignature(false)
     * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#getImplementationFormSignature()
     */
    @Override
    protected String handleGetImplementationFormSignature()
    {

        return this.getFormSignature(false);

    }

    /**
     * @return getFormSignature(true)
     * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#getFormSignature()
     */
    @Override
    protected String handleGetFormSignature()
    {

        return this.getFormSignature(true);

    }

    /**
     * Constructs the signature that takes the form for this operation.
     *
     * @param isAbstract whether or not the signature is abstract.
     * @return the appropriate signature.
     */
    private String getFormSignature(final boolean isAbstract)
    {

        final StringBuilder signature = new StringBuilder();

        signature.append(this.getVisibility() + ' ');

        if (isAbstract)
        {

            signature.append("abstract ");

        }

        final ModelElementFacade returnType = this.getReturnType();

        signature.append((returnType != null) ? returnType.getFullyQualifiedName() : null);
        signature.append(" " + this.getName() + "(");

        if (!this.getFormFields().isEmpty())
        {

            signature.append(this.getFormName() + " form");

        }

        signature.append(")");

        return signature.toString();

    }

    @Override
    protected java.lang.Object handleGetController()
    {

        final Object owner = this.getOwner();

        return (owner instanceof GuiController) ? owner : null;

    }

    @Override
    protected boolean handleIsBackEndServiceOperationMatchingParameters()
    {

        boolean matches = true;

        final ServiceOperation serviceOperation = this.getBackEndServiceOperation();

        // cache this operation's parameters for easy lookup
        final Map<String, ClassifierFacade> parameterMap = new HashMap<String, ClassifierFacade>();
        final Collection<ParameterFacade> controllerParameters = this.getParameters();

        for (final ParameterFacade parameterFacade : controllerParameters)
        {

            final ParameterFacade parameter = parameterFacade;

            parameterMap.put(parameter.getName(), parameter.getType());

        }

        // make sure that any service parameter exists here too
        final Collection<ParameterFacade> serviceParameters = serviceOperation.getParameters();

        for (final Iterator<ParameterFacade> iterator = serviceParameters.iterator(); iterator.hasNext() && matches;)
        {

            final ParameterFacade serviceParameter = iterator.next();
            final ClassifierFacade controllerParameterType = parameterMap.get(serviceParameter.getName());

            matches = (controllerParameterType != null) && controllerParameterType.equals(serviceParameter.getType());

        }

        return matches;

    }

    @Override
    protected java.lang.Object handleGetBackEndServiceOperation()
    {

        final Object owner = this.getOwner();

        return (owner instanceof GuiController) ? owner : null;

    }

    @Override
    protected boolean handleIsCallingBackEnd()
    {

        return this.getBackEndServiceOperation() != null;

    }

    @Override
    protected java.lang.String handleGetInterfaceName()
    {

        return StringUtilsHelper.upperCamelCaseName(this.getName()) + GuiGlobals.FORM_SUFFIX;

    }

    @Override
    protected java.lang.String handleGetInterfacePackageName()
    {

        return this.getOwner().getPackageName();

    }

    @Override
    protected java.lang.String handleGetInterfaceType()
    {

        return this.getInterfacePackageName() + "." + this.getInterfaceName();

    }

    @Override
    protected java.lang.String handleGetInterfaceFullPath()
    {

        return GuiGlobals.SEPARATOR + this.getInterfaceType().replace(".", GuiGlobals.SEPARATOR);

    }

}

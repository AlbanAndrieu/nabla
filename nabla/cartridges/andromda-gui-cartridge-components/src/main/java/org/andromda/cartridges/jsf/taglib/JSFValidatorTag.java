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
package org.andromda.cartridges.jsf.taglib;

import org.andromda.cartridges.jsf.component.JSFValidatorComponent;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.webapp.UIComponentTag;

/**
 * The tag class for the <code>s:validatorScript</code> tag.
 */
public class JSFValidatorTag extends UIComponentTag
{

    /**
     * Whether or not client side validation should be enabled
     */
    private String client;

    /**
     * Sets whether or not client side validation shall be enabled.
     *
     * @param clientIn a true/false string.
     */
    public void setClient(final String clientIn)
    {

        this.client = clientIn;

    }

    /**
     * Sets properties for the component.
     *
     * @param component The component whose properties we're setting
     */
    @Override
    public void setProperties(final UIComponent component)
    {

        super.setProperties(component);

        final String attributeName = JSFValidatorComponent.CLIENT;
        final String attributeValue = this.client;

        if (attributeValue != null)
        {

            if (UIComponentTag.isValueReference(this.client))
            {

                final FacesContext context = FacesContext.getCurrentInstance();
                final Application application = context.getApplication();
                final ValueBinding binding = application.createValueBinding(attributeValue);

                component.setValueBinding(attributeName, binding);

            } else
            {

                component.getAttributes().put(attributeName, attributeValue);

            }

        }

        final String validatorId = this.getId();

        if (validatorId != null)
        {

            component.setId(validatorId);

        }

    }

    /**
     * Sets the <code>client</code> property to null.
     *
     * @see javax.servlet.jsp.tagext.Tag#release()
     */
    @Override
    public void release()
    {

        super.release();
        this.client = null;

    }

    /**
     * Returns the renderer type, which is null.
     */
    @Override
    public String getRendererType()
    {

        return null;

    }

    /**
     * The component type.
     */
    private static final String COMPONENT_TYPE = JSFValidatorComponent.class.getName();

    /**
     * Returns the component type, which is
     * <code>org.andromda.cartridges.jsf.component.JSFValidatorScript</code>.
     */
    @Override
    public String getComponentType()
    {

        return COMPONENT_TYPE;

    }

}

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
package org.andromda.cartridges.jsf.utils;

import org.apache.commons.lang.ObjectUtils;

import java.lang.reflect.Method;

import javax.faces.component.UICommand;
import javax.faces.component.UIComponent;
import javax.faces.component.UIGraphic;
import javax.faces.component.UIParameter;
import javax.faces.component.UISelectBoolean;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.webapp.UIComponentTag;

/**
 * Utilities for dealing with the JSF components.
 * 
 * @author Chad Brandon
 */
public class ComponentUtils
{

    /**
     * Sets the value property of a component.
     * 
     * @param context the current faces context.
     * @param component the component.
     * @param value the value to set.
     */
    public static void setValueProperty(final FacesContext context, final UIComponent component, final String value)
    {

        if (value != null)
        {

            if (UIComponentTag.isValueReference(value))
            {

                final ValueBinding binding = context.getApplication().createValueBinding(value);

                component.setValueBinding("value", binding);

            } else if (component instanceof UICommand)
            {

                ((UICommand) component).setValue(value);

            } else if (component instanceof UIParameter)
            {

                ((UIParameter) component).setValue(value);

            } else if (component instanceof UISelectBoolean)
            {

                ((UISelectBoolean) component).setValue(Boolean.valueOf(value));

            } else if (component instanceof UIGraphic)
            {

                ((UIGraphic) component).setValue(value);

            } else if (component instanceof ValueHolder)
            {

                ((ValueHolder) component).setValue(value);

            }

        }

    }

    /**
     * Sets the property with the given <code>name</code> of a component.
     * 
     * @param name the name of the component to set.
     * @param context the current faces context.
     * @param component the component.
     * @param value the value to set.
     */
    public static void setStringProperty(final String name, final FacesContext context, final UIComponent component, final String value)
    {

        if (value != null)
        {

            if (UIComponentTag.isValueReference(value))
            {

                final ValueBinding binding = context.getApplication().createValueBinding(value);

                component.setValueBinding(name, binding);

            } else
            {

                component.getAttributes().put(name, value);

            }

        }

    }

    /**
     * Sets the boolean value of property with the given <code>name</code> of a component.
     * 
     * @param name the name of the component to set.
     * @param context the current faces context.
     * @param component the component.
     * @param value the value to set.
     */
    public static void setBooleanProperty(final String name, final FacesContext context, final UIComponent component, final String value)
    {

        if (value != null)
        {

            if (UIComponentTag.isValueReference(value))
            {

                final ValueBinding binding = context.getApplication().createValueBinding(value);

                component.setValueBinding(name, binding);

            } else
            {

                component.getAttributes().put(name, Boolean.valueOf(value));

            }

        }

    }

    /**
     * Gets the attribute from the given object. The object can be either a context, request
     * or response (HttpServletContext/PortletContext, HttpServletRequest/PortletRequest, etc).
     * 
     * @param object the object from which to retrieve the attribute.
     * @param attributeName the attribute name.
     * @return the value of the attribute if one is present.
     */
    public static Object getAttribute(final Object object, final String attributeName)
    {

        try
        {

            Object attribute = null;

            if (object != null)
            {

                try
                {

                    final Method method = object.getClass().getMethod("getAttribute", new Class[]
                    { String.class });

                    attribute = method.invoke(object, attributeName);

                } catch (NoSuchMethodException exception)
                {

                    // Swallow Exception
                }

            }

            return attribute;

        } catch (Exception exception)
        {

            throw new RuntimeException(exception);

        }

    }

    /**
     * Sets the attribute on the given object. The object can be either a context, request
     * or response (HttpServletContext/PortletContext, HttpServletRequest/PortletRequest, etc).
     * 
     * @param object the object on which to set the attribute.
     * @param attributeName the attribute name.
     * @param attributeValue the value of the attribute to set.
     */
    public static void setAttribute(final Object object, final String attributeName, final Object attributeValue)
    {

        try
        {

            if (object != null)
            {

                try
                {

                    final Method method = object.getClass().getMethod("setAttribute", new Class[]
                    { String.class, Object.class });

                    method.invoke(object, attributeName, attributeValue);

                } catch (NoSuchMethodException ignore)
                {

                    // Swallow exception
                }

            }

        } catch (Exception exception)
        {

            throw new RuntimeException(exception);

        }

    }

    /**
     * Gets the context path from the given request object (PortletRequest/HttpServletRequest)
     * 
     * @param request the request object from which to retrieve the context path.
     * @return the context path.
     */
    public static String getContextPath(final Object request)
    {

        try
        {

            String contextPath = null;

            if (request != null)
            {

                contextPath = ObjectUtils.toString(request.getClass().getMethod("getContextPath", new Class[0]).invoke(request));

            }

            return contextPath;

        } catch (Exception exception)
        {

            throw new RuntimeException(exception);

        }

    }

}

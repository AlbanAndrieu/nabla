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
package org.andromda.cartridges.jsf.converters;

import org.apache.myfaces.custom.calendar.HtmlCalendarRenderer.DateConverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.el.ValueBinding;

/**
 * Overrides the default DateTimeConverter to include conversion of Calendar
 * instances as well as Date instances.
 * <p>
 * Unfortunately because of poor design in myfaces's calendar component, we have to implement
 * DateConverter so that we can correctly convert to a date in the inputCalendar implementation.
 * </p>
 * 
 * @author Chad Brandon
 */
public class JSFDateTimeConverter extends javax.faces.convert.DateTimeConverter implements DateConverter
{

    /**
     * @see javax.faces.convert.DateTimeConverter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
     * @throws ConverterException
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {

        if (value instanceof Calendar)
        {

            // - if the time zone is not explicitly set, use the one from the calendar
            if (!this.timeZoneIsSet)
            {

                // - use the time zone from the calendar
                this.setTimeZone(((Calendar) value).getTimeZone());

            }

            value = ((Calendar) value).getTime();

        }

        final String pattern = this.getPattern();
        String result = null;

        if ((value != null) && (pattern != null) && (pattern.trim().length() > 0))
        {

            DateFormat format = new SimpleDateFormat(pattern);

            format.setTimeZone(this.getTimeZone());
            result = format.format((Date) value);

        }

        return result;

    }

    /**
     * @see javax.faces.convert.DateTimeConverter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, String)
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException
    {

        Object asObject = null;
        final Class componentType = this.getComponentType(context, component);

        if (componentType != null)
        {

            asObject = super.getAsObject(context, component, value);

            if (Calendar.class.isAssignableFrom(componentType) && asObject instanceof Date)
            {

                final Calendar calendar = Calendar.getInstance();

                calendar.setTimeZone(this.getTimeZone());
                calendar.setTime((Date) asObject);
                asObject = calendar;

            }

        }

        return asObject;

    }

    /**
     * Gets the component type for the given <code>component</code>.
     * 
     * @param context the current faces context.
     * @param component the component from which to retrieve the type.
     * @return true/false
     */
    protected Class getComponentType(final FacesContext context, final UIComponent component)
    {

        Class type = null;
        final ValueBinding binding = component.getValueBinding("value");

        if (binding != null)
        {

            type = binding.getType(context);

        }

        return type;

    }

    /**
     * Gets the component Value for the given <code>component</code>.
     * 
     * @param context the current faces context.
     * @param component the component from which to retrieve the value.
     * @return true/false
     */
    protected Object getComponentValue(final FacesContext context, final UIComponent component)
    {

        Object value = null;
        final ValueBinding binding = component.getValueBinding("value");

        if (binding != null)
        {

            value = binding.getValue(context);

        }

        return value;

    }

    private TimeZone timeZone;

    /**
     * @see #getTimeZone()
     */
    @Override
    public void restoreState(FacesContext facesContext, Object state)
    {

        super.restoreState(facesContext, state);

        Object[] values = (Object[]) state;

        this.timeZone = (TimeZone) values[4];

    }

    /**
     * @see #getTimeZone()
     */
    @Override
    public Object saveState(FacesContext facesContext)
    {

        Object[] values = (Object[]) super.saveState(facesContext);

        values[4] = this.timeZone;

        return values;

    }

    /**
     * Keeps track of whether or not the time zone was explicitly set.
     */
    private boolean timeZoneIsSet;

    /**
     * @see #getTimeZone()
     */
    @Override
    public void setTimeZone(TimeZone timeZone)
    {

        this.timeZone = timeZone;
        this.timeZoneIsSet = true;

    }

    /**
     * Overridden because the default timeZone is set as GMT, whereas it should be the default
     * for the operating system.
     */
    @Override
    public TimeZone getTimeZone()
    {

        return (this.timeZone == null) ? TimeZone.getDefault() : this.timeZone;

    }

    /**
     * andromda.faces.DateTime
     */
    public static final String CONVERTER_ID = "andromda.faces.DateTime";

    /**
     * @see org.apache.myfaces.custom.calendar.HtmlCalendarRenderer.DateConverter #getAsDate(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
     */
    @Override
    public Date getAsDate(FacesContext context, UIComponent component)
    {

        Object value = this.getComponentValue(context, component);

        if (value instanceof Calendar)
        {

            value = ((Calendar) value).getTime();

        }

        return (Date) value;

    }

}

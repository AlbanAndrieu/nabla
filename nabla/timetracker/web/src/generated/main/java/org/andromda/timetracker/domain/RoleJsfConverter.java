// license-header java merge-point
// Generated by andromda-jsf cartridge (converters\EnumerationConverter.java.vsl) DO NOT EDIT!
package org.andromda.timetracker.domain;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 * Handles conversion of the enumeration {@link Role}
 * to a String and back.
 */
public class RoleJsfConverter
    implements Converter
{
    /**
     * @see Converter#getAsString(FacesContext, UIComponent, Object)
     */
    @Override
    public String getAsString(
        FacesContext context,
        UIComponent component,
        Object value)
        throws ConverterException
    {
        return (value == null || value.toString().trim().length() == 0) ? "":  ((Role)value).toString();
    }

    /**
     * @see Converter#getAsObject(FacesContext, UIComponent, String)
     */
    @Override
    public Object getAsObject(
        FacesContext context,
        UIComponent component,
        String value)
        throws ConverterException
    {
        return value != null && value.trim().length() > 0 ? Role.fromValue(value) : null;
    }
}
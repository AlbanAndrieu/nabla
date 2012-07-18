// license-header java merge-point
// Generated by andromda-jsf cartridge (utils\JsfUtils.java.vsl) DO NOT EDIT!
package org.andromda.presentation.jsf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.component.UICommand;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.el.MethodBinding;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.portlet.PortletSession;
import javax.portlet.RenderResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Utilities used within the JSF Cartridge
 *
 * @author Chad Brandon
 */
public class JsfUtils
{
    private static Log logger =
        LogFactory.getLog(JsfUtils.class);

    /**
     * The location of the temporary directoy used the JSF cartridge.
     */
    private static final String TEMPORARY_DIRECTORY;

    /**
     * Perform any constant initialization.
     */
    static
    {
        // - initialize the TEMPORARY_DIRECTORY
        final String tmpDir = System.getProperty("java.io.tmpdir");
        final StringBuilder directory = new StringBuilder(tmpDir);
        if (!directory.toString().endsWith("/"))
        {
            directory.append("/");
        }
        final String userName = System.getProperty("user.name");
        if (StringUtils.isNotBlank(userName))
        {
            directory.append(userName).append("/");
        }
        directory.append(".andromda/jsf-cartridge/");
        TEMPORARY_DIRECTORY = directory.toString();
    }

    /**
     * Attempts to serialize the given <code>form</code> to disk so that it
     * can later be retrieved when the user's session times out.
     * @param context the FacesContext from which to create the serialization path.
     * @param form the form to serialize.
     */
    public static void serializeForm(final FacesContext context, final Object form)
    {
        ObjectOutputStream objectStream = null;
        try
        {
            final String path = getFormSerializationPath(context);
            if (StringUtils.isNotBlank(path))
            {
                final File serializationFile = new File(getFormSerializationPath(context));
                final File parent = serializationFile.getParentFile();
                if (parent != null)
                {
                    parent.mkdirs();
                }
                final FileOutputStream fileStream = new FileOutputStream(serializationFile.toString());
                objectStream = new ObjectOutputStream(fileStream);
                objectStream.writeObject(form);
            }
        }
        catch (final Exception exception)
        {
            logger.warn(exception);
        }
        finally
        {
            if (objectStream != null)
            {
                try
                {
                    objectStream.close();
                }
                catch (IOException exception)
                {
                    // - ignore
                }
            }
        }
    }

    /**
     * Retrieves the current serialized form for the given session.
     * @param context the FacesContext
     * @return the serialized form.
     */
    public static Object getSerializedForm(final FacesContext context)
    {
        Object form = null;
        ObjectInputStream objectStream = null;
        try
        {
            final String path = getFormSerializationPath(context);
            if (StringUtils.isNotBlank(path))
            {
                FileInputStream fileStream = new FileInputStream(path);
                objectStream = new ObjectInputStream(fileStream);
                form = objectStream.readObject();
            }
        }
        catch (final Exception exception)
        {
            // - ignore if we couldn't retrieve the serialized form
        }
        finally
        {
            if (objectStream != null)
            {
                try
                {
                    objectStream.close();
                }
                catch (IOException exception)
                {
                    // - ignore
                }
            }
        }
        return form;
    }

    /**
     * Removes the serialized form (if present) for the given <code>session</code>
     *
     * @param context the session context for which to remove the serialized form.
     */
    public static void deleteSerializedForm(final FacesContext context)
    {
        final String path = getFormSerializationPath(context);
        if (StringUtils.isNotBlank(path))
        {
            final File serializationFile =
                new File(getFormSerializationPath(context));
            serializationFile.delete();
            final File directory = serializationFile.getParentFile();
            if (directory != null)
            {
                directory.delete();
            }
        }
    }
    /**
     * Pattern used to strip characters not used in the portlet serialization file.
     */
    private static final String NAMESPACE_STRIP_PATTERN = "\\p{Punct}";

    private static String getSerializationFileName(final Object response)
    {
        String fileName = null;
        if (response instanceof RenderResponse)
        {
            fileName = ((RenderResponse)response).getNamespace().replaceAll(NAMESPACE_STRIP_PATTERN, "");
        }
        return fileName;
    }

    /**
     * Retrieves the path in which the serialized form will be stored.
     * @param session the session containing the unique id in which to create the path.
     * @return the path to which serialization occurs.
     */
    private static String getFormSerializationPath(final FacesContext context)
    {
        final String sessionId = ((PortletSession)context.getExternalContext().getSession(true)).getId();
        final String serializationFileName = getSerializationFileName(context.getExternalContext().getResponse());
        String path = null;
        if (StringUtils.isNotBlank(serializationFileName))
        {
            path = TEMPORARY_DIRECTORY + sessionId + '/' + serializationFileName;
        }
        return path;
    }

    /**
     * Gets the attribute from the given object.  The object can be either a context, request
     * or resposne (HttpServletContext/PortletContext, HttpServletRequest/PortletRequest, etc).
     *
     * @param object the object from which to retrieve the attribute.
     * @param attributeName the attribute name.
     * @return the value of the attribute if one is present, null otherwise.
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
                    final Method method = object.getClass().getMethod("getAttribute", new Class[]{String.class});
                    attribute = method.invoke(object, new Object[]{attributeName});
                }
                catch (NoSuchMethodException exception)
                {
                    // Ignore exception, return null
                }
            }
            return attribute;
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Sets the attribute on the given object.  The object can be either a context, request
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
                    final Method method = object.getClass().getMethod("setAttribute", new Class[]{String.class, Object.class});
                    method.invoke(object, new Object[]{attributeName, attributeValue});
                }
                catch (NoSuchMethodException exception)
                {
                    // Ignore exception, return null
                }
            }
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Gets the names of all attributes on the given object.
     *
     * @param object the object on which to get all attribute names.
     * @return an array of all attribute names.
     */
    public static String[] getAttributeNames(final Object object)
    {
        final Collection<String> names = new ArrayList<String>();
        try
        {
            if (object != null)
            {
                try
                {
                    final Method method = object.getClass().getMethod("getAttributeNames", new Class[]{});
                    final Enumeration<?> enumeration = (Enumeration<?>)method.invoke(object, (Object[])null);
                    if (enumeration != null)
                    {
                        while (enumeration.hasMoreElements())
                        {
                            names.add(String.valueOf(enumeration.nextElement()));
                        }
                    }
                }
                catch (NoSuchMethodException exception)
                {
                    // Ignore exception, return null
                }
            }
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception);
        }
        return names.toArray(new String[0]);
    }

    /**
     * Extracts and returns the parameters from the given URL string.
     *
     * @param url the URL from which to extract parameters.
     * @return the Map of parameters.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Map<String, Object> extractParameters(final String url)
    {
        final Map<String, Object> parameterMap = new LinkedHashMap<String, Object>();
        if (url != null && url.contains("?"))
        {
            final String parameterString = url.replaceAll(".*\\?", "");
            if (parameterString.trim().length() > 0)
            {
                final String[] parametersAndValues = parameterString.split("\\s*&\\s*");
                for (final String parameterAndValue : parametersAndValues)
                {
                    final String[] parameters = parameterAndValue.split("\\s*=\\s*");
                    final String parameter = parameters[0];
                    Object existingValue = parameterMap.get(parameter);
                    String value = null;
                    if (parameters.length > 1)
                    {
                        value = parameters[1];
                    }
                    if (existingValue != null)
                    {
                        if (existingValue instanceof Collection)
                        {
                            ((Collection)existingValue).add(value);
                        }
                        else
                        {
                            final Collection<Object> values = new ArrayList<Object>();
                            values.add(existingValue);
                            values.add(value);
                            parameterMap.put(parameter, values);
                        }
                    }
                    else
                    {
                        parameterMap.put(parameter, value);
                    }
                }
            }
        }
        return parameterMap;
    }

    /**
     * Finds the command that uses the action method on the given component.
     *
     * @param component the component from which to start the search.
     * @param actionMethod the action method (i.e. controller.myMethod)
     * @return the component or null of not found.
     */
    public static UICommand findCommand(final UIComponent component, final String actionMethod)
    {
        UICommand found = null;
        if (component instanceof UICommand)
        {
            final MethodBinding action = ((UICommand)component).getAction();
            if (action != null)
            {
                final String methodName = action.getExpressionString() != null ? action.getExpressionString().replaceAll(".\\{|\\}", "") : null;
                if (actionMethod.equals(methodName))
                {
                    found = (UICommand)component;
                }
            }
        }
        if (found == null && component != null)
        {
            for (final Iterator<UIComponent> iterator = component.getFacetsAndChildren(); iterator.hasNext();)
            {
                found = findCommand(iterator.next(), actionMethod);
                if (found != null)
                {
                    break;
                }
            }
        }
        return found;
    }

    /**
     * Returns the converter identified by converterId
     * @param converterId the id of the converter to be used
     * @return the Converter instance
     */
    public static Converter getConverter(
            final String converterId)
    {
        if(StringUtils.isEmpty(converterId))
        {
            return null;
        }
        final FacesContext facesContext=FacesContext.getCurrentInstance();
        return facesContext.getApplication().createConverter(converterId);
    }

    /**
     * Uses the converter identified by converterId to convert the value to a String.
     * @param value the value to be converted
     * @param converterId the id of the converter to be used
     * @param componentId the id of the component being rendered
     * @return the String representation of the value.
     */
    public static String valueFromConverter(
            final Object value,
            final String converterId,
            final String componentId)
    {
        final FacesContext facesContext=FacesContext.getCurrentInstance();
        final Converter converter = facesContext.getApplication().createConverter(converterId);
        return converter.getAsString(facesContext,
                StringUtils.isEmpty(componentId)?null:facesContext.getViewRoot().findComponent(componentId),
                value);
    }

    /**
     * Uses the converter identified by converterId to convert the value to a String.
     * @param value the value to be converted
     * @param converterId the id of the converter to be used
     * @return the String representation of the value.
     */
    public static String valueFromConverter(
            final Object value,
            final String converterId)
    {
        final FacesContext facesContext=FacesContext.getCurrentInstance();
        final Converter converter = facesContext.getApplication().createConverter(converterId);
        return converter.getAsString(facesContext,null,value);
    }

    /**
     * Guarantees the partial triggers is a String[].
     * @param partialTriggers the partialTriggers attribute.
     * @return the original partialTriggers if it is a String[] or the partialTriggers splitted if it was a String.
     */
    public static String[] splitPartialTriggers(Object partialTriggers)
    {
        if(partialTriggers instanceof String)
        {
            final String thePartialTriggers=partialTriggers.toString().trim();
            if(thePartialTriggers.length() > 0){
                return thePartialTriggers.split(" ");
            }
            return null;
        }
        else if(partialTriggers instanceof String[])
        {
            return (String[])partialTriggers;
        }
        return null;
    }

    /**
     * Returns an ActionEvent parameter value, from its name
     * @param parameterName the parameter name
     * @param event ActionEvent containing the parameter
     * @return the parameter value.
     */
    public static Object getParameterValue(String parameterName, ActionEvent event)
    {
        for(Object uiObject : event.getComponent().getChildren())
        {
            if(uiObject instanceof UIParameter)
            {
                final UIParameter param = (UIParameter)uiObject;
                if(param.getName().equals(parameterName))
                {
                    return param.getValue();
                }
            }
        }
        throw new RuntimeException("Parameter "+parameterName+" not found");
    }

    /**
     * Returns an array of SelectItem from the values/names of the enumeration
     * @param prefix a String prefix to be used to load the name from the messages
     * @param enumClassName the enumeration class name
     * @return the array of SelectItem
     */
    @SuppressWarnings("rawtypes")
    public static SelectItem[] getEnumSelectItems(final String prefix, final String enumClassName)
    {
        try
        {
            final SelectItem[] result;
            final Class<?> enumClass=JsfUtils.class.getClassLoader().loadClass(enumClassName);
            if(enumClass.isEnum())
            {
                final Enum[] values=(Enum[])enumClass.getMethod("values", (Class<?>[])null).invoke(null, (Object[])null);
                result=new SelectItem[values.length];
                int i=0;
                for(final Enum value:values)
                {
                    result[i]=new SelectItem(value,Messages.get(prefix+value.name()));
                    i++;
                }
            }
            else
            {
                final List values=(List)enumClass.getMethod("values", (Class<?>[])null).invoke(null, (Object[])null);
                final int sz=values.size();
                final List names=(List)enumClass.getMethod("names", (Class<?>[])null).invoke(null, (Object[])null);
                result=new SelectItem[sz];
                for(int i=0; i<sz; i++)
                {
                    result[i]=new SelectItem(values.get(i),Messages.get(prefix+names.get(i)));
                }
            }

            return result;
        }
        catch (Exception e)
        {
            throw new RuntimeException(enumClassName+" is not an Andromda generated enumeration.",e);
        }
    }

    /**
     * Returns the messages.properties message of the enumeration value
     * @param prefix a String prefix to be used to load the name from the messages
     * @param enumValue the value
     * @return the String from the messages.properties
     */
    @SuppressWarnings("rawtypes")
    public static String getEnumMessage(final String prefix, final Object enumValue)
    {
        if(enumValue == null)
        {
            return StringUtils.EMPTY;
        }
        final Class<?> enumClass=enumValue.getClass();
        if(enumClass.isEnum())
        {
            return Messages.get(prefix+((Enum)enumValue).name());
        }
        try
        {
            final List values=(List)enumClass.getMethod("values", (Class<?>[])null).invoke(null, (Object[])null);
            final int sz=values.size();
            final List names=(List)enumClass.getMethod("names", (Class<?>[])null).invoke(null, (Object[])null);
            for(int i=0; i<sz; i++)
            {
                if(values.get(i).equals(enumValue))
                {
                    return Messages.get(prefix+names.get(i));
                }
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(enumValue.getClass().getCanonicalName()+" is not an Andromda generated enumeration.",e);
        }
        return null;
    }

    /**
     * Returns the array without the entries with zero (using to avoid the null to zero issue of EL)
     * @param intArray an array filled with Integer
     * @return the array with the entries with zero and null removed
     */
    public static Integer[] removeZeros(Integer[] intArray)
    {
        if(intArray == null)
        {
            return null;
        }
        final Collection<Integer> result=new ArrayList<Integer>(intArray.length);
        for(Integer intValue: intArray)
        {
            if(intValue != null && intValue.intValue() != 0)
            {
                result.add(intValue);
            }
        }
        return result.toArray(new Integer[0]);
    }

    /**
     * Returns the array without the entries with zero (using to avoid the null to zero issue of EL)
     * @param longArray an array filled with Integer
     * @return the array with the entries with zero and null removed
     */
    public static Long[] removeZeros(Long[] longArray)
    {
        if(longArray == null)
        {
            return null;
        }
        final Collection<Long> result=new ArrayList<Long>(longArray.length);
        for(Long longValue: longArray)
        {
            if(longValue != null && longValue.longValue() != 0)
            {
                result.add(longValue);
            }
        }
        return result.toArray(new Long[0]);
    }
}
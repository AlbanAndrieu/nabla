// license-header java merge-point
// Generated by andromda-jsf cartridge (utils\FacesContextUtils.java.vsl) DO NOT EDIT!
package org.andromda.presentation.jsf;

import javax.faces.FactoryFinder;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.el.VariableResolver;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Contains utilities for dealing with the FacesContext.
 *
 * @author Chad Brandon
 */
public class FacesContextUtils
{
    /**
     * Retrieves the current faces context given the <code>request</code>,
     * and <code>response</code>.
     *
     * @param request the ServletRequest instance.
     * @param response the ServletResponse instance
     * @return the current faces context.
     */
    public static FacesContext getFacesContext(
        final ServletRequest request,
        final ServletResponse response)
    {
        if (request == null)
        {
            throw new IllegalArgumentException("'request' can not be null");
        }
        if (response == null)
        {
            throw new IllegalArgumentException("'response' can not be null");
        }
        final HttpServletRequest httpRequest = (HttpServletRequest)request;
        final ServletContext servletContext = httpRequest.getSession().getServletContext();
        final LifecycleFactory lifecycleFactory =
            (LifecycleFactory)FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
        final Lifecycle lifecycle = lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
        final FacesContextFactory facesContextFactory =
            (FacesContextFactory)FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
        final FacesContext facesContext = facesContextFactory.getFacesContext(
                servletContext,
                request,
                response,
                lifecycle);
        if (facesContext == null)
        {
            throw new RuntimeException("Could not retrieve the current faces context");
        }
        return facesContext;
    }

    /**
     * Attempts to resolve the variable having the given <code>name</code> from the given
     * <code>request</code>, and <code>response</code>
     * @param request the ServletRequest instance.
     * @param response the ServletResponse instance
     * @param name the name of the variable to resolve.
     * @return
     */
    public static Object resolveVariable(
        final ServletRequest request,
        final ServletResponse response,
        final String name)
    {
        final FacesContext facesContext = getFacesContext(request, response);
        final VariableResolver variableResolver = facesContext.getApplication().getVariableResolver();
        return variableResolver.resolveVariable(
                facesContext,
                name);
    }
}
// license-header java merge-point
// Generated by andromda-jsf cartridge (flow\crud\ViewPopulator.java.vsl) DO NOT EDIT!
package org.andromda.test.howto16.a.crud;

import java.io.IOException;
import javax.faces.FactoryFinder;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.el.VariableResolver;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.andromda.presentation.jsf.JsfUtils;
import org.apache.myfaces.trinidad.context.RequestContext;

/**
 * This filter handles the population of forms for the <em>Car</code>
 * view.
 */
public class ManageCarFormPopulator
    implements Filter
{
    private FilterConfig config;

    /**
     * Initialize the filter
     *
     * @param config the configuration
     * @see javax.servlet.Filter#setFilterConfig(FilterConfig)
     */
    public void init(FilterConfig config)
    {
        this.config = config;
    }

    /**
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain chain) throws IOException, ServletException
    {
        this.populateFormAndViewVariables(request, response, null);
        chain.doFilter(request, response);
    }

    private void populateFormAndViewVariables(final ServletRequest request, final ServletResponse response, Object form)
        throws ServletException
    {
        // - we need to retrieve the faces context differently since we're outside of the
        //   faces servlet
        final LifecycleFactory lifecycleFactory =
            (LifecycleFactory)FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
        final Lifecycle lifecycle = lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
        final FacesContextFactory facesContextFactory =
            (FacesContextFactory)FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
        final FacesContext facesContext =
            facesContextFactory.getFacesContext(
                this.config.getServletContext(),
                request,
                response,
                lifecycle);

        RequestContext adfContext = RequestContext.getCurrentInstance();
        final VariableResolver variableResolver = facesContext.getApplication().getVariableResolver();

        form = adfContext.getPageFlowScope().get("form");

        final HttpSession session = ((HttpServletRequest)request).getSession();

        // - if the form is still null, see if we can get it from a serialized state
        if (form == null)
        {
            form = JsfUtils.getSerializedForm(facesContext);
        }
        try
        {
            // - populate the forms
            if (form != null && form instanceof ManageCarForm)
            {
                ManageCarForm manageCarForm =
                    (ManageCarForm)variableResolver.resolveVariable(
                    facesContext,
                    "manageCarForm");
                // - populate the manageCarForm with any parameters from the previous form
                manageCarForm.copyFrom((ManageCarForm)form);
            }
            // - serialize the form
            if (form != null)
            {
                JsfUtils.serializeForm(facesContext, form);
            }
        }
        catch (final Throwable throwable)
        {
            throw new ServletException(throwable);
        }
    }

    /**
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy()
    {
        this.config = null;
    }
}
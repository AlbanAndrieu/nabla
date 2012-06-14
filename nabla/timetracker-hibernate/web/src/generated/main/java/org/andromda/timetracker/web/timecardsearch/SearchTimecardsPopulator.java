// license-header java merge-point
// Generated by andromda-jsf cartridge (flow\ViewPopulator.java.vsl) DO NOT EDIT!
package org.andromda.timetracker.web.timecardsearch;

import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.faces.el.VariableResolver;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.andromda.presentation.jsf.AdfFacesContextWrapper;
import org.andromda.presentation.jsf.FacesContextUtils;
import org.andromda.presentation.jsf.FormPopulator;
import org.andromda.presentation.jsf.JsfUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.myfaces.trinidad.context.RequestContext;

/**
 * This filter handles the population of forms for the <em>Search Timecards</code>
 * view.
 */
public class SearchTimecardsPopulator
    implements Filter
{
    private FilterConfig config;

    /**
     * Initialize the filter
     *
     * @param configIn the configuration
     * @see javax.servlet.Filter#init(FilterConfig)
     */
    public void init(FilterConfig configIn)
    {
        this.config = configIn;
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
        // - we need to retrieve the faces context differently since we're outside of the
        //   faces servlet
        populateFormAndViewVariables(FacesContextUtils.getFacesContext(request, response), null);
        chain.doFilter(request, response);
    }

    /**
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy()
    {
        this.config = null;
    }

    /**
     * @param facesContext
     * @param form
     * @throws ServletException
     */
    public static void populateFormAndViewVariables(final FacesContext facesContext, Object form)
        throws ServletException
    {
        final HttpServletRequest request = (HttpServletRequest)facesContext.getExternalContext().getRequest();
        final HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(true);
        RequestContext adfContext = RequestContext.getCurrentInstance();
        final VariableResolver variableResolver = facesContext.getApplication().getVariableResolver();
        if (form == null)
        {
            // - first try getting the form from the ADF PageFlowScope
            form = adfContext.getPageFlowScope().get("form");
            // - if the form is null, try getting the current adfContext from the session (and then remove it from the session)
            if (form == null)
            {
                final AdfFacesContextWrapper contextWrapper =
                    (AdfFacesContextWrapper)session.getAttribute("AndroMDAADFContext");
                adfContext = contextWrapper != null ? contextWrapper.getCurrentInstance() : null;
                form = adfContext != null ? adfContext.getPageFlowScope().get("form") : null;
                if (form == null)
                {
                    form = session.getAttribute("form");
                    session.removeAttribute("form");
                }
                // - if the form is still null, see if we can get it from a serialized state
                if (form == null)
                {
                    form = JsfUtils.getSerializedForm(facesContext);
                }
                if (form != null)
                {
                    // - add the form to the current process scope since it wasn't in the current one to begin with
                    RequestContext.getCurrentInstance().getPageFlowScope().put("form", form);
                }
            }
            else
            {
                // - remove the ADF context in the event that its present
                session.removeAttribute("AndroMDAADFContext");
            }
        }
        else
        {
            // - since the form argument is not null, set it as the "form" in the PageFlowScope
            //   (to replace the existing "form" attribute)
            adfContext.getPageFlowScope().put("form", form);
        }
        try
        {
            // - populate the forms
            if (form != null)
            {
                SearchTimecardsSearchFormImpl searchTimecardsSearchTimecardsSearchForm =
                    (SearchTimecardsSearchFormImpl)variableResolver.resolveVariable(
                    facesContext,
                    "searchTimecardsSearchTimecardsSearchForm");
                // - populate the searchTimecardsSearchTimecardsSearchForm with any parameters from the previous form
                FormPopulator.populateForm(form, searchTimecardsSearchTimecardsSearchForm, false);
                request.setAttribute("searchTimecardsSearchTimecardsSearchForm", searchTimecardsSearchTimecardsSearchForm);
                SearchTimecardsDetailsFormImpl searchTimecardsSearchTimecardsDetailsForm =
                    (SearchTimecardsDetailsFormImpl)variableResolver.resolveVariable(
                    facesContext,
                    "searchTimecardsSearchTimecardsDetailsForm");
                // - populate the searchTimecardsSearchTimecardsDetailsForm with any parameters from the previous form
                FormPopulator.populateForm(form, searchTimecardsSearchTimecardsDetailsForm, false);
                request.setAttribute("searchTimecardsSearchTimecardsDetailsForm", searchTimecardsSearchTimecardsDetailsForm);
            }
            // - serialize the form
            if (form != null)
            {
                JsfUtils.serializeForm(facesContext, form);
            }
            // - populate the view variables
            if (form != null)
            {
                final boolean timecardSummariesReadable = PropertyUtils.isReadable(form, "timecardSummaries");
                if (timecardSummariesReadable)
                {
                    Boolean propertySet = null;
                    final String isSetPropertyName = "timecardSummariesSet";
                    if (PropertyUtils.isReadable(form, isSetPropertyName))
                    {
                        propertySet = (Boolean)PropertyUtils.getProperty(form, isSetPropertyName);
                    }
                    // - only set the property if its been set, or we can't tell if it has
                    if (propertySet == null || propertySet.booleanValue())
                    {
                        request.setAttribute("timecardSummaries", PropertyUtils.getProperty(form, "timecardSummaries"));
                    }
                }
                final boolean submitterBackingListReadable = PropertyUtils.isReadable(form, "submitterBackingList");
                if (submitterBackingListReadable)
                {
                    Object backingList = PropertyUtils.getProperty(form, "submitterBackingList");
                    request.setAttribute("submitterBackingList", backingList);
                }
                final boolean approverBackingListReadable = PropertyUtils.isReadable(form, "approverBackingList");
                if (approverBackingListReadable)
                {
                    Object backingList = PropertyUtils.getProperty(form, "approverBackingList");
                    request.setAttribute("approverBackingList", backingList);
                }
                final boolean statusBackingListReadable = PropertyUtils.isReadable(form, "statusBackingList");
                if (statusBackingListReadable)
                {
                    Object backingList = PropertyUtils.getProperty(form, "statusBackingList");
                    request.setAttribute("statusBackingList", backingList);
                }
            }
        }
        catch (final Throwable throwable)
        {
            throw new ServletException(throwable);
        }
    }
}
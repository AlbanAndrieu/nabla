package org.andromda.presentation.jsf;

import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.el.EvaluationException;
import javax.faces.el.VariableResolver;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;

public class JsfVariableResolver extends VariableResolver
{
    private VariableResolver originalVariableResolver;

    /**
    * Constructor.
    * @param originalVariableResolver Original JSF variable resolver.
    */
    public JsfVariableResolver(VariableResolver originalVariableResolver) {
       this.originalVariableResolver = originalVariableResolver;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object resolveVariable(FacesContext context, String name) throws EvaluationException {

        Object result;

        result = originalVariableResolver.resolveVariable(context, name);

        if(result == null)
        {
            final PortletSession session=(PortletSession) context.getExternalContext().getSession(true);
            final Map<String, Object> controllerForms=(Map<String, Object>)session.getAttribute(ControllerBase.USE_CASE_FORMS_KEY);

            if(controllerForms != null)
            {
                result = controllerForms.get(name);
            }

            if(result == null)
            {
                final Map<String, Object> controllerVariables=(Map<String, Object>)session.getAttribute(ControllerBase.USE_CASE_PAGE_VARIABLES_KEY);
                if(controllerVariables != null)
                {
                    result = controllerVariables.get(name);
                }
            }

            if(result != null)
            {
                getRequest(context).setAttribute(name,result);
            }
        }

        return result;
    }

    /**
     * A helper method that gets the current request from the faces
     * context.
     *
     * @param context a faces context
     * @return the current request instance.
     */
    protected PortletRequest getRequest(FacesContext context)
    {
        return (PortletRequest)context.getExternalContext().getRequest();
    }
}
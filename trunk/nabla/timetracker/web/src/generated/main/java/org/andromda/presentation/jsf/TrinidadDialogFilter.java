// license-header java merge-point
// Generated by andromda-jsf cartridge (utils\TrinidadDialogFilter.java.vsl) DO NOT EDIT!
package org.andromda.presentation.jsf;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Solution to the Trinidad bug https://issues.apache.org/jira/browse/TRINIDAD-119
 *
 * @author Walter Mourao
 */
public class TrinidadDialogFilter implements Filter
{
    /**
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig config) throws ServletException
    {
        // Empty method
    }

    /**
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy()
    {
        // Empty method
    }

    /**
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException
    {
        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse)
        {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String requestURI = httpRequest.getRequestURI();
            if (requestURI != null && requestURI.contains("__ADFv__") && !requestURI.contains(".jsf")) {
                String context = httpRequest.getContextPath();
                String replacedURI = requestURI.replace("__ADFv__", "__ADFv__" + ".jsf" + "?" + httpRequest.getQueryString());
                replacedURI = replacedURI.replaceFirst("^" + context, "");
                RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(replacedURI);
                dispatcher.forward(request, response);
            }
            else
            {
                chain.doFilter(request, response);
            }
        }
    }
}
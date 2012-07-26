package com.gwtplatform.dispatch.server.seam;

import java.io.IOException;
import java.security.SecureRandom;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.seam.Component;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Startup;
import org.jboss.seam.annotations.intercept.BypassInterceptors;
import org.jboss.seam.annotations.web.Filter;
import org.jboss.seam.log.Log;
import org.jboss.seam.web.AbstractFilter;
import org.jboss.seam.web.ServletContexts;

/**
 * 
 * @author Florian Sauter
 */
@Startup
@Scope(ScopeType.APPLICATION)
@Name("com.gwtplatform.dispatch.server.seam.securityCookieFilter")
@BypassInterceptors
@Filter(within = "org.jboss.seam.web.ajax4jsfFilter")
public class SecurityCookieFilter extends AbstractFilter
{

    @Logger
    private Log                  log;

    private javax.servlet.Filter securityCookieFilter;

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException
    {
        if (securityCookieFilter == null)
        {
            chain.doFilter(request, response);
        } else
        {
            securityCookieFilter.doFilter(request, response, chain);
        }
    }

    /**
     * Determines the cookie filter configuration based on the passed {@link SecurityCookieFilterConfig}.
     */
    @Create
    public void create()
    {
        DispatchConfiguration gwtpDispatchConfiguration = (DispatchConfiguration) Component.getInstance(DispatchConfiguration.COMPONENT_NAME);
        SecurityCookieFilterConfig securityConfiguration = null;
        if (gwtpDispatchConfiguration != null)
        {
            securityConfiguration = gwtpDispatchConfiguration.getClass().getAnnotation(SecurityCookieFilterConfig.class);
        }
        if (securityConfiguration == null)
        {
            log.info("GWTP - Protecting against XSRF attacks is off.");
            setUrlPattern(SecurityCookieFilterConfig.DEFAULT_URL_PATTERN);
        } else
        {
            // Initialize with securityConfiguration
            if (HttpSessionSecurityCookieFilter.class.equals(securityConfiguration.filterClass()))
            {
                securityCookieFilter = new HttpSessionSecurityCookieFilter(securityConfiguration.cookieName(), getSession());
            } else if (RandomSecurityCookieFilter.class.equals(securityConfiguration.filterClass()))
            {
                securityCookieFilter = new RandomSecurityCookieFilter(securityConfiguration.cookieName(), new SecureRandom());
            }
            setUrlPattern(securityConfiguration.urlPattern());
            log.info("GWTP - Protecting against XSRF attacks is on.");
            log.info("SecurityCookieFilter: " + securityCookieFilter.getClass().getSimpleName());
            log.info("SecurityCookieName: " + securityConfiguration.cookieName());
            log.info("Url pattern: " + securityConfiguration.urlPattern());
        }
    }

    protected HttpSession getSession()
    {
        return ServletContexts.instance().getRequest().getSession();
    }

}

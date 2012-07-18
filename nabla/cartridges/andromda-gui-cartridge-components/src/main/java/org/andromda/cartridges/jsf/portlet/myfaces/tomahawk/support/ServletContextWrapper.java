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
package org.andromda.cartridges.jsf.portlet.myfaces.tomahawk.support;

import java.io.InputStream;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.Enumeration;
import java.util.Set;

import javax.portlet.PortletContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 *
 */
public class ServletContextWrapper implements ServletContext
{

    private PortletContext portletContext;

    /**
     * @param portletContext
     */
    public ServletContextWrapper(PortletContext portletContext)
    {

        this.portletContext = portletContext;

    }

    /**
     * @see javax.servlet.ServletContext#getAttribute(String)
     */
    public Object getAttribute(String arg0)
    {

        return portletContext.getAttribute(arg0);

    }

    /**
     * @see javax.servlet.ServletContext#getAttributeNames()
     */
    public Enumeration getAttributeNames()
    {

        return portletContext.getAttributeNames();

    }

    /**
     * return null
     * @see javax.servlet.ServletContext#getContext(String)
     */
    public ServletContext getContext(String arg0)
    {

        // TODO Portlet API does not have this method
        return null;

    }

    /**
     * @see javax.servlet.ServletContext#getInitParameter(String)
     */
    public String getInitParameter(String arg0)
    {

        return portletContext.getInitParameter(arg0);

    }

    /**
     * @see javax.servlet.ServletContext#getInitParameterNames()
     */
    public Enumeration getInitParameterNames()
    {

        return portletContext.getInitParameterNames();

    }

    /**
     * @see javax.servlet.ServletContext#getMajorVersion()
     */
    public int getMajorVersion()
    {

        return portletContext.getMajorVersion();

    }

    /**
     * @see javax.servlet.ServletContext#getMimeType(String)
     */
    public String getMimeType(String arg0)
    {

        return portletContext.getMimeType(arg0);

    }

    /**
     * @see javax.servlet.ServletContext#getMinorVersion()
     */
    public int getMinorVersion()
    {

        return portletContext.getMinorVersion();

    }

    /**
     * return null
     * @see javax.servlet.ServletContext#getNamedDispatcher(String)
     */
    public RequestDispatcher getNamedDispatcher(String arg0)
    {

        // TODO Portlet API does not have this method
        return null;

    }

    /**
     * @see javax.servlet.ServletContext#getRealPath(String)
     */
    public String getRealPath(String arg0)
    {

        return portletContext.getRealPath(arg0);

    }

    /**
     * return null
     * @see javax.servlet.ServletContext#getRequestDispatcher(String)
     */
    public RequestDispatcher getRequestDispatcher(String arg0)
    {

        // TODO Portlet API does not have this method
        return null;

    }

    /**
     * @see javax.servlet.ServletContext#getResource(String)
     */
    public URL getResource(String arg0) throws MalformedURLException
    {

        return portletContext.getResource(arg0);

    }

    /**
     * @see javax.servlet.ServletContext#getResourceAsStream(String)
     */
    public InputStream getResourceAsStream(String arg0)
    {

        return portletContext.getResourceAsStream(arg0);

    }

    /**
     * @see javax.servlet.ServletContext#getResourcePaths(String)
     */
    public Set getResourcePaths(String arg0)
    {

        return portletContext.getResourcePaths(arg0);

    }

    /**
     * @see javax.servlet.ServletContext#getServerInfo()
     */
    public String getServerInfo()
    {

        return portletContext.getServerInfo();

    }

    /**
     * return null
     * @see javax.servlet.ServletContext#getServlet(String)
     * @deprecated
     */
    @Deprecated
    public Servlet getServlet(String arg0) throws ServletException
    {

        // TODO Portlet API does not have this method
        return null;

    }

    /**
     * @see javax.servlet.ServletContext#getServletContextName()
     */
    public String getServletContextName()
    {

        return portletContext.getPortletContextName();

    }

    /**
     * return null
     * @see javax.servlet.ServletContext#getServletNames()
     * @deprecated
     */
    @Deprecated
    public Enumeration getServletNames()
    {

        // TODO Portlet API does not have this method
        return null;

    }

    /**
     * return null
     * @see javax.servlet.ServletContext#getServlets()
     * @deprecated
     */
    @Deprecated
    public Enumeration getServlets()
    {

        // TODO Portlet API does not have this method
        return null;

    }

    /**
     * @see javax.servlet.ServletContext#log(Exception, String)
     * @deprecated
     */
    @Deprecated
    public void log(Exception arg0, String arg1)
    {

        portletContext.log(arg1, new Exception(arg0));

    }

    /**
     * @see javax.servlet.ServletContext#log(String,
     *      Throwable)
     */
    public void log(String arg0, Throwable arg1)
    {

        portletContext.log(arg0, arg1);

    }

    /**
     * @see javax.servlet.ServletContext#log(String)
     */
    public void log(String arg0)
    {

        portletContext.log(arg0);

    }

    /**
     * @see javax.servlet.ServletContext#removeAttribute(String)
     */
    public void removeAttribute(String arg0)
    {

        portletContext.removeAttribute(arg0);

    }

    /**
     * @see javax.servlet.ServletContext#setAttribute(String,
     *      Object)
     */
    public void setAttribute(String arg0, Object arg1)
    {

        portletContext.setAttribute(arg0, arg1);

    }

    /**
     * @see javax.servlet.ServletContext#getContextPath()
     */
    public String getContextPath()
    {

        return portletContext.getPortletContextName();

    }

}

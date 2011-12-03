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
package com.sun.j2ee.blueprints.waf.controller.web;

import com.sun.j2ee.blueprints.waf.controller.web.flow.ScreenFlowManager;
import com.sun.j2ee.blueprints.waf.controller.web.util.WebKeys;
import com.sun.j2ee.blueprints.waf.util.I18nUtil;

import java.io.IOException;

import java.util.HashMap;
import java.util.Locale;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 359 $
 *
 * @since $Date: 2010-09-17 02:14:34 +0200 (ven., 17 sept. 2010) $
 */
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private transient ServletContext context;
    private HashMap<?, ?> urlMappings;
    private HashMap<?, ?> eventMappings;
    private Locale defaultLocale = null;

    /**
     * DOCUMENT ME!
     *
     * @param config DOCUMENT ME!
     *
     * @throws ServletException DOCUMENT ME!
     */
    @Override
    public void init(final ServletConfig config) throws ServletException {

        final String defaultLocaleString = config.getInitParameter("default_locale");

        this.defaultLocale = I18nUtil.getLocaleFromString(defaultLocaleString);
        this.context = config.getServletContext();

        String requestMappingsURL = null;

        try {

            requestMappingsURL = this.context.getResource("/WEB-INF/mappings.xml").toString();

        } catch (final java.net.MalformedURLException ex) {

            System.err.println("MainServlet: initializing ScreenFlowManager malformed URL exception: " + ex);

        }

        this.urlMappings = URLMappingsXmlDAO.loadRequestMappings(requestMappingsURL);
        this.context.setAttribute(WebKeys.URL_MAPPINGS, this.urlMappings);
        this.eventMappings = URLMappingsXmlDAO.loadEventMappings(requestMappingsURL);
        this.context.setAttribute(WebKeys.EVENT_MAPPINGS, this.eventMappings);
        this.getScreenFlowManager();
        this.getRequestProcessor();

    }

    /**
     * DOCUMENT ME!
     *
     * @param request DOCUMENT ME!
     * @param response DOCUMENT ME!
     *
     * @throws IOException DOCUMENT ME!
     * @throws ServletException DOCUMENT ME!
     */
    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response)
               throws IOException, ServletException {

        this.doProcess(request, response);

    }

    /**
     * DOCUMENT ME!
     *
     * @param request DOCUMENT ME!
     * @param response DOCUMENT ME!
     *
     * @throws IOException DOCUMENT ME!
     * @throws ServletException DOCUMENT ME!
     */
    @Override
    public void doPost(final HttpServletRequest request, final HttpServletResponse response)
                throws IOException, ServletException {

        this.doProcess(request, response);

    }

    private void doProcess(final HttpServletRequest request, final HttpServletResponse response)
                    throws IOException, ServletException {

        if (request.getSession().getAttribute(WebKeys.LOCALE) == null) {

            request.getSession().setAttribute(WebKeys.LOCALE, this.defaultLocale);

        }

        try {

            this.getRequestProcessor().processRequest(request);
            this.getScreenFlowManager().forwardToNextScreen(request, response);

        } catch (final Throwable ex) {

            final String className = ex.getClass().getName();
            final String nextScreen = this.getScreenFlowManager().getExceptionScreen(ex);

            request.setAttribute("javax.servlet.jsp.jspException", ex);

            if (nextScreen == null) {

                ex.printStackTrace();
                throw new ServletException("MainServlet: unknown exception: " + className);

            }

            this.context.getRequestDispatcher(nextScreen).forward(request, response);

        }

    }

    private RequestProcessor getRequestProcessor() {

        RequestProcessor rp = (RequestProcessor) this.context.getAttribute(WebKeys.REQUEST_PROCESSOR);

        if (rp == null) {

            rp = new RequestProcessor();
            rp.init(this.context);
            this.context.setAttribute(WebKeys.REQUEST_PROCESSOR, rp);

        }

        return rp;

    }

    private ScreenFlowManager getScreenFlowManager() {

        ScreenFlowManager screenManager = (ScreenFlowManager) this.context.getAttribute(WebKeys.SCREEN_FLOW_MANAGER);

        if (screenManager == null) {

            screenManager = new ScreenFlowManager();
            screenManager.init(this.context);
            this.context.setAttribute(WebKeys.SCREEN_FLOW_MANAGER, screenManager);

        }

        return screenManager;

    }

}

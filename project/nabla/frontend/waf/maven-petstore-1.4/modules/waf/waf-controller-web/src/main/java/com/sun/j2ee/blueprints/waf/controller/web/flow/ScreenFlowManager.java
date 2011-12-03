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
package com.sun.j2ee.blueprints.waf.controller.web.flow;

import com.sun.j2ee.blueprints.waf.controller.web.URLMapping;
import com.sun.j2ee.blueprints.waf.controller.web.URLMappingsXmlDAO;
import com.sun.j2ee.blueprints.waf.controller.web.util.WebKeys;

import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 359 $
 *
 * @since $Date: 2010-09-17 02:14:34 +0200 (ven., 17 sept. 2010) $
 */
public class ScreenFlowManager implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private final HashMap<?, ?> screens;
    private HashMap<?, ?> urlMappings;
    private HashMap<?, ?> exceptionMappings;
    private String defaultScreen = "";
    private transient ServletContext context;

/**
     * Creates a new ScreenFlowManager object.
     */
    public ScreenFlowManager() {

        this.screens = new HashMap<Object, Object>();

    }

    /**
     * DOCUMENT ME!
     *
     * @param context DOCUMENT ME!
     */
    public void init(final ServletContext context) {

        this.context = context;

        String requestMappingsURL = null;

        try {

            requestMappingsURL = context.getResource("/WEB-INF/mappings.xml").toString();

        } catch (final java.net.MalformedURLException ex) {

            System.err.println("ScreenFlowManager: initializing ScreenFlowManager malformed URL exception: " + ex);

        }

        this.urlMappings = (HashMap<?, ?>) context.getAttribute(WebKeys.URL_MAPPINGS);

        final ScreenFlowData screenFlowData = URLMappingsXmlDAO.loadScreenFlowData(requestMappingsURL);

        this.defaultScreen = screenFlowData.getDefaultScreen();
        this.exceptionMappings = screenFlowData.getExceptionMappings();

    }

    private URLMapping getURLMapping(final String urlPattern) {

        if ((this.urlMappings != null) && this.urlMappings.containsKey(urlPattern)) {

            return (URLMapping) this.urlMappings.get(urlPattern);

        } else {

            return null;

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @param exceptionClassName DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getExceptionScreen(final String exceptionClassName) {

        return (String) this.exceptionMappings.get(exceptionClassName);

    }

    /**
     * DOCUMENT ME!
     *
     * @param request DOCUMENT ME!
     * @param response DOCUMENT ME!
     *
     * @throws FlowHandlerException DOCUMENT ME!
     * @throws RuntimeException DOCUMENT ME!
     */
    public void forwardToNextScreen(final HttpServletRequest request, final HttpServletResponse response)
                             throws java.io.IOException, FlowHandlerException, javax.servlet.ServletException {

        final String fullURL = request.getRequestURI();

        String selectedURL = this.defaultScreen;
        final int lastPathSeparator = fullURL.lastIndexOf("/") + 1;

        if (lastPathSeparator != -1) {

            selectedURL = fullURL.substring(lastPathSeparator, fullURL.length());

        }

        String currentScreen = "";
        final URLMapping urlMapping = this.getURLMapping(selectedURL);

        if (urlMapping != null) {

            if (!urlMapping.useFlowHandler()) {

                currentScreen = urlMapping.getScreen();

            } else {

                FlowHandler handler = null;
                final String flowHandlerString = urlMapping.getFlowHandler();

                try {

                    handler = (FlowHandler) this.getClass().getClassLoader().loadClass(flowHandlerString).newInstance();

                    handler.doStart(request);

                    final String flowResult = handler.processFlow(request);

                    handler.doEnd(request);
                    currentScreen = urlMapping.getResultScreen(flowResult);

                    if (currentScreen == null) {

                        currentScreen = flowResult;

                    }

                } catch (final Exception ex) {

                    System.err.println("ScreenFlowManager caught loading handler: " + ex);

                }

            }

        }

        if (currentScreen == null) {

            System.err.println("ScreenFlowManager: Screen not found for " + selectedURL);
            throw new RuntimeException("Screen not found for " + selectedURL);

        }

        this.context.getRequestDispatcher("/" + currentScreen).forward(request, response);

    }

    /**
     * DOCUMENT ME!
     *
     * @param e DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getExceptionScreen(final Throwable e) {

        final Iterator<?> it = this.exceptionMappings.keySet().iterator();

        while (it.hasNext()) {

            final String exceptionName = (String) it.next();
            Class<?> targetExceptionClass = null;

            try {

                targetExceptionClass = this.getClass().getClassLoader().loadClass(exceptionName);

            } catch (final ClassNotFoundException cnfe) {

                System.err.println("ScreenFlowManager: Could not load exception " + exceptionName);

            }

            System.err.println("Checking exception: " + exceptionName + " against " + e.getClass().getName());

            if ((targetExceptionClass != null) && targetExceptionClass.isAssignableFrom(e.getClass())) {

                System.err.println("ScreenFlowManager: found exception for " + exceptionName + " matches");
                ;

                return "/" + (String) this.exceptionMappings.get(exceptionName);

            }

        }

        return null;

    }

    /**
     * DOCUMENT ME!
     *
     * @param defaultScreen DOCUMENT ME!
     */
    public void setDefaultScreen(final String defaultScreen) {

        this.defaultScreen = defaultScreen;

    }

    /**
     * DOCUMENT ME!
     *
     * @param session DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getCurrentScreen(final HttpSession session) {

        return (String) session.getAttribute(WebKeys.CURRENT_SCREEN);

    }

}

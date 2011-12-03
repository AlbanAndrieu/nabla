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
package com.sun.j2ee.blueprints.waf.view.template;

import com.sun.j2ee.blueprints.waf.controller.web.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;

import java.net.URL;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;


/**
 * DOCUMENT ME!
 *
 * @author $Author$
 * @version $Revision$
 *
 * @since $Date$
 */
public class TemplateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String PREVIOUS_SCREEN = "PREVIOUS";
    private HashMap<String, Screens> allScreens;
    private ServletContext context;
    private String defaultLocale;
    private boolean cachePreviousScreenAttributes = false;
    private boolean cachePreviousScreenParameters = false;

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

        this.process(request, response);

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

        this.process(request, response);

    }

    /**
     * DOCUMENT ME!
     *
     * @param config DOCUMENT ME!
     *
     * @throws ServletException DOCUMENT ME!
     */
    @Override
    public void init(final ServletConfig config) throws ServletException {

        super.init(config);
        this.context = config.getServletContext();

        final String cachePreviousScreenAttributesString = config.getInitParameter("cache_previous_screen_attributes");

        if (cachePreviousScreenAttributesString != null) {

            if (cachePreviousScreenAttributesString.toLowerCase().equals("true")) {

                System.out.println("TemplateServlet: Enabled caching of previous screen attributes.");
                this.cachePreviousScreenAttributes = true;

            }

        }

        final String cachePreviousScreenParametersString = config.getInitParameter("cache_previous_screen_parameters");

        if (cachePreviousScreenParametersString != null) {

            if (cachePreviousScreenParametersString.toLowerCase().equals("true")) {

                System.out.println("TemplateServlet: Enabled caching of previous screen parameters.");
                this.cachePreviousScreenParameters = true;

            }

        }

        this.allScreens = new HashMap<String, Screens>();
        this.defaultLocale = config.getInitParameter("default_locale");

        if (this.defaultLocale == null) {

            this.defaultLocale = (Locale.getDefault()).toString();

        }

        final String locales = config.getInitParameter("locales");

        if (locales != null) {

            final StringTokenizer strTok = new StringTokenizer(locales, ",");

            while (strTok.hasMoreTokens()) {

                this.initScreens(config.getServletContext(), strTok.nextToken());

            }

        }

    }

    private void initScreens(final ServletContext context, final String language) {

        URL screenDefinitionURL = null;

        try {

            screenDefinitionURL = context.getResource("/WEB-INF/screendefinitions_" + language + ".xml");

        } catch (final java.net.MalformedURLException ex) {

            System.err.println("TemplateServlet: malformed URL exception: " + ex);

        }

        if (screenDefinitionURL != null) {

            final Screens screenDefinitions = ScreenDefinitionDAO.loadScreenDefinitions(screenDefinitionURL);

            if (screenDefinitions != null) {

                this.allScreens.put(language, screenDefinitions);

            } else {

                System.err.println("Template Servlet Error Loading Screen Definitions: Confirm that file at URL /WEB-INF/screendefinitions_" + language + ".xml contains the screen definitions");

            }

        } else {

            System.err.println("Template Servlet Error Loading Screen Definitions: URL /WEB-INF/screendefinitions_" + language + ".xml not found");

        }

    }

    private void insertTemplate(final HttpServletRequest request, final HttpServletResponse response, final String templateName)
                         throws IOException, ServletException {

        boolean tx_started = false;
        UserTransaction ut = null;

        try {

            final InitialContext ic = new InitialContext();

            ut = (UserTransaction) ic.lookup("java:comp/UserTransaction");
            ut.begin();
            tx_started = true;

        } catch (final NamingException ne) {

            ne.printStackTrace();

        } catch (final NotSupportedException nse) {

            nse.printStackTrace();

        } catch (final SystemException se) {

            se.printStackTrace();

        }

        try {

            this.context.getRequestDispatcher(templateName).forward(request, response);

        } finally {

            try {

                if (tx_started && (ut != null)) {

                    ut.commit();

                }

            } catch (final IllegalStateException re) {

                re.printStackTrace();

            } catch (final RollbackException re) {

                re.printStackTrace();

            } catch (final HeuristicMixedException hme) {

                hme.printStackTrace();

            } catch (final HeuristicRollbackException hre) {

                hre.printStackTrace();

            } catch (final SystemException se) {

                se.printStackTrace();

            }

        }

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
    public void process(final HttpServletRequest request, final HttpServletResponse response)
                 throws IOException, ServletException {

        String screenName = null;
        String localeString = null;
        final String selectedUrl = request.getRequestURI();

        if (request.getSession().getAttribute(WebKeys.CURRENT_URL) != null) {

            request.getSession().removeAttribute(WebKeys.CURRENT_URL);

        }

        final String languageParam = request.getParameter("locale");

        if (languageParam != null) {

            localeString = languageParam;

        } else if (request.getSession().getAttribute(WebKeys.LOCALE) != null) {

            localeString = ((Locale) request.getSession().getAttribute(WebKeys.LOCALE)).toString();

        }

        if (this.allScreens.get(localeString) == null) {

            localeString = this.defaultLocale;

        }

        final int lastPathSeparator = selectedUrl.lastIndexOf("/") + 1;
        final int lastDot = selectedUrl.lastIndexOf(".");

        if ((lastPathSeparator != -1) && (lastDot != -1) && (lastDot > lastPathSeparator)) {

            screenName = selectedUrl.substring(lastPathSeparator, lastDot);

        }

        if (screenName.equals(TemplateServlet.PREVIOUS_SCREEN)) {

            final String longScreenName = (String) request.getSession().getAttribute(WebKeys.PREVIOUS_SCREEN);
            final int lastDot2 = longScreenName.lastIndexOf(".");

            if ((lastDot2 != -1) && (lastDot2 > 0)) {

                screenName = longScreenName.substring(0, lastDot2);

            }

            if (this.cachePreviousScreenParameters) {

                final Map<?, ?> previousParams = (Map<?, ?>) request.getSession().getAttribute(WebKeys.PREVIOUS_REQUEST_PARAMETERS);
                final Map<String, Object> params = request.getParameterMap();
                final Iterator<?> it = previousParams.keySet().iterator();

                while (it.hasNext()) {

                    final String key = (String) it.next();
                    final Object value = previousParams.get(key);

                    params.put(key, value);

                }

            }

            if (this.cachePreviousScreenAttributes) {

                final Map<?, ?> previousAttributes = (Map<?, ?>) request.getSession().getAttribute(WebKeys.PREVIOUS_REQUEST_ATTRIBUTES);
                final Iterator<?> it2 = previousAttributes.keySet().iterator();

                while (it2.hasNext()) {

                    final String key = (String) it2.next();
                    final Object value = previousAttributes.get(key);

                    request.setAttribute(key, value);

                }

            }

        } else {

            final String extension = selectedUrl.substring(lastDot, selectedUrl.length());

            request.getSession().setAttribute(WebKeys.PREVIOUS_SCREEN, screenName + extension);

            if (this.cachePreviousScreenParameters) {

                final HashMap<String, Object> newParams = new HashMap<String, Object>();
                final Map<String, Object> params = request.getParameterMap();
                final Iterator<String> it = params.keySet().iterator();

                while (it.hasNext()) {

                    final String key = it.next();
                    final Object value = params.get(key);

                    newParams.put(key, value);

                }

                request.getSession().setAttribute(WebKeys.PREVIOUS_REQUEST_PARAMETERS, newParams);

            }

            if (this.cachePreviousScreenAttributes) {

                final HashMap<String, Object> attributes = new HashMap<String, Object>();
                final Enumeration<?> enumeration = request.getAttributeNames();

                while (enumeration.hasMoreElements()) {

                    final String key = (String) enumeration.nextElement();
                    final Object value = request.getAttribute(key);

                    attributes.put(key, value);

                }

                request.getSession().setAttribute(WebKeys.PREVIOUS_REQUEST_ATTRIBUTES, attributes);

            }

        }

        Screen screen = null;

        if (screenName != null) {

            Screens localeScreens = this.allScreens.get(localeString);

            if (localeScreens != null) {

                screen = localeScreens.getScreen(screenName);

            }

            if (screen == null) {

                System.err.println("Screen not Found loading default from " + this.defaultLocale);
                localeScreens = this.allScreens.get(this.defaultLocale);
                screen = localeScreens.getScreen(screenName);

            }

            if (screen != null) {

                request.setAttribute(WebKeys.CURRENT_SCREEN, screen);

                final String templateName = localeScreens.getTemplate(screenName);

                if (templateName != null) {

                    this.insertTemplate(request, response, templateName);

                }

            } else {

                response.setContentType("text/html;charset=8859_1");

                final PrintWriter out = response.getWriter();

                out.println("<font size=+4>Error:</font><br>Definition for screen " + screenName + " not found");

            }

        }

    }

}

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

import com.sun.j2ee.blueprints.waf.controller.web.action.HTMLAction;
import com.sun.j2ee.blueprints.waf.controller.web.action.HTMLActionException;
import com.sun.j2ee.blueprints.waf.controller.web.util.WebKeys;
import com.sun.j2ee.blueprints.waf.event.Event;
import com.sun.j2ee.blueprints.waf.event.EventException;
import com.sun.j2ee.blueprints.waf.event.EventResponse;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 389 $
 *
 * @since $Date: 2010-10-27 20:02:35 +0200 (mer., 27 oct. 2010) $
 */
public class RequestProcessor implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Map<String, Object> urlMappings;
    private Map<String, Object> eventMappings;

/**
     * Creates a new RequestProcessor object.
     */
    public RequestProcessor() {

    }

    /**
     * DOCUMENT ME!
     *
     * @param context DOCUMENT ME!
     */
    public void init(final ServletContext context) {

        this.urlMappings = (HashMap<String, Object>) context.getAttribute(WebKeys.URL_MAPPINGS);
        this.eventMappings = (HashMap<String, Object>) context.getAttribute(WebKeys.EVENT_MAPPINGS);

    }

    private URLMapping getURLMapping(final String urlPattern) {

        if ((this.urlMappings != null) && this.urlMappings.containsKey(urlPattern)) {

            return (URLMapping) this.urlMappings.get(urlPattern);

        } else {

            return null;

        }

    }

    private EventMapping getEventMapping(final Event eventClass) {

        final String eventClassName = eventClass.getClass().getName();

        if ((this.eventMappings != null) && this.eventMappings.containsKey(eventClassName)) {

            return (EventMapping) this.eventMappings.get(eventClassName);

        } else {

            return null;

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @param request DOCUMENT ME!
     *
     * @throws HTMLActionException DOCUMENT ME!
     * @throws EventException DOCUMENT ME!
     * @throws ServletException DOCUMENT ME!
     */
    public void processRequest(final HttpServletRequest request)
                        throws HTMLActionException, EventException, ServletException {

        Event ev = null;
        final String fullURL = request.getRequestURI();

        String selectedURL = null;
        final int lastPathSeparator = fullURL.lastIndexOf("/") + 1;

        if (lastPathSeparator != -1) {

            selectedURL = fullURL.substring(lastPathSeparator, fullURL.length());

        }

        final URLMapping urlMapping = this.getURLMapping(selectedURL);
        final HTMLAction action = this.getAction(urlMapping);

        if (action != null) {

            action.setServletContext(request.getSession().getServletContext());
            action.doStart(request);
            ev = action.perform(request);

            EventResponse eventResponse = null;

            if (ev != null) {

                final EventMapping eventMapping = this.getEventMapping(ev);

                if (eventMapping != null) {

                    ev.setEJBActionClassName(eventMapping.getEJBActionClassName());

                }

                final ComponentManager sl = (ComponentManager) request.getSession().getAttribute(WebKeys.COMPONENT_MANAGER);
                final WebController wcc = sl.getWebController(request.getSession());

                eventResponse = wcc.handleEvent(ev, request.getSession());

            }

            action.doEnd(request, eventResponse);

        }

    }

    private HTMLAction getAction(final URLMapping urlMapping) {

        HTMLAction handler = null;
        String actionClassString = null;

        if (urlMapping != null) {

            actionClassString = urlMapping.getWebAction();

            if (urlMapping.isAction()) {

                try {

                    handler = (HTMLAction) this.getClass().getClassLoader().loadClass(actionClassString).newInstance();

                } catch (final Exception ex) {

                    System.err.println("RequestProcessor caught loading action: " + ex);

                }

            }

        }

        return handler;

    }

}

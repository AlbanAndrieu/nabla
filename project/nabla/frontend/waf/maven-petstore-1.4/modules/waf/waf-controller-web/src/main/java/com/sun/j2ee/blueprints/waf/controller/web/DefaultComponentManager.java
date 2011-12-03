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

import com.sun.j2ee.blueprints.servicelocator.ServiceLocatorException;
import com.sun.j2ee.blueprints.servicelocator.web.ServiceLocator;
import com.sun.j2ee.blueprints.waf.controller.ejb.EJBControllerLocal;
import com.sun.j2ee.blueprints.waf.controller.ejb.EJBControllerLocalHome;
import com.sun.j2ee.blueprints.waf.controller.web.util.WebKeys;
import com.sun.j2ee.blueprints.waf.exceptions.GeneralFailureException;
import com.sun.j2ee.blueprints.waf.util.JNDINames;

import java.beans.Beans;

import javax.ejb.CreateException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;


/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 350 $
 *
 * @since $Date: 2010-09-14 01:50:19 +0200 (mar., 14 sept. 2010) $
 */
public class DefaultComponentManager implements ComponentManager, java.io.Serializable {

    private static final long serialVersionUID = 1L;
    protected ServiceLocator sl = null;

/**
     * Creates a new DefaultComponentManager object.
     */
    public DefaultComponentManager() {

        sl = ServiceLocator.getInstance();

    }

    /**
     * DOCUMENT ME!
     *
     * @param session DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws GeneralFailureException DOCUMENT ME!
     */
    public EJBControllerLocal getEJBController(final HttpSession session) {

        EJBControllerLocal ccEjb = (EJBControllerLocal) session.getAttribute(WebKeys.EJB_CONTROLLER);

        if (ccEjb == null) {

            try {

                final EJBControllerLocalHome home = (EJBControllerLocalHome) sl.getLocalHome(JNDINames.EJB_CONTROLLER_EJBHOME);

                ccEjb = home.create();

            } catch (final CreateException ce) {

                throw new GeneralFailureException(ce.getMessage());

            } catch (final ServiceLocatorException slx) {

                throw new GeneralFailureException(slx.getMessage());

            }

        }

        return ccEjb;

    }

    /**
     * DOCUMENT ME!
     *
     * @param session DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws RuntimeException DOCUMENT ME!
     */
    public WebController getWebController(final HttpSession session) {

        final ServletContext context = session.getServletContext();
        WebController wcc = (WebController) context.getAttribute(WebKeys.WEB_CONTROLLER);

        if (wcc == null) {

            try {

                final String wccClassName = sl.getString(JNDINames.DEFAULT_WEB_CONTROLLER);

                wcc = (WebController) Beans.instantiate(this.getClass().getClassLoader(), wccClassName);
                wcc.init(context);

            } catch (final ServiceLocatorException slx) {

                throw new RuntimeException("Cannot create bean of class WebController: " + slx);

            } catch (final Exception exc) {

                throw new RuntimeException("Cannot create bean of class WebController: " + exc);

            }

        }

        return wcc;

    }

    /**
     * DOCUMENT ME!
     *
     * @param se DOCUMENT ME!
     */
    public void sessionCreated(final HttpSessionEvent se) {

        final HttpSession session = se.getSession();

        sl = ServiceLocator.getInstance();
        session.setAttribute(WebKeys.COMPONENT_MANAGER, this);

    }

    /**
     * DOCUMENT ME!
     *
     * @param se DOCUMENT ME!
     */
    public void sessionDestroyed(final HttpSessionEvent se) {

        try {

            final HttpSession session = se.getSession();
            final WebController wcc = getWebController(session);

            if (wcc != null) {

                wcc.destroy(session);

            }

        } catch (final Exception exe) {

        }

    }

}

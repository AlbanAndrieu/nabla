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

import java.util.HashMap;


/**
 * DOCUMENT ME!
 *
 * @author $Author$
 * @version $Revision$
 *
 * @since $Date$
 */
public class Screens implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private final HashMap<String, Screen> screenMap;
    private final HashMap<String, String> templateMap;
    private final String defaultTemplate;

/**
     * Creates a new Screens object.
     *
     * @param defaultTemplate DOCUMENT ME!
     */
    public Screens(final String defaultTemplate) {

        screenMap = new HashMap<String, Screen>();
        templateMap = new HashMap<String, String>();
        this.defaultTemplate = defaultTemplate;

    }

    /**
     * DOCUMENT ME!
     *
     * @param screenName DOCUMENT ME!
     * @param screen DOCUMENT ME!
     */
    public void addScreen(final String screenName, final Screen screen) {

        if (screenMap.containsKey(screenName)) {

            screenMap.remove(screenName);

        }

        screenMap.put(screenName, screen);

    }

    /**
     * DOCUMENT ME!
     *
     * @param templateName DOCUMENT ME!
     * @param templateURL DOCUMENT ME!
     */
    public void addTemplate(final String templateName, final String templateURL) {

        if (templateMap.containsKey(templateName)) {

            templateMap.remove(templateName);

        }

        templateMap.put(templateName, templateURL);

    }

    /**
     * DOCUMENT ME!
     *
     * @param screenName DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean containsScreen(final String screenName) {

        return screenMap.containsKey(screenName);

    }

    /**
     * DOCUMENT ME!
     *
     * @param templateName DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean containsTemplate(final String templateName) {

        return templateMap.containsKey(templateName);

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getDefaultTemplate() {

        return defaultTemplate;

    }

    /**
     * DOCUMENT ME!
     *
     * @param screenName DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Screen getScreen(final String screenName) {

        if (screenMap.containsKey(screenName)) {

            return screenMap.get(screenName);

        } else {

            System.err.println("Screens Error: Screen " + screenName + " not defined.");

            return null;

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @param screenName DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getTemplate(final String screenName) {

        if (screenMap.containsKey(screenName)) {

            final String templateName = (screenMap.get(screenName)).getTemplate();

            if ((templateName != null) && templateMap.containsKey(templateName)) {

                return templateMap.get(templateName);

            } else {

                return defaultTemplate;

            }

        } else {

            System.err.println("Screens:getTemplate() error: Screen " + screenName + " not defined.");

            return null;

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    @Override
    public String toString() {

        return "[Screens: defaultTemplate=" + defaultTemplate + ", " + "screenMap=" + screenMap + "templateMap=" + templateMap + "]";

    }

}

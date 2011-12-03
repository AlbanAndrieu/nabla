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

import com.sun.j2ee.blueprints.waf.controller.web.flow.ScreenFlowData;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.net.URL;

import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 350 $
 *
 * @since $Date: 2010-09-14 01:50:19 +0200 (mar., 14 sept. 2010) $
 */
public class URLMappingsXmlDAO {

    /**
     * DOCUMENT ME!
     */
    public static final String URL_MAPPING = "url-mapping";

    /**
     * DOCUMENT ME!
     */
    public static final String EVENT_MAPPING = "event-mapping";

    /**
     * DOCUMENT ME!
     */
    public static final String EXCEPTION_MAPPING = "exception-mapping";

    /**
     * DOCUMENT ME!
     */
    public static final String URL = "url";

    /**
     * DOCUMENT ME!
     */
    public static final String LANGUAGE = "language";

    /**
     * DOCUMENT ME!
     */
    public static final String TEMPLATE = "template";

    /**
     * DOCUMENT ME!
     */
    public static final String RESULT = "result";

    /**
     * DOCUMENT ME!
     */
    public static final String NEXT_SCREEN = "screen";

    /**
     * DOCUMENT ME!
     */
    public static final String PROCESSS_ACTION = "isAction";

    /**
     * DOCUMENT ME!
     */
    public static final String REQUIRES_SIGNIN = "requiresSignin";

    /**
     * DOCUMENT ME!
     */
    public static final String USE_FLOW_HANDLER = "useFlowHandler";

    /**
     * DOCUMENT ME!
     */
    public static final String FLOW_HANDLER_CLASS = "class";

    /**
     * DOCUMENT ME!
     */
    public static final String WEB_ACTION_CLASS = "web-action-class";

    /**
     * DOCUMENT ME!
     */
    public static final String EJB_ACTION_CLASS = "ejb-action-class";

    /**
     * DOCUMENT ME!
     */
    public static final String EVENT_CLASS = "event-class";

    /**
     * DOCUMENT ME!
     */
    public static final String HANDLER_RESULT = "handler-result";

    /**
     * DOCUMENT ME!
     */
    public static final String FLOW_HANDLER = "flow-handler";

    /**
     * DOCUMENT ME!
     */
    public static final String EXCEPTION_CLASS = "exception-class";

    /**
     * DOCUMENT ME!
     */
    public static final String DEFAULT_SCREEN = "default-screen";

    /**
     * DOCUMENT ME!
     */
    public static final String KEY = "key";

    /**
     * DOCUMENT ME!
     */
    public static final String VALUE = "value";

    /**
     * DOCUMENT ME!
     */
    public static final String DIRECT = "direct";

    /**
     * DOCUMENT ME!
     */
    public static final String SCREEN = "screen";

    /**
     * DOCUMENT ME!
     */
    public static final String SCREEN_NAME = "screen-name";

    /**
     * DOCUMENT ME!
     */
    public static final String PARAMETER = "parameter";

    /**
     * DOCUMENT ME!
     *
     * @param location DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static Element loadDocument(final String location) {

        Document doc = null;

        try {

            final URL url = new URL(location);
            final InputSource xmlInp = new InputSource(url.openStream());

            final DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder parser = docBuilderFactory.newDocumentBuilder();

            doc = parser.parse(xmlInp);

            final Element root = doc.getDocumentElement();

            root.normalize();

            return root;

        } catch (final SAXParseException err) {

            System.err.println("URLMappingsXmlDAO ** Parsing error" + ", line " + err.getLineNumber() + ", uri " + err.getSystemId());
            System.err.println("URLMappingsXmlDAO error: " + err.getMessage());

        } catch (final SAXException e) {

            System.err.println("URLMappingsXmlDAO error: " + e);

        } catch (final java.net.MalformedURLException mfx) {

            System.err.println("URLMappingsXmlDAO error: " + mfx);

        } catch (final java.io.IOException e) {

            System.err.println("URLMappingsXmlDAO error: " + e);

        } catch (final Exception pce) {

            System.err.println("URLMappingsXmlDAO error: " + pce);

        }

        return null;

    }

    /**
     * DOCUMENT ME!
     *
     * @param location DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static ScreenFlowData loadScreenFlowData(final String location) {

        final Element root = loadDocument(location);
        final HashMap<String, String> exceptionMappings = getExceptionMappings(root);
        final String defaultScreen = getTagValue(root, DEFAULT_SCREEN);

        return new ScreenFlowData(exceptionMappings, defaultScreen);

    }

    /**
     * DOCUMENT ME!
     *
     * @param location DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static HashMap<String, URLMapping> loadRequestMappings(final String location) {

        final Element root = loadDocument(location);

        return getRequestMappings(root);

    }

    /**
     * DOCUMENT ME!
     *
     * @param location DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static HashMap<String, String> loadExceptionMappings(final String location) {

        final Element root = loadDocument(location);

        return getExceptionMappings(root);

    }

    /**
     * DOCUMENT ME!
     *
     * @param location DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static HashMap<String, EventMapping> loadEventMappings(final String location) {

        final Element root = loadDocument(location);

        return getEventMappings(root);

    }

    /**
     * DOCUMENT ME!
     *
     * @param root DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static HashMap<String, String> getExceptionMappings(final Element root) {

        final HashMap<String, String> exceptionMappings = new HashMap<String, String>();
        final NodeList list = root.getElementsByTagName(EXCEPTION_MAPPING);

        for (int loop = 0; loop < list.getLength(); loop++) {

            final Node node = list.item(loop);

            if (node != null) {

                String exceptionClassName = "";
                String screen = null;

                if (node instanceof Element) {

                    final Element element = ((Element) node);

                    exceptionClassName = element.getAttribute(EXCEPTION_CLASS);
                    screen = element.getAttribute(SCREEN);
                    exceptionMappings.put(exceptionClassName, screen);

                }

            }

        }

        return exceptionMappings;

    }

    /**
     * DOCUMENT ME!
     *
     * @param root DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static HashMap<String, EventMapping> getEventMappings(final Element root) {

        final HashMap<String, EventMapping> eventMappings = new HashMap<String, EventMapping>();
        final NodeList list = root.getElementsByTagName(EVENT_MAPPING);

        for (int loop = 0; loop < list.getLength(); loop++) {

            final Node node = list.item(loop);

            if (node != null) {

                final String eventClassName = getSubTagValue(node, EVENT_CLASS);
                final String ejbActionClass = getSubTagValue(node, EJB_ACTION_CLASS);

                if ((eventClassName != null) && !eventClassName.equals("")) {

                    eventMappings.put(eventClassName, new EventMapping(eventClassName, ejbActionClass));

                }

            }

        }

        return eventMappings;

    }

    /**
     * DOCUMENT ME!
     *
     * @param root DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static HashMap<String, URLMapping> getRequestMappings(final Element root) {

        final HashMap<String, URLMapping> urlMappings = new HashMap<String, URLMapping>();
        final NodeList list = root.getElementsByTagName(URL_MAPPING);

        for (int loop = 0; loop < list.getLength(); loop++) {

            final Node node = list.item(loop);

            if (node != null) {

                String url = "";
                String screen = null;
                String useFlowHandlerString = null;
                String flowHandler = null;
                String webActionClass = null;
                HashMap<String, String> resultMappings = null;
                boolean useFlowHandler = false;
                boolean isAction = false;

                if (node instanceof Element) {

                    final Element element = ((Element) node);

                    url = element.getAttribute(URL);
                    screen = element.getAttribute(NEXT_SCREEN);
                    element.getAttribute(PROCESSS_ACTION);
                    useFlowHandlerString = element.getAttribute(USE_FLOW_HANDLER);

                }

                webActionClass = getSubTagValue(node, WEB_ACTION_CLASS);

                if (webActionClass != null) {

                    isAction = true;

                }

                if ((useFlowHandlerString != null) && useFlowHandlerString.equals("true")) {

                    useFlowHandler = true;

                }

                if ((useFlowHandlerString != null) && useFlowHandlerString.equals("true")) {

                    useFlowHandler = true;

                }

                if (useFlowHandler) {

                    if (node instanceof Element) {

                        final Element element = (Element) node;
                        final NodeList children = element.getElementsByTagName(FLOW_HANDLER);
                        Node flowHandlerNode = null;

                        if (children.getLength() >= 1) {

                            flowHandlerNode = children.item(0);

                        }

                        if (children.getLength() > 1) {

                            System.err.println("Non fatal error: There can be only one <" + FLOW_HANDLER + "> definition in a <" + URL_MAPPING + ">");

                        }

                        if (flowHandlerNode != null) {

                            if (flowHandlerNode instanceof Element) {

                                final Element flowElement = (Element) flowHandlerNode;

                                flowHandler = flowElement.getAttribute(FLOW_HANDLER_CLASS);

                                final NodeList results = flowElement.getElementsByTagName(HANDLER_RESULT);

                                if (results.getLength() > 0) {

                                    resultMappings = new HashMap<String, String>();

                                }

                                for (int resultLoop = 0; resultLoop < results.getLength(); resultLoop++) {

                                    final Node resultNode = results.item(resultLoop);

                                    if (resultNode instanceof Element) {

                                        final Element resultElement = (Element) resultNode;
                                        final String key = resultElement.getAttribute(RESULT);
                                        final String value = resultElement.getAttribute(NEXT_SCREEN);

                                        if (!resultMappings.containsKey(key)) {

                                            resultMappings.put(key, value);

                                        } else {

                                            System.err.println("*** Non Fatal errror: Screen " + url + " <" + FLOW_HANDLER + "> key " + "\"" + key + "\" defined more than one time");

                                        }

                                    }

                                }

                            }

                        }

                    }

                }

                final URLMapping mapping = new URLMapping(url, screen, isAction, useFlowHandler, webActionClass, flowHandler, resultMappings);

                if (!urlMappings.containsKey(url)) {

                    urlMappings.put(url, mapping);

                } else {

                    System.err.println("*** Non Fatal errror: Screen " + url + " defined more than once in screen definitions file");

                }

            }

        }

        return urlMappings;

    }

    /**
     * DOCUMENT ME!
     *
     * @param node DOCUMENT ME!
     * @param subTagName DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String getSubTagValue(final Node node, final String subTagName) {

        final String returnString = "";

        if (node != null) {

            final NodeList children = node.getChildNodes();

            for (int innerLoop = 0; innerLoop < children.getLength(); innerLoop++) {

                final Node child = children.item(innerLoop);

                if ((child != null) && (child.getNodeName() != null) && child.getNodeName().equals(subTagName)) {

                    final Node grandChild = child.getFirstChild();

                    if (grandChild.getNodeValue() != null) {

                        return grandChild.getNodeValue();

                    }

                }

            }

        }

        return returnString;

    }

    /**
     * DOCUMENT ME!
     *
     * @param root DOCUMENT ME!
     * @param tagName DOCUMENT ME!
     * @param subTagName DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String getSubTagValue(final Element root, final String tagName, final String subTagName) {

        final String returnString = "";
        final NodeList list = root.getElementsByTagName(tagName);

        for (int loop = 0; loop < list.getLength(); loop++) {

            final Node node = list.item(loop);

            if (node != null) {

                final NodeList children = node.getChildNodes();

                for (int innerLoop = 0; innerLoop < children.getLength(); innerLoop++) {

                    final Node child = children.item(innerLoop);

                    if ((child != null) && (child.getNodeName() != null) && child.getNodeName().equals(subTagName)) {

                        final Node grandChild = child.getFirstChild();

                        if (grandChild.getNodeValue() != null) {

                            return grandChild.getNodeValue();

                        }

                    }

                }

            }

        }

        return returnString;

    }

    /**
     * DOCUMENT ME!
     *
     * @param root DOCUMENT ME!
     * @param tagName DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String getTagValue(final Element root, final String tagName) {

        final String returnString = "";
        final NodeList list = root.getElementsByTagName(tagName);

        for (int loop = 0; loop < list.getLength(); loop++) {

            final Node node = list.item(loop);

            if (node != null) {

                final Node child = node.getFirstChild();

                if ((child != null) && (child.getNodeValue() != null)) {

                    return child.getNodeValue();

                }

            }

        }

        return returnString;

    }

}

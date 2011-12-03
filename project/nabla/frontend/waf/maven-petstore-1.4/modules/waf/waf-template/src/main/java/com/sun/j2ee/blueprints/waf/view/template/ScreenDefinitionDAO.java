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
 * @author $Author$
 * @version $Revision$
 *
 * @since $Date$
 */
public class ScreenDefinitionDAO {

    /**
     * DOCUMENT ME!
     */
    public static final String URL_MAPPING = "url-mapping";

    /**
     * DOCUMENT ME!
     */
    public static final String SCREEN_DEFINITION = "screen-definition";

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
    public static final String DEFAULT_TEMPLATE = "default-template";

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
    public static final String USE_REQUEST_HANDLER = "useRequestHandler";

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
    public static final String REQUEST_HANDLER_CLASS = "request-handler-class";

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
    public static final String NAME = "name";

    /**
     * DOCUMENT ME!
     */
    public static final String URL = "url";

    /**
     * DOCUMENT ME!
     */
    public static final String PARAMETER = "parameter";

    private static HashMap<String, Parameter> getParameters(final Node node) {

        final HashMap<String, Parameter> params = new HashMap<String, Parameter>();

        if (node != null) {

            final NodeList children = node.getChildNodes();

            for (int innerLoop = 0; innerLoop < children.getLength(); innerLoop++) {

                final Node child = children.item(innerLoop);

                if ((child != null) && (child.getNodeName() != null) && child.getNodeName().equals(PARAMETER)) {

                    if (child instanceof Element) {

                        final Element childElement = ((Element) child);
                        final String key = childElement.getAttribute(KEY);
                        final String value = childElement.getAttribute(VALUE);
                        final String directString = childElement.getAttribute(DIRECT);
                        boolean direct = false;

                        if ((directString != null) && directString.equals("true")) {

                            direct = true;

                        }

                        if (!params.containsKey(key)) {

                            params.put(key, new Parameter(key, value, direct));

                        } else {

                            System.err.println("*** Non Fatal errror: " + "Parameter " + key + " is defined more than once");

                        }

                    }

                }

            }

        }

        return params;

    }

    /**
     * DOCUMENT ME!
     *
     * @param root DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static HashMap<String, String> getScreenDefinitions(final Element root) {

        final HashMap<String, String> screensDefs = new HashMap<String, String>();
        final NodeList list = root.getElementsByTagName(SCREEN_DEFINITION);

        for (int loop = 0; loop < list.getLength(); loop++) {

            final Node node = list.item(loop);

            if (node != null) {

                String language = null;
                String url = null;

                if (node instanceof Element) {

                    language = ((Element) node).getAttribute(LANGUAGE);
                    url = ((Element) node).getAttribute(URL);

                }

                if ((language != null) && (url != null) && !screensDefs.containsKey(language)) {

                    screensDefs.put(language, url);

                } else {

                    System.err.println("*** Non Fatal errror: ScreenDefinitions for language " + language + " defined more than once in screen definitions file");

                }

            }

        }

        return screensDefs;

    }

    /**
     * DOCUMENT ME!
     *
     * @param root DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static Screens getScreens(final Element root) {

        final String defaultTemplate = getTagValue(root, DEFAULT_TEMPLATE);

        if (defaultTemplate == null) {

            System.err.println("*** ScreenDefinitionDAO error: " + " Default Template not Defined.");

            return null;

        }

        final Screens screens = new Screens(defaultTemplate);

        getTemplates(root, screens);

        final NodeList list = root.getElementsByTagName(SCREEN);

        for (int loop = 0; loop < list.getLength(); loop++) {

            final Node node = list.item(loop);

            if ((node != null) && (node instanceof Element)) {

                final String templateName = ((Element) node).getAttribute(TEMPLATE);
                final String screenName = ((Element) node).getAttribute(NAME);
                final HashMap<String, Parameter> parameters = getParameters(node);
                final Screen screen = new Screen(screenName, templateName, parameters);

                if (!screens.containsScreen(screenName)) {

                    screens.addScreen(screenName, screen);

                } else {

                    System.err.println("*** Non Fatal errror: Screen " + screenName + " defined more than once in screen definitions file");

                }

            }

        }

        return screens;

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

    /**
     * DOCUMENT ME!
     *
     * @param root DOCUMENT ME!
     * @param screens DOCUMENT ME!
     */
    public static void getTemplates(final Element root, final Screens screens) {

        final NodeList list = root.getElementsByTagName(TEMPLATE);

        for (int loop = 0; loop < list.getLength(); loop++) {

            final Node node = list.item(loop);
            String templateName = null;

            if (node != null) {

                if (node instanceof Element) {

                    templateName = ((Element) node).getAttribute(NAME);

                }

                final String templateURL = getSubTagValue(node, URL);

                if (!screens.containsTemplate(templateName)) {

                    screens.addTemplate(templateName, templateURL);

                } else {

                    System.err.println("*** Non Fatal errror: Template " + templateName + " defined more than once in screen definitions file");

                }

            }

        }

        ;

    }

    /**
     * DOCUMENT ME!
     *
     * @param url DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static Element loadDocument(final URL url) {

        Document doc = null;

        try {

            final InputSource xmlInp = new InputSource(url.openStream());

            final DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder parser = docBuilderFactory.newDocumentBuilder();

            doc = parser.parse(xmlInp);

            final Element root = doc.getDocumentElement();

            root.normalize();

            return root;

        } catch (final SAXParseException err) {

            System.err.println("ScreenFlowXmlDAO ** Parsing error" + ", line " + err.getLineNumber() + ", uri " + err.getSystemId());
            System.err.println("ScreenFlowXmlDAO error: " + err.getMessage());

        } catch (final SAXException e) {

            System.err.println("ScreenFlowXmlDAO error: " + e);

        } catch (final java.net.MalformedURLException mfx) {

            System.err.println("ScreenFlowXmlDAO error: " + mfx);

        } catch (final java.io.IOException e) {

            System.err.println("ScreenFlowXmlDAO error: " + e);

        } catch (final Exception pce) {

            System.err.println("ScreenFlowXmlDAO error: " + pce);

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
    public static Screens loadScreenDefinitions(final URL location) {

        final Element root = loadDocument(location);

        if (root != null) {

            return getScreens(root);

        } else {

            return null;

        }

    }

}

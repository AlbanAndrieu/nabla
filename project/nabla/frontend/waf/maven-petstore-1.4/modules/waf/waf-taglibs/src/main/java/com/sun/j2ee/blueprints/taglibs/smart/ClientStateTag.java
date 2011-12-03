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
package com.sun.j2ee.blueprints.taglibs.smart;

import com.sun.j2ee.blueprints.waf.controller.web.util.WebKeys;

import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;


/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 359 $
 *
 * @since $Date: 2010-09-17 02:14:34 +0200 (ven., 17 sept. 2010) $
 */
public class ClientStateTag extends BodyTagSupport {

    private static final long serialVersionUID = 1L;
    private String altText = "";
    private String buttonText;
    private String imageURL;
    private String cacheId;
    private String targetURL;
    private boolean encodeRequestAttributes = true;
    private boolean encodeRequestParameters = true;
    private Class<?> serializableClass = null;
    private HashMap<String, String> parameters = null;

    /**
     * DOCUMENT ME!
     *
     * @param cacheId DOCUMENT ME!
     */
    @Override
    public void setId(final String cacheId) {

        this.cacheId = cacheId;

    }

    /**
     * DOCUMENT ME!
     *
     * @param altText DOCUMENT ME!
     */
    public void setAlt(final String altText) {

        this.altText = altText;

    }

    /**
     * DOCUMENT ME!
     *
     * @param buttonText DOCUMENT ME!
     */
    public void setButtonText(final String buttonText) {

        this.buttonText = buttonText;

    }

    /**
     * DOCUMENT ME!
     *
     * @param imageURL DOCUMENT ME!
     */
    public void setImageURL(final String imageURL) {

        this.imageURL = imageURL;

    }

    /**
     * DOCUMENT ME!
     *
     * @param targetURL DOCUMENT ME!
     */
    public void setTargetURL(final String targetURL) {

        this.targetURL = targetURL;

    }

    /**
     * DOCUMENT ME!
     *
     * @param encodeRequestAttributes DOCUMENT ME!
     */
    public void setEncodeRequestAttributes(final boolean encodeRequestAttributes) {

        this.encodeRequestAttributes = encodeRequestAttributes;

    }

    /**
     * DOCUMENT ME!
     *
     * @param encodeRequestParameters DOCUMENT ME!
     */
    public void setEncodeRequestParameters(final boolean encodeRequestParameters) {

        this.encodeRequestAttributes = encodeRequestParameters;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws JspTagException DOCUMENT ME!
     */
    @Override
    public int doStartTag() throws JspTagException {

        if ((this.imageURL == null) && (this.buttonText == null)) {

            throw new JspTagException("ClientStateTag error: either an " + "imageURL or buttonText attribute must be specified.");

        }

        return BodyTag.EVAL_BODY_BUFFERED;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws JspTagException DOCUMENT ME!
     */
    @Override
    public int doEndTag() throws JspTagException {

        final HttpServletRequest request = ((HttpServletRequest) this.pageContext.getRequest());
        final StringBuffer buffer = new StringBuffer();

        buffer.append("<form method=\"POST\" action=\"" + this.targetURL + "\">");

        if (this.parameters != null) {

            final Iterator<String> it = this.parameters.keySet().iterator();

            while (it.hasNext()) {

                final String key = it.next();
                final String value = this.parameters.get(key);

                buffer.append(" <input type=\"hidden\" name=\"" + key + "\" value=\"" + value + "\" />");

            }

        }

        final String fullURL = request.getRequestURI();

        String targetURL = null;
        final int lastPathSeparator = fullURL.lastIndexOf("/") + 1;

        if (lastPathSeparator != -1) {

            targetURL = fullURL.substring(lastPathSeparator, fullURL.length());

        }

        buffer.append(" <input type=\"hidden\" name=\"referring_URL\"" + "value=\"" + targetURL + "\">");

        final String referringScreen = (String) request.getSession().getAttribute(WebKeys.PREVIOUS_SCREEN);

        buffer.append(" <input type=\"hidden\" name=\"referring_screen\"" + "value=\"" + referringScreen + "\">");
        buffer.append(" <input type=\"hidden\" name=\"cacheId\"" + "value=\"" + this.cacheId + "\">");

        final Map<?, ?> params = request.getParameterMap();

        if (!params.isEmpty() && this.encodeRequestParameters) {

            final Iterator<?> it = params.keySet().iterator();

            while (it.hasNext()) {

                final String key = (String) it.next();

                if (!key.startsWith(this.cacheId)) {

                    final String [] values = (String []) params.get(key);
                    final String valueString = values[0];

                    buffer.append(" <input type=\"hidden\" name=\"" + key + "\" value=\"" + valueString + "\" />");

                }

            }

        }

        if (this.encodeRequestAttributes) {

            final Enumeration<?> enumeration = request.getAttributeNames();

            while (enumeration.hasMoreElements()) {

                final String key = (String) enumeration.nextElement();

                if (!key.startsWith(this.cacheId) && !key.startsWith("javax.servlet")) {

                    final Object value = request.getAttribute(key);

                    if (this.serializableClass == null) {

                        try {

                            this.getClass();
                            this.serializableClass = Class.forName("java.io.Serializable");

                        } catch (final java.lang.ClassNotFoundException cnf) {

                            System.err.println("ClientStateTag caught: " + cnf);

                        }

                    }

                    if (this.serializableClass.isAssignableFrom(value.getClass())) {

                        try {

                            final ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            final ObjectOutput out = new ObjectOutputStream(bos);

                            out.writeObject(value);
                            out.close();
                            buffer.append(" <input type=\"hidden\" name=\"" + this.cacheId + "_attribute_" + key + "\" value=\"" + new String(Base64.encodeBase64(bos.toByteArray()), "ISO-8859-1") + "\" />");

                        } catch (final java.io.IOException iox) {

                            System.err.println("ClientStateTag caught: " + iox);

                        }

                    } else {

                        System.out.println(key + " not to Serializeable");

                    }

                }

            }

        }

        if (this.imageURL != null) {

            buffer.append(" <input alt=\"" + this.altText + "\" type=\"image\" " + "src=\"" + this.imageURL + "\"/>");

        } else {

            buffer.append(" <input alt=\"" + this.altText + "\"  type=\"submit\" " + "value=\"" + this.buttonText + "\"/>");

        }

        buffer.append("</form>");

        try {

            final JspWriter out = this.pageContext.getOut();

            out.print(buffer.toString());

        } catch (final IOException ioe) {

            System.err.println("ClientStateTag: Problems with writing...");

        }

        this.parameters = null;
        this.altText = "";
        this.buttonText = null;
        this.imageURL = null;
        this.cacheId = null;
        targetURL = null;
        this.encodeRequestAttributes = true;
        this.encodeRequestParameters = true;
        this.serializableClass = null;

        return Tag.EVAL_PAGE;

    }

    /**
     * DOCUMENT ME!
     *
     * @param key DOCUMENT ME!
     * @param value DOCUMENT ME!
     */
    public void putParameter(final String key, final String value) {

        if (this.parameters == null) {

            this.parameters = new HashMap<String, String>();

        }

        this.parameters.put(key, value);

    }

}

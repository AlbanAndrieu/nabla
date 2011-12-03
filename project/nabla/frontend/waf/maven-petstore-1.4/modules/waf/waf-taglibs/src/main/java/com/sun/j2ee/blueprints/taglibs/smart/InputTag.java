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

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;


/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 350 $
 *
 * @since $Date: 2010-09-14 01:50:19 +0200 (mar., 14 sept. 2010) $
 */
public class InputTag extends BodyTagSupport {

    private static final long serialVersionUID = 1L;
    String value;
    String name;
    String type;
    int size;
    String validation;
    int maxlength;
    String cssClass;

    /**
     * DOCUMENT ME!
     *
     * @param c DOCUMENT ME!
     */
    public void setCssClass(final String c) {

        this.cssClass = c;

    }

    /**
     * DOCUMENT ME!
     *
     * @param t DOCUMENT ME!
     */
    public void setType(final String t) {

        this.type = t;

    }

    /**
     * DOCUMENT ME!
     *
     * @param s DOCUMENT ME!
     */
    public void setSize(final int s) {

        this.size = s;

    }

    /**
     * DOCUMENT ME!
     *
     * @param n DOCUMENT ME!
     */
    public void setName(final String n) {

        this.name = n;

    }

    /**
     * DOCUMENT ME!
     *
     * @param v DOCUMENT ME!
     */
    public void setValue(final String v) {

        this.value = v;

    }

    /**
     * DOCUMENT ME!
     *
     * @param v DOCUMENT ME!
     */
    public void setValidation(final String v) {

        this.validation = v;

    }

    /**
     * DOCUMENT ME!
     *
     * @param ml DOCUMENT ME!
     */
    public void setMaxlength(final int ml) {

        this.maxlength = ml;

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

        return EVAL_BODY_BUFFERED;

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

        try {

            final FormTag tag = (FormTag) findAncestorWithClass(this, FormTag.class);

            if ((tag != null) && (this.validation != null)) {

                tag.putValidatedField(this.name, this.type);

            }

            final StringBuffer html = new StringBuffer();

            html.append("<input");
            html.append((this.size > 0) ? (" size=\"" + this.size + "\"") : "");
            html.append(" type=\"" + this.type + "\"");
            html.append((this.name != null) ? (" name=\"" + this.name + "\"") : "");
            html.append((this.value != null) ? (" value=\"" + this.value + "\"") : "");
            html.append((this.cssClass != null) ? (" class=\"" + this.cssClass + "\"") : "");
            html.append((this.maxlength > 0) ? (" maxlength=\"" + this.maxlength + "\"") : "");
            html.append(">");
            this.pageContext.getOut().print(html.toString());

            return EVAL_PAGE;

        } catch (final IOException e) {

            throw new JspTagException("InputTag: " + e.getMessage());

        }

    }

}

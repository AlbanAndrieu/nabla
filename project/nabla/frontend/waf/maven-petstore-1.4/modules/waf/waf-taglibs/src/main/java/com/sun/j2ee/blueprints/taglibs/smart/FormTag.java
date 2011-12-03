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

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;


/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 350 $
 *
 * @since $Date: 2010-09-14 01:50:19 +0200 (mar., 14 sept. 2010) $
 */
public class FormTag extends BodyTagSupport {

    private static final long serialVersionUID = 1L;
    Map<String, String> validatedFields = new TreeMap<String, String>();
    String name;
    String action;
    String method;
    String formHTML;

    /**
     * DOCUMENT ME!
     *
     * @param fieldName DOCUMENT ME!
     * @param fieldType DOCUMENT ME!
     */
    public void putValidatedField(final String fieldName, final String fieldType) {

        this.validatedFields.put(fieldName, fieldType);

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
     * @param a DOCUMENT ME!
     */
    public void setAction(final String a) {

        this.action = a;

    }

    /**
     * DOCUMENT ME!
     *
     * @param m DOCUMENT ME!
     */
    public void setMethod(final String m) {

        this.method = m;

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
    public int doAfterBody() throws JspTagException {

        final BodyContent bc = getBodyContent();

        this.formHTML = bc.getString();
        bc.clearBody();

        return SKIP_BODY;

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

            final StringBuffer html = new StringBuffer();
            final StringBuffer javaScript = new StringBuffer();

            javaScript.append("<script language=\"JavaScript\">\n");
            javaScript.append("function validate_" + this.name + "() {\n");
            javaScript.append("    var ret = true;\n");

            for (final Iterator<String> it = this.validatedFields.keySet().iterator(); it.hasNext();) {

                final String fieldName = it.next();

                this.validatedFields.get(fieldName);

                javaScript.append("    if (window.document.");
                javaScript.append(this.name + ".");
                javaScript.append(fieldName + ".");
                javaScript.append("value");
                javaScript.append(" ==");
                javaScript.append(" \"\"");
                javaScript.append(") {\n");
                javaScript.append("        alert(\"" + fieldName + " is empty.\");\n");
                javaScript.append("        ret = false;\n");
                javaScript.append("    }\n");

            }

            javaScript.append("    return ret;\n");
            javaScript.append("}\n");
            javaScript.append("</script>\n");

            html.append("<form");
            html.append(" name=\"" + this.name + "\"");
            html.append(" action=\"" + this.action + "\"");
            html.append(" method=\"" + this.method + "\"");
            html.append(" onSubmit=\"return validate_" + this.name + "();\"");
            html.append(">\n");
            html.append(this.formHTML);
            html.append("</form>");
            this.pageContext.getOut().print(javaScript.toString());
            this.pageContext.getOut().print(html.toString());

            return EVAL_PAGE;

        } catch (final IOException e) {

            throw new JspTagException("FormTag: " + e.getMessage());

        }

    }

}

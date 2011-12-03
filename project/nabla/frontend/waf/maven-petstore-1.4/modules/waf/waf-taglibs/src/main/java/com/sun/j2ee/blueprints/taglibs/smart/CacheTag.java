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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
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
public class CacheTag extends BodyTagSupport {

    private static final long serialVersionUID = 1L;
    private String scope;
    private String name;
    private long duration;
    private Entry entry;

    /**
     * DOCUMENT ME!
     *
     * @param s DOCUMENT ME!
     */
    public void setScope(final String s) {

        this.scope = s;

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
     * @param d DOCUMENT ME!
     */
    public void setDuration(final long d) {

        this.duration = d;

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

        this.entry = this.getEntry();

        if ((this.entry != null) && this.entry.isExpired()) {

            this.entry = null;
            this.removeEntry();

        }

        return (this.entry == null) ? BodyTag.EVAL_BODY_BUFFERED : Tag.SKIP_BODY;

    }

    private String getKey() {

        final HttpServletRequest req = ((HttpServletRequest) this.pageContext.getRequest());

        return (req.getRequestURL().toString() + '#' + this.name + '?' + req.getQueryString());

    }

    private Entry getEntry() {

        final String key = this.getKey();

        if ("context".equals(this.scope)) {

            return (Entry) this.pageContext.getServletContext().getAttribute(key);

        } else if ("session".equals(this.scope)) {

            return (Entry) this.pageContext.getSession().getAttribute(key);

        } else if ("request".equals(this.scope)) {

            return (Entry) this.pageContext.getRequest().getAttribute(key);

        } else if ("page".equals(this.scope)) {

            return (Entry) this.pageContext.getAttribute(key);

        }

        return null;

    }

    private void removeEntry() {

        final String key = this.getKey();

        if ("context".equals(this.scope)) {

            this.pageContext.getServletContext().removeAttribute(key);

        } else if ("session".equals(this.scope)) {

            this.pageContext.getSession().removeAttribute(key);

        } else if ("request".equals(this.scope)) {

            this.pageContext.getRequest().removeAttribute(key);

        } else if ("page".equals(this.scope)) {

            this.pageContext.removeAttribute(key);

        }

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

        if (this.entry == null) {

            final BodyContent bc = this.getBodyContent();

            if (bc != null) {

                final String content = bc.getString();

                this.entry = new Entry(content, this.duration);

                if ("context".equals(this.scope)) {

                    this.pageContext.getServletContext().setAttribute(this.getKey(), this.entry);

                } else if ("session".equals(this.scope)) {

                    this.pageContext.getSession().setAttribute(this.getKey(), this.entry);

                } else if ("request".equals(this.scope)) {

                    this.pageContext.getRequest().setAttribute(this.getKey(), this.entry);

                } else if ("page".equals(this.scope)) {

                    this.pageContext.setAttribute(this.getKey(), this.entry);

                }

                try {

                    final JspWriter out = bc.getEnclosingWriter();

                    out.print(content);

                } catch (final IOException ioe) {

                    System.err.println("ChacheTag: Problems with writing...");

                }

            }

        } else {

            try {

                final JspWriter out = this.pageContext.getOut();

                out.print(this.entry.getContent());

            } catch (final IOException ioe) {

                System.err.println("CacheTag: Problems with writing...");

            }

        }

        this.scope = null;
        this.name = null;
        this.duration = 0;
        this.entry = null;

        return Tag.EVAL_PAGE;

    }

    /**
     * DOCUMENT ME!
     *
     * @author $Author: albandri $
     * @version $Revision: 359 $
     *
     * @since $Date: 2010-09-17 02:14:34 +0200 (ven., 17 sept. 2010) $
     */
    class Entry implements java.io.Serializable {

        private static final long serialVersionUID = 1L;
        String content;
        long timestamp;
        long duration;

/**
         * Creates a new Entry object.
         * 
         * @param content DOCUMENT ME!
         * @param duration DOCUMENT ME!
         */
        public Entry(final String content, final long duration) {

            this.content = content;
            this.timestamp = System.currentTimeMillis();
            this.duration = duration;

        }

        /**
         * DOCUMENT ME!
         *
         * @return DOCUMENT ME!
         */
        public String getContent() {

            return this.content;

        }

        /**
         * DOCUMENT ME!
         *
         * @return DOCUMENT ME!
         */
        public boolean isExpired() {

            final long currentTime = System.currentTimeMillis();

            return ((currentTime - this.timestamp) > this.duration);

        }

    }

}

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
package org.andromda.cartridges.jsf.portlet.myfaces.tomahawk.support;

import org.xml.sax.InputSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import java.nio.charset.Charset;

import java.util.Locale;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * @author Sylvain Vieujot (latest modification by $Author: cwbrandon $)
 * @author Chad Brandon
 */
public class ExtensionsResponseWrapper extends HttpServletResponseWrapper implements RenderResponse
{

    private ByteArrayOutputStream stream      = null;
    private PrintWriter           printWriter = null;
    private String                contentType;
    private final RenderResponse  response;

    /**
     * @param servletResponse
     * @param response
     */
    public ExtensionsResponseWrapper(final HttpServletResponse servletResponse, final RenderResponse response)
    {
        super(servletResponse);
        this.response = response;
        stream = new ByteArrayOutputStream();

    }

    /**
     * @return stream.toByteArray()
     */
    public byte[] getBytes()
    {

        return stream.toByteArray();

    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString()
    {

        try
        {

            return stream.toString(getCharacterEncoding());

        }
        catch (final UnsupportedEncodingException e)
        {

            // an attempt to set an invalid character encoding would have caused
            // this exception before
            throw new RuntimeException("Response accepted invalid character encoding " + getCharacterEncoding());

        }

    }

    /**
     * This method is used by Tomcat.
     */
    @Override
    public PrintWriter getWriter()
    {

        if (printWriter == null)
        {

            final OutputStreamWriter streamWriter = new OutputStreamWriter(stream, Charset.forName(getCharacterEncoding()));

            printWriter = new PrintWriter(streamWriter, true);

        }

        return printWriter;

    }

    /**
     * This method is used by Jetty.
     *
     * @throws IOException
     */
    @Override
    public ServletOutputStream getOutputStream() throws IOException
    {

        return new MyServletOutputStream(stream);

    }

    /**
     * @return inputSource
     */
    public InputSource getInputSource()
    {

        final ByteArrayInputStream bais = new ByteArrayInputStream(stream.toByteArray());

        return new InputSource(bais);

    }

    /**
     * Prevent content-length being set as the page might be modified.
     */
    @Override
    public void setContentLength(final int contentLength)
    {

    }

    /**
     * @see javax.servlet.ServletResponseWrapper#setContentType(String)
     */
    @Override
    public void setContentType(final String contentType)
    {

        super.setContentType(contentType);
        this.contentType = contentType;

    }

    /**
     * @see javax.servlet.ServletResponseWrapper#getContentType()
     */
    @Override
    public String getContentType()
    {

        return contentType;

    }

    /**
     * @see javax.servlet.ServletResponseWrapper#flushBuffer()
     */
    @Override
    public void flushBuffer() throws IOException
    {

        stream.flush();

    }

    /**
     *
     */
    public void finishResponse()
    {

        try
        {

            if (printWriter != null)
            {

                printWriter.close();

            } else
            {

                if (stream != null)
                {

                    stream.close();

                }

            }

        }
        catch (final IOException e)
        {

            // Ignore
        }

    }

    /**
     * Used in the <code>getOutputStream()</code> method.
     */
    private class MyServletOutputStream extends ServletOutputStream
    {

        private final OutputStream outputStream;

        /**
         * Creates a new MyServletOutputStream object.
         *
         * @param outputStream DOCUMENT ME!
         */
        public MyServletOutputStream(final OutputStream outputStream)
        {

            this.outputStream = outputStream;

        }

        /**
         * DOCUMENT ME!
         *
         * @param b DOCUMENT ME!
         *
         * @throws IOException DOCUMENT ME!
         */
        @Override
        public void write(final int b) throws IOException
        {

            outputStream.write(b);

        }

        /**
         * DOCUMENT ME!
         *
         * @param bytes DOCUMENT ME!
         *
         * @throws IOException DOCUMENT ME!
         */
        @Override
        public void write(final byte[] bytes) throws IOException
        {

            outputStream.write(bytes);

        }

        /**
         * DOCUMENT ME!
         *
         * @param bytes DOCUMENT ME!
         * @param off DOCUMENT ME!
         * @param len DOCUMENT ME!
         *
         * @throws IOException DOCUMENT ME!
         */
        @Override
        public void write(final byte[] bytes, final int off, final int len) throws IOException
        {

            outputStream.write(bytes, off, len);

        }

    }

    /**
     * @see javax.portlet.RenderResponse#createActionURL()
     */
    public PortletURL createActionURL()
    {

        return response.createActionURL();

    }

    /**
     * @see javax.portlet.RenderResponse#createRenderURL()
     */
    public PortletURL createRenderURL()
    {

        return response.createRenderURL();

    }

    /**
     * @see javax.servlet.ServletResponseWrapper#getBufferSize()
     */
    @Override
    public int getBufferSize()
    {

        return response.getBufferSize();

    }

    /**
     * @see javax.servlet.ServletResponseWrapper#getCharacterEncoding()
     */
    @Override
    public String getCharacterEncoding()
    {

        return response.getCharacterEncoding();

    }

    /**
     * @see javax.servlet.ServletResponseWrapper#getLocale()
     */
    @Override
    public Locale getLocale()
    {

        return response.getLocale();

    }

    /**
     * @see javax.portlet.RenderResponse#getNamespace()
     */
    public String getNamespace()
    {

        return response.getNamespace();

    }

    /**
     * @see javax.portlet.RenderResponse#getPortletOutputStream()
     */
    public OutputStream getPortletOutputStream() throws IOException
    {

        return stream;

    }

    /**
     * @see javax.servlet.ServletResponseWrapper#isCommitted()
     */
    @Override
    public boolean isCommitted()
    {

        return response.isCommitted();

    }

    /**
     * @see javax.servlet.ServletResponseWrapper#reset()
     */
    @Override
    public void reset()
    {

        response.reset();

    }

    /**
     * @see javax.servlet.ServletResponseWrapper#resetBuffer()
     */
    @Override
    public void resetBuffer()
    {

        response.resetBuffer();

    }

    /**
     * @see javax.servlet.ServletResponseWrapper#setBufferSize(int)
     */
    @Override
    public void setBufferSize(final int bufferSize)
    {

        response.setBufferSize(bufferSize);

    }

    /**
     * @see javax.portlet.RenderResponse#setTitle(String)
     */
    public void setTitle(final String title)
    {

        response.setTitle(title);

    }

    /**
     * @see javax.portlet.PortletResponse#addProperty(String, String)
     */
    public void addProperty(final String arg0, final String arg1)
    {

        response.addProperty(arg0, arg1);

    }

    /**
     * @see javax.servlet.http.HttpServletResponseWrapper#encodeURL(String)
     */
    @Override
    public String encodeURL(final String arg0)
    {

        return response.encodeURL(arg0);

    }

    /**
     * @see javax.portlet.PortletResponse#setProperty(String, String)
     */
    public void setProperty(final String arg0, final String arg1)
    {

        response.setProperty(arg0, arg1);

    }

}

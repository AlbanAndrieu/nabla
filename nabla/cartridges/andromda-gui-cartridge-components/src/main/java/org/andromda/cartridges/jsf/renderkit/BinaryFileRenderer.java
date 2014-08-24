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
package org.andromda.cartridges.jsf.renderkit;

import org.andromda.cartridges.jsf.component.BinaryFile;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;

import javax.servlet.http.HttpServletResponse;

/**
 * A custom renderer for rendering a binary file.
 * 
 * @author Chad Brandon
 */
public class BinaryFileRenderer extends Renderer
{

    /**
     * Gets the current response instance.
     * 
     * @return the current response.
     */
    private HttpServletResponse getResponse(final FacesContext context)
    {

        return (HttpServletResponse) context.getExternalContext().getResponse();

    }

    private static final int BUFFER_SIZE = 4096;

    /**
     * DOCUMENT ME!
     * 
     * @param context DOCUMENT ME!
     * @param component DOCUMENT ME!
     * @throws IOException DOCUMENT ME!
     */
    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException
    {

        final BinaryFile fileComponent = (BinaryFile) component;

        if (fileComponent.isRendered())
        {

            final HttpServletResponse response = this.getResponse(context);
            final OutputStream stream = response.getOutputStream();

            // - reset the response to clear out any any headers (i.e. so
            // the user doesn't get "unable to open..." when using IE.)
            response.reset();

            final String fileName = fileComponent.getFileName();

            if (fileComponent.isPrompt() && (fileName != null) && (fileName.trim().length() > 0))
            {

                response.addHeader("Content-disposition", "attachment; filename=\"" + fileName + '"');

            }

            Object value = fileComponent.getValue();
            final String contentType = fileComponent.getContentType();

            // - for IE we need to set the content type, content length and buffer size and
            // then the flush the response right away because it seems as if there is any lag time
            // IE just displays a blank page. With mozilla based clients reports display correctly regardless.
            if (StringUtils.isNotBlank(contentType))
            {

                response.setContentType(contentType);

            }

            final String encoding = fileComponent.getEncoding();

            if (StringUtils.isNotBlank(encoding))
            {

                response.setCharacterEncoding(encoding);

            }

            if (value != null)
            {

                if (value instanceof String)
                {

                    value = StringUtils.isNotBlank(encoding) ? ((String) value).getBytes(encoding) : ((String) value).getBytes();

                }

                if (value instanceof byte[])
                {

                    byte[] file = (byte[]) value;

                    response.setBufferSize(file.length);
                    response.setContentLength(file.length);
                    response.flushBuffer();
                    stream.write(file);

                } else if (value instanceof InputStream)
                {

                    final InputStream report = (InputStream) value;
                    final byte[] buffer = new byte[BUFFER_SIZE];

                    response.setBufferSize(BUFFER_SIZE);
                    response.flushBuffer();

                    for (int ctr = 0; (ctr = report.read(buffer)) > 0;)
                    {

                        stream.write(buffer, 0, ctr);

                    }

                    stream.flush();

                }

            }

        }

    }

    /**
     * DOCUMENT ME!
     * 
     * @param context DOCUMENT ME!
     * @param component DOCUMENT ME!
     * @throws IOException DOCUMENT ME!
     */
    @Override
    public void encodeEnd(final FacesContext context, final UIComponent component) throws IOException
    {

        final BinaryFile fileComponent = (BinaryFile) component;

        if (fileComponent.isRendered())
        {

            final HttpServletResponse response = this.getResponse(context);
            final OutputStream stream = response.getOutputStream();

            stream.flush();
            stream.close();

        }

    }

}

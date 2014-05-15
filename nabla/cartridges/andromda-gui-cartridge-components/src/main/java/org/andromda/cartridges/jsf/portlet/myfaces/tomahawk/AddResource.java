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
package org.andromda.cartridges.jsf.portlet.myfaces.tomahawk;

import org.apache.myfaces.renderkit.html.util.HtmlBufferResponseWriterWrapper;
import org.apache.myfaces.shared_tomahawk.renderkit.html.HtmlRendererUtils;
import org.apache.myfaces.shared_tomahawk.renderkit.html.HtmlResponseWriterImpl;

import java.io.IOException;

import javax.faces.context.ResponseWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Extends the default MyFaces Tomahawk {DefaultAddResource} class in order to
 * allow injection of the required content into portlets.
 *
 * @author Chad Brandon
 */
public class AddResource extends org.apache.myfaces.renderkit.html.util.DefaultAddResource
{

    /**
     * Overridden to allow injection of the required content for portlets (i.e. which have no <head/>, <body/>, etc tags).
     *
     * @see org.apache.myfaces.renderkit.html.util.DefaultAddResource#writeWithFullHeader(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void writeWithFullHeader(HttpServletRequest request, HttpServletResponse response) throws IOException
    {

        if (!parserCalled)
        {

            throw new IOException("Method parseResponse has to be called first");

        }

        final ResponseWriter writer = new HtmlResponseWriterImpl(response.getWriter(), HtmlRendererUtils.selectContentType(request.getHeader("accept")), response.getCharacterEncoding());

        // - insert anything that was supposed to go into the <head/>
        headerInsertPosition = 0;

        final HtmlBufferResponseWriterWrapper headContents = HtmlBufferResponseWriterWrapper.getInstance(writer);

        for (final PositionedInfo positionedInfo : (Iterable<PositionedInfo>) getHeaderBeginInfos())
        {

            headContents.write("\n");

            if (!(positionedInfo instanceof WritablePositionedInfo))
            {

                throw new IllegalStateException("positionedInfo of type : " + positionedInfo.getClass().getName());

            }

            ((WritablePositionedInfo) positionedInfo).writePositionedInfo(response, headContents);

        }

        originalResponse.insert(headerInsertPosition, headContents.toString());

        // TODO: fix this
        /*
         * StringBuilder buf = new StringBuilder();
         * Set bodyInfos = getBodyOnloadInfos();
         * if (bodyInfos.size() > 0)
         * {
         * int i = 0;
         * for (Iterator it = getBodyOnloadInfos().iterator(); it.hasNext();)
         * {
         * AttributeInfo positionedInfo = (AttributeInfo) it.next();
         * if (i == 0)
         * {
         * buf.append(positionedInfo.getAttributeName());
         * buf.append("=\"");
         * }
         * buf.append(positionedInfo.getAttributeValue());
         * i++;
         * }
         * buf.append("\"");
         * originalResponse.insert(bodyInsertPosition - 1, " " + buf.toString());
         * }
         */

        // insert all the items that want to go immediately after the <body> tag.
        final HtmlBufferResponseWriterWrapper afterBodyContents = HtmlBufferResponseWriterWrapper.getInstance(writer);

        for (final PositionedInfo positionedInfo : (Iterable<PositionedInfo>) getBodyEndInfos())
        {

            afterBodyContents.write("\n");

            if (!(positionedInfo instanceof WritablePositionedInfo))
            {

                throw new IllegalStateException("positionedInfo of type : " + positionedInfo.getClass().getName());

            }

            ((WritablePositionedInfo) positionedInfo).writePositionedInfo(response, afterBodyContents);

        }

        originalResponse.insert(headContents.toString().length() + 1, afterBodyContents.toString());

    }

    /**
     * @see org.apache.myfaces.renderkit.html.util.DefaultAddResource#writeResponse(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public void writeResponse(HttpServletRequest request, HttpServletResponse response) throws IOException
    {

        ResponseWriter writer = new HtmlResponseWriterImpl(response.getWriter(), HtmlRendererUtils.selectContentType(null), response.getCharacterEncoding());

        writer.write(originalResponse.toString());

    }

}

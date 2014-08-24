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
package org.andromda.cartridges.jsf;

import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A servlet allowing us to load resources from a jar and make them available to
 * the web application.
 */
public class JSFServlet extends HttpServlet
{

    private static final long serialVersionUID = 34L;
    private final Logger      logger_          = Logger.getLogger(JSFServlet.class);

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
    {

        final String uri = request.getRequestURI();
        final String path = '/' + uri.substring(uri.indexOf(Constants.RESOURCE_CONTEXT) + Constants.RESOURCE_CONTEXT.length() + 1);
        final InputStream resource = JSFServlet.class.getResourceAsStream(path);

        if (resource == null)
        {

            throw new ServletException("Could not load resource from path '" + path + '\'');

        }

        this.logger_.info("JSFServlet : resource : " + resource.toString() + " - " + path);

        // - write resource to the output stream
        final OutputStream out = response.getOutputStream();
        final byte[] buffer = new byte[2048];
        final BufferedInputStream inputStream = new BufferedInputStream(resource);
        int read = 0;

        read = inputStream.read(buffer);

        while (read != -1)
        {

            out.write(buffer, 0, read);
            read = inputStream.read(buffer);

        }

        inputStream.close();
        out.flush();
        out.close();

    }

}

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
package com.nabla.project.application.api;

import com.nabla.project.application.api.config.Destination;
import com.nabla.project.application.api.config.Format;
import com.nabla.project.application.api.config.Packaging;
import com.nabla.project.application.api.config.Perimeter;
import com.nabla.project.application.api.config.RequestId;

/**
 * DOCUMENT ME!
 * 
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
 */
public class ExtractServiceParameterWrapper
{

    private Perimeter   perimeter;
    private Destination output;
    private Destination status;
    private Format      format;
    private Packaging   packaging;
    private RequestId   requestId;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public Format getFormat()
    {

        return format;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param format DOCUMENT ME!
     */
    public void setFormat(Format format)
    {

        this.format = format;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public Destination getOutput()
    {

        return output;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param output DOCUMENT ME!
     */
    public void setOutput(Destination output)
    {

        this.output = output;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public Packaging getPackaging()
    {

        return packaging;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param packaging DOCUMENT ME!
     */
    public void setPackaging(Packaging packaging)
    {

        this.packaging = packaging;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public Perimeter getPerimeter()
    {

        return perimeter;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param perimeter DOCUMENT ME!
     */
    public void setPerimeter(Perimeter perimeter)
    {

        this.perimeter = perimeter;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public RequestId getRequestId()
    {

        return requestId;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param requestId DOCUMENT ME!
     */
    public void setRequestId(RequestId requestId)
    {

        this.requestId = requestId;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public Destination getStatus()
    {

        return status;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param status DOCUMENT ME!
     */
    public void setStatus(Destination status)
    {

        this.status = status;

    }

}

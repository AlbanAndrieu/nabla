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
package com.nabla.project.application.core.flow;

import com.nabla.project.application.api.ExtractService;
import com.nabla.project.application.api.RequestStatus;
import com.nabla.project.application.api.UnsupportedRecoveryException;
import com.nabla.project.application.api.config.Destination;
import com.nabla.project.application.api.config.Format;
import com.nabla.project.application.api.config.Packaging;
import com.nabla.project.application.api.config.Perimeter;
import com.nabla.project.application.api.config.RequestId;
import com.nabla.project.application.core.flow.writer.FileDestination;

/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
  */
public class ExtractServiceSample implements ExtractService
{

    /**
     * DOCUMENT ME!
     *
     * @param perimeter DOCUMENT ME!
     * @param id DOCUMENT ME!
     * @param output DOCUMENT ME!
     * @param status DOCUMENT ME!
     * @param format DOCUMENT ME!
     * @param packaging DOCUMENT ME!
     */
    public void extractPerimeter(Perimeter perimeter, RequestId id, Destination output, Destination status, Format format, Packaging packaging)
    {

        System.out.println("output : " + ((FileDestination) output).getUrl());

    }

    /**
     * DOCUMENT ME!
     *
     * @param status DOCUMENT ME!
     */
    public void recoverRequest(RequestStatus status)
    {

        throw new UnsupportedRecoveryException();

    }

    /**
     * DOCUMENT ME!
     *
     * @param f DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean supportsFormat(Format f)
    {

        switch (f)
        {

            case XML:
                return true;

            default:
                return false;

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @param outputDestination DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean supportsOutputDestination(Destination outputDestination)
    {

        return outputDestination instanceof FileDestination;

    }

    /**
     * DOCUMENT ME!
     *
     * @param p DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean supportsPackaging(Packaging p)
    {

        switch (p)
        {

            case STANDARD:
                return true;

            default:
                return false;

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @param p DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean supportsPerimeter(Perimeter p)
    {

        return true;

    }

    /**
     * DOCUMENT ME!
     *
     * @param statusDestination DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean supportsStatusDestination(Destination statusDestination)
    {

        return statusDestination instanceof FileDestination;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getExtractServiceId()
    {

        return "Extract_Service_Sample";

    }

}

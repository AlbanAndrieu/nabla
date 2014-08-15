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
package com.nabla.project.application.api.config;

import org.apache.log4j.Logger;

import java.io.Serializable;

/**
 * DOCUMENT ME!
 * 
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
 */
public class RequestId implements Serializable, RequestIdMBean
{

    private static final long serialVersionUID = 1L;
    protected static Logger   logger           = Logger.getLogger(RequestId.class);
    protected static int      _id              = 0;
    protected String          id;

    /**
     * Creates a new RequestId object.
     */
    public RequestId()
    {
        this(Integer.toString(++_id));

    }

    /**
     * Creates a new RequestId object.
     * 
     * @param id DOCUMENT ME!
     */
    public RequestId(String id)
    {

        this.id = id;

        if (logger.isDebugEnabled())
        {

            logger.debug("RequestId(" + id + ")");

        }

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getId()
    {

        return id;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param id DOCUMENT ME!
     */
    public void setId(String id)
    {

        this.id = id;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param other DOCUMENT ME!
     * @return DOCUMENT ME!
     */
    public boolean equals(Object other)
    {

        return (other instanceof RequestId) && (other.toString().equals(id));

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String toString()
    {

        return id;

    }

}

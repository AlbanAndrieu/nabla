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
package com.nabla.project.application.core.pipe.container;

import com.nabla.project.application.api.config.RequestId;
import com.nabla.project.application.api.helpers.Pipe;
import com.nabla.project.application.api.helpers.PipePublisher;
import com.nabla.project.application.core.pipe.PipeBlockingQueuePublisher;
import com.nabla.project.application.core.pipe.PipeBlockingQueueService;
import com.nabla.project.application.core.pipe.PipeQueueMBean;
import com.nabla.project.application.core.spring.PipeConfig;

/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
  *
 * @param <X> DOCUMENT ME!
 */
public class PipePublisherContainer<X> implements Pipe<X>, PipeQueueMBean
{

    protected String           name;
    protected RequestId        requestId;
    protected PipePublisher<X> pipePublisher;

    /**
     * Creates a new PipePublisherContainer object.
     *
     * @param name DOCUMENT ME!
     * @param requestId DOCUMENT ME!
     */
    public PipePublisherContainer(String name, RequestId requestId)
    {

        setName(name);
        setRequestId(requestId);
        PipeBlockingQueueService.createPipeBlockingQueue(this.name, this.requestId, PipeConfig.getInstance().getQueueSize());
        pipePublisher = new PipeBlockingQueuePublisher<X>(this.name, this.requestId);

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getName()
    {

        return name;

    }

    /**
     * DOCUMENT ME!
     *
     * @param name DOCUMENT ME!
     */
    public void setName(String name)
    {

        this.name = name;

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
    public PipePublisher<X> getPipePublisher()
    {

        return pipePublisher;

    }

    /**
     * DOCUMENT ME!
     *
     * @param pipePublisher DOCUMENT ME!
     */
    public void setPipePublisher(PipePublisher<X> pipePublisher)
    {

        this.pipePublisher = pipePublisher;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String toString()
    {

        return name;

    }

}

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
package com.nabla.project.application.core.pipe;

import com.nabla.project.application.api.config.RequestId;
import com.nabla.project.application.core.pipe.PipeBlockingQueueListener;

import org.apache.log4j.Logger;

/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
  */
public class PipeListenerContainerCounter implements Runnable
{

    protected Logger    logger  = Logger.getLogger(this.getClass());
    protected int       counter = 0;
    protected String    name;
    protected RequestId requestId;

    /**
     * Creates a new PipeListenerContainerCounter object.
     *
     * @param name DOCUMENT ME!
     * @param requestId DOCUMENT ME!
     */
    public PipeListenerContainerCounter(String name, RequestId requestId)
    {

        setName(name);
        setRequestId(requestId);

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
    public int getCounter()
    {

        return counter;

    }

    /**
     * DOCUMENT ME!
     *
     * @param counter DOCUMENT ME!
     */
    public void setCounter(int counter)
    {

        this.counter = counter;

    }

    /**
     * DOCUMENT ME!
     */
    public void run()
    {

        Thread.currentThread().setName("PipeContainerCounter_" + this.name + this.requestId);
        logger.info("Entering consumer thread");
        new PipeBlockingQueueListener<Object>(this.name, this.requestId)
        {

            @Override
            public void onMessage(Object o)
            {

                counter++;

            }

        };
        logger.info("Exiting consumer thread");

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Thread launch()
    {

        Thread thread = new Thread(this);

        thread.start();

        return thread;

    }

}

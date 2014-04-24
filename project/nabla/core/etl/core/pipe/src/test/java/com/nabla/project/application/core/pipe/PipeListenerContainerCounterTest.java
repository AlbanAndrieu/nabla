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
import com.nabla.project.application.api.helpers.PipePublisher;
import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.core.spring.PipeConfig;

import junit.framework.TestCase;

/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
  */
public class PipeListenerContainerCounterTest extends TestCase
{

    protected String    pipeName = "pipeTest";
    protected RequestId requestId;

    protected void setUp()
    {

        PipeBlockingQueueService.createPipeBlockingQueue(this.pipeName, this.requestId, PipeConfig.getInstance().getQueueSize());

    }

    protected void tearDown()
    {

        try
        {

            PipeBlockingQueueService.destroyQueue(this.pipeName, this.requestId);

        }
        catch (Throwable ex)
        {

        }

    }

    /**
     * Creates a new PipeListenerContainerCounterTest object.
     */
    public PipeListenerContainerCounterTest()
    {

        Log.init();
        this.requestId = new RequestId();

    }

    /**
     * DOCUMENT ME!
     *
     * @throws Exception DOCUMENT ME!
     */
    public void testPipeContainerCounterEmpty() throws Exception
    {

        PipePublisher<Object> pipeOut = new PipeBlockingQueuePublisher<Object>(this.pipeName, this.requestId);
        PipeListenerContainerCounter pipeContainerCounter = new PipeListenerContainerCounter(this.pipeName, this.requestId);
        Thread thread = pipeContainerCounter.launch();

        pipeOut.closeQueue();
        thread.join();

        assertEquals(0, pipeContainerCounter.getCounter());

    }

    /**
     * DOCUMENT ME!
     *
     * @throws Exception DOCUMENT ME!
     */
    public void testPipeContainerCounter() throws Exception
    {

        PipePublisher<Object> pipeOut = new PipeBlockingQueuePublisher<Object>(this.pipeName, this.requestId);
        PipeListenerContainerCounter pipeContainerCounter = new PipeListenerContainerCounter(this.pipeName, this.requestId);
        Thread thread = pipeContainerCounter.launch();

        int nbTests = 10;

        for (int i = 0; i < nbTests; i++)
        {

            pipeOut.publish(new Integer(i));

        }

        pipeOut.closeQueue();
        thread.join();

        assertEquals(nbTests, pipeContainerCounter.getCounter());

    }

}

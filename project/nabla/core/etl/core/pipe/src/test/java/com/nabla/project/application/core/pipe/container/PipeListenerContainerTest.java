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
import com.nabla.project.application.api.helpers.PipePublisher;
import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.core.pipe.PipeBlockingQueuePublisher;
import com.nabla.project.application.core.pipe.PipeBlockingQueueService;
import com.nabla.project.application.core.spring.PipeConfig;

import junit.framework.TestCase;

/**
 * DOCUMENT ME!
 * 
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
 */
public class PipeListenerContainerTest extends TestCase
{

    protected String    pipeName = "pipeTest";
    protected RequestId requestId;

    protected void setUp()
    {

        Log.init();

    }

    protected void tearDown()
    {

        try
        {

            PipeBlockingQueueService.destroyQueue(this.pipeName, this.requestId);

        } catch (Throwable ex)
        {

        }

    }

    /**
     * Creates a new PipeListenerContainerTest object.
     */
    public PipeListenerContainerTest()
    {

        this.requestId = new RequestId();

    }

    /**
     * DOCUMENT ME!
     * 
     * @throws Exception DOCUMENT ME!
     */
    public void testPipeContainerCounterEmpty() throws Exception
    {

        PipeBlockingQueueService.createPipeBlockingQueue(this.pipeName, this.requestId, PipeConfig.getInstance().getQueueSize());

        PipePublisher<Object> pipeOut = new PipeBlockingQueuePublisher<Object>(this.pipeName, this.requestId);
        PipeListenerContainer pipeContainer = new PipeListenerContainer(this.pipeName, this.requestId);
        Thread thread = pipeContainer.launch();

        pipeOut.closeQueue();
        thread.join();

        assertNotNull(pipeContainer.getList());
        assertEquals(0, pipeContainer.getList().size());

    }

    /**
     * DOCUMENT ME!
     * 
     * @throws Exception DOCUMENT ME!
     */
    public void testPipeContainerCounter() throws Exception
    {

        PipeBlockingQueueService.createPipeBlockingQueue(this.pipeName, this.requestId, PipeConfig.getInstance().getQueueSize());

        PipePublisher<Object> pipeOut = new PipeBlockingQueuePublisher<Object>(this.pipeName, this.requestId);
        PipeListenerContainer pipeContainer = new PipeListenerContainer(this.pipeName, this.requestId);
        Thread thread = pipeContainer.launch();

        int nbTests = 10;

        for (int i = 0; i < nbTests; i++)
        {

            pipeOut.publish(new Integer(i));

        }

        pipeOut.closeQueue();
        thread.join();

        assertNotNull(pipeContainer.getList());
        assertEquals(10, pipeContainer.getList().size());

        for (int i = 0; i < nbTests; i++)
        {

            assertEquals(new Integer(i), pipeContainer.getList().get(i));

        }

    }

}

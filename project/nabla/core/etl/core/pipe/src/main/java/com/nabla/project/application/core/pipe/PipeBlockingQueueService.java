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

import com.nabla.project.application.api.TechnicalException;
import com.nabla.project.application.api.config.RequestId;
import com.nabla.project.application.api.helpers.Pipe;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
  */
public class PipeBlockingQueueService
{

    private static Logger                         logger       = Logger.getLogger(PipeBlockingQueueService.class);
    private static Map<String, PipeBlockingQueue> queueMap     = new HashMap<String, PipeBlockingQueue>();
    private static PipeBlockingQueueService       queueService = new PipeBlockingQueueService();

    /**
     * DOCUMENT ME!
     *
     * @param <T> DOCUMENT ME!
     * @param name DOCUMENT ME!
     * @param requestId DOCUMENT ME!
     * @param queueSize DOCUMENT ME!
     */
    public static <T> void createPipeBlockingQueue(String name, RequestId requestId, int queueSize)
    {

        if (logger.isDebugEnabled())
        {
            logger.debug("Create a new queue named : " + name + requestId);
        }

        synchronized (queueMap)
        {

            if (getQueue(name, requestId) == null)
            {

                queueMap.put(name + requestId, queueService.new PipeBlockingQueue<T>(queueSize));

            } else
            {

                logger.error("ERROR when creating the new queue named : " + name + requestId);
                throw new TechnicalException("A queue with this name already exist");

            }

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @param name DOCUMENT ME!
     * @param requestId DOCUMENT ME!
     */
    public static void destroyQueue(String name, RequestId requestId)
    {

        if (logger.isDebugEnabled())
        {
            logger.debug("Destroying the queue named : " + name + requestId);
        }

        synchronized (queueMap)
        {

            if (queueMap.get(name + requestId) == null)
            {

                logger.error("ERROR when destroying the queue named : " + name + requestId + " (Queue not found)");
                throw new TechnicalException("The queue doesn't exist.");

            } else
            {

                PipeBlockingQueue queue = queueMap.remove(name + requestId);

                queue.close();

            }

        }

    }

    /**
     * DOCUMENT ME!
     */
    public static void destroyAllQueue()
    {

        synchronized (queueMap)
        {

            if (logger.isDebugEnabled())
            {
                logger.debug("destroyAllQueue");
            }

            Set<String> queues = new HashSet<String>();

            queues.addAll(queueMap.keySet());

            for (int i = 0; i < queues.size(); i++)
            {

                String queueName = (String) queues.toArray()[i];

                if (logger.isDebugEnabled())
                {
                    logger.debug("Destroying the queue named : " + queueName);
                }

                PipeBlockingQueue queue = queueMap.remove(queueName);

                queue.close();

            }

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @param queues DOCUMENT ME!
     */
    public static void destroyQueues(Set<Pipe<Object>> queues)
    {

        for (Pipe<Object> pipe : queues)
        {

            PipeBlockingQueueService.destroyQueue(pipe.getName(), pipe.getRequestId());

        }

    }

    static <T> PipeBlockingQueue<T> getQueue(String name, RequestId requestId)
    {

        synchronized (queueMap)
        {

            return queueMap.get(name + requestId);

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @author $Author: albandri $
     * @version $Revision: 358 $
     * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
      *
     * @param <T> DOCUMENT ME!
     */
    class PipeBlockingQueue<T> extends ArrayBlockingQueue<T>
    {

        /**
         * DOCUMENT ME!
         */
        public AtomicBoolean isOpen = new AtomicBoolean(true);

        /**
         * Creates a new PipeBlockingQueue object.
         *
         * @param capacity DOCUMENT ME!
         */
        public PipeBlockingQueue(int capacity)
        {
            super(capacity, false);

        }

        /**
         * DOCUMENT ME!
         *
         * @param timeout DOCUMENT ME!
         * @param unit DOCUMENT ME!
         *
         * @return DOCUMENT ME!
         */
        @Override
        public T poll(long timeout, TimeUnit unit)
        {

            try
            {

                if (logger.isDebugEnabled())
                {
                    logger.debug("Retrieve object from queue");
                }

                return super.poll(timeout, unit);

            }
            catch (InterruptedException e)
            {

                throw new TechnicalException("Exception pushing element in queue", e);

            }

        }

        /**
         * DOCUMENT ME!
         *
         * @param o DOCUMENT ME!
         */
        @Override
        public void put(T o)
        {

            try
            {

                if (logger.isDebugEnabled())
                {
                    logger.debug("Put object in queue");
                }

                super.put(o);

            }
            catch (InterruptedException e)
            {

                throw new TechnicalException("Exception pushing element in queue", e);

            }

        }

        void open()
        {

            isOpen.set(true);

        }

        void close()
        {

            isOpen.set(false);

        }

        boolean isOpen()
        {

            return isOpen.get();

        }

    }

}

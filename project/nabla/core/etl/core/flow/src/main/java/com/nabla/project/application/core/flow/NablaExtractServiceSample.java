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

import com.nabla.project.application.api.RequestStatus;
import com.nabla.project.application.api.UnsupportedRecoveryException;
import com.nabla.project.application.api.config.Destination;
import com.nabla.project.application.api.config.Format;
import com.nabla.project.application.api.config.Packaging;
import com.nabla.project.application.api.config.Perimeter;
import com.nabla.project.application.api.config.RequestId;
import com.nabla.project.application.api.extractor.ExtractorThreadInterface;
import com.nabla.project.application.api.helpers.Pipe;
import com.nabla.project.application.api.helpers.PipePublisher;
import com.nabla.project.application.api.transformer.TransformerThreadInterface;
import com.nabla.project.application.api.writer.WriterThreadInterface;
import com.nabla.project.application.core.flow.service.ExtractServiceCommon;
import com.nabla.project.application.core.flow.writer.FileDestination;
import com.nabla.project.application.core.pipe.PipeBlockingQueueListener;
import com.nabla.project.application.core.pipe.PipeBlockingQueuePublisher;
import com.nabla.project.application.core.pipe.PipeBlockingQueueService;
import com.nabla.project.application.core.time.Chronometer;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
  */
public class NablaExtractServiceSample extends ExtractServiceCommon implements NablaExtractServiceMBean
{

    protected Logger logger = Logger.getLogger(getClass());

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

        logger.info("Extract starting");

        Chronometer chronometer = new Chronometer();

        chronometer.start();

        this.requestId.setId(id.getId());

        Set<Pipe<Object>> queues = new HashSet<Pipe<Object>>();
        String exceptionQueueName = "ExceptionQueue";

        try
        {

            if (logger.isDebugEnabled())
            {
                logger.debug("isUsingWriterThread=" + isUsingWriterThread);
            }

            PipeBlockingQueueService.createPipeBlockingQueue(exceptionQueueName, this.requestId, 10000);

            PipePublisher<Throwable> pipeOutException = new PipeBlockingQueuePublisher<Throwable>(exceptionQueueName, this.requestId);

            extractorsThreads = new ArrayList<Thread>();
            transformersThreads = new ArrayList<Thread>();
            writersThreads = new ArrayList<Thread>();

            System.out.println("Thread.MIN_PRIORITY  = " + Thread.MIN_PRIORITY);
            System.out.println("Thread.NORM_PRIORITY = " + Thread.NORM_PRIORITY);
            System.out.println("Thread.MAX_PRIORITY  = " + Thread.MAX_PRIORITY);

            int extractorThreadId = 0;
            ThreadGroup tg_extractor = new ThreadGroup("group_extractor");

            for (ExtractorThreadInterface<Object> extractor : extractors)
            {

                extractor.setId(new Integer(++extractorThreadId));
                extractor.setPerimeter(perimeter);
                extractor.setPipeException(pipeOutException);
                extractor.afterPropertiesSet();

                if (extractor.getPipe() != null)
                {

                    queues.add(extractor.getPipe());

                }

                Thread extractorThread = new Thread(tg_extractor, extractor, "extractor" + extractorThreadId);

                extractorThread.setPriority(Thread.MIN_PRIORITY);

                extractorsThreads.add(extractorThread);
                extractorThread.start();

            }

            int transformerThreadId = 0;
            ThreadGroup tg_transfomer = new ThreadGroup("group_transfomer");

            for (TransformerThreadInterface<Object, Object> transformer : transformers)
            {

                transformer.setId(new Integer(++transformerThreadId));
                transformer.setPipeException(pipeOutException);
                transformer.afterPropertiesSet();

                if (transformer.getPipeIn() != null)
                {

                    queues.add(transformer.getPipeIn());

                }

                if (transformer.getPipeOut() != null)
                {

                    queues.add(transformer.getPipeOut());

                }

                Thread transformerThread = new Thread(tg_transfomer, transformer, "transformer" + transformerThreadId);

                if ((!isUsingWriterThread) && (transformer.getWriterData() != null))
                {

                    transformer.getWriterData().open(output, packaging);

                }

                transformerThread.setPriority(Thread.MAX_PRIORITY);

                transformersThreads.add(transformerThread);
                transformerThread.start();

            }

            if (isUsingWriterThread)
            {

                int writerThreadId = 0;
                ThreadGroup tg_writer = new ThreadGroup("group_writer");

                for (WriterThreadInterface<Object> writer : writers)
                {

                    writer.setId(new Integer(++writerThreadId));
                    writer.setPipeException(pipeOutException);
                    writer.afterPropertiesSet();

                    if (writer.getPipeIn() != null)
                    {

                        queues.add(writer.getPipeIn());

                    }

                    writer.open(output, packaging);

                    Thread writerThread = new Thread(tg_writer, writer, "writer" + writerThreadId);

                    writerThread.setPriority(Thread.NORM_PRIORITY);

                    writersThreads.add(writerThread);
                    writerThread.start();

                }

            }

            for (Thread extractorThread : extractorsThreads)
            {

                extractorThread.join();

            }

            for (Thread transformerThread : transformersThreads)
            {

                transformerThread.join();

            }

            for (TransformerThreadInterface<Object, Object> transformer : transformers)
            {

                if ((!isUsingWriterThread) && (transformer.getWriterData() != null))
                {

                    transformer.getWriterData().close();

                }

            }

            if (isUsingWriterThread)
            {

                for (Thread writerThread : writersThreads)
                {

                    writerThread.join();

                }

            }

            logger.info("Extract done");

            pipeOutException.closeQueue();

            if (isUsingWriterThread)
            {

                for (WriterThreadInterface<Object> writer : writers)
                {

                    writer.close();

                }

            }

            dumpException(exceptionQueueName, this.requestId);

        }
        catch (Throwable ex)
        {

            logger.error("Exception :" + ex.getMessage());
            ex.printStackTrace();

        }
        finally
        {

            PipeBlockingQueueService.destroyQueues(queues);

        }

        chronometer.stop();
        logger.info("Total extract time=" + chronometer);

    }

    /**
     * DOCUMENT ME!
     *
     * @param exceptionQueueName DOCUMENT ME!
     * @param requestId DOCUMENT ME!
     */
    public void dumpException(String exceptionQueueName, RequestId requestId)
    {

        new PipeBlockingQueueListener<Throwable>(exceptionQueueName, requestId)
        {

            @Override
            public void onMessage(Throwable throwable)
            {

                logger.error("Exception: " + throwable.getMessage());

                if (throwable instanceof Exception)
                {

                    ((Exception) throwable).printStackTrace();

                }

            }

        };

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

        return Format.XML.equals(f);

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

        logger.error("supportsPackaging : pass");

        return Packaging.STANDARD.equals(p) || Packaging.COMPRESSED.equals(p);

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

        return "NablaExtractService";

    }

}

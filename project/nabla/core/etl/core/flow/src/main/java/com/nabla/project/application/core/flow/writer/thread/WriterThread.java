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
package com.nabla.project.application.core.flow.writer.thread;

import com.nabla.project.application.api.config.Destination;
import com.nabla.project.application.api.config.Packaging;
import com.nabla.project.application.core.flow.writer.Writer;
import com.nabla.project.application.core.pipe.PipeBlockingQueueListener;
import com.nabla.project.application.core.time.Chronometer;

import org.apache.log4j.Logger;


/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
  *
 * @param <X> DOCUMENT ME!
 */
public class WriterThread<X> extends Writer<X> implements WriterThreadMBean {

    protected Logger logger = Logger.getLogger(getClass());

    /**
     * DOCUMENT ME!
     *
     * @param output DOCUMENT ME!
     * @param packaging DOCUMENT ME!
     */
    public void open(Destination output, Packaging packaging) {

        writerData.open(output, packaging);

    }

    /**
     * DOCUMENT ME!
     */
    public void close() {

        writerData.close();

    }

    /**
     * DOCUMENT ME!
     *
     * @param data DOCUMENT ME!
     */
    public void write(Object data) {

        writerData.write(data);

    }

    /**
     * DOCUMENT ME!
     */
    public void run() {

        try {

            Thread.currentThread().setName(getWriterThreadName());

            Chronometer chronometer = new Chronometer();

            logger.info(name + " started.");
            chronometer.start();

            new PipeBlockingQueueListener<X>(this.pipeIn.getName(), this.pipeIn.getRequestId()) {

                    @Override
                    public void onMessage(X x) {

                        write(x);

                    }

                };

            chronometer.stop();
            logger.info(getName() + " completed. Time = " + chronometer);

        } catch (Exception exception) {

            exception.printStackTrace();
            logger.error("Exception: " + exception.getMessage());

            if (pipeException != null) {

                pipeException.publish(exception);

            }

        } catch (Throwable exception) {

            logger.error("Exception: " + exception.getMessage());
            logger.error(exception.getStackTrace());

            if (pipeException != null) {

                pipeException.publish(exception);

            }

        }

    }

}

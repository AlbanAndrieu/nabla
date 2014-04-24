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
package com.nabla.project.application.core.flow.extractor.thread;

import com.nabla.project.application.core.flow.extractor.Extractor;
import com.nabla.project.application.core.time.Chronometer;

import org.apache.log4j.Logger;

/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
  */
public class ExtractorThread extends Extractor implements ExtractorThreadMBean
{

    protected Logger logger = Logger.getLogger(getClass());

    /**
     * DOCUMENT ME!
     */
    public void afterPropertiesSet()
    {

        super.afterPropertiesSet();

        extractorData.setPipeOut(pipe.getPipePublisher());

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getPipeOutName()
    {

        return pipe.getName();

    }

    /**
     * DOCUMENT ME!
     */
    public void run()
    {

        try
        {

            Thread.currentThread().setName(getExtractorThreadName());

            Chronometer chronometer = new Chronometer();

            logger.info(name + " started.");
            chronometer.start();

            extractorData.extract(pipe.getName(), perimeter);

            chronometer.stop();
            logger.info(getName() + " completed. Time = " + chronometer);

        }
        catch (Throwable exception)
        {

            logger.error("Exception: " + exception.getMessage());

            if (pipeException != null)
            {

                pipeException.publish(exception);

            }

        }

    }

}

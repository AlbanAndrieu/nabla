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
package com.nabla.project.application.core.log;

import junit.framework.TestCase;

import org.apache.commons.logging.impl.Log4JLogger;

import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
  */
public class LogCustomTest extends TestCase
{

    /**
     * DOCUMENT ME!
     */
    public static Logger logger = Logger.getLogger(LogCustomTest.class);

    protected void setUp() throws Exception
    {

    }

    /**
     * DOCUMENT ME!
     *
     * @throws Exception DOCUMENT ME!
     */
    public void testLog() throws Exception
    {

        if (logger.isDebugEnabled())
        {
            logger.debug("testLog");
        }

        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/test/java/com/nabla/project/application/core/log/LogCustom.xml");
        Log4JLogger commonlogger = (Log4JLogger) ctx.getBean("loggingfactorybean");

        if (commonlogger.isDebugEnabled())
        {
            commonlogger.debug("Common logger is enable");
        }

        Log.setCommonlogger(commonlogger);

        if (Log.getCommonlogger().isDebugEnabled())
        {
            Log.getCommonlogger().debug("mylogger 1 - DEBUG - should not be print");
        }

        if (logger.isDebugEnabled())
        {
            logger.debug("rootLogger 1 - DEBUG - should not be print");
        }

        Log.getCommonlogger().warn("mylogger 3 - WARNING");
        logger.warn("rootLogger 1 - WARNING - should not be print");
        Log.getCommonlogger().info("mylogger 2 - INFO - should not be print");
        logger.info("rootLogger 1 - INFO - should not be print");
        Log.getCommonlogger().error("mylogger 4 - ERROR");
        logger.error("rootLogger 4 - ERROR - should not be print");
        Log.getCommonlogger().fatal("mylogger 5 - FATAL");
        logger.fatal("rootLogger 5 - FATAL");

        Thread.sleep(5000L);

    }

}

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

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * DOCUMENT ME!
 * 
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
 */
public class LogTest extends TestCase
{

    /**
     * DOCUMENT ME!
     */
    public static Logger logger = Logger.getLogger(LogTest.class);

    protected void setUp() throws Exception
    {

        Log.init();

    }

    /**
     * DOCUMENT ME!
     * 
     * @throws Exception DOCUMENT ME!
     */
    public void testDefaultLog() throws Exception
    {

        logger.setLevel(Level.DEBUG);

        if (logger.isDebugEnabled())
        {
            logger.debug("rootLogger 1 - DEBUG");
        }

        logger.info("rootLogger 1 - INFO");
        logger.warn("rootLogger 1 - WARNING");
        logger.error("rootLogger 1 - ERROR");
        logger.setLevel(Level.INFO);
        Log.setLogLevel(Level.INFO);

        if (logger.isDebugEnabled())
        {
            logger.debug("rootLogger 2 - DEBUG - should not be print");
        }

        logger.info("rootLogger 2 - INFO");
        logger.warn("rootLogger 2 - WARNING");
        logger.error("rootLogger 2 - ERROR");
        logger.setLevel(Level.WARN);
        Log.setLogLevel(Level.WARN);

        if (logger.isDebugEnabled())
        {
            logger.debug("rootLogger 3 - DEBUG - should not be print");
        }

        logger.info("rootLogger 3 - INFO - should not be print");
        logger.warn("rootLogger 4 - WARNING");
        logger.error("rootLogger 4 - ERROR");
        logger.setLevel(Level.ERROR);
        Log.setLogLevel(Level.ERROR);

        if (logger.isDebugEnabled())
        {
            logger.debug("rootLogger 5 - DEBUG - should not be print");
        }

        logger.info("rootLogger 5 - INFO - should not be print");
        logger.warn("rootLogger 5 - WARNING");
        logger.error("rootLogger 5 - ERROR");

        logger.fatal("Waiting...");
        Thread.sleep(500L);
        logger.setLevel(Level.DEBUG);
        Log.setLogLevel(Level.INFO);

        if (Log.getCommonlogger().isDebugEnabled())
        {
            Log.getCommonlogger().debug("mylogger 4 - DEBUG - should not be print");
        }

        Log.getCommonlogger().info("mylogger 4 - INFO");
        Log.getCommonlogger().warn("mylogger 4 - WARNING");
        Log.getCommonlogger().error("mylogger 4 - ERROR");

        Thread.sleep(5000L);
        Assert.assertFalse(Log.isNotInit);

    }

    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();

        LogManager.shutdown();
    }
}

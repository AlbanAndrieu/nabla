package com.nabla.project.application.model.message.service;

import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.core.pipe.PipeBlockingQueueService;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

/**
 * Author : $author$ Date : $Date: 2010-06-20 11:37:15 +0200 (mer., 20 juin 2010) $ Revision : $revision$
 */
public class PositionExtractParallelServiceTest extends TestCase
{
    public static Logger logger = Logger.getLogger(PositionExtractParallelServiceTest.class);

    static
    {
        Log.init();

        // PropertyConfigurator.configure( "log4j.properties" );
    }

    public volatile int  counter;

    protected void tearDown() throws Exception
    {
        PipeBlockingQueueService.destroyAllQueue();
    } // end tearDown()

    public void testExtractParallelBusinessCase070608() throws Exception
    {
        // Initialization
        counter = 2;

        Thread thread1 = new Thread()
        {
            public void run()
            {
                PositionExtractServiceTest EoleExtractServiceTest = new PositionExtractServiceTest("Thread 1");

                try
                {
                    EoleExtractServiceTest.testExtractBusinessCase070608();

                    if (logger.isDebugEnabled())
                    {
                        logger.debug("Ok");
                    } // end if

                    counter--;
                } // end try
                catch (Exception ex)
                {
                    logger.error(ex);
                    ex.printStackTrace();
                } // end catch
            } // end run()
        } // end new
        ;

        Thread thread2 = new Thread()
        {
            public void run()
            {
                PositionExtractServiceTest EoleExtractServiceTest = new PositionExtractServiceTest("Thread 2");

                try
                {
                    EoleExtractServiceTest.testExtractBusinessCase070608();

                    if (logger.isDebugEnabled())
                    {
                        logger.debug("Ok");
                    } // end if

                    counter--;
                } // end try
                catch (Exception ex)
                {
                    logger.error(ex);
                    ex.printStackTrace();
                } // end catch
            } // end run()
        } // end new
        ;

        // Launch tests
        thread1.start();
        thread2.start();
        // Wait
        thread1.join();
        thread2.join();
        // Verification
        assertEquals(0, counter);
    } // end testExtractParallelBusinessCase070608()
} // end PositionExtractParallelServiceTest

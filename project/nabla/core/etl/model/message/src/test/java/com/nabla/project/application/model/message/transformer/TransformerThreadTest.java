package com.nabla.project.application.model.message.transformer;

import com.nabla.project.application.api.config.RequestId;
import com.nabla.project.application.api.transformer.TransformerThreadInterface;
import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.core.pipe.PipeBlockingQueueService;
import com.nabla.project.application.core.pipe.PipeListenerContainerCounter;
import com.nabla.project.application.core.pipe.container.PipeListenerContainer;
import com.nabla.project.application.core.pipe.container.PipePublisherContainer;
import com.nabla.project.application.core.spring.AbstractMessageConfig;
import com.nabla.project.application.core.spring.ApplicationContextMessageFactory;
import com.nabla.project.application.core.time.Chronometer;
import com.nabla.project.application.model.message.domain.ContainerTradeTest;
import com.nabla.project.application.model.message.domain.ObjectContainer;
import com.nabla.project.application.model.message.domain.Trade;
import com.nabla.project.application.model.message.domain.TradeTest;
import com.nabla.project.application.model.message.test.PerformanceTest;

import junit.framework.TestCase;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Author : $author$ Date : $Date: 2010-06-20 17:01:12 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$ To unable jmx management, use this VM parameter :
 * -Dcom.sun.management.jmxremote
 */
public class TransformerThreadTest extends TestCase
{
    protected Logger        logger                       = Logger.getLogger(this.getClass());

    static
    {
        Log.init();
    }

    public final static int nbTransformLoopWithVerify    = PerformanceTest.nbTransformLoop;
    public final static int nbTransformLoopWithoutVerify = PerformanceTest.nbTransformLoop;
    protected String        pipeInName                   = "pipeInTest";
    protected String        pipeOutName                  = "pipeOutTest";

    /**
     * DOCUMENT ME!
     */
    Chronometer             chronometer;

    /*
     * (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp() throws Exception
    {
        // TODO Auto-generated method stub
        super.setUp();
        chronometer = new Chronometer();
        chronometer.start();
        ApplicationContextMessageFactory.springXmlConfiguration = ApplicationContextMessageFactory.springXmlConfigurationTest;
    } // end setUp()

    /*
     * (non-Javadoc)
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
        chronometer.stop();
        logger.info("Total Time = " + chronometer);
        PipeBlockingQueueService.destroyAllQueue();
    } // end tearDown()

    public TransformerThreadTest(String testName)
    {
        super(testName);
    } // end TransformerThreadTest()

    public void testTransformSCN01() throws Exception
    {
        // Initialization
        RequestId requestId = new RequestId();
        TransformerThreadInterface<Trade, ObjectContainer> transformer = (TransformerThreadInterface<Trade, ObjectContainer>) ApplicationContextMessageFactory.getInstance().getApplicationContext()
                .getBean(AbstractMessageConfig.beanTransformerThreadName);
        PipeBlockingQueueService.destroyAllQueue();

        PipePublisherContainer<Trade> pipeIn = new PipePublisherContainer<Trade>(pipeInName, requestId);
        PipePublisherContainer<ObjectContainer> pipeOut = new PipePublisherContainer<ObjectContainer>(pipeOutName, requestId);
        PipeListenerContainer pipeContainer = new PipeListenerContainer(pipeOutName, requestId);
        Thread pipeThread = pipeContainer.launch();
        // Configure transform thread
        transformer.setPipeIn(pipeIn);
        transformer.setPipeOut(pipeOut);
        transformer.setUsePipeOut(true);

        Thread transformerThread = new Thread(transformer);
        // Writer into pipeIn
        pipeIn.getPipePublisher().publish(TradeTest.getTrade("SCN01"));
        pipeIn.getPipePublisher().closeQueue();
        // Job
        transformerThread.start();
        transformerThread.join();
        pipeThread.join();

        // Verifications
        assertEquals(1, pipeContainer.getList().size());
        assertTrue(pipeContainer.getList().get(0) instanceof ObjectContainer);

        ObjectContainer containerTrade = (ObjectContainer) pipeContainer.getList().get(0);

        if ( // Debug
        logger.isDebugEnabled())
        {
            // Debug
            logger.debug(containerTrade);
        } // end if

        //
        ContainerTradeTest.testContainerTradeSCN01(containerTrade);
    } // end testTransformSCN01()

    public void testTransformSCN02() throws Exception
    {
        // Initialization
        RequestId requestId = new RequestId();
        TransformerThreadInterface<Trade, ObjectContainer> transformer = (TransformerThreadInterface<Trade, ObjectContainer>) ApplicationContextMessageFactory.getInstance().getApplicationContext()
                .getBean(AbstractMessageConfig.beanTransformerThreadName);
        PipeBlockingQueueService.destroyAllQueue();

        PipePublisherContainer<Trade> pipeIn = new PipePublisherContainer<Trade>(pipeInName, requestId);
        PipePublisherContainer<ObjectContainer> pipeOut = new PipePublisherContainer<ObjectContainer>(pipeOutName, requestId);
        PipeListenerContainer pipeContainer = new PipeListenerContainer(pipeOutName, requestId);
        Thread pipeThread = pipeContainer.launch();
        // Configure transform thread
        transformer.setPipeIn(pipeIn);
        transformer.setPipeOut(pipeOut);
        transformer.setUsePipeOut(true);

        Thread transformerThread = new Thread(transformer);
        // Writer into pipeIn
        pipeIn.getPipePublisher().publish(TradeTest.getTrade("SCN02"));
        pipeIn.getPipePublisher().closeQueue();
        // Job
        transformerThread.start();
        transformerThread.join();
        pipeThread.join();

        // Verifications
        assertEquals(1, pipeContainer.getList().size());
        assertTrue(pipeContainer.getList().get(0) instanceof ObjectContainer);

        ObjectContainer containerTrade = (ObjectContainer) pipeContainer.getList().get(0);

        if ( // Debug
        logger.isDebugEnabled())
        {
            // Debug
            logger.debug(containerTrade);
        } // end if

        //
        ContainerTradeTest.testContainerTradeSCN02(containerTrade);
    } // end testTransformSCN02()

    public void testTransformPerfWithVerif() throws Exception
    {
        // Initialization
        RequestId requestId = new RequestId();
        TransformerThreadInterface<Trade, ObjectContainer> transformer = (TransformerThreadInterface<Trade, ObjectContainer>) ApplicationContextMessageFactory.getInstance().getApplicationContext()
                .getBean(AbstractMessageConfig.beanTransformerThreadName);
        PipeBlockingQueueService.destroyAllQueue();

        PipePublisherContainer<Trade> pipeIn = new PipePublisherContainer<Trade>(pipeInName, requestId);
        PipePublisherContainer<ObjectContainer> pipeOut = new PipePublisherContainer<ObjectContainer>(pipeOutName, requestId);
        PipeListenerContainer pipeContainer = new PipeListenerContainer(pipeOutName, requestId);
        Thread pipeThread = pipeContainer.launch();
        Chronometer chronometer = new Chronometer();
        Level levelPrevious = Logger.getRootLogger().getLevel();
        Logger.getRootLogger().setLevel(Level.ERROR);
        // Configure transform thread
        transformer.setPipeIn(pipeIn);
        transformer.setPipeOut(pipeOut);
        transformer.setUsePipeOut(true);

        Thread transformerThread = new Thread(transformer);

        // Writer into pipeIn
        Trade trade = TradeTest.getTrade("SCN01");

        for (int i = 0; i < nbTransformLoopWithVerify; i++)
        {
            pipeIn.getPipePublisher().publish(trade);
        } // end for

        pipeIn.getPipePublisher().closeQueue();
        // Job
        chronometer.start();
        transformerThread.start();
        transformerThread.join();
        pipeThread.join();
        chronometer.stop();

        Logger.getRootLogger().setLevel(levelPrevious);
        // Debug
        logger.info(chronometer);
        // Verifications
        assertEquals(nbTransformLoopWithVerify, pipeContainer.getList().size());

        for (int i = 0; i < nbTransformLoopWithVerify; i++)
        {
            assertTrue(pipeContainer.getList().get(i) instanceof ObjectContainer);

            ObjectContainer containerTrade = (ObjectContainer) pipeContainer.getList().get(i);
            ContainerTradeTest.testContainerTradeSCN01(containerTrade);
        } // end for

        // fail("Fin normale");
    } // end testTransformPerfWithVerif()

    public void testTransformPerfWithoutVerif() throws Exception
    {
        // Initialization
        RequestId requestId = new RequestId();
        TransformerThreadInterface<Trade, ObjectContainer> transformer = (TransformerThreadInterface<Trade, ObjectContainer>) ApplicationContextMessageFactory.getInstance().getApplicationContext()
                .getBean(AbstractMessageConfig.beanTransformerThreadName);
        PipeBlockingQueueService.destroyAllQueue();

        PipePublisherContainer<Trade> pipeIn = new PipePublisherContainer<Trade>(pipeInName, requestId);
        PipePublisherContainer<ObjectContainer> pipeOut = new PipePublisherContainer<ObjectContainer>(pipeOutName, requestId);
        PipeListenerContainerCounter pipeContainer = new PipeListenerContainerCounter(pipeOutName, requestId);
        Thread pipeThread = pipeContainer.launch();
        Chronometer chronometer = new Chronometer();
        Level levelPrevious = Logger.getRootLogger().getLevel();
        Logger.getRootLogger().setLevel(Level.ERROR);
        // Configure transform thread
        transformer.setPipeIn(pipeIn);
        transformer.setPipeOut(pipeOut);
        transformer.setUsePipeOut(true);

        Thread transformerThread = new Thread(transformer);

        // Writer into pipeIn
        Trade trade = TradeTest.getTrade("SCN01");

        for (int i = 0; i < nbTransformLoopWithoutVerify; i++)
        {
            pipeIn.getPipePublisher().publish(trade);
        } // end for

        pipeIn.getPipePublisher().closeQueue();
        // Job
        chronometer.start();
        transformerThread.start();
        transformerThread.join();
        pipeThread.join();
        chronometer.stop();

        Logger.getRootLogger().setLevel(levelPrevious);
        // Debug
        logger.info(chronometer);
        // Verifications
        assertEquals(nbTransformLoopWithoutVerify, pipeContainer.getCounter());

        // fail("Fin normale");
    } // end testTransformPerfWithoutVerif()
} // end TransformerThreadTest

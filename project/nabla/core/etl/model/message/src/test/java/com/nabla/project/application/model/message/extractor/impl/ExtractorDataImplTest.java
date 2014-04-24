package com.nabla.project.application.model.message.extractor.impl;

import com.nabla.project.application.api.config.Perimeter;
import com.nabla.project.application.api.config.RequestId;
import com.nabla.project.application.api.extractor.ExtractDataInterface;
import com.nabla.project.application.api.helpers.PipePublisher;
import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.core.pipe.PipeBlockingQueuePublisher;
import com.nabla.project.application.core.pipe.PipeBlockingQueueService;
import com.nabla.project.application.core.pipe.PipeListenerContainerCounter;
import com.nabla.project.application.core.pipe.container.PipeListenerContainer;
import com.nabla.project.application.core.spring.AbstractConfig;
import com.nabla.project.application.core.spring.ApplicationContextMessageFactory;
import com.nabla.project.application.core.spring.MessageConfig;
import com.nabla.project.application.core.time.Chronometer;
import com.nabla.project.application.model.message.config.PerimeterTest;
import com.nabla.project.application.model.message.domain.Trade;
import com.nabla.project.application.model.message.domain.TradeTest;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

/**
 * Author : $author$ Date : $Date: 2010-06-21 11:30:31 +0200 (Thu, 21 Jun 2010) $ Revision : $revision$ Test below are launched via class
 * TestsUnitairesMapping
 */
public class ExtractorDataImplTest extends TestCase
{
    protected Logger logger   = Logger.getLogger(this.getClass());

    /**
     * DOCUMENT ME!
     */
    Chronometer      chronometer;
    protected String pipeName = "pipeTest";

    public ExtractorDataImplTest(String testName)
    {
        super(testName);
    } // end ExtractorDataImplTest()

    protected void setUp() throws Exception
    {
        chronometer = new Chronometer();
        chronometer.start();
        ApplicationContextMessageFactory.springXmlConfiguration = ApplicationContextMessageFactory.springXmlConfigurationTest;
        ApplicationContextMessageFactory.newExtractionScope();
        Log.init();
        PipeBlockingQueueService.destroyAllQueue();
    } // end setUp()

    protected void tearDown() throws Exception
    {
        chronometer.stop();
        logger.info("Total Time = " + chronometer);
        PipeBlockingQueueService.destroyAllQueue();
    } // end tearDown()

    public void testExtractPerimeter100() throws Exception
    {
        // Initialization
        RequestId requestId = (RequestId) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(AbstractConfig.beanRequestIdName);
        Perimeter perimeter = PerimeterTest.getPerimeter100((Perimeter) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanPerimeterName));
        ExtractDataInterface<Trade> dataExtractor = (ExtractDataInterface<Trade>) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanDataExtractorTradeName);

        PipeBlockingQueueService.createPipeBlockingQueue(this.pipeName, requestId, MessageConfig.getInstance().getQueueSize());

        // PipeQueue<ObjectContainer> pipeOut=new
        // PipeQueue<ObjectContainer>(this.pipeName,requestId);
        PipePublisher<Trade> pipeOut = new PipeBlockingQueuePublisher<Trade>(this.pipeName, requestId);
        PipeListenerContainerCounter pipeContainerCounter = new PipeListenerContainerCounter(this.pipeName, requestId);
        Thread thread = pipeContainerCounter.launch();
        // Configure extractor
        dataExtractor.setName(this.pipeName);
        dataExtractor.setPerimeter(perimeter);
        // dataExtractor.setPipeOut(pipeOut.getPipePublisher());
        dataExtractor.setPipeOut(pipeOut);

        // Job
        dataExtractor.extract(this.pipeName, perimeter);
        thread.join();

        // Check
        assertEquals(PerimeterTest.numberOfRowsPerimeter100.intValue(), pipeContainerCounter.getCounter());
    } // end testExtractPerimeter100()

    public void testExtractSCN01() throws Exception
    {
        // Initialization
        RequestId requestId = (RequestId) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(AbstractConfig.beanRequestIdName);
        Perimeter perimeter = PerimeterTest.getPerimeterDeal1((Perimeter) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanPerimeterName));
        ExtractDataInterface<Trade> dataExtractor = (ExtractDataInterface<Trade>) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanDataExtractorTradeName);

        PipeBlockingQueueService.createPipeBlockingQueue(this.pipeName, requestId, MessageConfig.getInstance().getQueueSize());

        PipePublisher<Trade> pipeOut = new PipeBlockingQueuePublisher<Trade>(this.pipeName, requestId);
        PipeListenerContainer pipeContainer = new PipeListenerContainer(this.pipeName, requestId);
        Thread thread = pipeContainer.launch();
        // Configure extractor
        dataExtractor.setName(this.pipeName);
        dataExtractor.setPerimeter(perimeter);
        dataExtractor.setPipeOut(pipeOut);

        // Job
        dataExtractor.extract(this.pipeName, perimeter);
        thread.join();

        // Check
        assertEquals(1, pipeContainer.getList().size());
        assertTrue(pipeContainer.getList().get(0) instanceof Trade);

        Trade trade = (Trade) pipeContainer.getList().get(0);

        if ( // Debug
        logger.isDebugEnabled())
        {
            // Debug
            logger.debug(trade);
        } // end if

        //
        TradeTest.testTradeSCN01(trade);
    } // end testExtractSCN01()

    public void testExtractSCN02() throws Exception
    {
        // Initialization
        RequestId requestId = (RequestId) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(AbstractConfig.beanRequestIdName);
        Perimeter perimeter = PerimeterTest.getPerimeterDeal2((Perimeter) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanPerimeterName));
        ExtractDataInterface<Trade> dataExtractor = (ExtractDataInterface<Trade>) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanDataExtractorTradeName);

        PipeBlockingQueueService.createPipeBlockingQueue(this.pipeName, requestId, MessageConfig.getInstance().getQueueSize());

        PipePublisher<Trade> pipeOut = new PipeBlockingQueuePublisher<Trade>(this.pipeName, requestId);
        PipeListenerContainer pipeContainer = new PipeListenerContainer(this.pipeName, requestId);
        Thread thread = pipeContainer.launch();
        // Configure extractor
        dataExtractor.setName(this.pipeName);
        dataExtractor.setPerimeter(perimeter);
        dataExtractor.setPipeOut(pipeOut);

        // Job
        dataExtractor.extract(this.pipeName, perimeter);
        thread.join();

        // Check
        assertEquals(1, pipeContainer.getList().size());
        assertTrue(pipeContainer.getList().get(0) instanceof Trade);

        Trade trade = (Trade) pipeContainer.getList().get(0);

        if ( // Debug
        logger.isDebugEnabled())
        {
            // Debug
            logger.debug(trade);
        } // end if

        //
        TradeTest.testTradeSCN02(trade);
    } // end testExtractSCN02()
} // end ExtractorDataImplTest

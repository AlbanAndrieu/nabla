package com.nabla.project.application.model.message.extractor;

import com.nabla.project.application.api.config.Perimeter;
import com.nabla.project.application.api.config.RequestId;
import com.nabla.project.application.api.extractor.ExtractorThreadInterface;
import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.core.pipe.PipeBlockingQueueService;
import com.nabla.project.application.core.pipe.PipeListenerContainerCounter;
import com.nabla.project.application.core.pipe.container.PipeListenerContainer;
import com.nabla.project.application.core.pipe.container.PipePublisherContainer;
import com.nabla.project.application.core.spring.AbstractMessageConfig;
import com.nabla.project.application.core.spring.ApplicationContextMessageFactory;
import com.nabla.project.application.core.spring.MessageConfig;
import com.nabla.project.application.core.time.Chronometer;
import com.nabla.project.application.model.message.config.PerimeterTest;
import com.nabla.project.application.model.message.domain.Trade;
import com.nabla.project.application.model.message.domain.TradeTest;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

/**
 * Author : $author$ Date : $Date: 2010-06-20 17:01:12 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$
 */
public class ExtractorThreadTest extends TestCase
{
    protected Logger logger   = Logger.getLogger(this.getClass());
    protected String pipeName = "pipeTest";

    /**
     * DOCUMENT ME!
     */
    Chronometer      chronometer;

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

    public ExtractorThreadTest()
    {
        Log.init();
    } // end ExtractorThreadTest()

    public ExtractorThreadTest(String testName)
    {
        super(testName);
    } // end ExtractorThreadTest()

    public void testExtractPerimeter100() throws Exception
    {
        // Initialization
        RequestId requestId = new RequestId();
        Perimeter perimeter = PerimeterTest.getPerimeter100((Perimeter) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanPerimeterName));
        ExtractorThreadInterface<Trade> extractor = (ExtractorThreadInterface<Trade>) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(AbstractMessageConfig.beanExtractorThreadName);
        PipePublisherContainer<Trade> pipe = new PipePublisherContainer<Trade>(pipeName, requestId);
        PipeListenerContainerCounter pipeContainerCounter = new PipeListenerContainerCounter(pipeName, requestId);
        Thread pipeThread = pipeContainerCounter.launch();
        // Configure extractor thread
        extractor.setPipe(pipe);
        extractor.setPerimeter(perimeter);
        extractor.getExtractorData().setPipeOut(pipe.getPipePublisher());

        Thread extractorThread = new Thread(extractor);
        // Job
        extractorThread.start();
        extractorThread.join();
        pipeThread.join();

        // Verifications
        assertEquals(PerimeterTest.numberOfRowsPerimeter100.intValue(), pipeContainerCounter.getCounter());
    } // end testExtractPerimeter100()

    public void testExtractSCN01() throws Exception
    {
        // Initialization
        RequestId requestId = new RequestId();
        Perimeter perimeter = PerimeterTest.getPerimeterDeal1((Perimeter) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanPerimeterName));
        ExtractorThreadInterface<Trade> extractor = (ExtractorThreadInterface<Trade>) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(AbstractMessageConfig.beanExtractorThreadName);
        PipePublisherContainer<Trade> pipe = new PipePublisherContainer<Trade>(pipeName, requestId);
        PipeListenerContainer pipeContainer = new PipeListenerContainer(pipeName, requestId);
        Thread pipeThread = pipeContainer.launch();
        // Configure extractor thread
        extractor.setPipe(pipe);
        extractor.setPerimeter(perimeter);
        extractor.getExtractorData().setPipeOut(pipe.getPipePublisher());

        Thread extractorThread = new Thread(extractor);
        // Job
        extractorThread.start();
        extractorThread.join();
        pipeThread.join();

        // Verifications
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
        RequestId requestId = new RequestId();
        Perimeter perimeter = PerimeterTest.getPerimeterDeal2((Perimeter) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanPerimeterName));
        ExtractorThreadInterface<Trade> extractor = (ExtractorThreadInterface<Trade>) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(AbstractMessageConfig.beanExtractorThreadName);
        PipePublisherContainer<Trade> pipe = new PipePublisherContainer<Trade>(pipeName, requestId);
        PipeListenerContainer pipeContainer = new PipeListenerContainer(pipeName, requestId);
        Thread pipeThread = pipeContainer.launch();
        // Configure extractor thread
        extractor.setPipe(pipe);
        extractor.setPerimeter(perimeter);
        extractor.getExtractorData().setPipeOut(pipe.getPipePublisher());

        Thread extractorThread = new Thread(extractor);
        // Job
        extractorThread.start();
        extractorThread.join();
        pipeThread.join();

        // Verifications
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

    public void testPerfExtractPerimeter100() throws Exception
    {
        // Initialization
        Chronometer chronometer = new Chronometer();
        chronometer.start();
        // Run test
        testExtractPerimeter100();
        // Verification
        chronometer.stop();

        long time = chronometer.time();

        if ( // Debug
        logger.isDebugEnabled())
        {
            // Debug
            logger.debug(time);
        } // end if

        // Verifications
        assertTrue(time < 8000);
    } // end testPerfExtractPerimeter100()
} // end ExtractorThreadTest

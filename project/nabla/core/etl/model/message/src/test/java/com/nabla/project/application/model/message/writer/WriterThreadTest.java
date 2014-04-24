package com.nabla.project.application.model.message.writer;

import com.nabla.project.application.api.config.Packaging;
import com.nabla.project.application.api.config.RequestId;
import com.nabla.project.application.api.writer.WriterThreadInterface;
import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.core.pipe.PipeBlockingQueueService;
import com.nabla.project.application.core.pipe.container.PipePublisherContainer;
import com.nabla.project.application.core.spring.AbstractConfig;
import com.nabla.project.application.core.spring.AbstractMessageConfig;
import com.nabla.project.application.core.spring.ApplicationContextMessageFactory;
import com.nabla.project.application.core.time.Chronometer;
import com.nabla.project.application.model.message.config.DestinationByteArrayStream;
import com.nabla.project.application.model.message.domain.ContainerTradeTest;
import com.nabla.project.application.model.message.domain.ObjectContainer;
import com.nabla.project.application.model.message.domain.XMLTradeTest;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

/**
 * Author : $author$ Date : $Date: 2010-06-20 17:01:12 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$
 */
public class WriterThreadTest extends TestCase
{
    protected Logger logger   = Logger.getLogger(this.getClass());

    static
    {
        Log.init();
    }

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

    public WriterThreadTest(String testName)
    {
        super(testName);
    } // end WriterThreadTest()

    public void testWriterSCN01() throws Exception
    {
        // Initialization
        RequestId requestId = (RequestId) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(AbstractConfig.beanRequestIdName);
        DestinationByteArrayStream destination = new DestinationByteArrayStream();
        Packaging packaging = null;
        WriterThreadInterface<ObjectContainer> writer = (WriterThreadInterface<ObjectContainer>) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(AbstractMessageConfig.beanWriterThreadName);
        PipeBlockingQueueService.destroyAllQueue();

        PipePublisherContainer<ObjectContainer> pipeIn = new PipePublisherContainer<ObjectContainer>(this.pipeName, requestId);
        // Configure transform thread
        writer.setPipeIn(pipeIn);
        writer.open(destination, packaging);

        Thread writerThread = new Thread(writer);
        // Writer into pipeIn
        pipeIn.getPipePublisher().publish(ContainerTradeTest.getContainerTradeSCN01());
        pipeIn.getPipePublisher().closeQueue();
        // Job
        writerThread.start();
        writerThread.join();
        writer.close();

        // Verifications
        String result = destination.toString();

        // Debug
        if (logger.isDebugEnabled())
        {
            logger.debug(result);
        } // end if

        XMLTradeTest.testXMLTradeSCN01(result);
    } // end testWriterSCN01()

    public void testWriterSCN02() throws Exception
    {
        // Initialization
        RequestId requestId = (RequestId) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(AbstractConfig.beanRequestIdName);
        DestinationByteArrayStream destination = new DestinationByteArrayStream();
        Packaging packaging = null;
        WriterThreadInterface<ObjectContainer> writer = (WriterThreadInterface<ObjectContainer>) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(AbstractMessageConfig.beanWriterThreadName);
        PipeBlockingQueueService.destroyAllQueue();

        PipePublisherContainer<ObjectContainer> pipeIn = new PipePublisherContainer<ObjectContainer>(this.pipeName, requestId);
        // Configure transform thread
        writer.setPipeIn(pipeIn);
        writer.open(destination, packaging);

        Thread writerThread = new Thread(writer);
        // Writer into pipeIn
        pipeIn.getPipePublisher().publish(ContainerTradeTest.getContainerTradeSCN02());
        pipeIn.getPipePublisher().closeQueue();
        // Job
        writerThread.start();
        writerThread.join();
        writer.close();

        // Verifications
        String result = destination.toString();

        // Debug
        if (logger.isDebugEnabled())
        {
            logger.debug(result);
        } // end if

        XMLTradeTest.testXMLTradeSCN02(result);
    } // end testWriterSCN02()
} // end WriterThreadTest

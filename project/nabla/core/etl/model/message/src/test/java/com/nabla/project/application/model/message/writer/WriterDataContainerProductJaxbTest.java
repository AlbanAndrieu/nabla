package com.nabla.project.application.model.message.writer;

import com.nabla.project.application.api.config.Packaging;
import com.nabla.project.application.api.writer.WriterDataInterface;
import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.core.spring.ApplicationContextMessageFactory;
import com.nabla.project.application.core.spring.MessageConfig;
import com.nabla.project.application.core.time.Chronometer;
import com.nabla.project.application.model.message.config.DestinationByteArrayStream;
import com.nabla.project.application.model.message.domain.ContainerTradeTest;
import com.nabla.project.application.model.message.test.PerformanceTest;

import org.apache.log4j.Logger;

import org.custommonkey.xmlunit.XMLTestCase;

/**
 * Author : $author$ Date : $Date: 2010-06-20 17:01:12 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$ Test below are launched via class
 * TestsUnitairesMapping
 */
public class WriterDataContainerProductJaxbTest extends XMLTestCase
{
    protected Logger              logger      = Logger.getLogger(this.getClass());

    static
    {
        Log.init();
    }

    protected final int           nbWriteLoop = PerformanceTest.nbWriteLoop;
    protected WriterDataInterface extractWriter;

    /**
     * DOCUMENT ME!
     */
    Chronometer                   chronometer;

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

        extractWriter = (WriterDataInterface) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanDataWriterContainerProductName);
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

        // PipeBlockingQueueService.destroyAllQueue();
    } // end tearDown()

    public WriterDataContainerProductJaxbTest(String testName)
    {
        super(testName);
    } // end WriterDataContainerProductJaxbTest()

    public void testWriterProduct3464() throws Exception
    {
        // Initialisation
        DestinationByteArrayStream destination = new DestinationByteArrayStream();
        Packaging packaging = null;

        // Work
        extractWriter.open(destination, packaging);
        extractWriter.write(ContainerTradeTest.getContainerTradeSCN01());
        extractWriter.close();

        // Verifications
        String result = destination.toString();

        // Debug
        if (logger.isDebugEnabled())
        {
            logger.debug(result);
        } // end if

        // TODO
        // XMLTradeTest.testXMLTradeSCN01(result);
    } // end testWriterProduct3464()

    public void testWriterProduct1925165() throws Exception
    {
        // Initialisation
        DestinationByteArrayStream destination = new DestinationByteArrayStream();
        Packaging packaging = null;

        // Work
        extractWriter.open(destination, packaging);
        extractWriter.write(ContainerTradeTest.getContainerTradeSCN02());
        extractWriter.close();

        // Verifications
        String result = destination.toString();

        // Debug
        if (logger.isDebugEnabled())
        {
            logger.debug(result);
        } // end if

        // TODO
        // XMLTradeTest.testXMLTradeSCN02(result);
    } // end testWriterProduct1925165()
} // end WriterDataContainerProductJaxbTest

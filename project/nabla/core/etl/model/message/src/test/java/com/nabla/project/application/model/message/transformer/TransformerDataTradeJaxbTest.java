package com.nabla.project.application.model.message.transformer;

import com.nabla.project.application.api.transformer.TransformerDataInterface;
import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.core.pipe.PipeBlockingQueueService;
import com.nabla.project.application.core.spring.ApplicationContextMessageFactory;
import com.nabla.project.application.core.spring.MessageConfig;
import com.nabla.project.application.core.time.Chronometer;
import com.nabla.project.application.model.message.domain.ContainerTradeTest;
import com.nabla.project.application.model.message.domain.ObjectContainer;
import com.nabla.project.application.model.message.domain.Trade;
import com.nabla.project.application.model.message.domain.TradeTest;
import com.nabla.project.application.model.message.test.PerformanceTest;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

/**
 * Author : $author$ Date : $Date: 2010-06-21 11:30:31 +0200 (Thu, 21 Jun 2010) $ Revision : $revision$
 */
public class TransformerDataTradeJaxbTest extends TestCase
{
    protected Logger    logger          = Logger.getLogger(this.getClass());

    static
    {
        Log.init();
    }

    protected final int nbTransformLoop = PerformanceTest.nbTransformLoop;

    /**
     * DOCUMENT ME!
     */
    Chronometer         chronometer;

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

    public TransformerDataTradeJaxbTest(String testName)
    {
        super(testName);
    } // end TransformerDataTradeJaxbTest()

    public void testTradeSCN01()
    {
        // Initialization
        TransformerDataInterface dataTransformer = (TransformerDataInterface) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanDataTransformerTradeName);
        Trade source = TradeTest.getTrade("SCN01");
        ObjectContainer reference = ContainerTradeTest.getContainerTradeSCN01();

        // Work
        Object result = dataTransformer.transform(source);
        // Verification
        assertTrue(result instanceof ObjectContainer);
        ContainerTradeTest.testContainerTradeSCN01((ObjectContainer) result);
    } // end testTradeSCN01()

    public void testTradeSCN02()
    {
        // Initialization
        TransformerDataInterface dataTransformer = (TransformerDataInterface) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanDataTransformerTradeName);
        Trade source = TradeTest.getTrade("SCN02");
        ObjectContainer reference = ContainerTradeTest.getContainerTradeSCN02();

        // Work
        Object result = dataTransformer.transform(source);
        // Verification
        assertTrue(result instanceof ObjectContainer);
        ContainerTradeTest.testContainerTradeSCN02((ObjectContainer) result);
    } // end testTradeSCN02()
} // end TransformerDataTradeJaxbTest

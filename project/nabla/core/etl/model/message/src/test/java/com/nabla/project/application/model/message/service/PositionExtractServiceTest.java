package com.nabla.project.application.model.message.service;

import com.nabla.project.application.api.ExtractService;
import com.nabla.project.application.api.config.Destination;
import com.nabla.project.application.api.config.Format;
import com.nabla.project.application.api.config.Packaging;
import com.nabla.project.application.api.config.Perimeter;
import com.nabla.project.application.api.config.RequestId;
import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.core.pipe.PipeBlockingQueueService;
import com.nabla.project.application.core.spring.AbstractConfig;
import com.nabla.project.application.core.spring.ApplicationContextMessageFactory;
import com.nabla.project.application.core.spring.MessageConfig;
import com.nabla.project.application.core.time.Chronometer;
import com.nabla.project.application.model.message.config.DestinationByteArrayStream;
import com.nabla.project.application.model.message.config.PerimeterTest;
import com.nabla.project.application.model.message.domain.XMLTradeTest;
import com.nabla.project.application.model.message.helpers.XmlTest;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.log4j.Logger;

/**
 * Author : $author$ Date : $Date: 2010-06-20 18:06:01 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$ To unable jmx management, use this VM parameter :
 * -Dcom.sun.management.jmxremote
 */
public class PositionExtractServiceTest extends TestCase
{
    protected static Logger logger = Logger.getLogger(PositionExtractServiceTest.class);

    static
    {
        Log.init();

        // PropertyConfigurator.configure("log4j.properties");
    }

    public Chronometer      chronometer;

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
        ApplicationContextMessageFactory.newExtractionScope();
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

    public PositionExtractServiceTest(String testName)
    {
        super(testName);
    } // end PositionExtractServiceTest()

    // obligation
    public void testExtractSCN01() throws Exception
    {
        // Initialization
        ExtractService extractService = (ExtractService) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanExtractServiceTradeName);
        Perimeter perimeter = PerimeterTest.getPerimeterDeal1((Perimeter) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanPerimeterName));
        Destination destination = new DestinationByteArrayStream();
        RequestId id = (RequestId) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(AbstractConfig.beanRequestIdName);
        Destination status = null;
        Format format = null;
        Packaging packaging = null;
        // Launch job
        extractService.extractPerimeter(perimeter, id, destination, status, format, packaging);
        // Verification
        XMLTradeTest.testXMLTradeSCN01(destination.toString());
    } // end testExtractSCN01()

    // Action
    public void testExtractSCN02() throws Exception
    {
        // Initialization
        ExtractService extractService = (ExtractService) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanExtractServiceTradeName);
        Perimeter perimeter = PerimeterTest.getPerimeterDeal2((Perimeter) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanPerimeterName));
        Destination destination = new DestinationByteArrayStream();
        RequestId id = (RequestId) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(AbstractConfig.beanRequestIdName);
        Destination status = null;
        Format format = null;
        Packaging packaging = null;
        // Launch job
        extractService.extractPerimeter(perimeter, id, destination, status, format, packaging);
        // Verification
        XMLTradeTest.testXMLTradeSCN02(destination.toString());
    } // end testExtractSCN02()

    public void testExtractBusinessCase070608() throws Exception
    {
        // Initialization
        ExtractService extractService = (ExtractService) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanExtractServiceTradeName);
        Perimeter perimeter = PerimeterTest.getPerimeterBusinessCase01((Perimeter) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanPerimeterName));
        Destination destination = new DestinationByteArrayStream();
        RequestId id = (RequestId) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(AbstractConfig.beanRequestIdName);
        Destination status = null;
        Format format = null;
        Packaging packaging = null;
        // Launch job
        extractService.extractPerimeter(perimeter, id, destination, status, format, packaging);
        // Verification
        XmlTest.xmlValidation(destination.toString());
        XmlTest.xmlSchemaValidation(destination.toString());
    } // end testExtractBusinessCase070608()

    public void testExtract100() throws Exception
    {
        // Initialization
        ExtractService extractService = (ExtractService) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanExtractServiceTradeName);
        Perimeter perimeter = PerimeterTest.getPerimeter100((Perimeter) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanPerimeterName));
        Destination destination = new DestinationByteArrayStream();
        RequestId id = (RequestId) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(AbstractConfig.beanRequestIdName);
        Destination status = null;
        Format format = null;
        Packaging packaging = null;
        // Launch job
        extractService.extractPerimeter(perimeter, id, destination, status, format, packaging);
        // Verification
        XmlTest.xmlValidation(destination.toString());
        XmlTest.xmlSchemaValidation(destination.toString());
    } // end testExtract100()

    public static void main(final String[] args)
    {
        TestSuite suite = new TestSuite(PositionExtractServiceTest.class.getName());

        suite.addTest(new PositionExtractServiceTest("testExtract100"));

        junit.textui.TestRunner.run(suite);
    } // end main()
} // end PositionExtractServiceTest

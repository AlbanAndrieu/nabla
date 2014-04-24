package com.nabla.project.application.model.message.service;

import com.nabla.project.application.api.ExtractService;
import com.nabla.project.application.api.ExtractServiceParameterWrapper;
import com.nabla.project.application.api.config.Condition;
import com.nabla.project.application.api.config.Condition.ConditionId;
import com.nabla.project.application.api.config.Packaging;
import com.nabla.project.application.api.config.Perimeter;
import com.nabla.project.application.api.config.RequestId;
import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.core.pipe.PipeBlockingQueueService;
import com.nabla.project.application.core.spring.AbstractConfig;
import com.nabla.project.application.core.spring.ApplicationContextMessageFactory;
import com.nabla.project.application.core.spring.MessageConfig;
import com.nabla.project.application.core.time.Chronometer;
import com.nabla.project.application.model.message.helpers.CheckFileValidity;
import com.nabla.project.application.model.message.writer.FileDestination;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.HashSet;
import java.util.Set;

/**
 * Author : $author$ Date : $Date: 2010-06-21 14:40:56 +0200 (Thu, 21 Jun 2010) $ Revision : $revision$
 */
public class PositionExtractServiceJaxbTest extends TestCase
{
    protected static Logger               logger = Logger.getLogger(PositionExtractServiceJaxbTest.class);

    static
    {
        Log.init();

        // PropertyConfigurator.configure( "log4j.properties" );
    }

    public Chronometer                    chronometer;
    public ExtractServiceParameterWrapper parameters;

    /**
     * DOCUMENT ME!
     */
    static String                         commonfileName;

    protected void setUp() throws Exception
    {
        chronometer = new Chronometer();
        chronometer.start();
        ApplicationContextMessageFactory.springXmlConfiguration = ApplicationContextMessageFactory.springXmlConfigurationTest;
        ApplicationContextMessageFactory.newExtractionScope();

        parameters = (ExtractServiceParameterWrapper) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanParametersName);

        parameters.setRequestId((RequestId) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(AbstractConfig.beanRequestIdName));
        commonfileName = parameters.getOutput().getUrl();
    } // end setUp()

    protected void tearDown() throws Exception
    {
        chronometer.stop();
        logger.info("Total Time = " + chronometer);
        PipeBlockingQueueService.destroyAllQueue();
    } // end tearDown()

    public PositionExtractServiceJaxbTest(String testName)
    {
        super(testName);
    } // end PositionExtractServiceJaxbTest()

    public PositionExtractServiceJaxbTest()
    {
    } // end PositionExtractServiceJaxbTest()

    public void testExtractTradeByDateMin()
    {
        parameters.getOutput().setUrl(commonfileName + "ByDateMin");
        parameters.setPackaging(Packaging.STANDARD);

        testUrl(parameters.getOutput().getUrl());

        final Integer maxrow = 10;
        Perimeter perimeter = parameters.getPerimeter();
        perimeter.addCondition(new Condition(ConditionId.MAXROW, maxrow.toString()));
        // perimeter.addCondition( new Condition( ConditionId.INDACT ) );
        perimeter.addCondition(new Condition(ConditionId.DATVALMIN, "2010-03-18"));
        // Set<String> idList = new HashSet<String>();
        parameters.getPerimeter().setIdList(null);

        runExtract((ExtractService) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanExtractServiceTradeName), parameters);

        if (parameters.getPackaging().equals(Packaging.STANDARD))
        {
            new CheckFileValidity().checkFileValidityTrades(((FileDestination) parameters.getOutput()).getPath(), maxrow);
        } // end if
    } // end testExtractTradeByDateMin()

    public void testExtractTradeByDateMinPartyAgency()
    {
        parameters.getOutput().setUrl(commonfileName + "ByDateMinPartyAgency");
        parameters.setPackaging(Packaging.STANDARD);

        testUrl(parameters.getOutput().getUrl());

        final Integer maxrow = 10;
        Perimeter perimeter = parameters.getPerimeter();
        perimeter.addCondition(new Condition(ConditionId.MAXROW, maxrow.toString()));
        // perimeter.addCondition( new Condition( ConditionId.INDACT ) );
        // perimeter.addCondition( new Condition( ConditionId.PARTYAGENCY ) );
        perimeter.addCondition(new Condition(ConditionId.DATVALMIN, "2010-03-18"));
        parameters.getPerimeter().setIdList(null);

        runExtract((ExtractService) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanExtractServiceTradeName), parameters);

        if (parameters.getPackaging().equals(Packaging.STANDARD))
        {
            new CheckFileValidity().checkFileValidityTrades(((FileDestination) parameters.getOutput()).getPath(), maxrow);
        } // end if
    } // end testExtractTradeByDateMinPartyAgency()

    public void testExtractTradeByDateMinInternal()
    {
        parameters.getOutput().setUrl(commonfileName + "ByDateMinInternal");
        parameters.setPackaging(Packaging.STANDARD);

        testUrl(parameters.getOutput().getUrl());

        final Integer maxrow = 10;
        Perimeter perimeter = parameters.getPerimeter();
        perimeter.addCondition(new Condition(ConditionId.MAXROW, maxrow.toString()));
        // perimeter.addCondition( new Condition( ConditionId.INDACT ) );
        // perimeter.addCondition( new Condition( ConditionId.INTERNAL ) );
        perimeter.addCondition(new Condition(ConditionId.DATVALMIN, "2010-03-18"));
        parameters.getPerimeter().setIdList(null);

        runExtract((ExtractService) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanExtractServiceTradeName), parameters);

        if (parameters.getPackaging().equals(Packaging.STANDARD))
        {
            new CheckFileValidity().checkFileValidityTrades(((FileDestination) parameters.getOutput()).getPath(), maxrow);
        } // end if
    } // end testExtractTradeByDateMinInternal()

    public void testExtractTradeByDateMinMax()
    {
        parameters.getOutput().setUrl(commonfileName + "ByDateMinMax");
        parameters.setPackaging(Packaging.STANDARD);

        testUrl(parameters.getOutput().getUrl());

        final Integer maxrow = 10;
        Perimeter perimeter = parameters.getPerimeter();
        perimeter.addCondition(new Condition(ConditionId.MAXROW, maxrow.toString()));
        // perimeter.addCondition( new Condition( ConditionId.INDACT ) );
        perimeter.addCondition(new Condition(ConditionId.DATVALMIN, "2010-03-18"));
        perimeter.addCondition(new Condition(ConditionId.DATVALMAX, "2010-03-19"));
        parameters.getPerimeter().setIdList(null);

        runExtract((ExtractService) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanExtractServiceTradeName), parameters);

        if (parameters.getPackaging().equals(Packaging.STANDARD))
        {
            new CheckFileValidity().checkFileValidityTrades(((FileDestination) parameters.getOutput()).getPath(), maxrow);
        } // end if
    } // end testExtractTradeByDateMinMax()

    public void testExtractTradeByDateMinPartyAgencyInternal()
    {
        parameters.getOutput().setUrl(commonfileName + "ByDateMinPartyAgencyInternal");
        parameters.setPackaging(Packaging.STANDARD);

        testUrl(parameters.getOutput().getUrl());

        final Integer maxrow = 10;
        Perimeter perimeter = parameters.getPerimeter();
        perimeter.addCondition(new Condition(ConditionId.MAXROW, maxrow.toString()));
        // perimeter.addCondition( new Condition( ConditionId.INDACT ) );
        // perimeter.addCondition( new Condition( ConditionId.PARTYAGENCY ) );
        // perimeter.addCondition( new Condition( ConditionId.INTERNAL ) );
        perimeter.addCondition(new Condition(ConditionId.DATVALMIN, "2010-03-18"));
        parameters.getPerimeter().setIdList(null);

        runExtract((ExtractService) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanExtractServiceTradeName), parameters);

        if (parameters.getPackaging().equals(Packaging.STANDARD))
        {
            new CheckFileValidity().checkFileValidityTrades(((FileDestination) parameters.getOutput()).getPath(), maxrow);
        } // end if
    } // end testExtractTradeByDateMinPartyAgencyInternal()

    public void testExtractTradeById()
    {
        parameters.getOutput().setUrl(commonfileName + "ById");
        parameters.setPackaging(Packaging.STANDARD);

        testUrl(parameters.getOutput().getUrl());

        Set<String> idList = new HashSet<String>();
        idList.add("TBG4689135");
        idList.add("TBG5219999");
        idList.add("TBG5409967");
        idList.add("TBG5409971");
        idList.add("TBG5421598");
        parameters.getPerimeter().setIdList(idList);

        runExtract((ExtractService) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanExtractServiceTradeName), parameters);

        System.err.println(idList.size());

        if (parameters.getPackaging().equals(Packaging.STANDARD))
        {
            new CheckFileValidity().checkFileValidityTrades(((FileDestination) parameters.getOutput()).getPath(), idList.size());
        } // end if
    } // end testExtractTradeById()

    public void testExtractTradeByIdIndact()
    {
        parameters.getOutput().setUrl(commonfileName + "ByIdIndact");
        parameters.setPackaging(Packaging.STANDARD);

        testUrl(parameters.getOutput().getUrl());

        Perimeter perimeter = parameters.getPerimeter();

        // perimeter.addCondition( new Condition( ConditionId.INDACT ) );
        Set<String> idList = new HashSet<String>();
        idList.add("TBG4689135");
        idList.add("TBG5219999");
        idList.add("TBG5409967");
        idList.add("TBG5409971");
        idList.add("TBG5421598");
        parameters.getPerimeter().setIdList(idList);

        runExtract((ExtractService) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanExtractServiceTradeName), parameters);

        if (parameters.getPackaging().equals(Packaging.STANDARD))
        {
            new CheckFileValidity().checkFileValidityTrades(((FileDestination) parameters.getOutput()).getPath(), idList.size());
        } // end if
    } // end testExtractTradeByIdIndact()

    private void runExtract(final ExtractService extractservice, final ExtractServiceParameterWrapper parameters)
    {
        if ( // ((ExtractServiceCommon) extractservice).setUsingWriterThread(true);
        logger.isDebugEnabled())
        {
            // ((ExtractServiceCommon) extractservice).setUsingWriterThread(true);
            logger.debug("Output : " + ((FileDestination) parameters.getOutput()).getPath());
        } // end if

        extractservice.extractPerimeter(parameters.getPerimeter(), parameters.getRequestId(), parameters.getOutput(), parameters.getStatus(), parameters.getFormat(), parameters.getPackaging());

        assertTrue(parameters.getOutput().toString(), new File(((FileDestination) parameters.getOutput()).getPath()).exists());
    } // end runExtract()

    public void testUrl(final String aUrl)
    {
        URL url;

        if (aUrl != null)
        {
            try
            {
                // Cr�ation d'une URL
                url = new URL("file://" + aUrl);

                if (logger.isDebugEnabled())
                {
                    logger.debug("URL : " + url + " correctement formee\n" + " et protocole " + url.getProtocol() + " reconnu.");
                } // end if

                assertTrue(true);
            } // end try
            catch (MalformedURLException e)
            {
                if ( // URL incorrect ou protocole inconnu
                logger.isDebugEnabled())
                {
                    // URL incorrect ou protocole inconnu
                    logger.debug("URL : " + aUrl + " incorrect\n" + " ou protocole non reconnu\n" + "(Exception " + e + ").");
                } // end if

                assertFalse(true);
            } // end catch
        } // end if
        else
        {
            assertFalse(true);
        } // end else
    } // end testUrl()
} // end PositionExtractServiceJaxbTest

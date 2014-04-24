package com.nabla.project.application.model.message.mapping;

import com.nabla.project.application.api.ExtractService;
import com.nabla.project.application.api.ExtractServiceParameterWrapper;
import com.nabla.project.application.api.config.Packaging;
import com.nabla.project.application.api.config.Perimeter;
import com.nabla.project.application.api.config.RequestId;
import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.core.pipe.PipeBlockingQueueService;
import com.nabla.project.application.core.spring.AbstractConfig;
import com.nabla.project.application.core.spring.ApplicationContextMessageFactory;
import com.nabla.project.application.core.spring.MessageConfig;
import com.nabla.project.application.core.time.Chronometer;
import com.nabla.project.application.model.message.writer.FileDestination;

import org.apache.log4j.Logger;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.custommonkey.xmlunit.XMLTestCase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author : $author$ Date : $Date: 2010-06-21 14:40:56 +0200 (Thu, 21 Jun 2010) $ Revision : $revision$
 */
public class XMLComparisonTest extends XMLTestCase
{
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * DOCUMENT ME!
     */
    XMLComparison  comparison;

    /**
     * DOCUMENT ME!
     */
    String         xmlReference;

    /**
     * DOCUMENT ME!
     */
    String         xmlResult;

    /**
     * DOCUMENT ME!
     */
    Chronometer    chronometer;

    protected void setUp() throws Exception
    {
        Log.init();

        chronometer = new Chronometer();
        chronometer.start();

        if (logger.isDebugEnabled())
        {
            logger.debug("Entering method setUp");
        } // end if

        ApplicationContextMessageFactory.springXmlConfiguration = ApplicationContextMessageFactory.springXmlConfigurationTest;
        ApplicationContextMessageFactory.newExtractionScope();

        // Generate reference file
        comparison = ((XMLComparison) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanComparison));
        xmlReference = comparison.getContentXmlControl();

        ExtractServiceParameterWrapper parameters = (ExtractServiceParameterWrapper) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanParametersName);
        parameters.setPackaging(comparison.getFileXMLTestName().getPackaging());
        parameters.setOutput(comparison.getFileXMLTestName());

        // Info
        logger.info("Reference file name = " + comparison.getFileXMLControlName().getPath());
        logger.info("Result file name = " + comparison.getFileXMLTestName().getPath());

        // Generate reference file
        TestFileGenerator(comparison.getId(), parameters.getOutput().getUrl(), parameters.getPackaging(), parameters);
    } // end setUp()

    protected void tearDown() throws Exception
    {
        chronometer.stop();
        logger.info("Total Time = " + chronometer);
        PipeBlockingQueueService.destroyAllQueue();
    } // end tearDown()

    public void TestFileGenerator(final String id, final String fileUrl, final Packaging packaging, final ExtractServiceParameterWrapper parameters) throws Exception
    {
        ((FileDestination) parameters.getOutput()).setUrl(fileUrl);
        parameters.setPackaging(packaging);

        parameters.setRequestId((RequestId) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(AbstractConfig.beanRequestIdName));

        Perimeter perimeter = parameters.getPerimeter();

        // perimeter.addCondition( new Condition( ConditionId.INDACT ) );
        Set<String> idList = new HashSet<String>();
        idList.add(id);
        parameters.getPerimeter().setIdList(idList);

        ((ExtractService) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanExtractServiceTradeName)).extractPerimeter(parameters.getPerimeter(),
                parameters.getRequestId() /*
                                           * new
                                           * RequestId
                                           * ("001")
                                           */, parameters.getOutput(), parameters.getStatus(), parameters.getFormat(), parameters.getPackaging());

        xmlResult = comparison.getContentXmlTest();

        /*
         * assertTrue(new
         * File(((FileDestination)parameters.getOutput()).getPath()).exists());
         * if (parameters.getPackaging().equals(Packaging.STANDARD)){ new
         * CheckFileValidity
         * ().checkFileValidityTrades(((FileDestination)parameters
         * .getOutput()).getPath(), idList.size()); }
         */
    } // end TestFileGenerator()

    public void testXMLIdentical() throws Exception
    {
        Diff myDiff = new Diff(xmlReference, xmlResult);
        assertTrue("XML similar " + myDiff.toString(), myDiff.similar());
        assertTrue("XML identical " + myDiff.toString(), myDiff.identical());
    } // end testXMLIdentical()

    public void testAllDifferences() throws Exception
    {
        DetailedDiff myDiff = new DetailedDiff(new Diff(xmlReference, xmlResult));
        List allDifferences = myDiff.getAllDifferences();
        assertEquals(myDiff.toString(), 0, allDifferences.size());
    } // end testAllDifferences()

    public void testCompareToSkeletonXML() throws Exception
    {
        DifferenceListener myDifferenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
        Diff myDiff = new Diff(xmlReference, xmlResult);
        myDiff.overrideDifferenceListener(myDifferenceListener);
        assertTrue("test XML matches control skeleton XML", myDiff.similar());
    } // end testCompareToSkeletonXML()
} // end XMLComparisonTest

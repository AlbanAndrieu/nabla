package com.nabla.project.application.model.message.test;

import com.clarkware.junitperf.TimedTest;

import com.nabla.project.application.model.message.extractor.impl.ExtractorDataImplTest;
import com.nabla.project.application.model.message.transformer.TransformerDataTradeJaxbTest;
import com.nabla.project.application.model.message.transformer.TransformerThreadTest;
import com.nabla.project.application.model.message.writer.WriterDataContainerTradeJaxbTest;

import junit.extensions.RepeatedTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Author : $author$ Date : $Date: 2010-06-21 11:30:31 +0200 (Thu, 21 Jun 2010) $ Revision : $revision$
 */
public class PerformanceTest
{
    public static final int nbTransformLoop = 100;
    public static final int nbWriteLoop     = 50;

    public static Test suite()
    {
        TestSuite suite = new TestSuite(UnitaryMappingTests.class.getName());

        // Extractor
        suite.addTest(new TimedTest(new ExtractorDataImplTest("testExtractPerimeter100"), 15000L));
        // suite.addTest(
        // new LoadTest(new ExtractorDataImplTest("testExtractPerimeter100"),2));

        // Transformer
        suite.addTest(new TimedTest(new RepeatedTest(new TransformerDataTradeJaxbTest("testTradeTBG5414992"), nbTransformLoop), 2000L));
        suite.addTest(new TimedTest(new RepeatedTest(new TransformerThreadTest("testTransformPerfWithVerif"), nbTransformLoop), 23000L));
        suite.addTest(new TimedTest(new RepeatedTest(new TransformerThreadTest("testTransformPerfWithoutVerif"), nbTransformLoop), 8000L));

        // Writer
        suite.addTest(new RepeatedTest(new WriterDataContainerTradeJaxbTest("testWriterTradeTBG4689135"), nbWriteLoop));

        return suite;
    } // end suite()

    public static void main(final String[] args)
    {
        junit.textui.TestRunner.run(suite());
    } // end main()
} // end PerformanceTest

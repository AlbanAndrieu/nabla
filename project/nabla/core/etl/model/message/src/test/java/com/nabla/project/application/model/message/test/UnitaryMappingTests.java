package com.nabla.project.application.model.message.test;

import com.nabla.project.application.model.message.extractor.ExtractorThreadTest;
import com.nabla.project.application.model.message.extractor.impl.ExtractorDataImplTest;
import com.nabla.project.application.model.message.transformer.TransformerDataTradeJaxbTest;
import com.nabla.project.application.model.message.transformer.TransformerThreadTest;
import com.nabla.project.application.model.message.writer.WriterDataContainerProductJaxbTest;
import com.nabla.project.application.model.message.writer.WriterDataContainerTradeJaxbTest;
import com.nabla.project.application.model.message.writer.WriterThreadTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Author : $author$ Date : $Date: 2010-06-20 18:06:01 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$
 */
public class UnitaryMappingTests
{
    public static Test suite()
    {
        TestSuite suite = new TestSuite(UnitaryMappingTests.class.getName());

        // MessageConfig technical test
        suite.addTestSuite(com.nabla.project.application.model.message.config.DestinationByteArrayStreamTest.class);

        // Extractor technical test
        suite.addTest(new ExtractorDataImplTest("testExtractPerimeter100"));
        suite.addTest(new ExtractorDataImplTest("testExtractTBG4689135"));
        suite.addTest(new ExtractorDataImplTest("testExtractTBG5414992"));
        suite.addTest(new ExtractorThreadTest("testExtractPerimeter100"));
        suite.addTest(new ExtractorThreadTest("testExtractTBG4689135"));
        suite.addTest(new ExtractorThreadTest("testExtractTBG5414992"));

        // Domain unitary fonctionnal test
        suite.addTestSuite(com.nabla.project.application.model.message.domain.XMLPartySetTest.class);
        suite.addTestSuite(com.nabla.project.application.model.message.domain.XMLProductSetTest.class);
        suite.addTestSuite(com.nabla.project.application.model.message.domain.XMLInventoryTradeMessageSetTest.class);
        suite.addTestSuite(com.nabla.project.application.model.message.domain.XMLTradeSetTest.class);
        suite.addTestSuite(com.nabla.project.application.model.message.domain.PartyTest.class);
        suite.addTestSuite(com.nabla.project.application.model.message.domain.ProductTest.class);
        suite.addTestSuite(com.nabla.project.application.model.message.domain.TradeTest.class);
        suite.addTestSuite(com.nabla.project.application.model.message.domain.XMLTradeTest.class);

        // Helpers unitary technical test
        /*
         * suite.addTestSuite(ExtractionScopeTest.class);
         * suite.addTestSuite(PipeListenerContainerTest.class);
         * suite.addTestSuite(PipeListenerContainerCounterTest.class);
         * suite.addTestSuite(StreamTest.class);
         */

        // Perimeter technical test
        suite.addTestSuite(com.nabla.project.application.model.message.config.PerimeterTest.class);

        // Transformer technical test
        suite.addTest(new TransformerDataTradeJaxbTest("testTradeTBG4689135"));
        suite.addTest(new TransformerDataTradeJaxbTest("testTradeTBG5414992"));
        suite.addTest(new TransformerThreadTest("testTransformTBG4689135"));
        suite.addTest(new TransformerThreadTest("testTransformTBG5414992"));

        // Writer technical test
        suite.addTest(new WriterDataContainerTradeJaxbTest("testWriterTradeTBG4689135"));
        suite.addTest(new WriterDataContainerTradeJaxbTest("testWriterTradeTBG5414992"));

        suite.addTest(new WriterDataContainerProductJaxbTest("testWriterProduct3464"));
        suite.addTest(new WriterDataContainerProductJaxbTest("testWriterProduct1925165"));

        suite.addTest(new WriterThreadTest("testWriterTBG4689135"));
        suite.addTest(new WriterThreadTest("testWriterTBG5414992"));

        // suite.addTest(new WriterDataJaxbTest("testWriterTradeTBG4689135"));
        // suite.addTest(new WriterJaxbTest("testWriterTradeTBG5414992"));

        // Main service
        suite.addTestSuite(com.nabla.project.application.model.message.service.PositionExtractServiceTest.class);
        suite.addTestSuite(com.nabla.project.application.model.message.service.PositionExtractParallelServiceTest.class);

        return suite;
    } // end suite()

    public static void main(final String[] args)
    {
        junit.textui.TestRunner.run(suite());
    } // end main()
} // end UnitaryMappingTests

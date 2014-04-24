package com.nabla.project.application.model.message.helpers;

import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.core.spring.ApplicationContextMessageFactory;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import org.apache.log4j.Logger;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.XMLTestCase;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

/**
 * Author : $author$ Date : $Date: 2010-06-22 14:58:07 +0200 (Fri, 22 Jun 2010) $ Revision : $revision$
 */
public class XmlTest extends XMLTestCase
{
    protected static Logger logger                  = Logger.getLogger(XmlTest.class);
    public static String    xmlDiffEngineBean       = "xmlDiffTrade";
    public static String    xmlValidatorBean        = "xmlValidator";
    public static String    xmlValidationCharOption = "v";
    public static String    xmlValidationOption     = "valid";
    public static String    xmlFileRefArg           = "ref";
    public static String    xmlFileTestArg          = "test";
    public static String    xmlFileXsdArg           = "xsd";

    static
    {
        ApplicationContextMessageFactory.springXmlConfigurationTest = ApplicationContextMessageFactory.springXmlDefaultConfiguration;
    }

    public void setUp()
    {
        Log.init();
    } // end setUp()

    public static void assertXmlIdentical(final String reference, final String test) throws SAXException, IOException, ParserConfigurationException
    {
        assertXmlIdentical(reference, test, xmlDiffEngineBean);
    } // end assertXmlIdentical()

    public static void assertXmlIdentical(final String reference, final String test, final String xmlDiffEngineBean) throws SAXException, IOException, ParserConfigurationException
    {
        Diff diff = new Diff(reference, test);
        diff.overrideDifferenceListener((DifferenceListener) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(xmlDiffEngineBean));
        assertTrue(diff.identical());
    } // end assertXmlIdentical()

    public static void assertXmlSimilar(final String reference, final String test) throws SAXException, IOException, ParserConfigurationException
    {
        assertXmlSimilar(reference, test, xmlDiffEngineBean);
    } // end assertXmlSimilar()

    public static void assertXmlSimilar(final String reference, final String test, final String xmlDiffEngineBean) throws SAXException, IOException, ParserConfigurationException
    {
        Diff diff = new Diff(reference, test);
        diff.overrideDifferenceListener((DifferenceListener) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(xmlDiffEngineBean));
        assertTrue(diff.similar());
    } // end assertXmlSimilar()

    public static void assertXmlIdentical(final InputSource reference, final InputSource test) throws SAXException, IOException, ParserConfigurationException
    {
        assertXmlSimilar(reference, test, xmlDiffEngineBean);
    } // end assertXmlIdentical()

    public static void assertXmlIdentical(final InputSource reference, final InputSource test, final String xmlDiffEngineBean) throws SAXException, IOException, ParserConfigurationException
    {
        Diff diff = new Diff(reference, test);
        diff.overrideDifferenceListener((DifferenceListener) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(xmlDiffEngineBean));
        assertTrue(diff.identical());
    } // end assertXmlIdentical()

    public static void assertXmlSimilar(final InputSource reference, final InputSource test) throws SAXException, IOException, ParserConfigurationException
    {
        assertXmlSimilar(reference, test, xmlDiffEngineBean);
    } // end assertXmlSimilar()

    public static void assertXmlSimilar(final InputSource reference, final InputSource test, final String xmlDiffEngineBean) throws SAXException, IOException, ParserConfigurationException
    {
        Diff diff = new Diff(reference, test);
        diff.overrideDifferenceListener((DifferenceListener) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(xmlDiffEngineBean));
        assertTrue(diff.similar());
    } // end assertXmlSimilar()

    public void testIdenticalNormal() throws Exception
    {
        Diff diff = new Diff("<a><b/><c/></a>", "<a><c/><b/></a>");
        assertFalse(diff.identical());
        assertTrue(diff.similar());
    } // end testIdenticalNormal()

    public void testSubPartIdentical() throws Exception
    {
        Diff diff = new Diff("<a><b/><c/></a>", "<a><c/><b/></a>");
        List<String> xPaths = new ArrayList<String>();
        xPaths.add("/a\\[[0-9]+\\]/b\\[[0-9]+\\].*");
        xPaths.add("/a\\[[0-9]+\\]/c\\[[0-9]+\\].*");
        diff.overrideDifferenceListener(new XmlDiffXPath(xPaths));
        assertTrue(diff.identical());
        assertTrue(diff.similar());
    } // end testSubPartIdentical()

    public void testXmlDiffTest() throws Exception
    {
        String reference = "<a><b/><c/></a>";
        String test = "<a><c/><b/></a>";
        assertXmlIdentical(reference, test, "xmlDiffTest");
        assertXmlSimilar(reference, test, "xmlDiffTest");
    } // end testXmlDiffTest()

    public void testXmlFilesIdentical(final String fileNameReference, final String fileNameTest) throws Exception
    {
        if ( // Debug
        logger.isDebugEnabled())
        {
            // Debug
            logger.debug("fileNameReference=" + fileNameReference);
        } // end if

        if (logger.isDebugEnabled())
        {
            logger.debug("fileNameTest=" + fileNameTest);
        } // end if

        //
        InputSource inputSourceReference = new InputSource(new FileInputStream(fileNameReference));
        InputSource inputSourceTest = new InputSource(new FileInputStream(fileNameTest));
        // Test
        assertXmlIdentical(inputSourceReference, inputSourceTest);
    } // end testXmlFilesIdentical()

    public void assertXmlFilesSimilar(final String fileNameReference, final String fileNameTest) throws Exception
    {
        if ( // Debug
        logger.isDebugEnabled())
        {
            // Debug
            logger.debug("fileNameReference=" + fileNameReference);
        } // end if

        if (logger.isDebugEnabled())
        {
            logger.debug("fileNameTest=" + fileNameTest);
        } // end if

        //
        InputSource inputSourceReference = new InputSource(new FileInputStream(fileNameReference));
        InputSource inputSourceTest = new InputSource(new FileInputStream(fileNameTest));
        // Test
        assertXmlSimilar(inputSourceReference, inputSourceTest);
    } // end assertXmlFilesSimilar()

    public static void xmlValidation(final String xmlContent) throws ParserConfigurationException, SAXException, IOException
    {
        xmlValidation(new ByteArrayInputStream(xmlContent.getBytes()));
    } // end xmlValidation()

    public static void xmlFileValidation(final String xmlFileName) throws ParserConfigurationException, SAXException, IOException
    {
        xmlValidation(new FileInputStream(xmlFileName));
    } // end xmlFileValidation()

    public static void xmlValidation(final InputStream inputStream) throws ParserConfigurationException, SAXException, IOException
    {
        SAXParserFactory parserFct = SAXParserFactory.newInstance();
        parserFct.setValidating(true);

        javax.xml.parsers.SAXParser parser = parserFct.newSAXParser();
        parser.parse(inputStream, new DefaultHandler());
    } // end xmlValidation()

    public void testXmlValidationGood() throws Exception
    {
        xmlValidation("<a><b/><c/></a>");
        xmlValidation("<a><b><c/></b></a>");
    } // end testXmlValidationGood()

    public void testXmlValidationBad() throws Exception
    {
        try
        {
            xmlValidation("<a><b><c/></a>");
        } // end try
        catch (Exception ex)
        {
        } // end catch

        try
        {
            xmlValidation("<a><b><c/></a>");
        } // end try
        catch (Exception ex)
        {
        } // end catch
    } // end testXmlValidationBad()

    public static void xmlSchemaValidation(final String xmlContent) throws Exception
    {
        try
        {
            xmlSchemaValidation(new ByteArrayInputStream(xmlContent.getBytes()));
        } // end try
        catch (Exception ex)
        {
            logger.error(ex.getMessage() + ':');
            logger.error(xmlContent);
            throw (ex);
        } // end catch
    } // end xmlSchemaValidation()

    public static void xmlSchemaValidation(final String schemaFileName, final String xmlContent) throws ParserConfigurationException, SAXException, IOException
    {
        xmlSchemaValidation(new ByteArrayInputStream(xmlContent.getBytes()));
    } // end xmlSchemaValidation()

    public static void xmlFileSchemaValidation(final String xmlFileName) throws ParserConfigurationException, SAXException, IOException
    {
        xmlSchemaValidation(new FileInputStream(xmlFileName));
    } // end xmlFileSchemaValidation()

    public static void xmlFileSchemaValidation(final String schemaFileName, final String xmlFileName) throws ParserConfigurationException, SAXException, IOException
    {
        xmlSchemaValidation(new FileInputStream(xmlFileName));
    } // end xmlFileSchemaValidation()

    public static void xmlSchemaValidation(final InputStream inputStreamXml) throws ParserConfigurationException, SAXException, IOException
    {
        XmlValidator xmlValidator = (XmlValidator) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(xmlValidatorBean);
        xmlValidator.validate(inputStreamXml);
    } // end xmlSchemaValidation()

    public void testXmlSchemaValidationGood() throws Exception
    {
        /*
         * String schemaSource=System.getProperty("user.dir")+ File.separator+"xml"+ File.separator+"SgibML_root.xsd";
         * xmlFileSchemaValidation(schemaSource, "C:\\Documents and Settings\\bfarez051507\\Desktop\\TradeTBG4689135Ref.xml");
         * xmlFileSchemaValidation("C:\\Documents and Settings\\bfarez051507\\Desktop\\TradeTBG4689135Ref.xml");
         */
    } // end testXmlSchemaValidationGood()

    public void testXmlSchemaValidationBad() throws Exception
    {
        String schemaSource = System.getProperty("user.dir") + File.separator + "xml" + File.separator + "A_XML_root.xsd";

        try
        {
            xmlSchemaValidation(schemaSource, "<a><b/><c/></a>");
        } // end try
        catch (Exception ex)
        {
        } // end catch

        try
        {
            xmlFileSchemaValidation(schemaSource, "C:\\temp\\TradeTBG4689135Test.xml");
        } // end try
        catch (Exception ex)
        {
        } // end catch
    } // end testXmlSchemaValidationBad()

    public static void banner(final Options options)
    {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("XmlTest", options);
    } // end banner()

    public static void main(final String[] args)
    {
        Log.init();

        /*
         * args=new String[]
         * {
         * "+"+xmlValidationOption,
         * "-"+xmlFileTestArg,
         * "C:\\Documents and Settings\\bfarez051507\\Desktop\\TradeTBG4689135Test.xml",
         * "-"+xmlFileRefArg,
         * "C:\\Documents and Settings\\bfarez051507\\Desktop\\TradeTBG4689135Ref.xml",
         * "-"+xmlFileXsdArg,
         * "C:\\USERS\\brice\\workfolder\\SGCIBML_Extract\\trunk\\poc\\JavaExtractorJaxb2\\xml\\SgibML_root.xsd",
         * };
         */

        // Create Options object
        Options options = new Options();

        // Add options
        options.addOption(xmlValidationCharOption, xmlValidationOption, true, "well formed xml document verification");
        options.addOption(OptionBuilder.withArgName("file").hasArg().isRequired().withDescription("xml file to test").create(xmlFileTestArg));
        options.addOption(OptionBuilder.withArgName("file").hasArg().withDescription("xml reference file").create(xmlFileRefArg));
        options.addOption(OptionBuilder.withArgName("file").hasArg().withDescription("xsd schema file").create(xmlFileXsdArg));

        CommandLineParser parser = new GnuParser();
        CommandLine cmd;

        try
        {
            cmd = parser.parse(options, args);
        } // end try
        catch (ParseException ex)
        {
            System.err.println(ex);
            banner(options);

            return;
        } // end catch

        String xmlFileNameTest = cmd.getOptionValue(xmlFileTestArg);
        String xmlFileNameRef = cmd.getOptionValue(xmlFileRefArg);
        String schemaFileName = cmd.getOptionValue(xmlFileXsdArg);

        // Is xml test well formed ?
        if (cmd.hasOption(xmlValidationCharOption))
        {
            try
            {
                xmlFileValidation(xmlFileNameTest);
                logger.info("TEST_XML_FILE correctly formed");
            } // end try
            catch (Exception ex)
            {
                logger.error("TEST_XML_FILE badly formed (" + ex.getMessage() + ")");
            } // end catch
        } // end if

        // Is xml test valid with schema ?
        if (cmd.hasOption(xmlFileXsdArg))
        {
            try
            {
                if (schemaFileName != null)
                {
                    xmlFileSchemaValidation(schemaFileName, xmlFileNameTest);
                } // end if
                else
                {
                    xmlFileSchemaValidation(xmlFileNameTest);
                } // end else

                logger.info("TEST_XML_FILE conformed to schema");
            } // end try
            catch (Exception ex)
            {
                logger.error("TEST_XML_FILE not conformed to schema (" + ex.getMessage() + ")");
            } // end catch
        } // end if

        // Is xml test and ref files similar ?
        if (cmd.hasOption(xmlFileRefArg))
        {
            try
            {
                assertXmlSimilar(new InputSource(new FileInputStream(xmlFileNameRef)), new InputSource(new FileInputStream(xmlFileNameTest)));
                logger.info("TEST_XML_FILE and REF_XML_FILE are similar");
            } // end try
            catch (Exception ex)
            {
                logger.error("TEST_XML_FILE and REF_XML_FILE are not similar (" + ex.getMessage() + ")");
            } // end catch
        } // end if

        // Is xml test and ref files identical ?
        if (cmd.hasOption(xmlFileRefArg))
        {
            try
            {
                assertXmlIdentical(new InputSource(new FileInputStream(xmlFileNameRef)), new InputSource(new FileInputStream(xmlFileNameTest)));
                logger.info("TEST_XML_FILE and REF_XML_FILE are identical");
            } // end try
            catch (Exception ex)
            {
                logger.error("TEST_XML_FILE and REF_XML_FILE are not identical (" + ex.getMessage() + ")");
            } // end catch
        } // end if
    } // end main()
} // end XmlTest

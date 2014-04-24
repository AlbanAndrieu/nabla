package com.nabla.project.application.model.message.helpers;

import com.nabla.project.application.api.TechnicalException;
import com.nabla.project.application.core.log.Log;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import org.apache.xerces.parsers.SAXParser;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;

/**
 * Author : $author$ Date : $Date: 2010-06-20 17:01:12 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$
 */
public class CheckFileValidity extends TestCase
{
    private Logger logger = Logger.getLogger(this.getClass());

    public CheckFileValidity()
    {
        Log.init();
    } // end CheckFileValidity()

    public void testFileValidity()
    {
        new CheckFileValidity().checkFileValidityTradesProducts(null, -1);
    } // end testFileValidity()

    public void checkFileValidityTrades(String file, final int rowExpected)
    {
        InputSource inputSource = null;

        try
        {
            inputSource = new InputSource(file);

            SAXParser p = new SAXParser();
            MySaxHandler handler = new MySaxHandler();
            p.setContentHandler(handler);

            if (file == null)
            {
                file = System.getProperty("user.dir") + File.separator + "target" + File.separator + "testExtractMrp.xml";
            } // end if

            p.parse(inputSource);
            logger.info("Trade count = " + handler.getTradeCount());
            logger.info("Product count = " + handler.getProductCount());
            logger.info("Party count = " + handler.getPartyCount());

            if (rowExpected != -1)
            {
                assertEquals(rowExpected, handler.getTradeCount());
                assertEquals(0, handler.getProductCount());
                assertEquals(rowExpected * 2, handler.getPartyCount());
            } // end if

            File f = new File(file);

            if (logger.isDebugEnabled())
            {
                logger.debug("File path = " + f.getCanonicalPath());
            } // end if

            logger.info("File lenght = " + f.length());
        } // end try
        catch (Exception e)
        {
            throw new TechnicalException("Error parsing file", e);
        } // end catch
    } // end checkFileValidityTrades()

    public void checkFileValidityProducts(String file, final int rowExpected)
    {
        try
        {
            SAXParser p = new SAXParser();
            MySaxHandler handler = new MySaxHandler();
            p.setContentHandler(handler);

            if (file == null)
            {
                file = System.getProperty("user.dir") + File.separator + "target" + File.separator + "testExtractMrp.xml";
            } // end if

            p.parse(new InputSource(file));
            logger.info("Trade count = " + handler.getTradeCount());
            logger.info("Product count = " + handler.getProductCount());
            logger.info("Party count = " + handler.getPartyCount());

            if (rowExpected != -1)
            {
                assertEquals(0, handler.getTradeCount());
                assertEquals(rowExpected, handler.getProductCount());
                assertEquals(rowExpected, handler.getPartyCount());
            } // end if

            File f = new File(file);

            if (logger.isDebugEnabled())
            {
                logger.debug("File path = " + f.getCanonicalPath());
            } // end if

            logger.info("File lenght = " + f.length());
        } // end try
        catch (Exception e)
        {
            throw new TechnicalException("Error parsing file", e);
        } // end catch
    } // end checkFileValidityProducts()

    public void checkFileValidityTradesProducts(String file, final int rowExpected)
    {
        try
        {
            SAXParser p = new SAXParser();
            MySaxHandler handler = new MySaxHandler();
            p.setContentHandler(handler);

            if (file == null)
            {
                file = System.getProperty("user.dir") + File.separator + "target" + File.separator + "testExtractMrp.xml";
            } // end if

            p.parse(new InputSource(file));
            logger.info("Trade count = " + handler.getTradeCount());
            logger.info("Product count = " + handler.getProductCount());
            logger.info("Party count = " + handler.getPartyCount());

            if (rowExpected != -1)
            {
                assertEquals(rowExpected, handler.getTradeCount());
                assertEquals(rowExpected, handler.getProductCount());
                assertEquals(rowExpected * 3, handler.getPartyCount());
            } // end if

            File f = new File(file);

            if (logger.isDebugEnabled())
            {
                logger.debug("File path = " + f.getCanonicalPath());
            } // end if

            logger.info("File lenght = " + f.length());
        } // end try
        catch (Exception e)
        {
            throw new TechnicalException("Error parsing file", e);
        } // end catch
    } // end checkFileValidityTradesProducts()

    private class MySaxHandler extends DefaultHandler
    {
        private int tradeCount   = 0;
        private int productCount = 0;
        private int partyCount   = 0;

        @Override
        public void startElement(final String uri, final String localName, final String qName, final Attributes attributes) throws SAXException
        {
            if (localName.equalsIgnoreCase("trade"))
            {
                tradeCount++;
            } // end if
            else if (localName.equalsIgnoreCase("product"))
            {
                productCount++;
            } // end else if
            else if (localName.equalsIgnoreCase("party"))
            {
                partyCount++;
            } // end else if
        } // end startElement()

        public int getPartyCount()
        {
            return partyCount;
        } // end getPartyCount()

        public int getProductCount()
        {
            return productCount;
        } // end getProductCount()

        public int getTradeCount()
        {
            return tradeCount;
        } // end getTradeCount()
    } // end MySaxHandler
} // end CheckFileValidity

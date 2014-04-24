package com.nabla.project.application.model.message.domain;

import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.model.message.transformer.ModelTransformer;
import com.nabla.project.application.model.message.transformer.common.XMLTradeModelTransformer;
import com.nabla.project.application.model.message.xml.JaxbDateHelper;
import com.nabla.project.application.model.xml.XMLCode;
import com.nabla.project.application.model.xml.XMLTrade;
import com.nabla.project.application.model.xml.TradeDirectionScheme;
import com.nabla.project.application.model.xml.TradePartyInfo;

import junit.framework.TestCase;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBElement;

/**
 * Author : $author$ Date : $Date: 2010-06-20 17:01:12 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$ Test below are launched via class
 * TestsUnitairesMapping
 */
public class XMLTradeSetTest extends TestCase
{
    public void setUp()
    {
        Log.init();
    } // end setUp()

    public static void testXMLTrade(final XMLTrade XMLTrade)
    {
        assertNotNull(XMLTrade);
        // TRADE GLOBAL
        assertEquals(ModelTransformer.BACK_TRADE_VERSION_SCHEME, XMLTrade.getVersion());
        // trade/tradeHeader/tradeIdentifier/tradeId/idScheme
        assertEquals(ModelTransformer.BACK_TRADE_SCHEME, XMLTrade.getTradeHeader().getTradeIdentifier().getTradeId().getIdScheme());

        // TODO not sure ... to check
        List<XMLCode> xmlCodeList = XMLTrade.getTradeHeader().getTradeIdentifier().getTradeCode();

        for (XMLCode code : xmlCodeList)
        {
            // trade/tradeHeader/tradeIdentifier/tradeCode/codingScheme
            assertEquals(ModelTransformer.FRONT_TRADE_SCHEME, code.getCodingScheme());
        } // end for

        // TRADE PARTIES
        List<TradePartyInfo> tradePartyInfoList = XMLTrade.getTradePartyInfo();

        for (TradePartyInfo partyInfo : tradePartyInfoList)
        {
            // trade/tradePartyInfo/storageApplication/id
            assertEquals(ModelTransformer.BACK_UNKNOWN_SCHEME, partyInfo.getStorageApplication().getId());
        } // end for
    } // end testXMLTrade()

    public static String               idSCN01         = TradeTest.idSCN01;
    public static String               idVersionSCN01  = TradeTest.idVersionSCN01;
    public static Date                 tradeDateSCN01  = TradeTest.tradeDateSCN01;
    public static Date                 valueDateSCN01  = TradeTest.valueDateSCN01;
    public static Date                 systemDateSCN01 = TradeTest.systemDateSCN01;
    public static BigDecimal           quantitySCN01   = TradeTest.quantitySCN01;
    public static BigDecimal           priceSCN01      = TradeTest.priceSCN01;
    public static TradeDirectionScheme directionSCN01  = TradeDirectionScheme.SELL; // TradeTest.directionSCN01;
    public static String               idFrontSCN01    = TradeTest.idFrontSCN01;

    public static XMLTrade getXMLTradeSCN01()
    {
        XMLTradeModelTransformer tradeModelTransformer = new XMLTradeModelTransformer();
        XMLTrade XMLTrade = (XMLTrade) tradeModelTransformer.buildTrade(TradeTest.getTrade(TradeTest.idSCN01));

        return XMLTrade;
    } // end getXMLTradeSCN01()

    public static void testXMLTradeSCN01(final XMLTrade XMLTrade)
    {
        testXMLTrade(XMLTrade);
        /** TRADE GLOBAL **/

        // assertEquals(trade.getReference(), XMLTrade.getId());
        /** TRADE HEADER **/

        // trade/tradeHeader/tradeIdentifier/tradeId/id
        assertEquals(idSCN01, XMLTrade.getTradeHeader().getTradeIdentifier().getTradeId().getId());
        // trade/tradeHeader/tradeIdentifier/tradeVersion/versionNumber
        assertEquals(idVersionSCN01, XMLTrade.getTradeHeader().getTradeIdentifier().getTradeVersion().getVersionNumber());

        // TODO not sure ... to check
        List<XMLCode> kxmlCodeList = XMLTrade.getTradeHeader().getTradeIdentifier().getTradeCode();

        for (XMLCode code : kxmlCodeList)
        {
            // trade/tradeHeader/tradeIdentifier/tradeCode/code
            assertEquals(idFrontSCN01, code.getCode());
        } // end for

        /** TRADE CONDITIONS **/

        // trade/tradeConditions/tradeDate
        assertEquals(JaxbDateHelper.getJaxbDate(tradeDateSCN01), XMLTrade.getTradeConditions().getTradeDate());
        // trade/tradeConditions/tradeTimeStamp
        assertNotNull(XMLTrade.getTradeConditions().getTradeTimeStamp());
        // !!! @TODO assertEquals(systemDateSCN01.getTime(),
        // XMLTrade.getTradeConditions().getTradeTimeStamp());
        // trade/tradeConditions/APartyReference
        // assertEquals(portfolioParty.getReference(),
        // XMLTrade.getTradeConditions().getAPartyId().getId());
        // trade/tradeConditions/BPartyReference
        // assertEquals(counterParty.getReference(),
        // XMLTrade.getTradeConditions().getBPartyId().getId());
        // trade/tradeConditions/exchangedProduct1/quantity
        assertEquals(quantitySCN01, XMLTrade.getTradeConditions().getExchangedProduct().getQuantity());
        // trade/tradeConditions/exchangedProduct1/valueDate
        assertEquals(JaxbDateHelper.getJaxbDate(valueDateSCN01), XMLTrade.getTradeConditions().getExchangedProduct().getValueDate());
        // trade/tradeConditions/ATradeDirection
        assertEquals(directionSCN01, XMLTrade.getTradeConditions().getATradeDirection());

        /** TRADE PARTIES **/
        List<TradePartyInfo> tradePartyInfoList = XMLTrade.getTradePartyInfo();

        for (TradePartyInfo partyInfo : tradePartyInfoList)
        {
            // String partyIdScheme = partyInfo.getPartyId().getIdScheme();
        } // end for
    } // end testXMLTradeSCN01()

    public static void testXMLTradeSCN01()
    {
        testXMLTradeSCN01(getXMLTradeSCN01());
    } // end testXMLTradeSCN01()

    public static JAXBElement<XMLTrade> getJAXBXMLTradeSCN01()
    {
        XMLTradeModelTransformer tradeModelTransformer = new XMLTradeModelTransformer();
        JAXBElement<XMLTrade> jaxbXMLTrade = (JAXBElement<XMLTrade>) tradeModelTransformer.transform(TradeTest.getTrade(TradeTest.idSCN01));

        return jaxbXMLTrade;
    } // end getJAXBXMLTradeSCN01()

    public static void testJAXBXMLTradeSCN01(final JAXBElement<XMLTrade> jaxbXMLTrade)
    {
        assertNotNull(jaxbXMLTrade);
        testXMLTradeSCN01(jaxbXMLTrade.getValue());
    } // end testJAXBXMLTradeSCN01()

    public void testJAXBXMLTradeSCN01()
    {
        testJAXBXMLTradeSCN01(getJAXBXMLTradeSCN01());
    } // end testJAXBXMLTradeSCN01()

    public static String               idSCN02         = TradeTest.idSCN02;
    public static String               idVersionSCN02  = TradeTest.idVersionSCN02;
    public static Date                 tradeDateSCN02  = TradeTest.tradeDateSCN02;
    public static Date                 valueDateSCN02  = TradeTest.valueDateSCN02;
    public static Date                 systemDateSCN02 = TradeTest.systemDateSCN02;
    public static BigDecimal           quantitySCN02   = TradeTest.quantitySCN02;
    public static BigDecimal           priceSCN02      = TradeTest.priceSCN02;
    public static TradeDirectionScheme directionSCN02  = TradeDirectionScheme.BUY; // TradeTest.directionSCN02;
    // ??
    public static String               idFrontSCN02    = TradeTest.idFrontSCN02;

    public static XMLTrade getXMLTradeSCN02()
    {
        XMLTradeModelTransformer tradeModelTransformer = new XMLTradeModelTransformer();
        XMLTrade XMLTrade = (XMLTrade) tradeModelTransformer.buildTrade(TradeTest.getTrade(TradeTest.idSCN02));

        return XMLTrade;
    } // end getXMLTradeSCN02()

    public static void testXMLTradeSCN02(final XMLTrade XMLTrade)
    {
        testXMLTrade(XMLTrade);
        /** TRADE GLOBAL **/

        // assertEquals(trade.getReference(), XMLTrade.getId());
        /** TRADE HEADER **/

        // trade/tradeHeader/tradeIdentifier/tradeId/id
        assertEquals(idSCN02, XMLTrade.getTradeHeader().getTradeIdentifier().getTradeId().getId());
        // trade/tradeHeader/tradeIdentifier/tradeVersion/versionNumber
        assertEquals(idVersionSCN02, XMLTrade.getTradeHeader().getTradeIdentifier().getTradeVersion().getVersionNumber());

        // TODO not sure ... to check
        List<XMLCode> kxmlCodeList = XMLTrade.getTradeHeader().getTradeIdentifier().getTradeCode();

        for (XMLCode code : kxmlCodeList)
        {
            // trade/tradeHeader/tradeIdentifier/tradeCode/code
            assertEquals(idFrontSCN02, code.getCode());
        } // end for

        /** TRADE CONDITIONS **/

        // trade/tradeConditions/tradeDate
        assertEquals(JaxbDateHelper.getJaxbDate(tradeDateSCN02), XMLTrade.getTradeConditions().getTradeDate());
        // trade/tradeConditions/tradeTimeStamp
        assertNotNull(XMLTrade.getTradeConditions().getTradeTimeStamp());
        // !!! @TODO assertEquals(systemDateSCN02.getTime(),
        // XMLTrade.getTradeConditions().getTradeTimeStamp());
        // trade/tradeConditions/APartyReference
        // assertEquals(portfolioParty.getReference(),
        // XMLTrade.getTradeConditions().getAPartyId().getId());
        // trade/tradeConditions/BPartyReference
        // assertEquals(counterParty.getReference(),
        // XMLTrade.getTradeConditions().getBPartyId().getId());
        // trade/tradeConditions/exchangedProduct1/quantity
        assertEquals(quantitySCN02, XMLTrade.getTradeConditions().getExchangedProduct().getQuantity());
        // trade/tradeConditions/exchangedProduct1/valueDate
        assertEquals(JaxbDateHelper.getJaxbDate(valueDateSCN02), XMLTrade.getTradeConditions().getExchangedProduct().getValueDate());
        // trade/tradeConditions/ATradeDirection
        assertEquals(directionSCN02, XMLTrade.getTradeConditions().getATradeDirection());

        /** TRADE PARTIES **/
        List<TradePartyInfo> tradePartyInfoList = XMLTrade.getTradePartyInfo();

        for (TradePartyInfo partyInfo : tradePartyInfoList)
        {
            // String partyIdScheme = partyInfo.getPartyId().getIdScheme();
        } // end for
    } // end testXMLTradeSCN02()

    public static void testXMLTradeSCN02()
    {
        testXMLTradeSCN02(getXMLTradeSCN02());
    } // end testXMLTradeSCN02()

    public static JAXBElement<XMLTrade> getJAXBXMLTradeSCN02()
    {
        XMLTradeModelTransformer tradeModelTransformer = new XMLTradeModelTransformer();
        JAXBElement<XMLTrade> jaxbXMLTrade = (JAXBElement<XMLTrade>) tradeModelTransformer.transform(TradeTest.getTrade(TradeTest.idSCN02));

        return jaxbXMLTrade;
    } // end getJAXBXMLTradeSCN02()

    public static void testJAXBXMLTradeSCN02(final JAXBElement<XMLTrade> jaxbXMLTrade)
    {
        assertNotNull(jaxbXMLTrade);

        // testXMLTradeSCN02(jaxbXMLTrade.getValue());
    } // end testJAXBXMLTradeSCN02()

    public void testJAXBXMLTradeSCN02()
    {
        testJAXBXMLTradeSCN02(getJAXBXMLTradeSCN02());
    } // end testJAXBXMLTradeSCN02()
} // end XMLTradeTest

package com.nabla.project.application.model.message.domain;

import javax.xml.bind.JAXBElement;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.nabla.project.application.api.transformer.TransformerDataInterface;
import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.core.spring.ApplicationContextMessageFactory;
import com.nabla.project.application.core.spring.MessageConfig;
import com.nabla.project.application.model.xml.XMLInventoryTradeMessage;

/**
 * Author : $author$ Date : $Date: 2010-06-20 17:01:12 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$
 */
public class XMLInventoryTradeMessageSetTest extends TestCase
{
    protected static Logger                   logger = Logger.getLogger(XMLInventoryTradeMessageSetTest.class);
    protected static TransformerDataInterface transformer;

    static
    {
        Log.init();
        ApplicationContextMessageFactory.springXmlConfiguration = ApplicationContextMessageFactory.springXmlConfigurationTest;
        transformer = (TransformerDataInterface) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanDataTransformerTradeEventMessageName);
    }

    public static XMLInventoryTradeMessage /* XMLTradeEventMessage */getXMLInventoryTradeMessageSCN01()
    {
        /* XMLTradeEventMessage */XMLInventoryTradeMessage tradeEventMessage = new XMLInventoryTradeMessage() /*
                                                                                                               * XMLTradeEventMessage
                                                                                                               * (
                                                                                                               * )
                                                                                                               */;

        tradeEventMessage.setTrade(XMLTradeSetTest.getXMLTradeSCN01());

        // Portfolio
        tradeEventMessage.getParty().add(XMLPartySetTest.getXMLParty3());

        // Counter Party
        tradeEventMessage.getParty().add(XMLPartySetTest.getXMLParty2());

        return tradeEventMessage;
    } // end getXMLInventoryTradeMessageSCN01()

    public static void testXMLInventoryTradeMessageSCN01(final XMLInventoryTradeMessage tradeEventMessage)
    {
        assertNotNull(tradeEventMessage);
        XMLTradeSetTest.testXMLTradeSCN01(tradeEventMessage.getTrade());

        // Party
        assertEquals(2, tradeEventMessage.getParty().size());

        // Portfolio
        XMLPartySetTest.testXMLParty3(tradeEventMessage.getParty().get(0));

        // Counter Party
        XMLPartySetTest.testXMLParty2(tradeEventMessage.getParty().get(1));
    } // end testXMLInventoryTradeMessageSCN01()

    public void testXMLInventoryTradeMessageSCN01()
    {
        testXMLInventoryTradeMessageSCN01(getXMLInventoryTradeMessageSCN01());
    } // end testXMLInventoryTradeMessageSCN01()

    @SuppressWarnings("unchecked")
    public static JAXBElement<XMLInventoryTradeMessage> getJAXBXMLInventoryTradeMessageSCN01()
    {
        JAXBElement<XMLInventoryTradeMessage> jaxbXMLInventoryTradeMessage = (JAXBElement<XMLInventoryTradeMessage>) transformer.transform(TradeTest.getTrade(TradeTest.idSCN01));

        return jaxbXMLInventoryTradeMessage;
    } // end getJAXBXMLInventoryTradeMessageSCN01()

    public static void testJAXBXMLInventoryTradeMessageSCN01(final JAXBElement<XMLInventoryTradeMessage> jaxbXMLInventoryTradeMessage)
    {
        assertNotNull(jaxbXMLInventoryTradeMessage);
        testXMLInventoryTradeMessageSCN01(jaxbXMLInventoryTradeMessage.getValue());
    } // end testJAXBXMLInventoryTradeMessageSCN01()

    public void testJAXBXMLInventoryTradeMessageSCN01()
    {
        testJAXBXMLInventoryTradeMessageSCN01(getJAXBXMLInventoryTradeMessageSCN01());
    } // end testJAXBXMLInventoryTradeMessageSCN01()

    public static XMLInventoryTradeMessage getXMLInventoryTradeMessageSCN02()
    {
        XMLInventoryTradeMessage tradeEventMessage = new XMLInventoryTradeMessage();
        tradeEventMessage.setTrade(XMLTradeSetTest.getXMLTradeSCN02());

        // Portfolio
        tradeEventMessage.getParty().add(XMLPartySetTest.getXMLParty3());

        // Counter Party
        tradeEventMessage.getParty().add(XMLPartySetTest.getXMLParty2());

        return tradeEventMessage;
    } // end getXMLInventoryTradeMessageSCN02()

    public static void testXMLInventoryTradeMessageSCN02(final XMLInventoryTradeMessage tradeEventMessage)
    {
        assertNotNull(tradeEventMessage);
        XMLTradeSetTest.testXMLTradeSCN02(tradeEventMessage.getTrade());

        // Party
        assertEquals(2, tradeEventMessage.getParty().size());

        // Portfolio
        XMLPartySetTest.testXMLParty3(tradeEventMessage.getParty().get(0));

        // Counter Party
        XMLPartySetTest.testXMLParty2(tradeEventMessage.getParty().get(1));
    } // end testXMLInventoryTradeMessageSCN02()

    public void testXMLInventoryTradeMessageSCN02()
    {
        testXMLInventoryTradeMessageSCN02(getXMLInventoryTradeMessageSCN02());
    } // end testXMLInventoryTradeMessageSCN02()

    public static JAXBElement<XMLInventoryTradeMessage> getJAXBXMLInventoryTradeMessageSCN02()
    {
        JAXBElement<XMLInventoryTradeMessage> jaxbXMLInventoryTradeMessage = (JAXBElement<XMLInventoryTradeMessage>) transformer.transform(TradeTest.getTrade(TradeTest.idSCN02));

        return jaxbXMLInventoryTradeMessage;
    } // end getJAXBXMLInventoryTradeMessageSCN02()

    public static void testJAXBXMLInventoryTradeMessageSCN02(final JAXBElement<XMLInventoryTradeMessage> jaxbXMLInventoryTradeMessage)
    {
        assertNotNull(jaxbXMLInventoryTradeMessage);
        testXMLInventoryTradeMessageSCN02(jaxbXMLInventoryTradeMessage.getValue());
    } // end testJAXBXMLInventoryTradeMessageSCN02()

    public void testJAXBXMLInventoryTradeMessageSCN02()
    {
        testJAXBXMLInventoryTradeMessageSCN02(getJAXBXMLInventoryTradeMessageSCN02());
    } // end testJAXBXMLInventoryTradeMessageSCN02()
} // end XMLTradeEventMessageTest

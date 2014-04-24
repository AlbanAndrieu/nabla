package com.nabla.project.application.model.message.domain;

import javax.xml.bind.JAXBElement;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.model.xml.XMLInventoryTradeMessage;
import com.nabla.project.application.model.xml.XMLProduct;

/**
 * Author : $author$ Date : $Date: 2010-06-20 17:01:12 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$
 */
public class ContainerTradeTest extends TestCase
{
    protected static Logger logger = Logger.getLogger(ContainerTradeTest.class);

    public void setUp()
    {
        Log.init();
    } // end setUp()

    public static ObjectContainer getContainerTradeSCN01()
    {
        ObjectContainer containerTrade = new ObjectContainer();
        containerTrade.setTrade(XMLInventoryTradeMessageSetTest.getJAXBXMLInventoryTradeMessageSCN01());
        containerTrade.setProduct(XMLProductSetTest.getJAXBXMLProduct1());

        return containerTrade;
    } // end getContainerTradeSCN01()

    public static void testContainerTradeSCN01(final ObjectContainer containerTrade)
    {
        assertNotNull(containerTrade);
        assertNotNull(containerTrade.getTrade());
        assertTrue(containerTrade.getTrade() instanceof JAXBElement);
        XMLInventoryTradeMessageSetTest.testJAXBXMLInventoryTradeMessageSCN01((JAXBElement<XMLInventoryTradeMessage>) containerTrade.getTrade());
        XMLProductSetTest.testJAXBXMLProduct2((JAXBElement<XMLProduct>) containerTrade.getProduct());
    } // end testContainerTradeSCN01()

    public void testContainerTradeSCN01()
    {
        testContainerTradeSCN01(getContainerTradeSCN01());
    } // end testContainerTradeSCN01()

    public static ObjectContainer getContainerTradeSCN02()
    {
        ObjectContainer containerTrade = new ObjectContainer();
        containerTrade.setTrade(XMLInventoryTradeMessageSetTest.getJAXBXMLInventoryTradeMessageSCN02());
        containerTrade.setProduct(XMLProductSetTest.getJAXBXMLProduct2());

        return containerTrade;
    } // end getContainerTradeSCN02()

    public static void testContainerTradeSCN02(final ObjectContainer containerTrade)
    {
        assertNotNull(containerTrade);
        assertNotNull(containerTrade.getTrade());
        assertTrue(containerTrade.getTrade() instanceof JAXBElement);
        XMLInventoryTradeMessageSetTest.testJAXBXMLInventoryTradeMessageSCN02((JAXBElement<XMLInventoryTradeMessage>) containerTrade.getTrade());
        XMLProductSetTest.testJAXBXMLProduct2((JAXBElement<XMLProduct>) containerTrade.getProduct());
    } // end testContainerTradeSCN02()

    public void testContainerTradeSCN02()
    {
        testContainerTradeSCN02(getContainerTradeSCN02());
    } // end testContainerTradeSCN02()
} // end ContainerTradeTest

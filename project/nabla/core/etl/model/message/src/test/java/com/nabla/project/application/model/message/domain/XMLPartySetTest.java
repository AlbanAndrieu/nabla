package com.nabla.project.application.model.message.domain;

import com.nabla.project.application.model.message.domain.Party.PartyType;
import com.nabla.project.application.model.message.transformer.common.XMLPartyModelTransformer;
import com.nabla.project.application.model.xml.XMLParty;

import junit.framework.TestCase;

import javax.xml.bind.JAXBElement;

/**
 * Author : $author$
 * Date : $Date: 2010-06-14 11:52:07 +0200 (Thu, 14 Jun 2010) $
 * Revision : $revision$
 * Test below are launched via class TestsUnitairesMapping
 */
public class XMLPartySetTest extends TestCase
{
    /**
     * Common tests on XMLParty objects
     * 
     * @param XMLParty
     */
    public static void testXMLParty(XMLParty XMLParty)
    {
        assertNotNull(XMLParty);
    }

    public static String    id1        = PartyTest.id1;
    public static String    idVersion1 = PartyTest.idVersion1;
    public static String    name1      = PartyTest.name1;
    public static String    shortName1 = PartyTest.shortName1;
    public static PartyType type1      = PartyTest.type1;

    public static XMLParty getXMLParty1()
    {
        XMLPartyModelTransformer modelTransformer = new XMLPartyModelTransformer();
        XMLParty XMLParty = (XMLParty) modelTransformer.buildParty(PartyTest.getParty1());

        return XMLParty;
    }

    /**
     * @TODO
     * @return
     */
    public static JAXBElement<XMLParty> getJAXBXMLParty1()
    {
        XMLPartyModelTransformer modelTransformer = new XMLPartyModelTransformer();
        JAXBElement<XMLParty> jaxbXMLParty = (JAXBElement<XMLParty>) modelTransformer.transform(PartyTest.getParty1());

        return jaxbXMLParty;
    }

    /**
     * Specifics tests on Product 1925165
     * 
     * @param deqtProduct
     */
    public static void testXMLParty1(XMLParty XMLParty)
    {
        testXMLParty(XMLParty);
    }

    public void testXMLParty1()
    {
        testXMLParty1(getXMLParty1());
    }

    public static String    id2        = PartyTest.id2;
    public static String    idVersion2 = PartyTest.idVersion2;
    public static String    name2      = PartyTest.name2;
    public static String    shortName2 = PartyTest.shortName2;
    public static PartyType type2      = PartyTest.type2;

    public static XMLParty getXMLParty2()
    {
        XMLPartyModelTransformer modelTransformer = new XMLPartyModelTransformer();
        XMLParty XMLParty = (XMLParty) modelTransformer.buildParty(PartyTest.getParty2());

        return XMLParty;
    }

    /**
     * @TODO
     * @return
     */
    public static JAXBElement<XMLParty> getJAXBXMLParty2()
    {
        XMLPartyModelTransformer modelTransformer = new XMLPartyModelTransformer();
        JAXBElement<XMLParty> jaxbXMLParty = (JAXBElement<XMLParty>) modelTransformer.transform(PartyTest.getParty2());

        return jaxbXMLParty;
    }

    /**
     * Specifics tests on Product 1925165
     * 
     * @param deqtProduct
     */
    public static void testXMLParty2(XMLParty XMLParty)
    {
        testXMLParty(XMLParty);
    }

    public void testXMLParty2()
    {
        testXMLParty2(getXMLParty2());
    }

    public static String    id3        = PartyTest.id3;
    public static String    idVersion3 = PartyTest.idVersion3;
    public static String    name3      = PartyTest.name3;
    public static String    shortName3 = PartyTest.shortName3;
    public static PartyType type3      = PartyTest.type3;

    public static XMLParty getXMLParty3()
    {
        XMLPartyModelTransformer modelTransformer = new XMLPartyModelTransformer();
        XMLParty XMLParty = (XMLParty) modelTransformer.buildParty(PartyTest.getParty3());

        return XMLParty;
    }

    /**
     * @TODO
     * @return
     */
    public static JAXBElement<XMLParty> getJAXBXMLParty3()
    {
        XMLPartyModelTransformer modelTransformer = new XMLPartyModelTransformer();
        JAXBElement<XMLParty> jaxbXMLParty = (JAXBElement<XMLParty>) modelTransformer.transform(PartyTest.getParty3());

        return jaxbXMLParty;
    }

    /**
     * Specifics tests on Product 1925165
     * 
     * @param deqtProduct
     */
    public static void testXMLParty3(XMLParty XMLParty)
    {
        testXMLParty(XMLParty);
    }

    public void testXMLParty3()
    {
        testXMLParty3(getXMLParty3());
    }
}

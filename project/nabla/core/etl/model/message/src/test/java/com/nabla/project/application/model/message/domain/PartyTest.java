package com.nabla.project.application.model.message.domain;

import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.model.message.domain.Party.PartyType;

import junit.framework.TestCase;

/**
 * Author : $author$ Date : $Date: 2010-06-20 17:01:12 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$ Test below are launched via class
 * TestsUnitairesMapping
 */
public class PartyTest extends TestCase
{
    public void setUp()
    {
        Log.init();
    } // end setUp()

    public static String idPortfolio0    = "idPortfolio";
    public static String idCounterParty0 = "idCounterParty";
    public static String idIssuerParty0  = "idIssuerParty";

    public static Party getPortfolioParty0()
    {
        Party portfolioParty = new Party();
        portfolioParty.setId(idPortfolio0);
        portfolioParty.setType(PartyType.PORTFOLIO);

        return portfolioParty;
    } // end getPortfolioParty0()

    public static Party getCounterParty0()
    {
        Party counterParty = new Party();
        counterParty.setId(idCounterParty0);
        counterParty.setType(PartyType.EXTERNAL);

        return counterParty;
    } // end getCounterParty0()

    public static Party getIssuerParty0()
    {
        Party issuerParty = new Party();
        issuerParty.setId(idIssuerParty0);
        issuerParty.setType(PartyType.EXTERNAL);

        return issuerParty;
    } // end getIssuerParty0()

    public static void testPortfolioParty1(final Party portfolioParty)
    {
        assertNotNull(portfolioParty);
        assertEquals(idPortfolio0, portfolioParty.getId());
    } // end testPortfolioParty1()

    public void testPortfolioParty0()
    {
        testPortfolioParty1(getPortfolioParty0());
    } // end testPortfolioParty0()

    public static void testCounterParty0(final Party counterParty)
    {
        assertNotNull(counterParty);
        assertEquals(idCounterParty0, counterParty.getId());
    } // end testCounterParty0()

    public void testCounterParty1()
    {
        testCounterParty0(getCounterParty0());
    } // end testCounterParty1()

    public static void testIssuerParty0(final Party issuerParty)
    {
        assertNotNull(issuerParty);
        assertEquals(idIssuerParty0, issuerParty.getId());
    } // end testIssuerParty0()

    public void testPIssuerParty0()
    {
        testIssuerParty0(getIssuerParty0());
    } // end testPIssuerParty0()

    public static String idParty0 = "idParty";

    public static Party getParty0()
    {
        Party party = new Party();
        party.setId(idParty0);
        party.setType(PartyType.EXTERNAL);

        return party;
    } // end getParty0()

    public static void testParty0(final Party party)
    {
        assertNotNull(party);
        assertEquals(idParty0, party.getId());
    } // end testParty0()

    public void testParty0()
    {
        testParty0(getParty0());
    } // end testParty0()

    public static String    id1        = "1";
    public static String    idVersion1 = "3";
    public static String    name1      = "REUTERS FINANCIAL SOFTWARE";
    public static String    shortName1 = "RFS";
    public static PartyType type1      = PartyType.EXTERNAL;

    public static Party getParty1()
    {
        Party party = new Party();
        party.setId(id1);
        party.setIdVersion(idVersion1);
        party.setName(name1);
        party.setShortName(shortName1);
        party.setType(type1);

        return party;
    } // end getParty1()

    public static void testParty1(final Party party)
    {
        assertNotNull(party);
        assertEquals(id1, party.getId());
        assertEquals(idVersion1, party.getIdVersion());
        assertEquals(name1, party.getName());
        assertEquals(shortName1, party.getShortName());
        assertEquals(type1, party.getType());
    } // end testParty1()

    public void testParty1()
    {
        testParty1(getParty1());
    } // end testParty1()

    public static String    id2        = "2";
    public static String    idVersion2 = "2";
    public static String    name2      = "SGOCIETE GENERALE";
    public static String    shortName2 = "SG";
    public static PartyType type2      = PartyType.EXTERNAL;

    public static Party getParty2()
    {
        Party party = new Party();
        party.setId(id2);
        party.setIdVersion(idVersion2);
        party.setName(name2);
        party.setShortName(shortName2);
        party.setType(type2);

        return party;
    } // end getParty2()

    public static void testParty2(final Party party)
    {
        assertNotNull(party);
        assertEquals(id2, party.getId());
        assertEquals(idVersion2, party.getIdVersion());
        assertEquals(name2, party.getName());
        assertEquals(shortName2, party.getShortName());
        assertEquals(type2, party.getType());
    } // end testParty2()

    public void testParty2()
    {
        testParty2(getParty2());
    } // end testParty2()

    public static String    id3        = "3";
    public static String    idVersion3 = "0";
    public static String    name3      = "Trading";
    public static String    shortName3 = "T";
    public static PartyType type3      = PartyType.PORTFOLIO;

    public static Party getParty3()
    {
        Party party = new Party();
        party.setId(id3);
        party.setIdVersion(idVersion3);
        party.setName(name3);
        party.setShortName(shortName3);
        party.setType(type3);

        return party;
    } // end getParty3()

    public static void testParty3(final Party party)
    {
        assertNotNull(party);
        assertEquals(id3, party.getId());
        assertEquals(idVersion3, party.getIdVersion());
        assertEquals(name3, party.getName());
        assertEquals(shortName3, party.getShortName());
        assertEquals(type3, party.getType());
    } // end testParty3()

    public void testParty3()
    {
        testParty3(getParty3());
    } // end testParty3()

    public static String    id4        = "4";
    public static String    idVersion4 = "1";
    public static String    name4      = "THOMSON REUTERS";
    public static String    shortName4 = "TR";
    public static PartyType type4      = PartyType.EXTERNAL;

    public static Party getParty4()
    {
        Party party = new Party();
        party.setId(id4);
        party.setIdVersion(idVersion4);
        party.setName(name4);
        party.setShortName(shortName4);
        party.setType(type4);

        return party;
    } // end getParty4()

    public static void testParty4(final Party party)
    {
        assertNotNull(party);
        assertEquals(id4, party.getId());
        assertEquals(idVersion4, party.getIdVersion());
        assertEquals(name4, party.getName());
        assertEquals(shortName4, party.getShortName());
        assertEquals(type4, party.getType());
    } // end testParty4()

    public void testParty4()
    {
        testParty4(getParty4());
    } // end testParty4()

    public static String    id5        = "5";
    public static String    idVersion5 = "5";
    public static String    name5      = "BNP PARIBAS";
    public static String    shortName5 = "BNP";
    public static PartyType type5      = PartyType.EXTERNAL;

    public static Party getParty5()
    {
        Party party = new Party();
        party.setId(id5);
        party.setIdVersion(idVersion5);
        party.setName(name5);
        party.setShortName(shortName5);
        party.setType(type5);

        return party;
    } // end getParty5()

    public static void testParty5(final Party party)
    {
        assertNotNull(party);
        assertEquals(id5, party.getId());
        assertEquals(idVersion5, party.getIdVersion());
        assertEquals(name5, party.getName());
        assertEquals(shortName5, party.getShortName());
        assertEquals(type5, party.getType());
    } // end testParty5()

    public void testParty5()
    {
        testParty5(getParty5());
    } // end testParty5()

    public static String    id6        = "6";
    public static String    idVersion6 = "0";
    public static String    name6      = "Invest";
    public static String    shortName6 = "I";
    public static PartyType type6      = PartyType.PORTFOLIO;

    public static Party getParty6()
    {
        Party party = new Party();
        party.setId(id6);
        party.setIdVersion(idVersion6);
        party.setName(name6);
        party.setShortName(shortName6);
        party.setType(type6);

        return party;
    } // end getParty6()

    public static void testParty6(final Party party)
    {
        assertNotNull(party);
        assertEquals(id6, party.getId());
        assertEquals(idVersion6, party.getIdVersion());
        assertEquals(name6, party.getName());
        assertEquals(shortName6, party.getShortName());
        assertEquals(type6, party.getType());
    } // end testParty6()

    public void testParty6()
    {
        testParty6(getParty6());
    } // end testParty6()
} // end PartyTest

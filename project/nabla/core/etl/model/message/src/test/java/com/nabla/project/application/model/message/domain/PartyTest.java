package com.nabla.project.application.model.message.domain;

import junit.framework.TestCase;

import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.model.message.domain.Party.PartyType;

/**
 * Author : $author$ Date : $Date: 2010-06-20 17:01:12 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$ Test below are launched via class
 * TestsUnitairesMapping
 */
public class PartyTest extends TestCase
{
    @Override
    public void setUp()
    {
        Log.init();
    } // end setUp()

    public static String idPortfolio0    = "idPortfolio";
    public static String idCounterParty0 = "idCounterParty";
    public static String idIssuerParty0  = "idIssuerParty";

    public static Party getPortfolioParty0()
    {
        final Party portfolioParty = new Party();
        portfolioParty.setId(PartyTest.idPortfolio0);
        portfolioParty.setType(PartyType.PORTFOLIO);

        return portfolioParty;
    } // end getPortfolioParty0()

    public static Party getCounterParty0()
    {
        final Party counterParty = new Party();
        counterParty.setId(PartyTest.idCounterParty0);
        counterParty.setType(PartyType.EXTERNAL);

        return counterParty;
    } // end getCounterParty0()

    public static Party getIssuerParty0()
    {
        final Party issuerParty = new Party();
        issuerParty.setId(PartyTest.idIssuerParty0);
        issuerParty.setType(PartyType.EXTERNAL);

        return issuerParty;
    } // end getIssuerParty0()

    public static void testPortfolioParty1(final Party portfolioParty)
    {
        TestCase.assertNotNull(portfolioParty);
        TestCase.assertEquals(PartyTest.idPortfolio0, portfolioParty.getId());
    } // end testPortfolioParty1()

    public void testPortfolioParty0()
    {
        PartyTest.testPortfolioParty1(PartyTest.getPortfolioParty0());
    } // end testPortfolioParty0()

    public static void testCounterParty0(final Party counterParty)
    {
        TestCase.assertNotNull(counterParty);
        TestCase.assertEquals(PartyTest.idCounterParty0, counterParty.getId());
    } // end testCounterParty0()

    public void testCounterParty1()
    {
        PartyTest.testCounterParty0(PartyTest.getCounterParty0());
    } // end testCounterParty1()

    public static void testIssuerParty0(final Party issuerParty)
    {
        TestCase.assertNotNull(issuerParty);
        TestCase.assertEquals(PartyTest.idIssuerParty0, issuerParty.getId());
    } // end testIssuerParty0()

    public void testPIssuerParty0()
    {
        PartyTest.testIssuerParty0(PartyTest.getIssuerParty0());
    } // end testPIssuerParty0()

    public static String idParty0 = "idParty";

    public static Party getParty0()
    {
        final Party party = new Party();
        party.setId(PartyTest.idParty0);
        party.setType(PartyType.EXTERNAL);

        return party;
    } // end getParty0()

    public static void testParty0(final Party party)
    {
        TestCase.assertNotNull(party);
        TestCase.assertEquals(PartyTest.idParty0, party.getId());
    } // end testParty0()

    public void testParty0()
    {
        PartyTest.testParty0(PartyTest.getParty0());
    } // end testParty0()

    public static String    id1        = "1";
    public static String    idVersion1 = "3";
    public static String    name1      = "REUTERS FINANCIAL SOFTWARE";
    public static String    shortName1 = "RFS";
    public static PartyType type1      = PartyType.EXTERNAL;

    public static Party getParty1()
    {
        final Party party = new Party();
        party.setId(PartyTest.id1);
        party.setIdVersion(PartyTest.idVersion1);
        party.setName(PartyTest.name1);
        party.setShortName(PartyTest.shortName1);
        party.setType(PartyTest.type1);

        return party;
    } // end getParty1()

    public static void testParty1(final Party party)
    {
        TestCase.assertNotNull(party);
        TestCase.assertEquals(PartyTest.id1, party.getId());
        TestCase.assertEquals(PartyTest.idVersion1, party.getIdVersion());
        TestCase.assertEquals(PartyTest.name1, party.getName());
        TestCase.assertEquals(PartyTest.shortName1, party.getShortName());
        TestCase.assertEquals(PartyTest.type1, party.getType());
    } // end testParty1()

    public void testParty1()
    {
        PartyTest.testParty1(PartyTest.getParty1());
    } // end testParty1()

    public static String    id2        = "2";
    public static String    idVersion2 = "2";
    public static String    name2      = "SGOCIETE GENERALE";
    public static String    shortName2 = "SG";
    public static PartyType type2      = PartyType.EXTERNAL;

    public static Party getParty2()
    {
        final Party party = new Party();
        party.setId(PartyTest.id2);
        party.setIdVersion(PartyTest.idVersion2);
        party.setName(PartyTest.name2);
        party.setShortName(PartyTest.shortName2);
        party.setType(PartyTest.type2);

        return party;
    } // end getParty2()

    public static void testParty2(final Party party)
    {
        TestCase.assertNotNull(party);
        TestCase.assertEquals(PartyTest.id2, party.getId());
        TestCase.assertEquals(PartyTest.idVersion2, party.getIdVersion());
        TestCase.assertEquals(PartyTest.name2, party.getName());
        TestCase.assertEquals(PartyTest.shortName2, party.getShortName());
        TestCase.assertEquals(PartyTest.type2, party.getType());
    } // end testParty2()

    public void testParty2()
    {
        PartyTest.testParty2(PartyTest.getParty2());
    } // end testParty2()

    public static String    id3        = "3";
    public static String    idVersion3 = "0";
    public static String    name3      = "Trading";
    public static String    shortName3 = "T";
    public static PartyType type3      = PartyType.PORTFOLIO;

    public static Party getParty3()
    {
        final Party party = new Party();
        party.setId(PartyTest.id3);
        party.setIdVersion(PartyTest.idVersion3);
        party.setName(PartyTest.name3);
        party.setShortName(PartyTest.shortName3);
        party.setType(PartyTest.type3);

        return party;
    } // end getParty3()

    public static void testParty3(final Party party)
    {
        TestCase.assertNotNull(party);
        TestCase.assertEquals(PartyTest.id3, party.getId());
        TestCase.assertEquals(PartyTest.idVersion3, party.getIdVersion());
        TestCase.assertEquals(PartyTest.name3, party.getName());
        TestCase.assertEquals(PartyTest.shortName3, party.getShortName());
        TestCase.assertEquals(PartyTest.type3, party.getType());
    } // end testParty3()

    public void testParty3()
    {
        PartyTest.testParty3(PartyTest.getParty3());
    } // end testParty3()

    public static String    id4        = "4";
    public static String    idVersion4 = "1";
    public static String    name4      = "THOMSON REUTERS";
    public static String    shortName4 = "TR";
    public static PartyType type4      = PartyType.EXTERNAL;

    public static Party getParty4()
    {
        final Party party = new Party();
        party.setId(PartyTest.id4);
        party.setIdVersion(PartyTest.idVersion4);
        party.setName(PartyTest.name4);
        party.setShortName(PartyTest.shortName4);
        party.setType(PartyTest.type4);

        return party;
    } // end getParty4()

    public static void testParty4(final Party party)
    {
        TestCase.assertNotNull(party);
        TestCase.assertEquals(PartyTest.id4, party.getId());
        TestCase.assertEquals(PartyTest.idVersion4, party.getIdVersion());
        TestCase.assertEquals(PartyTest.name4, party.getName());
        TestCase.assertEquals(PartyTest.shortName4, party.getShortName());
        TestCase.assertEquals(PartyTest.type4, party.getType());
    } // end testParty4()

    public void testParty4()
    {
        PartyTest.testParty4(PartyTest.getParty4());
    } // end testParty4()

    public static String    id5        = "5";
    public static String    idVersion5 = "5";
    public static String    name5      = "BNP PARIBAS";
    public static String    shortName5 = "BNP";
    public static PartyType type5      = PartyType.EXTERNAL;

    public static Party getParty5()
    {
        final Party party = new Party();
        party.setId(PartyTest.id5);
        party.setIdVersion(PartyTest.idVersion5);
        party.setName(PartyTest.name5);
        party.setShortName(PartyTest.shortName5);
        party.setType(PartyTest.type5);

        return party;
    } // end getParty5()

    public static void testParty5(final Party party)
    {
        TestCase.assertNotNull(party);
        TestCase.assertEquals(PartyTest.id5, party.getId());
        TestCase.assertEquals(PartyTest.idVersion5, party.getIdVersion());
        TestCase.assertEquals(PartyTest.name5, party.getName());
        TestCase.assertEquals(PartyTest.shortName5, party.getShortName());
        TestCase.assertEquals(PartyTest.type5, party.getType());
    } // end testParty5()

    public void testParty5()
    {
        PartyTest.testParty5(PartyTest.getParty5());
    } // end testParty5()

    public static String    id6        = "6";
    public static String    idVersion6 = "0";
    public static String    name6      = "Invest";
    public static String    shortName6 = "I";
    public static PartyType type6      = PartyType.PORTFOLIO;

    public static Party getParty6()
    {
        final Party party = new Party();
        party.setId(PartyTest.id6);
        party.setIdVersion(PartyTest.idVersion6);
        party.setName(PartyTest.name6);
        party.setShortName(PartyTest.shortName6);
        party.setType(PartyTest.type6);

        return party;
    } // end getParty6()

    public static void testParty6(final Party party)
    {
        TestCase.assertNotNull(party);
        TestCase.assertEquals(PartyTest.id6, party.getId());
        TestCase.assertEquals(PartyTest.idVersion6, party.getIdVersion());
        TestCase.assertEquals(PartyTest.name6, party.getName());
        TestCase.assertEquals(PartyTest.shortName6, party.getShortName());
        TestCase.assertEquals(PartyTest.type6, party.getType());
    } // end testParty6()

    public void testParty6()
    {
        PartyTest.testParty6(PartyTest.getParty6());
    } // end testParty6()
} // end PartyTest

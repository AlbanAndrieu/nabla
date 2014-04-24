package com.nabla.project.application.model.message.domain;

import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.model.message.domain.Trade.TradeDirection;
import com.nabla.project.application.model.message.extractor.common.ReferencesGenerator;

import junit.framework.TestCase;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * Author : $author$ Date : $Date: 2010-06-20 17:01:12 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$ Test below are launched via class
 * TestsUnitairesMapping
 */
public class TradeTest extends TestCase
{
    public void setUp()
    {
        Log.init();
    } // end setUp()

    public static void setReferences(final Trade trade)
    {
        String tradeReference = ReferencesGenerator.getTradeRefId(trade.getId());
        String productReference = ReferencesGenerator.getProductRefId(trade.getId(), trade.getProduct().getId());
        String portfolioPartyReference = ReferencesGenerator.getPartyRefForTrade(trade.getId(), trade.getPortfolioParty().getId());
        String counterPartyReference = ReferencesGenerator.getPartyRefForTrade(trade.getId(), trade.getCounterParty().getId());
        String issuerPartyReference = ReferencesGenerator.getPartyRefForProduct(trade.getProduct().getId(), trade.getProduct().getIssuerParty().getId());

        trade.setReference(tradeReference);
        trade.setProductReference(productReference);
        trade.setPortfolioReference(portfolioPartyReference);
        trade.setCounterPartyReference(counterPartyReference);
        trade.getProduct().setReference(productReference);
        trade.getProduct().setPartyReference(issuerPartyReference);
        trade.getPortfolioParty().setReference(portfolioPartyReference);
        trade.getCounterParty().setReference(counterPartyReference);
        trade.getProduct().getIssuerParty().setReference(issuerPartyReference);
    } // end setReferences()

    public static String         idSCN01                      = "SCN01";
    public static String         idVersionSCN01               = "0";
    public static Date           tradeDateSCN01;                                         // new SimpleDateFormat("yyyyMMdd").parse("20100305"); "2010-03-05";
    public static Date           valueDateSCN01;                                         // "2010-03-19"
    public static Date           systemDateSCN01              = new Date(1173119267000L); // 1173119267000
    public static Date           saisieFrontDateSCN01         = new Date(1173117518000L); // 1173119267000
    public static BigDecimal     quantitySCN01                = new BigDecimal(2948);
    public static BigDecimal     priceSCN01                   = new BigDecimal(5000);
    public static String         underlyingQuotationTypeSCN01 = "P";
    public static BigDecimal     nominalAmountSCN01           = new BigDecimal(14740000);
    public static BigDecimal     dirtyAmountSCN01             = new BigDecimal(14740000);
    public static BigDecimal     cleanAmountSCN01             = new BigDecimal(14740000);
    public static BigDecimal     accruedAmountSCN01           = new BigDecimal(0);
    public static TradeDirection directionSCN01               = TradeDirection.SELL;
    public static String         idFrontSCN01                 = idSCN01;
    public static String         applicationFrontSCN01        = "FO";

    static
    {
        try
        {
            tradeDateSCN01 = new SimpleDateFormat("yyyyMMdd").parse("20100305"); // "2010-03-05";
            valueDateSCN01 = new SimpleDateFormat("yyyyMMdd").parse("20100319"); // "2010-03-19";
        } // end try
        catch (Exception ex)
        {
            ex.printStackTrace();
        } // end catch
    }

    private static Trade getTradeSCN01()
    {
        Trade trade = new Trade();

        trade.setId(idSCN01);
        trade.setIdVersion(idVersionSCN01);
        trade.setTradeDate(tradeDateSCN01);
        trade.setSystemDate(systemDateSCN01);
        trade.setSaisieFrontDate(saisieFrontDateSCN01);
        trade.setValueDate(valueDateSCN01);
        trade.setQuantity(quantitySCN01);
        trade.setPrice(priceSCN01);
        trade.setUnderlyingQuotationType(underlyingQuotationTypeSCN01);
        trade.setNominalAmount(nominalAmountSCN01);
        trade.setDirtyAmount(dirtyAmountSCN01);
        trade.setCleanAmount(cleanAmountSCN01);
        trade.setAccruedAmount(accruedAmountSCN01);
        trade.setTradeDirection(directionSCN01);
        trade.setIdFront(idFrontSCN01);
        trade.setApplicationFront(applicationFrontSCN01);

        // Set Product
        trade.setProduct(ProductTest.getProduct1());

        // Set Parties
        trade.setPortfolioParty(PartyTest.getParty3());

        trade.setCounterParty(PartyTest.getParty2());

        setReferences(trade);

        return trade;
    } // end getTradeSCN01()

    public static void testTradeSCN01(final Trade trade)
    {
        assertNotNull(trade);
        assertEquals(idSCN01, trade.getId());
        assertEquals(idVersionSCN01, trade.getIdVersion());
        assertEquals(tradeDateSCN01, trade.getTradeDate());
        assertEquals(systemDateSCN01, trade.getSystemDate());
        assertEquals(saisieFrontDateSCN01, trade.getSaisieFrontDate());
        assertEquals(valueDateSCN01, trade.getValueDate());
        assertEquals(quantitySCN01, trade.getQuantity());
        assertEquals(priceSCN01, trade.getPrice());
        assertEquals(underlyingQuotationTypeSCN01, trade.getUnderlyingQuotationType());
        assertEquals(nominalAmountSCN01, trade.getNominalAmount());
        assertEquals(dirtyAmountSCN01, trade.getDirtyAmount());
        assertEquals(cleanAmountSCN01, trade.getCleanAmount());
        assertEquals(accruedAmountSCN01, trade.getAccruedAmount());
        assertEquals(directionSCN01, trade.getTradeDirection());
        assertEquals(idFrontSCN01, trade.getIdFront());
        assertEquals(applicationFrontSCN01, trade.getApplicationFront());

        // Verification Product
        ProductTest.testProduct1(trade.getProduct());
        assertEquals(trade.getProductReference(), trade.getProduct().getReference());

        // Verification Parties
        PartyTest.testParty3(trade.getPortfolioParty());
        assertEquals(trade.getPortfolioReference(), trade.getPortfolioParty().getReference());

        PartyTest.testParty2(trade.getCounterParty());
        assertEquals(trade.getCounterPartyReference(), trade.getCounterParty().getReference());
    } // end testTradeSCN01()

    public void testTradeSCN01()
    {
        testTradeSCN01(getTrade(idSCN01));
    } // end testTradeSCN01()

    public static String         idSCN02                      = "SCN02";
    public static String         idVersionSCN02               = "0";
    public static Date           tradeDateSCN02;                                         // new
    // SimpleDateFormat("yyyyMMdd").parse("20100305");
    // //"2010-03-05";
    public static Date           valueDateSCN02;                                         // "2010-03-19"
    public static Date           systemDateSCN02              = new Date(1173835980000L);
    public static Date           saisieFrontDateSCN02         = new Date(1173834076000L);
    public static BigDecimal     quantitySCN02                = new BigDecimal(100);
    public static BigDecimal     priceSCN02                   = new BigDecimal(1513);
    public static String         underlyingQuotationTypeSCN02 = "P";
    public static BigDecimal     nominalAmountSCN02           = new BigDecimal(100);
    public static BigDecimal     dirtyAmountSCN02             = new BigDecimal(151300);

    // public static BigDecimal cleanAmountSCN02=null;
    public static BigDecimal     cleanAmountSCN02             = new BigDecimal(0);
    public static BigDecimal     accruedAmountSCN02           = null;

    // public static BigDecimal accruedAmountSCN02=new BigDecimal(0);
    public static TradeDirection directionSCN02               = TradeDirection.BUY;
    public static String         idFrontSCN02                 = idSCN02;
    public static String         applicationFrontSCN02        = "FO";

    static
    {
        try
        {
            tradeDateSCN02 = new SimpleDateFormat("yyyyMMdd").parse("20100314");
            valueDateSCN02 = new SimpleDateFormat("yyyyMMdd").parse("20100319");
        } // end try
        catch (Exception ex)
        {
            ex.printStackTrace();
        } // end catch
    }

    private static Trade getTradeSCN02()
    {
        Trade trade = new Trade();

        trade.setId(idSCN02);
        trade.setIdVersion(idVersionSCN02);
        trade.setTradeDate(tradeDateSCN02);
        trade.setSystemDate(systemDateSCN02);
        trade.setSaisieFrontDate(saisieFrontDateSCN02);
        trade.setValueDate(valueDateSCN02);
        trade.setQuantity(quantitySCN02);
        trade.setPrice(priceSCN02);
        trade.setUnderlyingQuotationType(underlyingQuotationTypeSCN02);
        trade.setNominalAmount(nominalAmountSCN02);
        trade.setDirtyAmount(dirtyAmountSCN02);
        trade.setCleanAmount(cleanAmountSCN02);
        trade.setAccruedAmount(accruedAmountSCN02);
        trade.setTradeDirection(directionSCN02);
        trade.setIdFront(idFrontSCN02);
        trade.setApplicationFront(applicationFrontSCN02);

        // Set Product
        trade.setProduct(ProductTest.getProduct2());

        // Set Parties
        trade.setPortfolioParty(PartyTest.getParty6());

        trade.setCounterParty(PartyTest.getParty4());

        setReferences(trade);

        return trade;
    } // end getTradeSCN02()

    public static void testTradeSCN02(final Trade trade)
    {
        assertNotNull(trade);
        assertEquals(idSCN02, trade.getId());
        assertEquals(idVersionSCN02, trade.getIdVersion());
        assertEquals(tradeDateSCN02, trade.getTradeDate());
        assertEquals(systemDateSCN02, trade.getSystemDate());
        assertEquals(saisieFrontDateSCN02, trade.getSaisieFrontDate());
        assertEquals(valueDateSCN02, trade.getValueDate());
        assertEquals(quantitySCN02, trade.getQuantity());
        assertEquals(priceSCN02, trade.getPrice());
        assertEquals(underlyingQuotationTypeSCN02, trade.getUnderlyingQuotationType());
        assertEquals(nominalAmountSCN02, trade.getNominalAmount());
        assertEquals(dirtyAmountSCN02, trade.getDirtyAmount());
        // TODO
        /*
         * assertEquals(cleanAmountSCN02,new BigDecimal(0));
         * assertEquals(accruedAmountSCN02,new BigDecimal(0));
         */
        assertEquals(directionSCN02, trade.getTradeDirection());
        assertEquals(idFrontSCN02, trade.getIdFront());
        assertEquals(applicationFrontSCN02, trade.getApplicationFront());

        // Verification Product
        ProductTest.testProduct2(trade.getProduct());
        assertEquals(trade.getProductReference(), trade.getProduct().getReference());

        // Verification Parties
        PartyTest.testParty6(trade.getPortfolioParty());
        assertEquals(trade.getPortfolioReference(), trade.getPortfolioParty().getReference());

        PartyTest.testParty4(trade.getCounterParty());
        assertEquals(trade.getCounterPartyReference(), trade.getCounterParty().getReference());
    } // end testTradeSCN02()

    public void testTradeSCN02()
    {
        testTradeSCN02(getTrade(idSCN02));
    } // end testTradeSCN02()

    public static Trade getTrade(final String id)
    {
        if (id.equals(idSCN01))
        {
            return getTradeSCN01();
        } // end if

        if (id.equals(idSCN02))
        {
            return getTradeSCN02();
        } // end if

        return null;
    } // end getTrade()
} // end TradeTest

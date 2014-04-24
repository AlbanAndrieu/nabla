package com.nabla.project.application.model.message.domain;

import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.model.message.helpers.XmlTest;
import com.nabla.project.application.model.message.transformer.ModelTransformer;
import com.nabla.project.application.model.message.xml.JaxbDateHelper;
import com.nabla.project.application.model.xml.TradeDirectionScheme;

import org.apache.log4j.Logger;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLTestCase;

import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * Author : $author$ Date : $Date: 2010-06-20 17:01:12 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$ Test below are launched via class
 * TestsUnitairesMapping
 */
public class XMLTradeTest extends XMLTestCase
{
    protected static Logger logger = Logger.getLogger(XMLTradeTest.class);

    static
    {
        Log.init();
    }

    public static String toXmlDate(final Date date)
    {
        try
        {
            return JaxbDateHelper.getJaxbDate(date).toString();
        } // end try
        catch (Exception ex)
        {
            return "";
        } // end catch
    } // end toXmlDate()

    public void testXmlDate() throws Exception
    {
        assertEquals("2010-03-05+01:00", toXmlDate(new SimpleDateFormat("yyyyMMdd").parse("20100305")));
    } // end testXmlDate()

    protected static SimpleDateFormat xmlTimeStampFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    public static String toXmlTimeStamp(final Date date)
    {
        StringBuffer str = new StringBuffer();
        String result = xmlTimeStampFormat.format(date);
        int length = result.length();
        str.append(result.substring(0, length - 2));
        str.append(':');
        str.append(result.substring(length - 2));

        return str.toString();
    } // end toXmlTimeStamp()

    public void testXmlTimeStamp() throws Exception
    {
        assertEquals("2007-03-05T19:27:47.000+01:00", toXmlTimeStamp(new Date(1173119267000L)));
    } // end testXmlTimeStamp()

    public static final String xmlFragHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + "<MAI:XML_trade_template " + "xmlns:MAI=\"urn:nabla:Nabla_Service:1_0_0\" "
                                                     + "xmlns:TRD=\"urn:nabla:A_XML_Trade:1_0_0\" " + "xmlns:THD=\"urn:nabla:A_XML_TradeHeader:1_0_0\" " + "xmlns:GEN=\"urn:nabla:A_XML_TradingGeneric:1_0_0\" "
                                                     + "xmlns:TCD=\"urn:nabla:A_XML_TradeConditions:1_0_0\" "
                                                     /* + "xmlns:TPY=\"urn:nabla:A_XML_TradePayment:1_0_0\" " */
                                                     + "xmlns:TPI=\"urn:nabla:A_XML_TradePartyInfo:1_0_0\" "
                                                     /* + "xmlns:STL=\"urn:nabla:A_XML_SettlementInfo:1_0_0\" " */
                                                     /* + "xmlns:CAL=\"urn:nabla:A_XML_CommercialMargin:1_0_0\" " */
                                                     /* + "xmlns:PEQTINST=\"urn:nabla:A_XML_instrument:1_0_0\" " */
                                                     /* + "xmlns:PSH=\"urn:nabla:A_XML_OTCproductShared:1_0_0\" " */
                                                     + "xmlns:INS=\"urn:nabla:A_XML_InstrumentService:1_0_0\" " + "xmlns:PHD=\"urn:nabla:A_XML_ProductHeader:1_0_0\" "
                                                     + "xmlns:PTY=\"urn:nabla:A_XML_TradingParty:1_0_0\" "
                                                     /* + "xmlns:FIN=\"urn:nabla:A_XML_FinancialInfo:1_0_0\" " */
                                                     /* + "xmlns:PSHD=\"urn:nabla:A_XML_ProductStructureHeader:1_0_0\" " */
                                                     + "xmlns:REF=\"urn:nabla:DGEN_ReferentialGeneric:1_0_0\" " + "xmlns=\"urn:nabla:Nabla_Service:1_0_0\" " + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " + // "xsi:schemaLocation=\"urn:nabla:Nabla_Service:1_1_7 ..\\xml\\XML_root.xsd\""
                                                     // +
                                                     ">";
    public static final String xmlFragFooter = "</MAI:XML_trade_template>";

    public static void testXMLTrade(final String xmlReference, final String xmlResult) throws Exception
    {
        assertNotNull(xmlReference);
        assertNotNull(xmlResult);

        // Debug
        if (logger.isDebugEnabled())
        {
            logger.debug("XML reference : " + xmlReference);
            logger.debug("XML tested : " + xmlResult);
        } // end if

        XmlTest.xmlValidation(xmlResult);
        XmlTest.xmlSchemaValidation(xmlResult);

        Diff myDiff = new Diff(xmlReference, xmlResult);
        assertTrue("XML similar : " + myDiff.toString(), myDiff.similar());
        assertTrue("XML identical : " + myDiff.toString(), myDiff.identical());
    } // end testXMLTrade()

    public static String getXMLSpecificTradeConditions(final String id, final boolean coupon)
    {
        String xmlFragSpecificTradeConditions = "<INS:specificTradeConditions>" + "<INS:instrumentSpecificTradeConditions>" + "<INS:instrumentPrice>" + "<INS:underlyingQuotationType>Price</INS:underlyingQuotationType>"
                + "<INS:cleanPriceValue>" + TradeTest.getTrade(id).getPrice() + "</INS:cleanPriceValue>" + "<INS:marketPriceValue>" + TradeTest.getTrade(id).getPrice() + "</INS:marketPriceValue>"
                + "</INS:instrumentPrice>";

        if (coupon)
        {
            xmlFragSpecificTradeConditions = xmlFragSpecificTradeConditions + getXMLSpecificTradeConditionsCoupon(id);
        } // end if

        xmlFragSpecificTradeConditions = xmlFragSpecificTradeConditions + "<INS:nominalAmount>" + TradeTest.getTrade(id).getNominalAmount() + "</INS:nominalAmount>" + "<INS:cleanAmount>"
                + TradeTest.getTrade(id).getCleanAmount() + "</INS:cleanAmount>" + "<INS:dirtyAmount>" + TradeTest.getTrade(id).getDirtyAmount() + "</INS:dirtyAmount>" + "</INS:instrumentSpecificTradeConditions>"
                + "</INS:specificTradeConditions>";

        return xmlFragSpecificTradeConditions;
    } // end getXMLSpecificTradeConditions()

    public static String getXMLSpecificTradeConditionsCoupon(final String id)
    {
        String xmlFragSpecificTradeConditionsCoupon = "<INS:couponInfo>" + "<INS:accruedAmount>" + "<INS:realAccruedAmount>" + TradeTest.getTrade(id).getAccruedAmount() + "</INS:realAccruedAmount>"
                + "</INS:accruedAmount>" + "</INS:couponInfo>";

        return xmlFragSpecificTradeConditionsCoupon;
    } // end getXMLSpecificTradeConditionsCoupon()

    public static String getXMLTradeBody(final String id, final boolean specific, final boolean coupon)
    {
        String xmlFragTradeEvent = "<INS:endOfDayTradeEvent>" + "<INS:trade version=\"" + ModelTransformer.BACK_TRADE_VERSION_SCHEME + "\" id=\"" + TradeTest.getTrade(id).getReference() + "\">" + "<TRD:tradeHeader>"
                + "<THD:tradeIdentifier>" + "<THD:tradeId>" + "<REF:id>" + TradeTest.getTrade(id).getId() + "</REF:id>" + "<REF:idScheme>eoleTrade</REF:idScheme>" + "</THD:tradeId>" + "<THD:tradeVersion>"
                + "<REF:versionNumber>" + TradeTest.getTrade(id).getIdVersion() + "</REF:versionNumber>" + "</THD:tradeVersion>" + "<THD:tradeCode>" + "<REF:codingScheme>frontTrade</REF:codingScheme>" + "<REF:code>"
                + TradeTest.getTrade(id).getIdFront() + "</REF:code>" + "</THD:tradeCode>" + "</THD:tradeIdentifier>" + "<THD:tradeTypology>" + "<THD:tradeEventTypology>"
                + "<THD:tradeEventMacroType>Negotiation</THD:tradeEventMacroType>" + "<THD:tradeEventType>CreationNegotiation</THD:tradeEventType>" + "</THD:tradeEventTypology>" + "</THD:tradeTypology>"
                + "<THD:otherTradeInfo>" + "<GEN:inputInfo>" + "<REF:sourceApplicationId>" + "<REF:id>GEN:</REF:id>" + "<REF:idScheme>frontApplication</REF:idScheme>" + "</REF:sourceApplicationId>"
                + "<GEN:inputTimeStamp>" + toXmlTimeStamp(TradeTest.getTrade(id).getSaisieFrontDate()) + "</GEN:inputTimeStamp>" + "</GEN:inputInfo>" + "</THD:otherTradeInfo>" + "</TRD:tradeHeader>"
                + "<TRD:tradeConditions>" + "<TCD:tradeDate>" + toXmlDate(TradeTest.getTrade(id).getTradeDate()) + "</TCD:tradeDate>" + "<TCD:tradeTimeStamp>" + toXmlTimeStamp(TradeTest.getTrade(id).getSystemDate())
                + "</TCD:tradeTimeStamp>" + /*
                                             * "<TCD:APartyId>" +
                                             * "<REF:id>"+TradeTest.getTrade(id).getPortfolioReference
                                             * ()+"</REF:id>" +
                                             * "<REF:idScheme>eolePortfolio</REF:idScheme>" +
                                             * "</TCD:APartyId>" +
                                             */
                "<TCD:APartyReference href=\"" + TradeTest.getTrade(id).getPortfolioReference() + "\"/>" + /*
                                                                                                            * "<TCD:BPartyId>" +
                                                                                                            * "<REF:id>"+TradeTest.getTrade(id).getCounterPartyReference
                                                                                                            * ()+"</REF:id>" +
                                                                                                            * "<REF:idScheme>eoleIssuer</REF:idScheme>" +
                                                                                                            * "</TCD:BPartyId>" +
                                                                                                            */
                "<TCD:BPartyReference href=\"" + TradeTest.getTrade(id).getCounterPartyReference() + "\"/>" + "<TCD:exchangedProduct1>" + "<GEN:productId>" + "<REF:id>" + TradeTest.getTrade(id).getProductReference()
                + "</REF:id>" + "<REF:idScheme>eoleProduct</REF:idScheme>" + "</GEN:productId>" + "<TCD:quantity>" + TradeTest.getTrade(id).getQuantity() + "</TCD:quantity>" + "<TCD:valueDate>"
                + toXmlDate(TradeTest.getTrade(id).getValueDate()) + "</TCD:valueDate>" + "</TCD:exchangedProduct1>" + "<TCD:ATradeDirection>" + TradeDirectionScheme.BUY.value() + "</TCD:ATradeDirection>"
                + "</TRD:tradeConditions>" + "<TPI:tradePartyInfo>" + /*
                                                                       * "<REF:partyId>" +
                                                                       * "<REF:id>"+TradeTest.getTrade(id).getPortfolioReference
                                                                       * ()+"</REF:id>" +
                                                                       * "<REF:idScheme>eolePortfolio</REF:idScheme>" +
                                                                       * "</REF:partyId>" +
                                                                       */
                "<GEN:partyReference href=\"" + TradeTest.getTrade(id).getPortfolioReference() + "\"/>" + "<TPI:tradeManagerIndicator>true</TPI:tradeManagerIndicator>" + "<TPI:partyRole>Principal</TPI:partyRole>"
                + "<TPI:storageApplication>" + "<REF:id>BDR</REF:id>" + "<REF:idScheme>BDRPortfolio</REF:idScheme>" + "</TPI:storageApplication>" + "</TPI:tradePartyInfo>" + "<TPI:tradePartyInfo>" + /*
                                                                                                                                                                                                        * "<REF:partyId>" +
                                                                                                                                                                                                        * "<REF:id>"+TradeTest
                                                                                                                                                                                                        * .getTrade(id).
                                                                                                                                                                                                        * getCounterPartyReference
                                                                                                                                                                                                        * ()+"</REF:id>" +
                                                                                                                                                                                                        * "<REF:idScheme>eoleExternalParty</REF:idScheme>"
                                                                                                                                                                                                        * +
                                                                                                                                                                                                        * "</REF:partyId>" +
                                                                                                                                                                                                        */
                "<GEN:partyReference href=\"" + TradeTest.getTrade(id).getCounterPartyReference() + "\"/>" + "<TPI:tradeManagerIndicator>false</TPI:tradeManagerIndicator>"
                + "<TPI:partyRole>ExternalParty</TPI:partyRole>" + "<TPI:storageApplication>" + "<REF:id>BDR</REF:id>" + "<REF:idScheme>BDRExternalParty</REF:idScheme>" + "</TPI:storageApplication>"
                + "</TPI:tradePartyInfo>";

        if (specific)
        {
            xmlFragTradeEvent = xmlFragTradeEvent + getXMLSpecificTradeConditions(id, coupon);
        } // end if

        xmlFragTradeEvent = xmlFragTradeEvent + "</INS:trade>" + "<INS:party id=\"" + TradeTest.getTrade(id).getCounterPartyReference() + "\">" + "<PTY:partyIdentifier>" + "<PTY:tradePartyId>" + "<REF:id>"
                + TradeTest.getTrade(id).getCounterParty().getId() + "</REF:id>" + "<REF:idScheme>eoleExternalParty</REF:idScheme>" + "</PTY:tradePartyId>" + "<PTY:tradePartyType>Party</PTY:tradePartyType>"
                + "<PTY:tradePartyMnemonic>" + TradeTest.getTrade(id).getCounterParty().getName() + "</PTY:tradePartyMnemonic>" + "<PTY:tradePartyShortName>" + TradeTest.getTrade(id).getCounterParty().getShortName()
                + "</PTY:tradePartyShortName>" + "</PTY:partyIdentifier>" + "</INS:party>" + "<INS:party id=\"" + TradeTest.getTrade(id).getPortfolioReference() + "\">" + "<PTY:partyIdentifier>" + "<PTY:tradePartyId>"
                + "<REF:id>" + TradeTest.getTrade(id).getPortfolioParty().getId() + "</REF:id>" + "<REF:idScheme>eolePortfolio</REF:idScheme>" + "</PTY:tradePartyId>"
                + "<PTY:tradePartyType>Portfolio</PTY:tradePartyType>" + "<PTY:tradePartyMnemonic>" + TradeTest.getTrade(id).getPortfolioParty().getName() + "</PTY:tradePartyMnemonic>" + "<PTY:tradePartyShortName>"
                + TradeTest.getTrade(id).getPortfolioParty().getShortName() + "</PTY:tradePartyShortName>" + "</PTY:partyIdentifier>" + "</INS:party>" + "</INS:endOfDayTradeEvent>";

        return xmlFragTradeEvent;
    } // end getXMLTradeBody()

    public static String getXMLTrade(final String id, final boolean specific, final boolean coupon)
    {
        return xmlFragHeader + getXMLTradeBody(id, specific, coupon) + xmlFragFooter;
    } // end getXMLTrade()

    public static String getXMLProduct(final String id, final boolean body)
    {
        String xmlFragProductSet = "<INS:productSet>" + "<INS:product id=\"" + TradeTest.getTrade(id).getProductReference() + "\">" + "<INS:productHeader>" + "<PHD:productIdentifier>" + "<GEN:productId>" + "<REF:id>"
                + TradeTest.getTrade(id).getProduct().getId() + "</REF:id>" + "<REF:idScheme>eoleProduct</REF:idScheme>" + "</GEN:productId>" + "</PHD:productIdentifier>" + "<PHD:productInfo>" + "<PHD:productTypology>"
                + "<PHD:referentialInstrumentTypology>" + "<PHD:instrumentCategory>debtBond</PHD:instrumentCategory>" + "</PHD:referentialInstrumentTypology>" + "</PHD:productTypology>"
                + "<PHD:productSourceApplicationId>" + "<REF:id>BDR</REF:id>" + "<REF:idScheme>referencialApplication</REF:idScheme>" + "</PHD:productSourceApplicationId>" + "<PHD:productMnemonic>"
                + TradeTest.getTrade(id).getProduct().getName() + "</PHD:productMnemonic>" + "<PHD:productName>" + TradeTest.getTrade(id).getProduct().getShortName() + "</PHD:productName>" + "<PHD:productDates>"
                + "<PHD:startDate>2001-10-02+02:00</PHD:startDate>" + "<PHD:maturityDate>2010-04-18+02:00</PHD:maturityDate>" + "<PHD:maturityDateType>Fixed</PHD:maturityDateType>" + "</PHD:productDates>"
                + "<PHD:productValuationCurrency>USD</PHD:productValuationCurrency>" + "<PHD:productReferenceQuantity>5000</PHD:productReferenceQuantity>" + "<PHD:productReferenceParty>"
                + "<PHD:productPartyReference href=\"" + TradeTest.getTrade(id).getProduct().getIssuerParty().getReference() + "\"/>" + "<PHD:productPartyRole>InstrumentIssuer</PHD:productPartyRole>"
                + "</PHD:productReferenceParty>" + "</PHD:productInfo>" + "</INS:productHeader>" + "</INS:product>" + "<INS:party id=\"" + TradeTest.getTrade(id).getProduct().getIssuerParty().getReference() + "\">"
                + "<PTY:partyIdentifier>" + "<PTY:tradePartyId>" + "<REF:id>" + TradeTest.getTrade(id).getProduct().getIssuerParty().getId() + "</REF:id>" + "<REF:idScheme>eoleExternalParty</REF:idScheme>"
                + "</PTY:tradePartyId>" + "<PTY:tradePartyType>Party</PTY:tradePartyType>" + "<PTY:tradePartyMnemonic>" + TradeTest.getTrade(id).getProduct().getIssuerParty().getName() + "</PTY:tradePartyMnemonic>"
                + "<PTY:tradePartyShortName>" + TradeTest.getTrade(id).getProduct().getIssuerParty().getShortName() + "</PTY:tradePartyShortName>" + "</PTY:partyIdentifier>" + "</INS:party>" + "</INS:productSet>";

        if (body)
        {
            return xmlFragProductSet;
        } // end if
        else
        {
            return xmlFragHeader + xmlFragProductSet + xmlFragFooter;
        } // end else
    } // end getXMLProduct()

    public static void testXMLTradeSCN01(final String xmlResult) throws Exception
    {
        testXMLTrade(getXMLTrade("SCN01", true, true), xmlResult);
    } // end testXMLTradeSCN01()

    public void testXMLTradeSCN01() throws Exception
    {
        testXMLTradeSCN01(getXMLTrade("SCN01", true, true));
    } // end testXMLTradeSCN01()

    public static void testXMLTradeSCN02(final String xmlResult) throws Exception
    {
        testXMLTrade(getXMLTrade("SCN02", true, false), xmlResult);
    } // end testXMLTradeSCN02()

    public void testXMLTradeSCN02() throws Exception
    {
        testXMLTradeSCN02(getXMLTrade("SCN02", true, false));
    } // end testXMLTradeSCN02()
} // end XMLTradeTest

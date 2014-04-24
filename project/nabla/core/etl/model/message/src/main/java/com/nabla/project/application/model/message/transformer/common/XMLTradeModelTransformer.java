package com.nabla.project.application.model.message.transformer.common;

import java.util.Collection;
import java.util.LinkedList;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

import com.nabla.project.application.model.message.domain.Trade;
import com.nabla.project.application.model.message.transformer.ModelTransformer;
import com.nabla.project.application.model.message.xml.JaxbDateHelper;
import com.nabla.project.application.model.xml.TradeDirectionScheme;
import com.nabla.project.application.model.xml.TradePartyInfo;
import com.nabla.project.application.model.xml.XMLCode;
import com.nabla.project.application.model.xml.XMLDatetimeVersion;
import com.nabla.project.application.model.xml.XMLExchangedProduct;
import com.nabla.project.application.model.xml.XMLId;
import com.nabla.project.application.model.xml.XMLParty;
import com.nabla.project.application.model.xml.XMLPartyRoleScheme;
import com.nabla.project.application.model.xml.XMLReference;
import com.nabla.project.application.model.xml.XMLTrade;
import com.nabla.project.application.model.xml.XMLTradeConditions;
import com.nabla.project.application.model.xml.XMLTradeHeader;
import com.nabla.project.application.model.xml.XMLTradeId;
import com.nabla.project.application.model.xml.XMLTradeIdentifier;

/**
 * Author : $author$ Date : $Date: 2010-06-18 13:51:31 +0200 (Mon, 18 Jun 2010) $ Revision : $revision$
 */
public class XMLTradeModelTransformer extends ModelTransformer
{
    private Logger logger = Logger.getLogger(getClass());

    /* On implemente ici les composants reutilisable */
    public Object transform(final Object rbkModel)
    {
        XMLTrade transformedRbkModel = buildTrade((Trade) rbkModel);

        return new JAXBElement<XMLTrade>(TRADE_QNAME, XMLTrade.class, transformedRbkModel);
    } // end transform()

    public XMLTrade buildTrade(final Trade trade)
    {
        XMLTrade tradeRoot = XMLfactory.createXMLTrade();
        tradeRoot.setId(trade.getReference());
        tradeRoot.setVersion(BACK_TRADE_VERSION_SCHEME);
        tradeRoot.setTradeHeader(buildTradeHeader(trade));
        tradeRoot.setTradeConditions(buildTradeConditions(trade));
        tradeRoot.getTradePartyInfo().addAll(buildTradePartyInfos(trade));

        return tradeRoot;
    } // end buildTrade()

    protected XMLTradeHeader buildTradeHeader(final Trade trade)
    {
        /**
         * /trade/tradeHeader/tradeIdentifier
         */
        XMLTradeIdentifier identifier = XMLfactory.createXMLTradeIdentifier();

        // trade/tradeHeader/tradeIdentifier/tradeId/id
        // trade/tradeHeader/tradeIdentifier/tradeId/idScheme
        XMLTradeId tradeId = XMLfactory.createXMLTradeId();
        tradeId.setId(trade.getId());
        tradeId.setIdScheme(BACK_TRADE_SCHEME);
        identifier.setTradeId(tradeId);

        // trade/tradeHeader/tradeIdentifier/tradeVersion/versionNumber
        XMLDatetimeVersion version = XMLfactory.createXMLDatetimeVersion();
        version.setVersionNumber(trade.getIdVersion());
        identifier.setTradeVersion(version);

        // trade/tradeHeader/tradeIdentifier/tradeCode/code
        // trade/tradeHeader/tradeIdentifier/tradeCode/codingScheme
        if (trade.getIdFront() != null)
        {
            XMLCode code = XMLfactory.createXMLCode();
            code.setCode(trade.getIdFront());
            code.setCodingScheme(FRONT_TRADE_SCHEME);
            identifier.getTradeCode().add(code);
        } // end if

        XMLTradeHeader tradeHeader = XMLfactory.createXMLTradeHeader();
        tradeHeader.setTradeIdentifier(identifier);

        return tradeHeader;
    } // end buildTradeHeader()

    protected XMLTradeConditions buildTradeConditions(final Trade trade)
    {
        /**
         * /trade/tradeConditions
         */
        XMLTradeConditions tradeConditions = XMLfactory.createXMLTradeConditions();

        // trade/tradeConditions/tradeDate
        XMLGregorianCalendar date = JaxbDateHelper.getJaxbDate(trade.getTradeDate());

        if (date != null)
        {
            tradeConditions.setTradeDate(date);
        } // end if
        else
        {
            logger.warn("WARNING : " + trade.getId() + " DATNGC = " + date);
            throw new AssertionError("Unknown value for setTradeDate() : ");
        } // end else

        // trade/tradeConditions/tradeTimeStamp
        date = JaxbDateHelper.getJaxbDateTime(trade.getSystemDate());

        if (date != null)
        {
            tradeConditions.setTradeTimeStamp(date);
        } // end if
        else
        {
            logger.warn("WARNING : " + trade.getId() + " DATSYS = " + date);
            throw new AssertionError("Unknown value for setTradeTimeStamp() : ");
        } // end else

        // trade/tradeConditions/APartyReference
        XMLParty portfolioParty = XMLfactory.createXMLParty();
        portfolioParty.setId(trade.getPortfolioReference());

        XMLReference portfolioReference = XMLfactory.createXMLReference();
        portfolioReference.setHref(portfolioParty);
        tradeConditions.setAPartyReference(portfolioReference);

        // trade/tradeConditions/BPartyReference
        XMLParty counterPartyParty = XMLfactory.createXMLParty();
        counterPartyParty.setId(trade.getCounterPartyReference());

        XMLReference counterPartyReference = XMLfactory.createXMLReference();
        counterPartyReference.setHref(counterPartyParty);
        tradeConditions.setBPartyReference(counterPartyReference);

        // product
        XMLExchangedProduct exchangedProduct = XMLfactory.createXMLExchangedProduct();

        // trade/tradeConditions/exchangedProduct1/productId/id
        // trade/tradeConditions/exchangedProduct1/productId/idScheme
        XMLId idProduct = XMLfactory.createXMLId();
        idProduct.setId(trade.getProductReference());
        idProduct.setIdScheme(BACK_PRODUCT_SCHEME);
        exchangedProduct.setProductId(idProduct);

        // trade/tradeConditions/exchangedProduct1/quantity
        exchangedProduct.setQuantity(trade.getQuantity());

        // trade/tradeConditions/exchangedProduct1/valueDate
        date = JaxbDateHelper.getJaxbDate(trade.getValueDate());

        if (date != null)
        {
            exchangedProduct.setValueDate(date);
        } // end if
        else
        {
            logger.warn("WARNING : " + trade.getId() + " DATVAL = " + date);
            throw new AssertionError("Unknown value for setValueDate() : ");
        } // end else

        tradeConditions.setExchangedProduct(exchangedProduct);

        // trade/tradeConditions/ATradeDirection
        switch (trade.getTradeDirection())
        {
            case BUY:
                tradeConditions.setATradeDirection(TradeDirectionScheme.BUY);

                break;

            case SELL:
                tradeConditions.setATradeDirection(TradeDirectionScheme.SELL);

                break;

            default:
                logger.warn("WARNING : " + trade.getId() + " TYPAVT = " + trade.getTradeDirection());
                tradeConditions.setATradeDirection(TradeDirectionScheme.BUY);

                // throw new AssertionError("Unknown value for setATradeDirection() : ");
        } // end switch

        return tradeConditions;
    } // end buildTradeConditions()

    protected Collection<? extends TradePartyInfo> buildTradePartyInfos(final Trade trade)
    {
        Collection<TradePartyInfo> partyCollection = new LinkedList<TradePartyInfo>();

        /**
         * PORTFOLIO : /trade/tradePartyInfo
         */
        TradePartyInfo portfolio = XMLfactory.createTradePartyInfo();

        // trade/tradePartyInfo/partyRole
        portfolio.getPartyRole().add(XMLPartyRoleScheme.PRINCIPAL);

        // trade/tradePartyInfo/storageApplication/id
        // trade/tradePartyInfo/storageApplication/idScheme
        XMLId idPortfolioStorageApplication = XMLfactory.createXMLId();
        idPortfolioStorageApplication.setId(BACK_UNKNOWN_SCHEME);
        idPortfolioStorageApplication.setIdScheme(BACK_PORTFOLIO_SCHEME);
        portfolio.setStorageApplication(idPortfolioStorageApplication);

        // trade/tradePartyInfo/PartyReference/href/id
        XMLParty portfolioParty = XMLfactory.createXMLParty();
        portfolioParty.setId(trade.getPortfolioReference());

        XMLReference portfolioReference = XMLfactory.createXMLReference();
        portfolioReference.setHref(portfolioParty);
        portfolio.setPartyReference(portfolioReference);

        partyCollection.add(portfolio);

        /**
         * COUNTERPARTIE : /trade/tradePartyInfo
         */
        TradePartyInfo party = XMLfactory.createTradePartyInfo();

        // trade/tradePartyInfo/partyRole
        party.getPartyRole().add(XMLPartyRoleScheme.THIRD_PARTY);

        // trade/tradePartyInfo/storageApplication/id
        // trade/tradePartyInfo/storageApplication/idScheme
        XMLId idPartyStorageApplication = XMLfactory.createXMLId();
        idPartyStorageApplication.setId(BACK_UNKNOWN_SCHEME);
        idPartyStorageApplication.setIdScheme(BACK_EXTERNALPARTY_SCHEME);
        party.setStorageApplication(idPartyStorageApplication);

        // trade/tradePartyInfo/PartyReference/href/id
        XMLParty counterPartyParty = XMLfactory.createXMLParty();
        counterPartyParty.setId(trade.getCounterPartyReference());

        XMLReference counterPartyReference = XMLfactory.createXMLReference();
        counterPartyReference.setHref(counterPartyParty);
        party.setPartyReference(counterPartyReference);

        partyCollection.add(party);

        return partyCollection;
    } // end buildTradePartyInfos()
} // end XMLTradeModelTransformer

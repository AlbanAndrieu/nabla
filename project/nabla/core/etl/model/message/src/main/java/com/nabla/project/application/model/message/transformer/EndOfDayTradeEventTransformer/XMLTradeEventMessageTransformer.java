package com.nabla.project.application.model.message.transformer.EndOfDayTradeEventTransformer;

import com.nabla.project.application.model.message.domain.Trade;
import com.nabla.project.application.model.message.transformer.ModelTransformer;
import com.nabla.project.application.model.message.transformer.common.XMLPartyModelTransformer;
import com.nabla.project.application.model.message.transformer.common.XMLTradeModelTransformer;
import com.nabla.project.application.model.xml.XMLInventoryTradeMessage;

import org.apache.log4j.Logger;

/**
 * Author : $author$ Date : $Date: 2010-06-15 18:32:17 +0200 (Fri, 15 Jun 2010) $ Revision : $revision$
 */
public class XMLTradeEventMessageTransformer extends ModelTransformer
{
    public Logger            logger = Logger.getLogger(getClass());
    private ModelTransformer tradeTransformer;
    private ModelTransformer partyTransformer;

    public Object transform(final Object sources)
    {
        XMLInventoryTradeMessage tradeEventMessage = XMLfactory.createXMLInventoryTradeMessage();

        if (sources instanceof Trade)
        {
            // flush trade
            tradeEventMessage.setTrade(((XMLTradeModelTransformer) tradeTransformer).buildTrade((Trade) sources));
            // flush counter party
            tradeEventMessage.getParty().add(((XMLPartyModelTransformer) partyTransformer).buildParty(((Trade) sources).getCounterParty()));
            // flush portfolio party
            tradeEventMessage.getParty().add(((XMLPartyModelTransformer) partyTransformer).buildParty(((Trade) sources).getPortfolioParty()));
        } // end if
        else
        {
            throw new AssertionError("Unknown object to transform : must be a Trade type");
        } // end else

        // TODO uncomment this line to add financial info
        // tradeEventMessage.setFinancialInfo(buildFinancialInfo());
        return XMLfactory.createInventoryTrade(tradeEventMessage);
    } // end transform()

    /*
     * private XMLFinancialInfo buildFinancialInfo() {
     * // FIXME fake financial info for validating schema
     * // need to get data from database
     * XMLFinancialInfo financialInfo = XMLfactory.createXMLFinancialInfo();
     * financialInfo.setInfoTimeStamp(JaxbDateHelper.getJaxbDateTime(new Date()));
     * XMLFinancialIndicator financialIndicator = XMLfactory.createXMLFinancialIndicator();
     * XMLFinancialIndicatorTypology financialIndicatorTypology = XMLfactory.createXMLFinancialIndicatorTypology();
     * financialIndicatorTypology.setFinancialIndicatorCategory(XMLFinancialIndicatorCategoryScheme.INVENTORY_POSITION);
     * financialIndicatorTypology.setFinancialIndicatorType("AccruedInterest");
     * financialIndicator.setFinancialIndicatorTypology(financialIndicatorTypology);
     * XMLFinancialIndicatorValue financialIndicatorValue = XMLfactory.createXMLFinancialIndicatorValue();
     * financialIndicatorValue.setFinancialIndicatorValue("");
     * financialIndicator.setFinancialIndicatorValue(financialIndicatorValue);
     * financialInfo.getFinancialIndicator().add(financialIndicator);
     * return financialInfo;
     * }
     */
    /**
     * 
     * @return the partyTransformer
     */
    public ModelTransformer getPartyTransformer()
    {
        return partyTransformer;
    } // end getPartyTransformer()

    /**
     * 
     * @param partyTransformer the partyTransformer to set
     */
    public void setPartyTransformer(final ModelTransformer partyTransformer)
    {
        this.partyTransformer = partyTransformer;
    } // end setPartyTransformer()

    /**
     * 
     * @return the tradeTransformer
     */
    public ModelTransformer getTradeTransformer()
    {
        return tradeTransformer;
    } // end getTradeTransformer()

    /**
     * 
     * @param tradeTransformer the tradeTransformer to set
     */
    public void setTradeTransformer(final ModelTransformer tradeTransformer)
    {
        this.tradeTransformer = tradeTransformer;
    } // end setTradeTransformer()
} // end XMLTradeEventMessage

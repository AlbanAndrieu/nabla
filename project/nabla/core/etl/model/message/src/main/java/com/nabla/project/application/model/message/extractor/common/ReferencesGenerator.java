package com.nabla.project.application.model.message.extractor.common;

/**
 * Author : $author$ Date : $Date: 2010-06-14 12:02:51 +0200 (Thu, 14 Jun 2010) $ Revision : $revision$
 */
public class ReferencesGenerator
{
    public static String getTradeRefId(final String tradeId)
    {
        return new StringBuilder("trade_").append(tradeId).toString();
    } // end getTradeRefId()

    public static String getProductRefId(final String tradeId, final String productId)
    {
        return new StringBuilder("product_").append(tradeId).append("_").append(productId).toString();
    } // end getProductRefId()

    public static String getPartyRefForTrade(final String tradeId, final String partyId)
    {
        return new StringBuilder("party_").append(tradeId).append("_").append(partyId).toString();
    } // end getPartyRefForTrade()

    public static String getPartyRefForProduct(final String productId, final String partyId)
    {
        return new StringBuilder("party_").append(productId).append("_").append(partyId).toString();
    } // end getPartyRefForProduct()
} // end ReferencesGenerator

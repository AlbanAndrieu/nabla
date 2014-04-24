package com.nabla.project.application.model.message.domain;

import com.nabla.project.application.model.xml.XMLInventoryTradeMessage;
import com.nabla.project.application.model.xml.XMLProduct;

import javax.xml.bind.JAXBElement;

/**
 * Author : $author$ Date : $Date: 2010-06-14 12:02:51 +0200 (Thu, 14 Jun 2010) $ Revision : $revision$
 */
public class ObjectContainer
{
    protected JAXBElement<XMLInventoryTradeMessage> trade;
    protected JAXBElement<XMLProduct>               product;

    public JAXBElement<XMLProduct> getProduct()
    {
        return product;
    } // end getProduct()

    public void setProduct(final JAXBElement<XMLProduct> product)
    {
        this.product = product;
    } // end setProduct()

    public JAXBElement<XMLInventoryTradeMessage> getTrade()
    {
        return trade;
    } // end getTrade()

    public void setTrade(final JAXBElement<XMLInventoryTradeMessage> trade)
    {
        this.trade = trade;
    } // end setTrade()

    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("trade=").append(trade);
        str.append(",product=").append(product);

        return str.toString();
    } // end toString()
} // end ObjectContainer

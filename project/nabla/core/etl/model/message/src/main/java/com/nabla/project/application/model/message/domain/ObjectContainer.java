package com.nabla.project.application.model.message.domain;

import javax.xml.bind.JAXBElement;

import com.nabla.project.application.model.xml.XMLInventoryTradeMessage;
import com.nabla.project.application.model.xml.XMLProduct;

/**
 * Author : $author$ Date : $Date: 2010-06-14 12:02:51 +0200 (Thu, 14 Jun 2010) $ Revision : $revision$
 */
public class ObjectContainer
{
    protected JAXBElement<XMLInventoryTradeMessage> trade;
    protected JAXBElement<XMLProduct>               product;

    public JAXBElement<XMLProduct> getProduct()
    {
        return this.product;
    } // end getProduct()

    public void setProduct(final JAXBElement<XMLProduct> product)
    {
        this.product = product;
    } // end setProduct()

    public JAXBElement<XMLInventoryTradeMessage> getTrade()
    {
        return this.trade;
    } // end getTrade()

    public void setTrade(final JAXBElement<XMLInventoryTradeMessage> trade)
    {
        this.trade = trade;
    } // end setTrade()

    @Override
    public String toString()
    {
        final StringBuffer str = new StringBuffer();
        str.append("trade=").append(this.trade);
        str.append(",product=").append(this.product);

        return str.toString();
    } // end toString()
} // end ObjectContainer

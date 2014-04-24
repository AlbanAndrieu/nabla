package com.nabla.project.application.model.message.transformer.impl;

import com.nabla.project.application.api.transformer.TransformerDataInterface;
import com.nabla.project.application.model.message.domain.ObjectContainer;
import com.nabla.project.application.model.message.domain.Trade;
import com.nabla.project.application.model.message.transformer.ModelTransformer;
import com.nabla.project.application.model.xml.XMLInventoryTradeMessage;
import com.nabla.project.application.model.xml.XMLProduct;

import org.apache.log4j.Logger;

import javax.xml.bind.JAXBElement;

/**
 * Author : $author$ Date : $Date: 2010-06-15 16:05:13 +0200 (Fri, 15 Jun 2010) $ Revision : $revision$
 */
public class TransformerTradeJaxb<SRC, TRG> implements TransformerDataInterface, TransformerTradeJaxbMBean
{
    private Logger             logger = Logger.getLogger(getClass());
    protected ModelTransformer tradeEventMessage;
    protected ModelTransformer productSetMessage;

    public ModelTransformer getProductSetMessage()
    {
        return productSetMessage;
    } // end getProductSetMessage()

    public void setProductSetMessage(final ModelTransformer productSetMessage)
    {
        this.productSetMessage = productSetMessage;
    } // end setProductSetMessage()

    public ModelTransformer getTradeEventMessage()
    {
        return tradeEventMessage;
    } // end getTradeEventMessage()

    public void setTradeEventMessage(final ModelTransformer tradeEventMessage)
    {
        this.tradeEventMessage = tradeEventMessage;
    } // end setTradeEventMessage()

    public ObjectContainer transform(final Object object)
    {
        if (logger.isDebugEnabled())
        {
            logger.debug(object);
        } // end if

        Trade trade = (Trade) object;

        ObjectContainer container = new ObjectContainer();
        // transform trade
        container.setTrade((JAXBElement<XMLInventoryTradeMessage>) tradeEventMessage.transform(trade));
        container.setProduct((JAXBElement<XMLProduct>) productSetMessage.transform(trade.getProduct()));

        return container;
    } // end transform()
} // end TransformerTradeJaxb

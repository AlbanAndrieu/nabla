package com.nabla.project.application.model.message.transformer.EndOfDayTradeEventTransformer;

import org.apache.log4j.Logger;

import com.nabla.project.application.model.message.domain.Product;
import com.nabla.project.application.model.message.transformer.ModelTransformer;
import com.nabla.project.application.model.message.transformer.common.XMLPartyModelTransformer;
import com.nabla.project.application.model.message.transformer.common.XMLProductModelTransformer;
import com.nabla.project.application.model.xml.XMLProductSetMessage;

/**
 * Author : $author$ Date : $Date: 2010-06-15 18:32:17 +0200 (Fri, 15 Jun 2010) $ Revision : $revision$
 */
public class XMLProductSetMessageTransformer extends ModelTransformer
{
    public Logger            logger = Logger.getLogger(getClass());
    private ModelTransformer productTransformer;
    private ModelTransformer partyTransformer;

    public Object transform(final Object sources)
    {
        XMLProductSetMessage productSetMessage = XMLfactory.createXMLProductSetMessage();

        if (sources instanceof Product)
        {
            productSetMessage.getProduct().add((((XMLProductModelTransformer) productTransformer).buildProduct((Product) sources)));

            // flush product party
            productSetMessage.getParty().add(((XMLPartyModelTransformer) partyTransformer).buildParty(((Product) sources).getIssuerParty()));
        } // end if
        else
        {
            throw new AssertionError("Unknown object to transform : must be a Product type");
        } // end else

        return XMLfactory.createProductSet(productSetMessage);
    } // end transform()

    /**
     * @return the partyTransformer
     */
    public ModelTransformer getPartyTransformer()
    {
        return partyTransformer;
    } // end getPartyTransformer()

    /**
     * @param partyTransformer the partyTransformer to set
     */
    public void setPartyTransformer(final ModelTransformer partyTransformer)
    {
        this.partyTransformer = partyTransformer;
    } // end setPartyTransformer()

    /**
     * @return the productTransformer
     */
    public ModelTransformer getProductTransformer()
    {
        return productTransformer;
    } // end getProductTransformer()

    /**
     * @param productTransformer the productTransformer to set
     */
    public void setProductTransformer(final ModelTransformer productTransformer)
    {
        this.productTransformer = productTransformer;
    } // end setProductTransformer()
}

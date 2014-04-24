package com.nabla.project.application.model.message.transformer.common;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

import com.nabla.project.application.model.message.domain.Product;
import com.nabla.project.application.model.message.transformer.ModelTransformer;
import com.nabla.project.application.model.message.xml.JaxbDateHelper;
import com.nabla.project.application.model.xml.MaturityDateTypeScheme;
import com.nabla.project.application.model.xml.ProductPartyRoleScheme;
import com.nabla.project.application.model.xml.XMLCode;
import com.nabla.project.application.model.xml.XMLId;
import com.nabla.project.application.model.xml.XMLParty;
import com.nabla.project.application.model.xml.XMLProduct;
import com.nabla.project.application.model.xml.XMLProductDates;
import com.nabla.project.application.model.xml.XMLProductHeader;
import com.nabla.project.application.model.xml.XMLProductIdentifier;
import com.nabla.project.application.model.xml.XMLProductInfo;
import com.nabla.project.application.model.xml.XMLProductReferenceParty;
import com.nabla.project.application.model.xml.XMLProductTypologyInfo;
import com.nabla.project.application.model.xml.XMLReference;

/**
 * Author : $author$ Date : $Date: 2010-06-14 12:02:51 +0200 (Thu, 14 Jun 2010) $ Revision : $revision$
 */
public class XMLProductModelTransformer extends ModelTransformer
{
    private Logger logger = Logger.getLogger(getClass());

    public Object transform(final Object rbkModel)
    {
        XMLProduct transformedRbkModel = buildProduct((Product) rbkModel);

        return new JAXBElement<XMLProduct>(PRODUCT_QNAME, XMLProduct.class, transformedRbkModel);
    } // end transform()

    public XMLProduct buildProduct(final Product product)
    {
        XMLProduct productRoot = XMLfactory.createXMLProduct();
        productRoot.setId(product.getReference());
        productRoot.setProductHeader(buildProductHeader(product));

        return productRoot;
    } // end buildProduct()

    protected XMLProductHeader buildProductHeader(final Product product)
    {
        // product//productHeader/productIdentifier/productId/idScheme
        // product//productHeader/productIdentifier/productId/id
        XMLId productId = XMLfactory.createXMLId();
        productId.setId(product.getId());
        productId.setIdScheme(BACK_PRODUCT_SCHEME);

        XMLProductIdentifier identifier = XMLfactory.createXMLProductIdentifier();
        identifier.setProductId(productId);

        // product/productHeader/productIdentifier/productCode/code
        // product/productHeader/productIdentifier/productCode/codingScheme
        XMLCode code = new XMLCode();
        code.setCode(product.getIdentifiantISIN());
        code.setCodingScheme(BACK_PRODUCT_CODE_SCHEME);

        List<XMLCode> codeList = identifier.getProductCode();
        codeList.add(code);

        XMLProductHeader productHeader = XMLfactory.createXMLProductHeader();
        productHeader.setProductIdentifier(identifier);
        productHeader.setProductInfo(buildProductInfo(product));

        return productHeader;
    } // end buildProductHeader()

    protected XMLProductInfo buildProductInfo(final Product product)
    {
        XMLProductInfo productInfo = XMLfactory.createXMLProductInfo();

        XMLProductTypologyInfo typologyInfo = XMLfactory.createXMLProductTypologyInfo();

        // product//productHeader/productInfo/productMnemonic
        // product//productHeader/productInfo/productName
        productInfo.setProductName(product.getName());
        productInfo.setProductShortName(product.getShortName());

        // product//productHeader/productInfo/productDates/startDate
        XMLProductDates productDates = XMLfactory.createXMLProductDates();

        XMLGregorianCalendar startDate = JaxbDateHelper.getJaxbDate(product.getStartValidityDate());

        if (startDate != null)
        {
            productDates.setStartDate(startDate);
        } // end if
        else
        {
            logger.warn("WARNING : " + product.getId() + " DATSTR = " + startDate);
            throw new AssertionError("Unknown value for setStartDate() : ");
        } // end else

        // FIXME : not well implemented ! need to take data from different table in database.
        // TO FIX !!!!
        // product//productHeader/productInfo/productDates/maturityDate
        // product//productHeader/productInfo/productDates/maturityDateType
        XMLGregorianCalendar maturityDate = JaxbDateHelper.getJaxbDate(product.getEndValidityDate());

        switch (product.getProductCategory())
        {
            case BOND:
                productDates.setMaturityDate(maturityDate);

                // productDates.setMaturityDateType( eme.FIXED );
                break;

            case PAPERS:
                productDates.setMaturityDate(maturityDate);
                productDates.setMaturityDateType(MaturityDateTypeScheme.FIXED);

                break;

            case SHARE:
                productDates.setMaturityDateType(MaturityDateTypeScheme.OPEN);

                break;

            default:
                logger.warn("WARNING : " + product.getId() + " Product Category = " + product.getProductCategory());
                productDates.setMaturityDateType(MaturityDateTypeScheme.OPEN);

                // throw new AssertionError("Unknown value for setATradeDirection() : ");
        } // end switch

        if (maturityDate != null)
        {
            productDates.setMaturityDate(maturityDate);
        } // end if
        else
        {
            logger.warn("WARNING : " + product.getId() + " DATEND = " + maturityDate);
            throw new AssertionError("Unknown value for setMaturityDate() : ");
        } // end else

        productInfo.setProductDates(productDates);

        // product//productHeader/productInfo/productReferenceQuantity
        productInfo.setProductReferenceQuantity(product.getNominalAmount());

        XMLProductReferenceParty referenceParty = XMLfactory.createXMLProductReferenceParty();

        // product//productHeader/productInfo/productReferenceParty/productPartyId/Id
        XMLParty issuerPartyParty = XMLfactory.createXMLParty();
        issuerPartyParty.setId(product.getIssuerPartyReference());

        XMLReference partyReference = XMLfactory.createXMLReference();
        partyReference.setHref(issuerPartyParty);
        referenceParty.setProductPartyReference(partyReference);

        referenceParty.setProductPartyRole(ProductPartyRoleScheme.INSTRUMENT_ISSUER);

        productInfo.getProductReferenceParty().add(referenceParty);

        return productInfo;
    } // end buildProductInfo()
}

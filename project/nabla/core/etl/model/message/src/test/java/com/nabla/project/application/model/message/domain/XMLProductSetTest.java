package com.nabla.project.application.model.message.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.JAXBElement;

import junit.framework.TestCase;

import com.nabla.project.application.api.transformer.TransformerDataInterface;
import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.core.spring.ApplicationContextMessageFactory;
import com.nabla.project.application.core.spring.MessageConfig;
import com.nabla.project.application.model.message.transformer.common.XMLProductModelTransformer;
import com.nabla.project.application.model.xml.XMLProduct;

/**
 * Author : $author$
 * Date : $Date: 2010-06-20 17:01:12 +0200 (Wed, 20 Jun 2010) $
 * Revision : $revision$
 * Test below are launched via class TestsUnitairesMapping
 */
public class XMLProductSetTest extends TestCase
{
    protected static TransformerDataInterface transformer;

    static
    {
        Log.init();
        ApplicationContextMessageFactory.springXmlConfiguration = ApplicationContextMessageFactory.springXmlConfigurationTest;
        transformer = (TransformerDataInterface) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(MessageConfig.beanDataTransformerProductMessageName);
    }

    /**
     * Common tests on XMLProduct objects
     * 
     * @param XMLProduct
     */
    public static void testXMLProduct(XMLProduct XMLProduct)
    {
        assertNotNull(XMLProduct);
    }

    public static String                  id2                = ProductTest.id2;
    public static String                  name2              = ProductTest.name2;
    public static String                  shortName2         = ProductTest.shortNamet2;
    public static Product.ProductCategory category2          = ProductTest.category2;
    public static Date                    startValidityDate2 = ProductTest.startValidityDate2;
    public static Date                    endValidityDate2   = ProductTest.endValidityDate2;
    public static String                  valuationCurrency2 = ProductTest.valuationCurrency2;
    public static BigDecimal              nominalAmount2     = ProductTest.nominalAmount2;

    public static XMLProduct getXMLProduct2()
    {
        XMLProductModelTransformer modelTransformer = new XMLProductModelTransformer();
        XMLProduct XMLProduct = (XMLProduct) modelTransformer.buildProduct(TradeTest.getTrade(TradeTest.idSCN01).getProduct());

        return XMLProduct;
    }

    /**
     * Specifics tests on Product 2
     * 
     * @param XMLProduct
     */
    public static void testXMLProduct2(XMLProduct XMLProduct)
    {
        testXMLProduct(XMLProduct);
    }

    public void testXMLProduct2()
    {
        testXMLProduct2(getXMLProduct2());
    }

    @SuppressWarnings("unchecked")
    public static JAXBElement<XMLProduct> getJAXBXMLProduct2()
    {
        JAXBElement<XMLProduct> jaxbXMLProduct = (JAXBElement<XMLProduct>) transformer.transform(TradeTest.getTrade(TradeTest.idSCN01).getProduct());

        return jaxbXMLProduct;
    }

    /**
     * @TODO
     * @return
     */
    public static void testJAXBXMLProduct2(JAXBElement<XMLProduct> jaxbXMLProduct)
    {
        assertNotNull(jaxbXMLProduct);
    }

    public void testJAXBXMLProduct2()
    {
        testJAXBXMLProduct2(getJAXBXMLProduct2());
    }

    public static String                  id1                = ProductTest.id1;
    public static String                  name1              = ProductTest.name1;
    public static String                  shortName1         = ProductTest.shortName1;
    public static Product.ProductCategory category1          = ProductTest.category1;
    public static Date                    startValidityDate1 = ProductTest.startValidityDate1;
    public static Date                    endValidityDate1   = ProductTest.endValidityDate1;
    public static String                  valuationCurrency1 = ProductTest.valuationCurrency1;
    public static BigDecimal              nominalAmount1     = ProductTest.nominalAmount1;

    public static XMLProduct getXMLProduct1()
    {
        XMLProductModelTransformer modelTransformer = new XMLProductModelTransformer();
        XMLProduct XMLProduct = (XMLProduct) modelTransformer.buildProduct(TradeTest.getTrade(TradeTest.idSCN02).getProduct());

        return XMLProduct;
    }

    /**
     * Specifics tests on Product 1
     * 
     * @param XMLProduct
     */
    public static void testXMLProduct1(XMLProduct XMLProduct)
    {
        testXMLProduct(XMLProduct);
    }

    public void testXMLProduct1()
    {
        testXMLProduct1(getXMLProduct1());
    }

    public static JAXBElement<XMLProduct> getJAXBXMLProduct1()
    {
        JAXBElement<XMLProduct> jaxbXMLProduct = (JAXBElement<XMLProduct>) transformer.transform(TradeTest.getTrade(TradeTest.idSCN02).getProduct());

        return jaxbXMLProduct;
    }

    /**
     * @TODO
     * @return
     */
    public static void testJAXBXMLProduct1(JAXBElement<XMLProduct> jaxbXMLProduct)
    {
        assertNotNull(jaxbXMLProduct);
    }

    public void testJAXBXMLProduct1()
    {
        testJAXBXMLProduct1(getJAXBXMLProduct1());
    }
}

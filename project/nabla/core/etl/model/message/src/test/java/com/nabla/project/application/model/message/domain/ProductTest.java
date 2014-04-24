package com.nabla.project.application.model.message.domain;

import com.nabla.project.application.core.log.Log;

import junit.framework.TestCase;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * Author : $author$ Date : $Date: 2010-06-20 17:01:12 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$ Test below are launched via class
 * TestsUnitairesMapping
 */
public class ProductTest extends TestCase
{
    public void setUp()
    {
        Log.init();
    } // end setUp()

    public static String idProduct0 = "idProduct";

    public static Product getProduct0()
    {
        Product product = new Product();
        product.setId(idProduct0);

        return product;
    } // end getProduct0()

    public static void testProduct0(final Product product)
    {
        assertNotNull(product);
        assertEquals(idProduct0, product.getId());
    } // end testProduct0()

    public void testProduct0()
    {
        testProduct0(getProduct0());
    } // end testProduct0()

    public static String                  id1                = "1";
    public static String                  name1              = "SCN01";
    public static String                  shortName1         = "BOND-MODEL 03/07";
    public static Product.ProductCategory category1          = Product.ProductCategory.BOND;
    public static Date                    startValidityDate1;                               // 2001-10-02
    public static Date                    endValidityDate1;                                 // 2010-04-18
    public static String                  valuationCurrency1 = "USD";
    public static BigDecimal              nominalAmount1     = new BigDecimal(5000);

    static
    {
        try
        {
            startValidityDate1 = new SimpleDateFormat("yyyyMMdd").parse("20011002"); // "2010-03-05";
            endValidityDate1 = new SimpleDateFormat("yyyyMMdd").parse("20100418"); // "2010-03-19";
        } // end try
        catch (Exception ex)
        {
            ex.printStackTrace();
        } // end catch
    }

    public static Product getProduct1()
    {
        Product product = new Product();
        product.setId(id1);
        product.setName(name1);
        product.setProductCategory(category1);
        product.setStartValidityDate(startValidityDate1);
        product.setEndValidityDate(endValidityDate1);
        product.setValuationCurrency(valuationCurrency1);
        product.setNominalAmount(nominalAmount1);
        product.setIssuerParty(PartyTest.getParty1());
        product.setShortName(shortName1);

        return product;
    } // end getProduct1()

    public static void testProduct1(final Product product)
    {
        assertNotNull(product);
        assertEquals(id1, product.getId());
        assertEquals(name1, product.getName());
        assertEquals(category1, product.getProductCategory());
        assertEquals(startValidityDate1, product.getStartValidityDate());
        assertEquals(endValidityDate1, product.getEndValidityDate());
        assertEquals(valuationCurrency1, product.getValuationCurrency());
        assertEquals(nominalAmount1, product.getNominalAmount());
        assertEquals(shortName1, product.getShortName());

        PartyTest.testParty1(product.getIssuerParty());
    } // end testProduct1()

    public void testProduct1()
    {
        testProduct1(getProduct1());
    } // end testProduct1()

    public static String                  id2                = "2";
    public static String                  name2              = "SCN02";
    public static String                  shortNamet2        = "EQUITY-MODEL";
    public static Product.ProductCategory category2          = Product.ProductCategory.SHARE;
    public static Date                    startValidityDate2;
    public static Date                    endValidityDate2;
    public static String                  valuationCurrency2 = "JPY";
    public static BigDecimal              nominalAmount2     = new BigDecimal(1);

    static
    {
        try
        {
            startValidityDate2 = new SimpleDateFormat("yyyyMMdd").parse("19920306");
            endValidityDate2 = new SimpleDateFormat("yyyyMMdd").parse("34560201");
        } // end try
        catch (Exception ex)
        {
            ex.printStackTrace();
        } // end catch
    }

    public static Product getProduct2()
    {
        Product product = new Product();
        product.setId(id2);
        product.setName(name2);
        product.setProductCategory(category2);
        product.setStartValidityDate(startValidityDate2);
        product.setEndValidityDate(endValidityDate2);
        product.setValuationCurrency(valuationCurrency2);
        product.setNominalAmount(nominalAmount2);
        product.setIssuerParty(PartyTest.getParty5());
        product.setShortName(shortNamet2);

        return product;
    } // end getProduct2()

    public static void testProduct2(final Product product)
    {
        assertNotNull(product);
        assertEquals(id2, product.getId());
        assertEquals(name2, product.getName());
        assertEquals(category2, product.getProductCategory());
        assertEquals(startValidityDate2, product.getStartValidityDate());
        assertEquals(endValidityDate2, product.getEndValidityDate());
        assertEquals(valuationCurrency2, product.getValuationCurrency());
        assertEquals(nominalAmount2, product.getNominalAmount());
        assertEquals(shortNamet2, product.getShortName());

        PartyTest.testParty5(product.getIssuerParty());
    } // end testProduct2()

    public void testProduct2()
    {
        testProduct2(getProduct2());
    } // end testProduct2()
} // end ProductTest

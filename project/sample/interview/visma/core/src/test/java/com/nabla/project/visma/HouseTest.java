package com.nabla.project.visma;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.nabla.project.visma.api.IProduct;

/**
 * DOCUMENT ME!
 *
 * @author $Author$
 * @version $Revision$
 *
 * @since $Date$
 */
public class HouseTest {

    public static final BigDecimal EXPECTED_PRICE = new BigDecimal(1_000_000);

    @Test(expected = AssertionError.class)
    public final void testEmptyContructor() {

        IProduct product = new House();
        Assert.assertNotNull(product);

    }

    @Test(expected = IllegalArgumentException.class)
    public final void testProductNull() {

        IProduct product = new House(null);
        Assert.assertNotNull(product);

    }
    
    @Test
    public final void testPriceContructor() {

        Assert.assertEquals(new House(new BigDecimal(1_000_000)).getPrice(), EXPECTED_PRICE);
        Assert.assertFalse("to string", new House(new BigDecimal(1_000_000)).equals(EXPECTED_PRICE));
    }

    @Test(expected = NumberFormatException.class)
    public final void testPriceNotANumber() {

        IProduct product = new House(new BigDecimal("Not a number"));
        Assert.assertNotNull(product);

    }

    @Test(expected = IllegalArgumentException.class)
    public final void testPriceNotNull() {

        IProduct product = new House(null);
        Assert.assertNotNull(product);

    }
    
    @Test(expected = IllegalArgumentException.class)
    public final void testNegatifPriceContructor() {

        Assert.assertEquals(new House(new BigDecimal(-100)), new BigDecimal(-100));

    }

    @Test(expected = IllegalArgumentException.class)
    public final void testPriceZero1() {

        Assert.assertEquals(new House(BigDecimal.ZERO), BigDecimal.ZERO);

    }

    @Test(expected = IllegalArgumentException.class)
    public final void testPriceZero2() {

        Assert.assertEquals(new House(0), BigDecimal.ZERO);

    }

    @Test
    public final void testToString() {

        Assert.assertEquals(new House(1_000_000).toString(), "name:" + House.DEFAULT_HOUSE_NAME + " price:"+EXPECTED_PRICE);
        Assert.assertFalse(new House(1_000_000).equals("name:" + House.DEFAULT_HOUSE_NAME + " price:"+EXPECTED_PRICE));

    }
    
    @Test
    public final void testCompareNull() {

        Assert.assertFalse(new House(1_000_000).equals(null));
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public final void testCompareZero() {

        Assert.assertFalse(new House(1_000_000).equals(new House((BigDecimal.ZERO))));
    }    

    @Test
    public final void testCompareOK() {

        Assert.assertEquals(new House(1_000_000), new House(1_000_000));
        Assert.assertTrue(new House(1_000_000).equals(new House(1_000_000)));
        Assert.assertFalse(new House(1_000_000).equals(new House((3_565_777))));
    }
    
    @Test
    public final void testCompareNOK() {

        Assert.assertFalse(new House(1_000_000).equals(new House((3_565_777))));
    }        
    
    @Test(expected = AssertionError.class)
    public final void testCompareNOKwithException() {

        Assert.assertFalse(new House(1_000_000).equals(new House()));
    }         
}


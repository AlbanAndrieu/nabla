package com.nabla.project.visma;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.nabla.project.visma.House;
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

    private IProduct product;
    private BigDecimal expectedPrice = new BigDecimal(1_000_000);

    @Before
    public void setUp() throws Exception {
        product = new House(expectedPrice);
    }

    @After
    public void tearDown() throws Exception {
        product = null;
    }

    @Test(expected = AssertionError.class)
    public final void testEmptyContructor() {

        product = new House();

    }

    @Test
    public final void testPriceContructor() {

        Assert.assertEquals(new House(new BigDecimal(1_000_000)).getPrice(), expectedPrice);
        Assert.assertFalse("to string", new House(new BigDecimal(1_000_000)).equals(expectedPrice));
    }

    @Test(expected = NumberFormatException.class)
    public final void testPriceNotANumber() {

        product = new House(new BigDecimal("Not a number"));

    }

    @Test(expected = IllegalArgumentException.class)
    public final void testPriceNotNull() {

        product = new House(null);

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

        Assert.assertEquals(new House(1_000_000).toString(), "name=Default house name price="+expectedPrice);
        Assert.assertFalse(new House(1_000_000).equals("name=Default house name price="+expectedPrice));

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


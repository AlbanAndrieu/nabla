package com.nabla.project.application.model.message.config;

import com.nabla.project.application.api.config.Condition;
import com.nabla.project.application.api.config.Condition.ConditionId;
import com.nabla.project.application.api.config.Perimeter;
import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.core.spring.ApplicationContextMessageFactory;

import org.junit.Assert;
import junit.framework.TestCase;

import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Author : $author$ Date : $Date: 2010-06-20 17:01:12 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$ Test below are launched via class
 * TestsUnitairesMapping
 */
public class PerimeterTest extends TestCase
{
    private Logger              logger     = Logger.getLogger(getClass());
    private final static String deal1      = "SCN01";
    private final static String deal2      = "SCN02";
    private final static String folder     = "NCA_EQUITY";
    private final static String typeOfDeal = "EquitiesDeals";
    private final static String datmin     = "2009-03-18";
    private final static String datmax     = "2009-03-19";

    public PerimeterTest()
    {
        Log.init();
    } // end PerimeterTest()

    public static Perimeter getPerimeterDeal1(final Perimeter perimeter)
    {
        Set<String> idList = new HashSet<String>();
        idList.add(deal1);
        perimeter.setIdList(idList);

        return perimeter;
    } // end getPerimeterDeal1()

    public static Perimeter getPerimeterDeal2(final Perimeter perimeter)
    {
        Set<String> idList = new HashSet<String>();
        idList.add(deal2);
        perimeter.setIdList(idList);

        return perimeter;
    } // end getPerimeterDeal2()

    public static Perimeter getPerimeterAll(final Perimeter perimeter)
    {
        return perimeter;
    } // end getPerimeterAll()

    public static Perimeter getPerimeterDefault(final Perimeter perimeter)
    {
        perimeter.addCondition(new Condition(ConditionId.MAXROW, "30"));
        perimeter.addCondition(new Condition(ConditionId.FOLDER, folder));
        perimeter.addCondition(new Condition(ConditionId.TYPEOFDEAL, typeOfDeal));

        perimeter.addCondition(new Condition(ConditionId.DATVALMIN, datmin));
        perimeter.addCondition(new Condition(ConditionId.DATVALMAX, datmax));

        return perimeter;
    } // end getPerimeterDefault()

    public static final Integer numberOfRowsPerimeter100 = 100;

    public static Perimeter getPerimeter100(final Perimeter perimeter)
    {
        perimeter.addCondition(new Condition(ConditionId.MAXROW, numberOfRowsPerimeter100.toString()));
        perimeter.addCondition(new Condition(ConditionId.FOLDER, folder));
        perimeter.addCondition(new Condition(ConditionId.TYPEOFDEAL, typeOfDeal));

        perimeter.addCondition(new Condition(ConditionId.DATVALMIN, datmin));
        perimeter.addCondition(new Condition(ConditionId.DATVALMAX, datmax));

        return perimeter;
    } // end getPerimeter100()

    public static Perimeter getPerimeterBusinessCase01(final Perimeter perimeter)
    {
        Set<String> idList = new HashSet<String>();
        idList.add(deal1);
        idList.add(deal2);
        perimeter.setIdList(idList);

        return perimeter;
    } // end getPerimeterBusinessCase01()

    public void testTradePerimeter()
    {
        ApplicationContextMessageFactory.springXmlConfiguration = ApplicationContextMessageFactory.springXmlConfigurationTest;

        ApplicationContext context = ApplicationContextMessageFactory.getInstance().getApplicationContext();

        Perimeter perimeter = (Perimeter) context.getBean("tradePerimeterBean");
        perimeter.addCondition(new Condition(ConditionId.MAXROW, "10"));
        perimeter.addCondition(new Condition(ConditionId.FOLDER, folder));
        perimeter.addCondition(new Condition(ConditionId.TYPEOFDEAL, typeOfDeal));

        perimeter.addCondition(new Condition(ConditionId.DATVALMIN, datmin));
        perimeter.addCondition(new Condition(ConditionId.DATVALMAX, datmax));

        Map<String, String> queryParts = perimeter.getQueryParts();
        Set<Entry<String, String>> set = queryParts.entrySet();
        Set<String> keys = new HashSet<String>();

        for (Entry<String, String> entry : set)
        {
            keys.add(entry.getKey());
            Log.getCommonlogger().info(entry.getKey());

            // logger.info(entry.getValue());
        } // end for

        System.out.println("Keys : " + keys);

        Assert.assertTrue(keys.contains("MAXROW"));
        Assert.assertTrue(keys.contains("SELECT"));
        Assert.assertTrue(keys.contains("FROM"));
        Assert.assertTrue(keys.contains("WHERE"));
        Assert.assertTrue(keys.contains("FOLDER"));
        Assert.assertTrue(keys.contains("TYPEOFDEAL"));

        Assert.assertTrue(keys.contains("DATVALMAX"));
        Assert.assertTrue(keys.contains("DATVALMIN"));

        Set<Condition> conditions = perimeter.getConditions();

        for (Condition condition : conditions)
        {
            Log.getCommonlogger().info(condition.getConditionId());
            Log.getCommonlogger().info(condition.getValue());
        } // end for

        Assert.assertTrue(conditions.contains(new Condition(ConditionId.MAXROW, "10")));

        Assert.assertTrue(conditions.contains(new Condition(ConditionId.DATVALMIN, datmin)));
        Assert.assertTrue(conditions.contains(new Condition(ConditionId.DATVALMAX, datmax)));

        perimeter.removeCondition(new Condition(ConditionId.MAXROW, "10"));

        perimeter.removeCondition(new Condition(ConditionId.DATVALMIN, datmin));
        perimeter.removeCondition(new Condition(ConditionId.DATVALMAX, datmax));

        Assert.assertFalse(conditions.contains(new Condition(ConditionId.MAXROW, "10")));

        Assert.assertFalse(conditions.contains(new Condition(ConditionId.DATVALMIN, datmin)));
        Assert.assertFalse(conditions.contains(new Condition(ConditionId.DATVALMAX, datmax)));

        perimeter.addCondition(new Condition(ConditionId.MAXROW, "5"));

        perimeter.addCondition(new Condition(ConditionId.DATVALMIN, "2009-03-20"));

        Assert.assertTrue(conditions.contains(new Condition(ConditionId.MAXROW, "5")));

        Assert.assertTrue(conditions.contains(new Condition(ConditionId.DATVALMIN, "2009-03-20")));
        Assert.assertFalse(conditions.contains(new Condition(ConditionId.DATVALMAX, datmax)));

        String query = perimeter.generateSqlQuery();
        logger.info("Query is :" + query);
        Log.getCommonlogger().info("Query is :" + query);
        Assert.assertNotNull(query);
    } // end testTradePerimeter()
} // end PerimeterTest

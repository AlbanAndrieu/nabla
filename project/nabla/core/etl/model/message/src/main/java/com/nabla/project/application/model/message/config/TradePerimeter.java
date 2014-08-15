package com.nabla.project.application.model.message.config;

import com.nabla.project.application.api.config.Condition;
import com.nabla.project.application.api.config.Condition.ConditionId;
import com.nabla.project.application.api.config.Perimeter;

import org.apache.log4j.Logger;

import java.util.Iterator;

/**
 * Author : $author$ Date : $Date: 2010-06-14 12:02:51 +0200 (Thu, 14 Jun 2010) $ Revision : $revision$
 */
public class TradePerimeter extends Perimeter
{
    private static final long serialVersionUID = 1L;
    private Logger            logger           = Logger.getLogger(getClass());
    private String            dateFormat       = null;

    /**
     * @return the dateFormat
     */
    public String getDateFormat()
    {
        return dateFormat;
    } // end getDateFormat()

    /**
     * @param dateFormat the dateFormat to set
     */
    public void setDateFormat(final String dateFormat)
    {
        this.dateFormat = dateFormat;
    } // end setDateFormat()

    @Override
    public String generateSqlQuery()
    {
        // generate generic part : SELECT, FROM & WHERE
        StringBuilder builder = new StringBuilder();

        // builder.append(queryParts.get("[MAXROW]"));
        // builder.append(" ");

        // generate maxrow part
        for (Iterator iter = conditions.iterator(); iter.hasNext();)
        {
            Condition condition = (Condition) iter.next();
            ConditionId conditionId = condition.getConditionId();

            if (conditionId.equals(ConditionId.MAXROW))
            {
                // maxRowCondition = condition;
                String part = queryParts.get(conditionId.getXmlMapping());

                if (conditionId.getSqlValueName() != null)
                {
                    part = part.replaceFirst(conditionId.getSqlValueName(), condition.getValue());
                } // end if

                builder.append(part);
                builder.append(" ");
            } // end if
        } // end for

        builder.append(queryParts.get(ConditionId.SELECT));
        builder.append(" ");
        builder.append(queryParts.get(ConditionId.FROM));
        builder.append(" ");
        builder.append(queryParts.get(ConditionId.WHERE));
        builder.append(" ");

        logger.info(" Query : " + builder);

        Condition dateMinCondition = null;
        Condition dateMaxCondition = null;

        // generate condition part
        for (Iterator iter = conditions.iterator(); iter.hasNext();)
        {
            Condition condition = (Condition) iter.next();
            ConditionId conditionId = condition.getConditionId();

            logger.info(conditionId.getSqlValueName() + " token replace by " + condition.getValue());

            if (conditionId.equals(ConditionId.DATVALMIN))
            {
                dateMinCondition = condition;
            } // end if
            else if (conditionId.equals(ConditionId.DATVALMAX))
            {
                dateMaxCondition = condition;
            } // end else if
            else if (conditionId.equals(ConditionId.MAXROW))
            {
                logger.debug(ConditionId.MAXROW + " Already done");
            } // end else if
            else
            {
                // System.out.println(condition.getConditionId());
                // System.out.println(queryParts.get(conditionId.getXmlMapping()));
                String part = queryParts.get(conditionId.getXmlMapping());

                if (conditionId.getSqlValueName() != null)
                {
                    part = part.replaceFirst(conditionId.getSqlValueName(), condition.getValue());
                } // end if

                builder.append(part);
                builder.append(" ");
            } // end else
        } // end for

        // generate date part
        String part = "";

        /*
         * if ((dateMinCondition != null) && (dateMaxCondition != null)) {
         * part = queryParts.get("[DATVALMINMAX]");
         * part = part.replaceFirst(dateMinCondition.getConditionId().getSqlValueName(), dateMinCondition.getValue());
         * part = part.replaceFirst(dateMaxCondition.getConditionId().getSqlValueName(), dateMaxCondition.getValue());
         * } else
         */
        if (dateMinCondition != null)
        {
            part = queryParts.get(dateMinCondition.getConditionId().getXmlMapping());
            part = part.replaceFirst(dateMinCondition.getConditionId().getSqlValueName(), dateMinCondition.getValue());
        } // end if
        else if (dateMaxCondition != null)
        {
            // date max != null
            part = queryParts.get(dateMaxCondition.getConditionId().getXmlMapping());
            part = part.replaceFirst(dateMaxCondition.getConditionId().getSqlValueName(), dateMaxCondition.getValue());
        } // end else if
        else
        {
            // no date set ... do nothing
        } // end else

        builder.append(part);

        // add idlist
        if ((idList != null) && (idList.size() > 0))
        {
            // TODO remove hardcoded query part
            builder.append("AND BO.BODeal_Id IN (");

            for (String value : idList)
            {
                builder.append("'" + value + "'");
                builder.append(",");
            } // end for

            // remove last comma
            builder.deleteCharAt(builder.length() - 1);
            builder.append(") ");
        } // end if

        builder.append(queryParts.get(ConditionId.ORDERBY));
        builder.append(" ");

        return builder.toString().replaceAll("\\n", " ");
    } // end generateSqlQuery()

    @Override
    public String generateSqlQueryByIds()
    {
        // TODO Auto-generated method stub
        return null;
    } // end generateSqlQueryByIds()
} // end TradePerimeter

package com.nabla.project.application.model.message.extractor.impl;

import com.nabla.project.application.api.TechnicalException;
import com.nabla.project.application.api.config.Perimeter;
import com.nabla.project.application.api.helpers.PipePublisher;
import com.nabla.project.application.core.flow.extractor.AbstractJavaExtractor;
import com.nabla.project.application.model.message.domain.Party;
import com.nabla.project.application.model.message.domain.Party.PartyType;
import com.nabla.project.application.model.message.domain.Product;
import com.nabla.project.application.model.message.domain.Product.ProductCategory;
import com.nabla.project.application.model.message.domain.Trade;
import com.nabla.project.application.model.message.domain.Trade.TradeDirection;
import com.nabla.project.application.model.message.extractor.common.ReferencesGenerator;

import org.apache.log4j.Logger;

import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.RowCallbackHandler;

import java.math.BigDecimal;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author : $author$ Date : $Date: 2010-06-15 15:20:56 +0200 (Fri, 15 Jun 2010) $ Revision : $revision$
 */
public class DataExtractorTradeImpl<X> extends AbstractJavaExtractor<X> implements DataExtractorTradeImplMBean
{
    private Logger logger = Logger.getLogger(getClass());

    public void extract(final String extractId, final Perimeter perimeter)
    {
        setName(extractId);
        setPerimeter(perimeter);

        String sqlQuery = perimeter.generateSqlQuery();

        if (logger.isDebugEnabled())
        {
            logger.debug("SQL Request = " + sqlQuery);
        } // end if

        try
        {
            getJdbcTemplate().query(sqlQuery.toString(), new TradeRowMapper());
        } // end try
        catch (DataAccessException e)
        {
            throw new TechnicalException("Database connection unvailable", e);
        } // end catch
        finally
        {
            pipeOut.closeQueue();
        } // end finally
    } // end extract()

    protected class TradeRowMapper implements RowCallbackHandler
    {
        boolean firstProcess = true;
        int     columnPurposes_ShortName;
        int     columnPurposes_Name;
        int     columnDealIdFO;
        int     columnBODeal_Id;
        int     columnComments;
        int     columnSecurities_Id;
        int     columnSecurities_Name;
        int     columnSecurities_ShortName;
        int     columnSecuritiesType;
        int     columnValidated;
        int     columnEventDate;
        int     columnInternalStatus;
        int     columnEvent_Id;
        int     columnFolders_Id;
        int     columnCurrencies_Id;
        int     columnTradeDate;
        int     columnValueDate;
        int     columnBuySell;
        int     columnQuantity;
        int     columnPrincipal;
        int     columnPrice;
        int     columnNetPrice;
        int     columnPositionKey_Id;
        int     columnPositionStatus;
        int     columnPositionDate;
        int     columnReversalDate;
        int     columnPositionCfg_Id;
        int     columnPositionCfg_Name;
        int     columnEntity_Id;
        int     columnPositionLevel;
        int     columnChartOfAccount_Id;
        int     columnAccountingGroup_Id;
        int     columnAccGrpInventoryLevel;
        int     columnFoldersGrp_Id;
        int     columnFolGrpInventoryLevel;
        int     columnInventoryMethod;
        int     columnRevaluationType;
        int     columnAccountingRevalMethod;
        int     columnAllowProvisions;
        int     columnPositionDateCfg;
        int     columnSortingCriteria;
        int     columnOpenSenseSorting;
        int     columnReversalProcess;
        int     columnEndOfDay;
        int     columnAccountingMethod;
        int     columnResetAccruedAcquired;
        int     columnLongPositionRevalPrice;
        int     columnShortPositionRevalPrice;
        int     columnPositionSense;
        int     columnUseNativeDeal;
        int     columnUseExternalDeal;
        int     columnCollatAccMethod;
        int     columnUnsettledDeal;

        public final void initialization(final ResultSet rs) throws SQLException
        {
            firstProcess = false;

            columnPurposes_ShortName = rs.findColumn("Scenario");
            columnPurposes_Name = rs.findColumn("Purposes_Name");
            columnDealIdFO = rs.findColumn("DealIdFO");
            columnBODeal_Id = rs.findColumn("BODeal_Id");
            columnComments = rs.findColumn("KtpComment");
            columnSecurities_Id = rs.findColumn("Securities_Id");
            columnSecurities_Name = rs.findColumn("Securities_Name");
            columnSecurities_ShortName = rs.findColumn("Securities_ShortName");
            columnSecuritiesType = rs.findColumn("SecuritiesType");
            columnCurrencies_Id = rs.findColumn("Currencies_Id");
            columnValidated = rs.findColumn("Validated");
            columnEventDate = rs.findColumn("EventDate");
            columnInternalStatus = rs.findColumn("InternalStatus");
            columnEvent_Id = rs.findColumn("Event_Id");
            columnFolders_Id = rs.findColumn("Folders_Id");
            columnTradeDate = rs.findColumn("TradeDate");
            columnValueDate = rs.findColumn("ValueDate");
            columnBuySell = rs.findColumn("BuySell");
            columnQuantity = rs.findColumn("Quantity");
            columnPrincipal = rs.findColumn("Principal");
            columnPrice = rs.findColumn("Price");
            columnNetPrice = rs.findColumn("NetPrice");
            columnPositionKey_Id = rs.findColumn("PositionKey_Id");
            columnPositionStatus = rs.findColumn("PositionStatus");
            columnPositionDate = rs.findColumn("PositionDate");
            columnReversalDate = rs.findColumn("ReversalDate");
            columnPositionCfg_Id = rs.findColumn("PositionCfg_Id");
            columnPositionCfg_Name = rs.findColumn("PositionCfg_Name");
            columnEntity_Id = rs.findColumn("Entity_Id");
            columnPositionLevel = rs.findColumn("PositionLevel");
            columnChartOfAccount_Id = rs.findColumn("ChartOfAccount_Id");
            columnAccountingGroup_Id = rs.findColumn("AccountingGroup_Id");
            columnAccGrpInventoryLevel = rs.findColumn("AccGrpInventoryLevel");
            columnFoldersGrp_Id = rs.findColumn("FoldersGrp_Id");
            columnFolGrpInventoryLevel = rs.findColumn("FolGrpInventoryLevel");
            columnInventoryMethod = rs.findColumn("InventoryMethod");
            columnRevaluationType = rs.findColumn("RevaluationType");
            columnAccountingRevalMethod = rs.findColumn("AccountingRevalMethod");
            columnAllowProvisions = rs.findColumn("AllowProvisions");
            columnPositionDateCfg = rs.findColumn("PositionDateCfg");
            columnSortingCriteria = rs.findColumn("SortingCriteria");
            columnOpenSenseSorting = rs.findColumn("OpenSenseSorting");
            columnReversalProcess = rs.findColumn("ReversalProcess");
            columnEndOfDay = rs.findColumn("EndOfDay");
            columnAccountingMethod = rs.findColumn("AccountingMethod");
            columnResetAccruedAcquired = rs.findColumn("ResetAccruedAcquired");
            columnLongPositionRevalPrice = rs.findColumn("LongPositionRevalPrice");
            columnShortPositionRevalPrice = rs.findColumn("ShortPositionRevalPrice");
            columnPositionSense = rs.findColumn("PositionSense");
            columnUseNativeDeal = rs.findColumn("UseNativeDeal");
            columnUseExternalDeal = rs.findColumn("UseExternalDeal");
            columnCollatAccMethod = rs.findColumn("CollatAccMethod");
            columnUnsettledDeal = rs.findColumn("UnsettledDeal");
        } // end initialization()

        public final void processRow(final ResultSet rs) throws SQLException
        {
            if (firstProcess)
            {
                initialization(rs);
            } // end if

            String tradeId = rs.getString(columnBODeal_Id);
            String portfolioPartyId = rs.getString(columnFolders_Id);
            String productId = rs.getString(columnSecurities_Id);
            String counterPartyId = rs.getString(columnDealIdFO);
            String issuerPartyId = "0";

            String tradeReference = ReferencesGenerator.getTradeRefId(tradeId);
            String productReference = ReferencesGenerator.getProductRefId(tradeId, productId);
            String portfolioPartyReference = ReferencesGenerator.getPartyRefForTrade(tradeId, portfolioPartyId);
            String counterPartyReference = ReferencesGenerator.getPartyRefForTrade(tradeId, counterPartyId);
            String issuerPartyReference = ReferencesGenerator.getPartyRefForProduct(productId, issuerPartyId);

            // initialize trade
            Trade trade = new Trade();
            trade.setReference(tradeReference);
            trade.setProductReference(productReference);
            trade.setCounterPartyReference(counterPartyReference);
            trade.setPortfolioReference(portfolioPartyReference);
            trade.setId(tradeId);

            trade.setIdVersion(rs.getString(columnBODeal_Id));

            trade.setTradeDate(rs.getDate(columnTradeDate));
            trade.setValueDate(rs.getDate(columnValueDate));

            trade.setQuantity(rs.getBigDecimal(columnQuantity));
            trade.setPrice(rs.getBigDecimal(columnPrice));
            trade.setUnderlyingQuotationType("P");
            trade.setNominalAmount(new BigDecimal(0.0));
            trade.setDirtyAmount(new BigDecimal(0.0));
            trade.setCleanAmount(new BigDecimal(0.0));
            trade.setAccruedAmount(new BigDecimal(0.0));

            String tradeDirection = rs.getString(columnBuySell);
            setTradeDirection(trade, tradeDirection);

            trade.setIdFront(rs.getString(columnDealIdFO));
            trade.setApplicationFront("FO");

            // trade.setSaisieFrontDate( rs.getTimestamp( columnId ) );
            // trade.setSystemDate( rs.getTimestamp( columnId ) );

            // add portfolio party to trade
            Party portfolioParty = new Party();
            portfolioParty.setReference(portfolioPartyReference);
            portfolioParty.setId(portfolioPartyId);
            portfolioParty.setIdVersion(portfolioPartyId);
            // portfolioParty.setName( rs.getString( columnFolders_Name ) );
            // portfolioParty.setShortName( rs.getString(
            // columnFolders_ShortName ) );

            // String portfolioPartyType = rs.getString( column ).toUpperCase(
            // );
            setPartyType(portfolioParty, "FD");

            trade.setPortfolioParty(portfolioParty);

            // add counter party to trade
            Party counterParty = new Party();
            counterParty.setReference(counterPartyReference);
            counterParty.setId(counterPartyId);
            counterParty.setIdVersion(counterPartyId);
            // counterParty.setName( rs.getString( column ) );
            // counterParty.setShortName( rs.getString( column ) );
            setPartyType(portfolioParty, "EX");

            trade.setCounterParty(counterParty);

            // add product to trade
            Product product = new Product();
            product.setReference(productReference);
            // product.setPartyReference( issuerPartyReference );
            product.setId(productId);

            product.setName(rs.getString(columnSecurities_Name));
            product.setShortName(rs.getString(columnSecurities_ShortName));
            product.setIdentifiantISIN("1234567890");

            String productCategory = rs.getString(columnSecuritiesType);

            setProductCategory(product, productCategory);

            // product.setStartValidityDate( rs.getDate( column ) );
            // product.setEndValidityDate( rs.getDate( column ) );
            // product.setValuationCurrency( rs.getString( columnCurrencies_Id )
            // );
            // product.setNominalAmount( rs.getBigDecimal( column ) );
            trade.setProduct(product);

            // add party to product
            Party productParty = new Party();

            productParty.setReference(issuerPartyReference);
            productParty.setId(issuerPartyId);
            productParty.setIdVersion(issuerPartyId);
            // productParty.setName( rs.getString( column ) );
            // productParty.setShortName( rs.getString( column ) );
            setPartyType(portfolioParty, "AG");

            product.setIssuerParty(productParty);

            // Send to pipe
            ((PipePublisher<Trade>) pipeOut).publish(trade);

            // Progress status
            counter++;
        } // end processRow()

        private void setProductCategory(final Product product, final String productCategory) throws AssertionError
        {
            char productCategoryChar = ((productCategory != null) && (productCategory.length() > 0)) ? productCategory.toUpperCase().charAt(0) : ' ';

            switch (productCategoryChar)
            {
                case 'E':
                    product.setProductCategory(ProductCategory.SHARE);

                    break;

                case 'B':
                    product.setProductCategory(ProductCategory.BOND);

                    break;

                case 'P':
                    product.setProductCategory(ProductCategory.PAPERS);

                    break;

                case 'F':
                    product.setProductCategory(ProductCategory.FUTURES);

                    break;

                case 'O':
                    product.setProductCategory(ProductCategory.OPTIONS);

                    break;

                default:
                    logger.error("WARNING : " + product.getId() + " Product Category = " + productCategory);
                    throw new AssertionError("Unknown value for Product Category : ");
            } // end switch
        } // end setProductCategory()

        private void setTradeDirection(final Trade trade, final String tradeDirection) throws AssertionError
        {
            char tradeDirectionChar = ((tradeDirection != null) && (tradeDirection.length() > 0)) ? tradeDirection.toUpperCase().charAt(0) : ' ';

            switch (tradeDirectionChar)
            {
                case 'B':
                    trade.setTradeDirection(TradeDirection.BUY);

                    break;

                case 'S':
                    trade.setTradeDirection(TradeDirection.SELL);

                    break;

                default:
                    logger.error("WARNING : " + trade.getId() + " BUY/SELL = " + tradeDirection);
                    throw new AssertionError("Unknown value for BUY/SELL : " + tradeDirection);
            } // end switch
        } // end setTradeDirection()

        private void setPartyType(final Party portfolioParty, final String portfolioPartyType) throws AssertionError
        {
            if ("EX".equals(portfolioPartyType))
            {
                portfolioParty.setType(PartyType.EXTERNAL);
            } // end if
            else if ("AG".equals(portfolioPartyType))
            {
                portfolioParty.setType(PartyType.AGENCY);
            } // end else if
            else if ("FD".equals(portfolioPartyType))
            {
                portfolioParty.setType(PartyType.PORTFOLIO);
            } // end else if
            else
            {
                logger.error("WARNING : " + portfolioParty.getId() + " PartyType = " + portfolioPartyType);
                throw new AssertionError("Unknown value for PartyType : " + portfolioPartyType);
            } // end else
        } // end setPartyType()
    } // end TradeRowMapper
} // end DataExtractorTradeImpl

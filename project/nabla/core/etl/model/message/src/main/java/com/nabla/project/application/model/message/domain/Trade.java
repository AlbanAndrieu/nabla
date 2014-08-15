package com.nabla.project.application.model.message.domain;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Author : $author$ Date : $Date: 2010-06-14 12:02:51 +0200 (Thu, 14 Jun 2010) $ Revision : $revision$
 */
public class Trade
{
    private String     reference;
    private String     productReference;
    private String     portfolioReference;
    private String     counterPartyReference;
    private String     id;
    private String     idVersion;
    private Date       tradeDate;
    private Date       valueDate;
    private Product    product;
    private Party      portfolioParty;
    private Party      counterParty;
    private BigDecimal quantity;
    private BigDecimal price;
    private String     underlyingQuotationType;
    private BigDecimal nominalAmount;
    private BigDecimal dirtyAmount;
    private BigDecimal cleanAmount;
    private BigDecimal accruedAmount;

    public enum TradeDirection
    {
        BUY, SELL, OTHER; // end enum
    } // end enum

    private TradeDirection tradeDirection;
    private String         idFront;
    private String         applicationFront;
    private Date           saisieFrontDate;
    private Date           systemDate;

    /* Specifique */
    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("<Trade id=\"").append(id);
        str.append("\" idVersion=\"").append(idVersion);
        str.append("\" tradeDate=\"").append(tradeDate);
        str.append("\" systemDate=\"").append(systemDate);
        str.append("\" saisieFrontDate=\"").append(saisieFrontDate);
        str.append("\" valueDate=\"").append(valueDate);
        str.append("\" quantity=\"").append(quantity);
        str.append("\" price=\"").append(price);
        str.append("\" tradeDirection=\"").append(tradeDirection);
        str.append("\" applicationFront=\"").append(applicationFront);
        str.append("\" idFront=\"").append(idFront);
        str.append("\" >");
        str.append(product);
        str.append(portfolioParty);
        str.append(counterParty);
        str.append("</Trade>\n");

        return str.toString();
    } // end toString()

    /**
     * @return the id
     */
    public String getId()
    {
        return id;
    } // end getId()

    /**
     * @param id the id to set
     */
    public void setId(final String id)
    {
        this.id = id;
    } // end setId()

    /**
     * @return the applicationFront
     */
    public String getApplicationFront()
    {
        return applicationFront;
    } // end getApplicationFront()

    /**
     * @param applicationFront the applicationFront to set
     */
    public void setApplicationFront(final String applicationFront)
    {
        this.applicationFront = applicationFront;
    } // end setApplicationFront()

    /**
     * @return the idFront
     */
    public String getIdFront()
    {
        return idFront;
    } // end getIdFront()

    /**
     * @param idFront the idFront to set
     */
    public void setIdFront(final String idFront)
    {
        this.idFront = idFront;
    } // end setIdFront()

    /**
     * @return the idVersion
     */
    public String getIdVersion()
    {
        return idVersion;
    } // end getIdVersion()

    /**
     * @param idVersion the idVersion to set
     */
    public void setIdVersion(final String idVersion)
    {
        this.idVersion = idVersion;
    } // end setIdVersion()

    /**
     * @return the price
     */
    public BigDecimal getPrice()
    {
        return price;
    } // end getPrice()

    /**
     * @param price the price to set
     */
    public void setPrice(final BigDecimal price)
    {
        this.price = price;
    } // end setPrice()

    /**
     * @return the quantity
     */
    public BigDecimal getQuantity()
    {
        return quantity;
    } // end getQuantity()

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(final BigDecimal quantity)
    {
        this.quantity = quantity;
    } // end setQuantity()

    /**
     * @return the saisieFrontDate
     */
    public Date getSaisieFrontDate()
    {
        return saisieFrontDate;
    } // end getSaisieFrontDate()

    /**
     * @param saisieFrontDate the saisieFrontDate to set
     */
    public void setSaisieFrontDate(final Date saisieFrontDate)
    {
        this.saisieFrontDate = saisieFrontDate;
    } // end setSaisieFrontDate()

    /**
     * @return the systemDate
     */
    public Date getSystemDate()
    {
        return systemDate;
    } // end getSystemDate()

    /**
     * @param systemDate the systemDate to set
     */
    public void setSystemDate(final Date systemDate)
    {
        this.systemDate = systemDate;
    } // end setSystemDate()

    /**
     * @return the tradeDate
     */
    public Date getTradeDate()
    {
        return tradeDate;
    } // end getTradeDate()

    /**
     * @param tradeDate the tradeDate to set
     */
    public void setTradeDate(final Date tradeDate)
    {
        this.tradeDate = tradeDate;
    } // end setTradeDate()

    /**
     * @return the tradeDirection
     */
    public TradeDirection getTradeDirection()
    {
        return tradeDirection;
    } // end getTradeDirection()

    /**
     * @param tradeDirection the tradeDirection to set
     */
    public void setTradeDirection(final TradeDirection tradeDirection)
    {
        this.tradeDirection = tradeDirection;
    } // end setTradeDirection()

    /**
     * @return the valueDate
     */
    public Date getValueDate()
    {
        return valueDate;
    } // end getValueDate()

    /**
     * @param valueDate the valueDate to set
     */
    public void setValueDate(final Date valueDate)
    {
        this.valueDate = valueDate;
    } // end setValueDate()

    public Party getCounterParty()
    {
        return counterParty;
    } // end getCounterParty()

    public void setCounterParty(final Party counterParty)
    {
        this.counterParty = counterParty;
    } // end setCounterParty()

    public Party getPortfolioParty()
    {
        return portfolioParty;
    } // end getPortfolioParty()

    public void setPortfolioParty(final Party portfolioParty)
    {
        this.portfolioParty = portfolioParty;
    } // end setPortfolioParty()

    public Product getProduct()
    {
        return product;
    } // end getProduct()

    public void setProduct(final Product product)
    {
        this.product = product;
    } // end setProduct()

    public String getCounterPartyReference()
    {
        return counterPartyReference;
    } // end getCounterPartyReference()

    public void setCounterPartyReference(final String counterPartyReference)
    {
        this.counterPartyReference = counterPartyReference;
    } // end setCounterPartyReference()

    public String getPortfolioReference()
    {
        return portfolioReference;
    } // end getPortfolioReference()

    public void setPortfolioReference(final String portfolioReference)
    {
        this.portfolioReference = portfolioReference;
    } // end setPortfolioReference()

    public String getProductReference()
    {
        return productReference;
    } // end getProductReference()

    public void setProductReference(final String productReference)
    {
        this.productReference = productReference;
    } // end setProductReference()

    public String getReference()
    {
        return reference;
    } // end getReference()

    public void setReference(final String reference)
    {
        this.reference = reference;
    } // end setReference()

    public String getUnderlyingQuotationType()
    {
        return underlyingQuotationType;
    } // end getUnderlyingQuotationType()

    public void setUnderlyingQuotationType(final String quotationType)
    {
        this.underlyingQuotationType = quotationType;
    } // end setUnderlyingQuotationType()

    public BigDecimal getNominalAmount()
    {
        return nominalAmount;
    } // end getNominalAmount()

    public void setNominalAmount(final BigDecimal nominalAmount)
    {
        this.nominalAmount = nominalAmount;
    } // end setNominalAmount()

    public BigDecimal getDirtyAmount()
    {
        return dirtyAmount;
    } // end getDirtyAmount()

    public void setDirtyAmount(final BigDecimal dirtyAmountClean)
    {
        this.dirtyAmount = dirtyAmountClean;
    } // end setDirtyAmount()

    public BigDecimal getCleanAmount()
    {
        return cleanAmount;
    } // end getCleanAmount()

    public void setCleanAmount(final BigDecimal cleanAmount)
    {
        this.cleanAmount = cleanAmount;
    } // end setCleanAmount()

    public BigDecimal getAccruedAmount()
    {
        return accruedAmount;
    } // end getAccruedAmount()

    public void setAccruedAmount(final BigDecimal accruedAmount)
    {
        this.accruedAmount = accruedAmount;
    } // end setAccruedAmount()
} // end Trade

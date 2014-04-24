package com.nabla.project.application.model.message.domain;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Author : $author$ Date : $Date: 2010-06-14 12:02:51 +0200 (Thu, 14 Jun 2010) $ Revision : $revision$
 */
public class Product
{
    private String reference;
    private String partyReference;
    private String id;
    private String name;
    private String shortName;
    private String identifiantISIN;

    public enum ProductCategory
    {
        BOND, SHARE, PAPERS, FUTURES, OPTIONS, OTHER; // end enum
    } // end enum

    private ProductCategory productCategory;
    private Date            startValidityDate;
    private Date            endValidityDate;
    private String          valuationCurrency;
    private BigDecimal      nominalAmount;
    private Party           issuerParty;

    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("<Product id=\"").append(id);
        str.append("\" name=\"").append(name);
        str.append("\" shortName=\"").append(productCategory);
        str.append("\" startValidityDate=\"").append(startValidityDate);
        str.append("\" endValidityDate=\"").append(endValidityDate);
        str.append("\" valuationCurrency=\"").append(valuationCurrency);
        str.append("\" nominalAmount=\"").append(nominalAmount);
        str.append("\" reference=\"").append(reference);
        str.append("\" partyReference=\"").append(partyReference);
        str.append("\" shortName=\"").append(shortName);
        str.append("\" >");
        str.append(issuerParty);
        str.append("</Product>\n");

        return str.toString();
    } // end toString()

    public String getId()
    {
        return id;
    } // end getId()

    public void setId(final String id)
    {
        this.id = id;
    } // end setId()

    public Date getStartValidityDate()
    {
        return startValidityDate;
    } // end getStartValidityDate()

    public void setStartValidityDate(final Date startValidityDate)
    {
        this.startValidityDate = startValidityDate;
    } // end setStartValidityDate()

    public Date getEndValidityDate()
    {
        return endValidityDate;
    } // end getEndValidityDate()

    public void setEndValidityDate(final Date endValidityDate)
    {
        this.endValidityDate = endValidityDate;
    } // end setEndValidityDate()

    public ProductCategory getProductCategory()
    {
        return productCategory;
    } // end getProductCategory()

    public void setProductCategory(final ProductCategory productCategory)
    {
        this.productCategory = productCategory;
    } // end setProductCategory()

    public String getShortName()
    {
        return shortName;
    } // end getShortName()

    public void setShortName(final String shortName)
    {
        this.shortName = shortName;
    } // end setShortName()

    /**
     * 
     * @return the valuationCurrency
     */
    public String getValuationCurrency()
    {
        return valuationCurrency;
    } // end getValuationCurrency()

    /**
     * 
     * @param valuationCurrency the valuationCurrency to set
     */
    public void setValuationCurrency(final String valuationCurrency)
    {
        this.valuationCurrency = valuationCurrency;
    } // end setValuationCurrency()

    /**
     * 
     * @return the nominalAmount
     */
    public BigDecimal getNominalAmount()
    {
        return nominalAmount;
    } // end getNominalAmount()

    /**
     * 
     * @param nominalAmount the nominalAmount to set
     */
    public void setNominalAmount(final BigDecimal nominalAmount)
    {
        this.nominalAmount = nominalAmount;
    } // end setNominalAmount()

    /**
     * 
     * @return the name
     */
    public String getName()
    {
        return name;
    } // end getName()

    /**
     * 
     * @param name the name to set
     */
    public void setName(final String name)
    {
        this.name = name;
    } // end setName()

    public Party getIssuerParty()
    {
        return issuerParty;
    } // end getIssuerParty()

    public void setIssuerParty(final Party issuerParty)
    {
        this.issuerParty = issuerParty;
    } // end setIssuerParty()

    public String getReference()
    {
        return reference;
    } // end getReference()

    public void setReference(final String reference)
    {
        this.reference = reference;
    } // end setReference()

    public String getIssuerPartyReference()
    {
        return partyReference;
    } // end getIssuerPartyReference()

    public void setPartyReference(final String partyReference)
    {
        this.partyReference = partyReference;
    } // end setPartyReference()

    public String getIdentifiantISIN()
    {
        return identifiantISIN;
    } // end getIdentifiantISIN()

    public void setIdentifiantISIN(final String identifiantISIN)
    {
        this.identifiantISIN = identifiantISIN;
    } // end setIdentifiantISIN()
} // end Product

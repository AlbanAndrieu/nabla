package com.nabla.project.application.model.message.transformer;

import com.nabla.project.application.api.transformer.TransformerDataInterface;
import com.nabla.project.application.model.xml.ObjectFactory;

import javax.xml.namespace.QName;

/**
 * Author : $author$ Date : $Date: 2010-06-14 12:02:51 +0200 (Thu, 14 Jun 2010) $ Revision : $revision$
 */

// FIXME find a way to move this interface to the project ExtractServiceFwk
public abstract class ModelTransformer implements TransformerDataInterface
{
    protected ObjectFactory XMLfactory                     = new ObjectFactory();
    public static String    BACK_TRADE_VERSION_SCHEME      = "4.10";
    public static String    BACK_TRADE_SCHEME              = "backTrade";
    public static String    FRONT_APPLICATION_SCHEME       = "frontApplication";
    public static String    FRONT_TRADE_SCHEME             = "frontTrade";
    public static String    BACK_PRODUCT_SCHEME            = "backProduct";
    public static String    BACK_PORTFOLIO_SCHEME          = "backPortfolio";
    public static String    BACK_PARTY_SCHEME              = "backParty";
    public static String    BACK_EXTERNALPARTY_SCHEME      = "backExternalParty";
    public static String    BACK_UNKNOWN_SCHEME            = "otherParty";
    public static String    BACK_ISSUER_SCHEME             = "backIssuer";
    public static String    REFERENTIAL_APPLICATION_SCHEME = "referencialApplication";
    public static String    BACK_PRODUCT_CODE_SCHEME       = "ISIN";
    public static String    PRODUCT_QNAME_VALUE            = "INS:product";
    public static QName     PRODUCT_QNAME                  = new QName(PRODUCT_QNAME_VALUE);
    public static String    TRADE_QNAME_VALUE              = "INS:trade";
    public static QName     TRADE_QNAME                    = new QName(TRADE_QNAME_VALUE);
    public static String    PARTY_QNAME_VALUE              = "INS:party";
    public static QName     PARTY_QNAME                    = new QName(PARTY_QNAME_VALUE);

    /*
     * public static String BDR_SCHEME = "BDR";
     * public static String BDR_PORTFOLIO_SCHEME = "BDRPortfolio";
     * public static String BDR_EXTERNALPARTY_SCHEME = "BDRExternalParty";
     */
    /**
     * @return the BACK_TRADE_VERSION_SCHEME
     */
    public String getBACK_TRADE_VERSION_SCHEME()
    {
        return BACK_TRADE_VERSION_SCHEME;
    } // end getBACK_TRADE_VERSION_SCHEME()

    /**
     * @param back_trade_version_scheme the BACK_TRADE_VERSION_SCHEME to set
     */
    public void setBACK_TRADE_VERSION_SCHEME(final String back_trade_version_scheme)
    {
        BACK_TRADE_VERSION_SCHEME = back_trade_version_scheme;
    } // end setBACK_TRADE_VERSION_SCHEME()

    /**
     * @return the BDR_EXTERNALPARTY_SCHEME
     */

    /*
     * public String getBDR_EXTERNALPARTY_SCHEME() {
     * return BDR_EXTERNALPARTY_SCHEME;
     * }
     */
    /**
     * 
     */

    /*
     * public void setBDR_EXTERNALPARTY_SCHEME(String bdr_externalparty_scheme) {
     * BDR_EXTERNALPARTY_SCHEME = bdr_externalparty_scheme;
     * }
     */
    /**
     * @return the BDR_PORTFOLIO_SCHEME
     */

    /*
     * public String getBDR_PORTFOLIO_SCHEME() {
     * return BDR_PORTFOLIO_SCHEME;
     * }
     */
    /**
     * 
     */

    /*
     * public void setBDR_PORTFOLIO_SCHEME(String bdr_portfolio_scheme) {
     * BDR_PORTFOLIO_SCHEME = bdr_portfolio_scheme;
     * }
     */

    /**
     * @return the BACK_EXTERNALPARTY_SCHEME
     */
    public String getBACK_EXTERNALPARTY_SCHEME()
    {
        return BACK_EXTERNALPARTY_SCHEME;
    } // end getBACK_EXTERNALPARTY_SCHEME()

    /**
     * @param back_externalparty_scheme the BACK_EXTERNALPARTY_SCHEME to set
     */
    public void setBACK_EXTERNALPARTY_SCHEME(final String back_externalparty_scheme)
    {
        BACK_EXTERNALPARTY_SCHEME = back_externalparty_scheme;
    } // end setBACK_EXTERNALPARTY_SCHEME()

    /**
     * @return the BACK_ISSUER_SCHEME
     */
    public String getBACK_ISSUER_SCHEME()
    {
        return BACK_ISSUER_SCHEME;
    } // end getBACK_ISSUER_SCHEME()

    /**
     * @param back_issuer_scheme the BACK_ISSUER_SCHEME to set
     */
    public void setBACK_ISSUER_SCHEME(final String back_issuer_scheme)
    {
        BACK_ISSUER_SCHEME = back_issuer_scheme;
    } // end setBACK_ISSUER_SCHEME()

    /**
     * @return the BACK_PARTY_SCHEME
     */
    public String getBACK_PARTY_SCHEME()
    {
        return BACK_PARTY_SCHEME;
    } // end getBACK_PARTY_SCHEME()

    /**
     * @param back_party_scheme the BACK_PARTY_SCHEME to set
     */
    public void setBACK_PARTY_SCHEME(final String back_party_scheme)
    {
        BACK_PARTY_SCHEME = back_party_scheme;
    } // end setBACK_PARTY_SCHEME()

    /**
     * @return the BACK_PORTFOLIO_SCHEME
     */
    public String getBACK_PORTFOLIO_SCHEME()
    {
        return BACK_PORTFOLIO_SCHEME;
    } // end getBACK_PORTFOLIO_SCHEME()

    /**
     * @param back_portfolio_scheme the BACK_PORTFOLIO_SCHEME to set
     */
    public void setBACK_PORTFOLIO_SCHEME(final String back_portfolio_scheme)
    {
        BACK_PORTFOLIO_SCHEME = back_portfolio_scheme;
    } // end setBACK_PORTFOLIO_SCHEME()

    /**
     * @return the BACK_PRODUCT_SCHEME
     */
    public String getBACK_PRODUCT_SCHEME()
    {
        return BACK_PRODUCT_SCHEME;
    } // end getBACK_PRODUCT_SCHEME()

    /**
     * @param back_product_scheme the BACK_PRODUCT_SCHEME to set
     */
    public void setBACK_PRODUCT_SCHEME(final String back_product_scheme)
    {
        BACK_PRODUCT_SCHEME = back_product_scheme;
    } // end setBACK_PRODUCT_SCHEME()

    /**
     * @return the BACK_TRADE_SCHEME
     */
    public String getBACK_TRADE_SCHEME()
    {
        return BACK_TRADE_SCHEME;
    } // end getBACK_TRADE_SCHEME()

    /**
     * @param back_trade_scheme the BACK_TRADE_SCHEME to set
     */
    public void setBACK_TRADE_SCHEME(final String back_trade_scheme)
    {
        BACK_TRADE_SCHEME = back_trade_scheme;
    } // end setBACK_TRADE_SCHEME()

    /**
     * @return the FRONT_APPLICATION_SCHEME
     */
    public String getFRONT_APPLICATION_SCHEME()
    {
        return FRONT_APPLICATION_SCHEME;
    } // end getFRONT_APPLICATION_SCHEME()

    /**
     * @param front_application_scheme the FRONT_APPLICATION_SCHEME to set
     */
    public void setFRONT_APPLICATION_SCHEME(final String front_application_scheme)
    {
        FRONT_APPLICATION_SCHEME = front_application_scheme;
    } // end setFRONT_APPLICATION_SCHEME()

    /**
     * @return the FRONT_TRADE_SCHEME
     */
    public String getFRONT_TRADE_SCHEME()
    {
        return FRONT_TRADE_SCHEME;
    } // end getFRONT_TRADE_SCHEME()

    /**
     * @param front_trade_scheme the FRONT_TRADE_SCHEME to set
     */
    public void setFRONT_TRADE_SCHEME(final String front_trade_scheme)
    {
        FRONT_TRADE_SCHEME = front_trade_scheme;
    } // end setFRONT_TRADE_SCHEME()

    /**
     * @return the REFERENTIAL_APPLICATION_SCHEME
     */
    public String getREFERENTIAL_APPLICATION_SCHEME()
    {
        return REFERENTIAL_APPLICATION_SCHEME;
    } // end getREFERENTIAL_APPLICATION_SCHEME()

    /**
     * @param referential_application_scheme the REFERENTIAL_APPLICATION_SCHEME to set
     */
    public void setREFERENTIAL_APPLICATION_SCHEME(final String referential_application_scheme)
    {
        REFERENTIAL_APPLICATION_SCHEME = referential_application_scheme;
    } // end setREFERENTIAL_APPLICATION_SCHEME()

    /**
     * @return the TRADE_QNAME
     */
    public QName getTRADE_QNAME()
    {
        return TRADE_QNAME;
    } // end getTRADE_QNAME()

    /**
     * @param trade_qname the TRADE_QNAME to set
     */
    public void setTRADE_QNAME(final QName trade_qname)
    {
        TRADE_QNAME = trade_qname;
    } // end setTRADE_QNAME()

    /**
     * @param trade_qname the TRADE_QNAME to set
     */
    public void setTRADE_QNAME(final String trade_qname)
    {
        TRADE_QNAME = new QName(trade_qname);
    } // end setTRADE_QNAME()

    /**
     * @return the PARTY_QNAME
     */
    public QName getPARTY_QNAME()
    {
        return PARTY_QNAME;
    } // end getPARTY_QNAME()

    /**
     * @param party_qname the PARTY_QNAME to set
     */
    public void setPARTY_QNAME(final QName party_qname)
    {
        PARTY_QNAME = party_qname;
    } // end setPARTY_QNAME()

    /**
     * @param party_qname the PARTY_QNAME to set
     */
    public void setPARTY_QNAME(final String party_qname)
    {
        PARTY_QNAME = new QName(party_qname);
    } // end setPARTY_QNAME()

    /**
     * @return the PRODUCT_QNAME
     */
    public QName getPRODUCT_QNAME()
    {
        return PRODUCT_QNAME;
    } // end getPRODUCT_QNAME()

    /**
     * @param product_qname the PRODUCT_QNAME to set
     */
    public void setPRODUCT_QNAME(final QName product_qname)
    {
        PRODUCT_QNAME = product_qname;
    } // end setPRODUCT_QNAME()

    /**
     * @param product_qname the PRODUCT_QNAME to set
     */
    public void setPRODUCT_QNAME(final String product_qname)
    {
        PRODUCT_QNAME = new QName(product_qname);
    } // end setPRODUCT_QNAME()

    /**
     * @return the PARTY_QNAME_VALUE
     */
    public String getPARTY_QNAME_VALUE()
    {
        return PARTY_QNAME_VALUE;
    } // end getPARTY_QNAME_VALUE()

    /**
     * @param party_qname_value the PARTY_QNAME_VALUE to set
     */
    public void setPARTY_QNAME_VALUE(final String party_qname_value)
    {
        PARTY_QNAME_VALUE = party_qname_value;
        setPARTY_QNAME(party_qname_value);
    } // end setPARTY_QNAME_VALUE()

    /**
     * @return the PRODUCT_QNAME_VALUE
     */
    public String getPRODUCT_QNAME_VALUE()
    {
        return PRODUCT_QNAME_VALUE;
    } // end getPRODUCT_QNAME_VALUE()

    /**
     * @param product_qname_value the PRODUCT_QNAME_VALUE to set
     */
    public void setPRODUCT_QNAME_VALUE(final String product_qname_value)
    {
        PRODUCT_QNAME_VALUE = product_qname_value;
        setPRODUCT_QNAME(product_qname_value);
    } // end setPRODUCT_QNAME_VALUE()

    /**
     * @return the TRADE_QNAME_VALUE
     */
    public String getTRADE_QNAME_VALUE()
    {
        return TRADE_QNAME_VALUE;
    } // end getTRADE_QNAME_VALUE()

    /**
     * @param trade_qname_value the TRADE_QNAME_VALUE to set
     */
    public void setTRADE_QNAME_VALUE(final String trade_qname_value)
    {
        TRADE_QNAME_VALUE = trade_qname_value;
        setTRADE_QNAME(trade_qname_value);
    } // end setTRADE_QNAME_VALUE()
} // end ModelTransformer

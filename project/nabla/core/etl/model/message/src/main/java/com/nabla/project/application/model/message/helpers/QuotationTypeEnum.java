package com.nabla.project.application.model.message.helpers;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "underlyingInstrumentTypeScheme", namespace = "urn:xml:DGEN_ReferentialGeneric:1_0_3")
@XmlEnum
/**
 * Author : $author$
 * Date : $Date: 2010-06-14 12:02:51 +0200 (Thu, 14 Jun 2010) $
 * Revision : $revision$
 *
 */
public enum QuotationTypeEnum
{
    PERCENT("%", "%"), PRICE("P", "Price"), YIELD("Y", "Yield");
    private final String databaseValue;
    private final String xmlValue;

    /**
         * Creates a new QuotationTypeEnum object.
         *
         * @param dbV DOCUMENT ME!
         * @param xmlV DOCUMENT ME!
         */
    QuotationTypeEnum(String dbV, String xmlV)
    {
        databaseValue = dbV;
        xmlValue = xmlV;
    } // end QuotationTypeEnum()

    public String databaseValue()
    {
        return databaseValue;
    } // end databaseValue()

    public String xmlValue()
    {
        return xmlValue;
    } // end xmlValue()
} // end enum

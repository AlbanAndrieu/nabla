package com.nabla.project.application.model.message.writer;

import com.nabla.project.application.api.writer.WriterDataInterface;

/**
 * Author : $author$ Date : $Date: 2010-06-14 12:02:51 +0200 (Thu, 14 Jun 2010) $ Revision : $revision$
 */
public abstract class ModelWriter implements WriterDataInterface
{
    public static String  XML_HEADER;                // = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
    public static String  XML_NAMESPACE_HEADER_START; // = "<MAI:XML_trade_template";
    public static String  XML_NAMESPACE_HEADER_BODY;
    /* public static String XML_NAMESPACE_HEADER_VALIDATION; */
    public static boolean isUsingValidation = false;
    public static String  XML_NAMESPACE_HEADER_END;  /*
                                                       * =
                                                       * "xmlns=\"urn:xml:nabla_Service:1_1_7\" " +
                                                       * "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
                                                       * "xsi:schemaLocation=\"urn:xml:nabla_Service:1_1_7 ..\\xml\\XML_root.xsd\"" +
                                                       * ">";
                                                       */

    /* "xsi:noNamespaceSchemaLocation=\"..\\xml\\XML_root.xsd\"" */
    public static String  XML_NAMESPACE_FOOTER;      // = "</MAI:XML_trade_template>";

    // Use by test only
    public static String  XML_ROOT_START;            // = "<SGEDINS:endOfDayTradeEvent>";
    // Use by test only
    public static String  XML_ROOT_END;              // = "</SGEDINS:endOfDayTradeEvent>";

    /* public static NamespacePrefixMapperWriter namespaces; */

    /**
     * @return the xML_HEADER
     */
    public String getXML_HEADER()
    {
        return XML_HEADER;
    } // end getXML_HEADER()

    /**
     * @param xml_header the xML_HEADER to set
     */
    public void setXML_HEADER(final String xml_header)
    {
        XML_HEADER = xml_header;
    } // end setXML_HEADER()

    /**
     * @return the XML_NAMESPACE_FOOTER
     */
    public String getXML_NAMESPACE_FOOTER()
    {
        return XML_NAMESPACE_FOOTER;
    } // end getXML_NAMESPACE_FOOTER()

    /**
     * @param xml_namespace_footer the XML_NAMESPACE_FOOTER to set
     */
    public void setXML_NAMESPACE_FOOTER(final String xml_namespace_footer)
    {
        XML_NAMESPACE_FOOTER = xml_namespace_footer;
    } // end setXML_NAMESPACE_FOOTER()

    /**
     * @return the XML_NAMESPACE_HEADER_END
     */
    public String getXML_NAMESPACE_HEADER_END()
    {
        return XML_NAMESPACE_HEADER_END;
    } // end getXML_NAMESPACE_HEADER_END()

    /**
     * @param xml_namespace_header_end the XML_NAMESPACE_HEADER_END to set
     */
    public void setXML_NAMESPACE_HEADER_END(final String xml_namespace_header_end)
    {
        XML_NAMESPACE_HEADER_END = xml_namespace_header_end;
    } // end setXML_NAMESPACE_HEADER_END()

    /**
     * @return the XML_NAMESPACE_HEADER_START
     */
    public String getXML_NAMESPACE_HEADER_START()
    {
        return XML_NAMESPACE_HEADER_START;
    } // end getXML_NAMESPACE_HEADER_START()

    /**
     * @param xml_namespace_header_start the XML_NAMESPACE_HEADER_START to set
     */
    public void setXML_NAMESPACE_HEADER_START(final String xml_namespace_header_start)
    {
        XML_NAMESPACE_HEADER_START = xml_namespace_header_start;
    } // end setXML_NAMESPACE_HEADER_START()

    /**
     * @return the namespaces
     */
    /*
     * public NamespacePrefixMapperWriter getNamespaces()
     * {
     * return namespaces;
     * } // end getNamespaces()
     */
    /**
     * @param namespaces the namespaces to set
     */
    /*
     * public void setNamespaces(final NamespacePrefixMapperWriter namespaces)
     * {
     * this.namespaces = namespaces;
     * } // end setNamespaces()
     */
    /**
     * @return the xML_ROOT_END
     */
    public String getXML_ROOT_END()
    {
        return XML_ROOT_END;
    } // end getXML_ROOT_END()

    /**
     * @param xml_root_end the xML_ROOT_END to set
     */
    public void setXML_ROOT_END(final String xml_root_end)
    {
        XML_ROOT_END = xml_root_end;
    } // end setXML_ROOT_END()

    /**
     * @return the xML_ROOT_START
     */
    public String getXML_ROOT_START()
    {
        return XML_ROOT_START;
    } // end getXML_ROOT_START()

    /**
     * @param xml_root_start the xML_ROOT_START to set
     */
    public void setXML_ROOT_START(final String xml_root_start)
    {
        XML_ROOT_START = xml_root_start;
    } // end setXML_ROOT_START()

    /**
     * @return the XML_NAMESPACE_HEADER_BODY
     */
    public String getXML_NAMESPACE_HEADER_BODY()
    {
        return XML_NAMESPACE_HEADER_BODY;
    } // end getXML_NAMESPACE_HEADER_BODY()

    /**
     * @param xml_namespace_header_body the XML_NAMESPACE_HEADER_BODY to set
     */
    public void setXML_NAMESPACE_HEADER_BODY(final String xml_namespace_header_body)
    {
        XML_NAMESPACE_HEADER_BODY = xml_namespace_header_body;
    } // end setXML_NAMESPACE_HEADER_BODY()

    /**
     * @return the XML_NAMESPACE_HEADER_VALIDATION
     */
    /*
     * public String getXML_NAMESPACE_HEADER_VALIDATION()
     * {
     * return XML_NAMESPACE_HEADER_VALIDATION;
     * } // end getXML_NAMESPACE_HEADER_VALIDATION()
     *//**
     * @param xml_namespace_header_validation the XML_NAMESPACE_HEADER_VALIDATION to set
     */
    /*
     * public void setXML_NAMESPACE_HEADER_VALIDATION(final String xml_namespace_header_validation)
     * {
     * XML_NAMESPACE_HEADER_VALIDATION = xml_namespace_header_validation;
     * } // end setXML_NAMESPACE_HEADER_VALIDATION()
     */
    /**
     * @return the isUsingValidation
     */
    public boolean isUsingValidation()
    {
        return isUsingValidation;
    } // end isUsingValidation()

    /**
     * @param isUsingValidation the isUsingValidation to set
     */
    public void setUsingValidation(final boolean isUsingValidation)
    {
        this.isUsingValidation = isUsingValidation;
    } // end setUsingValidation()
} // end ModelWriter

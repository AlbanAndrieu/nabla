package com.nabla.project.application.model.message.writer.impl;

import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import org.apache.log4j.Logger;

import com.nabla.project.application.api.TechnicalException;
import com.nabla.project.application.api.config.Destination;
import com.nabla.project.application.api.config.Packaging;
import com.nabla.project.application.api.writer.WriterDataInterface;
import com.nabla.project.application.core.spring.MessageConfig;
import com.nabla.project.application.model.message.domain.ObjectContainer;
import com.nabla.project.application.model.message.writer.ModelWriter;

/**
 * Author : $author$ Date : $Date: 2010-06-20 17:01:12 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$
 */
public class WriterContainerTradeJaxb extends ModelWriter implements WriterDataInterface, ValidationEventHandler, WriterContainerTradeJaxbMBean
{
    protected static Logger   logger         = Logger.getLogger(WriterContainerTradeJaxb.class);
    protected boolean         jaxbValidation = MessageConfig.getInstance().isValidationXmlOutput();
    protected JAXBContext     jaxbContext    = null;
    protected Marshaller      marshaller;
    protected Destination     output;
    protected OutputStream    oStream;
    protected XMLStreamWriter writer;

    public boolean isJaxbValidation()
    {
        return jaxbValidation;
    } // end isJaxbValidation()

    public void setJaxbValidation(final boolean jaxbValidation)
    {
        this.jaxbValidation = jaxbValidation;
    } // end setJaxbValidation()

    public void open(final Destination output, final Packaging packaging)
    {
        if (logger.isDebugEnabled())
        {
            logger.debug("open(" + output + "," + packaging + ")");
        } // end if

        try
        {
            this.output = output;
            this.oStream = output.getOutputStream(packaging);
            this.writer = XMLOutputFactory.newFactory().createXMLStreamWriter(this.oStream);

            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("MAI", "XML_trade_template", "urn:nabla:Nabla_Service:1_0_0");
            // writer.writeAttribute("xmlns", "urn:nabla:Nabla_Service:1_0_0");
            writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeNamespace("MAI", "urn:nabla:Nabla_Service:1_0_0");
            writer.writeNamespace("TRD", "urn:nabla:A_XML_Trade:1_0_0");
            writer.writeNamespace("THD", "urn:nabla:A_XML_TradeHeader:1_0_0");
            writer.writeNamespace("GEN", "urn:nabla:A_XML_TradingGeneric:1_0_0");
            writer.writeNamespace("TCD", "urn:nabla:A_XML_TradeConditions:1_0_0");
            writer.writeNamespace("TPI", "urn:nabla:A_XML_TradePartyInfo:1_0_0");
            writer.writeNamespace("INS", "urn:nabla:A_XML_InstrumentService:1_0_0");
            writer.writeNamespace("PHD", "urn:nabla:A_XML_ProductHeader:1_0_0");
            writer.writeNamespace("PTY", "urn:nabla:A_XML_TradingParty:1_0_0");
            writer.writeNamespace("REF", "urn:nabla:A_XML_ReferentialGeneric:1_0_0");
            // writer.writeStartElement("WorkSets");

            /*
             * StringBuilder rootBuilder = new StringBuilder();
             * rootBuilder.append(XML_HEADER);
             * rootBuilder.append(XML_NAMESPACE_HEADER_START);
             * for (int i = 0; i < namespaces.getContextualNamespaceDecls().length; i++)
             * {
             * rootBuilder.append(" xmlns:"); //keep the space before 'xmlns'
             * rootBuilder.append(namespaces.getContextualNamespaceDecls()[i++]);
             * rootBuilder.append("=\"");
             * rootBuilder.append(namespaces.getContextualNamespaceDecls()[i]);
             * rootBuilder.append("\"");
             * } // end for
             * rootBuilder.append(" " + XML_NAMESPACE_HEADER_BODY);
             * if (isUsingValidation)
             * {
             * rootBuilder.append(" " + XML_NAMESPACE_HEADER_VALIDATION);
             * } // end if
             * rootBuilder.append(" " + XML_NAMESPACE_HEADER_END);
             * this.oStream.write(rootBuilder.toString().getBytes());
             */

            marshaller = jaxbContext.createMarshaller();

            // Set marshaller properties
            if (!jaxbValidation)
            {
                marshaller.setEventHandler(this);
            } // end if

            marshaller.setProperty("jaxb.fragment", true);
            // marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", namespaces);
        } // end try
        catch (Exception e)
        {
            throw new TechnicalException("Exception in Writer", e);
        } // end catch
    } // end open()

    public void write(final Object destinationModel)
    {
        ObjectContainer container = (ObjectContainer) destinationModel;
        writeJaxb(container.getTrade());

        // writeJaxb(container.getProduct());
    } // end write()

    public void writeJaxb(final Object destinationModel)
    {
        try
        {
            marshaller.marshal(destinationModel, this.writer /* this.oStream */);
        } // end try
        catch (JAXBException e)
        {
            throw new TechnicalException("Exception in Writer", e);
        } // end catch
    } // end writeJaxb()

    /*
     * public void writeString(final String data)
     * {
     * if (logger.isDebugEnabled())
     * {
     * logger.debug("writeString");
     * } // end if
     * try
     * {
     * this.oStream.write(data.getBytes());
     * } // end try
     * catch (Exception e)
     * {
     * throw new TechnicalException("Exception in Writer", e);
     * } // end catch
     * } // end writeString()
     */
    public void close()
    {
        if (logger.isDebugEnabled())
        {
            logger.debug("close " + output);
        } // end if

        try
        {
            /*
             * String root = XML_NAMESPACE_FOOTER;
             * this.oStream.write(root.getBytes());
             */
            /*
             * this.oStream.flush();
             * this.oStream.close();
             * this.oStream = null;
             */

            writer.writeEndDocument();
            writer.close();
        } // end try
        /*
         * catch (IOException e)
         * {
         * logger.error(e + " output=" + output);
         * throw new TechnicalException("Exception in Writer", e);
         * } // end catch
         */catch (Exception e)
        {
            throw new TechnicalException("Exception in Writer", e);
        } // end catch
    } // end close()

    public void setJaxbContext(final JAXBContext jaxbContext)
    {
        this.jaxbContext = jaxbContext;
    } // end setJaxbContext()

    public final boolean handleEvent(final ValidationEvent event)
    {
        return true;
    } // end handleEvent()
} // end WriterContainerTradeJaxb

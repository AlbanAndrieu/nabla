package com.nabla.project.application.model.message.helpers;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

/**
 * Author : $author$ Date : $Date: 2010-06-14 12:02:51 +0200 (Thu, 14 Jun 2010) $ Revision : $revision$
 */
public class XmlValidator
{
    protected String    schemaFileName;
    protected Schema    schema;
    protected Validator validator;

    public XmlValidator(String schemaFileName) throws SAXException
    {
        this.schemaFileName = schemaFileName;
        initialization();
    } // end XmlValidator()

    protected void initialization() throws SAXException
    {
        // <SCHEMA LANGUAGE> could be W3C XML Schema, Relax NG etc.
        // SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.XMLNS_ATTRIBUTE_NS_URI);
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        // load a WXS schema, represented by a Schema instance
        schema = schemaFactory.newSchema(new StreamSource(new File(schemaFileName)));
        // Create a Validator which can be used to validate instance document against this schema(s)
        validator = schema.newValidator();
    } // end initialization()

    public void validate(final InputStream inputStreamXml) throws SAXException, IOException
    {
        validator.validate(new StreamSource(inputStreamXml));
    } // end validate()
} // end XmlValidator

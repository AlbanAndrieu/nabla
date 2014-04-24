/*
 * Copyright (c) 2002-2004, Nabla
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Nabla' nor 'Alban' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package com.nabla.project.application.model.message.xml;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * DOCUMENT ME!
 *
 * @author $Author$
 * @version $Revision$
 * @since $Date$
  */
public class JaxbDateHelper
{

    /**
     * DOCUMENT ME!
     */
    public static Logger           logger = Logger.getLogger(JaxbDateHelper.class);
    private static DatatypeFactory myDataTypeFactory;

    static
    {

        Logger logger = Logger.getLogger(JaxbDateHelper.class);

        try
        {

            logger.info("Initializing DatatypeFactory");
            myDataTypeFactory = DatatypeFactory.newInstance();

        }
        catch (DatatypeConfigurationException e)
        {

            logger.error("DatatypeFactory initialsation exception");
            e.printStackTrace();
            throw new RuntimeException("Unable to initialize DatatypeFactory", e);

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @param date DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static XMLGregorianCalendar getJaxbDate(Date date)
    {

        if (date != null)
        {

            GregorianCalendar gCal = new GregorianCalendar();

            gCal.setTime(date);

            XMLGregorianCalendar xmlCal = myDataTypeFactory.newXMLGregorianCalendar(gCal);

            xmlCal.setHour(DatatypeConstants.FIELD_UNDEFINED);
            xmlCal.setMinute(DatatypeConstants.FIELD_UNDEFINED);
            xmlCal.setSecond(DatatypeConstants.FIELD_UNDEFINED);

            return xmlCal;

        } else
        {

            return null;

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @param date DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static XMLGregorianCalendar getJaxbTime(Date date)
    {

        if (date != null)
        {

            GregorianCalendar gCal = new GregorianCalendar();

            gCal.setTime(date);

            XMLGregorianCalendar xmlCal = myDataTypeFactory.newXMLGregorianCalendar(gCal);

            xmlCal.setDay(DatatypeConstants.FIELD_UNDEFINED);
            xmlCal.setMonth(DatatypeConstants.FIELD_UNDEFINED);
            xmlCal.setYear(DatatypeConstants.FIELD_UNDEFINED);

            return xmlCal;

        } else
        {

            return null;

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @param date DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static XMLGregorianCalendar getJaxbDateTime(Date date)
    {

        if (date != null)
        {

            GregorianCalendar gCal = new GregorianCalendar();

            gCal.setTime(date);

            XMLGregorianCalendar xmlCal = myDataTypeFactory.newXMLGregorianCalendar(gCal);

            return xmlCal;

        } else
        {

            return null;

        }

    }

}

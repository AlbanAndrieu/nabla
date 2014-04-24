package com.nabla.project.application.model.message.config;

import com.nabla.project.application.api.config.Destination;

import junit.framework.TestCase;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Author : $author$ Date : $Date: 2010-06-14 12:02:51 +0200 (Thu, 14 Jun 2010) $ Revision : $revision$
 */
public class DestinationByteArrayStreamTest extends TestCase
{
    public void testWrite() throws IOException
    {
        // Initialization
        Destination destination = new DestinationByteArrayStream();
        String source = "abcdef";
        String reference = source;

        // Work
        OutputStream outputStream = destination.getOutputStream(null);
        outputStream.write(source.getBytes());
        outputStream.close();

        String result = ((DestinationByteArrayStream) destination).toString();

        // Verification
        assertEquals(reference, result);
    } // end testWrite()
} // end DestinationByteArrayStreamTest

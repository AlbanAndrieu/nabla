package com.nabla.project.application.model.message.config;

import com.nabla.project.application.api.config.Destination;
import com.nabla.project.application.api.config.Packaging;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Author : $author$ Date : $Date: 2010-06-14 11:52:07 +0200 (Thu, 14 Jun 2010) $ Revision : $revision$
 */
public class DestinationNullStream implements Destination
{
    private static final long serialVersionUID = 1L;
    protected String          url              = "DestinationNullStream";
    protected OutputStream    stream           = new NullStream();

    public OutputStream getOutputStream(final Packaging packaging) throws IOException
    {
        return stream;
    } // end getOutputStream()

    public String getUrl()
    {
        return url;
    } // end getUrl()

    public void setUrl(final String aUrl)
    {
        url = aUrl;
    } // end setUrl()

    public String toString()
    {
        return stream.toString();
    } // end toString()
} // end DestinationNullStream

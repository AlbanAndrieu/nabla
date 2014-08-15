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
package com.nabla.project.application.core.flow.writer;

import com.nabla.project.application.api.UnsupportedFormatException;
import com.nabla.project.application.api.config.Destination;
import com.nabla.project.application.api.config.Packaging;

import org.apache.log4j.Logger;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.zip.GZIPOutputStream;

/**
 * DOCUMENT ME!
 * 
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
 */
public class FileDestination implements Destination
{

    private transient Logger logger = Logger.getLogger(getClass());
    protected String         url;
    protected String         path;
    protected OutputStream   outputStream;

    /**
     * Creates a new FileDestination object.
     */
    public FileDestination()
    {

    }

    /**
     * Creates a new FileDestination object.
     * 
     * @param aUrl DOCUMENT ME!
     */
    public FileDestination(String aUrl)
    {

        this.url = aUrl;
        this.path = System.getProperty("user.dir") + File.separator + "target" + File.separator + aUrl + ".xml";

    }

    /**
     * Creates a new FileDestination object.
     * 
     * @param url DOCUMENT ME!
     * @param path DOCUMENT ME!
     */
    public FileDestination(String url, String path)
    {

        this.url = url;
        this.path = path;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getUrl()
    {

        return url;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param aUrl DOCUMENT ME!
     */
    public void setUrl(String aUrl)
    {

        this.url = aUrl;
        this.path = System.getProperty("user.dir") + File.separator + "target" + File.separator + aUrl + ".xml";

    }

    /**
     * DOCUMENT ME!
     * 
     * @param packaging DOCUMENT ME!
     * @return DOCUMENT ME!
     * @throws IOException DOCUMENT ME!
     */
    public OutputStream getOutputStream(Packaging packaging) throws IOException
    {

        if (outputStream == null)
        {

            try
            {

                switch (packaging)
                {

                    case STANDARD:
                        outputStream = new BufferedOutputStream(new FileOutputStream(this.path), 32768);

                        break;

                    case COMPRESSED:
                        this.path = this.path + ".gz";
                        outputStream = new GZIPOutputStream(new FileOutputStream(this.path), 32768);

                        break;

                    default:
                        throw new UnsupportedFormatException();

                }

            } catch (IOException e)
            {

                logger.error(e);

                e.printStackTrace();

            }

        }

        if (logger.isDebugEnabled())
        {
            logger.debug("File path = " + this.path);
        }

        return outputStream;

    }

    /**
     * DOCUMENT ME!
     * 
     * @throws IOException DOCUMENT ME!
     */
    public void close() throws IOException
    {

        if (outputStream != null)
        {

            outputStream.close();

        }

        outputStream = null;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getPath()
    {

        return path;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param path DOCUMENT ME!
     */
    public void setPath(String path)
    {

        this.path = path;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String toString()
    {

        StringBuffer str = new StringBuffer();

        str.append("url=").append(url).append(' ');
        str.append("path=").append(path);

        return str.toString();

    }

    /**
     * DOCUMENT ME!
     * 
     * @param fileName DOCUMENT ME!
     * @return DOCUMENT ME!
     */
    public static String createFullPathForTmpFile(String fileName)
    {

        StringBuffer str = new StringBuffer();

        str.append(".").append(File.separator).append("target").append(File.separator);
        str.append(fileName).append(".xml");

        return str.toString();

    }

}

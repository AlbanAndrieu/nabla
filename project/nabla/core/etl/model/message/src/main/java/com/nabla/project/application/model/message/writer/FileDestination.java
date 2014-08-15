package com.nabla.project.application.model.message.writer;

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
 * Author : $author$ Date : $Date: 2010-06-21 14:40:56 +0200 (Thu, 21 Jun 2010) $ Revision : $revision$
 */
public class FileDestination implements Destination
{
    private transient Logger logger = Logger.getLogger(getClass());
    protected String         url;
    protected String         path;
    protected OutputStream   outputStream;

    public FileDestination()
    {
    } // end FileDestination()

    public FileDestination(String aUrl)
    {
        this.url = aUrl;
        this.path = System.getProperty("user.dir") + File.separator + "target" + File.separator + aUrl + ".xml";
    } // end FileDestination()

    public FileDestination(String url, String path)
    {
        this.url = url;
        this.path = path;
    } // end FileDestination()

    public String getUrl()
    {
        return url;
    } // end getUrl()

    public void setUrl(final String aUrl)
    {
        this.url = aUrl;
        this.path = System.getProperty("user.dir") + File.separator + "target" + File.separator + aUrl + ".xml";
    } // end setUrl()

    public OutputStream getOutputStream(final Packaging packaging) throws IOException
    {
        if (outputStream == null)
        {
            try
            {
                // File file = File.createTempFile(this.url, ".xml", new File(/*System.getProperty("user.dir")*/"." + File.separator
                // + "target" + File.separator));
                // this.path = file.getCanonicalPath();
                // this.path = "." + File.separator + "target" + File.separator + this.url + ".xml";
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
                } // end switch
            } // end try
            catch (IOException e)
            {
                logger.error(e);
                // TODO Auto-generated catch block
                e.printStackTrace();
            } // end catch
        } // end if

        if (logger.isDebugEnabled())
        {
            logger.debug("File path = " + this.path);
        } // end if

        return outputStream;
    } // end getOutputStream()

    public void close() throws IOException
    {
        if (outputStream != null)
        {
            outputStream.close();
        } // end if

        outputStream = null;
    } // end close()

    /**
     * @return the path
     */
    public String getPath()
    {
        return path;
    } // end getPath()

    /**
     * @param path the path to set
     */
    public void setPath(final String path)
    {
        this.path = path;
    } // end setPath()

    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("url=").append(url).append(' ');
        str.append("path=").append(path);

        return str.toString();
    } // end toString()

    public static String createFullPathForTmpFile(final String fileName)
    {
        StringBuffer str = new StringBuffer();
        str.append(".").append(File.separator).append("target").append(File.separator);
        str.append(fileName).append(".xml");

        return str.toString();
    } // end createFullPathForTmpFile()
} // end FileDestination

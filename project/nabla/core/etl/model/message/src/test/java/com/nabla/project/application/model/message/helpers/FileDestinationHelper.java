package com.nabla.project.application.model.message.helpers;

import com.nabla.project.application.api.UnsupportedFormatException;
import com.nabla.project.application.api.config.Packaging;
import com.nabla.project.application.model.message.writer.FileDestination;

import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Author : $author$ Date : $Date: 2010-06-20 18:06:01 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$
 */
public class FileDestinationHelper extends FileDestination
{
    private transient Logger logger = Logger.getLogger(getClass());
    private Packaging        packaging;
    private long             lenght;
    private InputStream      inputStream;

    public FileDestinationHelper()
    {
    } // end FileDestinationHelper()

    public void setUrl(final String aUrl)
    {
        this.url = aUrl;
        // File file = File.createTempFile(this.url, ".xml", new File(/*System.getProperty("user.dir")*/"." + File.separator
        // + "target" + File.separator));
        // this.path = file.getCanonicalPath();
        this.path = "." + File.separator + "target" + File.separator + aUrl + ".xml";

        switch (this.packaging)
        {
            case STANDARD:
                break;

            case COMPRESSED:
                this.path = this.path + ".gz";

                break;

            default:
                throw new UnsupportedFormatException();
        } // end switch
    } // end setUrl()

    public OutputStream getOutputStream() throws IOException
    {
        if (outputStream == null)
        {
            try
            {
                switch (this.packaging)
                {
                    case STANDARD:
                        outputStream = new BufferedOutputStream(new FileOutputStream(this.path), 32768);

                        break;

                    case COMPRESSED:
                        outputStream = new GZIPOutputStream(new FileOutputStream(this.path), 32768);

                        break;

                    default:
                        throw new UnsupportedFormatException();
                } // end switch
            } // end try
            catch (IOException e)
            {
                e.printStackTrace();
            } // end catch
        } // end if

        if (logger.isDebugEnabled())
        {
            logger.debug("File path = " + this.path);
        } // end if

        File f = new File(this.path);
        this.lenght = f.length();

        return outputStream;
    } // end getOutputStream()

    public InputStream getInputStream() throws IOException
    {
        if (inputStream == null)
        {
            try
            {
                switch (this.packaging)
                {
                    case STANDARD:
                        inputStream = new BufferedInputStream(new FileInputStream(this.path), 32768);

                        break;

                    case COMPRESSED:
                        inputStream = new GZIPInputStream(new FileInputStream(this.path), 32768);

                        break;

                    default:
                        throw new UnsupportedFormatException();
                } // end switch
            } // end try
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } // end catch
        } // end if

        if (logger.isDebugEnabled())
        {
            logger.debug("File path = " + this.path);
        } // end if

        File f = new File(this.path);
        this.lenght = f.length();

        return inputStream;
    } // end getInputStream()

    /**
     * @return the lenght
     */
    public long getLenght()
    {
        return lenght;
    } // end getLenght()

    /**
     * @param lenght the lenght to set
     */
    public void setLenght(final long lenght)
    {
        this.lenght = lenght;
    } // end setLenght()

    public Packaging getPackaging()
    {
        return packaging;
    } // end getPackaging()

    public void setPackaging(final Packaging packaging)
    {
        this.packaging = packaging;
    } // end setPackaging()
} // end FileDestinationHelper

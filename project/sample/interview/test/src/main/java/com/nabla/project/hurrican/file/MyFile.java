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
package com.nabla.project.hurrican.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.log4j.Logger;

import com.nabla.project.hurrican.Hurrican;

/**
 * Helper to get a file on Eclipse environment Reading and writing text files Check best practice.
 */
public final class MyFile implements IMyFile
{

    private static final long             serialVersionUID = 1L;
    private static final transient Logger LOGGER           = Logger.getLogger(MyFile.class);
    /** @serial */
    private final String                  url;
    /** @serial */
    private final String                  path;

    public void addURL(final URL url) throws Exception
    {
        final URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        final Class clazz = URLClassLoader.class;

        // Use reflection
        final Method method = clazz.getDeclaredMethod("addURL", new Class[] { URL.class });
        method.setAccessible(true);
        method.invoke(classLoader, new Object[] { url });
    }

    /**
     * @param aUrl ask for the file name only (path will be taken from eclipse default target classes directory) example test.txt
     */
    public MyFile(final String aUrl)
    {
        // this(aUrl, System.getProperty("user.dir") + File.separator + "target-eclipse" + File.separator + "classes" + File.separator + aUrl);
        this(aUrl, System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + aUrl);
        // this(aUrl, aUrl);

        // try {
        // this.addURL(new File("test" + File.separator + "resources").toURL());
        // } catch (final MalformedURLException e) {
        // if (MyFile.LOGGER.isDebugEnabled()) {
        // MyFile.LOGGER.debug(e);
        // }
        // } catch (final Exception e) {
        // if (MyFile.LOGGER.isDebugEnabled()) {
        // MyFile.LOGGER.debug(e);
        // }
        // }
        //
        // Thread.currentThread().getContextClassLoader().getResourceAsStream(aUrl);
        MyFile.LOGGER.info("class path=" + System.getProperty("java.class.path"));

    }

    /**
     * @param aUrl ask for the file name only
     * @param aPath should be defined with the url
     */
    private MyFile(final String aUrl, final String aPath)
    {

        this.url = aUrl;
        this.path = aPath;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    @Override
    public String getUrl()
    {

        return this.url;

    }

    /*
     * private void setUrl(final String aUrl) { this.url = aUrl; }
     */

    /**
     * DOCUMENT ME!
     *
     * @return the path
     */
    @Override
    public String getPath()
    {

        return this.path;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws FileNotFoundException DOCUMENT ME!
     */

    /*
     * private void setPath(final String aPath) { this.path = aPath; }
     */

    /**
     * Best way to use readLine as it is deprecated for DataInputStream Do not forget to close the reader in a finally it is a private method in order to show to use in this class only (to be properly catched).
     *
     * @return BufferedReader
     *
     * @throws FileNotFoundException do not forget to close the reader in a finally
     */
    private BufferedReader getReader() throws FileNotFoundException
    {

        // use buffering, reading one line at a time
        // FileReader always assumes default encoding is OK!
        return new BufferedReader(new FileReader(this.getPath()));

    }

    /**
     * DOCUMENT ME!
     *
     * @throws Exception DOCUMENT ME!
     */
    @Override
    public void printTest() throws Exception
    {

        if ((this.getPath() != null) && !this.getUrl().isEmpty())
        {

            if (MyFile.LOGGER.isDebugEnabled())
            {

                MyFile.LOGGER.debug("File path = " + this.getPath());

            }

            try
            {

                final BufferedReader dataIn = this.getReader();

                try
                {

                    FileHelper.printData(Hurrican.DEFAULT_SEASON, dataIn);

                }
                finally
                {

                    dataIn.close();

                }

            }
            catch (final IOException ex)
            {

                ex.printStackTrace();

            }

        } else
        {

            throw new Exception("File path or url is not defined");

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    @Override
    public String toString()
    {

        final StringBuffer str = new StringBuffer();

        str.append("url=").append(this.getUrl()).append(' ');
        str.append("path=").append(this.getPath());

        return str.toString();

    }

}

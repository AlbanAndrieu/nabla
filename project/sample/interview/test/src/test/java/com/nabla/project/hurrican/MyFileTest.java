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
package com.nabla.project.hurrican;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mockito;

import com.nabla.project.hurrican.file.FileHelper;
import com.nabla.project.hurrican.file.IMyFile;
import com.nabla.project.hurrican.file.MyFile;

/**
 * DOCUMENT ME!
 *
 * @author $Author$
 * @version $Revision$
 *
 * @since $Date$
 */
public class MyFileTest
{

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void testFileName()
    {

        final IMyFile input = new MyFile(FileHelper.DEFAULT_FILE_NAME);

        Assert.assertEquals(FileHelper.DEFAULT_FILE_NAME, input.getUrl());
        Assert.assertNotNull(input.getPath());
        System.out.println(input.getPath());

    }

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void testFileReadBufferedReader()
    {

        final IMyFile input = new MyFile(FileHelper.DEFAULT_FILE_NAME);

        try
        {

            String sCurrentLine;

            final BufferedReader br = new BufferedReader(new FileReader(input.getPath()));

            try
            {

                while ((sCurrentLine = br.readLine()) != null)
                {

                    System.out.println(sCurrentLine);

                }

            }
            finally
            {

                br.close();

            }

        }
        catch (final FileNotFoundException e)
        {

            e.printStackTrace();
            Assert.fail();

        }
        catch (final IOException e)
        {

            e.printStackTrace();
            Assert.fail();

        }

    }

    /**
     * Check that FileNotFoundException is catched.
     *
     * @throws Exception
     */
    @Test
    public final void testFileReadBufferedReaderFileNotFoundException() throws Exception
    {

        final MyFile input = new MyFile("NoFile" + FileHelper.DEFAULT_FILE_NAME_TXT);

        input.printTest();

    }

    /**
     * Check that we get our own Exception.
     *
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public final void testFileReadBufferedReaderException() throws Exception
    {

        final MyFile input = new MyFile("");

        try
        {

            input.printTest();

        }
        catch (final Exception e)
        {

            e.printStackTrace();
            Assert.assertEquals("File path or url is not defined", e.getMessage());
            throw e;

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @throws IOException DOCUMENT ME!
     */
    @Test
    public final void testFileReadBufferedReaderCloseCatched() throws IOException
    {

        final BufferedReader dataIn = Mockito.mock(BufferedReader.class);

        Mockito.doThrow(new IOException()).when(dataIn).close(); // throws an
        // IOException when
        // the mock
        // BufferedReader
        // close method is
        // called

        try
        {

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

        Mockito.verify(dataIn).close();

    }

    /**
     * DOCUMENT ME!
     *
     * @throws IOException DOCUMENT ME!
     */
    @Test(expected = IOException.class)
    public final void testFileReadBufferedReaderClose() throws IOException
    {

        final BufferedReader dataIn = Mockito.mock(BufferedReader.class);

        Mockito.doThrow(new IOException()).when(dataIn).close(); // throws an
        // IOException when
        // the mock
        // BufferedReader
        // close method is
        // called

        try
        {

            FileHelper.printData(Hurrican.DEFAULT_SEASON, dataIn);

        }
        finally
        {

            dataIn.close();

        }

        Mockito.verify(dataIn).close();

    }

}

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
import java.io.IOException;

import com.nabla.project.hurrican.VelocityConvertor;

/**
 * Specific Helper for the test format.
 *
 * @author $Author$
 * @version $Revision$
 *
 * @since $Date$
 */
public final class FileHelper
{

    /**
     * DOCUMENT ME!
     */
    public static final String DEFAULT_FILE_NAME_TXT = ".txt";

    /**
     * DOCUMENT ME!
     */
    public static final String DEFAULT_FILE_NAME     = "tracks1949to2010_epa" + FileHelper.DEFAULT_FILE_NAME_TXT;

    /**
     * The caller references the constants using <tt>FileHelper.DEFAULT_FILE_NAME</tt>, and so on. Thus, the caller should be prevented from constructing objects of this class, by declaring this private constructor.
     */
    private FileHelper()
    {
        super();

        // this prevents even the native class from
        // calling this ctor as well :
        throw new AssertionError();

    }

    /**
     * DOCUMENT ME!
     *
     * @param data DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String getCard(final String data)
    {

        return data.substring(0, 5);

    }

    /**
     * DOCUMENT ME!
     *
     * @param data DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String getDate(final String data)
    {

        return data.substring(6, 16);

    }

    /**
     * DOCUMENT ME!
     *
     * @param date DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String getYear(final String date)
    {

        return date.substring(6);

    }

    /**
     * DOCUMENT ME!
     *
     * @param data DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String getRecord(final String data)
    {

        return data.substring(19, 21).trim();

    }

    /**
     * DOCUMENT ME!
     *
     * @param data DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String getNumber(final String data)
    {

        return data.substring(30, 34).trim();

    }

    /**
     * DOCUMENT ME!
     *
     * @param data DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String getName(final String data)
    {

        return data.substring(35, 45).trim();

    }

    /**
     * DOCUMENT ME!
     *
     * @param season a season
     * @param dataIn a data as a Reader
     *
     * @throws IOException do not forget to close the reader in a finally
     */
    public static void printData(final String season, final BufferedReader dataIn) throws IOException
    {

        String line = null; // not declared within while loop
        // readLine is a bit quirky :
        // it returns the content of a line MINUS the newline.
        // it returns null only for the END of the stream.
        // it returns an empty String if two newlines appear in a row.

        while ((line = dataIn.readLine()) != null)
        {

            final String date = FileHelper.getDate(line);
            final String year = FileHelper.getYear(date);

            if (year.equals(season))
            {

                final Integer record = Integer.valueOf(FileHelper.getRecord(line));

                // System.out.println("Record : " + record);
                final String name = FileHelper.getName(line);

                System.out.println("Storm Name : " + name);

                FileHelper.printMaxWind(record, dataIn);

            }

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @param record number of record to parse
     * @param dataIn a data as a Reader
     *
     * @throws IOException do not forget to close the reader in a finally
     */
    public static void printMaxWind(final Integer record, final BufferedReader dataIn) throws IOException
    {

        Integer maxWind = 0;

        for (int i = 0; i < record; i++)
        {

            final String lineData = dataIn.readLine();

            if (lineData != null)
            {

                Integer index = 11;

                // For positions and intensities
                final Integer position = 4;

                for (int j = 0; j < position; j++)
                {

                    final Integer wind = index + 9;

                    final Integer currentWind = Integer.valueOf(lineData.substring(wind, wind + 4).trim());

                    if (currentWind > maxWind)
                    {

                        maxWind = currentWind;

                    }

                    index = wind + 8;

                } // For positions and intensities

            }

        } // For each date

        // System.out.println("Maximum sustained surface windspeed : " + maxWind);
        System.out.println("Maximum sustained surface windspeed in kilometers per hour : " + VelocityConvertor.knotsToKmph(Float.valueOf(maxWind)));

    }

}

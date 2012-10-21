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
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

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
public class ExtractionFileTest
{

    /**
     * DOCUMENT ME!
     *
     * @throws IOException DOCUMENT ME!
     */
    @Test
    public final void testDataHeader() throws IOException
    {

        final List<String> list = new ArrayList<String>();

        final IMyFile input = new MyFile(FileHelper.DEFAULT_FILE_NAME);

        String line;

        /*
         * final DataInputStream dataIn = new DataInputStream(new FileInputStream( input.getPath())); while ((line = dataIn.readLine()) != null) { list.add(line); }
         */
        final BufferedReader dataIn = new BufferedReader(new FileReader(input.getPath()));

        try
        {

            while ((line = dataIn.readLine()) != null)
            {

                list.add(line);

            }

            System.out.println(list.get(0));

            final String card = FileHelper.getCard(list.get(0));

            System.out.println("Card : " + card);
            Assert.assertEquals("00005", card);

            final String date = FileHelper.getDate(list.get(0));

            System.out.println("Date : " + date);
            Assert.assertEquals("06/11/1949", date);

            final String year = FileHelper.getYear(date);

            System.out.println("Year : " + year);
            Assert.assertEquals("1949", year);

            final String record = FileHelper.getRecord(list.get(0));

            System.out.println("Record : " + record);
            Assert.assertEquals("2", record);

            final String number = FileHelper.getNumber(list.get(0));

            System.out.println("Number : " + number);
            Assert.assertEquals("1", number);

            final String name = FileHelper.getName(list.get(0));

            System.out.println("Name : " + name);
            Assert.assertEquals("NOT NAMED", name);

        }
        finally
        {

            dataIn.close();

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @throws IOException DOCUMENT ME!
     */
    @Test
    public final void testData() throws IOException
    {

        final List<String> list = new ArrayList<String>();

        final IMyFile input = new MyFile(FileHelper.DEFAULT_FILE_NAME);

        /*
         * final DataInputStream dataIn = new DataInputStream(new FileInputStream( input.getPath())); while ((line = dataIn.readLine()) != null) { list.add(line); }
         */
        String line;
        final BufferedReader dataIn = new BufferedReader(new FileReader(input.getPath()));

        try
        {

            while ((line = dataIn.readLine()) != null)
            {

                final String date = FileHelper.getDate(line);
                final String year = FileHelper.getYear(date);

                // System.out.println("Year : " + year);
                if (year.equals(Hurrican.DEFAULT_SEASON))
                {

                    // final Integer record = Integer.valueOf(line.substring(20, 21));
                    final Integer record = Integer.valueOf(FileHelper.getRecord(line));

                    System.out.println("Record : " + record);

                    for (int i = 0; i < record; i++)
                    {

                        // System.out.println(line);
                        list.add(line);

                    }

                }

            }

            System.out.println(Hurrican.DEFAULT_SEASON + " records : " + list.size());
            Assert.assertEquals(135, list.size());
            System.out.println(list.get(0));
            System.out.println(list.get(1));
            System.out.println(list.get(2));

        }
        finally
        {

            dataIn.close();

        }

    }

    /**
     * DOCUMENT ME!
     */
    @Test
    public final void testExtractDataPosition()
    {

        try
        {

            final List<String> list = new ArrayList<String>();
            final List<String> data = new ArrayList<String>();

            final IMyFile input = new MyFile(FileHelper.DEFAULT_FILE_NAME);

            // final DataInputStream dataIn = new DataInputStream(new FileInputStream(((FileDestination) input).getPath()));
            final BufferedReader dataIn = new BufferedReader(new FileReader(input.getPath()));

            try
            {

                String line;

                while ((line = dataIn.readLine()) != null)
                {

                    final String date = line.substring(6, 16);
                    final String year = date.substring(6);

                    if (year.equals(Hurrican.DEFAULT_SEASON))
                    {

                        final Integer record = Integer.valueOf(line.substring(20, 21));

                        // System.out.println("Record : " + record);
                        list.add(line);

                        for (int i = 0; i < record; i++)
                        {

                            final String lineData = dataIn.readLine();

                            if (lineData != null)
                            {

                                System.out.println(lineData);
                                // It will be better to get the max wind here instead doing after
                                data.add(lineData);

                            }

                        }

                    }

                }

                // System.out.println("Header : " + list.get(0));
                System.out.println("Name :" + list.get(0).substring(35, 45));

                // System.out.println("Data 1 : " + data.get(1));
                final Integer date = 6;

                System.out.println("Data - Date : " + data.get(1).substring(date, date + 5));

                Integer type = date + 5;

                final Integer position = 4;

                for (int i = 0; i < position; i++)
                {

                    System.out.println("Data " + i + " - Type : " + data.get(1).substring(type, type + 1));

                    final Integer lati = type + 1;

                    System.out.println("Data " + i + " - Lat : " + data.get(1).substring(lati, lati + 4));

                    final Integer longi = lati + 4;

                    System.out.println("Data " + i + " - Long : " + data.get(1).substring(longi, longi + 4));

                    final Integer wind = longi + 4;

                    System.out.println("Data " + i + " - Wind : " + data.get(1).substring(wind, wind + 4));

                    final Integer press = wind + 4;

                    System.out.println("Data " + i + " - Press : " + data.get(1).substring(press, press + 4));

                    type = press + 4;

                }

                // Maximum sustained surface windspeed in kilometers per hour
                // Maximum sustained (1 minute) surface (10m) windspeed in knots (these are to the nearest 10 knots for 1851 to 1885 and to the nearest 5 kt for
                // 1886 onward).
                System.out.println("Data 2 : " + data.get(2));

            }
            finally
            {

                dataIn.close();

            }

        }
        catch (final IOException e)
        {

            e.printStackTrace();

        }

    }

}

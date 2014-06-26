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
package com.nabla.project.application.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DOCUMENT ME!
 * 
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
 */
public final class Chronometer
{

    private long                   msBegin;
    private long                   msEnd;
    private long                   msTime;
    private final SimpleDateFormat simpleDateFormat;
    private static String          DATE_PATTERN = "HH'h' mm'mn' ss's' SSS'ms'";

    /**
     * Creates a new Chronometer object.
     */
    public Chronometer()
    {
        this(Chronometer.DATE_PATTERN);

    }

    /**
     * Creates a new Chronometer object.
     * 
     * @param aDatePattern DOCUMENT ME!
     */
    public Chronometer(final String aDatePattern)
    {

        this.simpleDateFormat = new SimpleDateFormat(aDatePattern);

    }

    /**
     * DOCUMENT ME!
     */
    public void start()
    {

        this.msTime = 0;
        this.msBegin = System.currentTimeMillis();

    }

    /**
     * DOCUMENT ME!
     */
    public void stop()
    {

        this.msEnd = System.currentTimeMillis();
        this.msTime += (this.msEnd - this.msBegin);

    }

    /**
     * DOCUMENT ME!
     */
    public void resume()
    {

        this.msBegin = System.currentTimeMillis();

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public long time()
    {

        return this.msTime;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param timeMillis DOCUMENT ME!
     * @return DOCUMENT ME!
     */
    public static String convertMillisToString(final long timeMillis)
    {

        return new SimpleDateFormat(Chronometer.DATE_PATTERN).format(timeMillis);

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    @Override
    public String toString()
    {

        return this.simpleDateFormat.format(new Date(this.time() - 3600000));

    }

    /**
     * DOCUMENT ME!
     * 
     * @param arg DOCUMENT ME!
     */
    public static void main(final String arg[])
    {

        try
        {

            final Chronometer chronometer = new Chronometer();

            chronometer.start();
            Thread.sleep(3000);
            chronometer.stop();
            chronometer.resume();
            Thread.sleep(20);
            chronometer.stop();
            System.out.println(chronometer);

        } catch (final Exception e)
        {

        }

    }

}

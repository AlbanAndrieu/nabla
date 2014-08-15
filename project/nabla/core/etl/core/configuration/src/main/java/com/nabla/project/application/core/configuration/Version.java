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
package com.nabla.project.application.core.configuration;

import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * DOCUMENT ME!
 * 
 * @author $Author$
 * @version $Revision$
 * @since $Date$
 */
public class Version
{

    protected int    versionMajor = 0;
    protected int    versionMinor = 7;
    protected int    releaseMajor = 6;
    protected int    releaseMinor = 645;
    protected String versionId;
    protected String copyright    = "ALBAN (ETL project)";
    protected Date   releaseDate  = new Date(1182514063871L);

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public int getReleaseMajor()
    {

        return releaseMajor;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param releaseMajor DOCUMENT ME!
     */
    public void setReleaseMajor(int releaseMajor)
    {

        this.releaseMajor = releaseMajor;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public int getReleaseMinor()
    {

        return releaseMinor;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param releaseMinor DOCUMENT ME!
     */
    public void setReleaseMinor(int releaseMinor)
    {

        this.releaseMinor = releaseMinor;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public int getVersionMajor()
    {

        return versionMajor;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param versionMajor DOCUMENT ME!
     */
    public void setVersionMajor(int versionMajor)
    {

        this.versionMajor = versionMajor;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public int getVersionMinor()
    {

        return versionMinor;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param versionMinor DOCUMENT ME!
     */
    public void setVersionMinor(int versionMinor)
    {

        this.versionMinor = versionMinor;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public synchronized String getVersionId()
    {

        if (versionId == null)
        {

            StringBuffer str = new StringBuffer();

            str.append(versionMajor).append('.');
            str.append(versionMinor).append('.');
            str.append(releaseMajor).append('.');
            str.append(releaseMinor);

        }

        return versionId;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param versionId DOCUMENT ME!
     */
    public void setVersionId(String versionId)
    {

        this.versionId = versionId;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getCopyright()
    {

        return copyright;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param copyright DOCUMENT ME!
     */
    public void setCopyright(String copyright)
    {

        this.copyright = copyright;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public Date getReleaseDate()
    {

        return releaseDate;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param releaseDate DOCUMENT ME!
     */
    public void setReleaseDate(Date releaseDate)
    {

        this.releaseDate = releaseDate;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getReleaseDateFormated()
    {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return simpleDateFormat.format(releaseDate);

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String toString()
    {

        return getVersionId();

    }

}

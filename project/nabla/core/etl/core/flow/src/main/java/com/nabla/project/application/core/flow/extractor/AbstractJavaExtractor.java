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
package com.nabla.project.application.core.flow.extractor;

import com.nabla.project.application.api.config.Perimeter;
import com.nabla.project.application.api.extractor.ExtractDataInterface;
import com.nabla.project.application.api.helpers.PipePublisher;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * DOCUMENT ME!
 * 
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
 * @param <X> DOCUMENT ME!
 */
public abstract class AbstractJavaExtractor<X> extends JdbcDaoSupport implements ExtractDataInterface<X>
{

    protected String           name;
    protected Perimeter        perimeter;
    protected PipePublisher<X> pipeOut;
    protected int              counter;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getName()
    {

        return name;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param name DOCUMENT ME!
     */
    public void setName(String name)
    {

        this.name = name;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public Perimeter getPerimeter()
    {

        return perimeter;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param perimeter DOCUMENT ME!
     */
    public void setPerimeter(Perimeter perimeter)
    {

        this.perimeter = perimeter;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public PipePublisher<X> getPipeOut()
    {

        return pipeOut;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param pipeOut DOCUMENT ME!
     */
    public void setPipeOut(PipePublisher<X> pipeOut)
    {

        this.pipeOut = pipeOut;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public int getCounter()
    {

        return counter;

    }

}

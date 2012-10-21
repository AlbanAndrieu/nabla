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
package com.nabla.project.application.core.flow.service;

import com.nabla.project.application.api.ExtractService;
import com.nabla.project.application.api.config.RequestId;
import com.nabla.project.application.api.extractor.ExtractorThreadInterface;
import com.nabla.project.application.api.transformer.TransformerThreadInterface;
import com.nabla.project.application.api.writer.WriterThreadInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
  */
public abstract class ExtractServiceCommon implements ExtractService
{

    protected RequestId                                        requestId;
    protected List<ExtractorThreadInterface<Object>>           extractors;
    protected List<Thread>                                     extractorsThreads   = new ArrayList<Thread>();
    protected List<TransformerThreadInterface<Object, Object>> transformers;
    protected List<Thread>                                     transformersThreads = new ArrayList<Thread>();
    protected boolean                                          isUsingWriterThread = true;
    protected List<WriterThreadInterface<Object>>              writers;
    protected List<Thread>                                     writersThreads      = new ArrayList<Thread>();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public RequestId getRequestId()
    {

        return requestId;

    }

    /**
     * DOCUMENT ME!
     *
     * @param requestId DOCUMENT ME!
     */
    public void setRequestId(RequestId requestId)
    {

        this.requestId = requestId;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public List<ExtractorThreadInterface<Object>> getExtractors()
    {

        return extractors;

    }

    /**
     * DOCUMENT ME!
     *
     * @param extractors DOCUMENT ME!
     */
    public void setExtractors(List<ExtractorThreadInterface<Object>> extractors)
    {

        this.extractors = extractors;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean isUsingWriterThread()
    {

        return isUsingWriterThread;

    }

    /**
     * DOCUMENT ME!
     *
     * @param isUsingWriterThread DOCUMENT ME!
     */
    public void setUsingWriterThread(boolean isUsingWriterThread)
    {

        this.isUsingWriterThread = isUsingWriterThread;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public List<TransformerThreadInterface<Object, Object>> getTransformers()
    {

        return transformers;

    }

    /**
     * DOCUMENT ME!
     *
     * @param transformers DOCUMENT ME!
     */
    public void setTransformers(List<TransformerThreadInterface<Object, Object>> transformers)
    {

        this.transformers = transformers;

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public List<WriterThreadInterface<Object>> getWriters()
    {

        return writers;

    }

    /**
     * DOCUMENT ME!
     *
     * @param writers DOCUMENT ME!
     */
    public void setWriters(List<WriterThreadInterface<Object>> writers)
    {

        this.writers = writers;

    }

}

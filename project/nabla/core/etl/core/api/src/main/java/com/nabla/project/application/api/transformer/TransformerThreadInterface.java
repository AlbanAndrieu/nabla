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
package com.nabla.project.application.api.transformer;

import com.nabla.project.application.api.config.RequestId;
import com.nabla.project.application.api.helpers.Pipe;
import com.nabla.project.application.api.helpers.PipePublisher;
import com.nabla.project.application.api.writer.WriterDataInterface;

import org.springframework.beans.factory.InitializingBean;

/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
  *
 * @param <SRC> DOCUMENT ME!
 * @param <TRG> DOCUMENT ME!
 */
public interface TransformerThreadInterface<SRC, TRG> extends Runnable, InitializingBean
{

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Object getId();

    /**
     * DOCUMENT ME!
     *
     * @param id DOCUMENT ME!
     */
    public void setId(Object id);

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public RequestId getRequestId();

    /**
     * DOCUMENT ME!
     *
     * @param requestId DOCUMENT ME!
     */
    public void setRequestId(RequestId requestId);

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getName();

    /**
     * DOCUMENT ME!
     *
     * @param name DOCUMENT ME!
     */
    public void setName(String name);

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Pipe<SRC> getPipeIn();

    /**
     * DOCUMENT ME!
     *
     * @param pipeIn DOCUMENT ME!
     */
    public void setPipeIn(Pipe<SRC> pipeIn);

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Pipe<TRG> getPipeOut();

    /**
     * DOCUMENT ME!
     *
     * @param pipeOut DOCUMENT ME!
     */
    public void setPipeOut(Pipe<TRG> pipeOut);

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public TransformerDataInterface getTransformerData();

    /**
     * DOCUMENT ME!
     *
     * @param transformerData DOCUMENT ME!
     */
    public void setTransformerData(TransformerDataInterface transformerData);

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public WriterDataInterface getWriterData();

    /**
     * DOCUMENT ME!
     *
     * @param writerData DOCUMENT ME!
     */
    public void setWriterData(WriterDataInterface writerData);

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public PipePublisher<Throwable> getPipeException();

    /**
     * DOCUMENT ME!
     *
     * @param pipeException DOCUMENT ME!
     */
    public void setPipeException(PipePublisher<Throwable> pipeException);

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean isUsePipeOut();

    /**
     * DOCUMENT ME!
     *
     * @param isUsePipeOut DOCUMENT ME!
     */
    public void setUsePipeOut(boolean isUsePipeOut);

}

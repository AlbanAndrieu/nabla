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

import org.apache.log4j.Logger;

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
public final class Hurrican
{

    private static final transient Logger LOGGER         = Logger.getLogger(Hurrican.class);

    /**
     * DOCUMENT ME!
     */
    public static final String            DEFAULT_SEASON = "2009";

    /**
     * Constructor.
     */
    private Hurrican()
    {
        super();

        // this prevents even the native class from
        // calling this ctor as well :
        throw new AssertionError();

    }

    /**
     * DOCUMENT ME!
     *
     * @param args arguments
     *
     * @throws Exception DOCUMENT ME!
     */
    public static void main(final String... args) throws Exception
    {

        final IMyFile input = new MyFile(FileHelper.DEFAULT_FILE_NAME);

        try
        {

            input.printTest();

        }
        catch (final Exception e)
        {

            if (Hurrican.LOGGER.isDebugEnabled())
            {

                Hurrican.LOGGER.debug("Error", e);

            }

        }

        Hurrican.LOGGER.info("Task Done");

    }

}

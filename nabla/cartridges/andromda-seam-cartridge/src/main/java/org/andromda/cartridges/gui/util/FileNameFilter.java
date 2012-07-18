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
package org.andromda.cartridges.gui.util;

import java.io.File;

/**
 * DOCUMENT ME!
 *
 * @author $Author$
 * @version $Revision$
 * @since $Date$
 */
public class FileNameFilter implements java.io.FilenameFilter
{

    private final String name;

    /**
     * Creates a new FileNameFilter object.
     *
     * @param name DOCUMENT ME!
     */
    public FileNameFilter(final String name)
    {

        this.name = name;

    }

    /**
     * DOCUMENT ME!
     *
     * @param dir DOCUMENT ME!
     * @param name DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    @Override
    public boolean accept(final File dir, final String name)
    {

        return (this.name.equals(name));

    }

    /**
     * DOCUMENT ME!
     *
     * @param file DOCUMENT ME!
     * @param repertoire DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean isInFolder(final String file, final File repertoire)
    {

        final String[] listefichiers = repertoire.list();
        boolean b = false;

        for (final String listefichier : listefichiers)
        {

            if (listefichier.equals(this.name))
            {

                b = true;

                break;

            }

        }

        return b;

    }

}

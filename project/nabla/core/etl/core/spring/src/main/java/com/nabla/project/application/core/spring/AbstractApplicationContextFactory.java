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
package com.nabla.project.application.core.spring;

import com.nabla.project.application.api.config.RequestId;

import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * DOCUMENT ME!
 * 
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
 */
public abstract class AbstractApplicationContextFactory
{

    protected static Logger    logger                       = Logger.getLogger(AbstractApplicationContextFactory.class);

    public static final String SPRING_PACKAGE               = "com/nabla/project/application/core/spring/";
    /**
     * DOCUMENT ME!
     */
    public static String       springDefaultConfiguration[] =
                                                            { SPRING_PACKAGE + "/ServiceBase-Sample.xml", };
    public static String       springConfiguration[]        = springDefaultConfiguration;

    /**
     * Creates a new AbstractApplicationContextFactory object.
     */
    protected AbstractApplicationContextFactory()
    {
        super();

    }

    private static AbstractApplicationContextFactory getInstance()
    {

        return null;

    }

    protected ApplicationContext applicationContext = null;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public synchronized ApplicationContext getApplicationContext()
    {

        if (this.applicationContext == null)
        {

            this.applicationContext = new ClassPathXmlApplicationContext(springConfiguration);

            ((ConfigurableApplicationContext) applicationContext).registerShutdownHook();

        }

        return this.applicationContext;

    }

    /**
     * DOCUMENT ME!
     */
    public static void newExtractionScope()
    {

        ExtractionScope.extractionId.set(new RequestId());

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public static String[] getSpringConfiguration()
    {

        return springConfiguration;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param springConfiguration DOCUMENT ME!
     */
    public static void setSpringConfiguration(String springConfiguration[])
    {

        AbstractApplicationContextFactory.springConfiguration = springConfiguration;

    }

}

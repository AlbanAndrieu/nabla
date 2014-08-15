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
package com.nabla.project.application.tool.runner;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * DOCUMENT ME!
 * 
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
 */
public class ServiceRunnerTest extends TestCase
{

    private Logger logger = Logger.getLogger(getClass());

    /**
     * Creates a new ServiceRunnerTest object.
     */
    public ServiceRunnerTest()
    {

    }

    /**
     * DOCUMENT ME!
     */
    public void setUp()
    {

        ServiceImpl.setStatus(ServiceStatus.NOT_STARTED);

    }

    /**
     * DOCUMENT ME!
     * 
     * @throws Exception DOCUMENT ME!
     */
    public void testServiceRunnerSeparatedThread() throws Exception
    {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]
        { "com/nabla/project/application/tool/runner/SeparatedThreadConfig.xml" });
        IService service = (IService) context.getBean("testService");

        service.startService();
        Thread.sleep(500);
        assertEquals(ServiceStatus.STARTED, ServiceImpl.getStatus());
        Thread.sleep(1000);
        assertEquals(ServiceStatus.FINISHED, ServiceImpl.getStatus());

    }

    /**
     * DOCUMENT ME!
     * 
     * @throws Exception DOCUMENT ME!
     */
    public void testServiceRunnerSameThread() throws Exception
    {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]
        { "com/nabla/project/application/tool/runner/SameThreadConfig.xml" });
        IService service = (IService) context.getBean("testService");

        service.startService();
        assertEquals(ServiceStatus.FINISHED, ServiceImpl.getStatus());

    }

    /**
     * DOCUMENT ME!
     * 
     * @throws Exception DOCUMENT ME!
     */
    public void testServiceRunnerSeparatedVM() throws Exception
    {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]
        { "com/nabla/project/application/tool/runner/SeparatedJVMConfig.xml" });
        IService service = (IService) context.getBean("testService");

        service.startService();
        Thread.sleep(500);

        assertEquals(ServiceStatus.NOT_STARTED, ServiceImpl.getStatus());

    }

    /**
     * DOCUMENT ME!
     * 
     * @throws Exception DOCUMENT ME!
     */
    public void testServiceRunnerSeparatedVMWithParameters() throws Exception
    {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]
        { "com/nabla/project/application/tool/runner/SeparatedJVMConfig.xml" });
        IService service = (IService) context.getBean("testService");
        ServiceParameter param = new ServiceParameter();

        param.setName("serviceParameter");
        service.startServiceWithParameter(param);
        Thread.sleep(500);

        assertEquals(ServiceStatus.NOT_STARTED, ServiceImpl.getStatus());

    }

    /**
     * DOCUMENT ME!
     */
    public void testSynchronousAsynchronousService()
    {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]
        { "com/nabla/project/application/tool/runner/SynchronousAsynchronousServiceConfig.xml" });
        SynchronousAsynchronousService service = (SynchronousAsynchronousService) context.getBean("testService");

        service.sayHello();
        service.asynchronousService();

    }

    /**
     * DOCUMENT ME!
     */
    public void testSynchronousAsynchronousServiceWrongConfig()
    {

        try
        {

            new ClassPathXmlApplicationContext(new String[]
            { "com/nabla/project/application/tool/runner/SynchronousAsynchronousServiceWrongConfig.xml" });
            fail("IllegalArgumentException should be thrown with this config : methods with return types cannot be invoked asynchronously");

        } catch (Exception iae)
        {

            if (logger.isDebugEnabled())
            {

                logger.debug("Exception : ", iae);

            }

            assertTrue(iae.getMessage().indexOf(
                    "serviceInterface for ServiceRunner must containt only method returning void : public abstract java.lang.String com.nabla.project.application.tool.runner.SynchronousAsynchronousService.sayHello()") != -1);

        }

    }

}

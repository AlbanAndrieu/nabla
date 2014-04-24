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

import org.aopalliance.intercept.MethodInvocation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ObjectInputStream;

import java.lang.reflect.Method;

/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
  */
public class ServiceRunner implements Runnable
{

    private MethodInvocation invocation;
    private Object           service;

    /**
     * Creates a new ServiceRunner object.
     *
     * @param invocation DOCUMENT ME!
     * @param service DOCUMENT ME!
     */
    public ServiceRunner(MethodInvocation invocation, Object service)
    {

        this.invocation = invocation;
        this.service = service;

    }

    /**
     * DOCUMENT ME!
     */
    public void run()
    {

        try
        {

            invocation.getMethod().invoke(service, invocation.getArguments());

        }
        catch (Throwable t)
        {

            throw new RuntimeException("Exception during service execution", t);

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @param args DOCUMENT ME!
     *
     * @throws Exception DOCUMENT ME!
     * @throws RuntimeException DOCUMENT ME!
     */
    public static void main(String args[]) throws Exception
    {

        ObjectInputStream ois = new ObjectInputStream(System.in);
        Object methodArgs[] = (Object[]) ois.readObject();

        if (args.length < 3)
        {

            throw new RuntimeException("Error : usage : java com.nabla.project.application.tool.runner.ServiceRunner configFileName beanName methodName");

        }

        String configFileName = args[0];
        String beanName = args[1];
        String methodName = args[2];
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { configFileName });
        Object service = context.getBean(beanName);
        Method serviceMethod = null;
        Method methods[] = service.getClass().getMethods();

        for (Method method : methods)
        {

            if (method.getName().equals(methodName))
            {

                serviceMethod = method;

            }

        }

        if (serviceMethod == null)
        {

            throw new RuntimeException("Method " + methodName + " not found in class " + service.getClass());

        }

        serviceMethod.invoke(service, methodArgs);

    }

}

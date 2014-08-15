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

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import org.springframework.beans.factory.InitializingBean;

import java.io.File;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.List;

/**
 * DOCUMENT ME!
 * 
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
 */
public class ServiceInvoker implements MethodInterceptor, InitializingBean
{

    private Object         service;
    private Class          serviceInterface;
    private InvocationType invocationType;
    private String         newVMconfigFileName;
    private String         newVMServiceBeanName;
    private String         newVMClasspathRoot;
    private List<String>   asynchronousMethodNameList;

    /**
     * DOCUMENT ME!
     * 
     * @param invocation DOCUMENT ME!
     * @return DOCUMENT ME!
     * @throws Throwable DOCUMENT ME!
     * @throws RuntimeException DOCUMENT ME!
     */
    public Object invoke(MethodInvocation invocation) throws Throwable
    {

        try
        {

            if (InvocationType.SAME_THREAD.equals(invocationType) || !isAsynchronousMethod(invocation.getMethod()))
            {

                return invocation.getMethod().invoke(service, invocation.getArguments());

            } else if (InvocationType.SEPARATED_THREAD.equals(invocationType))
            {

                invokeInNewThread(invocation, service);

            } else if (InvocationType.SEPARATED_VM.equals(invocationType))
            {

                invokeInNewJVM(invocation);

            }

            return null;

        } catch (Throwable ex)
        {

            ex.printStackTrace();
            throw new RuntimeException("Failed to invoke service runner for service [" + getServiceInterface() + "]", ex);

        }

    }

    private boolean isAsynchronousMethod(Method method)
    {

        if (asynchronousMethodNameList == null)
        {

            return true;

        } else
        {

            return asynchronousMethodNameList.contains(method.getName());

        }

    }

    private void invokeInNewThread(MethodInvocation invocation, Object service)
    {

        ServiceRunner runner = new ServiceRunner(invocation, service);
        Thread invocationThread = new Thread(runner);

        invocationThread.start();

    }

    private void invokeInNewJVM(MethodInvocation invocation)
    {

        try
        {

            checkInvocationArgumentsForJVMTransfer(invocation.getArguments());

            String classpath = System.getProperty("java.class.path");

            if (newVMClasspathRoot != null)
            {

                classpath = generateClassPath(newVMClasspathRoot);

            }

            ProcessBuilder pb = new ProcessBuilder(new String[]
            { "java", "-classpath", classpath, "com.nabla.project.application.tool.runner.ServiceRunner", newVMconfigFileName, newVMServiceBeanName, invocation.getMethod().getName() });
            Process p = pb.start();

            ObjectOutputStream oos = new ObjectOutputStream(p.getOutputStream());

            oos.writeObject(invocation.getArguments());
            oos.flush();

        } catch (Exception ioe)
        {

            throw new RuntimeException(ioe);

        }

    }

    private String generateClassPath(String classpathRoot)
    {

        File rootDir = new File(classpathRoot);

        if (!rootDir.isDirectory())
        {

            throw new RuntimeException("Error while generating classpath with classpath root : " + classpathRoot + " ; absolute path is : " + rootDir.getAbsolutePath());

        }

        String fileNames[] = rootDir.list();
        String result = "";

        for (String fileName : fileNames)
        {

            File file = new File(fileName);

            if (file.isDirectory())
            {

                result += generateClassPath(fileName);

            } else if (fileName.endsWith(".jar"))
            {

                result += (rootDir + File.separator + fileName + ";");

            }

        }

        return result;

    }

    private void checkInvocationArgumentsForJVMTransfer(Object arguments[])
    {

        for (Object arg : arguments)
        {

            if (!(arg instanceof Serializable))
            {

                throw new IllegalArgumentException("method parameter " + arg + " must be serializable in order to execute method in a separated JVM");

            }

        }

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public Object getService()
    {

        return service;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param service DOCUMENT ME!
     */
    public void setService(Object service)
    {

        this.service = service;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public Class getServiceInterface()
    {

        return serviceInterface;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param serviceInterface DOCUMENT ME!
     */
    public void setServiceInterface(Class serviceInterface)
    {

        this.serviceInterface = serviceInterface;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public InvocationType getInvocationType()
    {

        return invocationType;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param invocationType DOCUMENT ME!
     */
    public void setInvocationType(InvocationType invocationType)
    {

        this.invocationType = invocationType;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getNewVMServiceBeanName()
    {

        return newVMServiceBeanName;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param newVMServiceBeanName DOCUMENT ME!
     */
    public void setNewVMServiceBeanName(String newVMServiceBeanName)
    {

        this.newVMServiceBeanName = newVMServiceBeanName;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getNewVMconfigFileName()
    {

        return newVMconfigFileName;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param newVMconfigFileName DOCUMENT ME!
     */
    public void setNewVMconfigFileName(String newVMconfigFileName)
    {

        this.newVMconfigFileName = newVMconfigFileName;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public List<String> getAsynchronousMethodNameList()
    {

        return asynchronousMethodNameList;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param asynchronousMethodNameList DOCUMENT ME!
     */
    public void setAsynchronousMethodNameList(List<String> asynchronousMethodNameList)
    {

        this.asynchronousMethodNameList = asynchronousMethodNameList;

    }

    /**
     * DOCUMENT ME!
     */
    public void afterPropertiesSet()
    {

        if ((serviceInterface != null) && !serviceInterface.isInterface())
        {

            throw new IllegalArgumentException("serviceInterface must be an interface");

        }

        Method methods[] = serviceInterface.getDeclaredMethods();

        for (Method method : methods)
        {

            if (isAsynchronousMethod(method) && !method.getReturnType().equals(Void.TYPE))
            {

                throw new IllegalArgumentException("serviceInterface for ServiceRunner must containt only method returning void : " + method);

            }

        }

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getNewVMClasspathRoot()
    {

        return newVMClasspathRoot;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param newVMClasspathRoot DOCUMENT ME!
     */
    public void setNewVMClasspathRoot(String newVMClasspathRoot)
    {

        this.newVMClasspathRoot = newVMClasspathRoot;

    }

}

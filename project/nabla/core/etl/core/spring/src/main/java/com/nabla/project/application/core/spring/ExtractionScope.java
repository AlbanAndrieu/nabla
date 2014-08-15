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

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.lang.management.ManagementFactory;

import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 * DOCUMENT ME!
 * 
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
 */
public class ExtractionScope implements Scope
{

    protected static Logger                       logger    = Logger.getLogger(ExtractionScope.class);
    protected Map<RequestId, Map<String, Object>> scopeMaps = new HashMap<RequestId, Map<String, Object>>();
    protected MBeanServer                         mbs;

    /**
     * Creates a new ExtractionScope object.
     */
    public ExtractionScope()
    {

        mbs = ManagementFactory.getPlatformMBeanServer();

    }

    protected final String getJmxObjectName(String beanName, RequestId requestId)
    {

        return new StringBuffer().append("Extraction").append(requestId).append(":type=").append(beanName).toString();

    }

    /**
     * DOCUMENT ME!
     * 
     * @param beanName DOCUMENT ME!
     * @param objectFactory DOCUMENT ME!
     * @return DOCUMENT ME!
     */
    public Object get(String beanName, ObjectFactory objectFactory)
    {

        RequestId requestId = (RequestId) extractionId.get();

        if (logger.isDebugEnabled())
        {

            logger.debug(new StringBuffer().append("get(").append(beanName).append(") extractionId=").append(requestId));

        }

        Map<String, Object> beansMap = scopeMaps.get(requestId);

        if (beansMap == null)
        {

            beansMap = new HashMap<String, Object>();
            scopeMaps.put(requestId, beansMap);

        }

        Object bean = beansMap.get(beanName);

        if (bean == null)
        {

            if (AbstractConfig.beanRequestIdName.equals(beanName))
            {

                bean = requestId;

            } else
            {

                bean = objectFactory.getObject();

            }

            beansMap.put(beanName, bean);

            try
            {

                ObjectName name = new ObjectName(getJmxObjectName(beanName, requestId));

                mbs.registerMBean(bean, name);

                if (logger.isDebugEnabled())
                {
                    logger.debug("JMX registration done for " + name);
                }

            } catch (Exception ex)
            {

                logger.warn(ex);

            }

        }

        return bean;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getConversationId()
    {

        return extractionId.get().toString();

    }

    /**
     * DOCUMENT ME!
     * 
     * @param beanName DOCUMENT ME!
     * @param arg1 DOCUMENT ME!
     */
    public void registerDestructionCallback(String beanName, Runnable arg1)
    {

        if (logger.isDebugEnabled())
        {
            logger.debug("registerDestructionCallback(" + beanName + ")");
        }

    }

    /**
     * DOCUMENT ME!
     * 
     * @param beanName DOCUMENT ME!
     * @return DOCUMENT ME!
     */
    public Object remove(String beanName)
    {

        RequestId requestId = (RequestId) extractionId.get();

        if (logger.isDebugEnabled())
        {
            logger.debug("remove(" + beanName + ") extractionId=" + requestId);
        }

        Object bean = null;

        Map<String, Object> beansMap = scopeMaps.get(requestId);

        if (beansMap != null)
        {

            beansMap.remove(beanName);

        }

        try
        {

            ObjectName name = new ObjectName(getJmxObjectName(beanName, requestId));

            mbs.unregisterMBean(name);

            if (logger.isDebugEnabled())
            {
                logger.debug("JMX registration done for " + name);
            }

        } catch (Exception ex)
        {

            logger.warn(ex);

        }

        return bean;

    }

    /**
     * DOCUMENT ME!
     */
    public static ThreadLocal extractionId = new ThreadLocal()
                                           {

                                               protected synchronized RequestId initialValue()
                                               {

                                                   if (logger.isDebugEnabled())
                                                   {
                                                       logger.debug("initialValue");
                                                   }

                                                   return new RequestId();

                                               }

                                           };

}

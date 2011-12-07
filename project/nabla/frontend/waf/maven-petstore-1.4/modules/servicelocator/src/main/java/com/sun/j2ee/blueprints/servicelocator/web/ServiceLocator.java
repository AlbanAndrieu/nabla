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
package com.sun.j2ee.blueprints.servicelocator.web;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJBHome;
import javax.ejb.EJBLocalHome;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Topic;
import javax.jms.TopicConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;

import com.sun.j2ee.blueprints.servicelocator.ServiceLocatorException;

/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 359 $
 *
 * @since $Date: 2010-09-17 02:14:34 +0200 (ven., 17 sept. 2010) $
 */
public class ServiceLocator implements java.io.Serializable {

    private static final long     serialVersionUID = 1L;
    private InitialContext        ic;
    private Map<String, Object>   cache;
    private static ServiceLocator me;

    static {

        try {

            ServiceLocator.me = new ServiceLocator();

        } catch (final ServiceLocatorException se) {

            System.err.println(se);
            se.printStackTrace(System.err);

        }

    }

    /**
         * Creates a new ServiceLocator object.
         *
         * @throws ServiceLocatorException DOCUMENT ME!
         */
    private ServiceLocator() throws ServiceLocatorException {

        try {

            this.ic = new InitialContext();
            this.cache = Collections.synchronizedMap(new HashMap<String, Object>());

        } catch (final NamingException ne) {

            throw new ServiceLocatorException(ne);

        } catch (final Exception e) {

            throw new ServiceLocatorException(e);

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    static public ServiceLocator getInstance() {

        return ServiceLocator.me;

    }

    /**
     * DOCUMENT ME!
     *
     * @param jndiHomeName DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws ServiceLocatorException DOCUMENT ME!
     */
    public EJBLocalHome getLocalHome(final String jndiHomeName) throws ServiceLocatorException {

        EJBLocalHome home = null;

        try {

            if (this.cache.containsKey(jndiHomeName)) {

                home = (EJBLocalHome) this.cache.get(jndiHomeName);

            } else {

                home = (EJBLocalHome) this.ic.lookup(jndiHomeName);
                this.cache.put(jndiHomeName, home);

            }

        } catch (final NamingException ne) {

            throw new ServiceLocatorException(ne);

        } catch (final Exception e) {

            throw new ServiceLocatorException(e);

        }

        return home;

    }

    /**
     * DOCUMENT ME!
     *
     * @param jndiHomeName DOCUMENT ME!
     * @param className DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws ServiceLocatorException DOCUMENT ME!
     */
    public EJBHome getRemoteHome(final String jndiHomeName, final Class<?> className) throws ServiceLocatorException {

        EJBHome home = null;

        try {

            if (this.cache.containsKey(jndiHomeName)) {

                home = (EJBHome) this.cache.get(jndiHomeName);

            } else {

                final Object objref = this.ic.lookup(jndiHomeName);
                final Object obj = PortableRemoteObject.narrow(objref, className);

                home = (EJBHome) obj;
                this.cache.put(jndiHomeName, home);

            }

        } catch (final NamingException ne) {

            throw new ServiceLocatorException(ne);

        } catch (final Exception e) {

            throw new ServiceLocatorException(e);

        }

        return home;

    }

    /**
     * DOCUMENT ME!
     *
     * @param qConnFactoryName DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws ServiceLocatorException DOCUMENT ME!
     */
    public QueueConnectionFactory getQueueConnectionFactory(final String qConnFactoryName) throws ServiceLocatorException {

        QueueConnectionFactory factory = null;

        try {

            if (this.cache.containsKey(qConnFactoryName)) {

                factory = (QueueConnectionFactory) this.cache.get(qConnFactoryName);

            } else {

                factory = (QueueConnectionFactory) this.ic.lookup(qConnFactoryName);
                this.cache.put(qConnFactoryName, factory);

            }

        } catch (final NamingException ne) {

            throw new ServiceLocatorException(ne);

        } catch (final Exception e) {

            throw new ServiceLocatorException(e);

        }

        return factory;

    }

    /**
     * DOCUMENT ME!
     *
     * @param queueName DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws ServiceLocatorException DOCUMENT ME!
     */
    public Queue getQueue(final String queueName) throws ServiceLocatorException {

        Queue queue = null;

        try {

            if (this.cache.containsKey(queueName)) {

                queue = (Queue) this.cache.get(queueName);

            } else {

                queue = (Queue) this.ic.lookup(queueName);
                this.cache.put(queueName, queue);

            }

        } catch (final NamingException ne) {

            throw new ServiceLocatorException(ne);

        } catch (final Exception e) {

            throw new ServiceLocatorException(e);

        }

        return queue;

    }

    /**
     * DOCUMENT ME!
     *
     * @param topicConnFactoryName DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws ServiceLocatorException DOCUMENT ME!
     */
    public TopicConnectionFactory getTopicConnectionFactory(final String topicConnFactoryName) throws ServiceLocatorException {

        TopicConnectionFactory factory = null;

        try {

            if (this.cache.containsKey(topicConnFactoryName)) {

                factory = (TopicConnectionFactory) this.cache.get(topicConnFactoryName);

            } else {

                factory = (TopicConnectionFactory) this.ic.lookup(topicConnFactoryName);
                this.cache.put(topicConnFactoryName, factory);

            }

        } catch (final NamingException ne) {

            throw new ServiceLocatorException(ne);

        } catch (final Exception e) {

            throw new ServiceLocatorException(e);

        }

        return factory;

    }

    /**
     * DOCUMENT ME!
     *
     * @param topicName DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws ServiceLocatorException DOCUMENT ME!
     */
    public Topic getTopic(final String topicName) throws ServiceLocatorException {

        Topic topic = null;

        try {

            if (this.cache.containsKey(topicName)) {

                topic = (Topic) this.cache.get(topicName);

            } else {

                topic = (Topic) this.ic.lookup(topicName);
                this.cache.put(topicName, topic);

            }

        } catch (final NamingException ne) {

            throw new ServiceLocatorException(ne);

        } catch (final Exception e) {

            throw new ServiceLocatorException(e);

        }

        return topic;

    }

    /**
     * DOCUMENT ME!
     *
     * @param dataSourceName DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws ServiceLocatorException DOCUMENT ME!
     */
    public DataSource getDataSource(final String dataSourceName) throws ServiceLocatorException {

        DataSource dataSource = null;

        try {

            if (this.cache.containsKey(dataSourceName)) {

                dataSource = (DataSource) this.cache.get(dataSourceName);

            } else {

                dataSource = (DataSource) this.ic.lookup(dataSourceName);
                this.cache.put(dataSourceName, dataSource);

            }

        } catch (final NamingException ne) {

            throw new ServiceLocatorException(ne);

        } catch (final Exception e) {

            throw new ServiceLocatorException(e);

        }

        return dataSource;

    }

    /**
     * DOCUMENT ME!
     *
     * @param envName DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws ServiceLocatorException DOCUMENT ME!
     */
    public URL getUrl(final String envName) throws ServiceLocatorException {

        URL url = null;

        try {

            url = (URL) this.ic.lookup(envName);

        } catch (final NamingException ne) {

            throw new ServiceLocatorException(ne);

        } catch (final Exception e) {

            throw new ServiceLocatorException(e);

        }

        return url;

    }

    /**
     * DOCUMENT ME!
     *
     * @param envName DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws ServiceLocatorException DOCUMENT ME!
     */
    public boolean getBoolean(final String envName) throws ServiceLocatorException {

        Boolean bool = null;

        try {

            bool = (Boolean) this.ic.lookup(envName);

        } catch (final NamingException ne) {

            throw new ServiceLocatorException(ne);

        } catch (final Exception e) {

            throw new ServiceLocatorException(e);

        }

        return bool.booleanValue();

    }

    /**
     * DOCUMENT ME!
     *
     * @param envName DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws ServiceLocatorException DOCUMENT ME!
     */
    public String getString(final String envName) throws ServiceLocatorException {

        String envEntry = null;

        try {

            envEntry = (String) this.ic.lookup(envName);

        } catch (final NamingException ne) {

            throw new ServiceLocatorException(ne);

        } catch (final Exception e) {

            throw new ServiceLocatorException(e);

        }

        return envEntry;

    }

}

package org.andromda.timetracker.service;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.apache.log4j.Logger;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.JndiName;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.ejb.SeamInterceptor;

/**
 * This is a stateless bean
 */
@Stateless
@Scope(ScopeType.CONVERSATION)
// @SecurityDomain("timetracker-ejb3")
@Name("helloWorldService")
@Interceptors(SeamInterceptor.class)
@JndiName("java:app/core/HelloWorldServiceBean!org.andromda.timetracker.service.HelloWorldServiceLocal")
public class HelloWorldServiceBean implements HelloWorldServiceLocal, HelloWorldServiceRemote
{
    /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger(HelloWorldServiceBean.class);

    @Override
    public void print()
    {
        HelloWorldServiceBean.logger.warn("----------------------------------");
        HelloWorldServiceBean.logger.warn("----*****  Hello World ! *****----");
        HelloWorldServiceBean.logger.warn("----------------------------------");

    }

}

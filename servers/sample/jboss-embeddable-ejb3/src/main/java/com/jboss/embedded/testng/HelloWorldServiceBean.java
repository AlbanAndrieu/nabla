package com.jboss.embedded.testng;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

/**
 * This is a stateless bean
 *
 */
@Stateless
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

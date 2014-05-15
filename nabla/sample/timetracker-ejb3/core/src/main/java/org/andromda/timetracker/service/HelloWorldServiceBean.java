package org.andromda.timetracker.service;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

/**
 * This is a stateless bean
 *
 */
@Stateless
// @SecurityDomain("timetracker-ejb3")
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

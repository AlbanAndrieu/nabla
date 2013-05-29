package com.nabla.project.application.core.spring;

import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author : $author$ Date : $Date: 2010-06-20 18:06:01 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$
 */
public class ApplicationContextFactory extends AbstractApplicationContextFactory
{
    protected static Logger                        logger                             = Logger.getLogger(ApplicationContextFactory.class);

    /**
     * The configuration file for the service application context
     */
    private final static String[]                  springXmlJaxbConfiguration         = { SPRING_PACKAGE + "ExtractServiceConfig.xml", SPRING_PACKAGE + "ExtractServiceParametersConfig.xml", };
    public final static String[]                   springXmlDefaultConfiguration      = springXmlJaxbConfiguration;
    private final static String[]                  springXmlTestsDefaultConfiguration = { SPRING_PACKAGE + "ExtractServiceConfig.xml", SPRING_PACKAGE + "ExtractServiceParametersConfig.xml",
            SPRING_PACKAGE + "XmlComparisonConfig.xml",                              };
    public static String[]                         springXmlConfiguration             = springXmlDefaultConfiguration;
    public static String[]                         springXmlConfigurationTest         = springXmlTestsDefaultConfiguration;

    /**
     * The configuration file for the service application context
     */
    public final static String[]                   springDefaultConfiguration         = { SPRING_PACKAGE + "/ServiceBase.xml", };

    /**
     * The singleton
     */
    private final static ApplicationContextFactory applicationContextFactory          = new ApplicationContextFactory();

    /**
             * Singleton
             */
    private ApplicationContextFactory()
    {
        super();
    } // end ApplicationContextFactory()

    /**
     * Gets the singleton of this class
     */
    public static ApplicationContextFactory getInstance()
    {
        return applicationContextFactory;
    } // end getInstance()

    // The service bean factory instance
    //private ApplicationContext applicationContext = null;
    /**
     * 
     * @return ApplicationContext
     */
    public synchronized ApplicationContext getApplicationContext()
    {
        if (this.applicationContext == null)
        {
            this.applicationContext = new ClassPathXmlApplicationContext(springXmlConfiguration);

            // add a shutdown hook for the above context...
            ((ConfigurableApplicationContext) applicationContext).registerShutdownHook();
        } // end if

        return this.applicationContext;
    } // end getApplicationContext()
} // end ApplicationContextFactory

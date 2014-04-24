package com.nabla.project.application.model.message.jmx;

import com.nabla.project.application.core.log.Log;

import org.apache.log4j.Logger;

/**
 * Author : $author$ Date : $Date: 2010-06-14 14:32:57 +0200 (jeu., 14 juin 2010) $ Revision : $revision$ To unable jmx management, use this VM parameter :
 * -Dcom.sun.management.jmxremote
 */
public class Jmx
{
    protected static Logger logger = Logger.getLogger(Jmx.class);

    public static void main(final String[] args) throws Exception
    {
        // ApplicationContextFactory.springXmlConfiguration=ApplicationContextFactory.springXmlTestsDefaultConfiguration;
        // AbstractApplicationContextFactory.get().getApplicationContext().getBean(Config.beanExtractServiceTradeName);
        Log.init();

        while (true)
        {
            if (logger.isDebugEnabled())
            {
                logger.debug("waiting");
            } // end if

            Thread.sleep(50000L);
        } // end while

        /*
         * Without spring :
         * MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
         * ObjectName name = new ObjectName("com.sgcib.services.extract.eoleextract.jmx:type=JmxTestBean");
         * mbs.registerMBean(new JmxTestBean(), name);
         * System.out.println("Waiting forever...");
         * Thread.sleep(Long.MAX_VALUE);
         */
    } // end main()
} // end Jmx

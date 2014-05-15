// license-header java merge-point
//
// Generated by: EJB3Container.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.test;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.ejb3.embedded.EJB3StandaloneBootstrap;
import org.jboss.ejb3.embedded.EJB3StandaloneDeployer;
import org.testng.annotations.Configuration;

/**
 * Boots the JBoss Microcontainer with an EJB3 configuration.
 *
 * You can also use this class to lookup managed beans from JNDI.
 *
 * @author vancek
 * <p><b>Note</b>. code was copied from christian.bauer@jboss.com
 * example on Hibernate's CaveatEmptor application
 * </p>
 */
public class EJB3Container
{
    private final static Log       logger = LogFactory.getLog(EJB3Container.class);

    private EJB3StandaloneDeployer deployer;

    @Configuration(beforeTest = true)
    public void startup()
    {
        try
        {
            logger.info("==>Bootstrapping EJB3 container...");

            // Boot the JBoss Microcontainer with EJB3 settings, loads ejb3-interceptors-aop.xml
            EJB3StandaloneBootstrap.boot(null);

            // Uncomment the following to enable security
            // logger.info("==>Deploying security-beans");
            // EJB3StandaloneBootstrap.deployXmlResource("security-beans.xml");
            // logger.info("==>Deployed security-beans");

            logger.info("==>Deploying jboss-jms-beans - init JBoss MQ core services");
            EJB3StandaloneBootstrap.deployXmlResource("jboss-jms-beans.xml");
            logger.info("==>Deployed jboss-jms-beans");

            logger.info("==>Configure test queue and topic");
            EJB3StandaloneBootstrap.deployXmlResource("testjms.xml");
            logger.info("==>Configured test queues and topics");

            logger.info("==>Deploying ejb3");
            EJB3StandaloneBootstrap.scanClasspath();

            // Add all EJBs found in the archive that has this file
            deployer = new EJB3StandaloneDeployer();

            // Deploy everything we got
            deployer.setKernel(EJB3StandaloneBootstrap.getKernel());
            deployer.create();
            logger.info("==>Deployer created");
            deployer.start();
            logger.info("==>Deployer started");
            logger.info("==>End of bootstrapping EJB3 container");
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
    }

    @Configuration(afterTest = true)
    public void shutdown()
    {
        try
        {
            logger.info("==>Invoking EJB3.shutdown...");
            deployer.stop();
            deployer.destroy();
            EJB3StandaloneBootstrap.shutdown();
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }
    }

    private static InitialContext initialContext        = null;
    private static InitialContext securedInitialContext = null;

    /**
     * Return a new InitialContext based on org.jnp.interfaces.LocalOnlyContextFactory,
     * setting the the default context.
     *
     * @return InitialContext
     * @throws Exception
     */
    public static InitialContext newInitialContext() throws Exception
    {
        Hashtable props = getInitialContextProperties();
        initialContext = new InitialContext(props);
        return initialContext;
    }

    /**
     * Return a new InitialContext based on org.jboss.security.jndi.JndiLoginInitialContextFactory,
     * setting the default context. Use the specified username and password to set the security context.
     *
     * @param principal
     * @param credential
     * @return InitialContext
     * @throws Exception
     */
    public static InitialContext newInitialContext(String principal, String credential) throws Exception
    {
        Hashtable props = getInitialContextProperties(principal, credential);
        securedInitialContext = new InitialContext(props);
        return securedInitialContext;
    }

    /**
     * Return the default InitialContext based on org.jnp.interfaces.LocalOnlyContextFactory
     * if one is already instantiated, otherwise create a new InitialContext and set as the default.
     *
     * @return InitialContext
     * @throws Exception
     */
    public static InitialContext getInitialContext() throws Exception
    {
        if (initialContext == null)
        {
            Hashtable props = getInitialContextProperties();
            initialContext = new InitialContext(props);
        }
        return initialContext;
    }

    /**
     * Return the default InitialContext based on org.jboss.security.jndi.JndiLoginInitialContextFactory
     * if one is already instantiated, otherwise create a new InitialContext and set as the default.
     * Use the specified username and password to set the security context.
     *
     * @param principal
     * @param credential
     * @return
     * @throws Exception
     */
    public static InitialContext getInitialContext(String principal, String credential) throws Exception
    {
        if (securedInitialContext == null)
        {
            Hashtable props = getInitialContextProperties(principal, credential);
            securedInitialContext = new InitialContext(props);
        }
        return securedInitialContext;
    }

    private static Hashtable getInitialContextProperties()
    {
        Hashtable<String, String> props = new Hashtable<String, String>();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.LocalOnlyContextFactory");
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        return props;
    }

    private static Hashtable getInitialContextProperties(String principal, String credential)
    {
        Hashtable<String, String> props = new Hashtable<String, String>();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.security.jndi.JndiLoginInitialContextFactory");
        props.put(Context.SECURITY_PRINCIPAL, principal);
        props.put(Context.SECURITY_CREDENTIALS, credential);
        return props;
    }
}

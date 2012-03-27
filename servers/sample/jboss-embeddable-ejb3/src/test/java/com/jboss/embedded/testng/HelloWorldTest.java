package com.jboss.embedded.testng;

import javax.naming.InitialContext;

import org.jboss.ejb3.embedded.EJB3StandaloneBootstrap;
import org.jboss.ejb3.embedded.EJB3StandaloneDeployer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * The following test lunches the JBoss Embedded Container calls the remote
 * interface and then stops the container
 *
 */
public class HelloWorldTest
{

    // a boolean to test if the container is running or not
    private static boolean          containerRunning = false;

    // the EJB3 deployer
    private EJB3StandaloneDeployer  deployer;

    // The remote interface
    private HelloWorldServiceRemote helloWorldServiceRemote;

    // the local interface
    private HelloWorldServiceLocal  helloWorldServiceLocal;

    /**
     * This method is executed before the test methods. It starts the JBoss
     * Embedded Container
     * @throws Exception
     */
    @BeforeClass
    public void init() throws Exception
    {

        this.startupEmbeddedContainer();

        /**
         * Create proxies to call the HelloWorld Service
         */
        final InitialContext initialContext = new InitialContext();

        this.helloWorldServiceLocal = (HelloWorldServiceLocal) initialContext.lookup("HelloWorldServiceBean/local");
        this.helloWorldServiceRemote = (HelloWorldServiceRemote) initialContext.lookup("HelloWorldServiceBean/remote");

    }

    /**
     * call the local interface
     */
    @Test
    public void localTest()
    {
        this.helloWorldServiceLocal.print();
    }

    /**
     * call the remote interface
     */
    @Test
    public void remoteTest()
    {
        this.helloWorldServiceRemote.print();
    }

    /**
     * The method is executed after lunching all tests methods.
     * It stops and destroys the EJB3 deployer and shuts down the container
     * @throws Exception
     */
    @AfterClass
    public void terminate() throws Exception
    {
        // stop container
        this.deployer.stop();
        this.deployer.destroy();

        EJB3StandaloneBootstrap.shutdown();

        HelloWorldTest.containerRunning = false;
    }

    /**
     * The method starts the container and creates a deployer
     * using the persistence.xml file
     *
     * @throws Exception
     */
    private void startupEmbeddedContainer() throws Exception
    {
        if (!HelloWorldTest.containerRunning)
        {

            // start EJB microcontainer
            // configuration files ejb3-interceptors-aop.xml and
            // embedded-jboss-beans.xml are used
            EJB3StandaloneBootstrap.boot(null);

            /*
             * Create a deployer based on the persistence.xml file
             */
            this.deployer = EJB3StandaloneBootstrap.createDeployer();
            this.deployer.getArchivesByResource().add("META-INF/persistence.xml");
            this.deployer.create();
            this.deployer.start();

            HelloWorldTest.containerRunning = true;
        }
    }

}

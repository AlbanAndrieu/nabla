package org.andromda.timetracker.action;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.mock.JUnitSeamTest;
import org.jboss.seam.security.Credentials;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@RunWith(Arquillian.class)
public class AuthenticatorTest extends JUnitSeamTest //SeamOpenEjbTest
{

    private static final Logger logger = Logger.getLogger(AuthenticatorTest.class);

    /* 
    @Override
    @BeforeSuite
    public void beforeSuite() throws Exception
    {

        // System.out.println("**** AuthenticatorTest.beforeSuite()");

        // Change some logging, INFO|DEBUG|WARN|ERROR|FATAL contextProperties.put("log4j.category.org.jboss.seam.Component", "DEBUG");
        //AbstractSeamOpenEjbTest.contextProperties.put("log4j.category.org.jboss.seam.transaction", "DEBUG");
        //AbstractSeamOpenEjbTest.contextProperties.put("log4j.category.org.jboss.seam.mock", "DEBUG");
        //AbstractSeamOpenEjbTest.contextProperties.put("log4j.category.no.knowit.seam.openejb.mock", "DEBUG");
        //AbstractSeamOpenEjbTest.contextProperties.put("log4j.category.no.knowit.seam.example", "debug");
        super.beforeSuite();
    }
    */

    @Deployment
    @OverProtocol("Servlet 3.0")
    public static Archive<?> createDeployment()
    {
        EnterpriseArchive er = ShrinkWrap.create(ZipImporter.class)
        .importFrom(new File("../registration-ear/target/seam-registration.ear"))
        .as(EnterpriseArchive.class);
        WebArchive web = er.getAsType(WebArchive.class, "registration-web.war");
        web.addClasses(AuthenticatorTest.class);

        // Replacing the SeamListener with MockSeamListener

        web.delete("/WEB-INF/web.xml");

        web.addAsWebInfResource("WEB-INF/mock-web.xml", "web.xml");

        return er;

    }

    public void shouldAuthenticate() throws Exception
    {
        new ComponentTest()
        {
            @Test
            @Override
            protected void testComponents() throws Exception
            {

                AuthenticatorTest.logger.info("credentials : " + this.getValue("#{credentials}"));
                AuthenticatorTest.logger.info("authenticator : " + this.getValue("#{authenticator}"));
                // given
                final Credentials cred = (Credentials) this.getValue("#{credentials}");
                final Authenticator auth = (Authenticator) this.getValue("#{authenticator}");

                // when
                cred.setUsername("admin");
                cred.setPassword("cooldude");
                final boolean success1 = auth.authenticate();

                // then
                AssertJUnit.assertTrue(success1);

                final Set<String> roles = new TreeSet<String>();
                final boolean success2 = auth.authenticate("admin", "cooldude", roles);
                // then
                AssertJUnit.assertTrue(success2);

                for (final String role : roles)
                {
                    AuthenticatorTest.logger.info("authenticator role : " + role);
                }
                AssertJUnit.assertEquals(roles.toString(), "[Administrator, StandardUser]");
                // AuthenticatorTest.logger.info("authenticator role hosRole : " + this.getValue("#{identity.checkRole(\"Administrator\")}"));

            }
        }.run();
    }

}

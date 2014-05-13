package com.nabla.selenium.tests;

import java.math.BigDecimal;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.nabla.project.visma.LoanService;
import com.nabla.project.visma.api.ILoanService;

@RunWith(Arquillian.class)
public class LoanServiceITest
{

    // @TargetsContainer("weld")
    @Deployment
    // @org.jboss.arquillian.container.test.api.TargetsContainer("jetty")
    // @org.jboss.arquillian.container.test.api.TargetsContainer("jbossas_managed")
    public static Archive<?> createTestArchive()
    {
        // return ShrinkWrap.create(JavaArchive.class, "test.jar")
        return ShrinkWrap.create(WebArchive.class, "test.war").addClasses(ILoanService.class, LoanService.class).setWebXML("jsf-web.xml");
        /*
         * .addLibraries(
         * MavenArtifactResolver.resolveQualifiedIds("com.sun.faces:jsf-api:2.0.4-b03", "com.sun.faces:jsf-impl:2.0.4-b03", "org.jboss.weld.servlet:weld-servlet:1.1.0.Final",
         * "com.sun.faces:jsf-api:2.0.3-b05", "com.sun.faces:jsf-impl:2.0.3",
         * // "org.jboss.weld.servlet:weld-servlet:1.1.0.Final",
         * "org.glassfish.web:el-impl:2.2", "javax.annotation:jsr250-api:1.0", "javax.servlet:jstl:1.2")); // ,
         */
        // .addAsResource("loan.xhtml", "loan.xhtml").addAsResource("payment.xhtml", "payment.xhtml")
        // .addAsWebResource("faces-config.xml")
        // .addAsWebResource(EmptyAsset.INSTANCE, "beans.xml")
        // .addPackage(Package.getPackage("org.jboss.jsfunit.example.hellojsf"))
        // .setWebXML("jsf-web.xml");
        // add sample data
        // .addAsResource("import.sql")
        // enable CDI
        // .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    // @Inject
    ILoanService service = new LoanService();

    // @Inject
    // private static transient Logger LOGGER = Logger.getLogger(LoanServiceITest.class);

    @Test
    @InSequence(1)
    public void testRegister() throws Exception
    {
        final BigDecimal total = this.service.getTotalPayment(new BigDecimal(200_000), 30);

        Assert.assertNotNull(total);
        Assert.assertEquals("4565", total);
        ;
    }

}

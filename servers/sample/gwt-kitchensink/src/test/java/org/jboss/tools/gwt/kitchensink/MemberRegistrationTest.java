package org.jboss.tools.gwt.kitchensink;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.tools.gwt.kitchensink.client.shared.Member;
import org.jboss.tools.gwt.kitchensink.client.shared.MemberService;
import org.jboss.tools.gwt.kitchensink.controller.MemberServiceImpl;
import org.jboss.tools.gwt.kitchensink.util.Resources;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class MemberRegistrationTest
{
    @Deployment
    public static Archive<?> createTestArchive()
    {
        return ShrinkWrap.create(WebArchive.class, "gwt-kitchensink-test.war").addClasses(Member.class, MemberService.class, MemberServiceImpl.class, Resources.class)
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                // Deploy our test datasource
                .addAsWebInfResource("test-ds.xml", "test-ds.xml");
    }

    @Inject
    MemberService memberRegistration;

    @Inject
    Logger        log;

    @Test
    public void testRegister() throws Exception
    {
        Member newMember = new Member();
        newMember.setName("Jane Doe");
        newMember.setEmail("jane@mailinator.com");
        newMember.setPhoneNumber("2125551234");
        memberRegistration.register(newMember);
        assertNotNull(newMember.getId());
        log.info(newMember.getName() + " was persisted with id " + newMember.getId());
    }

}

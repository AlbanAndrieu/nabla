package org.andromda.timetracker.service.test;

import org.jboss.seam.mock.SeamTest;
import org.testng.annotations.Test;

public class RegisterActionSeamTest extends SeamTest
{

    @Test
    public void testRegisterComponent() throws Exception
    {

        new ComponentTest()
        {

            @Override
            protected void testComponents() throws Exception
            {
                this.setValue("#{user.username}", "1ovthafew");
                this.setValue("#{user.name}", "Gavin King");
                this.setValue("#{user.password}", "secret");
                assert this.invokeMethod("#{register.register}").equals("success");
                assert this.getValue("#{user.username}").equals("1ovthafew");
                assert this.getValue("#{user.name}").equals("Gavin King");
                assert this.getValue("#{user.password}").equals("secret");
            }

        }.run();

    }

    @Test
    public void testRegister() throws Exception
    {

        new FacesRequest()
        {

            @Override
            protected void processValidations() throws Exception
            {
                this.validateValue("#{user.username}", "1ovthafew");
                this.validateValue("#{user.name}", "Gavin King");
                this.validateValue("#{user.password}", "secret");
                assert !this.isValidationFailure();
            }

            @Override
            protected void updateModelValues() throws Exception
            {
                this.setValue("#{user.username}", "1ovthafew");
                this.setValue("#{user.name}", "Gavin King");
                this.setValue("#{user.password}", "secret");
            }

            @Override
            protected void invokeApplication()
            {
                assert this.invokeMethod("#{register.register}").equals("success");
            }

            @Override
            protected void renderResponse()
            {
                assert this.getValue("#{user.username}").equals("1ovthafew");
                assert this.getValue("#{user.name}").equals("Gavin King");
                assert this.getValue("#{user.password}").equals("secret");
            }

        }.run();
    }

}

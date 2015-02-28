package org.andromda.timetracker.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;

import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.security.PasswordEncoder;
import org.andromda.timetracker.service.UserDoesNotExistException;
import org.andromda.timetracker.service.UserServiceBean;
import org.andromda.timetracker.service.UserServiceLocal;
import org.andromda.timetracker.vo.UserVO;
import org.apache.log4j.Logger;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.Component;
import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.mock.JUnitSeamTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class RegisterActionTest extends JUnitSeamTest
{

    private static final Logger logger = Logger.getLogger(RegisterActionTest.class);

    /*
     * @Override
     * @BeforeSuite
     * public void beforeSuite() throws Exception {
     * // System.out.println("**** AuthenticatorTest.beforeSuite()");
     * // Change some logging, INFO|DEBUG|WARN|ERROR|FATAL
     * // contextProperties.put("log4j.category.org.jboss.seam.Component",
     * // "DEBUG");
     * //AbstractSeamOpenEjbTest.contextProperties.put("log4j.category.org.jboss.seam.transaction", "DEBUG");
     * //AbstractSeamOpenEjbTest.contextProperties.put("log4j.category.org.jboss.seam.mock", "DEBUG");
     * //AbstractSeamOpenEjbTest.contextProperties.put("log4j.category.no.knowit.seam.openejb.mock", "DEBUG");
     * //AbstractSeamOpenEjbTest.contextProperties.put("log4j.category.no.knowit.seam.example", "debug");
     * super.beforeSuite();
     * }
     */

    @Override
    @Before
    public void begin()
    {

        super.begin();

        try
        {
            new ComponentTest()
            {

                @Override
                protected void testComponents() throws Exception
                {

                    final UserServiceLocal userService = (UserServiceLocal) Component.getInstance(UserServiceBean.class, true);
                    // Remote testuser if it already exists
                    UserVO userVO = null;
                    try
                    {
                        userVO = userService.getUser("testusertmp");
                        if ((userVO != null) && (userVO.getId().longValue() > 0))
                        {
                            userService.removeUser(userVO);
                        }
                    } catch (final UserDoesNotExistException e)
                    {
                        RegisterActionTest.logger.debug("UserDoesNotExistException : " + e);
                    } catch (final Exception e)
                    {
                        RegisterActionTest.logger.debug("Exception : " + e);
                        Assert.fail();
                    }

                }

            }.run();
        } catch (final Exception e)
        {
            RegisterActionTest.logger.debug("Exception : " + e);
        }
    }

    @Test
    public void testRegisterComponent() throws Exception
    {

        new ComponentTest()
        {

            @Override
            protected void testComponents() throws Exception
            {
                this.setValue("#{user.username}", "testusertmp");
                this.setValue("#{user.firstName}", "John");
                this.setValue("#{user.lastName}", "Smith");
                this.setValue("#{user.email}", "john.smith@unknown.no");
                this.setValue("#{user.creationDate}", new Date());
                this.setValue("#{user.password}", "secret");
                this.setValue("#{register.verify}", "secret");
                assert this.invokeMethod("#{register.register}").equals("success");
                assert this.getValue("#{user.username}").equals("testusertmp");
                assert this.getValue("#{user.firstName}").equals("John");
                assert this.getValue("#{user.lastName}").equals("Smith");
                assert this.getValue("#{user.email}").equals("john.smith@unknown.no");
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
                this.validateValue("#{user.username}", "testusertmp");
                this.validateValue("#{user.firstName}", "John");
                this.validateValue("#{user.lastName}", "Smith");
                this.validateValue("#{user.email}", "john.smith@unknown.no");
                this.validateValue("#{user.creationDate}", new Date());
                this.validateValue("#{user.password}", "secret");
                assert !this.isValidationFailure();
            }

            @Override
            protected void updateModelValues() throws Exception
            {
                this.setValue("#{user.username}", "testusertmp");
                this.setValue("#{user.firstName}", "John");
                this.setValue("#{user.lastName}", "Smith");
                this.setValue("#{user.email}", "john.smith@unknown.no");
                this.setValue("#{user.creationDate}", new Date());
                this.setValue("#{user.password}", "secret");
                this.setValue("#{register.verify}", "secret");
            }

            @Override
            protected void invokeApplication()
            {
                assert this.invokeMethod("#{register.register}").equals("success");
            }

            @Override
            protected void renderResponse()
            {
                assert this.getValue("#{user.username}").equals("testusertmp");
                assert this.getValue("#{user.firstName}").equals("John");
                assert this.getValue("#{user.lastName}").equals("Smith");
                assert this.getValue("#{user.email}").equals("john.smith@unknown.no");
                assert this.getValue("#{user.password}").equals("secret");
            }

        }.run();
    }

    // @Test
    // Does not work with transaction type to JTA in persistence.xml
    public void testRegisterAction() throws Exception
    {

        new ComponentTest()
        {
            /*
             * private EntityManagerFactory emf;
             * public EntityManagerFactory getEntityManagerFactory()
             * {
             * return emf;
             * }
             */

            @Override
            protected void testComponents()
            {
                try
                {


                    Date date;

                    date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");

                    final User user = new User("admin", PasswordEncoder.getMD5Base64EncodedPassword("cooldude"), "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu");
                    Contexts.getSessionContext().set("user", user);

                    // this.setValue("#{identity.username}", "admin");
                    // this.setValue("#{identity.password}",
                    // PasswordEncoder.getMD5Base64EncodedPassword("cooldude"));
                    // this.invokeMethod("#{identity.login}");
                    // assert
                    // this.getValue("#{identity.loggedIn}").equals(true);

                    // final EntityManager em = this.getEntityManagerFactory().createEntityManager();
                    final EntityManager em = (EntityManager) new InitialContext().lookup("java:/EntityManagerFactories/timetracker-ejb3");

                    em.getTransaction().begin();

                    final RegisterAction action = new RegisterAction();
                    action.setUser(user);
                    action.setEntityManager(em);
                    action.setVerify(PasswordEncoder.getMD5Base64EncodedPassword("cooldude"));

                    // assert "success".equals(action.register());
                    Assert.assertNull(action.register()); // Already exist

                    em.getTransaction().commit();
                    em.close();

                } catch (final Exception e)
                {
                    RegisterActionTest.logger.info("error : " + e);
                    Assert.fail();
                } /*
                   * finally
                   * {
                   * emf.close();
                   * }
                   */
            }
        }.run();

    }

}

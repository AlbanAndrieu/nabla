package org.andromda.timetracker.service.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.security.PasswordEncoder;
import org.andromda.timetracker.service.RegisterAction;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterActionTest
{
    @Test
    public void testRegisterAction() throws Exception
    {

        final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
        final User user = new User("admin", PasswordEncoder.getMD5Base64EncodedPassword("cooldude"), "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu");
        // Contexts.getSessionContext().set("user", user);

        final EntityManager em = this.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        final RegisterAction action = new RegisterAction();
        action.setUser(user);
        action.setEntityManager(em);

        assert "success".equals(action.register());

        em.getTransaction().commit();
        em.close();
    }

    private EntityManagerFactory emf;

    public EntityManagerFactory getEntityManagerFactory()
    {
        return this.emf;
    }

    @BeforeClass
    public void init()
    {
        this.emf = Persistence.createEntityManagerFactory("timetracker-ejb3-contextEntityManagerFactory");
    }

    @AfterClass
    public void destroy()
    {
        this.emf.close();
    }

}

package org.andromda.timetracker.service;

import static org.jboss.seam.ScopeType.EVENT;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;

import org.andromda.timetracker.domain.User;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.security.Restrict;
import org.jboss.seam.ejb.SeamInterceptor;
import org.jboss.seam.faces.FacesMessages;

// error Could not instantiate Seam component: simpleService if @Stateful
@Stateful
@Scope(EVENT)
@Name("simpleService")
@Restrict("#{identity.loggedIn}")
@Interceptors(SeamInterceptor.class)
public class SimpleServiceBean implements SimpleService
{

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SimpleServiceBean.class);

    @In
    @Out
    private User                                 user;

    @In
    private EntityManager                        entityManager;

    @In
    private FacesMessages                        facesMessages;

    @Override
    public User getUser()
    {
        return this.user;
    }

    public void setUser(final User user)
    {
        this.user = user;
    }

    @Override
    public void loadUser(final String username)
    {
        SimpleServiceBean.logger.debug("revertUser Username : " + username);

        this.user = (User) this.entityManager.createQuery("select u from User u where u.username=:username").setParameter("username", username).getSingleResult();

        this.facesMessages.add("User loaded");
    }

    @Override
    @Remove
    @Destroy
    public void destroy()
    {
    }
}

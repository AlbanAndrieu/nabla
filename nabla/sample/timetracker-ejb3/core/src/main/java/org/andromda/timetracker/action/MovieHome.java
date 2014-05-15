package org.andromda.timetracker.action;

import org.andromda.timetracker.domain.Movie;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.security.Restrict;
import org.jboss.seam.framework.EntityHome;

@Name("movieHome")
public class MovieHome extends EntityHome<Movie>
{

    private static final long serialVersionUID = 1L;

    public void setMovieId(Long id)
    {
        setId(id);
    }

    public Long getMovieId()
    {
        return (Long) getId();
    }

    @Override
    protected Movie createInstance()
    {
        Movie movie = new Movie();
        return movie;
    }

    public void load()
    {
        if (isIdDefined())
        {
            wire();
        }
    }

    public void wire()
    {
        getInstance();
    }

    public boolean isWired()
    {
        return true;
    }

    public Movie getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    @Override
    @Restrict("#{identity.loggedIn}")
    public String persist()
    {
        return super.persist();
    }

    @Override
    @Restrict("#{identity.loggedIn}")
    public String update()
    {
        return super.update();
    }

    @Override
    @Restrict("#{identity.loggedIn}")
    public String remove()
    {
        return super.remove();
    }
}

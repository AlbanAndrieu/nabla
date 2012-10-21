package org.andromda.timetracker.action;

import java.util.Arrays;

import org.andromda.timetracker.domain.Movie;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

@Name("movieList")
public class MovieList extends EntityQuery<Movie>
{

    private static final long     serialVersionUID = 1L;
    private static final String   EJBQL            = "select movie from Movie movie";

    private static final String[] RESTRICTIONS     = { "lower(movie.title) like lower(concat(#{movieList.movie.title},'%'))", "lower(movie.director) like lower(concat(#{movieList.movie.director},'%'))", };

    private final Movie           movie            = new Movie();

    public MovieList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public Movie getMovie()
    {
        return movie;
    }
}

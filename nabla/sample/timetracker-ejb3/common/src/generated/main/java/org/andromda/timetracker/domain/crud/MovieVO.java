// license-header java merge-point
// Generated by: crud/SpringCrudValueObject.vsl in andromda-spring-cartridge.
package org.andromda.timetracker.domain.crud;

import java.io.Serializable;

/**
 * TODO: Model Documentation for org.andromda.timetracker.domain.Movie
 */
public class MovieVO
    implements Serializable
{
    /** The serial version UID of this class. Needed for serialization. */
    private static final long serialVersionUID = -5894565260968997027L;

    private String title;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.title
     * @return title
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.title
     * @param titleIn
     */
    public void setTitle(String titleIn)
    {
        this.title = titleIn;
    }

    private Integer year;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.year
     * @return year
     */
    public Integer getYear()
    {
        return this.year;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.year
     * @param yearIn
     */
    public void setYear(Integer yearIn)
    {
        this.year = yearIn;
    }

    private Integer version;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.version
     * @return version
     */
    public Integer getVersion()
    {
        return this.version;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.version
     * @param versionIn
     */
    public void setVersion(Integer versionIn)
    {
        this.version = versionIn;
    }

    private String director;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.director
     * @return director
     */
    public String getDirector()
    {
        return this.director;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.director
     * @param directorIn
     */
    public void setDirector(String directorIn)
    {
        this.director = directorIn;
    }

    private String plot;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.plot
     * @return plot
     */
    public String getPlot()
    {
        return this.plot;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.plot
     * @param plotIn
     */
    public void setPlot(String plotIn)
    {
        this.plot = plotIn;
    }

    private Long id;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.id
     * @return id
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.id
     * @param idIn
     */
    public void setId(Long idIn)
    {
        this.id = idIn;
    }

}
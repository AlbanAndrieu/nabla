package org.andromda.timetracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Version;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
public class Movie implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    // @GeneratedValue(strategy = IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long           id;

    @Version
    private Long              version;

    @org.hibernate.annotations.Index(name = "idx_director")
    @Column(nullable = false, length = 50)
    @NotNull
    @Length(max = 50)
    private String            director;

    @Column(unique = true, nullable = false, length = 60)
    @NotNull
    @Length(max = 60)
    private String            title;

    @Column(nullable = false)
    @NotNull
    private Integer           year;

    @Lob
    private String            plot;

    public Movie()
    {
    }

    public Movie(final String director, final String title, Integer year)
    {
        this.director = director;
        this.title = title;
        this.year = year;
    }

    public Movie(final String director, final String title, Integer year, final String plot)
    {
        this.director = director;
        this.title = title;
        this.year = year;
        this.plot = plot;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getVersion()
    {
        return version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    public String getDirector()
    {
        return director;
    }

    public void setDirector(final String director)
    {
        this.director = director;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public Integer getYear()
    {
        return year;
    }

    public void setYear(Integer year)
    {
        this.year = year;
    }

    public String getPlot()
    {
        return plot;
    }

    public void setPlot(final String plot)
    {
        this.plot = plot;
    }

}

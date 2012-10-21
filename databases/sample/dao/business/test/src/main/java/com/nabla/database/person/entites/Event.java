package com.nabla.database.person.entites;

import java.util.Date;

public class Event
{
    private Long   id;
    private String title;
    private Date   date;

    public Event()
    {
    }

    public Long getId()
    {
        return this.id;
    }

    // private void setId( Long id )
    // {
    // this.id = id;
    // }

    public Date getDate()
    {
        return this.date;
    }

    public void setDate(final Date date)
    {
        this.date = date;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }
}

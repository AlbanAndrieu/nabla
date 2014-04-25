package com.nabla.project.application.database.business.global.dao;

@SuppressWarnings("serial")
public class DaoException extends RuntimeException
{
    private int code;

    public DaoException(final int code)
    {
        super();
        this.code = code;
    }

    public DaoException(final String message, final int code)
    {
        super(message);
        this.code = code;
    }

    public DaoException(final Throwable cause, final int code)
    {
        super(cause);
        this.code = code;
    }

    public DaoException(final String message, final Throwable cause, final int code)
    {
        super(message, cause);
        this.code = code;
    }

    // getter et setter
    public int getCode()
    {
        return this.code;
    }

    public void setCode(final int code)
    {
        this.code = code;
    }
}

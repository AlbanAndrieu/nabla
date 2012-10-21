package com.nabla.database.person.dao;

@SuppressWarnings("serial")
public class DaoException extends RuntimeException
{
    // code d'erreur
    private int code;

    public DaoException(int code)
    {
        super();
        this.code = code;
    }

    public DaoException(String message, int code)
    {
        super(message);
        this.code = code;
    }

    public DaoException(Throwable cause, int code)
    {
        super(cause);
        this.code = code;
    }

    public DaoException(String message, Throwable cause, int code)
    {
        super(message, cause);
        this.code = code;
    }

    // getter et setter
    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }
}

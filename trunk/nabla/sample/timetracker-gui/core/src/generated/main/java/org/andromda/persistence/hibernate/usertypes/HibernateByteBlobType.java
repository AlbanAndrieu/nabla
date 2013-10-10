// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by hibernate/usertypes/HibernateByteBlobType.vsl in andromda-hibernate-cartridge on 10/04/2013 00:08:35+0200.
//
package org.andromda.persistence.hibernate.usertypes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.usertype.UserType;

/**
 * <p>
 * A hibernate user type which converts a Blob into a byte[] and back again.
 * </p>
 */
public class HibernateByteBlobType
    implements UserType, Serializable
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 4850231348151909385L;

    /**
     * @see org.hibernate.usertype.UserType#sqlTypes()
     */
    @Override
    public int[] sqlTypes()
    {
        return new int[]
        {
            Types.BLOB
        };
    }

    /**
     * @see org.hibernate.usertype.UserType#returnedClass()
     */
    @Override
    public Class<?> returnedClass()
    {
        return byte[].class;
    }

    /**
     * @see org.hibernate.usertype.UserType#equals(Object, Object)
     */
    @Override
    public boolean equals(Object x, Object y)
    {
        return (x == y)
            || (x != null && y != null && Arrays.equals(
                (byte[])x,
                (byte[])y));
    }

    /**
     * @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet, String[], Object)
     */
    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] names, Object owner) throws HibernateException, SQLException
    {
        final Object object;

        final InputStream inputStream = resultSet.getBinaryStream(names[0]);
        if (inputStream == null)
        {
            object = null;
        }
        else
        {
            final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            try
            {
                final byte[] buffer = new byte[65536];
                int read = -1;

                while ((read = inputStream.read(buffer)) > -1)
                {
                    outputStream.write(buffer, 0, read);
                }
                outputStream.close();
            }
            catch (IOException exception)
            {
                throw new HibernateException("Unable to read blob " + names[0], exception);
            }
            object = outputStream.toByteArray();
        }

        return object;
    }

    /**
     * @see org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement, Object, int)
     */
    @Override
    public void nullSafeSet(PreparedStatement statement, Object value, int index) throws SQLException
    {
        final byte[] bytes = (byte[])value;
        if (bytes == null)
        {
            try
            {
                statement.setBinaryStream(index, null, 0);
            }
            catch (SQLException exception)
            {
                Blob nullBlob = null;
                statement.setBlob(index, nullBlob);
            }
        }
        else
        {
            statement.setBinaryStream(index, new ByteArrayInputStream(bytes), bytes.length);
        }
    }

    /**
     * @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet, String[], Object)
     */
    public Object nullSafeGet(ResultSet resultSet, String[] names,
        SessionImplementor session, Object owner) throws HibernateException, SQLException
    {
        return this.nullSafeGet(resultSet, names, owner);
    }

    /**
     * @see org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement, Object, int)
     */
    public void nullSafeSet(
        PreparedStatement preparedStatement,
        Object data,
        int index,
        SessionImplementor session)
        throws HibernateException, SQLException
    {
        this.nullSafeSet(preparedStatement, data, index);
    }

    /**
     * @see org.hibernate.usertype.UserType#deepCopy(Object)
     */
    @Override
    public Object deepCopy(Object value)
    {
        if (value == null)
            return null;

        byte[] bytes = (byte[])value;
        byte[] result = new byte[bytes.length];
        System.arraycopy(bytes, 0, result, 0, bytes.length);

        return result;
    }

    /**
     * @see org.hibernate.usertype.UserType#isMutable()
     */
    @Override
    public boolean isMutable()
    {
        return true;
    }

    /**
     * @see org.hibernate.usertype.UserType#replace(Object, Object, Object)
     */
    @Override
    public Object replace(Object original, Object target, Object owner)
    {
        return original;
    }

    /**
     * @see org.hibernate.usertype.UserType#assemble(Serializable, Object)
     */
    @Override
    public Object assemble(Serializable cached, Object owner)
    {
        return cached;
    }

    /**
     * @see org.hibernate.usertype.UserType#disassemble(Object)
     */
    @Override
    public Serializable disassemble(Object value)
    {
        return (Serializable)value;
    }

    /**
     * @param x
     * @return x.hashCode()
     * @see Object#hashCode()
     */
    @Override
    public int hashCode(Object x)
    {
        return x.hashCode();
    }
}
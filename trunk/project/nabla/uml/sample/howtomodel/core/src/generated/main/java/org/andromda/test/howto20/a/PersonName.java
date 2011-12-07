// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: EmbeddedValue.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto20.a;

import java.io.Serializable;
import javax.persistence.Column;

/**
 * 
 *
 * Migrated from using @javax.persistence.Embeddable annotation to mapping in orm.xml
 * Still use the attribute annotations
 */
public abstract class PersonName
    implements Serializable
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 4092849071200240965L;

    /**
     * Creates a new instance of {@link PersonName}
     * taking all properties.
     */
    public static PersonName newInstance(String firstName,String surname)
    {
        PersonNameImpl object = new PersonNameImpl();
        object.setFirstName(firstName);
        object.setSurname(surname);
        object.initialize();
        return object;
    }

    /**
     * Creates a new instance from other PersonName instance.
     */
    public static PersonName newInstance(PersonName otherObject)
    {
        if (otherObject != null)
        {
            return newInstance(otherObject.getFirstName(),otherObject.getSurname());
        }
        return null;
    }

    protected PersonName()
    {
    }

    /**
     * Hook for initializing the object in the subclass
     */
    protected void initialize()
    {
    }

    private String firstName;

    /**
     * 
     */
    @Column(name = "FIRST_NAME", unique = true, nullable = false, insertable = true, updatable = true)
    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    private String surname;

    /**
     * 
     */
    @Column(name = "SURNAME", unique = true, nullable = false, insertable = true, updatable = true)
    public String getSurname()
    {
        return this.surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    /**
     * Indicates if the argument is of the same type and all values are equal.
     */
    /**
     * Indicates if the argument is of the same type and all values are equal.
     *
     * @param object The target object to compare with
     * @return boolean True if both objects a 'equal'
     */
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof PersonName))
        {
            return false;
        }
        final PersonName that = (PersonName)object;
        if (this.getFirstName() == null || that.getFirstName() == null || !this.getFirstName().equals(that.getFirstName()))
        {
            return false;
        }
        if (this.getSurname() == null || that.getSurname() == null || !this.getSurname().equals(that.getSurname()))
        {
            return false;
        }
        return true;
    }

    /**
     * Returns a hash code value for the object
     *
     * @return int The hash code value
     */
    public int hashCode()
    {
        int hashCode = 0;
        hashCode = 29 * hashCode + (getFirstName() == null ? 0 : getFirstName().hashCode());
        hashCode = 29 * hashCode + (getSurname() == null ? 0 : getSurname().hashCode());

        return hashCode;
    }

    /**
     * Returns a String representation of the object
     *
     * @return String Textual representation of the object displaying name/value pairs for all attributes
     */
    /**
     * Returns a String representation of the object
     *
     * @return String Textual representation of the object displaying name/value pairs for all attributes
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("PersonName(=");
        sb.append("firstName: ");
        sb.append(getFirstName());
        sb.append(", surname: ");
        sb.append(getSurname());
        sb.append(")");
        return sb.toString();
    }
}
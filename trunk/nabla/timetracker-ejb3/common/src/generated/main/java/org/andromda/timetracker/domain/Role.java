// license-header java merge-point
/* Autogenerated by AndroMDA Enumeration.vsl in andromda-ejb3-cartridge - do not edit */
package org.andromda.timetracker.domain;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Autogenerated enumeration Role.
 *
 * 
 */
public enum Role
{
    /** TODO: Model Documentation for Enumeration Literal STANDARD_USER value "StandardUser" */
    STANDARD_USER("StandardUser"),

    /** TODO: Model Documentation for Enumeration Literal ADMINISTRATOR value "Administrator" */
    ADMINISTRATOR("Administrator");

    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = -5786864769759743669L;

    private String enumValue = null;

    /**
     * Role constructor with enumeration literal value allowing
     * super classes to access it.
     */
    private Role(String value)
    {
        this.enumValue = value;
    }

    /**
     * Return the Role from a string value
     * @param value
     * @return Role enum object
     */
    public static Role fromString(String value)
    {
        return valueOf(value);
    }

    /**
     * Returns an instance of Role from String <code>value</code>.
     * Required by JAXB2 enumeration implementation
     *
     * @param value the value to create the Role from.
     * @return static Enumeration with corresponding value
     */
    public static Role fromValue(String value)
    {
        for (Role enumName: Role.values())
        {
            if (enumName.getValue().equals(value))
            {
                return enumName;
            }
        }
        throw new IllegalArgumentException("Role.fromValue(" + value + ')');
    }

    /**
     * Gets the underlying value of this type safe enumeration.
     * This method is necessary to comply with DaoBase implementation.
     * @return The name of this literal.
     */
    public String getValue()
    {
        return this.enumValue;
    }

    /**
     * Return a Collection of all literal values for this enumeration, can not be modified.
     * @return Collection<String> literal values
     */
    public static Collection<String> literals()
    {
        final Collection<String> literals = new ArrayList<String>(values().length);
        for (int i = 0; i < values().length; i++)
        {
            literals.add(values()[i].name());
        }
        return literals;
    }
}
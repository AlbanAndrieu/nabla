// license-header java merge-point
/* Autogenerated by AndroMDA Enumeration.vsl in andromda-ejb3-cartridge - do not edit */
package org.andromda.test.howto10.a;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Autogenerated enumeration CarType.
 *
 * 
 */
public enum CarType
{
    /** TODO: Model Documentation for Enumeration Literal SEDAN value "SEDAN" */
    SEDAN("SEDAN"),

    /** TODO: Model Documentation for Enumeration Literal LIFTBACK value "LIFTBACK" */
    LIFTBACK("LIFTBACK"),

    /** TODO: Model Documentation for Enumeration Literal STATION_WAGON value "STATION_WAGON" */
    STATION_WAGON("STATION_WAGON");

    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = -4722917701229405625L;

    private String enumValue = null;

    /**
     * CarType constructor with enumeration literal value allowing
     * super classes to access it.
     */
    private CarType(String value)
    {
        this.enumValue = value;
    }

    /**
     * Return the CarType from a string value
     * @param value
     * @return CarType enum object
     */
    public static CarType fromString(String value)
    {
        return valueOf(value);
    }

    /**
     * Returns an instance of CarType from String <code>value</code>.
     * Required by JAXB2 enumeration implementation
     *
     * @param value the value to create the CarType from.
     * @return static Enumeration with corresponding value
     */
    public static CarType fromValue(String value)
    {
        for (CarType enumName: CarType.values())
        {
            if (enumName.getValue().equals(value))
            {
                return enumName;
            }
        }
        throw new IllegalArgumentException("CarType.fromValue(" + value + ')');
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
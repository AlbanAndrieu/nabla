// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: TypeSafeEnumeration.vsl in andromda-java-cartridge.
// Model Class:  Data::timetracker::org.andromda.timetracker::domain::Role
// Metafacade:   org.andromda.metafacades.uml.Enumeration
// Stereotype:  Enumeration
//
package org.andromda.timetracker.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
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

    private final String enumValue;

    /**
     * The constructor with enumeration literal value allowing
     * super classes to access it.
     */
    private Role(String value)
    {
        this.enumValue = value;
    }

    /*
     * Do not override this method directly. Use an alternate name
     * if providing a different toString implementation
     * @see Object#toString()
    @Override
    public String toString()
    {
        return String.valueOf(this.enumValue);
    }
     */

    /**
     * Retrieves an instance of Role from <code>its name</code>.
     *
     * @param name the name to create the Role from.
     * @return The enumeration literal named after the 'name' argument
     */
    public static Role fromString(String name)
    {
        return Role.valueOf(name);
    }

    /**
     * Returns an enumeration literal String <code>value</code>.
     * Required by JAXB2 enumeration implementation
     *
     * @return String with corresponding value
     */
    public String value()
    {
        return this.enumValue;
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
     * Returns an unmodifiable list containing the literals that are known by this enumeration.
     *
     * @return A List containing the actual literals defined by this enumeration, this list
     *         can not be modified.
     */
    public static List<String> literals()
    {
        return Role.literals;
    }

    /**
     * Returns an unmodifiable list containing the names of the literals that are known
     * by this enumeration.
     *
     * @return A List containing the actual names of the literals defined by this
     *         enumeration, this list can not be modified.
     */
    public static List<String> names()
    {
        return Role.names;
    }

    private static Map<String, Role> values = new LinkedHashMap<String, Role>(2, 1);
    private static List<String> literals = new ArrayList<String>(2);
    private static List<String> names = new ArrayList<String>(2);
    private static List<Role> valueList = new ArrayList<Role>(2);

    /**
     * Initializes the values.
     */
    static
    {
        synchronized (Role.values)
        {
            Role.values.put(STANDARD_USER.enumValue, STANDARD_USER);
            Role.values.put(ADMINISTRATOR.enumValue, ADMINISTRATOR);
        }
        synchronized (Role.valueList)
        {
            Role.valueList.add(STANDARD_USER);
            Role.valueList.add(ADMINISTRATOR);
            Role.valueList = Collections.unmodifiableList(valueList);
        }
        synchronized (Role.literals)
        {
            Role.literals.add(STANDARD_USER.enumValue);
            Role.literals.add(ADMINISTRATOR.enumValue);
            Role.literals = Collections.unmodifiableList(literals);
        }
        synchronized (Role.names)
        {
            Role.names.add("STANDARD_USER");
            Role.names.add("ADMINISTRATOR");
            Role.names = Collections.unmodifiableList(names);
        }
    }
    // type-safe-enumeration-object java merge-point
}
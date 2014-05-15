package org.andromda.cartridges.ejb3;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import org.andromda.cartridges.ejb3.HibernateGlobals;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;

/**
 * Contains utilities used within the Hibernate cartridge.
 *
 * @author Chad Brandon
 * @author Joel Kozikowski
 * @author Wouter Zoons
 */
public class HibernateUtils
{

    /**
     * Stores the version of Hibernate we're generating for.
     */
    private String hibernateVersion;

    /**
     * Sets the version of Hibernate we're generating for.
     *
     * @param hibernateVersion The version to set.
     */
    public void setHibernateVersion(final String hibernateVersion)
    {
        this.hibernateVersion = hibernateVersion;
    }

    /**
     * Retrieves the appropriate Hibernate package for the given version.
     *
     * @return the Hibernate package name.
     */
    public String getHibernatePackage()
    {
        return this.isVersion3() || this.isVersion4() ? "org.hibernate" : "net.sf.hibernate";
    }

    /**
     * Retrieves the appropriate package for Hibernate user types given
     * the version defined within this class.
     *
     * @return the hibernate user type package.
     */
    public String getHibernateUserTypePackage()
    {
        return this.isVersion3() || this.isVersion4() ? this.getHibernatePackage() + ".usertype" : this.getHibernatePackage();
    }

    /**
     * Indicates whether or not Hibernate 2 is enabled.
     *
     * @return true/false
     */
    public boolean isVersion2()
    {
        return isVersion2(this.hibernateVersion);
    }

    /**
     * Indicates whether or not Hibernate 3 is enabled.
     *
     * @return true/false
     */
    public boolean isVersion3()
    {
        return isVersion3(this.hibernateVersion);
    }

    /**
     * Indicates whether or not Hibernate 3 is enabled.
     *
     * @return true/false
     */
    public boolean isVersion4()
    {
        return isVersion4(this.hibernateVersion);
    }

    /**
     * Indicates whether or not the given property value is version 3 or not.
     *
     * @param hibernateVersionPropertyValue the value of the property
     * @return true/false
     */
    public static boolean isVersion2(String hibernateVersionPropertyValue)
    {
        boolean version2 = false;
        if (hibernateVersionPropertyValue != null)
        {
            version2 = hibernateVersionPropertyValue.startsWith(HibernateGlobals.HIBERNATE_VERSION_2);
        }
        return version2;
    }

    /**
     * Indicates whether or not the given property value is version 3 or not.
     *
     * @param hibernateVersionPropertyValue the value of the property
     * @return true/false
     */
    public static boolean isVersion3(String hibernateVersionPropertyValue)
    {
        boolean version3 = false;
        if (hibernateVersionPropertyValue != null)
        {
            version3 = hibernateVersionPropertyValue.startsWith(HibernateGlobals.HIBERNATE_VERSION_3);
        }
        return version3;
    }

    /**
     * Indicates whether or not the given property value is version 3 or not.
     *
     * @param hibernateVersionPropertyValue the value of the property
     * @return true/false
     */
    public static boolean isVersion4(String hibernateVersionPropertyValue)
    {
        boolean version4 = false;
        if (hibernateVersionPropertyValue != null)
        {
            version4 = hibernateVersionPropertyValue.startsWith(HibernateGlobals.HIBERNATE_VERSION_4);
        }
        return version4;
    }

}

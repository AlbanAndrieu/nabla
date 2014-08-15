package org.andromda.cartridges.ejb3;

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
     * Stores the version of Persistence we're generating for.
     */
    private String persistenceVersion;

    /**
     * Stores the version of Seam we're generating for.
     */
    private String seamVersion;

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
     * Indicates whether or not Hibernate 4 is enabled.
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
     * Indicates whether or not the given property value is version 4 or not.
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

    /**
     * Sets the version of Persistence we're generating for.
     * 
     * @param persistenceVersion The version to set.
     */
    public void setPersistenceVersion(final String persistenceVersion)
    {
        this.persistenceVersion = persistenceVersion;
    }

    /**
     * Indicates whether or not Persistence 1 is enabled.
     * 
     * @return true/false
     */
    public boolean isPersistenceVersion1()
    {
        return isPersistenceVersion1(this.persistenceVersion);
    }

    /**
     * Indicates whether or not Persistence 2 is enabled.
     * 
     * @return true/false
     */
    public boolean isPersistenceVersion2()
    {
        return isPersistenceVersion2(this.persistenceVersion);
    }

    /**
     * Indicates whether or not Persistence 3 is enabled.
     * 
     * @return true/false
     */
    public boolean isPersistenceVersion3()
    {
        return isPersistenceVersion3(this.persistenceVersion);
    }

    /**
     * Indicates whether or not the given property value is version 1 or not.
     * 
     * @param persistenceVersionPropertyValue the value of the property
     * @return true/false
     */
    public static boolean isPersistenceVersion1(String persistenceVersionPropertyValue)
    {
        boolean version1 = false;
        if (persistenceVersionPropertyValue != null)
        {
            version1 = persistenceVersionPropertyValue.startsWith(HibernateGlobals.PERSISTENCE_VERSION_1);
        }
        return version1;
    }

    /**
     * Indicates whether or not the given property value is version 2 or not.
     * 
     * @param persistenceVersionPropertyValue the value of the property
     * @return true/false
     */
    public static boolean isPersistenceVersion2(String persistenceVersionPropertyValue)
    {
        boolean version2 = false;
        if (persistenceVersionPropertyValue != null)
        {
            version2 = persistenceVersionPropertyValue.startsWith(HibernateGlobals.PERSISTENCE_VERSION_2);
        }
        return version2;
    }

    /**
     * Indicates whether or not the given property value is version 3 or not.
     * 
     * @param persistenceVersionPropertyValue the value of the property
     * @return true/false
     */
    public static boolean isPersistenceVersion3(String persistenceVersionPropertyValue)
    {
        boolean version3 = false;
        if (persistenceVersionPropertyValue != null)
        {
            version3 = persistenceVersionPropertyValue.startsWith(HibernateGlobals.PERSISTENCE_VERSION_3);
        }
        return version3;
    }

    /**
     * Sets the version of Seam we're generating for.
     * 
     * @param seamVersion The version to set.
     */
    public void setSeamVersion(final String seamVersion)
    {
        this.seamVersion = seamVersion;
    }

    /**
     * Indicates whether or not Seam 2 is enabled.
     * 
     * @return true/false
     */
    public boolean isSeamVersion22()
    {
        return isSeamVersion22(this.seamVersion);
    }

    /**
     * Indicates whether or not Seam 3 is enabled.
     * 
     * @return true/false
     */
    public boolean isSeamVersion23()
    {
        return isSeamVersion23(this.seamVersion);
    }

    /**
     * Indicates whether or not Seam 3 is enabled.
     * 
     * @return true/false
     */
    public boolean isSeamVersion3()
    {
        return isSeamVersion3(this.seamVersion);
    }

    /**
     * Indicates whether or not the given property value is version 2.2 or not.
     * 
     * @param seamVersionPropertyValue the value of the property
     * @return true/false
     */
    public static boolean isSeamVersion22(String seamVersionPropertyValue)
    {
        boolean version2 = false;
        if (seamVersionPropertyValue != null)
        {
            version2 = seamVersionPropertyValue.startsWith(HibernateGlobals.SEAM_VERSION_2_2);
        }
        return version2;
    }

    /**
     * Indicates whether or not the given property value is version 2.3 or not.
     * 
     * @param seamVersionPropertyValue the value of the property
     * @return true/false
     */
    public static boolean isSeamVersion23(String seamVersionPropertyValue)
    {
        boolean version3 = false;
        if (seamVersionPropertyValue != null)
        {
            version3 = seamVersionPropertyValue.startsWith(HibernateGlobals.SEAM_VERSION_2_3);
        }
        return version3;
    }

    /**
     * Indicates whether or not the given property value is version 3 or not.
     * 
     * @param seamVersionPropertyValue the value of the property
     * @return true/false
     */
    public static boolean isSeamVersion3(String seamVersionPropertyValue)
    {
        boolean version3 = false;
        if (seamVersionPropertyValue != null)
        {
            version3 = seamVersionPropertyValue.startsWith(HibernateGlobals.SEAM_VERSION_3);
        }
        return version3;
    }

}

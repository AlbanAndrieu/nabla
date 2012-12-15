// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import org.andromda.metafacades.uml.ManageableEntity;

/**
 * TODO: Model Documentation for org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3ManageableEntityFacade
    extends EJB3EntityFacade, ManageableEntity
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3ManageableEntityFacadeMetaType();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade.daoReferenceName
     * @return String
     */
    public String getDaoReferenceName();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade.fullyQualifiedManageableDaoBaseName
     * @return String
     */
    public String getFullyQualifiedManageableDaoBaseName();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade.fullyQualifiedManageableDaoName
     * @return String
     */
    public String getFullyQualifiedManageableDaoName();

    /**
     * Returns the fully qualified manageable service base class name that contains the
     * implementation.
     * @return String
     */
    public String getFullyQualifiedManageableServiceBaseName();

    /**
     * Returns the fully qualified name of the application create exception.
     * @return String
     */
    public String getFullyQualifiedManageableServiceCreateExceptionName();

    /**
     * Returns the fully qualified delete application exception name.
     * @return String
     */
    public String getFullyQualifiedManageableServiceDeleteExceptionName();

    /**
     * Returns the fully qualified name of the application read exception.
     * @return String
     */
    public String getFullyQualifiedManageableServiceReadExceptionName();

    /**
     * Returns the fully qualified update application exception name.
     * @return String
     */
    public String getFullyQualifiedManageableServiceUpdateExceptionName();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade.fullyQualifiedManageableValueObjectName
     * @return String
     */
    public String getFullyQualifiedManageableValueObjectName();

    /**
     * Returns the JNDI name prefix for this menageable session bean.  This is set using the
     * jndiNamePrefix namespace property and is commonly the ear file name excluding the extension
     * for the EJB3 cartridge.  The JNDI name prefix is applied like so:
     * jndiPrefix/EJBName/Remote
     * @return String
     */
    public String getJndiNamePrefix();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade.manageableDaoBaseFullPath
     * @return String
     */
    public String getManageableDaoBaseFullPath();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade.manageableDaoBaseName
     * @return String
     */
    public String getManageableDaoBaseName();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade.manageableDaoFullPath
     * @return String
     */
    public String getManageableDaoFullPath();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade.manageableDaoName
     * @return String
     */
    public String getManageableDaoName();

    /**
     * Returns the comma separated list of roles which are used to secure manageable service beans.
     * @return String
     */
    public String getManageableRolesAllowed();

    /**
     * Returns the manageable service base class fully qualified path used to set the template
     * generated file.
     * @return String
     */
    public String getManageableServiceBaseFullPath();

    /**
     * Returns the manageable service base class name.  This is the manageable session bean
     * containing the CRUD implementation.
     * @return String
     */
    public String getManageableServiceBaseName();

    /**
     * Returns the manageable service create exception name.
     * @return String
     */
    public String getManageableServiceCreateExceptionName();

    /**
     * Returns the manageable service delete exception name.
     * @return String
     */
    public String getManageableServiceDeleteExceptionName();

    /**
     * Returns the manageable service read exception name.
     * @return String
     */
    public String getManageableServiceReadExceptionName();

    /**
     * Returns the manageable service update exception name.
     * @return String
     */
    public String getManageableServiceUpdateExceptionName();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade.manageableValueObjectClassName
     * @return String
     */
    public String getManageableValueObjectClassName();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade.manageableValueObjectFullPath
     * @return String
     */
    public String getManageableValueObjectFullPath();
}
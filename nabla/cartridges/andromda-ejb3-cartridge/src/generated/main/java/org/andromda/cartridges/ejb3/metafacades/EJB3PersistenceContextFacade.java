// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import org.andromda.metafacades.uml.ClassifierFacade;

/**
 * Metafacade for a persistence context definition
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3PersistenceContextFacade
    extends ClassifierFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3PersistenceContextFacadeMetaType();

    /**
     * Specifies whether the persistence context for this EntityManager is transaction scoped or
     * extended.  This is derived from the andromda.service.persistence.cotnext.unit.type tag on the
     * PersistenceContext class referenced by dependency.
     * @return String
     */
    public String getContextType();

    /**
     * Returns the datasource specified via the andromda.service.persistence.context.datasource tag
     * on the PersistenceContext class referenced by dependency.
     * @return String
     */
    public String getDatasource();

    /**
     * Returns the persistence context unit name for the injected EntityManger.  This looks up the
     * andromda.service.persistence.context.unit.name on the PersistenceContext class, referenced by
     * dependency and is only required if multiple persistence units exists.
     * @return String
     */
    public String getUnitName();
}
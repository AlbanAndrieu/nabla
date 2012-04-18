// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import org.andromda.metafacades.uml.ManageableEntityAssociationEnd;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3ManageableEntityAssociationEndFacade
    extends ManageableEntityAssociationEnd, EJB3AssociationEndFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3ManageableEntityAssociationEndFacadeMetaType();

    /**
     * 
     * @return String
     */
    public String getDaoGetterName();

    /**
     * 
     * @return String
     */
    public String getDaoName();

    /**
     * 
     * @return String
     */
    public String getDaoReferenceName();

    /**
     * 
     * @return String
     */
    public String getDaoSetterName();
}
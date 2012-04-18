// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import org.andromda.metafacades.uml.ParameterFacade;

/**
 * Represents an argument in a EJB3 finder method.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3FinderMethodArgumentFacade
    extends ParameterFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3FinderMethodArgumentFacadeMetaType();

    /**
     * Returns the temporal type value set via tagged value on finder method parameters if one
     * exists.  Expect one of DATE, TIME, TIMESTAMP or NONE.  This is used in the Query.setParameter
     * method.
     * @return String
     */
    public String getTemporalType();

    /**
     * Returns true if this parameter is of type enum and has ordinal values.
     * @return boolean
     */
    public boolean isEnumerationTypeOrdinal();

    /**
     * Returns true if this parameter is of type enum and has string values.
     * @return boolean
     */
    public boolean isEnumerationTypeString();

    /**
     * Returns true if FirstResult stereotype is applied to this finder method parameter.
     * @return boolean
     */
    public boolean isFirstResult();

    /**
     * Returns true if MaxResults stereotype is applied to this finder method parameter.
     * @return boolean
     */
    public boolean isMaxResults();
}
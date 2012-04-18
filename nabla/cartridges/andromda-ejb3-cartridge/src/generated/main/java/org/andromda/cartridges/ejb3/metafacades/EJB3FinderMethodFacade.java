// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import org.andromda.metafacades.uml.EntityQueryOperation;

/**
 * Represents an EJB finder method.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3FinderMethodFacade
    extends EntityQueryOperation
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3FinderMethodFacadeMetaType();

    /**
     * The query string for this EJB entity finder.
     * @return String
     */
    public String getQuery();

    /**
     * Gets the query; taking the entity of which should be included in the query (not counting
     * queries that are explicitly modeled in OCL).
     * @param entity EJB3EntityFacade
     * @return String
     */
    public String getQuery(EJB3EntityFacade entity);

    /**
     * Gets the transaction type for this finder (i.e. REQUIRED, etc)
     * @return String
     */
    public String getTransactionType();

    /**
     * Returns true if query is specified using OCL or created by AndroMDA itself.  Return false if
     * specified using tagged value.
     * @return boolean
     */
    public boolean isNamedQuery();

    /**
     * Indicates whether or not the query parameters used for the body of the finder should be named
     * ':someParam' or unnamed '?'.
     * @return boolean
     */
    public boolean isUseNamedParameters();

    /**
     * Returns true if this query has the andromda_ejb_query_useCache tagged value true or the
     * application wide namespace property hibernateUseQueryCache is enabled.
     * @return boolean
     */
    public boolean isUseQueryCache();
}
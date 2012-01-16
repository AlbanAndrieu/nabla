// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * Represents a persistent entity finder method.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EntityQueryOperation
    extends OperationFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEntityQueryOperationMetaType();

    /**
     * The query string for this EntityFinderMethod.  The query returned is based on the
     * 'translation' passed in.  The translation must be one available to AndroMDA found with a
     * translation-library.
     * @param translation String
     * @return String
     */
    public String getQuery(String translation);
}
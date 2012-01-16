// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * A user-defined data value for an enumeration.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EnumerationLiteralFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEnumerationLiteralFacadeMetaType();

    /**
     * Gets the Literal's Value. This will be used to create the Literal's Instance.
     * @return String
     */
    public String getEnumerationValue();

    /**
     * Gets the name of the enumeration literal (if the "modelName" flag is true, then the actual
     * name of the literal in the model is returned - otherwise the name that has any masking
     * applied).
     * @param modelName boolean
     * @return String
     */
    public String getName(boolean modelName);

    /**
     * Returns the value of this enumeration literal, by default the value is the same as the name.
     * @return String
     */
    public String getValue();

    /**
     * Gets the value of the enumeration literal  (if the "modelValue" flag is true, then the actual
     * value of the literal in the model is returned - otherwise the value that has any masking
     * applied is returned).
     * @param modelValue boolean
     * @return String
     */
    public String getValue(boolean modelValue);
}
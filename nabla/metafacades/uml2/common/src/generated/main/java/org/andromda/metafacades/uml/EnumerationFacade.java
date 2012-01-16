// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * Represents an enumeration. A data type whose values are enumerated in the model as enumeration
 * literals. May also be a Classifier with Stereotype Enumeration.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EnumerationFacade
    extends ClassifierFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEnumerationFacadeMetaType();

    /**
     * The 'from' operation name.  This is the name of the operation that takes the actual literal
     * value and allows a new enumeration to be constructed.
     * @return String
     */
    public String getFromOperationName();

    /**
     * The 'from' operation signature.  This is the signature that takes the actual literal value
     * and allows a new enumeration to be constructed.
     * @return String
     */
    public String getFromOperationSignature();

    /**
     * The type of the enumeration's literals.
     * @return ClassifierFacade
     */
    public ClassifierFacade getLiteralType();

    /**
     * This enumeration's literals.
     * @return Collection<AttributeFacade>
     */
    public Collection<AttributeFacade> getLiterals();

    /**
     * The enumeration member variables.
     * @return Collection<AttributeFacade>
     */
    public Collection<AttributeFacade> getMemberVariables();

    /**
     * Indicates whether the enumeration must be generated using a Java 5 type-safe enum or a
     * traditional enumeration-pattern class.
     * @return boolean
     */
    public boolean isTypeSafe();
}
// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;
import org.andromda.core.metafacade.ModelValidationMessage;

/**
 * Represents a UML template parameter. Exposes a parameterable element as a formal template
 * parameter of a template.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface TemplateParameterFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isTemplateParameterFacadeMetaType();

    /**
     * Provides any required initialization of the metafacade.
     */
    void initialize();

    /**
     * Gets the metafacade that acts as the <code>owner</code> of this metafacade.
     * (for example: an operation is an owner of its parameters, etc). This is used
     * by AndroMDA's validation framework to provide more context as to where the
     * error has occurred.
     * @return Object the Validation Owner
     */
    public Object getValidationOwner();

    /**
     * Gets the name of the metafacade used within validation messages.  This provides
     * the full name of the metafacade.
     * @return String the Validation Name
     */
    public String getValidationName();

    /**
     * Performs validation of any invariants found on this model element
     * and stores the messages within the <code>validationMessages</code>
     * collection.
     *
     * @param validationMessages the collection of messages to which additional
     *        validation messages will be added if invariants are broken.
     */
    void validateInvariants(Collection<ModelValidationMessage> validationMessages);

    /**
     * 
     * @return ModelElementFacade
     */
    public ModelElementFacade getDefaultElement();

    /**
     * 
     * @return ModelElementFacade
     */
    public ModelElementFacade getParameter();
}
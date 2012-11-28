// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;
import org.andromda.core.metafacade.ModelValidationMessage;

/**
 * Represents the model object 'Template Parameter Substitution'. Relates the actual parameter(s) to
 * a formal template parameter as part of a template binding.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface TemplateArgumentFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isTemplateArgumentFacadeMetaType();

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
     * Represents a model element. It may be an Element or NamedElement. A named element is an
     * element in a
     * model that may have a name. An element is a constituent of a model. As such, it has the
     * capability
     * of owning other elements.
     * @return ModelElementFacade
     */
    public ModelElementFacade getElement();
}
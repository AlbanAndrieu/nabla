// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * A representation of the model object 'Template Binding'. Represents a relationship between a
 * templateable element and a template. Specifies the substitutions of actual parameters for the
 * formal parameters of the template.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface BindingFacade
    extends DependencyFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isBindingFacadeMetaType();

    /**
     * The arguments for this binding.
     * @return Collection<TemplateArgumentFacade>
     */
    public Collection<TemplateArgumentFacade> getArguments();
}
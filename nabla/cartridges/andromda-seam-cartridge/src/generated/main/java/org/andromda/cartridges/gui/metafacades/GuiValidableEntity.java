// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import java.util.List;
import org.andromda.metafacades.uml.Entity;

/**
 * A Validable entity handles Validable stereotype. Its a particular Manageable entity in the way it
 * carries some of the Manageable use cases, overrides some others, and defines specific ones.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiValidableEntity
    extends GuiManageableEntity
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiValidableEntityMetaType();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiValidableEntity.eachValidableObjectReferenceIsValid
     * @return boolean
     */
    public boolean eachValidableObjectReferenceIsValid();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiValidableEntity.getIdentifierForValidableObjectReference
     * @param businessObjectName String
     * @return String
     */
    public String getIdentifierForValidableObjectReference(String businessObjectName);

    /**
     * Represents a persistent entity.
     * @return List<Entity>
     */
    public List<Entity> getValidableObjectReferences();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiValidableEntity.validationNameSuffix
     * @return String
     */
    public String getValidationNameSuffix();
}
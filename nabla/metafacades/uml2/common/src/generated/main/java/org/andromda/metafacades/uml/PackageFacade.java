// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * Used to group elements, and provides a namespace for the grouped elements. A package can have one
 * or more profile applications to indicate which profiles have been applied. Because a profile is a
 * package, it is possible to apply a profile not only to packages, but also to profiles. Package
 * specializes TemplateableElement and PackageableElement specializes ParameterableElement to
 * specify that a package can be used as a template and a PackageableElement as a template
 * parameter.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface PackageFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isPackageFacadeMetaType();

    /**
     * Finds the model element with the given 'fullyQualifiedName', or returns null if one can't be
     * found with that name.
     * @param fullyQualifiedName String
     * @return ModelElementFacade
     */
    public ModelElementFacade findModelElement(String fullyQualifiedName);

    /**
     * Returns all classes in this package
     * @return Collection<ClassifierFacade>
     */
    public Collection<ClassifierFacade> getClasses();

    /**
     * Gets all the model elements belonging to the root package.
     * @return Collection<ModelElementFacade>
     */
    public Collection<ModelElementFacade> getModelElements();

    /**
     * The elements directly found in this package.
     * @return Collection<ModelElementFacade>
     */
    public Collection<ModelElementFacade> getOwnedElements();

    /**
     * returns all packages belonging to this package.
     * @return Collection<PackageFacade>
     */
    public Collection<PackageFacade> getSubPackages();

    /**
     * The Entity table prefix to be used for this package.
     * @return String
     */
    public String getTablePrefix();
}
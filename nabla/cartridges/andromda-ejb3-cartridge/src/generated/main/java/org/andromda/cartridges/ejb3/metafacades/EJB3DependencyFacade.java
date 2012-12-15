// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import org.andromda.metafacades.uml.DependencyFacade;

/**
 * TODO: Model Documentation for org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3DependencyFacade
    extends DependencyFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3DependencyFacadeMetaType();

    /**
     * The name of the DAO reference getter name.
     * @return String
     */
    public String getDaoGetterName();

    /**
     * The name given to a DAO reference.
     * @return String
     */
    public String getDaoName();

    /**
     * The DAO reference setter's name.
     * @return String
     */
    public String getDaoSetterName();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade.transformationAnonymousName
     * @return String
     */
    public String getTransformationAnonymousName();

    /**
     * The name of the constant designated for use as a transformation flag for value objects (only
     * makes sense when this dependency goes into a value object).
     * @return String
     */
    public String getTransformationConstantName();

    /**
     * Gets the transformation constant integer value.
     * @return int
     */
    public int getTransformationConstantValue();

    /**
     * The name of the method used for transformation into a value object (only makes sense when
     * this dependency goes into a value object).
     * @return String
     */
    public String getTransformationMethodName();

    /**
     * Returns the name of the method for transforming the contents of a collection.
     * @return String
     */
    public String getTransformationToCollectionMethodName();

    /**
     * The method name that performs the value object collection to entity collection
     * transformation.
     * @return String
     */
    public String getTransformationToEntityCollectionMethodName();

    /**
     * The name of the "to entity" transformation method name.
     * @return String
     */
    public String getTransformationToEntityMethodName();

    /**
     * The name of the class that performs the value object to entity transformation.
     * @return String
     */
    public String getValueObjectToEntityTransformerName();

    /**
     * Indicates if this dependency is part of a circular reference (meaning that both entities
     * reference each other).
     * @return boolean
     */
    public boolean isCircularReference();
}
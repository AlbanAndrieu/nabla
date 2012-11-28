// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.List;

/**
 * An association describes a set of tuples whose values refer to typed instances. An instance of an
 * association is called a link.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface AssociationFacade
    extends GeneralizableElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isAssociationFacadeMetaType();

    /**
     * The first association end.
     * @return AssociationEndFacade
     */
    public AssociationEndFacade getAssociationEndA();

    /**
     * The second association end.
     * @return AssociationEndFacade
     */
    public AssociationEndFacade getAssociationEndB();

    /**
     * Gets the association ends belonging to this association.
     * @return List<AssociationEndFacade>
     */
    public List<AssociationEndFacade> getAssociationEnds();

    /**
     * A name suited for naming this relationship. This name will be constructed from both
     * association ends.
     * @return String
     */
    public String getRelationName();

    /**
     * Indicates if this association is 'abstract'.
     * @return boolean
     */
    public boolean isAbstract();

    /**
     * True if the AssociationFacade is an AssociationClass.
     * @return boolean
     */
    public boolean isAssociationClass();

    /**
     * UML2: Determines whether this association is a binary association, i.e. whether it has
     * exactly two member ends. UML2 allows association classes in the association itself (many2many
     * with association attributes). Default=true: only two member ends.
     * @return boolean
     */
    public boolean isBinary();

    /**
     * UML2: Returns the value of the 'Is Derived' attribute. The default value is "false". If
     * isDerived is true, the value of the attribute is derived from information elsewhere.
     * Specifies whether the Property is derived, i.e., whether its value or values can be computed
     * from other information.
     * @return boolean
     */
    public boolean isDerived();

    /**
     * True if this association cannot be extended and represent a leaf in the inheritance tree.
     * @return boolean
     */
    public boolean isLeaf();

    /**
     * Indicates whether or not this associations represents a many-to-many relation.
     * @return boolean
     */
    public boolean isMany2Many();
}
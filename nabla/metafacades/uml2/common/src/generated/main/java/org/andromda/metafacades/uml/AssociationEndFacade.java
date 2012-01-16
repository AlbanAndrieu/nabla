// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * A property related by memberEnd or its specializations to an association represents an end of the
 * association. The type of the property is the type of the end of the association .Property
 * represents a declared state of one or more instances in terms of a named relationship to a value
 * or values. When a property is an association end, the value or values are related to the instance
 * or instances at the other end(s) of the association.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface AssociationEndFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isAssociationEndFacadeMetaType();

    /**
     * A name suitable for use when adding new elements to this association end in programming code.
     * @return String
     */
    public String getAdderName();

    /**
     * Returns the value of the 'Aggregation' attribute (none, shared, composite). The default value
     * is "none". The literals are from the enumeration org.eclipse.uml2.uml.AggregationKind.
     * Specifies the kind of aggregation that applies to the Property.
     * @return String
     */
    public String getAggregationKind();

    /**
     * The association owning this association end.
     * @return AssociationFacade
     */
    public AssociationFacade getAssociation();

    /**
     * UML2: Returns the value of the 'Default' attribute. Specifies a String that represents a
     * value to be used when no argument is supplied for the Property. A String that is evaluated to
     * give a default value for the Property when an object of the owning Classifier is
     * instantiated.  Can be something like: new ValueObject(values);
     * @return String
     */
    public String getDefault();

    /**
     * A name suitable for use when accessing this association end in programming code.
     * @return String
     */
    public String getGetterName();

    /**
     * The name of the type that is returned on the accessor and mutator operations,  determined in
     * part by the multiplicity.
     * @return String
     */
    public String getGetterSetterTypeName();

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @return int
     */
    public int getLower();

    /**
     * The other association end owned by this end's association.
     * @return AssociationEndFacade
     */
    public AssociationEndFacade getOtherEnd();

    /**
     * A name suitable for use when removing element from this association end in programming code.
     * @return String
     */
    public String getRemoverName();

    /**
     * A name suitable for use when accessing this association end in programming code.
     * @return String
     */
    public String getSetterName();

    /**
     * The classifier attached to this association end.
     * @return ClassifierFacade
     */
    public ClassifierFacade getType();

    /**
     * the upper value for the multiplicity (will be -1 for *)
     * -only applicable for UML2
     * @return int
     */
    public int getUpper();

    /**
     * True if this association end represents an aggregation relationship.
     * @return boolean
     */
    public boolean isAggregation();

    /**
     * Is true if update of one side of the association should also update the other side. false if
     * not.
     * @return boolean
     */
    public boolean isBidirectional();

    /**
     * Returns whether or not (true/false) this association end is the child end of the assocation
     * (i.e. the other end's aggregation is composition).
     * @return boolean
     */
    public boolean isChild();

    /**
     * True if this association end represents a composition relationship.
     * @return boolean
     */
    public boolean isComposition();

    /**
     * If the association end is derived (its value is computed). UML2 only. UML14 always returns
     * false. Default=false.
     * @return boolean
     */
    public boolean isDerived();

    /**
     * IsLeaf property in the association end property. If true, attribute is final, cannot be
     * extended or implemented by a descendant. Default=false.
     * @return boolean
     */
    public boolean isLeaf();

    /**
     * True if this association end's multiplicity is greater than one.
     * @return boolean
     */
    public boolean isMany();

    /**
     * True if this association end's and the other end's multiplicities are both many.
     * @return boolean
     */
    public boolean isMany2Many();

    /**
     * True if this association end's multiplicity is many while the other end's is one.
     * @return boolean
     */
    public boolean isMany2One();

    /**
     * True if it is possible to navigate from the other end to this association end .
     * @return boolean
     */
    public boolean isNavigable();

    /**
     * True if this association end's multiplicity is one while the other end's is many.
     * @return boolean
     */
    public boolean isOne2Many();

    /**
     * True if this association end's and the other end's multiplicities are both one.
     * @return boolean
     */
    public boolean isOne2One();

    /**
     * Indicates whether or not the association ends are ordered (if multiplicity is greater than
     * 1).
     * @return boolean
     */
    public boolean isOrdered();

    /**
     * True if the association end cannot be changed.
     * @return boolean
     */
    public boolean isReadOnly();

    /**
     * True if this association end's multiplicity is strictly greater than zero.
     * @return boolean
     */
    public boolean isRequired();

    /**
     * UML2: If the association attribute is unique within the Collection type. UML14 always returns
     * false. Unique+Ordered determines the implementation Collection type. Default=false.
     * @return boolean
     */
    public boolean isUnique();
}
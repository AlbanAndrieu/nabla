// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * Represents an attribute on a classifier. UML2 maps both Attributes and AssociationEnds to
 * Property. A property is a structural feature of a classifier that characterizes instances of the
 * classifier. A property related by ownedAttribute to a classifier (other than an association)
 * represents an attribute and might also represent an association end. It relates an instance of
 * the class to a value or set of values of the type of the attribute. A property represents a set
 * of instances that are owned by a containing classifier instance. Property represents a declared
 * state of one or more instances in terms of a named relationship to a value or values. When a
 * property is an attribute of a classifier, the value or values are related to the instance of the
 * classifier by being held in slots of the instance. The range of valid values represented by the
 * property can be controlled by setting the property's type.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface AttributeFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isAttributeFacadeMetaType();

    /**
     * Searches the given feature for the specified tag.
     * If the follow boolean is set to true then the search will continue from the class attribute
     * to the class itself and then up the class hierarchy.
     * @param name String
     * @param follow boolean
     * @return Object
     */
    public Object findTaggedValue(String name, boolean follow);

    /**
     * The default value of the attribute.  This is the value given if no value is defined.
     * @return String
     */
    public String getDefaultValue();

    /**
     * If the attribute is an enumeration literal this represents the owning enumeration. Can be
     * empty.
     * @return EnumerationFacade
     */
    public EnumerationFacade getEnumeration();

    /**
     * Returns the enumeration literal parameters defined by tagged value as a comma separated list.
     * @return String
     */
    public String getEnumerationLiteralParameters();

    /**
     * The value for this attribute if it is an enumeration literal, null otherwise. The default
     * value is returned as a String if it has been specified, if it's not specified this
     * attribute's name is assumed.
     * @return String
     */
    public String getEnumerationValue();

    /**
     * The name of the accessor operation that would retrieve this attribute's value.
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
     * Gets the classifier who is the owner of the attributes.
     * @return ClassifierFacade
     */
    public ClassifierFacade getOwner();

    /**
     * The name of the mutator operation that would retrieve this attribute's value.
     * @return String
     */
    public String getSetterName();

    /**
     * The classifier owning this attribute.
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
     * True if this attribute can only be set.
     * @return boolean
     */
    public boolean isAddOnly();

    /**
     * True if this attribute can be modified.
     * @return boolean
     */
    public boolean isChangeable();

    /**
     * Indicates if the default value is present.
     * @return boolean
     */
    public boolean isDefaultValuePresent();

    /**
     * If the attribute is derived (its value is computed). UML2 only. UML14 always returns false.
     * Default=false.
     * @return boolean
     */
    public boolean isDerived();

    /**
     * True if this attribute is owned by an enumeration.
     * @return boolean
     */
    public boolean isEnumerationLiteral();

    /**
     * Returns true if enumeration literal parameters exist (defined by tagged value) for the
     * literal.
     * @return boolean
     */
    public boolean isEnumerationLiteralParametersExist();

    /**
     * True if this attribute is owned by an enumeration but is defined as a member variable (NOT a
     * literal).
     * @return boolean
     */
    public boolean isEnumerationMember();

    /**
     * IsLeaf property in the operation. If true, operation is final, cannot be extended or
     * implemented by a descendant.
     * @return boolean
     */
    public boolean isLeaf();

    /**
     * Whether or not this attribute has a multiplicity greater than 1.
     * @return boolean
     */
    public boolean isMany();

    /**
     * Indicates whether or not the attributes are ordered (if multiplicity is greater than 1).
     * @return boolean
     */
    public boolean isOrdered();

    /**
     * Whether or not this attribute can be modified.
     * @return boolean
     */
    public boolean isReadOnly();

    /**
     * Whether or not the multiplicity of this attribute is 1.
     * @return boolean
     */
    public boolean isRequired();

    /**
     * Indicates if this attribute is 'static', meaning it has a classifier scope.
     * @return boolean
     */
    public boolean isStatic();

    /**
     * If the attribute is unique within the Collection type. UML2 only. UML14 always returns false.
     * Unique+Ordered determines the implementation Collection type. Default=false.
     * @return boolean
     */
    public boolean isUnique();
}
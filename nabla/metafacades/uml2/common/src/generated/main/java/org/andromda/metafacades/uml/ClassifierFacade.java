// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;
import java.util.List;

/**
 * A Classifier is a classification of instances - it describes a set of instances that have
 * features in common. Can specify a generalization hierarchy by referencing its general
 * classifiers. It may be a Class, DataType, PrimitiveType, Association, Collaboration, UseCase,
 * etc. Can specify a generalization hierarchy by referencing its general classifiers. Has the
 * capability to own collaboration uses. These collaboration uses link a collaboration with the
 * classifier to give a description of the workings of the classifier. Classifier is defined to be a
 * kind of templateable element so that a classifier can be parameterized. It is also defined to be
 * a kind of parameterable element so that a classifier can be a formal template parameter.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface ClassifierFacade
    extends GeneralizableElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isClassifierFacadeMetaType();

    /**
     * Return the attribute which name matches the parameter
     * @param name String
     * @return AttributeFacade
     */
    public AttributeFacade findAttribute(String name);

    /**
     * Those abstraction dependencies for which this classifier is the client.
     * @return Collection<ClassifierFacade>
     */
    public Collection<ClassifierFacade> getAbstractions();

    /**
     * Lists all classes associated to this one and any ancestor classes (through generalization).
     * There will be no duplicates. The order of the elements is predictable.
     * @return Collection<ClassifierFacade>
     */
    public Collection<ClassifierFacade> getAllAssociatedClasses();

    /**
     * A collection containing all 'properties' of the classifier and its ancestors.  Properties are
     * any attributes and navigable connecting association ends.
     * @return Collection<ModelElementFacade>
     */
    public Collection<ModelElementFacade> getAllProperties();

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier and its
     * ancestors. Properties are any attributes and navigable connecting association ends.
     * @return Collection<ModelElementFacade>
     */
    public Collection<ModelElementFacade> getAllRequiredConstructorParameters();

    /**
     * Gets the array type for this classifier.  If this classifier already represents an array, it
     * just returns itself.
     * @return ClassifierFacade
     */
    public ClassifierFacade getArray();

    /**
     * The name of the classifier as an array.
     * @return String
     */
    public String getArrayName();

    /**
     * Lists the classes associated to this one, there is no repitition of classes. The order of the
     * elements is predictable.
     * @return Collection<ClassifierFacade>
     */
    public Collection<ClassifierFacade> getAssociatedClasses();

    /**
     * Gets the association ends belonging to a classifier.
     * @return List<AssociationEndFacade>
     */
    public List<AssociationEndFacade> getAssociationEnds();

    /**
     * Gets the attributes that belong to the classifier.
     * @return List<AttributeFacade>
     */
    public List<AttributeFacade> getAttributes();

    /**
     * Gets all attributes for the classifier and if 'follow' is true goes up the inheritance
     * hierarchy and gets the attributes from the super classes as well.
     * @param follow boolean
     * @return List<AttributeFacade>
     */
    public List<AttributeFacade> getAttributes(boolean follow);

    /**
     * The fully qualified name of the classifier as an array.
     * @return String
     */
    public String getFullyQualifiedArrayName();

    /**
     * Returns all those operations that could be implemented at this classifier's level. This means
     * the operations owned by this classifier as well as any realized interface's operations
     * (recursively) in case this classifier itself is not already an interface, or generalized when
     * this classifier is an interface.
     * @return Collection<OperationFacade>
     */
    public Collection<OperationFacade> getImplementationOperations();

    /**
     * A comma separated list of the fully qualified names of all implemented interfaces.
     * @return String
     */
    public String getImplementedInterfaceList();

    /**
     * Those attributes that are scoped to an instance of this class.
     * @return Collection<AttributeFacade>
     */
    public Collection<AttributeFacade> getInstanceAttributes();

    /**
     * Those operations that are scoped to an instance of this class.
     * @return List<OperationFacade>
     */
    public List<OperationFacade> getInstanceOperations();

    /**
     * Those interfaces that are abstractions of this classifier, this basically means this
     * classifier realizes them.
     * @return Collection<ClassifierFacade>
     */
    public Collection<ClassifierFacade> getInterfaceAbstractions();

    /**
     * A String representing a new Constructor declaration for this classifier type to be used in a
     * Java environment.
     * @return String
     */
    public String getJavaNewString();

    /**
     * A String representing the null-value for this classifier type to be used in a Java
     * environment.
     * @return String
     */
    public String getJavaNullString();

    /**
     * The other ends of this classifier's association ends which are navigable.
     * @return Collection<AssociationEndFacade>
     */
    public Collection<AssociationEndFacade> getNavigableConnectingEnds();

    /**
     * Get the other ends of this classifier's association ends which are navigable and if 'follow'
     * is true goes up the inheritance hierarchy and gets the super association ends as well.
     * @param follow boolean
     * @return List<AssociationEndFacade>
     */
    public List<AssociationEndFacade> getNavigableConnectingEnds(boolean follow);

    /**
     * Assuming that the classifier is an array, this will return the non array type of the
     * classifier from
     * the model.  If the classifier is NOT an array, it will just return itself.
     * @return ClassifierFacade
     */
    public ClassifierFacade getNonArray();

    /**
     * The attributes from this classifier in the form of an operation call (this example would be
     * in Java): '(String attributeOne, String attributeTwo).  If there were no attributes on the
     * classifier, the result would be an empty '()'.
     * @return String
     */
    public String getOperationCallFromAttributes();

    /**
     * The operations owned by this classifier.
     * @return List<OperationFacade>
     */
    public List<OperationFacade> getOperations();

    /**
     * A collection containing all 'properties' of the classifier.  Properties are any attributes
     * and navigable connecting association ends.
     * @return List<ModelElementFacade>
     */
    public List<ModelElementFacade> getProperties();

    /**
     * Gets all properties (attributes and navigable association ends) for the classifier and if
     * 'follow' is true goes up the inheritance hierarchy and gets the properties from the super
     * classes as well.
     * @param follow boolean
     * @return List
     */
    public List getProperties(boolean follow);

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier. 
     * Properties are any attributes and navigable connecting association ends.
     * @return Collection<ModelElementFacade>
     */
    public Collection<ModelElementFacade> getRequiredConstructorParameters();

    /**
     * Returns the serial version UID of the underlying model element.
     * @return long
     */
    public long getSerialVersionUID();

    /**
     * Those attributes that are scoped to the definition of this class.
     * @return Collection<AttributeFacade>
     */
    public Collection<AttributeFacade> getStaticAttributes();

    /**
     * Those operations that are scoped to the definition of this class.
     * @return List<OperationFacade>
     */
    public List<OperationFacade> getStaticOperations();

    /**
     * This class' superclass, returns the generalization if it is a ClassifierFacade, null
     * otherwise.
     * @return ClassifierFacade
     */
    public ClassifierFacade getSuperClass();

    /**
     * The wrapper name for this classifier if a mapped type has a defined wrapper class (ie. 'long'
     * maps to 'Long').  If the classifier doesn't have a wrapper defined for it, this method will
     * return a null.  Note that wrapper mappings must be defined for the namespace by defining the
     * 'wrapperMappingsUri', this property must point to the location of the mappings file which
     * maps the primitives to wrapper types.
     * @return String
     */
    public String getWrapperName();

    /**
     * Indicates if this classifier is 'abstract'.
     * @return boolean
     */
    public boolean isAbstract();

    /**
     * True if this classifier represents an array type. False otherwise.
     * @return boolean
     */
    public boolean isArrayType();

    /**
     * True if the ClassifierFacade is an AssociationClass.
     * @return boolean
     */
    public boolean isAssociationClass();

    /**
     * Returns true if this type represents a Blob type.
     * @return boolean
     */
    public boolean isBlobType();

    /**
     * Indicates if this type represents a boolean type or not.
     * @return boolean
     */
    public boolean isBooleanType();

    /**
     * Indicates if this type represents a char, Character, or java.lang.Character type or not.
     * @return boolean
     */
    public boolean isCharacterType();

    /**
     * Returns true if this type represents a Clob type.
     * @return boolean
     */
    public boolean isClobType();

    /**
     * True if this classifier represents a collection type. False otherwise.
     * @return boolean
     */
    public boolean isCollectionType();

    /**
     * True/false depending on whether or not this classifier represents a datatype. A data type is
     * a type whose instances are identified only by their value. A data type may contain attributes
     * to support the modeling of structured data types.
     * @return boolean
     */
    public boolean isDataType();

    /**
     * True when this classifier is a date type.
     * @return boolean
     */
    public boolean isDateType();

    /**
     * Indicates if this type represents a Double type or not.
     * @return boolean
     */
    public boolean isDoubleType();

    /**
     * Indicates whether or not this classifier represents an "EmbeddedValue'.
     * @return boolean
     */
    public boolean isEmbeddedValue();

    /**
     * True if this classifier is in fact marked as an enumeration.
     * @return boolean
     */
    public boolean isEnumeration();

    /**
     * Returns true if this type represents a 'file' type.
     * @return boolean
     */
    public boolean isFileType();

    /**
     * Indicates if this type represents a Float type or not.
     * @return boolean
     */
    public boolean isFloatType();

    /**
     * Indicates if this type represents an int or Integer or java.lang.Integer type or not.
     * @return boolean
     */
    public boolean isIntegerType();

    /**
     * True/false depending on whether or not this Classifier represents an interface.
     * @return boolean
     */
    public boolean isInterface();

    /**
     * True if this classifier cannot be extended and represent a leaf in the inheritance tree.
     * @return boolean
     */
    public boolean isLeaf();

    /**
     * True if this classifier represents a list type. False otherwise.
     * @return boolean
     */
    public boolean isListType();

    /**
     * Indicates if this type represents a Long type or not.
     * @return boolean
     */
    public boolean isLongType();

    /**
     * Indicates whether or not this classifier represents a Map type.
     * @return boolean
     */
    public boolean isMapType();

    /**
     * Indicates whether or not this classifier represents a primitive type.
     * @return boolean
     */
    public boolean isPrimitive();

    /**
     * True if this classifier represents a set type. False otherwise.
     * @return boolean
     */
    public boolean isSetType();

    /**
     * Indicates whether or not this classifier represents a string type.
     * @return boolean
     */
    public boolean isStringType();

    /**
     * Indicates whether or not this classifier represents a time type.
     * @return boolean
     */
    public boolean isTimeType();

    /**
     * Returns true if this type is a wrapped primitive type.
     * @return boolean
     */
    public boolean isWrappedPrimitive();
}
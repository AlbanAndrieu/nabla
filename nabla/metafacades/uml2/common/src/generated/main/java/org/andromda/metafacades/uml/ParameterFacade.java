// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * Specification of an argument used to pass information into or out of an invocation of a
 * behavioral feature. Parameters are allowed to be treated as connectable elements. Parameters have
 * support for streaming, exceptions, and parameter sets.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface ParameterFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isParameterFacadeMetaType();

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.ParameterFacade.defaultValue
     * @return String
     */
    public String getDefaultValue();

    /**
     * UML2: A representation of the literals of the enumeration 'Parameter Effect Kind': CREATE,
     * READ, UPDATE, DELETE. The datatype ParameterEffectKind is an enumeration that indicates the
     * effect of a behavior on values passed in or out of its parameters.
     * @return String
     */
    public String getEffect();

    /**
     * If this parameter is located on an event, this will represent that event.
     * @return EventFacade
     */
    public EventFacade getEvent();

    /**
     * The name to use for accessors getting this parameter from a bean.
     * @return String
     */
    public String getGetterName();

    /**
     * Fully Qualified TypeName, determined in part by multiplicity (for UML2). For UML14, same as
     * getterName.
     * @return String
     */
    public String getGetterSetterTypeName();

    /**
     * Fully Qualified implementation class of TypeName, determined in part by multiplicity (for
     * UML2). If upper multiplicity =1, same as getterSetterTypeName.
     * @return String
     */
    public String getGetterSetterTypeNameImpl();

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @return int
     */
    public int getLower();

    /**
     * If this parameter is located on an operation, this will represent that operation.
     * @return OperationFacade
     */
    public OperationFacade getOperation();

    /**
     * The name to use for accessors getting this parameter in a bean.
     * @return String
     */
    public String getSetterName();

    /**
     * A Classifier is a classification of instances - it describes a set of instances that have
     * features
     * in common. Can specify a generalization hierarchy by referencing its general classifiers. It
     * may be
     * a Class, DataType, PrimitiveType, Association, Collaboration, UseCase, etc. Can specify a
     * generalization hierarchy by referencing its general classifiers. Has the capability to own
     * collaboration uses. These collaboration uses link a collaboration with the classifier to give
     * a
     * description of the workings of the classifier. Classifier is defined to be a kind of
     * templateable
     * element so that a classifier can be parameterized. It is also defined to be a kind of
     * parameterable
     * element so that a classifier can be a formal template parameter.
     * @return ClassifierFacade
     */
    public ClassifierFacade getType();

    /**
     * the upper value of the multiplicity (will be -1 for *)
     * -only applicable for UML2
     * @return int
     */
    public int getUpper();

    /**
     * Indicates if the default value is present.
     * @return boolean
     */
    public boolean isDefaultValuePresent();

    /**
     * UML2: Returns the value of the 'Is Exception' attribute. The default value is "false". Tells
     * whether an output parameter may emit a value to the exclusion of the other outputs.
     * @return boolean
     */
    public boolean isException();

    /**
     * True if this parameter is an 'in' parameter.
     * @return boolean
     */
    public boolean isInParameter();

    /**
     * True if this parameter is an inout parameter.
     * @return boolean
     */
    public boolean isInoutParameter();

    /**
     * If upper>1 or upper==unlimited. Only applies to UML2. For UML14, always false.
     * @return boolean
     */
    public boolean isMany();

    /**
     * UML2 Only: Is parameter ordered within the Collection type. Ordered+Unique determines the
     * implementation Collection Type. For UML14, always false.
     * @return boolean
     */
    public boolean isOrdered();

    /**
     * True if this parameter is an 'out' parameter.
     * @return boolean
     */
    public boolean isOutParameter();

    /**
     * True if this parameter is readable, aka an in-parameter, or this feature is unspecified.
     * @return boolean
     */
    public boolean isReadable();

    /**
     * Whether or not this parameter is considered required (i.e must a non-empty value).
     * @return boolean
     */
    public boolean isRequired();

    /**
     * Whether or not this parameter represents a return parameter.
     * @return boolean
     */
    public boolean isReturn();

    /**
     * If Parameter type isMany (UML2), is the parameter unique within the Collection. Unique+Sorted
     * determines pareter implementation type. For UML14, always false.
     * @return boolean
     */
    public boolean isUnique();

    /**
     * True if this parameter is writable, aka an out-parameter, or this feature is unspecified.
     * @return boolean
     */
    public boolean isWritable();
}
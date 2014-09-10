// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import java.util.Collection;
import org.andromda.core.common.Introspector;
import org.andromda.core.metafacade.MetafacadeBase;
import org.andromda.core.metafacade.MetafacadeFactory;
import org.andromda.core.metafacade.ModelValidationMessage;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.EnumerationFacade;
import org.andromda.metafacades.uml.ManageableEntityAttribute;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;

/**
 * TODO: Model Documentation for
 * org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityAttributeFacade
 * MetafacadeLogic for EJB3ManageableEntityAttributeFacade
 *
 * @see EJB3ManageableEntityAttributeFacade
 */
public abstract class EJB3ManageableEntityAttributeFacadeLogic
    extends MetafacadeBase
    implements EJB3ManageableEntityAttributeFacade
{

    private static final long serialVersionUID = 1L;
    
    /**
     * The underlying UML object
     * @see Object
     */
    protected transient Object metaObject;

    /** Create Metafacade implementation instance using the MetafacadeFactory from the context
     * @param metaObjectIn
     * @param context
     */
    protected EJB3ManageableEntityAttributeFacadeLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superEJB3EntityAttributeFacade =
           (EJB3EntityAttributeFacade)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade",
                    metaObjectIn,
                    getContext(context));
        this.superManageableEntityAttribute =
           (ManageableEntityAttribute)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.ManageableEntityAttribute",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to EJB3ManageableEntityAttributeFacade if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityAttributeFacade";
        }
        return context;
    }

    private EJB3EntityAttributeFacade superEJB3EntityAttributeFacade;
    private boolean superEJB3EntityAttributeFacadeInitialized = false;

    /**
     * Gets the EJB3EntityAttributeFacade parent instance.
     * @return this.superEJB3EntityAttributeFacade EJB3EntityAttributeFacade
     */
    protected EJB3EntityAttributeFacade getSuperEJB3EntityAttributeFacade()
    {
        if (!this.superEJB3EntityAttributeFacadeInitialized)
        {
            ((MetafacadeBase)this.superEJB3EntityAttributeFacade).setMetafacadeContext(this.getMetafacadeContext());
            this.superEJB3EntityAttributeFacadeInitialized = true;
        }
        return this.superEJB3EntityAttributeFacade;
    }

    private ManageableEntityAttribute superManageableEntityAttribute;
    private boolean superManageableEntityAttributeInitialized = false;

    /**
     * Gets the ManageableEntityAttribute parent instance.
     * @return this.superManageableEntityAttribute ManageableEntityAttribute
     */
    protected ManageableEntityAttribute getSuperManageableEntityAttribute()
    {
        if (!this.superManageableEntityAttributeInitialized)
        {
            ((MetafacadeBase)this.superManageableEntityAttribute).setMetafacadeContext(this.getMetafacadeContext());
            this.superManageableEntityAttributeInitialized = true;
        }
        return this.superManageableEntityAttribute;
    }

    /** Reset context only for non-root metafacades
     * @param context
     * @see org.andromda.core.metafacade.MetafacadeBase#resetMetafacadeContext(String context)
     */
    @Override
    public void resetMetafacadeContext(String context)
    {
        if (!this.contextRoot) // reset context only for non-root metafacades
        {
            context = getContext(context);  // to have same value as in original constructor call
            setMetafacadeContext (context);
            if (this.superEJB3EntityAttributeFacadeInitialized)
            {
                ((MetafacadeBase)this.superEJB3EntityAttributeFacade).resetMetafacadeContext(context);
            }
            if (this.superManageableEntityAttributeInitialized)
            {
                ((MetafacadeBase)this.superManageableEntityAttribute).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see EJB3ManageableEntityAttributeFacade
     */
    public boolean isEJB3ManageableEntityAttributeFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see EJB3EntityAttributeFacade
     */
    public boolean isEJB3EntityAttributeFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see ManageableEntityAttribute
     */
    public boolean isManageableEntityAttributeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.EntityAttribute
     */
    public boolean isEntityAttributeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.AttributeFacade
     */
    public boolean isAttributeFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see ModelElementFacade
     */
    public boolean isModelElementFacadeMetaType()
    {
        return true;
    }

    // ----------- delegates to EJB3EntityAttributeFacade ------------
    /**
     * Defines the column definition DDL used when creating table schema - use to override default
     * container DDL.  This is automatically defined if the attribute type is an enumeration.
     * @see EJB3EntityAttributeFacade#getColumnDefinition()
     */
    public String getColumnDefinition()
    {
        return this.getSuperEJB3EntityAttributeFacade().getColumnDefinition();
    }

    /**
     * Defines the seam identity UserPassword annotation.
     * @see EJB3EntityAttributeFacade#getColumnIdentityUserPassword()
     */
    public String getColumnIdentityUserPassword()
    {
        return this.getSuperEJB3EntityAttributeFacade().getColumnIdentityUserPassword();
    }

    /**
     * Defines the column index DDL used when creating table schema - use to override default
     * container DDL.
     * @see EJB3EntityAttributeFacade#getColumnIndexable()
     */
    public String getColumnIndexable()
    {
        return this.getSuperEJB3EntityAttributeFacade().getColumnIndexable();
    }

    /**
     * Whether the column can have a validation on minimum length. If andromda_validation_minLength
     * tag is set, the tagged value is used.
     * @see EJB3EntityAttributeFacade#getColumnMinLength()
     */
    public String getColumnMinLength()
    {
        return this.getSuperEJB3EntityAttributeFacade().getColumnMinLength();
    }

    /**
     * Whether the column can have a validation pattern. If andromda_validation_pattern tag is set,
     * the tagged value is used.
     * @see EJB3EntityAttributeFacade#getColumnPatternable()
     */
    public String getColumnPatternable()
    {
        return this.getSuperEJB3EntityAttributeFacade().getColumnPatternable();
    }

    /**
     * Set the column precision value.  Only applies to double and float columns.
     * ie Use for setting dollar precision.
     * @see EJB3EntityAttributeFacade#getColumnPrecision()
     */
    public String getColumnPrecision()
    {
        return this.getSuperEJB3EntityAttributeFacade().getColumnPrecision();
    }

    /**
     * Column scale use denotes the decimal precision.
     * ie Use to set the 2 digit cent scale.
     * @see EJB3EntityAttributeFacade#getColumnScale()
     */
    public String getColumnScale()
    {
        return this.getSuperEJB3EntityAttributeFacade().getColumnScale();
    }

    /**
     * Returns the persistent property/field enumeration type.  Will return either ORDINAL for enums
     * mapped as an integer or STRING for enums mapped as a string.  If not specified on an
     * enumerated type, then the ORDINAL type is assumed
     * @see EJB3EntityAttributeFacade#getEnumerationType()
     */
    public String getEnumerationType()
    {
        return this.getSuperEJB3EntityAttributeFacade().getEnumerationType();
    }

    /**
     * Gets the fetch type for this attribute.  Default fetch type for attribute is EAGER.
     * This will return either EAGER or LAZY.
     * @see EJB3EntityAttributeFacade#getFetchType()
     */
    public String getFetchType()
    {
        return this.getSuperEJB3EntityAttributeFacade().getFetchType();
    }

    /**
     * Returns the amount to increment the generator value when allocating id numbers.
     * @see EJB3EntityAttributeFacade#getGeneratorAllocationSize()
     */
    public int getGeneratorAllocationSize()
    {
        return this.getSuperEJB3EntityAttributeFacade().getGeneratorAllocationSize();
    }

    /**
     * Returns the org.hibernate.annotations.GenericGenerator strategy either a predefined Hibernate
     * strategy or a fully qualified class name.
     * @see EJB3EntityAttributeFacade#getGeneratorGenericStrategy()
     */
    public String getGeneratorGenericStrategy()
    {
        return this.getSuperEJB3EntityAttributeFacade().getGeneratorGenericStrategy();
    }

    /**
     * Returns the inital value assigned when allocating ids from the specified generator.
     * @see EJB3EntityAttributeFacade#getGeneratorInitialValue()
     */
    public int getGeneratorInitialValue()
    {
        return this.getSuperEJB3EntityAttributeFacade().getGeneratorInitialValue();
    }

    /**
     * Return the name for the generator, if one exists and should exists for SequenceGenerator and
     * TableGenerator, which can be reference by the id for its generator.
     * @see EJB3EntityAttributeFacade#getGeneratorName()
     */
    public String getGeneratorName()
    {
        return this.getSuperEJB3EntityAttributeFacade().getGeneratorName();
    }

    /**
     * Returns the name of the primary key value in the generator table assigned to this set of
     * generated values.
     * @see EJB3EntityAttributeFacade#getGeneratorPkColumnValue()
     */
    public String getGeneratorPkColumnValue()
    {
        return this.getSuperEJB3EntityAttributeFacade().getGeneratorPkColumnValue();
    }

    /**
     * Returns the sequence name or table name for the generator depending on the generator type
     * specified.
     * @see EJB3EntityAttributeFacade#getGeneratorSourceName()
     */
    public String getGeneratorSourceName()
    {
        return this.getSuperEJB3EntityAttributeFacade().getGeneratorSourceName();
    }

    /**
     * Determine the generator type for the Id annotation on the entity attribute - the PK strategy.
     * If the attribute type is numeric, the default generator type is AUTO.  Otherwise, the
     * generator type is NONE, ie for String types.
     * @see EJB3EntityAttributeFacade#getGeneratorType()
     */
    public String getGeneratorType()
    {
        return this.getSuperEJB3EntityAttributeFacade().getGeneratorType();
    }

    /**
     * Returns the user overriden lob type for this property.  This is set via tagged value
     * andromda_persistence_lob_type.  Default values are String for Clob and byte[] for Blob.
     * @see EJB3EntityAttributeFacade#getLobType()
     */
    public String getLobType()
    {
        return this.getSuperEJB3EntityAttributeFacade().getLobType();
    }

    /**
     * Returns the temporal type value set via tagged value on attribute if one exists.  Expect one
     * of DATE, TIME, TIMESTAMP or NONE.  This can only be applied to attributes of type
     * java.util.Date or java.util.Calendar.
     * @see EJB3EntityAttributeFacade#getTemporalType()
     */
    public String getTemporalType()
    {
        return this.getSuperEJB3EntityAttributeFacade().getTemporalType();
    }

    /**
     * Whether the column can be an email.  If andromda_persistence_column_emailable tag is set, the
     * tagged value is used.
     * @see EJB3EntityAttributeFacade#isColumnEmailable()
     */
    public boolean isColumnEmailable()
    {
        return this.getSuperEJB3EntityAttributeFacade().isColumnEmailable();
    }

    /**
     * Whether the column can be empty.  False for identifier and unique fields.  If
     * andromda_persistence_column_emptyable tag is set, the tagged value is used.  Otherwise,
     * determine if this attribute is required from the multiplicity set on the attribute.
     * @see EJB3EntityAttributeFacade#isColumnEmptyable()
     */
    public boolean isColumnEmptyable()
    {
        return this.getSuperEJB3EntityAttributeFacade().isColumnEmptyable();
    }

    /**
     * Defines the seam identity RoleConditional annotation.
     * @see EJB3EntityAttributeFacade#isColumnIdentityRoleConditional()
     */
    public boolean isColumnIdentityRoleConditional()
    {
        return this.getSuperEJB3EntityAttributeFacade().isColumnIdentityRoleConditional();
    }

    /**
     * Defines the seam identity RoleGroups annotation.
     * @see EJB3EntityAttributeFacade#isColumnIdentityRoleGroups()
     */
    public boolean isColumnIdentityRoleGroups()
    {
        return this.getSuperEJB3EntityAttributeFacade().isColumnIdentityRoleGroups();
    }

    /**
     * Defines the seam identity RoleName annotation.
     * @see EJB3EntityAttributeFacade#isColumnIdentityRoleName()
     */
    public boolean isColumnIdentityRoleName()
    {
        return this.getSuperEJB3EntityAttributeFacade().isColumnIdentityRoleName();
    }

    /**
     * Defines the seam identity UserEnabled annotation.
     * @see EJB3EntityAttributeFacade#isColumnIdentityUserEnabled()
     */
    public boolean isColumnIdentityUserEnabled()
    {
        return this.getSuperEJB3EntityAttributeFacade().isColumnIdentityUserEnabled();
    }

    /**
     * Defines the seam identity UserPrincipal annotation.
     * @see EJB3EntityAttributeFacade#isColumnIdentityUserPrincipal()
     */
    public boolean isColumnIdentityUserPrincipal()
    {
        return this.getSuperEJB3EntityAttributeFacade().isColumnIdentityUserPrincipal();
    }

    /**
     * Defines the seam identity UserRoles annotation.
     * @see EJB3EntityAttributeFacade#isColumnIdentityUserRoles()
     */
    public boolean isColumnIdentityUserRoles()
    {
        return this.getSuperEJB3EntityAttributeFacade().isColumnIdentityUserRoles();
    }

    /**
     * Whether the column can be nullable.  False for identifier and unique fields.  If
     * andromda_persistence_column_nullable tag is set, the tagged value is used.  Otherwise,
     * determine if this attribute is required from the multiplicity set on the attribute.
     * @see EJB3EntityAttributeFacade#isColumnNullable()
     */
    public boolean isColumnNullable()
    {
        return this.getSuperEJB3EntityAttributeFacade().isColumnNullable();
    }

    /**
     * Returns true if this attribute's type is an embedded value object.
     * @see EJB3EntityAttributeFacade#isContainsEmbeddedObject()
     */
    public boolean isContainsEmbeddedObject()
    {
        return this.getSuperEJB3EntityAttributeFacade().isContainsEmbeddedObject();
    }

    /**
     * Determine if the fetch type for this attribute is eager loading.
     * @see EJB3EntityAttributeFacade#isEager()
     */
    public boolean isEager()
    {
        return this.getSuperEJB3EntityAttributeFacade().isEager();
    }

    /**
     * Returns true if an auto generator has been assigned to this attribute, false otherwise.
     * @see EJB3EntityAttributeFacade#isGeneratorTypeAuto()
     */
    public boolean isGeneratorTypeAuto()
    {
        return this.getSuperEJB3EntityAttributeFacade().isGeneratorTypeAuto();
    }

    /**
     * Returns true if a generic generator has been assigned to this attribute, false otherwise.
     * @see EJB3EntityAttributeFacade#isGeneratorTypeGeneric()
     */
    public boolean isGeneratorTypeGeneric()
    {
        return this.getSuperEJB3EntityAttributeFacade().isGeneratorTypeGeneric();
    }

    /**
     * Returns true if an identity generator has been assigned to this attribute, false otherwise.
     * @see EJB3EntityAttributeFacade#isGeneratorTypeIdentity()
     */
    public boolean isGeneratorTypeIdentity()
    {
        return this.getSuperEJB3EntityAttributeFacade().isGeneratorTypeIdentity();
    }

    /**
     * Returns true no generator has been assigned to this attribute, false otherwise.
     * @see EJB3EntityAttributeFacade#isGeneratorTypeNone()
     */
    public boolean isGeneratorTypeNone()
    {
        return this.getSuperEJB3EntityAttributeFacade().isGeneratorTypeNone();
    }

    /**
     * Returns true if a sequence generator has been assigned to this attribute, false otherwise.
     * @see EJB3EntityAttributeFacade#isGeneratorTypeSequence()
     */
    public boolean isGeneratorTypeSequence()
    {
        return this.getSuperEJB3EntityAttributeFacade().isGeneratorTypeSequence();
    }

    /**
     * Returns true if a table generator has been assigned to this attribute, false otherwise.
     * @see EJB3EntityAttributeFacade#isGeneratorTypeTable()
     */
    public boolean isGeneratorTypeTable()
    {
        return this.getSuperEJB3EntityAttributeFacade().isGeneratorTypeTable();
    }

    /**
     * Specifies whether a mapped column should be included in SQL INSERT statements.
     * @see EJB3EntityAttributeFacade#isInsertEnabled()
     */
    public boolean isInsertEnabled()
    {
        return this.getSuperEJB3EntityAttributeFacade().isInsertEnabled();
    }

    /**
     * Determine if the fetch type for this attribute is lazy loading.
     * @see EJB3EntityAttributeFacade#isLazy()
     */
    public boolean isLazy()
    {
        return this.getSuperEJB3EntityAttributeFacade().isLazy();
    }

    /**
     * Returns true if the property type is specified as datatype::Blob or datatype::Clob.
     * LOB type is CLOB for characters or BLOB for binary data.
     * @see EJB3EntityAttributeFacade#isLob()
     */
    public boolean isLob()
    {
        return this.getSuperEJB3EntityAttributeFacade().isLob();
    }

    /**
     * Specifies whether a mapped column should be included in SQL UPDATE statements.
     * @see EJB3EntityAttributeFacade#isUpdateEnabled()
     */
    public boolean isUpdateEnabled()
    {
        return this.getSuperEJB3EntityAttributeFacade().isUpdateEnabled();
    }

    /**
     * True is this attribute is a version property (optimistic lock value) for this entity class.
     * @see EJB3EntityAttributeFacade#isVersion()
     */
    public boolean isVersion()
    {
        return this.getSuperEJB3EntityAttributeFacade().isVersion();
    }

    /**
     * Searches the given feature for the specified tag.
     * If the follow boolean is set to true then the search will continue from the class attribute
     * to the class itself and then up the class hierarchy.
     * @see org.andromda.metafacades.uml.AttributeFacade#findTaggedValue(String name, boolean follow)
     */
    public Object findTaggedValue(String name, boolean follow)
    {
        return this.getSuperEJB3EntityAttributeFacade().findTaggedValue(name, follow);
    }

    /**
     * The default value of the attribute.  This is the value given if no value is defined.
     * @see org.andromda.metafacades.uml.AttributeFacade#getDefaultValue()
     */
    public String getDefaultValue()
    {
        return this.getSuperEJB3EntityAttributeFacade().getDefaultValue();
    }

    /**
     * If the attribute is an enumeration literal this represents the owning enumeration. Can be
     * empty.
     * @see org.andromda.metafacades.uml.AttributeFacade#getEnumeration()
     */
    public EnumerationFacade getEnumeration()
    {
        return this.getSuperEJB3EntityAttributeFacade().getEnumeration();
    }

    /**
     * Returns the enumeration literal parameters defined by tagged value as a comma separated list.
     * @see org.andromda.metafacades.uml.AttributeFacade#getEnumerationLiteralParameters()
     */
    public String getEnumerationLiteralParameters()
    {
        return this.getSuperEJB3EntityAttributeFacade().getEnumerationLiteralParameters();
    }

    /**
     * The value for this attribute if it is an enumeration literal, null otherwise. The default
     * value is returned as a String if it has been specified, if it's not specified this
     * attribute's name is assumed.
     * @see org.andromda.metafacades.uml.AttributeFacade#getEnumerationValue()
     */
    public String getEnumerationValue()
    {
        return this.getSuperEJB3EntityAttributeFacade().getEnumerationValue();
    }

    /**
     * The name of the accessor operation that would retrieve this attribute's value.
     * @see org.andromda.metafacades.uml.AttributeFacade#getGetterName()
     */
    public String getGetterName()
    {
        return this.getSuperEJB3EntityAttributeFacade().getGetterName();
    }

    /**
     * The name of the type that is returned on the accessor and mutator operations,  determined in
     * part by the multiplicity.
     * @see org.andromda.metafacades.uml.AttributeFacade#getGetterSetterTypeName()
     */
    public String getGetterSetterTypeName()
    {
        return this.getSuperEJB3EntityAttributeFacade().getGetterSetterTypeName();
    }

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @see org.andromda.metafacades.uml.AttributeFacade#getLower()
     */
    public int getLower()
    {
        return this.getSuperEJB3EntityAttributeFacade().getLower();
    }

    /**
     * Gets the classifier who is the owner of the attributes.
     * @see org.andromda.metafacades.uml.AttributeFacade#getOwner()
     */
    public ClassifierFacade getOwner()
    {
        return this.getSuperEJB3EntityAttributeFacade().getOwner();
    }

    /**
     * The name of the mutator operation that would retrieve this attribute's value.
     * @see org.andromda.metafacades.uml.AttributeFacade#getSetterName()
     */
    public String getSetterName()
    {
        return this.getSuperEJB3EntityAttributeFacade().getSetterName();
    }

    /**
     * The classifier owning this attribute.
     * @see org.andromda.metafacades.uml.AttributeFacade#getType()
     */
    public ClassifierFacade getType()
    {
        return this.getSuperEJB3EntityAttributeFacade().getType();
    }

    /**
     * the upper value for the multiplicity (will be -1 for *)
     * -only applicable for UML2
     * @see org.andromda.metafacades.uml.AttributeFacade#getUpper()
     */
    public int getUpper()
    {
        return this.getSuperEJB3EntityAttributeFacade().getUpper();
    }

    /**
     * True if this attribute can only be set.
     * @see org.andromda.metafacades.uml.AttributeFacade#isAddOnly()
     */
    public boolean isAddOnly()
    {
        return this.getSuperEJB3EntityAttributeFacade().isAddOnly();
    }

    /**
     * True if this attribute can be modified.
     * @see org.andromda.metafacades.uml.AttributeFacade#isChangeable()
     */
    public boolean isChangeable()
    {
        return this.getSuperEJB3EntityAttributeFacade().isChangeable();
    }

    /**
     * Indicates if the default value is present.
     * @see org.andromda.metafacades.uml.AttributeFacade#isDefaultValuePresent()
     */
    public boolean isDefaultValuePresent()
    {
        return this.getSuperEJB3EntityAttributeFacade().isDefaultValuePresent();
    }

    /**
     * If the attribute is derived (its value is computed). UML2 only. UML14 always returns false.
     * Default=false.
     * @see org.andromda.metafacades.uml.AttributeFacade#isDerived()
     */
    public boolean isDerived()
    {
        return this.getSuperEJB3EntityAttributeFacade().isDerived();
    }

    /**
     * True if this attribute is owned by an enumeration.
     * @see org.andromda.metafacades.uml.AttributeFacade#isEnumerationLiteral()
     */
    public boolean isEnumerationLiteral()
    {
        return this.getSuperEJB3EntityAttributeFacade().isEnumerationLiteral();
    }

    /**
     * Returns true if enumeration literal parameters exist (defined by tagged value) for the
     * literal.
     * @see org.andromda.metafacades.uml.AttributeFacade#isEnumerationLiteralParametersExist()
     */
    public boolean isEnumerationLiteralParametersExist()
    {
        return this.getSuperEJB3EntityAttributeFacade().isEnumerationLiteralParametersExist();
    }

    /**
     * True if this attribute is owned by an enumeration but is defined as a member variable (NOT a
     * literal).
     * @see org.andromda.metafacades.uml.AttributeFacade#isEnumerationMember()
     */
    public boolean isEnumerationMember()
    {
        return this.getSuperEJB3EntityAttributeFacade().isEnumerationMember();
    }

    /**
     * IsLeaf property in the operation. If true, operation is final, cannot be extended or
     * implemented by a descendant.
     * @see org.andromda.metafacades.uml.AttributeFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperEJB3EntityAttributeFacade().isLeaf();
    }

    /**
     * Whether or not this attribute has a multiplicity greater than 1.
     * @see org.andromda.metafacades.uml.AttributeFacade#isMany()
     */
    public boolean isMany()
    {
        return this.getSuperEJB3EntityAttributeFacade().isMany();
    }

    /**
     * Indicates whether or not the attributes are ordered (if multiplicity is greater than 1).
     * @see org.andromda.metafacades.uml.AttributeFacade#isOrdered()
     */
    public boolean isOrdered()
    {
        return this.getSuperEJB3EntityAttributeFacade().isOrdered();
    }

    /**
     * Whether or not this attribute can be modified.
     * @see org.andromda.metafacades.uml.AttributeFacade#isReadOnly()
     */
    public boolean isReadOnly()
    {
        return this.getSuperEJB3EntityAttributeFacade().isReadOnly();
    }

    /**
     * Whether or not the multiplicity of this attribute is 1.
     * @see org.andromda.metafacades.uml.AttributeFacade#isRequired()
     */
    public boolean isRequired()
    {
        return this.getSuperEJB3EntityAttributeFacade().isRequired();
    }

    /**
     * Indicates if this attribute is 'static', meaning it has a classifier scope.
     * @see org.andromda.metafacades.uml.AttributeFacade#isStatic()
     */
    public boolean isStatic()
    {
        return this.getSuperEJB3EntityAttributeFacade().isStatic();
    }

    /**
     * If the attribute is unique within the Collection type. UML2 only. UML14 always returns false.
     * Unique+Ordered determines the implementation Collection type. Default=false.
     * @see org.andromda.metafacades.uml.AttributeFacade#isUnique()
     */
    public boolean isUnique()
    {
        return this.getSuperEJB3EntityAttributeFacade().isUnique();
    }

    /**
     * The name of the index to create on a column that persists the entity attribute.
     * @see org.andromda.metafacades.uml.EntityAttribute#getColumnIndex()
     */
    public String getColumnIndex()
    {
        return this.getSuperEJB3EntityAttributeFacade().getColumnIndex();
    }

    /**
     * The length of the column that persists this entity attribute.
     * @see org.andromda.metafacades.uml.EntityAttribute#getColumnLength()
     */
    public String getColumnLength()
    {
        return this.getSuperEJB3EntityAttributeFacade().getColumnLength();
    }

    /**
     * The name of the table column to which this entity is mapped.
     * @see org.andromda.metafacades.uml.EntityAttribute#getColumnName()
     */
    public String getColumnName()
    {
        return this.getSuperEJB3EntityAttributeFacade().getColumnName();
    }

    /**
     * The PIM to language specific mappings for JDBC.
     * @see org.andromda.metafacades.uml.EntityAttribute#getJdbcMappings()
     */
    public TypeMappings getJdbcMappings()
    {
        return this.getSuperEJB3EntityAttributeFacade().getJdbcMappings();
    }

    /**
     * The JDBC type for this entity attribute.
     * @see org.andromda.metafacades.uml.EntityAttribute#getJdbcType()
     */
    public String getJdbcType()
    {
        return this.getSuperEJB3EntityAttributeFacade().getJdbcType();
    }

    /**
     * The SQL mappings (i.e. the mappings which provide PIM to SQL mappings).
     * @see org.andromda.metafacades.uml.EntityAttribute#getSqlMappings()
     */
    public TypeMappings getSqlMappings()
    {
        return this.getSuperEJB3EntityAttributeFacade().getSqlMappings();
    }

    /**
     * The SQL type for this attribute.
     * @see org.andromda.metafacades.uml.EntityAttribute#getSqlType()
     */
    public String getSqlType()
    {
        return this.getSuperEJB3EntityAttributeFacade().getSqlType();
    }

    /**
     * The name of the unique-key that this unique attribute belongs
     * @see org.andromda.metafacades.uml.EntityAttribute#getUniqueGroup()
     */
    public String getUniqueGroup()
    {
        return this.getSuperEJB3EntityAttributeFacade().getUniqueGroup();
    }

    /**
     * True if this attribute is an identifier for its entity.
     * @see org.andromda.metafacades.uml.EntityAttribute#isIdentifier()
     */
    public boolean isIdentifier()
    {
        return this.getSuperEJB3EntityAttributeFacade().isIdentifier();
    }

    /**
     * Indicates this attribute should be ignored by the persistence layer.
     * @see org.andromda.metafacades.uml.EntityAttribute#isTransient()
     */
    public boolean isTransient()
    {
        return this.getSuperEJB3EntityAttributeFacade().isTransient();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperEJB3EntityAttributeFacade().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperEJB3EntityAttributeFacade().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperEJB3EntityAttributeFacade().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperEJB3EntityAttributeFacade().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperEJB3EntityAttributeFacade().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperEJB3EntityAttributeFacade().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperEJB3EntityAttributeFacade().getDocumentation(indent);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. By default paragraphs are returned as HTML.
     * This method is equivalent to <code>getDocumentation(indent, lineLength, true)</code>.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength)
     */
    public String getDocumentation(String indent, int lineLength)
    {
        return this.getSuperEJB3EntityAttributeFacade().getDocumentation(indent, lineLength);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. HTML style determines if HTML Escaping is applied.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperEJB3EntityAttributeFacade().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperEJB3EntityAttributeFacade().getFullyQualifiedName();
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element.  If modelName is true, then
     * the original name of the model element (the name contained within the model) will be the name
     * returned, otherwise a name from a language mapping will be returned.
     * @see ModelElementFacade#getFullyQualifiedName(boolean modelName)
     */
    public String getFullyQualifiedName(boolean modelName)
    {
        return this.getSuperEJB3EntityAttributeFacade().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperEJB3EntityAttributeFacade().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperEJB3EntityAttributeFacade().getId();
    }

    /**
     * UML2: Retrieves the keywords for this element. Used to modify implementation properties which
     * are not represented by other properties, i.e. native, transient, volatile, synchronized,
     * (added annotations) override, deprecated. Can also be used to suppress compiler warnings:
     * (added annotations) unchecked, fallthrough, path, serial, finally, all. Annotations require
     * JDK5 compiler level.
     * @see ModelElementFacade#getKeywords()
     */
    public Collection<String> getKeywords()
    {
        return this.getSuperEJB3EntityAttributeFacade().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperEJB3EntityAttributeFacade().getLabel();
    }

    /**
     * The language mappings that have been set for this model element.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperEJB3EntityAttributeFacade().getLanguageMappings();
    }

    /**
     * Return the model containing this model element (multiple models may be loaded and processed
     * at the same time).
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperEJB3EntityAttributeFacade().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperEJB3EntityAttributeFacade().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperEJB3EntityAttributeFacade().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperEJB3EntityAttributeFacade().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperEJB3EntityAttributeFacade().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperEJB3EntityAttributeFacade().getPackagePath();
    }

    /**
     * UML2: Returns the value of the 'Qualified Name' attribute. A name which allows the
     * NamedElement to be identified within a hierarchy of nested Namespaces. It is constructed from
     * the names of the containing namespaces starting at the root of the hierarchy and ending with
     * the name of the NamedElement itself.
     * @see ModelElementFacade#getQualifiedName()
     */
    public String getQualifiedName()
    {
        return this.getSuperEJB3EntityAttributeFacade().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperEJB3EntityAttributeFacade().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperEJB3EntityAttributeFacade().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperEJB3EntityAttributeFacade().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperEJB3EntityAttributeFacade().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperEJB3EntityAttributeFacade().getStereotypes();
    }

    /**
     * Return the TaggedValues associated with this model element, under all stereotypes.
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperEJB3EntityAttributeFacade().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperEJB3EntityAttributeFacade().getTargetDependencies();
    }

    /**
     * Get the template parameters for this model element.
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperEJB3EntityAttributeFacade().getTemplateParameter(parameterName);
    }

    /**
     * Get the template parameter for this model element having the parameterName.
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperEJB3EntityAttributeFacade().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperEJB3EntityAttributeFacade().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperEJB3EntityAttributeFacade().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperEJB3EntityAttributeFacade().hasKeyword(keywordName);
    }

    /**
     * Returns true if the model element has the specified stereotype.  If the stereotype itself
     * does not match, then a search will be made up the stereotype inheritance hierarchy, and if
     * one of the stereotype's ancestors has a matching name this method will return true, false
     * otherwise.
     * For example, if we have a certain stereotype called <<exception>> and a model element has a
     * stereotype called <<applicationException>> which extends <<exception>>, when calling this
     * method with 'stereotypeName' defined as 'exception' the method would return true since
     * <<applicationException>> inherits from <<exception>>.  If you want to check if the model
     * element has the exact stereotype, then use the method 'hasExactStereotype' instead.
     * @see ModelElementFacade#hasStereotype(String stereotypeName)
     */
    public boolean hasStereotype(String stereotypeName)
    {
        return this.getSuperEJB3EntityAttributeFacade().hasStereotype(stereotypeName);
    }

    /**
     * True if there are target dependencies from this element that are instances of BindingFacade.
     * Deprecated in UML2: Use TemplateBinding parameters instead of dependencies.
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperEJB3EntityAttributeFacade().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperEJB3EntityAttributeFacade().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperEJB3EntityAttributeFacade().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperEJB3EntityAttributeFacade().isReservedWord();
    }

    /**
     * True is there are template parameters on this model element. For UML2, applies to Class,
     * Operation, Property, and Parameter.
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperEJB3EntityAttributeFacade().isTemplateParametersPresent();
    }

    /**
     * True if this element name is a valid identifier name in Java, C#, ANSI or ISO C, C++,
     * JavaScript. Contains no spaces, special characters etc. Constraint always applied on
     * Enumerations and Interfaces, optionally applies on other model elements.
     * @see ModelElementFacade#isValidIdentifierName()
     */
    public boolean isValidIdentifierName()
    {
        return this.getSuperEJB3EntityAttributeFacade().isValidIdentifierName();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperEJB3EntityAttributeFacade().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperEJB3EntityAttributeFacade().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperEJB3EntityAttributeFacade().translateConstraints(kind, translation);
    }

    // ----------- delegates to ManageableEntityAttribute ------------
    /**
     * Whether or not this attribute should be displayed.
     * @see ManageableEntityAttribute#isDisplay()
     */
    public boolean isDisplay()
    {
        return this.getSuperManageableEntityAttribute().isDisplay();
    }

    /**
     * Whether or not this attribute can be read in a call isolated from the rest (for example when
     * downloading binary fields).
     * @see ManageableEntityAttribute#isManageableGetterAvailable()
     */
    public boolean isManageableGetterAvailable()
    {
        return this.getSuperManageableEntityAttribute().isManageableGetterAvailable();
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperEJB3EntityAttributeFacade().initialize();
        this.getSuperManageableEntityAttribute().initialize();
    }

    /**
     * @return Object getSuperEJB3EntityAttributeFacade().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperEJB3EntityAttributeFacade().getValidationOwner();
        if (owner == null)
        {
            owner = this.getSuperManageableEntityAttribute().getValidationOwner();
        }
        return owner;
    }

    /**
     * @return String getSuperEJB3EntityAttributeFacade().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperEJB3EntityAttributeFacade().getValidationName();
        if (name == null)
        {
            name = this.getSuperManageableEntityAttribute().getValidationName();
        }
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperEJB3EntityAttributeFacade().validateInvariants(validationMessages);
        this.getSuperManageableEntityAttribute().validateInvariants(validationMessages);
    }

    /**
     * The property that stores the name of the metafacade.
     */
    private static final String NAME_PROPERTY = "name";
    private static final String FQNAME_PROPERTY = "fullyQualifiedName";

    /**
     * @see Object#toString()
     */
    @Override
    public String toString()
    {
        final StringBuilder toString = new StringBuilder(this.getClass().getName());
        toString.append("[");
        try
        {
            toString.append(Introspector.instance().getProperty(this, FQNAME_PROPERTY));
        }
        catch (final Throwable tryAgain)
        {
            try
            {
                toString.append(Introspector.instance().getProperty(this, NAME_PROPERTY));
            }
            catch (final Throwable ignore)
            {
                // - just ignore when the metafacade doesn't have a name or fullyQualifiedName property
            }
        }
        toString.append("]");
        return toString.toString();
    }
}
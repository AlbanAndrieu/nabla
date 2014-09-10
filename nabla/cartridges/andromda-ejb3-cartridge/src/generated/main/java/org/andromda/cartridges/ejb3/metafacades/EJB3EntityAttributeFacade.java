// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import org.andromda.metafacades.uml.EntityAttribute;

/**
 * Represents an EJB attribute.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3EntityAttributeFacade
    extends EntityAttribute
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3EntityAttributeFacadeMetaType();

    /**
     * Defines the column definition DDL used when creating table schema - use to override default
     * container DDL.  This is automatically defined if the attribute type is an enumeration.
     * @return String
     */
    public String getColumnDefinition();

    /**
     * Defines the seam identity UserPassword annotation.
     * @return String
     */
    public String getColumnIdentityUserPassword();

    /**
     * Defines the column index DDL used when creating table schema - use to override default
     * container DDL.
     * @return String
     */
    public String getColumnIndexable();

    /**
     * Whether the column can have a validation on minimum length. If andromda_validation_minLength
     * tag is set, the tagged value is used.
     * @return String
     */
    public String getColumnMinLength();

    /**
     * Whether the column can have a validation pattern. If andromda_validation_pattern tag is set,
     * the tagged value is used.
     * @return String
     */
    public String getColumnPatternable();

    /**
     * Set the column precision value.  Only applies to double and float columns.
     * ie Use for setting dollar precision.
     * @return String
     */
    public String getColumnPrecision();

    /**
     * Column scale use denotes the decimal precision.
     * ie Use to set the 2 digit cent scale.
     * @return String
     */
    public String getColumnScale();

    /**
     * Returns the persistent property/field enumeration type.  Will return either ORDINAL for enums
     * mapped as an integer or STRING for enums mapped as a string.  If not specified on an
     * enumerated type, then the ORDINAL type is assumed
     * @return String
     */
    public String getEnumerationType();

    /**
     * Gets the fetch type for this attribute.  Default fetch type for attribute is EAGER.
     * This will return either EAGER or LAZY.
     * @return String
     */
    public String getFetchType();

    /**
     * Returns the amount to increment the generator value when allocating id numbers.
     * @return int
     */
    public int getGeneratorAllocationSize();

    /**
     * Returns the org.hibernate.annotations.GenericGenerator strategy either a predefined Hibernate
     * strategy or a fully qualified class name.
     * @return String
     */
    public String getGeneratorGenericStrategy();

    /**
     * Returns the inital value assigned when allocating ids from the specified generator.
     * @return int
     */
    public int getGeneratorInitialValue();

    /**
     * Return the name for the generator, if one exists and should exists for SequenceGenerator and
     * TableGenerator, which can be reference by the id for its generator.
     * @return String
     */
    public String getGeneratorName();

    /**
     * Returns the name of the primary key value in the generator table assigned to this set of
     * generated values.
     * @return String
     */
    public String getGeneratorPkColumnValue();

    /**
     * Returns the sequence name or table name for the generator depending on the generator type
     * specified.
     * @return String
     */
    public String getGeneratorSourceName();

    /**
     * Determine the generator type for the Id annotation on the entity attribute - the PK strategy.
     * If the attribute type is numeric, the default generator type is AUTO.  Otherwise, the
     * generator type is NONE, ie for String types.
     * @return String
     */
    public String getGeneratorType();

    /**
     * Returns the user overriden lob type for this property.  This is set via tagged value
     * andromda_persistence_lob_type.  Default values are String for Clob and byte[] for Blob.
     * @return String
     */
    public String getLobType();

    /**
     * Returns the temporal type value set via tagged value on attribute if one exists.  Expect one
     * of DATE, TIME, TIMESTAMP or NONE.  This can only be applied to attributes of type
     * java.util.Date or java.util.Calendar.
     * @return String
     */
    public String getTemporalType();

    /**
     * Whether the column can be an email.  If andromda_persistence_column_emailable tag is set, the
     * tagged value is used.
     * @return boolean
     */
    public boolean isColumnEmailable();

    /**
     * Whether the column can be empty.  False for identifier and unique fields.  If
     * andromda_persistence_column_emptyable tag is set, the tagged value is used.  Otherwise,
     * determine if this attribute is required from the multiplicity set on the attribute.
     * @return boolean
     */
    public boolean isColumnEmptyable();

    /**
     * Defines the seam identity RoleConditional annotation.
     * @return boolean
     */
    public boolean isColumnIdentityRoleConditional();

    /**
     * Defines the seam identity RoleGroups annotation.
     * @return boolean
     */
    public boolean isColumnIdentityRoleGroups();

    /**
     * Defines the seam identity RoleName annotation.
     * @return boolean
     */
    public boolean isColumnIdentityRoleName();

    /**
     * Defines the seam identity UserEnabled annotation.
     * @return boolean
     */
    public boolean isColumnIdentityUserEnabled();

    /**
     * Defines the seam identity UserPrincipal annotation.
     * @return boolean
     */
    public boolean isColumnIdentityUserPrincipal();

    /**
     * Defines the seam identity UserRoles annotation.
     * @return boolean
     */
    public boolean isColumnIdentityUserRoles();

    /**
     * Whether the column can be nullable.  False for identifier and unique fields.  If
     * andromda_persistence_column_nullable tag is set, the tagged value is used.  Otherwise,
     * determine if this attribute is required from the multiplicity set on the attribute.
     * @return boolean
     */
    public boolean isColumnNullable();

    /**
     * Returns true if this attribute's type is an embedded value object.
     * @return boolean
     */
    public boolean isContainsEmbeddedObject();

    /**
     * Determine if the fetch type for this attribute is eager loading.
     * @return boolean
     */
    public boolean isEager();

    /**
     * Returns true if an auto generator has been assigned to this attribute, false otherwise.
     * @return boolean
     */
    public boolean isGeneratorTypeAuto();

    /**
     * Returns true if a generic generator has been assigned to this attribute, false otherwise.
     * @return boolean
     */
    public boolean isGeneratorTypeGeneric();

    /**
     * Returns true if an identity generator has been assigned to this attribute, false otherwise.
     * @return boolean
     */
    public boolean isGeneratorTypeIdentity();

    /**
     * Returns true no generator has been assigned to this attribute, false otherwise.
     * @return boolean
     */
    public boolean isGeneratorTypeNone();

    /**
     * Returns true if a sequence generator has been assigned to this attribute, false otherwise.
     * @return boolean
     */
    public boolean isGeneratorTypeSequence();

    /**
     * Returns true if a table generator has been assigned to this attribute, false otherwise.
     * @return boolean
     */
    public boolean isGeneratorTypeTable();

    /**
     * Specifies whether a mapped column should be included in SQL INSERT statements.
     * @return boolean
     */
    public boolean isInsertEnabled();

    /**
     * Determine if the fetch type for this attribute is lazy loading.
     * @return boolean
     */
    public boolean isLazy();

    /**
     * Returns true if the property type is specified as datatype::Blob or datatype::Clob.
     * LOB type is CLOB for characters or BLOB for binary data.
     * @return boolean
     */
    public boolean isLob();

    /**
     * Specifies whether a mapped column should be included in SQL UPDATE statements.
     * @return boolean
     */
    public boolean isUpdateEnabled();

    /**
     * True is this attribute is a version property (optimistic lock value) for this entity class.
     * @return boolean
     */
    public boolean isVersion();
}
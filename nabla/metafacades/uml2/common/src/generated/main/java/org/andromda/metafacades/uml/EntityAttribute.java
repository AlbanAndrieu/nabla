// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * Represents an attribute of an entity.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EntityAttribute
    extends AttributeFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEntityAttributeMetaType();

    /**
     * The name of the index to create on a column that persists the entity attribute.
     * @return String
     */
    public String getColumnIndex();

    /**
     * The length of the column that persists this entity attribute.
     * @return String
     */
    public String getColumnLength();

    /**
     * The name of the table column to which this entity is mapped.
     * @return String
     */
    public String getColumnName();

    /**
     * The PIM to language specific mappings for JDBC.
     * @return TypeMappings
     */
    public TypeMappings getJdbcMappings();

    /**
     * The JDBC type for this entity attribute.
     * @return String
     */
    public String getJdbcType();

    /**
     * The SQL mappings (i.e. the mappings which provide PIM to SQL mappings).
     * @return TypeMappings
     */
    public TypeMappings getSqlMappings();

    /**
     * The SQL type for this attribute.
     * @return String
     */
    public String getSqlType();

    /**
     * The name of the unique-key that this unique attribute belongs
     * @return String
     */
    public String getUniqueGroup();

    /**
     * True if this attribute is an identifier for its entity.
     * @return boolean
     */
    public boolean isIdentifier();

    /**
     * Indicates this attribute should be ignored by the persistence layer.
     * @return boolean
     */
    public boolean isTransient();
}
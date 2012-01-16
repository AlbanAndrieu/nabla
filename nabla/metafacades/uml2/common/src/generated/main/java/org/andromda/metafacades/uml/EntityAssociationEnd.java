// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * Represents an association end of an entity.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EntityAssociationEnd
    extends AssociationEndFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEntityAssociationEndMetaType();

    /**
     * The name of the index to create on a column that persists the foreign key attribute.
     * @return String
     */
    public String getColumnIndex();

    /**
     * The name of the column that makes up the foreign key.
     * @return String
     */
    public String getColumnName();

    /**
     * The name of the foreign key constraint to use for databases.
     * @return String
     */
    public String getForeignKeyConstraintName();

    /**
     * The current foreign key suffix specified for this entity association end facade.
     * @return String
     */
    public String getForeignKeySuffix();

    /**
     * The SQL type for this the foreign key column of this association end.
     * @return String
     */
    public String getSqlType();

    /**
     * The name of the unique-key that this unique association end belongs
     * @return String
     */
    public String getUniqueGroup();

    /**
     * Indicates whether or not a foreign identifier should be used for the entity that owns this
     * association end.  This would only make sense in the case of a child in a one-to-one
     * parent-child association.  If this flag is true, then the identifier of this entity should
     * also be used as the foreign key to the related parent entity.
     * @return boolean
     */
    public boolean isForeignIdentifier();

    /**
     * True if the associationEnd is marked with identifiers stereotype, false otherwise.
     * @return boolean
     */
    public boolean isIdentifiersPresent();

    /**
     * Indicates this association end should be ignored by the persistence layer.
     * @return boolean
     */
    public boolean isTransient();
}
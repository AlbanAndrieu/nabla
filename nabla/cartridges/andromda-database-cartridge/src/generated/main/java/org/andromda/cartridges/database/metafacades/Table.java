// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.database.metafacades;

import java.util.Collection;
import org.andromda.metafacades.uml.Entity;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface Table
    extends Entity
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isTableMetaType();

    /**
     * 
     * @return Collection<Column>
     */
    public Collection<Column> getColumns();

    /**
     * The number of rows to insert to create the dummy load for this table.
     * @return int
     */
    public int getDummyLoadSize();

    /**
     * The foreign-key columns that are part of this table.
     * @return Collection<ForeignKeyColumn>
     */
    public Collection<ForeignKeyColumn> getForeignKeyColumns();

    /**
     * 
     * @return Collection<Column>
     */
    public Collection<Column> getIdentifierForeignKeyColumns();

    /**
     * Those tables that are being imported by this table, using foreign-keys.
     * @return Collection<Table>
     */
    public Collection<Table> getImportedTables();

    /**
     * Those tables that are importing this table using foreign-keys.
     * @return Collection<Table>
     */
    public Collection<Table> getImportingTables();

    /**
     * The columns that are part of this table and are not a primary-key column nor a foreign-key
     * column.
     * @return Collection<Column>
     */
    public Collection<Column> getNonForeignKeyColumns();

    /**
     * Gets the column that represents the primary key.
     * @return Column
     */
    public Column getPrimaryKeyColumn();

    /**
     * The name of the primary key constraint for this table.
     * @return String
     */
    public String getPrimaryKeyConstraintName();

    /**
     * Are there foreign key columns present in this table ?
     * @return boolean
     */
    public boolean isForeignKeyColumnsPresent();
}
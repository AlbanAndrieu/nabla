// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.database.metafacades;

import java.util.Collection;
import org.andromda.metafacades.uml.EntityAttribute;

/**
 * This column is used for all types of columns possible in a database table, such qs primary key
 * columns and data columns.  Most of the time this column doesn't represent a foreign key column
 * (except in the case where the foreignIdentifier flag is set on the own entity in which case the
 * primary key can play the foreign key as well).
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface Column
    extends EntityAttribute
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isColumnMetaType();

    /**
     * The name of the constraint when this column plays a foreign key (when the primary key plays a
     * foreign key).
     * @return String
     */
    public String getConstraintName();

    /**
     * Return the dummy load value for the specified index.
     * @param index int
     * @return String
     */
    public String getDummyLoadValue(int index);

    /**
     * The foreign-key columns importing this table.
     * @return Collection<ForeignKeyColumn>
     */
    public Collection<ForeignKeyColumn> getExportedColumns();

    /**
     * The table imported when this column plays a primary key that's a foreign key.
     * @return Table
     */
    public Table getImportedTable();

    /**
     * The set of tables that are importing this primary key column using foreign-keys.
     * @return Collection<Table>
     */
    public Collection<Table> getImportingTables();

    /**
     * This column's table.
     * @return Table
     */
    public Table getTable();

    /**
     * The name of the table that owns this column.  The only time this is used is when the primary
     * key acts as a foreign key.
     * @return String
     */
    public String getTableName();

    /**
     * Denotes whether or not a row of this column's table needs to be deleted if the entity to
     * which the foreign identifier key is related is deleted.
     * @return boolean
     */
    public boolean isCascadeDelete();

    /**
     * Denotes whether or not this column represents the primary key for its table.
     * @return boolean
     */
    public boolean isPrimaryKey();
}
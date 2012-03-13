// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.database.metafacades;

import org.andromda.metafacades.uml.EntityAssociationEnd;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface ForeignKeyColumn
    extends EntityAssociationEnd
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isForeignKeyColumnMetaType();

    /**
     * 
     * @return AssociationTable
     */
    public AssociationTable getAssociationTable();

    /**
     * The name of the foreign key constraint.
     * @return String
     */
    public String getConstraintName();

    /**
     * Returns the dummy load value for the specified index.
     * @param index int
     * @return String
     */
    public String getDummyLoadValue(int index);

    /**
     * The primary key column that is imported by this foreign key.
     * @return Column
     */
    public Column getImportedPrimaryKeyColumn();

    /**
     * The table imported by this foreign key column.
     * @return Table
     */
    public Table getImportedTable();

    /**
     * The name of the index for this foreign-key column.
     * @return String
     */
    public String getIndexName();

    /**
     * This foreign-key column's table.
     * @return Table
     */
    public Table getTable();

    /**
     * The name of the table tha stores the foreign key.
     * @return String
     */
    public String getTableName();

    /**
     * Denotes whether or not a row of this column's table needs to be deleted if the importing key
     * is deleted.
     * @return boolean
     */
    public boolean isCascadeDelete();
}
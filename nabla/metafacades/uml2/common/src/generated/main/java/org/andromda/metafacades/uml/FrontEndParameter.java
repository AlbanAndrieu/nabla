// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * A front-end parameter is a parameter passed between front-end action states.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface FrontEndParameter
    extends ParameterFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isFrontEndParameterMetaType();

    /**
     * The action to which this parameter belongs (if it belongs to an action), otherwise it returns
     * null.
     * @return FrontEndAction
     */
    public FrontEndAction getAction();

    /**
     * Gets the controller operation to which this parameter belongs.
     * @return FrontEndControllerOperation
     */
    public FrontEndControllerOperation getControllerOperation();

    /**
     * A collection of all possible attribute names of a table (this will only work when your table
     * is modeled as an array..not a collection).
     * @return Collection<String>
     */
    public Collection<String> getTableAttributeNames();

    /**
     * All the columns for this parameter if it represents a table variable. If a column is linked
     * by an event (action) a FrontEndParameter instance is included in the return value, otherwise
     * a plain String representing the column name.
     * @return Collection<String>
     */
    public Collection<String> getTableColumnNames();

    /**
     * A list of all attributes which make up the table columns of this table (this only contains
     * attributes when the table is represented by an array).
     * @return Collection<String>
     */
    public Collection<String> getTableColumns();

    /**
     * Represents the view in which this parameter will be used.
     * @return FrontEndView
     */
    public FrontEndView getView();

    /**
     * Indicates whether or not this is an action parameter or not.
     * @return boolean
     */
    public boolean isActionParameter();

    /**
     * Indicates if this parameter is contained in a "front-end" use case.
     * @return boolean
     */
    public boolean isContainedInFrontEndUseCase();

    /**
     * Indicates whether or not this parameter is an argument of a controller operation.
     * @return boolean
     */
    public boolean isControllerOperationArgument();

    /**
     * Indicates whether or not this parameter represents a table.
     * @return boolean
     */
    public boolean isTable();
}
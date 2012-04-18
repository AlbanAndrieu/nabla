// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import org.andromda.metafacades.uml.AttributeFacade;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3SessionAttributeFacade
    extends AttributeFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3SessionAttributeFacadeMetaType();

    /**
     * Returns a parameter string for org.jboss.seam.annotations.In annotation. Supported
     * parameters:
     * * value - specifies the name of the context variable. Default to the name of the component
     * attribute. Alternatively, specifies a JSF EL expression, surrounded by #{...}.
     * * create - specifies that Seam should instantiate the component with the same name as the
     * context variable if the context variable is undefined (null) in all contexts. Default to
     * false.
     * * required - specifies Seam should throw an exception if the context variable is undefined in
     * all contexts.
     * @return String
     */
    public String getSeamBijectionInParameters();

    /**
     * Returns a parameter string for org.jboss.seam.annotations.Logger annotation. Supported
     * parameters:
     * value - specifies the name of the log category. Default to the name of the component class.
     * @return String
     */
    public String getSeamBijectionLoggerParameters();

    /**
     * Returns a parameter string for org.jboss.seam.annotations.Out annotation. Supported
     * parameters:
     * * value - specifies the name of the context variable. Default to the name of the component
     * attribute.
     * * required - specifies Seam should throw an exception if the component attribute is null
     * during outjection.
     * * scope - specifies the scope that Seam should bind the returned value to.
     * @return String
     */
    public String getSeamBijectionOutParameters();

    /**
     * Returns a parameter string for org.jboss.seam.annotations.RequestParameter annotation.
     * Supported parameters:
     * * value - specifies the name of the request parameter. Default to the name of the component
     * attribute.
     * @return String
     */
    public String getSeamBijectionRequestParameterParameters();

    /**
     * Returns a parameter string for org.jboss.seam.annotations.DataModel annotation. Supported
     * parameters:
     * * value - name of the conversation context variable. Default to the attribute name.
     * * scope - if scope=ScopeType.PAGE is explicitly specified, the DataModel will be kept in the
     * PAGE context.
     * @return String
     */
    public String getSeamDataModelParameters();

    /**
     * Returns a parameter string for org.jboss.seam.annotations.DataModelSelection annotation.
     * Supported parameters:
     * * value - name of the conversation context variable. Not needed if there is exactly one
     * DataModel in the component.
     * @return String
     */
    public String getSeamDataModelSelectionIndexParameters();

    /**
     * Returns a parameter string for org.jboss.seam.annotations.DataModelSelection annotation.
     * Supported parameters:
     * * value - name of the conversation context variable. Not needed if there is exactly one
     * DataModel in the component.
     * @return String
     */
    public String getSeamDataModelSelectionParameters();

    /**
     * Gets the transaction type for this attribute (i.e. REQUIRED, etc)
     * @return String
     */
    public String getTransactionType();

    /**
     * Returns true if this attribute is a seam component attribute, marked with one or more of the
     * following annotations In, Out, Log, RequestParameter, DataModel, DatamodeSelection
     * @return boolean
     */
    public boolean isSeamAttribute();

    /**
     * Returns true the attribute is modelled with the <<In>> stereotype indicating that it is a
     * Seam component attribute and is to be injected from a context variable at the start of each
     * component invocation.
     * @return boolean
     */
    public boolean isSeamBijectionIn();

    /**
     * Returns true if stereotype <<Logger>> is set. Specifies that a component field is to be
     * injected with an instance of org.jboss.seam.log.Log.
     * @return boolean
     */
    public boolean isSeamBijectionLogger();

    /**
     * Returns true if the attribute is modelled with the <<Out>> stereotype indicating that it is a
     * Seam component attribute and is to be outjected to a context variable at the end of each
     * component invocation.
     * @return boolean
     */
    public boolean isSeamBijectionOut();

    /**
     * Returns true if stereotype <<RequestParameter>> is set. Specifies that a component attribute
     * is to be injected with the value of a request parameter. Basic type conversions are performed
     * automatically.
     * @return boolean
     */
    public boolean isSeamBijectionRequestParameter();

    /**
     * Returns true if the attribute of type List, Map, Set or Object[] is modelled with the
     * <<DataModel>> stereotype indicating that it shall be exposed as a JSF DataModel into the
     * scope of the owning component (or the EVENT scope if the owning component is STATELESS). In
     * the case of Map, each row of the DataModel is a Map.Entry.
     * @return boolean
     */
    public boolean isSeamDataModel();

    /**
     * Returns true if stereotype <<DataModelSelection>> is set. Injects the selected value from the
     * JSF DataModel (this is the element of the underlying collection, or the map value).
     * @return boolean
     */
    public boolean isSeamDataModelSelection();

    /**
     * Returns true if stereotype <<DataModelSelectionIndex>> is set. Exposes the selection index of
     * the JSF DataModel as an attribute of the component (this is the row number of the underlying
     * collection, or the map key).
     * @return boolean
     */
    public boolean isSeamDataModelSelectionIndex();

    /**
     * Returns true if the <<Valid>> stereotype is modelled on seam component bean attribute to
     * Indicates that the hibernate Validator recursively validate this and related objects when an
     * action listener Seam component method with IfInvalid annotation is invoked.
     * @return boolean
     */
    public boolean isSeamValidationValid();
}
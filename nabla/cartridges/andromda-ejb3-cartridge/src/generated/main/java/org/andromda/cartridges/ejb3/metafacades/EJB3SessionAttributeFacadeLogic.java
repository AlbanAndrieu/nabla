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
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.EnumerationFacade;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;

/**
 * 
 * MetafacadeLogic for EJB3SessionAttributeFacade
 *
 * @see EJB3SessionAttributeFacade
 */
public abstract class EJB3SessionAttributeFacadeLogic
    extends MetafacadeBase
    implements EJB3SessionAttributeFacade
{
    /**
     * The underlying UML object
     * @see Object
     */
    protected Object metaObject;

    /** Create Metafacade implementation instance using the MetafacadeFactory from the context
     * @param metaObjectIn
     * @param context
     */
    protected EJB3SessionAttributeFacadeLogic(Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superAttributeFacade =
           (AttributeFacade)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.AttributeFacade",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to EJB3SessionAttributeFacade if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade";
        }
        return context;
    }

    private AttributeFacade superAttributeFacade;
    private boolean superAttributeFacadeInitialized = false;

    /**
     * Gets the AttributeFacade parent instance.
     * @return this.superAttributeFacade AttributeFacade
     */
    private AttributeFacade getSuperAttributeFacade()
    {
        if (!this.superAttributeFacadeInitialized)
        {
            ((MetafacadeBase)this.superAttributeFacade).setMetafacadeContext(this.getMetafacadeContext());
            this.superAttributeFacadeInitialized = true;
        }
        return this.superAttributeFacade;
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
            if (this.superAttributeFacadeInitialized)
            {
                ((MetafacadeBase)this.superAttributeFacade).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see EJB3SessionAttributeFacade
     */
    public boolean isEJB3SessionAttributeFacadeMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade#getTransactionType()
    * @return String
    */
    protected abstract String handleGetTransactionType();

    private String __transactionType1a;
    private boolean __transactionType1aSet = false;

    /**
     * Gets the transaction type for this attribute (i.e. REQUIRED, etc)
     * @return (String)handleGetTransactionType()
     */
    public final String getTransactionType()
    {
        String transactionType1a = this.__transactionType1a;
        if (!this.__transactionType1aSet)
        {
            // transactionType has no pre constraints
            transactionType1a = handleGetTransactionType();
            // transactionType has no post constraints
            this.__transactionType1a = transactionType1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__transactionType1aSet = true;
            }
        }
        return transactionType1a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade#isSeamBijectionIn()
    * @return boolean
    */
    protected abstract boolean handleIsSeamBijectionIn();

    private boolean __seamBijectionIn2a;
    private boolean __seamBijectionIn2aSet = false;

    /**
     * Returns true the attribute is modelled with the <<In>> stereotype indicating that it is a
     * Seam component attribute and is to be injected from a context variable at the start of each
     * component invocation.
     * @return (boolean)handleIsSeamBijectionIn()
     */
    public final boolean isSeamBijectionIn()
    {
        boolean seamBijectionIn2a = this.__seamBijectionIn2a;
        if (!this.__seamBijectionIn2aSet)
        {
            // seamBijectionIn has no pre constraints
            seamBijectionIn2a = handleIsSeamBijectionIn();
            // seamBijectionIn has no post constraints
            this.__seamBijectionIn2a = seamBijectionIn2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__seamBijectionIn2aSet = true;
            }
        }
        return seamBijectionIn2a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade#isSeamBijectionOut()
    * @return boolean
    */
    protected abstract boolean handleIsSeamBijectionOut();

    private boolean __seamBijectionOut3a;
    private boolean __seamBijectionOut3aSet = false;

    /**
     * Returns true if the attribute is modelled with the <<Out>> stereotype indicating that it is a
     * Seam component attribute and is to be outjected to a context variable at the end of each
     * component invocation.
     * @return (boolean)handleIsSeamBijectionOut()
     */
    public final boolean isSeamBijectionOut()
    {
        boolean seamBijectionOut3a = this.__seamBijectionOut3a;
        if (!this.__seamBijectionOut3aSet)
        {
            // seamBijectionOut has no pre constraints
            seamBijectionOut3a = handleIsSeamBijectionOut();
            // seamBijectionOut has no post constraints
            this.__seamBijectionOut3a = seamBijectionOut3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__seamBijectionOut3aSet = true;
            }
        }
        return seamBijectionOut3a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade#isSeamValidationValid()
    * @return boolean
    */
    protected abstract boolean handleIsSeamValidationValid();

    private boolean __seamValidationValid4a;
    private boolean __seamValidationValid4aSet = false;

    /**
     * Returns true if the <<Valid>> stereotype is modelled on seam component bean attribute to
     * Indicates that the hibernate Validator recursively validate this and related objects when an
     * action listener Seam component method with IfInvalid annotation is invoked.
     * @return (boolean)handleIsSeamValidationValid()
     */
    public final boolean isSeamValidationValid()
    {
        boolean seamValidationValid4a = this.__seamValidationValid4a;
        if (!this.__seamValidationValid4aSet)
        {
            // seamValidationValid has no pre constraints
            seamValidationValid4a = handleIsSeamValidationValid();
            // seamValidationValid has no post constraints
            this.__seamValidationValid4a = seamValidationValid4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__seamValidationValid4aSet = true;
            }
        }
        return seamValidationValid4a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade#isSeamDataModel()
    * @return boolean
    */
    protected abstract boolean handleIsSeamDataModel();

    private boolean __seamDataModel5a;
    private boolean __seamDataModel5aSet = false;

    /**
     * Returns true if the attribute of type List, Map, Set or Object[] is modelled with the
     * <<DataModel>> stereotype indicating that it shall be exposed as a JSF DataModel into the
     * scope of the owning component (or the EVENT scope if the owning component is STATELESS). In
     * the case of Map, each row of the DataModel is a Map.Entry.
     * @return (boolean)handleIsSeamDataModel()
     */
    public final boolean isSeamDataModel()
    {
        boolean seamDataModel5a = this.__seamDataModel5a;
        if (!this.__seamDataModel5aSet)
        {
            // seamDataModel has no pre constraints
            seamDataModel5a = handleIsSeamDataModel();
            // seamDataModel has no post constraints
            this.__seamDataModel5a = seamDataModel5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__seamDataModel5aSet = true;
            }
        }
        return seamDataModel5a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade#isSeamDataModelSelection()
    * @return boolean
    */
    protected abstract boolean handleIsSeamDataModelSelection();

    private boolean __seamDataModelSelection6a;
    private boolean __seamDataModelSelection6aSet = false;

    /**
     * Returns true if stereotype <<DataModelSelection>> is set. Injects the selected value from the
     * JSF DataModel (this is the element of the underlying collection, or the map value).
     * @return (boolean)handleIsSeamDataModelSelection()
     */
    public final boolean isSeamDataModelSelection()
    {
        boolean seamDataModelSelection6a = this.__seamDataModelSelection6a;
        if (!this.__seamDataModelSelection6aSet)
        {
            // seamDataModelSelection has no pre constraints
            seamDataModelSelection6a = handleIsSeamDataModelSelection();
            // seamDataModelSelection has no post constraints
            this.__seamDataModelSelection6a = seamDataModelSelection6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__seamDataModelSelection6aSet = true;
            }
        }
        return seamDataModelSelection6a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade#isSeamDataModelSelectionIndex()
    * @return boolean
    */
    protected abstract boolean handleIsSeamDataModelSelectionIndex();

    private boolean __seamDataModelSelectionIndex7a;
    private boolean __seamDataModelSelectionIndex7aSet = false;

    /**
     * Returns true if stereotype <<DataModelSelectionIndex>> is set. Exposes the selection index of
     * the JSF DataModel as an attribute of the component (this is the row number of the underlying
     * collection, or the map key).
     * @return (boolean)handleIsSeamDataModelSelectionIndex()
     */
    public final boolean isSeamDataModelSelectionIndex()
    {
        boolean seamDataModelSelectionIndex7a = this.__seamDataModelSelectionIndex7a;
        if (!this.__seamDataModelSelectionIndex7aSet)
        {
            // seamDataModelSelectionIndex has no pre constraints
            seamDataModelSelectionIndex7a = handleIsSeamDataModelSelectionIndex();
            // seamDataModelSelectionIndex has no post constraints
            this.__seamDataModelSelectionIndex7a = seamDataModelSelectionIndex7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__seamDataModelSelectionIndex7aSet = true;
            }
        }
        return seamDataModelSelectionIndex7a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade#isSeamBijectionLogger()
    * @return boolean
    */
    protected abstract boolean handleIsSeamBijectionLogger();

    private boolean __seamBijectionLogger8a;
    private boolean __seamBijectionLogger8aSet = false;

    /**
     * Returns true if stereotype <<Logger>> is set. Specifies that a component field is to be
     * injected with an instance of org.jboss.seam.log.Log.
     * @return (boolean)handleIsSeamBijectionLogger()
     */
    public final boolean isSeamBijectionLogger()
    {
        boolean seamBijectionLogger8a = this.__seamBijectionLogger8a;
        if (!this.__seamBijectionLogger8aSet)
        {
            // seamBijectionLogger has no pre constraints
            seamBijectionLogger8a = handleIsSeamBijectionLogger();
            // seamBijectionLogger has no post constraints
            this.__seamBijectionLogger8a = seamBijectionLogger8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__seamBijectionLogger8aSet = true;
            }
        }
        return seamBijectionLogger8a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade#isSeamBijectionRequestParameter()
    * @return boolean
    */
    protected abstract boolean handleIsSeamBijectionRequestParameter();

    private boolean __seamBijectionRequestParameter9a;
    private boolean __seamBijectionRequestParameter9aSet = false;

    /**
     * Returns true if stereotype <<RequestParameter>> is set. Specifies that a component attribute
     * is to be injected with the value of a request parameter. Basic type conversions are performed
     * automatically.
     * @return (boolean)handleIsSeamBijectionRequestParameter()
     */
    public final boolean isSeamBijectionRequestParameter()
    {
        boolean seamBijectionRequestParameter9a = this.__seamBijectionRequestParameter9a;
        if (!this.__seamBijectionRequestParameter9aSet)
        {
            // seamBijectionRequestParameter has no pre constraints
            seamBijectionRequestParameter9a = handleIsSeamBijectionRequestParameter();
            // seamBijectionRequestParameter has no post constraints
            this.__seamBijectionRequestParameter9a = seamBijectionRequestParameter9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__seamBijectionRequestParameter9aSet = true;
            }
        }
        return seamBijectionRequestParameter9a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade#getSeamBijectionInParameters()
    * @return String
    */
    protected abstract String handleGetSeamBijectionInParameters();

    private String __seamBijectionInParameters10a;
    private boolean __seamBijectionInParameters10aSet = false;

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
     * @return (String)handleGetSeamBijectionInParameters()
     */
    public final String getSeamBijectionInParameters()
    {
        String seamBijectionInParameters10a = this.__seamBijectionInParameters10a;
        if (!this.__seamBijectionInParameters10aSet)
        {
            // seamBijectionInParameters has no pre constraints
            seamBijectionInParameters10a = handleGetSeamBijectionInParameters();
            // seamBijectionInParameters has no post constraints
            this.__seamBijectionInParameters10a = seamBijectionInParameters10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__seamBijectionInParameters10aSet = true;
            }
        }
        return seamBijectionInParameters10a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade#getSeamBijectionLoggerParameters()
    * @return String
    */
    protected abstract String handleGetSeamBijectionLoggerParameters();

    private String __seamBijectionLoggerParameters11a;
    private boolean __seamBijectionLoggerParameters11aSet = false;

    /**
     * Returns a parameter string for org.jboss.seam.annotations.Logger annotation. Supported
     * parameters:
     * value - specifies the name of the log category. Default to the name of the component class.
     * @return (String)handleGetSeamBijectionLoggerParameters()
     */
    public final String getSeamBijectionLoggerParameters()
    {
        String seamBijectionLoggerParameters11a = this.__seamBijectionLoggerParameters11a;
        if (!this.__seamBijectionLoggerParameters11aSet)
        {
            // seamBijectionLoggerParameters has no pre constraints
            seamBijectionLoggerParameters11a = handleGetSeamBijectionLoggerParameters();
            // seamBijectionLoggerParameters has no post constraints
            this.__seamBijectionLoggerParameters11a = seamBijectionLoggerParameters11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__seamBijectionLoggerParameters11aSet = true;
            }
        }
        return seamBijectionLoggerParameters11a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade#getSeamBijectionOutParameters()
    * @return String
    */
    protected abstract String handleGetSeamBijectionOutParameters();

    private String __seamBijectionOutParameters12a;
    private boolean __seamBijectionOutParameters12aSet = false;

    /**
     * Returns a parameter string for org.jboss.seam.annotations.Out annotation. Supported
     * parameters:
     * * value - specifies the name of the context variable. Default to the name of the component
     * attribute.
     * * required - specifies Seam should throw an exception if the component attribute is null
     * during outjection.
     * * scope - specifies the scope that Seam should bind the returned value to.
     * @return (String)handleGetSeamBijectionOutParameters()
     */
    public final String getSeamBijectionOutParameters()
    {
        String seamBijectionOutParameters12a = this.__seamBijectionOutParameters12a;
        if (!this.__seamBijectionOutParameters12aSet)
        {
            // seamBijectionOutParameters has no pre constraints
            seamBijectionOutParameters12a = handleGetSeamBijectionOutParameters();
            // seamBijectionOutParameters has no post constraints
            this.__seamBijectionOutParameters12a = seamBijectionOutParameters12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__seamBijectionOutParameters12aSet = true;
            }
        }
        return seamBijectionOutParameters12a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade#getSeamBijectionRequestParameterParameters()
    * @return String
    */
    protected abstract String handleGetSeamBijectionRequestParameterParameters();

    private String __seamBijectionRequestParameterParameters13a;
    private boolean __seamBijectionRequestParameterParameters13aSet = false;

    /**
     * Returns a parameter string for org.jboss.seam.annotations.RequestParameter annotation.
     * Supported parameters:
     * * value - specifies the name of the request parameter. Default to the name of the component
     * attribute.
     * @return (String)handleGetSeamBijectionRequestParameterParameters()
     */
    public final String getSeamBijectionRequestParameterParameters()
    {
        String seamBijectionRequestParameterParameters13a = this.__seamBijectionRequestParameterParameters13a;
        if (!this.__seamBijectionRequestParameterParameters13aSet)
        {
            // seamBijectionRequestParameterParameters has no pre constraints
            seamBijectionRequestParameterParameters13a = handleGetSeamBijectionRequestParameterParameters();
            // seamBijectionRequestParameterParameters has no post constraints
            this.__seamBijectionRequestParameterParameters13a = seamBijectionRequestParameterParameters13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__seamBijectionRequestParameterParameters13aSet = true;
            }
        }
        return seamBijectionRequestParameterParameters13a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade#getSeamDataModelParameters()
    * @return String
    */
    protected abstract String handleGetSeamDataModelParameters();

    private String __seamDataModelParameters14a;
    private boolean __seamDataModelParameters14aSet = false;

    /**
     * Returns a parameter string for org.jboss.seam.annotations.DataModel annotation. Supported
     * parameters:
     * * value - name of the conversation context variable. Default to the attribute name.
     * * scope - if scope=ScopeType.PAGE is explicitly specified, the DataModel will be kept in the
     * PAGE context.
     * @return (String)handleGetSeamDataModelParameters()
     */
    public final String getSeamDataModelParameters()
    {
        String seamDataModelParameters14a = this.__seamDataModelParameters14a;
        if (!this.__seamDataModelParameters14aSet)
        {
            // seamDataModelParameters has no pre constraints
            seamDataModelParameters14a = handleGetSeamDataModelParameters();
            // seamDataModelParameters has no post constraints
            this.__seamDataModelParameters14a = seamDataModelParameters14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__seamDataModelParameters14aSet = true;
            }
        }
        return seamDataModelParameters14a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade#getSeamDataModelSelectionParameters()
    * @return String
    */
    protected abstract String handleGetSeamDataModelSelectionParameters();

    private String __seamDataModelSelectionParameters15a;
    private boolean __seamDataModelSelectionParameters15aSet = false;

    /**
     * Returns a parameter string for org.jboss.seam.annotations.DataModelSelection annotation.
     * Supported parameters:
     * * value - name of the conversation context variable. Not needed if there is exactly one
     * DataModel in the component.
     * @return (String)handleGetSeamDataModelSelectionParameters()
     */
    public final String getSeamDataModelSelectionParameters()
    {
        String seamDataModelSelectionParameters15a = this.__seamDataModelSelectionParameters15a;
        if (!this.__seamDataModelSelectionParameters15aSet)
        {
            // seamDataModelSelectionParameters has no pre constraints
            seamDataModelSelectionParameters15a = handleGetSeamDataModelSelectionParameters();
            // seamDataModelSelectionParameters has no post constraints
            this.__seamDataModelSelectionParameters15a = seamDataModelSelectionParameters15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__seamDataModelSelectionParameters15aSet = true;
            }
        }
        return seamDataModelSelectionParameters15a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade#getSeamDataModelSelectionIndexParameters()
    * @return String
    */
    protected abstract String handleGetSeamDataModelSelectionIndexParameters();

    private String __seamDataModelSelectionIndexParameters16a;
    private boolean __seamDataModelSelectionIndexParameters16aSet = false;

    /**
     * Returns a parameter string for org.jboss.seam.annotations.DataModelSelection annotation.
     * Supported parameters:
     * * value - name of the conversation context variable. Not needed if there is exactly one
     * DataModel in the component.
     * @return (String)handleGetSeamDataModelSelectionIndexParameters()
     */
    public final String getSeamDataModelSelectionIndexParameters()
    {
        String seamDataModelSelectionIndexParameters16a = this.__seamDataModelSelectionIndexParameters16a;
        if (!this.__seamDataModelSelectionIndexParameters16aSet)
        {
            // seamDataModelSelectionIndexParameters has no pre constraints
            seamDataModelSelectionIndexParameters16a = handleGetSeamDataModelSelectionIndexParameters();
            // seamDataModelSelectionIndexParameters has no post constraints
            this.__seamDataModelSelectionIndexParameters16a = seamDataModelSelectionIndexParameters16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__seamDataModelSelectionIndexParameters16aSet = true;
            }
        }
        return seamDataModelSelectionIndexParameters16a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade#isSeamAttribute()
    * @return boolean
    */
    protected abstract boolean handleIsSeamAttribute();

    private boolean __seamAttribute17a;
    private boolean __seamAttribute17aSet = false;

    /**
     * Returns true if this attribute is a seam component attribute, marked with one or more of the
     * following annotations In, Out, Log, RequestParameter, DataModel, DatamodeSelection
     * @return (boolean)handleIsSeamAttribute()
     */
    public final boolean isSeamAttribute()
    {
        boolean seamAttribute17a = this.__seamAttribute17a;
        if (!this.__seamAttribute17aSet)
        {
            // seamAttribute has no pre constraints
            seamAttribute17a = handleIsSeamAttribute();
            // seamAttribute has no post constraints
            this.__seamAttribute17a = seamAttribute17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__seamAttribute17aSet = true;
            }
        }
        return seamAttribute17a;
    }

    /**
     * @return true
     * @see AttributeFacade
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

    // ----------- delegates to AttributeFacade ------------
    /**
     * Searches the given feature for the specified tag.
     * If the follow boolean is set to true then the search will continue from the class attribute
     * to the class itself and then up the class hierarchy.
     * @see AttributeFacade#findTaggedValue(String name, boolean follow)
     */
    public Object findTaggedValue(String name, boolean follow)
    {
        return this.getSuperAttributeFacade().findTaggedValue(name, follow);
    }

    /**
     * The default value of the attribute.  This is the value given if no value is defined.
     * @see AttributeFacade#getDefaultValue()
     */
    public String getDefaultValue()
    {
        return this.getSuperAttributeFacade().getDefaultValue();
    }

    /**
     * If the attribute is an enumeration literal this represents the owning enumeration. Can be
     * empty.
     * @see AttributeFacade#getEnumeration()
     */
    public EnumerationFacade getEnumeration()
    {
        return this.getSuperAttributeFacade().getEnumeration();
    }

    /**
     * Returns the enumeration literal parameters defined by tagged value as a comma separated list.
     * @see AttributeFacade#getEnumerationLiteralParameters()
     */
    public String getEnumerationLiteralParameters()
    {
        return this.getSuperAttributeFacade().getEnumerationLiteralParameters();
    }

    /**
     * The value for this attribute if it is an enumeration literal, null otherwise. The default
     * value is returned as a String if it has been specified, if it's not specified this
     * attribute's name is assumed.
     * @see AttributeFacade#getEnumerationValue()
     */
    public String getEnumerationValue()
    {
        return this.getSuperAttributeFacade().getEnumerationValue();
    }

    /**
     * The name of the accessor operation that would retrieve this attribute's value.
     * @see AttributeFacade#getGetterName()
     */
    public String getGetterName()
    {
        return this.getSuperAttributeFacade().getGetterName();
    }

    /**
     * The name of the type that is returned on the accessor and mutator operations,  determined in
     * part by the multiplicity.
     * @see AttributeFacade#getGetterSetterTypeName()
     */
    public String getGetterSetterTypeName()
    {
        return this.getSuperAttributeFacade().getGetterSetterTypeName();
    }

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @see AttributeFacade#getLower()
     */
    public int getLower()
    {
        return this.getSuperAttributeFacade().getLower();
    }

    /**
     * Gets the classifier who is the owner of the attributes.
     * @see AttributeFacade#getOwner()
     */
    public ClassifierFacade getOwner()
    {
        return this.getSuperAttributeFacade().getOwner();
    }

    /**
     * The name of the mutator operation that would retrieve this attribute's value.
     * @see AttributeFacade#getSetterName()
     */
    public String getSetterName()
    {
        return this.getSuperAttributeFacade().getSetterName();
    }

    /**
     * The classifier owning this attribute.
     * @see AttributeFacade#getType()
     */
    public ClassifierFacade getType()
    {
        return this.getSuperAttributeFacade().getType();
    }

    /**
     * the upper value for the multiplicity (will be -1 for *)
     * -only applicable for UML2
     * @see AttributeFacade#getUpper()
     */
    public int getUpper()
    {
        return this.getSuperAttributeFacade().getUpper();
    }

    /**
     * True if this attribute can only be set.
     * @see AttributeFacade#isAddOnly()
     */
    public boolean isAddOnly()
    {
        return this.getSuperAttributeFacade().isAddOnly();
    }

    /**
     * True if this attribute can be modified.
     * @see AttributeFacade#isChangeable()
     */
    public boolean isChangeable()
    {
        return this.getSuperAttributeFacade().isChangeable();
    }

    /**
     * Indicates if the default value is present.
     * @see AttributeFacade#isDefaultValuePresent()
     */
    public boolean isDefaultValuePresent()
    {
        return this.getSuperAttributeFacade().isDefaultValuePresent();
    }

    /**
     * If the attribute is derived (its value is computed). UML2 only. UML14 always returns false.
     * Default=false.
     * @see AttributeFacade#isDerived()
     */
    public boolean isDerived()
    {
        return this.getSuperAttributeFacade().isDerived();
    }

    /**
     * True if this attribute is owned by an enumeration.
     * @see AttributeFacade#isEnumerationLiteral()
     */
    public boolean isEnumerationLiteral()
    {
        return this.getSuperAttributeFacade().isEnumerationLiteral();
    }

    /**
     * Returns true if enumeration literal parameters exist (defined by tagged value) for the
     * literal.
     * @see AttributeFacade#isEnumerationLiteralParametersExist()
     */
    public boolean isEnumerationLiteralParametersExist()
    {
        return this.getSuperAttributeFacade().isEnumerationLiteralParametersExist();
    }

    /**
     * True if this attribute is owned by an enumeration but is defined as a member variable (NOT a
     * literal).
     * @see AttributeFacade#isEnumerationMember()
     */
    public boolean isEnumerationMember()
    {
        return this.getSuperAttributeFacade().isEnumerationMember();
    }

    /**
     * IsLeaf property in the operation. If true, operation is final, cannot be extended or
     * implemented by a descendant.
     * @see AttributeFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperAttributeFacade().isLeaf();
    }

    /**
     * Whether or not this attribute has a multiplicity greater than 1.
     * @see AttributeFacade#isMany()
     */
    public boolean isMany()
    {
        return this.getSuperAttributeFacade().isMany();
    }

    /**
     * Indicates whether or not the attributes are ordered (if multiplicity is greater than 1).
     * @see AttributeFacade#isOrdered()
     */
    public boolean isOrdered()
    {
        return this.getSuperAttributeFacade().isOrdered();
    }

    /**
     * Whether or not this attribute can be modified.
     * @see AttributeFacade#isReadOnly()
     */
    public boolean isReadOnly()
    {
        return this.getSuperAttributeFacade().isReadOnly();
    }

    /**
     * Whether or not the multiplicity of this attribute is 1.
     * @see AttributeFacade#isRequired()
     */
    public boolean isRequired()
    {
        return this.getSuperAttributeFacade().isRequired();
    }

    /**
     * Indicates if this attribute is 'static', meaning it has a classifier scope.
     * @see AttributeFacade#isStatic()
     */
    public boolean isStatic()
    {
        return this.getSuperAttributeFacade().isStatic();
    }

    /**
     * If the attribute is unique within the Collection type. UML2 only. UML14 always returns false.
     * Unique+Ordered determines the implementation Collection type. Default=false.
     * @see AttributeFacade#isUnique()
     */
    public boolean isUnique()
    {
        return this.getSuperAttributeFacade().isUnique();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperAttributeFacade().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperAttributeFacade().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection findTaggedValues(String tagName)
    {
        return this.getSuperAttributeFacade().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperAttributeFacade().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperAttributeFacade().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection getConstraints(String kind)
    {
        return this.getSuperAttributeFacade().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperAttributeFacade().getDocumentation(indent);
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
        return this.getSuperAttributeFacade().getDocumentation(indent, lineLength);
    }

    /**
     * 
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperAttributeFacade().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperAttributeFacade().getFullyQualifiedName();
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
        return this.getSuperAttributeFacade().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperAttributeFacade().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperAttributeFacade().getId();
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
        return this.getSuperAttributeFacade().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperAttributeFacade().getLabel();
    }

    /**
     * The language mappings that have been set for this model elemnt.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperAttributeFacade().getLanguageMappings();
    }

    /**
     * 
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperAttributeFacade().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperAttributeFacade().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperAttributeFacade().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperAttributeFacade().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperAttributeFacade().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperAttributeFacade().getPackagePath();
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
        return this.getSuperAttributeFacade().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperAttributeFacade().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperAttributeFacade().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperAttributeFacade().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperAttributeFacade().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperAttributeFacade().getStereotypes();
    }

    /**
     * 
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperAttributeFacade().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperAttributeFacade().getTargetDependencies();
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperAttributeFacade().getTemplateParameter(parameterName);
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperAttributeFacade().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperAttributeFacade().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperAttributeFacade().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperAttributeFacade().hasKeyword(keywordName);
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
        return this.getSuperAttributeFacade().hasStereotype(stereotypeName);
    }

    /**
     * 
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperAttributeFacade().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperAttributeFacade().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperAttributeFacade().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperAttributeFacade().isReservedWord();
    }

    /**
     * 
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperAttributeFacade().isTemplateParametersPresent();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperAttributeFacade().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperAttributeFacade().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperAttributeFacade().translateConstraints(kind, translation);
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperAttributeFacade().initialize();
    }

    /**
     * @return Object getSuperAttributeFacade().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperAttributeFacade().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperAttributeFacade().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperAttributeFacade().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperAttributeFacade().validateInvariants(validationMessages);
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
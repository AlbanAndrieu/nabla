// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.seam.metafacades;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.andromda.cartridges.jsf.metafacades.JSFAction;
import org.andromda.cartridges.jsf.metafacades.JSFForward;
import org.andromda.cartridges.jsf.metafacades.JSFPortletPreferences;
import org.andromda.cartridges.jsf.metafacades.JSFUseCase;
import org.andromda.cartridges.jsf.metafacades.JSFView;
import org.andromda.core.common.Introspector;
import org.andromda.core.metafacade.MetafacadeBase;
import org.andromda.core.metafacade.MetafacadeFactory;
import org.andromda.core.metafacade.ModelValidationMessage;
import org.andromda.metafacades.uml.ActivityGraphFacade;
import org.andromda.metafacades.uml.AssociationEndFacade;
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.ExtendFacade;
import org.andromda.metafacades.uml.ExtensionPointFacade;
import org.andromda.metafacades.uml.FrontEndAction;
import org.andromda.metafacades.uml.FrontEndActivityGraph;
import org.andromda.metafacades.uml.FrontEndController;
import org.andromda.metafacades.uml.FrontEndFinalState;
import org.andromda.metafacades.uml.FrontEndParameter;
import org.andromda.metafacades.uml.FrontEndUseCase;
import org.andromda.metafacades.uml.FrontEndView;
import org.andromda.metafacades.uml.GeneralizableElementFacade;
import org.andromda.metafacades.uml.GeneralizationFacade;
import org.andromda.metafacades.uml.IncludeFacade;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.Role;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;

/**
 * 
 * MetafacadeLogic for SeamUseCase
 *
 * @see SeamUseCase
 */
public abstract class SeamUseCaseLogic
    extends MetafacadeBase
    implements SeamUseCase
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
    protected SeamUseCaseLogic(Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superJSFUseCase =
           (JSFUseCase)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.cartridges.jsf.metafacades.JSFUseCase",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to SeamUseCase if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.seam.metafacades.SeamUseCase";
        }
        return context;
    }

    private JSFUseCase superJSFUseCase;
    private boolean superJSFUseCaseInitialized = false;

    /**
     * Gets the JSFUseCase parent instance.
     * @return this.superJSFUseCase JSFUseCase
     */
    private JSFUseCase getSuperJSFUseCase()
    {
        if (!this.superJSFUseCaseInitialized)
        {
            ((MetafacadeBase)this.superJSFUseCase).setMetafacadeContext(this.getMetafacadeContext());
            this.superJSFUseCaseInitialized = true;
        }
        return this.superJSFUseCase;
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
            if (this.superJSFUseCaseInitialized)
            {
                ((MetafacadeBase)this.superJSFUseCase).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see SeamUseCase
     */
    public boolean isSeamUseCaseMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see JSFUseCase
     */
    public boolean isJSFUseCaseMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see FrontEndUseCase
     */
    public boolean isFrontEndUseCaseMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.UseCaseFacade
     */
    public boolean isUseCaseFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.NamespaceFacade
     */
    public boolean isNamespaceFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see ClassifierFacade
     */
    public boolean isClassifierFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see GeneralizableElementFacade
     */
    public boolean isGeneralizableElementFacadeMetaType()
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

    // ----------- delegates to JSFUseCase ------------
    /**
     * The name of the action class that forwards to this use case.
     * @see JSFUseCase#getActionClassName()
     */
    public String getActionClassName()
    {
        return this.getSuperJSFUseCase().getActionClassName();
    }

    /**
     * All forwards in this use case that are represented as actions.
     * @see JSFUseCase#getActionForwards()
     */
    public List<JSFAction> getActionForwards()
    {
        return this.getSuperJSFUseCase().getActionForwards();
    }

    /**
     * 
     * @see JSFUseCase#getActionRoles()
     */
    public String getActionRoles()
    {
        return this.getSuperJSFUseCase().getActionRoles();
    }

    /**
     * Constains all forwards includes regular FrontEndForwards and all actiion forwards.
     * @see JSFUseCase#getAllForwards()
     */
    public List getAllForwards()
    {
        return this.getSuperJSFUseCase().getAllForwards();
    }

    /**
     * A map with keys sorted alphabetically, normalized across all different use-cases, views, etc.
     * @see JSFUseCase#getAllMessages()
     */
    public Map getAllMessages()
    {
        return this.getSuperJSFUseCase().getAllMessages();
    }

    /**
     * All views for the application (not just the ones belonging to this use case).
     * @see JSFUseCase#getAllViews()
     */
    public Collection<JSFView> getAllViews()
    {
        return this.getSuperJSFUseCase().getAllViews();
    }

    /**
     * The name of the action on the controller that executions this use case.
     * @see JSFUseCase#getControllerAction()
     */
    public String getControllerAction()
    {
        return this.getSuperJSFUseCase().getControllerAction();
    }

    /**
     * The key under which to store the action form passed along in this in this use-case.
     * @see JSFUseCase#getFormKey()
     */
    public String getFormKey()
    {
        return this.getSuperJSFUseCase().getFormKey();
    }

    /**
     * The name that will cause a forward to use case.
     * @see JSFUseCase#getForwardName()
     */
    public String getForwardName()
    {
        return this.getSuperJSFUseCase().getForwardName();
    }

    /**
     * All forwards contained in this use case.
     * @see JSFUseCase#getForwards()
     */
    public List<JSFForward> getForwards()
    {
        return this.getSuperJSFUseCase().getForwards();
    }

    /**
     * The name of the class that stores all the forwards paths.
     * @see JSFUseCase#getForwardsClassName()
     */
    public String getForwardsClassName()
    {
        return this.getSuperJSFUseCase().getForwardsClassName();
    }

    /**
     * The fully qualified name of the action class that forwards to this use case.
     * @see JSFUseCase#getFullyQualifiedActionClassName()
     */
    public String getFullyQualifiedActionClassName()
    {
        return this.getSuperJSFUseCase().getFullyQualifiedActionClassName();
    }

    /**
     * The fully qualified path to the action class that forwards to this use case.
     * @see JSFUseCase#getFullyQualifiedActionClassPath()
     */
    public String getFullyQualifiedActionClassPath()
    {
        return this.getSuperJSFUseCase().getFullyQualifiedActionClassPath();
    }

    /**
     * The path of the initial target going into this use case.
     * @see JSFUseCase#getInitialTargetPath()
     */
    public String getInitialTargetPath()
    {
        return this.getSuperJSFUseCase().getInitialTargetPath();
    }

    /**
     * 
     * @see JSFUseCase#getNavigationChildren()
     */
    public Collection getNavigationChildren()
    {
        return this.getSuperJSFUseCase().getNavigationChildren();
    }

    /**
     * 
     * @see JSFUseCase#getNavigationParents()
     */
    public Collection getNavigationParents()
    {
        return this.getSuperJSFUseCase().getNavigationParents();
    }

    /**
     * Retrieves all navigation rules for the faces-config.xml
     * @see JSFUseCase#getNavigationRules()
     */
    public Collection getNavigationRules()
    {
        return this.getSuperJSFUseCase().getNavigationRules();
    }

    /**
     * The path to which this use case points.
     * @see JSFUseCase#getPath()
     */
    public String getPath()
    {
        return this.getSuperJSFUseCase().getPath();
    }

    /**
     * The root path for this use case (this is the path the directory containing the use case's
     * resources).
     * @see JSFUseCase#getPathRoot()
     */
    public String getPathRoot()
    {
        return this.getSuperJSFUseCase().getPathRoot();
    }

    /**
     * The forward name for the portlet 'edit' page.
     * @see JSFUseCase#getPortletEditForwardName()
     */
    public String getPortletEditForwardName()
    {
        return this.getSuperJSFUseCase().getPortletEditForwardName();
    }

    /**
     * The path to the portlet 'edit' page.
     * @see JSFUseCase#getPortletEditPath()
     */
    public String getPortletEditPath()
    {
        return this.getSuperJSFUseCase().getPortletEditPath();
    }

    /**
     * The forward name for the portlet 'help' page.
     * @see JSFUseCase#getPortletHelpForwardName()
     */
    public String getPortletHelpForwardName()
    {
        return this.getSuperJSFUseCase().getPortletHelpForwardName();
    }

    /**
     * The path to the 'help' page of the portlet.
     * @see JSFUseCase#getPortletHelpPath()
     */
    public String getPortletHelpPath()
    {
        return this.getSuperJSFUseCase().getPortletHelpPath();
    }

    /**
     * The forward name for the portlet 'view' page.
     * @see JSFUseCase#getPortletViewForwardName()
     */
    public String getPortletViewForwardName()
    {
        return this.getSuperJSFUseCase().getPortletViewForwardName();
    }

    /**
     * The path to the portlet 'view' page.
     * @see JSFUseCase#getPortletViewPath()
     */
    public String getPortletViewPath()
    {
        return this.getSuperJSFUseCase().getPortletViewPath();
    }

    /**
     * Any portlet preferences associated to this use case.
     * @see JSFUseCase#getPreferences()
     */
    public JSFPortletPreferences getPreferences()
    {
        return this.getSuperJSFUseCase().getPreferences();
    }

    /**
     * All use cases that are labled as registration use cases.
     * @see JSFUseCase#getRegistrationUseCases()
     */
    public List<JSFUseCase> getRegistrationUseCases()
    {
        return this.getSuperJSFUseCase().getRegistrationUseCases();
    }

    /**
     * The title message key for this use-case.
     * @see JSFUseCase#getTitleKey()
     */
    public String getTitleKey()
    {
        return this.getSuperJSFUseCase().getTitleKey();
    }

    /**
     * The title message value for this use-case.
     * @see JSFUseCase#getTitleValue()
     */
    public String getTitleValue()
    {
        return this.getSuperJSFUseCase().getTitleValue();
    }

    /**
     * Indicates that at least one client/server parameter found in the collection of existing
     * use-cases requires validation.
     * @see JSFUseCase#isApplicationValidationRequired()
     */
    public boolean isApplicationValidationRequired()
    {
        return this.getSuperJSFUseCase().isApplicationValidationRequired();
    }

    /**
     * Indicates whether or not the initial target of this use case is a view or not.
     * @see JSFUseCase#isInitialTargetView()
     */
    public boolean isInitialTargetView()
    {
        return this.getSuperJSFUseCase().isInitialTargetView();
    }

    /**
     * Indicates whether or not this is a front-end registration use case.  Only one use case can be
     * labeled as a 'registration' use case.
     * @see JSFUseCase#isRegistrationUseCase()
     */
    public boolean isRegistrationUseCase()
    {
        return this.getSuperJSFUseCase().isRegistrationUseCase();
    }

    /**
     * Indicates whether or not at least one parameter in this use-case require validation.
     * @see JSFUseCase#isValidationRequired()
     */
    public boolean isValidationRequired()
    {
        return this.getSuperJSFUseCase().isValidationRequired();
    }

    /**
     * Indicates whether or not at least one view in the use case has the same name as this use
     * case.
     * @see JSFUseCase#isViewHasNameOfUseCase()
     */
    public boolean isViewHasNameOfUseCase()
    {
        return this.getSuperJSFUseCase().isViewHasNameOfUseCase();
    }

    /**
     * Return the attribute which name matches the parameter
     * @see ClassifierFacade#findAttribute(String name)
     */
    public AttributeFacade findAttribute(String name)
    {
        return this.getSuperJSFUseCase().findAttribute(name);
    }

    /**
     * Those abstraction dependencies for which this classifier is the client.
     * @see ClassifierFacade#getAbstractions()
     */
    public Collection<ClassifierFacade> getAbstractions()
    {
        return this.getSuperJSFUseCase().getAbstractions();
    }

    /**
     * Lists all classes associated to this one and any ancestor classes (through generalization).
     * There will be no duplicates. The order of the elements is predictable.
     * @see ClassifierFacade#getAllAssociatedClasses()
     */
    public Collection<ClassifierFacade> getAllAssociatedClasses()
    {
        return this.getSuperJSFUseCase().getAllAssociatedClasses();
    }

    /**
     * A collection containing all 'properties' of the classifier and its ancestors.  Properties are
     * any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getAllProperties()
     */
    public Collection getAllProperties()
    {
        return this.getSuperJSFUseCase().getAllProperties();
    }

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier and its
     * ancestors. Properties are any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getAllRequiredConstructorParameters()
     */
    public Collection getAllRequiredConstructorParameters()
    {
        return this.getSuperJSFUseCase().getAllRequiredConstructorParameters();
    }

    /**
     * Gets the array type for this classifier.  If this classifier already represents an array, it
     * just returns itself.
     * @see ClassifierFacade#getArray()
     */
    public ClassifierFacade getArray()
    {
        return this.getSuperJSFUseCase().getArray();
    }

    /**
     * The name of the classifier as an array.
     * @see ClassifierFacade#getArrayName()
     */
    public String getArrayName()
    {
        return this.getSuperJSFUseCase().getArrayName();
    }

    /**
     * Lists the classes associated to this one, there is no repitition of classes. The order of the
     * elements is predictable.
     * @see ClassifierFacade#getAssociatedClasses()
     */
    public Collection<ClassifierFacade> getAssociatedClasses()
    {
        return this.getSuperJSFUseCase().getAssociatedClasses();
    }

    /**
     * Gets the association ends belonging to a classifier.
     * @see ClassifierFacade#getAssociationEnds()
     */
    public List<AssociationEndFacade> getAssociationEnds()
    {
        return this.getSuperJSFUseCase().getAssociationEnds();
    }

    /**
     * Gets the attributes that belong to the classifier.
     * @see ClassifierFacade#getAttributes()
     */
    public List<AttributeFacade> getAttributes()
    {
        return this.getSuperJSFUseCase().getAttributes();
    }

    /**
     * Gets all attributes for the classifier and if 'follow' is true goes up the inheritance
     * hierarchy and gets the attributes from the super classes as well.
     * @see ClassifierFacade#getAttributes(boolean follow)
     */
    public List getAttributes(boolean follow)
    {
        return this.getSuperJSFUseCase().getAttributes(follow);
    }

    /**
     * The fully qualified name of the classifier as an array.
     * @see ClassifierFacade#getFullyQualifiedArrayName()
     */
    public String getFullyQualifiedArrayName()
    {
        return this.getSuperJSFUseCase().getFullyQualifiedArrayName();
    }

    /**
     * Returns all those operations that could be implemented at this classifier's level. This means
     * the operations owned by this classifier as well as any realized interface's operations
     * (recursively) in case this classifier itself is not already an interface, or generalized when
     * this classifier is an interface.
     * @see ClassifierFacade#getImplementationOperations()
     */
    public Collection<OperationFacade> getImplementationOperations()
    {
        return this.getSuperJSFUseCase().getImplementationOperations();
    }

    /**
     * A comma separated list of the fully qualified names of all implemented interfaces.
     * @see ClassifierFacade#getImplementedInterfaceList()
     */
    public String getImplementedInterfaceList()
    {
        return this.getSuperJSFUseCase().getImplementedInterfaceList();
    }

    /**
     * Those attributes that are scoped to an instance of this class.
     * @see ClassifierFacade#getInstanceAttributes()
     */
    public Collection<AttributeFacade> getInstanceAttributes()
    {
        return this.getSuperJSFUseCase().getInstanceAttributes();
    }

    /**
     * Those operations that are scoped to an instance of this class.
     * @see ClassifierFacade#getInstanceOperations()
     */
    public List<OperationFacade> getInstanceOperations()
    {
        return this.getSuperJSFUseCase().getInstanceOperations();
    }

    /**
     * Those interfaces that are abstractions of this classifier, this basically means this
     * classifier realizes them.
     * @see ClassifierFacade#getInterfaceAbstractions()
     */
    public Collection<ClassifierFacade> getInterfaceAbstractions()
    {
        return this.getSuperJSFUseCase().getInterfaceAbstractions();
    }

    /**
     * A String representing a new Constructor declaration for this classifier type to be used in a
     * Java environment.
     * @see ClassifierFacade#getJavaNewString()
     */
    public String getJavaNewString()
    {
        return this.getSuperJSFUseCase().getJavaNewString();
    }

    /**
     * A String representing the null-value for this classifier type to be used in a Java
     * environment.
     * @see ClassifierFacade#getJavaNullString()
     */
    public String getJavaNullString()
    {
        return this.getSuperJSFUseCase().getJavaNullString();
    }

    /**
     * The other ends of this classifier's association ends which are navigable.
     * @see ClassifierFacade#getNavigableConnectingEnds()
     */
    public Collection<ClassifierFacade> getNavigableConnectingEnds()
    {
        return this.getSuperJSFUseCase().getNavigableConnectingEnds();
    }

    /**
     * Get the other ends of this classifier's association ends which are navigable and if 'follow'
     * is true goes up the inheritance hierarchy and gets the super association ends as well.
     * @see ClassifierFacade#getNavigableConnectingEnds(boolean follow)
     */
    public List getNavigableConnectingEnds(boolean follow)
    {
        return this.getSuperJSFUseCase().getNavigableConnectingEnds(follow);
    }

    /**
     * Assuming that the classifier is an array, this will return the non array type of the
     * classifier from
     * the model.  If the classifier is NOT an array, it will just return itself.
     * @see ClassifierFacade#getNonArray()
     */
    public ClassifierFacade getNonArray()
    {
        return this.getSuperJSFUseCase().getNonArray();
    }

    /**
     * The attributes from this classifier in the form of an operation call (this example would be
     * in Java): '(String attributeOne, String attributeTwo).  If there were no attributes on the
     * classifier, the result would be an empty '()'.
     * @see ClassifierFacade#getOperationCallFromAttributes()
     */
    public String getOperationCallFromAttributes()
    {
        return this.getSuperJSFUseCase().getOperationCallFromAttributes();
    }

    /**
     * The operations owned by this classifier.
     * @see ClassifierFacade#getOperations()
     */
    public List<OperationFacade> getOperations()
    {
        return this.getSuperJSFUseCase().getOperations();
    }

    /**
     * A collection containing all 'properties' of the classifier.  Properties are any attributes
     * and navigable connecting association ends.
     * @see ClassifierFacade#getProperties()
     */
    public List getProperties()
    {
        return this.getSuperJSFUseCase().getProperties();
    }

    /**
     * Gets all properties (attributes and navigable association ends) for the classifier and if
     * 'follow' is true goes up the inheritance hierarchy and gets the properties from the super
     * classes as well.
     * @see ClassifierFacade#getProperties(boolean follow)
     */
    public List getProperties(boolean follow)
    {
        return this.getSuperJSFUseCase().getProperties(follow);
    }

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier. 
     * Properties are any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getRequiredConstructorParameters()
     */
    public Collection getRequiredConstructorParameters()
    {
        return this.getSuperJSFUseCase().getRequiredConstructorParameters();
    }

    /**
     * Returns the serial version UID of the underlying model element.
     * @see ClassifierFacade#getSerialVersionUID()
     */
    public long getSerialVersionUID()
    {
        return this.getSuperJSFUseCase().getSerialVersionUID();
    }

    /**
     * Those attributes that are scoped to the definition of this class.
     * @see ClassifierFacade#getStaticAttributes()
     */
    public Collection<AttributeFacade> getStaticAttributes()
    {
        return this.getSuperJSFUseCase().getStaticAttributes();
    }

    /**
     * Those operations that are scoped to the definition of this class.
     * @see ClassifierFacade#getStaticOperations()
     */
    public List<OperationFacade> getStaticOperations()
    {
        return this.getSuperJSFUseCase().getStaticOperations();
    }

    /**
     * This class' superclass, returns the generalization if it is a ClassifierFacade, null
     * otherwise.
     * @see ClassifierFacade#getSuperClass()
     */
    public ClassifierFacade getSuperClass()
    {
        return this.getSuperJSFUseCase().getSuperClass();
    }

    /**
     * The wrapper name for this classifier if a mapped type has a defined wrapper class (ie. 'long'
     * maps to 'Long').  If the classifier doesn't have a wrapper defined for it, this method will
     * return a null.  Note that wrapper mappings must be defined for the namespace by defining the
     * 'wrapperMappingsUri', this property must point to the location of the mappings file which
     * maps the primitives to wrapper types.
     * @see ClassifierFacade#getWrapperName()
     */
    public String getWrapperName()
    {
        return this.getSuperJSFUseCase().getWrapperName();
    }

    /**
     * Indicates if this classifier is 'abstract'.
     * @see ClassifierFacade#isAbstract()
     */
    public boolean isAbstract()
    {
        return this.getSuperJSFUseCase().isAbstract();
    }

    /**
     * True if this classifier represents an array type. False otherwise.
     * @see ClassifierFacade#isArrayType()
     */
    public boolean isArrayType()
    {
        return this.getSuperJSFUseCase().isArrayType();
    }

    /**
     * 
     * @see ClassifierFacade#isAssociationClass()
     */
    public boolean isAssociationClass()
    {
        return this.getSuperJSFUseCase().isAssociationClass();
    }

    /**
     * Returns true if this type represents a Blob type.
     * @see ClassifierFacade#isBlobType()
     */
    public boolean isBlobType()
    {
        return this.getSuperJSFUseCase().isBlobType();
    }

    /**
     * Indicates if this type represents a boolean type or not.
     * @see ClassifierFacade#isBooleanType()
     */
    public boolean isBooleanType()
    {
        return this.getSuperJSFUseCase().isBooleanType();
    }

    /**
     * Indicates if this type represents a char, Character, or java.lang.Character type or not.
     * @see ClassifierFacade#isCharacterType()
     */
    public boolean isCharacterType()
    {
        return this.getSuperJSFUseCase().isCharacterType();
    }

    /**
     * Returns true if this type represents a Clob type.
     * @see ClassifierFacade#isClobType()
     */
    public boolean isClobType()
    {
        return this.getSuperJSFUseCase().isClobType();
    }

    /**
     * True if this classifier represents a collection type. False otherwise.
     * @see ClassifierFacade#isCollectionType()
     */
    public boolean isCollectionType()
    {
        return this.getSuperJSFUseCase().isCollectionType();
    }

    /**
     * True/false depending on whether or not this classifier represents a datatype. A data type is
     * a type whose instances are identified only by their value. A data type may contain attributes
     * to support the modeling of structured data types.
     * @see ClassifierFacade#isDataType()
     */
    public boolean isDataType()
    {
        return this.getSuperJSFUseCase().isDataType();
    }

    /**
     * True when this classifier is a date type.
     * @see ClassifierFacade#isDateType()
     */
    public boolean isDateType()
    {
        return this.getSuperJSFUseCase().isDateType();
    }

    /**
     * Indicates if this type represents a Double type or not.
     * @see ClassifierFacade#isDoubleType()
     */
    public boolean isDoubleType()
    {
        return this.getSuperJSFUseCase().isDoubleType();
    }

    /**
     * Indicates whether or not this classifier represents an "EmbeddedValue'.
     * @see ClassifierFacade#isEmbeddedValue()
     */
    public boolean isEmbeddedValue()
    {
        return this.getSuperJSFUseCase().isEmbeddedValue();
    }

    /**
     * True if this classifier is in fact marked as an enumeration.
     * @see ClassifierFacade#isEnumeration()
     */
    public boolean isEnumeration()
    {
        return this.getSuperJSFUseCase().isEnumeration();
    }

    /**
     * Returns true if this type represents a 'file' type.
     * @see ClassifierFacade#isFileType()
     */
    public boolean isFileType()
    {
        return this.getSuperJSFUseCase().isFileType();
    }

    /**
     * Indicates if this type represents a Float type or not.
     * @see ClassifierFacade#isFloatType()
     */
    public boolean isFloatType()
    {
        return this.getSuperJSFUseCase().isFloatType();
    }

    /**
     * Indicates if this type represents an int or Integer or java.lang.Integer type or not.
     * @see ClassifierFacade#isIntegerType()
     */
    public boolean isIntegerType()
    {
        return this.getSuperJSFUseCase().isIntegerType();
    }

    /**
     * True/false depending on whether or not this Classifier represents an interface.
     * @see ClassifierFacade#isInterface()
     */
    public boolean isInterface()
    {
        return this.getSuperJSFUseCase().isInterface();
    }

    /**
     * True if this classifier cannot be extended and represent a leaf in the inheritance tree.
     * @see ClassifierFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperJSFUseCase().isLeaf();
    }

    /**
     * True if this classifier represents a list type. False otherwise.
     * @see ClassifierFacade#isListType()
     */
    public boolean isListType()
    {
        return this.getSuperJSFUseCase().isListType();
    }

    /**
     * Indicates if this type represents a Long type or not.
     * @see ClassifierFacade#isLongType()
     */
    public boolean isLongType()
    {
        return this.getSuperJSFUseCase().isLongType();
    }

    /**
     * Indicates whether or not this classifier represents a Map type.
     * @see ClassifierFacade#isMapType()
     */
    public boolean isMapType()
    {
        return this.getSuperJSFUseCase().isMapType();
    }

    /**
     * Indicates whether or not this classifier represents a primitive type.
     * @see ClassifierFacade#isPrimitive()
     */
    public boolean isPrimitive()
    {
        return this.getSuperJSFUseCase().isPrimitive();
    }

    /**
     * True if this classifier represents a set type. False otherwise.
     * @see ClassifierFacade#isSetType()
     */
    public boolean isSetType()
    {
        return this.getSuperJSFUseCase().isSetType();
    }

    /**
     * Indicates whether or not this classifier represents a string type.
     * @see ClassifierFacade#isStringType()
     */
    public boolean isStringType()
    {
        return this.getSuperJSFUseCase().isStringType();
    }

    /**
     * Indicates whether or not this classifier represents a time type.
     * @see ClassifierFacade#isTimeType()
     */
    public boolean isTimeType()
    {
        return this.getSuperJSFUseCase().isTimeType();
    }

    /**
     * Returns true if this type is a wrapped primitive type.
     * @see ClassifierFacade#isWrappedPrimitive()
     */
    public boolean isWrappedPrimitive()
    {
        return this.getSuperJSFUseCase().isWrappedPrimitive();
    }

    /**
     * The actions for this use-case. This will include the initial action to start the use-case.
     * @see FrontEndUseCase#getActions()
     */
    public List<FrontEndAction> getActions()
    {
        return this.getSuperJSFUseCase().getActions();
    }

    /**
     * Returns the activity graph describing this use-case in more detail.
     * @see FrontEndUseCase#getActivityGraph()
     */
    public FrontEndActivityGraph getActivityGraph()
    {
        return this.getSuperJSFUseCase().getActivityGraph();
    }

    /**
     * All roles that directly or indirectly related to any "front-end" use cases.
     * @see FrontEndUseCase#getAllRoles()
     */
    public List<Role> getAllRoles()
    {
        return this.getSuperJSFUseCase().getAllRoles();
    }

    /**
     * Returns all struts use-cases in this "front end" application.
     * @see FrontEndUseCase#getAllUseCases()
     */
    public List<FrontEndUseCase> getAllUseCases()
    {
        return this.getSuperJSFUseCase().getAllUseCases();
    }

    /**
     * Returns the controller for this use-case.
     * @see FrontEndUseCase#getController()
     */
    public FrontEndController getController()
    {
        return this.getSuperJSFUseCase().getController();
    }

    /**
     * The first view of this use case, this may actually return a view of another use case if the
     * first is found by traveling through the final state.
     * @see FrontEndUseCase#getInitialView()
     */
    public FrontEndView getInitialView()
    {
        return this.getSuperJSFUseCase().getInitialView();
    }

    /**
     * The final states linking to this use case
     * @see FrontEndUseCase#getReferencingFinalStates()
     */
    public List<FrontEndFinalState> getReferencingFinalStates()
    {
        return this.getSuperJSFUseCase().getReferencingFinalStates();
    }

    /**
     * Returns all roles that are directly and indirectly associated to this use-case.
     * @see FrontEndUseCase#getRoles()
     */
    public List<Role> getRoles()
    {
        return this.getSuperJSFUseCase().getRoles();
    }

    /**
     * The variables for all views in this use-case. A parameter qualifies to be a variable when it
     * explicitely and directly receives it via an action.
     * @see FrontEndUseCase#getViewVariables()
     */
    public List<FrontEndParameter> getViewVariables()
    {
        return this.getSuperJSFUseCase().getViewVariables();
    }

    /**
     * All views that are part of this use case.
     * @see FrontEndUseCase#getViews()
     */
    public List<FrontEndView> getViews()
    {
        return this.getSuperJSFUseCase().getViews();
    }

    /**
     * True if this use-case is the entry point to the front end.
     * @see FrontEndUseCase#isEntryUseCase()
     */
    public boolean isEntryUseCase()
    {
        return this.getSuperJSFUseCase().isEntryUseCase();
    }

    /**
     * Indicates if this use case is "secured".  This is true when there is at least one role
     * associated to it.
     * @see FrontEndUseCase#isSecured()
     */
    public boolean isSecured()
    {
        return this.getSuperJSFUseCase().isSecured();
    }

    /**
     * Finds the tagged value optional searching the entire inheritance hierarchy if 'follow' is set
     * to true.
     * @see GeneralizableElementFacade#findTaggedValue(String tagName, boolean follow)
     */
    public Object findTaggedValue(String tagName, boolean follow)
    {
        return this.getSuperJSFUseCase().findTaggedValue(tagName, follow);
    }

    /**
     * All generalizations for this generalizable element, goes up the inheritance tree.
     * @see GeneralizableElementFacade#getAllGeneralizations()
     */
    public Collection<GeneralizableElementFacade> getAllGeneralizations()
    {
        return this.getSuperJSFUseCase().getAllGeneralizations();
    }

    /**
     * All specializations (travels down the inheritance hierarchy).
     * @see GeneralizableElementFacade#getAllSpecializations()
     */
    public Collection<GeneralizableElementFacade> getAllSpecializations()
    {
        return this.getSuperJSFUseCase().getAllSpecializations();
    }

    /**
     * Gets the direct generalization for this generalizable element.
     * @see GeneralizableElementFacade#getGeneralization()
     */
    public GeneralizableElementFacade getGeneralization()
    {
        return this.getSuperJSFUseCase().getGeneralization();
    }

    /**
     * Gets the actual links that this generalization element is part of (it plays either the
     * specialization or generalization).
     * @see GeneralizableElementFacade#getGeneralizationLinks()
     */
    public Collection<GeneralizationFacade> getGeneralizationLinks()
    {
        return this.getSuperJSFUseCase().getGeneralizationLinks();
    }

    /**
     * A comma separated list of the fully qualified names of all generalizations.
     * @see GeneralizableElementFacade#getGeneralizationList()
     */
    public String getGeneralizationList()
    {
        return this.getSuperJSFUseCase().getGeneralizationList();
    }

    /**
     * The element found when you recursively follow the generalization path up to the root. If an
     * element has no generalization itself will be considered the root.
     * @see GeneralizableElementFacade#getGeneralizationRoot()
     */
    public GeneralizableElementFacade getGeneralizationRoot()
    {
        return this.getSuperJSFUseCase().getGeneralizationRoot();
    }

    /**
     * 
     * @see GeneralizableElementFacade#getGeneralizations()
     */
    public Collection<GeneralizableElementFacade> getGeneralizations()
    {
        return this.getSuperJSFUseCase().getGeneralizations();
    }

    /**
     * Gets the direct specializations (i.e. sub elements) for this generalizatble element.
     * @see GeneralizableElementFacade#getSpecializations()
     */
    public Collection<GeneralizableElementFacade> getSpecializations()
    {
        return this.getSuperJSFUseCase().getSpecializations();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperJSFUseCase().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperJSFUseCase().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection findTaggedValues(String tagName)
    {
        return this.getSuperJSFUseCase().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperJSFUseCase().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperJSFUseCase().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection getConstraints(String kind)
    {
        return this.getSuperJSFUseCase().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperJSFUseCase().getDocumentation(indent);
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
        return this.getSuperJSFUseCase().getDocumentation(indent, lineLength);
    }

    /**
     * 
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperJSFUseCase().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperJSFUseCase().getFullyQualifiedName();
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
        return this.getSuperJSFUseCase().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperJSFUseCase().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperJSFUseCase().getId();
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
        return this.getSuperJSFUseCase().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperJSFUseCase().getLabel();
    }

    /**
     * The language mappings that have been set for this model elemnt.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperJSFUseCase().getLanguageMappings();
    }

    /**
     * 
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperJSFUseCase().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperJSFUseCase().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperJSFUseCase().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperJSFUseCase().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperJSFUseCase().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperJSFUseCase().getPackagePath();
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
        return this.getSuperJSFUseCase().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperJSFUseCase().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperJSFUseCase().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperJSFUseCase().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperJSFUseCase().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperJSFUseCase().getStereotypes();
    }

    /**
     * 
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperJSFUseCase().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperJSFUseCase().getTargetDependencies();
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperJSFUseCase().getTemplateParameter(parameterName);
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperJSFUseCase().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperJSFUseCase().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperJSFUseCase().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperJSFUseCase().hasKeyword(keywordName);
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
        return this.getSuperJSFUseCase().hasStereotype(stereotypeName);
    }

    /**
     * 
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperJSFUseCase().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperJSFUseCase().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperJSFUseCase().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperJSFUseCase().isReservedWord();
    }

    /**
     * 
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperJSFUseCase().isTemplateParametersPresent();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperJSFUseCase().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperJSFUseCase().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperJSFUseCase().translateConstraints(kind, translation);
    }

    /**
     * Gets the model elements which this namespace owns.
     * @see org.andromda.metafacades.uml.NamespaceFacade#getOwnedElements()
     */
    public Collection<ModelElementFacade> getOwnedElements()
    {
        return this.getSuperJSFUseCase().getOwnedElements();
    }

    /**
     * The extend instances related to this use-case.
     * @see org.andromda.metafacades.uml.UseCaseFacade#getExtends()
     */
    public Collection<ExtendFacade> getExtends()
    {
        return this.getSuperJSFUseCase().getExtends();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.UseCaseFacade#getExtensionPoints()
     */
    public Collection<ExtensionPointFacade> getExtensionPoints()
    {
        return this.getSuperJSFUseCase().getExtensionPoints();
    }

    /**
     * The first activity graph directly owned by this use-case.
     * @see org.andromda.metafacades.uml.UseCaseFacade#getFirstActivityGraph()
     */
    public ActivityGraphFacade getFirstActivityGraph()
    {
        return this.getSuperJSFUseCase().getFirstActivityGraph();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.UseCaseFacade#getIncludes()
     */
    public Collection<IncludeFacade> getIncludes()
    {
        return this.getSuperJSFUseCase().getIncludes();
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperJSFUseCase().initialize();
    }

    /**
     * @return Object getSuperJSFUseCase().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperJSFUseCase().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperJSFUseCase().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperJSFUseCase().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperJSFUseCase().validateInvariants(validationMessages);
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
// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.database.metafacades;

import java.util.Collection;
import java.util.List;
import org.andromda.core.common.Introspector;
import org.andromda.core.metafacade.MetafacadeBase;
import org.andromda.core.metafacade.MetafacadeFactory;
import org.andromda.core.metafacade.ModelValidationMessage;
import org.andromda.metafacades.uml.AssociationEndFacade;
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.Entity;
import org.andromda.metafacades.uml.EntityAssociationEnd;
import org.andromda.metafacades.uml.EntityQueryOperation;
import org.andromda.metafacades.uml.GeneralizableElementFacade;
import org.andromda.metafacades.uml.GeneralizationFacade;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;
import org.apache.log4j.Logger;

/**
 * TODO: Model Documentation for Table
 * MetafacadeLogic for Table
 *
 * @see Table
 */
public abstract class TableLogic
    extends MetafacadeBase
    implements Table
{

    private static final long serialVersionUID = 1L;
    
    /**
     * The underlying UML object
     * @see Object
     */
    protected transient Object metaObject;

    /** Create Metafacade implementation instance using the MetafacadeFactory from the context
     * @param metaObjectIn
     * @param context
     */
    protected TableLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superEntity =
           (Entity)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.Entity",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = Logger.getLogger(TableLogic.class);

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to Table if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.database.metafacades.Table";
        }
        return context;
    }

    private Entity superEntity;
    private boolean superEntityInitialized = false;

    /**
     * Gets the Entity parent instance.
     * @return this.superEntity Entity
     */
    private Entity getSuperEntity()
    {
        if (!this.superEntityInitialized)
        {
            ((MetafacadeBase)this.superEntity).setMetafacadeContext(this.getMetafacadeContext());
            this.superEntityInitialized = true;
        }
        return this.superEntity;
    }

    /** Reset context only for non-root metafacades
     * @param context
     * @see MetafacadeBase#resetMetafacadeContext(String context)
     */
    @Override
    public void resetMetafacadeContext(String context)
    {
        if (!this.contextRoot) // reset context only for non-root metafacades
        {
            context = getContext(context);  // to have same value as in original constructor call
            setMetafacadeContext (context);
            if (this.superEntityInitialized)
            {
                ((MetafacadeBase)this.superEntity).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see Table
     */
    public boolean isTableMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see Table#getDummyLoadSize()
    * @return int
    */
    protected abstract int handleGetDummyLoadSize();

    private transient int dummyLoadSize1a;
    private transient boolean dummyLoadSize1aSet = false;

    /**
     * The number of rows to insert to create the dummy load for this table.
     * @return (int)handleGetDummyLoadSize()
     */
    public final int getDummyLoadSize()
    {
        int dummyLoadSize1a = this.dummyLoadSize1a;
        if (!this.dummyLoadSize1aSet)
        {
            // dummyLoadSize has no pre constraints
            dummyLoadSize1a = handleGetDummyLoadSize();
            // dummyLoadSize has no post constraints
            this.dummyLoadSize1a = dummyLoadSize1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.dummyLoadSize1aSet = true;
            }
        }
        return dummyLoadSize1a;
    }

   /**
    * @see Table#isForeignKeyColumnsPresent()
    * @return boolean
    */
    protected abstract boolean handleIsForeignKeyColumnsPresent();

    private transient boolean foreignKeyColumnsPresent2a;
    private transient boolean foreignKeyColumnsPresent2aSet = false;

    /**
     * Are there foreign key columns present in this table ?
     * @return (boolean)handleIsForeignKeyColumnsPresent()
     */
    public final boolean isForeignKeyColumnsPresent()
    {
        boolean foreignKeyColumnsPresent2a = this.foreignKeyColumnsPresent2a;
        if (!this.foreignKeyColumnsPresent2aSet)
        {
            // foreignKeyColumnsPresent has no pre constraints
            foreignKeyColumnsPresent2a = handleIsForeignKeyColumnsPresent();
            // foreignKeyColumnsPresent has no post constraints
            this.foreignKeyColumnsPresent2a = foreignKeyColumnsPresent2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.foreignKeyColumnsPresent2aSet = true;
            }
        }
        return foreignKeyColumnsPresent2a;
    }

   /**
    * @see Table#getPrimaryKeyConstraintName()
    * @return String
    */
    protected abstract String handleGetPrimaryKeyConstraintName();

    private transient String primaryKeyConstraintName3a;
    private transient boolean primaryKeyConstraintName3aSet = false;

    /**
     * The name of the primary key constraint for this table.
     * @return (String)handleGetPrimaryKeyConstraintName()
     */
    public final String getPrimaryKeyConstraintName()
    {
        String primaryKeyConstraintName3a = this.primaryKeyConstraintName3a;
        if (!this.primaryKeyConstraintName3aSet)
        {
            // primaryKeyConstraintName has no pre constraints
            primaryKeyConstraintName3a = handleGetPrimaryKeyConstraintName();
            // primaryKeyConstraintName has no post constraints
            this.primaryKeyConstraintName3a = primaryKeyConstraintName3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.primaryKeyConstraintName3aSet = true;
            }
        }
        return primaryKeyConstraintName3a;
    }

    // ------------- associations ------------------

    private transient Collection<Table> getImportingTables1r;
    private transient boolean getImportingTables1rSet = false;

    /**
     * Those tables that are being imported by this table, using foreign-keys.
     * @return (Collection<Table>)handleGetImportingTables()
     */
    public final Collection<Table> getImportingTables()
    {
        Collection<Table> getImportingTables1r = this.getImportingTables1r;
        if (!this.getImportingTables1rSet)
        {
            // importedTables has no pre constraints
            Collection result = handleGetImportingTables();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getImportingTables1r = (Collection<Table>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                TableLogic.LOGGER.warn("incorrect metafacade cast for TableLogic.getImportingTables Collection<Table> " + result + ": " + shieldedResult);
            }
            // importedTables has no post constraints
            this.getImportingTables1r = getImportingTables1r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getImportingTables1rSet = true;
            }
        }
        return getImportingTables1r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetImportingTables();

    private transient Collection<Table> getImportedTables2r;
    private transient boolean getImportedTables2rSet = false;

    /**
     * Those tables that are importing this table using foreign-keys.
     * @return (Collection<Table>)handleGetImportedTables()
     */
    public final Collection<Table> getImportedTables()
    {
        Collection<Table> getImportedTables2r = this.getImportedTables2r;
        if (!this.getImportedTables2rSet)
        {
            // importingTables has no pre constraints
            Collection result = handleGetImportedTables();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getImportedTables2r = (Collection<Table>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                TableLogic.LOGGER.warn("incorrect metafacade cast for TableLogic.getImportedTables Collection<Table> " + result + ": " + shieldedResult);
            }
            // importingTables has no post constraints
            this.getImportedTables2r = getImportedTables2r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getImportedTables2rSet = true;
            }
        }
        return getImportedTables2r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetImportedTables();

    private transient Collection<Column> getIdentifierForeignKeyColumns3r;
    private transient boolean getIdentifierForeignKeyColumns3rSet = false;

    /**
     * The table imported when this column plays a primary key that's a foreign key.
     * @return (Collection<Column>)handleGetIdentifierForeignKeyColumns()
     */
    public final Collection<Column> getIdentifierForeignKeyColumns()
    {
        Collection<Column> getIdentifierForeignKeyColumns3r = this.getIdentifierForeignKeyColumns3r;
        if (!this.getIdentifierForeignKeyColumns3rSet)
        {
            // importedTable has no pre constraints
            Collection result = handleGetIdentifierForeignKeyColumns();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getIdentifierForeignKeyColumns3r = (Collection<Column>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                TableLogic.LOGGER.warn("incorrect metafacade cast for TableLogic.getIdentifierForeignKeyColumns Collection<Column> " + result + ": " + shieldedResult);
            }
            // importedTable has no post constraints
            this.getIdentifierForeignKeyColumns3r = getIdentifierForeignKeyColumns3r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getIdentifierForeignKeyColumns3rSet = true;
            }
        }
        return getIdentifierForeignKeyColumns3r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetIdentifierForeignKeyColumns();

    private transient Collection<Column> getColumns4r;
    private transient boolean getColumns4rSet = false;

    /**
     * TODO: Model Documentation for Table
     * @return (Collection<Column>)handleGetColumns()
     */
    public final Collection<Column> getColumns()
    {
        Collection<Column> getColumns4r = this.getColumns4r;
        if (!this.getColumns4rSet)
        {
            // table has no pre constraints
            Collection result = handleGetColumns();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getColumns4r = (Collection<Column>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                TableLogic.LOGGER.warn("incorrect metafacade cast for TableLogic.getColumns Collection<Column> " + result + ": " + shieldedResult);
            }
            // table has no post constraints
            this.getColumns4r = getColumns4r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getColumns4rSet = true;
            }
        }
        return getColumns4r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetColumns();

    private transient Column getPrimaryKeyColumn5r;
    private transient boolean getPrimaryKeyColumn5rSet = false;

    /**
     * TODO: Model Documentation for Table
     * @return (Column)handleGetPrimaryKeyColumn()
     */
    public final Column getPrimaryKeyColumn()
    {
        Column getPrimaryKeyColumn5r = this.getPrimaryKeyColumn5r;
        if (!this.getPrimaryKeyColumn5rSet)
        {
            // table has no pre constraints
            Object result = handleGetPrimaryKeyColumn();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getPrimaryKeyColumn5r = (Column) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                TableLogic.LOGGER.warn("incorrect metafacade cast for TableLogic.getPrimaryKeyColumn Column " + result + ": " + shieldedResult);
            }
            // table has no post constraints
            this.getPrimaryKeyColumn5r = getPrimaryKeyColumn5r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getPrimaryKeyColumn5rSet = true;
            }
        }
        return getPrimaryKeyColumn5r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetPrimaryKeyColumn();

    private transient Collection<Column> getNonForeignKeyColumns6r;
    private transient boolean getNonForeignKeyColumns6rSet = false;

    /**
     * The set of tables that are importing this primary key column using foreign-keys.
     * @return (Collection<Column>)handleGetNonForeignKeyColumns()
     */
    public final Collection<Column> getNonForeignKeyColumns()
    {
        Collection<Column> getNonForeignKeyColumns6r = this.getNonForeignKeyColumns6r;
        if (!this.getNonForeignKeyColumns6rSet)
        {
            // importingTables has no pre constraints
            Collection result = handleGetNonForeignKeyColumns();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getNonForeignKeyColumns6r = (Collection<Column>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                TableLogic.LOGGER.warn("incorrect metafacade cast for TableLogic.getNonForeignKeyColumns Collection<Column> " + result + ": " + shieldedResult);
            }
            // importingTables has no post constraints
            this.getNonForeignKeyColumns6r = getNonForeignKeyColumns6r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getNonForeignKeyColumns6rSet = true;
            }
        }
        return getNonForeignKeyColumns6r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetNonForeignKeyColumns();

    private transient Collection<ForeignKeyColumn> getForeignKeyColumns8r;
    private transient boolean getForeignKeyColumns8rSet = false;

    /**
     * This foreign-key column's table.
     * @return (Collection<ForeignKeyColumn>)handleGetForeignKeyColumns()
     */
    public final Collection<ForeignKeyColumn> getForeignKeyColumns()
    {
        Collection<ForeignKeyColumn> getForeignKeyColumns8r = this.getForeignKeyColumns8r;
        if (!this.getForeignKeyColumns8rSet)
        {
            // table has no pre constraints
            Collection result = handleGetForeignKeyColumns();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getForeignKeyColumns8r = (Collection<ForeignKeyColumn>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                TableLogic.LOGGER.warn("incorrect metafacade cast for TableLogic.getForeignKeyColumns Collection<ForeignKeyColumn> " + result + ": " + shieldedResult);
            }
            // table has no post constraints
            this.getForeignKeyColumns8r = getForeignKeyColumns8r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getForeignKeyColumns8rSet = true;
            }
        }
        return getForeignKeyColumns8r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetForeignKeyColumns();

    /**
     * @return true
     * @see Entity
     */
    public boolean isEntityMetaType()
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

    // ----------- delegates to Entity ------------
    /**
     * Return the attribute which name matches the parameter
     * @see ClassifierFacade#findAttribute(String name)
     */
    public AttributeFacade findAttribute(String name)
    {
        return this.getSuperEntity().findAttribute(name);
    }

    /**
     * Those abstraction dependencies for which this classifier is the client.
     * @see ClassifierFacade#getAbstractions()
     */
    public Collection<ClassifierFacade> getAbstractions()
    {
        return this.getSuperEntity().getAbstractions();
    }

    /**
     * Lists all classes associated to this one and any ancestor classes (through generalization).
     * There will be no duplicates. The order of the elements is predictable.
     * @see ClassifierFacade#getAllAssociatedClasses()
     */
    public Collection<ClassifierFacade> getAllAssociatedClasses()
    {
        return this.getSuperEntity().getAllAssociatedClasses();
    }

    /**
     * A collection containing all 'properties' of the classifier and its ancestors.  Properties are
     * any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getAllProperties()
     */
    public Collection<ModelElementFacade> getAllProperties()
    {
        return this.getSuperEntity().getAllProperties();
    }

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier and its
     * ancestors. Properties are any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getAllRequiredConstructorParameters()
     */
    public Collection<ModelElementFacade> getAllRequiredConstructorParameters()
    {
        return this.getSuperEntity().getAllRequiredConstructorParameters();
    }

    /**
     * Gets the array type for this classifier.  If this classifier already represents an array, it
     * just returns itself.
     * @see ClassifierFacade#getArray()
     */
    public ClassifierFacade getArray()
    {
        return this.getSuperEntity().getArray();
    }

    /**
     * The name of the classifier as an array.
     * @see ClassifierFacade#getArrayName()
     */
    public String getArrayName()
    {
        return this.getSuperEntity().getArrayName();
    }

    /**
     * Lists the classes associated to this one, there is no repitition of classes. The order of the
     * elements is predictable.
     * @see ClassifierFacade#getAssociatedClasses()
     */
    public Collection<ClassifierFacade> getAssociatedClasses()
    {
        return this.getSuperEntity().getAssociatedClasses();
    }

    /**
     * Gets the association ends belonging to a classifier.
     * @see ClassifierFacade#getAssociationEnds()
     */
    public List<AssociationEndFacade> getAssociationEnds()
    {
        return this.getSuperEntity().getAssociationEnds();
    }

    /**
     * Gets the attributes that belong to the classifier.
     * @see ClassifierFacade#getAttributes()
     */
    public List<AttributeFacade> getAttributes()
    {
        return this.getSuperEntity().getAttributes();
    }

    /**
     * Gets all attributes for the classifier and if 'follow' is true goes up the inheritance
     * hierarchy and gets the attributes from the super classes as well.
     * @see ClassifierFacade#getAttributes(boolean follow)
     */
    public List<AttributeFacade> getAttributes(boolean follow)
    {
        return this.getSuperEntity().getAttributes(follow);
    }

    /**
     * The fully qualified name of the classifier as an array.
     * @see ClassifierFacade#getFullyQualifiedArrayName()
     */
    public String getFullyQualifiedArrayName()
    {
        return this.getSuperEntity().getFullyQualifiedArrayName();
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
        return this.getSuperEntity().getImplementationOperations();
    }

    /**
     * A comma separated list of the fully qualified names of all implemented interfaces.
     * @see ClassifierFacade#getImplementedInterfaceList()
     */
    public String getImplementedInterfaceList()
    {
        return this.getSuperEntity().getImplementedInterfaceList();
    }

    /**
     * Those attributes that are scoped to an instance of this class.
     * @see ClassifierFacade#getInstanceAttributes()
     */
    public Collection<AttributeFacade> getInstanceAttributes()
    {
        return this.getSuperEntity().getInstanceAttributes();
    }

    /**
     * Those operations that are scoped to an instance of this class.
     * @see ClassifierFacade#getInstanceOperations()
     */
    public List<OperationFacade> getInstanceOperations()
    {
        return this.getSuperEntity().getInstanceOperations();
    }

    /**
     * Those interfaces that are abstractions of this classifier, this basically means this
     * classifier realizes them.
     * @see ClassifierFacade#getInterfaceAbstractions()
     */
    public Collection<ClassifierFacade> getInterfaceAbstractions()
    {
        return this.getSuperEntity().getInterfaceAbstractions();
    }

    /**
     * A String representing a new Constructor declaration for this classifier type to be used in a
     * Java environment.
     * @see ClassifierFacade#getJavaNewString()
     */
    public String getJavaNewString()
    {
        return this.getSuperEntity().getJavaNewString();
    }

    /**
     * A String representing the null-value for this classifier type to be used in a Java
     * environment.
     * @see ClassifierFacade#getJavaNullString()
     */
    public String getJavaNullString()
    {
        return this.getSuperEntity().getJavaNullString();
    }

    /**
     * The other ends of this classifier's association ends which are navigable.
     * @see ClassifierFacade#getNavigableConnectingEnds()
     */
    public Collection<AssociationEndFacade> getNavigableConnectingEnds()
    {
        return this.getSuperEntity().getNavigableConnectingEnds();
    }

    /**
     * Get the other ends of this classifier's association ends which are navigable and if 'follow'
     * is true goes up the inheritance hierarchy and gets the super association ends as well.
     * @see ClassifierFacade#getNavigableConnectingEnds(boolean follow)
     */
    public List<AssociationEndFacade> getNavigableConnectingEnds(boolean follow)
    {
        return this.getSuperEntity().getNavigableConnectingEnds(follow);
    }

    /**
     * Assuming that the classifier is an array, this will return the non array type of the
     * classifier from
     * the model.  If the classifier is NOT an array, it will just return itself.
     * @see ClassifierFacade#getNonArray()
     */
    public ClassifierFacade getNonArray()
    {
        return this.getSuperEntity().getNonArray();
    }

    /**
     * The attributes from this classifier in the form of an operation call (this example would be
     * in Java): '(String attributeOne, String attributeTwo).  If there were no attributes on the
     * classifier, the result would be an empty '()'.
     * @see ClassifierFacade#getOperationCallFromAttributes()
     */
    public String getOperationCallFromAttributes()
    {
        return this.getSuperEntity().getOperationCallFromAttributes();
    }

    /**
     * The operations owned by this classifier.
     * @see ClassifierFacade#getOperations()
     */
    public List<OperationFacade> getOperations()
    {
        return this.getSuperEntity().getOperations();
    }

    /**
     * A collection containing all 'properties' of the classifier.  Properties are any attributes
     * and navigable connecting association ends.
     * @see ClassifierFacade#getProperties()
     */
    public List<ModelElementFacade> getProperties()
    {
        return this.getSuperEntity().getProperties();
    }

    /**
     * Gets all properties (attributes and navigable association ends) for the classifier and if
     * 'follow' is true goes up the inheritance hierarchy and gets the properties from the super
     * classes as well.
     * @see ClassifierFacade#getProperties(boolean follow)
     */
    public List getProperties(boolean follow)
    {
        return this.getSuperEntity().getProperties(follow);
    }

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier. 
     * Properties are any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getRequiredConstructorParameters()
     */
    public Collection<ModelElementFacade> getRequiredConstructorParameters()
    {
        return this.getSuperEntity().getRequiredConstructorParameters();
    }

    /**
     * Returns the serial version UID of the underlying model element.
     * @see ClassifierFacade#getSerialVersionUID()
     */
    public long getSerialVersionUID()
    {
        return this.getSuperEntity().getSerialVersionUID();
    }

    /**
     * Those attributes that are scoped to the definition of this class.
     * @see ClassifierFacade#getStaticAttributes()
     */
    public Collection<AttributeFacade> getStaticAttributes()
    {
        return this.getSuperEntity().getStaticAttributes();
    }

    /**
     * Those operations that are scoped to the definition of this class.
     * @see ClassifierFacade#getStaticOperations()
     */
    public List<OperationFacade> getStaticOperations()
    {
        return this.getSuperEntity().getStaticOperations();
    }

    /**
     * This class' superclass, returns the generalization if it is a ClassifierFacade, null
     * otherwise.
     * @see ClassifierFacade#getSuperClass()
     */
    public ClassifierFacade getSuperClass()
    {
        return this.getSuperEntity().getSuperClass();
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
        return this.getSuperEntity().getWrapperName();
    }

    /**
     * Indicates if this classifier is 'abstract'.
     * @see ClassifierFacade#isAbstract()
     */
    public boolean isAbstract()
    {
        return this.getSuperEntity().isAbstract();
    }

    /**
     * True if this classifier represents an array type. False otherwise.
     * @see ClassifierFacade#isArrayType()
     */
    public boolean isArrayType()
    {
        return this.getSuperEntity().isArrayType();
    }

    /**
     * True if the ClassifierFacade is an AssociationClass.
     * @see ClassifierFacade#isAssociationClass()
     */
    public boolean isAssociationClass()
    {
        return this.getSuperEntity().isAssociationClass();
    }

    /**
     * Returns true if this type represents a Blob type.
     * @see ClassifierFacade#isBlobType()
     */
    public boolean isBlobType()
    {
        return this.getSuperEntity().isBlobType();
    }

    /**
     * Indicates if this type represents a boolean type or not.
     * @see ClassifierFacade#isBooleanType()
     */
    public boolean isBooleanType()
    {
        return this.getSuperEntity().isBooleanType();
    }

    /**
     * Indicates if this type represents a char, Character, or java.lang.Character type or not.
     * @see ClassifierFacade#isCharacterType()
     */
    public boolean isCharacterType()
    {
        return this.getSuperEntity().isCharacterType();
    }

    /**
     * Returns true if this type represents a Clob type.
     * @see ClassifierFacade#isClobType()
     */
    public boolean isClobType()
    {
        return this.getSuperEntity().isClobType();
    }

    /**
     * True if this classifier represents a collection type. False otherwise.
     * @see ClassifierFacade#isCollectionType()
     */
    public boolean isCollectionType()
    {
        return this.getSuperEntity().isCollectionType();
    }

    /**
     * True/false depending on whether or not this classifier represents a datatype. A data type is
     * a type whose instances are identified only by their value. A data type may contain attributes
     * to support the modeling of structured data types.
     * @see ClassifierFacade#isDataType()
     */
    public boolean isDataType()
    {
        return this.getSuperEntity().isDataType();
    }

    /**
     * True when this classifier is a date type.
     * @see ClassifierFacade#isDateType()
     */
    public boolean isDateType()
    {
        return this.getSuperEntity().isDateType();
    }

    /**
     * Indicates if this type represents a Double type or not.
     * @see ClassifierFacade#isDoubleType()
     */
    public boolean isDoubleType()
    {
        return this.getSuperEntity().isDoubleType();
    }

    /**
     * Indicates whether or not this classifier represents an "EmbeddedValue'.
     * @see ClassifierFacade#isEmbeddedValue()
     */
    public boolean isEmbeddedValue()
    {
        return this.getSuperEntity().isEmbeddedValue();
    }

    /**
     * True if this classifier is in fact marked as an enumeration.
     * @see ClassifierFacade#isEnumeration()
     */
    public boolean isEnumeration()
    {
        return this.getSuperEntity().isEnumeration();
    }

    /**
     * Returns true if this type represents a 'file' type.
     * @see ClassifierFacade#isFileType()
     */
    public boolean isFileType()
    {
        return this.getSuperEntity().isFileType();
    }

    /**
     * Indicates if this type represents a Float type or not.
     * @see ClassifierFacade#isFloatType()
     */
    public boolean isFloatType()
    {
        return this.getSuperEntity().isFloatType();
    }

    /**
     * Indicates if this type represents an int or Integer or java.lang.Integer type or not.
     * @see ClassifierFacade#isIntegerType()
     */
    public boolean isIntegerType()
    {
        return this.getSuperEntity().isIntegerType();
    }

    /**
     * True/false depending on whether or not this Classifier represents an interface.
     * @see ClassifierFacade#isInterface()
     */
    public boolean isInterface()
    {
        return this.getSuperEntity().isInterface();
    }

    /**
     * True if this classifier cannot be extended and represent a leaf in the inheritance tree.
     * @see ClassifierFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperEntity().isLeaf();
    }

    /**
     * True if this classifier represents a list type. False otherwise.
     * @see ClassifierFacade#isListType()
     */
    public boolean isListType()
    {
        return this.getSuperEntity().isListType();
    }

    /**
     * Indicates if this type represents a Long type or not.
     * @see ClassifierFacade#isLongType()
     */
    public boolean isLongType()
    {
        return this.getSuperEntity().isLongType();
    }

    /**
     * Indicates whether or not this classifier represents a Map type.
     * @see ClassifierFacade#isMapType()
     */
    public boolean isMapType()
    {
        return this.getSuperEntity().isMapType();
    }

    /**
     * Indicates whether or not this classifier represents a primitive type.
     * @see ClassifierFacade#isPrimitive()
     */
    public boolean isPrimitive()
    {
        return this.getSuperEntity().isPrimitive();
    }

    /**
     * True if this classifier represents a set type. False otherwise.
     * @see ClassifierFacade#isSetType()
     */
    public boolean isSetType()
    {
        return this.getSuperEntity().isSetType();
    }

    /**
     * Indicates whether or not this classifier represents a string type.
     * @see ClassifierFacade#isStringType()
     */
    public boolean isStringType()
    {
        return this.getSuperEntity().isStringType();
    }

    /**
     * Indicates whether or not this classifier represents a time type.
     * @see ClassifierFacade#isTimeType()
     */
    public boolean isTimeType()
    {
        return this.getSuperEntity().isTimeType();
    }

    /**
     * Returns true if this type is a wrapped primitive type.
     * @see ClassifierFacade#isWrappedPrimitive()
     */
    public boolean isWrappedPrimitive()
    {
        return this.getSuperEntity().isWrappedPrimitive();
    }

    /**
     * Returns a collection of all entities this entity and its ancestors have a relation to.
     * @see Entity#getAllEntityReferences()
     */
    public Collection<DependencyFacade> getAllEntityReferences()
    {
        return this.getSuperEntity().getAllEntityReferences();
    }

    /**
     * Gets a comma separated list of attribute names.  If 'follow' is true, will travel up the
     * inheritance hiearchy to include attributes in parent entities as well.  If 'withIdentifiers'
     * is true, will include identifiers.
     * @see Entity#getAttributeNameList(boolean follow, boolean withIdentifiers)
     */
    public String getAttributeNameList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getAttributeNameList(follow, withIdentifiers);
    }

    /**
     * Gets a comma separated list of attribute names.  If 'follow' is true, will travel up the
     * inheritance hiearchy to include attributes in parent entities as well.  If 'withIdentifiers'
     * is true, will include identifiers  and  if 'withDerived' is set to true, will include derived
     * attributes.
     * @see Entity#getAttributeNameList(boolean follow, boolean withIdentifiers, boolean withDerived)
     */
    public String getAttributeNameList(boolean follow, boolean withIdentifiers, boolean withDerived)
    {
        return this.getSuperEntity().getAttributeNameList(follow, withIdentifiers, withDerived);
    }

    /**
     * Gets a comma separated list of attribute types.  If 'follow' is true, will travel up the
     * inheritance hierarchy to include attributes in parent entities as well.  If 'withIdentifiers'
     * is true, will include identifiers.
     * @see Entity#getAttributeTypeList(boolean follow, boolean withIdentifiers)
     */
    public String getAttributeTypeList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getAttributeTypeList(follow, withIdentifiers);
    }

    /**
     * Gets all attributes of the entity, and optionally retieves the super entities attributes as
     * well as excludes the entity's identifiers if 'withIdentifiers' is set to false.
     * @see Entity#getAttributes(boolean follow, boolean withIdentifiers)
     */
    public Collection<AttributeFacade> getAttributes(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getAttributes(follow, withIdentifiers);
    }

    /**
     * Gets all attributes of the entity, and optionally retieves the super entities attributes as
     * well as excludes the entity's identifiers if 'withIdentifiers' is set to false and exclude
     * derived attributes if 'withDerived' is set to false.
     * @see Entity#getAttributes(boolean follow, boolean withIdentifiers, boolean withDerived)
     */
    public Collection<AttributeFacade> getAttributes(boolean follow, boolean withIdentifiers, boolean withDerived)
    {
        return this.getSuperEntity().getAttributes(follow, withIdentifiers, withDerived);
    }

    /**
     * All business operations of the entity, these include any operations that aren't queries.
     * @see Entity#getBusinessOperations()
     */
    public Collection<OperationFacade> getBusinessOperations()
    {
        return this.getSuperEntity().getBusinessOperations();
    }

    /**
     * Gets any children association ends (i.e. entity association ends that are participants in an
     * association with this entity and this entity has composite aggregation defined for those
     * associations).
     * @see Entity#getChildEnds()
     */
    public Collection<EntityAssociationEnd> getChildEnds()
    {
        return this.getSuperEntity().getChildEnds();
    }

    /**
     * The embedded values belonging to this entity.
     * @see Entity#getEmbeddedValues()
     */
    public Collection<AttributeFacade> getEmbeddedValues()
    {
        return this.getSuperEntity().getEmbeddedValues();
    }

    /**
     * All entities referenced by this entity.
     * @see Entity#getEntityReferences()
     */
    public Collection<DependencyFacade> getEntityReferences()
    {
        return this.getSuperEntity().getEntityReferences();
    }

    /**
     * The full name of the type of the identifier. If composite identifier add the PK sufix to the
     * class name. If not, retorns the fully qualified name of the identifier.
     * @see Entity#getFullyQualifiedIdentifierTypeName()
     */
    public String getFullyQualifiedIdentifierTypeName()
    {
        return this.getSuperEntity().getFullyQualifiedIdentifierTypeName();
    }

    /**
     * Gets all the associationEnds of this entity marked with the identifiers stereotype.
     * @see Entity#getIdentifierAssociationEnds()
     */
    public Collection<AssociationEndFacade> getIdentifierAssociationEnds()
    {
        return this.getSuperEntity().getIdentifierAssociationEnds();
    }

    /**
     * The getter name of the identifier.
     * @see Entity#getIdentifierGetterName()
     */
    public String getIdentifierGetterName()
    {
        return this.getSuperEntity().getIdentifierGetterName();
    }

    /**
     * The name of the identifier. If composite identifier add the Pk suffix. If not composite
     * returns the attribute name of the identifier.
     * @see Entity#getIdentifierName()
     */
    public String getIdentifierName()
    {
        return this.getSuperEntity().getIdentifierName();
    }

    /**
     * The setter name of the identifier.
     * @see Entity#getIdentifierSetterName()
     */
    public String getIdentifierSetterName()
    {
        return this.getSuperEntity().getIdentifierSetterName();
    }

    /**
     * The name of the type of the identifier. If composite identifier add the PK suffix to the
     * class name. If not, returns the name of the identifier.
     * @see Entity#getIdentifierTypeName()
     */
    public String getIdentifierTypeName()
    {
        return this.getSuperEntity().getIdentifierTypeName();
    }

    /**
     * All the attributes of the entity which make up its identifier (primary key).  Will search any
     * super classes as well.  If no identifiers exist, a default identifier will be created if the
     * allowDefaultIdentifiers property is set to true.
     * @see Entity#getIdentifiers()
     */
    public Collection<ModelElementFacade> getIdentifiers()
    {
        return this.getSuperEntity().getIdentifiers();
    }

    /**
     * Gets all identifiers for an entity. If 'follow' is true, and if no identifiers can be found
     * on the entity, a search up the inheritance chain will be performed, and the identifiers from
     * the first super class having them will be used.   If no identifiers exist, a default
     * identifier will be created if the allowDefaultIdentifiers property is set to true.
     * Identifiers can be on attributes or associations (composite primary key).
     * @see Entity#getIdentifiers(boolean follow)
     */
    public Collection<ModelElementFacade> getIdentifiers(boolean follow)
    {
        return this.getSuperEntity().getIdentifiers(follow);
    }

    /**
     * The maximum length a SQL name may be.
     * @see Entity#getMaxSqlNameLength()
     */
    public short getMaxSqlNameLength()
    {
        return this.getSuperEntity().getMaxSqlNameLength();
    }

    /**
     * Gets the attributes as a list within an operation call, optionally including the type names
     * and the identifier attributes.
     * @see Entity#getOperationCallFromAttributes(boolean withIdentifiers)
     */
    public String getOperationCallFromAttributes(boolean withIdentifiers)
    {
        return this.getSuperEntity().getOperationCallFromAttributes(withIdentifiers);
    }

    /**
     * Gets the attributes as a list within an operation call.  If 'withTypeNames' is true, it will
     * include the type names, if 'withIdentifiers' is true it will include the identifiers.  If
     * 'follow' is true it will follow the inheritance hierarchy and get the attributes of the super
     * class as well.
     * @see Entity#getOperationCallFromAttributes(boolean withIdentifiers, boolean follow)
     */
    public String getOperationCallFromAttributes(boolean withIdentifiers, boolean follow)
    {
        return this.getSuperEntity().getOperationCallFromAttributes(withIdentifiers, follow);
    }

    /**
     * Returns the parent association end of this entity if its a child entity.  The parent is the
     * entity that is the participant the association that has composite aggregation defined.  Will
     * return null if the entity has no parent.
     * @see Entity#getParentEnd()
     */
    public EntityAssociationEnd getParentEnd()
    {
        return this.getSuperEntity().getParentEnd();
    }

    /**
     * Gets all properties of this entity, this includes the attributes and navigable association
     * ends of the entity.  The 'follow' flag indcates whether or not the inheritance hierarchy
     * should be followed when getting all the properties.  The 'withIdentifiers' flag indicates
     * whether or not identifiers should be included in the collection of properties.
     * @see Entity#getProperties(boolean follow, boolean withIdentifiers)
     */
    public Collection<ModelElementFacade> getProperties(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getProperties(follow, withIdentifiers);
    }

    /**
     * Returns all the operations that can perform queries on the entity.
     * @see Entity#getQueryOperations()
     */
    public Collection<EntityQueryOperation> getQueryOperations()
    {
        return this.getSuperEntity().getQueryOperations();
    }

    /**
     * Gets all query operations for an entity. If 'follow' is true, and if no query operations can
     * be found on the entity, a search up the inheritance chain will be performed, and the
     * identifiers from the first super class having them will be used.   If no identifiers exist, a
     * default identifier will be created if the allowDefaultIdentifiers property is set to true.
     * @see Entity#getQueryOperations(boolean follow)
     */
    public Collection<OperationFacade> getQueryOperations(boolean follow)
    {
        return this.getSuperEntity().getQueryOperations(follow);
    }

    /**
     * Gets a comma separated list of required attribute names.  If 'follow' is true, will travel up
     * the inheritance hierarchy to include attributes in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @see Entity#getRequiredAttributeNameList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredAttributeNameList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getRequiredAttributeNameList(follow, withIdentifiers);
    }

    /**
     * Gets a comma separated list of attribute types with are required.  If 'follow' is true, will
     * travel up the inheritance hierarchy to include attributes in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @see Entity#getRequiredAttributeTypeList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredAttributeTypeList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getRequiredAttributeTypeList(follow, withIdentifiers);
    }

    /**
     * Returns all attributes that are specified as 'required' in the model.  If 'follow' is true,
     * then required attributes in super classes will also be returned, if false, just the ones
     * directly on the entity will be returned.  If 'withIdentifiers' is true, the identifiers will
     * be include, if false, no identifiers will be included.
     * @see Entity#getRequiredAttributes(boolean follow, boolean withIdentifiers)
     */
    public Collection<AttributeFacade> getRequiredAttributes(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getRequiredAttributes(follow, withIdentifiers);
    }

    /**
     * Gets all required properties for this entity.  These consist of any required attributes as
     * well as navigable associations that are marked as 'required'.  If 'follow' is true, then the
     * inheritance hierchy will be followed and all required properties from super classes will be
     * included as well.
     * If 'withIdentifiers' is true, the identifiers will be include, if false, no identifiers will
     * be included.
     * @see Entity#getRequiredProperties(boolean follow, boolean withIdentifiers)
     */
    public Collection<ModelElementFacade> getRequiredProperties(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getRequiredProperties(follow, withIdentifiers);
    }

    /**
     * Creates a comma separated list of the required property names.
     * @see Entity#getRequiredPropertyNameList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredPropertyNameList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getRequiredPropertyNameList(follow, withIdentifiers);
    }

    /**
     * A comma separated list of the required property types.
     * @see Entity#getRequiredPropertyTypeList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredPropertyTypeList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getRequiredPropertyTypeList(follow, withIdentifiers);
    }

    /**
     * The name of the schema that contains the database table
     * @see Entity#getSchema()
     */
    public String getSchema()
    {
        return this.getSuperEntity().getSchema();
    }

    /**
     * The name of the database table to which this entity is persisted.
     * @see Entity#getTableName()
     */
    public String getTableName()
    {
        return this.getSuperEntity().getTableName();
    }

    /**
     * Returns true/false depending on whether or not this entity represetns a child in an
     * association (this occurs when this entity is on the opposite end of an assocation end defined
     * as composite).
     * @see Entity#isChild()
     */
    public boolean isChild()
    {
        return this.getSuperEntity().isChild();
    }

    /**
     * TODO: Model Documentation for Entity.compositeIdentifier
     * @see Entity#isCompositeIdentifier()
     */
    public boolean isCompositeIdentifier()
    {
        return this.getSuperEntity().isCompositeIdentifier();
    }

    /**
     * True if the entity has its identifiers dynamically added, false otherwise.
     * @see Entity#isDynamicIdentifiersPresent()
     */
    public boolean isDynamicIdentifiersPresent()
    {
        return this.getSuperEntity().isDynamicIdentifiersPresent();
    }

    /**
     * True if the entity has any identifiers defined, false otherwise.
     * @see Entity#isIdentifiersPresent()
     */
    public boolean isIdentifiersPresent()
    {
        return this.getSuperEntity().isIdentifiersPresent();
    }

    /**
     * Indiciates if this entity is using an assigned identifier or not.
     * @see Entity#isUsingAssignedIdentifier()
     */
    public boolean isUsingAssignedIdentifier()
    {
        return this.getSuperEntity().isUsingAssignedIdentifier();
    }

    /**
     * Indicates whether or not this entity is using a foreign identifier as its identifiers.  That
     * is: the foreignIdentifier flag was set on an incoming association end and the entity is
     * therefore using the related foreign parent entity's identifier.
     * @see Entity#isUsingForeignIdentifier()
     */
    public boolean isUsingForeignIdentifier()
    {
        return this.getSuperEntity().isUsingForeignIdentifier();
    }

    /**
     * Finds the tagged value optional searching the entire inheritance hierarchy if 'follow' is set
     * to true.
     * @see GeneralizableElementFacade#findTaggedValue(String tagName, boolean follow)
     */
    public Object findTaggedValue(String tagName, boolean follow)
    {
        return this.getSuperEntity().findTaggedValue(tagName, follow);
    }

    /**
     * All generalizations for this generalizable element, goes up the inheritance tree.
     * @see GeneralizableElementFacade#getAllGeneralizations()
     */
    public Collection<GeneralizableElementFacade> getAllGeneralizations()
    {
        return this.getSuperEntity().getAllGeneralizations();
    }

    /**
     * All specializations (travels down the inheritance hierarchy).
     * @see GeneralizableElementFacade#getAllSpecializations()
     */
    public Collection<GeneralizableElementFacade> getAllSpecializations()
    {
        return this.getSuperEntity().getAllSpecializations();
    }

    /**
     * Gets the direct generalization for this generalizable element.
     * @see GeneralizableElementFacade#getGeneralization()
     */
    public GeneralizableElementFacade getGeneralization()
    {
        return this.getSuperEntity().getGeneralization();
    }

    /**
     * Gets the actual links that this generalization element is part of (it plays either the
     * specialization or generalization).
     * @see GeneralizableElementFacade#getGeneralizationLinks()
     */
    public Collection<GeneralizationFacade> getGeneralizationLinks()
    {
        return this.getSuperEntity().getGeneralizationLinks();
    }

    /**
     * A comma separated list of the fully qualified names of all generalizations.
     * @see GeneralizableElementFacade#getGeneralizationList()
     */
    public String getGeneralizationList()
    {
        return this.getSuperEntity().getGeneralizationList();
    }

    /**
     * The element found when you recursively follow the generalization path up to the root. If an
     * element has no generalization itself will be considered the root.
     * @see GeneralizableElementFacade#getGeneralizationRoot()
     */
    public GeneralizableElementFacade getGeneralizationRoot()
    {
        return this.getSuperEntity().getGeneralizationRoot();
    }

    /**
     * The model element that represents an element that can be generalized or specialized.
     * @see GeneralizableElementFacade#getGeneralizations()
     */
    public Collection<GeneralizableElementFacade> getGeneralizations()
    {
        return this.getSuperEntity().getGeneralizations();
    }

    /**
     * Gets the direct specializations (i.e. sub elements) for this generalizatble element.
     * @see GeneralizableElementFacade#getSpecializations()
     */
    public Collection<GeneralizableElementFacade> getSpecializations()
    {
        return this.getSuperEntity().getSpecializations();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperEntity().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperEntity().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperEntity().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperEntity().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperEntity().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperEntity().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperEntity().getDocumentation(indent);
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
        return this.getSuperEntity().getDocumentation(indent, lineLength);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. HTML style determines if HTML Escaping is applied.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperEntity().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperEntity().getFullyQualifiedName();
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
        return this.getSuperEntity().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperEntity().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperEntity().getId();
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
        return this.getSuperEntity().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperEntity().getLabel();
    }

    /**
     * The language mappings that have been set for this model element.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperEntity().getLanguageMappings();
    }

    /**
     * Return the model containing this model element (multiple models may be loaded and processed
     * at the same time).
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperEntity().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperEntity().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperEntity().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperEntity().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperEntity().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperEntity().getPackagePath();
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
        return this.getSuperEntity().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperEntity().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperEntity().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperEntity().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperEntity().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperEntity().getStereotypes();
    }

    /**
     * Return the TaggedValues associated with this model element, under all stereotypes.
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperEntity().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperEntity().getTargetDependencies();
    }

    /**
     * Get the template parameters for this model element.
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperEntity().getTemplateParameter(parameterName);
    }

    /**
     * Get the template parameter for this model element having the parameterName.
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperEntity().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperEntity().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperEntity().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperEntity().hasKeyword(keywordName);
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
        return this.getSuperEntity().hasStereotype(stereotypeName);
    }

    /**
     * True if there are target dependencies from this element that are instances of BindingFacade.
     * Deprecated in UML2: Use TemplateBinding parameters instead of dependencies.
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperEntity().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperEntity().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperEntity().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperEntity().isReservedWord();
    }

    /**
     * True is there are template parameters on this model element. For UML2, applies to Class,
     * Operation, Property, and Parameter.
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperEntity().isTemplateParametersPresent();
    }

    /**
     * True if this element name is a valid identifier name in Java, C#, ANSI or ISO C, C++,
     * JavaScript. Contains no spaces, special characters etc. Constraint always applied on
     * Enumerations and Interfaces, optionally applies on other model elements.
     * @see ModelElementFacade#isValidIdentifierName()
     */
    public boolean isValidIdentifierName()
    {
        return this.getSuperEntity().isValidIdentifierName();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperEntity().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperEntity().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperEntity().translateConstraints(kind, translation);
    }

    /**
     * @see MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperEntity().initialize();
    }

    /**
     * @return Object getSuperEntity().getValidationOwner()
     * @see MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperEntity().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperEntity().getValidationName()
     * @see MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperEntity().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperEntity().validateInvariants(validationMessages);
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
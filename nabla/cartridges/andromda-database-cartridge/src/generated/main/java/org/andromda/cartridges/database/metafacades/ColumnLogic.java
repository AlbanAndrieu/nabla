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
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.EntityAttribute;
import org.andromda.metafacades.uml.EnumerationFacade;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;
import org.apache.log4j.Logger;

/**
 * This column is used for all types of columns possible in a database table, such qs primary key
 * columns and data columns.  Most of the time this column doesn't represent a foreign key column
 * (except in the case where the foreignIdentifier flag is set on the own entity in which case the
 * primary key can play the foreign key as well).
 * MetafacadeLogic for Column
 *
 * @see Column
 */
public abstract class ColumnLogic
    extends MetafacadeBase
    implements Column
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
    protected ColumnLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superEntityAttribute =
           (EntityAttribute)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.EntityAttribute",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = Logger.getLogger(ColumnLogic.class);

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to Column if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.database.metafacades.Column";
        }
        return context;
    }

    private EntityAttribute superEntityAttribute;
    private boolean superEntityAttributeInitialized = false;

    /**
     * Gets the EntityAttribute parent instance.
     * @return this.superEntityAttribute EntityAttribute
     */
    private EntityAttribute getSuperEntityAttribute()
    {
        if (!this.superEntityAttributeInitialized)
        {
            ((MetafacadeBase)this.superEntityAttribute).setMetafacadeContext(this.getMetafacadeContext());
            this.superEntityAttributeInitialized = true;
        }
        return this.superEntityAttribute;
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
            if (this.superEntityAttributeInitialized)
            {
                ((MetafacadeBase)this.superEntityAttribute).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see Column
     */
    public boolean isColumnMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.database.metafacades.Column#isPrimaryKey()
    * @return boolean
    */
    protected abstract boolean handleIsPrimaryKey();

    private transient boolean primaryKey1a;
    private transient boolean primaryKey1aSet = false;

    /**
     * Denotes whether or not this column represents the primary key for its table.
     * @return (boolean)handleIsPrimaryKey()
     */
    public final boolean isPrimaryKey()
    {
        boolean primaryKey1a = this.primaryKey1a;
        if (!this.primaryKey1aSet)
        {
            // primaryKey has no pre constraints
            primaryKey1a = handleIsPrimaryKey();
            // primaryKey has no post constraints
            this.primaryKey1a = primaryKey1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.primaryKey1aSet = true;
            }
        }
        return primaryKey1a;
    }

   /**
    * @see org.andromda.cartridges.database.metafacades.Column#getTableName()
    * @return String
    */
    protected abstract String handleGetTableName();

    private transient String tableName2a;
    private transient boolean tableName2aSet = false;

    /**
     * The name of the table that owns this column.  The only time this is used is when the primary
     * key acts as a foreign key.
     * @return (String)handleGetTableName()
     */
    public final String getTableName()
    {
        String tableName2a = this.tableName2a;
        if (!this.tableName2aSet)
        {
            // tableName has no pre constraints
            tableName2a = handleGetTableName();
            // tableName has no post constraints
            this.tableName2a = tableName2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableName2aSet = true;
            }
        }
        return tableName2a;
    }

   /**
    * @see org.andromda.cartridges.database.metafacades.Column#getConstraintName()
    * @return String
    */
    protected abstract String handleGetConstraintName();

    private transient String constraintName3a;
    private transient boolean constraintName3aSet = false;

    /**
     * The name of the constraint when this column plays a foreign key (when the primary key plays a
     * foreign key).
     * @return (String)handleGetConstraintName()
     */
    public final String getConstraintName()
    {
        String constraintName3a = this.constraintName3a;
        if (!this.constraintName3aSet)
        {
            // constraintName has no pre constraints
            constraintName3a = handleGetConstraintName();
            // constraintName has no post constraints
            this.constraintName3a = constraintName3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.constraintName3aSet = true;
            }
        }
        return constraintName3a;
    }

   /**
    * @see org.andromda.cartridges.database.metafacades.Column#isCascadeDelete()
    * @return boolean
    */
    protected abstract boolean handleIsCascadeDelete();

    private transient boolean cascadeDelete4a;
    private transient boolean cascadeDelete4aSet = false;

    /**
     * Denotes whether or not a row of this column's table needs to be deleted if the entity to
     * which the foreign identifier key is related is deleted.
     * @return (boolean)handleIsCascadeDelete()
     */
    public final boolean isCascadeDelete()
    {
        boolean cascadeDelete4a = this.cascadeDelete4a;
        if (!this.cascadeDelete4aSet)
        {
            // cascadeDelete has no pre constraints
            cascadeDelete4a = handleIsCascadeDelete();
            // cascadeDelete has no post constraints
            this.cascadeDelete4a = cascadeDelete4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.cascadeDelete4aSet = true;
            }
        }
        return cascadeDelete4a;
    }

    // ---------------- business methods ----------------------

    /**
     * Method to be implemented in descendants
     * Return the dummy load value for the specified index.
     * @param index
     * @return String
     */
    protected abstract String handleGetDummyLoadValue(int index);

    /**
     * Return the dummy load value for the specified index.
     * @param index int
     * TODO: Model Documentation for
     * org.andromda.cartridges.database.metafacades.Column.getDummyLoadValue(index)
     * @return handleGetDummyLoadValue(index)
     */
    public String getDummyLoadValue(int index)
    {
        // getDummyLoadValue has no pre constraints
        String returnValue = handleGetDummyLoadValue(index);
        // getDummyLoadValue has no post constraints
        return returnValue;
    }

    // ------------- associations ------------------

    private transient Collection<ForeignKeyColumn> getExportedColumns1r;
    private transient boolean getExportedColumns1rSet = false;

    /**
     * The primary key column that is imported by this foreign key.
     * @return (Collection<ForeignKeyColumn>)handleGetExportedColumns()
     */
    public final Collection<ForeignKeyColumn> getExportedColumns()
    {
        Collection<ForeignKeyColumn> getExportedColumns1r = this.getExportedColumns1r;
        if (!this.getExportedColumns1rSet)
        {
            // importedPrimaryKeyColumn has no pre constraints
            Collection result = handleGetExportedColumns();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getExportedColumns1r = (Collection<ForeignKeyColumn>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                ColumnLogic.LOGGER.warn("incorrect metafacade cast for ColumnLogic.getExportedColumns Collection<ForeignKeyColumn> " + result + ": " + shieldedResult);
            }
            // importedPrimaryKeyColumn has no post constraints
            this.getExportedColumns1r = getExportedColumns1r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getExportedColumns1rSet = true;
            }
        }
        return getExportedColumns1r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetExportedColumns();

    private transient Table getImportedTable2r;
    private transient boolean getImportedTable2rSet = false;

    /**
     * This column is used for all types of columns possible in a database table, such qs primary
     * key
     * columns and data columns.  Most of the time this column doesn't represent a foreign key
     * column
     * (except in the case where the foreignIdentifier flag is set on the own entity in which case
     * the
     * primary key can play the foreign key as well).
     * @return (Table)handleGetImportedTable()
     */
    public final Table getImportedTable()
    {
        Table getImportedTable2r = this.getImportedTable2r;
        if (!this.getImportedTable2rSet)
        {
            // identifierForeignKeyColumns has no pre constraints
            Object result = handleGetImportedTable();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getImportedTable2r = (Table) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                ColumnLogic.LOGGER.warn("incorrect metafacade cast for ColumnLogic.getImportedTable Table " + result + ": " + shieldedResult);
            }
            // identifierForeignKeyColumns has no post constraints
            this.getImportedTable2r = getImportedTable2r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getImportedTable2rSet = true;
            }
        }
        return getImportedTable2r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetImportedTable();

    private transient Table getTable3r;
    private transient boolean getTable3rSet = false;

    /**
     * This column is used for all types of columns possible in a database table, such qs primary
     * key
     * columns and data columns.  Most of the time this column doesn't represent a foreign key
     * column
     * (except in the case where the foreignIdentifier flag is set on the own entity in which case
     * the
     * primary key can play the foreign key as well).
     * @return (Table)handleGetTable()
     */
    public final Table getTable()
    {
        Table getTable3r = this.getTable3r;
        if (!this.getTable3rSet)
        {
            // column has no pre constraints
            Object result = handleGetTable();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getTable3r = (Table) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                ColumnLogic.LOGGER.warn("incorrect metafacade cast for ColumnLogic.getTable Table " + result + ": " + shieldedResult);
            }
            // column has no post constraints
            this.getTable3r = getTable3r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getTable3rSet = true;
            }
        }
        return getTable3r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetTable();

    private transient Collection<Table> getImportingTables4r;
    private transient boolean getImportingTables4rSet = false;

    /**
     * The columns that are part of this table and are not a primary-key column nor a foreign-key
     * column.
     * @return (Collection<Table>)handleGetImportingTables()
     */
    public final Collection<Table> getImportingTables()
    {
        Collection<Table> getImportingTables4r = this.getImportingTables4r;
        if (!this.getImportingTables4rSet)
        {
            // nonForeignKeyColumns has no pre constraints
            Collection result = handleGetImportingTables();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getImportingTables4r = (Collection<Table>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                ColumnLogic.LOGGER.warn("incorrect metafacade cast for ColumnLogic.getImportingTables Collection<Table> " + result + ": " + shieldedResult);
            }
            // nonForeignKeyColumns has no post constraints
            this.getImportingTables4r = getImportingTables4r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getImportingTables4rSet = true;
            }
        }
        return getImportingTables4r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetImportingTables();

    /**
     * @return true
     * @see EntityAttribute
     */
    public boolean isEntityAttributeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.AttributeFacade
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

    // ----------- delegates to EntityAttribute ------------
    /**
     * Searches the given feature for the specified tag.
     * If the follow boolean is set to true then the search will continue from the class attribute
     * to the class itself and then up the class hierarchy.
     * @see org.andromda.metafacades.uml.AttributeFacade#findTaggedValue(String name, boolean follow)
     */
    public Object findTaggedValue(String name, boolean follow)
    {
        return this.getSuperEntityAttribute().findTaggedValue(name, follow);
    }

    /**
     * The default value of the attribute.  This is the value given if no value is defined.
     * @see org.andromda.metafacades.uml.AttributeFacade#getDefaultValue()
     */
    public String getDefaultValue()
    {
        return this.getSuperEntityAttribute().getDefaultValue();
    }

    /**
     * If the attribute is an enumeration literal this represents the owning enumeration. Can be
     * empty.
     * @see org.andromda.metafacades.uml.AttributeFacade#getEnumeration()
     */
    public EnumerationFacade getEnumeration()
    {
        return this.getSuperEntityAttribute().getEnumeration();
    }

    /**
     * Returns the enumeration literal parameters defined by tagged value as a comma separated list.
     * @see org.andromda.metafacades.uml.AttributeFacade#getEnumerationLiteralParameters()
     */
    public String getEnumerationLiteralParameters()
    {
        return this.getSuperEntityAttribute().getEnumerationLiteralParameters();
    }

    /**
     * The value for this attribute if it is an enumeration literal, null otherwise. The default
     * value is returned as a String if it has been specified, if it's not specified this
     * attribute's name is assumed.
     * @see org.andromda.metafacades.uml.AttributeFacade#getEnumerationValue()
     */
    public String getEnumerationValue()
    {
        return this.getSuperEntityAttribute().getEnumerationValue();
    }

    /**
     * The name of the accessor operation that would retrieve this attribute's value.
     * @see org.andromda.metafacades.uml.AttributeFacade#getGetterName()
     */
    public String getGetterName()
    {
        return this.getSuperEntityAttribute().getGetterName();
    }

    /**
     * The name of the type that is returned on the accessor and mutator operations,  determined in
     * part by the multiplicity.
     * @see org.andromda.metafacades.uml.AttributeFacade#getGetterSetterTypeName()
     */
    public String getGetterSetterTypeName()
    {
        return this.getSuperEntityAttribute().getGetterSetterTypeName();
    }

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @see org.andromda.metafacades.uml.AttributeFacade#getLower()
     */
    public int getLower()
    {
        return this.getSuperEntityAttribute().getLower();
    }

    /**
     * Gets the classifier who is the owner of the attributes.
     * @see org.andromda.metafacades.uml.AttributeFacade#getOwner()
     */
    public ClassifierFacade getOwner()
    {
        return this.getSuperEntityAttribute().getOwner();
    }

    /**
     * The name of the mutator operation that would retrieve this attribute's value.
     * @see org.andromda.metafacades.uml.AttributeFacade#getSetterName()
     */
    public String getSetterName()
    {
        return this.getSuperEntityAttribute().getSetterName();
    }

    /**
     * The classifier owning this attribute.
     * @see org.andromda.metafacades.uml.AttributeFacade#getType()
     */
    public ClassifierFacade getType()
    {
        return this.getSuperEntityAttribute().getType();
    }

    /**
     * the upper value for the multiplicity (will be -1 for *)
     * -only applicable for UML2
     * @see org.andromda.metafacades.uml.AttributeFacade#getUpper()
     */
    public int getUpper()
    {
        return this.getSuperEntityAttribute().getUpper();
    }

    /**
     * True if this attribute can only be set.
     * @see org.andromda.metafacades.uml.AttributeFacade#isAddOnly()
     */
    public boolean isAddOnly()
    {
        return this.getSuperEntityAttribute().isAddOnly();
    }

    /**
     * True if this attribute can be modified.
     * @see org.andromda.metafacades.uml.AttributeFacade#isChangeable()
     */
    public boolean isChangeable()
    {
        return this.getSuperEntityAttribute().isChangeable();
    }

    /**
     * Indicates if the default value is present.
     * @see org.andromda.metafacades.uml.AttributeFacade#isDefaultValuePresent()
     */
    public boolean isDefaultValuePresent()
    {
        return this.getSuperEntityAttribute().isDefaultValuePresent();
    }

    /**
     * If the attribute is derived (its value is computed). UML2 only. UML14 always returns false.
     * Default=false.
     * @see org.andromda.metafacades.uml.AttributeFacade#isDerived()
     */
    public boolean isDerived()
    {
        return this.getSuperEntityAttribute().isDerived();
    }

    /**
     * True if this attribute is owned by an enumeration.
     * @see org.andromda.metafacades.uml.AttributeFacade#isEnumerationLiteral()
     */
    public boolean isEnumerationLiteral()
    {
        return this.getSuperEntityAttribute().isEnumerationLiteral();
    }

    /**
     * Returns true if enumeration literal parameters exist (defined by tagged value) for the
     * literal.
     * @see org.andromda.metafacades.uml.AttributeFacade#isEnumerationLiteralParametersExist()
     */
    public boolean isEnumerationLiteralParametersExist()
    {
        return this.getSuperEntityAttribute().isEnumerationLiteralParametersExist();
    }

    /**
     * True if this attribute is owned by an enumeration but is defined as a member variable (NOT a
     * literal).
     * @see org.andromda.metafacades.uml.AttributeFacade#isEnumerationMember()
     */
    public boolean isEnumerationMember()
    {
        return this.getSuperEntityAttribute().isEnumerationMember();
    }

    /**
     * IsLeaf property in the operation. If true, operation is final, cannot be extended or
     * implemented by a descendant.
     * @see org.andromda.metafacades.uml.AttributeFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperEntityAttribute().isLeaf();
    }

    /**
     * Whether or not this attribute has a multiplicity greater than 1.
     * @see org.andromda.metafacades.uml.AttributeFacade#isMany()
     */
    public boolean isMany()
    {
        return this.getSuperEntityAttribute().isMany();
    }

    /**
     * Indicates whether or not the attributes are ordered (if multiplicity is greater than 1).
     * @see org.andromda.metafacades.uml.AttributeFacade#isOrdered()
     */
    public boolean isOrdered()
    {
        return this.getSuperEntityAttribute().isOrdered();
    }

    /**
     * Whether or not this attribute can be modified.
     * @see org.andromda.metafacades.uml.AttributeFacade#isReadOnly()
     */
    public boolean isReadOnly()
    {
        return this.getSuperEntityAttribute().isReadOnly();
    }

    /**
     * Whether or not the multiplicity of this attribute is 1.
     * @see org.andromda.metafacades.uml.AttributeFacade#isRequired()
     */
    public boolean isRequired()
    {
        return this.getSuperEntityAttribute().isRequired();
    }

    /**
     * Indicates if this attribute is 'static', meaning it has a classifier scope.
     * @see org.andromda.metafacades.uml.AttributeFacade#isStatic()
     */
    public boolean isStatic()
    {
        return this.getSuperEntityAttribute().isStatic();
    }

    /**
     * If the attribute is unique within the Collection type. UML2 only. UML14 always returns false.
     * Unique+Ordered determines the implementation Collection type. Default=false.
     * @see org.andromda.metafacades.uml.AttributeFacade#isUnique()
     */
    public boolean isUnique()
    {
        return this.getSuperEntityAttribute().isUnique();
    }

    /**
     * The name of the index to create on a column that persists the entity attribute.
     * @see EntityAttribute#getColumnIndex()
     */
    public String getColumnIndex()
    {
        return this.getSuperEntityAttribute().getColumnIndex();
    }

    /**
     * The length of the column that persists this entity attribute.
     * @see EntityAttribute#getColumnLength()
     */
    public String getColumnLength()
    {
        return this.getSuperEntityAttribute().getColumnLength();
    }

    /**
     * The name of the table column to which this entity is mapped.
     * @see EntityAttribute#getColumnName()
     */
    public String getColumnName()
    {
        return this.getSuperEntityAttribute().getColumnName();
    }

    /**
     * The PIM to language specific mappings for JDBC.
     * @see EntityAttribute#getJdbcMappings()
     */
    public TypeMappings getJdbcMappings()
    {
        return this.getSuperEntityAttribute().getJdbcMappings();
    }

    /**
     * The JDBC type for this entity attribute.
     * @see EntityAttribute#getJdbcType()
     */
    public String getJdbcType()
    {
        return this.getSuperEntityAttribute().getJdbcType();
    }

    /**
     * The SQL mappings (i.e. the mappings which provide PIM to SQL mappings).
     * @see EntityAttribute#getSqlMappings()
     */
    public TypeMappings getSqlMappings()
    {
        return this.getSuperEntityAttribute().getSqlMappings();
    }

    /**
     * The SQL type for this attribute.
     * @see EntityAttribute#getSqlType()
     */
    public String getSqlType()
    {
        return this.getSuperEntityAttribute().getSqlType();
    }

    /**
     * The name of the unique-key that this unique attribute belongs
     * @see EntityAttribute#getUniqueGroup()
     */
    public String getUniqueGroup()
    {
        return this.getSuperEntityAttribute().getUniqueGroup();
    }

    /**
     * True if this attribute is an identifier for its entity.
     * @see EntityAttribute#isIdentifier()
     */
    public boolean isIdentifier()
    {
        return this.getSuperEntityAttribute().isIdentifier();
    }

    /**
     * Indicates this attribute should be ignored by the persistence layer.
     * @see EntityAttribute#isTransient()
     */
    public boolean isTransient()
    {
        return this.getSuperEntityAttribute().isTransient();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperEntityAttribute().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperEntityAttribute().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperEntityAttribute().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperEntityAttribute().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperEntityAttribute().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperEntityAttribute().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperEntityAttribute().getDocumentation(indent);
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
        return this.getSuperEntityAttribute().getDocumentation(indent, lineLength);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. HTML style determines if HTML Escaping is applied.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperEntityAttribute().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperEntityAttribute().getFullyQualifiedName();
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
        return this.getSuperEntityAttribute().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperEntityAttribute().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperEntityAttribute().getId();
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
        return this.getSuperEntityAttribute().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperEntityAttribute().getLabel();
    }

    /**
     * The language mappings that have been set for this model element.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperEntityAttribute().getLanguageMappings();
    }

    /**
     * Return the model containing this model element (multiple models may be loaded and processed
     * at the same time).
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperEntityAttribute().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperEntityAttribute().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperEntityAttribute().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperEntityAttribute().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperEntityAttribute().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperEntityAttribute().getPackagePath();
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
        return this.getSuperEntityAttribute().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperEntityAttribute().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperEntityAttribute().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperEntityAttribute().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperEntityAttribute().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperEntityAttribute().getStereotypes();
    }

    /**
     * Return the TaggedValues associated with this model element, under all stereotypes.
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperEntityAttribute().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperEntityAttribute().getTargetDependencies();
    }

    /**
     * Get the template parameters for this model element.
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperEntityAttribute().getTemplateParameter(parameterName);
    }

    /**
     * Get the template parameter for this model element having the parameterName.
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperEntityAttribute().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperEntityAttribute().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperEntityAttribute().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperEntityAttribute().hasKeyword(keywordName);
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
        return this.getSuperEntityAttribute().hasStereotype(stereotypeName);
    }

    /**
     * True if there are target dependencies from this element that are instances of BindingFacade.
     * Deprecated in UML2: Use TemplateBinding parameters instead of dependencies.
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperEntityAttribute().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperEntityAttribute().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperEntityAttribute().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperEntityAttribute().isReservedWord();
    }

    /**
     * True is there are template parameters on this model element. For UML2, applies to Class,
     * Operation, Property, and Parameter.
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperEntityAttribute().isTemplateParametersPresent();
    }

    /**
     * True if this element name is a valid identifier name in Java, C#, ANSI or ISO C, C++,
     * JavaScript. Contains no spaces, special characters etc. Constraint always applied on
     * Enumerations and Interfaces, optionally applies on other model elements.
     * @see ModelElementFacade#isValidIdentifierName()
     */
    public boolean isValidIdentifierName()
    {
        return this.getSuperEntityAttribute().isValidIdentifierName();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperEntityAttribute().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperEntityAttribute().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperEntityAttribute().translateConstraints(kind, translation);
    }

    /**
     * @see MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperEntityAttribute().initialize();
    }

    /**
     * @return Object getSuperEntityAttribute().getValidationOwner()
     * @see MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperEntityAttribute().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperEntityAttribute().getValidationName()
     * @see MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperEntityAttribute().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperEntityAttribute().validateInvariants(validationMessages);
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
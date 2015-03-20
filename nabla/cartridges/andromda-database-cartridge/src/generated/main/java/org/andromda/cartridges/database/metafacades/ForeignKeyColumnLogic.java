// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.database.metafacades;

import java.util.Collection;
import org.andromda.core.common.Introspector;
import org.andromda.core.metafacade.MetafacadeBase;
import org.andromda.core.metafacade.MetafacadeFactory;
import org.andromda.core.metafacade.ModelValidationMessage;
import org.andromda.metafacades.uml.AssociationEndFacade;
import org.andromda.metafacades.uml.AssociationFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.EntityAssociationEnd;
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
 * TODO: Model Documentation for org.andromda.cartridges.database.metafacades.ForeignKeyColumn
 * MetafacadeLogic for ForeignKeyColumn
 *
 * @see ForeignKeyColumn
 */
public abstract class ForeignKeyColumnLogic
    extends MetafacadeBase
    implements ForeignKeyColumn
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
    protected ForeignKeyColumnLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superEntityAssociationEnd =
           (EntityAssociationEnd)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.EntityAssociationEnd",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = Logger.getLogger(ForeignKeyColumnLogic.class);

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to ForeignKeyColumn if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.database.metafacades.ForeignKeyColumn";
        }
        return context;
    }

    private EntityAssociationEnd superEntityAssociationEnd;
    private boolean superEntityAssociationEndInitialized = false;

    /**
     * Gets the EntityAssociationEnd parent instance.
     * @return this.superEntityAssociationEnd EntityAssociationEnd
     */
    private EntityAssociationEnd getSuperEntityAssociationEnd()
    {
        if (!this.superEntityAssociationEndInitialized)
        {
            ((MetafacadeBase)this.superEntityAssociationEnd).setMetafacadeContext(this.getMetafacadeContext());
            this.superEntityAssociationEndInitialized = true;
        }
        return this.superEntityAssociationEnd;
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
            if (this.superEntityAssociationEndInitialized)
            {
                ((MetafacadeBase)this.superEntityAssociationEnd).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see ForeignKeyColumn
     */
    public boolean isForeignKeyColumnMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.database.metafacades.ForeignKeyColumn#isCascadeDelete()
    * @return boolean
    */
    protected abstract boolean handleIsCascadeDelete();

    private transient boolean cascadeDelete1a;
    private transient boolean cascadeDelete1aSet = false;

    /**
     * Denotes whether or not a row of this column's table needs to be deleted if the importing key
     * is deleted.
     * @return (boolean)handleIsCascadeDelete()
     */
    public final boolean isCascadeDelete()
    {
        boolean cascadeDelete1a = this.cascadeDelete1a;
        if (!this.cascadeDelete1aSet)
        {
            // cascadeDelete has no pre constraints
            cascadeDelete1a = handleIsCascadeDelete();
            // cascadeDelete has no post constraints
            this.cascadeDelete1a = cascadeDelete1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.cascadeDelete1aSet = true;
            }
        }
        return cascadeDelete1a;
    }

   /**
    * @see org.andromda.cartridges.database.metafacades.ForeignKeyColumn#getConstraintName()
    * @return String
    */
    protected abstract String handleGetConstraintName();

    private transient String constraintName2a;
    private transient boolean constraintName2aSet = false;

    /**
     * The name of the foreign key constraint.
     * @return (String)handleGetConstraintName()
     */
    public final String getConstraintName()
    {
        String constraintName2a = this.constraintName2a;
        if (!this.constraintName2aSet)
        {
            // constraintName has no pre constraints
            constraintName2a = handleGetConstraintName();
            // constraintName has no post constraints
            this.constraintName2a = constraintName2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.constraintName2aSet = true;
            }
        }
        return constraintName2a;
    }

   /**
    * @see org.andromda.cartridges.database.metafacades.ForeignKeyColumn#getIndexName()
    * @return String
    */
    protected abstract String handleGetIndexName();

    private transient String indexName3a;
    private transient boolean indexName3aSet = false;

    /**
     * The name of the index for this foreign-key column.
     * @return (String)handleGetIndexName()
     */
    public final String getIndexName()
    {
        String indexName3a = this.indexName3a;
        if (!this.indexName3aSet)
        {
            // indexName has no pre constraints
            indexName3a = handleGetIndexName();
            // indexName has no post constraints
            this.indexName3a = indexName3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.indexName3aSet = true;
            }
        }
        return indexName3a;
    }

   /**
    * @see org.andromda.cartridges.database.metafacades.ForeignKeyColumn#getTableName()
    * @return String
    */
    protected abstract String handleGetTableName();

    private transient String tableName4a;
    private transient boolean tableName4aSet = false;

    /**
     * The name of the table tha stores the foreign key.
     * @return (String)handleGetTableName()
     */
    public final String getTableName()
    {
        String tableName4a = this.tableName4a;
        if (!this.tableName4aSet)
        {
            // tableName has no pre constraints
            tableName4a = handleGetTableName();
            // tableName has no post constraints
            this.tableName4a = tableName4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableName4aSet = true;
            }
        }
        return tableName4a;
    }

    // ---------------- business methods ----------------------

    /**
     * Method to be implemented in descendants
     * Returns the dummy load value for the specified index.
     * @param index
     * @return String
     */
    protected abstract String handleGetDummyLoadValue(int index);

    /**
     * Returns the dummy load value for the specified index.
     * @param index int
     * TODO: Model Documentation for
     * org.andromda.cartridges.database.metafacades.ForeignKeyColumn.getDummyLoadValue(index)
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

    private transient Table getTable1r;
    private transient boolean getTable1rSet = false;

    /**
     * The foreign-key columns that are part of this table.
     * @return (Table)handleGetTable()
     */
    public final Table getTable()
    {
        Table getTable1r = this.getTable1r;
        if (!this.getTable1rSet)
        {
            // foreignKeyColumns has no pre constraints
            Object result = handleGetTable();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getTable1r = (Table) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                ForeignKeyColumnLogic.LOGGER.warn("incorrect metafacade cast for ForeignKeyColumnLogic.getTable Table " + result + ": " + shieldedResult);
            }
            // foreignKeyColumns has no post constraints
            this.getTable1r = getTable1r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getTable1rSet = true;
            }
        }
        return getTable1r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetTable();

    private transient Column getImportedPrimaryKeyColumn2r;
    private transient boolean getImportedPrimaryKeyColumn2rSet = false;

    /**
     * The foreign-key columns importing this table.
     * @return (Column)handleGetImportedPrimaryKeyColumn()
     */
    public final Column getImportedPrimaryKeyColumn()
    {
        Column getImportedPrimaryKeyColumn2r = this.getImportedPrimaryKeyColumn2r;
        if (!this.getImportedPrimaryKeyColumn2rSet)
        {
            // exportedColumns has no pre constraints
            Object result = handleGetImportedPrimaryKeyColumn();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getImportedPrimaryKeyColumn2r = (Column) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                ForeignKeyColumnLogic.LOGGER.warn("incorrect metafacade cast for ForeignKeyColumnLogic.getImportedPrimaryKeyColumn Column " + result + ": " + shieldedResult);
            }
            // exportedColumns has no post constraints
            this.getImportedPrimaryKeyColumn2r = getImportedPrimaryKeyColumn2r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getImportedPrimaryKeyColumn2rSet = true;
            }
        }
        return getImportedPrimaryKeyColumn2r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetImportedPrimaryKeyColumn();

    private transient Table getImportedTable3r;
    private transient boolean getImportedTable3rSet = false;

    /**
     * TODO: Model Documentation for org.andromda.cartridges.database.metafacades.ForeignKeyColumn
     * @return (Table)handleGetImportedTable()
     */
    public final Table getImportedTable()
    {
        Table getImportedTable3r = this.getImportedTable3r;
        if (!this.getImportedTable3rSet)
        {
            // foreignKeyColumn has no pre constraints
            Object result = handleGetImportedTable();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getImportedTable3r = (Table) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                ForeignKeyColumnLogic.LOGGER.warn("incorrect metafacade cast for ForeignKeyColumnLogic.getImportedTable Table " + result + ": " + shieldedResult);
            }
            // foreignKeyColumn has no post constraints
            this.getImportedTable3r = getImportedTable3r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getImportedTable3rSet = true;
            }
        }
        return getImportedTable3r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetImportedTable();

    private transient AssociationTable getAssociationTable4r;
    private transient boolean getAssociationTable4rSet = false;

    /**
     * The foreign-key columns that are part of this association table.
     * @return (AssociationTable)handleGetAssociationTable()
     */
    public final AssociationTable getAssociationTable()
    {
        AssociationTable getAssociationTable4r = this.getAssociationTable4r;
        if (!this.getAssociationTable4rSet)
        {
            // foreignKeyColumns has no pre constraints
            Object result = handleGetAssociationTable();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getAssociationTable4r = (AssociationTable) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                ForeignKeyColumnLogic.LOGGER.warn("incorrect metafacade cast for ForeignKeyColumnLogic.getAssociationTable AssociationTable " + result + ": " + shieldedResult);
            }
            // foreignKeyColumns has no post constraints
            this.getAssociationTable4r = getAssociationTable4r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getAssociationTable4rSet = true;
            }
        }
        return getAssociationTable4r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetAssociationTable();

    /**
     * @return true
     * @see EntityAssociationEnd
     */
    public boolean isEntityAssociationEndMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see AssociationEndFacade
     */
    public boolean isAssociationEndFacadeMetaType()
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

    // ----------- delegates to EntityAssociationEnd ------------
    /**
     * A name suitable for use when adding new elements to this association end in programming code.
     * @see AssociationEndFacade#getAdderName()
     */
    public String getAdderName()
    {
        return this.getSuperEntityAssociationEnd().getAdderName();
    }

    /**
     * Returns the value of the 'Aggregation' attribute (none, shared, composite). The default value
     * is "none". The literals are from the enumeration org.eclipse.uml2.uml.AggregationKind.
     * Specifies the kind of aggregation that applies to the Property.
     * @see AssociationEndFacade#getAggregationKind()
     */
    public String getAggregationKind()
    {
        return this.getSuperEntityAssociationEnd().getAggregationKind();
    }

    /**
     * The association owning this association end.
     * @see AssociationEndFacade#getAssociation()
     */
    public AssociationFacade getAssociation()
    {
        return this.getSuperEntityAssociationEnd().getAssociation();
    }

    /**
     * UML2: Returns the value of the 'Default' attribute. Specifies a String that represents a
     * value to be used when no argument is supplied for the Property. A String that is evaluated to
     * give a default value for the Property when an object of the owning Classifier is
     * instantiated.  Can be something like: new ValueObject(values);
     * @see AssociationEndFacade#getDefault()
     */
    public String getDefault()
    {
        return this.getSuperEntityAssociationEnd().getDefault();
    }

    /**
     * A name suitable for use when accessing this association end in programming code.
     * @see AssociationEndFacade#getGetterName()
     */
    public String getGetterName()
    {
        return this.getSuperEntityAssociationEnd().getGetterName();
    }

    /**
     * The name of the type that is returned on the accessor and mutator operations,  determined in
     * part by the multiplicity.
     * @see AssociationEndFacade#getGetterSetterTypeName()
     */
    public String getGetterSetterTypeName()
    {
        return this.getSuperEntityAssociationEnd().getGetterSetterTypeName();
    }

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @see AssociationEndFacade#getLower()
     */
    public int getLower()
    {
        return this.getSuperEntityAssociationEnd().getLower();
    }

    /**
     * The other association end owned by this end's association.
     * @see AssociationEndFacade#getOtherEnd()
     */
    public AssociationEndFacade getOtherEnd()
    {
        return this.getSuperEntityAssociationEnd().getOtherEnd();
    }

    /**
     * A name suitable for use when removing element from this association end in programming code.
     * @see AssociationEndFacade#getRemoverName()
     */
    public String getRemoverName()
    {
        return this.getSuperEntityAssociationEnd().getRemoverName();
    }

    /**
     * A name suitable for use when accessing this association end in programming code.
     * @see AssociationEndFacade#getSetterName()
     */
    public String getSetterName()
    {
        return this.getSuperEntityAssociationEnd().getSetterName();
    }

    /**
     * The classifier attached to this association end.
     * @see AssociationEndFacade#getType()
     */
    public ClassifierFacade getType()
    {
        return this.getSuperEntityAssociationEnd().getType();
    }

    /**
     * the upper value for the multiplicity (will be -1 for *)
     * -only applicable for UML2
     * @see AssociationEndFacade#getUpper()
     */
    public int getUpper()
    {
        return this.getSuperEntityAssociationEnd().getUpper();
    }

    /**
     * True if this association end represents an aggregation relationship.
     * @see AssociationEndFacade#isAggregation()
     */
    public boolean isAggregation()
    {
        return this.getSuperEntityAssociationEnd().isAggregation();
    }

    /**
     * Is true if update of one side of the association should also update the other side. false if
     * not.
     * @see AssociationEndFacade#isBidirectional()
     */
    public boolean isBidirectional()
    {
        return this.getSuperEntityAssociationEnd().isBidirectional();
    }

    /**
     * Returns whether or not (true/false) this association end is the child end of the assocation
     * (i.e. the other end's aggregation is composition).
     * @see AssociationEndFacade#isChild()
     */
    public boolean isChild()
    {
        return this.getSuperEntityAssociationEnd().isChild();
    }

    /**
     * True if this association end represents a composition relationship.
     * @see AssociationEndFacade#isComposition()
     */
    public boolean isComposition()
    {
        return this.getSuperEntityAssociationEnd().isComposition();
    }

    /**
     * If the association end is derived (its value is computed). UML2 only. UML14 always returns
     * false. Default=false.
     * @see AssociationEndFacade#isDerived()
     */
    public boolean isDerived()
    {
        return this.getSuperEntityAssociationEnd().isDerived();
    }

    /**
     * IsLeaf property in the association end property. If true, attribute is final, cannot be
     * extended or implemented by a descendant. Default=false.
     * @see AssociationEndFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperEntityAssociationEnd().isLeaf();
    }

    /**
     * True if this association end's multiplicity is greater than one.
     * @see AssociationEndFacade#isMany()
     */
    public boolean isMany()
    {
        return this.getSuperEntityAssociationEnd().isMany();
    }

    /**
     * True if this association end's and the other end's multiplicities are both many.
     * @see AssociationEndFacade#isMany2Many()
     */
    public boolean isMany2Many()
    {
        return this.getSuperEntityAssociationEnd().isMany2Many();
    }

    /**
     * True if this association end's multiplicity is many while the other end's is one.
     * @see AssociationEndFacade#isMany2One()
     */
    public boolean isMany2One()
    {
        return this.getSuperEntityAssociationEnd().isMany2One();
    }

    /**
     * True if it is possible to navigate from the other end to this association end .
     * @see AssociationEndFacade#isNavigable()
     */
    public boolean isNavigable()
    {
        return this.getSuperEntityAssociationEnd().isNavigable();
    }

    /**
     * True if this association end's multiplicity is one while the other end's is many.
     * @see AssociationEndFacade#isOne2Many()
     */
    public boolean isOne2Many()
    {
        return this.getSuperEntityAssociationEnd().isOne2Many();
    }

    /**
     * True if this association end's and the other end's multiplicities are both one.
     * @see AssociationEndFacade#isOne2One()
     */
    public boolean isOne2One()
    {
        return this.getSuperEntityAssociationEnd().isOne2One();
    }

    /**
     * Indicates whether or not the association ends are ordered (if multiplicity is greater than
     * 1).
     * @see AssociationEndFacade#isOrdered()
     */
    public boolean isOrdered()
    {
        return this.getSuperEntityAssociationEnd().isOrdered();
    }

    /**
     * True if the association end cannot be changed.
     * @see AssociationEndFacade#isReadOnly()
     */
    public boolean isReadOnly()
    {
        return this.getSuperEntityAssociationEnd().isReadOnly();
    }

    /**
     * True if this association end's multiplicity is strictly greater than zero.
     * @see AssociationEndFacade#isRequired()
     */
    public boolean isRequired()
    {
        return this.getSuperEntityAssociationEnd().isRequired();
    }

    /**
     * Indicates if this associationEnd is 'static', meaning it has a classifier scope.
     * @see AssociationEndFacade#isStatic()
     */
    public boolean isStatic()
    {
        return this.getSuperEntityAssociationEnd().isStatic();
    }

    /**
     * UML2: If the association attribute is unique within the Collection type. UML14 always returns
     * false. Unique+Ordered determines the implementation Collection type. Default=false.
     * @see AssociationEndFacade#isUnique()
     */
    public boolean isUnique()
    {
        return this.getSuperEntityAssociationEnd().isUnique();
    }

    /**
     * The name of the index to create on a column that persists the foreign key attribute.
     * @see EntityAssociationEnd#getColumnIndex()
     */
    public String getColumnIndex()
    {
        return this.getSuperEntityAssociationEnd().getColumnIndex();
    }

    /**
     * The name of the column that makes up the foreign key.
     * @see EntityAssociationEnd#getColumnName()
     */
    public String getColumnName()
    {
        return this.getSuperEntityAssociationEnd().getColumnName();
    }

    /**
     * The name of the foreign key constraint to use for databases.
     * @see EntityAssociationEnd#getForeignKeyConstraintName()
     */
    public String getForeignKeyConstraintName()
    {
        return this.getSuperEntityAssociationEnd().getForeignKeyConstraintName();
    }

    /**
     * The current foreign key suffix specified for this entity association end facade.
     * @see EntityAssociationEnd#getForeignKeySuffix()
     */
    public String getForeignKeySuffix()
    {
        return this.getSuperEntityAssociationEnd().getForeignKeySuffix();
    }

    /**
     * The SQL type for this the foreign key column of this association end.
     * @see EntityAssociationEnd#getSqlType()
     */
    public String getSqlType()
    {
        return this.getSuperEntityAssociationEnd().getSqlType();
    }

    /**
     * The name of the unique-key that this unique association end belongs
     * @see EntityAssociationEnd#getUniqueGroup()
     */
    public String getUniqueGroup()
    {
        return this.getSuperEntityAssociationEnd().getUniqueGroup();
    }

    /**
     * Indicates whether or not a foreign identifier should be used for the entity that owns this
     * association end.  This would only make sense in the case of a child in a one-to-one
     * parent-child association.  If this flag is true, then the identifier of this entity should
     * also be used as the foreign key to the related parent entity.
     * @see EntityAssociationEnd#isForeignIdentifier()
     */
    public boolean isForeignIdentifier()
    {
        return this.getSuperEntityAssociationEnd().isForeignIdentifier();
    }

    /**
     * True if this association is an identifier for its entity.
     * @see EntityAssociationEnd#isIdentifier()
     */
    public boolean isIdentifier()
    {
        return this.getSuperEntityAssociationEnd().isIdentifier();
    }

    /**
     * True if the associationEnd is marked with identifiers stereotype, false otherwise.
     * @see EntityAssociationEnd#isIdentifiersPresent()
     */
    public boolean isIdentifiersPresent()
    {
        return this.getSuperEntityAssociationEnd().isIdentifiersPresent();
    }

    /**
     * Indicates this association end should be ignored by the persistence layer.
     * @see EntityAssociationEnd#isTransient()
     */
    public boolean isTransient()
    {
        return this.getSuperEntityAssociationEnd().isTransient();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperEntityAssociationEnd().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperEntityAssociationEnd().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperEntityAssociationEnd().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperEntityAssociationEnd().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperEntityAssociationEnd().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperEntityAssociationEnd().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperEntityAssociationEnd().getDocumentation(indent);
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
        return this.getSuperEntityAssociationEnd().getDocumentation(indent, lineLength);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. HTML style determines if HTML Escaping is applied.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperEntityAssociationEnd().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperEntityAssociationEnd().getFullyQualifiedName();
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
        return this.getSuperEntityAssociationEnd().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperEntityAssociationEnd().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperEntityAssociationEnd().getId();
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
        return this.getSuperEntityAssociationEnd().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperEntityAssociationEnd().getLabel();
    }

    /**
     * The language mappings that have been set for this model element.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperEntityAssociationEnd().getLanguageMappings();
    }

    /**
     * Return the model containing this model element (multiple models may be loaded and processed
     * at the same time).
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperEntityAssociationEnd().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperEntityAssociationEnd().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperEntityAssociationEnd().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperEntityAssociationEnd().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperEntityAssociationEnd().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperEntityAssociationEnd().getPackagePath();
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
        return this.getSuperEntityAssociationEnd().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperEntityAssociationEnd().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperEntityAssociationEnd().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperEntityAssociationEnd().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperEntityAssociationEnd().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperEntityAssociationEnd().getStereotypes();
    }

    /**
     * Return the TaggedValues associated with this model element, under all stereotypes.
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperEntityAssociationEnd().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperEntityAssociationEnd().getTargetDependencies();
    }

    /**
     * Get the template parameters for this model element.
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperEntityAssociationEnd().getTemplateParameter(parameterName);
    }

    /**
     * Get the template parameter for this model element having the parameterName.
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperEntityAssociationEnd().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperEntityAssociationEnd().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperEntityAssociationEnd().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperEntityAssociationEnd().hasKeyword(keywordName);
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
        return this.getSuperEntityAssociationEnd().hasStereotype(stereotypeName);
    }

    /**
     * True if there are target dependencies from this element that are instances of BindingFacade.
     * Deprecated in UML2: Use TemplateBinding parameters instead of dependencies.
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperEntityAssociationEnd().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperEntityAssociationEnd().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperEntityAssociationEnd().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperEntityAssociationEnd().isReservedWord();
    }

    /**
     * True is there are template parameters on this model element. For UML2, applies to Class,
     * Operation, Property, and Parameter.
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperEntityAssociationEnd().isTemplateParametersPresent();
    }

    /**
     * True if this element name is a valid identifier name in Java, C#, ANSI or ISO C, C++,
     * JavaScript. Contains no spaces, special characters etc. Constraint always applied on
     * Enumerations and Interfaces, optionally applies on other model elements.
     * @see ModelElementFacade#isValidIdentifierName()
     */
    public boolean isValidIdentifierName()
    {
        return this.getSuperEntityAssociationEnd().isValidIdentifierName();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperEntityAssociationEnd().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperEntityAssociationEnd().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperEntityAssociationEnd().translateConstraints(kind, translation);
    }

    /**
     * @see MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperEntityAssociationEnd().initialize();
    }

    /**
     * @return Object getSuperEntityAssociationEnd().getValidationOwner()
     * @see MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperEntityAssociationEnd().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperEntityAssociationEnd().getValidationName()
     * @see MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperEntityAssociationEnd().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperEntityAssociationEnd().validateInvariants(validationMessages);
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
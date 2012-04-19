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

/**
 * Represents an EJB attribute.
 * MetafacadeLogic for EJB3EntityAttributeFacade
 *
 * @see EJB3EntityAttributeFacade
 */
public abstract class EJB3EntityAttributeFacadeLogic
    extends MetafacadeBase
    implements EJB3EntityAttributeFacade
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
    protected EJB3EntityAttributeFacadeLogic(Object metaObjectIn, String context)
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
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to EJB3EntityAttributeFacade if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade";
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
     * @see org.andromda.core.metafacade.MetafacadeBase#resetMetafacadeContext(String context)
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
     * @see EJB3EntityAttributeFacade
     */
    public boolean isEJB3EntityAttributeFacadeMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#getFetchType()
    * @return String
    */
    protected abstract String handleGetFetchType();

    private String __fetchType1a;
    private boolean __fetchType1aSet = false;

    /**
     * Gets the fetch type for this attribute.  Default fetch type for attribute is EAGER.
     * This will return either EAGER or LAZY.
     * @return (String)handleGetFetchType()
     */
    public final String getFetchType()
    {
        String fetchType1a = this.__fetchType1a;
        if (!this.__fetchType1aSet)
        {
            // fetchType has no pre constraints
            fetchType1a = handleGetFetchType();
            // fetchType has no post constraints
            this.__fetchType1a = fetchType1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__fetchType1aSet = true;
            }
        }
        return fetchType1a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#isVersion()
    * @return boolean
    */
    protected abstract boolean handleIsVersion();

    private boolean __version2a;
    private boolean __version2aSet = false;

    /**
     * True is this attribute is a version property (optimistic lock value) for this entity class.
     * @return (boolean)handleIsVersion()
     */
    public final boolean isVersion()
    {
        boolean version2a = this.__version2a;
        if (!this.__version2aSet)
        {
            // version has no pre constraints
            version2a = handleIsVersion();
            // version has no post constraints
            this.__version2a = version2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__version2aSet = true;
            }
        }
        return version2a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#isLob()
    * @return boolean
    */
    protected abstract boolean handleIsLob();

    private boolean __lob3a;
    private boolean __lob3aSet = false;

    /**
     * Returns true if the property type is specified as datatype::Blob or datatype::Clob.
     * LOB type is CLOB for characters or BLOB for binary data.
     * @return (boolean)handleIsLob()
     */
    public final boolean isLob()
    {
        boolean lob3a = this.__lob3a;
        if (!this.__lob3aSet)
        {
            // lob has no pre constraints
            lob3a = handleIsLob();
            // lob has no post constraints
            this.__lob3a = lob3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__lob3aSet = true;
            }
        }
        return lob3a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#getGeneratorType()
    * @return String
    */
    protected abstract String handleGetGeneratorType();

    private String __generatorType4a;
    private boolean __generatorType4aSet = false;

    /**
     * Determine the generator type for the Id annotation on the entity attribute - the PK strategy.
     * If the attribute type is numeric, the default generator type is AUTO.  Otherwise, the
     * generator type is NONE, ie for String types.
     * @return (String)handleGetGeneratorType()
     */
    public final String getGeneratorType()
    {
        String generatorType4a = this.__generatorType4a;
        if (!this.__generatorType4aSet)
        {
            // generatorType has no pre constraints
            generatorType4a = handleGetGeneratorType();
            // generatorType has no post constraints
            this.__generatorType4a = generatorType4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__generatorType4aSet = true;
            }
        }
        return generatorType4a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#getColumnDefinition()
    * @return String
    */
    protected abstract String handleGetColumnDefinition();

    private String __columnDefinition5a;
    private boolean __columnDefinition5aSet = false;

    /**
     * Defines the column definition DDL used when creating table schema - use to override default
     * container DDL.  This is automatically defined if the attribute type is an enumeration.
     * @return (String)handleGetColumnDefinition()
     */
    public final String getColumnDefinition()
    {
        String columnDefinition5a = this.__columnDefinition5a;
        if (!this.__columnDefinition5aSet)
        {
            // columnDefinition has no pre constraints
            columnDefinition5a = handleGetColumnDefinition();
            // columnDefinition has no post constraints
            this.__columnDefinition5a = columnDefinition5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__columnDefinition5aSet = true;
            }
        }
        return columnDefinition5a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#getColumnPrecision()
    * @return String
    */
    protected abstract String handleGetColumnPrecision();

    private String __columnPrecision6a;
    private boolean __columnPrecision6aSet = false;

    /**
     * Set the column precision value.  Only applies to double and float columns.
     * ie Use for setting dollar precision.
     * @return (String)handleGetColumnPrecision()
     */
    public final String getColumnPrecision()
    {
        String columnPrecision6a = this.__columnPrecision6a;
        if (!this.__columnPrecision6aSet)
        {
            // columnPrecision has no pre constraints
            columnPrecision6a = handleGetColumnPrecision();
            // columnPrecision has no post constraints
            this.__columnPrecision6a = columnPrecision6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__columnPrecision6aSet = true;
            }
        }
        return columnPrecision6a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#getColumnScale()
    * @return String
    */
    protected abstract String handleGetColumnScale();

    private String __columnScale7a;
    private boolean __columnScale7aSet = false;

    /**
     * Column scale use denotes the decimal precision.
     * ie Use to set the 2 digit cent scale.
     * @return (String)handleGetColumnScale()
     */
    public final String getColumnScale()
    {
        String columnScale7a = this.__columnScale7a;
        if (!this.__columnScale7aSet)
        {
            // columnScale has no pre constraints
            columnScale7a = handleGetColumnScale();
            // columnScale has no post constraints
            this.__columnScale7a = columnScale7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__columnScale7aSet = true;
            }
        }
        return columnScale7a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#isColumnNullable()
    * @return boolean
    */
    protected abstract boolean handleIsColumnNullable();

    private boolean __columnNullable8a;
    private boolean __columnNullable8aSet = false;

    /**
     * Whether the column can be nullable.  False for identifier and unique fields.  If
     * andromda_persistence_column_nullable tag is set, the tagged value is used.  Otherwise,
     * determine if this attribute is required from the multiplicity set on the attribute.
     * @return (boolean)handleIsColumnNullable()
     */
    public final boolean isColumnNullable()
    {
        boolean columnNullable8a = this.__columnNullable8a;
        if (!this.__columnNullable8aSet)
        {
            // columnNullable has no pre constraints
            columnNullable8a = handleIsColumnNullable();
            // columnNullable has no post constraints
            this.__columnNullable8a = columnNullable8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__columnNullable8aSet = true;
            }
        }
        return columnNullable8a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#isEager()
    * @return boolean
    */
    protected abstract boolean handleIsEager();

    private boolean __eager9a;
    private boolean __eager9aSet = false;

    /**
     * Determine if the fetch type for this attribute is eager loading.
     * @return (boolean)handleIsEager()
     */
    public final boolean isEager()
    {
        boolean eager9a = this.__eager9a;
        if (!this.__eager9aSet)
        {
            // eager has no pre constraints
            eager9a = handleIsEager();
            // eager has no post constraints
            this.__eager9a = eager9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__eager9aSet = true;
            }
        }
        return eager9a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#isLazy()
    * @return boolean
    */
    protected abstract boolean handleIsLazy();

    private boolean __lazy10a;
    private boolean __lazy10aSet = false;

    /**
     * Determine if the fetch type for this attribute is lazy loading.
     * @return (boolean)handleIsLazy()
     */
    public final boolean isLazy()
    {
        boolean lazy10a = this.__lazy10a;
        if (!this.__lazy10aSet)
        {
            // lazy has no pre constraints
            lazy10a = handleIsLazy();
            // lazy has no post constraints
            this.__lazy10a = lazy10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__lazy10aSet = true;
            }
        }
        return lazy10a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#getGeneratorName()
    * @return String
    */
    protected abstract String handleGetGeneratorName();

    private String __generatorName11a;
    private boolean __generatorName11aSet = false;

    /**
     * Return the name for the generator, if one exists and should exists for SequenceGenerator and
     * TableGenerator, which can be reference by the id for its generator.
     * @return (String)handleGetGeneratorName()
     */
    public final String getGeneratorName()
    {
        String generatorName11a = this.__generatorName11a;
        if (!this.__generatorName11aSet)
        {
            // generatorName has no pre constraints
            generatorName11a = handleGetGeneratorName();
            // generatorName has no post constraints
            this.__generatorName11a = generatorName11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__generatorName11aSet = true;
            }
        }
        return generatorName11a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#getGeneratorSourceName()
    * @return String
    */
    protected abstract String handleGetGeneratorSourceName();

    private String __generatorSourceName12a;
    private boolean __generatorSourceName12aSet = false;

    /**
     * Returns the sequence name or table name for the generator depending on the generator type
     * specified.
     * @return (String)handleGetGeneratorSourceName()
     */
    public final String getGeneratorSourceName()
    {
        String generatorSourceName12a = this.__generatorSourceName12a;
        if (!this.__generatorSourceName12aSet)
        {
            // generatorSourceName has no pre constraints
            generatorSourceName12a = handleGetGeneratorSourceName();
            // generatorSourceName has no post constraints
            this.__generatorSourceName12a = generatorSourceName12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__generatorSourceName12aSet = true;
            }
        }
        return generatorSourceName12a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#getGeneratorPkColumnValue()
    * @return String
    */
    protected abstract String handleGetGeneratorPkColumnValue();

    private String __generatorPkColumnValue13a;
    private boolean __generatorPkColumnValue13aSet = false;

    /**
     * Returns the name of the primary key value in the generator table assigned to this set of
     * generated values.
     * @return (String)handleGetGeneratorPkColumnValue()
     */
    public final String getGeneratorPkColumnValue()
    {
        String generatorPkColumnValue13a = this.__generatorPkColumnValue13a;
        if (!this.__generatorPkColumnValue13aSet)
        {
            // generatorPkColumnValue has no pre constraints
            generatorPkColumnValue13a = handleGetGeneratorPkColumnValue();
            // generatorPkColumnValue has no post constraints
            this.__generatorPkColumnValue13a = generatorPkColumnValue13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__generatorPkColumnValue13aSet = true;
            }
        }
        return generatorPkColumnValue13a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#getGeneratorInitialValue()
    * @return int
    */
    protected abstract int handleGetGeneratorInitialValue();

    private int __generatorInitialValue14a;
    private boolean __generatorInitialValue14aSet = false;

    /**
     * Returns the inital value assigned when allocating ids from the specified generator.
     * @return (int)handleGetGeneratorInitialValue()
     */
    public final int getGeneratorInitialValue()
    {
        int generatorInitialValue14a = this.__generatorInitialValue14a;
        if (!this.__generatorInitialValue14aSet)
        {
            // generatorInitialValue has no pre constraints
            generatorInitialValue14a = handleGetGeneratorInitialValue();
            // generatorInitialValue has no post constraints
            this.__generatorInitialValue14a = generatorInitialValue14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__generatorInitialValue14aSet = true;
            }
        }
        return generatorInitialValue14a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#getGeneratorAllocationSize()
    * @return int
    */
    protected abstract int handleGetGeneratorAllocationSize();

    private int __generatorAllocationSize15a;
    private boolean __generatorAllocationSize15aSet = false;

    /**
     * Returns the amount to increment the generator value when allocating id numbers.
     * @return (int)handleGetGeneratorAllocationSize()
     */
    public final int getGeneratorAllocationSize()
    {
        int generatorAllocationSize15a = this.__generatorAllocationSize15a;
        if (!this.__generatorAllocationSize15aSet)
        {
            // generatorAllocationSize has no pre constraints
            generatorAllocationSize15a = handleGetGeneratorAllocationSize();
            // generatorAllocationSize has no post constraints
            this.__generatorAllocationSize15a = generatorAllocationSize15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__generatorAllocationSize15aSet = true;
            }
        }
        return generatorAllocationSize15a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#isGeneratorTypeSequence()
    * @return boolean
    */
    protected abstract boolean handleIsGeneratorTypeSequence();

    private boolean __generatorTypeSequence16a;
    private boolean __generatorTypeSequence16aSet = false;

    /**
     * Returns true if a sequence generator has been assigned to this attribute, false otherwise.
     * @return (boolean)handleIsGeneratorTypeSequence()
     */
    public final boolean isGeneratorTypeSequence()
    {
        boolean generatorTypeSequence16a = this.__generatorTypeSequence16a;
        if (!this.__generatorTypeSequence16aSet)
        {
            // generatorTypeSequence has no pre constraints
            generatorTypeSequence16a = handleIsGeneratorTypeSequence();
            // generatorTypeSequence has no post constraints
            this.__generatorTypeSequence16a = generatorTypeSequence16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__generatorTypeSequence16aSet = true;
            }
        }
        return generatorTypeSequence16a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#isGeneratorTypeTable()
    * @return boolean
    */
    protected abstract boolean handleIsGeneratorTypeTable();

    private boolean __generatorTypeTable17a;
    private boolean __generatorTypeTable17aSet = false;

    /**
     * Returns true if a table generator has been assigned to this attribute, false otherwise.
     * @return (boolean)handleIsGeneratorTypeTable()
     */
    public final boolean isGeneratorTypeTable()
    {
        boolean generatorTypeTable17a = this.__generatorTypeTable17a;
        if (!this.__generatorTypeTable17aSet)
        {
            // generatorTypeTable has no pre constraints
            generatorTypeTable17a = handleIsGeneratorTypeTable();
            // generatorTypeTable has no post constraints
            this.__generatorTypeTable17a = generatorTypeTable17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__generatorTypeTable17aSet = true;
            }
        }
        return generatorTypeTable17a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#isGeneratorTypeAuto()
    * @return boolean
    */
    protected abstract boolean handleIsGeneratorTypeAuto();

    private boolean __generatorTypeAuto18a;
    private boolean __generatorTypeAuto18aSet = false;

    /**
     * Returns true if an auto generator has been assigned to this attribute, false otherwise.
     * @return (boolean)handleIsGeneratorTypeAuto()
     */
    public final boolean isGeneratorTypeAuto()
    {
        boolean generatorTypeAuto18a = this.__generatorTypeAuto18a;
        if (!this.__generatorTypeAuto18aSet)
        {
            // generatorTypeAuto has no pre constraints
            generatorTypeAuto18a = handleIsGeneratorTypeAuto();
            // generatorTypeAuto has no post constraints
            this.__generatorTypeAuto18a = generatorTypeAuto18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__generatorTypeAuto18aSet = true;
            }
        }
        return generatorTypeAuto18a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#isGeneratorTypeNone()
    * @return boolean
    */
    protected abstract boolean handleIsGeneratorTypeNone();

    private boolean __generatorTypeNone19a;
    private boolean __generatorTypeNone19aSet = false;

    /**
     * Returns true no generator has been assigned to this attribute, false otherwise.
     * @return (boolean)handleIsGeneratorTypeNone()
     */
    public final boolean isGeneratorTypeNone()
    {
        boolean generatorTypeNone19a = this.__generatorTypeNone19a;
        if (!this.__generatorTypeNone19aSet)
        {
            // generatorTypeNone has no pre constraints
            generatorTypeNone19a = handleIsGeneratorTypeNone();
            // generatorTypeNone has no post constraints
            this.__generatorTypeNone19a = generatorTypeNone19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__generatorTypeNone19aSet = true;
            }
        }
        return generatorTypeNone19a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#isGeneratorTypeIdentity()
    * @return boolean
    */
    protected abstract boolean handleIsGeneratorTypeIdentity();

    private boolean __generatorTypeIdentity20a;
    private boolean __generatorTypeIdentity20aSet = false;

    /**
     * Returns true if an identity generator has been assigned to this attribute, false otherwise.
     * @return (boolean)handleIsGeneratorTypeIdentity()
     */
    public final boolean isGeneratorTypeIdentity()
    {
        boolean generatorTypeIdentity20a = this.__generatorTypeIdentity20a;
        if (!this.__generatorTypeIdentity20aSet)
        {
            // generatorTypeIdentity has no pre constraints
            generatorTypeIdentity20a = handleIsGeneratorTypeIdentity();
            // generatorTypeIdentity has no post constraints
            this.__generatorTypeIdentity20a = generatorTypeIdentity20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__generatorTypeIdentity20aSet = true;
            }
        }
        return generatorTypeIdentity20a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#getTemporalType()
    * @return String
    */
    protected abstract String handleGetTemporalType();

    private String __temporalType21a;
    private boolean __temporalType21aSet = false;

    /**
     * Returns the temporal type value set via tagged value on attribute if one exists.  Expect one
     * of DATE, TIME, TIMESTAMP or NONE.  This can only be applied to attributes of type
     * java.util.Date or java.util.Calendar.
     * @return (String)handleGetTemporalType()
     */
    public final String getTemporalType()
    {
        String temporalType21a = this.__temporalType21a;
        if (!this.__temporalType21aSet)
        {
            // temporalType has no pre constraints
            temporalType21a = handleGetTemporalType();
            // temporalType has no post constraints
            this.__temporalType21a = temporalType21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__temporalType21aSet = true;
            }
        }
        return temporalType21a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#getEnumerationType()
    * @return String
    */
    protected abstract String handleGetEnumerationType();

    private String __enumerationType22a;
    private boolean __enumerationType22aSet = false;

    /**
     * Returns the persistent property/field enumeration type.  Will return either ORDINAL for enums
     * mapped as an integer or STRING for enums mapped as a string.  If not specified on an
     * enumerated type, then the ORDINAL type is assumed
     * @return (String)handleGetEnumerationType()
     */
    public final String getEnumerationType()
    {
        String enumerationType22a = this.__enumerationType22a;
        if (!this.__enumerationType22aSet)
        {
            // enumerationType has no pre constraints
            enumerationType22a = handleGetEnumerationType();
            // enumerationType has no post constraints
            this.__enumerationType22a = enumerationType22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__enumerationType22aSet = true;
            }
        }
        return enumerationType22a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#isInsertEnabled()
    * @return boolean
    */
    protected abstract boolean handleIsInsertEnabled();

    private boolean __insertEnabled23a;
    private boolean __insertEnabled23aSet = false;

    /**
     * Specifies whether a mapped column should be included in SQL INSERT statements.
     * @return (boolean)handleIsInsertEnabled()
     */
    public final boolean isInsertEnabled()
    {
        boolean insertEnabled23a = this.__insertEnabled23a;
        if (!this.__insertEnabled23aSet)
        {
            // insertEnabled has no pre constraints
            insertEnabled23a = handleIsInsertEnabled();
            // insertEnabled has no post constraints
            this.__insertEnabled23a = insertEnabled23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__insertEnabled23aSet = true;
            }
        }
        return insertEnabled23a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#isUpdateEnabled()
    * @return boolean
    */
    protected abstract boolean handleIsUpdateEnabled();

    private boolean __updateEnabled24a;
    private boolean __updateEnabled24aSet = false;

    /**
     * Specifies whether a mapped column should be included in SQL UPDATE statements.
     * @return (boolean)handleIsUpdateEnabled()
     */
    public final boolean isUpdateEnabled()
    {
        boolean updateEnabled24a = this.__updateEnabled24a;
        if (!this.__updateEnabled24aSet)
        {
            // updateEnabled has no pre constraints
            updateEnabled24a = handleIsUpdateEnabled();
            // updateEnabled has no post constraints
            this.__updateEnabled24a = updateEnabled24a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__updateEnabled24aSet = true;
            }
        }
        return updateEnabled24a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#getLobType()
    * @return String
    */
    protected abstract String handleGetLobType();

    private String __lobType25a;
    private boolean __lobType25aSet = false;

    /**
     * Returns the user overriden lob type for this property.  This is set via tagged value
     * andromda_persistence_lob_type.  Default values are String for Clob and byte[] for Blob.
     * @return (String)handleGetLobType()
     */
    public final String getLobType()
    {
        String lobType25a = this.__lobType25a;
        if (!this.__lobType25aSet)
        {
            // lobType has no pre constraints
            lobType25a = handleGetLobType();
            // lobType has no post constraints
            this.__lobType25a = lobType25a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__lobType25aSet = true;
            }
        }
        return lobType25a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#isContainsEmbeddedObject()
    * @return boolean
    */
    protected abstract boolean handleIsContainsEmbeddedObject();

    private boolean __containsEmbeddedObject26a;
    private boolean __containsEmbeddedObject26aSet = false;

    /**
     * Returns true if this attribute's type is an embedded value object.
     * @return (boolean)handleIsContainsEmbeddedObject()
     */
    public final boolean isContainsEmbeddedObject()
    {
        boolean containsEmbeddedObject26a = this.__containsEmbeddedObject26a;
        if (!this.__containsEmbeddedObject26aSet)
        {
            // containsEmbeddedObject has no pre constraints
            containsEmbeddedObject26a = handleIsContainsEmbeddedObject();
            // containsEmbeddedObject has no post constraints
            this.__containsEmbeddedObject26a = containsEmbeddedObject26a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__containsEmbeddedObject26aSet = true;
            }
        }
        return containsEmbeddedObject26a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#isGeneratorTypeGeneric()
    * @return boolean
    */
    protected abstract boolean handleIsGeneratorTypeGeneric();

    private boolean __generatorTypeGeneric27a;
    private boolean __generatorTypeGeneric27aSet = false;

    /**
     * Returns true if a generic generator has been assigned to this attribute, false otherwise.
     * @return (boolean)handleIsGeneratorTypeGeneric()
     */
    public final boolean isGeneratorTypeGeneric()
    {
        boolean generatorTypeGeneric27a = this.__generatorTypeGeneric27a;
        if (!this.__generatorTypeGeneric27aSet)
        {
            // generatorTypeGeneric has no pre constraints
            generatorTypeGeneric27a = handleIsGeneratorTypeGeneric();
            // generatorTypeGeneric has no post constraints
            this.__generatorTypeGeneric27a = generatorTypeGeneric27a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__generatorTypeGeneric27aSet = true;
            }
        }
        return generatorTypeGeneric27a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#getGeneratorGenericStrategy()
    * @return String
    */
    protected abstract String handleGetGeneratorGenericStrategy();

    private String __generatorGenericStrategy28a;
    private boolean __generatorGenericStrategy28aSet = false;

    /**
     * Returns the org.hibernate.annotations.GenericGenerator strategy either a predefined Hibernate
     * strategy or a fully qualified class name.
     * @return (String)handleGetGeneratorGenericStrategy()
     */
    public final String getGeneratorGenericStrategy()
    {
        String generatorGenericStrategy28a = this.__generatorGenericStrategy28a;
        if (!this.__generatorGenericStrategy28aSet)
        {
            // generatorGenericStrategy has no pre constraints
            generatorGenericStrategy28a = handleGetGeneratorGenericStrategy();
            // generatorGenericStrategy has no post constraints
            this.__generatorGenericStrategy28a = generatorGenericStrategy28a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__generatorGenericStrategy28aSet = true;
            }
        }
        return generatorGenericStrategy28a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#isColumnEmptyable()
    * @return boolean
    */
    protected abstract boolean handleIsColumnEmptyable();

    private boolean __columnEmptyable29a;
    private boolean __columnEmptyable29aSet = false;

    /**
     * Whether the column can be empty.  False for identifier and unique fields.  If
     * andromda_persistence_column_emptyable tag is set, the tagged value is used.  Otherwise,
     * determine if this attribute is required from the multiplicity set on the attribute.
     * @return (boolean)handleIsColumnEmptyable()
     */
    public final boolean isColumnEmptyable()
    {
        boolean columnEmptyable29a = this.__columnEmptyable29a;
        if (!this.__columnEmptyable29aSet)
        {
            // columnEmptyable has no pre constraints
            columnEmptyable29a = handleIsColumnEmptyable();
            // columnEmptyable has no post constraints
            this.__columnEmptyable29a = columnEmptyable29a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__columnEmptyable29aSet = true;
            }
        }
        return columnEmptyable29a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#isColumnEmailable()
    * @return boolean
    */
    protected abstract boolean handleIsColumnEmailable();

    private boolean __columnEmailable30a;
    private boolean __columnEmailable30aSet = false;

    /**
     * Whether the column can be an email.  If andromda_persistence_column_emailable tag is set, the
     * tagged value is used.
     * @return (boolean)handleIsColumnEmailable()
     */
    public final boolean isColumnEmailable()
    {
        boolean columnEmailable30a = this.__columnEmailable30a;
        if (!this.__columnEmailable30aSet)
        {
            // columnEmailable has no pre constraints
            columnEmailable30a = handleIsColumnEmailable();
            // columnEmailable has no post constraints
            this.__columnEmailable30a = columnEmailable30a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__columnEmailable30aSet = true;
            }
        }
        return columnEmailable30a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#getColumnPatternable()
    * @return String
    */
    protected abstract String handleGetColumnPatternable();

    private String __columnPatternable31a;
    private boolean __columnPatternable31aSet = false;

    /**
     * Whether the column can have a validation pattern. If andromda_validation_pattern tag is set,
     * the tagged value is used.
     * @return (String)handleGetColumnPatternable()
     */
    public final String getColumnPatternable()
    {
        String columnPatternable31a = this.__columnPatternable31a;
        if (!this.__columnPatternable31aSet)
        {
            // columnPatternable has no pre constraints
            columnPatternable31a = handleGetColumnPatternable();
            // columnPatternable has no post constraints
            this.__columnPatternable31a = columnPatternable31a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__columnPatternable31aSet = true;
            }
        }
        return columnPatternable31a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade#getColumnMinLength()
    * @return String
    */
    protected abstract String handleGetColumnMinLength();

    private String __columnMinLength32a;
    private boolean __columnMinLength32aSet = false;

    /**
     * Whether the column can have a validation on minimum length. If andromda_validation_minLength
     * tag is set, the tagged value is used.
     * @return (String)handleGetColumnMinLength()
     */
    public final String getColumnMinLength()
    {
        String columnMinLength32a = this.__columnMinLength32a;
        if (!this.__columnMinLength32aSet)
        {
            // columnMinLength has no pre constraints
            columnMinLength32a = handleGetColumnMinLength();
            // columnMinLength has no post constraints
            this.__columnMinLength32a = columnMinLength32a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__columnMinLength32aSet = true;
            }
        }
        return columnMinLength32a;
    }

    // ------------- associations ------------------

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
    public Collection findTaggedValues(String tagName)
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
    public Collection getConstraints(String kind)
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
     * 
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
     * The language mappings that have been set for this model elemnt.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperEntityAttribute().getLanguageMappings();
    }

    /**
     * 
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
     * 
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
     * 
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperEntityAttribute().getTemplateParameter(parameterName);
    }

    /**
     * 
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
     * 
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
     * 
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperEntityAttribute().isTemplateParametersPresent();
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
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperEntityAttribute().initialize();
    }

    /**
     * @return Object getSuperEntityAttribute().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperEntityAttribute().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperEntityAttribute().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperEntityAttribute().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
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
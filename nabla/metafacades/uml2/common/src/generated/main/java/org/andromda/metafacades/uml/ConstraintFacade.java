// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * Condition or restriction expressed in natural language text or in a machine readable language for
 * the purpose of declaring some of the semantics of an element.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface ConstraintFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isConstraintFacadeMetaType();

    /**
     * Gets the 'body' or text of this constraint.
     * @return String
     */
    public String getBody();

    /**
     * Gets the model element to which the constraint applies (i.e. is the context of).
     * @return ModelElementFacade
     */
    public ModelElementFacade getContextElement();

    /**
     * This constraint's translation for the argument languange.
     * @param language String
     * @return String
     */
    public String getTranslation(String language);

    /**
     * True if this constraint denotes a body expression.
     * For example:
     * <pre>
     * context CustomerCard:getTransaction(from:Date, until:Date)
     * body: transactions->select(date.isAfter(from) and date.isBefore(until))
     * </pre>
     * False otherwise.
     * @return boolean
     */
    public boolean isBodyExpression();

    /**
     * True if this constraint denotes a definition.
     * For example:
     * <pre>
     * context CustomerCard
     * def: getTotalPoints(d: date) : Integer = transaction->select(date.isAfter(d)).points->sum()
     * </pre>
     * False otherwise.
     * @return boolean
     */
    public boolean isDefinition();

    /**
     * True if this constraint denotes an invariant.
     * For example:
     * <pre>
     * context LivingAnimal
     * inv: alive = true
     * </pre>
     * False otherwise.
     * @return boolean
     */
    public boolean isInvariant();

    /**
     * True if this constraint denotes a postcondition.
     * For example:
     * <pre>
     * context LivingAnimal::getNumberOfLegs()
     * post: numberOfLegs >= 0
     * </pre>
     * False otherwise.
     * @return boolean
     */
    public boolean isPostCondition();

    /**
     * True if this constraint denotes a precondition.
     * For example:
     * <pre>
     * context LivingAnimal::canFly()
     * pre: hasWings = true
     * </pre>
     * False otherwise.
     * @return boolean
     */
    public boolean isPreCondition();
}
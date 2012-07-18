/*
 * Copyright (c) 2002-2004, Nabla
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Nabla' nor 'Alban' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package com.nabla.project.foobar;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Currency;

/**
 * Represent an amount of money in any currency.
 *
 * <P>This class assumes <em>decimal currency</em>, without funky divisions
 * like 1/5 and so on. <tt>Money</tt> objects are immutable. Like {@link BigDecimal},
 * many operations return new <tt>Money</tt> objects. In addition, most operations
 * involving more than one <tt>Money</tt> object will throw a
 * <tt>MismatchedCurrencyException</tt> if the currencies don't match.
 *
 * <h2>Decimal Places and Scale</h2>
 * Monetary amounts can be stored in the database in various ways. Let's take the
 * example of dollars. It may appear in the database in the following ways :
 * <ul>
 *  <li>as <tt>123456.78</tt>, with the usual number of decimal places
 *    associated with that currency.
 *  <li>as <tt>123456</tt>, without any decimal places at all.
 *  <li>as <tt>123</tt>, in units of thousands of dollars.
 *  <li>in some other unit, such as millions or billions of dollars.
 * </ul>
 *
 * <P>The number of decimal places or style of units is referred to as the
 * <em>scale</em> by {@link java.math.BigDecimal}. This class's constructors
 * take a <tt>BigDecimal</tt>, so you need to understand it use of the idea of scale.
 *
 * <P>The scale can be negative. Using the above examples :
 * <table border='1' cellspacing='0' cellpadding='3'>
 *  <tr><th>Number</th><th>Scale</th></tr>
 *  <tr><td><th>123456.78</th><th>2</th></tr>
 *  <tr><td><th>123456</th><th>0</th></tr>
 *  <tr><td><th>123 (thousands)</th><th>-3</th></tr>
 * </table>
 *
 * <P>Note that scale and rounding are two separate issues.
 * In addition, rounding is only necessary for multiplication and division operations.
 * It doesn't apply to addition and subtraction.
 *
 * <h2>Operations and Scale</h2>
 * <P>Operations can be performed on items having <em>different scale</em>.
 * For example, these  operations are valid (using an <em>ad hoc</em>
 * symbolic notation):
 * <PRE>
 * 10.plus(1.23) => 11.23
 * 10.minus(1.23) => 8.77
 * 10.gt(1.23) => true
 * 10.eq(10.00) => true
 * </PRE>
 * This corresponds to typical user expectations.
 * An important exception to this rule is that {@link #equals(Object)} is sensitive
 * to scale (while {@link #eq(Money)} is not) . That is,
 * <PRE>
 *   10.equals(10.00) => false
 * </PRE>
 *
 * <h2>Multiplication, Division and Extra Decimal Places</h2>
 * <P>Operations involving multiplication and division are different, since the result
 * can have a scale which exceeds that expected for the given currency. For example
 * <PRE>($10.00).times(0.1256) => $1.256</PRE>
 * which has more than two decimals. In such cases, <em>this class will always round
 * to the expected number of decimal places for that currency.</em>
 * This is the simplest policy, and likely conforms to the expectations of most
 * end users.
 *
 * <P>This class takes either an <tt>int</tt> or a {@link BigDecimal} for its
 * multiplication and division methods. It doesn't take <tt>float</tt> or
 * <tt>double</tt> for those methods, since those types don't interact well with
 * <tt>BigDecimal</tt>. Instead, the <tt>BigDecimal</tt> class must be used when the
 * factor or divisor is a non-integer.
 *
 * <P><em>The {@link #init(Currency, RoundingMode)} method must be called at least
 * once before using the other members of this class.</em> It establishes your
 * desired defaults. Typically, it will be called once (and only once) upon startup.
 *
 * <P>Various methods in this class have unusually terse names, such as
 * {@link #lt} and {@link #gt}. The intent is that such names will improve the
 * legibility of mathematical expressions. Example :
 * <PRE> if ( amount.lt(hundred) ) {
 *     cost = amount.times(price);
 *  }</PRE>
 */
public final class Money implements Comparable<Money>, Serializable
{

    /**
     * Thrown when a set of <tt>Money</tt> objects do not have matching currencies.
     *
     * <P>For example, adding together Euros and Dollars does not make any sense.
     */
    public static final class MismatchedCurrencyException extends RuntimeException
    {

        private static final long serialVersionUID = 1L;

        /**
         *
         * Constructor.
         *
         * @param aMessage a message
         */
        MismatchedCurrencyException(final String aMessage)
        {
            super(aMessage);
        }
    }

    /**
     * Set default values for currency and rounding style.
     *
     * <em>Your application must call this method upon startup</em>.
     * This method should usually be called only once (upon startup).
     *
     * <P>The recommended rounding style is {@link RoundingMode#HALF_EVEN}, also called
     * <em>banker's rounding</em>; this rounding style introduces the least bias.
     *
     * <P>Setting these defaults allow you to use the more terse constructors of this class,
     * which are much more convenient.
     *
     * <P>(In a servlet environment, each app has its own classloader. Calling this
     * method in one app will never affect the operation of a second app running in the same
     * servlet container. They are independent.)
     *
     * @param aDefaultCurrency is required.
     * @param aDefaultRounding is required.
     */
    public static void init(final Currency aDefaultCurrency, final RoundingMode aDefaultRounding)
    {
        Money.defaultCurrency = aDefaultCurrency;
        Money.defaultRounding = aDefaultRounding;
    }

    /**
     * Full constructor.
     *
     * @param aAmount is required, can be positive or negative. The number of
     * decimals in the amount cannot <em>exceed</em> the maximum number of
     * decimals for the given {@link Currency}. It's possible to create a
     * <tt>Money</tt> object in terms of 'thousands of dollars', for instance.
     * Such an amount would have a scale of -3.
     * @param aCurrency is required.
     * @param aRoundingStyle is required, must match a rounding style used by
     * {@link BigDecimal}.
     */
    public Money(final BigDecimal aAmount, final Currency aCurrency, final RoundingMode aRoundingStyle)
    {
        this.fAmount = aAmount;
        this.fCurrency = aCurrency;
        this.fRounding = aRoundingStyle;
        this.validateState();
    }

    /**
     * Constructor taking only the money amount.
     *
     * <P>The currency and rounding style both take default values.
     * @param aAmount is required, can be positive or negative.
     */
    public Money(final BigDecimal aAmount)
    {
        this(aAmount, Money.defaultCurrency, Money.defaultRounding);
    }

    /**
     * Constructor taking the money amount and currency.
     *
     * <P>The rounding style takes a default value.
     * @param aAmount is required, can be positive or negative.
     * @param aCurrency is required.
     */
    public Money(final BigDecimal aAmount, final Currency aCurrency)
    {
        this(aAmount, aCurrency, Money.defaultRounding);
    }

    /** @return Return the amount passed to the constructor. */
    public BigDecimal getAmount()
    {
        return this.fAmount;
    }

    /** @return Return the currency passed to the constructor, or the default currency. */
    public Currency getCurrency()
    {
        return this.fCurrency;
    }

    /** @return Return the rounding style passed to the constructor, or the default rounding style. */
    public RoundingMode getRoundingStyle()
    {
        return this.fRounding;
    }

    /**
     *
     * @param aThat a money
     *
     * @return Return <tt>true</tt> only if <tt>aThat</tt> <tt>Money</tt> has the same currency
     * as this <tt>Money</tt>.
     */
    public boolean isSameCurrencyAs(final Money aThat)
    {
        boolean result = false;
        if (aThat != null)
        {
            result = this.fCurrency.equals(aThat.fCurrency);
        }
        return result;
    }

    /** @return Return <tt>true</tt> only if the amount is positive. */
    public boolean isPlus()
    {
        return this.fAmount.compareTo(BigDecimal.ZERO) > 0;
    }

    /** @return Return <tt>true</tt> only if the amount is negative. */
    public boolean isMinus()
    {
        return this.fAmount.compareTo(BigDecimal.ZERO) < 0;
    }

    /** @return Return <tt>true</tt> only if the amount is zero. */
    public boolean isZero()
    {
        return this.fAmount.compareTo(BigDecimal.ZERO) == 0;
    }

    /**
     * Add <tt>aThat</tt> <tt>Money</tt> to this <tt>Money</tt>.
     * Currencies must match.
     *
     * @param aThat a money
     *
     * @return a money
     */
    public Money plus(final Money aThat)
    {
        this.checkCurrenciesMatch(aThat);
        return new Money(this.fAmount.add(aThat.fAmount), this.fCurrency, this.fRounding);
    }

    /**
     * Subtract <tt>aThat</tt> <tt>Money</tt> from this <tt>Money</tt>.
     * Currencies must match.
     *
     * @param aThat a money
     *
     * @return a money
     */
    public Money minus(final Money aThat)
    {
        this.checkCurrenciesMatch(aThat);
        return new Money(this.fAmount.subtract(aThat.fAmount), this.fCurrency, this.fRounding);
    }

    /**
     * Sum a collection of <tt>Money</tt> objects.
     * Currencies must match. You are encouraged to use database summary functions
     * whenever possible, instead of this method.
     *
     * @param aMoneys collection of <tt>Money</tt> objects, all of the same currency.
     * If the collection is empty, then a zero value is returned.
     * @param aCurrencyIfEmpty is used only when <tt>aMoneys</tt> is empty; that way, this
     * method can return a zero amount in the desired currency.
     *
     * @return a money
     */
    public static Money sum(final Collection<Money> aMoneys, final Currency aCurrencyIfEmpty)
    {
        Money sum = new Money(BigDecimal.ZERO, aCurrencyIfEmpty);
        for (final Money money : aMoneys)
        {
            sum = sum.plus(money);
        }
        return sum;
    }

    /**
     * Equals (insensitive to scale).
     *
     * @param aThat a money
     *
     * @return Return <tt>true</tt> only if the amounts are equal.
     * Currencies must match.
     * This method is <em>not</em> synonymous with the <tt>equals</tt> method.
     */
    public boolean eq(final Money aThat)
    {
        this.checkCurrenciesMatch(aThat);
        return this.compareAmount(aThat) == 0;
    }

    /**
     * Greater than.
     *
     * @param aThat a money
     *
     * @return Return <tt>true</tt> only if  'this' amount is greater than
     * 'that' amount. Currencies must match.
     */
    public boolean gt(final Money aThat)
    {
        this.checkCurrenciesMatch(aThat);
        return this.compareAmount(aThat) > 0;
    }

    /**
     * Greater than or equal to.
     *
     * @param aThat a money
     *
     * @return Return <tt>true</tt> only if 'this' amount is
     * greater than or equal to 'that' amount. Currencies must match.
     */
    public boolean gteq(final Money aThat)
    {
        this.checkCurrenciesMatch(aThat);
        return this.compareAmount(aThat) >= 0;
    }

    /**
     * Less than.
     *
     * @param aThat a money
     *
     * @return Return <tt>true</tt> only if 'this' amount is less than
     * 'that' amount. Currencies must match.
     */
    public boolean lt(final Money aThat)
    {
        this.checkCurrenciesMatch(aThat);
        return this.compareAmount(aThat) < 0;
    }

    /**
     * Less than or equal to.
     *
     * @param aThat a money
     *
     * @return Return <tt>true</tt> only if 'this' amount is less than or equal to
     * 'that' amount. Currencies must match.
     */
    public boolean lteq(final Money aThat)
    {
        this.checkCurrenciesMatch(aThat);
        return this.compareAmount(aThat) <= 0;
    }

    /**
     * Multiply this <tt>Money</tt> by an integral factor.
     *
     * The scale of the returned <tt>Money</tt> is equal to the scale of 'this'
     * <tt>Money</tt>.
     *
     * @param aFactor a factor
     *
     * @return a money
     */
    public Money times(final int aFactor)
    {
        final BigDecimal factor = new BigDecimal(aFactor);
        final BigDecimal newAmount = this.fAmount.multiply(factor);
        return new Money(newAmount, this.fCurrency, this.fRounding);
    }

    /**
     * Multiply this <tt>Money</tt> by an non-integral factor (having a decimal point).
     *
     * <P>The scale of the returned <tt>Money</tt> is equal to the scale of
     * 'this' <tt>Money</tt>.
     *
     * @param aFactor a factor
     *
     * @return a money
     */
    public Money times(final double aFactor)
    {
        BigDecimal newAmount = this.fAmount.multiply(this.asBigDecimal(aFactor));
        newAmount = newAmount.setScale(this.getNumDecimalsForCurrency(), this.fRounding);
        return new Money(newAmount, this.fCurrency, this.fRounding);
    }

    /**
     * Divide this <tt>Money</tt> by an integral divisor.
     *
     * <P>The scale of the returned <tt>Money</tt> is equal to the scale of
     * 'this' <tt>Money</tt>.
     *
     * @param aDivisor a divisor
     *
     * @return a money
     */
    public Money div(final int aDivisor)
    {
        final BigDecimal divisor = new BigDecimal(aDivisor);
        final BigDecimal newAmount = this.fAmount.divide(divisor, this.fRounding);
        return new Money(newAmount, this.fCurrency, this.fRounding);
    }

    /**
     * Divide this <tt>Money</tt> by an non-integral divisor.
     *
     * <P>The scale of the returned <tt>Money</tt> is equal to the scale of
     * 'this' <tt>Money</tt>.
     *
     * @param aDivisor a divisor
     *
     * @return a money
     */
    public Money div(final double aDivisor)
    {
        final BigDecimal newAmount = this.fAmount.divide(this.asBigDecimal(aDivisor), this.fRounding);
        return new Money(newAmount, this.fCurrency, this.fRounding);
    }

    /** @return Return the absolute value of the amount. */
    public Money abs()
    {
        return this.isPlus() ? this : this.times(-1);
    }

    /** @return Return the amount x (-1). */
    public Money negate()
    {
        return this.times(-1);
    }

    /**
     * @return Returns {@link #getAmount()}.getPlainString() + space + {@link #getCurrency()}.getSymbol().
     *
     * <P>The return value uses the runtime's <em>default locale</em>, and will not
     * always be suitable for display to an end user.
     */
    @Override
    public String toString()
    {
        return this.fAmount.toPlainString() + " " + this.fCurrency.getSymbol();
    }

    /**
     * Like {@link BigDecimal#equals(java.lang.Object)}, this <tt>equals</tt> method is also sensitive to scale.
     *
     * For example, <tt>10</tt> is <em>not</em> equal to <tt>10.00</tt> The {@link #eq(Money)} method, on
     * the other hand, is <em>not</em> sensitive to scale.
     *
     * @param aThat an object
     *
     * @return true or false
     */
    @Override
    public boolean equals(final Object aThat)
    {
        if (this == aThat)
        {
            return true;
        }
        if (!(aThat instanceof Money))
        {
            return false;
        }
        final Money that = (Money) aThat;
        // the object fields are never null :
        boolean result = (this.fAmount.equals(that.fAmount));
        result = result && (this.fCurrency.equals(that.fCurrency));
        result = result && (this.fRounding == that.fRounding);
        return result;
    }

    @Override
    public int hashCode()
    {
        if (this.fHashCode == 0)
        {
            this.fHashCode = Money.HASH_SEED;
            this.fHashCode = (Money.HASH_FACTOR * this.fHashCode) + this.fAmount.hashCode();
            this.fHashCode = (Money.HASH_FACTOR * this.fHashCode) + this.fCurrency.hashCode();
            this.fHashCode = (Money.HASH_FACTOR * this.fHashCode) + this.fRounding.hashCode();
        }
        return this.fHashCode;
    }

    /**
     * compareTo method.
     *
     * @param aThat a money
     *
     * @return an int
     */
    @Override
    public int compareTo(final Money aThat)
    {

        if (this == aThat)
        {
            return 0;
        }

        // the object fields are never null
        int comparison = this.fAmount.compareTo(aThat.fAmount);
        if (comparison != 0)
        {
            return comparison;
        }

        comparison = this.fCurrency.getCurrencyCode().compareTo(aThat.fCurrency.getCurrencyCode());
        if (comparison != 0)
        {
            return comparison;
        }

        comparison = this.fRounding.compareTo(aThat.fRounding);
        if (comparison != 0)
        {
            return comparison;
        }

        return 0;
    }

    // PRIVATE //

    /**
     * The money amount.
     * Never null.
     * @serial
     */
    private BigDecimal          fAmount;

    /**
     * The currency of the money, such as US Dollars or Euros.
     * Never null.
     * @serial
     */
    private final Currency      fCurrency;

    /**
     * The rounding style to be used.
     * See {@link BigDecimal}.
     * @serial
     */
    private final RoundingMode  fRounding;

    /**
     * The default currency to be used if no currency is passed to the constructor.
     */
    private static Currency     defaultCurrency;

    /**
     * The default rounding style to be used if no currency is passed to the constructor.
     * See {@link BigDecimal}.
     */
    private static RoundingMode defaultRounding;

    /** @serial */
    private int                 fHashCode;
    private static final int    HASH_SEED        = 23;
    private static final int    HASH_FACTOR      = 37;

    /**
     * Determines if a deserialized file is compatible with this class.
     *
     * Maintainers must change this value if and only if the new version
     * of this class is not compatible with old versions. See Sun docs
     * for <a href=http://java.sun.com/products/jdk/1.1/docs/guide
     * /serialization/spec/version.doc.html> details. </a>
     *
     * Not necessary to include in first version of the class, but
     * included here as a reminder of its importance.
     */
    private static final long   serialVersionUID = 7526471155622776147L;

    /**
     * Always treat de-serialization as a full-blown constructor, by validating the final state of the de-serialized object.
     *
     * @param aInputStream an input stream
     *
     * @throws ClassNotFoundException an exception to handle
     * @throws IOException an exception to handle
     */
    private void readObject(final ObjectInputStream aInputStream) throws ClassNotFoundException, IOException
    {
        // always perform the default de-serialization first
        aInputStream.defaultReadObject();
        // defensive copy for mutable date field
        // BigDecimal is not technically immutable, since its non-final
        this.fAmount = new BigDecimal(this.fAmount.toPlainString());
        // ensure that object state has not been corrupted or tampered with maliciously
        this.validateState();
    }

    /**
     * Write current object.
     *
     * @param aOutputStream an output stream
     *
     * @throws IOException an exception to handle
     */
    private void writeObject(final ObjectOutputStream aOutputStream) throws IOException
    {
        // perform the default serialization for all non-transient, non-static fields
        aOutputStream.defaultWriteObject();
    }

    /**
     * Validate immutable data like BigDecimal.
     * It raise the exception IllegalArgumentException when arguments are wrong
     */
    private void validateState()
    {
        if (this.fAmount == null)
        {
            throw new IllegalArgumentException("Amount cannot be null");
        }
        if (this.fCurrency == null)
        {
            throw new IllegalArgumentException("Currency cannot be null");
        }
        if (this.fAmount.scale() > this.getNumDecimalsForCurrency())
        {
            throw new IllegalArgumentException("Number of decimals is " + this.fAmount.scale() + ", but currency only takes " + this.getNumDecimalsForCurrency() + " decimals.");
        }
    }

    /**
     * Get number of decimal for this currency.
     *
     * @return the number of decimal
     */
    private int getNumDecimalsForCurrency()
    {
        return this.fCurrency.getDefaultFractionDigits();
    }

    /**
     * Check the currencies.
     * It raise the exception MismatchedCurrencyException when currency is wrong
     *
     * @param aThat a money
     */
    private void checkCurrenciesMatch(final Money aThat)
    {
        if (!this.fCurrency.equals(aThat.getCurrency()))
        {
            throw new MismatchedCurrencyException(aThat.getCurrency() + " doesn't match the expected currency : " + this.fCurrency);
        }
    }

    /**
     * Ignores scale: 0 same as 0.00.
     *
     * @param aThat a money
     *
     * @return result of compareTo on amount
     */
    private int compareAmount(final Money aThat)
    {
        return this.fAmount.compareTo(aThat.fAmount);
    }

    /**
     * Transform to BigDecimal.
     *
     * @param aDouble a double value
     *
     * @return a BigDecimal
     */
    private BigDecimal asBigDecimal(final double aDouble)
    {
        final String asString = Double.toString(aDouble);
        return new BigDecimal(asString);
    }
}

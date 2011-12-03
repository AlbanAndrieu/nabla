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
package com.sun.j2ee.blueprints.waf.util;

import com.sun.j2ee.blueprints.util.tracer.Debug;

import java.io.ByteArrayOutputStream;

import java.text.BreakIterator;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.util.Locale;
import java.util.Vector;


/**
 * DOCUMENT ME!
 *
 * @author $Author: albandri $
 * @version $Revision: 350 $
 *
 * @since $Date: 2010-09-14 01:50:19 +0200 (mar., 14 sept. 2010) $
 */
public final class I18nUtil extends Object {

    /**
     * DOCUMENT ME!
     *
     * @param target DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String convertJISEncoding(final String target) {

        final ByteArrayOutputStream bos = new ByteArrayOutputStream();

        if (target == null) {

            return null;

        }

        final String paramString = target.trim();

        for (int loop = 0; loop < paramString.length(); loop++) {

            final int i = paramString.charAt(loop);

            bos.write(i);

        }

        String convertedString = null;

        try {

            convertedString = new String(bos.toByteArray(), "JISAutoDetect");

        } catch (final java.io.UnsupportedEncodingException uex) {

        }

        return convertedString;

    }

    /**
     * DOCUMENT ME!
     *
     * @param amount DOCUMENT ME!
     * @param precision DOCUMENT ME!
     * @param pattern DOCUMENT ME!
     * @param locale DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String formatCurrency(final double amount, final int precision, final String pattern, final Locale locale) {

        final NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        final DecimalFormat df = (DecimalFormat) nf;

        df.setMinimumFractionDigits(precision);
        df.setMaximumFractionDigits(precision);
        df.setDecimalSeparatorAlwaysShown(true);
        df.applyPattern(pattern);

        return df.format(amount);

    }

    /**
     * DOCUMENT ME!
     *
     * @param amount DOCUMENT ME!
     * @param precision DOCUMENT ME!
     * @param pattern DOCUMENT ME!
     * @param locale DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String formatNumber(final double amount, final int precision, final String pattern, final Locale locale) {

        final NumberFormat nf = NumberFormat.getNumberInstance(locale);
        final DecimalFormat df = (DecimalFormat) nf;

        df.setMinimumFractionDigits(precision);
        df.setMaximumFractionDigits(precision);
        df.setDecimalSeparatorAlwaysShown(true);
        df.applyPattern(pattern);

        return df.format(amount);

    }

    /**
     * DOCUMENT ME!
     *
     * @param amount DOCUMENT ME!
     * @param precision DOCUMENT ME!
     * @param locale DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String formatCurrency(final double amount, final int precision, final Locale locale) {

        final NumberFormat nf = NumberFormat.getCurrencyInstance(locale);

        nf.setMinimumFractionDigits(precision);
        nf.setMaximumFractionDigits(precision);

        return nf.format(amount);

    }

    /**
     * DOCUMENT ME!
     *
     * @param amount DOCUMENT ME!
     * @param precision DOCUMENT ME!
     * @param locale DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String formatNumber(final double amount, final int precision, final Locale locale) {

        final NumberFormat nf = NumberFormat.getNumberInstance(locale);

        nf.setMinimumFractionDigits(precision);
        nf.setMaximumFractionDigits(precision);

        return nf.format(amount);

    }

    /**
     * DOCUMENT ME!
     *
     * @param keywordString DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static Vector<String> parseKeywords(final String keywordString) {

        if (keywordString != null) {

            final Vector<String> keywords = new Vector<String>();
            final BreakIterator breakIt = BreakIterator.getWordInstance();
            int index = 0;
            int previousIndex = 0;

            breakIt.setText(keywordString);

            try {

                while (index < keywordString.length()) {

                    previousIndex = index;
                    index = breakIt.next();

                    final String word = keywordString.substring(previousIndex, index);

                    if (!word.trim().equals("")) {

                        keywords.addElement(word);

                    }

                }

                return keywords;

            } catch (final Throwable e) {

                Debug.print(e, "Error while parsing search string");

            }

        }

        return null;

    }

    /**
     * DOCUMENT ME!
     *
     * @param keywordString DOCUMENT ME!
     * @param locale DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static Vector<String> parseKeywords(final String keywordString, final Locale locale) {

        if (keywordString != null) {

            final Vector<String> keywords = new Vector<String>();
            final BreakIterator breakIt = BreakIterator.getWordInstance(locale);
            int index = 0;
            int previousIndex = 0;

            breakIt.setText(keywordString);

            try {

                while (index < keywordString.length()) {

                    previousIndex = index;
                    index = breakIt.next();

                    final String word = keywordString.substring(previousIndex, index);

                    if (!word.trim().equals("")) {

                        keywords.addElement(word);

                    }

                }

                return keywords;

            } catch (final Throwable e) {

                Debug.print(e, "Error while parsing search string");

            }

        }

        return null;

    }

    /**
     * DOCUMENT ME!
     *
     * @param localeString DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static Locale getLocaleFromString(final String localeString) {

        if (localeString == null) {

            return null;

        }

        if (localeString.toLowerCase().equals("default")) {

            return Locale.getDefault();

        }

        final int languageIndex = localeString.indexOf('_');

        if (languageIndex == -1) {

            return null;

        }

        int countryIndex = localeString.indexOf('_', languageIndex + 1);
        String country = null;

        if (countryIndex == -1) {

            if (localeString.length() > languageIndex) {

                country = localeString.substring(languageIndex + 1, localeString.length());

            } else {

                return null;

            }

        }

        final int variantIndex = -1;

        if (countryIndex != -1) {

            countryIndex = localeString.indexOf('_', countryIndex + 1);

        }

        final String language = localeString.substring(0, languageIndex);
        String variant = null;

        if (variantIndex != -1) {

            variant = localeString.substring(variantIndex + 1, localeString.length());

        }

        if (variant != null) {

            return new Locale(language, country, variant);

        } else {

            return new Locale(language, country);

        }

    }

}

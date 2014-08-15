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
package com.nabla.project.application.api.config;

import java.io.Serializable;

/**
 * DOCUMENT ME!
 * 
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
 */
public class Condition implements Serializable
{

    private static final long serialVersionUID = 1L;
    private ConditionId       conditionId;
    private String            value;

    /**
     * Creates a new Condition object.
     * 
     * @param conditionId DOCUMENT ME!
     */
    public Condition(ConditionId conditionId)
    {
        this(conditionId, null);

    }

    /**
     * Creates a new Condition object.
     * 
     * @param conditionId DOCUMENT ME!
     * @param parameter DOCUMENT ME!
     */
    public Condition(ConditionId conditionId, String parameter)
    {

        this.conditionId = conditionId;
        this.value = parameter;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public ConditionId getConditionId()
    {

        return conditionId;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param conditionId DOCUMENT ME!
     */
    public void setConditionId(ConditionId conditionId)
    {

        this.conditionId = conditionId;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getValue()
    {

        return value;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param value DOCUMENT ME!
     */
    public void setValue(String value)
    {

        this.value = value;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param o DOCUMENT ME!
     * @return DOCUMENT ME!
     */
    public boolean equals(Object o)
    {

        if (o == null)
        {

            return false;

        }

        if (!(o instanceof Condition))
        {

            return false;

        } else
        {

            Condition comp = (Condition) o;

            return comp.conditionId.equals(this.conditionId) && ((comp.value == null) || comp.value.equals(this.value));

        }

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public int hashCode()
    {

        return this.conditionId.hashCode();

    }

    public enum ConditionId
    {

        MAXROW("MAXROW", "[MAXROW]"), SELECT("SELECT", "[SELECT]"), FROM("FROM", "[FROM]"), WHERE("WHERE", "[WHERE]"), ORDERBY("ORDERBY", "[ORDERBY]"), DATVALMIN("DATVALMIN", "[DATVALMIN]"), DATVALMAX(
                "DATVALMAX",
                "[DATVALMAX]"), TYPEOFDEAL("TYPEOFDEAL", "[typeofdeal]"), FOLDER("FOLDER", "[folder]");

        private String xmlMapping;
        private String sqlValueName;

        /**
         * Creates a new ConditionId object.
         * 
         * @param aXmlMapping DOCUMENT ME!
         */
        ConditionId(String aXmlMapping)
        {
            this(aXmlMapping, null);

        }

        /**
         * Creates a new ConditionId object.
         * 
         * @param aXmlMapping DOCUMENT ME!
         * @param aSqlValueName DOCUMENT ME!
         */
        ConditionId(String aXmlMapping, String aSqlValueName)
        {

            xmlMapping = aXmlMapping;
            sqlValueName = aSqlValueName;

        }

        /**
         * DOCUMENT ME!
         * 
         * @return DOCUMENT ME!
         */
        public String getXmlMapping()
        {

            return xmlMapping;

        }

        /**
         * DOCUMENT ME!
         * 
         * @return DOCUMENT ME!
         */
        public String getSqlValueName()
        {

            return sqlValueName;

        }
    }

}

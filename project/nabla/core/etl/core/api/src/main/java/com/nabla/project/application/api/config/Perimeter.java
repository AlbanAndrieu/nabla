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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * DOCUMENT ME!
 * 
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
 */
public abstract class Perimeter implements Serializable
{

    private static final long     serialVersionUID = 1L;

    private transient Logger      logger           = Logger.getLogger(this.getClass());
    protected Map<String, String> queryParts;
    protected String              sqlQueryById;
    protected Set<Condition>      conditions       = new LinkedHashSet<Condition>();
    protected Set<String>         idList           = new HashSet<String>();
    private Perimeter             subPerimeter;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public Perimeter getSubPerimeter()
    {

        return this.subPerimeter;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param subPerimeter DOCUMENT ME!
     */
    public void setSubPerimeter(final Perimeter subPerimeter)
    {

        this.subPerimeter = subPerimeter;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public Set<Condition> getConditions()
    {

        return this.conditions;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param conditions DOCUMENT ME!
     */
    public void setConditions(final Set<Condition> conditions)
    {

        this.conditions = conditions;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param condition DOCUMENT ME!
     */
    public void addCondition(final Condition condition)
    {

        this.conditions.add(condition);

    }

    /**
     * DOCUMENT ME!
     * 
     * @param condition DOCUMENT ME!
     */
    public void removeCondition(final Condition condition)
    {

        this.conditions.remove(condition);

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public Map<String, String> getQueryParts()
    {

        return this.queryParts;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param queryParts DOCUMENT ME!
     */
    public void setQueryParts(final Map<String, String> queryParts)
    {

        this.queryParts = queryParts;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getSqlQueryById()
    {

        return this.sqlQueryById;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param sqlQueryById DOCUMENT ME!
     */
    public void setSqlQueryById(final String sqlQueryById)
    {

        this.sqlQueryById = sqlQueryById;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public Set<String> getIdList()
    {

        return this.idList;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param idList DOCUMENT ME!
     */
    public void setIdList(final Set<String> idList)
    {

        this.idList = idList;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param id DOCUMENT ME!
     */
    public void addId(final String id)
    {

        if (!this.idList.add(id))
        {

            this.logger.debug("ID already in set");

        }

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public abstract String generateSqlQuery();

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public abstract String generateSqlQueryByIds();

}

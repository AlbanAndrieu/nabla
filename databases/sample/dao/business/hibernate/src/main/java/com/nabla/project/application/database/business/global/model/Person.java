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
package com.nabla.project.application.database.business.global.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.appfuse.model.BaseObject;
import org.compass.annotations.SearchableId;

/**
 * DOCUMENT ME!
 * 
 * @author $Author: albandri $
 * @version $Revision: 358 $
 * @since $Date: 2010-09-16 01:11:04 +0200 (jeu., 16 sept. 2010) $
 */
@Entity
@Table(name = "person", schema = "APP", catalog = "")
public class Person extends BaseObject
{

    private Long   id;
    private String firstName;
    private String lastName;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SearchableId
    public Long getId()
    {

        return this.id;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param id DOCUMENT ME!
     */
    public void setId(final Long id)
    {

        this.id = id;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    @Column(name = "first_name", length = 50)
    public String getFirstName()
    {

        return this.firstName;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param firstName DOCUMENT ME!
     */
    public void setFirstName(final String firstName)
    {

        this.firstName = firstName;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    @Column(name = "last_name", length = 50)
    public String getLastName()
    {

        return this.lastName;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param lastName DOCUMENT ME!
     */
    public void setLastName(final String lastName)
    {

        this.lastName = lastName;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param o DOCUMENT ME!
     * @return DOCUMENT ME!
     */
    @Override
    public boolean equals(final Object o)
    {

        if (this == o)
        {

            return true;

        }

        if ((o == null) || (this.getClass() != o.getClass()))
        {

            return false;

        }

        final Person person = (Person) o;

        if ((this.firstName != null) ? (!this.firstName.equals(person.firstName)) : (person.firstName != null))
        {

            return false;

        }

        if ((this.lastName != null) ? (!this.lastName.equals(person.lastName)) : (person.lastName != null))
        {

            return false;

        }

        return true;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    @Override
    public int hashCode()
    {

        int result;

        result = ((this.firstName != null) ? this.firstName.hashCode() : 0);
        result = (31 * result) + ((this.lastName != null) ? this.lastName.hashCode() : 0);

        return result;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    @Override
    public String toString()
    {

        return "Person{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName + '\'' + '}';

    }

}

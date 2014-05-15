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
package org.andromda.cartridges.gui.metafacades;

import org.andromda.cartridges.gui.GuiProfile;

import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.Entity;
import org.andromda.metafacades.uml.ManageableEntityAssociationEnd;
import org.andromda.metafacades.uml.ManageableEntityAttribute;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.UMLProfile;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * A Validable entity handles Validable stereotype. Its a particular Manageable entity in the way it
 * carries some of the Manageable use cases, overrides some others, and defines specific ones.
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiValidableEntity.
 *
 * @see org.andromda.cartridges.gui.metafacades.GuiValidableEntity
 */
public class GuiValidableEntityLogicImpl extends GuiValidableEntityLogic
{

    private static final long serialVersionUID = 34L;
    private final Logger      logger_          = Logger.getLogger(GuiValidableEntityLogicImpl.class);

    /**
     * Public constructor for GuiValidableEntityLogicImpl
     * @see org.andromda.cartridges.gui.metafacades.GuiValidableEntity
     */
    public GuiValidableEntityLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);

    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    @Override
    public String getName()
    {

        return super.getName() + this.getValidationNameSuffix();

    }

    /**
     *
     * @see org.andromda.cartridges.gui.metafacades.GuiValidableEntity#getValidationNameSuffix()
     */
    @Override
    public String handleGetValidationNameSuffix()
    {

        return "Validation";

    }

    /**
     *
     * @see org.andromda.cartridges.gui.metafacades.GuiValidableEntity#getValidableObjectReferences()
     */
    @Override
    protected List<ModelElementFacade> handleGetValidableObjectReferences()
    {

        final Collection<DependencyFacade> sourceDeps = this.getSourceDependencies();
        final List<ModelElementFacade> boRef = new ArrayList<ModelElementFacade>();

        for (final DependencyFacade dep : sourceDeps)
        {

            if (dep.hasStereotype(GuiProfile.STEREOTYPE_VO_REF))
            {

                boRef.add(dep.getTargetElement());

            }

        }

        return boRef;

    }

    /**
     *
     * @see org.andromda.cartridges.gui.metafacades.GuiValidableEntity#eachValidableObjectReferenceIsValid()
     */
    @Override
    protected boolean handleEachValidableObjectReferenceIsValid()
    {

        final List<Entity> boRefs = this.getValidableObjectReferences();

        for (final Entity classifier : boRefs)
        {

            if (this.getIdentifierForValidableObjectReference(classifier.getName()) == null)
            {

                return false;

            }

            if (classifier.hasStereotype(UMLProfile.STEREOTYPE_ENTITY) && !this.hasValueObject(classifier))
            {

                return false;

            }

        }

        return true;

    }

    /**
     *
     * @see org.andromda.cartridges.gui.metafacades.GuiValidableEntity#getIdentifierForValidableObjectReference(String)
     */
    @Override
    protected String handleGetIdentifierForValidableObjectReference(final String validableObjectName)
    {

        final Collection<DependencyFacade> sourceDeps = this.getSourceDependencies();
        String attributeName = this.getManageableIdentifier().getName();

        // Retrieve referenced Business Object, and the discrimator attribute name
        for (final DependencyFacade dep : sourceDeps)
        {

            if (dep.hasStereotype(GuiProfile.STEREOTYPE_VO_REF) && dep.getTargetElement().getName().equals(validableObjectName))
            {

                final Object filterTag = dep.findTaggedValue(GuiProfile.TAGGEDVALUE_MANAGEABLE_VOREF_DISCRIMINATOR);

                this.logger_.info("GetIdentifierForValidableObjectReference : The tag value is : " + filterTag + " for tag : " + GuiProfile.TAGGEDVALUE_MANAGEABLE_VOREF_DISCRIMINATOR + " - "
                        + this.getFullyQualifiedName());

                if (filterTag != null)
                {

                    if (!"".equals(String.valueOf(filterTag)))
                    {

                        attributeName = String.valueOf(filterTag);

                    }

                }

            }

        }

        this.logger_.info("GetIdentifierForValidableObjectReference : The tag value is : " + attributeName + " for tag : " + GuiProfile.TAGGEDVALUE_MANAGEABLE_VOREF_DISCRIMINATOR + " - " + this.getFullyQualifiedName());

        // Find the corresponding attribute or association
        for (final Iterator<ManageableEntityAttribute> it = this.getManageableAttributes().iterator(); it.hasNext();)
        {

            final AttributeFacade attribute = it.next();

            if (attribute.getName().equals(attributeName))
            {

                return attribute.getName();

            }

        }

        for (final ManageableEntityAssociationEnd assoc : this.getManageableAssociationEnds())
        {

            if (assoc.getName().equals(attributeName))
            {

                return assoc.getName();

            }

        }

        return null;

    }

}

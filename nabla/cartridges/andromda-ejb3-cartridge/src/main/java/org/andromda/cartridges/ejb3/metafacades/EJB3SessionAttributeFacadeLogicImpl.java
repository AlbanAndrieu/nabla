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
package org.andromda.cartridges.ejb3.metafacades;

import java.util.ArrayList;
import java.util.List;
import org.andromda.cartridges.ejb3.EJB3Profile;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.ejb3.metafacades.EJB3SessionAttributeFacade.
 * 
 * @see EJB3SessionAttributeFacade
 */
public class EJB3SessionAttributeFacadeLogicImpl extends EJB3SessionAttributeFacadeLogic
{
    private static final long serialVersionUID = 34L;

    // ---------------- constructor -------------------------------

    /**
     * @param metaObject
     * @param context
     */
    public EJB3SessionAttributeFacadeLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);
    }

    // ---------------- methods -------------------------------

    /**
     * @see EJB3SessionAttributeFacade#getTransactionType()
     */
    @Override
    protected String handleGetTransactionType()
    {
        return (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_EJB_TRANSACTION_TYPE, true);
    }

    /**
     * @see EJB3SessionAttributeFacadeLogic#handleIsSeamAttribute()
     */
    @Override
    protected boolean handleIsSeamAttribute()
    {
        boolean isSeamAttribute = false;
        if (this.isSeamBijectionIn() || this.isSeamBijectionLogger() || this.isSeamBijectionOut() || this.isSeamBijectionRequestParameter() || this.isSeamDataModel() || this.isSeamDataModelSelection())
        {
            isSeamAttribute = true;
        }
        return isSeamAttribute;
    }

    /**
     * @see EJB3SessionAttributeFacadeLogic#handleIsSeamBijectionIn()
     */
    @Override
    protected boolean handleIsSeamBijectionIn()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_SEAM_BIJECTION_IN);
    }

    /**
     * @see EJB3SessionAttributeFacadeLogic#handleGetSeamBijectionInParameters()
     */
    @Override
    protected String handleGetSeamBijectionInParameters()
    {
        List<String> parameters = new ArrayList<String>();
        if (!super.isRequired())
        {
            parameters.add("required = false");
        } else
        {
            if (BooleanUtils.toBoolean((String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_SEAM_BIJECTION_IN_CREATE, true)))
            {
                parameters.add("create = true");
            }
        }
        String value = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_SEAM_BIJECTION_IN_VALUE, true);
        if (StringUtils.isNotBlank(value))
        {
            parameters.add("value = \"" + value + '\"');
        }

        return EJB3MetafacadeUtils.buildAnnotationParameters(parameters);
    }

    /**
     * @see EJB3SessionAttributeFacadeLogic#handleIsSeamBijectionOut()
     */
    @Override
    protected boolean handleIsSeamBijectionOut()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_SEAM_BIJECTION_OUT);
    }

    /**
     * @see EJB3SessionAttributeFacadeLogic#handleGetSeamBijectionOutParameters()
     */
    @Override
    protected String handleGetSeamBijectionOutParameters()
    {
        List<String> parameters = new ArrayList<String>();
        if (!super.isRequired())
        {
            parameters.add("required = false");
        }

        String scope = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_SEAM_BIJECTION_OUT_SCOPE_TYPE, true);
        if (StringUtils.isNotBlank(scope))
        {
            parameters.add("scope = org.jboss.seam.ScopeType." + scope);
        }

        String value = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_SEAM_BIJECTION_OUT_VALUE, true);
        if (StringUtils.isNotBlank(value))
        {
            parameters.add("value = \"" + value + '\"');
        }

        return EJB3MetafacadeUtils.buildAnnotationParameters(parameters);
    }

    /**
     * @see EJB3SessionAttributeFacadeLogic#handleIsSeamValidationValid()
     */
    @Override
    protected boolean handleIsSeamValidationValid()
    {
        boolean isSeamValidComponent = false;
        if (this.hasStereotype(EJB3Profile.STEREOTYPE_SEAM_VALIDATION_VALID))
        {
            isSeamValidComponent = true;
        }
        return isSeamValidComponent;
    }

    /**
     * @see EJB3SessionAttributeFacadeLogic#handleIsSeamDataModel()
     */
    @Override
    protected boolean handleIsSeamDataModel()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_SEAM_DATA_DATAMODEL);
    }

    /**
     * @see EJB3SessionAttributeFacadeLogic#handleGetSeamDataModelParameters()
     */
    @Override
    protected String handleGetSeamDataModelParameters()
    {
        List<String> parameters = new ArrayList<String>();
        String value = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_SEAM_DATA_DATAMODEL_VALUE, true);
        if (StringUtils.isNotBlank(value))
        {
            parameters.add("value = \"" + value + '\"');
        }
        String scope = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_SEAM_DATA_DATAMODEL_SCOPE_TYPE, true);
        if (StringUtils.isNotBlank(scope))
        {
            parameters.add("scope = org.jboss.seam.ScopeType." + scope);
        }

        return EJB3MetafacadeUtils.buildAnnotationParameters(parameters);
    }

    /**
     * @see EJB3SessionAttributeFacadeLogic#handleIsSeamDataModelSelection()
     */
    @Override
    protected boolean handleIsSeamDataModelSelection()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_SEAM_DATA_DATAMODEL_SELECTION);
    }

    /**
     * @see EJB3SessionAttributeFacadeLogic#handleGetSeamDataModelSelectionParameters()
     */
    @Override
    protected String handleGetSeamDataModelSelectionParameters()
    {
        List<String> parameters = new ArrayList<String>();
        String value = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_SEAM_DATA_DATAMODEL_SELECTION_VALUE, true);
        if (StringUtils.isNotBlank(value))
        {
            parameters.add("value = \"" + value + '\"');
        }

        return EJB3MetafacadeUtils.buildAnnotationParameters(parameters);
    }

    /**
     * @see EJB3SessionAttributeFacadeLogic#handleIsSeamDataModelSelection()
     */
    @Override
    protected boolean handleIsSeamDataModelSelectionIndex()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_SEAM_DATA_DATAMODEL_SELECTION_INDEX);
    }

    /**
     * @see EJB3SessionAttributeFacadeLogic#handleGetSeamDataModelSelectionIndexParameters()
     */
    @Override
    protected String handleGetSeamDataModelSelectionIndexParameters()
    {
        List<String> parameters = new ArrayList<String>();
        String value = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_SEAM_DATA_DATAMODEL_SELECTION_INDEX_VALUE, true);
        if (StringUtils.isNotBlank(value))
        {
            parameters.add("value = \"" + value + '\"');
        }

        return EJB3MetafacadeUtils.buildAnnotationParameters(parameters);
    }

    /**
     * @see EJB3SessionAttributeFacadeLogic#handleIsSeamBijectionLogger()
     */
    @Override
    protected boolean handleIsSeamBijectionLogger()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_SEAM_BIJECTION_LOGGER);
    }

    /**
     * @see EJB3SessionAttributeFacadeLogic#handleGetSeamBijectionLoggerParameters()
     */
    @Override
    protected String handleGetSeamBijectionLoggerParameters()
    {
        if (!this.hasStereotype(EJB3Profile.STEREOTYPE_SEAM_BIJECTION_LOGGER))
        {
            return null;
        }
        List<String> parameters = new ArrayList<String>();
        String value = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_SEAM_BIJECTION_LOGGER_VALUE, true);
        if (StringUtils.isNotBlank(value))
        {
            parameters.add("value = \"" + value + '\"');
        }

        return EJB3MetafacadeUtils.buildAnnotationParameters(parameters);
    }

    /**
     * @see EJB3SessionAttributeFacadeLogic#handleIsSeamBijectionRequestParameter()
     */
    @Override
    protected boolean handleIsSeamBijectionRequestParameter()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_SEAM_BIJECTION_REQUEST_PARAMETER);
    }

    /**
     * @see EJB3SessionAttributeFacadeLogic#handleGetSeamBijectionRequestParameterParameters()
     */
    @Override
    protected String handleGetSeamBijectionRequestParameterParameters()
    {
        List<String> parameters = new ArrayList<String>();
        String value = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_SEAM_BIJECTION_REQUEST_PARAMETER_VALUE, true);
        if (StringUtils.isNotBlank(value))
        {
            parameters.add("value = \"" + value + '\"');
        }

        return EJB3MetafacadeUtils.buildAnnotationParameters(parameters);
    }
}

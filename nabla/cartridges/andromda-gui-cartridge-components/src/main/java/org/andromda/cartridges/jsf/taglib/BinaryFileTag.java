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
package org.andromda.cartridges.jsf.taglib;

import org.andromda.cartridges.jsf.component.BinaryFile;
import org.andromda.cartridges.jsf.utils.ComponentUtils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.webapp.UIComponentTag;

/**
 * The tag class for the <code>s:validatorScript</code> tag.
 */
public class BinaryFileTag extends UIComponentTag
{

    /**
     * Sets properties for the component.
     * 
     * @param component The component whose properties we're setting
     */
    @Override
    public void setProperties(final UIComponent component)
    {

        final FacesContext context = this.getFacesContext();

        ComponentUtils.setValueProperty(context, component, this.getValue());
        ComponentUtils.setStringProperty(BinaryFile.FILE_NAME_ATTRIBUTE, context, component, this.getFileName());
        ComponentUtils.setStringProperty(BinaryFile.CONTENT_TYPE_ATTRIBUTE, context, component, this.getContentType());
        ComponentUtils.setBooleanProperty(BinaryFile.PROMPT_ATTRIBUTE, context, component, this.getPrompt());
        super.setProperties(component);

    }

    /**
     * @see javax.faces.webapp.UIComponentTag#getRendererType()
     */
    @Override
    public String getRendererType()
    {

        return BinaryFile.RENDERER_TYPE;

    }

    /**
     * The component type.
     */
    private static final String COMPONENT_TYPE = BinaryFile.COMPONENT_TYPE;

    /**
     * Returns the component type.
     */
    @Override
    public String getComponentType()
    {

        return COMPONENT_TYPE;

    }

    private String value;

    /**
     * Sets the value.
     * 
     * @return Returns the value.
     */
    public String getValue()
    {

        return this.value;

    }

    /**
     * Gets the value.
     * 
     * @param value The value to set.
     */
    public void setValue(String value)
    {

        this.value = value;

    }

    private String fileName;

    /**
     * @return Returns the fileName.
     */
    public String getFileName()
    {

        return this.fileName;

    }

    /**
     * @param fileName The fileName to set.
     */
    public void setFileName(String fileName)
    {

        this.fileName = fileName;

    }

    private String contentType;

    /**
     * @return Returns the contentType.
     */
    public String getContentType()
    {

        return this.contentType;

    }

    /**
     * @param contentType The contentType to set.
     */
    public void setContentType(String contentType)
    {

        this.contentType = contentType;

    }

    private String encoding;

    /**
     * @return Returns the encoding.
     */
    public String getEncoding()
    {

        return this.encoding;

    }

    /**
     * @param encoding The encoding to set.
     */
    public void setEncoding(String encoding)
    {

        this.encoding = encoding;

    }

    private String prompt;

    /**
     * @return Returns the prompt.
     */
    public String getPrompt()
    {

        return this.prompt;

    }

    /**
     * @param prompt The prompt to set.
     */
    public void setPrompt(String prompt)
    {

        this.prompt = prompt;

    }

}

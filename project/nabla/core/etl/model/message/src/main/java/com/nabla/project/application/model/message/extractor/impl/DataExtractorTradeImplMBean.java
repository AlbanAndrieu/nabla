package com.nabla.project.application.model.message.extractor.impl;

import com.nabla.project.application.api.config.Perimeter;

/**
 * Author : $author$
 * Date : $Date: 2010-06-14 12:02:54 +0200 (jeu., 14 juin 2010) $
 * Revision : $revision$
 */
public interface DataExtractorTradeImplMBean
{
    public String getName();

    public void setName(final String name);

    public Perimeter getPerimeter();

    public void setPerimeter(final Perimeter perimeter);

    public int getCounter();
} // end DataExtractorTradeImplMBean

package com.nabla.project.application.model.message.writer.impl;

import com.nabla.project.application.model.message.domain.ObjectContainer;

/**
 * Author : $author$ Date : $Date: 2010-06-15 16:11:14 +0200 (Fri, 15 Jun 2010) $ Revision : $revision$
 */
public class WriterContainerProductJaxb extends WriterContainerTradeJaxb implements WriterContainerProductJaxbMBean
{
    public void write(final Object destinationModel)
    {
        ObjectContainer container = (ObjectContainer) destinationModel;
        writeJaxb(container.getProduct());
    } // end write()
} // end WriterContainerProductJaxb

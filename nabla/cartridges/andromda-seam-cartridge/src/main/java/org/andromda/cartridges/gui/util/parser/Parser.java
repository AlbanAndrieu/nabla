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
package org.andromda.cartridges.gui.util.parser;

import org.andromda.cartridges.gui.util.exception.ParsingException;
import org.andromda.cartridges.gui.util.screensLib.Cell;
import org.andromda.cartridges.gui.util.screensLib.Expandable;
import org.andromda.cartridges.gui.util.screensLib.Expandables;
import org.andromda.cartridges.gui.util.screensLib.Field;
import org.andromda.cartridges.gui.util.screensLib.Fieldline;
import org.andromda.cartridges.gui.util.screensLib.Fieldset;
import org.andromda.cartridges.gui.util.screensLib.Header;
import org.andromda.cartridges.gui.util.screensLib.Item;
import org.andromda.cartridges.gui.util.screensLib.TitleBar;
import org.andromda.cartridges.gui.util.screensLib.ViewContent;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import org.dom4j.io.SAXReader;

import java.net.URL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * DOCUMENT ME!
 * 
 * @author $Author: albandri $
 * @version $Revision: 377 $
 * @since $Date: 2010-10-03 03:28:10 +0200 (dim., 03 oct. 2010) $
 */
public class Parser
{

    private Document     document;
    private List<String> attributesAndAssociations;
    private List<String> invalidAttributes;

    /**
     * Creates a new Parser object.
     * 
     * @param url DOCUMENT ME!
     * @param attributesAndAssociations DOCUMENT ME!
     */
    public Parser(final URL url, final List<String> attributesAndAssociations)
    {

        try
        {

            this.document = this.parse(url);
            this.attributesAndAssociations = attributesAndAssociations;
            this.invalidAttributes = new ArrayList<String>();

        } catch (final DocumentException e)
        {

            e.printStackTrace();

        }

    }

    /**
     * DOCUMENT ME!
     * 
     * @param url DOCUMENT ME!
     * @return DOCUMENT ME!
     * @throws DocumentException DOCUMENT ME!
     */
    public Document parse(final URL url) throws DocumentException
    {

        final SAXReader reader = new SAXReader();
        final Document document = reader.read(url);

        return document;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * @throws DocumentException DOCUMENT ME!
     */
    public ViewContent parse() throws DocumentException
    {

        final Element root = this.document.getRootElement();

        if ((root != null) && root.getName().equals("view_content"))
        {

            final ViewContent view_content = new ViewContent();

            view_content.setHeader(this.header(root));
            view_content.setCells(this.cells(root));

            if (view_content.getCells().size() == 0)
            {

                final List<Field> fields = new ArrayList<Field>();

                for (final Iterator<Element> i = root.elementIterator(); i.hasNext();)
                {

                    final Element element = i.next();

                    if (element.getName().equals("fieldline"))
                    {

                        fields.add(this.fieldline(element));

                    } else if (element.getName().equals("fieldset"))
                    {

                        fields.add(this.fieldset(element));

                    } else if (element.getName().equals("expandable"))
                    {

                        fields.add(this.expandable(element));

                    }

                }

                view_content.setFields(fields);

            }

            return view_content;

        }

        return null;

    }

    @SuppressWarnings("unchecked")
    private Header header(final Element view_content)
    {

        final Element element = view_content.element("header");
        Header header = null;

        if (element != null)
        {

            header = new Header();

            header.setItems(this.control(element.elements()));

        }

        return header;

    }

    private List<Cell> cells(final Element root)
    {

        @SuppressWarnings("unchecked")
        final List<Element> elements = root.elements("cell");

        if (elements.size() > 2)
        {

            try
            {

                throw new ParsingException();

            } catch (final ParsingException e1)
            {

                e1.printStackTrace();

            }

        }

        final List<Cell> cells = new ArrayList<Cell>();

        for (final Object e : elements)
        {

            cells.add(this.cell((Element) e));

        }

        return cells;

    }

    private Cell cell(final Element element)
    {

        final Cell cell = new Cell(element.attributeValue("align"));
        final List<Field> fields = new ArrayList<Field>();

        for (final Iterator<Element> i = element.elementIterator(); i.hasNext();)
        {

            final Element e = i.next();

            if (e.getName().equals("item"))
            {

                fields.add(this.control(e));

            } else if (e.getName().equals("fieldline"))
            {

                fields.add(this.fieldline(e));

            } else if (e.getName().equals("fieldset"))
            {

                fields.add(this.fieldset(e));

            } else if (e.getName().equals("expandables"))
            {

                fields.add(this.expandables(e));

            }

        }

        cell.setFields(fields);

        return cell;

    }

    private Expandables expandables(final Element element)
    {

        final Expandables expandables = new Expandables();

        expandables.setTitle(element.attributeValue("title"));

        final List<Field> fields = new ArrayList<Field>();

        for (final Iterator<Element> i = element.elementIterator(); i.hasNext();)
        {

            final Element e = i.next();

            if (e.getName().equals("expandable"))
            {

                fields.add(this.expandable(e));

            }

        }

        expandables.setFields(fields);

        return expandables;

    }

    private Expandable expandable(final Element element)
    {

        final Expandable expandable = new Expandable();

        expandable.setTitle(element.attributeValue("title"));

        final List<Field> fields = new ArrayList<Field>();

        for (final Iterator<Element> i = element.elementIterator(); i.hasNext();)
        {

            final Element e = i.next();

            if (e.getName().equals("item"))
            {

                fields.add(this.control(e));

            } else if (e.getName().equals("fieldline"))
            {

                fields.add(this.fieldline(e));

            } else if (e.getName().equals("fieldset"))
            {

                fields.add(this.fieldset(e));

            }

        }

        expandable.setFields(fields);

        return expandable;

    }

    private List<Field> control(final List<Field> elements)
    {

        final List<Field> items = new ArrayList<Field>();

        for (final Object e : elements)
        {

            items.add(this.control((Element) e));

        }

        return items;

    }

    private Item control(final Element element)
    {

        final Item item = new Item();

        item.setHidden(element.attributeValue("hidden").equals("true") ? true : false);
        item.setLegend(element.attributeValue("name"));
        item.setLabel((element.attributeValue("label") != null) ? element.attributeValue("label") : "");
        item.setMandatory(element.attributeValue("mandatory").equals("true") ? true : false);
        item.setReadonly(element.attributeValue("readonly").equals("true") ? true : false);

        // TODO: delete (item.getLegend().equals("Related Cfg")) and solution how to
        // add Related Cfg in MailHeaderCfgMore.xml
        if (!this.contains(item.getLegend(), this.attributesAndAssociations) && !(item.getLegend().equals("RelatedHelper")))
        {

            this.invalidAttributes.add(item.getLegend());

        }

        return item;

    }

    private boolean contains(final String name, final List<String> list)
    {

        for (final Object o : list)
        {

            if (((String) o).equals(name))
            {

                return true;

            }

        }

        return false;

    }

    private TitleBar titleBar(final Element element)
    {

        return new TitleBar(element.attributeValue("title"));

    }

    private Fieldline fieldline(final Element element)
    {

        final Fieldline fieldline = new Fieldline();

        final List<Field> fields = new ArrayList<Field>();

        for (final Iterator<Element> i = element.elementIterator(); i.hasNext();)
        {

            final Element e = i.next();

            if (e.getName().equals("item"))
            {

                fields.add(this.control(e));

            } else if (e.getName().equals("fieldset"))
            {

                fields.add(this.fieldset(e));

            } else if (e.getName().equals("titleBar"))
            {

                fields.add(this.titleBar(e));

            } else if (e.getName().equals("fieldline"))
            {

                fields.add(this.fieldline(e));

            }

        }

        fieldline.setItems(fields);

        return fieldline;

    }

    private Fieldset fieldset(final Element element)
    {

        final Fieldset fieldset = new Fieldset();
        final List<Field> fields = new ArrayList<Field>();

        for (final Iterator<Element> i = element.elementIterator(); i.hasNext();)
        {

            final Element e = i.next();

            if (e.getName().equals("item"))
            {

                fields.add(this.control(e));

            } else if (e.getName().equals("fieldline"))
            {

                fields.add(this.fieldline(e));

            } else if (e.getName().equals("fieldset"))
            {

                fields.add(this.fieldset(e));

            } else if (e.getName().equals("titleBar"))
            {

                fields.add(this.titleBar(e));

            }

        }

        fieldset.setLegend(element.attributeValue("legend"));
        fieldset.setFields(fields);

        return fieldset;

    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public List<String> getInvalidAttributes()
    {

        return this.invalidAttributes;

    }

    /**
     * DOCUMENT ME!
     * 
     * @param invalidAttributes DOCUMENT ME!
     */
    public void setInvalidAttributes(final List<String> invalidAttributes)
    {

        this.invalidAttributes = invalidAttributes;

    }

}

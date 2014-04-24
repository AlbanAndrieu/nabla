package com.nabla.project.application.model.message.helpers;

import org.apache.log4j.Logger;

import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.XMLTestCase;

import org.w3c.dom.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author : $author$ Date : $Date: 2010-06-14 12:02:51 +0200 (Thu, 14 Jun 2010) $ Revision : $revision$
 */
public class XmlDiffXPath extends XMLTestCase implements DifferenceListener
{
    protected static Logger logger    = Logger.getLogger(XmlDiffXPath.class);
    protected boolean       diffFound = false;
    protected Set<Pattern>  xPathToSkipPattern;

    public XmlDiffXPath()
    {
        xPathToSkipPattern = new HashSet<Pattern>();
    } // end XmlDiffXPath()

    public XmlDiffXPath(List<String> xPathsToSkip)
    {
        // ignoredAttributePath = path;
        this();

        for (String xPathToSkip : xPathsToSkip)
        {
            xPathToSkipPattern.add(Pattern.compile(xPathToSkip));
        } // end for
    } // end XmlDiffXPath()

    public boolean called()
    {
        return diffFound;
    } // end called()

    public int differenceFound(final Difference difference)
    {
        // Init
        int diffResult = RETURN_ACCEPT_DIFFERENCE;

        // Debug
        if (logger.isDebugEnabled())
        {
            logger.debug("difference=" + difference);
            logger.debug("difference.getTestNodeDetail()=" + difference.getTestNodeDetail().getXpathLocation());
        } // end if

        // Treatment
        if (!xPathToSkipPattern.isEmpty())
        {
            Iterator it = xPathToSkipPattern.iterator();

            while (it.hasNext())
            {
                Matcher m = ((Pattern) it.next()).matcher(difference.getTestNodeDetail().getXpathLocation());

                if (m.matches())
                {
                    // diffResult=RETURN_IGNORE_DIFFERENCE_NODES_SIMILAR;
                    diffResult = RETURN_IGNORE_DIFFERENCE_NODES_IDENTICAL;
                } // end if
            } // end while
        } // end if

        // End
        diffFound = true;

        if ( // Debug
        logger.isDebugEnabled())
        {
            // Debug
            logger.debug("diffResult=" + diffResult);
        } // end if

        return diffResult;
    } // end differenceFound()

    public void skippedComparison(final Node control, final Node test)
    {
        if (logger.isDebugEnabled())
        {
            logger.debug(control);
        } // end if

        if (logger.isDebugEnabled())
        {
            logger.debug(test);
        } // end if
    } // end skippedComparison()
} // end XmlDiffXPath

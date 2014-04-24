package com.nabla.project.application.model.message.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Author : $author$ Date : $Date: 2010-06-20 18:06:01 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$
 */
public class GlobaleMappingTests
{
    public static Test suite()
    {
        TestSuite suite = new TestSuite(GlobaleMappingTests.class.getName());

        // Fonctionnal
        suite.addTestSuite(com.nabla.project.application.model.message.service.PositionExtractServiceJaxbTest.class);

        // Global XML comparison
        suite.addTestSuite(com.nabla.project.application.model.message.mapping.XMLComparisonTest.class);

        return suite;
    } // end suite()

    public static void main(final String[] args)
    {
        junit.textui.TestRunner.run(suite());
    } // end main()
} // end GlobaleMappingTests

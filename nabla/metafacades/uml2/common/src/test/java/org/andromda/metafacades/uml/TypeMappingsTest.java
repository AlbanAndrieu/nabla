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
package org.andromda.metafacades.uml;

import junit.framework.TestCase;
import org.andromda.core.mapping.Mapping;
import org.andromda.core.mapping.Mappings;

/**
 * Tests {@link org.andromda.metafacades.uml.TypeMappings}
 * 
 * @author Chad Brandon
 */
public class TypeMappingsTest extends TestCase
{
    /**
     * Constructor for MappingsTest.
     * 
     * @param name
     */
    public TypeMappingsTest(String name)
    {
        super(name);
    }

    private static final String TO_1         = "base64Binary";

    private static final String FROM_1       = "datatype.Blob";

    private static final String FROM_2       = "datatype.byte[]";

    private static final String FROM_3       = "datatype.Byte[]";

    private static final String FROM_4       = "datatype.Clob";

    private static final String TO_2         = "java.lang.String";

    private static final String FROM_5       = "datatype.String";

    private static final String NOT_MAPPED_1 = "datatype.byte";

    private static final String NOT_MAPPED_2 = "datatype.String[]";

    private static final String ARRAY_SUFFIX = "[]";

    private static final String TO_3         = "Class<? extends ToType>";

    private static final String FROM_6       = "Class<? extends FromType>";

    /**
     *
     */
    public void testGetTo()
    {
        Mappings mappings1 = new Mappings();
        Mapping mapping1 = new Mapping();
        mapping1.setTo(TO_1);
        mapping1.addFrom(FROM_1);
        mapping1.addFrom(FROM_2);
        mapping1.addFrom(FROM_3);
        mapping1.addFrom(FROM_4);
        mappings1.addMapping(mapping1);
        TypeMappings typeMappings1 = TypeMappings.getInstance(mappings1);

        // make sure the to == from when passing in a mappings1 that don't exist
        assertNotNull(typeMappings1.getTo(NOT_MAPPED_1));
        assertEquals(NOT_MAPPED_1, typeMappings1.getTo(NOT_MAPPED_1));
        assertEquals(typeMappings1.getTo(NOT_MAPPED_2), typeMappings1.getTo(NOT_MAPPED_2));

        // make sure we can retrieve the to using a from array.
        assertNotNull(typeMappings1.getTo(FROM_1));
        assertEquals(TO_1, typeMappings1.getTo(FROM_1));

        // make sure we can retrieve the to using a from non array.
        assertEquals(TO_1, typeMappings1.getTo(FROM_4));

        Mappings mappings2 = new Mappings();
        Mapping mapping2 = new Mapping();
        mapping2.setTo(TO_2);
        mapping2.addFrom(FROM_5);
        mappings2.addMapping(mapping2);
        TypeMappings typeMappings2 = TypeMappings.getInstance(mappings2);
        typeMappings2.setArraySuffix(ARRAY_SUFFIX);

        assertEquals(TO_2, typeMappings2.getTo(FROM_5));
        assertEquals(TO_2 + ARRAY_SUFFIX, typeMappings2.getTo(FROM_5 + ARRAY_SUFFIX));

        Mappings mappings3 = new Mappings();
        Mapping mapping3 = new Mapping();
        mapping3.setTo(TO_3);
        mapping3.addFrom(FROM_6);
        mappings3.addMapping(mapping3);
        TypeMappings typeMappings3 = TypeMappings.getInstance(mappings3);
        // make sure whitespace isn't deleted, only trimmed (Java generics would fail compilation otherwise for example)
        assertEquals(TO_3, typeMappings3.getTo(FROM_6));
    }
}

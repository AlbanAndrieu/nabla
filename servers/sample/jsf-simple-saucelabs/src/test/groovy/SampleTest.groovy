import groovy.util.GroovyTestCase

import org.junit.Test

class SampleTest extends GroovyTestCase {
	@Test
    void testSomething() {
        assert 1 == 1
        assert 2 + 2 == 4 : "We're in trouble, arithmetic is broken"
    }
}
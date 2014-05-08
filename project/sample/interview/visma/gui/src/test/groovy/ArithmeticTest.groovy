import static org.junit.Assert.assertEquals
import groovy.util.GroovyTestCase;

import org.junit.Test

class ArithmeticTest extends GroovyTestCase {
    
    @Test
    void additionIsWorking() {
        assertEquals 4, 2+2
    }

    @Test(expected=ArithmeticException)
    void divideByZero() {
        println 1/0
    }

    @Test
    void testSomething() {
        assert 1 == 1
        assert 2 + 2 == 4 : "We're in trouble, arithmetic is broken"
    }
    
}
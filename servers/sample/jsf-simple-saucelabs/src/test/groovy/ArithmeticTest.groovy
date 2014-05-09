import groovy.util.GroovyTestCase;

import org.junit.Test

import static org.junit.Assert.assertEquals

class ArithmeticTest /*extends GroovyTestCase*/ {
    @Test
    void additionIsWorking() {
        assertEquals 4, 2+2
    }

    @Test(expected=ArithmeticException)
    void divideByZero() {
        println 1/0
    }
}
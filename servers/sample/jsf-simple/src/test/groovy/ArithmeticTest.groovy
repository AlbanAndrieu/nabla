import static org.junit.Assert.assertEquals

import org.junit.Test

//Use extends GroovyTestCase in eclipse
class ArithmeticTest /*extends GroovyTestCase*/ {

    @Test
    void testAdditionIsWorking() {
        assertEquals 4, 2+2
    }

    /*
    @Test
    void testShouldFailWithMessage() {
        def msg = shouldFail { throw new RuntimeException('x') }
        assertEquals 'x', msg
    }
    */
    
    @Test(expected=ArithmeticException)
    void testDivideByZero() {

        //try {
            println 1/0
        //} catch (ArithmeticException expected) {
        //}
        //fail 'Expected ArithmeticException was not thrown.'
    }
}
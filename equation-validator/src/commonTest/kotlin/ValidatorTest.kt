import kotlin.test.Test
import kotlin.test.assertEquals

internal class ValidatorTest {

    @Test
    fun testTwoEquations() {
        assertEquals(validate("""05+03=08 and 2+2=4"""), "regular expression does not match")
    }

    @Test
    fun testSimpleEquation() {
        assertEquals(validate("""2+2=4"""), "OK")
    }

    @Test
    fun testIncorrectEquation() {
        assertEquals(validate("""5+3=999"""), "math does not check")
    }

    @Test
    fun testZero() {
        assertEquals(validate("""0+4=4"""), "OK")
    }

    @Test
    fun testWhitespace() {
        assertEquals(validate("""     2   +    2 =   4"""), "OK")
    }

    @Test
    fun testStartWithZero() {
        assertEquals(validate("""05+04=9"""), "OK")
    }
}
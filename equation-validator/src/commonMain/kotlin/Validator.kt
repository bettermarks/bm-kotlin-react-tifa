import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport()
@JsName("validateEquation")
fun validate(equationString: String): String {
    /*
    A three-step process here:
    1. remove all whitespace, just like a computer interpreter would do
    2. certify the expression is structurally correct using a regular expression
    3. Actually evaluate the expression and see if it's true or false.
     */


    // First, remove every single space and then use a regular expression,
    // because I honestly think it's the simplest way
    val validateThis = Regex("""\s""").replace(equationString, "")
    val validatorRegex = Regex("""^(\d+)\+(\d+)=(\d+)$""");
    val responseGroups = validatorRegex.matchEntire(validateThis)?.groupValues ?: return( "regular expression does not match")

    // Now let's validate the sum
    return if ((responseGroups[1].toInt() + responseGroups[2].toInt()) == responseGroups[3].toInt()) "OK" else "math does not check"

}
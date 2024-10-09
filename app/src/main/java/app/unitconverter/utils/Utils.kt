package app.unitconverter.utils

fun validateInput(input: String): Boolean {
    val scientificPattern = Regex("^\\d*\\.?\\d*([eE][+-]?\\d*)?$")

    println("validateInput: ${scientificPattern.matches(input)}")

    return if (scientificPattern.matches(input)) {
        val numberWithoutExponent = input.split("[eE]".toRegex())[0].replace(".", "")
        numberWithoutExponent.length <= 16
    } else {
        val decimalPart = input.substringAfter(".", "")
        decimalPart.length <= 16
    }
}

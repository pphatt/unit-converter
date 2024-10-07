package app.unitconverter.enums

enum class EAreaUnit(
    override val displayName: String,
    override val symbol: String,
    override val nameWithoutSymbol: String
) : DisplayableUnit {
    Acre("Acre (ac)", "ac", "Acre"),
    Are("Are (a)", "a", "Are"),
    Hectare("Hectare (ha)", "ha", "Hectare"),
    CentimetresSquared("Centimetres Squared (cm²)", "cm²", "Centimetres Squared"),
    FeetSquared("Feet Squared (ft²)", "ft²", "Feet Squared"),
    InchesSquared("Inches Squared (in²)", "in²", "Inches Squared"),
    MetersSquared("Meters Squared (m²)", "m²", "Meters Squared")
}

package app.unitconverter.enums

enum class ELengthUnit(
    override val displayName: String,
    override val symbol: String,
    override val nameWithoutSymbol: String
) :
    DisplayableUnit {
    Millimetres("Millimetres (mm)", "mm", "Millimetres"),
    Centimetres("Centimetres (cm)", "cm", "Centimetres"),
    Metres("Metres (m)", "m", "Metres"),
    Kilometres("Kilometres (km)", "km", "Kilometres"),
    Feet("Feet (ft)", "ft", "Feet"),
    Inches("Inches (in)", "in", "Inches"),
    Yards("Yards (yd)", "yd", "Yards"),
    Miles("Miles (mi)", "mi", "Miles"),
    NauticalMiles("Nautical Miles (NM)", "NM", "NauticalMiles")
}

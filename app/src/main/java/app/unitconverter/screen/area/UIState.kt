package app.unitconverter.screen.area

import app.unitconverter.enums.UnitInput

data class UIState(
    val iInputValue: String,
    val oInputValue: String,
    val iUnitSelectValue: UnitInput,
    val oUnitSelectValue: UnitInput,
    val iFocusedState: Boolean,
    val oFocusedState: Boolean,
) {
    companion object {
        val default = UIState(
            iInputValue = "1",
            oInputValue = "10000",

            iUnitSelectValue = UnitInput("MetersSquared", "m²", "Meters Squared"),
            oUnitSelectValue = UnitInput("CentimetresSquared", "cm²", "Centimetres Squared"),

            iFocusedState = false,
            oFocusedState = false,
        )
    }
}

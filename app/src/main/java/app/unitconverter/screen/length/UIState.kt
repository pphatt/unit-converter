package app.unitconverter.screen.length

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
            oInputValue = "100",

            iUnitSelectValue = UnitInput("Metres", "m", "Metres"),
            oUnitSelectValue = UnitInput("Centimetres", "cm", "Centimetres"),

            iFocusedState = false,
            oFocusedState = false,
        )
    }
}

package app.unitconverter.screen.area

import app.unitconverter.enums.ETypes
import app.unitconverter.enums.UnitInput

sealed interface ViewAction {
    data class SetIInputValue(val value: String) : ViewAction
    data class SetOInputValue(val value: String) : ViewAction

    data class SetIUnitSelectValue(val value: UnitInput) : ViewAction
    data class SetOUnitSelectValue(val value: UnitInput) : ViewAction

    data class SetIFocused(val value: Boolean) : ViewAction
    data class SetOFocused(val value: Boolean) : ViewAction

    data class HandleConvertWhenInput(val value: String, val type: ETypes) :
        ViewAction

    data object HandleConvertWhenSelect : ViewAction
}
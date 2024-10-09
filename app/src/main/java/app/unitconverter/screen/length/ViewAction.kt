package app.unitconverter.screen.length

import app.unitconverter.enums.UnitInput

sealed interface ViewAction {
    data class SetIInputValue(val value: String) : ViewAction
    data class SetOInputValue(val value: String) : ViewAction

    data class SetIUnitSelectValue(val value: UnitInput) : ViewAction
    data class SetOUnitSelectValue(val value: UnitInput) : ViewAction

    data class HandleConvertWhenInput(val value: String, val type: LengthScreenViewModel.ETypes) : ViewAction
    data class HandleConvertWhenSelect(val type: LengthScreenViewModel.ETypes) : ViewAction
}

package app.unitconverter.screen.length

import androidx.lifecycle.ViewModel
import app.unitconverter.enums.UnitInput
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import kotlin.math.pow
import kotlin.math.round

@HiltViewModel
class LengthScreenViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(UIState.default)
    val uiState = _uiState.asStateFlow()
    private var state: UIState
        get() = _uiState.value
        set(value) {
            _uiState.update { value }
        }

    fun execute(action: ViewAction) {
        when (action) {
            is ViewAction.SetIInputValue -> setIInputValue(action.value)
            is ViewAction.SetOInputValue -> setOInputValue(action.value)

            is ViewAction.SetIUnitSelectValue -> setIUnitSelectValue(action.value)
            is ViewAction.SetOUnitSelectValue -> setOUnitSelectValue(action.value)

            is ViewAction.SetIFocused -> setIFocused(action.value)
            is ViewAction.SetOFocused -> setOFocused(action.value)

            is ViewAction.HandleConvertWhenInput -> handleConvertWhenInput(
                value = action.value, type = action.type
            )

            ViewAction.HandleConvertWhenSelect -> handleConvertWhenSelect()
        }
    }

    private fun setIInputValue(value: String) {
        if (value.isEmpty()) {
            setOInputValue(value = "")
        } else {
            setOInputValue(
                value = convertLength(
                    value = value.toDoubleOrNull() ?: state.iInputValue.toDouble(),
                    fromUnit = state.iUnitSelectValue.value,
                    toUnit = state.oUnitSelectValue.value
                ).toString()
            )
        }

        state = state.copy(iInputValue = value)
    }

    private fun setOInputValue(value: String) {
        state = state.copy(oInputValue = value)
    }

    private fun setIUnitSelectValue(value: UnitInput) {
        state = state.copy(iUnitSelectValue = value)
    }

    private fun setOUnitSelectValue(value: UnitInput) {
        state = state.copy(oUnitSelectValue = value)
    }

    private fun setIFocused(value: Boolean) {
        state = state.copy(iFocusedState = value)
    }

    private fun setOFocused(value: Boolean) {
        state = state.copy(oFocusedState = value)
    }

    enum class ETypes {
        I, O
    }

    private fun handleConvertWhenInput(value: String, type: ETypes) {
        if (value.isEmpty()) {
            if (type == ETypes.I) setOInputValue(value = "")
            else if (type == ETypes.O) setIInputValue(value = "")
        } else {
            if (type == ETypes.I) {
                setOInputValue(
                    value = convertLength(
                        value = value.toDoubleOrNull() ?: state.iInputValue.toDouble(),
                        fromUnit = state.iUnitSelectValue.value,
                        toUnit = state.oUnitSelectValue.value
                    ).toString()
                )
            } else if (type == ETypes.O) {
                setIInputValue(
                    value = convertLength(
                        value = value.toDoubleOrNull() ?: state.oInputValue.toDouble(),
                        fromUnit = state.oUnitSelectValue.value,
                        toUnit = state.iUnitSelectValue.value
                    ).toString()
                )
            }
        }
    }

    private fun handleConvertWhenSelect() {
        if (state.iFocusedState) {
            setOInputValue(
                value = convertLength(
                    value = state.iInputValue.toDouble(),
                    fromUnit = state.iUnitSelectValue.value,
                    toUnit = state.oUnitSelectValue.value
                ).toString()
            )
        } else {
            setIInputValue(
                value = convertLength(
                    value = state.oInputValue.toDouble(),
                    fromUnit = state.oUnitSelectValue.value,
                    toUnit = state.iUnitSelectValue.value
                ).toString()
            )
        }
    }

    private fun convertLength(value: Double, fromUnit: String, toUnit: String): Number {
        val valueInMeters = when (fromUnit) {
            "Metres" -> value
            "Centimetres" -> value / 100
            "Feet" -> value / 3.28084
            "Millimetres" -> value / 1000
            "Kilometres" -> value * 1000
            "Inches" -> value / 39.3701
            "Yards" -> value / 1.09361
            "Miles" -> value * 1609.34
            "NauticalMiles" -> value * 1852
            else -> value
        }

        val convertedValue = when (toUnit) {
            "Metres" -> valueInMeters
            "Centimetres" -> valueInMeters * 100
            "Feet" -> valueInMeters * 3.28084
            "Millimetres" -> valueInMeters * 1000
            "Kilometres" -> valueInMeters / 1000
            "Inches" -> valueInMeters * 39.3701
            "Yards" -> valueInMeters * 1.09361
            "Miles" -> valueInMeters / 1609.34
            "NauticalMiles" -> valueInMeters / 1852
            else -> valueInMeters
        }

        val decimalPlaces = value.toString().substringAfter('.', "").length
        val minDecimalPlaces = 5
        val roundingPlaces = maxOf(decimalPlaces, minDecimalPlaces)

        val factor = 10.0.pow(roundingPlaces)
        val roundedValue = round(convertedValue * factor) / factor

        return if (roundedValue % 1.0 == 0.0) {
            roundedValue.toInt()
        } else {
            roundedValue
        }
    }
}

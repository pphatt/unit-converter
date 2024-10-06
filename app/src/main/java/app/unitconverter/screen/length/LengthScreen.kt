package app.unitconverter.screen.length

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.unit.dp
import app.unitconverter.ui.components.common.DropdownMenu
import app.unitconverter.ui.components.common.NumberInputField

data class InputWithUnit(
    var value: String,
    var symbol: String
)

@Composable
fun LengthScreen(
    modifier: Modifier,
) {
    // LengthScreen inputs state
    var IInputValue by remember { mutableStateOf(InputWithUnit("1", "m")) }
    var OInputValue by remember { mutableStateOf(InputWithUnit("100", "cm")) }

    // LengthScreen unit state
    var IUnitSelectValue by rememberSaveable {
        mutableStateOf("Metres")
    }

    var OUnitSelectValue by rememberSaveable {
        mutableStateOf("Centimetres")
    }

    // Focus states
    var IFocusedState by remember { mutableStateOf(false) }
    var OFocusedState by remember { mutableStateOf(false) }

    fun convertLength(value: Double, fromUnit: String, toUnit: String): Double {
        return when (fromUnit to toUnit) {
            "Meters" to "CentiMeters" -> value * 100
            "Meters" to "Feet" -> value * 3.28084
            "Meters" to "MilliMeters" -> value * 1000
            "CentiMeters" to "Meters" -> value / 100
            "CentiMeters" to "Feet" -> value * 0.0328084
            "CentiMeters" to "MilliMeters" -> value * 10
            "Feet" to "Meters" -> value / 3.28084
            "Feet" to "CentiMeters" -> value * 30.48
            "Feet" to "MilliMeters" -> value * 304.8
            "MilliMeters" to "Meters" -> value / 1000
            "MilliMeters" to "CentiMeters" -> value / 10
            "MilliMeters" to "Feet" -> value / 304.8
            else -> value // If no conversion needed or unknown unit
        }
    }

//    fun updateInputValues(key: String) {
//        when (tabIndex.value) {
//            0 -> {
//                if (isFirstInputFocused) {
//                    lengthInputValueOne += key
//                    lengthInputValueTwo = convertLength(
//                        lengthInputValueOne.toDoubleOrNull() ?: 0.0,
//                        lengthUnitFirstInput,
//                        lengthUnitSecondInput
//                    ).toString()
//                } else {
//                    lengthInputValueTwo += key
//                    lengthInputValueOne = convertLength(
//                        lengthInputValueTwo.toDoubleOrNull() ?: 0.0,
//                        lengthUnitSecondInput,
//                        lengthUnitFirstInput
//                    ).toString()
//                }
//            }
//        }
//    }

    Column(
        modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            DropdownMenu(
                IUnitSelectValue = IUnitSelectValue,
                onUnitSelect = { IUnitSelectValue = it }
            )

            NumberInputField(
                modifier = Modifier.onFocusChanged { IFocusedState = it.isFocused },
                value = IInputValue,
                onValueChange = { string ->
                    IInputValue = IInputValue.copy(value = string)
                })
        }

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(), thickness = 1.dp
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            DropdownMenu(
                IUnitSelectValue = OUnitSelectValue,
                onUnitSelect = { OUnitSelectValue = it }
            )

            NumberInputField(
                modifier = Modifier.onFocusChanged { OFocusedState = it.isFocused },
                value = OInputValue,
                onValueChange = { OInputValue = OInputValue.copy(value = it) })
        }
    }
}

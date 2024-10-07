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
import kotlin.math.pow
import kotlin.math.round

data class InputWithUnit(
    var value: String, var symbol: String
)

@Composable
fun LengthScreen(
    modifier: Modifier,
) {
    // LengthScreen inputs state
    var IInputValue by remember { mutableStateOf("1") }
    var OInputValue by remember { mutableStateOf("100") }

    // LengthScreen unit state
    var IUnitSelectValue by remember {
        mutableStateOf(InputWithUnit("Metres", "m"))
    }

    var OUnitSelectValue by remember {
        mutableStateOf(InputWithUnit("Centimetres", "cm"))
    }

    // Focus states
    var IFocusedState by remember { mutableStateOf(false) }
    var OFocusedState by remember { mutableStateOf(false) }

    fun convertLength(value: Double, fromUnit: String, toUnit: String): Number {
        val valueInMeters = when (fromUnit) {
            "Metres" -> value
            "Centimetres" -> value / 100
            "Feet" -> value / 3.28084
            "Millimetres" -> value / 1000
            else -> value
        }

        val convertedValue = when (toUnit) {
            "Metres" -> valueInMeters
            "Centimetres" -> valueInMeters * 100
            "Feet" -> valueInMeters * 3.28084
            "Millimetres" -> valueInMeters * 1000
            else -> valueInMeters
        }

        val decimalPlaces = value.toString().substringAfter('.', "").length
        val minDecimalPlaces = 2
        val roundingPlaces = maxOf(decimalPlaces, minDecimalPlaces)

        val factor = 10.0.pow(roundingPlaces)
        val roundedValue = round(convertedValue * factor) / factor

        return if (roundedValue % 1.0 == 0.0) {
            roundedValue.toInt()
        } else {
            roundedValue
        }
    }

    Column(
        modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            DropdownMenu(IUnitSelectValue = IUnitSelectValue, onUnitSelect = { value ->
                IUnitSelectValue = IUnitSelectValue.copy(
                    value = value.value, symbol = value.symbol
                )

                OInputValue = convertLength(
                    value = IInputValue.toDouble(),
                    fromUnit = value.value,
                    toUnit = OUnitSelectValue.value
                ).toString()
            })

            NumberInputField(
                modifier = Modifier.onFocusChanged { IFocusedState = it.isFocused },
                value = IInputValue,
                onValueChange = { string ->
                    OInputValue =
                        if (string.isEmpty()) {
                            ""
                        } else {
                            convertLength(
                                value = string.toDoubleOrNull() ?: IInputValue.toDouble(),
                                fromUnit = IUnitSelectValue.value,
                                toUnit = OUnitSelectValue.value
                            ).toString()
                        }

                    IInputValue = string
                },
                symbol = IUnitSelectValue.symbol
            )
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
            DropdownMenu(IUnitSelectValue = OUnitSelectValue, onUnitSelect = { value ->
                OUnitSelectValue = OUnitSelectValue.copy(
                    value = value.value, symbol = value.symbol
                )

                IInputValue = convertLength(
                    value = OInputValue.toDouble(),
                    fromUnit = value.value,
                    toUnit = IUnitSelectValue.value
                ).toString()
            })

            NumberInputField(
                modifier = Modifier.onFocusChanged { OFocusedState = it.isFocused },
                value = OInputValue,
                onValueChange = { string ->
                    IInputValue =
                        if (string.isEmpty()) {
                            ""
                        } else {
                            convertLength(
                                value = string.toDoubleOrNull() ?: OInputValue.toDouble(),
                                fromUnit = OUnitSelectValue.value,
                                toUnit = IUnitSelectValue.value
                            ).toString()
                        }

                    OInputValue = string
                },
                symbol = OUnitSelectValue.symbol
            )
        }
    }
}

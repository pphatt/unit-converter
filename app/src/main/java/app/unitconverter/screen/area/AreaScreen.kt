package app.unitconverter.screen.area

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.unit.dp
import app.unitconverter.enums.EAreaUnit
import app.unitconverter.enums.UnitInput
import app.unitconverter.ui.components.common.DropdownMenu
import app.unitconverter.ui.components.common.NumberInputField
import kotlin.math.pow
import kotlin.math.round

@Composable
fun AreaScreen(
    modifier: Modifier
) {
    // LengthScreen inputs state
    var IInputValue by remember { mutableStateOf("1") }
    var OInputValue by remember { mutableStateOf("10000") }

    // LengthScreen unit state
    var IUnitSelectValue by remember {
        mutableStateOf(UnitInput("MetersSquared", "m²", "Meters Squared"))
    }

    var OUnitSelectValue by remember {
        mutableStateOf(UnitInput("CentimetresSquared", "cm²", "Centimetres Squared"))
    }

    // Focus states
    var IFocusedState by remember { mutableStateOf(false) }
    var OFocusedState by remember { mutableStateOf(false) }

    fun convertArea(value: Double, fromUnit: String, toUnit: String): Number {
        // First, convert the input value to square meters
        val valueInSquareMeters = when (fromUnit) {
            "Acre" -> value * 4046.86
            "Are" -> value * 100
            "Hectare" -> value * 10000
            "CentimetresSquared" -> value / 10000
            "FeetSquared" -> value / 10.7639
            "InchesSquared" -> value / 1550.0031
            "MetersSquared" -> value
            else -> value
        }

        // Then, convert the value from square meters to the desired unit
        val convertedValue = when (toUnit) {
            "Acre" -> valueInSquareMeters / 4046.86
            "Are" -> valueInSquareMeters / 100
            "Hectare" -> valueInSquareMeters / 10000
            "CentimetresSquared" -> valueInSquareMeters * 10000
            "FeetSquared" -> valueInSquareMeters * 10.7639
            "InchesSquared" -> valueInSquareMeters * 1550.0031
            "MetersSquared" -> valueInSquareMeters
            else -> valueInSquareMeters
        }

        // Rounding logic
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
                enumEntries = EAreaUnit.entries.toTypedArray(),
                unitSelectValue = IUnitSelectValue,
                onUnitSelect = { value ->
                    IUnitSelectValue = IUnitSelectValue.copy(
                        value = value.value,
                        symbol = value.symbol,
                        name = value.name
                    )

                    OInputValue = convertArea(
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
                            convertArea(
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
            DropdownMenu(
                enumEntries = EAreaUnit.entries.toTypedArray(),
                unitSelectValue = OUnitSelectValue,
                onUnitSelect = { value ->
                    OUnitSelectValue = OUnitSelectValue.copy(
                        value = value.value,
                        symbol = value.symbol,
                        name = value.name
                    )

                    IInputValue = convertArea(
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
                            convertArea(
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

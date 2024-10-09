package app.unitconverter.screen.length

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import app.unitconverter.enums.ELengthUnit
import app.unitconverter.enums.ETypes
import app.unitconverter.enums.UnitInput
import app.unitconverter.ui.components.common.DropdownMenu
import app.unitconverter.ui.components.common.NumberInputField

@Composable
fun LengthScreen(
    viewModel: LengthScreenViewModel = hiltViewModel(),
    modifier: Modifier,
) {
    val state = viewModel.uiState.collectAsState().value

    Column(
        modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            DropdownMenu(enumEntries = ELengthUnit.entries.toTypedArray(),
                unitSelectValue = state.iUnitSelectValue,
                onUnitSelect = { unit ->
                    viewModel.execute(
                        ViewAction.SetIUnitSelectValue(
                            value = UnitInput(
                                value = unit.value, symbol = unit.symbol, name = unit.name
                            )
                        )
                    )

                    if (state.iInputValue.isEmpty() || state.oInputValue.isEmpty()) {
                        return@DropdownMenu
                    }

                    viewModel.execute(
                        ViewAction.HandleConvertWhenSelect
                    )
                })

            NumberInputField(
                modifier = Modifier
                    .onFocusChanged { viewModel.execute(ViewAction.SetIFocused(it.isFocused)) },
                value = state.iInputValue,
                onValueChange = { stringValue ->
                    viewModel.execute(
                        ViewAction.HandleConvertWhenInput(
                            value = stringValue, type = ETypes.I
                        )
                    )

                    viewModel.execute(ViewAction.SetIInputValue(value = stringValue))
                },
                symbol = state.iUnitSelectValue.symbol
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
            DropdownMenu(enumEntries = ELengthUnit.entries.toTypedArray(),
                unitSelectValue = state.oUnitSelectValue,
                onUnitSelect = { unit ->
                    viewModel.execute(
                        ViewAction.SetOUnitSelectValue(
                            value = UnitInput(
                                value = unit.value, symbol = unit.symbol, name = unit.name
                            )
                        )
                    )

                    if (state.iInputValue.isEmpty() || state.oInputValue.isEmpty()) {
                        return@DropdownMenu
                    }

                    viewModel.execute(
                        ViewAction.HandleConvertWhenSelect
                    )
                })

            NumberInputField(
                modifier = Modifier.onFocusChanged { viewModel.execute(ViewAction.SetOFocused(it.isFocused)) },
                value = state.oInputValue,
                onValueChange = { stringValue ->
                    viewModel.execute(
                        ViewAction.HandleConvertWhenInput(
                            value = stringValue, type = ETypes.O
                        )
                    )

                    viewModel.execute(ViewAction.SetOInputValue(value = stringValue))
                },
                symbol = state.oUnitSelectValue.symbol
            )
        }
    }
}

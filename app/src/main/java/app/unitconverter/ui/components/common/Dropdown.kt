package app.unitconverter.ui.components.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.unitconverter.enums.DisplayableUnit
import app.unitconverter.enums.UnitInput
import app.unitconverter.ui.theme.LocalColorScheme

@Composable
fun <T> DropdownMenu(
    enumEntries: Array<T>,
    unitSelectValue: UnitInput,
    onUnitSelect: (UnitInput) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    val onDismissRequest = {
        isExpanded = false
    }

    Box {
        Button(
            onClick = { isExpanded = true },
            contentPadding = PaddingValues(start = 12.dp, end = 8.dp),
            colors = ButtonDefaults.filledTonalButtonColors(
                containerColor = LocalColorScheme.current.secondaryAlt,
            )
        ) {
            Text(
                text = unitSelectValue.name,
                color = LocalColorScheme.current.foreground,
                fontSize = 15.sp
            )

            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Arrow Down",
                tint = LocalColorScheme.current.foregroundAlt
            )
        }

        MaterialTheme(shapes = MaterialTheme.shapes.copy(extraSmall = RoundedCornerShape(16.dp))) {
            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = onDismissRequest
            ) {
                enumEntries.forEach { unit ->
                    unit as DisplayableUnit

                    DropdownMenuItem(
                        text = {
                            Text(
                                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                                text = unit.displayName,
                                color = if (unit.name == unitSelectValue.value)
                                    LocalColorScheme.current.foregroundAlt3 else LocalColorScheme.current.foregroundAlt4
                            )
                        },
                        onClick = {
                            onUnitSelect(
                                UnitInput(
                                    unit.name,
                                    unit.symbol,
                                    unit.nameWithoutSymbol
                                )
                            )

                            onDismissRequest()
                        })
                }
            }
        }
    }
}

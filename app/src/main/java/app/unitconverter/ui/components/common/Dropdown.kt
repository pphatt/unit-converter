package app.unitconverter.ui.components.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.unitconverter.enums.ELengthUnit
import app.unitconverter.screen.length.InputWithUnit
import app.unitconverter.ui.theme.LocalColorScheme

@Composable
fun DropdownMenu(
    IUnitSelectValue: InputWithUnit, onUnitSelect: (InputWithUnit) -> Unit
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
                text = IUnitSelectValue.value,
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
                ELengthUnit.entries.forEach { unit ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                                text = unit.displayName,
                                color = if (unit.name == IUnitSelectValue.value)
                                    LocalColorScheme.current.foregroundAlt3 else LocalColorScheme.current.foregroundAlt4
                            )
                        },
                        onClick = {
                            onUnitSelect(InputWithUnit(unit.name, unit.symbol))

                            onDismissRequest()
                        })
                }
            }
        }
    }
}

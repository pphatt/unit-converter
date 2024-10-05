package app.unitconverter.screen.length

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.unitconverter.ui.components.common.NumberInputField

@Composable
fun LengthScreen(
    modifier: Modifier,
) {
    var inputValue by remember { mutableStateOf("1") }

    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }

    var inputUnitOne by remember { mutableStateOf("Meters") }
    var inputUnitTwo by remember { mutableStateOf("CentiMeters") }

    Column(
        modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Box {
                Button(
                    modifier = Modifier.padding(0.dp),
                    onClick = { iExpanded = true },
                    colors = ButtonDefaults.filledTonalButtonColors(
                        containerColor = Color(0xFF1B1B1B),
                    )
                ) {
                    Text(text = inputUnitOne, fontSize = 15.sp)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }

                DropdownMenu(modifier = Modifier,
                    expanded = iExpanded,
                    onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(text = { Text("CentiMeters") }, onClick = {
                        iExpanded = false
                        inputUnitOne = "CentiMeters"
                    })

                    DropdownMenuItem(text = { Text("Meters") }, onClick = {
                        iExpanded = false
                        inputUnitOne = "Meters"
                    })

                    DropdownMenuItem(text = { Text("Feet") }, onClick = {
                        iExpanded = false
                        inputUnitOne = "Feet"
                    })

                    DropdownMenuItem(text = { Text("MilliMeters") }, onClick = {
                        iExpanded = false
                        inputUnitOne = "MilliMeters"
                    })
                }
            }

            NumberInputField(value = inputValue)
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
            Box {
                Button(
                    modifier = Modifier.padding(0.dp),
                    onClick = { oExpanded = true },
                    colors = ButtonDefaults.filledTonalButtonColors(
                        containerColor = Color(0xFF1B1B1B),
                    )
                ) {
                    Text(text = inputUnitTwo, fontSize = 15.sp)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }

                DropdownMenu(modifier = Modifier,
                    expanded = oExpanded,
                    onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(text = { Text("CentiMeters") }, onClick = {
                        oExpanded = false
                        inputUnitTwo = "CentiMeters"
                    })

                    DropdownMenuItem(text = { Text("Meters") }, onClick = {
                        oExpanded = false
                        inputUnitTwo = "Meters"
                    })

                    DropdownMenuItem(text = { Text("Feet") }, onClick = {
                        oExpanded = false
                        inputUnitTwo = "Feet"
                    })

                    DropdownMenuItem(text = { Text("MilliMeters") }, onClick = {
                        oExpanded = false
                        inputUnitTwo = "MilliMeters"
                    })
                }
            }

            NumberInputField(value = inputValue)
        }
    }
}

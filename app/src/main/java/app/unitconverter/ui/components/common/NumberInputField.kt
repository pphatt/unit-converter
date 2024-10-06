package app.unitconverter.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.unitconverter.screen.length.InputWithUnit
import app.unitconverter.ui.theme.LocalColorScheme

@Composable
fun NumberInputField(
    modifier: Modifier = Modifier,
    value: InputWithUnit,
    onValueChange: (String) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            modifier = modifier
                .weight(1f),
            value = value.value,
            onValueChange = { newValue ->
                val pattern = Regex("[\\d,]*[.]?[\\d,]*")

                if (newValue.isEmpty() || newValue.matches(pattern)) {
                    onValueChange(newValue)
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
            ),
            textStyle = TextStyle.Default.copy(
                color = LocalColorScheme.current.foreground,
                fontSize = 30.sp,
                textDirection = TextDirection.ContentOrRtl
            )
        )

        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = value.symbol,
            color = LocalColorScheme.current.foreground,
            fontSize = 20.sp,
        )
    }
}

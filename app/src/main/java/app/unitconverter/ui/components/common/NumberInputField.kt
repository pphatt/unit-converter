package app.unitconverter.ui.components.common

import android.icu.text.DecimalFormat
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
    value: String,
    onValueChange: (String) -> Unit,
    symbol: String
) {
    val context = LocalContext.current

    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            modifier = modifier
                .weight(1f),
            value = value,
            onValueChange = { newValue ->
                val pattern = Regex("^\\d*[.]?\\d*$")

                if (newValue.isEmpty() || newValue.matches(pattern)) {
                    onValueChange(newValue)
                } else {
                    Toast.makeText(context, "Invalid input type (only digit and dot)", Toast.LENGTH_LONG).show()
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
            )
        )

        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = symbol,
            color = LocalColorScheme.current.foreground,
            fontSize = 20.sp,
        )
    }
}

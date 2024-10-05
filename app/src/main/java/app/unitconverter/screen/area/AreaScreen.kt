package app.unitconverter.screen.area

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import komikku.presentation.domain.enums.ETabs

@Composable
fun AreaScreen(
    modifier: Modifier
) {
    var inputValue by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        TextField(value = inputValue, onValueChange = {
            inputValue = it
        }, label = { Text("Enter Value") })
    }
}

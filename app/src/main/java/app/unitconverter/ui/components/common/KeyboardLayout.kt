package app.unitconverter.ui.components.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.unitconverter.enums.Measure
import app.unitconverter.ui.components.icons.ArrowDown
import app.unitconverter.ui.components.icons.ArrowUp
import app.unitconverter.ui.components.icons.Delete
import app.unitconverter.ui.components.icons.PlusSlashMinus

@Composable
fun KeyboardLayout() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Measure.buttonSpacing)
    ) {
        AppDefaultButton(modifier = Modifier.weight(1f), content = {
            Text(
                text = "7", fontSize = 32.sp
            )
        }, onClick = {})

        AppDefaultButton(modifier = Modifier.weight(1f), content = {
            Text(
                text = "8", fontSize = 32.sp
            )
        }, onClick = {})

        AppDefaultButton(modifier = Modifier.weight(1f), content = {
            Text(
                text = "9", fontSize = 32.sp
            )
        }, onClick = {})

        AppDefaultButton(modifier = Modifier.weight(1f), content = {
            Icon(
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp),
                imageVector = Delete,
                contentDescription = "",
                tint = Color(0xFF916B53)
            )
        }, onClick = {})
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Measure.buttonSpacing)
    ) {
        AppDefaultButton(modifier = Modifier.weight(1f), content = {
            Text(
                text = "4", fontSize = 32.sp
            )
        }, onClick = {})

        AppDefaultButton(modifier = Modifier.weight(1f), content = {
            Text(
                text = "5", fontSize = 32.sp
            )
        }, onClick = {})

        AppDefaultButton(modifier = Modifier.weight(1f), content = {
            Text(
                text = "6", fontSize = 32.sp
            )
        }, onClick = {})

        AppDefaultButton(modifier = Modifier.weight(1f), content = {
            Text(
                text = "C", fontSize = 32.sp, color = Color(0xFF9E2B24)
            )
        }, onClick = {})
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Measure.buttonSpacing)
    ) {
        AppDefaultButton(modifier = Modifier.weight(1f), content = {
            Text(
                text = "1", fontSize = 32.sp
            )
        }, onClick = {})

        AppDefaultButton(modifier = Modifier.weight(1f), content = {
            Text(
                text = "2", fontSize = 32.sp
            )
        }, onClick = {})

        AppDefaultButton(modifier = Modifier.weight(1f), content = {
            Text(
                text = "3", fontSize = 32.sp
            )
        }, onClick = {})

        AppDefaultButton(modifier = Modifier.weight(1f), content = {
            Icon(
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp),
                imageVector = ArrowUp,
                contentDescription = "",
                tint = Color(0xFF916B53)
            )
        }, onClick = {})
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Measure.buttonSpacing)
    ) {
        AppDefaultButton(modifier = Modifier.weight(1f), enabled = false, content = {
            Icon(
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp),
                imageVector = PlusSlashMinus,
                contentDescription = "",
            )
        }, onClick = {})

        AppDefaultButton(modifier = Modifier.weight(1f), content = {
            Text(
                text = "0", fontSize = 32.sp
            )
        }, onClick = {})

        AppDefaultButton(modifier = Modifier.weight(1f), content = {
            Text(
                text = ",", fontSize = 32.sp
            )
        }, onClick = {})

        AppDefaultButton(modifier = Modifier.weight(1f), content = {
            Icon(
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp),
                imageVector = ArrowDown,
                contentDescription = "",
                tint = Color(0xFF916B53)
            )
        }, onClick = {})
    }
}
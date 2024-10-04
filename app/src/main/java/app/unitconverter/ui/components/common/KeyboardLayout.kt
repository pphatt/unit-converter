package app.unitconverter.ui.components.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.unitconverter.enums.Measure
import app.unitconverter.ui.components.icons.ArrowDown
import app.unitconverter.ui.components.icons.ArrowUp
import app.unitconverter.ui.components.icons.Delete

@Composable
fun KeyboardLayout() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Measure.buttonSpacing)
    ) {
        AppDefaultButton(modifier = Modifier
            .aspectRatio(1f)
            .weight(1f),
            content = {
                Text(
                    text = "7",
                    fontSize = 36.sp,
                    color = Color(0xFF7AB5D2)
                )
            },
            onClick = {})

        AppDefaultButton(modifier = Modifier
            .aspectRatio(1f)
            .weight(1f),
            content = {
                Text(
                    text = "8",
                    fontSize = 36.sp,
                    color = Color(0xFF7AB5D2)
                )
            },
            onClick = {})

        AppDefaultButton(modifier = Modifier
            .aspectRatio(1f)
            .weight(1f),
            content = {
                Text(
                    text = "9",
                    fontSize = 36.sp,
                    color = Color(0xFF7AB5D2)
                )
            },
            onClick = {})

        AppDefaultButton(modifier = Modifier
            .aspectRatio(1f)
            .weight(1f),
            content = {
                Icon(
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp),
                    imageVector = Delete,
                    contentDescription = ""
                )
            },
            onClick = {})
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Measure.buttonSpacing)
    ) {
        AppDefaultButton(modifier = Modifier
            .aspectRatio(1f)
            .weight(1f),
            content = {
                Text(
                    text = "4",
                    fontSize = 36.sp,
                    color = Color(0xFF7AB5D2)
                )
            },
            onClick = {})

        AppDefaultButton(modifier = Modifier
            .aspectRatio(1f)
            .weight(1f),
            content = {
                Text(
                    text = "5",
                    fontSize = 36.sp,
                    color = Color(0xFF7AB5D2)
                )
            },
            onClick = {})

        AppDefaultButton(modifier = Modifier
            .aspectRatio(1f)
            .weight(1f),
            content = {
                Text(
                    text = "6",
                    fontSize = 36.sp,
                    color = Color(0xFF7AB5D2)
                )
            },
            onClick = {})

        AppDefaultButton(modifier = Modifier
            .aspectRatio(1f)
            .weight(1f),
            content = {
                Text(
                    text = "C",
                    fontSize = 36.sp,
                    color = Color(0xFF7AB5D2)
                )
            },
            onClick = {})
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Measure.buttonSpacing)
    ) {
        AppDefaultButton(modifier = Modifier
            .aspectRatio(1f)
            .weight(1f),
            content = {
                Text(
                    text = "1",
                    fontSize = 36.sp,
                    color = Color(0xFF7AB5D2)
                )
            },
            onClick = {})

        AppDefaultButton(modifier = Modifier
            .aspectRatio(1f)
            .weight(1f),
            content = {
                Text(
                    text = "2",
                    fontSize = 36.sp,
                    color = Color(0xFF7AB5D2)
                )
            },
            onClick = {})

        AppDefaultButton(modifier = Modifier
            .aspectRatio(1f)
            .weight(1f),
            content = {
                Text(
                    text = "3",
                    fontSize = 36.sp,
                    color = Color(0xFF7AB5D2)
                )
            },
            onClick = {})

        AppDefaultButton(modifier = Modifier
            .aspectRatio(1f)
            .weight(1f),
            content = {
                Icon(
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp),
                    imageVector = ArrowUp,
                    contentDescription = ""
                )
            },
            onClick = {})
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Measure.buttonSpacing)
    ) {
        AppDefaultButton(modifier = Modifier
            .aspectRatio(1f)
            .weight(1f),
            enabled = false,
            content = {
                Text(
                    text = "+/-",
                    fontSize = 24.sp,
                    color = Color(0xFF7AB5D2)
                )
            },
            onClick = {})

        AppDefaultButton(modifier = Modifier
            .aspectRatio(1f)
            .weight(1f),
            content = {
                Text(
                    text = "0",
                    fontSize = 36.sp,
                    color = Color(0xFF7AB5D2)
                )
            },
            onClick = {})

        AppDefaultButton(modifier = Modifier
            .aspectRatio(1f)
            .weight(1f),
            content = {
                Text(
                    text = ",",
                    fontSize = 36.sp,
                    color = Color(0xFF7AB5D2)
                )
            },
            onClick = {})

        AppDefaultButton(modifier = Modifier
            .aspectRatio(1f)
            .weight(1f),
            content = {
                Icon(
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp),
                    imageVector = ArrowDown,
                    contentDescription = ""
                )
            },
            onClick = {})
    }
}
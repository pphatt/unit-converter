package app.unitconverter.enums

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Measure {
    val buttonSpacing: Dp = 28.dp
}

data class UnitInput(
    var value: String, var symbol: String, var name: String
)

interface DisplayableUnit {
    val displayName: String
    val name: String
    val nameWithoutSymbol: String
    val symbol: String
}

enum class ETypes {
    I, O
}

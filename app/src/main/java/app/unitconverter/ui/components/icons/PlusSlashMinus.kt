package app.unitconverter.ui.components.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val PlusSlashMinus: ImageVector
    get() {
        if (_PlusSlashMinus != null) {
            return _PlusSlashMinus!!
        }
        _PlusSlashMinus = ImageVector.Builder(
            name = "PlusSlashMinus",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(1.854f, 14.854f)
                lineToRelative(13f, -13f)
                arcToRelative(
                    0.5f,
                    0.5f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    -0.708f,
                    -0.708f
                )
                lineToRelative(-13f, 13f)
                arcToRelative(
                    0.5f,
                    0.5f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    0.708f,
                    0.708f
                )
                moveTo(4f, 1f)
                arcToRelative(
                    0.5f,
                    0.5f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    0.5f,
                    0.5f
                )
                verticalLineToRelative(2f)
                horizontalLineToRelative(2f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 1f)
                horizontalLineToRelative(-2f)
                verticalLineToRelative(2f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1f, 0f)
                verticalLineToRelative(-2f)
                horizontalLineToRelative(-2f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, -1f)
                horizontalLineToRelative(2f)
                verticalLineToRelative(-2f)
                arcTo(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 4f, 1f)
                moveToRelative(5f, 11f)
                arcToRelative(
                    0.5f,
                    0.5f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    0.5f,
                    -0.5f
                )
                horizontalLineToRelative(5f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 1f)
                horizontalLineToRelative(-5f)
                arcTo(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 9f, 12f)
            }
        }.build()
        return _PlusSlashMinus!!
    }

private var _PlusSlashMinus: ImageVector? = null

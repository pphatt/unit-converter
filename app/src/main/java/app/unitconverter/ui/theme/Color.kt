package app.unitconverter.ui.theme

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import app.unitconverter.ui.components.tabs.TabRowLayout
import komikku.presentation.domain.enums.ETabs

val primaryLight = Color(0xFF000000)
val onPrimaryLight = Color(0xFFFFFFFF)
val primaryContainerLight = Color(0xFF262625)
val onPrimaryContainerLight = Color(0xFFB3B0B0)
val secondaryLight = Color(0xFF3E3E3E)
val onSecondaryLight = Color(0xFFFFFFFF)
val secondaryContainerLight = Color(0xFF616161)
val onSecondaryContainerLight = Color(0xFFFFFFFF)
val tertiaryLight = Color(0xFF5D5E5F)
val onTertiaryLight = Color(0xFFFFFFFF)
val tertiaryContainerLight = Color(0xFFC5C5C5)
val onTertiaryContainerLight = Color(0xFF343536)
val errorLight = Color(0xFFBA1A1A)
val onErrorLight = Color(0xFFFFFFFF)
val errorContainerLight = Color(0xFFFFDAD6)
val onErrorContainerLight = Color(0xFF410002)
val backgroundLight = Color(0xFFFDF8F8)
val onBackgroundLight = Color(0xFF1C1B1B)
val surfaceLight = Color(0xFFFDF8F8)
val onSurfaceLight = Color(0xFF1C1B1B)
val surfaceVariantLight = Color(0xFFE0E3E3)
val onSurfaceVariantLight = Color(0xFF444748)
val outlineLight = Color(0xFF747878)
val outlineVariantLight = Color(0xFFC4C7C7)
val scrimLight = Color(0xFF000000)
val inverseSurfaceLight = Color(0xFF313030)
val inverseOnSurfaceLight = Color(0xFFF4F0EF)
val inversePrimaryLight = Color(0xFFC9C6C5)
val surfaceDimLight = Color(0xFFDDD9D8)
val surfaceBrightLight = Color(0xFFFDF8F8)
val surfaceContainerLowestLight = Color(0xFFFFFFFF)
val surfaceContainerLowLight = Color(0xFFF7F3F2)
val surfaceContainerLight = Color(0xFFF1EDEC)
val surfaceContainerHighLight = Color(0xFFEBE7E6)
val surfaceContainerHighestLight = Color(0xFFE5E2E1)

val primaryDark = Color(0xFFC9C6C5)
val onPrimaryDark = Color(0xFF313030)
val primaryContainerDark = Color(0xFF000000)
val onPrimaryContainerDark = Color(0xFF989595)
val secondaryDark = Color(0xFFC8C6C6)
val onSecondaryDark = Color(0xFF303030)
val secondaryContainerDark = Color(0xFF484848)
val onSecondaryContainerDark = Color(0xFFE4E2E1)
val tertiaryDark = Color(0xFFE1E1E1)
val onTertiaryDark = Color(0xFF2F3131)
val tertiaryContainerDark = Color(0xFFB7B7B7)
val onTertiaryContainerDark = Color(0xFF2A2B2B)
val errorDark = Color(0xFFFFB4AB)
val onErrorDark = Color(0xFF690005)
val errorContainerDark = Color(0xFF93000A)
val onErrorContainerDark = Color(0xFFFFDAD6)
val backgroundDark = Color(0xFF010101)
val onBackgroundDark = Color(0xFFE5E2E1)
val surfaceDark = Color(0xFF010101)
val onSurfaceDark = Color(0xFFFFFFFF)
val surfaceVariantDark = Color(0xFF444748)
val onSurfaceVariantDark = Color(0xFF525252)
val outlineDark = Color(0xFF8E9192)
val outlineVariantDark = Color(0xFF444748)
val scrimDark = Color(0xFF000000)
val inverseSurfaceDark = Color(0xFFE5E2E1)
val inverseOnSurfaceDark = Color(0xFF313030)
val inversePrimaryDark = Color(0xFF5F5E5E)
val surfaceDimDark = Color(0xFF010101)
val surfaceBrightDark = Color(0xFF3A3939)
val surfaceContainerLowestDark = Color(0xFF0E0E0E)
val surfaceContainerLowDark = Color(0xFF1C1B1B)
val surfaceContainerDark = Color(0xFF201F1F)
val surfaceContainerHighDark = Color(0xFF2B2A2A)
val surfaceContainerHighestDark = Color(0xFF363434)

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)

@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)

@Composable
fun ReplyAppPreviewLight() {
    UnitConverterTheme {
        val scope = rememberCoroutineScope()
        val pagerState = rememberPagerState(pageCount = { ETabs.entries.size })
        val tabIndex = remember { derivedStateOf { pagerState.currentPage } }

        Scaffold(
            topBar = { TopAppBar(title = { Text(text = "Unit converter") }) }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        start = paddingValues.calculateStartPadding(LayoutDirection.Rtl),
                        end = paddingValues.calculateStartPadding(LayoutDirection.Ltr)
                    )
            ) {
                TabRowLayout(
                    scope = scope,
                    selectedIndex = tabIndex.value,
                    pagerState = pagerState
                )

                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) { page ->
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = ETabs.entries[page].text)
                    }
                }
            }
        }
    }
}

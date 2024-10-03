package app.unitconverter.ui.main

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import app.unitconverter.ui.components.tabs.TabRowLayout
import app.unitconverter.ui.theme.UnitConverterTheme
import komikku.presentation.domain.enums.ETabs

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                Color.TRANSPARENT, Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.auto(
                Color.TRANSPARENT, Color.TRANSPARENT
            )
        )

        setContent {
            UnitConverterTheme {
                val scope = rememberCoroutineScope()
                val pagerState = rememberPagerState(pageCount = { ETabs.entries.size })
                val tabIndex = remember { derivedStateOf { pagerState.currentPage } }

                Scaffold(
                    topBar = {
                        TopAppBar(title = {
                            Text(
                                text = "Unit converter",
                                fontWeight = FontWeight.Bold
                            )
                        })
                    }
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
    }
}

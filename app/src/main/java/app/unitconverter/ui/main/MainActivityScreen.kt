package app.unitconverter.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import app.unitconverter.screen.area.AreaScreen
import app.unitconverter.screen.length.LengthScreen
import app.unitconverter.ui.components.tabs.TabRowLayout
import komikku.presentation.domain.enums.ETabs

@Composable
fun MainActivityScreen() {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { ETabs.entries.size })
    val tabIndex = remember { derivedStateOf { pagerState.currentPage } }

    Scaffold(modifier = Modifier
        .background(color = MaterialTheme.colorScheme.surface) // this is hidden under the content UI
        .systemBarsPadding()
        .padding(start = 5.dp), topBar = {
        TopAppBar(title = {
            Text(
                text = "Unit converter", fontWeight = FontWeight.Bold
            )
        })
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = 10.dp,
                    start = paddingValues.calculateStartPadding(LayoutDirection.Rtl),
                    end = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                )
        ) {
            Column(modifier = Modifier.weight(0.54f)) {
                TabRowLayout(
                    scope = scope,
                    selectedIndex = tabIndex.value,
                    pagerState = pagerState
                )

                HorizontalPager(
                    state = pagerState, modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) { page ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = 10.dp, end = 16.dp, bottom = 10.dp, start = 16.dp
                            )
                    ) {
                        HorizontalDivider(
                            modifier = Modifier.fillMaxWidth(), thickness = 1.dp
                        )

                        when (page) {
                            0 -> {
                                LengthScreen(
                                    modifier = Modifier.weight(1f),
                                )
                            }

                            1 -> {
                                AreaScreen(
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }

                        HorizontalDivider(
                            modifier = Modifier.fillMaxWidth(), thickness = 1.dp
                        )
                    }
                }
            }

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .weight(0.46f)
                    .fillMaxWidth()
                    .padding(
                        top = 20.dp, bottom = 0.dp, start = 16.dp, end = 16.dp
                    )
            ) {
            }
        }
    }
}
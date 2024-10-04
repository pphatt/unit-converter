package app.unitconverter.ui.components.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import komikku.presentation.domain.enums.ETabs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TabRowLayout(
    scope: CoroutineScope,
    selectedIndex: Int,
    pagerState: PagerState
) {
    ScrollableTabRow(
        selectedTabIndex = selectedIndex,
        modifier = Modifier.fillMaxWidth(),
        edgePadding = 16.dp,
        indicator = {},
        divider = {}
    ) {
        ETabs.entries.forEachIndexed { index, currentTab ->
            Tab(
                modifier = Modifier
                    .zIndex(1f)
                    .wrapContentSize()
                    .height(30.dp)
                    .clip(shape = RoundedCornerShape(50))
                    .background(
                        color = if (selectedIndex == index) Color(0xFF1B1B1B) else Color.Transparent,
                        shape = RoundedCornerShape(50)
                    ),
                selected = selectedIndex == index,
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = MaterialTheme.colorScheme.outline,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(currentTab.ordinal)
                    }
                },
                text = {
                    Text(
                        text = currentTab.text,
                        fontSize = 14.sp,
                        fontWeight = if (selectedIndex == index) FontWeight.Bold else FontWeight.Normal
                    )
                },
            )
        }
    }
}

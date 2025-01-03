package com.zrq.wanandroid.screen.system

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zrq.wanandroid.type.Children
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SystemDetailScreen(list: List<Children>, index: Int) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = index) { list.size }
    Column {
        ScrollableTabRow(
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = pagerState.currentPage
        ) {
            list.forEachIndexed { index, it ->
                Text(
                    modifier = Modifier
                        .clickable {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                        .padding(10.dp),
                    text = it.name,
                    textAlign = TextAlign.Center
                )
            }
        }
        HorizontalPager(state = pagerState) {
            Text(modifier = Modifier.fillMaxSize(), text = list[pagerState.currentPage].name)
        }
    }
}
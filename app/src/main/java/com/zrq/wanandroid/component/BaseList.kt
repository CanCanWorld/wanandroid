package com.zrq.wanandroid.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.zrq.wanandroid.ui.theme.Black5
import kotlinx.coroutines.launch

@Composable
fun BaseList(
    modifier: Modifier = Modifier,
    listSize: Int,
    refresh: suspend () -> Unit = {},
    getMore: suspend () -> Unit = {},
    loadContent: @Composable (() -> Unit)? = null,
    content: LazyListScope.() -> Unit,
) {
    var isLoadMore by remember { mutableStateOf(false) }
    var isRefresh by remember { mutableStateOf(false) }
    val listState = rememberLazyListState()
    val lastVisibleIndex by remember { derivedStateOf { listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0 } }
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(lastVisibleIndex) {
        if (!isLoadMore) {
            if (listSize > 0 && lastVisibleIndex >= listSize - 5) {
                coroutineScope.launch {
                    isLoadMore = true
                    getMore()
                    isLoadMore = false
                }
            }
        }
    }
    SwipeRefresh(
        modifier = modifier,
        state = rememberSwipeRefreshState(isRefreshing = isRefresh),
        onRefresh = {
            coroutineScope.launch {
                isRefresh = true
                refresh()
                isRefresh = false
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            state = listState
        ) {
            content()
            if (isLoadMore) {
                item {
                    if (loadContent == null) {
                        LinearProgressIndicator(
                            modifier = Modifier
                                .fillMaxWidth(),
                            color = Black5
                        )
                    } else {
                        loadContent()
                    }
                }
            }
        }
    }
}
package com.zrq.wanandroid.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zrq.wanandroid.component.BaseList
import com.zrq.wanandroid.nav.Route
import com.zrq.wanandroid.screen.home.component.ArticleItem
import com.zrq.wanandroid.screen.home.component.Banners
import com.zrq.wanandroid.screen.home.component.Search
import com.zrq.wanandroid.ui.theme.Black5
import com.zrq.wanandroid.utils.LocalNavController


@Composable
fun HomeScreen() {
    val vm = viewModel<HomeViewModel>()
    val navHostController = LocalNavController.current

    Column {
        Search(Modifier.padding(top = 20.dp))
        BaseList(
            modifier = Modifier.fillMaxSize(),
            listSize = vm.articleList.size,
            refresh = {
                vm.refresh()
            },
            getMore = {
                vm.getMore()
            },
            loadContent = {
                LinearProgressIndicator(
                    modifier = Modifier
                        .padding(bottom = 80.dp)
                        .fillMaxWidth(), color = Black5
                )
            }
        ) {
            item {
                Banners(Modifier.padding(vertical = 10.dp))
            }
            items(vm.articleList.size) {
                ArticleItem(vm.articleList[it]) {
                    navHostController.navigate("${Route.Web.route}?url=${vm.articleList[it].link}")
                }
            }
        }
    }
}

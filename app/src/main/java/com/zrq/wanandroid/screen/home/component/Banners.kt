package com.zrq.wanandroid.screen.home.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.zrq.wanandroid.screen.home.HomeViewModel

@OptIn(ExperimentalFoundationApi::class, ExperimentalCoilApi::class)
@Composable
fun Banners(modifier: Modifier = Modifier) {
    val vm = viewModel<HomeViewModel>()
    Column(modifier = modifier) {
        val pagerState = rememberPagerState { vm.bannerList.size }
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            state = pagerState
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal =  20.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.FillBounds,
                painter = rememberImagePainter(data = vm.bannerList[it].imagePath),
                contentDescription = vm.bannerList[it].desc
            )
        }
    }
}
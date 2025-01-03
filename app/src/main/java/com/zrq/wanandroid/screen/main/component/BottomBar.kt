package com.zrq.wanandroid.screen.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zrq.wanandroid.screen.main.MainViewModel
import com.zrq.wanandroid.ui.theme.BottomBarBg

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
) {
    val vm: MainViewModel = viewModel()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
            .shadow(4.dp, RoundedCornerShape(20.dp))
            .background(BottomBarBg)
    ) {
        vm.bottomTabs.forEachIndexed { index, item ->
            BottomTab(
                modifier = Modifier.weight(1f),
                bottomTab = item,
                isSelected = vm.selectIndex == index,
            ) {
                vm.selectIndex = index
            }
        }
    }
}
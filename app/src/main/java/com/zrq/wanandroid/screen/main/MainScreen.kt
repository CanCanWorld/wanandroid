package com.zrq.wanandroid.screen.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zrq.wanandroid.screen.home.HomeScreen
import com.zrq.wanandroid.screen.home.HomeViewModel
import com.zrq.wanandroid.screen.main.component.BottomBar
import com.zrq.wanandroid.screen.mine.MineScreen
import com.zrq.wanandroid.screen.square.SquareScreen
import com.zrq.wanandroid.screen.system.SystemScreen
import com.zrq.wanandroid.screen.system.SystemViewModel


@Composable
fun MainScreen() {
    val vm: MainViewModel = viewModel()
    val homeVM : HomeViewModel = viewModel()
    val systemVM: SystemViewModel = viewModel()
    LaunchedEffect(Unit) {
        homeVM.init()
        systemVM.init()
    }
    Box(modifier = Modifier.fillMaxSize()) {
        when (vm.selectIndex) {
            0 -> HomeScreen()
            1 -> SystemScreen()
            2 -> SquareScreen()
            3 -> MineScreen()
            else -> {}
        }
        BottomBar(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
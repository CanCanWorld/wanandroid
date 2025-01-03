package com.zrq.wanandroid.screen.system

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zrq.wanandroid.component.BaseList
import com.zrq.wanandroid.screen.system.component.SystemItem

@Composable
fun SystemScreen() {
    val vm: SystemViewModel = viewModel()

    BaseList(
        listSize = vm.systemList.size,
        refresh = { vm.refresh() },
    ) {
        items(vm.systemList.size) {
            SystemItem(index = it)
        }
        item {
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}
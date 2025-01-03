package com.zrq.wanandroid.screen.main

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.zrq.wanandroid.R
import com.zrq.wanandroid.base.BaseViewModel
import com.zrq.wanandroid.type.BottomTabType

class MainViewModel(application: Application) : BaseViewModel(application) {

    val bottomTabs = listOf(
        BottomTabType("首页", R.drawable.ic_home),
        BottomTabType("体系", R.drawable.ic_tixi),
        BottomTabType("广场", R.drawable.ic_guangchang),
        BottomTabType("我的", R.drawable.ic_mine),
    )
    var selectIndex by mutableIntStateOf(0)

}
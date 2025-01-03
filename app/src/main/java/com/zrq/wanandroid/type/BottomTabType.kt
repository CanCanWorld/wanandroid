package com.zrq.wanandroid.type

import androidx.annotation.DrawableRes

/**
 * 底部导航栏Tab的实体类
 */
data class BottomTabType(
    var title: String,
    @DrawableRes var iconRes: Int
)
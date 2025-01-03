package com.zrq.wanandroid.nav

sealed class Route(var route: String) {

    /**
     * 主页
     */
    data object Main : Route("main")

    /**
     * 搜索页
     */
    data object Search : Route("search")

    /**
     * web页
     */
    data object Web : Route("web")

    /**
     * 体系详情页
     */
    data object SystemDetail : Route("system_detail")

}
package com.zrq.wanandroid.http

import com.zrq.wanandroid.http.Constants.ARTICLE_LIST
import com.zrq.wanandroid.http.Constants.BANNER_JSON
import com.zrq.wanandroid.http.Constants.TREE_JSON
import com.zrq.wanandroid.type.ArticleEntity
import com.zrq.wanandroid.type.BannerEntity
import com.zrq.wanandroid.type.DataEntity
import com.zrq.wanandroid.type.PageEntity
import com.zrq.wanandroid.type.SystemEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    /**
     * 首页banner
     */
    @GET(BANNER_JSON)
    suspend fun getBanner(): DataEntity<List<BannerEntity>>

    /**
     * 首页文章列表
     */
    @GET("$ARTICLE_LIST/{page}/json")
    suspend fun getArticleList(
        @Path("page") page: Int
    ): DataEntity<PageEntity<ArticleEntity>>
    /**
     * 体系数据
     */
    @GET(TREE_JSON)
    suspend fun getSystemList(): DataEntity<List<SystemEntity>>

}
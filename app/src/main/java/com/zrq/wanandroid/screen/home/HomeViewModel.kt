package com.zrq.wanandroid.screen.home

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.viewModelScope
import com.zrq.wanandroid.base.BaseViewModel
import com.zrq.wanandroid.type.ArticleEntity
import com.zrq.wanandroid.type.BannerEntity
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : BaseViewModel(application) {

    val bannerList = mutableStateListOf<BannerEntity>()
    val articleList = mutableStateListOf<ArticleEntity>()
    var page = 0

    fun init() {
        viewModelScope.launch {
            launch { getBanner() }
            refresh()
        }
    }

    suspend fun refresh() {
        page = 0
        articleList.clear()
        getArticleList()
    }

    suspend fun getMore() {
        page++
        getArticleList()
    }

    suspend fun getBanner() {
        Log.d(TAG, "获取轮播图")
        bannerList.clear()
        request(
            block = { apiService.getBanner() },
            success = {
                bannerList.addAll(it)
                Log.d(TAG, "获取轮播图成功")
            }
        )
    }

    suspend fun getArticleList() {
        Log.d(TAG, "获取文章列表")
        request(
            block = { apiService.getArticleList(page) },
            success = {
                articleList.addAll(it.datas)
                Log.d(TAG, "获取文章列表成功")
            }
        )
    }
}
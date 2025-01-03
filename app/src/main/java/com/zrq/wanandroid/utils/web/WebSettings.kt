package com.zrq.wanandroid.utils.web

import android.annotation.SuppressLint
import android.webkit.WebSettings
import android.webkit.WebView

@SuppressLint("SetJavaScriptEnabled")
fun WebView.initSettings() {
    settings.apply {

        // 设置支持多窗口
        setSupportMultipleWindows(true);

        //  设置支持自动打开新窗口
        javaScriptCanOpenWindowsAutomatically = true

        // 允许访问文件
        allowFileAccess = true

        // 设置是否允许访问文件数据
        allowContentAccess = true

        // 缓存模式
        cacheMode = WebSettings.LOAD_DEFAULT

        // 设置支持DomStorage
        domStorageEnabled = true

        // 支持JavaScript
        javaScriptEnabled = true

        // 设置允许JS弹窗
        javaScriptCanOpenWindowsAutomatically = true

        // 自适应屏幕
        useWideViewPort = true

        // 显示网页或者图片flash的时候,充满全屏
        loadWithOverviewMode = true

        // JS打开新窗口
        javaScriptCanOpenWindowsAutomatically = true

        // 允许加载Assets和resources文件
        allowFileAccess = true

        // 可以 使用content://加载文件
        allowContentAccess = true

        // 允许运行在一个URL环境（the context of a file scheme URL）中的JavaScript访问来自其他URL环境的内容
        allowFileAccessFromFileURLs = true

        // 否允许运行在一个file schema URL环境下的JavaScript访问来自其他任何来源的内容，包括其他file schema URLs
        allowUniversalAccessFromFileURLs = true

        // 不显示缩放按钮
        builtInZoomControls = false

        // 不支持缩放
        setSupportZoom(false)

        // 设置WebView是否通过手势触发播放媒体，默认是true，需要手势触发
        mediaPlaybackRequiresUserGesture = false

        // 开启 DOM storage API 功能
        domStorageEnabled = true

        // 开启 DB storage API 功能
        databaseEnabled = true

        // 设置缓存模式，非常重要，决定了webview缓存资源的方式
        cacheMode = WebSettings.LOAD_DEFAULT

        // https请求的页面中嵌套了http的图片链接时，会导致图片不显示
        mixedContentMode = WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE
    }
}

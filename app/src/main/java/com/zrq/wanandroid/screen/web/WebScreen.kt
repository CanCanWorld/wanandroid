package com.zrq.wanandroid.screen.web

import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.zrq.wanandroid.utils.web.initSettings

@Composable
fun WebScreen(url: String) {
    println(url)
    AndroidView(
        factory = {
            WebView(it).apply {
                initSettings()
                loadUrl(url)
            }
        }
    )
}
package com.zrq.wanandroid.type

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class SystemEntity(
    val articleList: List<Any>,
    val author: String,
    val children: List<Children>,
    val courseId: Int,
    val cover: String,
    val desc: String,
    val id: Int,
    val lisense: String,
    val lisenseLink: String,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val type: Int,
    val userControlSetTop: Boolean,
    val visible: Int,
)
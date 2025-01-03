package com.zrq.wanandroid.type

data class DataEntity<T>(
    val data: T,
    val errorCode: Int,
    val errorMsg: String
)
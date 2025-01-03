package com.zrq.wanandroid.screen.system

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.viewModelScope
import com.zrq.wanandroid.base.BaseViewModel
import com.zrq.wanandroid.type.SystemEntity
import kotlinx.coroutines.launch

class SystemViewModel(application: Application) : BaseViewModel(application) {
    val systemList = mutableStateListOf<SystemEntity>()
    var isExpends = mutableStateListOf<Boolean>()

    fun init() {
        viewModelScope.launch {
            refresh()
        }
    }

    suspend fun refresh() {
        systemList.clear()
        getSystemList()
    }

    suspend fun getSystemList() {
        request(
            block = {
                apiService.getSystemList()
            },
            success = {
                Log.d(TAG, "getSystemList: $it")
                repeat(it.size) {
                    isExpends.add(false)
                }
                systemList.addAll(it)
            }
        )
    }

}
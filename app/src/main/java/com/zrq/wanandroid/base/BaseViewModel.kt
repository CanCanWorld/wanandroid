package com.zrq.wanandroid.base

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.zrq.wanandroid.http.RetrofitClient
import com.zrq.wanandroid.type.DataEntity
import kotlinx.coroutines.delay

open class BaseViewModel(private val application: Application) : AndroidViewModel(application) {

    protected val TAG = javaClass.name

    protected val apiService by lazy { RetrofitClient.apiService }

    fun showToast(msg: String) {
        Toast.makeText(application, msg, Toast.LENGTH_SHORT).show()
    }

    suspend fun <T> request(
        block: suspend () -> DataEntity<T>,
        success: (T) -> Unit = {},
        error: (Throwable) -> Unit = {},
        finally: () -> Unit = {}
    ) {
        try {
            val data = block()
            if (data.errorCode == 0) {
                success(data.data)
            } else {
                showToast("系统异常（${data.errorMsg}）")
                error(Throwable(data.errorMsg))
            }
        } catch (e: Exception) {
            showToast("网络异常")
            e.printStackTrace()
            error(e)
        } finally {
            finally()
            delay(200)
        }
    }
}
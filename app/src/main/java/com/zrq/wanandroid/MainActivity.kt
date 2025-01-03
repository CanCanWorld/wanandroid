package com.zrq.wanandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.zrq.wanandroid.nav.MainNavHost
import com.zrq.wanandroid.ui.theme.MainBg
import com.zrq.wanandroid.ui.theme.WanandroidTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WanandroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .background(MainBg)
                            .padding(innerPadding)
                    ) {
                        MainNavHost()
                    }
                }
            }
        }
    }
}

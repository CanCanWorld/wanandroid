package com.zrq.wanandroid.screen.square

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SquareScreen() {
    Column (modifier = Modifier.fillMaxSize()){
        Text(text = "SquareScreen")
    }
}
package com.zrq.wanandroid.screen.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zrq.wanandroid.R
import com.zrq.wanandroid.ui.theme.SearchBg
import com.zrq.wanandroid.ui.theme.SearchIconBg
import com.zrq.wanandroid.ui.theme.White

@Composable
fun Search(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(start = 20.dp, end = 20.dp, bottom = 4.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp))
            .background(SearchBg)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(40.dp)
                .padding(10.dp),
        ) {
        }

        Icon(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(SearchIconBg)
                .size(40.dp)
                .padding(12.dp),
            painter = painterResource(id = R.drawable.img_search),
            tint = White,
            contentDescription = "搜索"
        )
    }
}
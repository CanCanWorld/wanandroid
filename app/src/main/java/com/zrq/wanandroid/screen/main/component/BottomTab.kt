package com.zrq.wanandroid.screen.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zrq.wanandroid.type.BottomTabType
import com.zrq.wanandroid.ui.theme.BottomBarTabBg

@Composable
fun BottomTab(
    modifier: Modifier = Modifier,
    bottomTab: BottomTabType,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(if (isSelected) BottomBarTabBg else Color.Transparent)
            .clickable {
                onClick()
            }
            .padding(top = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = bottomTab.iconRes),
            tint = if (isSelected) Color(0xFF3f6560) else Color.Gray,
            contentDescription = bottomTab.title
        )
        Text(
            text = bottomTab.title,
            fontSize = 12.sp,
            color = if (isSelected) Color(0xFF3f6560) else Color.Gray
        )
    }
}
package com.zrq.wanandroid.screen.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zrq.wanandroid.type.ArticleEntity
import com.zrq.wanandroid.ui.theme.AuthorTagBg
import com.zrq.wanandroid.ui.theme.Black3
import com.zrq.wanandroid.ui.theme.Black5
import com.zrq.wanandroid.ui.theme.MainBg
import com.zrq.wanandroid.ui.theme.ShareTagBg

@Composable
fun ArticleItem(
    article: ArticleEntity,
    onClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MainBg)
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Black3)
            .clickable {
                onClick()
            }
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .clip(CircleShape)
                            .background(if (article.shareUser.isNotEmpty()) ShareTagBg else AuthorTagBg)
                            .padding(horizontal = 1.dp),
                        text = if (article.shareUser.isNotEmpty()) "分享" else "作者",
                        fontSize = 10.sp,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = article.shareUser.ifEmpty { article.author },
                    fontSize = 14.sp,
                )
            }
            Text(
                text = article.niceShareDate,
                fontSize = 11.sp,
            )
        }
        Text(
            modifier = Modifier.padding(horizontal = 2.dp, vertical = 10.dp),
            text = article.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Row {
            if (article.chapterName.isNotEmpty()) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Black5)
                        .padding(horizontal = 4.dp),
                    text = article.chapterName,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Thin
                )
            }
            if (article.superChapterName.isNotEmpty()) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Black5)
                        .padding(horizontal = 4.dp),
                    text = article.superChapterName,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Thin
                )
            }
        }
    }
}
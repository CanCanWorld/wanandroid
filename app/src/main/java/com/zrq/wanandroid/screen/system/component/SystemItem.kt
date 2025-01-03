package com.zrq.wanandroid.screen.system.component

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.gson.Gson
import com.zrq.wanandroid.nav.Route
import com.zrq.wanandroid.screen.system.SystemViewModel
import com.zrq.wanandroid.ui.theme.Black3
import com.zrq.wanandroid.ui.theme.SystemTagBg
import com.zrq.wanandroid.ui.theme.White
import com.zrq.wanandroid.utils.LocalNavController

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SystemItem(
    modifier: Modifier = Modifier,
    index: Int
) {

    val vm: SystemViewModel = viewModel()
    val textMeasurer = rememberTextMeasurer()
    val density = LocalDensity.current
    val interactionSource = remember { MutableInteractionSource() }
    val navHostController = LocalNavController.current
    Log.d("TAG", "vm111: $vm")

    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(8.dp))
            .background(Black3)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { vm.isExpends[index] = !vm.isExpends[index] }
            .padding(8.dp)
    ) {
        val systemEntity = vm.systemList[index]
        Text(text = systemEntity.name)
        FlowRow(
            modifier = Modifier
                .fillMaxSize()
        ) {
            systemEntity.children.forEachIndexed { childIndex,  child ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 6.dp, vertical = 3.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(SystemTagBg)
                        .clickable {
                            if (vm.isExpends[index]) {
                                navHostController.navigate("${Route.SystemDetail.route}?data=${Gson().toJson(systemEntity.children)}&index=$childIndex")
                            } else {
                                vm.isExpends[index] = true
                            }
                        }
                        .padding(horizontal = 4.dp, vertical = 2.dp)
                        .width(with(density) { textMeasurer.measure(child.name).size.width.toDp() })
                        .animateContentSize(),
                ) {
                    if (vm.isExpends[index]) {
                        Text(
                            modifier = Modifier
                                .align(Alignment.Center),
                            text = child.name,
                            color = White,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}
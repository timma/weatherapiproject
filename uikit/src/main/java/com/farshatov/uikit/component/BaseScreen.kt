package com.farshatov.uikit

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.farshatov.uikit.resources.UiColors
import com.farshatov.uikit.resources.UiTextStyle

@Composable
fun TitleString(
    modifier: Modifier = Modifier,
    title: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .drawBehind {
                drawLine(
                    color = UiColors.BLUE.value,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 2.dp.toPx()
                )
            }
    ) {
        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            text = title,
            textAlign = TextAlign.Center,
            style = UiTextStyle.H1.style
        )
    }
}

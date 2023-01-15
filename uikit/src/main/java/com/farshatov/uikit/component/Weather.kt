package com.farshatov.uikit.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.farshatov.common.R
import com.farshatov.uikit.resources.UiColors
import com.farshatov.uikit.resources.UiTextStyle
import com.farshatov.uikit.resources.defaultPadding

@Composable
fun WeatherItem(
    precipMm: String,
    windKph: String,
    tempC: String,
    feelslikeC: String,
    humidity: String,
    gustKph: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = defaultPadding),
        elevation = 4.dp
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(
                        start = defaultPadding,
                        end = defaultPadding,
                        top = defaultPadding
                    )
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.precip_string),
                    style = UiTextStyle.TITLE_BODY.style
                )
                Text(
                    text = stringResource(id = R.string.windSpeed_string),
                    style = UiTextStyle.TITLE_BODY.style
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = defaultPadding,
                        end = defaultPadding,
                        bottom = defaultPadding
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = precipMm,
                    color = UiColors.RED.value,
                    style = UiTextStyle.TITLE_BODY.style
                )
                Text(
                    text = windKph,
                    color = UiColors.RED.value,
                    style = UiTextStyle.TITLE_BODY.style
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(
                        start = defaultPadding,
                        end = defaultPadding
                    ),
                textAlign = TextAlign.Center,
                text = tempC + stringResource(id = R.string.celsius),
                style = UiTextStyle.H1.style
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.feelslikeTemp) + " " +
                    feelslikeC +
                    stringResource(id = R.string.celsius),
                style = UiTextStyle.TITLE_BODY.style
            )
            Row(
                modifier = Modifier
                    .padding(
                        start = defaultPadding,
                        end = defaultPadding,
                        top = defaultPadding
                    )
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.humidity_string),
                    style = UiTextStyle.TITLE_BODY.style
                )
                Text(
                    text = stringResource(id = R.string.gust_string),
                    style = UiTextStyle.TITLE_BODY.style
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = defaultPadding,
                        end = defaultPadding,
                        bottom = defaultPadding
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = humidity,
                    color = UiColors.RED.value,
                    style = UiTextStyle.TITLE_BODY.style
                )
                Text(
                    text = gustKph,
                    color = UiColors.RED.value,
                    style = UiTextStyle.TITLE_BODY.style
                )
            }
        }
    }
}

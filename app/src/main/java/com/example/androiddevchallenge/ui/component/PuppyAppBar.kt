package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R


@Composable
fun PuppyAppBar(isDark: Boolean = true, onModeChanged: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Image(
            modifier = Modifier
                .absolutePadding(left = 16.dp)
                .align(Alignment.CenterVertically)
                .size(36.dp),
            painter = painterResource(id = R.drawable.ic_puppy),
            contentDescription = null
        )
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .absolutePadding(left = 16.dp)
                .align(Alignment.CenterVertically)
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            modifier = Modifier
                .absolutePadding(right = 16.dp)
                .align(Alignment.CenterVertically)
                .size(40.dp)
                .clickable {
                    onModeChanged(!isDark)
                },
            painter = painterResource(id = R.drawable.ic_dark),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary)
        )
    }
}

@Preview
@Composable
fun PuppyAppBarPreview() {
    PuppyAppBar(onModeChanged = { })
}
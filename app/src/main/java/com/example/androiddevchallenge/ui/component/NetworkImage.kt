package com.example.androiddevchallenge.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun NetworkImage(
    data: Any,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop
) {
    CoilImage(
        data = data,
        modifier = modifier,
        contentDescription = null,
        contentScale = contentScale,
        fadeIn = true
    )
}
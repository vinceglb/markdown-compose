package com.vinceglb.markdown.compose

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.seiko.imageloader.ImageLoader
import com.seiko.imageloader.LocalImageLoader
import com.seiko.imageloader.rememberImagePainter

@Composable
internal fun ImageUrl(
    url: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    contentDescription: String? = null,
) {
    CompositionLocalProvider(
        LocalImageLoader provides generateImageLoader(),
    ) {
        Image(
            painter = rememberImagePainter(url),
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale,
        )
    }
}

@Composable
expect fun generateImageLoader(): ImageLoader

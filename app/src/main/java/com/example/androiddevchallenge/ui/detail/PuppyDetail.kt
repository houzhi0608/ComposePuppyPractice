package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.androiddevchallenge.ui.component.NetworkImage
import com.example.androiddevchallenge.viewmodel.puppyList

@Composable
fun PuppyDetail(puppyId: Int, back: () -> Unit) {
    val puppy = puppyList.first {
        it.id == puppyId
    }
    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { back() },
            modifier = Modifier
                .zIndex(8f)
                .align(Alignment.TopStart)
                .padding(start = 4.dp)
        ) {
            Icon(imageVector = Icons.TwoTone.ArrowBack, contentDescription = null)
        }
        Column {
            NetworkImage(
                data = puppy.image,
                modifier = Modifier
                    .fillMaxHeight(fraction = 0.45f)
                    .fillMaxWidth()
            )
            Card(
                elevation = if (MaterialTheme.colors.isLight) 8.dp else 0.dp,
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                Column {
                    Text(text = puppy.name)
                    Text(text = puppy.breed)
                    Text(text = puppy.brithDate)
                    Text(text = puppy.location)
                    Text(text = puppy.desc)
                }
            }
        }
        Button(
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = {
            }
        ) {
            Text("Adopt Me")
        }
    }
}

@Preview
@Composable
fun PuppyDetailPreview() {
    PuppyDetail(puppyId = 7245, back = { /*TODO*/ })
}
package com.example.androiddevchallenge.ui.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.component.PuppyAppBar
import com.example.androiddevchallenge.ui.component.PuppyListItem
import com.example.androiddevchallenge.viewmodel.puppyList

@Composable
fun PuppyList(list: List<Puppy>, onPuppyClick: (Int) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        content = {
            items(list) { puppy ->
                PuppyListItem(puppy = puppy, onPuppyClick = onPuppyClick)
            }
        })
}

@Composable
fun PuppyScreen(onPuppyClick: (Int) -> Unit = {}) {
    Column {
        PuppyAppBar(onModeChanged = { /*TODO*/ })
        PuppyList(puppyList, onPuppyClick)
    }
}
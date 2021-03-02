/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.component.PuppyAppBar
import com.example.androiddevchallenge.ui.component.PuppyListItem
import com.example.androiddevchallenge.viewmodel.puppyList

@Composable
fun PuppyList(list: List<Puppy>, onPuppyClick: (Int) -> Unit, darkTheme: MutableState<Boolean>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        content = {
            items(list) { puppy ->
                PuppyListItem(puppy = puppy, onPuppyClick = onPuppyClick, darkTheme)
            }
        }
    )
}

@Composable
fun PuppyScreen(
    onPuppyClick: (Int) -> Unit = {},
    darkTheme: MutableState<Boolean> = mutableStateOf(true)
) {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            PuppyAppBar(darkTheme)
            PuppyList(puppyList, onPuppyClick, darkTheme)
        }
    }
}

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
package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.MainDestinations.PUPPY_DETAIL_ID_KEY
import com.example.androiddevchallenge.ui.detail.PuppyDetail
import com.example.androiddevchallenge.ui.list.PuppyScreen

object MainDestinations {
    const val PUPPY_LIST = "list"
    const val PUPPY_DETAIL = "detail"
    const val PUPPY_DETAIL_ID_KEY = "puppyId"
}

@Composable
fun NavGraph(
    startDestination: String = MainDestinations.PUPPY_LIST,
    darkTheme: MutableState<Boolean>
) {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.PUPPY_LIST) {
            PuppyScreen(actions.puppySelected, darkTheme)
        }
        composable(
            "${MainDestinations.PUPPY_DETAIL}/{$PUPPY_DETAIL_ID_KEY}",
            arguments = listOf(navArgument(PUPPY_DETAIL_ID_KEY) { type = NavType.IntType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)

            PuppyDetail(
                puppyId = arguments.getInt(PUPPY_DETAIL_ID_KEY),
                back = actions.back
            )
        }
    }
}

class MainActions(navController: NavHostController) {
    val puppySelected: (Int) -> Unit = { puppyId: Int ->
        navController.navigate("${MainDestinations.PUPPY_DETAIL}/$puppyId")
    }
    val back: () -> Unit = {
        navController.navigateUp()
    }
}

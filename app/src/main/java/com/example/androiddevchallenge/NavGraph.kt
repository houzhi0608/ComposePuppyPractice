package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
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

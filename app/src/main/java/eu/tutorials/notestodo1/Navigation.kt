package eu.tutorials.notestodo1


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun SetupNavGraph(modifier: Modifier = Modifier, viewModel: NotesViewModel = viewModel(),
                  navController : NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.First.route
    ) {
        composable(route = Screen.First.route) {
            FrontPage(modifier = modifier, navController = navController, viewModel = viewModel)
        }

        composable(route = Screen.Second1.route){

            NotesScreen(modifier = modifier , navController = navController, viewModel = viewModel)
        }
//        composable(route = Screen.Third.route){
//            NotesDetail(navController = navController, noteId =0L, viewModel = viewModel)
//        }
        composable(
            route = Screen.Third.route+"/{noteId}",
            arguments = listOf(
                navArgument("noteId") { type = NavType.IntType }
            )
        )
        { backStackEntry ->
            val noteId = backStackEntry.arguments?.getInt("noteId") ?: -1

                NotesDetail(navController = navController, noteId = noteId.toLong(), viewModel = viewModel)

        }
    }
    }




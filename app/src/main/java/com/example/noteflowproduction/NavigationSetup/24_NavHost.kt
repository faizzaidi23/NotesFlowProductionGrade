package com.example.noteflowproduction.NavigationSetup

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.noteflowproduction.UserInterface.HomeScreen
import com.example.noteflowproduction.UserInterface.NoteDetailScreen
import com.example.noteflowproduction.ViewModels.NoteViewModel

@Composable
fun AppNavHost(
    modifier:Modifier= Modifier,
    navController: NavHostController= rememberNavController(),
    startDestination:String= Screen.HomeScreen.route,
    noteViewModel: NoteViewModel,

){
    NavHost(
        modifier=modifier,
        navController =navController,
        startDestination = startDestination
    ){

        //For home screen
      composable(
          route=Screen.HomeScreen.route
      ){
          HomeScreen(navController=navController, viewModel = noteViewModel)
      }


        //Editor Screen
      composable(route=Screen.EditorScreen.route){

      }

        //NoteDetail Screen
        composable(
           route= "detail/{noteId}",
            arguments = listOf(
                navArgument("noteId") { type = NavType.IntType }
            )
        ){backStackEntry ->
            val noteId = backStackEntry.arguments?.getInt("noteId") ?: 0
            NoteDetailScreen(
                noteId = noteId,
                onNavigateBack = { navController.popBackStack() },
                viewModel = noteViewModel
            )
        }

        //Folder Screen
        composable(
           route= Screen.FolderScreen.route
        ){

        }

        //Tag Screen

        composable(
           route= Screen.TagScreen.route
        ) {

        }

        //Search Screen

        composable(
          route=  Screen.SearchScreen.route
        ) {

        }


    }

}
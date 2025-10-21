package com.example.noteflowproduction.NavigationSetup

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost(
    modifier:Modifier= Modifier,
    navController: NavHostController= rememberNavController(),
    startDestination:String= Screen.HomeScreen.route
){
    NavHost(
        modifier=modifier,
        navController =navController,
        startDestination = startDestination
    ){

        //For home screen
      composable(
          Screen.HomeScreen.route
      ){

      }


        //Editor Screen
      composable(Screen.EditorScreen.route){

      }

        //NoteDetail Screen
        composable(
            Screen.NoteDetailScreen.route
        ){

        }

        //Folder Screen
        composable(
            Screen.FolderScreen.route
        ){

        }

        //Tag Screen

        composable(
            Screen.TagScreen.route
        ) {

        }

        //Search Screen

        composable(
            Screen.SearchScreen.route
        ) {

        }


    }

}
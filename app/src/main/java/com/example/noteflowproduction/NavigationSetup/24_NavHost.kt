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
          route=Screen.HomeScreen.route
      ){

      }


        //Editor Screen
      composable(route=Screen.EditorScreen.route){

      }

        //NoteDetail Screen
        composable(
           route= Screen.NoteDetailScreen.route
        ){

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
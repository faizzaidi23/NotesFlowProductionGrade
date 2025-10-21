package com.example.noteflowproduction.NavigationSetup

sealed class Screen(val route: String){
    object HomeScreen : Screen("home")
    object FolderScreen:Screen("folder")
    object ReminderScreen:Screen("reminder")
    object TagScreen:Screen("tagScreen")
}
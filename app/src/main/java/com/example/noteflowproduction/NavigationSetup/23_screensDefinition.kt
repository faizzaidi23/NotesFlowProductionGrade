package com.example.noteflowproduction.NavigationSetup

sealed class Screen(val route: String){
    object HomeScreen : Screen("home")
    object EditorScreen:Screen("editor/{noteId}")
    object NoteDetailScreen:Screen("detail/{noteId}")
    object FolderScreen:Screen("folders")
    object TagScreen:Screen("tags")
    object SearchScreen:Screen("search")
}
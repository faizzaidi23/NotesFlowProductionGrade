package com.example.noteflowproduction.UserInterface

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.noteflowproduction.NavigationSetup.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteDetailScreen(noteId: Int,navController: NavController){
    //shows the whole detail of the note
    //title
    Scaffold(
        modifier=Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title={Text("NotesFlow",fontSize=36.sp, fontWeight = FontWeight.ExtraBold)},
                navigationIcon ={
                    IconButton(
                        onClick = {navController.navi}
                    ){
                        Icon(imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "Navigate back to the home screen")
                    }
                }
            )
        }
    ){

    }
}
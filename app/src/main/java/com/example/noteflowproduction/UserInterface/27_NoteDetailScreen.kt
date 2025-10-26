package com.example.noteflowproduction.UserInterface

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.noteflowproduction.NavigationSetup.Screen
import com.example.noteflowproduction.ViewModels.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteDetailScreen(noteId: Int,onNavigateBack:()-> Unit,viewModel: NoteViewModel){
    //shows the whole detail of the note

    //I want a single note
    //The selected note is

    LaunchedEffect(noteId){
        viewModel.getNoteById(noteId)
    }

    val selectedNote by viewModel.selectedNote.collectAsState()

    Scaffold(
        modifier=Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title={Text("NotesFlow",fontSize=36.sp, fontWeight = FontWeight.ExtraBold)},
                navigationIcon ={
                    IconButton(
                        onClick = onNavigateBack
                    ){
                        Icon(imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "Navigate back to the home screen")
                    }
                }
            )
        }
    ){internalPadding->
        Column(
            modifier=Modifier.padding(internalPadding).fillMaxSize()
        ){
            //Time
            Text(
                text="Created At: ${selectedNote?.createdDate}"
            )


        }

    }
}
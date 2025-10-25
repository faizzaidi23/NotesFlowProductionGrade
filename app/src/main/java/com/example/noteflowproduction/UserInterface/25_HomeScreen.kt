package com.example.noteflowproduction.UserInterface

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.foundation.lazy.grid.items
import com.example.noteflowproduction.NavigationSetup.Screen

import com.example.noteflowproduction.ViewModels.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController,viewModel: NoteViewModel){

    val notesList by viewModel.allNotes.collectAsState()

    Scaffold(
        modifier=Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title={Text(text="NotesFlow",fontWeight=FontWeight.ExtraBold,fontSize=36.sp)},
                modifier=Modifier.fillMaxSize()

            )
        }
    ) { internalPadding->
        LazyVerticalGrid(
            modifier=Modifier.padding(internalPadding),
            columns = GridCells.Fixed(2),
            contentPadding= PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(notesList){
                note->
                NoteCardComponent(
                    title=note.title,
                    content = note.content,
                    createdDate = note.createdDate,
                    image = "",
                    navigateToNoteDetail ={
                        noteId->
                        navController.navigate(Screen.NoteDetailScreen.route +"/$noteId")
                    }
                )
            }
        }
    }
}
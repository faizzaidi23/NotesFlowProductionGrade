package com.example.noteflowproduction.UserInterface

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import com.example.noteflowproduction.Database.Note
import com.example.noteflowproduction.NavigationSetup.Screen

import com.example.noteflowproduction.ViewModels.NoteViewModel
import java.sql.Date
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

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
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModelScope.launch {
                        val newNote = Note(
                            id = 0,
                            folderId = 1,
                            title = "New Note",
                            content = "",
                            createdDate = Date(System.currentTimeMillis()),
                            modifiedDate = Date(System.currentTimeMillis())
                        )
                        viewModel.addNote(newNote)
                        // Wait briefly for the note to be added, then get the latest note
                        kotlinx.coroutines.delay(100)
                        val allNotes = notesList
                        if (allNotes.isNotEmpty()) {
                            val latestNote = allNotes.last()
                            navController.navigate(Screen.NoteDetailScreen.route + "/${latestNote.id}")
                        }
                    }
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add New Note")
            }
        }
    ) { internalPadding->
        LazyVerticalGrid(
            modifier=Modifier.padding(internalPadding),
            columns = GridCells.Fixed(2),
            contentPadding= PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(notesList){ note->
                NoteCardComponent(
                    noteId = note.id,
                    title = note.title,
                    content = note.content,
                    createdDate = note.createdDate,
                    navigateToNoteDetail = { noteId ->
                        navController.navigate(Screen.NoteDetailScreen.route + "/$noteId")
                    }
                )
            }
        }
    }
}
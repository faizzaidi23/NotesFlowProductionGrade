package com.example.noteflowproduction.UserInterface

import android.R.attr.height
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.util.Date

@Composable
fun NoteCardComponent(
    navController: NavController,
    showTitle:(title: String)-> Unit,
    showContent:(content:String)-> Unit,
    showImages:(image: String?)-> Unit,
    showDate:(date: Date)-> Unit,
    navigateToNoteDetail:(noteId: Int)-> Unit
){
    Card(
        modifier=Modifier.fillMaxWidth()
            .height(200.dp)
            .padding(8.dp),
        elevation= CardDefaults.cardElevation(defaultElevation = 4.dp)
    ){

        Column(
            modifier=Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ){

        }

    }


}
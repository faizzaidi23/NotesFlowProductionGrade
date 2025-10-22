package com.example.noteflowproduction.UserInterface

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        modifier=Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title={Text(text="NotesFlow",fontWeight=FontWeight.ExtraBold,fontSize=36.sp)},
                modifier=Modifier.fillMaxSize(),
                navigationIcon = R.drawad

            )
        }
    ) { internalPadding->
        Column(
            modifier=Modifier.padding(internalPadding)
        ){

        }
    }
}
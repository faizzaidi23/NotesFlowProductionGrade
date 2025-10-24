package com.example.noteflowproduction.UserInterface

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun NoteCardComponent(
    title: String,
    content: String,
    image: String?,
    createdDate: Date?,
    navigateToNoteDetail: (noteId: Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround
        ) {


            Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold)


            Text(text = content, fontSize = 14.sp)


            val formattedDate = if (createdDate != null) {
                SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault()).format(createdDate)
            } else {
                "Unknown"
            }

            val annotated = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold, fontSize = 12.sp)) {
                    append("Created At: ")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Normal, fontSize = 12.sp, color = Color.Gray)) {
                    append(formattedDate)
                }
            }

            Text(text = annotated)

        }

    }

}
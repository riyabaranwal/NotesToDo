package eu.tutorials.notestodo.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@Composable
fun FrontPage(){
    val text1 = remember { TextFieldValue("Make Notes") }
    val text2 = remember { TextFieldValue("Make ToDoList") }
    val text3 = remember { TextFieldValue("Make Routine") }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
//        Spacer(modifier = Modifier.weight(0.2f))
        Text(text = "NotesToDo",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(50.dp))
        OutlinedTextField(value = text1 ,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Red)
                .padding(4.dp).border(border = BorderStroke(2.dp, Color.Red),
                    shape = RoundedCornerShape(20)),
            textStyle = TextStyle(color = Color.White)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = text2 ,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF512DA8))
                .padding(4.dp).border(border = BorderStroke(2.dp, Color(0xFF512DA8)),
                    shape = RoundedCornerShape(20)),
            textStyle = TextStyle(color = Color.White))
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = text3 ,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFFF9800))
                .padding(4.dp).border(border = BorderStroke(2.dp, Color(0xFFFF9800)),
                    shape = RoundedCornerShape(20)),
            textStyle = TextStyle(color = Color.White))
//?H/ekkdenieujehhiojdo
    }


    }


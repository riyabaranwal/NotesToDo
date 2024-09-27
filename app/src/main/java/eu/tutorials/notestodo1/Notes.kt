package eu.tutorials.notestodo1


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController


@Composable
fun FrontPage(modifier: Modifier,
              navController: NavController,
              viewModel: NotesViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "NotesToDo",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(50.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Red)
                .border(
                    border = BorderStroke(2.dp, Color.Red),
                    shape = RoundedCornerShape(24)
                )
                .clickable { navController.navigate(Screen.Second1.route) }
                .padding(16.dp)
        ) {
            Text(
                text = "Notes",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                // modifier = Modifier.align(Alignment.Start)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF9C27B0))
                .border(
                    border = BorderStroke(2.dp, Color(0xFF9C27B0)),
                    shape = RoundedCornerShape(24)
                )
                .clickable {}
                .padding(16.dp)
        ) {
            Text(
                text = "ToDoList",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                //modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFFF9800))
                .border(
                    border = BorderStroke(2.dp, Color(0xFFFF9800)),
                    shape = RoundedCornerShape(24)
                )
                .clickable { }
                .padding(16.dp)
        ) {
            Text(
                text = "TimeTable",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                //modifier = Modifier.align(Alignment.Center)
            )
        }

    }
}


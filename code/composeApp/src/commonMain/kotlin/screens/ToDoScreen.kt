package screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import navigation.ToDoScreenComponent

@Composable
fun ToDoScreen(component: ToDoScreenComponent) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = { Text(text = "ToDo") },
        placeholder = { Text(text = "Description") },
    )
        Button(
            onClick = {
               //TODO: Implement
            }
        ) {
            Text("Add ToDo")
        }
        Button(
            onClick = {
               component.goBack()
            }
        ) {
            Text("Back to space")
        }
    }
}

@Composable
fun ToDoItem(
    content: String,
) = Column {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(content, Modifier.weight(1f))
    }
    Divider()
}
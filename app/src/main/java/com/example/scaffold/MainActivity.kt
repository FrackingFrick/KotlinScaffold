package com.example.scaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.scaffold.ui.theme.ScaffoldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScaffoldApp()
                }
            }
        }
    }
}

@Composable
fun ScaffoldApp() {
    Scaffold (
        topBar = { MyTopBar()},
        content= { Text(text = "This is the content")},
        bottomBar = { BottomAppBar() { Text(text = "Bottom bar")}}
            )


}
@Composable
fun MyTopBar(){
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
        title={ Text( "My App")},
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.MoreVert, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = { expanded=!expanded}) {
                Icon(Icons.Filled.MoreVert, contentDescription = null)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded=false }) {
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Text(text = "Info")
                }
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Text(text = "Settings")

                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScaffoldTheme {
        ScaffoldApp()
    }
}
package com.example.cw2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cw2.ui.theme.Cw2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Cw2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    KotlinPracticeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun KotlinPracticeScreen(modifier: Modifier = Modifier) {
    // manage status
    var currentAnimal by remember { mutableStateOf("cat") }
    var nullableMessage by remember { mutableStateOf<String?>(null) }
    var counter by remember { mutableStateOf(0) }

    // change animals
    fun changeAnimal() {
        currentAnimal = when (currentAnimal) {
            "cat" -> "dog"
            "dog" -> "fish"
            else -> "cat"
        }
        // set nullableMessage when changing animals
        nullableMessage = "Current animal changed to $currentAnimal"
    }


    val animalDescription = when (currentAnimal) {
        "cat" -> "current animal is cat"
        "dog" -> "current animal is dog"
        "fish" -> "current animal is fish"
        else -> "no animals"
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. When changing animals
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Animal Info:", style = MaterialTheme.typography.titleMedium)
            Text(text = "Current: $currentAnimal")
            Text(text = animalDescription)
            Button(onClick = ::changeAnimal) {
                Text("Change Animal")
            }
        }

        // 2. Nullable situation (?.)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Nullable Message:", style = MaterialTheme.typography.titleMedium)
            nullableMessage?.let {
                Text(text = "Message: $it")
            } ?: Text(text = "Message is null")

            Button(onClick = { nullableMessage = null }) {
                Text("Clear Message(set to null)")
            }
        }

        // 3.Counter
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Counter:", style = MaterialTheme.typography.titleMedium)
            Text(text = "Current value: $counter")
            Button(
                onClick = { if (counter < 5) counter++ },
                enabled = counter < 5
            ) {
                Text("Increment (up to 5)")
            }
            // reset the number to 0
            Button(onClick = { counter = 0 }) {
                Text("Reset Counter")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KotlinPracticeScreenPreview() {
    Cw2Theme {
        KotlinPracticeScreen()
    }
}



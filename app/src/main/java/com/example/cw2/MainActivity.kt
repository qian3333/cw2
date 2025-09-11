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
    // 状态管理
    var currentAnimal by remember { mutableStateOf("cat") }
    var nullableMessage by remember { mutableStateOf<String?>(null) }
    var counter by remember { mutableStateOf(0) }

    // 切换动物类型的函数
    fun changeAnimal() {
        currentAnimal = when (currentAnimal) {
            "cat" -> "dog"
            "dog" -> "fish"
            else -> "cat"
        }
        // 当切换动物时设置nullableMessage
        nullableMessage = "Current animal changed to $currentAnimal"
    }

    // 使用when表达式处理动物类型
    val animalDescription = when (currentAnimal) {
        "cat" -> "Cats are known for their agility and independence."
        "dog" -> "Dogs are loyal companions and often called man's best friend."
        "fish" -> "Fish live in water and breathe through gills."
        else -> "Unknown animal"
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. When表达式示例
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Animal Info:", style = MaterialTheme.typography.titleMedium)
            Text(text = "Current: $currentAnimal")
            Text(text = animalDescription)
            Button(onClick = ::changeAnimal) {
                Text("Change Animal")
            }
        }

        // 2. Nullable字符串处理示例 (?.)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Nullable Message:", style = MaterialTheme.typography.titleMedium)
            nullableMessage?.let {
                Text(text = "Message: $it")
            } ?: Text(text = "No message available")

            Button(onClick = { nullableMessage = null }) {
                Text("Clear Message")
            }
        }

        // 3. 计数器示例 (仅在小于5时递增)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Counter:", style = MaterialTheme.typography.titleMedium)
            Text(text = "Current value: $counter")
            Button(
                onClick = { if (counter < 5) counter++ },
                enabled = counter < 5
            ) {
                Text("Increment (up to 5)")
            }
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Cw2Theme {
        Greeting("Android")
    }
}
